package agrar.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

public abstract class SearchHelper<ObjectT> {
	
	protected final HttpServletRequest request;
	
	public SearchHelper() {
		this.request = null;
	}
	
	public SearchHelper(HttpServletRequest request) {
		this.request = request;
		getData();
	}

	/**
	 * @return Кол-во записей в текущем запросе
	 * @throws SystemException 
	 */
	public int getTotal() throws SystemException {
		return (int) countDynamicQuery(buildQuery());
	}	

	/**
	 * @param start - для выборки всех записей = 0
	 * @param end - для выборки всех записей = countDynamicQuery(buildQuery())
	 * @return Список объектов, полученный из выборки записей по запросу с указанием диапозона
	 * @throws SystemException
	 */
	public List<ObjectT> getList(int start, int end) throws SystemException {
		final DynamicQuery query = buildQuery();
		query.setLimit(start, end);
		addQueryOrder(query);
		return buildDynamicQuery(query);
	}

	/**
	 * Сбор данных из запроса
	 * Пример: ParamUtil.getString(request, parameter);
	 */
	protected abstract void getData();

	/**
	 * Этот метод можно перегрузить и модифицировать запрос
	 * @return Стандартный запрос всех записей из таблицы
	 */
	protected DynamicQuery buildQuery() throws SystemException {
		return buildDynamicQuery();
	}

	/**
	 * Этот метод можно перегрузить и добавить сортировку запроса <br>
	 * Пример: query.addOrder(OrderFactoryUtil.desc("id"));
	 * @param query
	 * @return Дефолтный порядок записей в запросе
	 */
	protected DynamicQuery addQueryOrder(DynamicQuery query) {
		return query;
	}

	/**
	 * Вызов локального сервиса: {Class}LocalServiceUtil.dynamicQuery();
	 * @return Новый запрос
	 */
	protected abstract DynamicQuery buildDynamicQuery();

	/**
	 * Вызов локального сервиса: {Class}LocalServiceUtil.dynamicQuery(query);
	 * @param query
	 * @return Выборка записей по запросу
	 * @throws SystemException
	 */
	protected abstract List<ObjectT> buildDynamicQuery(DynamicQuery query) throws SystemException;
	
	/**
	 * Вызов локального сервиса: {Class}LocalServiceUtil.dynamicQueryCount(query);
	 * @param query
	 * @return Кол-во записей в запросе
	 * @throws SystemException
	 */
	protected abstract long countDynamicQuery(DynamicQuery query) throws SystemException;
		
}

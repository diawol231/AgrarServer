package agrar.dict.search;

import agrar.dict.constants.WebKeys;
import agrar.dict.sbuilder.model.DictArea;
import agrar.dict.sbuilder.service.DictAreaLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.asc;
import static com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.desc;



public class DictAreaSearcher extends BaseSearcher<DictArea> {

	private String name;
	private long code;
	private boolean archive;

	private String orderByCol;
	private String orderByType;

	public DictAreaSearcher(HttpServletRequest request) {
		super(request);
	}

	/**
	 * Получение данных фильтров
	 */
	@Override
	protected void getData() {
		this.name = ParamUtil.getString(request, WebKeys.FILTER_01);
		this.archive = ParamUtil.getBoolean(request, WebKeys.FILTER_02);
		
		this.orderByCol = ParamUtil.getString(request, "orderByCol", "name");
		this.orderByType = ParamUtil.getString(request, "orderByType", "asc");
	}

	@Override
	protected DynamicQuery buildQuery() {
		
		DynamicQuery query = buildDynamicQuery();

		// Фильтр по названию
		if(!name.isEmpty())
			query.add(RestrictionsFactoryUtil.ilike("name", "%" + name + "%"));

		// Фильтр по коду
		if(code!=0)
			query.add(RestrictionsFactoryUtil.eq("code",  code));

		// Фильтр по архивности
		query.add(RestrictionsFactoryUtil.eq("archive", archive));			
			
		return query;
	}

	// Сортировка
	@Override
	protected DynamicQuery addQueryOrder(DynamicQuery query) {
	
		boolean isAscending = orderByType.equalsIgnoreCase("asc") ? true : false;
		
		if (orderByCol.equals("name")) {
			query.addOrder(isAscending ? asc("name") : desc("name"));
		} else {
			query.addOrder(asc("name"));
		}
		
		return query;
	}

	@Override
	protected DynamicQuery buildDynamicQuery() {
		return DictAreaLocalServiceUtil.dynamicQuery();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<DictArea> buildDynamicQuery(DynamicQuery query) throws SystemException {
		return DictAreaLocalServiceUtil.dynamicQuery(query);
	}

	@Override
	protected long countDynamicQuery(DynamicQuery query) throws SystemException {
		return DictAreaLocalServiceUtil.dynamicQueryCount(query);
	}

}

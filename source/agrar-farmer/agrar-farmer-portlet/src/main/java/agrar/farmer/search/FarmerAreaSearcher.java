package agrar.farmer.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import agrar.farmer.sbuilder.model.FarmerArea;
import agrar.farmer.sbuilder.service.FarmerAreaLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

public class FarmerAreaSearcher extends BaseSearcher<FarmerArea> {

	private final long farmId;
	
	private String orderByCol;
	private String orderByType;
	
	public FarmerAreaSearcher(HttpServletRequest request, long farmId) {
		super(request);
		this.farmId = farmId;
	}

	// Фильтр по фермеру
	@Override
	protected DynamicQuery buildQuery() {
		return buildDynamicQuery().add(RestrictionsFactoryUtil.eq("farmerId", farmId));
	}

	// Сортировка
	@Override
	protected DynamicQuery addQueryOrder(DynamicQuery query) {
		
		return query;
	}

	@Override
	protected DynamicQuery buildDynamicQuery() {
		return FarmerAreaLocalServiceUtil.dynamicQuery();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<FarmerArea> buildDynamicQuery(DynamicQuery query) throws SystemException {
		return FarmerAreaLocalServiceUtil.dynamicQuery(query);
	}

	@Override
	protected long countDynamicQuery(DynamicQuery query) throws SystemException {
		return FarmerAreaLocalServiceUtil.dynamicQueryCount(query);
	}

	/**
	 * Получение данных фильтров
	 */
	@Override
	protected void getData() {
		this.orderByCol = ParamUtil.getString(request, "orderByCol", "name");
		this.orderByType = ParamUtil.getString(request, "orderByType", "asc");
	}

}

package agrar.farmer.search;

import static com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.asc;
import static com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.desc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import agrar.farmer.constants.WebKeys;
import agrar.farmer.sbuilder.model.Farmer;
import agrar.farmer.sbuilder.service.FarmerLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.portal.kernel.util.Validator;

public class FarmerSearcher extends BaseSearcher<Farmer> {

	private String name;
	private String inn;
	private long reg_area;
	private Date reg_date_start;
	private Date reg_date_end;
	private boolean archive;
	
	private String orderByCol;
	private String orderByType;
	
	public FarmerSearcher(HttpServletRequest request) {
		super(request);
	}


	@SuppressWarnings("unchecked")
	@Override
	protected DynamicQuery buildQuery() {

		DynamicQuery query = buildDynamicQuery();

		// Фильтр по названию
		if(!name.isEmpty()) {
			query.add(RestrictionsFactoryUtil.ilike("name", "%" + name + "%")); 
		}

		// Фильтр по ИНН
		if(!inn.isEmpty()) {
			query.add(RestrictionsFactoryUtil.ilike("inn", "%" + inn + "%"));
		}

		// Фильтр по району регистрации
		if(reg_area != 0) {
			query.add(RestrictionsFactoryUtil.eq("registrationArea", reg_area));
		}

		// Фильтр по дате регистрации
		if(Validator.isNotNull(reg_date_start) && Validator.isNotNull(reg_date_end)) {
			query.add(RestrictionsFactoryUtil.between("registrationDate", reg_date_start, reg_date_end));
		} else if (Validator.isNotNull(reg_date_start) && Validator.isNull(reg_date_end)) {
			query.add(RestrictionsFactoryUtil.ge("registrationDate", reg_date_start));
		} else if (Validator.isNull(reg_date_start) && Validator.isNotNull(reg_date_end)) {
			query.add(RestrictionsFactoryUtil.le("registrationDate", reg_date_end));
		}

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
		return FarmerLocalServiceUtil.dynamicQuery();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Farmer> buildDynamicQuery(DynamicQuery query) throws SystemException {
		return FarmerLocalServiceUtil.dynamicQuery(query);
	}

	@Override
	protected long countDynamicQuery(DynamicQuery query) throws SystemException {
		return FarmerLocalServiceUtil.dynamicQueryCount(query);
	}

	/**
	 * Получение данных фильтров
	 */
	@Override
	protected void getData() {
		this.name = ParamUtil.getString(request, WebKeys.FILTER_01);
		this.inn = ParamUtil.getString(request, WebKeys.FILTER_02);
		this.reg_area = ParamUtil.getLong(request, WebKeys.FILTER_03);
		this.reg_date_start = ParamUtil.getDate(request, WebKeys.FILTER_04, new SimpleDateFormat("dd.MM.yyyy"), null);
		this.reg_date_end = ParamUtil.getDate(request, WebKeys.FILTER_05, new SimpleDateFormat("dd.MM.yyyy"), null);
		this.archive = ParamUtil.getBoolean(request, WebKeys.FILTER_06);
		
		this.orderByCol = ParamUtil.getString(request, "orderByCol", "name");
		this.orderByType = ParamUtil.getString(request, "orderByType", "asc");
	}

}

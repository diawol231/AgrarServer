package agrar.farmer.portlet;

import javax.portlet.*;

import agrar.farmer.constants.TabKeys;
import agrar.farmer.constants.WebKeys;
import agrar.farmer.sbuilder.model.Farmer;
import agrar.farmer.sbuilder.model.FarmerArea;
import agrar.farmer.sbuilder.service.FarmerAreaLocalServiceUtil;
import agrar.farmer.sbuilder.service.FarmerLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FarmerPortlet extends MVCPortlet {

	/**
	 * Добавить фермера в архив
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void archiveFarmer(ActionRequest actionRequest, ActionResponse actionResponse) {
		long farmId;
		Farmer farm;

		// Получаем id фермера из реквеста
		farmId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID);

		try {
			// Получаем объект фермера из БД
			farm = FarmerLocalServiceUtil.getFarmer(farmId);
			// Изменяем статус архивности
			farm.setArchive(!farm.getArchive());
			// Обновляем сущность в БД
			FarmerLocalServiceUtil.updateFarmer(farm);

			// Вернуться в реестр фермеров
			actionResponse.setRenderParameter(WebKeys.JSP_PAGE, WebKeys.FARMER);
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}


	}

	/**
	 * Добавить/изменить фермера
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void editFarmer(ActionRequest actionRequest, ActionResponse actionResponse) {
		final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		long farmId;
		Farmer farmer;
		int form;
		String name;
		String inn;
		String kpp;
		String ogrn;
		long regArea;
		String regDateString;
		Date regDate = null;

		// Получаем id фермера и остальные параметры из реквеста
		farmId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID);
		form = ParamUtil.getInteger(actionRequest, WebKeys.FARM_FORM);
		name = ParamUtil.getString(actionRequest, WebKeys.FARM_NAME);
		inn = ParamUtil.getString(actionRequest, WebKeys.FARM_INN);
		kpp = ParamUtil.getString(actionRequest, WebKeys.FARM_KPP);
		ogrn = ParamUtil.getString(actionRequest, WebKeys.FARM_OGRN);
		regArea = ParamUtil.getLong(actionRequest, WebKeys.FARM_REG_AREA);
		regDateString = ParamUtil.getString(actionRequest, WebKeys.FARM_REG_DATE);

		try {
			if(farmId > 0) {
				// Получаем объект фермера из БД
				farmer = FarmerLocalServiceUtil.fetchFarmer(farmId);

			} else {
				// Создаем новый объект фермера в БД
				farmer = FarmerLocalServiceUtil.createFarmer(0L);
			}

			try {
				// Пробуем запарсить дату
				if(Validator.isNotNull(regDateString)) {
					regDate = sdf.parse(regDateString);
				}
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			}

			if(farmId == 0) {
				// Устанавливаем для нового фермера id
				farmId = CounterLocalServiceUtil.increment(Farmer.class.getName());
				farmer.setId(farmId);
				farmer.setArchive(false);
			}

			// Устанавливаем параметры фермера
			farmer.setForm(form);
			farmer.setName(name);
			farmer.setInn(inn);
			farmer.setKpp(kpp);
			farmer.setOgrn(ogrn);
			farmer.setRegistrationArea(regArea);
			if(Validator.isNotNull(regDateString)){
				farmer.setRegistrationDate(regDate);
			}

			// Обновляем сущность в БД
			FarmerLocalServiceUtil.updateFarmer(farmer);

			// Вернуться в карточку фермера
			actionResponse.setRenderParameter(WebKeys.JSP_PAGE, WebKeys.FARMER_CARD);
			actionResponse.setRenderParameter(WebKeys.JSP_TAB, TabKeys.FARMER.getName());
			actionResponse.setRenderParameter(WebKeys.PARAM_ID, Long.toString(farmId));

		} catch (SystemException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Добавление/изменение района фермера
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void editFarmerArea(ActionRequest actionRequest, ActionResponse actionResponse) {

		long farmId;
		long areaId;
		FarmerArea farmArea;
		long name;
		String description;

		// Получаем id фермера, id района фермера и остальные параметры из реквеста
		farmId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID);
		areaId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID_2);
		name = ParamUtil.getLong(actionRequest, WebKeys.FARM_AREA_NAME + Long.toString(areaId));
		description = ParamUtil.getString(actionRequest, WebKeys.FARM_AREA_DESCRIPTION + Long.toString(areaId));

		try {
			if(areaId > 0) {
				// Получаем объект района фермера из БД
				farmArea = FarmerAreaLocalServiceUtil.getFarmerArea(areaId);
			} else {
				// Создаем новый объект района фермера в БД
				farmArea = FarmerAreaLocalServiceUtil.createFarmerArea(0);
			}

			if(farmArea.getId() == 0) {
				// Устанавливаем для нового района фермера id
				farmArea.setId(CounterLocalServiceUtil.increment(FarmerArea.class.getName()));
				farmArea.setFarmerId(farmId);
			}

			// Устанавливаем параметры района фермера
			farmArea.setAreaId(name);
			farmArea.setDescription(description);

			// Обновляем сущность в БД
			FarmerAreaLocalServiceUtil.updateFarmerArea(farmArea);

			// Вернуться в карточку фермера на вкладку раонов
			actionResponse.setRenderParameter(WebKeys.JSP_PAGE, WebKeys.FARMER_CARD);
			actionResponse.setRenderParameter(WebKeys.JSP_TAB, TabKeys.AREA.getName());
			actionResponse.setRenderParameter(WebKeys.PARAM_ID, Long.toString(farmId));
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Удаление района фермера
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void deleteFarmerArea(ActionRequest actionRequest, ActionResponse actionResponse) {
		long farmId;
		long areaId;

		// Получаем id фермера, id района фермера из реквеста
		farmId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID);
		areaId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID_2);

		try {
			// Удаляем сущность из БД
			FarmerAreaLocalServiceUtil.deleteFarmerArea(areaId);

			// Вернуться в карточку фермера на вкладку раонов
			actionResponse.setRenderParameter(WebKeys.JSP_PAGE, WebKeys.FARMER_CARD);
			actionResponse.setRenderParameter(WebKeys.JSP_TAB, TabKeys.AREA.getName());
			actionResponse.setRenderParameter(WebKeys.PARAM_ID, Long.toString(farmId));
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}

	}


}

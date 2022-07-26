package agrar.dict.portlet;

import agrar.dict.constants.WebKeys;
import agrar.dict.sbuilder.model.DictArea;
import agrar.dict.sbuilder.service.DictAreaLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

public class DictionariesPortlet extends MVCPortlet {

	/**
	 * Добавить район в архив
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void archiveArea(ActionRequest actionRequest, ActionResponse actionResponse) {
		long paramId;
		DictArea entry;

		// Получаем id района из реквеста
		paramId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID);

		try {
			// Получаем объект района из БД
			entry = DictAreaLocalServiceUtil.getDictArea(paramId);
			// Изменяем статус архивности
			entry.setArchive(!entry.getArchive());
			// Обновляем сущность в БД
			DictAreaLocalServiceUtil.updateDictArea(entry);
		} catch (PortalException e) {
			throw new RuntimeException(e);
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Удалить район из справочника
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void deleteArea(ActionRequest actionRequest, ActionResponse actionResponse) {
		long paramId;

		// Получаем id района из реквеста
		paramId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID);

		try {
			// Удаляем сущность из БД
			DictAreaLocalServiceUtil.deleteDictArea(paramId);
		} catch (PortalException e) {
			throw new RuntimeException(e);
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}


	}

	/**
	 * Добавить/изменить район
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void editArea(ActionRequest actionRequest, ActionResponse actionResponse) {
		long paramId;
		DictArea entry;

		String name;
		long code;

		// Получаем id района, имя и код из реквеста
		paramId = ParamUtil.getLong(actionRequest, WebKeys.PARAM_ID);
		name = ParamUtil.getString(actionRequest, WebKeys.REGION_NAME + Long.toString(paramId));
		code = ParamUtil.getLong(actionRequest, WebKeys.REGION_CODE + Long.toString(paramId));


		try {
			if(paramId > 0) {
				// Получаем объект района из БД
				entry = DictAreaLocalServiceUtil.fetchDictArea(paramId);
			} else {
				// Создаем новый объект района в БД
				entry = DictAreaLocalServiceUtil.createDictArea(0L);
			}


			if(paramId == 0) {
				// Устанавливаем для нового района id
				paramId = CounterLocalServiceUtil.increment(DictArea.class.getName());
				entry.setId(paramId);
				entry.setArchive(false);
			}

			// Устанавливаем название, код
			entry.setName(name);
			entry.setCode(code);
			// Обновляем сущность в БД
			DictAreaLocalServiceUtil.updateDictArea(entry);
		} catch (SystemException e) {
			throw new RuntimeException(e);
		}
	}

}

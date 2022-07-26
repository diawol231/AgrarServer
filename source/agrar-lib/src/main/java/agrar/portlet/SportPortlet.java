package agrar.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import agrar.action.Action;
import agrar.keys.WebKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public abstract class SportPortlet extends MVCPortlet {

	private static final Log log = LogFactoryUtil.getLog(SportPortlet.class);
	
	protected void doAction(ActionRequest actionRequest, ActionResponse actionResponse, final Action action) {

		//SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		//SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		if(action.doAction(actionRequest, actionResponse)) {

			copyRequestParameters(actionRequest, actionResponse);
			
		} else {
			
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);

			String failureJspPage = ParamUtil.getString(actionRequest, WebKeys.FAILURE_JSP_PAGE);
			if(Validator.isNotNull(failureJspPage))
				actionResponse.setRenderParameter(WebKeys.JSP_PAGE, failureJspPage);
			
			String failureJspTab = ParamUtil.getString(actionRequest, WebKeys.FAILURE_JSP_TAB);
			if(Validator.isNotNull(failureJspTab))
				actionResponse.setRenderParameter(WebKeys.JSP_TAB, failureJspTab);

		}
		
	}
	

	
	private void copyRequestParameters(ActionRequest actionRequest, ActionResponse actionResponse) {

		copyRequestParameter(actionRequest, actionResponse, WebKeys.JSP_PAGE);

		copyRequestParameter(actionRequest, actionResponse, WebKeys.ACTION);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.ACTION_2);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.ACTION_3);

		copyRequestParameter(actionRequest, actionResponse, WebKeys.ENTRY_ID);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.ENTRY_ID_2);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.ENTRY_ID_3);

		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_01);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_02);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_03);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_04);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_05);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_06);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_07);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_08);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_09);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_10);
		copyRequestParameter(actionRequest, actionResponse, WebKeys.FILTER_11);
		
	}
	
	private void copyRequestParameter(ActionRequest actionRequest, ActionResponse actionResponse, String parameter) {
		String value = ParamUtil.getString(actionRequest, parameter);
		if(!value.isEmpty()) actionResponse.setRenderParameter(parameter, value);
	}
	
}

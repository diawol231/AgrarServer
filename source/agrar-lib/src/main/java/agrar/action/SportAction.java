package agrar.action;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public abstract class SportAction implements Action {

	private static final Log log = LogFactoryUtil.getLog(SportAction.class);
	
	protected static final Locale DEFAULT_LOCALE = new Locale("ru", "RU");
	
	protected ActionRequest actionRequest;
	protected ActionResponse actionResponse;
	protected ThemeDisplay themeDisplay;
	protected String portletId;
	protected long userId;

	@Override
	public boolean doAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		this.actionRequest = actionRequest;
		this.actionResponse = actionResponse;
		this.themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		this.portletId = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		this.userId = themeDisplay.getUser().getUserId();

		
		try {
			
			getData();
			if(checkData()) {				
				processData();
				return true;
			}
			
		} catch (PortalException | SystemException e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error.unknown");
		}
		
		return false;
	}


	
	protected abstract void getData();
	protected abstract boolean checkData() throws SystemException, PortalException;
	protected abstract void processData() throws PortalException, SystemException;
	
}

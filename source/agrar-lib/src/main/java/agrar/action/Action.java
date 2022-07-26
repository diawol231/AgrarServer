package agrar.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

public interface Action {

	public abstract boolean doAction(ActionRequest actionRequest, ActionResponse actionResponse);
	
}

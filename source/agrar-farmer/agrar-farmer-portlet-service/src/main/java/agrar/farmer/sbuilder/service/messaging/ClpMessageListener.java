package agrar.farmer.sbuilder.service.messaging;

import agrar.farmer.sbuilder.service.ClpSerializer;
import agrar.farmer.sbuilder.service.FarmerAreaLocalServiceUtil;
import agrar.farmer.sbuilder.service.FarmerLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            FarmerLocalServiceUtil.clearService();

            FarmerAreaLocalServiceUtil.clearService();
        }
    }
}

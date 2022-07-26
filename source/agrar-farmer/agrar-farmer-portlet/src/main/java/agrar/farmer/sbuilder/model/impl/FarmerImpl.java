package agrar.farmer.sbuilder.model.impl;

import agrar.dict.sbuilder.service.DictAreaLocalServiceUtil;
import agrar.farmer.type.OrgForm;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model implementation for the Farmer service. Represents a row in the &quot;agrar_Farmer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link agrar.farmer.sbuilder.model.Farmer} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class FarmerImpl extends FarmerBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a farmer model instance should use the {@link agrar.farmer.sbuilder.model.Farmer} interface instead.
     */
    public FarmerImpl() {
    }

    public String showForm() {

        String result = "";

        result = OrgForm.findById(this.getForm()).getLabel();

        return result;
    }

    public String showRegArea() {

        String result = "";

        try {
            result = DictAreaLocalServiceUtil.getDictArea(this.getRegistrationArea()).getName();
        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return result;
    }
}

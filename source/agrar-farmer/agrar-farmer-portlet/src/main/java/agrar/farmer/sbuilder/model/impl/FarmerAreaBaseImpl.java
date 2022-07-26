package agrar.farmer.sbuilder.model.impl;

import agrar.farmer.sbuilder.model.FarmerArea;
import agrar.farmer.sbuilder.service.FarmerAreaLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the FarmerArea service. Represents a row in the &quot;agrar_farmer_FarmerArea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FarmerAreaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerAreaImpl
 * @see agrar.farmer.sbuilder.model.FarmerArea
 * @generated
 */
public abstract class FarmerAreaBaseImpl extends FarmerAreaModelImpl
    implements FarmerArea {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a farmer area model instance should use the {@link FarmerArea} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FarmerAreaLocalServiceUtil.addFarmerArea(this);
        } else {
            FarmerAreaLocalServiceUtil.updateFarmerArea(this);
        }
    }
}

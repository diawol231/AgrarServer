package agrar.farmer.sbuilder.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Farmer service. Represents a row in the &quot;agrar_farmer_Farmer&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerModel
 * @see agrar.farmer.sbuilder.model.impl.FarmerImpl
 * @see agrar.farmer.sbuilder.model.impl.FarmerModelImpl
 * @generated
 */
public interface Farmer extends FarmerModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link agrar.farmer.sbuilder.model.impl.FarmerImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.lang.String showForm();

    public java.lang.String showRegArea();
}

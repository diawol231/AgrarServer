package agrar.farmer.sbuilder.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the FarmerArea service. Represents a row in the &quot;agrar_farmer_FarmerArea&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerAreaModel
 * @see agrar.farmer.sbuilder.model.impl.FarmerAreaImpl
 * @see agrar.farmer.sbuilder.model.impl.FarmerAreaModelImpl
 * @generated
 */
public interface FarmerArea extends FarmerAreaModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link agrar.farmer.sbuilder.model.impl.FarmerAreaImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Отображение названия района фермера
    *
    * @return
    */
    public java.lang.String showArea();

    /**
    * Получение кода района фермера
    *
    * @return
    */
    public long getAreaCode();
}

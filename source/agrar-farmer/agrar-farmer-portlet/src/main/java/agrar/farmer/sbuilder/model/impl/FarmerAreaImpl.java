package agrar.farmer.sbuilder.model.impl;

import agrar.dict.sbuilder.model.DictArea;
import agrar.dict.sbuilder.service.DictAreaLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The extended model implementation for the FarmerArea service. Represents a row in the &quot;agrar_FarmerArea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link agrar.farmer.sbuilder.model.FarmerArea} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class FarmerAreaImpl extends FarmerAreaBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a farmer area model instance should use the {@link agrar.farmer.sbuilder.model.FarmerArea} interface instead.
     */
    public FarmerAreaImpl() {
    }

    /**
     * Отображение названия района фермера
     * @return
     */
    public String showArea() {

        String result = "";

        try {
            DictArea area = DictAreaLocalServiceUtil.fetchDictArea(this.getAreaId());
            if(Validator.isNotNull(area)) {
                result = area.getName();
            } else {
                result = "area:" + this.getAreaId();
            }
        } catch (SystemException e) {
            result = "error";
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Получение кода района фермера
     * @return
     */
    public long getAreaCode() {

        long result = 0;

        try {
            DictArea area = DictAreaLocalServiceUtil.fetchDictArea(this.getAreaId());
            if(Validator.isNotNull(area)) {
                result = area.getCode();
            } else {
                result = this.getAreaId();
            }
        } catch (SystemException e) {
            result = 0;
            e.printStackTrace();
        }

        return result;
    }
}

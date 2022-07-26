package agrar.farmer.sbuilder.service.persistence;

import agrar.farmer.sbuilder.model.FarmerArea;
import agrar.farmer.sbuilder.service.FarmerAreaLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FarmerAreaActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FarmerAreaActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FarmerAreaLocalServiceUtil.getService());
        setClass(FarmerArea.class);

        setClassLoader(agrar.farmer.sbuilder.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}

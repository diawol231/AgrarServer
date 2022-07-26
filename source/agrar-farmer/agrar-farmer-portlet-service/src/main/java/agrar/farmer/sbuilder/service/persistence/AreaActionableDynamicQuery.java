package agrar.farmer.sbuilder.service.persistence;

import agrar.farmer.sbuilder.model.Area;
import agrar.farmer.sbuilder.service.AreaLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AreaActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public AreaActionableDynamicQuery() throws SystemException {
        setBaseLocalService(AreaLocalServiceUtil.getService());
        setClass(Area.class);

        setClassLoader(agrar.farmer.sbuilder.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}

package agrar.dict.sbuilder.service.persistence;

import agrar.dict.sbuilder.model.DictArea;
import agrar.dict.sbuilder.service.DictAreaLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class DictAreaActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DictAreaActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DictAreaLocalServiceUtil.getService());
        setClass(DictArea.class);

        setClassLoader(agrar.dict.sbuilder.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("id");
    }
}

package agrar.dict.sbuilder.service.impl;

import agrar.dict.sbuilder.model.DictArea;
import agrar.dict.sbuilder.service.DictAreaLocalServiceUtil;
import agrar.dict.sbuilder.service.base.DictAreaLocalServiceBaseImpl;
import agrar.dict.sbuilder.service.persistence.DictAreaUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the dict area local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link agrar.dict.sbuilder.service.DictAreaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see agrar.dict.sbuilder.service.base.DictAreaLocalServiceBaseImpl
 * @see agrar.dict.sbuilder.service.DictAreaLocalServiceUtil
 */
public class DictAreaLocalServiceImpl extends DictAreaLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link agrar.dict.sbuilder.service.DictAreaLocalServiceUtil} to access the dict area local service.
     */


    /**
     * Получаем список неархивных районов
     * @return
     * @throws SystemException
     */
    @SuppressWarnings("unchecked")
    public List<DictArea> getAreas() throws SystemException {
        DynamicQuery query = DictAreaLocalServiceUtil.dynamicQuery();
        query.add(RestrictionsFactoryUtil.eq("archive", false));
        query.addOrder(OrderFactoryUtil.asc("name"));
        return DictAreaLocalServiceUtil.dynamicQuery(query);
    }

}

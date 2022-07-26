package agrar.dict.sbuilder.service.persistence;

import agrar.dict.sbuilder.model.DictArea;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the dict area service. This utility wraps {@link DictAreaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DictAreaPersistence
 * @see DictAreaPersistenceImpl
 * @generated
 */
public class DictAreaUtil {
    private static DictAreaPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(DictArea dictArea) {
        getPersistence().clearCache(dictArea);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<DictArea> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<DictArea> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<DictArea> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static DictArea update(DictArea dictArea) throws SystemException {
        return getPersistence().update(dictArea);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static DictArea update(DictArea dictArea,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(dictArea, serviceContext);
    }

    /**
    * Caches the dict area in the entity cache if it is enabled.
    *
    * @param dictArea the dict area
    */
    public static void cacheResult(agrar.dict.sbuilder.model.DictArea dictArea) {
        getPersistence().cacheResult(dictArea);
    }

    /**
    * Caches the dict areas in the entity cache if it is enabled.
    *
    * @param dictAreas the dict areas
    */
    public static void cacheResult(
        java.util.List<agrar.dict.sbuilder.model.DictArea> dictAreas) {
        getPersistence().cacheResult(dictAreas);
    }

    /**
    * Creates a new dict area with the primary key. Does not add the dict area to the database.
    *
    * @param id the primary key for the new dict area
    * @return the new dict area
    */
    public static agrar.dict.sbuilder.model.DictArea create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the dict area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the dict area
    * @return the dict area that was removed
    * @throws agrar.dict.sbuilder.NoSuchDictAreaException if a dict area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.dict.sbuilder.model.DictArea remove(long id)
        throws agrar.dict.sbuilder.NoSuchDictAreaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static agrar.dict.sbuilder.model.DictArea updateImpl(
        agrar.dict.sbuilder.model.DictArea dictArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(dictArea);
    }

    /**
    * Returns the dict area with the primary key or throws a {@link agrar.dict.sbuilder.NoSuchDictAreaException} if it could not be found.
    *
    * @param id the primary key of the dict area
    * @return the dict area
    * @throws agrar.dict.sbuilder.NoSuchDictAreaException if a dict area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.dict.sbuilder.model.DictArea findByPrimaryKey(long id)
        throws agrar.dict.sbuilder.NoSuchDictAreaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the dict area with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the dict area
    * @return the dict area, or <code>null</code> if a dict area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.dict.sbuilder.model.DictArea fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the dict areas.
    *
    * @return the dict areas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<agrar.dict.sbuilder.model.DictArea> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the dict areas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.dict.sbuilder.model.impl.DictAreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of dict areas
    * @param end the upper bound of the range of dict areas (not inclusive)
    * @return the range of dict areas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<agrar.dict.sbuilder.model.DictArea> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the dict areas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.dict.sbuilder.model.impl.DictAreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of dict areas
    * @param end the upper bound of the range of dict areas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of dict areas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<agrar.dict.sbuilder.model.DictArea> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the dict areas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of dict areas.
    *
    * @return the number of dict areas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static DictAreaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (DictAreaPersistence) PortletBeanLocatorUtil.locate(agrar.dict.sbuilder.service.ClpSerializer.getServletContextName(),
                    DictAreaPersistence.class.getName());

            ReferenceRegistry.registerReference(DictAreaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(DictAreaPersistence persistence) {
    }
}

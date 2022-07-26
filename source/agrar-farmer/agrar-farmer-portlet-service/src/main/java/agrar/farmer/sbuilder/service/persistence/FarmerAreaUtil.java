package agrar.farmer.sbuilder.service.persistence;

import agrar.farmer.sbuilder.model.FarmerArea;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the farmer area service. This utility wraps {@link FarmerAreaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerAreaPersistence
 * @see FarmerAreaPersistenceImpl
 * @generated
 */
public class FarmerAreaUtil {
    private static FarmerAreaPersistence _persistence;

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
    public static void clearCache(FarmerArea farmerArea) {
        getPersistence().clearCache(farmerArea);
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
    public static List<FarmerArea> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<FarmerArea> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<FarmerArea> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static FarmerArea update(FarmerArea farmerArea)
        throws SystemException {
        return getPersistence().update(farmerArea);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static FarmerArea update(FarmerArea farmerArea,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(farmerArea, serviceContext);
    }

    /**
    * Caches the farmer area in the entity cache if it is enabled.
    *
    * @param farmerArea the farmer area
    */
    public static void cacheResult(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea) {
        getPersistence().cacheResult(farmerArea);
    }

    /**
    * Caches the farmer areas in the entity cache if it is enabled.
    *
    * @param farmerAreas the farmer areas
    */
    public static void cacheResult(
        java.util.List<agrar.farmer.sbuilder.model.FarmerArea> farmerAreas) {
        getPersistence().cacheResult(farmerAreas);
    }

    /**
    * Creates a new farmer area with the primary key. Does not add the farmer area to the database.
    *
    * @param id the primary key for the new farmer area
    * @return the new farmer area
    */
    public static agrar.farmer.sbuilder.model.FarmerArea create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the farmer area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area that was removed
    * @throws agrar.farmer.sbuilder.NoSuchFarmerAreaException if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.farmer.sbuilder.model.FarmerArea remove(long id)
        throws agrar.farmer.sbuilder.NoSuchFarmerAreaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(id);
    }

    public static agrar.farmer.sbuilder.model.FarmerArea updateImpl(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(farmerArea);
    }

    /**
    * Returns the farmer area with the primary key or throws a {@link agrar.farmer.sbuilder.NoSuchFarmerAreaException} if it could not be found.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area
    * @throws agrar.farmer.sbuilder.NoSuchFarmerAreaException if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.farmer.sbuilder.model.FarmerArea findByPrimaryKey(
        long id)
        throws agrar.farmer.sbuilder.NoSuchFarmerAreaException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the farmer area with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area, or <code>null</code> if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.farmer.sbuilder.model.FarmerArea fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the farmer areas.
    *
    * @return the farmer areas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<agrar.farmer.sbuilder.model.FarmerArea> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the farmer areas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.FarmerAreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of farmer areas
    * @param end the upper bound of the range of farmer areas (not inclusive)
    * @return the range of farmer areas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<agrar.farmer.sbuilder.model.FarmerArea> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the farmer areas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.FarmerAreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of farmer areas
    * @param end the upper bound of the range of farmer areas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of farmer areas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<agrar.farmer.sbuilder.model.FarmerArea> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the farmer areas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of farmer areas.
    *
    * @return the number of farmer areas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static FarmerAreaPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (FarmerAreaPersistence) PortletBeanLocatorUtil.locate(agrar.farmer.sbuilder.service.ClpSerializer.getServletContextName(),
                    FarmerAreaPersistence.class.getName());

            ReferenceRegistry.registerReference(FarmerAreaUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(FarmerAreaPersistence persistence) {
    }
}

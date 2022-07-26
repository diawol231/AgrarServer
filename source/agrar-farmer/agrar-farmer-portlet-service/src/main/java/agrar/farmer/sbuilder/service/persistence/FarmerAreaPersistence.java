package agrar.farmer.sbuilder.service.persistence;

import agrar.farmer.sbuilder.model.FarmerArea;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the farmer area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerAreaPersistenceImpl
 * @see FarmerAreaUtil
 * @generated
 */
public interface FarmerAreaPersistence extends BasePersistence<FarmerArea> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link FarmerAreaUtil} to access the farmer area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the farmer area in the entity cache if it is enabled.
    *
    * @param farmerArea the farmer area
    */
    public void cacheResult(agrar.farmer.sbuilder.model.FarmerArea farmerArea);

    /**
    * Caches the farmer areas in the entity cache if it is enabled.
    *
    * @param farmerAreas the farmer areas
    */
    public void cacheResult(
        java.util.List<agrar.farmer.sbuilder.model.FarmerArea> farmerAreas);

    /**
    * Creates a new farmer area with the primary key. Does not add the farmer area to the database.
    *
    * @param id the primary key for the new farmer area
    * @return the new farmer area
    */
    public agrar.farmer.sbuilder.model.FarmerArea create(long id);

    /**
    * Removes the farmer area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area that was removed
    * @throws agrar.farmer.sbuilder.NoSuchFarmerAreaException if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.farmer.sbuilder.model.FarmerArea remove(long id)
        throws agrar.farmer.sbuilder.NoSuchFarmerAreaException,
            com.liferay.portal.kernel.exception.SystemException;

    public agrar.farmer.sbuilder.model.FarmerArea updateImpl(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmer area with the primary key or throws a {@link agrar.farmer.sbuilder.NoSuchFarmerAreaException} if it could not be found.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area
    * @throws agrar.farmer.sbuilder.NoSuchFarmerAreaException if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.farmer.sbuilder.model.FarmerArea findByPrimaryKey(long id)
        throws agrar.farmer.sbuilder.NoSuchFarmerAreaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the farmer area with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area, or <code>null</code> if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.farmer.sbuilder.model.FarmerArea fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the farmer areas.
    *
    * @return the farmer areas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<agrar.farmer.sbuilder.model.FarmerArea> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<agrar.farmer.sbuilder.model.FarmerArea> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<agrar.farmer.sbuilder.model.FarmerArea> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the farmer areas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of farmer areas.
    *
    * @return the number of farmer areas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

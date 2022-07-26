package agrar.farmer.sbuilder.service.persistence;

import agrar.farmer.sbuilder.model.Area;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaPersistenceImpl
 * @see AreaUtil
 * @generated
 */
public interface AreaPersistence extends BasePersistence<Area> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link AreaUtil} to access the area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the area in the entity cache if it is enabled.
    *
    * @param area the area
    */
    public void cacheResult(agrar.farmer.sbuilder.model.Area area);

    /**
    * Caches the areas in the entity cache if it is enabled.
    *
    * @param areas the areas
    */
    public void cacheResult(
        java.util.List<agrar.farmer.sbuilder.model.Area> areas);

    /**
    * Creates a new area with the primary key. Does not add the area to the database.
    *
    * @param id the primary key for the new area
    * @return the new area
    */
    public agrar.farmer.sbuilder.model.Area create(long id);

    /**
    * Removes the area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the area
    * @return the area that was removed
    * @throws agrar.farmer.sbuilder.NoSuchAreaException if a area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.farmer.sbuilder.model.Area remove(long id)
        throws agrar.farmer.sbuilder.NoSuchAreaException,
            com.liferay.portal.kernel.exception.SystemException;

    public agrar.farmer.sbuilder.model.Area updateImpl(
        agrar.farmer.sbuilder.model.Area area)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the area with the primary key or throws a {@link agrar.farmer.sbuilder.NoSuchAreaException} if it could not be found.
    *
    * @param id the primary key of the area
    * @return the area
    * @throws agrar.farmer.sbuilder.NoSuchAreaException if a area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.farmer.sbuilder.model.Area findByPrimaryKey(long id)
        throws agrar.farmer.sbuilder.NoSuchAreaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the area with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the area
    * @return the area, or <code>null</code> if a area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.farmer.sbuilder.model.Area fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the areas.
    *
    * @return the areas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<agrar.farmer.sbuilder.model.Area> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the areas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of areas
    * @param end the upper bound of the range of areas (not inclusive)
    * @return the range of areas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<agrar.farmer.sbuilder.model.Area> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the areas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.AreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of areas
    * @param end the upper bound of the range of areas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of areas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<agrar.farmer.sbuilder.model.Area> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the areas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of areas.
    *
    * @return the number of areas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

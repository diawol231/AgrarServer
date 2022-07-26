package agrar.dict.sbuilder.service.persistence;

import agrar.dict.sbuilder.model.DictArea;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the dict area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DictAreaPersistenceImpl
 * @see DictAreaUtil
 * @generated
 */
public interface DictAreaPersistence extends BasePersistence<DictArea> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link DictAreaUtil} to access the dict area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the dict area in the entity cache if it is enabled.
    *
    * @param dictArea the dict area
    */
    public void cacheResult(agrar.dict.sbuilder.model.DictArea dictArea);

    /**
    * Caches the dict areas in the entity cache if it is enabled.
    *
    * @param dictAreas the dict areas
    */
    public void cacheResult(
        java.util.List<agrar.dict.sbuilder.model.DictArea> dictAreas);

    /**
    * Creates a new dict area with the primary key. Does not add the dict area to the database.
    *
    * @param id the primary key for the new dict area
    * @return the new dict area
    */
    public agrar.dict.sbuilder.model.DictArea create(long id);

    /**
    * Removes the dict area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the dict area
    * @return the dict area that was removed
    * @throws agrar.dict.sbuilder.NoSuchDictAreaException if a dict area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.dict.sbuilder.model.DictArea remove(long id)
        throws agrar.dict.sbuilder.NoSuchDictAreaException,
            com.liferay.portal.kernel.exception.SystemException;

    public agrar.dict.sbuilder.model.DictArea updateImpl(
        agrar.dict.sbuilder.model.DictArea dictArea)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the dict area with the primary key or throws a {@link agrar.dict.sbuilder.NoSuchDictAreaException} if it could not be found.
    *
    * @param id the primary key of the dict area
    * @return the dict area
    * @throws agrar.dict.sbuilder.NoSuchDictAreaException if a dict area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.dict.sbuilder.model.DictArea findByPrimaryKey(long id)
        throws agrar.dict.sbuilder.NoSuchDictAreaException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the dict area with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the dict area
    * @return the dict area, or <code>null</code> if a dict area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public agrar.dict.sbuilder.model.DictArea fetchByPrimaryKey(long id)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the dict areas.
    *
    * @return the dict areas
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<agrar.dict.sbuilder.model.DictArea> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<agrar.dict.sbuilder.model.DictArea> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<agrar.dict.sbuilder.model.DictArea> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the dict areas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of dict areas.
    *
    * @return the number of dict areas
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

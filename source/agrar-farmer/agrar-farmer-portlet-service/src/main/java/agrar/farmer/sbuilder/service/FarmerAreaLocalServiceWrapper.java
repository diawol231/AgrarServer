package agrar.farmer.sbuilder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FarmerAreaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerAreaLocalService
 * @generated
 */
public class FarmerAreaLocalServiceWrapper implements FarmerAreaLocalService,
    ServiceWrapper<FarmerAreaLocalService> {
    private FarmerAreaLocalService _farmerAreaLocalService;

    public FarmerAreaLocalServiceWrapper(
        FarmerAreaLocalService farmerAreaLocalService) {
        _farmerAreaLocalService = farmerAreaLocalService;
    }

    /**
    * Adds the farmer area to the database. Also notifies the appropriate model listeners.
    *
    * @param farmerArea the farmer area
    * @return the farmer area that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public agrar.farmer.sbuilder.model.FarmerArea addFarmerArea(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.addFarmerArea(farmerArea);
    }

    /**
    * Creates a new farmer area with the primary key. Does not add the farmer area to the database.
    *
    * @param id the primary key for the new farmer area
    * @return the new farmer area
    */
    @Override
    public agrar.farmer.sbuilder.model.FarmerArea createFarmerArea(long id) {
        return _farmerAreaLocalService.createFarmerArea(id);
    }

    /**
    * Deletes the farmer area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area that was removed
    * @throws PortalException if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public agrar.farmer.sbuilder.model.FarmerArea deleteFarmerArea(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.deleteFarmerArea(id);
    }

    /**
    * Deletes the farmer area from the database. Also notifies the appropriate model listeners.
    *
    * @param farmerArea the farmer area
    * @return the farmer area that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public agrar.farmer.sbuilder.model.FarmerArea deleteFarmerArea(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.deleteFarmerArea(farmerArea);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _farmerAreaLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.FarmerAreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.FarmerAreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public agrar.farmer.sbuilder.model.FarmerArea fetchFarmerArea(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.fetchFarmerArea(id);
    }

    /**
    * Returns the farmer area with the primary key.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area
    * @throws PortalException if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public agrar.farmer.sbuilder.model.FarmerArea getFarmerArea(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.getFarmerArea(id);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<agrar.farmer.sbuilder.model.FarmerArea> getFarmerAreas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.getFarmerAreas(start, end);
    }

    /**
    * Returns the number of farmer areas.
    *
    * @return the number of farmer areas
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getFarmerAreasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.getFarmerAreasCount();
    }

    /**
    * Updates the farmer area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param farmerArea the farmer area
    * @return the farmer area that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public agrar.farmer.sbuilder.model.FarmerArea updateFarmerArea(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _farmerAreaLocalService.updateFarmerArea(farmerArea);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _farmerAreaLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _farmerAreaLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _farmerAreaLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public FarmerAreaLocalService getWrappedFarmerAreaLocalService() {
        return _farmerAreaLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedFarmerAreaLocalService(
        FarmerAreaLocalService farmerAreaLocalService) {
        _farmerAreaLocalService = farmerAreaLocalService;
    }

    @Override
    public FarmerAreaLocalService getWrappedService() {
        return _farmerAreaLocalService;
    }

    @Override
    public void setWrappedService(FarmerAreaLocalService farmerAreaLocalService) {
        _farmerAreaLocalService = farmerAreaLocalService;
    }
}

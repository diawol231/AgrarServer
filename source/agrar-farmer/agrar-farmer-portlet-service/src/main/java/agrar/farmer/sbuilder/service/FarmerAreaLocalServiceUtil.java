package agrar.farmer.sbuilder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FarmerArea. This utility wraps
 * {@link agrar.farmer.sbuilder.service.impl.FarmerAreaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerAreaLocalService
 * @see agrar.farmer.sbuilder.service.base.FarmerAreaLocalServiceBaseImpl
 * @see agrar.farmer.sbuilder.service.impl.FarmerAreaLocalServiceImpl
 * @generated
 */
public class FarmerAreaLocalServiceUtil {
    private static FarmerAreaLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link agrar.farmer.sbuilder.service.impl.FarmerAreaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the farmer area to the database. Also notifies the appropriate model listeners.
    *
    * @param farmerArea the farmer area
    * @return the farmer area that was added
    * @throws SystemException if a system exception occurred
    */
    public static agrar.farmer.sbuilder.model.FarmerArea addFarmerArea(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addFarmerArea(farmerArea);
    }

    /**
    * Creates a new farmer area with the primary key. Does not add the farmer area to the database.
    *
    * @param id the primary key for the new farmer area
    * @return the new farmer area
    */
    public static agrar.farmer.sbuilder.model.FarmerArea createFarmerArea(
        long id) {
        return getService().createFarmerArea(id);
    }

    /**
    * Deletes the farmer area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area that was removed
    * @throws PortalException if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.farmer.sbuilder.model.FarmerArea deleteFarmerArea(
        long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteFarmerArea(id);
    }

    /**
    * Deletes the farmer area from the database. Also notifies the appropriate model listeners.
    *
    * @param farmerArea the farmer area
    * @return the farmer area that was removed
    * @throws SystemException if a system exception occurred
    */
    public static agrar.farmer.sbuilder.model.FarmerArea deleteFarmerArea(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteFarmerArea(farmerArea);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static agrar.farmer.sbuilder.model.FarmerArea fetchFarmerArea(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchFarmerArea(id);
    }

    /**
    * Returns the farmer area with the primary key.
    *
    * @param id the primary key of the farmer area
    * @return the farmer area
    * @throws PortalException if a farmer area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.farmer.sbuilder.model.FarmerArea getFarmerArea(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getFarmerArea(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<agrar.farmer.sbuilder.model.FarmerArea> getFarmerAreas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFarmerAreas(start, end);
    }

    /**
    * Returns the number of farmer areas.
    *
    * @return the number of farmer areas
    * @throws SystemException if a system exception occurred
    */
    public static int getFarmerAreasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFarmerAreasCount();
    }

    /**
    * Updates the farmer area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param farmerArea the farmer area
    * @return the farmer area that was updated
    * @throws SystemException if a system exception occurred
    */
    public static agrar.farmer.sbuilder.model.FarmerArea updateFarmerArea(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateFarmerArea(farmerArea);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static FarmerAreaLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    FarmerAreaLocalService.class.getName());

            if (invokableLocalService instanceof FarmerAreaLocalService) {
                _service = (FarmerAreaLocalService) invokableLocalService;
            } else {
                _service = new FarmerAreaLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(FarmerAreaLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(FarmerAreaLocalService service) {
    }
}

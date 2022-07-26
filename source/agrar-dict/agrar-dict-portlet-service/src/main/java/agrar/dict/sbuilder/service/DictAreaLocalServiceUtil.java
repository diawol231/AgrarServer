package agrar.dict.sbuilder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DictArea. This utility wraps
 * {@link agrar.dict.sbuilder.service.impl.DictAreaLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DictAreaLocalService
 * @see agrar.dict.sbuilder.service.base.DictAreaLocalServiceBaseImpl
 * @see agrar.dict.sbuilder.service.impl.DictAreaLocalServiceImpl
 * @generated
 */
public class DictAreaLocalServiceUtil {
    private static DictAreaLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link agrar.dict.sbuilder.service.impl.DictAreaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the dict area to the database. Also notifies the appropriate model listeners.
    *
    * @param dictArea the dict area
    * @return the dict area that was added
    * @throws SystemException if a system exception occurred
    */
    public static agrar.dict.sbuilder.model.DictArea addDictArea(
        agrar.dict.sbuilder.model.DictArea dictArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addDictArea(dictArea);
    }

    /**
    * Creates a new dict area with the primary key. Does not add the dict area to the database.
    *
    * @param id the primary key for the new dict area
    * @return the new dict area
    */
    public static agrar.dict.sbuilder.model.DictArea createDictArea(long id) {
        return getService().createDictArea(id);
    }

    /**
    * Deletes the dict area with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the dict area
    * @return the dict area that was removed
    * @throws PortalException if a dict area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.dict.sbuilder.model.DictArea deleteDictArea(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDictArea(id);
    }

    /**
    * Deletes the dict area from the database. Also notifies the appropriate model listeners.
    *
    * @param dictArea the dict area
    * @return the dict area that was removed
    * @throws SystemException if a system exception occurred
    */
    public static agrar.dict.sbuilder.model.DictArea deleteDictArea(
        agrar.dict.sbuilder.model.DictArea dictArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteDictArea(dictArea);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.dict.sbuilder.model.impl.DictAreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.dict.sbuilder.model.impl.DictAreaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static agrar.dict.sbuilder.model.DictArea fetchDictArea(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchDictArea(id);
    }

    /**
    * Returns the dict area with the primary key.
    *
    * @param id the primary key of the dict area
    * @return the dict area
    * @throws PortalException if a dict area with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static agrar.dict.sbuilder.model.DictArea getDictArea(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getDictArea(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<agrar.dict.sbuilder.model.DictArea> getDictAreas(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDictAreas(start, end);
    }

    /**
    * Returns the number of dict areas.
    *
    * @return the number of dict areas
    * @throws SystemException if a system exception occurred
    */
    public static int getDictAreasCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getDictAreasCount();
    }

    /**
    * Updates the dict area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param dictArea the dict area
    * @return the dict area that was updated
    * @throws SystemException if a system exception occurred
    */
    public static agrar.dict.sbuilder.model.DictArea updateDictArea(
        agrar.dict.sbuilder.model.DictArea dictArea)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateDictArea(dictArea);
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

    /**
    * Получаем список неархивных районов
    *
    * @return
    * @throws SystemException
    */
    public static java.util.List<agrar.dict.sbuilder.model.DictArea> getAreas()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAreas();
    }

    public static void clearService() {
        _service = null;
    }

    public static DictAreaLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    DictAreaLocalService.class.getName());

            if (invokableLocalService instanceof DictAreaLocalService) {
                _service = (DictAreaLocalService) invokableLocalService;
            } else {
                _service = new DictAreaLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(DictAreaLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(DictAreaLocalService service) {
    }
}

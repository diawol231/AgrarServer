package agrar.farmer.sbuilder.service.base;

import agrar.farmer.sbuilder.model.Farmer;
import agrar.farmer.sbuilder.service.FarmerLocalService;
import agrar.farmer.sbuilder.service.persistence.FarmerAreaPersistence;
import agrar.farmer.sbuilder.service.persistence.FarmerPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the farmer local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link agrar.farmer.sbuilder.service.impl.FarmerLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see agrar.farmer.sbuilder.service.impl.FarmerLocalServiceImpl
 * @see agrar.farmer.sbuilder.service.FarmerLocalServiceUtil
 * @generated
 */
public abstract class FarmerLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements FarmerLocalService, IdentifiableBean {
    @BeanReference(type = agrar.farmer.sbuilder.service.FarmerLocalService.class)
    protected agrar.farmer.sbuilder.service.FarmerLocalService farmerLocalService;
    @BeanReference(type = FarmerPersistence.class)
    protected FarmerPersistence farmerPersistence;
    @BeanReference(type = agrar.farmer.sbuilder.service.FarmerAreaLocalService.class)
    protected agrar.farmer.sbuilder.service.FarmerAreaLocalService farmerAreaLocalService;
    @BeanReference(type = FarmerAreaPersistence.class)
    protected FarmerAreaPersistence farmerAreaPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private FarmerLocalServiceClpInvoker _clpInvoker = new FarmerLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link agrar.farmer.sbuilder.service.FarmerLocalServiceUtil} to access the farmer local service.
     */

    /**
     * Adds the farmer to the database. Also notifies the appropriate model listeners.
     *
     * @param farmer the farmer
     * @return the farmer that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Farmer addFarmer(Farmer farmer) throws SystemException {
        farmer.setNew(true);

        return farmerPersistence.update(farmer);
    }

    /**
     * Creates a new farmer with the primary key. Does not add the farmer to the database.
     *
     * @param id the primary key for the new farmer
     * @return the new farmer
     */
    @Override
    public Farmer createFarmer(long id) {
        return farmerPersistence.create(id);
    }

    /**
     * Deletes the farmer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the farmer
     * @return the farmer that was removed
     * @throws PortalException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Farmer deleteFarmer(long id) throws PortalException, SystemException {
        return farmerPersistence.remove(id);
    }

    /**
     * Deletes the farmer from the database. Also notifies the appropriate model listeners.
     *
     * @param farmer the farmer
     * @return the farmer that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Farmer deleteFarmer(Farmer farmer) throws SystemException {
        return farmerPersistence.remove(farmer);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Farmer.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return farmerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return farmerPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return farmerPersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return farmerPersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return farmerPersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Farmer fetchFarmer(long id) throws SystemException {
        return farmerPersistence.fetchByPrimaryKey(id);
    }

    /**
     * Returns the farmer with the primary key.
     *
     * @param id the primary key of the farmer
     * @return the farmer
     * @throws PortalException if a farmer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Farmer getFarmer(long id) throws PortalException, SystemException {
        return farmerPersistence.findByPrimaryKey(id);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return farmerPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the farmers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link agrar.farmer.sbuilder.model.impl.FarmerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of farmers
     * @param end the upper bound of the range of farmers (not inclusive)
     * @return the range of farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Farmer> getFarmers(int start, int end)
        throws SystemException {
        return farmerPersistence.findAll(start, end);
    }

    /**
     * Returns the number of farmers.
     *
     * @return the number of farmers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getFarmersCount() throws SystemException {
        return farmerPersistence.countAll();
    }

    /**
     * Updates the farmer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param farmer the farmer
     * @return the farmer that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Farmer updateFarmer(Farmer farmer) throws SystemException {
        return farmerPersistence.update(farmer);
    }

    /**
     * Returns the farmer local service.
     *
     * @return the farmer local service
     */
    public agrar.farmer.sbuilder.service.FarmerLocalService getFarmerLocalService() {
        return farmerLocalService;
    }

    /**
     * Sets the farmer local service.
     *
     * @param farmerLocalService the farmer local service
     */
    public void setFarmerLocalService(
        agrar.farmer.sbuilder.service.FarmerLocalService farmerLocalService) {
        this.farmerLocalService = farmerLocalService;
    }

    /**
     * Returns the farmer persistence.
     *
     * @return the farmer persistence
     */
    public FarmerPersistence getFarmerPersistence() {
        return farmerPersistence;
    }

    /**
     * Sets the farmer persistence.
     *
     * @param farmerPersistence the farmer persistence
     */
    public void setFarmerPersistence(FarmerPersistence farmerPersistence) {
        this.farmerPersistence = farmerPersistence;
    }

    /**
     * Returns the farmer area local service.
     *
     * @return the farmer area local service
     */
    public agrar.farmer.sbuilder.service.FarmerAreaLocalService getFarmerAreaLocalService() {
        return farmerAreaLocalService;
    }

    /**
     * Sets the farmer area local service.
     *
     * @param farmerAreaLocalService the farmer area local service
     */
    public void setFarmerAreaLocalService(
        agrar.farmer.sbuilder.service.FarmerAreaLocalService farmerAreaLocalService) {
        this.farmerAreaLocalService = farmerAreaLocalService;
    }

    /**
     * Returns the farmer area persistence.
     *
     * @return the farmer area persistence
     */
    public FarmerAreaPersistence getFarmerAreaPersistence() {
        return farmerAreaPersistence;
    }

    /**
     * Sets the farmer area persistence.
     *
     * @param farmerAreaPersistence the farmer area persistence
     */
    public void setFarmerAreaPersistence(
        FarmerAreaPersistence farmerAreaPersistence) {
        this.farmerAreaPersistence = farmerAreaPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("agrar.farmer.sbuilder.model.Farmer",
            farmerLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "agrar.farmer.sbuilder.model.Farmer");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Farmer.class;
    }

    protected String getModelClassName() {
        return Farmer.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = farmerPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}

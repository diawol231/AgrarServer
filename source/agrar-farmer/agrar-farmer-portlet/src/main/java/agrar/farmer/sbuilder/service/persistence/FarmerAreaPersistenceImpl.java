package agrar.farmer.sbuilder.service.persistence;

import agrar.farmer.sbuilder.NoSuchFarmerAreaException;
import agrar.farmer.sbuilder.model.FarmerArea;
import agrar.farmer.sbuilder.model.impl.FarmerAreaImpl;
import agrar.farmer.sbuilder.model.impl.FarmerAreaModelImpl;
import agrar.farmer.sbuilder.service.persistence.FarmerAreaPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the farmer area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerAreaPersistence
 * @see FarmerAreaUtil
 * @generated
 */
public class FarmerAreaPersistenceImpl extends BasePersistenceImpl<FarmerArea>
    implements FarmerAreaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link FarmerAreaUtil} to access the farmer area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = FarmerAreaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
            FarmerAreaModelImpl.FINDER_CACHE_ENABLED, FarmerAreaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
            FarmerAreaModelImpl.FINDER_CACHE_ENABLED, FarmerAreaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
            FarmerAreaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_FARMERAREA = "SELECT farmerArea FROM FarmerArea farmerArea";
    private static final String _SQL_COUNT_FARMERAREA = "SELECT COUNT(farmerArea) FROM FarmerArea farmerArea";
    private static final String _ORDER_BY_ENTITY_ALIAS = "farmerArea.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FarmerArea exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(FarmerAreaPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id"
            });
    private static FarmerArea _nullFarmerArea = new FarmerAreaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<FarmerArea> toCacheModel() {
                return _nullFarmerAreaCacheModel;
            }
        };

    private static CacheModel<FarmerArea> _nullFarmerAreaCacheModel = new CacheModel<FarmerArea>() {
            @Override
            public FarmerArea toEntityModel() {
                return _nullFarmerArea;
            }
        };

    public FarmerAreaPersistenceImpl() {
        setModelClass(FarmerArea.class);
    }

    /**
     * Caches the farmer area in the entity cache if it is enabled.
     *
     * @param farmerArea the farmer area
     */
    @Override
    public void cacheResult(FarmerArea farmerArea) {
        EntityCacheUtil.putResult(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
            FarmerAreaImpl.class, farmerArea.getPrimaryKey(), farmerArea);

        farmerArea.resetOriginalValues();
    }

    /**
     * Caches the farmer areas in the entity cache if it is enabled.
     *
     * @param farmerAreas the farmer areas
     */
    @Override
    public void cacheResult(List<FarmerArea> farmerAreas) {
        for (FarmerArea farmerArea : farmerAreas) {
            if (EntityCacheUtil.getResult(
                        FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
                        FarmerAreaImpl.class, farmerArea.getPrimaryKey()) == null) {
                cacheResult(farmerArea);
            } else {
                farmerArea.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all farmer areas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(FarmerAreaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(FarmerAreaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the farmer area.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(FarmerArea farmerArea) {
        EntityCacheUtil.removeResult(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
            FarmerAreaImpl.class, farmerArea.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<FarmerArea> farmerAreas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (FarmerArea farmerArea : farmerAreas) {
            EntityCacheUtil.removeResult(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
                FarmerAreaImpl.class, farmerArea.getPrimaryKey());
        }
    }

    /**
     * Creates a new farmer area with the primary key. Does not add the farmer area to the database.
     *
     * @param id the primary key for the new farmer area
     * @return the new farmer area
     */
    @Override
    public FarmerArea create(long id) {
        FarmerArea farmerArea = new FarmerAreaImpl();

        farmerArea.setNew(true);
        farmerArea.setPrimaryKey(id);

        return farmerArea;
    }

    /**
     * Removes the farmer area with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the farmer area
     * @return the farmer area that was removed
     * @throws agrar.farmer.sbuilder.NoSuchFarmerAreaException if a farmer area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FarmerArea remove(long id)
        throws NoSuchFarmerAreaException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the farmer area with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the farmer area
     * @return the farmer area that was removed
     * @throws agrar.farmer.sbuilder.NoSuchFarmerAreaException if a farmer area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FarmerArea remove(Serializable primaryKey)
        throws NoSuchFarmerAreaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            FarmerArea farmerArea = (FarmerArea) session.get(FarmerAreaImpl.class,
                    primaryKey);

            if (farmerArea == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchFarmerAreaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(farmerArea);
        } catch (NoSuchFarmerAreaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected FarmerArea removeImpl(FarmerArea farmerArea)
        throws SystemException {
        farmerArea = toUnwrappedModel(farmerArea);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(farmerArea)) {
                farmerArea = (FarmerArea) session.get(FarmerAreaImpl.class,
                        farmerArea.getPrimaryKeyObj());
            }

            if (farmerArea != null) {
                session.delete(farmerArea);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (farmerArea != null) {
            clearCache(farmerArea);
        }

        return farmerArea;
    }

    @Override
    public FarmerArea updateImpl(
        agrar.farmer.sbuilder.model.FarmerArea farmerArea)
        throws SystemException {
        farmerArea = toUnwrappedModel(farmerArea);

        boolean isNew = farmerArea.isNew();

        Session session = null;

        try {
            session = openSession();

            if (farmerArea.isNew()) {
                session.save(farmerArea);

                farmerArea.setNew(false);
            } else {
                session.merge(farmerArea);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
            FarmerAreaImpl.class, farmerArea.getPrimaryKey(), farmerArea);

        return farmerArea;
    }

    protected FarmerArea toUnwrappedModel(FarmerArea farmerArea) {
        if (farmerArea instanceof FarmerAreaImpl) {
            return farmerArea;
        }

        FarmerAreaImpl farmerAreaImpl = new FarmerAreaImpl();

        farmerAreaImpl.setNew(farmerArea.isNew());
        farmerAreaImpl.setPrimaryKey(farmerArea.getPrimaryKey());

        farmerAreaImpl.setId(farmerArea.getId());
        farmerAreaImpl.setFarmerId(farmerArea.getFarmerId());
        farmerAreaImpl.setAreaId(farmerArea.getAreaId());
        farmerAreaImpl.setDescription(farmerArea.getDescription());

        return farmerAreaImpl;
    }

    /**
     * Returns the farmer area with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the farmer area
     * @return the farmer area
     * @throws agrar.farmer.sbuilder.NoSuchFarmerAreaException if a farmer area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FarmerArea findByPrimaryKey(Serializable primaryKey)
        throws NoSuchFarmerAreaException, SystemException {
        FarmerArea farmerArea = fetchByPrimaryKey(primaryKey);

        if (farmerArea == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchFarmerAreaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return farmerArea;
    }

    /**
     * Returns the farmer area with the primary key or throws a {@link agrar.farmer.sbuilder.NoSuchFarmerAreaException} if it could not be found.
     *
     * @param id the primary key of the farmer area
     * @return the farmer area
     * @throws agrar.farmer.sbuilder.NoSuchFarmerAreaException if a farmer area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FarmerArea findByPrimaryKey(long id)
        throws NoSuchFarmerAreaException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the farmer area with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the farmer area
     * @return the farmer area, or <code>null</code> if a farmer area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FarmerArea fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        FarmerArea farmerArea = (FarmerArea) EntityCacheUtil.getResult(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
                FarmerAreaImpl.class, primaryKey);

        if (farmerArea == _nullFarmerArea) {
            return null;
        }

        if (farmerArea == null) {
            Session session = null;

            try {
                session = openSession();

                farmerArea = (FarmerArea) session.get(FarmerAreaImpl.class,
                        primaryKey);

                if (farmerArea != null) {
                    cacheResult(farmerArea);
                } else {
                    EntityCacheUtil.putResult(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
                        FarmerAreaImpl.class, primaryKey, _nullFarmerArea);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(FarmerAreaModelImpl.ENTITY_CACHE_ENABLED,
                    FarmerAreaImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return farmerArea;
    }

    /**
     * Returns the farmer area with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the farmer area
     * @return the farmer area, or <code>null</code> if a farmer area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public FarmerArea fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the farmer areas.
     *
     * @return the farmer areas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<FarmerArea> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<FarmerArea> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<FarmerArea> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<FarmerArea> list = (List<FarmerArea>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_FARMERAREA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_FARMERAREA;

                if (pagination) {
                    sql = sql.concat(FarmerAreaModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<FarmerArea>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<FarmerArea>(list);
                } else {
                    list = (List<FarmerArea>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the farmer areas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (FarmerArea farmerArea : findAll()) {
            remove(farmerArea);
        }
    }

    /**
     * Returns the number of farmer areas.
     *
     * @return the number of farmer areas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_FARMERAREA);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the farmer area persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.agrar.farmer.sbuilder.model.FarmerArea")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<FarmerArea>> listenersList = new ArrayList<ModelListener<FarmerArea>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<FarmerArea>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(FarmerAreaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

package agrar.farmer.sbuilder.service.persistence;

import agrar.farmer.sbuilder.NoSuchAreaException;
import agrar.farmer.sbuilder.model.Area;
import agrar.farmer.sbuilder.model.impl.AreaImpl;
import agrar.farmer.sbuilder.model.impl.AreaModelImpl;
import agrar.farmer.sbuilder.service.persistence.AreaPersistence;

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
 * The persistence implementation for the area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaPersistence
 * @see AreaUtil
 * @generated
 */
public class AreaPersistenceImpl extends BasePersistenceImpl<Area>
    implements AreaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link AreaUtil} to access the area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = AreaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AreaModelImpl.ENTITY_CACHE_ENABLED,
            AreaModelImpl.FINDER_CACHE_ENABLED, AreaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AreaModelImpl.ENTITY_CACHE_ENABLED,
            AreaModelImpl.FINDER_CACHE_ENABLED, AreaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AreaModelImpl.ENTITY_CACHE_ENABLED,
            AreaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_AREA = "SELECT area FROM Area area";
    private static final String _SQL_COUNT_AREA = "SELECT COUNT(area) FROM Area area";
    private static final String _ORDER_BY_ENTITY_ALIAS = "area.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Area exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(AreaPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "code"
            });
    private static Area _nullArea = new AreaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Area> toCacheModel() {
                return _nullAreaCacheModel;
            }
        };

    private static CacheModel<Area> _nullAreaCacheModel = new CacheModel<Area>() {
            @Override
            public Area toEntityModel() {
                return _nullArea;
            }
        };

    public AreaPersistenceImpl() {
        setModelClass(Area.class);
    }

    /**
     * Caches the area in the entity cache if it is enabled.
     *
     * @param area the area
     */
    @Override
    public void cacheResult(Area area) {
        EntityCacheUtil.putResult(AreaModelImpl.ENTITY_CACHE_ENABLED,
            AreaImpl.class, area.getPrimaryKey(), area);

        area.resetOriginalValues();
    }

    /**
     * Caches the areas in the entity cache if it is enabled.
     *
     * @param areas the areas
     */
    @Override
    public void cacheResult(List<Area> areas) {
        for (Area area : areas) {
            if (EntityCacheUtil.getResult(AreaModelImpl.ENTITY_CACHE_ENABLED,
                        AreaImpl.class, area.getPrimaryKey()) == null) {
                cacheResult(area);
            } else {
                area.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all areas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(AreaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(AreaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the area.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Area area) {
        EntityCacheUtil.removeResult(AreaModelImpl.ENTITY_CACHE_ENABLED,
            AreaImpl.class, area.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Area> areas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Area area : areas) {
            EntityCacheUtil.removeResult(AreaModelImpl.ENTITY_CACHE_ENABLED,
                AreaImpl.class, area.getPrimaryKey());
        }
    }

    /**
     * Creates a new area with the primary key. Does not add the area to the database.
     *
     * @param id the primary key for the new area
     * @return the new area
     */
    @Override
    public Area create(long id) {
        Area area = new AreaImpl();

        area.setNew(true);
        area.setPrimaryKey(id);

        return area;
    }

    /**
     * Removes the area with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the area
     * @return the area that was removed
     * @throws agrar.farmer.sbuilder.NoSuchAreaException if a area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Area remove(long id) throws NoSuchAreaException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the area with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the area
     * @return the area that was removed
     * @throws agrar.farmer.sbuilder.NoSuchAreaException if a area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Area remove(Serializable primaryKey)
        throws NoSuchAreaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Area area = (Area) session.get(AreaImpl.class, primaryKey);

            if (area == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchAreaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(area);
        } catch (NoSuchAreaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Area removeImpl(Area area) throws SystemException {
        area = toUnwrappedModel(area);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(area)) {
                area = (Area) session.get(AreaImpl.class,
                        area.getPrimaryKeyObj());
            }

            if (area != null) {
                session.delete(area);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (area != null) {
            clearCache(area);
        }

        return area;
    }

    @Override
    public Area updateImpl(agrar.farmer.sbuilder.model.Area area)
        throws SystemException {
        area = toUnwrappedModel(area);

        boolean isNew = area.isNew();

        Session session = null;

        try {
            session = openSession();

            if (area.isNew()) {
                session.save(area);

                area.setNew(false);
            } else {
                session.merge(area);
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

        EntityCacheUtil.putResult(AreaModelImpl.ENTITY_CACHE_ENABLED,
            AreaImpl.class, area.getPrimaryKey(), area);

        return area;
    }

    protected Area toUnwrappedModel(Area area) {
        if (area instanceof AreaImpl) {
            return area;
        }

        AreaImpl areaImpl = new AreaImpl();

        areaImpl.setNew(area.isNew());
        areaImpl.setPrimaryKey(area.getPrimaryKey());

        areaImpl.setId(area.getId());
        areaImpl.setArchive(area.isArchive());
        areaImpl.setCode(area.getCode());
        areaImpl.setName(area.getName());

        return areaImpl;
    }

    /**
     * Returns the area with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the area
     * @return the area
     * @throws agrar.farmer.sbuilder.NoSuchAreaException if a area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Area findByPrimaryKey(Serializable primaryKey)
        throws NoSuchAreaException, SystemException {
        Area area = fetchByPrimaryKey(primaryKey);

        if (area == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchAreaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return area;
    }

    /**
     * Returns the area with the primary key or throws a {@link agrar.farmer.sbuilder.NoSuchAreaException} if it could not be found.
     *
     * @param id the primary key of the area
     * @return the area
     * @throws agrar.farmer.sbuilder.NoSuchAreaException if a area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Area findByPrimaryKey(long id)
        throws NoSuchAreaException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the area with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the area
     * @return the area, or <code>null</code> if a area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Area fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Area area = (Area) EntityCacheUtil.getResult(AreaModelImpl.ENTITY_CACHE_ENABLED,
                AreaImpl.class, primaryKey);

        if (area == _nullArea) {
            return null;
        }

        if (area == null) {
            Session session = null;

            try {
                session = openSession();

                area = (Area) session.get(AreaImpl.class, primaryKey);

                if (area != null) {
                    cacheResult(area);
                } else {
                    EntityCacheUtil.putResult(AreaModelImpl.ENTITY_CACHE_ENABLED,
                        AreaImpl.class, primaryKey, _nullArea);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(AreaModelImpl.ENTITY_CACHE_ENABLED,
                    AreaImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return area;
    }

    /**
     * Returns the area with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the area
     * @return the area, or <code>null</code> if a area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Area fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the areas.
     *
     * @return the areas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Area> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

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
    @Override
    public List<Area> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Area> findAll(int start, int end,
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

        List<Area> list = (List<Area>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_AREA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_AREA;

                if (pagination) {
                    sql = sql.concat(AreaModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Area>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Area>(list);
                } else {
                    list = (List<Area>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the areas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Area area : findAll()) {
            remove(area);
        }
    }

    /**
     * Returns the number of areas.
     *
     * @return the number of areas
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

                Query q = session.createQuery(_SQL_COUNT_AREA);

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
     * Initializes the area persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.agrar.farmer.sbuilder.model.Area")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Area>> listenersList = new ArrayList<ModelListener<Area>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Area>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(AreaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

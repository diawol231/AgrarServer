package agrar.dict.sbuilder.service.persistence;

import agrar.dict.sbuilder.NoSuchDictAreaException;
import agrar.dict.sbuilder.model.DictArea;
import agrar.dict.sbuilder.model.impl.DictAreaImpl;
import agrar.dict.sbuilder.model.impl.DictAreaModelImpl;
import agrar.dict.sbuilder.service.persistence.DictAreaPersistence;

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
 * The persistence implementation for the dict area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DictAreaPersistence
 * @see DictAreaUtil
 * @generated
 */
public class DictAreaPersistenceImpl extends BasePersistenceImpl<DictArea>
    implements DictAreaPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link DictAreaUtil} to access the dict area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = DictAreaImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
            DictAreaModelImpl.FINDER_CACHE_ENABLED, DictAreaImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
            DictAreaModelImpl.FINDER_CACHE_ENABLED, DictAreaImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
            DictAreaModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_DICTAREA = "SELECT dictArea FROM DictArea dictArea";
    private static final String _SQL_COUNT_DICTAREA = "SELECT COUNT(dictArea) FROM DictArea dictArea";
    private static final String _ORDER_BY_ENTITY_ALIAS = "dictArea.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DictArea exists with the primary key ";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(DictAreaPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "id", "code"
            });
    private static DictArea _nullDictArea = new DictAreaImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<DictArea> toCacheModel() {
                return _nullDictAreaCacheModel;
            }
        };

    private static CacheModel<DictArea> _nullDictAreaCacheModel = new CacheModel<DictArea>() {
            @Override
            public DictArea toEntityModel() {
                return _nullDictArea;
            }
        };

    public DictAreaPersistenceImpl() {
        setModelClass(DictArea.class);
    }

    /**
     * Caches the dict area in the entity cache if it is enabled.
     *
     * @param dictArea the dict area
     */
    @Override
    public void cacheResult(DictArea dictArea) {
        EntityCacheUtil.putResult(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
            DictAreaImpl.class, dictArea.getPrimaryKey(), dictArea);

        dictArea.resetOriginalValues();
    }

    /**
     * Caches the dict areas in the entity cache if it is enabled.
     *
     * @param dictAreas the dict areas
     */
    @Override
    public void cacheResult(List<DictArea> dictAreas) {
        for (DictArea dictArea : dictAreas) {
            if (EntityCacheUtil.getResult(
                        DictAreaModelImpl.ENTITY_CACHE_ENABLED,
                        DictAreaImpl.class, dictArea.getPrimaryKey()) == null) {
                cacheResult(dictArea);
            } else {
                dictArea.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all dict areas.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(DictAreaImpl.class.getName());
        }

        EntityCacheUtil.clearCache(DictAreaImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the dict area.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(DictArea dictArea) {
        EntityCacheUtil.removeResult(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
            DictAreaImpl.class, dictArea.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<DictArea> dictAreas) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (DictArea dictArea : dictAreas) {
            EntityCacheUtil.removeResult(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
                DictAreaImpl.class, dictArea.getPrimaryKey());
        }
    }

    /**
     * Creates a new dict area with the primary key. Does not add the dict area to the database.
     *
     * @param id the primary key for the new dict area
     * @return the new dict area
     */
    @Override
    public DictArea create(long id) {
        DictArea dictArea = new DictAreaImpl();

        dictArea.setNew(true);
        dictArea.setPrimaryKey(id);

        return dictArea;
    }

    /**
     * Removes the dict area with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the dict area
     * @return the dict area that was removed
     * @throws agrar.dict.sbuilder.NoSuchDictAreaException if a dict area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DictArea remove(long id)
        throws NoSuchDictAreaException, SystemException {
        return remove((Serializable) id);
    }

    /**
     * Removes the dict area with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the dict area
     * @return the dict area that was removed
     * @throws agrar.dict.sbuilder.NoSuchDictAreaException if a dict area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DictArea remove(Serializable primaryKey)
        throws NoSuchDictAreaException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DictArea dictArea = (DictArea) session.get(DictAreaImpl.class,
                    primaryKey);

            if (dictArea == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchDictAreaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(dictArea);
        } catch (NoSuchDictAreaException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected DictArea removeImpl(DictArea dictArea) throws SystemException {
        dictArea = toUnwrappedModel(dictArea);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(dictArea)) {
                dictArea = (DictArea) session.get(DictAreaImpl.class,
                        dictArea.getPrimaryKeyObj());
            }

            if (dictArea != null) {
                session.delete(dictArea);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (dictArea != null) {
            clearCache(dictArea);
        }

        return dictArea;
    }

    @Override
    public DictArea updateImpl(agrar.dict.sbuilder.model.DictArea dictArea)
        throws SystemException {
        dictArea = toUnwrappedModel(dictArea);

        boolean isNew = dictArea.isNew();

        Session session = null;

        try {
            session = openSession();

            if (dictArea.isNew()) {
                session.save(dictArea);

                dictArea.setNew(false);
            } else {
                session.merge(dictArea);
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

        EntityCacheUtil.putResult(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
            DictAreaImpl.class, dictArea.getPrimaryKey(), dictArea);

        return dictArea;
    }

    protected DictArea toUnwrappedModel(DictArea dictArea) {
        if (dictArea instanceof DictAreaImpl) {
            return dictArea;
        }

        DictAreaImpl dictAreaImpl = new DictAreaImpl();

        dictAreaImpl.setNew(dictArea.isNew());
        dictAreaImpl.setPrimaryKey(dictArea.getPrimaryKey());

        dictAreaImpl.setId(dictArea.getId());
        dictAreaImpl.setArchive(dictArea.isArchive());
        dictAreaImpl.setCode(dictArea.getCode());
        dictAreaImpl.setName(dictArea.getName());

        return dictAreaImpl;
    }

    /**
     * Returns the dict area with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the dict area
     * @return the dict area
     * @throws agrar.dict.sbuilder.NoSuchDictAreaException if a dict area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DictArea findByPrimaryKey(Serializable primaryKey)
        throws NoSuchDictAreaException, SystemException {
        DictArea dictArea = fetchByPrimaryKey(primaryKey);

        if (dictArea == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchDictAreaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return dictArea;
    }

    /**
     * Returns the dict area with the primary key or throws a {@link agrar.dict.sbuilder.NoSuchDictAreaException} if it could not be found.
     *
     * @param id the primary key of the dict area
     * @return the dict area
     * @throws agrar.dict.sbuilder.NoSuchDictAreaException if a dict area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DictArea findByPrimaryKey(long id)
        throws NoSuchDictAreaException, SystemException {
        return findByPrimaryKey((Serializable) id);
    }

    /**
     * Returns the dict area with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the dict area
     * @return the dict area, or <code>null</code> if a dict area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DictArea fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        DictArea dictArea = (DictArea) EntityCacheUtil.getResult(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
                DictAreaImpl.class, primaryKey);

        if (dictArea == _nullDictArea) {
            return null;
        }

        if (dictArea == null) {
            Session session = null;

            try {
                session = openSession();

                dictArea = (DictArea) session.get(DictAreaImpl.class, primaryKey);

                if (dictArea != null) {
                    cacheResult(dictArea);
                } else {
                    EntityCacheUtil.putResult(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
                        DictAreaImpl.class, primaryKey, _nullDictArea);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(DictAreaModelImpl.ENTITY_CACHE_ENABLED,
                    DictAreaImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return dictArea;
    }

    /**
     * Returns the dict area with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the dict area
     * @return the dict area, or <code>null</code> if a dict area with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public DictArea fetchByPrimaryKey(long id) throws SystemException {
        return fetchByPrimaryKey((Serializable) id);
    }

    /**
     * Returns all the dict areas.
     *
     * @return the dict areas
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<DictArea> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<DictArea> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<DictArea> findAll(int start, int end,
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

        List<DictArea> list = (List<DictArea>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_DICTAREA);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_DICTAREA;

                if (pagination) {
                    sql = sql.concat(DictAreaModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<DictArea>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<DictArea>(list);
                } else {
                    list = (List<DictArea>) QueryUtil.list(q, getDialect(),
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
     * Removes all the dict areas from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (DictArea dictArea : findAll()) {
            remove(dictArea);
        }
    }

    /**
     * Returns the number of dict areas.
     *
     * @return the number of dict areas
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

                Query q = session.createQuery(_SQL_COUNT_DICTAREA);

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
     * Initializes the dict area persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.agrar.dict.sbuilder.model.DictArea")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DictArea>> listenersList = new ArrayList<ModelListener<DictArea>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DictArea>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(DictAreaImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}

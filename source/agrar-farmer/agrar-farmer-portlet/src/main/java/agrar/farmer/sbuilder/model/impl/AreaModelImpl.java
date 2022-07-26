package agrar.farmer.sbuilder.model.impl;

import agrar.farmer.sbuilder.model.Area;
import agrar.farmer.sbuilder.model.AreaModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Area service. Represents a row in the &quot;agrar_Area&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link agrar.farmer.sbuilder.model.AreaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AreaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AreaImpl
 * @see agrar.farmer.sbuilder.model.Area
 * @see agrar.farmer.sbuilder.model.AreaModel
 * @generated
 */
public class AreaModelImpl extends BaseModelImpl<Area> implements AreaModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a area model instance should use the {@link agrar.farmer.sbuilder.model.Area} interface instead.
     */
    public static final String TABLE_NAME = "agrar_Area";
    public static final Object[][] TABLE_COLUMNS = {
            { "id_", Types.BIGINT },
            { "archive", Types.BOOLEAN },
            { "code_", Types.BIGINT },
            { "name", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table agrar_Area (id_ LONG not null primary key,archive BOOLEAN,code_ LONG,name VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table agrar_Area";
    public static final String ORDER_BY_JPQL = " ORDER BY area.id ASC";
    public static final String ORDER_BY_SQL = " ORDER BY agrar_Area.id_ ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.agrar.farmer.sbuilder.model.Area"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.agrar.farmer.sbuilder.model.Area"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.agrar.farmer.sbuilder.model.Area"));
    private static ClassLoader _classLoader = Area.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Area.class };
    private long _id;
    private boolean _archive;
    private long _code;
    private String _name;
    private Area _escapedModel;

    public AreaModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Area.class;
    }

    @Override
    public String getModelClassName() {
        return Area.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("archive", getArchive());
        attributes.put("code", getCode());
        attributes.put("name", getName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Boolean archive = (Boolean) attributes.get("archive");

        if (archive != null) {
            setArchive(archive);
        }

        Long code = (Long) attributes.get("code");

        if (code != null) {
            setCode(code);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }
    }

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;
    }

    @Override
    public boolean getArchive() {
        return _archive;
    }

    @Override
    public boolean isArchive() {
        return _archive;
    }

    @Override
    public void setArchive(boolean archive) {
        _archive = archive;
    }

    @Override
    public long getCode() {
        return _code;
    }

    @Override
    public void setCode(long code) {
        _code = code;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            Area.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Area toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Area) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        AreaImpl areaImpl = new AreaImpl();

        areaImpl.setId(getId());
        areaImpl.setArchive(getArchive());
        areaImpl.setCode(getCode());
        areaImpl.setName(getName());

        areaImpl.resetOriginalValues();

        return areaImpl;
    }

    @Override
    public int compareTo(Area area) {
        long primaryKey = area.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Area)) {
            return false;
        }

        Area area = (Area) obj;

        long primaryKey = area.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
    }

    @Override
    public CacheModel<Area> toCacheModel() {
        AreaCacheModel areaCacheModel = new AreaCacheModel();

        areaCacheModel.id = getId();

        areaCacheModel.archive = getArchive();

        areaCacheModel.code = getCode();

        areaCacheModel.name = getName();

        String name = areaCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            areaCacheModel.name = null;
        }

        return areaCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", archive=");
        sb.append(getArchive());
        sb.append(", code=");
        sb.append(getCode());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("agrar.farmer.sbuilder.model.Area");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>archive</column-name><column-value><![CDATA[");
        sb.append(getArchive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>code</column-name><column-value><![CDATA[");
        sb.append(getCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

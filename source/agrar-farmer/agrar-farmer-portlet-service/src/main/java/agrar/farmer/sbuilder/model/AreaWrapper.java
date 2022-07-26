package agrar.farmer.sbuilder.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Area}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @generated
 */
public class AreaWrapper implements Area, ModelWrapper<Area> {
    private Area _area;

    public AreaWrapper(Area area) {
        _area = area;
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

    /**
    * Returns the primary key of this area.
    *
    * @return the primary key of this area
    */
    @Override
    public long getPrimaryKey() {
        return _area.getPrimaryKey();
    }

    /**
    * Sets the primary key of this area.
    *
    * @param primaryKey the primary key of this area
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _area.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this area.
    *
    * @return the ID of this area
    */
    @Override
    public long getId() {
        return _area.getId();
    }

    /**
    * Sets the ID of this area.
    *
    * @param id the ID of this area
    */
    @Override
    public void setId(long id) {
        _area.setId(id);
    }

    /**
    * Returns the archive of this area.
    *
    * @return the archive of this area
    */
    @Override
    public boolean getArchive() {
        return _area.getArchive();
    }

    /**
    * Returns <code>true</code> if this area is archive.
    *
    * @return <code>true</code> if this area is archive; <code>false</code> otherwise
    */
    @Override
    public boolean isArchive() {
        return _area.isArchive();
    }

    /**
    * Sets whether this area is archive.
    *
    * @param archive the archive of this area
    */
    @Override
    public void setArchive(boolean archive) {
        _area.setArchive(archive);
    }

    /**
    * Returns the code of this area.
    *
    * @return the code of this area
    */
    @Override
    public long getCode() {
        return _area.getCode();
    }

    /**
    * Sets the code of this area.
    *
    * @param code the code of this area
    */
    @Override
    public void setCode(long code) {
        _area.setCode(code);
    }

    /**
    * Returns the name of this area.
    *
    * @return the name of this area
    */
    @Override
    public java.lang.String getName() {
        return _area.getName();
    }

    /**
    * Sets the name of this area.
    *
    * @param name the name of this area
    */
    @Override
    public void setName(java.lang.String name) {
        _area.setName(name);
    }

    @Override
    public boolean isNew() {
        return _area.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _area.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _area.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _area.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _area.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _area.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _area.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _area.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _area.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _area.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _area.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new AreaWrapper((Area) _area.clone());
    }

    @Override
    public int compareTo(agrar.farmer.sbuilder.model.Area area) {
        return _area.compareTo(area);
    }

    @Override
    public int hashCode() {
        return _area.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<agrar.farmer.sbuilder.model.Area> toCacheModel() {
        return _area.toCacheModel();
    }

    @Override
    public agrar.farmer.sbuilder.model.Area toEscapedModel() {
        return new AreaWrapper(_area.toEscapedModel());
    }

    @Override
    public agrar.farmer.sbuilder.model.Area toUnescapedModel() {
        return new AreaWrapper(_area.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _area.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _area.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _area.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof AreaWrapper)) {
            return false;
        }

        AreaWrapper areaWrapper = (AreaWrapper) obj;

        if (Validator.equals(_area, areaWrapper._area)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Area getWrappedArea() {
        return _area;
    }

    @Override
    public Area getWrappedModel() {
        return _area;
    }

    @Override
    public void resetOriginalValues() {
        _area.resetOriginalValues();
    }
}

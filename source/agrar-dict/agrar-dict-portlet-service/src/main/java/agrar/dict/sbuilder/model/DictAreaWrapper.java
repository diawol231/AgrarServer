package agrar.dict.sbuilder.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DictArea}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DictArea
 * @generated
 */
public class DictAreaWrapper implements DictArea, ModelWrapper<DictArea> {
    private DictArea _dictArea;

    public DictAreaWrapper(DictArea dictArea) {
        _dictArea = dictArea;
    }

    @Override
    public Class<?> getModelClass() {
        return DictArea.class;
    }

    @Override
    public String getModelClassName() {
        return DictArea.class.getName();
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
    * Returns the primary key of this dict area.
    *
    * @return the primary key of this dict area
    */
    @Override
    public long getPrimaryKey() {
        return _dictArea.getPrimaryKey();
    }

    /**
    * Sets the primary key of this dict area.
    *
    * @param primaryKey the primary key of this dict area
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _dictArea.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this dict area.
    *
    * @return the ID of this dict area
    */
    @Override
    public long getId() {
        return _dictArea.getId();
    }

    /**
    * Sets the ID of this dict area.
    *
    * @param id the ID of this dict area
    */
    @Override
    public void setId(long id) {
        _dictArea.setId(id);
    }

    /**
    * Returns the archive of this dict area.
    *
    * @return the archive of this dict area
    */
    @Override
    public boolean getArchive() {
        return _dictArea.getArchive();
    }

    /**
    * Returns <code>true</code> if this dict area is archive.
    *
    * @return <code>true</code> if this dict area is archive; <code>false</code> otherwise
    */
    @Override
    public boolean isArchive() {
        return _dictArea.isArchive();
    }

    /**
    * Sets whether this dict area is archive.
    *
    * @param archive the archive of this dict area
    */
    @Override
    public void setArchive(boolean archive) {
        _dictArea.setArchive(archive);
    }

    /**
    * Returns the code of this dict area.
    *
    * @return the code of this dict area
    */
    @Override
    public long getCode() {
        return _dictArea.getCode();
    }

    /**
    * Sets the code of this dict area.
    *
    * @param code the code of this dict area
    */
    @Override
    public void setCode(long code) {
        _dictArea.setCode(code);
    }

    /**
    * Returns the name of this dict area.
    *
    * @return the name of this dict area
    */
    @Override
    public java.lang.String getName() {
        return _dictArea.getName();
    }

    /**
    * Sets the name of this dict area.
    *
    * @param name the name of this dict area
    */
    @Override
    public void setName(java.lang.String name) {
        _dictArea.setName(name);
    }

    @Override
    public boolean isNew() {
        return _dictArea.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _dictArea.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _dictArea.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _dictArea.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _dictArea.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _dictArea.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _dictArea.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _dictArea.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _dictArea.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _dictArea.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _dictArea.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DictAreaWrapper((DictArea) _dictArea.clone());
    }

    @Override
    public int compareTo(agrar.dict.sbuilder.model.DictArea dictArea) {
        return _dictArea.compareTo(dictArea);
    }

    @Override
    public int hashCode() {
        return _dictArea.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<agrar.dict.sbuilder.model.DictArea> toCacheModel() {
        return _dictArea.toCacheModel();
    }

    @Override
    public agrar.dict.sbuilder.model.DictArea toEscapedModel() {
        return new DictAreaWrapper(_dictArea.toEscapedModel());
    }

    @Override
    public agrar.dict.sbuilder.model.DictArea toUnescapedModel() {
        return new DictAreaWrapper(_dictArea.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _dictArea.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _dictArea.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _dictArea.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DictAreaWrapper)) {
            return false;
        }

        DictAreaWrapper dictAreaWrapper = (DictAreaWrapper) obj;

        if (Validator.equals(_dictArea, dictAreaWrapper._dictArea)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public DictArea getWrappedDictArea() {
        return _dictArea;
    }

    @Override
    public DictArea getWrappedModel() {
        return _dictArea;
    }

    @Override
    public void resetOriginalValues() {
        _dictArea.resetOriginalValues();
    }
}

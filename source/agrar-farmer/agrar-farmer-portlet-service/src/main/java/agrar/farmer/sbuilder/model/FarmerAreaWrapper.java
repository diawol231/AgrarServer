package agrar.farmer.sbuilder.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FarmerArea}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FarmerArea
 * @generated
 */
public class FarmerAreaWrapper implements FarmerArea, ModelWrapper<FarmerArea> {
    private FarmerArea _farmerArea;

    public FarmerAreaWrapper(FarmerArea farmerArea) {
        _farmerArea = farmerArea;
    }

    @Override
    public Class<?> getModelClass() {
        return FarmerArea.class;
    }

    @Override
    public String getModelClassName() {
        return FarmerArea.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("farmerId", getFarmerId());
        attributes.put("areaId", getAreaId());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Long farmerId = (Long) attributes.get("farmerId");

        if (farmerId != null) {
            setFarmerId(farmerId);
        }

        Long areaId = (Long) attributes.get("areaId");

        if (areaId != null) {
            setAreaId(areaId);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }
    }

    /**
    * Returns the primary key of this farmer area.
    *
    * @return the primary key of this farmer area
    */
    @Override
    public long getPrimaryKey() {
        return _farmerArea.getPrimaryKey();
    }

    /**
    * Sets the primary key of this farmer area.
    *
    * @param primaryKey the primary key of this farmer area
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _farmerArea.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this farmer area.
    *
    * @return the ID of this farmer area
    */
    @Override
    public long getId() {
        return _farmerArea.getId();
    }

    /**
    * Sets the ID of this farmer area.
    *
    * @param id the ID of this farmer area
    */
    @Override
    public void setId(long id) {
        _farmerArea.setId(id);
    }

    /**
    * Returns the farmer ID of this farmer area.
    *
    * @return the farmer ID of this farmer area
    */
    @Override
    public long getFarmerId() {
        return _farmerArea.getFarmerId();
    }

    /**
    * Sets the farmer ID of this farmer area.
    *
    * @param farmerId the farmer ID of this farmer area
    */
    @Override
    public void setFarmerId(long farmerId) {
        _farmerArea.setFarmerId(farmerId);
    }

    /**
    * Returns the area ID of this farmer area.
    *
    * @return the area ID of this farmer area
    */
    @Override
    public long getAreaId() {
        return _farmerArea.getAreaId();
    }

    /**
    * Sets the area ID of this farmer area.
    *
    * @param areaId the area ID of this farmer area
    */
    @Override
    public void setAreaId(long areaId) {
        _farmerArea.setAreaId(areaId);
    }

    /**
    * Returns the description of this farmer area.
    *
    * @return the description of this farmer area
    */
    @Override
    public java.lang.String getDescription() {
        return _farmerArea.getDescription();
    }

    /**
    * Sets the description of this farmer area.
    *
    * @param description the description of this farmer area
    */
    @Override
    public void setDescription(java.lang.String description) {
        _farmerArea.setDescription(description);
    }

    @Override
    public boolean isNew() {
        return _farmerArea.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _farmerArea.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _farmerArea.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _farmerArea.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _farmerArea.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _farmerArea.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _farmerArea.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _farmerArea.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _farmerArea.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _farmerArea.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _farmerArea.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FarmerAreaWrapper((FarmerArea) _farmerArea.clone());
    }

    @Override
    public int compareTo(agrar.farmer.sbuilder.model.FarmerArea farmerArea) {
        return _farmerArea.compareTo(farmerArea);
    }

    @Override
    public int hashCode() {
        return _farmerArea.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<agrar.farmer.sbuilder.model.FarmerArea> toCacheModel() {
        return _farmerArea.toCacheModel();
    }

    @Override
    public agrar.farmer.sbuilder.model.FarmerArea toEscapedModel() {
        return new FarmerAreaWrapper(_farmerArea.toEscapedModel());
    }

    @Override
    public agrar.farmer.sbuilder.model.FarmerArea toUnescapedModel() {
        return new FarmerAreaWrapper(_farmerArea.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _farmerArea.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _farmerArea.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmerArea.persist();
    }

    /**
    * Отображение названия района фермера
    *
    * @return
    */
    @Override
    public java.lang.String showArea() {
        return _farmerArea.showArea();
    }

    /**
    * Получение кода района фермера
    *
    * @return
    */
    @Override
    public long getAreaCode() {
        return _farmerArea.getAreaCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FarmerAreaWrapper)) {
            return false;
        }

        FarmerAreaWrapper farmerAreaWrapper = (FarmerAreaWrapper) obj;

        if (Validator.equals(_farmerArea, farmerAreaWrapper._farmerArea)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public FarmerArea getWrappedFarmerArea() {
        return _farmerArea;
    }

    @Override
    public FarmerArea getWrappedModel() {
        return _farmerArea;
    }

    @Override
    public void resetOriginalValues() {
        _farmerArea.resetOriginalValues();
    }
}

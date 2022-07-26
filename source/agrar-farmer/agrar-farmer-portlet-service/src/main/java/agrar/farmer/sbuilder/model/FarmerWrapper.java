package agrar.farmer.sbuilder.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Farmer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Farmer
 * @generated
 */
public class FarmerWrapper implements Farmer, ModelWrapper<Farmer> {
    private Farmer _farmer;

    public FarmerWrapper(Farmer farmer) {
        _farmer = farmer;
    }

    @Override
    public Class<?> getModelClass() {
        return Farmer.class;
    }

    @Override
    public String getModelClassName() {
        return Farmer.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("archive", getArchive());
        attributes.put("form", getForm());
        attributes.put("name", getName());
        attributes.put("inn", getInn());
        attributes.put("kpp", getKpp());
        attributes.put("ogrn", getOgrn());
        attributes.put("registrationArea", getRegistrationArea());
        attributes.put("registrationDate", getRegistrationDate());

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

        Integer form = (Integer) attributes.get("form");

        if (form != null) {
            setForm(form);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String inn = (String) attributes.get("inn");

        if (inn != null) {
            setInn(inn);
        }

        String kpp = (String) attributes.get("kpp");

        if (kpp != null) {
            setKpp(kpp);
        }

        String ogrn = (String) attributes.get("ogrn");

        if (ogrn != null) {
            setOgrn(ogrn);
        }

        Long registrationArea = (Long) attributes.get("registrationArea");

        if (registrationArea != null) {
            setRegistrationArea(registrationArea);
        }

        Date registrationDate = (Date) attributes.get("registrationDate");

        if (registrationDate != null) {
            setRegistrationDate(registrationDate);
        }
    }

    /**
    * Returns the primary key of this farmer.
    *
    * @return the primary key of this farmer
    */
    @Override
    public long getPrimaryKey() {
        return _farmer.getPrimaryKey();
    }

    /**
    * Sets the primary key of this farmer.
    *
    * @param primaryKey the primary key of this farmer
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _farmer.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ID of this farmer.
    *
    * @return the ID of this farmer
    */
    @Override
    public long getId() {
        return _farmer.getId();
    }

    /**
    * Sets the ID of this farmer.
    *
    * @param id the ID of this farmer
    */
    @Override
    public void setId(long id) {
        _farmer.setId(id);
    }

    /**
    * Returns the archive of this farmer.
    *
    * @return the archive of this farmer
    */
    @Override
    public boolean getArchive() {
        return _farmer.getArchive();
    }

    /**
    * Returns <code>true</code> if this farmer is archive.
    *
    * @return <code>true</code> if this farmer is archive; <code>false</code> otherwise
    */
    @Override
    public boolean isArchive() {
        return _farmer.isArchive();
    }

    /**
    * Sets whether this farmer is archive.
    *
    * @param archive the archive of this farmer
    */
    @Override
    public void setArchive(boolean archive) {
        _farmer.setArchive(archive);
    }

    /**
    * Returns the form of this farmer.
    *
    * @return the form of this farmer
    */
    @Override
    public int getForm() {
        return _farmer.getForm();
    }

    /**
    * Sets the form of this farmer.
    *
    * @param form the form of this farmer
    */
    @Override
    public void setForm(int form) {
        _farmer.setForm(form);
    }

    /**
    * Returns the name of this farmer.
    *
    * @return the name of this farmer
    */
    @Override
    public java.lang.String getName() {
        return _farmer.getName();
    }

    /**
    * Sets the name of this farmer.
    *
    * @param name the name of this farmer
    */
    @Override
    public void setName(java.lang.String name) {
        _farmer.setName(name);
    }

    /**
    * Returns the inn of this farmer.
    *
    * @return the inn of this farmer
    */
    @Override
    public java.lang.String getInn() {
        return _farmer.getInn();
    }

    /**
    * Sets the inn of this farmer.
    *
    * @param inn the inn of this farmer
    */
    @Override
    public void setInn(java.lang.String inn) {
        _farmer.setInn(inn);
    }

    /**
    * Returns the kpp of this farmer.
    *
    * @return the kpp of this farmer
    */
    @Override
    public java.lang.String getKpp() {
        return _farmer.getKpp();
    }

    /**
    * Sets the kpp of this farmer.
    *
    * @param kpp the kpp of this farmer
    */
    @Override
    public void setKpp(java.lang.String kpp) {
        _farmer.setKpp(kpp);
    }

    /**
    * Returns the ogrn of this farmer.
    *
    * @return the ogrn of this farmer
    */
    @Override
    public java.lang.String getOgrn() {
        return _farmer.getOgrn();
    }

    /**
    * Sets the ogrn of this farmer.
    *
    * @param ogrn the ogrn of this farmer
    */
    @Override
    public void setOgrn(java.lang.String ogrn) {
        _farmer.setOgrn(ogrn);
    }

    /**
    * Returns the registration area of this farmer.
    *
    * @return the registration area of this farmer
    */
    @Override
    public long getRegistrationArea() {
        return _farmer.getRegistrationArea();
    }

    /**
    * Sets the registration area of this farmer.
    *
    * @param registrationArea the registration area of this farmer
    */
    @Override
    public void setRegistrationArea(long registrationArea) {
        _farmer.setRegistrationArea(registrationArea);
    }

    /**
    * Returns the registration date of this farmer.
    *
    * @return the registration date of this farmer
    */
    @Override
    public java.util.Date getRegistrationDate() {
        return _farmer.getRegistrationDate();
    }

    /**
    * Sets the registration date of this farmer.
    *
    * @param registrationDate the registration date of this farmer
    */
    @Override
    public void setRegistrationDate(java.util.Date registrationDate) {
        _farmer.setRegistrationDate(registrationDate);
    }

    @Override
    public boolean isNew() {
        return _farmer.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _farmer.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _farmer.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _farmer.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _farmer.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _farmer.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _farmer.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _farmer.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _farmer.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _farmer.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _farmer.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FarmerWrapper((Farmer) _farmer.clone());
    }

    @Override
    public int compareTo(agrar.farmer.sbuilder.model.Farmer farmer) {
        return _farmer.compareTo(farmer);
    }

    @Override
    public int hashCode() {
        return _farmer.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<agrar.farmer.sbuilder.model.Farmer> toCacheModel() {
        return _farmer.toCacheModel();
    }

    @Override
    public agrar.farmer.sbuilder.model.Farmer toEscapedModel() {
        return new FarmerWrapper(_farmer.toEscapedModel());
    }

    @Override
    public agrar.farmer.sbuilder.model.Farmer toUnescapedModel() {
        return new FarmerWrapper(_farmer.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _farmer.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _farmer.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _farmer.persist();
    }

    @Override
    public java.lang.String showForm() {
        return _farmer.showForm();
    }

    @Override
    public java.lang.String showRegArea() {
        return _farmer.showRegArea();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FarmerWrapper)) {
            return false;
        }

        FarmerWrapper farmerWrapper = (FarmerWrapper) obj;

        if (Validator.equals(_farmer, farmerWrapper._farmer)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Farmer getWrappedFarmer() {
        return _farmer;
    }

    @Override
    public Farmer getWrappedModel() {
        return _farmer;
    }

    @Override
    public void resetOriginalValues() {
        _farmer.resetOriginalValues();
    }
}

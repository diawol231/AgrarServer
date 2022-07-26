package agrar.farmer.sbuilder.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Area service. Represents a row in the &quot;agrar_Area&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link agrar.farmer.sbuilder.model.impl.AreaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link agrar.farmer.sbuilder.model.impl.AreaImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @see agrar.farmer.sbuilder.model.impl.AreaImpl
 * @see agrar.farmer.sbuilder.model.impl.AreaModelImpl
 * @generated
 */
public interface AreaModel extends BaseModel<Area> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a area model instance should use the {@link Area} interface instead.
     */

    /**
     * Returns the primary key of this area.
     *
     * @return the primary key of this area
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this area.
     *
     * @param primaryKey the primary key of this area
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the ID of this area.
     *
     * @return the ID of this area
     */
    public long getId();

    /**
     * Sets the ID of this area.
     *
     * @param id the ID of this area
     */
    public void setId(long id);

    /**
     * Returns the archive of this area.
     *
     * @return the archive of this area
     */
    public boolean getArchive();

    /**
     * Returns <code>true</code> if this area is archive.
     *
     * @return <code>true</code> if this area is archive; <code>false</code> otherwise
     */
    public boolean isArchive();

    /**
     * Sets whether this area is archive.
     *
     * @param archive the archive of this area
     */
    public void setArchive(boolean archive);

    /**
     * Returns the code of this area.
     *
     * @return the code of this area
     */
    public long getCode();

    /**
     * Sets the code of this area.
     *
     * @param code the code of this area
     */
    public void setCode(long code);

    /**
     * Returns the name of this area.
     *
     * @return the name of this area
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this area.
     *
     * @param name the name of this area
     */
    public void setName(String name);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(agrar.farmer.sbuilder.model.Area area);

    @Override
    public int hashCode();

    @Override
    public CacheModel<agrar.farmer.sbuilder.model.Area> toCacheModel();

    @Override
    public agrar.farmer.sbuilder.model.Area toEscapedModel();

    @Override
    public agrar.farmer.sbuilder.model.Area toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}

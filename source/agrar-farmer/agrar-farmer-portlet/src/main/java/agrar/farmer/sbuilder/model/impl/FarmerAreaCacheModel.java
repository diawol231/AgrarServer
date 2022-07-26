package agrar.farmer.sbuilder.model.impl;

import agrar.farmer.sbuilder.model.FarmerArea;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FarmerArea in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FarmerArea
 * @generated
 */
public class FarmerAreaCacheModel implements CacheModel<FarmerArea>,
    Externalizable {
    public long id;
    public long farmerId;
    public long areaId;
    public String description;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", farmerId=");
        sb.append(farmerId);
        sb.append(", areaId=");
        sb.append(areaId);
        sb.append(", description=");
        sb.append(description);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public FarmerArea toEntityModel() {
        FarmerAreaImpl farmerAreaImpl = new FarmerAreaImpl();

        farmerAreaImpl.setId(id);
        farmerAreaImpl.setFarmerId(farmerId);
        farmerAreaImpl.setAreaId(areaId);

        if (description == null) {
            farmerAreaImpl.setDescription(StringPool.BLANK);
        } else {
            farmerAreaImpl.setDescription(description);
        }

        farmerAreaImpl.resetOriginalValues();

        return farmerAreaImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        farmerId = objectInput.readLong();
        areaId = objectInput.readLong();
        description = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeLong(farmerId);
        objectOutput.writeLong(areaId);

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }
    }
}

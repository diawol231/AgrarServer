package agrar.farmer.sbuilder.model.impl;

import agrar.farmer.sbuilder.model.Area;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Area in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Area
 * @generated
 */
public class AreaCacheModel implements CacheModel<Area>, Externalizable {
    public long id;
    public boolean archive;
    public long code;
    public String name;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(id);
        sb.append(", archive=");
        sb.append(archive);
        sb.append(", code=");
        sb.append(code);
        sb.append(", name=");
        sb.append(name);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Area toEntityModel() {
        AreaImpl areaImpl = new AreaImpl();

        areaImpl.setId(id);
        areaImpl.setArchive(archive);
        areaImpl.setCode(code);

        if (name == null) {
            areaImpl.setName(StringPool.BLANK);
        } else {
            areaImpl.setName(name);
        }

        areaImpl.resetOriginalValues();

        return areaImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        archive = objectInput.readBoolean();
        code = objectInput.readLong();
        name = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeBoolean(archive);
        objectOutput.writeLong(code);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }
    }
}

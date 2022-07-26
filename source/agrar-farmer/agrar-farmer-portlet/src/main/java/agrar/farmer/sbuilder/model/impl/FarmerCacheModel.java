package agrar.farmer.sbuilder.model.impl;

import agrar.farmer.sbuilder.model.Farmer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Farmer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Farmer
 * @generated
 */
public class FarmerCacheModel implements CacheModel<Farmer>, Externalizable {
    public long id;
    public boolean archive;
    public int form;
    public String name;
    public String inn;
    public String kpp;
    public String ogrn;
    public long registrationArea;
    public long registrationDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{id=");
        sb.append(id);
        sb.append(", archive=");
        sb.append(archive);
        sb.append(", form=");
        sb.append(form);
        sb.append(", name=");
        sb.append(name);
        sb.append(", inn=");
        sb.append(inn);
        sb.append(", kpp=");
        sb.append(kpp);
        sb.append(", ogrn=");
        sb.append(ogrn);
        sb.append(", registrationArea=");
        sb.append(registrationArea);
        sb.append(", registrationDate=");
        sb.append(registrationDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Farmer toEntityModel() {
        FarmerImpl farmerImpl = new FarmerImpl();

        farmerImpl.setId(id);
        farmerImpl.setArchive(archive);
        farmerImpl.setForm(form);

        if (name == null) {
            farmerImpl.setName(StringPool.BLANK);
        } else {
            farmerImpl.setName(name);
        }

        if (inn == null) {
            farmerImpl.setInn(StringPool.BLANK);
        } else {
            farmerImpl.setInn(inn);
        }

        if (kpp == null) {
            farmerImpl.setKpp(StringPool.BLANK);
        } else {
            farmerImpl.setKpp(kpp);
        }

        if (ogrn == null) {
            farmerImpl.setOgrn(StringPool.BLANK);
        } else {
            farmerImpl.setOgrn(ogrn);
        }

        farmerImpl.setRegistrationArea(registrationArea);

        if (registrationDate == Long.MIN_VALUE) {
            farmerImpl.setRegistrationDate(null);
        } else {
            farmerImpl.setRegistrationDate(new Date(registrationDate));
        }

        farmerImpl.resetOriginalValues();

        return farmerImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        id = objectInput.readLong();
        archive = objectInput.readBoolean();
        form = objectInput.readInt();
        name = objectInput.readUTF();
        inn = objectInput.readUTF();
        kpp = objectInput.readUTF();
        ogrn = objectInput.readUTF();
        registrationArea = objectInput.readLong();
        registrationDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(id);
        objectOutput.writeBoolean(archive);
        objectOutput.writeInt(form);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (inn == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(inn);
        }

        if (kpp == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kpp);
        }

        if (ogrn == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(ogrn);
        }

        objectOutput.writeLong(registrationArea);
        objectOutput.writeLong(registrationDate);
    }
}

package agrar.dict.sbuilder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DictAreaSoap implements Serializable {
    private long _id;
    private boolean _archive;
    private long _code;
    private String _name;

    public DictAreaSoap() {
    }

    public static DictAreaSoap toSoapModel(DictArea model) {
        DictAreaSoap soapModel = new DictAreaSoap();

        soapModel.setId(model.getId());
        soapModel.setArchive(model.getArchive());
        soapModel.setCode(model.getCode());
        soapModel.setName(model.getName());

        return soapModel;
    }

    public static DictAreaSoap[] toSoapModels(DictArea[] models) {
        DictAreaSoap[] soapModels = new DictAreaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static DictAreaSoap[][] toSoapModels(DictArea[][] models) {
        DictAreaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new DictAreaSoap[models.length][models[0].length];
        } else {
            soapModels = new DictAreaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static DictAreaSoap[] toSoapModels(List<DictArea> models) {
        List<DictAreaSoap> soapModels = new ArrayList<DictAreaSoap>(models.size());

        for (DictArea model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new DictAreaSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public boolean getArchive() {
        return _archive;
    }

    public boolean isArchive() {
        return _archive;
    }

    public void setArchive(boolean archive) {
        _archive = archive;
    }

    public long getCode() {
        return _code;
    }

    public void setCode(long code) {
        _code = code;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}

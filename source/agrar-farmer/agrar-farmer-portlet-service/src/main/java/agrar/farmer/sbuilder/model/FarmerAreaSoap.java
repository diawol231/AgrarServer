package agrar.farmer.sbuilder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FarmerAreaSoap implements Serializable {
    private long _id;
    private long _farmerId;
    private long _areaId;
    private String _description;

    public FarmerAreaSoap() {
    }

    public static FarmerAreaSoap toSoapModel(FarmerArea model) {
        FarmerAreaSoap soapModel = new FarmerAreaSoap();

        soapModel.setId(model.getId());
        soapModel.setFarmerId(model.getFarmerId());
        soapModel.setAreaId(model.getAreaId());
        soapModel.setDescription(model.getDescription());

        return soapModel;
    }

    public static FarmerAreaSoap[] toSoapModels(FarmerArea[] models) {
        FarmerAreaSoap[] soapModels = new FarmerAreaSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FarmerAreaSoap[][] toSoapModels(FarmerArea[][] models) {
        FarmerAreaSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FarmerAreaSoap[models.length][models[0].length];
        } else {
            soapModels = new FarmerAreaSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FarmerAreaSoap[] toSoapModels(List<FarmerArea> models) {
        List<FarmerAreaSoap> soapModels = new ArrayList<FarmerAreaSoap>(models.size());

        for (FarmerArea model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FarmerAreaSoap[soapModels.size()]);
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

    public long getFarmerId() {
        return _farmerId;
    }

    public void setFarmerId(long farmerId) {
        _farmerId = farmerId;
    }

    public long getAreaId() {
        return _areaId;
    }

    public void setAreaId(long areaId) {
        _areaId = areaId;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }
}

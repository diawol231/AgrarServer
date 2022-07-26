package agrar.farmer.sbuilder.model;

import agrar.farmer.sbuilder.service.ClpSerializer;
import agrar.farmer.sbuilder.service.FarmerAreaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class FarmerAreaClp extends BaseModelImpl<FarmerArea>
    implements FarmerArea {
    private long _id;
    private long _farmerId;
    private long _areaId;
    private String _description;
    private BaseModel<?> _farmerAreaRemoteModel;
    private Class<?> _clpSerializerClass = agrar.farmer.sbuilder.service.ClpSerializer.class;

    public FarmerAreaClp() {
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
    public long getPrimaryKey() {
        return _id;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _id;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_farmerAreaRemoteModel != null) {
            try {
                Class<?> clazz = _farmerAreaRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_farmerAreaRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFarmerId() {
        return _farmerId;
    }

    @Override
    public void setFarmerId(long farmerId) {
        _farmerId = farmerId;

        if (_farmerAreaRemoteModel != null) {
            try {
                Class<?> clazz = _farmerAreaRemoteModel.getClass();

                Method method = clazz.getMethod("setFarmerId", long.class);

                method.invoke(_farmerAreaRemoteModel, farmerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAreaId() {
        return _areaId;
    }

    @Override
    public void setAreaId(long areaId) {
        _areaId = areaId;

        if (_farmerAreaRemoteModel != null) {
            try {
                Class<?> clazz = _farmerAreaRemoteModel.getClass();

                Method method = clazz.getMethod("setAreaId", long.class);

                method.invoke(_farmerAreaRemoteModel, areaId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_farmerAreaRemoteModel != null) {
            try {
                Class<?> clazz = _farmerAreaRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_farmerAreaRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAreaCode() {
        try {
            String methodName = "getAreaCode";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            Long returnObj = (Long) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public java.lang.String showArea() {
        try {
            String methodName = "showArea";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.lang.String returnObj = (java.lang.String) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getFarmerAreaRemoteModel() {
        return _farmerAreaRemoteModel;
    }

    public void setFarmerAreaRemoteModel(BaseModel<?> farmerAreaRemoteModel) {
        _farmerAreaRemoteModel = farmerAreaRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _farmerAreaRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_farmerAreaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FarmerAreaLocalServiceUtil.addFarmerArea(this);
        } else {
            FarmerAreaLocalServiceUtil.updateFarmerArea(this);
        }
    }

    @Override
    public FarmerArea toEscapedModel() {
        return (FarmerArea) ProxyUtil.newProxyInstance(FarmerArea.class.getClassLoader(),
            new Class[] { FarmerArea.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FarmerAreaClp clone = new FarmerAreaClp();

        clone.setId(getId());
        clone.setFarmerId(getFarmerId());
        clone.setAreaId(getAreaId());
        clone.setDescription(getDescription());

        return clone;
    }

    @Override
    public int compareTo(FarmerArea farmerArea) {
        long primaryKey = farmerArea.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FarmerAreaClp)) {
            return false;
        }

        FarmerAreaClp farmerArea = (FarmerAreaClp) obj;

        long primaryKey = farmerArea.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", farmerId=");
        sb.append(getFarmerId());
        sb.append(", areaId=");
        sb.append(getAreaId());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("agrar.farmer.sbuilder.model.FarmerArea");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>farmerId</column-name><column-value><![CDATA[");
        sb.append(getFarmerId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>areaId</column-name><column-value><![CDATA[");
        sb.append(getAreaId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

package agrar.dict.sbuilder.model;

import agrar.dict.sbuilder.service.ClpSerializer;
import agrar.dict.sbuilder.service.DictAreaLocalServiceUtil;

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


public class DictAreaClp extends BaseModelImpl<DictArea> implements DictArea {
    private long _id;
    private boolean _archive;
    private long _code;
    private String _name;
    private BaseModel<?> _dictAreaRemoteModel;
    private Class<?> _clpSerializerClass = agrar.dict.sbuilder.service.ClpSerializer.class;

    public DictAreaClp() {
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

    @Override
    public long getId() {
        return _id;
    }

    @Override
    public void setId(long id) {
        _id = id;

        if (_dictAreaRemoteModel != null) {
            try {
                Class<?> clazz = _dictAreaRemoteModel.getClass();

                Method method = clazz.getMethod("setId", long.class);

                method.invoke(_dictAreaRemoteModel, id);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getArchive() {
        return _archive;
    }

    @Override
    public boolean isArchive() {
        return _archive;
    }

    @Override
    public void setArchive(boolean archive) {
        _archive = archive;

        if (_dictAreaRemoteModel != null) {
            try {
                Class<?> clazz = _dictAreaRemoteModel.getClass();

                Method method = clazz.getMethod("setArchive", boolean.class);

                method.invoke(_dictAreaRemoteModel, archive);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCode() {
        return _code;
    }

    @Override
    public void setCode(long code) {
        _code = code;

        if (_dictAreaRemoteModel != null) {
            try {
                Class<?> clazz = _dictAreaRemoteModel.getClass();

                Method method = clazz.getMethod("setCode", long.class);

                method.invoke(_dictAreaRemoteModel, code);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_dictAreaRemoteModel != null) {
            try {
                Class<?> clazz = _dictAreaRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_dictAreaRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getDictAreaRemoteModel() {
        return _dictAreaRemoteModel;
    }

    public void setDictAreaRemoteModel(BaseModel<?> dictAreaRemoteModel) {
        _dictAreaRemoteModel = dictAreaRemoteModel;
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

        Class<?> remoteModelClass = _dictAreaRemoteModel.getClass();

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

        Object returnValue = method.invoke(_dictAreaRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DictAreaLocalServiceUtil.addDictArea(this);
        } else {
            DictAreaLocalServiceUtil.updateDictArea(this);
        }
    }

    @Override
    public DictArea toEscapedModel() {
        return (DictArea) ProxyUtil.newProxyInstance(DictArea.class.getClassLoader(),
            new Class[] { DictArea.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        DictAreaClp clone = new DictAreaClp();

        clone.setId(getId());
        clone.setArchive(getArchive());
        clone.setCode(getCode());
        clone.setName(getName());

        return clone;
    }

    @Override
    public int compareTo(DictArea dictArea) {
        long primaryKey = dictArea.getPrimaryKey();

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

        if (!(obj instanceof DictAreaClp)) {
            return false;
        }

        DictAreaClp dictArea = (DictAreaClp) obj;

        long primaryKey = dictArea.getPrimaryKey();

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
        sb.append(", archive=");
        sb.append(getArchive());
        sb.append(", code=");
        sb.append(getCode());
        sb.append(", name=");
        sb.append(getName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("agrar.dict.sbuilder.model.DictArea");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>archive</column-name><column-value><![CDATA[");
        sb.append(getArchive());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>code</column-name><column-value><![CDATA[");
        sb.append(getCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}

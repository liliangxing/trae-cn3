package com.lynx.jsbridge.jsi;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes6.dex */
public class LynxJSIObjectHub {
    private static final String TAG = "LynxJSIObjectHub";
    private static volatile LynxJSIObjectHub sInstance;
    private final ConcurrentHashMap<String, ILynxJSIObjectDescriptor> cacheDescriptors = new ConcurrentHashMap<>();

    /* loaded from: classes6.dex */
    private enum JObjectType {
        UNKNOWN_TYPE,
        LYNX_JSI_OBJECT_TYPE,
        STRING_TYPE,
        OBJECT_ARRAY_TYPE,
        BOOLEAN_ARRAY_TYPE,
        INT_ARRAY_TYPE,
        LONG_ARRAY_TYPE,
        FLOAT_ARRAY_TYPE,
        DOUBLE_ARRAY_TYPE,
        LIST_TYPE,
        BOOLEAN_WRAPPER_TYPE,
        INT_WRAPPER_TYPE,
        LONG_WRAPPER_TYPE,
        FLOAT_WRAPPER_TYPE,
        DOUBLE_WRAPPER_TYPE
    }

    public static LynxJSIObjectHub inst() {
        if (sInstance == null) {
            synchronized (LynxJSIObjectHub.class) {
                if (sInstance == null) {
                    sInstance = new LynxJSIObjectHub();
                }
            }
        }
        return sInstance;
    }

    public ILynxJSIObjectDescriptor getLynxJSIObjectDescriptor(String str) {
        ILynxJSIObjectDescriptor iLynxJSIObjectDescriptor = this.cacheDescriptors.get(str);
        if (iLynxJSIObjectDescriptor == null && (iLynxJSIObjectDescriptor = reflectJSIObjectDescriptor(str)) != null) {
            this.cacheDescriptors.put(str, iLynxJSIObjectDescriptor);
        }
        return iLynxJSIObjectDescriptor;
    }

    public void warmUpLynxJSIObject(Class<? extends ILynxJSIObject> cls) {
        String name = cls.getName();
        String str = "warmUpLynxJSIObject, class: " + name;
        TraceEvent.beginSection(str);
        ILynxJSIObjectDescriptor iLynxJSIObjectDescriptor = this.cacheDescriptors.get(name);
        if (iLynxJSIObjectDescriptor != null) {
            iLynxJSIObjectDescriptor.warmUp();
        }
        TraceEvent.endSection(str);
    }

    private static ILynxJSIObjectDescriptor reflectJSIObjectDescriptor(String str) {
        try {
            return (ILynxJSIObjectDescriptor) Class.forName(str + "$$Descriptor").newInstance();
        } catch (Exception e) {
            LLog.e(TAG, "getJSIObjectDescriptor failed, error: " + e + ", className: " + str);
            return null;
        }
    }

    private static ILynxJSIObjectDescriptor getJSIObjectDescriptor(ILynxJSIObject iLynxJSIObject) {
        return inst().getLynxJSIObjectDescriptor(iLynxJSIObject.getClass().getName());
    }

    private static int getJSIObjectFieldType(Object obj) {
        if (obj == null) {
            return JObjectType.UNKNOWN_TYPE.ordinal();
        }
        if (obj instanceof ILynxJSIObject) {
            return JObjectType.LYNX_JSI_OBJECT_TYPE.ordinal();
        }
        if (obj instanceof String) {
            return JObjectType.STRING_TYPE.ordinal();
        }
        if (obj instanceof boolean[]) {
            return JObjectType.BOOLEAN_ARRAY_TYPE.ordinal();
        }
        if (obj instanceof int[]) {
            return JObjectType.INT_ARRAY_TYPE.ordinal();
        }
        if (obj instanceof long[]) {
            return JObjectType.LONG_ARRAY_TYPE.ordinal();
        }
        if (obj instanceof float[]) {
            return JObjectType.FLOAT_ARRAY_TYPE.ordinal();
        }
        if (obj instanceof double[]) {
            return JObjectType.DOUBLE_ARRAY_TYPE.ordinal();
        }
        if (obj.getClass().isArray()) {
            return JObjectType.OBJECT_ARRAY_TYPE.ordinal();
        }
        if (obj instanceof List) {
            return JObjectType.LIST_TYPE.ordinal();
        }
        if (obj instanceof Boolean) {
            return JObjectType.BOOLEAN_WRAPPER_TYPE.ordinal();
        }
        if (obj instanceof Integer) {
            return JObjectType.INT_WRAPPER_TYPE.ordinal();
        }
        if (obj instanceof Long) {
            return JObjectType.LONG_WRAPPER_TYPE.ordinal();
        }
        if (obj instanceof Float) {
            return JObjectType.FLOAT_WRAPPER_TYPE.ordinal();
        }
        if (obj instanceof Double) {
            return JObjectType.DOUBLE_WRAPPER_TYPE.ordinal();
        }
        return JObjectType.UNKNOWN_TYPE.ordinal();
    }
}

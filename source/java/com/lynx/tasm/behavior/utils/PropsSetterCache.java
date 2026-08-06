package com.lynx.tasm.behavior.utils;

import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PropsSetterCache {
    private static final Map<Class, Map<String, PropSetter>> CLASS_PROPS_CACHE = new ConcurrentHashMap();
    private static final Map<String, PropSetter> EMPTY_PROPS_MAP = new HashMap();

    PropsSetterCache() {
    }

    public static void clear() {
        CLASS_PROPS_CACHE.clear();
        EMPTY_PROPS_MAP.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class PropSetter {
        protected final Integer mIndex;
        protected final String mPropName;
        protected final String mPropType;
        protected final Method mSetter;

        protected abstract Object extractProperty(StylesDiffMap stylesDiffMap);

        private PropSetter(LynxProp lynxProp, String str, Method method) {
            this.mPropName = lynxProp.name();
            this.mPropType = "__default_type__".equals(lynxProp.customType()) ? str : lynxProp.customType();
            this.mSetter = method;
            this.mIndex = null;
        }

        private PropSetter(LynxPropGroup lynxPropGroup, String str, Method method, int i) {
            this.mPropName = lynxPropGroup.names()[i];
            this.mPropType = "__default_type__".equals(lynxPropGroup.customType()) ? str : lynxPropGroup.customType();
            this.mSetter = method;
            this.mIndex = Integer.valueOf(i);
        }

        public String getPropName() {
            return this.mPropName;
        }

        public String getPropType() {
            return this.mPropType;
        }

        public void updateShadowNodeProp(ShadowNode shadowNode, StylesDiffMap stylesDiffMap) {
            try {
                Integer num = this.mIndex;
                if (num == null) {
                    this.mSetter.invoke(shadowNode, extractProperty(stylesDiffMap));
                } else {
                    this.mSetter.invoke(shadowNode, num, extractProperty(stylesDiffMap));
                }
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException("Fallback setter, error while updating property '" + this.mPropName + "' in shadow node of type: " + shadowNode.getTagName() + Constants.COLON_SEPARATOR + th, th);
                runtimeException.setStackTrace(th.getStackTrace());
                throw runtimeException;
            }
        }

        public void updateLynxUIProp(LynxBaseUI lynxBaseUI, StylesDiffMap stylesDiffMap) {
            try {
                Integer num = this.mIndex;
                if (num == null) {
                    this.mSetter.invoke(lynxBaseUI, extractProperty(stylesDiffMap));
                } else {
                    this.mSetter.invoke(lynxBaseUI, num, extractProperty(stylesDiffMap));
                }
            } catch (Throwable th) {
                RuntimeException runtimeException = new RuntimeException("Fallback setter, error while updating property '" + this.mPropName + "' in Lynx UI of type: " + lynxBaseUI.getClass() + Constants.COLON_SEPARATOR + th, th);
                runtimeException.setStackTrace(th.getStackTrace());
                throw runtimeException;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DynamicPropSetter extends PropSetter {
        public DynamicPropSetter(LynxProp lynxProp, Method method) {
            super(lynxProp, "mixed", method);
        }

        public DynamicPropSetter(LynxPropGroup lynxPropGroup, Method method, int i) {
            super(lynxPropGroup, "mixed", method, i);
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            return stylesDiffMap.getDynamic(this.mPropName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class IntPropSetter extends PropSetter {
        private final int mDefaultValue;

        public IntPropSetter(LynxProp lynxProp, Method method, int i) {
            super(lynxProp, "number", method);
            this.mDefaultValue = i;
        }

        public IntPropSetter(LynxPropGroup lynxPropGroup, Method method, int i, int i2) {
            super(lynxPropGroup, "number", method, i);
            this.mDefaultValue = i2;
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            return Integer.valueOf(stylesDiffMap.getInt(this.mPropName, this.mDefaultValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DoublePropSetter extends PropSetter {
        private final double mDefaultValue;

        public DoublePropSetter(LynxProp lynxProp, Method method, double d) {
            super(lynxProp, "number", method);
            this.mDefaultValue = d;
        }

        public DoublePropSetter(LynxPropGroup lynxPropGroup, Method method, int i, double d) {
            super(lynxPropGroup, "number", method, i);
            this.mDefaultValue = d;
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            return Double.valueOf(stylesDiffMap.getDouble(this.mPropName, this.mDefaultValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class BooleanPropSetter extends PropSetter {
        private final boolean mDefaultValue;

        public BooleanPropSetter(LynxProp lynxProp, Method method, boolean z) {
            super(lynxProp, "boolean", method);
            this.mDefaultValue = z;
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            return stylesDiffMap.getBoolean(this.mPropName, this.mDefaultValue) ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class FloatPropSetter extends PropSetter {
        private final float mDefaultValue;

        public FloatPropSetter(LynxProp lynxProp, Method method, float f) {
            super(lynxProp, "number", method);
            this.mDefaultValue = f;
        }

        public FloatPropSetter(LynxPropGroup lynxPropGroup, Method method, int i, float f) {
            super(lynxPropGroup, "number", method, i);
            this.mDefaultValue = f;
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            return Float.valueOf(stylesDiffMap.getFloat(this.mPropName, this.mDefaultValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ArrayPropSetter extends PropSetter {
        public ArrayPropSetter(LynxProp lynxProp, Method method) {
            super(lynxProp, "Array", method);
        }

        public ArrayPropSetter(LynxPropGroup lynxPropGroup, Method method, int i) {
            super(lynxPropGroup, "Array", method, i);
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            return stylesDiffMap.getArray(this.mPropName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class MapPropSetter extends PropSetter {
        public MapPropSetter(LynxProp lynxProp, Method method) {
            super(lynxProp, "Map", method);
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            return stylesDiffMap.getMap(this.mPropName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class StringPropSetter extends PropSetter {
        public StringPropSetter(LynxProp lynxProp, Method method) {
            super(lynxProp, "String", method);
        }

        public StringPropSetter(LynxPropGroup lynxPropGroup, Method method, int i) {
            super(lynxPropGroup, "String", method, i);
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            return stylesDiffMap.getString(this.mPropName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class BoxedBooleanPropSetter extends PropSetter {
        public BoxedBooleanPropSetter(LynxProp lynxProp, Method method) {
            super(lynxProp, "boolean", method);
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            if (stylesDiffMap.isNull(this.mPropName)) {
                return null;
            }
            return stylesDiffMap.getBoolean(this.mPropName, false) ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class BoxedIntPropSetter extends PropSetter {
        public BoxedIntPropSetter(LynxProp lynxProp, Method method) {
            super(lynxProp, "number", method);
        }

        public BoxedIntPropSetter(LynxPropGroup lynxPropGroup, Method method, int i) {
            super(lynxPropGroup, "number", method, i);
        }

        @Override // com.lynx.tasm.behavior.utils.PropsSetterCache.PropSetter
        protected Object extractProperty(StylesDiffMap stylesDiffMap) {
            if (stylesDiffMap.isNull(this.mPropName)) {
                return null;
            }
            return Integer.valueOf(stylesDiffMap.getInt(this.mPropName, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, PropSetter> getNativePropSettersForLynxUIClass(Class<? extends LynxBaseUI> cls) {
        if (cls == null) {
            return EMPTY_PROPS_MAP;
        }
        Map<Class, Map<String, PropSetter>> map = CLASS_PROPS_CACHE;
        Map<String, PropSetter> map2 = map.get(cls);
        if (map2 != null) {
            return map2;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getNativePropSettersForLynxUIClass(cls == LynxBaseUI.class ? null : cls.getSuperclass()));
        extractPropSettersFromLynxUIClassDefinition(cls, hashMap);
        map.put(cls, hashMap);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, PropSetter> getNativePropSettersForShadowNodeClass(Class<? extends ShadowNode> cls) {
        if (cls == null) {
            return EMPTY_PROPS_MAP;
        }
        Map<Class, Map<String, PropSetter>> map = CLASS_PROPS_CACHE;
        Map<String, PropSetter> map2 = map.get(cls);
        if (map2 != null) {
            return map2;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(getNativePropSettersForShadowNodeClass(cls == ShadowNode.class ? null : cls.getSuperclass()));
        extractPropSettersFromShadowNodeClassDefinition(cls, hashMap);
        map.put(cls, hashMap);
        return hashMap;
    }

    private static PropSetter createPropSetter(LynxProp lynxProp, Method method, Class<?> cls) {
        if (cls == Dynamic.class) {
            return new DynamicPropSetter(lynxProp, method);
        }
        if (cls == Boolean.TYPE) {
            return new BooleanPropSetter(lynxProp, method, lynxProp.defaultBoolean());
        }
        if (cls == Integer.TYPE) {
            return new IntPropSetter(lynxProp, method, lynxProp.defaultInt());
        }
        if (cls == Float.TYPE) {
            return new FloatPropSetter(lynxProp, method, lynxProp.defaultFloat());
        }
        if (cls == Double.TYPE) {
            return new DoublePropSetter(lynxProp, method, lynxProp.defaultDouble());
        }
        if (cls == String.class) {
            return new StringPropSetter(lynxProp, method);
        }
        if (cls == Boolean.class) {
            return new BoxedBooleanPropSetter(lynxProp, method);
        }
        if (cls == Integer.class) {
            return new BoxedIntPropSetter(lynxProp, method);
        }
        if (cls == ReadableArray.class) {
            return new ArrayPropSetter(lynxProp, method);
        }
        if (cls == ReadableMap.class) {
            return new MapPropSetter(lynxProp, method);
        }
        throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
    }

    private static void createPropSetters(LynxPropGroup lynxPropGroup, Method method, Class<?> cls, Map<String, PropSetter> map) {
        String[] names = lynxPropGroup.names();
        int i = 0;
        if (cls == Dynamic.class) {
            while (i < names.length) {
                map.put(names[i], new DynamicPropSetter(lynxPropGroup, method, i));
                i++;
            }
            return;
        }
        if (cls == Integer.TYPE) {
            while (i < names.length) {
                map.put(names[i], new IntPropSetter(lynxPropGroup, method, i, lynxPropGroup.defaultInt()));
                i++;
            }
            return;
        }
        if (cls == Float.TYPE) {
            while (i < names.length) {
                map.put(names[i], new FloatPropSetter(lynxPropGroup, method, i, lynxPropGroup.defaultFloat()));
                i++;
            }
            return;
        }
        if (cls == Double.TYPE) {
            while (i < names.length) {
                map.put(names[i], new DoublePropSetter(lynxPropGroup, method, i, lynxPropGroup.defaultDouble()));
                i++;
            }
            return;
        }
        if (cls == Integer.class) {
            while (i < names.length) {
                map.put(names[i], new BoxedIntPropSetter(lynxPropGroup, method, i));
                i++;
            }
        } else if (cls == String.class) {
            while (i < names.length) {
                map.put(names[i], new StringPropSetter(lynxPropGroup, method, i));
                i++;
            }
        } else {
            if (cls == ReadableArray.class) {
                while (i < names.length) {
                    map.put(names[i], new ArrayPropSetter(lynxPropGroup, method, i));
                    i++;
                }
                return;
            }
            throw new RuntimeException("Unrecognized type: " + cls + " for method: " + method.getDeclaringClass().getName() + "#" + method.getName());
        }
    }

    private static void extractPropSettersFromLynxUIClassDefinition(Class<? extends LynxBaseUI> cls, Map<String, PropSetter> map) {
        for (Method method : cls.getDeclaredMethods()) {
            LynxProp lynxProp = (LynxProp) method.getAnnotation(LynxProp.class);
            if (lynxProp != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
                map.put(lynxProp.name(), createPropSetter(lynxProp, method, parameterTypes[0]));
            }
            LynxPropGroup lynxPropGroup = (LynxPropGroup) method.getAnnotation(LynxPropGroup.class);
            if (lynxPropGroup != null) {
                Class<?>[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 2) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                }
                if (parameterTypes2[0] != Integer.TYPE) {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                }
                createPropSetters(lynxPropGroup, method, parameterTypes2[1], map);
            }
        }
    }

    private static void extractPropSettersFromShadowNodeClassDefinition(Class<? extends ShadowNode> cls, Map<String, PropSetter> map) {
        for (Method method : cls.getDeclaredMethods()) {
            LynxProp lynxProp = (LynxProp) method.getAnnotation(LynxProp.class);
            if (lynxProp != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 1) {
                    throw new RuntimeException("Wrong number of args for prop setter: " + cls.getName() + "#" + method.getName());
                }
                map.put(lynxProp.name(), createPropSetter(lynxProp, method, parameterTypes[0]));
            }
            LynxPropGroup lynxPropGroup = (LynxPropGroup) method.getAnnotation(LynxPropGroup.class);
            if (lynxPropGroup != null) {
                Class<?>[] parameterTypes2 = method.getParameterTypes();
                if (parameterTypes2.length != 2) {
                    throw new RuntimeException("Wrong number of args for group prop setter: " + cls.getName() + "#" + method.getName());
                }
                if (parameterTypes2[0] != Integer.TYPE) {
                    throw new RuntimeException("Second argument should be property index: " + cls.getName() + "#" + method.getName());
                }
                createPropSetters(lynxPropGroup, method, parameterTypes2[1], map);
            }
        }
    }
}

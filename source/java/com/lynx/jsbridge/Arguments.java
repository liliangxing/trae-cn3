package com.lynx.jsbridge;

import android.os.Bundle;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class Arguments {
    private static Object makeNativeObject(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Float) || (obj instanceof Long) || (obj instanceof Byte) || (obj instanceof Short)) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj.getClass().isArray()) {
            return makeNativeArray(obj);
        }
        if (obj instanceof List) {
            return makeNativeArray((List) obj);
        }
        if (obj instanceof Map) {
            return makeNativeMap((Map<String, Object>) obj);
        }
        return obj instanceof Bundle ? makeNativeMap((Bundle) obj) : obj;
    }

    public static JavaOnlyArray makeNativeArray(List list) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        if (list == null) {
            return javaOnlyArray;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object makeNativeObject = makeNativeObject(it.next());
            if (makeNativeObject == null) {
                javaOnlyArray.pushNull();
            } else if (makeNativeObject instanceof Boolean) {
                javaOnlyArray.pushBoolean(((Boolean) makeNativeObject).booleanValue());
            } else if (makeNativeObject instanceof Integer) {
                javaOnlyArray.pushInt(((Integer) makeNativeObject).intValue());
            } else if (makeNativeObject instanceof Double) {
                javaOnlyArray.pushDouble(((Double) makeNativeObject).doubleValue());
            } else if (makeNativeObject instanceof String) {
                javaOnlyArray.pushString((String) makeNativeObject);
            } else if (makeNativeObject instanceof JavaOnlyArray) {
                javaOnlyArray.pushArray((JavaOnlyArray) makeNativeObject);
            } else if (makeNativeObject instanceof JavaOnlyMap) {
                javaOnlyArray.pushMap((JavaOnlyMap) makeNativeObject);
            } else {
                throw new IllegalArgumentException("Could not convert " + makeNativeObject.getClass());
            }
        }
        return javaOnlyArray;
    }

    public static <T> JavaOnlyArray makeNativeArray(final Object obj) {
        if (obj == null) {
            return new JavaOnlyArray();
        }
        return makeNativeArray((List) new AbstractList() { // from class: com.lynx.jsbridge.Arguments.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return Array.getLength(obj);
            }

            @Override // java.util.AbstractList, java.util.List
            public Object get(int i) {
                return Array.get(obj, i);
            }
        });
    }

    private static void addEntry(JavaOnlyMap javaOnlyMap, String str, Object obj) {
        Object makeNativeObject = makeNativeObject(obj);
        if (makeNativeObject == null) {
            javaOnlyMap.putNull(str);
            return;
        }
        if (makeNativeObject instanceof Boolean) {
            javaOnlyMap.putBoolean(str, ((Boolean) makeNativeObject).booleanValue());
            return;
        }
        if (makeNativeObject instanceof Integer) {
            javaOnlyMap.putInt(str, ((Integer) makeNativeObject).intValue());
            return;
        }
        if (makeNativeObject instanceof Number) {
            javaOnlyMap.putDouble(str, ((Number) makeNativeObject).doubleValue());
            return;
        }
        if (makeNativeObject instanceof String) {
            javaOnlyMap.putString(str, (String) makeNativeObject);
        } else if (makeNativeObject instanceof JavaOnlyArray) {
            javaOnlyMap.putArray(str, (JavaOnlyArray) makeNativeObject);
        } else {
            if (makeNativeObject instanceof JavaOnlyMap) {
                javaOnlyMap.putMap(str, (JavaOnlyMap) makeNativeObject);
                return;
            }
            throw new IllegalArgumentException("Could not convert " + makeNativeObject.getClass());
        }
    }

    public static JavaOnlyMap makeNativeMap(Map<String, Object> map) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (map == null) {
            return javaOnlyMap;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            addEntry(javaOnlyMap, entry.getKey(), entry.getValue());
        }
        return javaOnlyMap;
    }

    public static JavaOnlyMap makeNativeMap(Bundle bundle) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (bundle == null) {
            return javaOnlyMap;
        }
        for (String str : bundle.keySet()) {
            addEntry(javaOnlyMap, str, bundle.get(str));
        }
        return javaOnlyMap;
    }

    public static WritableArray createArray() {
        return new JavaOnlyArray();
    }

    public static WritableMap createMap() {
        return new JavaOnlyMap();
    }

    public static JavaOnlyArray fromJavaArgs(Object[] objArr) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        for (Object obj : objArr) {
            if (obj == null) {
                javaOnlyArray.pushNull();
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class) {
                    javaOnlyArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (cls == Integer.class) {
                    javaOnlyArray.pushDouble(((Integer) obj).doubleValue());
                } else if (cls == Double.class) {
                    javaOnlyArray.pushDouble(((Double) obj).doubleValue());
                } else if (cls == Float.class) {
                    javaOnlyArray.pushDouble(((Float) obj).doubleValue());
                } else if (cls == String.class) {
                    javaOnlyArray.pushString(obj.toString());
                } else if (cls == JavaOnlyMap.class) {
                    javaOnlyArray.pushMap((JavaOnlyMap) obj);
                } else if (cls == JavaOnlyArray.class) {
                    javaOnlyArray.pushArray((JavaOnlyArray) obj);
                } else {
                    throw new RuntimeException("Cannot convert argument of type " + cls);
                }
            }
        }
        return javaOnlyArray;
    }

    public static WritableArray fromArray(Object obj) {
        WritableArray createArray = createArray();
        int i = 0;
        if (obj instanceof String[]) {
            String[] strArr = (String[]) obj;
            int length = strArr.length;
            while (i < length) {
                createArray.pushString(strArr[i]);
                i++;
            }
        } else if (obj instanceof Bundle[]) {
            Bundle[] bundleArr = (Bundle[]) obj;
            int length2 = bundleArr.length;
            while (i < length2) {
                createArray.pushMap(fromBundle(bundleArr[i]));
                i++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i < length3) {
                createArray.pushInt(iArr[i]);
                i++;
            }
        } else if (obj instanceof float[]) {
            int length4 = ((float[]) obj).length;
            while (i < length4) {
                createArray.pushDouble(r5[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length5 = dArr.length;
            while (i < length5) {
                createArray.pushDouble(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length6 = zArr.length;
            while (i < length6) {
                createArray.pushBoolean(zArr[i]);
                i++;
            }
        } else {
            throw new IllegalArgumentException("Unknown array type " + obj.getClass());
        }
        return createArray;
    }

    public static WritableArray fromList(List list) {
        WritableArray createArray = createArray();
        for (Object obj : list) {
            if (obj == null) {
                createArray.pushNull();
            } else if (obj.getClass().isArray()) {
                createArray.pushArray(fromArray(obj));
            } else if (obj instanceof Bundle) {
                createArray.pushMap(fromBundle((Bundle) obj));
            } else if (obj instanceof List) {
                createArray.pushArray(fromList((List) obj));
            } else if (obj instanceof String) {
                createArray.pushString((String) obj);
            } else if (obj instanceof Integer) {
                createArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Number) {
                createArray.pushDouble(((Number) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                createArray.pushBoolean(((Boolean) obj).booleanValue());
            } else {
                throw new IllegalArgumentException("Unknown value type " + obj.getClass());
            }
        }
        return createArray;
    }

    public static WritableMap fromBundle(Bundle bundle) {
        WritableMap createMap = createMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                createMap.putNull(str);
            } else if (obj.getClass().isArray()) {
                createMap.putArray(str, fromArray(obj));
            } else if (obj instanceof String) {
                createMap.putString(str, (String) obj);
            } else if (obj instanceof Number) {
                if (obj instanceof Integer) {
                    createMap.putInt(str, ((Integer) obj).intValue());
                } else {
                    createMap.putDouble(str, ((Number) obj).doubleValue());
                }
            } else if (obj instanceof Boolean) {
                createMap.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Bundle) {
                createMap.putMap(str, fromBundle((Bundle) obj));
            } else if (obj instanceof List) {
                createMap.putArray(str, fromList((List) obj));
            } else {
                throw new IllegalArgumentException("Could not convert " + obj.getClass());
            }
        }
        return createMap;
    }

    public static ArrayList toList(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (C14282.$SwitchMap$com$lynx$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    arrayList.add(null);
                    break;
                case 2:
                    arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case 3:
                    double d = readableArray.getDouble(i);
                    if (d == Math.rint(d)) {
                        arrayList.add(Integer.valueOf((int) d));
                        break;
                    } else {
                        arrayList.add(Double.valueOf(d));
                        break;
                    }
                case 4:
                    arrayList.add(readableArray.getString(i));
                    break;
                case 5:
                    arrayList.add(toBundle(readableArray.getMap(i)));
                    break;
                case 6:
                    arrayList.add(toList(readableArray.getArray(i)));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object in array.");
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.jsbridge.Arguments$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C14282 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$lynx$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static Bundle toBundle(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        Bundle bundle = new Bundle();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (C14282.$SwitchMap$com$lynx$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    bundle.putString(nextKey, null);
                    break;
                case 2:
                    bundle.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 3:
                    bundle.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case 4:
                    bundle.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    bundle.putBundle(nextKey, toBundle(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    bundle.putSerializable(nextKey, toList(readableMap.getArray(nextKey)));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object with key: " + nextKey + ".");
            }
        }
        return bundle;
    }
}

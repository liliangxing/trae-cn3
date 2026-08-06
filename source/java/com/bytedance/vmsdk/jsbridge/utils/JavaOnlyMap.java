package com.bytedance.vmsdk.jsbridge.utils;

import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {
    private static final String TAG = "JavaOnlyMap";

    public static JavaOnlyMap from(Map map) {
        return new JavaOnlyMap(map);
    }

    private JavaOnlyMap(Map map) {
        super(map);
    }

    public JavaOnlyMap() {
    }

    public static JavaOnlyMap deepClone(ReadableMap readableMap) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (C00182.$SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    javaOnlyMap.putNull(nextKey);
                    break;
                case 2:
                    javaOnlyMap.putBoolean(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 3:
                    javaOnlyMap.putInt(nextKey, readableMap.getInt(nextKey));
                    break;
                case 4:
                    javaOnlyMap.putLong(nextKey, readableMap.getLong(nextKey));
                    break;
                case 5:
                    javaOnlyMap.putDouble(nextKey, readableMap.getDouble(nextKey));
                    break;
                case 6:
                    javaOnlyMap.putString(nextKey, readableMap.getString(nextKey));
                    break;
                case 7:
                    javaOnlyMap.putMap(nextKey, deepClone(readableMap.getMap(nextKey)));
                    break;
                case 8:
                    javaOnlyMap.putArray(nextKey, JavaOnlyArray.deepClone(readableMap.getArray(nextKey)));
                    break;
                case 9:
                    javaOnlyMap.putByteArray(nextKey, (byte[]) readableMap.getByteArray(nextKey).clone());
                    break;
            }
        }
        return javaOnlyMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C00182 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[ReadableType.Int.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[ReadableType.Long.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[ReadableType.Number.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[ReadableType.String.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[ReadableType.Map.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[ReadableType.Array.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$bytedance$vmsdk$jsbridge$utils$ReadableType[ReadableType.ByteArray.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean hasKey(String str) {
        return containsKey(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean isNull(String str) {
        return get(str) == null;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj == null || obj.getClass() == null) {
            throw new NullPointerException("key: " + str);
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.Boolean, key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public double getDouble(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (obj == null || obj.getClass() == null) {
            throw new NullPointerException("key: " + str);
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.Number, key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public long getLong(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj == null || obj.getClass() == null) {
            throw new NullPointerException("key: " + str);
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.Long, key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int getInt(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj == null || obj.getClass() == null) {
            throw new NullPointerException("key: " + str);
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.Number, key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public String getString(String str) {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj == null || obj.getClass() == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.String, key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMap getMap(String str) {
        Object obj = get(str);
        if (obj instanceof ReadableMap) {
            return (ReadableMap) obj;
        }
        if (obj == null || obj.getClass() == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public boolean getBoolean(String str, boolean z) {
        Object obj = get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public double getDouble(String str, double d) {
        Object obj = get(str);
        return obj instanceof Number ? ((Number) obj).doubleValue() : d;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int getInt(String str, int i) {
        Object obj = get(str);
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public long getLong(String str, long j) {
        Object obj = get(str);
        return obj instanceof Number ? ((Number) obj).longValue() : j;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public String getString(String str, String str2) {
        Object obj = get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableArray getArray(String str, ReadableArray readableArray) {
        Object obj = get(str);
        return obj instanceof ReadableArray ? (ReadableArray) obj : readableArray;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMap getMap(String str, ReadableMap readableMap) {
        Object obj = get(str);
        return obj instanceof ReadableMap ? (ReadableMap) obj : readableMap;
    }

    ArrayList<String> getKeys() {
        return new ArrayList<>(keySet());
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public JavaOnlyArray getArray(String str) {
        Object obj = get(str);
        if (obj instanceof JavaOnlyArray) {
            return (JavaOnlyArray) obj;
        }
        if (obj == null || obj.getClass() == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + JavaOnlyArray.class.getName() + ", key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public byte[] getByteArray(String str, byte[] bArr) {
        Object obj = get(str);
        return obj instanceof byte[] ? (byte[]) obj : bArr;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public byte[] getByteArray(String str) {
        Object obj = get(str);
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj == null || obj.getClass() == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + byte[].class.getName() + ", key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public NativeHostObject getNativeHostObject(String str) {
        Object obj = get(str);
        if (obj instanceof NativeHostObject) {
            return (NativeHostObject) obj;
        }
        if (obj == null || obj.getClass() == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + JavaOnlyArray.class.getName() + ", key: " + str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public Dynamic getDynamic(String str) {
        return DynamicFromMap.create(this, str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableType getType(String str) {
        Object obj = get(str);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Integer) {
            return ReadableType.Int;
        }
        if (obj instanceof Long) {
            return ReadableType.Long;
        }
        if ((obj instanceof Number) || (obj instanceof Character)) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof byte[]) {
            return ReadableType.ByteArray;
        }
        if (obj instanceof Dynamic) {
            return ((Dynamic) obj).getType();
        }
        if (obj instanceof NativeHostObject) {
            return ReadableType.NativeHostObject;
        }
        throw new IllegalArgumentException("Invalid value " + obj.toString() + " for key " + str + "contained in JavaOnlyMap");
    }

    public int getTypeIndex(String str) {
        return getType(str).ordinal();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new ReadableMapKeySetIterator() { // from class: com.bytedance.vmsdk.jsbridge.utils.JavaOnlyMap.1
            Iterator<String> mIterator;

            {
                this.mIterator = JavaOnlyMap.this.keySet().iterator();
            }

            @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator
            public boolean hasNextKey() {
                return this.mIterator.hasNext();
            }

            @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator
            public String nextKey() {
                return this.mIterator.next();
            }
        };
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putBoolean(String str, boolean z) {
        put(str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putDouble(String str, double d) {
        put(str, Double.valueOf(d));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putLong(String str, long j) {
        put(str, Long.valueOf(j));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putString(String str, String str2) {
        put(str, str2);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putNull(String str) {
        put(str, null);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putMap(String str, WritableMap writableMap) {
        put(str, writableMap);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public int size() {
        return super.size();
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void merge(ReadableMap readableMap) {
        putAll((JavaOnlyMap) readableMap);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putArray(String str, WritableArray writableArray) {
        put(str, writableArray);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putByteArrayAsString(byte[] bArr, byte[] bArr2) {
        put(new String(bArr), new String(bArr2));
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putByteArray(String str, byte[] bArr) {
        put(str, bArr);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.WritableMap
    public void putNativeHostObject(String str, NativeHostObject nativeHostObject) {
        put(str, nativeHostObject);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public HashMap<String, Object> toHashMap() {
        return new HashMap<>(this);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.ReadableMap
    public ArrayMap<String, Object> toArrayMap() {
        ArrayMap<String, Object> arrayMap = new ArrayMap<>();
        arrayMap.putAll(this);
        return arrayMap;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (size() == 0) {
            return jSONObject;
        }
        for (String str : keySet()) {
            Object obj = get(str);
            try {
                if (getType(str) == ReadableType.Map) {
                    jSONObject.putOpt(str, ((JavaOnlyMap) obj).toJSONObject());
                } else if (getType(str) == ReadableType.Array) {
                    jSONObject.putOpt(str, ((JavaOnlyArray) obj).toJSONArray());
                } else if (getType(str) == ReadableType.Null) {
                    jSONObject.putOpt(str, JSONObject.NULL);
                } else {
                    jSONObject.putOpt(str, obj);
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
        return jSONObject;
    }

    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }
}

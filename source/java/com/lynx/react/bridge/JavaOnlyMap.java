package com.lynx.react.bridge;

import android.util.Log;
import com.caverock.androidsvg.SVGParser;
import com.lynx.tasm.TemplateData;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {
    private static final String TAG = "JavaOnlyMap";

    @Override // com.lynx.react.bridge.ReadableMap
    public HashMap<String, Object> asHashMap() {
        return this;
    }

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
            switch (C14622.$SwitchMap$com$lynx$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
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
    /* renamed from: com.lynx.react.bridge.JavaOnlyMap$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C14622 {
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
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Int.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Long.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.String.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.ByteArray.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static JavaOnlyMap shallowCopy(ReadableMap readableMap) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (C14622.$SwitchMap$com$lynx$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
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
                    javaOnlyMap.putMap(nextKey, (WritableMap) readableMap.getMap(nextKey));
                    break;
                case 8:
                    javaOnlyMap.putArray(nextKey, (WritableArray) readableMap.getArray(nextKey));
                    break;
                case 9:
                    javaOnlyMap.putByteArray(nextKey, readableMap.getByteArray(nextKey));
                    break;
            }
        }
        return javaOnlyMap;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean hasKey(String str) {
        return containsKey(str);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean isNull(String str) {
        return get(str) == null;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            return str2.equalsIgnoreCase("true") || str2.equalsIgnoreCase("yes");
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0;
        }
        if (obj == null) {
            throw new NullPointerException("key: " + str);
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.Boolean, key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public double getDouble(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1.0d : 0.0d;
        }
        if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("String cannot be cast to double, key: " + str + ", value: " + obj);
            }
        }
        if (obj == null) {
            throw new NullPointerException("key: " + str);
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.Number, key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public long getLong(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1L : 0L;
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("String cannot be cast to long int, key: " + str + ", value: " + obj);
            }
        }
        if (obj == null) {
            throw new NullPointerException("key: " + str);
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.Long, key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public int getInt(String str) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1 : 0;
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("String cannot be cast to int, key: " + str + ", value: " + obj);
            }
        }
        if (obj == null) {
            throw new NullPointerException("key: " + str);
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.Number, key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public String getString(String str) {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? "true" : "false";
        }
        if (obj instanceof Number) {
            return ((Number) obj).toString();
        }
        if (obj == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.String, key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMap getMap(String str) {
        Object obj = get(str);
        if (obj instanceof ReadableMap) {
            return (ReadableMap) obj;
        }
        if (obj == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean getBoolean(String str, boolean z) {
        Object obj = get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.equalsIgnoreCase("true") || str2.equalsIgnoreCase("yes")) {
                return true;
            }
            if (str2.equalsIgnoreCase("false") || str2.equalsIgnoreCase(SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO)) {
                return false;
            }
        }
        return z;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public double getDouble(String str, double d) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1.0d : 0.0d;
        }
        if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return d;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public int getInt(String str, int i) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1 : 0;
        }
        if (obj instanceof String) {
            try {
                return Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public long getLong(String str, long j) {
        Object obj = get(str);
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? 1L : 0L;
        }
        if (obj instanceof String) {
            try {
                return Long.parseLong((String) obj);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public String getString(String str, String str2) {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() ? "true" : "false" : obj instanceof Number ? ((Number) obj).toString() : str2;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableArray getArray(String str, ReadableArray readableArray) {
        Object obj = get(str);
        return obj instanceof ReadableArray ? (ReadableArray) obj : readableArray;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMap getMap(String str, ReadableMap readableMap) {
        Object obj = get(str);
        return obj instanceof ReadableMap ? (ReadableMap) obj : readableMap;
    }

    ArrayList<String> getKeys() {
        return new ArrayList<>(keySet());
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableArray getArray(String str) {
        Object obj = get(str);
        if (obj instanceof ReadableArray) {
            return (ReadableArray) obj;
        }
        if (obj == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + ReadableArray.class.getName() + ", key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public TemplateData getTemplateData(String str) {
        Object obj = get(str);
        if (obj instanceof TemplateData) {
            return (TemplateData) obj;
        }
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public byte[] getByteArray(String str, byte[] bArr) {
        Object obj = get(str);
        return obj instanceof byte[] ? (byte[]) obj : bArr;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public byte[] getByteArray(String str) {
        Object obj = get(str);
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + byte[].class.getName() + ", key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public PiperData getPiperData(String str, PiperData piperData) {
        Object obj = get(str);
        return obj instanceof PiperData ? (PiperData) obj : piperData;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public PiperData getPiperData(String str) {
        Object obj = get(str);
        if (obj instanceof PiperData) {
            return (PiperData) obj;
        }
        if (obj == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + PiperData.class.getName() + ", key: " + str);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public Dynamic getDynamic(String str) {
        return new DynamicFromMap(this, str);
    }

    @Override // com.lynx.react.bridge.ReadableMap
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
        if (obj instanceof PiperData) {
            return ReadableType.PiperData;
        }
        if (obj instanceof TemplateData) {
            return ReadableType.TemplateData;
        }
        if (obj instanceof Dynamic) {
            return ((Dynamic) obj).getType();
        }
        throw new IllegalArgumentException("Invalid value " + obj.toString() + " for key " + str + "contained in JavaOnlyMap");
    }

    public int getTypeIndex(String str) {
        return getType(str).ordinal();
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new ReadableMapKeySetIterator() { // from class: com.lynx.react.bridge.JavaOnlyMap.1
            Iterator<String> mIterator;

            {
                this.mIterator = JavaOnlyMap.this.keySet().iterator();
            }

            @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
            public boolean hasNextKey() {
                return this.mIterator.hasNext();
            }

            @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
            public String nextKey() {
                return this.mIterator.next();
            }
        };
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putBoolean(String str, boolean z) {
        put(str, Boolean.valueOf(z));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putDouble(String str, double d) {
        put(str, Double.valueOf(d));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putLong(String str, long j) {
        put(str, Long.valueOf(j));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putString(String str, String str2) {
        put(str, str2);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putNull(String str) {
        put(str, null);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putMap(String str, WritableMap writableMap) {
        put(str, writableMap);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.lynx.react.bridge.ReadableMap
    public int size() {
        return super.size();
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void merge(ReadableMap readableMap) {
        putAll(readableMap.asHashMap());
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putArray(String str, WritableArray writableArray) {
        put(str, writableArray);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteArrayAsString(byte[] bArr, byte[] bArr2) {
        put(new String(bArr), new String(bArr2));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteArray(String str, byte[] bArr) {
        put(str, bArr);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putPiperData(String str, PiperData piperData) {
        put(str, piperData);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ByteBuffer getByteBuffer(String str) {
        Object obj = get(str);
        if (obj instanceof ByteBuffer) {
            return (ByteBuffer) obj;
        }
        if (obj == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to " + ByteBuffer.class.getName() + ", key: " + str);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ByteBuffer getByteBuffer(String str, ByteBuffer byteBuffer) {
        Object obj = get(str);
        return obj instanceof ByteBuffer ? (ByteBuffer) obj : byteBuffer;
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteBuffer(String str, ByteBuffer byteBuffer) {
        put(str, byteBuffer);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    @Deprecated
    public HashMap<String, Object> toHashMap() {
        return new HashMap<>(this);
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

    private JavaOnlyMap shallowCopy() {
        return shallowCopy(this);
    }
}

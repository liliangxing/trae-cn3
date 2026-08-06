package com.lynx.animax.base.bridge;

import com.bytedance.ies.bullet.service.router.RouterConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap {
    @Override // com.lynx.animax.base.bridge.ReadableMap
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

    @Override // com.lynx.animax.base.bridge.ReadableMap
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

    @Override // com.lynx.animax.base.bridge.ReadableMap
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

    @Override // com.lynx.animax.base.bridge.ReadableMap
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

    public void putDouble(String str, double d) {
        put(str, Double.valueOf(d));
    }

    public void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    public void putString(String str, String str2) {
        put(str, str2);
    }

    public void putByteArrayAsString(byte[] bArr, byte[] bArr2) {
        put(new String(bArr), new String(bArr2));
    }

    public void putArray(String str, JavaOnlyArray javaOnlyArray) {
        put(str, javaOnlyArray);
    }

    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    public ArrayList<String> getKeys() {
        return new ArrayList<>(keySet());
    }

    public int getTypeIndex(String str) {
        return getType(str).ordinal();
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public String getString(String str) {
        Object obj = get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? RouterConstants.TRUE : "false";
        }
        if (obj instanceof Number) {
            return ((Number) obj).toString();
        }
        if (obj == null) {
            return null;
        }
        throw new ClassCastException(obj.getClass().getName() + " cannot be cast to java.lang.String, key: " + str + ", value: " + obj);
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
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
        throw new IllegalArgumentException("Invalid value " + obj.toString() + " for key " + str + "contained in JavaOnlyMap");
    }
}

package com.lynx.react.bridge;

import android.util.Log;
import com.lynx.jsbridge.jsi.ILynxJSIObject;
import com.lynx.tasm.TemplateData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class JavaOnlyArray extends ArrayList<Object> implements ReadableArray, WritableArray, NativeArrayInterface {
    private static final String TAG = "JavaOnlyArray";

    @Override // com.lynx.react.bridge.ReadableArray
    public ArrayList<Object> asArrayList() {
        return this;
    }

    public static JavaOnlyArray from(List list) {
        return new JavaOnlyArray(list);
    }

    /* renamed from: of */
    public static JavaOnlyArray m2566of(Object... objArr) {
        return new JavaOnlyArray(Arrays.asList(objArr));
    }

    public static JavaOnlyArray deepClone(ReadableArray readableArray) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            switch (C14601.$SwitchMap$com$lynx$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    javaOnlyArray.pushNull();
                    break;
                case 2:
                    javaOnlyArray.pushBoolean(readableArray.getBoolean(i));
                    break;
                case 3:
                    javaOnlyArray.pushInt(readableArray.getInt(i));
                    break;
                case 4:
                    javaOnlyArray.pushLong(readableArray.getLong(i));
                    break;
                case 5:
                    javaOnlyArray.pushDouble(readableArray.getDouble(i));
                    break;
                case 6:
                    javaOnlyArray.pushString(readableArray.getString(i));
                    break;
                case 7:
                    javaOnlyArray.pushMap(JavaOnlyMap.deepClone(readableArray.getMap(i)));
                    break;
                case 8:
                    javaOnlyArray.pushArray(deepClone(readableArray.getArray(i)));
                    break;
                case 9:
                    javaOnlyArray.pushByteArray((byte[]) readableArray.getByteArray(i).clone());
                    break;
            }
        }
        return javaOnlyArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.react.bridge.JavaOnlyArray$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C14601 {
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

    public static JavaOnlyArray shallowCopy(ReadableArray readableArray) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            switch (C14601.$SwitchMap$com$lynx$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    javaOnlyArray.pushNull();
                    break;
                case 2:
                    javaOnlyArray.pushBoolean(readableArray.getBoolean(i));
                    break;
                case 3:
                    javaOnlyArray.pushInt(readableArray.getInt(i));
                    break;
                case 4:
                    javaOnlyArray.pushLong(readableArray.getLong(i));
                    break;
                case 5:
                    javaOnlyArray.pushDouble(readableArray.getDouble(i));
                    break;
                case 6:
                    javaOnlyArray.pushString(readableArray.getString(i));
                    break;
                case 7:
                    javaOnlyArray.pushMap((WritableMap) readableArray.getMap(i));
                    break;
                case 8:
                    javaOnlyArray.pushArray((WritableArray) readableArray.getArray(i));
                    break;
                case 9:
                    javaOnlyArray.pushByteArray(readableArray.getByteArray(i));
                    break;
            }
        }
        return javaOnlyArray;
    }

    protected JavaOnlyArray(List list) {
        super(list);
    }

    public JavaOnlyArray() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List, com.lynx.react.bridge.ReadableArray
    public int size() {
        return super.size();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public boolean isNull(int i) {
        return get(i) == null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public double getDouble(int i) {
        return ((Number) get(i)).doubleValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public byte getByte(int i) {
        return ((Number) get(i)).byteValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public short getShort(int i) {
        return ((Number) get(i)).shortValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public long getLong(int i) {
        return ((Number) get(i)).longValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public char getChar(int i) {
        return (char) ((Number) get(i)).shortValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public int getInt(int i) {
        return ((Number) get(i)).intValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public String getString(int i) {
        return (String) get(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public JavaOnlyArray getArray(int i) {
        return (JavaOnlyArray) get(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public boolean getBoolean(int i) {
        return ((Boolean) get(i)).booleanValue();
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public JavaOnlyMap getMap(int i) {
        return (JavaOnlyMap) get(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public byte[] getByteArray(int i) {
        return (byte[]) get(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public PiperData getPiperData(int i) {
        return (PiperData) get(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public Dynamic getDynamic(int i) {
        return new DynamicFromArray(this, i);
    }

    public Object getObject(int i) {
        return get(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ReadableType getType(int i) {
        Object obj = get(i);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
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
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof byte[]) {
            return ReadableType.ByteArray;
        }
        if (obj instanceof PiperData) {
            return ReadableType.PiperData;
        }
        if (obj instanceof ILynxJSIObject) {
            return ReadableType.LynxObject;
        }
        if (obj instanceof TemplateData) {
            return ReadableType.TemplateData;
        }
        throw new IllegalArgumentException("unsupported type " + obj.getClass() + " contained in JavaOnlyArray");
    }

    public int getTypeIndex(int i) {
        return getType(i).ordinal();
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushBoolean(boolean z) {
        add(Boolean.valueOf(z));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushDouble(double d) {
        add(Double.valueOf(d));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushInt(int i) {
        add(Integer.valueOf(i));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushLong(long j) {
        add(Long.valueOf(j));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushString(String str) {
        add(str);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushArray(WritableArray writableArray) {
        add(writableArray);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushMap(WritableMap writableMap) {
        add(writableMap);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushNull() {
        add(null);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushByteArray(byte[] bArr) {
        add(bArr);
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushTemplateData(TemplateData templateData) {
        add(templateData);
    }

    public void pushByteArrayAsString(byte[] bArr) {
        add(new String(bArr));
    }

    @Override // com.lynx.react.bridge.WritableArray
    public void pushPiperData(PiperData piperData) {
        add(piperData);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        super.clear();
    }

    public JSONArray toJSONArray() {
        JSONArray jSONArray = new JSONArray();
        int size = size();
        for (int i = 0; i < size; i++) {
            Object obj = get(i);
            try {
                if (getType(i) == ReadableType.Map) {
                    jSONArray.put(((JavaOnlyMap) obj).toJSONObject());
                } else if (getType(i) == ReadableType.Array) {
                    jSONArray.put(((JavaOnlyArray) obj).toJSONArray());
                } else {
                    jSONArray.put(obj);
                }
            } catch (Exception e) {
                Log.e(TAG, e.toString());
            }
        }
        return jSONArray;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    @Deprecated
    public ArrayList<Object> toArrayList() {
        return new ArrayList<>(this);
    }

    public Object getAt(int i) {
        return get(i);
    }

    private static JavaOnlyArray create() {
        return new JavaOnlyArray();
    }

    private JavaOnlyArray shallowCopy() {
        return shallowCopy(this);
    }
}

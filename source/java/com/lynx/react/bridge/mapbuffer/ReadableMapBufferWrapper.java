package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ReadableMapBufferWrapper implements ReadableArray {
    private final MapBuffer mBackingMap;

    @Override // com.lynx.react.bridge.ReadableArray
    public ArrayList<Object> asArrayList() {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public byte[] getByteArray(int i) {
        return new byte[0];
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public char getChar(int i) {
        return (char) 0;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ReadableMap getMap(int i) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public PiperData getPiperData(int i) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public boolean isNull(int i) {
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ArrayList<Object> toArrayList() {
        return null;
    }

    public ReadableMapBufferWrapper(MapBuffer mapBuffer) {
        this.mBackingMap = mapBuffer;
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public boolean getBoolean(int i) {
        return this.mBackingMap.getBoolean(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public double getDouble(int i) {
        return this.mBackingMap.getDouble(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public byte getByte(int i) {
        return (byte) getInt(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public short getShort(int i) {
        return (short) getInt(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public int getInt(int i) {
        return this.mBackingMap.getInt(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public long getLong(int i) {
        return this.mBackingMap.getLong(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public String getString(int i) {
        return this.mBackingMap.getString(i);
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ReadableArray getArray(int i) {
        return new ReadableMapBufferWrapper(this.mBackingMap.getMapBuffer(i));
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public Dynamic getDynamic(int i) {
        return new DynamicFromMapBuffer(this, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.react.bridge.mapbuffer.ReadableMapBufferWrapper$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C14671 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType;

        static {
            int[] iArr = new int[MapBuffer.DataType.values().length];
            $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType = iArr;
            try {
                iArr[MapBuffer.DataType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.INT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[MapBuffer.DataType.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private static ReadableType MapBufferDataTypeToReadableType(MapBuffer.DataType dataType) {
        switch (C14671.$SwitchMap$com$lynx$react$bridge$mapbuffer$MapBuffer$DataType[dataType.ordinal()]) {
            case 1:
                return ReadableType.String;
            case 2:
                return ReadableType.Number;
            case 3:
                return ReadableType.Array;
            case 4:
                return ReadableType.Null;
            case 5:
                return ReadableType.Long;
            case 6:
                return ReadableType.Int;
            case 7:
                return ReadableType.Boolean;
            default:
                return ReadableType.Null;
        }
    }

    @Override // com.lynx.react.bridge.ReadableArray
    public ReadableType getType(int i) {
        return MapBufferDataTypeToReadableType(this.mBackingMap.getType(i));
    }

    @Override // com.lynx.react.bridge.ReadableArray, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mBackingMap.count();
    }
}

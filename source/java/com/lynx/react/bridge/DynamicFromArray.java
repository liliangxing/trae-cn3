package com.lynx.react.bridge;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DynamicFromArray implements Dynamic {
    private final ReadableArray mArray;
    private final int mIndex;

    @Override // com.lynx.react.bridge.Dynamic
    @Deprecated
    public void recycle() {
    }

    public DynamicFromArray(ReadableArray readableArray, int i) {
        this.mArray = readableArray;
        this.mIndex = i;
    }

    @Deprecated
    public static DynamicFromArray create(ReadableArray readableArray, int i) {
        return new DynamicFromArray(readableArray, i);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public boolean isNull() {
        return this.mArray.isNull(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public boolean asBoolean() {
        return this.mArray.getBoolean(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public double asDouble() {
        return this.mArray.getDouble(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public int asInt() {
        return this.mArray.getInt(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public long asLong() {
        return this.mArray.getLong(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public String asString() {
        return this.mArray.getString(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableArray asArray() {
        return this.mArray.getArray(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableMap asMap() {
        return this.mArray.getMap(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public byte[] asByteArray() {
        return this.mArray.getByteArray(this.mIndex);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableType getType() {
        return this.mArray.getType(this.mIndex);
    }
}

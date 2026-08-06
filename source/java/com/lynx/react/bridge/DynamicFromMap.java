package com.lynx.react.bridge;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DynamicFromMap implements Dynamic {
    private final ReadableMap mMap;
    private final String mName;

    @Override // com.lynx.react.bridge.Dynamic
    @Deprecated
    public void recycle() {
    }

    public DynamicFromMap(ReadableMap readableMap, String str) {
        this.mMap = readableMap;
        this.mName = str;
    }

    @Deprecated
    public static DynamicFromMap create(ReadableMap readableMap, String str) {
        return new DynamicFromMap(readableMap, str);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public boolean isNull() {
        return this.mMap.isNull(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public boolean asBoolean() {
        return this.mMap.getBoolean(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public double asDouble() {
        return this.mMap.getDouble(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public int asInt() {
        return this.mMap.getInt(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public long asLong() {
        return this.mMap.getLong(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public String asString() {
        return this.mMap.getString(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableArray asArray() {
        return this.mMap.getArray(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableMap asMap() {
        return this.mMap.getMap(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public byte[] asByteArray() {
        return this.mMap.getByteArray(this.mName);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableType getType() {
        return this.mMap.getType(this.mName);
    }
}

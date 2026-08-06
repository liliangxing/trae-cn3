package com.lynx.react.bridge.mapbuffer;

import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DynamicFromMapBuffer implements Dynamic {
    private final int mKey;
    private final ReadableMapBufferWrapper mMap;

    @Override // com.lynx.react.bridge.Dynamic
    public void recycle() {
    }

    public DynamicFromMapBuffer(ReadableMapBufferWrapper readableMapBufferWrapper, int i) {
        this.mMap = readableMapBufferWrapper;
        this.mKey = i;
    }

    @Override // com.lynx.react.bridge.Dynamic
    public boolean isNull() {
        return this.mMap.isNull(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public boolean asBoolean() {
        return this.mMap.getBoolean(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public double asDouble() {
        return this.mMap.getDouble(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public int asInt() {
        return this.mMap.getInt(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public long asLong() {
        return this.mMap.getLong(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public String asString() {
        return this.mMap.getString(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableArray asArray() {
        return this.mMap.getArray(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableMap asMap() {
        return this.mMap.getMap(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public byte[] asByteArray() {
        return this.mMap.getByteArray(this.mKey);
    }

    @Override // com.lynx.react.bridge.Dynamic
    public ReadableType getType() {
        return this.mMap.getType(this.mKey);
    }
}

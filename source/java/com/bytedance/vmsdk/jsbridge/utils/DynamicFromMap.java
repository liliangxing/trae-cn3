package com.bytedance.vmsdk.jsbridge.utils;

import androidx.core.util.Pools;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DynamicFromMap implements Dynamic {
    private static final Pools.SimplePool<DynamicFromMap> sPool = new Pools.SimplePool<>(10);
    private ReadableMap mMap;
    private String mName;

    private DynamicFromMap() {
    }

    public static DynamicFromMap create(ReadableMap readableMap, String str) {
        DynamicFromMap dynamicFromMap = (DynamicFromMap) sPool.acquire();
        if (dynamicFromMap == null) {
            dynamicFromMap = new DynamicFromMap();
        }
        dynamicFromMap.mMap = readableMap;
        dynamicFromMap.mName = str;
        return dynamicFromMap;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public void recycle() {
        this.mMap = null;
        this.mName = null;
        sPool.release(this);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public boolean isNull() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.isNull(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public boolean asBoolean() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getBoolean(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public double asDouble() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getDouble(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public int asInt() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getInt(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public long asLong() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getLong(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public String asString() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getString(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public ReadableArray asArray() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getArray(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public ReadableMap asMap() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getMap(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public byte[] asByteArray() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getByteArray(str);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public ReadableType getType() {
        String str;
        ReadableMap readableMap = this.mMap;
        if (readableMap == null || (str = this.mName) == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableMap.getType(str);
    }
}

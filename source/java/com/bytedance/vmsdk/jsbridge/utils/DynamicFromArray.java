package com.bytedance.vmsdk.jsbridge.utils;

import androidx.core.util.Pools;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DynamicFromArray implements Dynamic {
    private static final Pools.SimplePool<DynamicFromArray> sPool = new Pools.SimplePool<>(10);
    private ReadableArray mArray;
    private int mIndex = -1;

    private DynamicFromArray() {
    }

    public static DynamicFromArray create(ReadableArray readableArray, int i) {
        DynamicFromArray dynamicFromArray = (DynamicFromArray) sPool.acquire();
        if (dynamicFromArray == null) {
            dynamicFromArray = new DynamicFromArray();
        }
        dynamicFromArray.mArray = readableArray;
        dynamicFromArray.mIndex = i;
        return dynamicFromArray;
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public void recycle() {
        this.mArray = null;
        this.mIndex = -1;
        sPool.release(this);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public boolean isNull() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.isNull(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public boolean asBoolean() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getBoolean(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public double asDouble() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getDouble(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public int asInt() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getInt(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public long asLong() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getLong(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public String asString() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getString(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public ReadableArray asArray() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getArray(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public ReadableMap asMap() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getMap(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public byte[] asByteArray() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getByteArray(this.mIndex);
    }

    @Override // com.bytedance.vmsdk.jsbridge.utils.Dynamic
    public ReadableType getType() {
        ReadableArray readableArray = this.mArray;
        if (readableArray == null) {
            throw new IllegalStateException("This dynamic value has been recycled");
        }
        return readableArray.getType(this.mIndex);
    }
}

package com.lynx.tasm.behavior.p000ui.utils;

import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.utils.FloatUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PlatformLength {
    private ReadableArray mArray;
    private final int mType;
    private float mValue;

    public PlatformLength(Dynamic dynamic, int i) {
        if (i == 2) {
            this.mArray = dynamic.asArray();
        } else if (i == 0 || i == 1) {
            this.mValue = (float) dynamic.asDouble();
        }
        this.mType = i;
    }

    public PlatformLength(float f, int i) {
        this.mValue = f;
        this.mType = i;
    }

    public float asNumber() {
        if (this.mType == 0) {
            return this.mValue;
        }
        return 0.0f;
    }

    public float getValue(float f) {
        return getValueInternal(this.mArray, this.mValue, this.mType, f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        PlatformLength platformLength = (PlatformLength) obj;
        int i = this.mType;
        if (i != platformLength.mType) {
            return false;
        }
        if (i != 2) {
            return FloatUtils.floatsEqual(this.mValue, platformLength.mValue);
        }
        return this.mArray.asArrayList().equals(platformLength.mArray.asArrayList());
    }

    public boolean isZero() {
        return this.mType != 2 && this.mValue == 0.0f;
    }

    private static float getValueInternal(ReadableArray readableArray, float f, int i, float f2) {
        ReadableArray readableArray2;
        float f3;
        if (i == 1) {
            return f * f2;
        }
        if (i == 0) {
            return f;
        }
        if (i != 2) {
            return 0.0f;
        }
        float f4 = 0.0f;
        for (int i2 = 0; i2 < readableArray.size(); i2 += 2) {
            int i3 = readableArray.getInt(i2 + 1);
            if (i3 == 2) {
                readableArray2 = readableArray.getArray(i2);
            } else {
                readableArray2 = null;
                if (i3 == 0 || i3 == 1) {
                    f3 = (float) readableArray.getDouble(i2);
                    f4 += getValueInternal(readableArray2, f3, i3, f2);
                }
            }
            f3 = 0.0f;
            f4 += getValueInternal(readableArray2, f3, i3, f2);
        }
        return f4;
    }
}

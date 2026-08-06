package com.lynx.tasm.behavior.p000ui.utils;

import com.lynx.react.bridge.ReadableArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TransformOrigin {
    public static final TransformOrigin TRANSFORM_ORIGIN_DEFAULT = new TransformOrigin();

    /* renamed from: p0 */
    private final float f15p0;
    private final int p0Unit;

    /* renamed from: p1 */
    private final float f16p1;
    private final int p1Unit;

    public static TransformOrigin MakeTransformOrigin(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() < 2) {
            return null;
        }
        return new TransformOrigin(readableArray);
    }

    private TransformOrigin() {
        this.f15p0 = 0.5f;
        this.p0Unit = 1;
        this.f16p1 = 0.5f;
        this.p1Unit = 1;
    }

    private TransformOrigin(ReadableArray readableArray) {
        this.f15p0 = (float) readableArray.getDouble(0);
        this.p0Unit = readableArray.getInt(1);
        if (readableArray.size() >= 4) {
            this.f16p1 = (float) readableArray.getDouble(2);
            this.p1Unit = readableArray.getInt(3);
        } else {
            this.f16p1 = 0.5f;
            this.p1Unit = 1;
        }
    }

    private TransformOrigin(float f, float f2) {
        this.f15p0 = f;
        this.f16p1 = f2;
        this.p0Unit = 0;
        this.p1Unit = 0;
    }

    public boolean isValid() {
        return isP0Valid() || isP1Valid();
    }

    public boolean isP0Valid() {
        return (this.f15p0 == 0.5f && this.p0Unit == 1) ? false : true;
    }

    public boolean isP1Valid() {
        return (this.f16p1 == 0.5f && this.p1Unit == 1) ? false : true;
    }

    public boolean isP0Percent() {
        return this.p0Unit == 1;
    }

    public boolean isP1Percent() {
        return this.p1Unit == 1;
    }

    public boolean hasPercent() {
        return isP0Percent() || isP1Percent();
    }

    public float getP0() {
        return this.f15p0;
    }

    public float getP1() {
        return this.f16p1;
    }

    public static boolean hasPercent(TransformOrigin transformOrigin) {
        return transformOrigin != null && transformOrigin.isValid() && transformOrigin.hasPercent();
    }
}

package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;

/* loaded from: classes7.dex */
public class TransformOrigin {
    public static final TransformOrigin TRANSFORM_ORIGIN_DEFAULT = new TransformOrigin();
    private final float p0;
    private final int p0Unit;
    private final float p1;
    private final int p1Unit;

    public static TransformOrigin MakeTransformOrigin(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() < 2) {
            return null;
        }
        return new TransformOrigin(readableArray);
    }

    private TransformOrigin() {
        this.p0 = 0.5f;
        this.p0Unit = 1;
        this.p1 = 0.5f;
        this.p1Unit = 1;
    }

    private TransformOrigin(ReadableArray readableArray) {
        this.p0 = (float) readableArray.getDouble(0);
        this.p0Unit = readableArray.getInt(1);
        if (readableArray.size() >= 4) {
            this.p1 = (float) readableArray.getDouble(2);
            this.p1Unit = readableArray.getInt(3);
        } else {
            this.p1 = 0.5f;
            this.p1Unit = 1;
        }
    }

    private TransformOrigin(float f, float f2) {
        this.p0 = f;
        this.p1 = f2;
        this.p0Unit = 0;
        this.p1Unit = 0;
    }

    public boolean isValid() {
        return isP0Valid() || isP1Valid();
    }

    public boolean isP0Valid() {
        return (this.p0 == 0.5f && this.p0Unit == 1) ? false : true;
    }

    public boolean isP1Valid() {
        return (this.p1 == 0.5f && this.p1Unit == 1) ? false : true;
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
        return this.p0;
    }

    public float getP1() {
        return this.p1;
    }

    public static boolean hasPercent(TransformOrigin transformOrigin) {
        return transformOrigin != null && transformOrigin.isValid() && transformOrigin.hasPercent();
    }
}

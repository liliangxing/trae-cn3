package com.lynx.tasm.behavior.p000ui.utils;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.shadow.MeasureUtils;
import com.lynx.tasm.utils.FloatUtils;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BorderRadius {
    private static final int ARR_SIZE = 8;
    private static final int CORNER_SIZE = 4;
    private float[] mCachedArray;
    private Corner[] mCornerRadii;
    private float mWidth = 0.0f;
    private float mHeight = 0.0f;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum Location {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Corner {

        /* renamed from: x */
        public PlatformLength f13x;

        /* renamed from: y */
        public PlatformLength f14y;

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            Corner corner = (Corner) obj;
            return Objects.equals(this.f13x, corner.f13x) && Objects.equals(this.f14y, corner.f14y);
        }

        public static Corner toCorner(ReadableArray readableArray, int i) {
            Corner corner = new Corner();
            corner.f13x = new PlatformLength(readableArray.getDynamic(i), readableArray.getInt(i + 1));
            corner.f14y = new PlatformLength(readableArray.getDynamic(i + 2), readableArray.getInt(i + 3));
            return corner;
        }
    }

    public void clearCache() {
        this.mCachedArray = null;
    }

    public boolean updateSize(float f, float f2) {
        if (f < 0.0f || MeasureUtils.isUndefined(f)) {
            f = 0.0f;
        }
        if (f2 < 0.0f || MeasureUtils.isUndefined(f2)) {
            f2 = 0.0f;
        }
        if (FloatUtils.floatsEqual(f, this.mWidth) && FloatUtils.floatsEqual(f2, this.mHeight)) {
            return this.mCachedArray == null;
        }
        this.mWidth = f;
        this.mHeight = f2;
        this.mCachedArray = null;
        return true;
    }

    public boolean hasArray() {
        return this.mCachedArray != null;
    }

    public float[] getArray() {
        float[] fArr = this.mCachedArray;
        if (fArr != null) {
            return fArr;
        }
        this.mCachedArray = getBorderRadiusArrayOrDefaultTo();
        adjustBorderRadiusForBound();
        return this.mCachedArray;
    }

    public boolean hasRoundedBorders() {
        Corner[] cornerArr = this.mCornerRadii;
        if (cornerArr != null) {
            for (Corner corner : cornerArr) {
                if (corner != null && corner.f13x != null && (!corner.f13x.isZero() || !corner.f14y.isZero())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean setCorner(int i, Corner corner) {
        if (i >= 0 && i < 4) {
            if (this.mCornerRadii == null) {
                this.mCornerRadii = new Corner[4];
            }
            if (corner == null) {
                corner = new Corner();
            }
            if (!Objects.equals(corner, this.mCornerRadii[i])) {
                this.mCornerRadii[i] = corner;
                return true;
            }
        }
        return false;
    }

    private float[] getBorderRadiusArrayOrDefaultTo() {
        float[] fArr = new float[8];
        int i = 0;
        if (this.mCornerRadii == null) {
            while (i < 8) {
                fArr[i] = 0.0f;
                i++;
            }
            return fArr;
        }
        while (i < 4) {
            Corner corner = this.mCornerRadii[i];
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (corner == null || corner.f13x == null) {
                fArr[i3] = 0.0f;
                fArr[i2] = 0.0f;
            } else {
                fArr[i2] = corner.f13x.getValue(this.mWidth);
                fArr[i3] = corner.f14y.getValue(this.mHeight);
            }
            i++;
        }
        return fArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if (r2 < 1.0f) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void adjustBorderRadiusForBound() {
        float f;
        if (FloatUtils.floatsEqual(this.mWidth, 0.0f) || FloatUtils.floatsEqual(this.mHeight, 0.0f)) {
            return;
        }
        float[] fArr = this.mCachedArray;
        float f2 = fArr[0];
        float f3 = fArr[2];
        float f4 = f2 + f3;
        float f5 = this.mWidth;
        if (f4 > f5) {
            f = f5 / (f2 + f3);
        }
        f = 1.0f;
        float f6 = fArr[4];
        float f7 = fArr[6];
        if (f6 + f7 > f5) {
            float f8 = f5 / (f6 + f7);
            if (f8 < f) {
                f = f8;
            }
        }
        float f9 = fArr[1];
        float f10 = fArr[7];
        float f11 = f9 + f10;
        float f12 = this.mHeight;
        if (f11 > f12) {
            float f13 = f12 / (f9 + f10);
            if (f13 < f) {
                f = f13;
            }
        }
        float f14 = fArr[3];
        float f15 = fArr[5];
        if (f14 + f15 > f12) {
            float f16 = f12 / (f14 + f15);
            if (f16 < f) {
                f = f16;
            }
        }
        if (f < 1.0f) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = fArr[i] * f;
            }
        }
    }
}

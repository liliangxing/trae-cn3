package com.lynx.tasm.ui.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;
import com.lynx.tasm.image.ScalingUtils;

/* loaded from: classes7.dex */
public class LynxScalingUtils {

    /* loaded from: classes7.dex */
    public interface ScaleType extends ScalingUtils.ScaleType {
        public static final ScalingUtils.ScaleType FIT_XY = ScaleTypeFitXY.INSTANCE;
        public static final ScalingUtils.ScaleType CENTER = ScaleTypeCenter.INSTANCE;
        public static final ScalingUtils.ScaleType CENTER_CROP = ScaleTypeCenterCrop.INSTANCE;
        public static final ScalingUtils.ScaleType FIT_CENTER = ScaleTypeFitCenter.INSTANCE;
    }

    /* loaded from: classes7.dex */
    private static class ScaleTypeFitXY implements ScalingUtils.ScaleType {
        public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitXY();

        private ScaleTypeFitXY() {
        }

        public String toString() {
            return ScalingUtils.ScaleType.FIT_XY.toString();
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            return ScalingUtils.ScaleType.FIT_XY.getTransform(matrix, rect, i, i2, f, f2);
        }
    }

    /* loaded from: classes7.dex */
    private static class ScaleTypeFitCenter implements ScalingUtils.ScaleType {
        public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeFitCenter();

        private ScaleTypeFitCenter() {
        }

        public String toString() {
            return ScalingUtils.ScaleType.FIT_CENTER.toString();
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            return ScalingUtils.ScaleType.FIT_CENTER.getTransform(matrix, rect, i, i2, f, f2);
        }
    }

    /* loaded from: classes7.dex */
    private static class ScaleTypeCenter implements ScalingUtils.ScaleType {
        public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeCenter();

        private ScaleTypeCenter() {
        }

        public String toString() {
            return ScalingUtils.ScaleType.CENTER.toString();
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            return ScalingUtils.ScaleType.CENTER.getTransform(matrix, rect, i, i2, f, f2);
        }
    }

    /* loaded from: classes7.dex */
    private static class ScaleTypeCenterCrop implements ScalingUtils.ScaleType {
        public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeCenterCrop();

        private ScaleTypeCenterCrop() {
        }

        public String toString() {
            return ScalingUtils.ScaleType.CENTER_CROP.toString();
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            return ScalingUtils.ScaleType.CENTER_CROP.getTransform(matrix, rect, i, i2, f, f2);
        }
    }
}

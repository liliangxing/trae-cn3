package com.lynx.tasm.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.lynx.tasm.utils.PixelUtils;

/* loaded from: classes7.dex */
public class ScalingUtils {

    /* loaded from: classes7.dex */
    public interface ScaleType {
        public static final ScaleType FIT_XY = ScaleTypeFitXY.INSTANCE;
        public static final ScaleType FIT_CENTER = ScaleTypeFitCenter.INSTANCE;
        public static final ScaleType CENTER = ScaleTypeCenter.INSTANCE;
        public static final ScaleType CENTER_CROP = ScaleTypeCenterCrop.INSTANCE;

        Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2);
    }

    /* loaded from: classes7.dex */
    public static abstract class AbstractScaleType implements ScaleType {
        public abstract void getTransformImpl(Matrix matrix, float f, float f2, float f3, float f4, float f5, float f6);

        @Override // com.lynx.tasm.image.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            getTransformImpl(matrix, rect.width(), rect.height(), i, i2, rect.left, rect.top);
            return matrix;
        }
    }

    /* loaded from: classes7.dex */
    private static class ScaleTypeFitXY extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitXY();

        public String toString() {
            return "fit_xy";
        }

        private ScaleTypeFitXY() {
        }

        @Override // com.lynx.tasm.image.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, float f, float f2, float f3, float f4, float f5, float f6) {
            matrix.setScale(f / f3, f2 / f4);
            matrix.postTranslate(f5, f6);
        }
    }

    /* loaded from: classes7.dex */
    private static class ScaleTypeFitCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitCenter();

        public String toString() {
            return "fit_center";
        }

        private ScaleTypeFitCenter() {
        }

        @Override // com.lynx.tasm.image.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, float f, float f2, float f3, float f4, float f5, float f6) {
            float f7 = f / f3;
            float f8 = f2 / f4;
            if (f7 > f8) {
                matrix.setScale(f8, f8);
                matrix.postTranslate(((f - (f3 * f8)) / 2.0f) + f5, f6);
            } else {
                matrix.setScale(f7, f7);
                matrix.postTranslate(f5, ((f2 - (f4 * f7)) / 2.0f) + f6);
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class ScaleTypeCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenter();

        public String toString() {
            return "center";
        }

        private ScaleTypeCenter() {
        }

        @Override // com.lynx.tasm.image.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, float f, float f2, float f3, float f4, float f5, float f6) {
            float dipToPx = PixelUtils.dipToPx(1.0f);
            float round = Math.round((f - (f3 * dipToPx)) * 0.5f);
            float round2 = Math.round((f2 - (f4 * dipToPx)) * 0.5f);
            matrix.setScale(dipToPx, dipToPx);
            matrix.postTranslate(round, round2);
        }
    }

    /* loaded from: classes7.dex */
    private static class ScaleTypeCenterCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterCrop();

        public String toString() {
            return "center_crop";
        }

        private ScaleTypeCenterCrop() {
        }

        @Override // com.lynx.tasm.image.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, float f, float f2, float f3, float f4, float f5, float f6) {
            float f7 = f / f3;
            float f8 = f2 / f4;
            if (f7 > f8) {
                matrix.setScale(f7, f7);
                matrix.postTranslate(f5, ((f2 - (f4 * f7)) / 2.0f) + f6);
            } else {
                matrix.setScale(f8, f8);
                matrix.postTranslate(((f - (f3 * f8)) / 2.0f) + f5, f6);
            }
        }
    }
}

package com.lynx.tasm.behavior.p000ui.background;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.utils.GradientUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BackgroundRadialGradientLayer extends BackgroundGradientLayer {
    private static final int RADIAL_CENTER_TYPE_PERCENTAGE = 11;
    private static final int RADIAL_CENTER_TYPE_PX = 5;
    private static final int RADIAL_CENTER_TYPE_RPX = 6;
    private static final int RADIAL_SHAPE_CIRCLE = 1;
    private static final int RADIAL_SHAPE_ELLIPSE = 0;
    private static final int RADIAL_SIZE_CLOSEST_CORNER = 2;
    private static final int RADIAL_SIZE_CLOSEST_SIDE = 3;
    private static final int RADIAL_SIZE_FARTHEST_CORNER = 0;
    private static final int RADIAL_SIZE_FARTHEST_SIDE = 1;
    private static final int RADIAL_SIZE_LENGTH = 4;
    private static final String TAG = "RadialGradient";
    private PointF mAt = new PointF(0.5f, 0.5f);
    private int mCenterX;
    private float mCenterXValue;
    private int mCenterY;
    private float mCenterYValue;
    private int mShape;
    private int mShapeSize;
    private int mShapeSizeXUnit;
    private float mShapeSizeXValue;
    private int mShapeSizeYUnit;
    private float mShapeSizeYValue;

    private float calculateValue(int i, float f, float f2) {
        if (i == 11) {
            return (f2 * f) / 100.0f;
        }
        switch (i) {
            case 32:
            case 35:
                return 0.0f;
            case 33:
            case 34:
                return f2;
            case 36:
                return f2 * 0.5f;
            default:
                return f;
        }
    }

    public BackgroundRadialGradientLayer(ReadableArray readableArray) {
        this.mShape = 0;
        this.mShapeSize = 0;
        this.mCenterX = 36;
        this.mCenterY = 36;
        this.mCenterXValue = 0.5f;
        this.mCenterYValue = 0.5f;
        if (readableArray == null) {
            LLog.e(TAG, "native parser error, array is null");
            return;
        }
        if (readableArray.size() != 3) {
            LLog.e(TAG, "native parser error, array.size must be 3");
        }
        ReadableArray array = readableArray.getArray(0);
        this.mShape = (int) array.getLong(0);
        this.mShapeSize = (int) array.getLong(1);
        this.mCenterX = (int) array.getLong(2);
        this.mCenterXValue = (float) array.getDouble(3);
        this.mCenterY = (int) array.getLong(4);
        this.mCenterYValue = (float) array.getDouble(5);
        if (this.mShapeSize == 4) {
            this.mShapeSizeXValue = (float) array.getDouble(10);
            this.mShapeSizeXUnit = array.getInt(11);
            this.mShapeSizeYValue = (float) array.getDouble(12);
            this.mShapeSizeYUnit = array.getInt(13);
        }
        setColorAndStop(readableArray.getArray(1), readableArray.getArray(2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        PointF radius;
        this.mWidth = rect.width();
        this.mHeight = rect.height();
        calculateCenter();
        float f = this.mAt.x;
        float f2 = this.mAt.y;
        int i = this.mShapeSize;
        boolean z = true;
        if (i == 4) {
            radius = new PointF(this.mShapeSizeXUnit == 1 ? this.mWidth * this.mShapeSizeXValue : this.mShapeSizeXValue, this.mShapeSizeYUnit == 1 ? this.mHeight * this.mShapeSizeYValue : this.mShapeSizeYValue);
        } else {
            radius = GradientUtils.getRadius(this.mShape, i, f, f2, this.mWidth, this.mHeight);
        }
        if (this.mColors == null || this.mColors.length < 2) {
            this.mShader = null;
        } else if (this.mPositions != null && this.mPositions.length != this.mColors.length) {
            this.mShader = null;
        } else {
            try {
                if (radius.x != 0.0f && radius.y != 0.0f) {
                    z = false;
                }
                float f3 = z ? 1.0f : radius.x / radius.y;
                this.mShader = new RadialGradient(f, f2, Math.max(radius.x, 1.0f), this.mColors, this.mPositions, Shader.TileMode.CLAMP);
                if (f3 != 1.0f) {
                    Matrix matrix = new Matrix();
                    matrix.preScale(1.0f, 1.0f / f3, f, f2);
                    this.mShader.setLocalMatrix(matrix);
                }
            } catch (Exception e) {
                this.mShader = null;
                e.printStackTrace();
                LLog.w("BackgroundRadialGradientLayer", "exception:\n" + e.toString());
            }
        }
        super.setBounds(rect);
    }

    private void calculateCenter() {
        this.mAt.x = calculateValue(this.mCenterX, this.mCenterXValue, this.mWidth);
        this.mAt.y = calculateValue(this.mCenterY, this.mCenterYValue, this.mHeight);
    }
}

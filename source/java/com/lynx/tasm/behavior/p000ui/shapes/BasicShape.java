package com.lynx.tasm.behavior.p000ui.shapes;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.core.graphics.PathParser;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BasicShape {
    private static final String BASIC_SHAPE_TAG = "LynxBasicShape";
    private static final int CORNER_RECT = 1;
    private static final int CORNER_ROUNDED = 2;
    private static final int CORNER_SUPER_ELLIPTICAL = 3;
    private static final int INDEX_BASIC_SHAPE_TYPE = 0;
    public static final int INDEX_CIRCLE_CENTER_X = 1;
    public static final int INDEX_CIRCLE_CENTER_Y = 2;
    public static final int INDEX_CIRCLE_RADIUS = 0;
    public static final int INDEX_ELLIPSE_CENTER_X = 2;
    public static final int INDEX_ELLIPSE_CENTER_Y = 3;
    public static final int INDEX_ELLIPSE_RADIUS_X = 0;
    public static final int INDEX_ELLIPSE_RADIUS_Y = 1;
    public static final int INDEX_SUPER_ELLIPSE_CENTER_X = 2;
    public static final int INDEX_SUPER_ELLIPSE_CENTER_Y = 3;
    public static final int INDEX_SUPER_ELLIPSE_EXPONENT_X = 0;
    public static final int INDEX_SUPER_ELLIPSE_EXPONENT_Y = 1;
    public static final int INDEX_SUPER_ELLIPSE_RADIUS_X = 0;
    public static final int INDEX_SUPER_ELLIPSE_RADIUS_Y = 1;
    public static final int PARAMS_LEN_CIRCLE = 3;
    public static final int PARAMS_LEN_ELLIPSE = 4;
    private static final int PARAMS_LEN_INSET = 4;
    public static final int PARAMS_LEN_SUPER_ELLIPSE = 4;
    public static final int PARAMS_LEN_SUPER_ELLIPSE_EXPONENTS = 2;
    public static final int RAW_INDEX_CIRCLE_CENTER_X = 3;
    public static final int RAW_INDEX_CIRCLE_CENTER_X_UNIT = 4;
    public static final int RAW_INDEX_CIRCLE_CENTER_Y = 5;
    public static final int RAW_INDEX_CIRCLE_CENTER_Y_UNIT = 6;
    public static final int RAW_INDEX_CIRCLE_RADIUS = 1;
    public static final int RAW_INDEX_CIRCLE_RADIUS_UNIT = 2;
    public static final int RAW_INDEX_ELLIPSE_CENTER_X = 5;
    public static final int RAW_INDEX_ELLIPSE_CENTER_X_UNIT = 6;
    public static final int RAW_INDEX_ELLIPSE_CENTER_Y = 7;
    public static final int RAW_INDEX_ELLIPSE_CENTER_Y_UNIT = 8;
    public static final int RAW_INDEX_ELLIPSE_RADIUS_X = 1;
    public static final int RAW_INDEX_ELLIPSE_RADIUS_X_UNIT = 2;
    public static final int RAW_INDEX_ELLIPSE_RADIUS_Y = 3;
    public static final int RAW_INDEX_ELLIPSE_RADIUS_Y_UNIT = 4;
    public static final int RAW_INDEX_PATH_DATA = 1;
    public static final int RAW_INDEX_SUPER_ELLIPSE_CENTER_X = 7;
    public static final int RAW_INDEX_SUPER_ELLIPSE_CENTER_X_UNIT = 8;
    public static final int RAW_INDEX_SUPER_ELLIPSE_CENTER_Y = 9;
    public static final int RAW_INDEX_SUPER_ELLIPSE_CENTER_Y_UNIT = 10;
    public static final int RAW_INDEX_SUPER_ELLIPSE_EXPONENT_X = 5;
    public static final int RAW_INDEX_SUPER_ELLIPSE_EXPONENT_Y = 6;
    public static final int RAW_INDEX_SUPER_ELLIPSE_RADIUS_X = 1;
    public static final int RAW_INDEX_SUPER_ELLIPSE_RADIUS_X_UNIT = 2;
    public static final int RAW_INDEX_SUPER_ELLIPSE_RADIUS_Y = 3;
    public static final int RAW_INDEX_SUPER_ELLIPSE_RADIUS_Y_UNIT = 4;
    public static final int RAW_PARAMS_LEN_CIRCLE = 7;
    public static final int RAW_PARAMS_LEN_ELLIPSE = 9;
    private static final int RAW_PARAMS_LEN_INSET_RECT = 9;
    private static final int RAW_PARAMS_LEN_INSET_ROUND = 25;
    private static final int RAW_PARAMS_LEN_INSET_SUPER_ELLIPSE = 27;
    public static final int RAW_PARAMS_LEN_PATH = 2;
    public static final int RAW_PARAMS_LEN_SUPER_ELLIPSE = 11;
    private static Matrix sDensityScale;
    private static final double sqrt_2 = Math.sqrt(2.0d);
    public double[] exponents;
    private BorderRadius mCornerRadius;
    private int mCornerType;
    private int mHeight;
    private Path mPath;
    private int mType;
    private int mWidth;
    public Length[] params;

    public static BasicShape CreateFromReadableArray(ReadableArray readableArray, float f) {
        if (readableArray == null || readableArray.size() <= 1) {
            return null;
        }
        int size = readableArray.size();
        long j = readableArray.getLong(0);
        if (j == 3) {
            if (size != 2) {
                return null;
            }
            return new BasicShape(readableArray.getString(1), f);
        }
        int i = 11;
        if (j == 4) {
            if (size != 11) {
                return null;
            }
            BasicShape basicShape = new BasicShape(4);
            Length[] lengthArr = new Length[4];
            basicShape.params = lengthArr;
            lengthArr[0] = new Length(readableArray.getDouble(1), readableArray.getInt(2));
            basicShape.params[1] = new Length(readableArray.getDouble(3), readableArray.getInt(4));
            basicShape.params[2] = new Length(readableArray.getDouble(7), readableArray.getInt(8));
            basicShape.params[3] = new Length(readableArray.getDouble(9), readableArray.getInt(10));
            basicShape.exponents = r2;
            double[] dArr = {readableArray.getDouble(5)};
            basicShape.exponents[1] = readableArray.getDouble(6);
            return basicShape;
        }
        if (j == 1) {
            if (size != 7) {
                return null;
            }
            BasicShape basicShape2 = new BasicShape(1);
            Length[] lengthArr2 = new Length[3];
            basicShape2.params = lengthArr2;
            lengthArr2[0] = new Length(readableArray.getDouble(1), readableArray.getInt(2));
            basicShape2.params[1] = new Length(readableArray.getDouble(3), readableArray.getInt(4));
            basicShape2.params[2] = new Length(readableArray.getDouble(5), readableArray.getInt(6));
            return basicShape2;
        }
        if (j == 2) {
            if (size != 9) {
                return null;
            }
            BasicShape basicShape3 = new BasicShape(2);
            Length[] lengthArr3 = new Length[4];
            basicShape3.params = lengthArr3;
            lengthArr3[0] = new Length(readableArray.getDouble(1), readableArray.getInt(2));
            basicShape3.params[1] = new Length(readableArray.getDouble(3), readableArray.getInt(4));
            basicShape3.params[2] = new Length(readableArray.getDouble(5), readableArray.getInt(6));
            basicShape3.params[3] = new Length(readableArray.getDouble(7), readableArray.getInt(8));
            return basicShape3;
        }
        if (j != 5) {
            return null;
        }
        BasicShape basicShape4 = new BasicShape(5);
        basicShape4.params = new Length[4];
        if (readableArray.size() == 9) {
            basicShape4.mCornerType = 1;
        } else if (readableArray.size() == 25) {
            basicShape4.mCornerType = 2;
        } else {
            if (readableArray.size() != 27) {
                return null;
            }
            basicShape4.mCornerType = 3;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 2;
            basicShape4.params[i2] = new Length(readableArray.getDouble(i3 + 1), readableArray.getInt(i3 + 2));
        }
        int i4 = basicShape4.mCornerType;
        if (i4 != 2) {
            if (i4 == 3) {
                basicShape4.exponents = r1;
                double[] dArr2 = {readableArray.getDouble(9)};
                basicShape4.exponents[1] = readableArray.getDouble(10);
            }
            return basicShape4;
        }
        i = 9;
        basicShape4.mCornerRadius = new BorderRadius();
        for (int i5 = 0; i5 < 4; i5++) {
            basicShape4.mCornerRadius.setCorner(i5, BorderRadius.Corner.toCorner(readableArray, (i5 * 4) + i));
        }
        return basicShape4;
    }

    public BasicShape(String str, float f) {
        this.mPath = null;
        this.params = null;
        this.exponents = null;
        this.mCornerRadius = null;
        this.mCornerType = 0;
        this.mType = 3;
        try {
            this.mPath = PathParser.createPathFromPathData(str);
        } catch (RuntimeException unused) {
            LLog.e(BASIC_SHAPE_TAG, "Create path from data string failed. Check the path string. \n" + str);
        }
        if (this.mPath == null) {
            LLog.e(BASIC_SHAPE_TAG, "Invalid path data string: " + str);
            return;
        }
        if (sDensityScale == null) {
            sDensityScale = new Matrix();
        }
        sDensityScale.setScale(f, f);
        this.mPath.transform(sDensityScale);
    }

    public BasicShape(int i) {
        this.mPath = null;
        this.params = null;
        this.exponents = null;
        this.mCornerRadius = null;
        this.mCornerType = 0;
        this.mType = i;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Length {
        public int mUnit;
        public double mVal;

        public Length(double d, int i) {
            this.mVal = d;
            this.mUnit = i;
        }
    }

    public Path getPath(int i, int i2) {
        Path path;
        int i3 = this.mType;
        if (i3 == 3) {
            return this.mPath;
        }
        if (i3 == 0) {
            return null;
        }
        if (i == this.mWidth && i2 == this.mHeight && (path = this.mPath) != null) {
            return path;
        }
        this.mWidth = i;
        this.mHeight = i2;
        doDrawPath(i, i2);
        return this.mPath;
    }

    protected void doDrawPath(int i, int i2) {
        double[] dArr;
        Path path = this.mPath;
        if (path == null) {
            this.mPath = new Path();
        } else {
            path.reset();
        }
        int i3 = this.mType;
        if (i3 == 1) {
            Length[] lengthArr = this.params;
            if (lengthArr == null || lengthArr.length != 3) {
                return;
            }
            this.mPath.addCircle((float) lengthToDouble(this.params[1], i), (float) lengthToDouble(this.params[2], i2), (float) lengthToDouble(lengthArr[0], Math.sqrt((i * i) + (i2 * i2)) / sqrt_2), Path.Direction.CW);
            return;
        }
        if (i3 == 2) {
            Length[] lengthArr2 = this.params;
            if (lengthArr2 == null || lengthArr2.length != 4) {
                return;
            }
            double d = i;
            float lengthToDouble = (float) lengthToDouble(lengthArr2[0], d);
            float lengthToDouble2 = (float) lengthToDouble(this.params[1], d);
            float lengthToDouble3 = (float) lengthToDouble(this.params[2], d);
            float lengthToDouble4 = (float) lengthToDouble(this.params[3], i2);
            if (lengthToDouble == 0.0f && lengthToDouble2 == 0.0f) {
                return;
            }
            this.mPath.addOval(lengthToDouble3 - lengthToDouble, lengthToDouble4 - lengthToDouble2, lengthToDouble3 + lengthToDouble, lengthToDouble4 + lengthToDouble2, Path.Direction.CW);
            return;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                return;
            }
            doDrawBasicShapeInset(i, i2);
            return;
        }
        Length[] lengthArr3 = this.params;
        if (lengthArr3 == null || lengthArr3.length != 4 || (dArr = this.exponents) == null || dArr.length != 2) {
            return;
        }
        double d2 = i;
        float lengthToDouble5 = (float) lengthToDouble(lengthArr3[0], d2);
        float lengthToDouble6 = (float) lengthToDouble(this.params[1], d2);
        float lengthToDouble7 = (float) lengthToDouble(this.params[2], d2);
        float lengthToDouble8 = (float) lengthToDouble(this.params[3], i2);
        double[] dArr2 = this.exponents;
        float f = (float) dArr2[0];
        float f2 = (float) dArr2[1];
        if (lengthToDouble5 == 0.0f && lengthToDouble6 == 0.0f) {
            return;
        }
        for (int i4 = 1; i4 <= 4; i4++) {
            addLameCurveToPath(this.mPath, lengthToDouble5, lengthToDouble6, lengthToDouble7, lengthToDouble8, f, f2, i4);
        }
        this.mPath.close();
    }

    private void doDrawBasicShapeInset(int i, int i2) {
        Length[] lengthArr = this.params;
        if (lengthArr == null || lengthArr.length != 4) {
            return;
        }
        double d = i2;
        double lengthToDouble = lengthToDouble(lengthArr[0], d);
        double d2 = i;
        double lengthToDouble2 = lengthToDouble(this.params[1], d2);
        double lengthToDouble3 = lengthToDouble(this.params[2], d);
        double lengthToDouble4 = lengthToDouble(this.params[3], d2);
        double d3 = lengthToDouble + lengthToDouble3;
        double d4 = lengthToDouble4 + lengthToDouble2;
        if (d3 != 0.0d && d3 > d) {
            double d5 = d / d3;
            lengthToDouble *= d5;
            lengthToDouble3 *= d5;
        }
        if (d4 != 0.0d && d4 > d2) {
            double d6 = d2 / d4;
            lengthToDouble4 *= d6;
            lengthToDouble2 *= d6;
        }
        RectF rectF = new RectF((float) lengthToDouble4, (float) lengthToDouble, (float) (d2 - lengthToDouble2), (float) (d - lengthToDouble3));
        int i3 = this.mCornerType;
        if (i3 == 1) {
            this.mPath.addRect(rectF, Path.Direction.CW);
            return;
        }
        if (i3 == 2) {
            this.mCornerRadius.updateSize(rectF.width(), rectF.height());
            this.mPath.addRoundRect(rectF, this.mCornerRadius.getArray(), Path.Direction.CW);
            return;
        }
        if (i3 != 3) {
            return;
        }
        this.mCornerRadius.updateSize(rectF.width(), rectF.height());
        float[] array = this.mCornerRadius.getArray();
        if (array.length < 8) {
            return;
        }
        float f = array[4];
        float f2 = array[5];
        float f3 = rectF.right - f;
        float f4 = rectF.bottom - f2;
        double[] dArr = this.exponents;
        float f5 = (float) dArr[0];
        float f6 = (float) dArr[1];
        addLameCurveToPath(this.mPath, f, f2, f3, f4, f5, f6, 1);
        float f7 = array[6];
        float f8 = array[7];
        addLameCurveToPath(this.mPath, f7, f8, rectF.left + f7, rectF.bottom - f8, f5, f6, 2);
        float f9 = array[0];
        float f10 = array[1];
        addLameCurveToPath(this.mPath, f9, f10, rectF.left + f9, rectF.top + f10, f5, f6, 3);
        float f11 = array[2];
        float f12 = array[3];
        addLameCurveToPath(this.mPath, f11, f12, rectF.right - f11, rectF.top + f12, f5, f6, 4);
        this.mPath.close();
    }

    private double lengthToDouble(Length length, double d) {
        if (length == null) {
            return 0.0d;
        }
        return length.mUnit == 1 ? length.mVal * d : length.mVal;
    }

    private static void addLameCurveToPath(Path path, float f, float f2, float f3, float f4, float f5, float f6, int i) {
        int i2 = i;
        float f7 = (i2 == 1 || i2 == 4) ? 1.0f : -1.0f;
        float f8 = (i2 == 1 || i2 == 2) ? 1.0f : -1.0f;
        double d = 1.5707963267948966d;
        float f9 = (float) ((i2 - 1) * 1.5707963267948966d);
        while (true) {
            double d2 = f9;
            if (d2 >= i2 * d) {
                return;
            }
            double cos = f7 * Math.cos(d2);
            double sin = f8 * Math.sin(d2);
            double pow = (f7 * f * Math.pow(cos, 2.0f / f5)) + f3;
            float f10 = f8;
            double pow2 = (f8 * f2 * Math.pow(sin, 2.0f / f6)) + f4;
            if (f9 == 0.0f) {
                path.moveTo((float) pow, (float) pow2);
            } else {
                path.lineTo((float) pow, (float) pow2);
            }
            f9 = (float) (d2 + 0.01d);
            i2 = i;
            f8 = f10;
            d = 1.5707963267948966d;
        }
    }
}

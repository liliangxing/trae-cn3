package com.lynx.tasm.behavior.p000ui.utils;

import android.graphics.Matrix;
import android.renderscript.Matrix4f;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.utils.FloatUtils;
import com.lynx.tasm.utils.MatrixMathUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TransformProps {
    private float mTransformOriginX;
    private float mTransformOriginY;
    private LinkedHashMap<String, Float> mTransformPropsMap = new LinkedHashMap<>();

    public TransformProps() {
        reset();
    }

    private void setMatrixDecompositionContext(MatrixMathUtils.MatrixDecompositionContext matrixDecompositionContext) {
        setTranslationX(FloatUtils.sanitizeFloatPropertyValue(matrixDecompositionContext.getTranslationX()));
        setTranslationY(FloatUtils.sanitizeFloatPropertyValue(matrixDecompositionContext.getTranslationY()));
        setTranslationZ(FloatUtils.sanitizeFloatPropertyValue(matrixDecompositionContext.getTranslationZ()));
        setRotation(FloatUtils.sanitizeFloatPropertyValue(matrixDecompositionContext.getRotation()));
        setRotationX(FloatUtils.sanitizeFloatPropertyValue(matrixDecompositionContext.getRotationX()));
        setRotationY(FloatUtils.sanitizeFloatPropertyValue(matrixDecompositionContext.getRotationY()));
        setScaleX(FloatUtils.sanitizeFloatPropertyValue(matrixDecompositionContext.getScaleX()));
        setScaleY(FloatUtils.sanitizeFloatPropertyValue(matrixDecompositionContext.getScaleY()));
    }

    public void reset() {
        this.mTransformPropsMap.clear();
    }

    public float getTranslationX() {
        Float f = this.mTransformPropsMap.get(PropsConstants.TRANSLATE_X);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void setTranslationX(float f) {
        this.mTransformPropsMap.put(PropsConstants.TRANSLATE_X, Float.valueOf(f));
    }

    public float getTranslationY() {
        Float f = this.mTransformPropsMap.get(PropsConstants.TRANSLATE_Y);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void setTranslationY(float f) {
        this.mTransformPropsMap.put(PropsConstants.TRANSLATE_Y, Float.valueOf(f));
    }

    public void setTranslationZ(float f) {
        this.mTransformPropsMap.put(PropsConstants.TRANSLATE_Z, Float.valueOf(f));
    }

    public float getTranslationZ() {
        Float f = this.mTransformPropsMap.get(PropsConstants.TRANSLATE_Z);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public float getRotation() {
        Float f = this.mTransformPropsMap.get(PropsConstants.ROTATE);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void setRotation(float f) {
        this.mTransformPropsMap.put(PropsConstants.ROTATE, Float.valueOf(f));
    }

    public float getRotationX() {
        Float f = this.mTransformPropsMap.get(PropsConstants.ROTATE_X);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void setRotationX(float f) {
        this.mTransformPropsMap.put(PropsConstants.ROTATE_X, Float.valueOf(f));
    }

    public float getRotationY() {
        Float f = this.mTransformPropsMap.get(PropsConstants.ROTATE_Y);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void setRotationY(float f) {
        this.mTransformPropsMap.put(PropsConstants.ROTATE_Y, Float.valueOf(f));
    }

    public float getScaleX() {
        Float f = this.mTransformPropsMap.get(PropsConstants.SCALE_X);
        if (f != null) {
            return f.floatValue();
        }
        return 1.0f;
    }

    public void setScaleX(float f) {
        this.mTransformPropsMap.put(PropsConstants.SCALE_X, Float.valueOf(f));
    }

    public float getScaleY() {
        Float f = this.mTransformPropsMap.get(PropsConstants.SCALE_Y);
        if (f != null) {
            return f.floatValue();
        }
        return 1.0f;
    }

    public void setScaleY(float f) {
        this.mTransformPropsMap.put(PropsConstants.SCALE_Y, Float.valueOf(f));
    }

    public float getSkewX() {
        Float f = this.mTransformPropsMap.get(PropsConstants.SKEW_X);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void setSkewX(float f) {
        this.mTransformPropsMap.put(PropsConstants.SKEW_X, Float.valueOf((float) Math.tan(f)));
    }

    public float getSkewY() {
        Float f = this.mTransformPropsMap.get(PropsConstants.SKEW_Y);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public void setSkewY(float f) {
        this.mTransformPropsMap.put(PropsConstants.SKEW_Y, Float.valueOf((float) Math.tan(f)));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x002e. Please report as an issue. */
    public Matrix getTransformMatrix(float f, float f2, Matrix matrix) {
        for (Map.Entry<String, Float> entry : this.mTransformPropsMap.entrySet()) {
            String key = entry.getKey();
            float floatValue = entry.getValue().floatValue();
            key.hashCode();
            char c = 65535;
            switch (key.hashCode()) {
                case -1721943862:
                    if (key.equals(PropsConstants.TRANSLATE_X)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1721943861:
                    if (key.equals(PropsConstants.TRANSLATE_Y)) {
                        c = 1;
                        break;
                    }
                    break;
                case -925180581:
                    if (key.equals(PropsConstants.ROTATE)) {
                        c = 2;
                        break;
                    }
                    break;
                case -908189618:
                    if (key.equals(PropsConstants.SCALE_X)) {
                        c = 3;
                        break;
                    }
                    break;
                case -908189617:
                    if (key.equals(PropsConstants.SCALE_Y)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    matrix.preTranslate(floatValue, 0.0f);
                    break;
                case 1:
                    matrix.preTranslate(0.0f, floatValue);
                    break;
                case 2:
                    matrix.preRotate(floatValue, f, f2);
                    break;
                case 3:
                    matrix.preScale(floatValue, 1.0f, f, f2);
                    break;
                case 4:
                    matrix.preScale(1.0f, floatValue, f, f2);
                    break;
            }
        }
        return matrix;
    }

    public float getTransformOriginX() {
        return this.mTransformOriginX;
    }

    public void setTransformOriginX(float f) {
        this.mTransformOriginX = f;
    }

    public float getTransformOriginY() {
        return this.mTransformOriginY;
    }

    public void setTransformOriginY(float f) {
        this.mTransformOriginY = f;
    }

    float GetRawLengthValue(TransformRaw transformRaw, int i, float f) {
        int round;
        if (i == 0) {
            float value = transformRaw.getPlatformLengthP0().getValue(f);
            if (!transformRaw.isP0Percent()) {
                return value;
            }
            round = Math.round(value);
        } else if (i == 1) {
            float value2 = transformRaw.getPlatformLengthP1().getValue(f);
            if (!transformRaw.isP1Percent()) {
                return value2;
            }
            round = Math.round(value2);
        } else {
            if (i != 2) {
                return 0.0f;
            }
            float value3 = transformRaw.getPlatformLengthP2().getValue(f);
            if (!transformRaw.isP2Percent()) {
                return value3;
            }
            round = Math.round(value3);
        }
        return round;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x002b. Please report as an issue. */
    public static TransformProps processTransform(List<TransformRaw> list, float f, float f2, int i, int i2, int i3, int i4) {
        TransformProps transformProps = new TransformProps();
        if (list != null && !list.isEmpty()) {
            for (TransformRaw transformRaw : list) {
                int transformType = transformRaw.getTransformType();
                if (transformType != 1) {
                    if (transformType == 2) {
                        transformProps.setTranslationX(transformProps.GetRawLengthValue(transformRaw, 0, i3));
                    } else {
                        switch (transformType) {
                            case 4:
                                transformProps.setTranslationY(transformProps.GetRawLengthValue(transformRaw, 0, i4));
                                break;
                            case 8:
                                transformProps.setTranslationZ(transformProps.GetRawLengthValue(transformRaw, 0, 0.0f));
                                break;
                            case 16:
                                break;
                            case 32:
                            case 256:
                                transformProps.setRotation(transformRaw.getP0());
                                break;
                            case 64:
                                transformProps.setRotationX(transformRaw.getP0());
                                break;
                            case 128:
                                transformProps.setRotationY(transformRaw.getP0());
                                break;
                            case 512:
                                transformProps.setScaleX(transformRaw.getP0());
                                transformProps.setScaleY(transformRaw.getP1());
                                break;
                            case 1024:
                                transformProps.setScaleX(transformRaw.getP0());
                                break;
                            case 2048:
                                transformProps.setScaleY(transformRaw.getP0());
                                break;
                            case 4096:
                                transformProps.setSkewX((float) MatrixMathUtils.degreesToRadians(transformRaw.getP0()));
                                transformProps.setSkewY((float) MatrixMathUtils.degreesToRadians(transformRaw.getP1()));
                                break;
                            case 8192:
                                transformProps.setSkewX((float) MatrixMathUtils.degreesToRadians(transformRaw.getP0()));
                                break;
                            case 16384:
                                transformProps.setSkewY((float) MatrixMathUtils.degreesToRadians(transformRaw.getP0()));
                                break;
                            case 32768:
                            case 65536:
                                Matrix4f matrix4f = new Matrix4f(transformRaw.getTransformRawData());
                                MatrixMathUtils.MatrixDecompositionContext matrixDecompositionContext = new MatrixMathUtils.MatrixDecompositionContext();
                                matrixDecompositionContext.reset();
                                MatrixMathUtils.decomposeMatrix(convertFloatsToDoubles(matrix4f.getArray()), matrixDecompositionContext);
                                transformProps.setMatrixDecompositionContext(matrixDecompositionContext);
                                break;
                            default:
                                LLog.DTHROW();
                                return null;
                        }
                    }
                }
                transformProps.setTranslationX(transformProps.GetRawLengthValue(transformRaw, 0, i3));
                transformProps.setTranslationY(transformProps.GetRawLengthValue(transformRaw, 1, i4));
                transformProps.setTranslationZ(transformProps.GetRawLengthValue(transformRaw, 2, 0.0f));
            }
        }
        return transformProps;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0032. Please report as an issue. */
    public static TransformProps processTransformInOrder(List<TransformRaw> list, float f, float f2, int i, int i2, int i3, int i4) {
        TransformProps transformProps = new TransformProps();
        if (list != null && !list.isEmpty()) {
            Matrix4f matrix4f = new Matrix4f();
            for (TransformRaw transformRaw : list) {
                int transformType = transformRaw.getTransformType();
                if (transformType != 1) {
                    if (transformType == 2) {
                        matrix4f.translate(transformProps.GetRawLengthValue(transformRaw, 0, i3), 0.0f, 0.0f);
                    } else {
                        switch (transformType) {
                            case 4:
                                matrix4f.translate(0.0f, transformProps.GetRawLengthValue(transformRaw, 0, i4), 0.0f);
                                break;
                            case 8:
                                matrix4f.translate(0.0f, 0.0f, transformProps.GetRawLengthValue(transformRaw, 0, 0.0f));
                                break;
                            case 16:
                                break;
                            case 32:
                            case 256:
                                matrix4f.rotate(transformRaw.getP0(), 0.0f, 0.0f, 1.0f);
                                break;
                            case 64:
                                matrix4f.rotate(transformRaw.getP0(), 1.0f, 0.0f, 0.0f);
                                break;
                            case 128:
                                matrix4f.rotate(transformRaw.getP0(), 0.0f, 1.0f, 0.0f);
                                break;
                            case 512:
                                matrix4f.scale(transformRaw.getP0(), transformRaw.getP1(), 1.0f);
                                break;
                            case 1024:
                                matrix4f.scale(transformRaw.getP0(), 1.0f, 1.0f);
                                break;
                            case 2048:
                                matrix4f.scale(1.0f, transformRaw.getP0(), 1.0f);
                                break;
                            case 4096:
                                transformProps.setSkewX((float) MatrixMathUtils.degreesToRadians(transformRaw.getP0()));
                                transformProps.setSkewY((float) MatrixMathUtils.degreesToRadians(transformRaw.getP1()));
                                break;
                            case 8192:
                                transformProps.setSkewX((float) MatrixMathUtils.degreesToRadians(transformRaw.getP0()));
                                break;
                            case 16384:
                                transformProps.setSkewY((float) MatrixMathUtils.degreesToRadians(transformRaw.getP0()));
                                break;
                            case 32768:
                            case 65536:
                                matrix4f.multiply(new Matrix4f(transformRaw.getTransformRawData()));
                                break;
                            default:
                                LLog.DTHROW();
                                return null;
                        }
                    }
                }
                matrix4f.translate(transformProps.GetRawLengthValue(transformRaw, 0, i3), transformProps.GetRawLengthValue(transformRaw, 1, i4), transformProps.GetRawLengthValue(transformRaw, 2, 0.0f));
            }
            MatrixMathUtils.MatrixDecompositionContext matrixDecompositionContext = new MatrixMathUtils.MatrixDecompositionContext();
            matrixDecompositionContext.reset();
            MatrixMathUtils.decomposeMatrix(convertFloatsToDoubles(matrix4f.getArray()), matrixDecompositionContext);
            transformProps.setMatrixDecompositionContext(matrixDecompositionContext);
        }
        return transformProps;
    }

    public float toFinalValue(TransformRaw transformRaw, float f) {
        if (transformRaw.isP0Percent()) {
            return transformRaw.getP0() * f;
        }
        return transformRaw.getP0();
    }

    public static TransformProps processTransformOrigin(TransformOrigin transformOrigin, float f, float f2) {
        TransformProps transformProps = new TransformProps();
        transformProps.setTransformOriginX(f * 0.5f);
        transformProps.setTransformOriginY(0.5f * f2);
        if (transformOrigin != null && transformOrigin != TransformOrigin.TRANSFORM_ORIGIN_DEFAULT) {
            if (transformOrigin.isP0Valid()) {
                float p0 = transformOrigin.getP0();
                if (transformOrigin.isP0Percent()) {
                    p0 *= f;
                }
                transformProps.setTransformOriginX(p0);
            }
            if (transformOrigin.isP1Valid()) {
                float p1 = transformOrigin.getP1();
                if (transformOrigin.isP1Percent()) {
                    p1 *= f2;
                }
                transformProps.setTransformOriginY(p1);
            }
        }
        return transformProps;
    }

    public static double[] convertFloatsToDoubles(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        double[] dArr = new double[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            dArr[i] = fArr[i];
        }
        return dArr;
    }

    public Matrix4f transformPropsToMatrix4f() {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.translate(getTranslationX(), getTranslationY(), getTranslationZ());
        matrix4f.rotate(getRotationX(), 1.0f, 0.0f, 0.0f);
        matrix4f.rotate(getRotationY(), 0.0f, 1.0f, 0.0f);
        matrix4f.rotate(getRotation(), 0.0f, 0.0f, 1.0f);
        matrix4f.scale(getScaleX(), getScaleY(), 1.0f);
        float skewX = getSkewX();
        float skewY = getSkewY();
        Matrix4f matrix4f2 = new Matrix4f();
        matrix4f2.set(0, 1, skewX);
        Matrix4f matrix4f3 = new Matrix4f();
        matrix4f3.set(1, 0, skewY);
        matrix4f.multiply(matrix4f2);
        matrix4f.multiply(matrix4f3);
        return matrix4f;
    }

    public static void matrix4fToTransformProps(Matrix4f matrix4f, TransformProps transformProps) {
        MatrixMathUtils.MatrixDecompositionContext matrixDecompositionContext = new MatrixMathUtils.MatrixDecompositionContext();
        matrixDecompositionContext.reset();
        MatrixMathUtils.decomposeMatrix(convertFloatsToDoubles(matrix4f.getArray()), matrixDecompositionContext);
        transformProps.setMatrixDecompositionContext(matrixDecompositionContext);
    }
}

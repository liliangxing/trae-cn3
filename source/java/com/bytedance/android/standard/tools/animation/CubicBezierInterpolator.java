package com.bytedance.android.standard.tools.animation;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
public class CubicBezierInterpolator implements Interpolator {
    public static final int CUBICEASEIN = 7;
    public static final int CUBICEASEINOUT = 9;
    public static final int CUBICEASEOUT = 8;
    public static final int EXPOEASEIN = 16;
    public static final int EXPOEASEINOUT = 18;
    public static final int EXPOEASEOUT = 17;
    private static final int INT_3 = 3;
    public static final int LINEAR = 0;
    public static final int QUADEASEIN = 4;
    public static final int QUADEASEINOUT = 6;
    public static final int QUADEASEOUT = 5;
    public static final int QUARTEASEIN = 10;
    public static final int QUARTEASEINOUT = 12;
    public static final int QUARTEASEOUT = 11;
    public static final int QUINTEASEIN = 13;
    public static final int QUINTEASEINOUT = 15;
    public static final int QUINTEASEOUT = 14;
    public static final int SINEEASEIN = 1;
    public static final int SINEEASEINOUT = 3;
    public static final int SINEEASEOUT = 2;
    protected PointF a;
    protected PointF b;
    protected PointF c;
    protected PointF end;
    protected PointF start;

    public CubicBezierInterpolator(PointF pointF, PointF pointF2) throws IllegalArgumentException {
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("startX value must be in the range [0, 1]");
        }
        if (pointF2.x < 0.0f || pointF2.x > 1.0f) {
            throw new IllegalArgumentException("endX value must be in the range [0, 1]");
        }
        this.start = pointF;
        this.end = pointF2;
    }

    public CubicBezierInterpolator(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    public CubicBezierInterpolator(double d, double d2, double d3, double d4) {
        this((float) d, (float) d2, (float) d3, (float) d4);
    }

    public CubicBezierInterpolator(int i) {
        this(getCurveParameters(i)[0], getCurveParameters(i)[1], getCurveParameters(i)[2], getCurveParameters(i)[3]);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return getBezierCoordinateY(getXForTime(f));
    }

    protected float getBezierCoordinateY(float f) {
        this.c.y = this.start.y * 3.0f;
        this.b.y = ((this.end.y - this.start.y) * 3.0f) - this.c.y;
        this.a.y = (1.0f - this.c.y) - this.b.y;
        return f * (this.c.y + ((this.b.y + (this.a.y * f)) * f));
    }

    protected float getXForTime(float f) {
        float f2 = f;
        for (int i = 1; i < 14; i++) {
            float bezierCoordinateX = getBezierCoordinateX(f2) - f;
            if (Math.abs(bezierCoordinateX) < 0.001d) {
                break;
            }
            f2 -= bezierCoordinateX / getXDerivate(f2);
        }
        return f2;
    }

    protected static float[] getCurveParameters(int i) {
        switch (i) {
            case 0:
                return new float[]{0.0f, 0.0f, 1.0f, 1.0f};
            case 1:
                return new float[]{0.47f, 0.0f, 0.745f, 0.715f};
            case 2:
                return new float[]{0.39f, 0.575f, 0.565f, 1.0f};
            case 3:
                return new float[]{0.445f, 0.05f, 0.55f, 0.95f};
            case 4:
                return new float[]{0.26f, 0.0f, 0.6f, 0.2f};
            case 5:
                return new float[]{0.4f, 0.8f, 0.74f, 1.0f};
            case 6:
                return new float[]{0.48f, 0.04f, 0.52f, 0.96f};
            case 7:
                return new float[]{0.4f, 0.0f, 0.68f, 0.06f};
            case 8:
                return new float[]{0.32f, 0.94f, 0.6f, 1.0f};
            case 9:
                return new float[]{0.66f, 0.0f, 0.34f, 1.0f};
            case 10:
                return new float[]{0.52f, 0.0f, 0.74f, 0.0f};
            case 11:
                return new float[]{0.26f, 1.0f, 0.48f, 1.0f};
            case 12:
                return new float[]{0.76f, 0.0f, 0.24f, 1.0f};
            case 13:
                return new float[]{0.64f, 0.0f, 0.78f, 0.0f};
            case 14:
                return new float[]{0.22f, 1.0f, 0.36f, 1.0f};
            case 15:
                return new float[]{0.84f, 0.0f, 0.16f, 1.0f};
            case 16:
                return new float[]{0.66f, 0.0f, 0.86f, 0.0f};
            case 17:
                return new float[]{0.14f, 1.0f, 0.34f, 1.0f};
            case 18:
                return new float[]{0.9f, 0.0f, 0.1f, 1.0f};
            default:
                return new float[]{0.9f, 0.0f, 0.1f, 1.1f};
        }
    }

    private float getXDerivate(float f) {
        return this.c.x + (f * ((this.b.x * 2.0f) + (this.a.x * 3.0f * f)));
    }

    private float getBezierCoordinateX(float f) {
        this.c.x = this.start.x * 3.0f;
        this.b.x = ((this.end.x - this.start.x) * 3.0f) - this.c.x;
        this.a.x = (1.0f - this.c.x) - this.b.x;
        return f * (this.c.x + ((this.b.x + (this.a.x * f)) * f));
    }
}

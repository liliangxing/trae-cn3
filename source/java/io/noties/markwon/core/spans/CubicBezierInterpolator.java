package io.noties.markwon.core.spans;

import android.view.animation.Interpolator;

/* loaded from: classes6.dex */
public class CubicBezierInterpolator implements Interpolator {
    private static final int MAX_ITERATIONS = 14;
    private static final double PRECISION = 0.001d;
    protected PointF a;
    protected PointF b;
    protected PointF c;
    protected PointF end;
    protected PointF start;

    /* loaded from: classes6.dex */
    enum CurveType {
        LINEAR(0.0f, 0.0f, 1.0f, 1.0f),
        SINE_EASE_IN(0.47f, 0.0f, 0.745f, 0.715f),
        SINE_EASE_OUT(0.39f, 0.575f, 0.565f, 1.0f),
        SINE_EASE_IN_OUT(0.445f, 0.05f, 0.55f, 0.95f),
        QUAD_EASE_IN(0.26f, 0.0f, 0.6f, 0.2f),
        EXPO_EASE_IN_OUT(0.9f, 0.0f, 0.1f, 1.0f);

        final float endX;
        final float endY;
        final float startX;
        final float startY;

        CurveType(float f, float f2, float f3, float f4) {
            this.startX = f;
            this.startY = f2;
            this.endX = f3;
            this.endY = f4;
        }
    }

    public CubicBezierInterpolator(CurveType curveType) {
        this(new PointF(curveType.startX, curveType.startY), new PointF(curveType.endX, curveType.endY));
    }

    public CubicBezierInterpolator(float f, float f2, float f3, float f4) {
        this(new PointF(f, f2), new PointF(f3, f4));
    }

    public CubicBezierInterpolator(PointF pointF, PointF pointF2) {
        this.a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
        validatePoint(pointF);
        validatePoint(pointF2);
        this.start = pointF;
        this.end = pointF2;
    }

    private void validatePoint(PointF pointF) {
        if (pointF.x < 0.0f || pointF.x > 1.0f) {
            throw new IllegalArgumentException("Point x value must be in the range [0, 1]");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return getBezierCoordinateY(getXForTime(f));
    }

    protected float getBezierCoordinateY(float f) {
        setupCoefficients();
        return f * (this.c.y + ((this.b.y + (this.a.y * f)) * f));
    }

    protected float getXForTime(float f) {
        float f2 = f;
        for (int i = 0; i < 14; i++) {
            float bezierCoordinateX = getBezierCoordinateX(f2) - f;
            if (Math.abs(bezierCoordinateX) < PRECISION) {
                break;
            }
            f2 -= bezierCoordinateX / getXDerivative(f2);
        }
        return f2;
    }

    private void setupCoefficients() {
        this.c.x = this.start.x * 3.0f;
        this.b.x = ((this.end.x - this.start.x) * 3.0f) - this.c.x;
        this.a.x = (1.0f - this.c.x) - this.b.x;
        this.c.y = this.start.y * 3.0f;
        this.b.y = ((this.end.y - this.start.y) * 3.0f) - this.c.y;
        this.a.y = (1.0f - this.c.y) - this.b.y;
    }

    private float getBezierCoordinateX(float f) {
        return f * (this.c.x + ((this.b.x + (this.a.x * f)) * f));
    }

    private float getXDerivative(float f) {
        return this.c.x + (f * ((this.b.x * 2.0f) + (this.a.x * 3.0f * f)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes6.dex */
    public static class PointF {
        float x;
        float y;

        PointF() {
        }

        PointF(float f, float f2) {
            this.x = f;
            this.y = f2;
        }
    }
}

package com.bytedance.ies.uikit.progressview;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.bytedance.ugc.uikit.R;
import com.ttnet.org.chromium.base.TimeUtils;

/* loaded from: classes4.dex */
public class CircleProgress extends View {
    private static final int BLUE = -221678;
    private static final int COLOR_NUM = 3;
    private static final int DELTA_ANGLE = 45;
    private static final int POINT_NUM = 8;
    private static final int RED = -1759188;
    private static final int YELLOW = -14708582;
    private int[] COLORS;
    private final double DEGREE;
    private ArcPoint[] mArcPoint;
    private Point mCenter;
    private long mDuration;
    private TimeInterpolator mInterpolator;
    private Paint mPaint;
    private long mPlayTime;
    private int mPointRadius;
    private boolean mStartAnim;
    private long mStartTime;
    private int mViewSize;

    public CircleProgress(Context context) {
        super(context);
        this.mInterpolator = new EaseInOutCubicInterpolator();
        this.DEGREE = 0.017453292519943295d;
        this.mStartAnim = false;
        this.mCenter = new Point();
        this.mDuration = TimeUtils.SECONDS_PER_HOUR;
        init(null, 0);
    }

    public CircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInterpolator = new EaseInOutCubicInterpolator();
        this.DEGREE = 0.017453292519943295d;
        this.mStartAnim = false;
        this.mCenter = new Point();
        this.mDuration = TimeUtils.SECONDS_PER_HOUR;
        init(attributeSet, 0);
    }

    public CircleProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInterpolator = new EaseInOutCubicInterpolator();
        this.DEGREE = 0.017453292519943295d;
        this.mStartAnim = false;
        this.mCenter = new Point();
        this.mDuration = TimeUtils.SECONDS_PER_HOUR;
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        this.mArcPoint = new ArcPoint[8];
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CircleProgress, i, 0);
        int color = obtainStyledAttributes.getColor(R.styleable.CircleProgress_color1, RED);
        int color2 = obtainStyledAttributes.getColor(R.styleable.CircleProgress_color2, YELLOW);
        int color3 = obtainStyledAttributes.getColor(R.styleable.CircleProgress_color3, BLUE);
        obtainStyledAttributes.recycle();
        this.COLORS = new int[]{color, color2, color3};
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.default_circle_view_size);
        int min = Math.min(getDefaultSize(dimensionPixelSize, i), getDefaultSize(dimensionPixelSize, i2));
        this.mViewSize = min;
        setMeasuredDimension(min, min);
        Point point = this.mCenter;
        int i3 = this.mViewSize;
        point.set(i3 / 2, i3 / 2);
        calPoints(1.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(this.mCenter.x, this.mCenter.y);
        float factor = getFactor();
        canvas.rotate(36.0f * factor);
        for (int i = 0; i < 8; i++) {
            this.mPaint.setColor(this.mArcPoint[i].color);
            float itemFactor = getItemFactor(i, factor);
            canvas.drawCircle(this.mArcPoint[i].x - ((this.mArcPoint[i].x * 2.0f) * itemFactor), this.mArcPoint[i].y - ((this.mArcPoint[i].y * 2.0f) * itemFactor), this.mPointRadius, this.mPaint);
        }
        canvas.restore();
        if (this.mStartAnim) {
            postInvalidate();
        }
    }

    private void calPoints(float f) {
        int i = (int) ((this.mViewSize / 3) * f);
        this.mPointRadius = i / 6;
        for (int i2 = 0; i2 < 8; i2++) {
            float f2 = i;
            double d = i2 * 0.7853981633974483d;
            this.mArcPoint[i2] = new ArcPoint((-((float) Math.sin(d))) * f2, f2 * (-((float) Math.cos(d))), this.COLORS[i2 % 3]);
        }
    }

    private float getFactor() {
        if (this.mStartAnim) {
            this.mPlayTime = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
        }
        return (((float) this.mPlayTime) / ((float) this.mDuration)) % 5.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        if (r3 > 1.0f) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private float getItemFactor(int i, float f) {
        float f2 = (f - (i * 0.0825f)) * 3.0f;
        float f3 = f2 >= 0.0f ? 1.0f : 0.0f;
        f2 = f3;
        return this.mInterpolator.getInterpolation(f2);
    }

    public void startAnim() {
        this.mPlayTime %= this.mDuration;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartAnim = true;
        postInvalidate();
    }

    public void reset() {
        stopAnim();
        this.mPlayTime = 0L;
        postInvalidate();
    }

    public void stopAnim() {
        this.mStartAnim = false;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setRadius(float f) {
        stopAnim();
        calPoints(f);
        startAnim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class ArcPoint {
        int color;
        float x;
        float y;

        ArcPoint(float f, float f2, int i) {
            this.x = f;
            this.y = f2;
            this.color = i;
        }
    }

    /* loaded from: classes4.dex */
    static class EaseInOutCubicInterpolator implements TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return 0.5f * f2 * f2 * f2;
            }
            float f3 = f2 - 2.0f;
            return (0.5f * f3 * f3 * f3) + 1.0f;
        }

        EaseInOutCubicInterpolator() {
        }
    }
}

package com.bytedance.sdk.open.aweme.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.open.aweme.R;

/* loaded from: classes5.dex */
public class DoubleColorBallAnimationView extends View {
    private boolean autoProgress;
    private int cycleBias;
    private boolean dataReady;
    private long mAnimateStartTime;
    private boolean mAnimating;
    private final float mBaseHorizon;
    private final float mBaseP;
    private float mBaseR;
    private float mBaseX;
    private int mColor1;
    private int mColor2;
    private final long mDelay;
    private float mDistance;
    private final float mDuration;
    private final float mMaxScale;
    private final float mMinScale;
    private Paint mPaint;
    private int mSide;
    private float mSideCenter;
    private final PorterDuffXfermode mode;
    private float progress;

    public DoubleColorBallAnimationView(Context context) {
        this(context, null);
        init(context);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init(context);
    }

    public DoubleColorBallAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxScale = 0.25f;
        this.mMinScale = 0.375f;
        this.mBaseHorizon = 0.16f;
        this.mBaseP = 0.32f;
        this.mDuration = 400.0f;
        this.mDelay = 17L;
        this.mode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        this.autoProgress = false;
        this.dataReady = false;
        this.cycleBias = 0;
        this.mAnimating = false;
        this.mAnimateStartTime = -1L;
        this.mSide = -1;
        init(context);
    }

    private void checkData() {
        this.mAnimateStartTime = -1L;
        if (this.mSide <= 0) {
            setProgressBarInfo(getContext().getResources().getDimensionPixelSize(R.dimen.default_loading_side));
        }
        int min = Math.min(getMeasuredHeight(), getMeasuredWidth());
        if (this.mSide > min && min > 0) {
            setProgressBarInfo(min);
        }
        if (this.mPaint == null) {
            this.mPaint = createPaint();
        }
        this.dataReady = true;
    }

    private Paint createPaint() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        return paint;
    }

    private float getRealProgress(float f) {
        return ((double) f) < 0.5d ? 2.0f * f * f : ((f * 2.0f) * (2.0f - f)) - 1.0f;
    }

    private void init(Context context) {
        this.mColor1 = getContext().getResources().getColor(R.color.aweme_open_loading_color1);
        this.mColor2 = getContext().getResources().getColor(R.color.aweme_open_loading_color2);
    }

    public boolean isAnimating() {
        return this.mAnimating;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if ((isAnimating() || !this.autoProgress) && this.dataReady) {
            if (this.autoProgress) {
                long nanoTime = System.nanoTime() / 1000000;
                if (this.mAnimateStartTime < 0) {
                    this.mAnimateStartTime = nanoTime;
                }
                float f = ((float) (nanoTime - this.mAnimateStartTime)) / 400.0f;
                this.progress = f;
                int i = (int) f;
                r1 = ((this.cycleBias + i) & 1) == 1;
                this.progress = f - i;
            }
            float realProgress = getRealProgress(this.progress);
            float f2 = this.mSide;
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, f2, f2, this.mPaint, 31);
            float f3 = (this.mDistance * realProgress) + this.mBaseX;
            double d = realProgress;
            float f4 = realProgress * 2.0f;
            if (d >= 0.5d) {
                f4 = 2.0f - f4;
            }
            float f5 = this.mBaseR;
            float f6 = (0.25f * f4 * f5) + f5;
            this.mPaint.setColor(r1 ? this.mColor2 : this.mColor1);
            canvas.drawCircle(f3, this.mSideCenter, f6, this.mPaint);
            float f7 = this.mSide - f3;
            float f8 = this.mBaseR;
            float f9 = f8 - ((f4 * 0.375f) * f8);
            this.mPaint.setColor(r1 ? this.mColor1 : this.mColor2);
            this.mPaint.setXfermode(this.mode);
            canvas.drawCircle(f7, this.mSideCenter, f9, this.mPaint);
            this.mPaint.setXfermode(null);
            canvas.restoreToCount(saveLayer);
            postInvalidateDelayed(17L);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.mSide <= min || min <= 0) {
            return;
        }
        setProgressBarInfo(min);
    }

    public void setCycleBias(int i) {
        this.cycleBias = i;
    }

    public void setProgress(float f) {
        if (!this.dataReady) {
            checkData();
        }
        this.progress = f;
        this.mAnimating = false;
        this.autoProgress = false;
        postInvalidate();
    }

    public void setProgressBarInfo(int i) {
        if (i > 0) {
            this.mSide = i;
            float f = i;
            this.mSideCenter = f / 2.0f;
            float f2 = (i >> 1) * 0.32f;
            this.mBaseR = f2;
            float f3 = (0.16f * f) + f2;
            this.mBaseX = f3;
            this.mDistance = f - (f3 * 2.0f);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            startAnimate();
        } else {
            stopAnimate();
        }
    }

    public void startAnimate() {
        checkData();
        this.mAnimating = true;
        this.autoProgress = true;
        postInvalidate();
    }

    public void stopAnimate() {
        this.mAnimating = false;
        this.dataReady = false;
        this.progress = 0.0f;
    }
}

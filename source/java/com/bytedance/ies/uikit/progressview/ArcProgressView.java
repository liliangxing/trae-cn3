package com.bytedance.ies.uikit.progressview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ugc.uikit.R;
import com.ttnet.org.chromium.net.NetError;

/* loaded from: classes4.dex */
public class ArcProgressView extends View {
    private int mBackgroud;
    private RectF mBigOval;
    private Paint mPaint;
    private int mProgress;
    private int mRadius;
    private int mSweepingColor;
    private Paint mSweepingPaint;

    public ArcProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRadius = 50;
        this.mProgress = 0;
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcProgressView, i, 0);
        this.mBackgroud = obtainStyledAttributes.getColor(R.styleable.ArcProgressView_background_color, resources.getColor(R.color.arc_progress_background));
        this.mSweepingColor = obtainStyledAttributes.getColor(R.styleable.ArcProgressView_sweeping_color, resources.getColor(R.color.arc_progress_sweeping_color));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ArcProgressView_radius, resources.getDimensionPixelSize(R.dimen.arc_progress_radius));
        this.mRadius = dimensionPixelSize;
        if (dimensionPixelSize < 50) {
            this.mRadius = 50;
        }
        obtainStyledAttributes.recycle();
        init();
    }

    public ArcProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArcProgressView(Context context) {
        super(context);
        this.mRadius = 50;
        this.mProgress = 0;
        Resources resources = context.getResources();
        this.mBackgroud = resources.getColor(R.color.arc_progress_background);
        this.mSweepingColor = resources.getColor(R.color.arc_progress_sweeping_color);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.arc_progress_radius);
        this.mRadius = dimensionPixelSize;
        if (dimensionPixelSize < 50) {
            this.mRadius = 50;
        }
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mBackgroud);
        this.mPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mSweepingPaint = paint2;
        paint2.setColor(this.mSweepingColor);
        this.mPaint.setAntiAlias(true);
        this.mBigOval = new RectF();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (this.mRadius * 2) + getPaddingTop() + getPaddingBottom();
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int paddingTop = (this.mRadius * 2) + getPaddingTop() + getPaddingBottom();
        return mode == Integer.MIN_VALUE ? Math.min(paddingTop, size) : paddingTop;
    }

    public void setProgress(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.mProgress = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        int width = getWidth() - (this.mRadius * 2);
        this.mBigOval.set(width / 2, (getHeight() - (this.mRadius * 2)) / 2, r1 + (r3 * 2), r2 + (r3 * 2));
        int i = ((int) ((this.mProgress / 100.0d) * 360.0d)) + 0;
        if (i > 360) {
            i += NetError.ERR_HTTP2_INADEQUATE_TRANSPORT_SECURITY;
        }
        canvas.drawArc(this.mBigOval, 0, i, true, this.mSweepingPaint);
    }
}

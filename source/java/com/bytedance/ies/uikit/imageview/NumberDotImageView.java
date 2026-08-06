package com.bytedance.ies.uikit.imageview;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;

/* loaded from: classes4.dex */
public class NumberDotImageView extends ImageView {
    private static final int DOT_RADIUS = 8;
    private static final int SPACE = 5;
    private static final int UNSELECTED_DOT_RADIUS = 3;
    private Context mContext;
    private int mCurrentPosition;
    private int mDotRadius;
    private int mMaxNumber;
    private Paint mSelectPaint;
    private int mSelfHeight;
    private int mSpace;
    private Paint mUnSelectPaint;
    private int mUnSelectedDotRadius;

    public NumberDotImageView(Context context) {
        super(context);
        this.mMaxNumber = 0;
        this.mCurrentPosition = 0;
        this.mContext = context;
        init();
    }

    public NumberDotImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxNumber = 0;
        this.mCurrentPosition = 0;
        this.mContext = context;
        init();
    }

    public NumberDotImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxNumber = 0;
        this.mCurrentPosition = 0;
        this.mContext = context;
        init();
    }

    private void init() {
        this.mSpace = (int) UIUtils.dip2Px(this.mContext, 5.0f);
        this.mDotRadius = (int) UIUtils.dip2Px(this.mContext, 8.0f);
        this.mUnSelectedDotRadius = (int) UIUtils.dip2Px(this.mContext, 3.0f);
        refreshWidthHeight();
        Paint paint = new Paint();
        this.mUnSelectPaint = paint;
        paint.setAntiAlias(true);
        this.mUnSelectPaint.setColor(getResources().getColor(R.color.white));
        this.mUnSelectPaint.setAlpha(125);
        Paint paint2 = new Paint();
        this.mSelectPaint = paint2;
        paint2.reset();
        this.mSelectPaint.setAntiAlias(true);
        this.mSelectPaint.setColor(getResources().getColor(R.color.black));
        this.mSelectPaint.setAlpha(255);
        invalidate();
    }

    private void refreshWidthHeight() {
        int i = (this.mDotRadius * 2) + 4;
        this.mSelfHeight = i;
        setMaxHeight(i);
        setMinimumHeight(this.mSelfHeight);
    }

    public void refresh(int i, int i2) {
        if (i2 >= i) {
            return;
        }
        this.mMaxNumber = i;
        this.mCurrentPosition = i2;
        refreshWidthHeight();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        while (true) {
            int i2 = this.mMaxNumber;
            if (i >= i2) {
                return;
            }
            int i3 = this.mDotRadius;
            int i4 = i2 * 2 * i3;
            int i5 = i2 + (-1) >= 0 ? i2 - 1 : 0;
            int i6 = this.mSpace;
            int width = ((getWidth() / 2) - ((i4 + (i5 * i6)) / 2)) + (((i3 * 2) + i6) * i) + i3;
            int i7 = this.mDotRadius + 2;
            if (i == this.mCurrentPosition) {
                this.mSelectPaint.reset();
                this.mSelectPaint.setColor(-1);
                this.mSelectPaint.setAlpha(255);
                this.mSelectPaint.setAntiAlias(true);
                this.mSelectPaint.setStyle(Paint.Style.STROKE);
                this.mSelectPaint.setStrokeWidth(2.0f);
                canvas.drawCircle(width, i7, this.mDotRadius, this.mSelectPaint);
                this.mSelectPaint.reset();
                this.mSelectPaint.setColor(-1);
                this.mSelectPaint.setAlpha(255);
                this.mSelectPaint.setAntiAlias(true);
                this.mSelectPaint.setTextSize(this.mDotRadius * 2);
                int i8 = this.mDotRadius;
                canvas.drawText((i + 1) + "", width - (i8 / 2), i7 + ((i8 * 2) / 3), this.mSelectPaint);
            } else {
                this.mUnSelectPaint.reset();
                this.mUnSelectPaint.setColor(-1);
                this.mUnSelectPaint.setAlpha(200);
                this.mSelectPaint.setAntiAlias(true);
                canvas.drawCircle(width, i7, this.mUnSelectedDotRadius, this.mUnSelectPaint);
            }
            i++;
        }
    }
}

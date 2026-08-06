package com.bytedance.ies.uikit.imageview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ugc.uikit.R;

/* loaded from: classes4.dex */
public class DotImageView extends ImageView {
    private static final int DOT_RADIUS = 4;
    private static final int SPACE = 4;
    private Context mContext;
    private int mCurrentPosition;
    private int mDotRadius;
    private int mMaxNumber;
    private Paint mSelectPaint;
    private int mSelfHeight;
    private int mSpace;
    private Paint mUnSelectPaint;

    public DotImageView(Context context) {
        super(context);
        this.mMaxNumber = 0;
        this.mCurrentPosition = 0;
        this.mContext = context;
        init();
    }

    public DotImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxNumber = 0;
        this.mCurrentPosition = 0;
        this.mContext = context;
        init();
    }

    public DotImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxNumber = 0;
        this.mCurrentPosition = 0;
        this.mContext = context;
        init();
    }

    private void init() {
        this.mSpace = (int) UIUtils.dip2Px(this.mContext, 4.0f);
        this.mDotRadius = (int) UIUtils.dip2Px(this.mContext, 4.0f);
        refreshWidthHeight();
        this.mUnSelectPaint = new Paint();
        resetUnSelectPaint();
        this.mSelectPaint = new Paint();
        resetSelectPaint();
        invalidate();
    }

    private void resetUnSelectPaint() {
        this.mUnSelectPaint.setAntiAlias(true);
        this.mUnSelectPaint.setColor(getResources().getColor(R.color.dot_unselect_color));
    }

    private void resetSelectPaint() {
        this.mSelectPaint.reset();
        this.mSelectPaint.setAntiAlias(true);
        this.mSelectPaint.setColor(getResources().getColor(R.color.dot_select_color));
    }

    private void refreshWidthHeight() {
        int i = this.mDotRadius * 2;
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
            int i7 = this.mDotRadius;
            if (i == this.mCurrentPosition) {
                canvas.drawCircle(width, i7, i7, this.mSelectPaint);
            } else {
                canvas.drawCircle(width, i7, i7, this.mUnSelectPaint);
            }
            i++;
        }
    }
}

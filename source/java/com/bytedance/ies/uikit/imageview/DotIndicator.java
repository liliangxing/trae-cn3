package com.bytedance.ies.uikit.imageview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ugc.uikit.R;

/* loaded from: classes4.dex */
public class DotIndicator extends ImageView {
    private static final int DOT_RADIUS = 4;
    private static final int SPACE = 4;
    protected Context mContext;
    protected int mCurrentPosition;
    private int mDotRadius;
    protected int mMaxNumber;
    protected int mSelectedColor;
    protected Paint mSelectedPaint;
    private int mSelfHeight;
    private int mSelfWidth;
    private int mSpace;
    protected int mUnSelectedColor;
    protected Paint mUnSelectedPaint;

    public DotIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxNumber = 0;
        this.mCurrentPosition = 0;
        this.mContext = context;
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DotIndicator, i, 0);
        this.mSelectedColor = obtainStyledAttributes.getColor(R.styleable.DotIndicator_selected_color, resources.getColor(R.color.dot_select_color));
        this.mUnSelectedColor = obtainStyledAttributes.getColor(R.styleable.DotIndicator_unselected_color, resources.getColor(R.color.dot_unselect_color));
        this.mSpace = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DotIndicator_space, (int) UIUtils.dip2Px(this.mContext, 4.0f));
        this.mDotRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DotIndicator_dot_radius, (int) UIUtils.dip2Px(this.mContext, 4.0f));
        obtainStyledAttributes.recycle();
        init();
    }

    public DotIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotIndicator(Context context) {
        super(context);
        this.mMaxNumber = 0;
        this.mCurrentPosition = 0;
        this.mContext = context;
        init();
    }

    protected void init() {
        refreshWidthHeight();
        Paint paint = new Paint();
        this.mUnSelectedPaint = paint;
        paint.setAntiAlias(true);
        this.mUnSelectedPaint.setColor(this.mUnSelectedColor);
        Paint paint2 = new Paint();
        this.mSelectedPaint = paint2;
        paint2.setAntiAlias(true);
        this.mSelectedPaint.setColor(this.mSelectedColor);
        invalidate();
    }

    protected void refreshWidthHeight() {
        int i = this.mDotRadius;
        int i2 = i * 2;
        this.mSelfHeight = i2;
        int i3 = this.mMaxNumber;
        this.mSelfWidth = (i3 * 2 * i) + ((i3 + (-1) >= 0 ? i3 - 1 : 0) * this.mSpace);
        setMaxHeight(i2);
        setMinimumHeight(this.mSelfHeight);
        setMinimumWidth(this.mSelfWidth);
    }

    public void setDotRadius(int i) {
        this.mDotRadius = i;
    }

    public void setSpace(int i) {
        this.mSpace = i;
    }

    public void setSelectedColor(int i) {
        this.mSelectedColor = i;
        this.mSelectedPaint.setColor(i);
    }

    public void setUnSelectedColor(int i) {
        this.mUnSelectedColor = i;
        this.mUnSelectedPaint.setColor(i);
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

    public void setCurrentPosition(int i) {
        if (i >= this.mMaxNumber) {
            return;
        }
        this.mCurrentPosition = i;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawIndicator(canvas);
    }

    protected void drawIndicator(Canvas canvas) {
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
                canvas.drawCircle(width, i7, i7, this.mSelectedPaint);
            } else {
                canvas.drawCircle(width, i7, i7, this.mUnSelectedPaint);
            }
            i++;
        }
    }
}

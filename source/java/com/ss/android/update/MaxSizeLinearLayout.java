package com.ss.android.update;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes7.dex */
public class MaxSizeLinearLayout extends LinearLayout {
    private int mMaxHeight;
    private int mMaxWidth;

    public MaxSizeLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxWidth = 0;
        this.mMaxHeight = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxSizeLinearLayout, 0, 0);
        this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaxSizeLinearLayout_maxWidth, 0);
        this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaxSizeLinearLayout_maxHeight, 0);
        obtainStyledAttributes.recycle();
    }

    public MaxSizeLinearLayout(Context context) {
        super(context);
        this.mMaxWidth = 0;
        this.mMaxHeight = 0;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.mMaxWidth;
        if (i3 > 0 && i3 < size) {
            i = View.MeasureSpec.makeMeasureSpec(this.mMaxWidth, View.MeasureSpec.getMode(i));
        }
        int i4 = this.mMaxHeight;
        if (i4 > 0 && i4 < size2) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }
}

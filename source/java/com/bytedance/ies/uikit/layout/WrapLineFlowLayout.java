package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ugc.uikit.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class WrapLineFlowLayout extends ViewGroup {
    protected final boolean mAlignCenter;
    protected int mHSpacing;
    final ArrayList<LayoutParams> mTmpRow;
    protected int mVSpacing;

    public WrapLineFlowLayout(Context context) {
        this(context, null, 0);
    }

    public WrapLineFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WrapLineFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHSpacing = 0;
        this.mVSpacing = 0;
        this.mTmpRow = new ArrayList<>();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WrapLineFlowLayout, i, 0);
        this.mHSpacing = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.WrapLineFlowLayout_hSpacing, 0);
        this.mVSpacing = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.WrapLineFlowLayout_vSpacing, 0);
        this.mAlignCenter = obtainStyledAttributes.getBoolean(R.styleable.WrapLineFlowLayout_alignCenter, false);
        obtainStyledAttributes.recycle();
        if (this.mHSpacing < 0) {
            this.mHSpacing = 0;
        }
        if (this.mVSpacing < 0) {
            this.mVSpacing = 0;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int makeMeasureSpec;
        int i4;
        int i5;
        int makeMeasureSpec2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int i6 = 0;
        if (mode == 0) {
            size = 0;
        }
        int paddingLeft2 = (size - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        this.mTmpRow.clear();
        int i7 = paddingLeft2;
        int i8 = paddingLeft;
        int i9 = 0;
        int i10 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (paddingLeft2 <= 0) {
                i3 = paddingLeft;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
                layoutParams.x = i8;
                layoutParams.y = paddingTop;
                i5 = paddingLeft2;
                i4 = i6;
            } else {
                i3 = paddingLeft;
                if (layoutParams.width == -2) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft2, Integer.MIN_VALUE);
                } else if (layoutParams.width == -1) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                }
                if (layoutParams.height == -2) {
                    i4 = 0;
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    i5 = paddingLeft2;
                } else {
                    i4 = 0;
                    i5 = paddingLeft2;
                    if (layoutParams.height == -1) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
                    } else {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                    }
                }
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
                if (childAt.getMeasuredWidth() > i7) {
                    if (i10 > 0) {
                        paddingTop += i10 + this.mVSpacing;
                    }
                    if (this.mAlignCenter && i7 > 1 && !this.mTmpRow.isEmpty()) {
                        int i11 = i7 / 2;
                        Iterator<LayoutParams> it = this.mTmpRow.iterator();
                        while (it.hasNext()) {
                            it.next().x += i11;
                        }
                    }
                    this.mTmpRow.clear();
                    i10 = i4;
                    i8 = i3;
                    i7 = i5;
                }
                layoutParams.x = i8;
                layoutParams.y = paddingTop;
                if (this.mAlignCenter) {
                    this.mTmpRow.add(layoutParams);
                }
                int measuredWidth = childAt.getMeasuredWidth() + this.mHSpacing;
                i8 += measuredWidth;
                i7 -= measuredWidth;
                if (childAt.getMeasuredHeight() > i10) {
                    i10 = childAt.getMeasuredHeight();
                }
            }
            i9++;
            i6 = i4;
            paddingLeft = i3;
            paddingLeft2 = i5;
        }
        if (this.mAlignCenter && i7 > 1 && !this.mTmpRow.isEmpty()) {
            int i12 = i7 / 2;
            Iterator<LayoutParams> it2 = this.mTmpRow.iterator();
            while (it2.hasNext()) {
                it2.next().x += i12;
            }
        }
        if (i10 > 0) {
            paddingTop += i10;
        }
        if (mode2 == 0) {
            size2 = paddingTop + getPaddingBottom();
        } else if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, paddingTop + getPaddingBottom());
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.x, layoutParams.y, layoutParams.x + childAt.getMeasuredWidth(), layoutParams.y + childAt.getMeasuredHeight());
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams.width, layoutParams.height);
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int x;
        public int y;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }
}

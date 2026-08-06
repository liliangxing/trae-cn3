package com.lynx.tasm.behavior.p000ui.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.utils.PixelUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class SwiperView extends FrameLayout implements IDrawChildHook.IDrawChildHookBinding {
    public static final boolean DEBUG = false;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final String TAG = "LynxSwiperUI#SwiperView";
    private IDrawChildHook mDrawChildHook;
    private final int mIndicatorSize;
    private final LinearLayout mIndicators;
    private int mOrientation;
    private int mSelectedColor;
    private int mSelectedIndex;
    private int mUnselectedColor;
    private final ViewPager mViewPager;

    public SwiperView(Context context) {
        this(context, null);
    }

    public SwiperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedColor = XSwiperUI.SELECTED_COLOR;
        this.mUnselectedColor = XSwiperUI.UNSELECTED_COLOR;
        this.mSelectedIndex = 0;
        this.mOrientation = 0;
        this.mIndicatorSize = (int) PixelUtils.dipToPx(7.0f);
        ViewPager viewPager = new ViewPager(context);
        this.mViewPager = viewPager;
        addView(viewPager, new FrameLayout.LayoutParams(-1, -1));
        this.mIndicators = new LinearLayout(context);
        updateIndicators(0);
    }

    private void updateIndicators(int i) {
        FrameLayout.LayoutParams layoutParams;
        if (i == 1) {
            this.mIndicators.setGravity(16);
            this.mIndicators.setOrientation(1);
            layoutParams = new FrameLayout.LayoutParams(-2, -1);
            layoutParams.rightMargin = (int) PixelUtils.dipToPx(10.0f);
            layoutParams.gravity = 8388629;
        } else {
            this.mIndicators.setGravity(17);
            this.mIndicators.setOrientation(0);
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = (int) PixelUtils.dipToPx(10.0f);
            layoutParams.gravity = 81;
        }
        addView(this.mIndicators, layoutParams);
        int childCount = this.mIndicators.getChildCount();
        this.mIndicators.removeAllViews();
        for (int i2 = 0; i2 < childCount; i2++) {
            addIndicator();
        }
        setSelectedInternal();
    }

    public ViewPager getViewPager() {
        return this.mViewPager;
    }

    public void addIndicator() {
        View view = new View(getContext());
        view.setClickable(false);
        int i = this.mIndicatorSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        if (this.mOrientation == 1) {
            int i2 = this.mIndicatorSize / 2;
            layoutParams.bottomMargin = i2;
            layoutParams.topMargin = i2;
        } else {
            int i3 = this.mIndicatorSize / 2;
            layoutParams.rightMargin = i3;
            layoutParams.leftMargin = i3;
        }
        this.mIndicators.addView(view, layoutParams);
        int childCount = this.mIndicators.getChildCount();
        int i4 = this.mSelectedColor;
        if (childCount == i4) {
            view.setBackground(createIndicatorDrawable(i4));
        } else {
            view.setBackground(createIndicatorDrawable(this.mUnselectedColor));
        }
    }

    public void removeIndicator() {
        if (this.mIndicators.getChildCount() > 0) {
            this.mIndicators.removeViewAt(0);
            setSelected(this.mSelectedIndex);
        }
    }

    private GradientDrawable createIndicatorDrawable(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    public void setSelectedColor(int i) {
        this.mSelectedColor = i;
        int childCount = this.mIndicators.getChildCount();
        do {
            childCount--;
            if (childCount <= -1) {
                return;
            }
        } while (childCount != this.mSelectedIndex);
        this.mIndicators.getChildAt(childCount).setBackground(createIndicatorDrawable(this.mSelectedColor));
    }

    public void setUnSelectedColor(int i) {
        this.mUnselectedColor = i;
        int childCount = this.mIndicators.getChildCount();
        while (true) {
            childCount--;
            if (childCount <= -1) {
                return;
            }
            if (childCount != this.mSelectedIndex) {
                this.mIndicators.getChildAt(childCount).setBackground(createIndicatorDrawable(this.mUnselectedColor));
            }
        }
    }

    public void setSelected(int i) {
        this.mSelectedIndex = i;
        setSelectedInternal();
    }

    private void setSelectedInternal() {
        int childCount = this.mIndicators.getChildCount();
        while (true) {
            childCount--;
            if (childCount <= -1) {
                return;
            }
            View childAt = this.mIndicators.getChildAt(childCount);
            if (childCount == this.mSelectedIndex) {
                childAt.setBackground(createIndicatorDrawable(this.mSelectedColor));
            } else {
                childAt.setBackground(createIndicatorDrawable(this.mUnselectedColor));
            }
        }
    }

    public void enableIndicator(boolean z) {
        this.mIndicators.setVisibility(z ? 0 : 8);
    }

    public void setIsRtl(boolean z) {
        if (z) {
            ViewCompat.setLayoutDirection(this.mIndicators, 1);
        } else {
            ViewCompat.setLayoutDirection(this.mIndicators, 0);
        }
        this.mViewPager.setIsRTL(z);
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
        LinearLayout linearLayout = this.mIndicators;
        if (linearLayout != null) {
            removeView(linearLayout);
            updateIndicators(i);
        }
        getViewPager().setOrientation(i);
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook iDrawChildHook) {
        this.mDrawChildHook = iDrawChildHook;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mDrawChildHook.beforeDispatchDraw(canvas);
        super.dispatchDraw(canvas);
    }
}

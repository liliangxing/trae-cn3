package com.bytedance.ies.uikit.menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ies.uikit.menu.SlidingMenu;
import com.bytedance.ugc.uikit.C1158R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CustomViewBehind extends ViewGroup {
    private static final int MARGIN_THRESHOLD = 15;
    private static final String TAG = "CustomViewBehind";
    private boolean mChildrenEnabled;
    private View mContent;
    private float mFadeDegree;
    private boolean mFadeEnabled;
    private final Paint mFadePaint;
    private int mMarginThreshold;
    private int mMode;
    private float mScrollScale;
    private View mSecondaryContent;
    private Drawable mSecondaryShadowDrawable;
    private int mSecondaryWidthOffset;
    private View mSelectedView;
    private Bitmap mSelectorDrawable;
    private boolean mSelectorEnabled;
    private Drawable mShadowDrawable;
    private int mShadowWidth;
    private int mTouchMode;
    private SlidingMenu.CanvasTransformer mTransformer;
    private CustomViewAbove mViewAbove;
    private int mWidthOffset;

    public CustomViewBehind(Context context) {
        this(context, null);
    }

    public CustomViewBehind(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchMode = 0;
        this.mFadePaint = new Paint();
        this.mSelectorEnabled = true;
        this.mMarginThreshold = (int) TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics());
    }

    public void setCustomViewAbove(CustomViewAbove customViewAbove) {
        this.mViewAbove = customViewAbove;
    }

    public void setCanvasTransformer(SlidingMenu.CanvasTransformer canvasTransformer) {
        this.mTransformer = canvasTransformer;
    }

    public void setWidthOffset(int i) {
        this.mWidthOffset = i;
        requestLayout();
    }

    public void setSecondaryWidthOffset(int i) {
        this.mSecondaryWidthOffset = i;
        requestLayout();
    }

    public int getBehindWidth() {
        return this.mContent.getWidth();
    }

    public int getSecondaryBehindWidth() {
        return this.mSecondaryContent.getWidth();
    }

    public void setContent(View view) {
        View view2 = this.mContent;
        if (view2 != null) {
            removeView(view2);
        }
        this.mContent = view;
        addView(view);
    }

    public View getContent() {
        return this.mContent;
    }

    public void setSecondaryContent(View view) {
        View view2 = this.mSecondaryContent;
        if (view2 != null) {
            removeView(view2);
        }
        this.mSecondaryContent = view;
        addView(view);
    }

    public View getSecondaryContent() {
        return this.mSecondaryContent;
    }

    public void setChildrenEnabled(boolean z) {
        this.mChildrenEnabled = z;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        if (this.mTransformer != null) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.mChildrenEnabled;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.mChildrenEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mTransformer != null) {
            canvas.save();
            this.mTransformer.transformCanvas(canvas, this.mViewAbove.getPercentOpen());
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.mContent.layout(0, 0, i5 - this.mWidthOffset, i6);
        View view = this.mSecondaryContent;
        if (view != null) {
            view.layout(0, 0, i5 - this.mSecondaryWidthOffset, i6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        int childMeasureSpec = getChildMeasureSpec(i, 0, defaultSize - this.mWidthOffset);
        int childMeasureSpec2 = getChildMeasureSpec(i2, 0, defaultSize2);
        this.mContent.measure(childMeasureSpec, childMeasureSpec2);
        if (this.mSecondaryContent != null) {
            this.mSecondaryContent.measure(getChildMeasureSpec(i, 0, defaultSize - this.mSecondaryWidthOffset), childMeasureSpec2);
        }
    }

    public void setMode(int i) {
        if (i == 0 || i == 1) {
            View view = this.mContent;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.mSecondaryContent;
            if (view2 != null) {
                view2.setVisibility(4);
            }
        }
        this.mMode = i;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setScrollScale(float f) {
        this.mScrollScale = f;
    }

    public float getScrollScale() {
        return this.mScrollScale;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.mShadowDrawable = drawable;
        invalidate();
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.mSecondaryShadowDrawable = drawable;
        invalidate();
    }

    public void setShadowWidth(int i) {
        this.mShadowWidth = i;
        invalidate();
    }

    public void setFadeEnabled(boolean z) {
        this.mFadeEnabled = z;
    }

    public void setFadeDegree(float f) {
        if (f > 1.0f || f < 0.0f) {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        }
        this.mFadeDegree = f;
    }

    public int getMenuPage(int i) {
        if (i > 1) {
            i = 2;
        } else if (i < 1) {
            i = 0;
        }
        int i2 = this.mMode;
        if (i2 == 0 && i > 1) {
            return 0;
        }
        if (i2 != 1 || i >= 1) {
            return i;
        }
        return 2;
    }

    public void scrollBehindTo(View view, int i, int i2) {
        int i3 = this.mMode;
        if (i3 == 0) {
            r2 = i >= view.getLeft() ? 4 : 0;
            scrollTo((int) ((i + getBehindWidth()) * this.mScrollScale), i2);
        } else if (i3 == 1) {
            r2 = i <= view.getLeft() ? 4 : 0;
            scrollTo((int) ((getSecondaryBehindWidth() - getWidth()) + ((i - getSecondaryBehindWidth()) * this.mScrollScale)), i2);
        } else if (i3 == 2) {
            this.mContent.setVisibility(i >= view.getLeft() ? 4 : 0);
            this.mSecondaryContent.setVisibility(i <= view.getLeft() ? 4 : 0);
            r2 = i == 0 ? 4 : 0;
            if (i <= view.getLeft()) {
                scrollTo((int) ((i + getBehindWidth()) * this.mScrollScale), i2);
            } else {
                scrollTo((int) ((getSecondaryBehindWidth() - getWidth()) + ((i - getSecondaryBehindWidth()) * this.mScrollScale)), i2);
            }
        }
        if (r2 == 4) {
            Log.v(TAG, "behind INVISIBLE");
        }
        setVisibility(r2);
    }

    public int getMenuLeft(View view, int i) {
        int i2 = this.mMode;
        if (i2 == 0) {
            if (i == 0) {
                return view.getLeft() - getBehindWidth();
            }
            if (i == 2) {
                return view.getLeft();
            }
        } else if (i2 == 1) {
            if (i == 0) {
                return view.getLeft();
            }
            if (i == 2) {
                return view.getLeft() + getSecondaryBehindWidth();
            }
        } else if (i2 == 2) {
            if (i == 0) {
                return view.getLeft() - getBehindWidth();
            }
            if (i == 2) {
                return view.getLeft() + getSecondaryBehindWidth();
            }
        }
        return view.getLeft();
    }

    public int getAbsLeftBound(View view) {
        int i = this.mMode;
        if (i == 0 || i == 2) {
            return view.getLeft() - getBehindWidth();
        }
        if (i == 1) {
            return view.getLeft();
        }
        return 0;
    }

    public int getAbsRightBound(View view) {
        int i = this.mMode;
        if (i == 0) {
            return view.getLeft();
        }
        if (i == 1 || i == 2) {
            return view.getLeft() + getSecondaryBehindWidth();
        }
        return 0;
    }

    public boolean marginTouchAllowed(View view, int i) {
        int left = view.getLeft();
        int right = view.getRight();
        int i2 = this.mMode;
        if (i2 == 0) {
            return i >= left && i <= this.mMarginThreshold + left;
        }
        if (i2 == 1) {
            return i <= right && i >= right - this.mMarginThreshold;
        }
        if (i2 == 2) {
            return (i >= left && i <= this.mMarginThreshold + left) || (i <= right && i >= right - this.mMarginThreshold);
        }
        return false;
    }

    public void setTouchMode(int i) {
        this.mTouchMode = i;
    }

    public boolean menuOpenTouchAllowed(View view, int i, float f) {
        int i2 = this.mTouchMode;
        if (i2 != 0) {
            return i2 == 1;
        }
        return menuTouchInQuickReturn(view, i, f);
    }

    public boolean menuTouchInQuickReturn(View view, int i, float f) {
        int i2 = this.mMode;
        return (i2 == 0 || (i2 == 2 && i == 0)) ? f >= ((float) view.getLeft()) : (i2 == 1 || (i2 == 2 && i == 2)) && f <= ((float) view.getRight());
    }

    public boolean menuClosedSlideAllowed(float f) {
        int i = this.mMode;
        return i == 0 ? f > 0.0f : i == 1 ? f < 0.0f : i == 2;
    }

    public boolean menuOpenSlideAllowed(float f) {
        int i = this.mMode;
        return i == 0 ? f < 0.0f : i == 1 ? f > 0.0f : i == 2;
    }

    public void drawShadow(View view, Canvas canvas) {
        int i;
        int left;
        int i2;
        if (this.mShadowDrawable == null || this.mShadowWidth <= 0) {
            return;
        }
        int i3 = this.mMode;
        if (i3 == 0) {
            left = view.getLeft();
            i2 = this.mShadowWidth;
        } else {
            if (i3 == 1) {
                i = view.getRight();
            } else if (i3 == 2) {
                if (this.mSecondaryShadowDrawable != null) {
                    int right = view.getRight();
                    this.mSecondaryShadowDrawable.setBounds(right, 0, this.mShadowWidth + right, getHeight());
                    this.mSecondaryShadowDrawable.draw(canvas);
                }
                left = view.getLeft();
                i2 = this.mShadowWidth;
            } else {
                i = 0;
            }
            this.mShadowDrawable.setBounds(i, 0, this.mShadowWidth + i, getHeight());
            this.mShadowDrawable.draw(canvas);
        }
        i = left - i2;
        this.mShadowDrawable.setBounds(i, 0, this.mShadowWidth + i, getHeight());
        this.mShadowDrawable.draw(canvas);
    }

    public void drawFade(View view, Canvas canvas, float f) {
        int i;
        int right;
        int secondaryBehindWidth;
        if (this.mFadeEnabled) {
            int i2 = 0;
            this.mFadePaint.setColor(Color.argb((int) (this.mFadeDegree * 255.0f * Math.abs(1.0f - f)), 0, 0, 0));
            int i3 = this.mMode;
            if (i3 == 0) {
                i2 = view.getLeft() - getBehindWidth();
                i = view.getLeft();
            } else {
                if (i3 == 1) {
                    i2 = view.getRight();
                    right = view.getRight();
                    secondaryBehindWidth = getSecondaryBehindWidth();
                } else if (i3 == 2) {
                    canvas.drawRect(view.getLeft() - getSecondaryBehindWidth(), 0.0f, view.getLeft(), getHeight(), this.mFadePaint);
                    i2 = view.getRight();
                    right = view.getRight();
                    secondaryBehindWidth = getSecondaryBehindWidth();
                } else {
                    i = 0;
                }
                i = right + secondaryBehindWidth;
            }
            canvas.drawRect(i2, 0.0f, i, getHeight(), this.mFadePaint);
        }
    }

    public void drawSelector(View view, Canvas canvas, float f) {
        View view2;
        if (this.mSelectorEnabled && this.mSelectorDrawable != null && (view2 = this.mSelectedView) != null && ((String) view2.getTag(C1158R.id.selected_view)).equals("CustomViewBehindSelectedView")) {
            canvas.save();
            int width = (int) (this.mSelectorDrawable.getWidth() * f);
            int i = this.mMode;
            if (i == 0) {
                int left = view.getLeft();
                int i2 = left - width;
                canvas.clipRect(i2, 0, left, getHeight());
                canvas.drawBitmap(this.mSelectorDrawable, i2, getSelectorTop(), (Paint) null);
            } else if (i == 1) {
                int right = view.getRight();
                canvas.clipRect(right, 0, width + right, getHeight());
                canvas.drawBitmap(this.mSelectorDrawable, r7 - r5.getWidth(), getSelectorTop(), (Paint) null);
            }
            canvas.restore();
        }
    }

    public void setSelectorEnabled(boolean z) {
        this.mSelectorEnabled = z;
    }

    public void setSelectedView(View view) {
        View view2 = this.mSelectedView;
        if (view2 != null) {
            view2.setTag(C1158R.id.selected_view, null);
            this.mSelectedView = null;
        }
        if (view == null || view.getParent() == null) {
            return;
        }
        this.mSelectedView = view;
        view.setTag(C1158R.id.selected_view, "CustomViewBehindSelectedView");
        invalidate();
    }

    private int getSelectorTop() {
        return this.mSelectedView.getTop() + ((this.mSelectedView.getHeight() - this.mSelectorDrawable.getHeight()) / 2);
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.mSelectorDrawable = bitmap;
        refreshDrawableState();
    }
}

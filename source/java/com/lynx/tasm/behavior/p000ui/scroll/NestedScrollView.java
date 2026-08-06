package com.lynx.tasm.behavior.p000ui.scroll;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Field;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NestedScrollView extends ScrollView implements NestedScrollingParent2, NestedScrollingChild2 {
    private static final String TAG = "LynxNestedScrollView";
    protected BounceGestureHelper mBounceGestureHelper;
    private NestedScrollingChildHelper mChildHelper;
    protected boolean mEnableNewBounce;
    private boolean mEnableNewNested;
    private int mLastFlingScrollY;
    private NestedScrollingParentHelper mParentHelper;
    private final int[] mScrollConsumed;
    private UIScrollView mUIScrollView;
    private OverScroller mVScroller;

    public NestedScrollView(Context context, UIScrollView uIScrollView) {
        super(context);
        this.mEnableNewNested = false;
        this.mEnableNewBounce = false;
        this.mScrollConsumed = new int[2];
        this.mUIScrollView = uIScrollView;
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        this.mBounceGestureHelper = new BounceGestureHelper(this, true, this.mParentHelper);
        setNestedScrollingEnabled(true);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            return bounceGestureHelper.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            return bounceGestureHelper.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        OverScroller vScroller;
        LLog.i(TAG, "fling with vel = " + i);
        if (!this.mEnableNewNested || (vScroller = getVScroller()) == null) {
            super.fling(i);
        } else if (getChildCount() > 0) {
            startNestedScroll(2, 1);
            vScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            ViewCompat.postInvalidateOnAnimation(this);
            this.mLastFlingScrollY = getScrollY();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        OverScroller vScroller;
        if (!this.mEnableNewNested || (vScroller = getVScroller()) == null) {
            super.computeScroll();
            return;
        }
        if (vScroller.computeScrollOffset()) {
            int currY = vScroller.getCurrY();
            int i = currY - this.mLastFlingScrollY;
            if (dispatchNestedPreScroll(0, i, this.mScrollConsumed, null, 1)) {
                i -= this.mScrollConsumed[1];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = this.mUIScrollView.getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY + i2;
                boolean z = i3 < 0 || i3 > scrollRange;
                int clamp = MathUtils.clamp(i3, 0, scrollRange);
                if (z && !hasNestedScrollingParent(1)) {
                    vScroller.springBack(0, clamp, 0, 0, 0, scrollRange);
                }
                super.scrollTo(getScrollX(), clamp);
                int scrollY2 = getScrollY() - scrollY;
                dispatchNestedScroll(0, scrollY2, 0, i2 - scrollY2, null, 1);
            }
            this.mLastFlingScrollY = currY;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (hasNestedScrollingParent(1)) {
            stopNestedScroll(1);
        }
        this.mLastFlingScrollY = 0;
        BounceGestureHelper bounceGestureHelper = this.mBounceGestureHelper;
        if (bounceGestureHelper == null || !this.mEnableNewBounce) {
            return;
        }
        bounceGestureHelper.checkNestedStateByDeadLine();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void smoothScrollToInternal(int i, int i2) {
        if (this.mEnableNewNested && getVScroller() != null) {
            this.mLastFlingScrollY = getScrollY();
        }
        super.smoothScrollTo(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OverScroller getVScroller() {
        OverScroller overScroller = this.mVScroller;
        if (overScroller != null) {
            return overScroller;
        }
        try {
            Field declaredField = ScrollView.class.getDeclaredField("mScroller");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                if (obj instanceof OverScroller) {
                    this.mVScroller = (OverScroller) obj;
                }
            }
        } catch (IllegalAccessException unused) {
            LLog.e(TAG, "Failed to get mScroller of ScrollView!");
        } catch (NoSuchFieldException unused2) {
            LLog.e(TAG, "Failed to get mScroller field of ScrollView!");
        }
        return this.mVScroller;
    }

    public void setEnableNewNested(boolean z) {
        this.mEnableNewNested = z;
    }

    public void setEnableNewBounce(boolean z) {
        this.mEnableNewBounce = z;
    }

    public void setBounceScrollRange(int i, int i2) {
        BounceGestureHelper bounceGestureHelper = this.mBounceGestureHelper;
        if (bounceGestureHelper != null) {
            if (i != bounceGestureHelper.getScrollRange() || i2 != this.mBounceGestureHelper.getBounceScrollRange()) {
                requestLayout();
            }
            this.mBounceGestureHelper.setScrollRange(i);
            this.mBounceGestureHelper.setBounceScrollRange(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPagingTouchSlopIfNeeded() {
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            Field declaredField = ScrollView.class.getDeclaredField("mTouchSlop");
            if (viewConfiguration == null || declaredField == null) {
                return;
            }
            int scaledPagingTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(scaledPagingTouchSlop));
        } catch (IllegalAccessException unused) {
            LLog.e(TAG, "Failed to get mTouchSlop field of NestedScrollView!");
        } catch (NoSuchFieldException unused2) {
            LLog.e(TAG, "Failed to get mTouchSlop field of NestedScrollView!");
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.mChildHelper.hasNestedScrollingParent(i);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean startNestedScroll(int i, int i2) {
        return this.mChildHelper.startNestedScroll(i, i2);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public void stopNestedScroll(int i) {
        this.mChildHelper.stopNestedScroll(i);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        BounceGestureHelper bounceGestureHelper;
        if (!this.mEnableNewBounce || (bounceGestureHelper = this.mBounceGestureHelper) == null) {
            return (i & 2) != 0;
        }
        return bounceGestureHelper.onStartNestedScroll(view, view2, i, i2);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            bounceGestureHelper.onNestedScrollAccepted(view, view2, i, i2);
        } else {
            this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
            startNestedScroll(2, i2);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            bounceGestureHelper.onStopNestedScroll(view, i);
        } else {
            this.mParentHelper.onStopNestedScroll(view, i);
            stopNestedScroll(i);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            bounceGestureHelper.onNestedScroll(view, i, i2, i3, i4, i5);
            return;
        }
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null, i5);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            bounceGestureHelper.onNestedPreScroll(view, i, i2, iArr, i3);
        } else {
            dispatchNestedPreScroll(i, i2, iArr, null, i3);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null, 0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            return bounceGestureHelper.onNestedFling(view, f, f2, z);
        }
        boolean z2 = false;
        if (z) {
            return false;
        }
        int scrollY = getScrollY();
        int scrollRange = this.mUIScrollView.getScrollRange();
        if ((scrollY > 0 || f2 > 0.0f) && (scrollY < scrollRange || f2 < 0.0f)) {
            z2 = true;
        }
        if (!dispatchNestedPreFling(0.0f, f2)) {
            dispatchNestedFling(0.0f, f2, z2);
            fling((int) f2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            return bounceGestureHelper.onNestedPreFling(view, f, f2);
        }
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }
}

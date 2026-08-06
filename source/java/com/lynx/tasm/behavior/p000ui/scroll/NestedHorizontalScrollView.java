package com.lynx.tasm.behavior.p000ui.scroll;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import java.lang.reflect.Field;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NestedHorizontalScrollView extends HorizontalScrollView implements NestedScrollingParent2, NestedScrollingChild2 {
    public static final boolean DEBUG_GESTURE = false;
    private static final int INVALID_POINTER = -1;
    private static final String TAG = "LynxNestedHorizontalScrollView";
    private int mActivePointerId;
    protected BounceGestureHelper mBounceGestureHelper;
    private NestedScrollingChildHelper mChildHelper;
    protected boolean mEnableNewBounce;
    protected boolean mEnableNewNested;
    private OverScroller mHScroller;
    private boolean mIsBeingDragged;
    private int mLastFlingScrollX;
    private int mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedXOffset;
    private NestedScrollingParentHelper mParentHelper;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private int mTouchSlop;
    private UIScrollView mUIScrollView;
    private VelocityTracker mVelocityTracker;

    public NestedHorizontalScrollView(Context context, UIScrollView uIScrollView) {
        super(context);
        this.mEnableNewNested = false;
        this.mIsBeingDragged = false;
        this.mEnableNewBounce = false;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mUIScrollView = uIScrollView;
        initHorizontalScrollView();
    }

    private void initHorizontalScrollView() {
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        this.mBounceGestureHelper = new BounceGestureHelper(this, false, this.mParentHelper);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPagingTouchSlopIfNeeded() {
        try {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            Field declaredField = HorizontalScrollView.class.getDeclaredField("mTouchSlop");
            if (viewConfiguration == null || declaredField == null) {
                return;
            }
            int scaledPagingTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(scaledPagingTouchSlop));
            this.mTouchSlop = scaledPagingTouchSlop;
        } catch (IllegalAccessException unused) {
            LLog.e(TAG, "Failed to get mTouchSlop field of HorizontalScrollView!");
        } catch (NoSuchFieldException unused2) {
            LLog.e(TAG, "Failed to get mTouchSlop field of HorizontalScrollView!");
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        BounceGestureHelper bounceGestureHelper;
        if (!this.mEnableNewNested) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            return bounceGestureHelper.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            if (!inChild(x, (int) motionEvent.getY())) {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            } else {
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mLastMotionX = x;
                OverScroller hScroller = getHScroller();
                if (hScroller != null) {
                    hScroller.computeScrollOffset();
                    this.mIsBeingDragged = !getHScroller().isFinished();
                }
                startNestedScroll(1, 0);
            }
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.mActivePointerId;
                    if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                        int x2 = (int) motionEvent.getX(findPointerIndex);
                        if (Math.abs(x2 - this.mLastMotionX) > this.mTouchSlop && (getNestedScrollAxes() & 1) == 0) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionX = x2;
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mNestedXOffset = 0;
                        }
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            int scrollRange = this.mUIScrollView.getScrollRange();
            if (getHScroller() != null && getHScroller().springBack(getScrollX(), getScrollY(), 0, scrollRange, 0, 0)) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            stopNestedScroll(0);
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        BounceGestureHelper bounceGestureHelper;
        if (!this.mEnableNewNested) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            return bounceGestureHelper.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        initVelocityTrackerIfNotExists();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            this.mNestedXOffset = 0;
        }
        obtain.offsetLocation(this.mNestedXOffset, 0.0f);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int i = -((int) velocityTracker.getXVelocity(this.mActivePointerId));
                int scrollRange = this.mUIScrollView.getScrollRange();
                OverScroller hScroller = getHScroller();
                if (getChildCount() > 0) {
                    if (Math.abs(i) > this.mMinimumVelocity) {
                        if ((getScrollX() > 0 || i > 0) && (getScrollX() < scrollRange || i < 0)) {
                            z = true;
                        }
                        float f = i;
                        if (!dispatchNestedPreFling(f, 0.0f)) {
                            dispatchNestedFling(f, 0.0f, z);
                            fling(i);
                        }
                    } else if (hScroller != null && hScroller.springBack(getScrollX(), getScrollY(), 0, scrollRange, 0, 0)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
                endDrag();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    int x = (int) motionEvent.getX(findPointerIndex);
                    int i2 = this.mLastMotionX - x;
                    if (dispatchNestedPreScroll(i2, 0, this.mScrollConsumed, this.mScrollOffset, 0)) {
                        i2 -= this.mScrollConsumed[0];
                        obtain.offsetLocation(this.mScrollOffset[0], 0.0f);
                        this.mNestedXOffset += this.mScrollOffset[0];
                    }
                    if (!this.mIsBeingDragged && Math.abs(i2) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        if (i2 > 0) {
                            i2 -= this.mTouchSlop;
                        } else {
                            i2 += this.mTouchSlop;
                        }
                    }
                    if (this.mIsBeingDragged) {
                        this.mLastMotionX = x - this.mScrollOffset[0];
                        int scrollRange2 = this.mUIScrollView.getScrollRange();
                        int scrollX = getScrollX();
                        int i3 = scrollX + i2;
                        boolean z2 = i3 < 0 || i3 > scrollRange2;
                        int clamp = MathUtils.clamp(i3, 0, scrollRange2);
                        OverScroller hScroller2 = getHScroller();
                        if (z2 && !hasNestedScrollingParent(1) && hScroller2 != null) {
                            hScroller2.springBack(clamp, 0, 0, scrollRange2, 0, 0);
                        }
                        super.scrollTo(clamp, getScrollY());
                        if (z2 && !hasNestedScrollingParent(0)) {
                            this.mVelocityTracker.clear();
                        }
                        int scrollX2 = getScrollX() - scrollX;
                        if (dispatchNestedScroll(scrollX2, 0, i2 - scrollX2, 0, this.mScrollOffset, 0)) {
                            int i4 = this.mLastMotionX;
                            int i5 = this.mScrollOffset[0];
                            this.mLastMotionX = i4 - i5;
                            this.mNestedXOffset += i5;
                            obtain.offsetLocation(i5, 0.0f);
                        }
                    }
                }
            } else if (actionMasked == 3) {
                int scrollRange3 = this.mUIScrollView.getScrollRange();
                OverScroller hScroller3 = getHScroller();
                if (this.mIsBeingDragged && getChildCount() > 0 && hScroller3 != null && hScroller3.springBack(getScrollX(), getScrollY(), 0, scrollRange3, 0, 0)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                endDrag();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.mLastMotionX = (int) motionEvent.getX(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 != -1) {
                    this.mLastMotionX = (int) motionEvent.getX(findPointerIndex2);
                }
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            OverScroller hScroller4 = getHScroller();
            if (hScroller4 != null) {
                boolean z3 = !hScroller4.isFinished();
                this.mIsBeingDragged = z3;
                if (z3 && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                hScroller4.abortAnimation();
            }
            this.mLastMotionX = (int) motionEvent.getX();
            this.mActivePointerId = motionEvent.getPointerId(0);
            startNestedScroll(1, 0);
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i) {
        OverScroller hScroller;
        if (!this.mEnableNewNested || (hScroller = getHScroller()) == null) {
            super.fling(i);
        } else if (getChildCount() > 0) {
            startNestedScroll(1, 1);
            hScroller.fling(getScrollX(), getScrollY(), i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0, 0);
            ViewCompat.postInvalidateOnAnimation(this);
            this.mLastFlingScrollX = getScrollX();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void computeScroll() {
        OverScroller hScroller;
        if (!this.mEnableNewNested || (hScroller = getHScroller()) == null) {
            super.computeScroll();
            return;
        }
        if (hScroller.computeScrollOffset()) {
            int currX = hScroller.getCurrX();
            int i = currX - this.mLastFlingScrollX;
            if (dispatchNestedPreScroll(i, 0, this.mScrollConsumed, null, 1)) {
                i -= this.mScrollConsumed[0];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = this.mUIScrollView.getScrollRange();
                int scrollX = getScrollX();
                int i3 = scrollX + i2;
                boolean z = i3 < 0 || i3 > scrollRange;
                int clamp = MathUtils.clamp(i3, 0, scrollRange);
                if (z && !hasNestedScrollingParent(1)) {
                    hScroller.springBack(clamp, 0, 0, scrollRange, 0, 0);
                }
                super.scrollTo(clamp, getScrollY());
                int scrollX2 = getScrollX() - scrollX;
                dispatchNestedScroll(scrollX2, 0, i2 - scrollX2, 0, null, 1);
            }
            this.mLastFlingScrollX = currX;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (hasNestedScrollingParent(1)) {
            stopNestedScroll(1);
        }
        this.mLastFlingScrollX = 0;
        BounceGestureHelper bounceGestureHelper = this.mBounceGestureHelper;
        if (bounceGestureHelper == null || !this.mEnableNewBounce) {
            return;
        }
        bounceGestureHelper.checkNestedStateByDeadLine();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void smoothScrollToInternal(int i, int i2) {
        if (this.mEnableNewNested && getHScroller() != null) {
            this.mLastFlingScrollX = getScrollX();
        }
        super.smoothScrollTo(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OverScroller getHScroller() {
        OverScroller overScroller = this.mHScroller;
        if (overScroller != null) {
            return overScroller;
        }
        try {
            Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                if (obj instanceof OverScroller) {
                    this.mHScroller = (OverScroller) obj;
                }
            }
        } catch (IllegalAccessException unused) {
            LLog.e(TAG, "Failed to get mScroller of HorizontalScrollView!");
        } catch (NoSuchFieldException unused2) {
            LLog.e(TAG, "Failed to get mScroller field of HorizontalScrollView!");
        }
        return this.mHScroller;
    }

    private boolean inChild(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollX = getScrollX();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() && i2 < childAt.getBottom() && i >= childAt.getLeft() - scrollX && i < childAt.getRight() - scrollX;
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = (int) motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        recycleVelocityTracker();
        stopNestedScroll(0);
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
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        BounceGestureHelper bounceGestureHelper;
        if (!this.mEnableNewBounce || (bounceGestureHelper = this.mBounceGestureHelper) == null) {
            return (i & 1) != 0;
        }
        return bounceGestureHelper.onStartNestedScroll(view, view2, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            bounceGestureHelper.onNestedScrollAccepted(view, view2, i, i2);
        } else {
            this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
            startNestedScroll(1, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            bounceGestureHelper.onNestedScroll(view, i, i2, i3, i4, i5);
            return;
        }
        int scrollX = getScrollX();
        scrollBy(i3, 0);
        int scrollX2 = getScrollX() - scrollX;
        dispatchNestedScroll(scrollX2, 0, i3 - scrollX2, 0, null, i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        BounceGestureHelper bounceGestureHelper;
        if (this.mEnableNewBounce && (bounceGestureHelper = this.mBounceGestureHelper) != null) {
            return bounceGestureHelper.onNestedFling(view, f, f2, z);
        }
        boolean z2 = false;
        if (z) {
            return false;
        }
        int scrollX = getScrollX();
        int scrollRange = this.mUIScrollView.getScrollRange();
        if ((scrollX > 0 || f > 0.0f) && (scrollX < scrollRange || f < 0.0f)) {
            z2 = true;
        }
        if (!dispatchNestedPreFling(f, 0.0f)) {
            dispatchNestedFling(f, 0.0f, z2);
            fling((int) f);
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

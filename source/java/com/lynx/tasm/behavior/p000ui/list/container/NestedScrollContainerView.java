package com.lynx.tasm.behavior.p000ui.list.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.list.LynxSnapHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NestedScrollContainerView extends FrameLayout implements NestedScrollingParent2, NestedScrollingChild2 {
    private static final boolean DEBUG = false;
    private static final int INVALID_POINTER = -1;
    public static final float LIST_AUTOMATIC_MAX_FLING_RATIO = Float.MAX_VALUE;
    public static final int SCROLL_STATE_DRAGGING = 2;
    public static final int SCROLL_STATE_FLING = 3;
    public static final int SCROLL_STATE_IDLE = 1;
    public static final int SCROLL_STATE_SCROLL_ANIMATION = 4;
    private static final String TAG = "UIListContainer.NestedScrollContainerView";
    static final Interpolator sQuinticInterpolator = new Interpolator() { // from class: com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private int mInitialMotionX;
    private int mInitialMotionY;
    public boolean mIsDuringAutoScroll;
    private boolean mIsVertical;
    private int mLastMotionX;
    private int mLastMotionY;
    private float mMaxFlingDistanceRatio;
    private int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private final int[] mNestedOffsets;
    protected ArrayList<OnScrollListener> mOnScrollListeners;
    private ArrayList<OnScrollStateChangeListener> mOnScrollStateChangeListeners;
    private final NestedScrollingParentHelper mParentHelper;
    private final int[] mScrollConsumed;
    protected ScrollHelper mScrollHelper;
    private final int[] mScrollOffset;
    private int mScrollState;
    private final int[] mScrollStepConsumed;
    public LynxSnapHelper mSnapHelper;
    private final int[] mTargetScrollOffset;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnScrollListener {
        void onScrollChange(int i, int i2, int i3, int i4);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnScrollStateChangeListener {
        void onScrollStateChange(NestedScrollContainerView nestedScrollContainerView, int i);
    }

    private int clampScrollDelta(int i, int i2, int i3) {
        int i4 = i2 + i;
        return i4 < 0 ? -i2 : i4 > i3 ? i3 - i2 : i;
    }

    protected boolean isRtl() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onGestureRecognizedDuringNestedScroll(boolean z) {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class CustomScrollHook {
        public void onSmoothScrollEnd() {
        }

        public void onSmoothScrollStart(int i, int i2, int i3, int i4) {
        }

        public void onSmoothScroll(int i, int i2, int[] iArr) {
            iArr[0] = i;
            iArr[1] = i2;
        }
    }

    public NestedScrollContainerView(Context context) {
        this(context, null);
    }

    public NestedScrollContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSnapHelper = null;
        this.mIsVertical = true;
        this.mTouchSlop = 0;
        this.mMinFlingVelocity = 0;
        this.mMaxFlingVelocity = 0;
        this.mScrollState = 1;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        this.mNestedOffsets = new int[2];
        this.mScrollStepConsumed = new int[2];
        this.mTargetScrollOffset = new int[2];
        this.mOnScrollStateChangeListeners = new ArrayList<>();
        this.mOnScrollListeners = new ArrayList<>();
        this.mMaxFlingDistanceRatio = -1.0f;
        this.mIsDuringAutoScroll = false;
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        this.mScrollHelper = new ScrollHelper();
        setNestedScrollingEnabled(true);
        initScrollView();
    }

    private void initScrollView() {
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastMotionX = x;
            this.mInitialMotionX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastMotionY = y;
            this.mInitialMotionY = y;
            int i = this.mScrollState;
            if (i == 3 || i == 4) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(2);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            startNestedScroll(getNestedScrollAxis(), 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                if (findPointerIndex < 0) {
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                if (this.mScrollState != 2) {
                    int i3 = x2 - this.mInitialMotionX;
                    boolean z = this.mIsVertical && Math.abs(y2 - this.mInitialMotionY) > this.mTouchSlop && (getNestedScrollAxes() & 2) == 0;
                    boolean z2 = !this.mIsVertical && Math.abs(i3) > this.mTouchSlop && (getNestedScrollAxes() & 1) == 0;
                    if (z || z2) {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        setScrollState(2);
                    }
                }
            }
        } else if (actionMasked == 3) {
            resetTouch();
            setScrollState(1);
        } else if (actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastMotionX = x3;
            this.mInitialMotionX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastMotionY = y3;
            this.mInitialMotionY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.mNestedOffsets;
        obtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastMotionX = x;
            this.mInitialMotionX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastMotionY = y;
            this.mInitialMotionY = y;
            startNestedScroll(getNestedScrollAxis(), 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.addMovement(obtain);
            this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
            if (!flingWithNestedDispatch((int) (!this.mIsVertical ? -this.mVelocityTracker.getXVelocity(this.mActivePointerId) : 0.0f), (int) (this.mIsVertical ? -this.mVelocityTracker.getYVelocity(this.mActivePointerId) : 0.0f)) && !this.mScrollHelper.paging()) {
                setScrollState(1);
            }
            resetTouch();
            z = true;
        } else if (actionMasked == 2) {
            int i = this.mActivePointerId;
            if (i != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i);
                if (findPointerIndex < 0) {
                    return false;
                }
                int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                int i2 = this.mLastMotionX - x2;
                int i3 = this.mLastMotionY - y2;
                if (dispatchNestedPreScroll(i2, i3, this.mScrollConsumed, this.mScrollOffset, 0)) {
                    int[] iArr3 = this.mScrollConsumed;
                    i2 -= iArr3[0];
                    i3 -= iArr3[1];
                    int[] iArr4 = this.mScrollOffset;
                    obtain.offsetLocation(iArr4[0], iArr4[1]);
                    int[] iArr5 = this.mNestedOffsets;
                    int i4 = iArr5[0];
                    int[] iArr6 = this.mScrollOffset;
                    iArr5[0] = i4 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                }
                if (this.mScrollState != 2) {
                    if (this.mIsVertical) {
                        int abs = Math.abs(i3);
                        int i5 = this.mTouchSlop;
                        if (abs > i5) {
                            i3 = i3 > 0 ? i3 - i5 : i3 + i5;
                            setScrollState(2);
                        }
                    }
                    if (!this.mIsVertical) {
                        int abs2 = Math.abs(i2);
                        int i6 = this.mTouchSlop;
                        if (abs2 > i6) {
                            i2 = i2 > 0 ? i2 - i6 : i2 + i6;
                            setScrollState(2);
                        }
                    }
                }
                if (this.mScrollState == 2) {
                    int[] iArr7 = this.mScrollOffset;
                    this.mLastMotionX = x2 - iArr7[0];
                    this.mLastMotionY = y2 - iArr7[1];
                    boolean z2 = this.mIsVertical;
                    if (z2) {
                        i2 = 0;
                    }
                    if (!z2) {
                        i3 = 0;
                    }
                    if (scrollByInternal(i2, i3, obtain)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
        } else if (actionMasked == 3) {
            resetTouch();
            setScrollState(1);
        } else if (actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastMotionX = x3;
            this.mInitialMotionX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastMotionY = y3;
            this.mInitialMotionY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (!z) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int[] iArr = this.mScrollStepConsumed;
        iArr[0] = 0;
        iArr[1] = 0;
        scrollStep(i, i2, iArr);
        int[] iArr2 = this.mScrollStepConsumed;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        if (dispatchNestedScroll(i3, i4, i - i3, i2 - i4, this.mScrollOffset, 0)) {
            int i5 = this.mLastMotionX;
            int[] iArr3 = this.mScrollOffset;
            int i6 = iArr3[0];
            this.mLastMotionX = i5 - i6;
            int i7 = this.mLastMotionY;
            int i8 = iArr3[1];
            this.mLastMotionY = i7 - i8;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i6, i8);
            }
            int[] iArr4 = this.mNestedOffsets;
            int i9 = iArr4[0];
            int[] iArr5 = this.mScrollOffset;
            iArr4[0] = i9 + iArr5[0];
            iArr4[1] = iArr4[1] + iArr5[1];
        }
        int[] iArr6 = this.mScrollStepConsumed;
        return (iArr6[0] == 0 && iArr6[1] == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollStep(int i, int i2, int[] iArr) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int clampScrollDelta = clampScrollDelta(i, scrollX, this.mIsVertical ? 0 : scrollRange);
        if (!this.mIsVertical) {
            scrollRange = 0;
        }
        int clampScrollDelta2 = clampScrollDelta(i2, scrollY, scrollRange);
        if (Math.abs(clampScrollDelta) > 0 || Math.abs(clampScrollDelta2) > 0) {
            super.scrollTo(scrollX + clampScrollDelta, scrollY + clampScrollDelta2);
        }
        if (iArr != null) {
            iArr[0] = clampScrollDelta;
            iArr[1] = clampScrollDelta2;
        }
    }

    private boolean flingWithNestedDispatch(int i, int i2) {
        if (this.mIsVertical || Math.abs(i) < this.mMinFlingVelocity) {
            i = 0;
        }
        if (!this.mIsVertical || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (dispatchNestedPreFling(f, f2)) {
            return false;
        }
        dispatchNestedFling(f, f2, true);
        startNestedScroll(getNestedScrollAxis(), 1);
        int i3 = this.mMaxFlingVelocity;
        int max = Math.max(-i3, Math.min(i, i3));
        int i4 = this.mMaxFlingVelocity;
        this.mScrollHelper.fling(max, Math.max(-i4, Math.min(i2, i4)));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setScrollState(int i) {
        LLog.i(TAG, "setScrollState: " + this.mScrollState + " -> " + i);
        if (i == this.mScrollState) {
            return;
        }
        if (this.mIsDuringAutoScroll && i == 1) {
            return;
        }
        this.mScrollState = i;
        if (i != 3 && i != 4) {
            this.mScrollHelper.stop();
        }
        dispatchOnScrollStateChanged(i);
    }

    public void smoothScrollTo(int i, int i2) {
        this.mScrollHelper.smoothScrollTo(i, i2);
    }

    public void stopFling() {
        this.mScrollHelper.stopFling();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class ScrollHelper implements Runnable {
        private CustomScrollHook mCustomScrollHook;
        private int mLastScrollX;
        private int mLastScrollY;
        private ListCustomScroller mScroller;
        private int mTotalDeltaX;
        private int mTotalDeltaY;

        public ScrollHelper() {
            this.mScroller = new ListCustomScroller(NestedScrollContainerView.this.getContext(), NestedScrollContainerView.sQuinticInterpolator);
        }

        private float getAvailableScrollOffsetFromSubviews(boolean z) {
            float x;
            int width;
            boolean z2 = NestedScrollContainerView.this.mIsVertical;
            float f = Float.MAX_VALUE;
            float f2 = Float.MIN_VALUE;
            if (NestedScrollContainerView.this.getChildCount() > 0) {
                int i = 0;
                if (NestedScrollContainerView.this.getChildAt(0) instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) NestedScrollContainerView.this.getChildAt(0);
                    if (z) {
                        while (i < viewGroup.getChildCount()) {
                            View childAt = viewGroup.getChildAt(i);
                            if (z2) {
                                x = childAt.getY();
                                width = childAt.getHeight();
                            } else {
                                x = childAt.getX();
                                width = childAt.getWidth();
                            }
                            float f3 = x + width;
                            if (f2 < f3) {
                                f2 = f3;
                            }
                            i++;
                        }
                        f2 -= z2 ? NestedScrollContainerView.this.getHeight() : NestedScrollContainerView.this.getWidth();
                    } else {
                        while (i < viewGroup.getChildCount()) {
                            View childAt2 = viewGroup.getChildAt(i);
                            float y = z2 ? childAt2.getY() : childAt2.getX();
                            if (f > y) {
                                f = y;
                            }
                            i++;
                        }
                    }
                }
            }
            return z ? f2 : f;
        }

        public void fling(int i, int i2) {
            float height;
            float f;
            NestedScrollContainerView.this.setScrollState(3);
            this.mCustomScrollHook = null;
            this.mLastScrollX = NestedScrollContainerView.this.getScrollX();
            this.mLastScrollY = NestedScrollContainerView.this.getScrollY();
            this.mTotalDeltaX = 0;
            this.mTotalDeltaY = 0;
            if (NestedScrollContainerView.this.mSnapHelper != null) {
                pagingInternal(i, i2);
            } else if (NestedScrollContainerView.this.mMaxFlingDistanceRatio > 0.0f) {
                float f2 = NestedScrollContainerView.this.mIsVertical ? this.mLastScrollY : this.mLastScrollX;
                if (NestedScrollContainerView.this.mMaxFlingDistanceRatio != Float.MAX_VALUE) {
                    height = NestedScrollContainerView.this.mMaxFlingDistanceRatio * (NestedScrollContainerView.this.mIsVertical ? NestedScrollContainerView.this.getHeight() : NestedScrollContainerView.this.getWidth());
                    f = height;
                } else {
                    height = getAvailableScrollOffsetFromSubviews(true) - f2;
                    f = f2 - getAvailableScrollOffsetFromSubviews(false);
                }
                this.mScroller.fling(this.mLastScrollX, this.mLastScrollY, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, (int) height, (int) f);
            } else {
                this.mScroller.fling(this.mLastScrollX, this.mLastScrollY, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
            postOnAnimationCompat();
        }

        public boolean paging() {
            if (NestedScrollContainerView.this.mSnapHelper == null || NestedScrollContainerView.this.mScrollState == 1) {
                return false;
            }
            NestedScrollContainerView.this.setScrollState(3);
            this.mCustomScrollHook = null;
            this.mLastScrollX = NestedScrollContainerView.this.getScrollX();
            this.mLastScrollY = NestedScrollContainerView.this.getScrollY();
            this.mTotalDeltaX = 0;
            this.mTotalDeltaY = 0;
            pagingInternal(0, 0);
            postOnAnimationCompat();
            return true;
        }

        private void pagingInternal(int i, int i2) {
            int[] findTargetSnapOffset = NestedScrollContainerView.this.mSnapHelper.findTargetSnapOffset(i, i2, NestedScrollContainerView.this.mIsVertical, NestedScrollContainerView.this.isRtl());
            int i3 = findTargetSnapOffset[0] - this.mLastScrollX;
            int i4 = findTargetSnapOffset[1] - this.mLastScrollY;
            int ceil = (int) (Math.ceil(Math.ceil(Math.abs(NestedScrollContainerView.this.mIsVertical ? i4 : i3) * NestedScrollContainerView.this.mSnapHelper.mSnapAlignmentMillisecondsPerPx)) / 0.3356d);
            this.mScroller.startScroll(this.mLastScrollX, this.mLastScrollY, i3, i4, ceil < 100 ? 100 : ceil);
        }

        public void stopFling() {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            this.mLastScrollX = 0;
            this.mLastScrollY = 0;
            this.mTotalDeltaX = 0;
            this.mTotalDeltaY = 0;
        }

        public void smoothScrollTo(int i, int i2) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            NestedScrollContainerView.this.setScrollState(4);
            this.mLastScrollX = NestedScrollContainerView.this.getScrollX();
            int scrollY = NestedScrollContainerView.this.getScrollY();
            this.mLastScrollY = scrollY;
            CustomScrollHook customScrollHook = this.mCustomScrollHook;
            if (customScrollHook != null) {
                customScrollHook.onSmoothScrollStart(this.mLastScrollX, scrollY, i, i2);
            }
            ListCustomScroller listCustomScroller = this.mScroller;
            int i3 = this.mLastScrollX;
            int i4 = this.mLastScrollY;
            listCustomScroller.startScroll(i3, i4, i - i3, i2 - i4);
            postOnAnimationCompat();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            NestedScrollContainerView.this.removeCallbacks(this);
            this.mScroller.abortAnimation();
            CustomScrollHook customScrollHook = this.mCustomScrollHook;
            if (customScrollHook != null) {
                customScrollHook.onSmoothScrollEnd();
                this.mCustomScrollHook = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            ListCustomScroller listCustomScroller = this.mScroller;
            if (listCustomScroller.computeScrollOffset()) {
                int[] iArr = NestedScrollContainerView.this.mScrollConsumed;
                int currX = listCustomScroller.getCurrX();
                int currY = listCustomScroller.getCurrY();
                if (this.mCustomScrollHook != null) {
                    int[] iArr2 = NestedScrollContainerView.this.mTargetScrollOffset;
                    this.mCustomScrollHook.onSmoothScroll(currX, currY, iArr2);
                    i2 = iArr2[0];
                    i = iArr2[1];
                } else {
                    int i3 = currX - this.mTotalDeltaX;
                    i = currY - this.mTotalDeltaY;
                    i2 = i3;
                }
                int i4 = i2 - this.mLastScrollX;
                int i5 = i - this.mLastScrollY;
                if (NestedScrollContainerView.this.dispatchNestedPreScroll(i4, i5, iArr, null, 1)) {
                    i4 -= iArr[0];
                    i5 -= iArr[1];
                }
                NestedScrollContainerView.this.mScrollStepConsumed[0] = 0;
                NestedScrollContainerView.this.mScrollStepConsumed[1] = 0;
                NestedScrollContainerView nestedScrollContainerView = NestedScrollContainerView.this;
                nestedScrollContainerView.scrollStep(i4, i5, nestedScrollContainerView.mScrollStepConsumed);
                int i6 = NestedScrollContainerView.this.mScrollStepConsumed[0];
                int i7 = NestedScrollContainerView.this.mScrollStepConsumed[1];
                int i8 = i4 - i6;
                int i9 = i5 - i7;
                NestedScrollContainerView.this.dispatchNestedScroll(i6, i7, i8, i9, null, 1);
                if (!((!NestedScrollContainerView.this.mIsVertical && (i4 == 0 || (i4 != 0 && i8 == 0))) || (NestedScrollContainerView.this.mIsVertical && (i5 == 0 || (i5 != 0 && i9 == 0)))) && !NestedScrollContainerView.this.hasNestedScrollingParent(1)) {
                    NestedScrollContainerView.this.setScrollState(1);
                }
                this.mLastScrollX = NestedScrollContainerView.this.getScrollX();
                int scrollY = NestedScrollContainerView.this.getScrollY();
                this.mLastScrollY = scrollY;
                this.mTotalDeltaX += i2 - this.mLastScrollX;
                this.mTotalDeltaY += i - scrollY;
                postOnAnimationCompat();
                return;
            }
            NestedScrollContainerView.this.setScrollState(1);
            if (NestedScrollContainerView.this.hasNestedScrollingParent(1)) {
                NestedScrollContainerView.this.stopNestedScroll(1);
            }
            this.mLastScrollX = 0;
            this.mLastScrollY = 0;
            this.mTotalDeltaX = 0;
            this.mTotalDeltaY = 0;
            CustomScrollHook customScrollHook = this.mCustomScrollHook;
            if (customScrollHook != null) {
                customScrollHook.onSmoothScrollEnd();
            }
        }

        private void postOnAnimationCompat() {
            NestedScrollContainerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(NestedScrollContainerView.this, this);
        }
    }

    public int getScrollRange() {
        int width;
        int width2;
        int paddingRight;
        if (getChildCount() <= 0 || getChildAt(0) == null) {
            return 0;
        }
        View childAt = getChildAt(0);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.mIsVertical) {
            width = childAt.getHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
            width2 = getHeight() - getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            width = childAt.getWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin;
            width2 = getWidth() - getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        return Math.max(0, width - (width2 - paddingRight));
    }

    public boolean canScrollBy(int i) {
        int scrollX = getScrollX() + (this.mIsVertical ? 0 : i);
        int scrollY = getScrollY();
        if (!this.mIsVertical) {
            i = 0;
        }
        int i2 = scrollY + i;
        int scrollRange = getScrollRange();
        if (this.mIsVertical) {
            if (i2 <= 0 || i2 >= scrollRange) {
                return false;
            }
        } else if (scrollX <= 0 || scrollX >= scrollRange) {
            return false;
        }
        return true;
    }

    private int getNestedScrollAxis() {
        return this.mIsVertical ? 2 : 1;
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mActivePointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastMotionX = x;
            this.mInitialMotionX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastMotionY = y;
            this.mInitialMotionY = y;
        }
    }

    private void resetTouch() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
    }

    public void setIsVertical(boolean z) {
        this.mIsVertical = z;
    }

    public void setCustomScrollHook(CustomScrollHook customScrollHook) {
        ScrollHelper scrollHelper = this.mScrollHelper;
        if (scrollHelper != null) {
            scrollHelper.mCustomScrollHook = customScrollHook;
        }
    }

    public CustomScrollHook getCustomScrollHook() {
        ScrollHelper scrollHelper = this.mScrollHelper;
        if (scrollHelper != null) {
            return scrollHelper.mCustomScrollHook;
        }
        return null;
    }

    private void dispatchOnScrollStateChanged(int i) {
        Iterator<OnScrollStateChangeListener> it = this.mOnScrollStateChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollStateChange(this, i);
        }
    }

    public void addOnScrollStateChangeListener(OnScrollStateChangeListener onScrollStateChangeListener) {
        this.mOnScrollStateChangeListeners.add(onScrollStateChangeListener);
    }

    public void removeOnScrollStateChangeListener(OnScrollStateChangeListener onScrollStateChangeListener) {
        this.mOnScrollStateChangeListeners.remove(onScrollStateChangeListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListeners.add(onScrollListener);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListeners.remove(onScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearOnScrollListeners() {
        this.mOnScrollListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearOnScrollStateChangeListeners() {
        this.mOnScrollStateChangeListeners.clear();
    }

    public void setMaxFlingDistanceRatio(float f) {
        this.mMaxFlingDistanceRatio = f;
    }

    public void setEnableScroll(final boolean z) {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return !z;
            }
        });
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return !this.mIsVertical && super.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.mIsVertical && super.canScrollVertically(i);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.mIsVertical) {
            return 0;
        }
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        if (getChildCount() <= 0 || getChildAt(0) == null) {
            return width;
        }
        View childAt = getChildAt(0);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return width;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        return childAt.getWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        if (!this.mIsVertical) {
            return 0;
        }
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (getChildCount() <= 0 || getChildAt(0) == null) {
            return height;
        }
        View childAt = getChildAt(0);
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            return height;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        return childAt.getHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        if (this.mIsVertical) {
            return 0;
        }
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        if (this.mIsVertical) {
            return Math.max(0, super.computeVerticalScrollOffset());
        }
        return 0;
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
        boolean dispatchNestedPreScroll = this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        onGestureRecognizedDuringNestedScroll(dispatchNestedPreScroll);
        return dispatchNestedPreScroll;
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
        return this.mIsVertical ? (i & 2) != 0 : (i & 1) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
        if (this.mIsVertical) {
            startNestedScroll(2, i2);
        } else {
            startNestedScroll(1, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.mParentHelper.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        int scrollRange = getScrollRange();
        if (this.mIsVertical) {
            int scrollY = getScrollY();
            scrollTo(getScrollX(), MathUtils.clamp(scrollY + i4, 0, scrollRange));
            int scrollY2 = getScrollY() - scrollY;
            dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null, i5);
            return;
        }
        int scrollX = getScrollX();
        scrollTo(MathUtils.clamp(scrollX + i3, 0, scrollRange), getScrollY());
        int scrollX2 = getScrollX() - scrollX;
        dispatchNestedScroll(scrollX2, 0, i3 - scrollX2, 0, null, i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        return flingWithNestedDispatch((int) f, (int) f2);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }
}

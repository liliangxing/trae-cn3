package com.lynx.tasm.behavior.p000ui.swiper;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    public static final boolean DEBUG = false;
    public static final boolean DEBUG_GESTURE = false;
    static final int INIT_ITEM_INDEX = -1;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final int INVALID_TOUCH_POINTER_ID = -1;
    public static final int SCROLL_DIRECTION_BEGIN = 0;
    public static final int SCROLL_DIRECTION_END = 1;
    static final int SCROLL_STATE_DRAGGING = 1;
    static final int SCROLL_STATE_IDLE = 0;
    static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "LynxSwiperUI#ViewPager";
    private boolean isRTL;
    private int mActivePointerId;
    private Adapter mAdapter;
    private int mAnimDuration;
    private float mBounceBeginThreshold;
    private int mBounceDuration;
    private float mBounceEndThreshold;
    private int mCloseEnough;
    private int mCurrentIndex;
    private final GestureDetector mDetector;
    private int mDragDistance;
    private boolean mEnableBounce;
    private boolean mEnableNestedChild;
    private boolean mEnableViceLoop;
    private int mExpectChildSize;
    private int mExpectOffset;
    private int mExpectSize;
    protected int mFinalPosition;
    private boolean mFling;
    private boolean mForceCanScroll;
    private boolean mHLayoutUpdated;
    private boolean mHandleGesture;
    private boolean mIgnoreLayoutUpdate;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private boolean mIsInit;
    private boolean mIsUnableToDrag;
    private boolean mKeepItemView;
    private float mLastX;
    private float mLastY;
    private boolean mLoop;
    private boolean mLoopChanged;
    private int mMaxScrollBoundary;
    private final int mMaxVelocityX;
    private final int mMaxVelocityY;
    private int mMinScrollBoundary;
    private int mOffset;
    private int mOldCurrentIndex;
    private int mOrientation;
    private int mPageMargin;
    private final List<OnPageScrollListener> mPageScrollListeners;
    private int mPageSize;
    private int mPendingCurrentIndex;
    private boolean mPendingSmoothScroll;
    private boolean mPropsUpdated;
    private boolean mReadyToScroll;
    private boolean mScrollInToBeginBounce;
    private boolean mScrollInToEndBounce;
    private int mScrollState;
    private final Scroller mScroller;
    private int mTotalCount;
    private final float mTouchSlop;
    private boolean mTouchable;
    private PageTransformer mTransformer;
    private boolean mTriggerBounceEvent;
    protected boolean mTriggerEvent;
    private boolean mVLayoutUpdated;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Adapter {
        View get(ViewGroup viewGroup, int i);

        int getCount();

        void recycle(ViewGroup viewGroup, int i, View view);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnPageScrollListener {
        void onPageChange(int i, int i2, boolean z);

        void onPageScrollEnd(int i);

        void onPageScrollStart(int i, boolean z);

        void onPageScrollStateChanged(int i, int i2);

        void onPageScrolling(int i, boolean z, float f, float f2);

        void onScrollToBounce(boolean z, boolean z2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface PageTransformer {
        void reset(View view);

        void transformPage(ViewPager viewPager, View view, boolean z, int i);
    }

    private String getStateName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "" : "STATE_SETTLING" : "STATE_DRAGGING" : "STATE_IDLE";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        int position;

        public LayoutParams() {
            super(-1, -1);
        }
    }

    public ViewPager(Context context) {
        this(context, null);
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPendingSmoothScroll = false;
        this.mHLayoutUpdated = false;
        this.mVLayoutUpdated = false;
        this.mPropsUpdated = false;
        this.mTotalCount = 0;
        this.mCurrentIndex = -1;
        this.mOldCurrentIndex = -1;
        this.mPendingCurrentIndex = -1;
        this.mTriggerEvent = false;
        this.mIsInit = true;
        this.mTouchable = true;
        this.mEnableNestedChild = false;
        this.mLoop = false;
        this.isRTL = false;
        this.mKeepItemView = false;
        this.mForceCanScroll = false;
        this.mEnableViceLoop = false;
        this.mLoopChanged = false;
        this.mAnimDuration = 300;
        this.mOrientation = 0;
        this.mScrollState = 0;
        this.mFling = false;
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        this.mReadyToScroll = false;
        this.mActivePointerId = -1;
        this.mDragDistance = 0;
        this.mCloseEnough = 0;
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mInitialMotionX = 0.0f;
        this.mInitialMotionY = 0.0f;
        this.mPageSize = -1;
        this.mOffset = 0;
        this.mExpectChildSize = -1;
        this.mExpectSize = -1;
        this.mExpectOffset = -1;
        this.mPageMargin = 0;
        this.mMinScrollBoundary = Integer.MIN_VALUE;
        this.mMaxScrollBoundary = Integer.MAX_VALUE;
        this.mEnableBounce = false;
        this.mScrollInToBeginBounce = false;
        this.mScrollInToEndBounce = false;
        this.mTriggerBounceEvent = false;
        this.mIgnoreLayoutUpdate = false;
        this.mHandleGesture = true;
        this.mBounceDuration = 300;
        this.mBounceBeginThreshold = -1.0f;
        this.mBounceEndThreshold = -1.0f;
        this.mFinalPosition = Integer.MIN_VALUE;
        this.mDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() { // from class: com.lynx.tasm.behavior.ui.swiper.ViewPager.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!ViewPager.this.mIsBeingDragged) {
                    if (motionEvent2.findPointerIndex(ViewPager.this.mActivePointerId) == -1) {
                        return super.onScroll(motionEvent, motionEvent2, f, f2);
                    }
                    float abs = Math.abs(f);
                    float abs2 = Math.abs(f2);
                    if ((!ViewPager.this.isVertical() || abs2 <= abs || !ViewPager.this.canScrollVerticallyInternal((int) f2)) && (ViewPager.this.isVertical() || abs <= abs2 || !ViewPager.this.canScrollHorizontallyInternal((int) f))) {
                        ViewPager.this.requestParentDisallowInterceptTouchEvent(false);
                    } else {
                        ViewPager.this.mIsBeingDragged = true;
                        ViewPager.this.setScrollState(1);
                        ViewPager.this.requestParentDisallowInterceptTouchEvent(true);
                    }
                }
                if (ViewPager.this.mIsBeingDragged) {
                    int findPointerIndex = motionEvent2.findPointerIndex(ViewPager.this.mActivePointerId);
                    float x = motionEvent2.getX(findPointerIndex);
                    float y = motionEvent2.getY(findPointerIndex);
                    float f3 = ViewPager.this.mLastX - x;
                    float f4 = ViewPager.this.mLastY - y;
                    ViewPager.this.mDragDistance = (int) (r0.mDragDistance + (ViewPager.this.isVertical() ? f4 : f3));
                    ViewPager.this.mLastX = x;
                    ViewPager.this.mLastY = y;
                    if (ViewPager.this.mReadyToScroll) {
                        ViewPager.this.triggerScrollStartEvent();
                        ViewPager.this.mReadyToScroll = false;
                    }
                    if (ViewPager.this.isVertical()) {
                        ViewPager.this.scrollBy(0, (int) (f4 + 0.5d));
                    } else {
                        ViewPager.this.scrollBy((int) (f3 + 0.5d), 0);
                    }
                }
                return ViewPager.this.mIsBeingDragged;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                boolean onFling = super.onFling(motionEvent, motionEvent2, f, f2);
                if ((ViewPager.this.isVertical() && f2 >= (-ViewPager.this.mMaxVelocityY) && f2 <= ViewPager.this.mMaxVelocityY) || (!ViewPager.this.isVertical() && f >= (-ViewPager.this.mMaxVelocityX) && f <= ViewPager.this.mMaxVelocityX)) {
                    return onFling;
                }
                ViewPager.this.mFling = true;
                ViewPager.this.mScroller.abortAnimation();
                ViewPager.this.flingToPosition(f, f2);
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                ViewPager.this.mScroller.abortAnimation();
                ViewPager.this.mDragDistance = 0;
                ViewPager.this.mReadyToScroll = true;
                ViewPager.this.mFling = false;
                ViewPager viewPager = ViewPager.this;
                viewPager.mLastX = viewPager.mInitialMotionX = motionEvent.getX();
                ViewPager viewPager2 = ViewPager.this;
                viewPager2.mLastY = viewPager2.mInitialMotionY = motionEvent.getY();
                ViewPager.this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                return true;
            }
        }, new Handler(Looper.getMainLooper()));
        float f = getResources().getDisplayMetrics().density;
        this.mScroller = new Scroller(context, new LinearInterpolator());
        int i = (int) (600.0f * f);
        this.mMaxVelocityY = i;
        this.mMaxVelocityX = i;
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mCloseEnough = (int) (f * 2.0f);
        this.mPageScrollListeners = new ArrayList();
    }

    public void setCurrentIndex(int i, boolean z, int i2) {
        int i3;
        boolean z2 = true;
        if (this.mTotalCount < 1 || getChildCount() < 1) {
            return;
        }
        int clamp = MathUtils.clamp(i, 0, this.mTotalCount - 1);
        View currentView = getCurrentView();
        int i4 = ((LayoutParams) currentView.getLayoutParams()).position;
        if (i4 == clamp) {
            return;
        }
        int childExpectSize = getChildExpectSize();
        int scrollDistance = getScrollDistance();
        int pile = getPile() + (childExpectSize / 2);
        int begin = ((getBegin(currentView) + getEnd(currentView)) / 2) - scrollDistance;
        int i5 = this.mPageMargin;
        int i6 = (clamp - i4) * (childExpectSize + i5);
        boolean z3 = this.mLoop;
        if (z3 || this.mEnableViceLoop) {
            if (i2 == 1) {
                if (clamp <= i4) {
                    i3 = this.mTotalCount + clamp;
                    i6 = (i3 - i4) * (childExpectSize + i5);
                }
                i3 = clamp;
                i6 = (i3 - i4) * (childExpectSize + i5);
            } else if (i2 == 0) {
                if (clamp > i4) {
                    i3 = clamp - this.mTotalCount;
                    i6 = (i3 - i4) * (childExpectSize + i5);
                }
                i3 = clamp;
                i6 = (i3 - i4) * (childExpectSize + i5);
            }
            if (!z3) {
                this.mLoopChanged = true;
                if ((i2 != 1 || clamp >= i4) && (i2 != 0 || clamp <= i4)) {
                    z2 = false;
                }
                this.mLoop = z2;
            }
        }
        triggerScrollStartEvent();
        if (isRTL()) {
            this.mScroller.startScroll(scrollDistance, 0, (begin - pile) - i6, 0, z ? this.mAnimDuration : 0);
        } else if (isVertical()) {
            this.mScroller.startScroll(0, scrollDistance, 0, (begin - pile) + i6, z ? this.mAnimDuration : 0);
        } else {
            this.mScroller.startScroll(scrollDistance, 0, i6 + (begin - pile), 0, z ? this.mAnimDuration : 0);
        }
        setScrollState(2);
        this.mFinalPosition = isVertical() ? this.mScroller.getFinalY() : this.mScroller.getFinalX();
        invalidate();
    }

    public void setAdapter(Adapter adapter) {
        if (this.mAdapter != null) {
            int childCount = getChildCount();
            while (true) {
                childCount--;
                if (childCount <= -1) {
                    break;
                } else {
                    recycleView(getChildAt(childCount), false);
                }
            }
        } else {
            removeAllViews();
        }
        this.mAdapter = adapter;
        if (adapter == null) {
            return;
        }
        this.mTotalCount = adapter.getCount();
    }

    public void setOffset(int i, boolean z) {
        this.mOffset = i;
        if (z) {
            if (isVertical()) {
                scrollTo(0, -i);
            } else {
                scrollTo(-i, 0);
            }
        }
    }

    protected void computeScrollPosition() {
        if (this.mAdapter == null || this.mTotalCount <= 0) {
            return;
        }
        boolean z = false;
        boolean z2 = this.mHLayoutUpdated || this.mVLayoutUpdated || this.mPropsUpdated;
        if (!this.mIgnoreLayoutUpdate || z2) {
            setOffset(this.mOffset, z2);
            int i = this.mPendingCurrentIndex;
            if (i != -1 && i != this.mCurrentIndex) {
                z = this.mPendingSmoothScroll;
            } else {
                i = this.mCurrentIndex;
                if (i == -1) {
                    i = -1;
                }
            }
            if (i < 0 || i >= this.mTotalCount) {
                return;
            }
            setCurrentIndex(i, z, 1);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mHLayoutUpdated || this.mVLayoutUpdated) {
            computeScrollPosition();
            this.mHLayoutUpdated = false;
            this.mVLayoutUpdated = false;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        reMeasureChildren();
        if (this.mPropsUpdated || this.mHLayoutUpdated || this.mVLayoutUpdated) {
            computeScrollPosition();
            this.mPropsUpdated = false;
            this.mHLayoutUpdated = false;
            this.mVLayoutUpdated = false;
            return;
        }
        relayoutChildren();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        super.setPadding(i, i2, i3, i4);
        if (isVertical()) {
            scrollBy(0, paddingLeft - i);
        } else {
            scrollBy(paddingLeft - i, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        setScrollState(0);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalStateException();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return (this.mTouchable && canScrollHorizontallyInternal(i)) || this.mForceCanScroll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScrollHorizontallyInternal(int i) {
        int i2;
        int i3;
        if (isVertical() || this.mAdapter == null || (i2 = this.mTotalCount) <= 1 || (i3 = this.mCurrentIndex) == -1) {
            return false;
        }
        if (!this.mLoop && (i <= 0 || (!this.isRTL ? i3 >= i2 - 1 : i3 <= 0))) {
            if (i >= 0) {
                return false;
            }
            if (this.isRTL) {
                if (i3 >= i2 - 1) {
                    return false;
                }
            } else if (i3 <= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return (this.mTouchable && canScrollVerticallyInternal(i)) || this.mForceCanScroll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScrollVerticallyInternal(int i) {
        int i2;
        int i3;
        if (!isVertical() || this.mAdapter == null || (i2 = this.mTotalCount) <= 1 || (i3 = this.mCurrentIndex) == -1) {
            return false;
        }
        return this.mLoop || (i > 0 && i3 < i2 - 1) || (i < 0 && i3 > 0);
    }

    private void reMeasureChildren() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount <= -1) {
                return;
            } else {
                measureChild(getChildAt(childCount));
            }
        }
    }

    private void measureChild(View view) {
        int makeMeasureSpec;
        int childHeightMeasureSpec;
        if (isVertical()) {
            makeMeasureSpec = getChildWidthMeasureSpec(view);
            childHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getChildExpectSize(), 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getChildExpectSize(), 1073741824);
            childHeightMeasureSpec = getChildHeightMeasureSpec(view);
        }
        view.measure(makeMeasureSpec, childHeightMeasureSpec);
    }

    private int getChildHeightMeasureSpec(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.height >= 0) {
            return View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        }
        int max = Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (layoutParams.height == -1) {
            return View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        }
        if (layoutParams.height == -2) {
            return View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }

    private int getChildWidthMeasureSpec(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.width >= 0) {
            return View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
        }
        int max = Math.max(0, (getWidth() - getPaddingLeft()) - getPaddingRight());
        if (layoutParams.width == -1) {
            return View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        }
        if (layoutParams.width == -2) {
            return View.MeasureSpec.makeMeasureSpec(max, Integer.MIN_VALUE);
        }
        return View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }

    private void relayoutChildren() {
        int childExpectSize;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int width;
        if (this.mTotalCount >= 1 && (childExpectSize = getChildExpectSize()) > 0) {
            int scrollDistance = getScrollDistance();
            int i8 = this.mPageMargin + childExpectSize;
            if (i8 <= 0) {
                return;
            }
            int i9 = scrollDistance / i8;
            int i10 = scrollDistance % i8;
            if (isRTL()) {
                if (this.mLoop) {
                    if (scrollDistance > 0) {
                        i9 = i10 != 0 ? i9 + 1 : i9 % this.mTotalCount;
                        width = ((getWidth() + scrollDistance) - i10) + (i10 == 0 ? 0 : this.mPageMargin + childExpectSize);
                    } else {
                        width = (getWidth() + scrollDistance) - i10;
                    }
                    int i11 = this.mTotalCount;
                    i = (i11 - i9) % i11;
                    if (i < 0) {
                        i += i11;
                    }
                    i3 = width;
                } else {
                    int paddingRight = getPaddingRight() - this.mOffset;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= this.mTotalCount - 1) {
                            i12 = 0;
                            break;
                        }
                        int i13 = i12 + 1;
                        if (scrollDistance < ((this.mMaxScrollBoundary - paddingRight) + getWidth()) - (i13 * i8)) {
                            break;
                        } else {
                            i12 = i13;
                        }
                    }
                    i3 = ((this.mMaxScrollBoundary - paddingRight) + getWidth()) - (i8 * i12);
                    i = i12;
                }
                i2 = 0;
            } else {
                if (!this.mLoop) {
                    int paddingLeft = getPaddingLeft() + this.mOffset;
                    i = 0;
                    while (true) {
                        if (i >= this.mTotalCount) {
                            i = 0;
                            break;
                        }
                        int i14 = i + 1;
                        if (scrollDistance < this.mMinScrollBoundary + paddingLeft + (i14 * i8)) {
                            break;
                        } else {
                            i = i14;
                        }
                    }
                    i2 = this.mMinScrollBoundary + paddingLeft + (i8 * i);
                } else if (scrollDistance < 0) {
                    if (i10 != 0) {
                        i9--;
                    }
                    int i15 = this.mTotalCount;
                    i = ((i9 % i15) + i15) % i15;
                    i2 = ((scrollDistance - (i10 == 0 ? -this.mPageMargin : childExpectSize)) - i10) - this.mPageMargin;
                } else {
                    i = i9 % this.mTotalCount;
                    i2 = scrollDistance - i10;
                }
                i3 = 0;
            }
            int max = Math.max(0, getPageGap()) + scrollDistance;
            List<View> arrayList = new ArrayList<>();
            if (!this.mKeepItemView) {
                List<View> allChildren = getAllChildren();
                while (true) {
                    View childByPosition = getChildByPosition(i);
                    allChildren.remove(childByPosition);
                    if (isRTL()) {
                        i2 = i3 - childExpectSize;
                    } else {
                        i3 = i2 + childExpectSize;
                    }
                    relayoutChild(childByPosition, i, i2, i3);
                    transformIfNeeded();
                    if (!isRTL()) {
                        if (i3 >= max) {
                            break;
                        }
                        i2 = this.mPageMargin + i3;
                        i6 = i + 1;
                        i7 = this.mTotalCount;
                        if (i6 < i7) {
                        }
                        i = i6 % i7;
                    } else {
                        if (i2 <= scrollDistance) {
                            break;
                        }
                        i3 = i2 - this.mPageMargin;
                        i6 = i + 1;
                        i7 = this.mTotalCount;
                        if (i6 < i7 && !this.mLoop) {
                            break;
                        } else {
                            i = i6 % i7;
                        }
                    }
                }
                arrayList = allChildren;
            } else {
                if (this.mLoop) {
                    int i16 = i;
                    do {
                        View childByPosition2 = getChildByPosition(i16);
                        if (isRTL()) {
                            i2 = i3 - childExpectSize;
                        } else {
                            i3 = i2 + childExpectSize;
                        }
                        if ((isRTL() && i3 <= scrollDistance) || (!isRTL() && i2 >= max)) {
                            arrayList.add(childByPosition2);
                        }
                        relayoutChild(childByPosition2, i16, i2, i3);
                        if (isRTL()) {
                            i3 = i2 - this.mPageMargin;
                        } else {
                            i2 = this.mPageMargin + i3;
                        }
                        i16 = (i16 + 1) % this.mTotalCount;
                    } while (i16 != i);
                } else {
                    int i17 = i2;
                    int i18 = i3;
                    for (int i19 = i - 1; i19 >= 0; i19--) {
                        View childByPosition3 = getChildByPosition(i19);
                        if (isRTL()) {
                            i5 = i18 + this.mPageMargin;
                            i4 = i5 + childExpectSize;
                        } else {
                            i4 = i17 - this.mPageMargin;
                            i5 = i4 - childExpectSize;
                        }
                        int i20 = i5;
                        i18 = i4;
                        i17 = i20;
                        if ((isRTL() && i17 - this.mPageMargin >= max) || (!isRTL() && this.mPageMargin + i18 <= scrollDistance)) {
                            arrayList.add(childByPosition3);
                        }
                        relayoutChild(childByPosition3, i19, i17, i18);
                    }
                    while (i < this.mTotalCount) {
                        View childByPosition4 = getChildByPosition(i);
                        if (isRTL()) {
                            i2 = i3 - childExpectSize;
                        } else {
                            i3 = i2 + childExpectSize;
                        }
                        if ((isRTL() && i3 <= scrollDistance) || (!isRTL() && i2 >= max)) {
                            arrayList.add(childByPosition4);
                        }
                        relayoutChild(childByPosition4, i, i2, i3);
                        if (isRTL()) {
                            i3 = i2 - this.mPageMargin;
                        } else {
                            i2 = this.mPageMargin + i3;
                        }
                        i++;
                    }
                }
                transformIfNeeded();
            }
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                recycleView(it.next(), this.mKeepItemView);
            }
        }
    }

    private void relayoutChild(View view, int i, int i2, int i3) {
        int paddingTop;
        int measuredHeight;
        if (isVertical()) {
            int paddingLeft = getPaddingLeft();
            int measuredWidth = view.getMeasuredWidth() + paddingLeft;
            i2 = paddingLeft;
            paddingTop = i2;
            measuredHeight = i3;
            i3 = measuredWidth;
        } else {
            paddingTop = getPaddingTop();
            measuredHeight = view.getMeasuredHeight() + paddingTop;
        }
        view.layout(i2, paddingTop, i3, measuredHeight);
    }

    private List<View> getAllChildren() {
        int childCount = getChildCount();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < childCount; i++) {
            linkedList.add(getChildAt(i));
        }
        return linkedList;
    }

    private View getChildByPosition(int i) {
        for (int childCount = getChildCount() - 1; childCount > -1; childCount--) {
            View childAt = getChildAt(childCount);
            if (((LayoutParams) childAt.getLayoutParams()).position == i) {
                return childAt;
            }
        }
        View view = this.mAdapter.get(this, i);
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.position = i;
        addViewInLayout(view, 0, layoutParams, true);
        measureChild(view);
        return view;
    }

    private void transformIfNeeded() {
        if (this.mTransformer == null) {
            return;
        }
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount <= -1) {
                return;
            }
            View childAt = getChildAt(childCount);
            if (!isBounceBeginView(childAt) && !isBounceEndView(childAt)) {
                transformChild(childAt);
            }
        }
    }

    private void transformChild(View view) {
        int left;
        int paddingLeft;
        if (view != null) {
            if (isRTL()) {
                left = (view.getLeft() - getScrollX()) + getOffset();
                paddingLeft = getPaddingLeft();
            } else if (isVertical()) {
                left = (view.getTop() - getScrollY()) - getOffset();
                paddingLeft = getPaddingTop();
            } else {
                left = (view.getLeft() - getScrollX()) - getOffset();
                paddingLeft = getPaddingLeft();
            }
            this.mTransformer.transformPage(this, view, isVertical(), left - paddingLeft);
        }
    }

    private void recycleView(View view, boolean z) {
        PageTransformer pageTransformer = this.mTransformer;
        if (pageTransformer != null) {
            pageTransformer.reset(view);
        }
        if (z) {
            return;
        }
        removeView(view);
        this.mAdapter.recycle(this, ((LayoutParams) view.getLayoutParams()).position, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerScrollStartEvent() {
        if (this.mIsInit || this.mTriggerEvent) {
            return;
        }
        boolean z = this.mTouchable && this.mScrollState == 1;
        Iterator<OnPageScrollListener> it = this.mPageScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onPageScrollStart(this.mCurrentIndex, z);
        }
        this.mTriggerEvent = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r6.mScrollState == 1) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void triggerTransitionEvent() {
        if (this.mIsInit || !this.mTriggerEvent) {
            return;
        }
        boolean z = this.mTouchable;
        Iterator<OnPageScrollListener> it = this.mPageScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onPageScrolling(this.mCurrentIndex, z, getScrollX(), getScrollY());
        }
    }

    private void triggerScrollToBounce(boolean z, boolean z2) {
        if (this.mIsInit || !this.mTriggerEvent) {
            return;
        }
        Iterator<OnPageScrollListener> it = this.mPageScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollToBounce(z, z2);
        }
    }

    private void triggerScrollEndEvent() {
        if (this.mIsInit || !this.mTriggerEvent) {
            return;
        }
        Iterator<OnPageScrollListener> it = this.mPageScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onPageScrollEnd(this.mCurrentIndex);
        }
        this.mTriggerEvent = false;
    }

    private void triggerPageChangeEvent() {
        if (this.mOldCurrentIndex != this.mCurrentIndex) {
            Iterator<OnPageScrollListener> it = this.mPageScrollListeners.iterator();
            while (it.hasNext()) {
                it.next().onPageChange(this.mOldCurrentIndex, this.mCurrentIndex, this.mIsInit);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            this.mFinalPosition = isVertical() ? this.mScroller.getFinalY() : this.mScroller.getFinalX();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (isVertical() && scrollY != currY) {
                scrollTo(scrollX, currY);
            } else if (!isVertical() && scrollX != currX) {
                scrollTo(currX, scrollY);
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (getChildCount() <= 0 || this.mScrollState == 1) {
            return;
        }
        this.mCurrentIndex = ((LayoutParams) getCurrentView().getLayoutParams()).position;
        triggerPageChangeEvent();
        if (this.mEnableViceLoop && this.mLoopChanged) {
            this.mLoop = false;
            this.mLoopChanged = false;
            requestLayout();
        }
        triggerScrollEndEvent();
        if (this.mOldCurrentIndex == -1 && this.mCurrentIndex != -1) {
            this.mIsInit = false;
        }
        this.mOldCurrentIndex = this.mCurrentIndex;
        setScrollState(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void scrollToFinalPositionDirectly() {
        if (this.mFinalPosition != Integer.MIN_VALUE) {
            if (isVertical()) {
                scrollTo(this.mScroller.getCurrX(), this.mFinalPosition);
            } else {
                scrollTo(this.mFinalPosition, this.mScroller.getCurrY());
            }
        }
        this.mFinalPosition = Integer.MIN_VALUE;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int finalX;
        int currX;
        if (!this.mTouchable) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 3 || actionMasked == 1) {
            this.mActivePointerId = -1;
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mFling = false;
            this.mReadyToScroll = false;
            this.mDragDistance = 0;
            return false;
        }
        if (actionMasked != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastY = y;
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mReadyToScroll = false;
            this.mFling = false;
            this.mDragDistance = 0;
            this.mScroller.computeScrollOffset();
            if (isVertical()) {
                finalX = this.mScroller.getFinalY();
                currX = this.mScroller.getCurrY();
            } else {
                finalX = this.mScroller.getFinalX();
                currX = this.mScroller.getCurrX();
            }
            int i = finalX - currX;
            if (this.mHandleGesture) {
                requestParentDisallowInterceptTouchEvent(true);
            }
            if (this.mScrollState == 2 && Math.abs(i) > this.mCloseEnough) {
                this.mScroller.abortAnimation();
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
                this.mIsBeingDragged = true;
            }
        } else if (actionMasked == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(findPointerIndex);
                float y2 = motionEvent.getY(findPointerIndex);
                float f = x2 - this.mLastX;
                float f2 = y2 - this.mLastY;
                float f3 = x2 - this.mInitialMotionX;
                float f4 = y2 - this.mInitialMotionY;
                int i3 = (int) (isVertical() ? f2 : f);
                if (this.mEnableNestedChild && i3 != 0 && canScroll(this, isVertical(), false, i3, (int) x2, (int) y2)) {
                    this.mLastX = x2;
                    this.mLastY = y2;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                if (isVertical()) {
                    if (Math.abs(f2) > this.mTouchSlop && Math.abs(f2) > Math.abs(f3) * 0.5f) {
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        this.mIsBeingDragged = true;
                        this.mReadyToScroll = true;
                        this.mLastY = f2 > 0.0f ? this.mInitialMotionY + this.mTouchSlop : this.mInitialMotionY - this.mTouchSlop;
                        this.mLastX = x2;
                    } else if (f3 > this.mTouchSlop) {
                        this.mIsUnableToDrag = true;
                    }
                } else if (Math.abs(f) > this.mTouchSlop && Math.abs(f) > Math.abs(f4) * 0.5f) {
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    this.mIsBeingDragged = true;
                    this.mReadyToScroll = true;
                    this.mLastX = f > 0.0f ? this.mInitialMotionX + this.mTouchSlop : this.mInitialMotionX - this.mTouchSlop;
                    this.mLastY = y2;
                } else if (f4 > this.mTouchSlop) {
                    this.mIsUnableToDrag = true;
                }
            }
        } else if (actionMasked == 5) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
        } else if (actionMasked == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    protected boolean canScroll(View view, boolean z, boolean z2, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, z, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z2) {
            if (z) {
                if (view.canScrollVertically(-i)) {
                    return true;
                }
            } else if (view.canScrollHorizontally(-i)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            this.mActivePointerId = -1;
            if (!this.mFling) {
                scrollToFinalPosition();
            }
        } else if (actionMasked == 5) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            this.mLastX = motionEvent.getX(actionIndex);
            this.mLastY = motionEvent.getY(actionIndex);
        } else if (actionMasked == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mTouchable) {
            return this.mDetector.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mLastX = motionEvent.getX(i);
            this.mLastY = motionEvent.getY(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.mScrollState == i) {
            return;
        }
        Iterator<OnPageScrollListener> it = this.mPageScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onPageScrollStateChanged(this.mScrollState, i);
        }
        this.mScrollState = i;
    }

    private void scrollToFinalPosition() {
        if (getChildCount() < 1) {
            return;
        }
        View currentView = getCurrentView();
        int scrollDistance = getScrollDistance();
        int begin = getBegin(currentView) - scrollDistance;
        int end = getEnd(currentView) - scrollDistance;
        if (isBounceBeginView(currentView)) {
            int pile = getPile();
            if (isVertical()) {
                this.mScroller.startScroll(0, scrollDistance, 0, (end + this.mPageMargin) - pile, this.mBounceDuration);
            } else if (this.isRTL) {
                this.mScroller.startScroll(scrollDistance, 0, (begin - this.mPageMargin) - (getPile() + getChildExpectSize()), 0, this.mBounceDuration);
            } else {
                this.mScroller.startScroll(scrollDistance, 0, (end + this.mPageMargin) - pile, 0, this.mBounceDuration);
            }
        } else if (isBounceEndView(currentView)) {
            int pile2 = getPile() + getChildExpectSize();
            if (isVertical()) {
                this.mScroller.startScroll(0, scrollDistance, 0, (begin - this.mPageMargin) - pile2, this.mBounceDuration);
            } else if (this.isRTL) {
                this.mScroller.startScroll(scrollDistance, 0, (end + this.mPageMargin) - getPile(), 0, this.mBounceDuration);
            } else {
                this.mScroller.startScroll(scrollDistance, 0, (begin - this.mPageMargin) - pile2, 0, this.mBounceDuration);
            }
        } else {
            int pile3 = getPile() + (getChildExpectSize() / 2);
            int i = (begin + end) / 2;
            if (isVertical()) {
                this.mScroller.startScroll(0, scrollDistance, 0, i - pile3, this.mAnimDuration);
            } else {
                this.mScroller.startScroll(scrollDistance, 0, i - pile3, 0, this.mAnimDuration);
            }
        }
        setScrollState(2);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flingToPosition(float f, float f2) {
        if (getChildCount() < 1) {
            return;
        }
        if (isVertical()) {
            f = f2;
        }
        int pile = getPile();
        int scrollDistance = getScrollDistance();
        int i = ((LayoutParams) getCurrentView().getLayoutParams()).position;
        if (f < 0.0f) {
            int childCount = getChildCount();
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < childCount; i3++) {
                int begin = getBegin(getChildAt(i3)) - scrollDistance;
                if (begin > pile && begin < i2) {
                    i2 = begin;
                }
            }
            if (i2 == Integer.MAX_VALUE) {
                flingToPositionInner(i, true);
                return;
            }
            if (isVertical()) {
                this.mScroller.startScroll(0, scrollDistance, 0, i2 - pile, this.mAnimDuration);
            } else {
                this.mScroller.startScroll(scrollDistance, 0, i2 - pile, 0, this.mAnimDuration);
            }
            setScrollState(2);
        } else {
            int childCount2 = getChildCount();
            int i4 = Integer.MIN_VALUE;
            for (int i5 = 0; i5 < childCount2; i5++) {
                int begin2 = getBegin(getChildAt(i5)) - scrollDistance;
                if (begin2 < pile && begin2 > i4) {
                    i4 = begin2;
                }
            }
            if (i4 == Integer.MIN_VALUE) {
                flingToPositionInner(i, false);
                return;
            }
            if (isVertical()) {
                this.mScroller.startScroll(0, scrollDistance, 0, i4 - pile, this.mAnimDuration);
            } else {
                this.mScroller.startScroll(scrollDistance, 0, i4 - pile, 0, this.mAnimDuration);
            }
            setScrollState(2);
        }
        invalidate();
    }

    private void flingToPositionInner(int i, boolean z) {
        int i2;
        if (z) {
            if (isRTL()) {
                if (this.mLoop && i - 1 < 0) {
                    i = this.mTotalCount;
                }
                i2 = i - 1;
            } else {
                i2 = (!this.mLoop || i + 1 < this.mTotalCount) ? i + 1 : 0;
            }
            setCurrentIndex(i2, true, !isRTL() ? 1 : 0);
            return;
        }
        if (isRTL()) {
            if (!this.mLoop || i + 1 < this.mTotalCount) {
                r0 = i + 1;
            }
        } else {
            if (this.mLoop && i - 1 < 0) {
                i = this.mTotalCount;
            }
            r0 = i - 1;
        }
        setCurrentIndex(r0, true, isRTL() ? 1 : 0);
    }

    private View getCurrentView() {
        int pile = getPile() + (getChildExpectSize() / 2);
        int scrollDistance = getScrollDistance();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int begin = getBegin(childAt) - scrollDistance;
            int end = getEnd(childAt) - scrollDistance;
            int i2 = this.mDragDistance;
            if (i2 > 0) {
                end += this.mPageMargin;
            } else if (i2 < 0) {
                begin -= this.mPageMargin;
            }
            if (begin <= pile && end >= pile) {
                return childAt;
            }
        }
        return getChildAt(0);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        resetScrollRange();
        boolean z = true;
        if (!this.mLoop) {
            if (isVertical()) {
                int childExpectSize = enableBounceBegin() ? (int) (this.mMinScrollBoundary + (this.mBounceBeginThreshold * (getChildExpectSize() + this.mPageMargin))) : this.mMinScrollBoundary;
                int childExpectSize2 = enableBounceEnd() ? (int) (this.mMaxScrollBoundary - (this.mBounceEndThreshold * (getChildExpectSize() + this.mPageMargin))) : this.mMaxScrollBoundary;
                this.mScrollInToBeginBounce = enableBounceBegin() && i2 <= childExpectSize;
                this.mScrollInToEndBounce = enableBounceEnd() && i2 >= childExpectSize2;
                i2 = Math.min(Math.max(i2, childExpectSize), childExpectSize2);
            } else {
                int i3 = this.mMinScrollBoundary;
                int i4 = this.mMaxScrollBoundary;
                if (enableBounceBegin()) {
                    if (this.isRTL) {
                        i4 = (int) (this.mMaxScrollBoundary - (this.mBounceBeginThreshold * (getChildExpectSize() + this.mPageMargin)));
                    } else {
                        i3 = (int) (this.mMinScrollBoundary + (this.mBounceBeginThreshold * (getChildExpectSize() + this.mPageMargin)));
                    }
                }
                if (enableBounceEnd()) {
                    if (this.isRTL) {
                        i3 = (int) (this.mMinScrollBoundary + (this.mBounceEndThreshold * (getChildExpectSize() + this.mPageMargin)));
                    } else {
                        i4 = (int) (this.mMaxScrollBoundary - (this.mBounceEndThreshold * (getChildExpectSize() + this.mPageMargin)));
                    }
                }
                this.mScrollInToBeginBounce = enableBounceBegin() && (!this.isRTL ? i > i3 : i < i4);
                this.mScrollInToEndBounce = enableBounceEnd() && (!this.isRTL ? i < i4 : i > i3);
                i = Math.min(Math.max(i, i3), i4);
            }
        }
        super.scrollTo(i, i2);
        updateScrollRange();
        relayoutChildren();
        triggerTransitionEvent();
        if (this.mLoop) {
            return;
        }
        if (this.mScrollInToBeginBounce || this.mScrollInToEndBounce) {
            scrollToFinalPosition();
            if (!this.mTriggerBounceEvent) {
                triggerScrollToBounce(this.mScrollInToBeginBounce, this.mScrollInToEndBounce);
            }
        }
        if (!this.mScrollInToBeginBounce && !this.mScrollInToEndBounce) {
            z = false;
        }
        this.mTriggerBounceEvent = z;
        this.mScrollInToBeginBounce = false;
        this.mScrollInToEndBounce = false;
    }

    private boolean scrollRangeChanged() {
        int childExpectSize = getChildExpectSize() + this.mPageMargin;
        int i = this.mTotalCount * childExpectSize;
        int paddingLeft = getPaddingLeft() + this.mOffset;
        boolean z = ((this.mMinScrollBoundary != Integer.MIN_VALUE || this.mMaxScrollBoundary != Integer.MAX_VALUE) && this.mExpectChildSize == childExpectSize && this.mExpectSize == i && this.mExpectOffset == paddingLeft) ? false : true;
        this.mExpectChildSize = childExpectSize;
        this.mExpectSize = i;
        this.mExpectOffset = paddingLeft;
        return z;
    }

    private void resetScrollRange() {
        if (scrollRangeChanged()) {
            if (isRTL()) {
                int paddingRight = getPaddingRight() - this.mOffset;
                this.mMinScrollBoundary = ((-(this.mTotalCount - 1)) * (getChildExpectSize() + this.mPageMargin)) + paddingRight;
                this.mMaxScrollBoundary = paddingRight;
            } else {
                int paddingTop = (isVertical() ? getPaddingTop() : getPaddingLeft()) + this.mOffset;
                this.mMinScrollBoundary = -paddingTop;
                this.mMaxScrollBoundary = ((this.mTotalCount - 1) * (getChildExpectSize() + this.mPageMargin)) - paddingTop;
            }
        }
    }

    private void updateScrollRange() {
        int childExpectSize = getChildExpectSize() + this.mPageMargin;
        int i = this.mTotalCount * childExpectSize;
        if (!this.mLoop || i <= 0 || childExpectSize <= 0) {
            return;
        }
        int scrollDistance = getScrollDistance();
        if (isRTL()) {
            int paddingRight = getPaddingRight() - this.mOffset;
            int i2 = scrollDistance - (childExpectSize / 2);
            if (i2 >= 0) {
                int i3 = i2 / i;
                this.mMinScrollBoundary = (i3 * i) + childExpectSize + paddingRight;
                this.mMaxScrollBoundary = ((i3 + 1) * i) + paddingRight;
                return;
            } else {
                this.mMinScrollBoundary = ((-((Math.abs(i2) / i) + 1)) * i) + childExpectSize + paddingRight;
                this.mMaxScrollBoundary = ((-(Math.abs(i2) / i)) * i) + paddingRight;
                return;
            }
        }
        int paddingTop = (isVertical() ? getPaddingTop() : getPaddingLeft()) + this.mOffset;
        int i4 = scrollDistance + (childExpectSize / 2);
        if (i4 >= 0) {
            int i5 = i4 / i;
            this.mMinScrollBoundary = (i5 * i) - paddingTop;
            this.mMaxScrollBoundary = (((i5 + 1) * i) - childExpectSize) - paddingTop;
        } else {
            this.mMinScrollBoundary = ((-((Math.abs(i4) / i) + 1)) * i) - paddingTop;
            this.mMaxScrollBoundary = (((-(Math.abs(i4) / i)) * i) - childExpectSize) - paddingTop;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void addPageScrollListener(OnPageScrollListener onPageScrollListener) {
        this.mPageScrollListeners.add(onPageScrollListener);
    }

    public void removePageScrollListener(OnPageScrollListener onPageScrollListener) {
        this.mPageScrollListeners.remove(onPageScrollListener);
    }

    private int getContentSize() {
        return isVertical() ? getContentHeight() : getContentWidth();
    }

    private int getPile() {
        if (isVertical()) {
            return getPaddingTop() + getOffset();
        }
        if (isRTL()) {
            return ((getPaddingLeft() + getOffset()) + getWidth()) - getChildExpectSize();
        }
        return getPaddingLeft() + getOffset();
    }

    private int getBegin(View view) {
        return isVertical() ? view.getTop() : view.getLeft();
    }

    private int getEnd(View view) {
        return isVertical() ? view.getBottom() : view.getRight();
    }

    private int getScrollDistance() {
        return isVertical() ? getScrollY() : getScrollX();
    }

    private int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int getContentHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getPageGap() {
        int width;
        int i;
        if (isVertical()) {
            width = getHeight() - getPaddingBottom();
            i = this.mPageMargin;
        } else {
            width = getWidth() - getPaddingRight();
            i = this.mPageMargin;
        }
        return width - i;
    }

    private boolean isRTL() {
        return this.isRTL && this.mOrientation == 0;
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getTotalCount() {
        return this.mTotalCount;
    }

    public boolean isVertical() {
        return this.mOrientation == 1;
    }

    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    public int getChildExpectSize() {
        int i = this.mPageSize;
        return i > 0 ? i : getContentSize();
    }

    public int getOffset() {
        return this.mOffset;
    }

    public void setTransformer(PageTransformer pageTransformer) {
        if (this.mTransformer != null) {
            int childCount = getChildCount();
            while (true) {
                childCount--;
                if (childCount <= -1) {
                    break;
                }
                this.mTransformer.reset(getChildAt(childCount));
            }
        }
        this.mTransformer = pageTransformer;
        transformIfNeeded();
    }

    public void setIsRTL(boolean z) {
        this.isRTL = z;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setHLayoutUpdated(boolean z) {
        if (this.mHLayoutUpdated) {
            return;
        }
        this.mHLayoutUpdated = z;
    }

    public void setVLayoutUpdated(boolean z) {
        if (this.mVLayoutUpdated) {
            return;
        }
        this.mVLayoutUpdated = z;
    }

    public void setPropsUpdated(boolean z) {
        if (this.mPropsUpdated) {
            return;
        }
        this.mPropsUpdated = z;
    }

    public void setPendingCurrentIndex(int i, boolean z) {
        this.mPendingCurrentIndex = i;
        this.mPendingSmoothScroll = z;
    }

    public void setAnimDuration(int i) {
        this.mAnimDuration = i;
    }

    public void setTouchable(boolean z) {
        this.mTouchable = z;
    }

    public void setLoop(boolean z) {
        this.mLoop = z;
        if (!this.mEnableViceLoop || this.mAdapter == null || this.mTotalCount <= 1 || this.mCurrentIndex == -1) {
            return;
        }
        requestLayout();
    }

    public void setPageSize(int i) {
        this.mPageSize = i;
    }

    public void setPageMargin(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mPageMargin = i;
    }

    public void setKeepItemView(boolean z) {
        this.mKeepItemView = z;
    }

    public void setForceCanScroll(boolean z) {
        this.mForceCanScroll = z;
    }

    public void setEnableViceLoop(boolean z) {
        this.mEnableViceLoop = z;
    }

    public void setEnableNestedChild(boolean z) {
        this.mEnableNestedChild = z;
    }

    public boolean enableBounceBegin() {
        if (this.mEnableBounce && !this.mLoop && !this.mIsInit) {
            float f = this.mBounceBeginThreshold;
            if (f > 0.0f && f < 1.0f && this.mAdapter != null && (this.mBounceEndThreshold >= 0.0f ? this.mTotalCount >= 3 : this.mTotalCount >= 2) && !this.mPropsUpdated && !this.mHLayoutUpdated && !this.mVLayoutUpdated) {
                return true;
            }
        }
        return false;
    }

    public boolean enableBounceEnd() {
        if (this.mEnableBounce && !this.mLoop && !this.mIsInit) {
            float f = this.mBounceEndThreshold;
            if (f > 0.0f && f < 1.0f && this.mAdapter != null && (this.mBounceBeginThreshold >= 0.0f ? this.mTotalCount >= 3 : this.mTotalCount >= 2) && !this.mPropsUpdated && !this.mHLayoutUpdated && !this.mVLayoutUpdated) {
                return true;
            }
        }
        return false;
    }

    public void setEnableBounce(boolean z) {
        this.mEnableBounce = z;
    }

    public void setBounceBeginThreshold(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.mBounceBeginThreshold = 1.0f - f;
        } else {
            this.mBounceBeginThreshold = -1.0f;
        }
    }

    public void setBounceEndThreshold(float f) {
        if (f > 0.0f && f < 1.0f) {
            this.mBounceEndThreshold = 1.0f - f;
        } else {
            this.mBounceEndThreshold = -1.0f;
        }
    }

    public void setBounceDuration(int i) {
        this.mBounceDuration = i;
    }

    public void setIgnoreLayoutUpdate(boolean z) {
        this.mIgnoreLayoutUpdate = z;
    }

    public void setHandleGesture(boolean z) {
        this.mHandleGesture = z;
    }

    private boolean isBounceBeginView(View view) {
        return enableBounceBegin() && ((LayoutParams) view.getLayoutParams()).position == 0;
    }

    private boolean isBounceEndView(View view) {
        return enableBounceEnd() && ((LayoutParams) view.getLayoutParams()).position == this.mTotalCount - 1;
    }
}

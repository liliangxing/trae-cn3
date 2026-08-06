package com.lynx.tasm.behavior.p000ui.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.p000ui.utils.BorderRadius;
import com.lynx.tasm.event.LynxScrollEvent;
import com.lynx.tasm.gesture.arena.GestureArenaManager;
import com.lynx.tasm.utils.PixelUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AndroidScrollView extends NestedScrollView implements IDrawChildHook.IDrawChildHookBinding {
    public static final int HORIZONTAL = 0;
    private static final int INTERNAL_FOR_SCROLL_END_CHECK = 100;
    public static final int SCROLL_NESTED_SCROLL = 4;
    public static final int SCROLL_STATE_ANIMATION = 3;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_FLING = 2;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int VERTICAL = 1;
    private int initialPositionX;
    private int initialPositionY;
    boolean isHorizontal;
    private boolean isLinearLayoutExist;
    boolean isUserDragging;
    private int mAutoScrollRate;
    private boolean mBlockDescendantFocusability;
    private Rect mClipRect;
    private Boolean mConsumeGesture;
    protected boolean mDirectionChanged;
    private IDrawChildHook mDrawChildHook;
    private boolean mForbidFocusChangeAfterFling;
    private boolean mForceCanScroll;
    private boolean mHandleTouchMove;
    private CustomHorizontalScrollView mHorizontalScrollView;
    private Boolean mInterceptGesture;
    private boolean mIsDownEventHandled;
    int mLastScrollState;
    private int mLastScrollX;
    private int mLastScrollY;
    private LinearLayout mLinearLayout;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private boolean mNeedAutoScroll;
    private ArrayList<OnScrollListener> mOnScrollListenerList;
    private int mScrollRange;
    int mScrollState;
    private Runnable mScrollerEndDetectionTask;
    private SmoothScrollRunnable mSmoothScrollRunnable;
    private UIScrollView mUIScrollView;
    private Rect mUiBound;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnScrollListener {
        void onFling(int i);

        void onScrollChanged(int i, int i2, int i3, int i4);

        void onScrollStart();

        void onScrollStateChanged(int i);

        void onScrollStop();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class ScrollerEndDetectionTask implements Runnable {
        private WeakReference<AndroidScrollView> mWeakScrollView;

        public ScrollerEndDetectionTask(AndroidScrollView androidScrollView) {
            this.mWeakScrollView = new WeakReference<>(androidScrollView);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mWeakScrollView.get() != null) {
                AndroidScrollView androidScrollView = this.mWeakScrollView.get();
                int scrollY = androidScrollView.getScrollY();
                int scrollX = androidScrollView.mHorizontalScrollView.getScrollX();
                boolean z = (androidScrollView.isHorizontal && androidScrollView.initialPositionX - scrollX == 0) || (!androidScrollView.isHorizontal && androidScrollView.initialPositionY - scrollY == 0);
                if (androidScrollView.isUserDragging || !z) {
                    androidScrollView.initialPositionY = scrollY;
                    androidScrollView.initialPositionX = scrollX;
                    androidScrollView.postDelayed(this, 100L);
                } else {
                    androidScrollView.notifyStateChange(0);
                    androidScrollView.triggerOnScrollStop();
                    androidScrollView.mUIScrollView.scrollToBounce(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void autoScroll(ReadableMap readableMap) {
        double d = readableMap.getDouble("rate", 0.0d);
        if (readableMap.getBoolean("start", true)) {
            int dipToPx = (int) PixelUtils.dipToPx(d / 60.0d);
            if (d == 0.0d) {
                LLog.e("LynxUIScrollView", "the rate of speed  is not right, current value is 0");
                return;
            }
            if (this.mNeedAutoScroll) {
                return;
            }
            this.mNeedAutoScroll = true;
            this.mAutoScrollRate = dipToPx;
            SmoothScrollRunnable smoothScrollRunnable = new SmoothScrollRunnable(this);
            this.mSmoothScrollRunnable = smoothScrollRunnable;
            post(smoothScrollRunnable);
            return;
        }
        this.mNeedAutoScroll = false;
        this.mAutoScrollRate = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SmoothScrollRunnable implements Runnable {
        private WeakReference<AndroidScrollView> mWeakScrollView;

        public SmoothScrollRunnable(AndroidScrollView androidScrollView) {
            this.mWeakScrollView = new WeakReference<>(androidScrollView);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            WeakReference<AndroidScrollView> weakReference = this.mWeakScrollView;
            if (weakReference == null || weakReference.get() == null || this.mWeakScrollView.get().mLinearLayout == null) {
                return;
            }
            AndroidScrollView androidScrollView = this.mWeakScrollView.get();
            if (!androidScrollView.mNeedAutoScroll) {
                return;
            }
            int realScrollX = androidScrollView.getRealScrollX();
            int realScrollY = androidScrollView.getRealScrollY();
            int i = androidScrollView.mAutoScrollRate;
            LinearLayout linearLayout = androidScrollView.mLinearLayout;
            if (!androidScrollView.isHorizontal) {
                int i2 = realScrollY + i;
                androidScrollView.setScrollTo(realScrollX, i2, false);
                if (i < 0) {
                    if (realScrollY <= 0) {
                        androidScrollView.mNeedAutoScroll = false;
                        return;
                    } else {
                        androidScrollView.postDelayed(this, 16L);
                        return;
                    }
                }
                if (i2 + androidScrollView.getMeasuredHeight() >= linearLayout.getMeasuredHeight()) {
                    androidScrollView.mNeedAutoScroll = false;
                    return;
                } else {
                    androidScrollView.postDelayed(this, 16L);
                    return;
                }
            }
            boolean z = true;
            int i3 = ViewCompat.getLayoutDirection(androidScrollView) == 1 ? realScrollX - i : realScrollX + i;
            androidScrollView.setScrollTo(i3, realScrollY, false);
            if (i < 0) {
                if (ViewCompat.getLayoutDirection(androidScrollView) == 0) {
                    z = false;
                    if (!z) {
                        androidScrollView.mNeedAutoScroll = false;
                        return;
                    } else {
                        androidScrollView.postDelayed(this, 16L);
                        return;
                    }
                }
                z = false;
                if (!z) {
                }
            } else if (i3 <= 0 || i3 + androidScrollView.getMeasuredWidth() >= linearLayout.getMeasuredWidth()) {
                androidScrollView.mNeedAutoScroll = false;
            } else {
                androidScrollView.postDelayed(this, 16L);
            }
        }
    }

    public void consumeGesture(boolean z) {
        this.mConsumeGesture = Boolean.valueOf(z);
        if (z) {
            this.mIsDownEventHandled = false;
        }
    }

    public void interceptGesture(boolean z) {
        this.mInterceptGesture = Boolean.valueOf(z);
    }

    public AndroidScrollView(Context context, UIScrollView uIScrollView) {
        super(context, uIScrollView);
        this.mIsDownEventHandled = true;
        this.mConsumeGesture = null;
        this.mInterceptGesture = null;
        this.isLinearLayoutExist = false;
        this.isHorizontal = false;
        this.isUserDragging = false;
        this.mMeasuredWidth = 0;
        this.mMeasuredHeight = 0;
        this.initialPositionY = 0;
        this.initialPositionX = 0;
        this.mSmoothScrollRunnable = null;
        this.mNeedAutoScroll = false;
        this.mBlockDescendantFocusability = false;
        this.mAutoScrollRate = 0;
        this.mScrollRange = 0;
        this.mDirectionChanged = false;
        this.mForbidFocusChangeAfterFling = false;
        this.mHandleTouchMove = false;
        this.mForceCanScroll = false;
        this.mScrollState = 0;
        this.mLastScrollState = 0;
        this.mUiBound = null;
        this.mUIScrollView = uIScrollView;
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFadingEdgeLength(0);
        setScrollContainer(false);
        this.mClipRect = new Rect();
        this.mOnScrollListenerList = new ArrayList<>();
        if (this.mLinearLayout == null) {
            createLinearLayout();
            createInnerScrollView(this.mUIScrollView);
            this.mHorizontalScrollView.addView(this.mLinearLayout, new FrameLayout.LayoutParams(-1, -1));
            addView(this.mHorizontalScrollView, new FrameLayout.LayoutParams(-2, -2));
        }
        this.mScrollerEndDetectionTask = new ScrollerEndDetectionTask(this);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.isHorizontal) {
            return;
        }
        int bounceScrollRange = this.mBounceGestureHelper.getBounceScrollRange();
        if (!this.mEnableNewBounce || bounceScrollRange <= 0 || bounceScrollRange == getScrollY()) {
            return;
        }
        setScrollTo(getScrollX(), bounceScrollRange, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConsumeGesture(MotionEvent motionEvent) {
        Boolean bool;
        return (!this.mUIScrollView.isEnableNewGesture() || (bool = this.mConsumeGesture) == null || bool.booleanValue() || motionEvent.getActionMasked() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInterceptGestureNotNull() {
        return this.mUIScrollView.isEnableNewGesture() && this.mInterceptGesture != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNeedInterceptGesture() {
        return isInterceptGestureNotNull() && this.mInterceptGesture.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotIncludeNativeGesture() {
        return this.mUIScrollView.isEnableNewGesture() && !this.mUIScrollView.getIncludeNativeGesture();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isHorizontal || isNotIncludeNativeGesture() || handleConsumeGesture(motionEvent)) {
            return false;
        }
        if (isInterceptGestureNotNull()) {
            if (motionEvent.getActionMasked() == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                if (motionEvent.getActionMasked() == 2) {
                    getParent().requestDisallowInterceptTouchEvent(this.mInterceptGesture.booleanValue());
                    return !this.mInterceptGesture.booleanValue() ? super.onTouchEvent(motionEvent) : this.mInterceptGesture.booleanValue();
                }
                if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                    this.mInterceptGesture = null;
                }
            }
        }
        this.mHandleTouchMove = motionEvent.getAction() == 2;
        try {
            try {
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    this.isUserDragging = false;
                    this.mHandleTouchMove = false;
                    this.mUIScrollView.scrollToBounce(true);
                    stopNestedScroll(0);
                } else if (motionEvent.getAction() == 0) {
                    this.isUserDragging = true;
                    this.mUIScrollView.recognizeGestureInternal(this.mScrollState);
                } else if (motionEvent.getAction() == 3) {
                    this.mHandleTouchMove = false;
                    stopNestedScroll(0);
                }
                return onTouchEvent;
            } catch (IllegalStateException e) {
                LLog.e("LynxUIScrollView", "AndroidScrollView onTouchEvent: " + motionEvent.getAction() + ", " + e.getMessage());
                if (motionEvent.getAction() == 1) {
                    this.isUserDragging = false;
                    this.mHandleTouchMove = false;
                    this.mUIScrollView.scrollToBounce(true);
                    stopNestedScroll(0);
                } else if (motionEvent.getAction() == 0) {
                    this.isUserDragging = true;
                    this.mUIScrollView.recognizeGestureInternal(this.mScrollState);
                } else if (motionEvent.getAction() == 3) {
                    this.mHandleTouchMove = false;
                    stopNestedScroll(0);
                }
                return false;
            }
        } catch (Throwable unused) {
            if (motionEvent.getAction() == 1) {
                this.isUserDragging = false;
                this.mHandleTouchMove = false;
                this.mUIScrollView.scrollToBounce(true);
                stopNestedScroll(0);
            } else if (motionEvent.getAction() == 0) {
                this.isUserDragging = true;
                this.mUIScrollView.recognizeGestureInternal(this.mScrollState);
            } else if (motionEvent.getAction() == 3) {
                this.mHandleTouchMove = false;
                stopNestedScroll(0);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleConsumeGesture(MotionEvent motionEvent) {
        if (!isConsumeGesture(motionEvent)) {
            return false;
        }
        if (motionEvent.getActionMasked() == 1) {
            this.isUserDragging = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transferToScroll() {
        triggerOnScrollStart();
        notifyStateChange((this.isUserDragging || this.mHandleTouchMove) ? 1 : 3);
        this.initialPositionY = getScrollY();
        this.initialPositionX = this.mHorizontalScrollView.getScrollX();
        postDelayed(this.mScrollerEndDetectionTask, 100L);
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook iDrawChildHook) {
        this.mDrawChildHook = iDrawChildHook;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public void addView(View view) {
        if (this.isLinearLayoutExist) {
            this.mLinearLayout.addView(view);
        } else {
            super.addView(view);
            this.isLinearLayoutExist = true;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        if (this.isLinearLayoutExist) {
            this.mLinearLayout.addView(view, i);
        } else {
            super.addView(view, i);
            this.isLinearLayoutExist = true;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.isLinearLayoutExist) {
            this.mLinearLayout.addView(view, i, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
            this.isLinearLayoutExist = true;
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (this.isLinearLayoutExist) {
            this.mLinearLayout.addView(view, layoutParams);
        } else {
            super.addView(view, layoutParams);
            this.isLinearLayoutExist = true;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        if (this.isLinearLayoutExist) {
            this.mLinearLayout.addView(view, i, i2);
        } else {
            super.addView(view, i, i2);
            this.isLinearLayoutExist = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.isLinearLayoutExist) {
            this.mLinearLayout.removeView(view);
        } else {
            super.removeView(view);
            this.isLinearLayoutExist = true;
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        if (this.isLinearLayoutExist) {
            this.mLinearLayout.removeViewAt(i);
        } else {
            super.removeViewAt(i);
            this.isLinearLayoutExist = true;
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        if (this.isLinearLayoutExist) {
            this.mLinearLayout.removeAllViews();
        } else {
            super.removeAllViews();
            this.isLinearLayoutExist = true;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.View
    public void computeScroll() {
        GestureArenaManager gestureArenaManager;
        super.computeScroll();
        UIScrollView uIScrollView = this.mUIScrollView;
        if (uIScrollView != null) {
            if (uIScrollView.mPendingScrollToIndex != -1) {
                LLog.i("LynxUIScrollView", "computeScroll: apply mPendingScrollToIndex when computing scroll " + this.mUIScrollView.mPendingScrollToIndex);
                setScrollToIndex(this.mUIScrollView.mPendingScrollToIndex);
                this.mUIScrollView.mPendingScrollToIndex = -1;
            }
            this.mUIScrollView.handleComputeScroll();
            if (!this.mUIScrollView.isEnableNewGesture() || (gestureArenaManager = this.mUIScrollView.getGestureArenaManager()) == null) {
                return;
            }
            gestureArenaManager.computeScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ScrollView
    public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (this.mBlockDescendantFocusability) {
            return 0;
        }
        return super.computeScrollDeltaToGetChildRectOnScreen(rect);
    }

    public void sendScrollToEdgeEvent(int i, int i2) {
        int updateBorderStatus = this.mUIScrollView.updateBorderStatus(i, i2, 0, 0);
        if (this.mUIScrollView.mEnableScrollToLowerEdgeEvent && UIScrollView.isLower(updateBorderStatus)) {
            this.mUIScrollView.sendCustomEvent(getScrollX(), getScrollY(), getScrollX(), getScrollY(), LynxScrollEvent.EVENT_SCROLL_TO_LOWER_EDGE);
        }
        if (this.mUIScrollView.mEnableScrollToUpperEdgeEvent && UIScrollView.isUpper(updateBorderStatus)) {
            this.mUIScrollView.sendCustomEvent(getScrollX(), getScrollY(), getScrollX(), getScrollY(), LynxScrollEvent.EVENT_SCROLL_TO_UPPER_EDGE);
        }
        if (!this.mUIScrollView.mEnableScrollToNormalStateEvent || UIScrollView.isUpper(updateBorderStatus) || UIScrollView.isLower(updateBorderStatus)) {
            return;
        }
        this.mUIScrollView.sendCustomEvent(getScrollX(), getScrollY(), getScrollX(), getScrollY(), LynxScrollEvent.EVENT_SCROLL_TO_NORMAL_STATE);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (i2 == this.mLastScrollY) {
            return;
        }
        this.mLastScrollY = getScrollY();
        if (this.mScrollState == 0) {
            transferToScroll();
        }
        triggerOnScrollChanged(i, i2, i3, i4);
        if (!this.isUserDragging && !this.mNeedAutoScroll) {
            this.mUIScrollView.scrollToBounce(true);
        }
        sendScrollToEdgeEvent(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Drawable background = getBackground();
        if (background instanceof BackgroundDrawable) {
            BackgroundDrawable backgroundDrawable = (BackgroundDrawable) background;
            RectF directionAwareBorderInsets = backgroundDrawable.getDirectionAwareBorderInsets();
            BorderRadius borderRadius = backgroundDrawable.getBorderRadius();
            Rect rect = this.mUiBound;
            if (rect == null) {
                rect = background.getBounds();
            }
            Path path = new Path();
            RectF rectF = new RectF(rect.left + directionAwareBorderInsets.left, rect.top + directionAwareBorderInsets.top + this.mLastScrollY, rect.right - directionAwareBorderInsets.right, (rect.bottom - directionAwareBorderInsets.bottom) + this.mLastScrollY);
            if (borderRadius == null) {
                path.addRect(rectF, Path.Direction.CW);
            } else {
                path.addRoundRect(rectF, BackgroundDrawable.RoundRectPath.newBorderRadius(borderRadius.getArray(), directionAwareBorderInsets, 1.0f), Path.Direction.CW);
            }
            int save = canvas.save();
            canvas.clipPath(path);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        if (getParent() instanceof ViewGroup) {
            if (getClipBounds() == null) {
                Rect rect2 = this.mClipRect;
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int scrollX2 = getScrollX();
                Rect rect3 = this.mUiBound;
                int width = scrollX2 + (rect3 == null ? getWidth() : rect3.width());
                int scrollY2 = getScrollY();
                Rect rect4 = this.mUiBound;
                rect2.set(scrollX, scrollY, width, scrollY2 + (rect4 == null ? getHeight() : rect4.height()));
                canvas.clipRect(this.mClipRect);
            }
        }
        super.dispatchDraw(canvas);
    }

    public int getContentWidth() {
        return this.mMeasuredWidth;
    }

    public int getContentHeight() {
        return this.mMeasuredHeight;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mUIScrollView.isEnableNewGesture()) {
            if (Boolean.FALSE.equals(this.mConsumeGesture)) {
                return true;
            }
            if (motionEvent.getActionMasked() == 2 && this.mConsumeGesture != null && !this.mIsDownEventHandled) {
                motionEvent.setAction(0);
                this.mIsDownEventHandled = true;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView, android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isHorizontal) {
            return false;
        }
        if (this.mUIScrollView.mPreferenceConsumeGesture) {
            requestDisallowInterceptTouchEvent(true);
        }
        if (isNotIncludeNativeGesture() || isConsumeGesture(motionEvent)) {
            return false;
        }
        if (isNeedInterceptGesture()) {
            return this.mInterceptGesture.booleanValue();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView, android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        boolean dispatchNestedScroll = super.dispatchNestedScroll(i, i2, i3, i4, iArr);
        if (dispatchNestedScroll) {
            triggerOnScrollStateChanged(4);
        }
        return dispatchNestedScroll;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        boolean dispatchNestedScroll = super.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        if (dispatchNestedScroll) {
            triggerOnScrollStateChanged(4);
        }
        return dispatchNestedScroll;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView, android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        if (dispatchNestedPreScroll) {
            triggerOnScrollStateChanged(4);
        }
        return dispatchNestedPreScroll;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        if (dispatchNestedPreScroll) {
            triggerOnScrollStateChanged(4);
        }
        return dispatchNestedPreScroll;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView, android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        boolean dispatchNestedFling = super.dispatchNestedFling(f, f2, z);
        if (dispatchNestedFling) {
            triggerOnScrollStateChanged(4);
        }
        return dispatchNestedFling;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView, android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        boolean dispatchNestedPreFling = super.dispatchNestedPreFling(f, f2);
        if (dispatchNestedPreFling) {
            triggerOnScrollStateChanged(4);
        }
        return dispatchNestedPreFling;
    }

    @Override // android.view.View
    public void setClipBounds(Rect rect) {
        this.mUiBound = rect;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.mLinearLayout.setPadding(i, i2, i3, i4);
    }

    public void setScrollBarEnable(boolean z) {
        setVerticalScrollBarEnabled(z);
    }

    public void setBlockDescendantFocusability(boolean z) {
        this.mBlockDescendantFocusability = z;
    }

    public void setScrollTo(int i, int i2, boolean z) {
        if (this.mLastScrollX == i && this.mLastScrollY == i2) {
            return;
        }
        if (z) {
            if (this.isHorizontal) {
                this.mHorizontalScrollView.setSmoothScrollingEnabled(true);
                this.mHorizontalScrollView.smoothScrollToInternal(i, i2);
                return;
            } else {
                setSmoothScrollingEnabled(true);
                smoothScrollToInternal(i, i2);
                return;
            }
        }
        if (this.isHorizontal) {
            abortAnimation(this.mHorizontalScrollView);
            this.mHorizontalScrollView.scrollTo(i, i2);
        } else {
            abortAnimation(this);
            scrollTo(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScrollToIndex(int i) {
        int childCount;
        int left;
        UIScrollView uIScrollView = this.mUIScrollView;
        if (uIScrollView == null || (childCount = uIScrollView.getChildCount()) == 0 || i < 0 || i >= childCount || this.mUIScrollView.getChildAt(i) == null) {
            return;
        }
        if (this.isHorizontal) {
            int scrollY = this.mHorizontalScrollView.getScrollY();
            this.mHorizontalScrollView.getScrollX();
            LynxBaseUI childAt = this.mUIScrollView.getChildAt(i);
            if (ViewCompat.getLayoutDirection(this) == 1) {
                left = (childAt.getLeft() + childAt.getWidth()) - this.mUIScrollView.getWidth();
            } else {
                left = childAt.getLeft();
            }
            setScrollTo(left, scrollY, false);
            return;
        }
        setScrollTo(getScrollX(), this.mUIScrollView.getChildAt(i).getTop(), false);
    }

    public void abortAnimation(View view) {
        Field declaredField;
        try {
            if (view instanceof HorizontalScrollView) {
                declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
            } else {
                declaredField = view instanceof ScrollView ? ScrollView.class.getDeclaredField("mScroller") : null;
            }
            if (declaredField == null) {
                LLog.w("AndroidScrollView", "did not find mScroller in " + view.getClass().getName());
                return;
            }
            declaredField.setAccessible(true);
            OverScroller overScroller = (OverScroller) declaredField.get(view);
            if (overScroller.isFinished()) {
                return;
            }
            overScroller.abortAnimation();
        } catch (Throwable th) {
            LLog.w("AndroidScrollView", th.getMessage());
        }
    }

    public int getRealScrollX() {
        if (this.isHorizontal) {
            return this.mHorizontalScrollView.getScrollX();
        }
        return getScrollX();
    }

    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    public int getRealScrollY() {
        if (this.isHorizontal) {
            return this.mHorizontalScrollView.getScrollY();
        }
        return getScrollY();
    }

    public void setEnableScroll(final boolean z) {
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return !z;
            }
        };
        this.mHorizontalScrollView.setOnTouchListener(onTouchListener);
        setOnTouchListener(onTouchListener);
    }

    public void setOrientation(int i) {
        if (i == 0) {
            this.mLinearLayout.setOrientation(0);
            this.isHorizontal = true;
        } else if (i == 1) {
            this.mLinearLayout.setOrientation(1);
            this.isHorizontal = false;
        }
    }

    public int getOrientation() {
        return this.mLinearLayout.getOrientation();
    }

    private void createLinearLayout() {
        LinearLayout linearLayout = new LinearLayout(getContext()) { // from class: com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.2
            @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            }

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                setMeasuredDimension(AndroidScrollView.this.mMeasuredWidth, AndroidScrollView.this.mMeasuredHeight);
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (AndroidScrollView.this.mDrawChildHook != null) {
                    AndroidScrollView.this.mDrawChildHook.beforeDispatchDraw(canvas);
                }
                super.dispatchDraw(canvas);
                if (AndroidScrollView.this.mDrawChildHook != null) {
                    AndroidScrollView.this.mDrawChildHook.afterDispatchDraw(canvas);
                }
            }

            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View view, long j) {
                boolean drawChild;
                Rect beforeDrawChild = AndroidScrollView.this.mDrawChildHook != null ? AndroidScrollView.this.mDrawChildHook.beforeDrawChild(canvas, view, j) : null;
                if (beforeDrawChild != null) {
                    canvas.save();
                    canvas.clipRect(beforeDrawChild);
                    drawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                } else {
                    drawChild = super.drawChild(canvas, view, j);
                }
                if (AndroidScrollView.this.mDrawChildHook != null) {
                    AndroidScrollView.this.mDrawChildHook.afterDrawChild(canvas, view, j);
                }
                return drawChild;
            }

            @Override // android.view.View
            public boolean canScrollHorizontally(int i) {
                if (AndroidScrollView.this.mUIScrollView.isEnableNewGesture()) {
                    return super.canScrollHorizontally(i);
                }
                return (AndroidScrollView.this.mForceCanScroll && AndroidScrollView.this.isHorizontal) || super.canScrollHorizontally(i);
            }
        };
        this.mLinearLayout = linearLayout;
        linearLayout.setOrientation(1);
        this.mLinearLayout.setWillNotDraw(true);
        this.mLinearLayout.setFocusableInTouchMode(true);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (this.mUIScrollView.isEnableNewGesture()) {
            return super.canScrollVertically(i);
        }
        return (this.mForceCanScroll && !this.isHorizontal) || super.canScrollVertically(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedScrollView, android.widget.ScrollView
    public void fling(int i) {
        super.fling(i);
        if (this.mScrollState == 1) {
            notifyStateChange(2);
        }
        triggerOnFling(i);
    }

    private void createInnerScrollView(UIScrollView uIScrollView) {
        CustomHorizontalScrollView customHorizontalScrollView = new CustomHorizontalScrollView(getContext(), uIScrollView);
        this.mHorizontalScrollView = customHorizontalScrollView;
        customHorizontalScrollView.setOverScrollMode(2);
        this.mHorizontalScrollView.setFadingEdgeLength(0);
        this.mHorizontalScrollView.setWillNotDraw(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStateChange(int i) {
        LLog.i("LynxUIScrollView", "notifyStateChange " + this.mScrollState + " -> " + i);
        int i2 = this.mScrollState;
        if (i2 != i) {
            this.mLastScrollState = i2;
            this.mScrollState = i;
            triggerOnScrollStateChanged(i);
        }
    }

    public void setMeasuredSize(int i, int i2) {
        this.mMeasuredHeight = i2;
        this.mMeasuredWidth = i;
        LinearLayout linearLayout = this.mLinearLayout;
        if (linearLayout != null) {
            linearLayout.requestLayout();
        }
    }

    public CustomHorizontalScrollView getHScrollView() {
        return this.mHorizontalScrollView;
    }

    public void setForbidFlingFocusChange(boolean z) {
        this.mForbidFocusChangeAfterFling = z;
    }

    public LinearLayout getLinearLayout() {
        return this.mLinearLayout;
    }

    public void setForceCanScroll(boolean z) {
        this.mForceCanScroll = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CustomHorizontalScrollView extends NestedHorizontalScrollView {
        public CustomHorizontalScrollView(Context context, UIScrollView uIScrollView) {
            super(context, uIScrollView);
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView
        public void fling(int i) {
            if (AndroidScrollView.this.mScrollState == 1) {
                AndroidScrollView.this.notifyStateChange(2);
            }
            AndroidScrollView.this.triggerOnFling(i);
            if (!AndroidScrollView.this.mForbidFocusChangeAfterFling || this.mEnableNewNested) {
                super.fling(i);
                return;
            }
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                if (declaredField == null) {
                    throw new Exception("can not find mScroller field in HorizontalScrollView");
                }
                declaredField.setAccessible(true);
                OverScroller overScroller = (OverScroller) declaredField.get(this);
                if (overScroller == null) {
                    throw new Exception("failed to get mScroller in HorizontalScrollView");
                }
                if (getChildCount() > 0) {
                    int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
                    overScroller.fling(getScrollX(), getScrollY(), i, 0, 0, Math.max(0, getChildAt(0).getWidth() - width), 0, 0, width / 2, 0);
                    postInvalidateOnAnimation();
                }
            } catch (Throwable th) {
                LLog.w("AndroidScrollView", th.getMessage());
                super.fling(i);
            }
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
        }

        @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int scrollX = getScrollX();
            super.onLayout(z, i, i2, i3, i4);
            if (AndroidScrollView.this.isHorizontal) {
                int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredWidth() : 0) - (((i3 - i) - getPaddingLeft()) - getPaddingRight()));
                if (AndroidScrollView.this.mDirectionChanged) {
                    setScrollX(ViewCompat.getLayoutDirection(this) == 1 ? max : 0);
                    AndroidScrollView.this.mDirectionChanged = false;
                    AndroidScrollView.this.mLastScrollX = getScrollX();
                } else if (ViewCompat.getLayoutDirection(this) == 1) {
                    if (ViewCompat.isLaidOut(this) || AndroidScrollView.this.mScrollRange != max) {
                        if (AndroidScrollView.this.mScrollRange != max && AndroidScrollView.this.mScrollRange >= 0) {
                            setScrollX(MathUtils.clamp(scrollX + (max - AndroidScrollView.this.mScrollRange), 0, max));
                        }
                    } else {
                        setScrollX(AndroidScrollView.this.mLastScrollX);
                    }
                    AndroidScrollView.this.mLastScrollX = getScrollX();
                }
                AndroidScrollView.this.mScrollRange = max;
                int bounceScrollRange = this.mBounceGestureHelper.getBounceScrollRange();
                if (!this.mEnableNewBounce || bounceScrollRange <= 0 || bounceScrollRange == getScrollX()) {
                    return;
                }
                AndroidScrollView.this.setScrollTo(bounceScrollRange, getScrollY(), false);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (AndroidScrollView.this.mUIScrollView.isEnableNewGesture()) {
                if (Boolean.FALSE.equals(AndroidScrollView.this.mConsumeGesture)) {
                    return true;
                }
                if (motionEvent.getActionMasked() == 2 && AndroidScrollView.this.mConsumeGesture != null && !AndroidScrollView.this.mIsDownEventHandled) {
                    motionEvent.setAction(0);
                    AndroidScrollView.this.mIsDownEventHandled = true;
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!AndroidScrollView.this.isHorizontal || AndroidScrollView.this.isConsumeGesture(motionEvent) || AndroidScrollView.this.isNotIncludeNativeGesture()) {
                return false;
            }
            if (AndroidScrollView.this.isNeedInterceptGesture()) {
                return AndroidScrollView.this.mInterceptGesture.booleanValue();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView, android.widget.HorizontalScrollView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!AndroidScrollView.this.isHorizontal || AndroidScrollView.this.isNotIncludeNativeGesture() || AndroidScrollView.this.handleConsumeGesture(motionEvent)) {
                return false;
            }
            if (AndroidScrollView.this.isInterceptGestureNotNull()) {
                if (motionEvent.getActionMasked() == 0) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    if (motionEvent.getActionMasked() == 2) {
                        getParent().requestDisallowInterceptTouchEvent(AndroidScrollView.this.mInterceptGesture.booleanValue());
                        return !AndroidScrollView.this.mInterceptGesture.booleanValue() ? super.onTouchEvent(motionEvent) : AndroidScrollView.this.mInterceptGesture.booleanValue();
                    }
                    if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
                        AndroidScrollView.this.mInterceptGesture = null;
                    }
                }
            }
            AndroidScrollView.this.mHandleTouchMove = motionEvent.getAction() == 2;
            if (motionEvent.getAction() == 1) {
                AndroidScrollView.this.isUserDragging = false;
                AndroidScrollView.this.mHandleTouchMove = false;
                AndroidScrollView.this.mUIScrollView.scrollToBounce(true);
            } else if (motionEvent.getAction() == 0) {
                AndroidScrollView.this.isUserDragging = true;
                AndroidScrollView.this.mUIScrollView.recognizeGestureInternal(AndroidScrollView.this.mScrollState);
            } else if (motionEvent.getAction() == 3) {
                AndroidScrollView.this.mHandleTouchMove = false;
            }
            try {
                try {
                    return super.onTouchEvent(motionEvent);
                } catch (IllegalStateException e) {
                    LLog.e("LynxUIScrollView", "CustomHorizontalScrollView onTouchEvent: " + motionEvent.getAction() + ", " + e.getMessage());
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        }

        @Override // android.view.View
        protected void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (i == AndroidScrollView.this.mLastScrollX) {
                return;
            }
            AndroidScrollView.this.mLastScrollX = getScrollX();
            if (AndroidScrollView.this.mScrollState == 0) {
                AndroidScrollView.this.transferToScroll();
            }
            AndroidScrollView.this.triggerOnScrollChanged(i, i2, i3, i4);
            if (AndroidScrollView.this.isUserDragging || AndroidScrollView.this.mNeedAutoScroll) {
                return;
            }
            AndroidScrollView.this.mUIScrollView.scrollToBounce(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.HorizontalScrollView
        public int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
            if (AndroidScrollView.this.mBlockDescendantFocusability) {
                return 0;
            }
            return super.computeScrollDeltaToGetChildRectOnScreen(rect);
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView, android.view.View
        public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
            boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
            if (dispatchNestedPreScroll) {
                AndroidScrollView.this.triggerOnScrollStateChanged(4);
            }
            return dispatchNestedPreScroll;
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView
        public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
            boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
            if (dispatchNestedPreScroll) {
                AndroidScrollView.this.triggerOnScrollStateChanged(4);
            }
            return dispatchNestedPreScroll;
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView, android.view.View
        public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
            boolean dispatchNestedScroll = super.dispatchNestedScroll(i, i2, i3, i4, iArr);
            if (dispatchNestedScroll) {
                AndroidScrollView.this.triggerOnScrollStateChanged(4);
            }
            return dispatchNestedScroll;
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView
        public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
            boolean dispatchNestedScroll = super.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
            if (dispatchNestedScroll) {
                AndroidScrollView.this.triggerOnScrollStateChanged(4);
            }
            return dispatchNestedScroll;
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView, android.view.View
        public boolean dispatchNestedPreFling(float f, float f2) {
            boolean dispatchNestedPreFling = super.dispatchNestedPreFling(f, f2);
            if (dispatchNestedPreFling) {
                AndroidScrollView.this.triggerOnScrollStateChanged(4);
            }
            return dispatchNestedPreFling;
        }

        @Override // com.lynx.tasm.behavior.p000ui.scroll.NestedHorizontalScrollView, android.view.View
        public boolean dispatchNestedFling(float f, float f2, boolean z) {
            boolean dispatchNestedFling = super.dispatchNestedFling(f, f2, z);
            if (dispatchNestedFling) {
                AndroidScrollView.this.triggerOnScrollStateChanged(4);
            }
            return dispatchNestedFling;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerOnScrollStop() {
        ArrayList<OnScrollListener> arrayList = this.mOnScrollListenerList;
        if (arrayList != null) {
            Iterator<OnScrollListener> it = arrayList.iterator();
            while (it.hasNext()) {
                OnScrollListener next = it.next();
                if (next != null) {
                    next.onScrollStop();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerOnScrollChanged(int i, int i2, int i3, int i4) {
        ArrayList<OnScrollListener> arrayList = this.mOnScrollListenerList;
        if (arrayList != null) {
            Iterator<OnScrollListener> it = arrayList.iterator();
            while (it.hasNext()) {
                OnScrollListener next = it.next();
                if (next != null) {
                    next.onScrollChanged(i, i2, i3, i4);
                }
            }
        }
    }

    private void triggerOnScrollStart() {
        ArrayList<OnScrollListener> arrayList = this.mOnScrollListenerList;
        if (arrayList != null) {
            Iterator<OnScrollListener> it = arrayList.iterator();
            while (it.hasNext()) {
                OnScrollListener next = it.next();
                if (next != null) {
                    next.onScrollStart();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerOnScrollStateChanged(int i) {
        ArrayList<OnScrollListener> arrayList = this.mOnScrollListenerList;
        if (arrayList != null) {
            Iterator<OnScrollListener> it = arrayList.iterator();
            while (it.hasNext()) {
                OnScrollListener next = it.next();
                if (next != null) {
                    next.onScrollStateChanged(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerOnFling(int i) {
        ArrayList<OnScrollListener> arrayList = this.mOnScrollListenerList;
        if (arrayList != null) {
            Iterator<OnScrollListener> it = arrayList.iterator();
            while (it.hasNext()) {
                OnScrollListener next = it.next();
                if (next != null) {
                    next.onFling(i);
                }
            }
        }
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        addOnScrollListener(onScrollListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mOnScrollListenerList == null) {
            this.mOnScrollListenerList = new ArrayList<>();
        }
        if (onScrollListener != null) {
            this.mOnScrollListenerList.add(onScrollListener);
        }
    }

    public void clearOnScrollListener() {
        ArrayList<OnScrollListener> arrayList = this.mOnScrollListenerList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        ArrayList<OnScrollListener> arrayList = this.mOnScrollListenerList;
        if (arrayList == null || onScrollListener == null) {
            return;
        }
        arrayList.remove(onScrollListener);
    }
}

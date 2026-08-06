package com.lynx.tasm.behavior.p000ui.list.container;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.lynx.tasm.IListNodeInfoFetcher;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.behavior.p000ui.list.container.NestedScrollContainerView;
import com.lynx.tasm.gesture.arena.GestureArenaManager;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ListContainerView extends NestedScrollContainerView implements IDrawChildHook.IDrawChildHookBinding {
    private static final boolean DEBUG = true;
    private static final String TAG = "ListContainerView";
    private Boolean mConsumeGesture;
    private CustomLinearLayout mCustomLinearLayout;
    private IDrawChildHook mDrawChildHook;
    private boolean mForceCanScroll;
    private Boolean mInterceptGesture;
    private boolean mIsDownEventHandled;
    private boolean mIsVertical;
    int mMeasuredHeight;
    int mMeasuredWidth;
    private int mPreviousOffsetX;
    private int mPreviousOffsetY;
    private boolean mShouldBlockScrollByListContainer;
    private UIListContainer mUiListContainer;

    public ListContainerView(Context context, UIListContainer uIListContainer) {
        super(context);
        this.mConsumeGesture = null;
        this.mInterceptGesture = null;
        this.mIsDownEventHandled = true;
        this.mIsVertical = true;
        this.mMeasuredWidth = 0;
        this.mMeasuredHeight = 0;
        this.mShouldBlockScrollByListContainer = false;
        this.mForceCanScroll = false;
        this.mUiListContainer = uIListContainer;
        createCustomLinearLayoutIfNeeded();
        addView(this.mCustomLinearLayout, new FrameLayout.LayoutParams(-1, -1));
    }

    private void createCustomLinearLayoutIfNeeded() {
        if (this.mCustomLinearLayout == null) {
            this.mCustomLinearLayout = new CustomLinearLayout(getContext());
            LLog.i(TAG, "Create CustomLinearLayout: " + this.mCustomLinearLayout + ", " + this);
        }
        this.mCustomLinearLayout.setOrientation(1);
        this.mCustomLinearLayout.setWillNotDraw(true);
        this.mCustomLinearLayout.setFocusableInTouchMode(true);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.container.NestedScrollContainerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mUiListContainer == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (isNotIncludeNativeGesture() || isConsumeGesture(motionEvent)) {
            return false;
        }
        if (isNeedInterceptGesture()) {
            return this.mInterceptGesture.booleanValue();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        UIListContainer uIListContainer = this.mUiListContainer;
        if (uIListContainer == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (uIListContainer.isEnableNewGesture()) {
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

    private boolean isConsumeGesture(MotionEvent motionEvent) {
        Boolean bool;
        return (!this.mUiListContainer.isEnableNewGesture() || (bool = this.mConsumeGesture) == null || bool.booleanValue() || motionEvent.getActionMasked() == 0) ? false : true;
    }

    private boolean isNotIncludeNativeGesture() {
        return this.mUiListContainer.isEnableNewGesture() && !this.mUiListContainer.getIncludeNativeGesture();
    }

    private boolean isInterceptGestureNotNull() {
        return this.mUiListContainer.isEnableNewGesture() && this.mInterceptGesture != null;
    }

    private boolean isNeedInterceptGesture() {
        return isInterceptGestureNotNull() && this.mInterceptGesture.booleanValue();
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.container.NestedScrollContainerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mUiListContainer == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (isNotIncludeNativeGesture() || isConsumeGesture(motionEvent)) {
            return false;
        }
        if (isInterceptGestureNotNull()) {
            if (motionEvent.getAction() == 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                if (motionEvent.getAction() == 2) {
                    getParent().requestDisallowInterceptTouchEvent(this.mInterceptGesture.booleanValue());
                    return !this.mInterceptGesture.booleanValue() ? super.onTouchEvent(motionEvent) : this.mInterceptGesture.booleanValue();
                }
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    this.mInterceptGesture = null;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.list.container.NestedScrollContainerView
    public void onGestureRecognizedDuringNestedScroll(boolean z) {
        super.onGestureRecognizedDuringNestedScroll(z);
        UIListContainer uIListContainer = this.mUiListContainer;
        if (uIListContainer == null || !z) {
            return;
        }
        uIListContainer.recognizeGesturere();
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

    @Override // android.view.View
    public void computeScroll() {
        GestureArenaManager gestureArenaManager;
        super.computeScroll();
        UIListContainer uIListContainer = this.mUiListContainer;
        if (uIListContainer == null || !uIListContainer.isEnableNewGesture() || (gestureArenaManager = this.mUiListContainer.getGestureArenaManager()) == null) {
            return;
        }
        gestureArenaManager.computeScroll();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMeasuredSize(int i, int i2) {
        if (this.mMeasuredWidth == i && this.mMeasuredHeight == i2) {
            return;
        }
        this.mMeasuredHeight = i2;
        this.mMeasuredWidth = i;
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            customLinearLayout.requestLayout();
        }
    }

    public void setForceCanScroll(boolean z) {
        this.mForceCanScroll = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateContentSizeAndOffset(int i, int i2, int i3) {
        boolean z = this.mIsVertical;
        if (z && i != this.mMeasuredHeight) {
            setMeasuredSize(this.mMeasuredWidth, Math.max(i, this.mUiListContainer.getHeight()));
        } else if (!z && i != this.mMeasuredWidth) {
            setMeasuredSize(Math.max(i, this.mUiListContainer.getWidth()), this.mMeasuredHeight);
        }
        this.mShouldBlockScrollByListContainer = true;
        if (this.mIsVertical) {
            int i4 = this.mPreviousOffsetY + i3;
            this.mPreviousOffsetY = i4;
            setScrollY(i4);
        } else {
            this.mPreviousOffsetX += i2;
            setScrollX(this.mUiListContainer.isRtl() ? contentOffsetXRTL(this.mPreviousOffsetX) : this.mPreviousOffsetX);
        }
        this.mShouldBlockScrollByListContainer = false;
    }

    private int contentOffsetXRTL(float f) {
        return (int) Math.max((this.mMeasuredWidth - f) - this.mUiListContainer.getWidth(), 0.0f);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.container.NestedScrollContainerView, android.view.View
    public boolean canScrollVertically(int i) {
        return (this.mForceCanScroll && this.mIsVertical) || super.canScrollVertically(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.container.NestedScrollContainerView, android.view.View
    public boolean canScrollHorizontally(int i) {
        return (this.mForceCanScroll && !this.mIsVertical) || super.canScrollHorizontally(i);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        UIListContainer uIListContainer;
        super.onScrollChanged(i, i2, i3, i4);
        LLog.i(TAG, "onScrollChanged: " + i4 + " -> " + i2 + ", " + i3 + " -> " + i);
        if (this.mShouldBlockScrollByListContainer || (uIListContainer = this.mUiListContainer) == null || uIListContainer.getLynxContext() == null) {
            return;
        }
        IListNodeInfoFetcher listNodeInfoFetcher = this.mUiListContainer.getLynxContext().getListNodeInfoFetcher();
        if (listNodeInfoFetcher == null) {
            LLog.e(TAG, "onScrollChanged: listNodeInfoFetcher is nullptr");
            return;
        }
        this.mPreviousOffsetY = i2;
        this.mPreviousOffsetX = this.mUiListContainer.isRtl() ? contentOffsetXRTL(i) : i;
        float f = i2;
        listNodeInfoFetcher.scrollByListContainer(this.mUiListContainer.getSign(), this.mPreviousOffsetX, f, i, f);
        this.mUiListContainer.updateStickyStarts();
        this.mUiListContainer.updateStickyEnds();
        Iterator<NestedScrollContainerView.OnScrollListener> it = this.mOnScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollChange(this.mPreviousOffsetX, i2, this.mUiListContainer.isRtl() ? contentOffsetXRTL(i3) : i3, i4);
        }
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook iDrawChildHook) {
        this.mDrawChildHook = iDrawChildHook;
    }

    public void setOrientation(int i) {
        boolean z = i == 1;
        this.mIsVertical = z;
        setIsVertical(z);
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            customLinearLayout.setOrientation(i == 1 ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void destroy() {
        TraceEvent.beginSection("ListContainerView.destroy");
        this.mDrawChildHook = null;
        this.mUiListContainer = null;
        this.mCustomLinearLayout = null;
        clearOnScrollListeners();
        clearOnScrollStateChangeListeners();
        TraceEvent.endSection("ListContainerView.destroy");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LinearLayout getLinearLayout() {
        return this.mCustomLinearLayout;
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.container.NestedScrollContainerView
    protected boolean isRtl() {
        UIListContainer uIListContainer = this.mUiListContainer;
        if (uIListContainer == null) {
            return false;
        }
        return uIListContainer.isRtl();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            if (customLinearLayout == view) {
                super.addView(customLinearLayout);
            } else {
                customLinearLayout.addView(view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            if (customLinearLayout == view) {
                super.addView(customLinearLayout, i);
            } else {
                customLinearLayout.addView(view, i);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            if (customLinearLayout == view) {
                super.addView(customLinearLayout, layoutParams);
            } else {
                customLinearLayout.addView(view, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, int i2) {
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            if (customLinearLayout == view) {
                super.addView(customLinearLayout, i, i2);
            } else {
                customLinearLayout.addView(view, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            if (customLinearLayout == view) {
                super.addView(customLinearLayout, i, layoutParams);
            } else {
                customLinearLayout.addView(view, i, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            if (customLinearLayout == view) {
                super.removeView(customLinearLayout);
            } else {
                customLinearLayout.removeView(view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            customLinearLayout.removeViewAt(i);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        CustomLinearLayout customLinearLayout = this.mCustomLinearLayout;
        if (customLinearLayout != null) {
            customLinearLayout.removeAllViews();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        LLog.e(TAG, "onDetachedFromWindow: " + this + ", ui = " + this.mUiListContainer);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CustomLinearLayout extends LinearLayout {
        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public CustomLinearLayout(Context context) {
            super(context);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            if (ListContainerView.this.mUiListContainer == null) {
                LLog.e(ListContainerView.TAG, "CustomLinearLayout$$onMeasure: mUiListContainer is null: " + this + ", " + ListContainerView.this);
                setMeasuredDimension(0, 0);
            } else {
                setMeasuredDimension(ListContainerView.this.mMeasuredWidth > 0 ? ListContainerView.this.mMeasuredWidth : ListContainerView.this.mUiListContainer.getWidth(), ListContainerView.this.mMeasuredHeight > 0 ? ListContainerView.this.mMeasuredHeight : ListContainerView.this.mUiListContainer.getHeight());
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (ListContainerView.this.mDrawChildHook != null) {
                ListContainerView.this.mDrawChildHook.beforeDispatchDraw(canvas);
            }
            super.dispatchDraw(canvas);
            if (ListContainerView.this.mDrawChildHook != null) {
                ListContainerView.this.mDrawChildHook.afterDispatchDraw(canvas);
            }
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            boolean drawChild;
            Rect beforeDrawChild = ListContainerView.this.mDrawChildHook != null ? ListContainerView.this.mDrawChildHook.beforeDrawChild(canvas, view, j) : null;
            if (beforeDrawChild != null) {
                canvas.save();
                canvas.clipRect(beforeDrawChild);
                drawChild = super.drawChild(canvas, view, j);
                canvas.restore();
            } else {
                drawChild = super.drawChild(canvas, view, j);
            }
            if (ListContainerView.this.mDrawChildHook != null) {
                ListContainerView.this.mDrawChildHook.afterDrawChild(canvas, view, j);
            }
            return drawChild;
        }
    }
}

package com.lynx.tasm.behavior.p000ui.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityWrapper;
import com.lynx.tasm.behavior.p000ui.list.UIList;
import com.lynx.tasm.behavior.p000ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.p000ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.p000ui.utils.LynxUIHelper;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.event.LynxScrollEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.LynxNewGestureDelegate;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.gesture.handler.BaseGestureHandler;
import com.lynx.tasm.utils.PixelUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.UnitUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIScrollView extends AbsLynxUIScroll<AndroidScrollView> implements IScrollSticky, GestureArenaMember, LynxNewGestureDelegate {
    private static final String ACCESSIBILITY_TAG = "LynxAccessibilityScrollView";
    private static final int BORDER_STATUS_LOWER = 2;
    private static final int BORDER_STATUS_UPPER = 1;
    private static final String EVENT_CONTENT_SIZE_CHANGED = "contentsizechanged";
    static final int INVALID_INDEX = -1;
    protected static final String LynxScrollViewInitialScrollIndex = "initialScrollIndex";
    protected static final String LynxScrollViewInitialScrollOffset = "initialScrollOffset";
    protected static final String TAG = "LynxUIScrollView";
    private UIBounceView mBounceView;
    private String mCurrentItemKey;
    private CustomUIScrollViewAccessibilityDelegate mDelegate;
    private boolean mEnableContentSizeChangedEvent;
    private boolean mEnableNewBounce;
    private boolean mEnableScroll;
    private boolean mEnableScrollEndEvent;
    private boolean mEnableScrollEvent;
    private boolean mEnableScrollStartEvent;
    private boolean mEnableScrollTap;
    boolean mEnableScrollToLowerEdgeEvent;
    private boolean mEnableScrollToLowerEvent;
    boolean mEnableScrollToNormalStateEvent;
    boolean mEnableScrollToUpperEdgeEvent;
    private boolean mEnableScrollToUpperEvent;
    private boolean mEnableScrollY;
    private boolean mEnableSticky;
    private UIBounceView mEndUIBounce;
    private int mFadingEdgeLength;
    private int mListSign;
    private int mLowerThreshold;
    private int mPendingInitialScrollOffset;
    private int mPendingInitialScrollToIndex;
    private int mPendingScrollOffset;
    int mPendingScrollToIndex;
    protected boolean mPreferenceConsumeGesture;
    private int mPreviousStatus;
    private HashMap<String, Integer> mPropMap;
    private Callback mScrollToCallback;
    private String mScrollToCallbackInfo;
    private UIBounceView mStartUIBounce;
    private int mUpperThreshold;
    private boolean mUsePagingTouchSlop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isLower(int i) {
        return (i & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isUpper(int i) {
        return (i & 1) != 0;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isScrollContainer() {
        return true;
    }

    public UIScrollView(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIScrollView(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mEnableScrollToUpperEdgeEvent = false;
        this.mEnableScrollToLowerEdgeEvent = false;
        this.mEnableScrollToNormalStateEvent = false;
        this.mEnableSticky = false;
        this.mPreferenceConsumeGesture = false;
        this.mPendingScrollOffset = 0;
        this.mPendingInitialScrollOffset = 0;
        this.mLowerThreshold = 0;
        this.mUpperThreshold = 0;
        this.mPreviousStatus = 1;
        this.mPendingScrollToIndex = -1;
        this.mPendingInitialScrollToIndex = -1;
        this.mEnableNewBounce = false;
        this.mDelegate = null;
        this.mEnableScroll = true;
        this.mUsePagingTouchSlop = false;
        this.mFadingEdgeLength = 0;
        this.mPropMap = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public AndroidScrollView createView(Context context) {
        final AndroidScrollView androidScrollView = new AndroidScrollView(context, this);
        androidScrollView.setOnScrollListener(new AndroidScrollView.OnScrollListener() { // from class: com.lynx.tasm.behavior.ui.scroll.UIScrollView.1
            @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.OnScrollListener
            public void onFling(int i) {
                View view = UIScrollView.this.mView;
                if (view != null && UIScrollView.this.isEnableScrollMonitor()) {
                    UIScrollView.this.getLynxContext().getLynxViewClient().onFling(new LynxViewClient.ScrollInfo(view, UIScrollView.this.getTagName(), UIScrollView.this.getScrollMonitorTag()));
                }
            }

            @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.OnScrollListener
            public void onScrollStart() {
                UIScrollView.this.getLynxContext().getFluencyTraceHelper().start(UIScrollView.this.getSign(), "scroll", UIScrollView.this.getScrollMonitorTag());
                if (UIScrollView.this.mEnableSticky) {
                    UIScrollView.this.onScrollSticky();
                }
                if (UIScrollView.this.mEnableScrollStartEvent) {
                    UIScrollView uIScrollView = UIScrollView.this;
                    uIScrollView.sendCustomEvent(uIScrollView.getScrollX(), UIScrollView.this.getScrollY(), UIScrollView.this.getScrollX(), UIScrollView.this.getScrollY(), LynxScrollEvent.EVENT_SCROLL_START);
                }
                if (UIScrollView.this.isEnableScrollMonitor()) {
                    UIScrollView.this.getLynxContext().getLynxViewClient().onScrollStart(new LynxViewClient.ScrollInfo(androidScrollView, UIScrollView.this.getTagName(), UIScrollView.this.getScrollMonitorTag()));
                }
            }

            @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.OnScrollListener
            public void onScrollStop() {
                UIScrollView.this.getLynxContext().getFluencyTraceHelper().stop(UIScrollView.this.getSign());
                if (UIScrollView.this.mEnableScrollEndEvent) {
                    UIScrollView uIScrollView = UIScrollView.this;
                    uIScrollView.sendCustomEvent(uIScrollView.getScrollX(), UIScrollView.this.getScrollY(), UIScrollView.this.getScrollX(), UIScrollView.this.getScrollY(), LynxScrollEvent.EVENT_SCROLL_END);
                }
                if (!UIScrollView.this.isEnableScrollMonitor() || UIScrollView.this.getLynxContext().getLynxViewClient() == null) {
                    return;
                }
                UIScrollView.this.getLynxContext().getLynxViewClient().onScrollStop(new LynxViewClient.ScrollInfo(androidScrollView, UIScrollView.this.getTagName(), UIScrollView.this.getScrollMonitorTag()));
            }

            @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.OnScrollListener
            public void onScrollChanged(int i, int i2, int i3, int i4) {
                if (UIScrollView.this.mEnableSticky) {
                    UIScrollView.this.onScrollSticky();
                }
                if (UIScrollView.this.mEnableScrollEvent) {
                    UIScrollView.this.sendCustomEvent(i, i2, i3, i4, "scroll");
                }
                if (UIScrollView.this.mEnableScrollToLowerEvent || UIScrollView.this.mEnableScrollToUpperEvent) {
                    int updateBorderStatus = UIScrollView.this.updateBorderStatus(i, i2);
                    if (!UIScrollView.this.mEnableScrollToLowerEvent || !UIScrollView.isLower(updateBorderStatus) || UIScrollView.isLower(UIScrollView.this.mPreviousStatus)) {
                        if (UIScrollView.this.mEnableScrollToUpperEvent && UIScrollView.isUpper(updateBorderStatus) && !UIScrollView.isUpper(UIScrollView.this.mPreviousStatus)) {
                            UIScrollView uIScrollView = UIScrollView.this;
                            uIScrollView.sendCustomEvent(uIScrollView.getScrollX(), UIScrollView.this.getScrollY(), UIScrollView.this.getScrollX(), UIScrollView.this.getScrollY(), "scrolltoupper");
                        }
                    } else {
                        UIScrollView uIScrollView2 = UIScrollView.this;
                        uIScrollView2.sendCustomEvent(uIScrollView2.getScrollX(), UIScrollView.this.getScrollY(), UIScrollView.this.getScrollX(), UIScrollView.this.getScrollY(), "scrolltolower");
                    }
                    UIScrollView.this.mPreviousStatus = updateBorderStatus;
                }
            }

            @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.OnScrollListener
            public void onScrollStateChanged(int i) {
                LLog.i(UIScrollView.TAG, "onScrollStateChanged: " + i);
                UIScrollView.this.recognizeGestureInternal(i);
                if (UIScrollView.this.mScrollToCallback != null && i == 0 && ((AndroidScrollView) UIScrollView.this.mView).mLastScrollState == 3) {
                    Callback callback = UIScrollView.this.mScrollToCallback;
                    String str = UIScrollView.this.mScrollToCallbackInfo;
                    UIScrollView.this.mScrollToCallback = null;
                    UIScrollView.this.mScrollToCallbackInfo = "";
                    callback.invoke(new Object[]{0, str});
                }
            }
        });
        return androidScrollView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void recognizeGestureInternal(int i) {
        if (this.mEnableScrollTap) {
            if (i == 1 || i == 4) {
                recognizeGesturere();
                return;
            }
            return;
        }
        if (i == 0 || i == 3) {
            return;
        }
        recognizeGesturere();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    protected View getRealParentView() {
        AndroidScrollView androidScrollView = (AndroidScrollView) getView();
        return (this.mEnableScrollY || androidScrollView == null) ? androidScrollView : androidScrollView.getHScrollView();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        int i = this.mPaddingLeft + this.mBorderLeftWidth;
        int i2 = this.mPaddingRight + this.mBorderRightWidth;
        ((AndroidScrollView) this.mView).setPadding(i, this.mPaddingTop + this.mBorderTopWidth, i2, this.mPaddingBottom + this.mBorderBottomWidth);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mFadingEdgeLength > 0) {
            ((AndroidScrollView) this.mView).setFadingEdgeLength(this.mFadingEdgeLength);
            ((AndroidScrollView) this.mView).setHorizontalFadingEdgeEnabled(!this.mEnableScrollY);
            ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(this.mEnableScrollY);
        }
        if (this.mUsePagingTouchSlop) {
            if (!this.mEnableScrollY) {
                ((AndroidScrollView) this.mView).getHScrollView().setPagingTouchSlopIfNeeded();
            } else {
                ((AndroidScrollView) this.mView).setPagingTouchSlopIfNeeded();
            }
        }
        this.mFirstRender = false;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void insertChild(LynxBaseUI lynxBaseUI, int i) {
        super.insertChild(lynxBaseUI, i);
        if (lynxBaseUI instanceof UIBounceView) {
            UIBounceView uIBounceView = (UIBounceView) lynxBaseUI;
            if (this.mEnableNewBounce) {
                int i2 = uIBounceView.mDirection;
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.mStartUIBounce = uIBounceView;
                        return;
                    } else if (i2 != 3) {
                        return;
                    }
                }
                this.mEndUIBounce = uIBounceView;
                return;
            }
            this.mBounceView = uIBounceView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScrollSticky() {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        for (int i = 0; i < this.mChildren.size(); i++) {
            this.mChildren.get(i).checkStickyOnParentScroll(scrollX, scrollY);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setLynxDirection(int i) {
        ((AndroidScrollView) this.mView).mDirectionChanged = i != this.mLynxDirection;
        this.mLynxDirection = i;
        if (i == 2) {
            ViewCompat.setLayoutDirection(this.mView, 1);
            ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getHScrollView(), 1);
            ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getLinearLayout(), 1);
        } else {
            ViewCompat.setLayoutDirection(this.mView, 0);
            ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getHScrollView(), 0);
            ViewCompat.setLayoutDirection(((AndroidScrollView) this.mView).getLinearLayout(), 0);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void measure() {
        boolean z = ((AndroidScrollView) this.mView).getOrientation() == 0;
        int width = getWidth();
        int height = getHeight();
        for (int i = 0; i < getChildCount(); i++) {
            LynxBaseUI childAt = getChildAt(i);
            if (z) {
                width = Math.max(width, childAt.getWidth() + childAt.getLeft() + childAt.getMarginRight() + this.mPaddingRight);
            } else {
                height = Math.max(height, childAt.getHeight() + childAt.getTop() + childAt.getMarginBottom() + this.mPaddingBottom);
            }
        }
        if (((AndroidScrollView) this.mView).getContentWidth() != width || ((AndroidScrollView) this.mView).getContentHeight() != height) {
            onContentSizeChanged(width, height);
            ((AndroidScrollView) this.mView).setMeasuredSize(width, height);
            ((AndroidScrollView) this.mView).sendScrollToEdgeEvent(((AndroidScrollView) this.mView).getScrollX(), ((AndroidScrollView) this.mView).getScrollY());
        }
        super.measure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void layout() {
        if (getOverflow() != 0) {
            ((AndroidScrollView) this.mView).setClipChildren(false);
            if (((AndroidScrollView) this.mView).getHScrollView() != null) {
                ((AndroidScrollView) this.mView).getHScrollView().setClipChildren(false);
            }
            if (((AndroidScrollView) this.mView).getLinearLayout() != null) {
                ((AndroidScrollView) this.mView).getLinearLayout().setClipToPadding(false);
            }
        }
        boolean z = this.mEnableNewBounce;
        if (z && !this.mEnableScrollY) {
            UIBounceView uIBounceView = this.mStartUIBounce;
            ((AndroidScrollView) this.mView).getHScrollView().setBounceScrollRange(getScrollRange(), uIBounceView != null ? uIBounceView.getWidth() : 0);
        } else if (z && this.mEnableScrollY) {
            UIBounceView uIBounceView2 = this.mStartUIBounce;
            ((AndroidScrollView) this.mView).setBounceScrollRange(getScrollRange(), uIBounceView2 != null ? uIBounceView2.getHeight() : 0);
        }
        super.layout();
        int i = this.mPendingScrollOffset;
        if (i > 0) {
            if (this.mEnableScrollY && i + getHeight() <= ((AndroidScrollView) getView()).getContentHeight()) {
                ((AndroidScrollView) getView()).setScrollTo(((AndroidScrollView) getView()).getRealScrollX(), this.mPendingScrollOffset, false);
                this.mPendingScrollOffset = 0;
            } else {
                if (this.mEnableScrollY || this.mPendingScrollOffset + getWidth() > ((AndroidScrollView) getView()).getContentWidth()) {
                    return;
                }
                ((AndroidScrollView) getView()).setScrollTo(this.mPendingScrollOffset, ((AndroidScrollView) getView()).getRealScrollY(), false);
                this.mPendingScrollOffset = 0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReload() {
        super.onNodeReload();
        if (this.mLynxDirection == 2) {
            ((AndroidScrollView) getView()).setScrollTo(getScrollRange(), 0, false);
        } else {
            ((AndroidScrollView) getView()).setScrollTo(0, 0, false);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public void invalidate() {
        ((AndroidScrollView) this.mView).getLinearLayout().invalidate();
        ((AndroidScrollView) this.mView).invalidate();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        this.mScrollToCallback = null;
        ((AndroidScrollView) this.mView).clearOnScrollListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public Rect getBoundRectForOverflow() {
        return super.getClipBounds();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setScrollY(boolean z) {
        this.mEnableScrollY = z;
        handleScrollDirection();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setScrollX(boolean z) {
        this.mEnableScrollY = !z;
        handleScrollDirection();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setScrollBarEnable(boolean z) {
        try {
            ((AndroidScrollView) this.mView).setScrollBarEnable(Boolean.valueOf(z).booleanValue());
        } catch (Exception e) {
            LLog.e("UIScrollView", e.getMessage());
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.IScrollSticky
    public void setEnableSticky() {
        this.mEnableSticky = true;
        onScrollSticky();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setUpperThreshole(int i) {
        this.mUpperThreshold = i;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setLowerThreshole(int i) {
        this.mLowerThreshold = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setScrollTopInner(int i, boolean z, boolean z2) {
        int realScrollX = ((AndroidScrollView) getView()).getRealScrollX();
        if (z) {
            i = (int) PixelUtils.dipToPx(i);
        }
        if (!z2 && getHeight() + i <= ((AndroidScrollView) getView()).getContentHeight()) {
            ((AndroidScrollView) getView()).setScrollTo(realScrollX, i, false);
            this.mPendingScrollOffset = 0;
        } else if (z2) {
            setPendingInitialScrollOffset(i);
        } else {
            this.mPendingScrollOffset = i;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setScrollTop(int i) {
        setScrollTopInner(i, true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setScrollLeftInner(int i, boolean z, boolean z2) {
        int realScrollY = ((AndroidScrollView) getView()).getRealScrollY();
        if (z) {
            i = (int) PixelUtils.dipToPx(i);
        }
        if (!z2 && getWidth() + i <= ((AndroidScrollView) getView()).getContentWidth()) {
            ((AndroidScrollView) getView()).setScrollTo(i, realScrollY, false);
            this.mPendingScrollOffset = 0;
        } else if (z2) {
            setPendingInitialScrollOffset(i);
        } else {
            this.mPendingScrollOffset = i;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setScrollLeft(int i) {
        setScrollLeftInner(i, true, false);
    }

    protected void scrollToIndexInner(int i, boolean z) {
        if (this.mView == 0 || ((AndroidScrollView) this.mView).getLinearLayout() == null) {
            return;
        }
        if (z) {
            setPendingInitialScrollToIndex(-1);
        } else {
            this.mPendingScrollToIndex = -1;
        }
        if (i < 0) {
            LLog.e(TAG, "Invalid scroll-to-index with index < 0: " + i);
            return;
        }
        if (this.mChildren.size() == 0) {
            if (z) {
                setPendingInitialScrollToIndex(i);
                return;
            } else {
                this.mPendingScrollToIndex = i;
                return;
            }
        }
        if (i >= this.mChildren.size()) {
            LLog.e(TAG, "Invalid scroll-to-index with index out of boundary: " + i);
            return;
        }
        if (canInvokeScrollImmediately() && !z) {
            ((AndroidScrollView) this.mView).setScrollToIndex(i);
        } else if (z) {
            setPendingInitialScrollToIndex(i);
        } else {
            this.mPendingScrollToIndex = i;
        }
    }

    private String constructListStateCacheKey() {
        return constructListStateCacheKey(getTagName(), this.mCurrentItemKey, getIdSelector());
    }

    private void setPendingInitialScrollToIndex(int i) {
        if (i == -1) {
            this.mPendingInitialScrollToIndex = -1;
        } else {
            if (getParentList() != null) {
                if (getParentList().initialPropsFlushed(LynxScrollViewInitialScrollIndex, constructListStateCacheKey())) {
                    i = -1;
                }
                this.mPendingInitialScrollToIndex = i;
                return;
            }
            this.mPendingInitialScrollToIndex = i;
        }
    }

    private void setPendingInitialScrollOffset(int i) {
        if (i == 0) {
            this.mPendingInitialScrollOffset = 0;
        } else {
            if (getParentList() != null) {
                if (getParentList().initialPropsFlushed(LynxScrollViewInitialScrollOffset, constructListStateCacheKey())) {
                    i = 0;
                }
                this.mPendingInitialScrollOffset = i;
                return;
            }
            this.mPendingInitialScrollOffset = i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleComputeScroll() {
        if (this.mPendingInitialScrollOffset > 0 && (this.mFirstRender || getParentList() == null || !getParentList().initialPropsFlushed(LynxScrollViewInitialScrollOffset, constructListStateCacheKey()))) {
            if (getParentList() != null) {
                getParentList().setInitialPropsHasFlushed(LynxScrollViewInitialScrollOffset, constructListStateCacheKey());
            }
            if (this.mEnableScrollY && this.mPendingInitialScrollOffset + getHeight() <= ((AndroidScrollView) getView()).getContentHeight()) {
                ((AndroidScrollView) getView()).setScrollTo(((AndroidScrollView) getView()).getRealScrollX(), this.mPendingInitialScrollOffset, false);
                setPendingInitialScrollOffset(0);
            } else if (!this.mEnableScrollY && this.mPendingInitialScrollOffset + getWidth() <= ((AndroidScrollView) getView()).getContentWidth()) {
                ((AndroidScrollView) getView()).setScrollTo(this.mPendingInitialScrollOffset, ((AndroidScrollView) getView()).getRealScrollY(), false);
                setPendingInitialScrollOffset(0);
            }
        }
        if (this.mPendingInitialScrollToIndex != -1) {
            if (this.mFirstRender || getParentList() == null || !getParentList().initialPropsFlushed(LynxScrollViewInitialScrollIndex, constructListStateCacheKey())) {
                if (getParentList() != null) {
                    getParentList().setInitialPropsHasFlushed(LynxScrollViewInitialScrollIndex, constructListStateCacheKey());
                }
                ((AndroidScrollView) this.mView).setScrollToIndex(this.mPendingInitialScrollToIndex);
            }
            this.mPendingInitialScrollToIndex = -1;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void scrollToIndex(int i) {
        scrollToIndexInner(i, false);
    }

    @LynxProp(customType = "vertical", name = "scroll-orientation")
    public void setScrollOrientation(String str) {
        if (TextUtils.equals(str, "vertical")) {
            this.mEnableScrollY = true;
        } else if (TextUtils.equals(str, "horizontal")) {
            this.mEnableScrollY = false;
        } else {
            this.mEnableScrollY = true;
        }
        handleScrollDirection();
    }

    @LynxProp(defaultBoolean = false, name = "enable-nested-scroll")
    public void setEnableNestedScroll(boolean z) {
        if (this.mView == 0) {
            return;
        }
        ((AndroidScrollView) this.mView).setNestedScrollingEnabled(z);
        if (((AndroidScrollView) this.mView).getHScrollView() != null) {
            ((AndroidScrollView) this.mView).getHScrollView().setNestedScrollingEnabled(z);
        }
    }

    @LynxProp(name = "initial-scroll-to-index")
    public void setInitialScrollToIndex(Integer num) {
        if (num == null) {
            this.mPropMap.remove(LynxScrollViewInitialScrollIndex);
        } else {
            this.mPropMap.put(LynxScrollViewInitialScrollIndex, num);
            scrollToIndexInner(num.intValue(), true);
        }
    }

    @LynxProp(name = "initial-scroll-offset")
    public void setInitialScrollOffset(Integer num) {
        if (num == null) {
            this.mPropMap.remove(LynxScrollViewInitialScrollOffset);
            return;
        }
        this.mPropMap.put(LynxScrollViewInitialScrollOffset, Integer.valueOf((int) PixelUtils.dipToPx(num.intValue())));
        if (this.mEnableScrollY) {
            setScrollTopInner(num.intValue(), true, true);
        } else {
            setScrollLeftInner(num.intValue(), true, true);
        }
    }

    @LynxProp(name = "fading-edge-length")
    public void setFadingEdgeLength(String str) {
        int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(str, 0.0f, 0.0f, this.mContext.getScreenMetrics());
        this.mFadingEdgeLength = pxWithDisplayMetrics;
        if (pxWithDisplayMetrics > 0 || this.mView == 0) {
            return;
        }
        ((AndroidScrollView) this.mView).setHorizontalFadingEdgeEnabled(false);
        ((AndroidScrollView) this.mView).setVerticalFadingEdgeEnabled(false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setScrollTap(boolean z) {
        this.mEnableScrollTap = z;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setEnableScroll(boolean z) {
        if (this.mView != 0) {
            ((AndroidScrollView) this.mView).setEnableScroll(z);
        }
        this.mEnableScroll = z;
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap readableMap) {
        ((AndroidScrollView) this.mView).autoScroll(readableMap);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void sendCustomEvent(int i, int i2, int i3, int i4, String str) {
        LynxScrollEvent createScrollEvent = LynxScrollEvent.createScrollEvent(getSign(), str);
        createScrollEvent.setScrollParams(i, i2, ((AndroidScrollView) this.mView).getContentHeight(), ((AndroidScrollView) this.mView).getContentWidth(), i - i3, i2 - i4);
        if (getLynxContext() != null) {
            getLynxContext().getEventEmitter().sendCustomEvent(createScrollEvent);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void scrollInto(LynxBaseUI lynxBaseUI, boolean z, String str, String str2) {
        scrollInto(lynxBaseUI, z, str, str2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void scrollInto(LynxBaseUI lynxBaseUI, boolean z, String str, String str2, int i) {
        int i2;
        int width;
        int height;
        if (this.mEnableScrollY) {
            if ("nearest".equals(str)) {
                return;
            }
            if ("center".equals(str)) {
                height = 0 - ((((AndroidScrollView) getView()).getHeight() - lynxBaseUI.getHeight()) / 2);
            } else {
                height = "end".equals(str) ? (0 - (((AndroidScrollView) getView()).getHeight() - lynxBaseUI.getHeight())) + i : 0;
            }
            while (lynxBaseUI != this) {
                height += lynxBaseUI.getTop();
                lynxBaseUI = lynxBaseUI.getParentBaseUI();
                while (lynxBaseUI instanceof LynxFlattenUI) {
                    lynxBaseUI = (LynxBaseUI) lynxBaseUI.getParent();
                }
            }
            ((AndroidScrollView) this.mView).setScrollTo(0, Math.max(0, Math.min(height, ((AndroidScrollView) getView()).getContentHeight() - ((AndroidScrollView) getView()).getHeight())), z);
            return;
        }
        if ("nearest".equals(str2)) {
            return;
        }
        if ("center".equals(str2)) {
            width = (((AndroidScrollView) getView()).getWidth() - lynxBaseUI.getWidth()) / 2;
        } else if ("end".equals(str2)) {
            width = ((AndroidScrollView) getView()).getWidth() - lynxBaseUI.getWidth();
        } else {
            i2 = 0;
            while (lynxBaseUI != this) {
                i2 += lynxBaseUI.getLeft();
                lynxBaseUI = lynxBaseUI.getParentBaseUI();
                while (lynxBaseUI instanceof LynxFlattenUI) {
                    lynxBaseUI = (LynxBaseUI) lynxBaseUI.getParent();
                }
            }
            ((AndroidScrollView) this.mView).setScrollTo(Math.max(0, Math.min(i2, ((AndroidScrollView) getView()).getContentWidth() - ((AndroidScrollView) getView()).getWidth())), 0, z);
        }
        i2 = 0 - width;
        while (lynxBaseUI != this) {
        }
        ((AndroidScrollView) this.mView).setScrollTo(Math.max(0, Math.min(i2, ((AndroidScrollView) getView()).getContentWidth() - ((AndroidScrollView) getView()).getWidth())), 0, z);
    }

    private void handleScrollDirection() {
        if (this.mEnableScrollY) {
            ((AndroidScrollView) this.mView).setOrientation(1);
        } else {
            ((AndroidScrollView) this.mView).setOrientation(0);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> map) {
        super.setEvents(map);
        if (map == null) {
            return;
        }
        this.mEnableScrollToUpperEvent = false;
        this.mEnableScrollToLowerEvent = false;
        this.mEnableScrollEvent = false;
        this.mEnableScrollEndEvent = false;
        if (map.containsKey("scrolltolower")) {
            this.mEnableScrollToLowerEvent = true;
        }
        if (map.containsKey(LynxScrollEvent.EVENT_SCROLL_TO_LOWER_EDGE)) {
            this.mEnableScrollToLowerEdgeEvent = true;
        }
        if (map.containsKey("scrolltoupper")) {
            this.mEnableScrollToUpperEvent = true;
        }
        if (map.containsKey(LynxScrollEvent.EVENT_SCROLL_TO_UPPER_EDGE)) {
            this.mEnableScrollToUpperEdgeEvent = true;
        }
        if (map.containsKey(LynxScrollEvent.EVENT_SCROLL_TO_NORMAL_STATE)) {
            this.mEnableScrollToNormalStateEvent = true;
        }
        if (map.containsKey("scroll")) {
            this.mEnableScrollEvent = true;
        }
        if (map.containsKey(LynxScrollEvent.EVENT_SCROLL_START)) {
            this.mEnableScrollStartEvent = true;
        }
        if (map.containsKey(LynxScrollEvent.EVENT_SCROLL_END)) {
            this.mEnableScrollEndEvent = true;
        }
        if (map.containsKey(EVENT_CONTENT_SIZE_CHANGED)) {
            this.mEnableContentSizeChangedEvent = true;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    protected void drawChild(LynxFlattenUI lynxFlattenUI, Canvas canvas) {
        super.drawChild(lynxFlattenUI, canvas);
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollX() {
        return getScrollX();
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getScrollContainerDirection() {
        return ((AndroidScrollView) this.mView).isHorizontal ? -1 : 1;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollY() {
        return getScrollY();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getScrollX() {
        return ((AndroidScrollView) this.mView).getHScrollView().getScrollX();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getScrollY() {
        return ((AndroidScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onInvalidate() {
        if (this.mView == 0 || !isEnableNewGesture()) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    boolean canInvokeScrollImmediately() {
        LinearLayout linearLayout = ((AndroidScrollView) this.mView).getLinearLayout();
        return ((this.mEnableScrollY ? ((AndroidScrollView) this.mView).getHeight() : ((AndroidScrollView) this.mView).getWidth()) == 0 || (this.mEnableScrollY ? linearLayout.getHeight() : linearLayout.getWidth()) == 0) ? false : true;
    }

    private void onContentSizeChanged(float f, float f2) {
        if (this.mEnableContentSizeChangedEvent) {
            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSign(), EVENT_CONTENT_SIZE_CHANGED);
            lynxDetailEvent.addDetail("scrollWidth", Float.valueOf(PixelUtils.pxToDip(f)));
            lynxDetailEvent.addDetail("scrollHeight", Float.valueOf(PixelUtils.pxToDip(f2)));
            if (getLynxContext() != null) {
                getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
            }
        }
    }

    @LynxUIMethod
    public void getScrollInfo(Callback callback) {
        int memberScrollX = getMemberScrollX();
        int memberScrollY = getMemberScrollY();
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putInt("scrollX", LynxUIHelper.px2dip(this.mContext, memberScrollX));
        javaOnlyMap.putInt("scrollY", LynxUIHelper.px2dip(this.mContext, memberScrollY));
        javaOnlyMap.putInt("scrollRange", LynxUIHelper.px2dip(this.mContext, getScrollRange()));
        callback.invoke(new Object[]{0, javaOnlyMap});
    }

    @LynxUIMethod
    public void scrollBy(ReadableMap readableMap, final Callback callback) {
        if (callback == null) {
            return;
        }
        if (readableMap == null || !readableMap.hasKey("offset")) {
            callback.invoke(new Object[]{4, "Invoke scrollBy failed due to param is null"});
        } else {
            final double dipToPx = PixelUtils.dipToPx(readableMap.getDouble("offset", 0.0d));
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.scroll.UIScrollView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UIScrollView.this.m4132lambda$scrollBy$0$comlynxtasmbehavioruiscrollUIScrollView(dipToPx, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$scrollBy$0$com-lynx-tasm-behavior-ui-scroll-UIScrollView, reason: not valid java name */
    public /* synthetic */ void m4132lambda$scrollBy$0$comlynxtasmbehavioruiscrollUIScrollView(double d, Callback callback) {
        float f = (float) d;
        float[] scrollBy = scrollBy(f, f);
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putDouble("consumedX", (int) PixelUtils.pxToDip(scrollBy[0]));
        javaOnlyMap.putDouble("consumedY", (int) PixelUtils.pxToDip(scrollBy[1]));
        javaOnlyMap.putDouble("unconsumedX", (int) PixelUtils.pxToDip(scrollBy[2]));
        javaOnlyMap.putDouble("unconsumedY", (int) PixelUtils.pxToDip(scrollBy[3]));
        callback.invoke(new Object[]{0, javaOnlyMap});
    }

    @LynxUIMethod
    public void scrollTo(ReadableMap readableMap, Callback callback) {
        int i;
        boolean z;
        Callback callback2 = this.mScrollToCallback;
        if (callback2 != null) {
            this.mScrollToCallback = null;
            callback2.invoke(new Object[]{0, "Due to the start of a new scrollTo operation, the previous scrollTo has stopped."});
        }
        if (this.mChildren.isEmpty()) {
            callback.invoke(new Object[]{4, "Invoke scrollTo failed due to empty children."});
            return;
        }
        this.mScrollToCallbackInfo = "";
        double dipToPx = PixelUtils.dipToPx(readableMap.getDouble("offset", 0.0d));
        boolean z2 = readableMap.getBoolean("smooth", false);
        if (readableMap.hasKey("index")) {
            i = readableMap.getInt("index");
            if (i < 0 || i >= this.mChildren.size()) {
                callback.invoke(new Object[]{4, "scrollTo index " + i + " is out of range [0, " + this.mChildren.size() + "]"});
                return;
            }
        } else {
            i = -1;
        }
        if (this.mEnableScrollY) {
            if (i >= 0 && i < this.mChildren.size()) {
                dipToPx += this.mChildren.get(i).getTop();
            }
            if (dipToPx < 0.0d || dipToPx > getScrollRange()) {
                this.mScrollToCallbackInfo = "Target scroll position = " + dipToPx + " is beyond threshold. ";
                dipToPx = MathUtils.clamp(dipToPx, 0.0d, getScrollRange());
                this.mScrollToCallbackInfo += "Clamped to position = " + dipToPx;
            }
            z = dipToPx != ((double) getScrollY());
            ((AndroidScrollView) this.mView).setScrollTo(0, (int) dipToPx, z2);
        } else {
            if (i >= 0 && i < this.mChildren.size()) {
                dipToPx = this.mLynxDirection == 2 ? Math.max(0.0d, ((this.mChildren.get(i).getLeft() + this.mChildren.get(i).getWidth()) - getWidth()) - dipToPx) : dipToPx + this.mChildren.get(i).getLeft();
            }
            if (dipToPx < 0.0d || dipToPx > getScrollRange()) {
                this.mScrollToCallbackInfo = "Target scroll position = " + dipToPx + " is beyond threshold. ";
                dipToPx = MathUtils.clamp(dipToPx, 0.0d, getScrollRange());
                this.mScrollToCallbackInfo += "Clamped to position = " + dipToPx;
            }
            z = dipToPx != ((double) getScrollX());
            ((AndroidScrollView) this.mView).setScrollTo((int) dipToPx, 0, z2);
        }
        if (z2 && z) {
            this.mScrollToCallback = callback;
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mScrollToCallbackInfo.isEmpty() ? 0 : 4);
        objArr[1] = this.mScrollToCallbackInfo;
        callback.invoke(objArr);
        this.mScrollToCallback = null;
        this.mScrollToCallbackInfo = "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollToBounce(boolean z) {
        UIBounceView uIBounceView;
        if (this.mEnableNewBounce || (uIBounceView = this.mBounceView) == null) {
            return;
        }
        int i = -1;
        if (this.mEnableScrollY) {
            int i2 = uIBounceView.mDirection;
            UIBounceView uIBounceView2 = this.mBounceView;
            if (i2 == 3 && uIBounceView2.getTop() < getScrollY() + getHeight()) {
                i = this.mBounceView.getTop() - getHeight();
            } else {
                int i3 = this.mBounceView.mDirection;
                UIBounceView uIBounceView3 = this.mBounceView;
                if (i3 == 2 && uIBounceView3.getHeight() > getScrollY()) {
                    i = this.mBounceView.getHeight();
                }
            }
            if (i > 0) {
                flingY(0.0d);
                ((AndroidScrollView) this.mView).setScrollTo(0, i, z);
                return;
            }
            return;
        }
        int i4 = uIBounceView.mDirection;
        UIBounceView uIBounceView4 = this.mBounceView;
        if (i4 == 0 && uIBounceView4.getLeft() < getScrollX() + getWidth()) {
            i = this.mBounceView.getLeft() - getWidth();
        } else {
            int i5 = this.mBounceView.mDirection;
            UIBounceView uIBounceView5 = this.mBounceView;
            if (i5 == 1 && uIBounceView5.getWidth() > getScrollX()) {
                i = this.mBounceView.getWidth();
            }
        }
        if (i > 0) {
            flingX(0.0d);
            ((AndroidScrollView) this.mView).setScrollTo(i, 0, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int updateBorderStatus(int i, int i2) {
        return updateBorderStatus(i, i2, this.mUpperThreshold, this.mLowerThreshold);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int updateBorderStatus(int i, int i2, int i3, int i4) {
        if (this.mEnableScrollY) {
            return computeStatus(i2, i3, i4, 1, 2);
        }
        if (this.mLynxDirection == 2) {
            return computeStatus(i, i4, i3, 2, 1);
        }
        return computeStatus(i, i3, i4, 1, 2);
    }

    private int computeStatus(int i, int i2, int i3, int i4, int i5) {
        int measuredWidth;
        int measuredWidth2;
        int i6 = i <= i2 ? i4 | 0 : 0;
        if (((AndroidScrollView) this.mView).getHScrollView() == null) {
            return i6;
        }
        View childAt = ((AndroidScrollView) this.mView).getHScrollView().getChildAt(0);
        if (this.mEnableScrollY) {
            measuredWidth = childAt.getMeasuredHeight();
            measuredWidth2 = ((AndroidScrollView) this.mView).getMeasuredHeight();
        } else {
            measuredWidth = childAt.getMeasuredWidth();
            measuredWidth2 = ((AndroidScrollView) this.mView).getMeasuredWidth();
        }
        return i >= (measuredWidth - measuredWidth2) - i3 ? i6 | i5 : i6;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public boolean canScroll(int i) {
        if (this.mView == 0) {
            return false;
        }
        if (i == 0) {
            return ((AndroidScrollView) this.mView).canScrollVertically(-1);
        }
        if (i == 1) {
            return ((AndroidScrollView) this.mView).canScrollVertically(1);
        }
        if (i == 2) {
            return ((AndroidScrollView) this.mView).getHScrollView().canScrollHorizontally(-1);
        }
        if (i != 3) {
            return false;
        }
        return ((AndroidScrollView) this.mView).getHScrollView().canScrollHorizontally(1);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void scrollByX(double d) {
        if (this.mView == 0) {
            return;
        }
        int scrollX = getScrollX();
        ((AndroidScrollView) this.mView).setScrollTo(scrollX + ((int) d), getScrollY(), false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void scrollByY(double d) {
        if (this.mView == 0) {
            return;
        }
        ((AndroidScrollView) this.mView).setScrollTo(getScrollX(), getScrollY() + ((int) d), false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void flingX(double d) {
        if (this.mView == 0) {
            return;
        }
        ((AndroidScrollView) this.mView).getHScrollView().fling((int) d);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void flingY(double d) {
        if (this.mView == 0) {
            return;
        }
        ((AndroidScrollView) this.mView).fling((int) d);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setForbidFlingFocusChange(boolean z) {
        if (this.mView != 0) {
            ((AndroidScrollView) this.mView).setForbidFlingFocusChange(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setBlockDescendantFocusability(boolean z) {
        if (this.mView != 0) {
            ((AndroidScrollView) this.mView).setBlockDescendantFocusability(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.mEnableScrollY) {
            ((AndroidScrollView) this.mView).setEnableNewBounce(this.mEnableNewBounce);
        } else {
            ((AndroidScrollView) this.mView).getHScrollView().setEnableNewBounce(this.mEnableNewBounce);
        }
        updateAccessibilityDelegate();
    }

    private void updateAccessibilityDelegate() {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null) {
            if (lynxAccessibilityWrapper.enableDelegate() || lynxAccessibilityWrapper.enableHelper()) {
                if (this.mDelegate == null) {
                    this.mDelegate = new CustomUIScrollViewAccessibilityDelegate();
                }
                if (this.mEnableScrollY) {
                    ViewCompat.setAccessibilityDelegate(this.mView, this.mDelegate);
                    ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), (AccessibilityDelegateCompat) null);
                } else {
                    ViewCompat.setAccessibilityDelegate(this.mView, (AccessibilityDelegateCompat) null);
                    ViewCompat.setAccessibilityDelegate(((AndroidScrollView) this.mView).getHScrollView(), this.mDelegate);
                }
                if (lynxAccessibilityWrapper.enableHelper()) {
                    ViewCompat.setImportantForAccessibility(this.mView, this.mEnableScrollY ? 1 : 2);
                    ViewCompat.setImportantForAccessibility(((AndroidScrollView) this.mView).getHScrollView(), this.mEnableScrollY ? 2 : 1);
                    ViewCompat.setImportantForAccessibility(((AndroidScrollView) this.mView).getLinearLayout(), 2);
                }
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isAccessibilityDirectionVertical() {
        return this.mEnableScrollY;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public View getAccessibilityHostView() {
        return getRealParentView();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean requestChildUIRectangleOnScreen(LynxBaseUI lynxBaseUI, Rect rect, boolean z) {
        int computeScrollDeltaToGetChildRectOnScreen;
        if (!this.mEnableScroll || lynxBaseUI == null) {
            return false;
        }
        rect.offset(lynxBaseUI.getLeft() - lynxBaseUI.getScrollX(), lynxBaseUI.getTop() - lynxBaseUI.getScrollY());
        if (this.mEnableScrollY) {
            computeScrollDeltaToGetChildRectOnScreen = ((AndroidScrollView) this.mView).computeScrollDeltaToGetChildRectOnScreen(rect);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                ((AndroidScrollView) this.mView).setScrollTo(((AndroidScrollView) this.mView).getRealScrollX(), ((AndroidScrollView) this.mView).getRealScrollY() + computeScrollDeltaToGetChildRectOnScreen, z);
            }
        } else {
            computeScrollDeltaToGetChildRectOnScreen = ((AndroidScrollView) this.mView).getHScrollView().computeScrollDeltaToGetChildRectOnScreen(rect);
            if (computeScrollDeltaToGetChildRectOnScreen != 0) {
                ((AndroidScrollView) this.mView).setScrollTo(((AndroidScrollView) this.mView).getRealScrollX() + computeScrollDeltaToGetChildRectOnScreen, ((AndroidScrollView) this.mView).getRealScrollY(), z);
            }
        }
        return computeScrollDeltaToGetChildRectOnScreen != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getViewportSize() {
        int width;
        int paddingRight;
        if (this.mEnableScrollY) {
            width = getHeight() - ((AndroidScrollView) this.mView).getPaddingBottom();
            paddingRight = ((AndroidScrollView) this.mView).getPaddingTop();
        } else {
            width = getWidth() - ((AndroidScrollView) this.mView).getPaddingLeft();
            paddingRight = ((AndroidScrollView) this.mView).getPaddingRight();
        }
        return width - paddingRight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollRange() {
        return (this.mEnableScrollY ? ((AndroidScrollView) this.mView).getContentHeight() : ((AndroidScrollView) this.mView).getContentWidth()) - getViewportSize();
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onGestureScrollBy(final float f, final float f2) {
        if (isEnableNewGesture()) {
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.scroll.UIScrollView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    UIScrollView.this.m7x85205266(f, f2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onGestureScrollBy$1$com-lynx-tasm-behavior-ui-scroll-UIScrollView */
    public /* synthetic */ void m7x85205266(float f, float f2) {
        if (this.mView == 0) {
            return;
        }
        if (((AndroidScrollView) this.mView).isHorizontal && ((AndroidScrollView) this.mView).getHScrollView() != null) {
            ((AndroidScrollView) this.mView).getHScrollView().scrollBy((int) f, 0);
        } else {
            ((AndroidScrollView) this.mView).scrollBy(0, (int) f2);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.gesture.GestureArenaMember
    public Map<Integer, BaseGestureHandler> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean canConsumeGesture(float f, float f2) {
        if (!isEnableNewGesture() || this.mView == 0) {
            return false;
        }
        if (((AndroidScrollView) this.mView).isHorizontal()) {
            if (!isAtBorder(true) || f >= 0.0f) {
                return !isAtBorder(false) || f <= 0.0f;
            }
            return false;
        }
        if (!isAtBorder(true) || f2 >= 0.0f) {
            return !isAtBorder(false) || f2 <= 0.0f;
        }
        return false;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean isAtBorder(boolean z) {
        if (!isEnableNewGesture() || this.mView == 0) {
            return false;
        }
        if (z) {
            if (((AndroidScrollView) this.mView).isHorizontal()) {
                return !canScroll(2);
            }
            return !canScroll(0);
        }
        if (((AndroidScrollView) this.mView).isHorizontal()) {
            return !canScroll(3);
        }
        return !canScroll(1);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, GestureDetector> map) {
        super.setGestureDetectors(map);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected void consumeGesture(boolean z) {
        ((AndroidScrollView) this.mView).consumeGesture(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void interceptGesture(boolean z) {
        ((AndroidScrollView) this.mView).interceptGesture(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.gesture.LynxNewGestureDelegate
    public float[] scrollBy(float f, float f2) {
        float[] fArr = new float[4];
        if (this.mView == 0) {
            return fArr;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        if (((AndroidScrollView) this.mView).isHorizontal) {
            ((AndroidScrollView) this.mView).getHScrollView().scrollBy((int) f, 0);
        } else {
            ((AndroidScrollView) this.mView).scrollBy(0, (int) f2);
        }
        if (Math.abs(f) > Float.MIN_VALUE || Math.abs(f2) > Float.MIN_VALUE) {
            recognizeGesturere();
        }
        if (((AndroidScrollView) getView()).isHorizontal) {
            float scrollX2 = getScrollX() - scrollX;
            fArr[0] = scrollX2;
            fArr[1] = 0.0f;
            fArr[2] = f - scrollX2;
            fArr[3] = f2;
        } else {
            fArr[0] = 0.0f;
            float scrollY2 = getScrollY() - scrollY;
            fArr[1] = scrollY2;
            fArr[2] = f;
            fArr[3] = f2 - scrollY2;
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CustomUIScrollViewAccessibilityDelegate extends AccessibilityDelegateCompat {
        protected CustomUIScrollViewAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            int scrollRange = UIScrollView.this.getScrollRange();
            accessibilityEvent.setScrollable(UIScrollView.this.mEnableScroll && scrollRange > 0);
            accessibilityEvent.setScrollX(((AndroidScrollView) UIScrollView.this.mView).getRealScrollX());
            accessibilityEvent.setScrollY(((AndroidScrollView) UIScrollView.this.mView).getRealScrollY());
            if (UIScrollView.this.mEnableScrollY) {
                accessibilityEvent.setMaxScrollX(((AndroidScrollView) UIScrollView.this.mView).getRealScrollX());
                accessibilityEvent.setMaxScrollY(scrollRange);
            } else {
                accessibilityEvent.setMaxScrollX(scrollRange);
                accessibilityEvent.setMaxScrollY(((AndroidScrollView) UIScrollView.this.mView).getRealScrollY());
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            int scrollRange = UIScrollView.this.getScrollRange();
            boolean z = UIScrollView.this.mEnableScroll && scrollRange > 0;
            accessibilityNodeInfoCompat.setScrollable(z);
            if (z) {
                if (UIScrollView.this.mEnableScrollY) {
                    if (((AndroidScrollView) UIScrollView.this.mView).getRealScrollY() <= 0) {
                        if (((AndroidScrollView) UIScrollView.this.mView).getRealScrollY() < scrollRange) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                            return;
                        }
                        return;
                    }
                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    return;
                }
                if (((AndroidScrollView) UIScrollView.this.mView).getRealScrollX() <= 0) {
                    if (((AndroidScrollView) UIScrollView.this.mView).getRealScrollX() < scrollRange) {
                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                        return;
                    }
                    return;
                }
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            int viewportSize = UIScrollView.this.getViewportSize();
            int scrollRange = UIScrollView.this.getScrollRange();
            if (!(UIScrollView.this.mEnableScroll && scrollRange > 0)) {
                return false;
            }
            int realScrollX = ((AndroidScrollView) UIScrollView.this.mView).getRealScrollX();
            int realScrollY = ((AndroidScrollView) UIScrollView.this.mView).getRealScrollY();
            if (i == 4096) {
                if (UIScrollView.this.mEnableScrollY) {
                    int min = Math.min((viewportSize / 2) + realScrollY, scrollRange);
                    if (min != realScrollY) {
                        ((AndroidScrollView) UIScrollView.this.mView).setScrollTo(0, min, true);
                    }
                } else {
                    int min2 = Math.min((viewportSize / 2) + realScrollX, scrollRange);
                    if (min2 != realScrollX) {
                        ((AndroidScrollView) UIScrollView.this.mView).setScrollTo(min2, 0, true);
                    }
                }
                return true;
            }
            if (i != 8192) {
                return false;
            }
            if (UIScrollView.this.mEnableScrollY) {
                int max = Math.max(realScrollY - (viewportSize / 2), 0);
                if (max != realScrollY) {
                    ((AndroidScrollView) UIScrollView.this.mView).setScrollTo(0, max, true);
                }
            } else {
                int max2 = Math.max(realScrollX - (viewportSize / 2), 0);
                if (max2 != realScrollX) {
                    ((AndroidScrollView) UIScrollView.this.mView).setScrollTo(max2, 0, true);
                }
            }
            return true;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.AbsLynxUIScroll
    public void setEnableNewNested(boolean z) {
        if (this.mView == 0) {
            return;
        }
        ((AndroidScrollView) this.mView).setEnableNewNested(z);
        if (((AndroidScrollView) this.mView).getHScrollView() != null) {
            ((AndroidScrollView) this.mView).getHScrollView().setEnableNewNested(z);
        }
    }

    @LynxProp(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean z) {
        this.mPreferenceConsumeGesture = z;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-new-bounce")
    public void setEnableNewBounce(boolean z) {
        this.mEnableNewBounce = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onListCellAppear(String str, LynxBaseUI lynxBaseUI) {
        super.onListCellAppear(str, lynxBaseUI);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mCurrentItemKey = str;
        this.mListSign = lynxBaseUI.getSign();
        String constructListStateCacheKey = constructListStateCacheKey(getTagName(), str, getIdSelector());
        Object valueFromNativeStorage = lynxBaseUI.getValueFromNativeStorage(constructListStateCacheKey);
        if (valueFromNativeStorage != null) {
            int intValue = ((Integer) valueFromNativeStorage).intValue();
            if (((AndroidScrollView) getView()).isHorizontal) {
                setScrollLeftInner(intValue, false, false);
                return;
            } else {
                setScrollTopInner(intValue, false, false);
                return;
            }
        }
        if (this.mPropMap.containsKey(LynxScrollViewInitialScrollIndex) && !lynxBaseUI.initialPropsFlushed(LynxScrollViewInitialScrollIndex, constructListStateCacheKey)) {
            setPendingInitialScrollToIndex(this.mPropMap.get(LynxScrollViewInitialScrollIndex).intValue());
        }
        if (!this.mPropMap.containsKey(LynxScrollViewInitialScrollOffset) || lynxBaseUI.initialPropsFlushed(LynxScrollViewInitialScrollOffset, constructListStateCacheKey)) {
            return;
        }
        setPendingInitialScrollOffset(this.mPropMap.get(LynxScrollViewInitialScrollOffset).intValue());
    }

    private LynxBaseUI getParentList() {
        LynxBaseUI findLynxUIBySign = getLynxContext().getLynxUIOwner().findLynxUIBySign(this.mListSign);
        if ((findLynxUIBySign instanceof UIList) || (findLynxUIBySign instanceof UIListContainer)) {
            return findLynxUIBySign;
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onListCellPrepareForReuse(String str, LynxBaseUI lynxBaseUI) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mListSign = lynxBaseUI.getSign();
        this.mCurrentItemKey = str;
        resetOffset();
    }

    public void resetOffset() {
        if (this.mEnableScrollY) {
            ((AndroidScrollView) this.mView).setScrollTo(0, 0, false);
        } else if (this.mLynxDirection == 2) {
            ((AndroidScrollView) this.mView).setScrollTo(((AndroidScrollView) this.mView).getContentWidth() - ((AndroidScrollView) this.mView).getWidth(), 0, false);
        } else {
            ((AndroidScrollView) this.mView).setScrollTo(0, 0, false);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onListCellDisAppear(String str, LynxBaseUI lynxBaseUI, boolean z) {
        super.onListCellDisAppear(str, lynxBaseUI, z);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String constructListStateCacheKey = constructListStateCacheKey(getTagName(), str, getIdSelector());
        this.mListSign = lynxBaseUI.getSign();
        this.mCurrentItemKey = str;
        if (z) {
            lynxBaseUI.storeKeyToNativeStorage(constructListStateCacheKey, Integer.valueOf(((AndroidScrollView) this.mView).getRealScrollX()));
        } else {
            lynxBaseUI.removeKeyFromNativeStorage(constructListStateCacheKey);
        }
    }

    @LynxProp(name = "android-touch-slop")
    public void setTouchSlop(String str) {
        this.mUsePagingTouchSlop = TextUtils.equals(str, "paging");
    }

    @LynxProp(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean z) {
        if (this.mView != 0) {
            ((AndroidScrollView) this.mView).setForceCanScroll(z);
        }
    }
}

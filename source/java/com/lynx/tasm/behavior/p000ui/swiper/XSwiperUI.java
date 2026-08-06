package com.lynx.tasm.behavior.p000ui.swiper;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityWrapper;
import com.lynx.tasm.behavior.p000ui.list.UIList;
import com.lynx.tasm.behavior.p000ui.swiper.ViewPager;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.utils.ColorUtils;
import com.lynx.tasm.utils.PixelUtils;
import com.lynx.tasm.utils.UnitUtils;
import com.ss.ttm.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@LynxBehavior(isCreateAsync = true, tagName = {"swiper"})
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.swiper")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class XSwiperUI extends UISimpleView<SwiperView> {
    private static final String BIND_CHANGE = "change";
    private static final String BIND_CONTENT_SIZE_CHANGED = "contentsizechanged";
    private static final String BIND_SCROLL_END = "scrollend";
    private static final String BIND_SCROLL_START = "scrollstart";
    private static final String BIND_SCROLL_TO_BOUNCE = "scrolltobounce";
    private static final String BIND_TRANSITION = "transition";
    public static final boolean DEBUG = false;
    private static final String METHOD_PARAMS_DIRECTION = "direction";
    private static final String METHOD_PARAMS_DIRECTION_BEGIN = "begin";
    private static final String METHOD_PARAMS_DIRECTION_END = "end";
    private static final String METHOD_PARAMS_INDEX = "index";
    private static final String METHOD_PARAMS_SMOOTH = "smooth";
    private static final String MODE_CAROUSEL = "carousel";
    private static final String MODE_CARRY = "carry";
    private static final String MODE_COVER_FLOW = "coverflow";
    private static final String MODE_DEFAULT = "normal";
    private static final String MODE_FLAT_COVER_FLOW = "flat-coverflow";
    public static final String TAG = "LynxSwiperUI";
    protected boolean mAttachedToWindow;
    private boolean mAutoPlay;
    private ModeCarryTransformer mCarryTransformer;
    private final List<View> mChildrenList;
    protected boolean mCircular;
    private boolean mCompatible;
    private int mContentHeight;
    private int mContentWidth;
    private ModeCoverFlowTransformer mCoverFlowTransformer;
    private CustomSwiperAccessibilityDelegate mDelegate;
    protected int mDuration;
    private boolean mEnableChangeEvent;
    private boolean mEnableContentSizeChanged;
    private boolean mEnableScrollEnd;
    private boolean mEnableScrollStart;
    private boolean mEnableScrollToBounce;
    private boolean mEnableTransitionEvent;
    protected boolean mFinishReset;
    protected final Handler mHandler;
    protected int mInterval;
    private boolean mIsVertical;
    private long mLastTransitionTime;
    private boolean mLayoutPropsChanged;
    private String mMode;
    private int mNextMargin;
    private int mPageMargin;
    private int mPreviousMargin;
    private Runnable mRunnable;
    private boolean mScrollBeforeDetached;
    protected boolean mSmoothScroll;
    private boolean mTouchable;
    protected int mTransitionThrottle;
    static final int SELECTED_COLOR = Color.argb(255, 255, 255, 255);
    static final int UNSELECTED_COLOR = Color.argb(89, 255, 255, 255);

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public boolean enableAutoClipRadius() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public boolean needCustomLayout() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onListCellPrepareForReuse(String str, LynxBaseUI lynxBaseUI) {
    }

    public XSwiperUI(Context context) {
        super(context);
        this.mMode = "normal";
        this.mEnableChangeEvent = false;
        this.mEnableScrollStart = false;
        this.mEnableScrollEnd = false;
        this.mEnableTransitionEvent = false;
        this.mEnableScrollToBounce = false;
        this.mEnableContentSizeChanged = false;
        this.mContentWidth = -1;
        this.mContentHeight = -1;
        this.mPageMargin = -1;
        this.mNextMargin = -1;
        this.mPreviousMargin = -1;
        this.mIsVertical = false;
        this.mAutoPlay = false;
        this.mCircular = false;
        this.mSmoothScroll = true;
        this.mInterval = 5000;
        this.mDuration = MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE;
        this.mTransitionThrottle = 0;
        this.mLastTransitionTime = 0L;
        this.mAttachedToWindow = false;
        this.mFinishReset = false;
        this.mLayoutPropsChanged = false;
        this.mCompatible = true;
        this.mScrollBeforeDetached = false;
        this.mTouchable = true;
        this.mCoverFlowTransformer = new ModeCoverFlowTransformer();
        this.mCarryTransformer = new ModeCarryTransformer();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mChildrenList = new ArrayList();
        this.mRunnable = new AutoScrollTask(this);
        this.mDelegate = null;
    }

    public XSwiperUI(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public XSwiperUI(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mMode = "normal";
        this.mEnableChangeEvent = false;
        this.mEnableScrollStart = false;
        this.mEnableScrollEnd = false;
        this.mEnableTransitionEvent = false;
        this.mEnableScrollToBounce = false;
        this.mEnableContentSizeChanged = false;
        this.mContentWidth = -1;
        this.mContentHeight = -1;
        this.mPageMargin = -1;
        this.mNextMargin = -1;
        this.mPreviousMargin = -1;
        this.mIsVertical = false;
        this.mAutoPlay = false;
        this.mCircular = false;
        this.mSmoothScroll = true;
        this.mInterval = 5000;
        this.mDuration = MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE;
        this.mTransitionThrottle = 0;
        this.mLastTransitionTime = 0L;
        this.mAttachedToWindow = false;
        this.mFinishReset = false;
        this.mLayoutPropsChanged = false;
        this.mCompatible = true;
        this.mScrollBeforeDetached = false;
        this.mTouchable = true;
        this.mCoverFlowTransformer = new ModeCoverFlowTransformer();
        this.mCarryTransformer = new ModeCarryTransformer();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mChildrenList = new ArrayList();
        this.mRunnable = new AutoScrollTask(this);
        this.mDelegate = null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class AutoScrollTask implements Runnable {
        private WeakReference<XSwiperUI> mWeakUI;

        public AutoScrollTask(XSwiperUI xSwiperUI) {
            this.mWeakUI = new WeakReference<>(xSwiperUI);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            XSwiperUI xSwiperUI = this.mWeakUI.get();
            if (xSwiperUI != null && xSwiperUI.mAttachedToWindow && xSwiperUI.mAutoPlay) {
                ViewPager viewPager = ((SwiperView) xSwiperUI.getView()).getViewPager();
                boolean z = true;
                int currentIndex = viewPager.getCurrentIndex() + 1;
                if (currentIndex == viewPager.getTotalCount() && (xSwiperUI.mFinishReset || xSwiperUI.mCircular)) {
                    currentIndex = 0;
                } else {
                    z = false;
                }
                xSwiperUI.setIndex(viewPager, currentIndex, xSwiperUI.mSmoothScroll, z);
                xSwiperUI.mHandler.postDelayed(this, xSwiperUI.mInterval);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public SwiperView createView(Context context) {
        final SwiperView swiperView = new SwiperView(context);
        swiperView.getViewPager().addPageScrollListener(new ViewPager.OnPageScrollListener() { // from class: com.lynx.tasm.behavior.ui.swiper.XSwiperUI.1
            private boolean mNeedRestartAutoPlay = false;

            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.OnPageScrollListener
            public void onPageScrollStart(int i, boolean z) {
                if (XSwiperUI.this.mEnableScrollStart) {
                    LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(XSwiperUI.this.getSign(), "scrollstart");
                    lynxDetailEvent.addDetail("current", Integer.valueOf(i));
                    lynxDetailEvent.addDetail("isDragged", Boolean.valueOf(z));
                    if (XSwiperUI.this.getLynxContext() != null) {
                        XSwiperUI.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
                    }
                }
            }

            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.OnPageScrollListener
            public void onPageScrolling(int i, boolean z, float f, float f2) {
                XSwiperUI.this.recognizeGesturere();
                if (XSwiperUI.this.mEnableTransitionEvent) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j = currentTimeMillis - XSwiperUI.this.mLastTransitionTime;
                    if (XSwiperUI.this.mTransitionThrottle <= 0 || j > XSwiperUI.this.mTransitionThrottle) {
                        XSwiperUI.this.mLastTransitionTime = currentTimeMillis;
                        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(XSwiperUI.this.getSign(), XSwiperUI.BIND_TRANSITION);
                        lynxDetailEvent.addDetail("current", Integer.valueOf(swiperView.getViewPager().getCurrentIndex()));
                        lynxDetailEvent.addDetail("isDragged", Boolean.valueOf(z));
                        lynxDetailEvent.addDetail("dx", Float.valueOf(PixelUtils.pxToDip(f)));
                        lynxDetailEvent.addDetail("dy", Float.valueOf(PixelUtils.pxToDip(f2)));
                        if (XSwiperUI.this.getLynxContext() != null) {
                            XSwiperUI.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
                        }
                    }
                }
            }

            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.OnPageScrollListener
            public void onPageScrollEnd(int i) {
                if (XSwiperUI.this.mEnableScrollEnd) {
                    LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(XSwiperUI.this.getSign(), "scrollend");
                    lynxDetailEvent.addDetail("current", Integer.valueOf(i));
                    if (XSwiperUI.this.getLynxContext() != null) {
                        XSwiperUI.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
                    }
                }
            }

            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.OnPageScrollListener
            public void onPageChange(int i, int i2, boolean z) {
                ((SwiperView) XSwiperUI.this.mView).setSelected(i2);
                if (!XSwiperUI.this.mEnableChangeEvent || z) {
                    return;
                }
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(XSwiperUI.this.getSign(), "change");
                lynxDetailEvent.addDetail("current", Integer.valueOf(i2));
                if (XSwiperUI.this.getLynxContext() != null) {
                    XSwiperUI.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
                }
            }

            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.OnPageScrollListener
            public void onPageScrollStateChanged(int i, int i2) {
                if (XSwiperUI.this.mAutoPlay) {
                    if (i2 == 1) {
                        this.mNeedRestartAutoPlay = true;
                        XSwiperUI.this.mHandler.removeCallbacks(XSwiperUI.this.mRunnable);
                    } else if (this.mNeedRestartAutoPlay) {
                        this.mNeedRestartAutoPlay = false;
                        XSwiperUI.this.mHandler.removeCallbacks(XSwiperUI.this.mRunnable);
                        XSwiperUI.this.mHandler.postDelayed(XSwiperUI.this.mRunnable, XSwiperUI.this.mInterval);
                    }
                }
            }

            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.OnPageScrollListener
            public void onScrollToBounce(boolean z, boolean z2) {
                if (XSwiperUI.this.mEnableScrollToBounce) {
                    LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(XSwiperUI.this.getSign(), XSwiperUI.BIND_SCROLL_TO_BOUNCE);
                    lynxDetailEvent.addDetail("isToBegin", Boolean.valueOf(z));
                    lynxDetailEvent.addDetail("isToEnd", Boolean.valueOf(z2));
                    if (XSwiperUI.this.getLynxContext() != null) {
                        XSwiperUI.this.getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
                    }
                }
            }
        });
        swiperView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.lynx.tasm.behavior.ui.swiper.XSwiperUI.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                XSwiperUI.this.mAttachedToWindow = true;
                if (XSwiperUI.this.mAutoPlay) {
                    XSwiperUI.this.mHandler.removeCallbacks(XSwiperUI.this.mRunnable);
                    XSwiperUI.this.mHandler.postDelayed(XSwiperUI.this.mRunnable, XSwiperUI.this.mInterval);
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (XSwiperUI.this.mScrollBeforeDetached && ((SwiperView) XSwiperUI.this.mView).getViewPager().mTriggerEvent) {
                    ((SwiperView) XSwiperUI.this.mView).getViewPager().scrollToFinalPositionDirectly();
                }
                XSwiperUI.this.mAttachedToWindow = false;
                XSwiperUI.this.mHandler.removeCallbacks(XSwiperUI.this.mRunnable);
            }
        });
        LLog.i(TAG, "create Android NewSwiperView");
        return swiperView;
    }

    private void onContentSizeChanged(float f, float f2) {
        if (!this.mEnableContentSizeChanged || this.mContext.getScreenMetrics() == null) {
            return;
        }
        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSign(), BIND_CONTENT_SIZE_CHANGED);
        lynxDetailEvent.addDetail("contentWidth", Float.valueOf(PixelUtils.pxToDip(f)));
        lynxDetailEvent.addDetail("contentHeight", Float.valueOf(PixelUtils.pxToDip(f2)));
        if (getLynxContext() != null) {
            getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void insertChild(LynxBaseUI lynxBaseUI, int i) {
        if (lynxBaseUI instanceof LynxUI) {
            this.mChildren.add(i, lynxBaseUI);
            lynxBaseUI.setParent(this);
            this.mChildrenList.add(i, ((LynxUI) lynxBaseUI).getView());
            setAdapter();
            ((SwiperView) getView()).addIndicator();
            applyModeInternal(false, false, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void removeChild(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI instanceof LynxUI) {
            this.mChildren.remove(lynxBaseUI);
            this.mChildrenList.remove(((LynxUI) lynxBaseUI).getView());
            setAdapter();
            ((SwiperView) getView()).removeIndicator();
            applyModeInternal(false, false, true);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> map) {
        super.setEvents(map);
        if (map != null) {
            this.mEnableChangeEvent = map.containsKey("change");
            this.mEnableScrollStart = map.containsKey("scrollstart");
            this.mEnableScrollEnd = map.containsKey("scrollend");
            this.mEnableTransitionEvent = map.containsKey(BIND_TRANSITION);
            this.mEnableScrollToBounce = map.containsKey(BIND_SCROLL_TO_BOUNCE);
            this.mEnableContentSizeChanged = map.containsKey(BIND_CONTENT_SIZE_CHANGED);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.mLayoutPropsChanged) {
            applyModeInternal(false, false, true);
            this.mLayoutPropsChanged = false;
        }
        createAccessibilityDelegateIfNeeded();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        int width = getWidth();
        int height = getHeight();
        super.onLayoutUpdated();
        ((SwiperView) this.mView).setPadding(this.mPaddingLeft + this.mBorderLeftWidth, this.mPaddingTop + this.mBorderTopWidth, this.mPaddingRight + this.mBorderRightWidth, this.mPaddingBottom + this.mBorderBottomWidth);
        this.mChildrenList.clear();
        Iterator<LynxBaseUI> it = this.mChildren.iterator();
        while (it.hasNext()) {
            this.mChildrenList.add(((LynxUI) it.next()).getView());
        }
        setAdapter();
        ((SwiperView) this.mView).setIsRtl(isRtl());
        if (getOverflow() != 0) {
            ((SwiperView) this.mView).setClipChildren(false);
        }
        applyModeInternal(this.mContentWidth != width, this.mContentHeight != height, false);
        if (this.mContentWidth == width && this.mContentHeight == height) {
            return;
        }
        onContentSizeChanged(width, height);
        this.mContentWidth = width;
        this.mContentHeight = height;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReload() {
        super.onNodeReload();
        setCurrentIndexInner(0, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setLynxDirection(int i) {
        super.setLynxDirection(i);
        if (i == 2 || i == 2) {
            ((SwiperView) getView()).setIsRtl(true);
        } else {
            ((SwiperView) getView()).setIsRtl(false);
        }
        this.mLayoutPropsChanged = true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isAccessibilityDirectionVertical() {
        return this.mIsVertical;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public View getAccessibilityHostView() {
        return ((SwiperView) this.mView).getViewPager();
    }

    private void createAccessibilityDelegateIfNeeded() {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null) {
            if (lynxAccessibilityWrapper.enableDelegate() || lynxAccessibilityWrapper.enableHelper()) {
                if (this.mDelegate == null) {
                    this.mDelegate = new CustomSwiperAccessibilityDelegate();
                }
                ViewPager viewPager = ((SwiperView) this.mView).getViewPager();
                if (viewPager != null) {
                    ViewCompat.setAccessibilityDelegate(viewPager, this.mDelegate);
                    ViewCompat.setImportantForAccessibility(viewPager, 1);
                    ViewCompat.setImportantForAccessibility(this.mView, 2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CustomSwiperAccessibilityDelegate extends AccessibilityDelegateCompat {
        CustomSwiperAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            if (((SwiperView) XSwiperUI.this.mView).getViewPager() != null) {
                accessibilityEvent.setClassName(ViewPager.class.getName());
                boolean canScroll = canScroll();
                accessibilityEvent.setScrollable(canScroll);
                if (canScroll && accessibilityEvent.getEventType() == 4096) {
                    accessibilityEvent.setItemCount(XSwiperUI.this.mChildrenList.size());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            boolean canScroll = canScroll();
            accessibilityNodeInfoCompat.setScrollable(canScroll);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(), getColumnCountForAccessibility(), false, 0));
            ViewPager viewPager = ((SwiperView) XSwiperUI.this.mView).getViewPager();
            if (!canScroll || viewPager == null) {
                return;
            }
            if (XSwiperUI.this.mIsVertical) {
                if (viewPager.canScrollVertically(1)) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
                if (viewPager.canScrollVertically(-1)) {
                    accessibilityNodeInfoCompat.addAction(8192);
                    return;
                }
                return;
            }
            if (viewPager.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (viewPager.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            ViewPager viewPager = ((SwiperView) XSwiperUI.this.mView).getViewPager();
            if (viewPager != null && viewPager.getCurrentIndex() != -1) {
                int currentIndex = viewPager.getCurrentIndex();
                if (i == 4096) {
                    if (canScrollViewPager(viewPager, 1)) {
                        XSwiperUI.this.setCurrentIndex(currentIndex + 1);
                        return true;
                    }
                } else {
                    if (i != 8192 || !canScrollViewPager(viewPager, -1)) {
                        return false;
                    }
                    XSwiperUI.this.setCurrentIndex(currentIndex - 1);
                    return true;
                }
            }
            return false;
        }

        private int getRowCountForAccessibility() {
            if (((SwiperView) XSwiperUI.this.mView).getViewPager() == null || XSwiperUI.this.mChildrenList == null || XSwiperUI.this.mChildrenList.isEmpty() || !XSwiperUI.this.mIsVertical) {
                return 1;
            }
            return XSwiperUI.this.mChildrenList.size();
        }

        private int getColumnCountForAccessibility() {
            if (((SwiperView) XSwiperUI.this.mView).getViewPager() == null || XSwiperUI.this.mChildrenList == null || XSwiperUI.this.mChildrenList.isEmpty() || XSwiperUI.this.mIsVertical) {
                return 1;
            }
            return XSwiperUI.this.mChildrenList.size();
        }

        private boolean canScroll() {
            return XSwiperUI.this.mTouchable && ((SwiperView) XSwiperUI.this.mView).getViewPager() != null && XSwiperUI.this.mChildrenList != null && XSwiperUI.this.mChildrenList.size() > 1;
        }

        private boolean canScrollViewPager(ViewPager viewPager, int i) {
            return viewPager != null && ((XSwiperUI.this.mIsVertical && viewPager.canScrollVertically(i)) || (!XSwiperUI.this.mIsVertical && viewPager.canScrollHorizontally(i)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setAdapter() {
        ((SwiperView) getView()).getViewPager().setAdapter(new ViewPager.Adapter() { // from class: com.lynx.tasm.behavior.ui.swiper.XSwiperUI.3
            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.Adapter
            public void recycle(ViewGroup viewGroup, int i, View view) {
            }

            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.Adapter
            public int getCount() {
                return XSwiperUI.this.mChildrenList.size();
            }

            @Override // com.lynx.tasm.behavior.ui.swiper.ViewPager.Adapter
            public View get(ViewGroup viewGroup, int i) {
                return (View) XSwiperUI.this.mChildrenList.get(i);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void applyModeInternal(boolean z, boolean z2, boolean z3) {
        ViewPager viewPager = ((SwiperView) getView()).getViewPager();
        int contentSize = getContentSize(this.mIsVertical);
        if (contentSize == 0) {
            return;
        }
        viewPager.setHLayoutUpdated(z);
        viewPager.setVLayoutUpdated(z2);
        viewPager.setPropsUpdated(z3);
        viewPager.setPageMargin(this.mPageMargin);
        String str = this.mMode;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1039745817:
                if (str.equals("normal")) {
                    c = 0;
                    break;
                }
                break;
            case 2908512:
                if (str.equals(MODE_CAROUSEL)) {
                    c = 1;
                    break;
                }
                break;
            case 94431515:
                if (str.equals(MODE_CARRY)) {
                    c = 2;
                    break;
                }
                break;
            case 1720139793:
                if (str.equals(MODE_FLAT_COVER_FLOW)) {
                    c = 3;
                    break;
                }
                break;
            case 1980277093:
                if (str.equals(MODE_COVER_FLOW)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                viewPager.setPageSize(contentSize);
                viewPager.setTransformer(null);
                viewPager.setOffset(0, false);
                break;
            case 1:
                viewPager.setPageSize((int) Math.ceil(contentSize * 0.8f));
                viewPager.setTransformer(null);
                viewPager.setOffset(0, false);
                break;
            case 2:
                viewPager.setTransformer(this.mCarryTransformer);
                if (setOffsetIfNeeded(viewPager, contentSize)) {
                    viewPager.setPageSize(contentSize);
                    viewPager.setOffset(0, false);
                    break;
                }
                break;
            case 3:
                viewPager.setTransformer(null);
                if (setOffsetIfNeeded(viewPager, contentSize)) {
                    viewPager.setPageSize((int) Math.ceil(0.6f * r1));
                    int i = (int) ((contentSize * 0.4f) / 2.0f);
                    if (isRtl() && !this.mIsVertical) {
                        viewPager.setOffset(-i, false);
                        break;
                    } else {
                        viewPager.setOffset(i, false);
                        break;
                    }
                }
                break;
            case 4:
                viewPager.setTransformer(this.mCoverFlowTransformer);
                if (setOffsetIfNeeded(viewPager, contentSize)) {
                    viewPager.setPageSize((int) Math.ceil(0.6f * r1));
                    int i2 = (int) ((contentSize * 0.4f) / 2.0f);
                    if (isRtl() && !this.mIsVertical) {
                        viewPager.setOffset(-i2, false);
                        break;
                    } else {
                        viewPager.setOffset(i2, false);
                        break;
                    }
                }
                break;
        }
        viewPager.requestLayout();
    }

    private boolean setOffsetIfNeeded(ViewPager viewPager, int i) {
        int i2 = this.mPreviousMargin;
        int i3 = this.mNextMargin;
        int i4 = this.mPageMargin;
        int i5 = (((i - i2) - i3) - i4) - i4;
        if (!this.mCompatible) {
            i5 = (i - i2) - i3;
        }
        if (i2 < 0 || i3 < 0 || i5 <= 0) {
            return true;
        }
        viewPager.setPageSize(i5);
        int i6 = this.mPreviousMargin;
        int i7 = this.mPageMargin + i6;
        if (this.mCompatible) {
            i6 = i7;
        }
        if (isRtl() && !this.mIsVertical) {
            viewPager.setOffset(-i6, false);
        } else {
            viewPager.setOffset(i6, false);
        }
        return false;
    }

    private int getContentSize(boolean z) {
        int width;
        int borderRightWidth;
        if (z) {
            width = ((getHeight() - getPaddingTop()) - getPaddingBottom()) - getBorderTopWidth();
            borderRightWidth = getBorderBottomWidth();
        } else {
            width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - getBorderLeftWidth();
            borderRightWidth = getBorderRightWidth();
        }
        return width - borderRightWidth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxUIMethod
    public void scrollTo(ReadableMap readableMap, Callback callback) {
        ViewPager viewPager = ((SwiperView) getView()).getViewPager();
        if (viewPager == null || viewPager.getAdapter() == null) {
            callback.invoke(new Object[]{1, "Check failed when invoking scrollTo method: viewPager == null || adapter == null"});
            return;
        }
        int i = readableMap.getInt(METHOD_PARAMS_INDEX, -1);
        boolean z = readableMap.getBoolean(METHOD_PARAMS_SMOOTH, this.mSmoothScroll);
        int i2 = !readableMap.getString("direction", METHOD_PARAMS_DIRECTION_END).equals(METHOD_PARAMS_DIRECTION_BEGIN) ? 1 : 0;
        if (viewPager.getChildCount() == 0) {
            callback.invoke(new Object[]{1, "Check failed when invoking scrollTo method: no swiper item added to viewpager"});
        } else if (i < 0 || i >= viewPager.getTotalCount()) {
            callback.invoke(new Object[]{4, "Check failed when invoking scrollTo method: index < 0 or index >= data count"});
        } else {
            setIndexImpl(viewPager, i, z, i2);
            callback.invoke(new Object[]{0});
        }
    }

    @LynxProp(name = PropsConstants.MODE)
    public void setMode(String str) {
        this.mMode = str;
        this.mLayoutPropsChanged = true;
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.AUTO_PLAY)
    public void setAutoPlay(boolean z) {
        this.mAutoPlay = z;
        this.mHandler.removeCallbacks(this.mRunnable);
        if (this.mAutoPlay) {
            this.mHandler.postDelayed(this.mRunnable, this.mInterval);
        }
    }

    @LynxProp(defaultBoolean = false, name = "finish-reset")
    public void setFinishReset(boolean z) {
        this.mFinishReset = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void setCurrentIndexInner(int i, boolean z) {
        ViewPager viewPager = ((SwiperView) getView()).getViewPager();
        if (viewPager.getChildCount() > 0) {
            viewPager.setPendingCurrentIndex(i, z);
            setIndex(viewPager, i, z, false);
        } else {
            viewPager.setPendingCurrentIndex(i, false);
        }
    }

    @LynxProp(defaultInt = 0, name = "current")
    public void setCurrentIndex(int i) {
        setCurrentIndexInner(i, this.mSmoothScroll);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public void onListCellAppear(String str, UIList uIList) {
        super.onListCellPrepareForReuse(str, uIList);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String constructListStateCacheKey = constructListStateCacheKey(getTagName(), str, getIdSelector());
        setCurrentIndexInner(uIList.nativeListStateCache.containsKey(constructListStateCacheKey) ? ((Integer) uIList.nativeListStateCache.get(constructListStateCacheKey)).intValue() : -1, false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onListCellDisAppear(String str, LynxBaseUI lynxBaseUI, boolean z) {
        super.onListCellDisAppear(str, lynxBaseUI, z);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String constructListStateCacheKey = constructListStateCacheKey(getTagName(), str, getIdSelector());
        if (z) {
            lynxBaseUI.storeKeyToNativeStorage(constructListStateCacheKey, Integer.valueOf(((SwiperView) this.mView).getViewPager().getCurrentIndex()));
        } else {
            lynxBaseUI.removeKeyFromNativeStorage(constructListStateCacheKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIndex(ViewPager viewPager, int i, boolean z, boolean z2) {
        int totalCount = viewPager.getTotalCount();
        int currentIndex = viewPager.getCurrentIndex();
        boolean z3 = this.mCircular;
        if (z3 && i == 0 && currentIndex == totalCount - 1) {
            setIndexImpl(viewPager, i, z, (totalCount > 2 || z2) ? 1 : 0);
        } else if (z3 && i == totalCount - 1 && currentIndex == 0) {
            setIndexImpl(viewPager, i, z, totalCount <= 2 ? 1 : 0);
        } else {
            setIndexImpl(viewPager, i, z, i >= currentIndex ? 1 : 0);
        }
    }

    private void setIndexImpl(ViewPager viewPager, int i, boolean z, int i2) {
        int totalCount = viewPager.getTotalCount();
        if (i < 0 || i >= totalCount) {
            return;
        }
        viewPager.setCurrentIndex(i, z, i2);
    }

    @LynxProp(name = "page-margin")
    public void setPageMargin(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.String) {
            String asString = dynamic.asString();
            if (asString.endsWith("px") || asString.endsWith("rpx")) {
                int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(asString, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, getLynxContext().getScreenMetrics());
                if (pxWithDisplayMetrics <= 0) {
                    pxWithDisplayMetrics = 0;
                }
                this.mPageMargin = pxWithDisplayMetrics;
                this.mLayoutPropsChanged = true;
            }
        }
    }

    @LynxProp(name = "previous-margin")
    public void setPreviousMargin(Dynamic dynamic) {
        if (dynamic.getType() != ReadableType.String) {
            return;
        }
        String asString = dynamic.asString();
        if (asString.endsWith("px") || asString.endsWith("rpx")) {
            int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(asString, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().getScreenMetrics());
            if (pxWithDisplayMetrics < 0) {
                pxWithDisplayMetrics = -1;
            }
            this.mPreviousMargin = pxWithDisplayMetrics;
            this.mLayoutPropsChanged = true;
        }
    }

    @LynxProp(name = "next-margin")
    public void setNextMargin(Dynamic dynamic) {
        if (dynamic.getType() != ReadableType.String) {
            return;
        }
        String asString = dynamic.asString();
        if (asString.endsWith("px") || asString.endsWith("rpx")) {
            int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(asString, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, getLynxContext().getScreenMetrics());
            if (pxWithDisplayMetrics < 0) {
                pxWithDisplayMetrics = -1;
            }
            this.mNextMargin = pxWithDisplayMetrics;
            this.mLayoutPropsChanged = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "orientation")
    @Deprecated
    public void setOrientation(String str) {
        if ("vertical".equals(str)) {
            this.mIsVertical = true;
            ((SwiperView) getView()).setOrientation(1);
        } else if ("horizontal".equals(str)) {
            this.mIsVertical = false;
            ((SwiperView) getView()).setOrientation(0);
        }
        this.mLayoutPropsChanged = true;
    }

    @LynxProp(defaultBoolean = false, name = "vertical")
    public void setVertical(boolean z) {
        if (z) {
            ((SwiperView) this.mView).setOrientation(1);
        } else {
            ((SwiperView) this.mView).setOrientation(0);
        }
        this.mIsVertical = z;
        this.mLayoutPropsChanged = true;
    }

    @LynxProp(defaultFloat = 0.0f, name = "norm-translation-factor")
    public void setNormalTranslationFactor(double d) {
        if (d > 1.0d || d < -1.0d) {
            return;
        }
        this.mCarryTransformer.setNormTranslationFactor((float) d);
        this.mLayoutPropsChanged = true;
    }

    @LynxProp(defaultInt = 5000, name = "interval")
    public void setInterval(int i) {
        this.mInterval = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultInt = MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE, name = "duration")
    public void setDuration(int i) {
        this.mDuration = i;
        if (this.mSmoothScroll) {
            ((SwiperView) getView()).getViewPager().setAnimDuration(i);
        } else {
            ((SwiperView) getView()).getViewPager().setAnimDuration(0);
        }
    }

    @LynxProp(defaultBoolean = false, name = "circular")
    public void setCircular(boolean z) {
        this.mCircular = z;
        ((SwiperView) this.mView).getViewPager().setLoop(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "touchable")
    public void setTouchable(boolean z) {
        this.mTouchable = z;
        ((SwiperView) getView()).getViewPager().setTouchable(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "smooth-scroll")
    public void setSmoothScroll(boolean z) {
        this.mSmoothScroll = z;
        if (z) {
            ((SwiperView) getView()).getViewPager().setAnimDuration(this.mDuration);
        } else {
            ((SwiperView) getView()).getViewPager().setAnimDuration(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "indicator-dots")
    public void setIndicator(boolean z) {
        ((SwiperView) getView()).enableIndicator(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "indicator-color")
    public void setIndicatorColor(String str) {
        int i;
        try {
            i = ColorUtils.parse(str);
        } catch (Exception unused) {
            i = UNSELECTED_COLOR;
        }
        ((SwiperView) getView()).setUnSelectedColor(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "indicator-active-color")
    public void setIndicatorActiveColor(String str) {
        int i;
        try {
            i = ColorUtils.parse(str);
        } catch (Exception unused) {
            i = SELECTED_COLOR;
        }
        ((SwiperView) getView()).setSelectedColor(i);
    }

    @LynxProp(defaultBoolean = false, name = "keep-item-view")
    public void setKeepItemView(boolean z) {
        ((SwiperView) this.mView).getViewPager().setKeepItemView(z);
    }

    @LynxProp(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean z) {
        ((SwiperView) this.mView).getViewPager().setForceCanScroll(z);
    }

    @LynxProp(defaultBoolean = true, name = "compatible")
    public void setCompatible(boolean z) {
        this.mCompatible = z;
        this.mLayoutPropsChanged = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "enable-vice-loop")
    public void setEnableViceLoop(boolean z) {
        ((SwiperView) getView()).getViewPager().setEnableViceLoop(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "enable-bounce")
    public void setEnableBounce(boolean z) {
        ((SwiperView) getView()).getViewPager().setEnableBounce(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultFloat = 0.3f, name = "bounce-begin-threshold")
    public void setBounceBeginThreshold(float f) {
        ((SwiperView) getView()).getViewPager().setBounceBeginThreshold(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultFloat = 0.3f, name = "bounce-end-threshold")
    public void setBounceEndThreshold(float f) {
        ((SwiperView) getView()).getViewPager().setBounceEndThreshold(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultInt = MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE, name = "bounce-duration")
    public void setBounceDuration(int i) {
        ((SwiperView) getView()).getViewPager().setBounceDuration(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "ignore-layout-update")
    public void setIgnoreLayoutUpdate(boolean z) {
        ((SwiperView) getView()).getViewPager().setIgnoreLayoutUpdate(z);
    }

    @LynxProp(defaultBoolean = false, name = "scroll-before-detached")
    public void setScrollBeforeDetached(boolean z) {
        this.mScrollBeforeDetached = z;
    }

    @LynxProp(name = "max-x-scale")
    public void setMaxXScale(double d) {
        this.mCarryTransformer.setMaxScaleX((float) d);
    }

    @LynxProp(name = "min-x-scale")
    public void setMinXScale(double d) {
        this.mCarryTransformer.setMinScaleX((float) d);
    }

    @LynxProp(name = "max-y-scale")
    public void setMaxYScale(double d) {
        this.mCarryTransformer.setMaxScaleY((float) d);
    }

    @LynxProp(name = "min-y-scale")
    public void setMinYScale(double d) {
        this.mCarryTransformer.setMinScaleY((float) d);
    }

    @LynxProp(defaultInt = 0, name = "transition-throttle")
    public void setTransitionThrottle(int i) {
        this.mTransitionThrottle = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = true, name = "handle-gesture")
    public void setHandleGesture(boolean z) {
        ((SwiperView) getView()).getViewPager().setHandleGesture(z);
    }

    @LynxProp(defaultBoolean = false, name = "enable-nested-child")
    public void setEnableNestedChild(boolean z) {
        ViewPager viewPager = ((SwiperView) this.mView).getViewPager();
        if (viewPager != null) {
            viewPager.setEnableNestedChild(z);
        }
    }
}

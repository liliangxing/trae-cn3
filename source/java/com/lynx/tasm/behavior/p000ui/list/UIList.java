package com.lynx.tasm.behavior.p000ui.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityWrapper;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxNodeProvider;
import com.lynx.tasm.behavior.p000ui.list.FactoredPagerSnapHelper;
import com.lynx.tasm.behavior.p000ui.list.ListLayoutManager;
import com.lynx.tasm.behavior.p000ui.list.ListViewHolder;
import com.lynx.tasm.behavior.p000ui.utils.LynxUIHelper;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.arena.GestureArenaManager;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.gesture.handler.BaseGestureHandler;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.PixelUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.UnitUtils;
import com.lynx.trace.BuildConfig;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIList extends AbsLynxList<RecyclerView> implements GestureArenaMember {
    public static boolean DEBUG = false;
    private static final int DIRECTION_DOWN_OR_RIGHT = 1;
    private static final int DIRECTION_UP_OR_LEFT = -1;
    static int ITEM_HOLDER_TYPE_CLEAR = 1;
    static int ITEM_HOLDER_TYPE_DEFAULT = 0;
    static int ITEM_HOLDER_TYPE_KEEP = 2;
    public static final String TAG = "UIList";
    public Map<String, HashSet<String>> initialFlushPropCache;
    private UIListAdapter mAdapter;
    private AppearEventCourier mAppearEventCourier;
    private boolean mAutoMeasure;
    private int mAutoRatePerFrame;
    private boolean mAutoStopOnBounds;
    int mColumnCount;
    private ArrayList<String> mComponentAccessibilityOrder;
    private ViewGroup mContainerView;
    private int mCrossAxisGap;
    private HashMap<String, ArrayList<LynxNodeProvider.LynxCustomNodeInfo>> mCustomNodeMap;
    private boolean mEnableAsyncList;
    private boolean mEnableFocusSearch;
    protected boolean mEnableGapItemDecoration;
    private boolean mEnableItemPrefetch;
    private boolean mEnableOverflow;
    private boolean mEnableRTL;
    boolean mEnableScroll;
    boolean mEnableSizeCache;
    private boolean mEnableStrictScrollable;
    private FactoredPagerSnapHelper mFactorSnapHelper;
    private boolean mFiberArch;
    private Choreographer.FrameCallback mFrameCallback;
    private GapItemDecoration mGapItemDecoration;
    boolean mIgnoreAttachForBinding;
    private int mInitialScrollIndex;
    public int mItemHolderType;
    ListEventManager mListEventManager;
    private ReadableMap mListNoDiffInfo;
    private ReadableMap mListPlatformInfo;
    private ListScroller mListScroller;
    private ListStickyManager mListStickyManager;
    private String mListType;
    private int mMainAxisGap;
    private float mMaxFlingVelocityPercent;
    private boolean mNeedLayoutComplete;
    protected boolean mNeedUpdateLayoutManager;
    private boolean mNewArch;
    private boolean mNewScrollTop;
    private boolean mPendingOldStickCategory;
    private int mPendingStickyOffset;
    int mPreloadBufferCount;
    ListPreloadCache mPreloadCache;
    private RecyclerView.OnScrollListener mPreloadListener;
    private int mScrollIndex;
    private SnapHelper mSnapHelper;
    private boolean mStackFromEnd;
    private boolean mStart;
    private boolean mTriggerStickyLayout;
    private boolean mUpperLowerSwitch;
    private boolean mVerticalOrientation;
    public Map<String, Object> nativeListStateCache;
    boolean noInvalidate;

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isAccessibilityHostUI() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void sendCustomEvent(int i, int i2, int i3, int i4, String str) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setCacheQueueRatio(Dynamic dynamic) {
    }

    @Deprecated
    public void setInitialRows(Dynamic dynamic) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setScrollStateChangeEventThrottle(String str) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setScrollX(Dynamic dynamic) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setScrollY(Dynamic dynamic) {
    }

    public UIList(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIList(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mColumnCount = 1;
        this.mMainAxisGap = 0;
        this.mCrossAxisGap = 0;
        this.mListType = MonitorConstants.SINGLE;
        this.mNeedUpdateLayoutManager = true;
        this.mAutoMeasure = false;
        this.mNeedLayoutComplete = false;
        this.mEnableScroll = true;
        this.noInvalidate = false;
        this.mInitialScrollIndex = -1;
        this.mPendingStickyOffset = 0;
        this.mPendingOldStickCategory = true;
        this.mNewScrollTop = false;
        this.mVerticalOrientation = true;
        this.nativeListStateCache = new HashMap();
        this.initialFlushPropCache = new HashMap();
        this.mComponentAccessibilityOrder = new ArrayList<>();
        this.mCustomNodeMap = new HashMap<>();
        this.mUpperLowerSwitch = false;
        this.mStart = false;
        this.mAutoRatePerFrame = 0;
        this.mAutoStopOnBounds = true;
        this.mTriggerStickyLayout = false;
        this.mEnableItemPrefetch = true;
        this.mIgnoreAttachForBinding = false;
        this.mEnableAsyncList = false;
        this.mEnableRTL = false;
        this.mEnableSizeCache = false;
        this.mPreloadBufferCount = 0;
        this.mEnableGapItemDecoration = false;
        this.mGapItemDecoration = null;
        this.mItemHolderType = ITEM_HOLDER_TYPE_DEFAULT;
        this.mMaxFlingVelocityPercent = 1.0f;
        this.mPreloadListener = null;
        this.mEnableStrictScrollable = false;
        this.mEnableFocusSearch = true;
        this.mStackFromEnd = false;
        this.mFiberArch = false;
        this.mFrameCallback = null;
        this.mScrollIndex = -1;
        this.mEnableOverflow = false;
        if (DEBUG) {
            LLog.i(TAG, "UIList init");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public RecyclerView createView(Context context) {
        RecyclerView createRecyclerView = createRecyclerView(context);
        createRecyclerView.setClipToPadding(false);
        createRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool() { // from class: com.lynx.tasm.behavior.ui.list.UIList.1
            public void putRecycledView(RecyclerView.ViewHolder viewHolder) {
                if (UIList.this.isAsyncThreadStrategy() && (viewHolder instanceof ListViewHolder)) {
                    ListViewHolder listViewHolder = (ListViewHolder) viewHolder;
                    if (listViewHolder.getUIComponent() != null) {
                        if (UIList.this.mPreloadCache == null || UIList.this.mPreloadBufferCount <= 0) {
                            UIList.this.mAdapter.recycleHolderComponent(listViewHolder);
                        } else {
                            UIList.this.mPreloadCache.enqueueComponentFromRecyclerPool(listViewHolder);
                        }
                    }
                }
                super.putRecycledView(viewHolder);
            }
        });
        this.mListEventManager = new ListEventManager(getLynxContext().getEventEmitter(), createRecyclerView, this);
        this.mAppearEventCourier = new AppearEventCourier(getLynxContext().getEventEmitter(), createRecyclerView);
        createRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.mAdapter = new UIListAdapter(this, this.mAppearEventCourier);
        this.mListScroller = new ListScroller(context, createRecyclerView);
        createRecyclerView.setOverScrollMode(2);
        if (isAsyncThreadStrategy()) {
            LynxFeatureCounter.count(78, this.mContext.getInstanceId());
        }
        return createRecyclerView;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onGestureScrollBy(final float f, final float f2) {
        if (isEnableNewGesture()) {
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.UIList$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UIList.this.m4128lambda$onGestureScrollBy$0$comlynxtasmbehavioruilistUIList(f, f2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onGestureScrollBy$0$com-lynx-tasm-behavior-ui-list-UIList, reason: not valid java name */
    public /* synthetic */ void m4128lambda$onGestureScrollBy$0$comlynxtasmbehavioruilistUIList(float f, float f2) {
        if (this.mView == 0) {
            return;
        }
        this.mView.scrollBy((int) f, (int) f2);
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean canConsumeGesture(float f, float f2) {
        if (!isEnableNewGesture()) {
            return false;
        }
        if (isVertical()) {
            if (!isAtBorder(true) || f2 >= 0.0f) {
                return !isAtBorder(false) || f2 <= 0.0f;
            }
            return false;
        }
        if (!isAtBorder(true) || f >= 0.0f) {
            return !isAtBorder(false) || f <= 0.0f;
        }
        return false;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean isAtBorder(boolean z) {
        if (!isEnableNewGesture()) {
            return false;
        }
        if (z) {
            return !canScroll(-1);
        }
        return !canScroll(1);
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onInvalidate() {
        if (!isEnableNewGesture() || this.mView == 0) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.gesture.GestureArenaMember
    public Map<Integer, BaseGestureHandler> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, GestureDetector> map) {
        super.setGestureDetectors(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class PrivateRecyclerView extends RecyclerView {
        private Boolean mConsumeGesture;
        private ScrollContainerDrawHelper mDrawHelper;
        private boolean mEnableOverflow;
        private Boolean mInterceptGesture;
        private boolean mIsDownEventHandled;
        protected boolean mPreferenceConsumeGesture;
        private boolean mTouchScroll;
        private WeakReference<LynxContext> mWeakContext;
        private WeakReference<UIList> mWeakUIList;

        public PrivateRecyclerView(Context context, UIList uIList) {
            super(context);
            this.mWeakContext = null;
            this.mWeakUIList = null;
            this.mTouchScroll = true;
            this.mPreferenceConsumeGesture = false;
            this.mEnableOverflow = false;
            this.mDrawHelper = new ScrollContainerDrawHelper();
            this.mConsumeGesture = null;
            this.mInterceptGesture = null;
            this.mIsDownEventHandled = true;
            if (context == null || !(context instanceof LynxContext)) {
                return;
            }
            this.mWeakContext = new WeakReference<>((LynxContext) context);
            this.mWeakUIList = new WeakReference<>(uIList);
        }

        protected void onAttachedToWindow() {
            LLog.i(UIList.TAG, "PrivateRecyclerView onAttachedToWindow");
            super.onAttachedToWindow();
        }

        protected void onDetachedFromWindow() {
            LLog.i(UIList.TAG, "PrivateRecyclerView onDetachedFromWindow");
            super.onDetachedFromWindow();
        }

        public void setClipBounds(Rect rect) {
            if (!this.mEnableOverflow) {
                super.setClipBounds(rect);
            } else {
                this.mDrawHelper.setUiBound(rect);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected void dispatchDraw(Canvas canvas) {
            if (!this.mEnableOverflow) {
                super.dispatchDraw(canvas);
                return;
            }
            Path clipPath = this.mDrawHelper.getClipPath(this);
            int save = canvas.save();
            if (clipPath != null) {
                canvas.clipPath(clipPath);
            }
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }

        public void setEnableOverflow(boolean z) {
            this.mEnableOverflow = z;
        }

        public boolean fling(int i, int i2) {
            UIList uIList = this.mWeakUIList.get();
            if (uIList == null) {
                super.fling(i, i2);
            }
            if (uIList.mMaxFlingVelocityPercent > 0.0f && uIList.mMaxFlingVelocityPercent < 1.0f) {
                if (uIList.mVerticalOrientation) {
                    i2 = (int) MathUtils.clamp(i2, (-getMaxFlingVelocity()) * uIList.mMaxFlingVelocityPercent, getMaxFlingVelocity() * uIList.mMaxFlingVelocityPercent);
                } else {
                    i = (int) MathUtils.clamp(i, (-getMaxFlingVelocity()) * uIList.mMaxFlingVelocityPercent, getMaxFlingVelocity() * uIList.mMaxFlingVelocityPercent);
                }
            }
            return super.fling(i, i2);
        }

        public void computeScroll() {
            GestureArenaManager gestureArenaManager;
            super.computeScroll();
            UIList uIList = this.mWeakUIList.get();
            if (uIList == null || !uIList.isEnableNewGesture() || (gestureArenaManager = uIList.getGestureArenaManager()) == null) {
                return;
            }
            gestureArenaManager.computeScroll();
        }

        public boolean canScrollHorizontally(int i) {
            UIList uIList = this.mWeakUIList.get();
            if (uIList != null && uIList.mEnableStrictScrollable) {
                if (i < 0) {
                    if (uIList.findFirstCompleteLyListItem() == 0) {
                        return false;
                    }
                    return super.canScrollHorizontally(i);
                }
                if (i > 0) {
                    if (uIList.findLastCompleteLyListItem() >= getAdapter().getItemCount() - 1) {
                        return false;
                    }
                    return super.canScrollHorizontally(i);
                }
            }
            return super.canScrollHorizontally(i);
        }

        public boolean canScrollVertically(int i) {
            UIList uIList = this.mWeakUIList.get();
            if (uIList != null && uIList.mEnableStrictScrollable) {
                if (i < 0) {
                    if (uIList.findFirstCompleteLyListItem() == 0) {
                        return false;
                    }
                    return super.canScrollVertically(i);
                }
                if (i > 0) {
                    int findLastCompleteLyListItem = uIList.findLastCompleteLyListItem();
                    if (getAdapter() != null) {
                        if (findLastCompleteLyListItem >= getAdapter().getItemCount() - 1) {
                            return false;
                        }
                        return super.canScrollVertically(i);
                    }
                }
            }
            return super.canScrollVertically(i);
        }

        public View focusSearch(View view, int i) {
            WeakReference<UIList> weakReference = this.mWeakUIList;
            return (weakReference == null || weakReference.get() == null || this.mWeakUIList.get().mEnableFocusSearch || !(i == 130 || i == 33)) ? super.focusSearch(view, i) : view;
        }

        private void detectNestedScroll(boolean z) {
            WeakReference<LynxContext> weakReference = this.mWeakContext;
            if (weakReference == null || this.mWeakUIList == null) {
                return;
            }
            LynxContext lynxContext = weakReference.get();
            UIList uIList = this.mWeakUIList.get();
            if (!z || lynxContext == null || uIList == null) {
                return;
            }
            lynxContext.onGestureRecognized(uIList);
        }

        public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
            boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
            detectNestedScroll(dispatchNestedPreScroll);
            return dispatchNestedPreScroll;
        }

        public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
            boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
            detectNestedScroll(dispatchNestedPreScroll);
            return dispatchNestedPreScroll;
        }

        public void setTouchScroll(boolean z) {
            this.mTouchScroll = z;
        }

        private boolean isConsumeGesture(UIList uIList, MotionEvent motionEvent) {
            Boolean bool;
            return (!uIList.isEnableNewGesture() || (bool = this.mConsumeGesture) == null || bool.booleanValue() || motionEvent.getActionMasked() == 0) ? false : true;
        }

        private boolean isNotIncludeNativeGesture(UIList uIList) {
            return uIList.isEnableNewGesture() && !uIList.getIncludeNativeGesture();
        }

        private boolean isInterceptGestureNotNull(UIList uIList) {
            return uIList.isEnableNewGesture() && this.mInterceptGesture != null;
        }

        private boolean isNeedInterceptGesture(UIList uIList) {
            return isInterceptGestureNotNull(uIList) && this.mInterceptGesture.booleanValue();
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (this.mPreferenceConsumeGesture) {
                requestDisallowInterceptTouchEvent(true);
            }
            UIList uIList = this.mWeakUIList.get();
            if (uIList == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (isNotIncludeNativeGesture(uIList) || isConsumeGesture(uIList, motionEvent)) {
                return false;
            }
            if (isNeedInterceptGesture(uIList)) {
                return this.mInterceptGesture.booleanValue();
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            UIList uIList = this.mWeakUIList.get();
            if (uIList == null) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (uIList.isEnableNewGesture()) {
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

        public boolean onTouchEvent(MotionEvent motionEvent) {
            UIList uIList = this.mWeakUIList.get();
            if (uIList == null) {
                return super.onTouchEvent(motionEvent);
            }
            if (isNotIncludeNativeGesture(uIList) || isConsumeGesture(uIList, motionEvent)) {
                return false;
            }
            if (isInterceptGestureNotNull(uIList)) {
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
            if (this.mTouchScroll) {
                return super.onTouchEvent(motionEvent);
            }
            return true;
        }

        public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
            LynxAccessibilityWrapper lynxAccessibilityWrapper;
            WeakReference<LynxContext> weakReference = this.mWeakContext;
            if (weakReference != null && weakReference.get() != null && (lynxAccessibilityWrapper = this.mWeakContext.get().getLynxAccessibilityWrapper()) != null && lynxAccessibilityWrapper.enableDelegate()) {
                return super.requestChildRectangleOnScreen(view, rect, false);
            }
            return super.requestChildRectangleOnScreen(view, rect, z);
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
    }

    protected RecyclerView createRecyclerView(Context context) {
        return new PrivateRecyclerView(context, this);
    }

    public RecyclerView getRecyclerView() {
        return (RecyclerView) getView();
    }

    protected void setAdapter(UIListAdapter uIListAdapter) {
        this.mAdapter = uIListAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UIListAdapter getAdapter() {
        return this.mAdapter;
    }

    protected void setAppearEventCourier(AppearEventCourier appearEventCourier) {
        this.mAppearEventCourier = appearEventCourier;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        ListEventManager listEventManager;
        super.onPropsUpdated();
        if (this.noInvalidate) {
            this.noInvalidate = false;
            return;
        }
        if (this.mView.getAdapter() == null) {
            this.mView.setAdapter(this.mAdapter);
        }
        if (!isNeedRenderComponents()) {
            reportException();
            return;
        }
        if (this.mNewArch) {
            this.mAdapter.isAsync = isAsyncThreadStrategy();
            int i = this.mScrollIndex;
            if (i >= 0 && i < this.mAdapter.getItemCount()) {
                ((RecyclerView) getView()).scrollToPosition(this.mScrollIndex);
                this.mScrollIndex = -1;
            }
            ReadableMap readableMap = this.mListNoDiffInfo;
            if (readableMap != null) {
                this.mAdapter.updateListActionInfo(readableMap);
                this.mListNoDiffInfo = null;
            } else if (this.mListPlatformInfo instanceof ReadableMap) {
                if (this.mPreloadBufferCount > 0 && isAsyncThreadStrategy()) {
                    if (this.mPreloadCache == null) {
                        this.mPreloadCache = new ListPreloadCache(this, this.mPreloadBufferCount);
                    }
                    setPreBufferListener();
                }
                this.mAdapter.updateChildrenInfo((JavaOnlyMap) this.mListPlatformInfo);
                this.mListPlatformInfo = null;
            }
        } else {
            this.mAdapter.updateChildrenInfo(getPlatformInfo());
        }
        updateLayoutMangerIfNeeded();
        setReverseLayout(this.mEnableRTL && isRtl());
        int size = this.mAdapter.mViewNames == null ? 0 : this.mAdapter.mViewNames.size();
        int i2 = this.mInitialScrollIndex;
        if (size > i2 && i2 > -1) {
            this.mListScroller.scrollToPositionInner(i2);
            this.mInitialScrollIndex = -1;
        }
        LLog.i(TAG, "onPropsUpdated viewNames " + size);
        if (this.mListEventManager.isLayoutCompleteEnable()) {
            this.mNeedLayoutComplete = !this.mFiberArch || this.mView.isLayoutRequested();
        }
        ListStickyManager listStickyManager = this.mListStickyManager;
        if (listStickyManager != null) {
            listStickyManager.flushStickyComponent();
            this.mListStickyManager.setUseOldStickCategory(this.mPendingOldStickCategory);
        }
        this.mListScroller.setVerticalOrientation(isVertical());
        if (this.mUpperLowerSwitch && (listEventManager = this.mListEventManager) != null) {
            listEventManager.resetScrollBorderStatus();
        }
        updateGapItemDecorationIfNeed();
    }

    private boolean isNeedRenderComponents() {
        if (!isAsyncThreadStrategy()) {
            return true;
        }
        if (this.mNewArch) {
            return this.mEnableAsyncList;
        }
        return false;
    }

    private void reportException() {
        if (this.mContext == null || this.mContext.getLynxView() == null) {
            return;
        }
        this.mContext.handleLynxError(new LynxError(220207, "Multi thread strategy can not be used by default.", "Please set the attribute of enable-async-list to true at LynxSDK 2.10+ .", "error"));
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutFinish(long j, LynxBaseUI lynxBaseUI) {
        if (isAsyncThreadStrategy()) {
            if (lynxBaseUI instanceof UIComponent) {
                this.mAdapter.onLayoutFinishAsync((UIComponent) lynxBaseUI, j);
                return;
            } else {
                LLog.e(TAG, "component is null! the operationId is " + j);
                return;
            }
        }
        this.mAdapter.onLayoutFinish(j);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        int i = this.mPaddingTop + this.mBorderTopWidth;
        int i2 = this.mPaddingBottom + this.mBorderBottomWidth;
        int i3 = this.mPaddingLeft + this.mBorderLeftWidth;
        int i4 = this.mPaddingRight + this.mBorderRightWidth;
        if (1 == this.mView.getLayoutDirection()) {
            this.mView.setPadding(i4, i, i3, i2);
        } else {
            this.mView.setPadding(i3, i, i4, i2);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList, com.lynx.tasm.behavior.p000ui.UIGroup
    public void onInsertChild(LynxBaseUI lynxBaseUI, int i) {
        if (DEBUG) {
            LLog.i(TAG, "insertChild index: " + i + " child: " + lynxBaseUI);
        }
    }

    public boolean isAsyncThreadStrategy() {
        if (this.mContext == null || this.mContext.getLynxView() == null) {
            return false;
        }
        ThreadStrategyForRendering threadStrategyForRendering = this.mContext.getLynxView().getThreadStrategyForRendering();
        return threadStrategyForRendering == ThreadStrategyForRendering.MOST_ON_TASM || threadStrategyForRendering == ThreadStrategyForRendering.MULTI_THREADS;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void measure() {
        int makeMeasureSpec;
        TraceEvent.beginSection("UIList.measure");
        ViewGroup viewGroup = this.mContainerView;
        if (!(viewGroup != null ? viewGroup.isLayoutRequested() : this.mView.isLayoutRequested())) {
            TraceEvent.endSection("UIList.measure");
            return;
        }
        measureChildren();
        setLayoutParamsInternal();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
        if (this.mAutoMeasure) {
            if (DEBUG) {
                LLog.i(TAG, "UIList autoMeasure maxHeight " + this.mMaxHeight);
            }
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.mMaxHeight, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824);
        }
        ViewGroup viewGroup2 = this.mContainerView;
        if (viewGroup2 != null) {
            viewGroup2.measure(makeMeasureSpec2, makeMeasureSpec);
        }
        this.mView.measure(makeMeasureSpec2, makeMeasureSpec);
        this.mAdapter.mDiffResultConsumed = true;
        TraceEvent.endSection("UIList.measure");
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void layout() {
        TraceEvent.beginSection("UIList.layout");
        ViewGroup viewGroup = this.mContainerView;
        if (!(viewGroup != null ? viewGroup.isLayoutRequested() : this.mView.isLayoutRequested())) {
            TraceEvent.endSection("UIList.layout");
            return;
        }
        layoutChildren();
        ViewGroup viewGroup2 = this.mContainerView;
        if (viewGroup2 != null) {
            viewGroup2.layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        } else {
            this.mView.layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        }
        setClipChildrenInternal();
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
        this.mAppearEventCourier.onListLayout();
        TraceEvent.endSection("UIList.layout");
    }

    private void setClipChildrenInternal() {
        ViewGroup viewGroup;
        if (this.mEnableOverflow) {
            ViewGroup viewGroup2 = this.mContainerView;
            ViewParent parent = viewGroup2 != null ? viewGroup2.getParent() : this.mView.getParent();
            boolean z = getOverflow() != 0;
            if (z && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).setClipChildren(false);
            }
            if (z && (viewGroup = this.mContainerView) != null) {
                viewGroup.setClipChildren(false);
            }
            if (this.mOverflow != 0) {
                this.mView.setOverScrollMode(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public Rect getBoundRectForOverflow() {
        if (!this.mEnableOverflow) {
            return super.getBoundRectForOverflow();
        }
        return super.getClipBounds();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public void requestLayout() {
        this.mView.requestLayout();
        if (this.mView.isLayoutRequested()) {
            return;
        }
        final T t = this.mView;
        this.mView.post(new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.UIList.2
            @Override // java.lang.Runnable
            public void run() {
                t.requestLayout();
            }
        });
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public void layoutChildren() {
        if (this.mTriggerStickyLayout && this.mContainerView != null) {
            UIComponent stickyTopComponent = this.mListStickyManager.getStickyTopComponent();
            if (stickyTopComponent != null) {
                stickyTopComponent.performLayoutChildrenUI();
            }
            UIComponent stickyBottomComponent = this.mListStickyManager.getStickyBottomComponent();
            if (stickyBottomComponent != null) {
                stickyBottomComponent.performLayoutChildrenUI();
            }
        }
        super.layoutChildren();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected void consumeGesture(boolean z) {
        if (this.mView instanceof PrivateRecyclerView) {
            ((PrivateRecyclerView) this.mView).consumeGesture(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void interceptGesture(boolean z) {
        if (this.mView instanceof PrivateRecyclerView) {
            ((PrivateRecyclerView) this.mView).interceptGesture(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.gesture.LynxNewGestureDelegate
    public float[] scrollBy(float f, float f2) {
        float[] fArr = new float[4];
        this.mView.scrollBy((int) f, (int) f2);
        if (Math.abs(f) > Float.MIN_VALUE || Math.abs(f2) > Float.MIN_VALUE) {
            recognizeGesturere();
        }
        if (!(this.mView.getLayoutManager() instanceof ListLayoutManager.ListLayoutInfo)) {
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = f;
            fArr[3] = f2;
        } else if (isVertical()) {
            fArr[0] = 0.0f;
            float consumedY = this.mView.getLayoutManager().getConsumedY();
            fArr[1] = consumedY;
            fArr[2] = f;
            fArr[3] = f2 - consumedY;
        } else {
            float consumedX = this.mView.getLayoutManager().getConsumedX();
            fArr[0] = consumedX;
            fArr[1] = 0.0f;
            fArr[2] = f - consumedX;
            fArr[3] = f2;
        }
        return fArr;
    }

    @LynxProp(defaultBoolean = false, name = "enable-new-exposure-strategy")
    public void setNewAppear(boolean z) {
        this.mAppearEventCourier.setNewAppear(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setUpperThreshold(Dynamic dynamic) {
        this.mListEventManager.setUpperThreshold(dynamic);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setLowerThreshold(Dynamic dynamic) {
        this.mListEventManager.setLowerThreshold(dynamic);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setUpperThresholdItemCount(Dynamic dynamic) {
        this.mListEventManager.setUpperThresholdItemCount(dynamic);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setLowerThresholdItemCount(Dynamic dynamic) {
        this.mListEventManager.setLowerThresholdItemCount(dynamic);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setScrollEventThrottle(Dynamic dynamic) {
        this.mListEventManager.setScrollEventThrottle(dynamic);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setColumnCount(int i) {
        if (this.mColumnCount == i) {
            return;
        }
        this.mColumnCount = i;
        GridLayoutManager layoutManager = this.mView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            layoutManager.setSpanCount(this.mColumnCount);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) layoutManager).setSpanCount(this.mColumnCount);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setMainAxisGap(float f) {
        this.mMainAxisGap = Math.round(f);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setCrossAxisGap(float f) {
        this.mCrossAxisGap = Math.round(f);
        RecyclerView.LayoutManager layoutManager = this.mView.getLayoutManager();
        if (layoutManager instanceof ListLayoutManager.ListGridLayoutManager) {
            ((ListLayoutManager.ListGridLayoutManager) layoutManager).setCrossAxisGap(getCrossAxisGap());
        } else if (layoutManager instanceof ListLayoutManager.ListStaggeredGridLayoutManager) {
            ((ListLayoutManager.ListStaggeredGridLayoutManager) layoutManager).setCrossAxisGap(getCrossAxisGap());
        }
    }

    public int getMainAxisGap() {
        if (this.mEnableGapItemDecoration) {
            return 0;
        }
        return this.mMainAxisGap;
    }

    public int getCrossAxisGap() {
        if (this.mEnableGapItemDecoration) {
            return 0;
        }
        return this.mCrossAxisGap;
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setListType(String str) {
        if (TextUtils.isEmpty(str)) {
            str = MonitorConstants.SINGLE;
        }
        if (TextUtils.equals(str, this.mListType)) {
            return;
        }
        this.mNeedUpdateLayoutManager = true;
        this.mListType = str;
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setUpdateAnimation(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, BuildConfig.enable_trace)) {
            this.mView.setItemAnimator((RecyclerView.ItemAnimator) null);
        }
        if (TextUtils.equals(str, DownloadSettingKeys.BugFix.DEFAULT)) {
            this.mView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setEnablePagerSnap(Dynamic dynamic) {
        if (ListEventManager.dynamicToBoolean(dynamic, false) && this.mFactorSnapHelper == null) {
            if (this.mSnapHelper == null) {
                this.mSnapHelper = new PagerSnapHelper();
            }
            this.mSnapHelper.attachToRecyclerView(this.mView);
        } else {
            SnapHelper snapHelper = this.mSnapHelper;
            if (snapHelper != null) {
                snapHelper.attachToRecyclerView((RecyclerView) null);
                this.mSnapHelper = null;
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setPagingAlignment(ReadableMap readableMap) {
        if ((readableMap instanceof JavaOnlyMap) && ((JavaOnlyMap) readableMap).size() != 0) {
            double d = readableMap.getDouble("factor");
            if (d < 0.0d || d > 1.0d) {
                getLynxContext().handleLynxError(new LynxError(220205, "item-snap invalid!", "The factor should be constrained to the range of [0,1].", "warn"));
                d = 0.0d;
            }
            int i = readableMap.getInt("offset", 0);
            if (this.mFactorSnapHelper == null) {
                FactoredPagerSnapHelper factoredPagerSnapHelper = new FactoredPagerSnapHelper();
                this.mFactorSnapHelper = factoredPagerSnapHelper;
                factoredPagerSnapHelper.attachToRecyclerView(this.mView);
                this.mFactorSnapHelper.mPagerHooks = new FactoredPagerSnapHelper.FactoredPagerHooks() { // from class: com.lynx.tasm.behavior.ui.list.UIList.3
                    @Override // com.lynx.tasm.behavior.ui.list.FactoredPagerSnapHelper.FactoredPagerHooks
                    public void willSnapTo(int i2, int i3, int i4, int i5, int i6) {
                        UIList.this.willSnapTo(i2, i3, i4, i5, i6);
                    }
                };
            }
            this.mFactorSnapHelper.setPagerAlignFactor(d);
            this.mFactorSnapHelper.setPagerAlignOffset(i);
            return;
        }
        FactoredPagerSnapHelper factoredPagerSnapHelper2 = this.mFactorSnapHelper;
        if (factoredPagerSnapHelper2 != null) {
            factoredPagerSnapHelper2.attachToRecyclerView(null);
            this.mFactorSnapHelper = null;
        }
    }

    public void willSnapTo(int i, int i2, int i3, int i4, int i5) {
        if (!this.mVerticalOrientation) {
            i2 = this.mListEventManager.getScrollOffset();
        }
        if (this.mVerticalOrientation) {
            i3 = this.mListEventManager.getScrollOffset();
        }
        int i6 = i4 + i2;
        int i7 = i5 + i3;
        if (i2 == i6 && i3 == i7) {
            return;
        }
        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSign(), "snap");
        lynxDetailEvent.addDetail(PropsConstants.POSITION, Integer.valueOf(i));
        lynxDetailEvent.addDetail("currentScrollLeft", Float.valueOf(PixelUtils.pxToDip(i2)));
        lynxDetailEvent.addDetail("currentScrollTop", Float.valueOf(PixelUtils.pxToDip(i3)));
        lynxDetailEvent.addDetail("targetScrollLeft", Float.valueOf(PixelUtils.pxToDip(i6)));
        lynxDetailEvent.addDetail("targetScrollTop", Float.valueOf(PixelUtils.pxToDip(i7)));
        this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent);
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setEnableSticky(Dynamic dynamic) {
        if (ListEventManager.dynamicToBoolean(dynamic, false) && this.mContainerView == null) {
            ListStickyManager listStickyManager = new ListStickyManager(this);
            this.mListStickyManager = listStickyManager;
            this.mContainerView = listStickyManager.getContainer();
            this.mListStickyManager.setStickyOffset(this.mPendingStickyOffset);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setStickyOffset(Dynamic dynamic) {
        int dipToPx = (int) PixelUtils.dipToPx(ListEventManager.dynamicToInt(dynamic, 0));
        ListStickyManager listStickyManager = this.mListStickyManager;
        if (listStickyManager == null) {
            this.mPendingStickyOffset = dipToPx;
        } else {
            listStickyManager.setStickyOffset(dipToPx);
        }
    }

    public View getContainer() {
        return this.mContainerView;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2) {
        return hitTest(f, f2, false);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2, boolean z) {
        ListViewHolder listViewHolder;
        if (this.mAdapter == null) {
            return this;
        }
        ListStickyManager listStickyManager = this.mListStickyManager;
        EventTarget hitTest = listStickyManager != null ? listStickyManager.hitTest((int) f, (int) f2, z) : null;
        if (hitTest != null) {
            return hitTest;
        }
        for (int childCount = this.mView.getChildCount() - 1; childCount >= 0; childCount--) {
            RecyclerView.ViewHolder childViewHolder = this.mView.getChildViewHolder(this.mView.getChildAt(childCount));
            if ((childViewHolder instanceof ListViewHolder) && (listViewHolder = (ListViewHolder) childViewHolder) != null && listViewHolder.getUIComponent() != null) {
                UIComponent uIComponent = listViewHolder.getUIComponent();
                if (uIComponent.containsPoint(f - r1.getLeft(), f2 - r1.getTop(), z)) {
                    return uIComponent.hitTest(f - r1.getLeft(), f2 - r1.getTop(), z);
                }
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLayoutCompleted() {
        LLog.i(TAG, "onLayoutCompleted " + this.mAdapter.mViewNames.size());
        if (!this.mNeedLayoutComplete || this.mView.getChildCount() <= 0) {
            return;
        }
        this.mListEventManager.sendLayoutCompleteEvent(this.mAdapter.mViewNames);
        this.mNeedLayoutComplete = false;
    }

    private void updateLayoutMangerIfNeeded() {
        RecyclerView.LayoutManager layoutManager;
        if (this.mNeedUpdateLayoutManager) {
            getAdapter().initItemHeightData();
            new WeakReference(this);
            if (TextUtils.equals(this.mListType, MonitorConstants.SINGLE)) {
                layoutManager = new ListLayoutManager.ListLinearLayoutManager(this.mContext, this);
                layoutManager.setOrientation(this.mVerticalOrientation ? 1 : 0);
                if (!this.mEnableItemPrefetch) {
                    layoutManager.setInitialPrefetchItemCount(0);
                }
            } else if (TextUtils.equals(this.mListType, "flow")) {
                layoutManager = new ListLayoutManager.ListGridLayoutManager(this.mContext, this.mColumnCount, getCrossAxisGap(), this);
                layoutManager.setOrientation(this.mVerticalOrientation ? 1 : 0);
                if (!this.mEnableItemPrefetch) {
                    layoutManager.setInitialPrefetchItemCount(0);
                }
            } else if (TextUtils.equals(this.mListType, "waterfall")) {
                layoutManager = new ListLayoutManager.ListStaggeredGridLayoutManager(this.mColumnCount, getCrossAxisGap(), 1, this);
                layoutManager.setOrientation(this.mVerticalOrientation ? 1 : 0);
            } else {
                layoutManager = null;
            }
            ListStickyManager listStickyManager = this.mListStickyManager;
            if (listStickyManager != null) {
                listStickyManager.clear();
            }
            if (!this.mEnableItemPrefetch && layoutManager != null) {
                layoutManager.setItemPrefetchEnabled(false);
            }
            if (this.mPreloadCache != null) {
                this.mView.setItemViewCacheSize(0);
            }
            this.mView.setLayoutManager(layoutManager);
        }
        this.mNeedUpdateLayoutManager = false;
        if (this.mView.getLayoutManager() instanceof ListLayoutManager.ListLinearLayoutManager) {
            ListLayoutManager.ListLinearLayoutManager layoutManager2 = this.mView.getLayoutManager();
            boolean stackFromEnd = layoutManager2.getStackFromEnd();
            boolean z = this.mStackFromEnd;
            if (stackFromEnd != z) {
                layoutManager2.setStackFromEnd(z);
            }
        }
        if (this.mView.getLayoutManager() instanceof GridLayoutManager) {
            final GridLayoutManager layoutManager3 = this.mView.getLayoutManager();
            layoutManager3.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.lynx.tasm.behavior.ui.list.UIList.4
                public int getSpanSize(int i) {
                    if (!UIList.this.mAdapter.isFullSpan(i) || UIList.this.mColumnCount <= 1) {
                        return 1;
                    }
                    return layoutManager3.getSpanCount();
                }
            });
        }
    }

    private void setReverseLayout(boolean z) {
        this.mView.setLayoutDirection(z ? 1 : 0);
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap readableMap, Callback callback) {
        String string = readableMap.getString("rate", "");
        this.mStart = readableMap.getBoolean("start", true);
        this.mAutoStopOnBounds = readableMap.getBoolean("autoStop", true);
        if (this.mStart) {
            int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(string, 0.0f, 0.0f, this.mContext.getScreenMetrics());
            if (pxWithDisplayMetrics == 0) {
                callback.invoke(new Object[]{1, "rate is not right"});
                return;
            }
            int refreshRate = (int) DeviceUtils.getRefreshRate(getLynxContext());
            if (refreshRate <= 0) {
                refreshRate = 60;
            }
            this.mAutoRatePerFrame = pxWithDisplayMetrics > 0 ? Math.max(pxWithDisplayMetrics / refreshRate, 1) : Math.min(pxWithDisplayMetrics / refreshRate, -1);
            removeFrameCallback();
            autoScroll();
        } else {
            removeFrameCallback();
        }
        callback.invoke(new Object[]{0});
    }

    boolean canScroll(int i) {
        if (this.mVerticalOrientation) {
            return ((RecyclerView) getView()).canScrollVertically(i);
        }
        return ((RecyclerView) getView()).canScrollHorizontally(i);
    }

    void autoScroll() {
        this.mFrameCallback = new Choreographer.FrameCallback() { // from class: com.lynx.tasm.behavior.ui.list.UIList.5
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                boolean z = true;
                if ((UIList.this.mAutoRatePerFrame <= 0 || !UIList.this.canScroll(1)) && (UIList.this.mAutoRatePerFrame >= 0 || !UIList.this.canScroll(-1))) {
                    z = false;
                }
                if (z) {
                    if (UIList.this.mVerticalOrientation) {
                        ((RecyclerView) UIList.this.getView()).scrollBy(0, UIList.this.mAutoRatePerFrame);
                    } else {
                        ((RecyclerView) UIList.this.getView()).scrollBy(UIList.this.mAutoRatePerFrame, 0);
                    }
                }
                if (!UIList.this.mStart || (!z && UIList.this.mAutoStopOnBounds)) {
                    UIList.this.removeFrameCallback();
                } else if (UIList.this.mFrameCallback != null) {
                    Choreographer.getInstance().postFrameCallback(UIList.this.mFrameCallback);
                }
            }
        };
        Choreographer.getInstance().postFrameCallback(this.mFrameCallback);
    }

    public void scrollToPosition(ReadableMap readableMap) {
        scrollToPosition(readableMap, new Callback() { // from class: com.lynx.tasm.behavior.ui.list.UIList.6
            public void invoke(Object... objArr) {
            }
        });
    }

    @LynxUIMethod
    public void getScrollInfo(Callback callback) {
        int memberScrollX = getMemberScrollX();
        int memberScrollY = getMemberScrollY();
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putInt("scrollX", LynxUIHelper.px2dip(this.mContext, memberScrollX));
        javaOnlyMap.putInt("scrollY", LynxUIHelper.px2dip(this.mContext, memberScrollY));
        callback.invoke(new Object[]{0, javaOnlyMap});
    }

    @LynxUIMethod
    public void scrollBy(ReadableMap readableMap, final Callback callback) {
        if (callback == null) {
            return;
        }
        if (readableMap == null || !readableMap.hasKey("offset")) {
            callback.invoke(new Object[]{4, "Invoke scrollBy failed due to index param is null"});
        } else {
            final double dipToPx = PixelUtils.dipToPx(readableMap.getDouble("offset", 0.0d));
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.UIList$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    UIList.this.m4129lambda$scrollBy$1$comlynxtasmbehavioruilistUIList(dipToPx, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$scrollBy$1$com-lynx-tasm-behavior-ui-list-UIList, reason: not valid java name */
    public /* synthetic */ void m4129lambda$scrollBy$1$comlynxtasmbehavioruilistUIList(double d, Callback callback) {
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
    public void scrollToPosition(ReadableMap readableMap, Callback callback) {
        int height;
        if (this.mAdapter == null) {
            callback.invoke(new Object[]{1, "scrollToPosition before init"});
            return;
        }
        int i = readableMap.getInt("index", readableMap.getInt(PropsConstants.POSITION, 0));
        int dipToPx = (int) PixelUtils.dipToPx(readableMap.getDouble("offset", 0.0d));
        boolean z = readableMap.getBoolean("smooth", false);
        int dipToPx2 = (int) PixelUtils.dipToPx(readableMap.getDouble("itemHeight", 0.0d));
        String string = readableMap.getString("alignTo", BuildConfig.enable_trace);
        if (i < 0 || i > this.mAdapter.getItemCount()) {
            callback.invoke(new Object[]{4, "position < 0 or position >= data count"});
            return;
        }
        if (z) {
            this.mListScroller.scrollToPositionSmoothly(i, string, dipToPx, callback);
            return;
        }
        if (TextUtils.equals(string, "middle")) {
            height = (((RecyclerView) getView()).getHeight() - dipToPx2) / 2;
        } else {
            if (TextUtils.equals(string, PropsConstants.HIT_SLOP_BOTTOM)) {
                height = ((RecyclerView) getView()).getHeight() - dipToPx2;
            }
            this.mListScroller.scrollToPositionInner(i, dipToPx, callback);
            this.mView.post(new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.UIList.7
                @Override // java.lang.Runnable
                public void run() {
                    if (UIList.this.mListStickyManager != null) {
                        UIList.this.mListStickyManager.flushStickyComponentAfterScrolling();
                    }
                    if (UIList.this.mNewScrollTop) {
                        UIList.this.mListEventManager.mScrollTop = UIList.this.mAdapter.getScrollY();
                        UIList.this.mListEventManager.sendScrollEvent("scroll", 1, UIList.this.mListEventManager.mScrollTop, UIList.this.mListEventManager.mScrollTop, 0, 0);
                    }
                }
            });
        }
        dipToPx += height;
        this.mListScroller.scrollToPositionInner(i, dipToPx, callback);
        this.mView.post(new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.UIList.7
            @Override // java.lang.Runnable
            public void run() {
                if (UIList.this.mListStickyManager != null) {
                    UIList.this.mListStickyManager.flushStickyComponentAfterScrolling();
                }
                if (UIList.this.mNewScrollTop) {
                    UIList.this.mListEventManager.mScrollTop = UIList.this.mAdapter.getScrollY();
                    UIList.this.mListEventManager.sendScrollEvent("scroll", 1, UIList.this.mListEventManager.mScrollTop, UIList.this.mListEventManager.mScrollTop, 0, 0);
                }
            }
        });
    }

    @LynxUIMethod
    public void getVisibleCells(Callback callback) {
        if (callback == null) {
            LLog.i(TAG, "getVisibleCells with null callback");
        } else {
            callback.invoke(new Object[]{0, this.mListEventManager.getVisibleCellsInfo()});
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> map) {
        super.setEvents(map);
        this.mListEventManager.setEvents(map);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isAccessibilityDirectionVertical() {
        return this.mVerticalOrientation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean requestChildUIRectangleOnScreen(LynxBaseUI lynxBaseUI, Rect rect, boolean z) {
        if (this.mEnableScroll && (lynxBaseUI instanceof UIComponent)) {
            UIComponent uIComponent = (UIComponent) lynxBaseUI;
            if (uIComponent.getView() != 0) {
                Object parent = ((AndroidView) uIComponent.getView()).getParent();
                if (!(parent instanceof ListViewHolder.WrapView)) {
                    return false;
                }
                return this.mView.getLayoutManager().requestChildRectangleOnScreen(this.mView, (View) parent, rect, false, false);
            }
        }
        return false;
    }

    public ArrayList<String> getComponentAccessibilityOrder() {
        return this.mComponentAccessibilityOrder;
    }

    public HashMap<String, ArrayList<LynxNodeProvider.LynxCustomNodeInfo>> getCustomNodeMap() {
        return this.mCustomNodeMap;
    }

    public void initNodeInfo() {
        Iterator<ArrayList<LynxNodeProvider.LynxCustomNodeInfo>> it = this.mCustomNodeMap.values().iterator();
        while (it.hasNext()) {
            Iterator<LynxNodeProvider.LynxCustomNodeInfo> it2 = it.next().iterator();
            while (it2.hasNext()) {
                it2.next().invalid();
            }
        }
    }

    public void updateNodeInfo(String str, ArrayList<LynxNodeProvider.LynxCustomNodeInfo> arrayList) {
        if (!this.mCustomNodeMap.containsKey(str)) {
            this.mComponentAccessibilityOrder.add(str);
        }
        this.mCustomNodeMap.put(str, arrayList);
    }

    @LynxProp(defaultBoolean = true, name = "vertical-orientation")
    public void setVerticalOrientation(boolean z) {
        this.mVerticalOrientation = z;
    }

    @LynxProp(customType = "false", name = "auto-measure")
    public void setAutoMeasure(Dynamic dynamic) {
        this.mAutoMeasure = ListEventManager.dynamicToBoolean(dynamic, false);
    }

    @LynxProp(customType = "true", name = "android-diffable")
    public void setDiffable(Dynamic dynamic) {
        if (this.mView.getAdapter() == null) {
            this.mAdapter.setHasStableIds(!ListEventManager.dynamicToBoolean(dynamic, true));
        }
    }

    @LynxProp(defaultBoolean = true, name = "use-old-sticky")
    public void setListOldStickySwitch(boolean z) {
        this.mPendingOldStickCategory = z;
    }

    @LynxProp(defaultBoolean = false, name = "android-new-scroll-top")
    public void setListNewScrollTopSwitch(boolean z) {
        this.mNewScrollTop = z;
    }

    @LynxProp(defaultBoolean = false, name = "scroll-upper-lower-switch")
    public void setUpperLowerSwitch(boolean z) {
        this.mUpperLowerSwitch = z;
    }

    @LynxProp(defaultInt = -1, name = "scroll-index")
    public void setScrollIndex(int i) {
        this.mScrollIndex = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "android-enable-overflow")
    public void setEnableOverflow(boolean z) {
        this.mEnableOverflow = z;
        if (this.mView instanceof PrivateRecyclerView) {
            ((PrivateRecyclerView) this.mView).setEnableOverflow(z);
        }
    }

    @LynxProp(name = "list-platform-info")
    public void setListPlatformInfo(ReadableMap readableMap) {
        this.mNewArch = true;
        this.mListPlatformInfo = readableMap;
        this.mListNoDiffInfo = null;
        this.mFiberArch = false;
    }

    @LynxProp(name = "update-list-info")
    public void updateListActionInfo(ReadableMap readableMap) {
        this.mNewArch = true;
        this.mListNoDiffInfo = readableMap;
        this.mListPlatformInfo = null;
        this.mFiberArch = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(defaultBoolean = false, name = "android-preference-consume-gesture")
    public void setPreferenceConsumeGesture(boolean z) {
        if (this.mView instanceof PrivateRecyclerView) {
            ((PrivateRecyclerView) this.mView).mPreferenceConsumeGesture = z;
        }
    }

    @LynxProp(defaultBoolean = false, name = "android-trigger-sticky-layout")
    public void setTriggerStickyLayout(boolean z) {
        this.mTriggerStickyLayout = z;
    }

    @LynxProp(defaultBoolean = false, name = "android-stack-from-end")
    public void setStackFromEnd(boolean z) {
        this.mStackFromEnd = z;
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setInternalCellAppearNotification(boolean z) {
        super.setInternalCellAppearNotification(z);
        UIListAdapter uIListAdapter = this.mAdapter;
        if (uIListAdapter != null) {
            uIListAdapter.setInternalCellAppearNotification(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setInternalCellDisappearNotification(boolean z) {
        super.setInternalCellDisappearNotification(z);
        UIListAdapter uIListAdapter = this.mAdapter;
        if (uIListAdapter != null) {
            uIListAdapter.setInternalCellDisappearNotification(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setInternalCellPrepareForReuseNotification(boolean z) {
        super.setInternalCellPrepareForReuseNotification(z);
        UIListAdapter uIListAdapter = this.mAdapter;
        if (uIListAdapter != null) {
            uIListAdapter.setInternalCellPrepareForReuseNotification(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setShouldRequestStateRestore(boolean z) {
        super.setInternalCellAppearNotification(z);
        UIListAdapter uIListAdapter = this.mAdapter;
        if (uIListAdapter != null) {
            uIListAdapter.setInternalCellAppearNotification(z);
            this.mAdapter.setInternalCellDisappearNotification(z);
            this.mAdapter.setInternalCellPrepareForReuseNotification(z);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setNeedVisibleCells(boolean z) {
        this.mListEventManager.mNeedsVisibleCells = z;
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setScrollEnable(Dynamic dynamic) {
        this.mEnableScroll = ListEventManager.dynamicToBoolean(dynamic, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setTouchScroll(Dynamic dynamic) {
        if (this.mView instanceof PrivateRecyclerView) {
            ((PrivateRecyclerView) this.mView).setTouchScroll(ListEventManager.dynamicToBoolean(dynamic, true));
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setComponentInitMeasure(boolean z) {
        UIListAdapter uIListAdapter = this.mAdapter;
        if (uIListAdapter != null) {
            uIListAdapter.mComponentInitMeasure = z;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setNoInvalidate(boolean z) {
        this.noInvalidate = z;
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList
    public void setInitialScrollIndex(Dynamic dynamic) {
        this.mInitialScrollIndex = ListEventManager.dynamicToInt(dynamic, -1);
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        if (this.mPreloadListener != null) {
            ((RecyclerView) getView()).removeOnScrollListener(this.mPreloadListener);
        }
        ListPreloadCache listPreloadCache = this.mPreloadCache;
        if (listPreloadCache != null) {
            listPreloadCache.destroy();
        }
        super.destroy();
        removeFrameCallback();
        this.nativeListStateCache.clear();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void removeKeyFromNativeStorage(String str) {
        Map<String, Object> map = this.nativeListStateCache;
        if (map != null) {
            map.remove(str);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public Object getValueFromNativeStorage(String str) {
        Map<String, Object> map = this.nativeListStateCache;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void storeKeyToNativeStorage(String str, Object obj) {
        Map<String, Object> map = this.nativeListStateCache;
        if (map != null) {
            map.put(str, obj);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean initialPropsFlushed(String str, String str2) {
        HashSet<String> hashSet;
        return (this.nativeListStateCache == null || (hashSet = this.initialFlushPropCache.get(str)) == null || !hashSet.contains(str)) ? false : true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setInitialPropsHasFlushed(String str, String str2) {
        if (this.nativeListStateCache != null) {
            HashSet<String> orDefault = this.initialFlushPropCache.getOrDefault(str2, new HashSet<>());
            orDefault.add(str);
            this.nativeListStateCache.put(str2, orDefault);
        }
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollX() {
        if (isVertical()) {
            return 0;
        }
        return this.mListEventManager.getScrollOffset();
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getScrollContainerDirection() {
        return isVertical() ? 1 : -1;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollY() {
        if (isVertical()) {
            return this.mListEventManager.getScrollOffset();
        }
        return 0;
    }

    public boolean isVertical() {
        return this.mVerticalOrientation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getUpperLowerSwitch() {
        return this.mUpperLowerSwitch;
    }

    @LynxProp(defaultBoolean = false, name = "android-ignore-attach-for-binding")
    public void setAndroidIgnoreAttachForBinding(boolean z) {
        this.mIgnoreAttachForBinding = z;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-item-prefetch")
    public void setEnableItemPrefetch(boolean z) {
        this.mEnableItemPrefetch = z;
    }

    @LynxProp(defaultBoolean = false, name = "enable-async-list")
    public void setEnableAsyncList(boolean z) {
        this.mEnableAsyncList = z;
    }

    @LynxProp(defaultInt = 0, name = "item-holder-type")
    public void setItemHolderType(Dynamic dynamic) {
        this.mItemHolderType = ListEventManager.dynamicToInt(dynamic, 0);
    }

    @LynxUIMethod
    public void removeStickyView() {
        ListStickyManager listStickyManager = this.mListStickyManager;
        if (listStickyManager != null) {
            listStickyManager.resetStickyView();
        }
    }

    @LynxProp(defaultBoolean = false, name = "enable-disappear")
    public void setEnableDisappear(boolean z) {
        this.mAppearEventCourier.setDisappear(z);
    }

    @LynxProp(defaultBoolean = false, name = "enable-size-cache")
    public void setEnableSizeCache(boolean z) {
        this.mEnableSizeCache = z;
    }

    @LynxProp(defaultBoolean = false, name = "enable-rtl")
    public void enableRtl(boolean z) {
        this.mEnableRTL = z;
    }

    @LynxProp(defaultBoolean = true, name = "enable-nested-scroll")
    public void enableNestedScroll(boolean z) {
        if (this.mView == 0) {
            return;
        }
        this.mView.setNestedScrollingEnabled(z);
    }

    @LynxProp(defaultInt = 0, name = "preload-buffer-count")
    public void setPreloadBufferCount(Dynamic dynamic) {
        this.mPreloadBufferCount = ListEventManager.dynamicToInt(dynamic, 0);
    }

    @LynxProp(defaultDouble = 1.0d, name = "max-fling-velocity-percent")
    public void setMaxFlingVelocityPercent(float f) {
        this.mMaxFlingVelocityPercent = f;
    }

    @LynxUIMethod
    public void initCache() {
        ListPreloadCache listPreloadCache = this.mPreloadCache;
        if (listPreloadCache != null) {
            listPreloadCache.clear();
            this.mPreloadCache.initCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPartOnLayoutThreadStrategy() {
        return (this.mContext == null || this.mContext.getLynxView() == null || this.mContext.getLynxView().getThreadStrategyForRendering() != ThreadStrategyForRendering.PART_ON_LAYOUT) ? false : true;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-strict-scrollable")
    public void setEnableStrictScrollable(boolean z) {
        this.mEnableStrictScrollable = z;
    }

    @LynxProp(defaultBoolean = true, name = "android-enable-focus-search")
    public void setEnableFocusSearch(boolean z) {
        this.mEnableFocusSearch = z;
    }

    @LynxProp(defaultBoolean = false, name = "android-enable-gap-item-decoration")
    public void setEnableGapItemDecoration(boolean z) {
        this.mEnableGapItemDecoration = z;
    }

    void updateGapItemDecorationIfNeed() {
        if (this.mView == 0 || this.mView.getLayoutManager() == null) {
            LLog.e(TAG, "Fail to update gap item decoration because mView == null or LayoutManager == null");
            return;
        }
        if (this.mEnableGapItemDecoration) {
            if (this.mGapItemDecoration == null) {
                this.mGapItemDecoration = new GapItemDecoration();
                this.mView.addItemDecoration(this.mGapItemDecoration);
            }
            this.mGapItemDecoration.setIsVertical(isVertical());
            this.mGapItemDecoration.setIsRTL(this.mEnableRTL && isRtl());
            this.mGapItemDecoration.setColumnCount(this.mColumnCount);
            this.mGapItemDecoration.setMainAxisGap(this.mMainAxisGap);
            this.mGapItemDecoration.setCrossAxisGap(this.mCrossAxisGap);
            this.mView.invalidateItemDecorations();
            return;
        }
        if (this.mGapItemDecoration != null) {
            this.mView.removeItemDecoration(this.mGapItemDecoration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFrameCallback() {
        if (this.mFrameCallback != null) {
            Choreographer.getInstance().removeFrameCallback(this.mFrameCallback);
            this.mFrameCallback = null;
        }
    }

    public void setPreBufferListener() {
        if (this.mPreloadBufferCount > 0) {
            if (this.mPreloadListener == null) {
                this.mPreloadListener = new RecyclerView.OnScrollListener() { // from class: com.lynx.tasm.behavior.ui.list.UIList.8
                    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                        super.onScrolled(recyclerView, i, i2);
                        if (UIList.this.getAdapter() == null || !UIList.this.getAdapter().shouldInitCache) {
                            return;
                        }
                        if (UIList.this.mPreloadCache != null) {
                            UIList.this.mPreloadCache.initCache();
                        }
                        UIList.this.getAdapter().shouldInitCache = false;
                    }
                };
                ((RecyclerView) getView()).addOnScrollListener(this.mPreloadListener);
                return;
            }
            return;
        }
        ListPreloadCache listPreloadCache = this.mPreloadCache;
        if (listPreloadCache != null) {
            listPreloadCache.clear();
        }
    }

    public int findFirstListItem() {
        int i;
        LinearLayoutManager layoutManager = ((RecyclerView) getView()).getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return layoutManager.findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager) || (i = this.mColumnCount) <= 0) {
            return -1;
        }
        int[] iArr = new int[i];
        ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(iArr);
        int i2 = iArr[0];
        for (int i3 = 1; i3 < this.mColumnCount; i3++) {
            i2 = Math.min(i2, iArr[i3]);
        }
        return i2;
    }

    public int findLastListItem() {
        int i;
        LinearLayoutManager layoutManager = ((RecyclerView) getView()).getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return layoutManager.findLastVisibleItemPosition();
        }
        int i2 = -1;
        if ((layoutManager instanceof StaggeredGridLayoutManager) && (i = this.mColumnCount) > 0) {
            int[] iArr = new int[i];
            ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(iArr);
            for (int i3 = 0; i3 < this.mColumnCount; i3++) {
                i2 = Math.max(i2, iArr[i3]);
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findFirstCompleteLyListItem() {
        int i;
        if (getView() != 0) {
            LinearLayoutManager layoutManager = ((RecyclerView) getView()).getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                return layoutManager.findFirstCompletelyVisibleItemPosition();
            }
            if (!(layoutManager instanceof StaggeredGridLayoutManager) || (i = this.mColumnCount) <= 0) {
                return -1;
            }
            int[] iArr = new int[i];
            ((StaggeredGridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPositions(iArr);
            int i2 = iArr[0];
            for (int i3 = 1; i3 < this.mColumnCount; i3++) {
                i2 = Math.min(i2, iArr[i3]);
            }
            return i2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findLastCompleteLyListItem() {
        int i = -1;
        if (getView() != 0) {
            LinearLayoutManager layoutManager = ((RecyclerView) getView()).getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                return layoutManager.findLastCompletelyVisibleItemPosition();
            }
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                int i2 = this.mColumnCount;
                if (i2 <= 0) {
                    return -1;
                }
                int[] iArr = new int[i2];
                ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(iArr);
                for (int i3 = 0; i3 < this.mColumnCount; i3++) {
                    i = Math.max(i, iArr[i3]);
                }
            }
        }
        return i;
    }
}

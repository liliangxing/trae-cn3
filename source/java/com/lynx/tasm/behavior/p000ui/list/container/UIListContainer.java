package com.lynx.tasm.behavior.p000ui.list.container;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.IListNodeInfoFetcher;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.list.ListEventManager;
import com.lynx.tasm.behavior.p000ui.list.LynxSnapHelper;
import com.lynx.tasm.behavior.p000ui.list.container.NestedScrollContainerView;
import com.lynx.tasm.behavior.p000ui.utils.LynxUIHelper;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.behavior.p000ui.view.ComponentView;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.event.LynxScrollEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.gesture.handler.BaseGestureHandler;
import com.lynx.tasm.utils.PixelUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.update.UpdateEventUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIListContainer extends UISimpleView<ListContainerView> implements NestedScrollContainerView.OnScrollStateChangeListener, GestureArenaMember, UIComponent.NodeReadyListener {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_FADE_IN_ANIMATION_DURATION = 100;
    public static final int INVALID_SCROLL_ESTIMATED_OFFSET = -1;
    private static final String TAG = "UIListContainer";
    public Map<String, HashSet<String>> initialFlushPropCache;
    private UIListAutoScroller mAutoScroller;
    private final NestedScrollContainerView.CustomScrollHook mCustomScrollHook;
    private boolean mEnableBatchRender;
    private boolean mEnableFadeInAnimation;
    private boolean mEnableInsertPlatformViewOperation;
    private boolean mEnableListSticky;
    private boolean mEnableNeedVisibleItemInfo;
    private boolean mEnableRecycleStickyItem;
    private boolean mEnableScrollEndEvent;
    private boolean mEnableScrollStateChangeEvent;
    private boolean mIsVertical;
    private final HashMap<String, Integer> mItemKeyMap;
    private JavaOnlyArray mItemKeys;
    private UIComponent mPrevStickyBottomItem;
    private UIComponent mPrevStickyTopItem;
    private Callback mScrollToCallback;
    private int mScrollingEstimatedOffset;
    private JavaOnlyArray mStickyBottomIndexes;
    private final HashSet<String> mStickyBottomItemKeySet;
    private final HashMap<String, UIComponent> mStickyBottomItemMap;
    private final HashMap<Integer, UIComponent> mStickyBottomItems;
    private int mStickyOffset;
    private JavaOnlyArray mStickyTopIndexes;
    private final HashSet<String> mStickyTopItemKeySet;
    private final HashMap<String, UIComponent> mStickyTopItemMap;
    private final HashMap<Integer, UIComponent> mStickyTopItems;
    private int mUpdateAnimationFadeInDuration;
    private boolean mUpdateStickyForDiff;
    public Map<String, Object> nativeListStateCache;

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isScrollContainer() {
        return true;
    }

    public UIListContainer(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIListContainer(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mIsVertical = true;
        this.mAutoScroller = null;
        this.mItemKeys = new JavaOnlyArray();
        this.mItemKeyMap = new HashMap<>();
        this.mEnableListSticky = false;
        this.mStickyOffset = 0;
        this.nativeListStateCache = new HashMap();
        this.initialFlushPropCache = new HashMap();
        this.mStickyTopItems = new LinkedHashMap();
        this.mStickyBottomItems = new LinkedHashMap();
        this.mStickyTopIndexes = new JavaOnlyArray();
        this.mStickyBottomIndexes = new JavaOnlyArray();
        this.mPrevStickyTopItem = null;
        this.mPrevStickyBottomItem = null;
        this.mEnableFadeInAnimation = false;
        this.mUpdateAnimationFadeInDuration = 100;
        this.mEnableRecycleStickyItem = true;
        this.mEnableScrollEndEvent = false;
        this.mEnableScrollStateChangeEvent = false;
        this.mEnableBatchRender = false;
        this.mEnableNeedVisibleItemInfo = false;
        this.mUpdateStickyForDiff = true;
        this.mStickyTopItemKeySet = new HashSet<>();
        this.mStickyBottomItemKeySet = new HashSet<>();
        this.mStickyTopItemMap = new HashMap<>();
        this.mStickyBottomItemMap = new HashMap<>();
        this.mScrollToCallback = null;
        this.mEnableInsertPlatformViewOperation = false;
        this.mScrollingEstimatedOffset = -1;
        this.mCustomScrollHook = new NestedScrollContainerView.CustomScrollHook() { // from class: com.lynx.tasm.behavior.ui.list.container.UIListContainer.1
            private int mInitialScrollingEstimatedOffset = -1;
            private boolean mScrollToLower = false;

            @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView.CustomScrollHook
            public void onSmoothScrollStart(int i, int i2, int i3, int i4) {
                if (UIListContainer.this.mIsVertical) {
                    i3 = i4;
                }
                this.mInitialScrollingEstimatedOffset = i3;
                if (UIListContainer.this.mIsVertical) {
                    i = i2;
                }
                this.mScrollToLower = i3 > i;
            }

            @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView.CustomScrollHook
            public void onSmoothScrollEnd() {
                LynxContext lynxContext2 = UIListContainer.this.getLynxContext();
                if (lynxContext2 == null || lynxContext2.getListNodeInfoFetcher() == null) {
                    return;
                }
                UIListContainer.this.getLynxContext().getListNodeInfoFetcher().scrollStopped(UIListContainer.this.getSign());
            }

            @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView.CustomScrollHook
            public void onSmoothScroll(int i, int i2, int[] iArr) {
                int i3 = !UIListContainer.this.mIsVertical ? i : i2;
                if (this.mInitialScrollingEstimatedOffset != 0) {
                    i3 = (int) (i3 * ((UIListContainer.this.mScrollingEstimatedOffset * 1.0f) / this.mInitialScrollingEstimatedOffset));
                }
                if (UIListContainer.this.mScrollingEstimatedOffset > 0 && ((this.mScrollToLower && i3 > UIListContainer.this.mScrollingEstimatedOffset) || (!this.mScrollToLower && i3 < UIListContainer.this.mScrollingEstimatedOffset))) {
                    i3 = UIListContainer.this.mScrollingEstimatedOffset;
                }
                if (!UIListContainer.this.mIsVertical) {
                    i = i3;
                }
                iArr[0] = i;
                if (UIListContainer.this.mIsVertical) {
                    i2 = i3;
                }
                iArr[1] = i2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public ListContainerView createView(Context context) {
        ListContainerView listContainerView = new ListContainerView(context, this);
        listContainerView.addOnScrollStateChangeListener(this);
        LLog.i(TAG, "create UIListContainer: " + this + ", " + listContainerView);
        return listContainerView;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void insertChild(LynxBaseUI lynxBaseUI, int i) {
        super.onInsertChild(lynxBaseUI, i);
        if (!this.mEnableListSticky || this.mUpdateStickyForDiff) {
            return;
        }
        int indexFromItemKey = getIndexFromItemKey(((UIComponent) lynxBaseUI).getItemKey());
        updateStickyInfoForInsertedChild(lynxBaseUI, this.mStickyTopItems, this.mStickyTopIndexes, indexFromItemKey);
        updateStickyInfoForInsertedChild(lynxBaseUI, this.mStickyBottomItems, this.mStickyBottomIndexes, indexFromItemKey);
    }

    @Override // com.lynx.tasm.behavior.ui.view.UIComponent.NodeReadyListener
    public void onComponentNodeReady(UIComponent uIComponent) {
        if (!this.mEnableListSticky || !this.mUpdateStickyForDiff || uIComponent == null || uIComponent.getItemKey() == null) {
            return;
        }
        String itemKey = uIComponent.getItemKey();
        if (this.mStickyTopItemKeySet.contains(itemKey)) {
            updateStickyItemMap(uIComponent, this.mStickyTopItemMap, true);
        } else if (this.mStickyBottomItemKeySet.contains(itemKey)) {
            updateStickyItemMap(uIComponent, this.mStickyBottomItemMap, true);
        } else {
            updateStickyItemMap(uIComponent, this.mStickyTopItemMap, false);
            updateStickyItemMap(uIComponent, this.mStickyBottomItemMap, false);
        }
    }

    private void updateStickyItemMap(UIComponent uIComponent, HashMap<String, UIComponent> hashMap, boolean z) {
        if (uIComponent == null || uIComponent.getItemKey() == null) {
            return;
        }
        if (z) {
            String itemKey = uIComponent.getItemKey();
            if (hashMap.get(itemKey) == uIComponent) {
                return;
            }
            Iterator<Map.Entry<String, UIComponent>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, UIComponent> next = it.next();
                if (next.getValue() == uIComponent && !TextUtils.equals(next.getKey(), itemKey)) {
                    it.remove();
                    hashMap.put(itemKey, uIComponent);
                    return;
                }
            }
            return;
        }
        Iterator<Map.Entry<String, UIComponent>> it2 = hashMap.entrySet().iterator();
        while (it2.hasNext()) {
            if (it2.next().getValue() == uIComponent) {
                it2.remove();
                resetStickyItem(uIComponent);
                return;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void removeChild(LynxBaseUI lynxBaseUI) {
        ?? view;
        super.removeChild(lynxBaseUI);
        if (lynxBaseUI instanceof UIComponent) {
            UIComponent uIComponent = (UIComponent) lynxBaseUI;
            if (this.mEnableFadeInAnimation && isAsyncThreadStrategy() && (view = uIComponent.getView()) != 0 && view.getAnimation() != null) {
                view.getAnimation().cancel();
            }
            uIComponent.setOnUpdateListener(null);
            uIComponent.setNodeReadyListener(null);
        }
        if (!this.mEnableListSticky || this.mUpdateStickyForDiff) {
            return;
        }
        updateStickyInfoForDeletedChild(lynxBaseUI, this.mStickyTopItems);
        updateStickyInfoForDeletedChild(lynxBaseUI, this.mStickyBottomItems);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutFinish(long j, LynxBaseUI lynxBaseUI) {
        super.onLayoutFinish(j, lynxBaseUI);
        if (this.mEnableBatchRender || this.mEnableInsertPlatformViewOperation) {
            return;
        }
        insertListItemNode(lynxBaseUI);
    }

    public void insertListItemNode(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI instanceof UIComponent) {
            UIComponent uIComponent = (UIComponent) lynxBaseUI;
            if (this.mEnableBatchRender) {
                insertListItemNodeInternal(uIComponent);
            } else if (uIComponent.getWidth() != 0 || uIComponent.getHeight() != 0) {
                insertListItemNodeInternal(uIComponent);
            } else if (uIComponent.getOnUpdateListener() == null) {
                uIComponent.setOnUpdateListener(new UIComponent.OnUpdateListener() { // from class: com.lynx.tasm.behavior.ui.list.container.UIListContainer.2
                    @Override // com.lynx.tasm.behavior.ui.view.UIComponent.OnUpdateListener
                    public void onLayoutUpdated(UIComponent uIComponent2) {
                        if (uIComponent2 != null) {
                            UIListContainer.this.insertListItemNodeInternal(uIComponent2);
                        }
                    }
                });
            }
            if (this.mEnableListSticky) {
                if (this.mUpdateStickyForDiff) {
                    String itemKey = uIComponent.getItemKey();
                    if (itemKey != null) {
                        if (this.mStickyTopItemKeySet.contains(itemKey)) {
                            this.mStickyTopItemMap.put(itemKey, uIComponent);
                            uIComponent.setNodeReadyListener(this);
                            return;
                        } else {
                            if (this.mStickyBottomItemKeySet.contains(itemKey)) {
                                this.mStickyBottomItemMap.put(itemKey, uIComponent);
                                uIComponent.setNodeReadyListener(this);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                int indexFromItemKey = getIndexFromItemKey(uIComponent.getItemKey());
                updateStickyInfoForUpdatedChild(uIComponent, this.mStickyTopItems, this.mStickyTopIndexes, indexFromItemKey);
                updateStickyInfoForUpdatedChild(uIComponent, this.mStickyBottomItems, this.mStickyBottomIndexes, indexFromItemKey);
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public void removeView(LynxBaseUI lynxBaseUI) {
        super.removeView(lynxBaseUI);
        if (lynxBaseUI instanceof UIComponent) {
            UIComponent uIComponent = (UIComponent) lynxBaseUI;
            if (this.mEnableListSticky) {
                if (this.mUpdateStickyForDiff) {
                    String itemKey = uIComponent.getItemKey();
                    if (itemKey != null) {
                        if (this.mStickyTopItemMap.get(itemKey) == uIComponent) {
                            this.mStickyTopItemMap.remove(itemKey);
                            uIComponent.setNodeReadyListener(null);
                            if (this.mEnableRecycleStickyItem) {
                                resetStickyItem(uIComponent);
                                return;
                            }
                            return;
                        }
                        if (this.mStickyBottomItemMap.get(itemKey) == uIComponent) {
                            this.mStickyBottomItemMap.remove(itemKey);
                            uIComponent.setNodeReadyListener(null);
                            if (this.mEnableRecycleStickyItem) {
                                resetStickyItem(uIComponent);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                updateStickyInfoForDeletedChild(uIComponent, this.mStickyTopItems);
                updateStickyInfoForDeletedChild(uIComponent, this.mStickyBottomItems);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void insertListItemNodeInternal(UIComponent uIComponent) {
        View view = uIComponent.getView();
        if (view != null && view.getParent() == null) {
            ((ListContainerView) this.mView).addView(view);
            startFadeInAnimation(view);
        }
        setChildTranslationZ(uIComponent);
    }

    private void setChildTranslationZ(UIComponent uIComponent) {
        if (uIComponent != null) {
            setChildTranslationZ(uIComponent, uIComponent.getZIndex());
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    private void setChildTranslationZ(UIComponent uIComponent, float f) {
        ?? view = uIComponent.getView();
        if (view != 0) {
            view.setOutlineProvider(null);
            ViewCompat.setTranslationZ((View) view, f);
        }
    }

    public boolean isAsyncThreadStrategy() {
        if (this.mContext == null || this.mContext.getLynxView() == null) {
            return false;
        }
        ThreadStrategyForRendering threadStrategyForRendering = this.mContext.getLynxView().getThreadStrategyForRendering();
        return threadStrategyForRendering == ThreadStrategyForRendering.MOST_ON_TASM || threadStrategyForRendering == ThreadStrategyForRendering.MULTI_THREADS;
    }

    private void startFadeInAnimation(View view) {
        if (this.mEnableFadeInAnimation && view != null && isAsyncThreadStrategy()) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.mUpdateAnimationFadeInDuration);
            view.startAnimation(alphaAnimation);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        updateStickyStarts();
        updateStickyEnds();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        ViewCompat.setLayoutDirection(this.mView, 0);
        if (this.mIsVertical && ((ListContainerView) this.mView).mMeasuredWidth != getWidth()) {
            ((ListContainerView) this.mView).setMeasuredSize(getWidth(), ((ListContainerView) this.mView).mMeasuredHeight);
        } else {
            if (this.mIsVertical || ((ListContainerView) this.mView).mMeasuredHeight == getHeight()) {
                return;
            }
            ((ListContainerView) this.mView).setMeasuredSize(((ListContainerView) this.mView).mMeasuredWidth, getHeight());
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void removeKeyFromNativeStorage(String str) {
        Map<String, Object> map = this.nativeListStateCache;
        if (map != null) {
            map.remove(str);
        }
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
        Map<String, HashSet<String>> map = this.initialFlushPropCache;
        return (map == null || (hashSet = map.get(str2)) == null || !hashSet.contains(str)) ? false : true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setInitialPropsHasFlushed(String str, String str2) {
        Map<String, HashSet<String>> map = this.initialFlushPropCache;
        if (map != null) {
            HashSet<String> hashSet = map.get(str2) == null ? new HashSet<>() : this.initialFlushPropCache.get(str2);
            hashSet.add(str);
            this.initialFlushPropCache.put(str2, hashSet);
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

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void layout() {
        if (getOverflow() != 0) {
            ((ListContainerView) this.mView).setClipChildren(false);
        }
        super.layout();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.p000ui.UIParent
    public void invalidate() {
        if (((ListContainerView) this.mView).getLinearLayout() != null) {
            ((ListContainerView) this.mView).getLinearLayout().invalidate();
        }
        super.invalidate();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        LLog.i(TAG, "destroy: " + this + ", listContainerView: " + this.mView);
        super.destroy();
        if (this.mView != 0) {
            ((ListContainerView) this.mView).destroy();
        }
        UIListAutoScroller uIListAutoScroller = this.mAutoScroller;
        if (uIListAutoScroller != null) {
            uIListAutoScroller.removeFrameCallback();
        }
    }

    public void updateContentSizeAndOffset(float f, float f2, float f3) {
        ((ListContainerView) this.mView).updateContentSizeAndOffset((int) f, (int) f2, (int) f3);
    }

    @LynxProp(name = "item-snap")
    public void setPagingAlignment(ReadableMap readableMap) {
        double d;
        if (readableMap != null && readableMap.size() > 0) {
            double d2 = readableMap.getDouble("factor");
            if (d2 < 0.0d || d2 > 1.0d) {
                getLynxContext().handleLynxError(new LynxError(220205, "item-snap invalid!", "The factor should be constrained to the range of [0,1].", "warn"));
                d = 0.0d;
            } else {
                d = d2;
            }
            ((ListContainerView) this.mView).mSnapHelper = new LynxSnapHelper(d, readableMap.getInt("offset", 0), 50.0f / this.mContext.getScreenMetrics().densityDpi, new LynxSnapHelper.LynxSnapHooks() { // from class: com.lynx.tasm.behavior.ui.list.container.UIListContainer.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public int getScrollX() {
                    return ((ListContainerView) UIListContainer.this.getView()).getScrollX();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public int getScrollY() {
                    return ((ListContainerView) UIListContainer.this.getView()).getScrollY();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public int getScrollHeight() {
                    return ((ListContainerView) UIListContainer.this.getView()).getHeight();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public int getScrollWidth() {
                    return ((ListContainerView) UIListContainer.this.getView()).getWidth();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public int getChildrenCount() {
                    return ((ListContainerView) UIListContainer.this.getView()).getLinearLayout().getChildCount();
                }

                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public int getVirtualChildrenCount() {
                    return UIListContainer.this.mItemKeys.size();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public View getChildAtIndex(int i) {
                    return ((ListContainerView) UIListContainer.this.getView()).getLinearLayout().getChildAt(i);
                }

                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public View getViewAtPosition(int i) {
                    String str = (String) UIListContainer.this.mItemKeys.get(i);
                    for (int i2 = 0; i2 < ((ListContainerView) UIListContainer.this.mView).getLinearLayout().getChildCount(); i2++) {
                        View childAt = ((ListContainerView) UIListContainer.this.mView).getLinearLayout().getChildAt(i2);
                        if (str.equals(((UIComponent) ((ComponentView) childAt).getDrawChildHook()).getItemKey())) {
                            return childAt;
                        }
                    }
                    return null;
                }

                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public int getIndexFromView(View view) {
                    if (!(view instanceof ComponentView)) {
                        return -1;
                    }
                    ComponentView componentView = (ComponentView) view;
                    if (!(componentView.getDrawChildHook() instanceof UIComponent)) {
                        return -1;
                    }
                    String itemKey = ((UIComponent) componentView.getDrawChildHook()).getItemKey();
                    if (UIListContainer.this.mItemKeys.contains(itemKey)) {
                        return UIListContainer.this.mItemKeys.indexOf(itemKey);
                    }
                    return -1;
                }

                @Override // com.lynx.tasm.behavior.ui.list.LynxSnapHelper.LynxSnapHooks
                public void willSnapTo(int i, int i2, int i3, int i4, int i5) {
                    UIListContainer.this.willSnapTo(i, i2, i3, i4, i5);
                }
            });
            return;
        }
        ((ListContainerView) this.mView).mSnapHelper = null;
    }

    public void willSnapTo(int i, int i2, int i3, int i4, int i5) {
        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSign(), "snap");
        lynxDetailEvent.addDetail(PropsConstants.POSITION, Integer.valueOf(i));
        lynxDetailEvent.addDetail("currentScrollLeft", Float.valueOf(PixelUtils.pxToDip(i2)));
        lynxDetailEvent.addDetail("currentScrollTop", Float.valueOf(PixelUtils.pxToDip(i3)));
        lynxDetailEvent.addDetail("targetScrollLeft", Float.valueOf(PixelUtils.pxToDip(i4)));
        lynxDetailEvent.addDetail("targetScrollTop", Float.valueOf(PixelUtils.pxToDip(i5)));
        this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent);
    }

    @LynxProp(name = "experimental-max-fling-distance-ratio")
    public void setMaxFlingDistanceRatio(Dynamic dynamic) {
        if (dynamic.getType() == ReadableType.String && dynamic.asString().equals(UpdateEventUtils.SOURCE_AUTO)) {
            ((ListContainerView) this.mView).setMaxFlingDistanceRatio(Float.MAX_VALUE);
        } else if (dynamic.getType() == ReadableType.Number) {
            ((ListContainerView) this.mView).setMaxFlingDistanceRatio((float) dynamic.asDouble());
        }
    }

    @LynxProp(defaultBoolean = true, name = "enable-scroll")
    public void setEnableScroll(boolean z) {
        ((ListContainerView) this.mView).setEnableScroll(z);
    }

    @LynxProp(defaultBoolean = false, name = "force-can-scroll")
    public void setForceCanScroll(boolean z) {
        if (this.mView != 0) {
            ((ListContainerView) this.mView).setForceCanScroll(z);
        }
    }

    @LynxProp(defaultBoolean = false, name = "vertical-orientation")
    public void setVerticalOrientation(boolean z) {
        this.mIsVertical = z;
        ((ListContainerView) this.mView).setOrientation(this.mIsVertical ? 1 : 0);
    }

    @LynxProp(customType = "vertical", name = "scroll-orientation")
    public void setScrollOrientation(String str) {
        if (TextUtils.equals(str, "vertical")) {
            this.mIsVertical = true;
        } else if (TextUtils.equals(str, "horizontal")) {
            this.mIsVertical = false;
        } else {
            this.mIsVertical = true;
        }
        ((ListContainerView) this.mView).setOrientation(this.mIsVertical ? 1 : 0);
    }

    @LynxProp(defaultBoolean = false, name = "enable-nested-scroll")
    public void setEnableNestedScroll(boolean z) {
        ((ListContainerView) this.mView).setNestedScrollingEnabled(z);
    }

    @LynxProp(defaultInt = 0, name = "experimental-batch-render-strategy")
    public void setBatchRenderStrategy(int i) {
        this.mEnableBatchRender = i > 0;
    }

    @LynxProp(name = "list-container-info")
    public void setDiffInfo(ReadableMap readableMap) {
        if (readableMap != null) {
            ReadableArray array = readableMap.getArray("stickyStart");
            if (array != null) {
                this.mStickyTopIndexes = JavaOnlyArray.shallowCopy(array);
            }
            ReadableArray array2 = readableMap.getArray("stickyEnd");
            if (array2 != null) {
                this.mStickyBottomIndexes = JavaOnlyArray.shallowCopy(array2);
            }
            ReadableArray array3 = readableMap.getArray("itemkeys");
            if (array3 != null) {
                this.mItemKeys = JavaOnlyArray.shallowCopy(array3);
            }
            int size = this.mItemKeys.size();
            this.mItemKeyMap.clear();
            for (int i = 0; i < size; i++) {
                this.mItemKeyMap.put(this.mItemKeys.getString(i), Integer.valueOf(i));
            }
        }
    }

    @LynxProp(defaultBoolean = true, name = "sticky")
    public void setEnableListSticky(boolean z) {
        this.mEnableListSticky = z;
    }

    @LynxProp(defaultInt = 0, name = "sticky-offset")
    public void setStickyOffset(Dynamic dynamic) {
        this.mStickyOffset = (int) PixelUtils.dipToPx(ListEventManager.dynamicToInt(dynamic, 0));
    }

    @LynxProp(defaultBoolean = false, name = "enable-fade-in-animation")
    public void setEnableFadeInAnimation(boolean z) {
        this.mEnableFadeInAnimation = z;
    }

    @LynxProp(defaultBoolean = false, name = "enable-insert-platform-view-operation")
    public void setEnableInsertPlatformViewOperation(boolean z) {
        this.mEnableInsertPlatformViewOperation = z;
    }

    @LynxProp(defaultInt = 100, name = "update-animation-fade-in-duration")
    public void setUpdateAnimationFadeInDuration(int i) {
        this.mUpdateAnimationFadeInDuration = i;
    }

    @LynxProp(defaultBoolean = true, name = "experimental-recycle-sticky-item")
    public void setEnableRecycleStickyItem(boolean z) {
        this.mEnableRecycleStickyItem = z;
    }

    @LynxProp(defaultBoolean = false, name = "need-visible-item-info")
    public void setNeedVisibleItemInfo(boolean z) {
        this.mEnableNeedVisibleItemInfo = z;
    }

    @LynxProp(defaultBoolean = true, name = "experimental-update-sticky-for-diff")
    public void setUpdateStickyForDiff(boolean z) {
        this.mUpdateStickyForDiff = z;
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
    public void scrollToPosition(ReadableMap readableMap, Callback callback) {
        int i;
        Callback callback2 = this.mScrollToCallback;
        if (callback2 != null) {
            this.mScrollToCallback = null;
            callback2.invoke(new Object[]{1, "the scroll has stopped, triggered by a new scrolling request"});
        }
        int i2 = readableMap.getInt("index", readableMap.getInt(PropsConstants.POSITION, 0));
        float f = (float) readableMap.getDouble("offset", 0.0d);
        boolean z = readableMap.getBoolean("smooth", false);
        int dipToPx = (int) PixelUtils.dipToPx(f);
        if (i2 < 0 || i2 >= this.mItemKeys.size()) {
            callback.invoke(new Object[]{1, "position < 0 or position >= data count"});
            return;
        }
        if (!z) {
            ((ListContainerView) this.mView).stopFling();
        }
        String string = readableMap.getString("alignTo");
        if (TextUtils.equals(string, "middle")) {
            i = 1;
        } else {
            i = TextUtils.equals(string, PropsConstants.HIT_SLOP_BOTTOM) ? 2 : 0;
        }
        if (z) {
            this.mScrollToCallback = callback;
        }
        LynxContext lynxContext = getLynxContext();
        IListNodeInfoFetcher listNodeInfoFetcher = lynxContext != null ? lynxContext.getListNodeInfoFetcher() : null;
        if (listNodeInfoFetcher != null) {
            listNodeInfoFetcher.scrollToPosition(getSign(), i2, dipToPx, i, z);
            if (z) {
                return;
            }
            sendCustomEvent(((ListContainerView) this.mView).getScrollX(), ((ListContainerView) this.mView).getScrollY(), ((ListContainerView) this.mView).getScrollX(), ((ListContainerView) this.mView).getScrollY(), LynxScrollEvent.EVENT_SCROLL_END);
            callback.invoke(new Object[]{0});
            return;
        }
        callback.invoke(new Object[]{1, "List has been destroyed"});
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
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.container.UIListContainer$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    UIListContainer.this.m5xea16c685(dipToPx, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$scrollBy$0$com-lynx-tasm-behavior-ui-list-container-UIListContainer */
    public /* synthetic */ void m5xea16c685(double d, Callback callback) {
        float f = (float) d;
        float[] scrollBy = scrollBy(f, f);
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putDouble("consumedX", (int) PixelUtils.pxToDip(scrollBy[0]));
        javaOnlyMap.putDouble("consumedY", (int) PixelUtils.pxToDip(scrollBy[1]));
        javaOnlyMap.putDouble("unconsumedX", (int) PixelUtils.pxToDip(scrollBy[2]));
        javaOnlyMap.putDouble("unconsumedY", (int) PixelUtils.pxToDip(scrollBy[3]));
        callback.invoke(new Object[]{0, javaOnlyMap});
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected void consumeGesture(boolean z) {
        ((ListContainerView) this.mView).consumeGesture(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void interceptGesture(boolean z) {
        ((ListContainerView) this.mView).interceptGesture(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.gesture.LynxNewGestureDelegate
    public float[] scrollBy(float f, float f2) {
        float[] fArr = new float[4];
        if (this.mView == 0) {
            return fArr;
        }
        int scrollX = ((ListContainerView) this.mView).getScrollX();
        int scrollY = ((ListContainerView) this.mView).getScrollY();
        if (!this.mIsVertical) {
            ((ListContainerView) this.mView).scrollBy((int) f, 0);
        } else {
            ((ListContainerView) this.mView).scrollBy(0, (int) f2);
        }
        if (Math.abs(f) > Float.MIN_VALUE || Math.abs(f2) > Float.MIN_VALUE) {
            recognizeGesturere();
        }
        if (!this.mIsVertical) {
            float scrollX2 = ((ListContainerView) this.mView).getScrollX() - scrollX;
            fArr[0] = scrollX2;
            fArr[1] = 0.0f;
            fArr[2] = f - scrollX2;
            fArr[3] = f2;
        } else {
            fArr[0] = 0.0f;
            float scrollY2 = ((ListContainerView) this.mView).getScrollY() - scrollY;
            fArr[1] = scrollY2;
            fArr[2] = f;
            fArr[3] = f2 - scrollY2;
        }
        return fArr;
    }

    @LynxUIMethod
    public void getVisibleCells(ReadableMap readableMap, Callback callback) {
        callback.invoke(new Object[]{0, visibleCellsInfo()});
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JavaOnlyArray visibleCellsInfo() {
        IDrawChildHook drawChildHook;
        if (this.mContext == null) {
            return new JavaOnlyArray();
        }
        ArrayList arrayList = new ArrayList();
        float f = this.mContext.getScreenMetrics().density;
        int scrollX = ((ListContainerView) this.mView).getScrollX();
        int scrollY = ((ListContainerView) this.mView).getScrollY();
        for (int i = 0; i < ((ListContainerView) this.mView).getLinearLayout().getChildCount(); i++) {
            View childAt = ((ListContainerView) this.mView).getLinearLayout().getChildAt(i);
            if (childAt instanceof ComponentView) {
                ComponentView componentView = (ComponentView) childAt;
                if (!this.mIsVertical) {
                    if (!isVisibleCellHorizontal(componentView)) {
                    }
                    drawChildHook = componentView.getDrawChildHook();
                    if (!(drawChildHook instanceof UIComponent)) {
                    }
                } else {
                    if (!isVisibleCellVertical(componentView)) {
                    }
                    drawChildHook = componentView.getDrawChildHook();
                    if (!(drawChildHook instanceof UIComponent)) {
                        UIComponent uIComponent = (UIComponent) drawChildHook;
                        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                        javaOnlyMap.put("id", uIComponent.getIdSelector());
                        javaOnlyMap.put(PropsConstants.POSITION, Integer.valueOf(getIndexFromItemKey(uIComponent.getItemKey())));
                        javaOnlyMap.put("index", Integer.valueOf(getIndexFromItemKey(uIComponent.getItemKey())));
                        javaOnlyMap.put("itemKey", uIComponent.getItemKey());
                        javaOnlyMap.put(PropsConstants.HIT_SLOP_TOP, Float.valueOf((childAt.getTop() - scrollY) / f));
                        javaOnlyMap.put(PropsConstants.HIT_SLOP_BOTTOM, Float.valueOf((childAt.getBottom() - scrollY) / f));
                        javaOnlyMap.put(PropsConstants.HIT_SLOP_LEFT, Float.valueOf((childAt.getLeft() - scrollX) / f));
                        javaOnlyMap.put(PropsConstants.HIT_SLOP_RIGHT, Float.valueOf((childAt.getRight() - scrollX) / f));
                        arrayList.add(javaOnlyMap);
                    }
                }
            }
        }
        Collections.sort(arrayList, new Comparator<JavaOnlyMap>() { // from class: com.lynx.tasm.behavior.ui.list.container.UIListContainer.4
            @Override // java.util.Comparator
            public int compare(JavaOnlyMap javaOnlyMap2, JavaOnlyMap javaOnlyMap3) {
                return Integer.compare(javaOnlyMap2.getInt(PropsConstants.POSITION), javaOnlyMap3.getInt(PropsConstants.POSITION));
            }
        });
        return JavaOnlyArray.from(arrayList);
    }

    private boolean isVisibleCellVertical(ComponentView componentView) {
        int top = componentView.getTop();
        int bottom = componentView.getBottom();
        int scrollY = ((ListContainerView) this.mView).getScrollY();
        int height = ((ListContainerView) this.mView).getHeight() + scrollY;
        return (top <= scrollY && bottom >= scrollY) || (top <= height && bottom >= height) || (top >= scrollY && bottom <= height);
    }

    private boolean isVisibleCellHorizontal(ComponentView componentView) {
        int left = componentView.getLeft();
        int right = componentView.getRight();
        int scrollX = ((ListContainerView) this.mView).getScrollX();
        int width = ((ListContainerView) this.mView).getWidth() + scrollX;
        return (left <= scrollX && right >= scrollX) || (left <= width && right >= width) || (left >= scrollX && right <= width);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> map) {
        super.setEvents(map);
        if (map == null) {
            return;
        }
        this.mEnableScrollEndEvent = map.containsKey(LynxScrollEvent.EVENT_SCROLL_END);
        this.mEnableScrollStateChangeEvent = map.containsKey("scrollstatechange");
    }

    @LynxUIMethod
    public void autoScroll(ReadableMap readableMap, final Callback callback) {
        if (this.mAutoScroller == null) {
            this.mAutoScroller = new UIListAutoScroller() { // from class: com.lynx.tasm.behavior.ui.list.container.UIListContainer.5
                @Override // com.lynx.tasm.behavior.p000ui.list.container.UIListAutoScroller
                void onAutoScrollError(String str) {
                    callback.invoke(new Object[]{1, str});
                }

                @Override // com.lynx.tasm.behavior.p000ui.list.container.UIListAutoScroller
                void onAutoScrollStart() {
                    ((ListContainerView) UIListContainer.this.mView).mIsDuringAutoScroll = true;
                    if (UIListContainer.this.mScrollToCallback != null) {
                        Callback callback2 = UIListContainer.this.mScrollToCallback;
                        UIListContainer.this.mScrollToCallback = null;
                        callback2.invoke(new Object[]{4, "the scroll has stopped, triggered by auto scroll"});
                    }
                    if (canScroll(this.mAutoRatePerFrame)) {
                        ((ListContainerView) UIListContainer.this.mView).setScrollState(4);
                    }
                    callback.invoke(new Object[]{0});
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.lynx.tasm.behavior.p000ui.list.container.UIListAutoScroller
                boolean canScroll(int i) {
                    if (i <= 0 || !((ListContainerView) UIListContainer.this.getView()).canScrollBy(1)) {
                        return i < 0 && ((ListContainerView) UIListContainer.this.getView()).canScrollBy(-1);
                    }
                    return true;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.lynx.tasm.behavior.p000ui.list.container.UIListAutoScroller
                void scrollBy(int i) {
                    if (UIListContainer.this.mIsVertical) {
                        ((ListContainerView) UIListContainer.this.getView()).scrollBy(0, i);
                    } else {
                        ((ListContainerView) UIListContainer.this.getView()).scrollBy(i, 0);
                    }
                }

                @Override // com.lynx.tasm.behavior.p000ui.list.container.UIListAutoScroller
                void onAutoScrollEnd() {
                    ((ListContainerView) UIListContainer.this.mView).mIsDuringAutoScroll = false;
                    ((ListContainerView) UIListContainer.this.mView).setScrollState(1);
                }
            };
        }
        this.mAutoScroller.setAutoScrollParams(readableMap.getBoolean("start", true), readableMap.getBoolean("autoStop", true));
        this.mAutoScroller.execute(readableMap.getString("rate", ""), getLynxContext());
    }

    @Override // com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView.OnScrollStateChangeListener
    public void onScrollStateChange(NestedScrollContainerView nestedScrollContainerView, int i) {
        if (i != 1) {
            recognizeGesturere();
        }
        if (i == 1) {
            getLynxContext().getFluencyTraceHelper().stop(getSign());
            Callback callback = this.mScrollToCallback;
            if (callback != null) {
                this.mScrollToCallback = null;
                callback.invoke(new Object[]{0});
            }
            if (this.mEnableScrollEndEvent) {
                sendCustomEvent(((ListContainerView) this.mView).getScrollX(), ((ListContainerView) this.mView).getScrollY(), ((ListContainerView) this.mView).getScrollX(), ((ListContainerView) this.mView).getScrollY(), LynxScrollEvent.EVENT_SCROLL_END);
            }
        } else if (i == 2) {
            getLynxContext().getFluencyTraceHelper().start(getSign(), "scroll", getScrollMonitorTag());
            Callback callback2 = this.mScrollToCallback;
            if (callback2 != null) {
                this.mScrollToCallback = null;
                callback2.invoke(new Object[]{1, "the scroll has stopped, triggered by dragging events"});
            }
        }
        if (this.mEnableScrollStateChangeEvent) {
            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSign(), "scrollstatechange");
            if (this.mEnableNeedVisibleItemInfo) {
                lynxDetailEvent.addDetail("attachedCells", visibleCellsInfo());
            }
            lynxDetailEvent.addDetail("state", Integer.valueOf(i));
            this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent);
        }
    }

    public void sendCustomEvent(int i, int i2, int i3, int i4, String str) {
        LynxScrollEvent createScrollEvent = LynxScrollEvent.createScrollEvent(getSign(), str);
        createScrollEvent.setScrollParams(i, i2, ((ListContainerView) this.mView).getMeasuredHeight(), ((ListContainerView) this.mView).getMeasuredWidth(), i - i3, i2 - i4);
        if (getLynxContext() != null) {
            getLynxContext().getEventEmitter().sendCustomEvent(createScrollEvent);
        }
    }

    public void updateScrollInfo(boolean z, float f, boolean z2) {
        int i = (int) f;
        this.mScrollingEstimatedOffset = i;
        if (z2) {
            return;
        }
        if (((ListContainerView) this.mView).getCustomScrollHook() != this.mCustomScrollHook) {
            ((ListContainerView) this.mView).setCustomScrollHook(this.mCustomScrollHook);
        }
        ListContainerView listContainerView = (ListContainerView) this.mView;
        boolean z3 = this.mIsVertical;
        int i2 = z3 ? 0 : i;
        if (!z3) {
            i = 0;
        }
        listContainerView.smoothScrollTo(i2, i);
    }

    private int getIndexFromItemKey(String str) {
        if (TextUtils.isEmpty(str) || !this.mItemKeyMap.containsKey(str)) {
            return -1;
        }
        return this.mItemKeyMap.get(str).intValue();
    }

    private void updateStickyInfoForInsertedChild(LynxBaseUI lynxBaseUI, HashMap<Integer, UIComponent> hashMap, JavaOnlyArray javaOnlyArray, int i) {
        if (this.mEnableListSticky && (lynxBaseUI instanceof UIComponent)) {
            int size = javaOnlyArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i == javaOnlyArray.getInt(i2)) {
                    hashMap.put(Integer.valueOf(i), (UIComponent) lynxBaseUI);
                    return;
                }
            }
        }
    }

    private void updateStickyInfoForDeletedChild(LynxBaseUI lynxBaseUI, HashMap<Integer, UIComponent> hashMap) {
        if (this.mEnableListSticky && (lynxBaseUI instanceof UIComponent)) {
            Iterator<Map.Entry<Integer, UIComponent>> it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue() == lynxBaseUI) {
                    if (this.mEnableRecycleStickyItem) {
                        resetStickyItem((UIComponent) lynxBaseUI);
                    }
                    it.remove();
                    return;
                }
            }
        }
    }

    private void updateStickyInfoForUpdatedChild(LynxBaseUI lynxBaseUI, HashMap<Integer, UIComponent> hashMap, JavaOnlyArray javaOnlyArray, int i) {
        if (this.mEnableListSticky && (lynxBaseUI instanceof UIComponent)) {
            UIComponent uIComponent = (UIComponent) lynxBaseUI;
            int size = javaOnlyArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i == javaOnlyArray.getInt(i2)) {
                    hashMap.put(Integer.valueOf(i), uIComponent);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void resetStickyItem(UIComponent uIComponent) {
        if (uIComponent.getView() != 0) {
            if (this.mIsVertical) {
                ((AndroidView) uIComponent.getView()).setTranslationY(0.0f);
            } else {
                ((AndroidView) uIComponent.getView()).setTranslationX(0.0f);
            }
            setChildTranslationZ(uIComponent);
        }
    }

    private UIComponent getStickyItemWithIndex(Integer num, boolean z) {
        String string;
        if (this.mUpdateStickyForDiff) {
            HashMap<String, UIComponent> hashMap = z ? this.mStickyTopItemMap : this.mStickyBottomItemMap;
            int intValue = num.intValue();
            if (intValue < 0 || intValue >= this.mItemKeys.size() || (string = this.mItemKeys.getString(intValue)) == null) {
                return null;
            }
            return hashMap.get(string);
        }
        return (z ? this.mStickyTopItems : this.mStickyBottomItems).get(num);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateStickyStarts() {
        int left;
        int width;
        if (this.mEnableListSticky) {
            int scrollY = (this.mIsVertical ? getScrollY() : getScrollX()) + this.mStickyOffset;
            JavaOnlyArray javaOnlyArray = this.mStickyTopIndexes;
            ListIterator listIterator = javaOnlyArray.listIterator(javaOnlyArray.size());
            UIComponent uIComponent = null;
            UIComponent uIComponent2 = null;
            while (listIterator.hasPrevious()) {
                UIComponent stickyItemWithIndex = getStickyItemWithIndex((Integer) listIterator.previous(), true);
                if (stickyItemWithIndex != null) {
                    if ((this.mIsVertical ? stickyItemWithIndex.getTop() : stickyItemWithIndex.getLeft()) > scrollY) {
                        resetStickyItem(stickyItemWithIndex);
                        uIComponent2 = stickyItemWithIndex;
                    } else if (uIComponent != null) {
                        resetStickyItem(stickyItemWithIndex);
                    } else {
                        uIComponent = stickyItemWithIndex;
                    }
                }
            }
            if (uIComponent != null) {
                if (this.mPrevStickyTopItem != uIComponent) {
                    if (this.mIsVertical) {
                        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSign(), "stickytop");
                        lynxDetailEvent.addDetail(PropsConstants.HIT_SLOP_TOP, uIComponent.getItemKey());
                        this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent);
                    }
                    LynxDetailEvent lynxDetailEvent2 = new LynxDetailEvent(getSign(), "stickystart");
                    lynxDetailEvent2.addDetail("start", uIComponent.getItemKey());
                    this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent2);
                    this.mPrevStickyTopItem = uIComponent;
                }
                if (uIComponent2 != null) {
                    if (this.mIsVertical) {
                        left = uIComponent2.getTop() - scrollY;
                        width = uIComponent.getHeight();
                    } else {
                        left = uIComponent2.getLeft() - scrollY;
                        width = uIComponent.getWidth();
                    }
                    int i = width - left;
                    if (i > 0) {
                        scrollY -= i;
                    }
                }
                if (uIComponent.getView() != 0) {
                    if (this.mIsVertical) {
                        ((AndroidView) uIComponent.getView()).setTranslationY(scrollY - uIComponent.getTop());
                    } else {
                        ((AndroidView) uIComponent.getView()).setTranslationX(scrollY - uIComponent.getLeft());
                    }
                    ((AndroidView) uIComponent.getView()).bringToFront();
                    setChildTranslationZ(uIComponent, 2.14748365E9f);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updateStickyEnds() {
        int width;
        int i;
        int left;
        int width2;
        int left2;
        int width3;
        if (this.mEnableListSticky) {
            if (this.mIsVertical) {
                width = getHeight() + getScrollY();
                i = this.mStickyOffset;
            } else {
                width = getWidth() + getScrollX();
                i = this.mStickyOffset;
            }
            int i2 = width - i;
            Iterator it = this.mStickyBottomIndexes.iterator();
            UIComponent uIComponent = null;
            UIComponent uIComponent2 = null;
            while (it.hasNext()) {
                UIComponent stickyItemWithIndex = getStickyItemWithIndex((Integer) it.next(), false);
                if (stickyItemWithIndex != null) {
                    if (this.mIsVertical) {
                        left2 = stickyItemWithIndex.getTop();
                        width3 = stickyItemWithIndex.getHeight();
                    } else {
                        left2 = stickyItemWithIndex.getLeft();
                        width3 = stickyItemWithIndex.getWidth();
                    }
                    if (left2 + width3 < i2) {
                        resetStickyItem(stickyItemWithIndex);
                        uIComponent2 = stickyItemWithIndex;
                    } else if (uIComponent != null) {
                        resetStickyItem(stickyItemWithIndex);
                    } else {
                        uIComponent = stickyItemWithIndex;
                    }
                }
            }
            if (uIComponent != null) {
                if (this.mPrevStickyBottomItem != uIComponent) {
                    if (this.mIsVertical) {
                        LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(getSign(), "stickybottom");
                        lynxDetailEvent.addDetail(PropsConstants.HIT_SLOP_BOTTOM, uIComponent.getItemKey());
                        this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent);
                    }
                    LynxDetailEvent lynxDetailEvent2 = new LynxDetailEvent(getSign(), "stickyend");
                    lynxDetailEvent2.addDetail("end", uIComponent.getItemKey());
                    this.mContext.getEventEmitter().sendCustomEvent(lynxDetailEvent2);
                    this.mPrevStickyBottomItem = uIComponent;
                }
                int height = i2 - (this.mIsVertical ? uIComponent.getHeight() : uIComponent.getWidth());
                if (uIComponent2 != null) {
                    if (this.mIsVertical) {
                        left = i2 - (uIComponent2.getTop() + uIComponent2.getHeight());
                        width2 = uIComponent.getHeight();
                    } else {
                        left = i2 - (uIComponent2.getLeft() + uIComponent2.getWidth());
                        width2 = uIComponent.getWidth();
                    }
                    int i3 = width2 - left;
                    if (i3 > 0) {
                        height += i3;
                    }
                }
                if (uIComponent.getView() != 0) {
                    if (this.mIsVertical) {
                        ((AndroidView) uIComponent.getView()).setTranslationY(height - uIComponent.getTop());
                    } else {
                        ((AndroidView) uIComponent.getView()).setTranslationX(height - uIComponent.getLeft());
                    }
                    ((AndroidView) uIComponent.getView()).bringToFront();
                    setChildTranslationZ(uIComponent, 2.14748365E9f);
                }
            }
        }
    }

    private void generateStickyItemKeySet(HashSet<String> hashSet, JavaOnlyArray javaOnlyArray, HashMap<String, UIComponent> hashMap) {
        hashSet.clear();
        int size = javaOnlyArray.size();
        for (int i = 0; i < size; i++) {
            int i2 = javaOnlyArray.getInt(i);
            if (i2 >= 0 && i2 < this.mItemKeys.size()) {
                hashSet.add(this.mItemKeys.getString(i2));
            }
        }
        Iterator<Map.Entry<String, UIComponent>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, UIComponent> next = it.next();
            String key = next.getKey();
            UIComponent value = next.getValue();
            if (value != null && key != null && !hashSet.contains(key)) {
                resetStickyItem(value);
                value.setNodeReadyListener(null);
                it.remove();
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getScrollX() {
        return ((ListContainerView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getScrollY() {
        return ((ListContainerView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
        if (this.mEnableListSticky && this.mUpdateStickyForDiff) {
            generateStickyItemKeySet(this.mStickyTopItemKeySet, this.mStickyTopIndexes, this.mStickyTopItemMap);
            generateStickyItemKeySet(this.mStickyBottomItemKeySet, this.mStickyBottomIndexes, this.mStickyBottomItemMap);
        }
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onGestureScrollBy(final float f, final float f2) {
        if (isEnableNewGesture()) {
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.container.UIListContainer$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    UIListContainer.this.m4xf875b2f4(f2, f);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onGestureScrollBy$1$com-lynx-tasm-behavior-ui-list-container-UIListContainer */
    public /* synthetic */ void m4xf875b2f4(float f, float f2) {
        if (this.mView == 0) {
            return;
        }
        if (this.mIsVertical) {
            ((ListContainerView) this.mView).scrollBy(0, (int) f);
        } else {
            ((ListContainerView) this.mView).scrollBy((int) f2, 0);
        }
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean canConsumeGesture(float f, float f2) {
        if (!isEnableNewGesture()) {
            return false;
        }
        if (this.mIsVertical) {
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
    public int getMemberScrollX() {
        if (this.mIsVertical) {
            return 0;
        }
        return ((ListContainerView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getScrollContainerDirection() {
        return this.mIsVertical ? 1 : -1;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollY() {
        if (this.mIsVertical) {
            return ((ListContainerView) this.mView).getScrollY();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean isAtBorder(boolean z) {
        if (!isEnableNewGesture()) {
            return false;
        }
        if (z) {
            return !((ListContainerView) getView()).canScrollBy(-1);
        }
        return !((ListContainerView) getView()).canScrollBy(1);
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onInvalidate() {
        if (!isEnableNewGesture() || this.mView == 0) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, GestureDetector> map) {
        super.setGestureDetectors(map);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.gesture.GestureArenaMember
    public Map<Integer, BaseGestureHandler> getGestureHandlers() {
        return super.getGestureHandlers();
    }
}

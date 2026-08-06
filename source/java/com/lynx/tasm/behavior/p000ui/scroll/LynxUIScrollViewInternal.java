package com.lynx.tasm.behavior.p000ui.scroll;

import android.content.Context;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewScrolling;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxScrollEvent;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.UnitUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIScrollViewInternal extends UISimpleView<LynxBaseScrollView> implements LynxBaseScrollViewScrolling.ScrollDelegate {
    private boolean mAtLower;
    private boolean mAtUpper;
    private ArrayList<LynxUIScrollViewInternalNodeReadyBlock> mFirstRenderBlockArray;
    private int[] mLastContentOffset;
    private long mLastUpdateTime;
    private int mLowerThreshold;
    private long mThrottle;
    private int mUpperThreshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface LynxUIScrollViewInternalNodeReadyBlock {
        void invoke(LynxUIScrollViewInternal lynxUIScrollViewInternal);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScrolling.ScrollDelegate
    public void onScrollStateChanged(int i, int i2) {
        if (i2 == 0) {
            sendScrollEvent(LynxScrollEvent.EVENT_SCROLL_END, null);
        } else if (i2 == 1) {
            sendScrollEvent(LynxScrollEvent.EVENT_SCROLL_START, null);
        } else if (i2 == 2 && i == 0) {
            sendScrollEvent(LynxScrollEvent.EVENT_SCROLL_START, null);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("previousState", Integer.valueOf(i));
        hashMap.put("currentState", Integer.valueOf(i2));
        sendScrollEvent("scrollstatechange", hashMap);
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScrolling.ScrollDelegate
    public void scrollViewDidScroll(LynxBaseScrollViewScrolling lynxBaseScrollViewScrolling) {
        tryToSendScrollEvent();
        updateScrollPosition();
        updateSticky();
    }

    private void tryToSendScrollEvent() {
        if (this.mThrottle != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastUpdateTime >= this.mThrottle) {
                int[] scrollOffset = ((LynxBaseScrollView) this.mView).getScrollOffset();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("deltaX", Integer.valueOf(scrollOffset[0] - this.mLastContentOffset[0]));
                hashMap.put("deltaY", Integer.valueOf(scrollOffset[1] - this.mLastContentOffset[1]));
                sendScrollEvent("scroll", hashMap);
                this.mLastContentOffset = scrollOffset;
                this.mLastUpdateTime = currentTimeMillis;
                return;
            }
            return;
        }
        int[] scrollOffset2 = ((LynxBaseScrollView) this.mView).getScrollOffset();
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("deltaX", Integer.valueOf(scrollOffset2[0] - this.mLastContentOffset[0]));
        hashMap2.put("deltaY", Integer.valueOf(scrollOffset2[1] - this.mLastContentOffset[1]));
        sendScrollEvent("scroll", hashMap2);
        this.mLastContentOffset = scrollOffset2;
    }

    private void updateScrollPosition() {
        LynxBaseScrollView lynxBaseScrollView = (LynxBaseScrollView) this.mView;
        int scrollOffsetVertically = lynxBaseScrollView.isVertical() ? lynxBaseScrollView.getScrollOffsetVertically() : lynxBaseScrollView.getScrollOffsetHorizontally();
        int[] scrollRangeVertically = lynxBaseScrollView.isVertical() ? lynxBaseScrollView.getScrollRangeVertically() : lynxBaseScrollView.getScrollRangeHorizontally();
        boolean z = scrollOffsetVertically <= scrollRangeVertically[0] + this.mUpperThreshold;
        boolean z2 = scrollOffsetVertically >= scrollRangeVertically[1] - this.mLowerThreshold;
        if (z && !this.mAtUpper) {
            sendScrollEvent("scrolltoupper", null);
        }
        if (z2 && !this.mAtLower) {
            sendScrollEvent("scrolltolower", null);
        }
        this.mAtUpper = z;
        this.mAtLower = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateSticky() {
        int[] scrollOffset = ((LynxBaseScrollView) getView()).getScrollOffset();
        boolean z = false;
        for (int i = 0; i < this.mChildren.size(); i++) {
            if (this.mChildren.get(i).checkStickyOnParentScroll(scrollOffset[0], scrollOffset[1])) {
                z = true;
            }
        }
        if (z) {
            invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static int[] getPositionOf(LynxBaseUI lynxBaseUI, LynxUIScrollViewInternal lynxUIScrollViewInternal, boolean z) {
        int[] iArr = {0, 0};
        if (lynxUIScrollViewInternal != null && lynxBaseUI != null) {
            if (z) {
                iArr[0] = (((LynxBaseScrollView) lynxUIScrollViewInternal.getView()).getScrollRange()[1] - lynxBaseUI.getLeft()) - lynxBaseUI.getWidth();
                iArr[1] = lynxBaseUI.getTop();
            } else {
                iArr[0] = lynxBaseUI.getLeft();
                iArr[1] = lynxBaseUI.getTop();
            }
        }
        return iArr;
    }

    static void addOffset(int[] iArr, int[] iArr2, boolean z) {
        iArr[0] = iArr[0] + (z ? -iArr2[0] : iArr2[0]);
        iArr[1] = iArr[1] + iArr2[1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void formatOffset(int[] iArr, LynxUIScrollViewInternal lynxUIScrollViewInternal, boolean z) {
        if (z) {
            iArr[0] = ((LynxBaseScrollView) lynxUIScrollViewInternal.getView()).getScrollRange()[1] - iArr[0];
        }
    }

    public LynxUIScrollViewInternal(LynxContext lynxContext) {
        super(lynxContext);
        this.mThrottle = 0L;
        this.mLastUpdateTime = 0L;
        this.mLastContentOffset = new int[]{0, 0};
        this.mUpperThreshold = 0;
        this.mLowerThreshold = 0;
        this.mAtUpper = false;
        this.mAtLower = false;
        this.mFirstRenderBlockArray = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public LynxBaseScrollView createView(Context context) {
        LynxBaseScrollView lynxBaseScrollView = new LynxBaseScrollView(context);
        lynxBaseScrollView.setScrollDelegate(this);
        return lynxBaseScrollView;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        ((LynxBaseScrollView) this.mView).setScrollDelegate(null);
    }

    public void setScrollOrientation(String str) {
        ((LynxBaseScrollView) this.mView).setVertical("vertical".equals(str));
    }

    public void setEnableScroll(boolean z) {
        ((LynxBaseScrollView) this.mView).enableScroll(z);
    }

    public void setBounces(boolean z) {
        ((LynxBaseScrollView) this.mView).enableBounces(z);
    }

    public void setForwardsNestedScroll(int i) {
        ((LynxBaseScrollView) this.mView).setForwardNestedScrollMode(i);
    }

    public void setBackwardsNestedScroll(int i) {
        ((LynxBaseScrollView) this.mView).setBackwardNestedScrollMode(i);
    }

    public void setInitialScrollIndex(final int i) {
        ArrayList<LynxUIScrollViewInternalNodeReadyBlock> arrayList = this.mFirstRenderBlockArray;
        if (arrayList != null) {
            arrayList.add(new LynxUIScrollViewInternalNodeReadyBlock() { // from class: com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal$$ExternalSyntheticLambda1
                @Override // com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal.LynxUIScrollViewInternalNodeReadyBlock
                public final void invoke(LynxUIScrollViewInternal lynxUIScrollViewInternal) {
                    LynxUIScrollViewInternal.lambda$setInitialScrollIndex$0(i, lynxUIScrollViewInternal);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$setInitialScrollIndex$0(int i, LynxUIScrollViewInternal lynxUIScrollViewInternal) {
        if (i < 0 || i >= lynxUIScrollViewInternal.getChildCount()) {
            return;
        }
        ((LynxBaseScrollView) lynxUIScrollViewInternal.getView()).scrollTo(getPositionOf(lynxUIScrollViewInternal.getChildAt(i), lynxUIScrollViewInternal, lynxUIScrollViewInternal.isRtl()));
    }

    public void setInitialScrollOffset(final String str) {
        ArrayList<LynxUIScrollViewInternalNodeReadyBlock> arrayList = this.mFirstRenderBlockArray;
        if (arrayList != null) {
            arrayList.add(new LynxUIScrollViewInternalNodeReadyBlock() { // from class: com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal$$ExternalSyntheticLambda0
                @Override // com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal.LynxUIScrollViewInternalNodeReadyBlock
                public final void invoke(LynxUIScrollViewInternal lynxUIScrollViewInternal) {
                    LynxUIScrollViewInternal.this.m6xaccacce8(str, lynxUIScrollViewInternal);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$setInitialScrollOffset$1$com-lynx-tasm-behavior-ui-scroll-LynxUIScrollViewInternal */
    public /* synthetic */ void m6xaccacce8(String str, LynxUIScrollViewInternal lynxUIScrollViewInternal) {
        int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(str, ((LynxBaseScrollView) lynxUIScrollViewInternal.getView()).isVertical() ? lynxUIScrollViewInternal.getHeight() : lynxUIScrollViewInternal.getWidth(), 0.0f, getLynxContext().getScreenMetrics());
        int[] iArr = {pxWithDisplayMetrics, pxWithDisplayMetrics};
        formatOffset(iArr, lynxUIScrollViewInternal, lynxUIScrollViewInternal.isRtl());
        ((LynxBaseScrollView) lynxUIScrollViewInternal.getView()).scrollTo(iArr);
    }

    public void setLowerThreshold(String str) {
        this.mLowerThreshold = (int) UnitUtils.toPxWithDisplayMetrics(str, ((LynxBaseScrollView) this.mView).isVertical() ? getHeight() : getWidth(), 0.0f, getLynxContext().getScreenMetrics());
    }

    public void setUpperThreshold(String str) {
        this.mUpperThreshold = (int) UnitUtils.toPxWithDisplayMetrics(str, ((LynxBaseScrollView) this.mView).isVertical() ? getHeight() : getWidth(), 0.0f, getLynxContext().getScreenMetrics());
    }

    public void setScrollEventThrottle(float f) {
        this.mThrottle = f;
    }

    public void scrollTo(ReadableMap readableMap, Callback callback) {
        int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(readableMap.getString("offset", "0px"), ((LynxBaseScrollView) this.mView).isVertical() ? getHeight() : getWidth(), 0.0f, getLynxContext().getScreenMetrics());
        boolean z = readableMap.getBoolean("smooth", readableMap.getBoolean("animated", true));
        int i = readableMap.getInt("index", -1);
        if (i >= 0 && i < getChildCount()) {
            int[] positionOf = getPositionOf(getChildAt(i), this, isRtl());
            addOffset(positionOf, new int[]{pxWithDisplayMetrics, pxWithDisplayMetrics}, isRtl());
            if (z) {
                ((LynxBaseScrollView) this.mView).animatedScrollTo(positionOf, null);
            } else {
                ((LynxBaseScrollView) this.mView).scrollTo(positionOf);
            }
            callback.invoke(new Object[]{0});
            return;
        }
        callback.invoke(new Object[]{4, "scrollTo index: " + i + " is out of range[0, " + getChildCount() + ")."});
    }

    public void scrollBy(ReadableMap readableMap, Callback callback) {
        int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(readableMap.getString("offset", "0px"), ((LynxBaseScrollView) this.mView).isVertical() ? getHeight() : getWidth(), 0.0f, getLynxContext().getScreenMetrics());
        ((LynxBaseScrollView) this.mView).scrollBy(new int[]{pxWithDisplayMetrics, pxWithDisplayMetrics});
        callback.invoke(new Object[]{0});
    }

    public void autoScroll(ReadableMap readableMap, Callback callback) {
        if (readableMap.getBoolean("start", true)) {
            int pxWithDisplayMetrics = (int) UnitUtils.toPxWithDisplayMetrics(readableMap.getString("rate", "0px"), ((LynxBaseScrollView) this.mView).isVertical() ? getHeight() : getWidth(), 0.0f, getLynxContext().getScreenMetrics());
            int refreshRate = (int) DeviceUtils.getRefreshRate(this.mContext);
            if (refreshRate <= 0) {
                refreshRate = 60;
            }
            ((LynxBaseScrollView) this.mView).autoScrollWithRate(pxWithDisplayMetrics > 0 ? Math.max(pxWithDisplayMetrics / refreshRate, 1) : Math.min(pxWithDisplayMetrics / refreshRate, -1), true, null);
        } else {
            ((LynxBaseScrollView) this.mView).stopScrolling();
        }
        callback.invoke(new Object[]{0});
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        ((LynxBaseScrollView) this.mView).mWidth = getWidth();
        ((LynxBaseScrollView) this.mView).mHeight = getHeight();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getScrollX() {
        return ((LynxBaseScrollView) this.mView).getScrollX();
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getScrollY() {
        return ((LynxBaseScrollView) this.mView).getScrollY();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void measure() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            LynxBaseUI childAt = getChildAt(i3);
            i2 = Math.max(i2, childAt.getHeight() + childAt.getTop() + childAt.getMarginBottom() + this.mPaddingBottom);
            i = Math.max(i, childAt.getWidth() + childAt.getLeft() + childAt.getMarginRight() + this.mPaddingRight);
        }
        ((LynxBaseScrollView) this.mView).setScrollContentSize(new int[]{i, i2});
        flushFirstRenderOperations();
        updateScrollPosition();
        super.measure();
    }

    private void flushFirstRenderOperations() {
        if (this.mFirstRender) {
            Iterator<LynxUIScrollViewInternalNodeReadyBlock> it = this.mFirstRenderBlockArray.iterator();
            while (it.hasNext()) {
                it.next().invoke(this);
            }
            this.mFirstRenderBlockArray = null;
            this.mFirstRender = false;
        }
    }

    private void sendScrollEvent(String str, HashMap<String, Object> hashMap) {
        HashMap hashMap2 = new HashMap();
        LynxBaseScrollView lynxBaseScrollView = (LynxBaseScrollView) this.mView;
        hashMap2.put("scrollLeft", Integer.valueOf(lynxBaseScrollView.getScrollOffsetHorizontally()));
        hashMap2.put("scrollTop", Integer.valueOf(lynxBaseScrollView.getScrollOffsetVertically()));
        hashMap2.put("scrollHeight", Integer.valueOf(lynxBaseScrollView.getScrollRangeVertically()[1]));
        hashMap2.put("scrollWidth", Integer.valueOf(lynxBaseScrollView.getScrollRangeHorizontally()[1]));
        hashMap2.put("isDragging", Boolean.valueOf(lynxBaseScrollView.currentScrollState() == 1));
        hashMap2.put("scrollState", Integer.valueOf(lynxBaseScrollView.currentScrollState()));
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        this.mContext.getEventEmitter().sendCustomEvent(new LynxCustomEvent(getSign(), str, hashMap2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void scrollInto(LynxBaseUI lynxBaseUI, boolean z, String str) {
        int[] iArr = {0, 0};
        if ("center".equals(str)) {
            iArr[1] = iArr[1] - ((((LynxBaseScrollView) getView()).getHeight() - lynxBaseUI.getHeight()) / 2);
            iArr[0] = iArr[0] - ((((LynxBaseScrollView) getView()).getWidth() - lynxBaseUI.getWidth()) / 2);
        } else if ("end".equals(str)) {
            iArr[1] = iArr[1] - (((LynxBaseScrollView) getView()).getHeight() - lynxBaseUI.getHeight());
            iArr[0] = iArr[0] - (((LynxBaseScrollView) getView()).getWidth() - lynxBaseUI.getWidth());
        }
        while (lynxBaseUI != this) {
            iArr[1] = iArr[1] + lynxBaseUI.getTop();
            iArr[0] = iArr[0] + lynxBaseUI.getLeft();
            lynxBaseUI = lynxBaseUI.getParentBaseUI();
            while (lynxBaseUI instanceof LynxFlattenUI) {
                lynxBaseUI = (LynxBaseUI) lynxBaseUI.getParent();
            }
        }
        if (z) {
            ((LynxBaseScrollView) this.mView).animatedScrollTo(iArr, null);
        } else {
            ((LynxBaseScrollView) this.mView).scrollTo(iArr);
        }
    }
}

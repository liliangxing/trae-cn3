package com.lynx.tasm.behavior.p000ui.list;

import android.view.ViewGroup;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.IListNodeInfoFetcher;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView;
import com.vivo.push.PushClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsLynxList<T extends ViewGroup> extends UISimpleView<T> {
    protected static final String ALIGN_TO_BOTTOM = "bottom";
    protected static final String ALIGN_TO_MIDDLE = "middle";
    protected static final String ALIGN_TO_NONE = "none";
    protected static final String ALIGN_TO_TOP = "top";
    protected static final String LIST_TYPE_FLOW = "flow";
    protected static final String LIST_TYPE_SINGLE = "single";
    protected static final String LIST_TYPE_WATERFALL = "waterfall";
    protected static final String METHOD_PARAMS_ALIGN_TO = "alignTo";
    protected static final String METHOD_PARAMS_INDEX = "index";
    protected static final String METHOD_PARAMS_ITEM_HEIGHT = "itemHeight";
    protected static final String METHOD_PARAMS_OFFSET = "offset";
    protected static final String METHOD_PARAMS_POSITION = "position";
    protected static final String METHOD_PARAMS_SMOOTH = "smooth";
    private int[] mCellViewLocation;
    private LynxBaseUI mCurrentChild;
    private IListNodeInfoFetcher mListNodeInfoFetcher;
    private int[] mRootViewLocation;

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean isScrollable() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public void onInsertChild(LynxBaseUI lynxBaseUI, int i) {
    }

    public abstract void sendCustomEvent(int i, int i2, int i3, int i4, String str);

    @LynxProp(customType = PushClient.DEFAULT_REQUEST_ID, name = "cache-queue-ratio")
    public abstract void setCacheQueueRatio(Dynamic dynamic);

    @LynxProp(defaultInt = 1, name = "column-count")
    public abstract void setColumnCount(int i);

    @LynxProp(defaultBoolean = false, name = "component-init-measure")
    public abstract void setComponentInitMeasure(boolean z);

    @LynxProp(customType = "0", name = "list-cross-axis-gap")
    public abstract void setCrossAxisGap(float f);

    @LynxProp(customType = "false", name = "paging-enabled")
    public abstract void setEnablePagerSnap(Dynamic dynamic);

    @LynxProp(name = "sticky")
    public abstract void setEnableSticky(Dynamic dynamic);

    @LynxProp(customType = "0", name = "initial-scroll-index")
    public abstract void setInitialScrollIndex(Dynamic dynamic);

    @LynxProp(defaultBoolean = false, name = "internal-cell-appear-notification")
    public void setInternalCellAppearNotification(boolean z) {
    }

    @LynxProp(defaultBoolean = false, name = "internal-cell-disappear-notification")
    public void setInternalCellDisappearNotification(boolean z) {
    }

    @LynxProp(defaultBoolean = false, name = "internal-cell-prepare-for-reuse-notification")
    public void setInternalCellPrepareForReuseNotification(boolean z) {
    }

    @LynxProp(customType = "single", name = "list-type")
    public abstract void setListType(String str);

    @LynxProp(defaultInt = 50, name = "lower-threshold")
    public abstract void setLowerThreshold(Dynamic dynamic);

    @LynxProp(defaultInt = 0, name = "lower-threshold-item-count")
    public void setLowerThresholdItemCount(Dynamic dynamic) {
    }

    @LynxProp(customType = "0", name = "list-main-axis-gap")
    public abstract void setMainAxisGap(float f);

    @LynxProp(defaultBoolean = false, name = "needs-visible-cells")
    public abstract void setNeedVisibleCells(boolean z);

    @LynxProp(defaultBoolean = false, name = "no-invalidate")
    public abstract void setNoInvalidate(boolean z);

    @LynxProp(name = "item-snap")
    public abstract void setPagingAlignment(ReadableMap readableMap);

    @LynxProp(customType = "true", name = "enable-scroll")
    public abstract void setScrollEnable(Dynamic dynamic);

    @LynxProp(customType = "200", name = "scroll-event-throttle")
    public abstract void setScrollEventThrottle(Dynamic dynamic);

    @LynxProp(customType = "10", name = "scroll-state-change-event-throttle")
    public abstract void setScrollStateChangeEventThrottle(String str);

    @LynxProp(customType = "false", name = "scroll-x")
    public abstract void setScrollX(Dynamic dynamic);

    @LynxProp(customType = "true", name = "scroll-y")
    public abstract void setScrollY(Dynamic dynamic);

    @LynxProp(defaultBoolean = false, name = "should-request-state-restore")
    public void setShouldRequestStateRestore(boolean z) {
    }

    @LynxProp(defaultInt = 0, name = "sticky-offset")
    public abstract void setStickyOffset(Dynamic dynamic);

    @LynxProp(customType = "true", name = "touch-scroll")
    public abstract void setTouchScroll(Dynamic dynamic);

    @LynxProp(customType = "none", name = "update-animation")
    public abstract void setUpdateAnimation(String str);

    @LynxProp(defaultInt = 50, name = "upper-threshold")
    public abstract void setUpperThreshold(Dynamic dynamic);

    @LynxProp(defaultInt = 0, name = "upper-threshold-item-count")
    public void setUpperThresholdItemCount(Dynamic dynamic) {
    }

    public AbsLynxList(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public AbsLynxList(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        this.mCellViewLocation = new int[2];
        this.mRootViewLocation = new int[2];
        this.mListNodeInfoFetcher = lynxContext.getListNodeInfoFetcher();
        this.mCurrentChild = null;
    }

    public final JavaOnlyMap getPlatformInfo() {
        return this.mListNodeInfoFetcher.getPlatformInfo(getSign());
    }

    public final LynxUI renderChild(int i, long j) {
        this.mListNodeInfoFetcher.renderChild(getSign(), i, j);
        LynxUI lynxUI = (LynxUI) this.mCurrentChild;
        this.mCurrentChild = null;
        return lynxUI;
    }

    public final void updateChild(LynxUI lynxUI, int i, long j) {
        this.mListNodeInfoFetcher.updateChild(getSign(), lynxUI.getSign(), i, j);
    }

    public final void removeChild(LynxUI lynxUI) {
        this.mListNodeInfoFetcher.removeChild(getSign(), lynxUI.getSign());
    }

    public final LynxUI obtainChild(int i, long j, boolean z) {
        LynxBaseUI findLynxUIBySign;
        int obtainChild = this.mListNodeInfoFetcher.obtainChild(getSign(), i, j, z);
        if (obtainChild <= 0 || (findLynxUIBySign = this.mContext.findLynxUIBySign(obtainChild)) == null || !(findLynxUIBySign instanceof UIComponent)) {
            return null;
        }
        return (UIComponent) findLynxUIBySign;
    }

    public final void obtainChildAsync(int i, long j) {
        this.mListNodeInfoFetcher.obtainChildAsync(getSign(), i, j);
    }

    public final void recycleChild(LynxUI lynxUI) {
        this.mListNodeInfoFetcher.recycleChild(getSign(), lynxUI.getSign());
    }

    public final void recycleChildAsync(LynxUI lynxUI) {
        this.mListNodeInfoFetcher.recycleChildAsync(getSign(), lynxUI.getSign());
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public final void insertChild(LynxBaseUI lynxBaseUI, int i) {
        this.mCurrentChild = lynxBaseUI;
        lynxBaseUI.setParent(this);
        this.mChildren.add(this.mChildren.size(), lynxBaseUI);
        onInsertChild(lynxBaseUI, i);
    }

    @LynxProp(customType = "false", name = "over-scroll")
    public void setOverScroll(Dynamic dynamic) {
        boolean asBoolean;
        ReadableType type = dynamic.getType();
        if (type == ReadableType.String) {
            asBoolean = "true".equals(dynamic.asString());
        } else {
            asBoolean = type == ReadableType.Boolean ? dynamic.asBoolean() : true;
        }
        if (asBoolean) {
            ((ViewGroup) this.mView).setOverScrollMode(0);
        } else {
            ((ViewGroup) this.mView).setOverScrollMode(2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public double getCellOffsetByIndex(int i) {
        for (LynxBaseUI lynxBaseUI : this.mChildren) {
            if (lynxBaseUI.getSign() == i && (lynxBaseUI instanceof LynxUI)) {
                ((UIBody.UIBodyView) getLynxContext().getUIBody().getView()).getLocationOnScreen(this.mRootViewLocation);
                ((LynxUI) lynxBaseUI).getView().getLocationOnScreen(this.mCellViewLocation);
                return this.mCellViewLocation[1] - this.mRootViewLocation[1];
            }
        }
        return 0.0d;
    }
}

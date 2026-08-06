package com.lynx.tasm.behavior.p000ui.list;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxViewClient;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.event.LynxListEvent;
import com.lynx.tasm.utils.PixelUtils;
import com.optimize.statistics.FrescoMonitorConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ListEventManager extends RecyclerView.OnScrollListener {
    private static final int BORDER_STATUS_DEFAULT = 0;
    private static final int BORDER_STATUS_LOWER = 2;
    private static final int BORDER_STATUS_READY_TO_LOWER = 8;
    private static final int BORDER_STATUS_READY_TO_UPPER = 4;
    private static final int BORDER_STATUS_UPPER = 1;
    private static final int LAYOUT_COMPONENT_ON = 16;
    private static final int LOWER_THRESHOLD_DEFAULT = 50;
    private static final int SCROLL_DIRECTION_DOWN = 1;
    private static final int SCROLL_DIRECTION_UP = -1;
    protected static final int SCROLL_EVENT_ON = 1;
    private static final int SCROLL_EVENT_THROTTLE_DEFAULT = 200;
    private static final int SCROLL_STATE_EVENT_ON = 8;
    private static final int SCROLL_TO_LOWER_EVENT_ON = 4;
    private static final int SCROLL_TO_UPPER_EVENT_ON = 2;
    private static final int UPPER_THRESHOLD_DEFAULT = 50;
    private final EventEmitter mEventEmitter;
    private final RecyclerView mRecyclerView;
    private final UIList mUIList;
    private int mEventEnableBitMask = 0;
    private int mScrollEventThrottleMs = 200;
    private int mUpperThresholdPx = 50;
    private int mLowerThresholdPx = 50;
    private int mUpperThresholdItemCount = 0;
    private int mLowerThresholdItemCount = 0;
    private long mLastScrollEventTime = 0;
    private boolean mHasBorderWhenDragging = true;
    int mScrollTop = 0;
    private int mLastBorderStatus = 1;
    boolean mNeedsVisibleCells = false;

    private boolean isLower(int i) {
        return (i & 2) != 0;
    }

    private boolean isReadyLower(int i) {
        return (i & 8) != 0;
    }

    private boolean isReadyUpper(int i) {
        return (i & 4) != 0;
    }

    private boolean isUpper(int i) {
        return (i & 1) != 0;
    }

    public ListEventManager(EventEmitter eventEmitter, RecyclerView recyclerView, UIList uIList) {
        this.mEventEmitter = eventEmitter;
        this.mRecyclerView = recyclerView;
        recyclerView.addOnScrollListener(this);
        this.mUIList = uIList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEvents(Map<String, EventsListener> map) {
        this.mEventEnableBitMask = 0;
        if (map == null) {
            return;
        }
        this.mEventEnableBitMask = map.containsKey("scroll") ? this.mEventEnableBitMask | 1 : this.mEventEnableBitMask;
        this.mEventEnableBitMask = map.containsKey("scrolltoupper") ? this.mEventEnableBitMask | 2 : this.mEventEnableBitMask;
        this.mEventEnableBitMask = map.containsKey("scrolltolower") ? this.mEventEnableBitMask | 4 : this.mEventEnableBitMask;
        this.mEventEnableBitMask = map.containsKey("scrollstatechange") ? this.mEventEnableBitMask | 8 : this.mEventEnableBitMask;
        this.mEventEnableBitMask = map.containsKey(LynxListEvent.EVENT_LAYOUT_COMPLETE) ? this.mEventEnableBitMask | 16 : this.mEventEnableBitMask;
    }

    public boolean isLayoutCompleteEnable() {
        return (this.mEventEnableBitMask & 16) != 0;
    }

    public void sendLayoutCompleteEvent(JavaOnlyArray javaOnlyArray) {
        if (isLayoutCompleteEnable()) {
            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(this.mUIList.getSign(), LynxListEvent.EVENT_LAYOUT_COMPLETE);
            lynxDetailEvent.addDetail(FrescoMonitorConst.TIMESTAMP, Long.valueOf(new Date().getTime()));
            lynxDetailEvent.addDetail("cells", javaOnlyArray);
            this.mEventEmitter.sendCustomEvent(lynxDetailEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUpperThreshold(Dynamic dynamic) {
        this.mUpperThresholdPx = dynamicToInt(dynamic, 50);
        this.mUpperThresholdItemCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLowerThreshold(Dynamic dynamic) {
        this.mLowerThresholdPx = dynamicToInt(dynamic, 50);
        this.mLowerThresholdItemCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUpperThresholdItemCount(Dynamic dynamic) {
        this.mUpperThresholdItemCount = dynamicToInt(dynamic, 0);
        this.mUpperThresholdPx = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLowerThresholdItemCount(Dynamic dynamic) {
        this.mLowerThresholdItemCount = dynamicToInt(dynamic, 0);
        this.mLowerThresholdPx = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setScrollEventThrottle(Dynamic dynamic) {
        this.mScrollEventThrottleMs = dynamicToInt(dynamic, 200);
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        int i3 = this.mUIList.isVertical() ? i2 : i;
        if (1 == this.mRecyclerView.getLayoutDirection()) {
            i3 = -i3;
        }
        int i4 = i3;
        this.mScrollTop += i4;
        if (System.currentTimeMillis() - this.mLastScrollEventTime > this.mScrollEventThrottleMs) {
            int i5 = this.mScrollTop;
            sendScrollEvent("scroll", 1, i5, i5, i, i2);
            this.mLastScrollEventTime = System.currentTimeMillis();
        }
        int updateBorderStatus = updateBorderStatus();
        boolean z = isUpper(updateBorderStatus) && !isUpper(this.mLastBorderStatus);
        boolean z2 = isReadyUpper(updateBorderStatus) && !isReadyUpper(this.mLastBorderStatus);
        boolean z3 = isLower(updateBorderStatus) && !isLower(this.mLastBorderStatus);
        boolean z4 = isReadyLower(updateBorderStatus) && !isReadyLower(this.mLastBorderStatus);
        if (i4 < 0 && (z || z2)) {
            int i6 = this.mScrollTop;
            sendScrollEvent("scrolltoupper", 2, i6, i6, 0, 0);
        } else if (i4 > 0 && (z3 || z4)) {
            int i7 = this.mScrollTop;
            sendScrollEvent("scrolltolower", 4, i7, i7, 0, 0);
        }
        this.mLastBorderStatus = updateBorderStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetScrollBorderStatus() {
        this.mLastBorderStatus = 0;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        this.mUIList.recognizeGesturere();
        if (i == 0) {
            this.mUIList.getLynxContext().getFluencyTraceHelper().stop(this.mUIList.getSign());
            sendScrollStateChangeEvent(1, "scrollstatechange");
            if (this.mUIList.isEnableScrollMonitor()) {
                this.mUIList.getLynxContext().getLynxViewClient().onScrollStop(new LynxViewClient.ScrollInfo(recyclerView, this.mUIList.getTagName(), this.mUIList.getScrollMonitorTag()));
            }
            if (this.mUIList.mEnableGapItemDecoration) {
                recyclerView.invalidateItemDecorations();
            }
            this.mUIList.notifyScrollStateChanged(0);
            return;
        }
        if (i != 1) {
            if (i != 2) {
                return;
            }
            sendScrollStateChangeEvent(3, "scrollstatechange");
            if (this.mUIList.isEnableScrollMonitor()) {
                this.mUIList.getLynxContext().getLynxViewClient().onFling(new LynxViewClient.ScrollInfo(recyclerView, this.mUIList.getTagName(), this.mUIList.getScrollMonitorTag()));
            }
            this.mUIList.notifyScrollStateChanged(2);
            return;
        }
        this.mUIList.getLynxContext().getFluencyTraceHelper().start(this.mUIList.getSign(), "scroll", this.mUIList.getScrollMonitorTag());
        this.mHasBorderWhenDragging = false;
        sendScrollStateChangeEvent(2, "scrollstatechange");
        if (this.mUIList.isEnableScrollMonitor()) {
            this.mUIList.getLynxContext().getLynxViewClient().onScrollStart(new LynxViewClient.ScrollInfo(recyclerView, this.mUIList.getTagName(), this.mUIList.getScrollMonitorTag()));
        }
        this.mUIList.notifyScrollStateChanged(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScrollBy(int i, int i2) {
        if (this.mHasBorderWhenDragging || i2 != 0) {
            return;
        }
        if (i > 0) {
            if (!this.mUIList.getUpperLowerSwitch() || (this.mLowerThresholdItemCount == 0 && this.mLowerThresholdPx == 0)) {
                int i3 = this.mScrollTop;
                sendScrollEvent("scrolltolower", 4, i3, i3, 0, 0);
                this.mHasBorderWhenDragging = true;
                return;
            }
            return;
        }
        if (i < 0) {
            this.mScrollTop = 0;
            if (!this.mUIList.getUpperLowerSwitch() || (this.mUpperThresholdItemCount == 0 && this.mUpperThresholdPx == 0)) {
                int i4 = this.mScrollTop;
                sendScrollEvent("scrolltoupper", 2, i4, i4, 0, 0);
                this.mHasBorderWhenDragging = true;
            }
        }
    }

    private int updateBorderStatus() {
        int width;
        int paddingRight;
        int i;
        int decoratedLeft;
        int decoratedRight;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int childCount = this.mRecyclerView.getChildCount();
        int itemCount = layoutManager.getItemCount();
        boolean isVertical = this.mUIList.isVertical();
        int paddingTop = isVertical ? layoutManager.getPaddingTop() : layoutManager.getPaddingLeft();
        if (isVertical) {
            width = layoutManager.getHeight();
            paddingRight = layoutManager.getPaddingBottom();
        } else {
            width = layoutManager.getWidth();
            paddingRight = layoutManager.getPaddingRight();
        }
        int i2 = width - paddingRight;
        int i3 = this.mUpperThresholdItemCount;
        if (i3 > 0 || this.mLowerThresholdItemCount > 0) {
            int i4 = (itemCount - this.mLowerThresholdItemCount) - 1;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = this.mRecyclerView.getChildAt(i7);
                int childLayoutPosition = this.mRecyclerView.getChildLayoutPosition(childAt);
                if (isVertical) {
                    decoratedLeft = layoutManager.getDecoratedTop(childAt);
                } else {
                    decoratedLeft = layoutManager.getDecoratedLeft(childAt);
                }
                int i8 = decoratedLeft;
                if (isVertical) {
                    decoratedRight = layoutManager.getDecoratedBottom(childAt);
                } else {
                    decoratedRight = layoutManager.getDecoratedRight(childAt);
                }
                if (decoratedRight > paddingTop) {
                    i5 = Math.min(childLayoutPosition, i5);
                }
                if (i8 < i2) {
                    i6 = Math.max(childLayoutPosition, i6);
                }
            }
            i = i5 < i3 ? 4 : 0;
            if (i6 > i4) {
                i |= 8;
            }
        } else {
            i = 0;
        }
        boolean z = this.mRecyclerView.findViewHolderForLayoutPosition(0) != null;
        boolean z2 = this.mRecyclerView.findViewHolderForLayoutPosition(itemCount - 1) != null;
        if (!z && !z2) {
            return i;
        }
        int i9 = Integer.MIN_VALUE;
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = this.mRecyclerView.getChildAt(i11);
            if (isVertical) {
                i10 = Math.min(layoutManager.getDecoratedTop(childAt2), i10);
            } else {
                i10 = Math.min(layoutManager.getDecoratedLeft(childAt2), i10);
            }
            if (isVertical) {
                i9 = Math.max(layoutManager.getDecoratedBottom(childAt2), i9);
            } else {
                i9 = Math.max(layoutManager.getDecoratedRight(childAt2), i9);
            }
        }
        if (z) {
            if (i10 == paddingTop) {
                this.mScrollTop = 0;
            }
            if (i10 > paddingTop - this.mUpperThresholdPx) {
                int i12 = i | 1;
                if (this.mUpperThresholdItemCount > 0) {
                    i12 &= -5;
                }
                i = i12;
            }
        }
        if (!z2 || i9 >= i2 + this.mLowerThresholdPx) {
            return i;
        }
        int i13 = i | 2;
        return this.mLowerThresholdItemCount > 0 ? i13 & (-9) : i13;
    }

    public int getScrollOffset() {
        return this.mScrollTop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendScrollEvent(String str, int i, int i2, int i3, int i4, int i5) {
        if ((i & this.mEventEnableBitMask) != 0) {
            LynxListEvent createListEvent = LynxListEvent.createListEvent(this.mUIList.getSign(), str);
            createListEvent.setScrollParams(i2, i3, i4, i5, this.mNeedsVisibleCells ? getVisibleCellsInfo() : null);
            this.mEventEmitter.sendCustomEvent(createListEvent);
        }
    }

    private void sendScrollStateChangeEvent(int i, String str) {
        if ((this.mEventEnableBitMask & 8) == 0) {
            return;
        }
        LynxListEvent createListEvent = LynxListEvent.createListEvent(this.mUIList.getSign(), str);
        createListEvent.setListScrollStateChangeParams(i, this.mNeedsVisibleCells ? getVisibleCellsInfo() : null);
        this.mEventEmitter.sendCustomEvent(createListEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JavaOnlyArray getVisibleCellsInfo() {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        ArrayList arrayList = new ArrayList();
        LinearLayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            int findLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            for (int findFirstVisibleItemPosition = r2.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                arrayList.add(Integer.valueOf(findFirstVisibleItemPosition));
            }
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] findFirstVisibleItemPositions = staggeredGridLayoutManager.findFirstVisibleItemPositions((int[]) null);
            int[] findLastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions((int[]) null);
            int i = Integer.MIN_VALUE;
            for (int i2 : findFirstVisibleItemPositions) {
                arrayList.add(Integer.valueOf(i2));
                i = Math.max(i, i2);
            }
            int i3 = Integer.MAX_VALUE;
            for (int i4 : findLastVisibleItemPositions) {
                arrayList.add(Integer.valueOf(i4));
                i3 = Math.min(i3, i4);
            }
            while (true) {
                i++;
                if (i >= i3) {
                    break;
                }
                arrayList.add(Integer.valueOf(i));
            }
            Collections.sort(arrayList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            ListViewHolder listViewHolder = (ListViewHolder) this.mRecyclerView.findViewHolderForLayoutPosition(intValue);
            if (listViewHolder != null && listViewHolder.getUIComponent() != null) {
                View view = listViewHolder.itemView;
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                javaOnlyMap.put("id", listViewHolder.getUIComponent().getIdSelector());
                javaOnlyMap.put(PropsConstants.POSITION, Integer.valueOf(intValue));
                javaOnlyMap.put("index", Integer.valueOf(intValue));
                javaOnlyMap.put("itemKey", listViewHolder.getUIComponent().getItemKey());
                javaOnlyMap.put(PropsConstants.HIT_SLOP_TOP, Float.valueOf(PixelUtils.pxToDip(view.getTop())));
                javaOnlyMap.put(PropsConstants.HIT_SLOP_BOTTOM, Float.valueOf(PixelUtils.pxToDip(view.getBottom())));
                javaOnlyMap.put(PropsConstants.HIT_SLOP_LEFT, Float.valueOf(PixelUtils.pxToDip(view.getLeft())));
                javaOnlyMap.put(PropsConstants.HIT_SLOP_RIGHT, Float.valueOf(PixelUtils.pxToDip(view.getRight())));
                javaOnlyArray.add(javaOnlyMap);
            }
        }
        return javaOnlyArray;
    }

    public static int dynamicToInt(Dynamic dynamic, int i) {
        ReadableType type = dynamic.getType();
        if (type != ReadableType.String) {
            return (type == ReadableType.Int || type == ReadableType.Number || type == ReadableType.Long) ? dynamic.asInt() : i;
        }
        try {
            return Integer.parseInt(dynamic.asString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static boolean dynamicToBoolean(Dynamic dynamic, boolean z) {
        if (dynamic == null) {
            return z;
        }
        ReadableType type = dynamic.getType();
        if (type == ReadableType.String) {
            return Boolean.parseBoolean(dynamic.asString());
        }
        if (type == ReadableType.Int || type == ReadableType.Number || type == ReadableType.Long) {
            return dynamic.asInt() != 0;
        }
        return type == ReadableType.Boolean ? dynamic.asBoolean() : z;
    }

    public static String dynamicToString(Dynamic dynamic, String str) {
        if (dynamic == null) {
            return str;
        }
        ReadableType type = dynamic.getType();
        if (type == ReadableType.String) {
            return dynamic.asString();
        }
        return (type == ReadableType.Int || type == ReadableType.Number || type == ReadableType.Long) ? String.valueOf(dynamic.asLong()) : str;
    }
}

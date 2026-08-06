package com.lynx.tasm.behavior.p000ui.list;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.event.LynxListEvent;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.ss.android.common.applog.AppLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppearEventCourierImplV2 implements AppearEventCourierInterface {
    private static final long INTERVAL_IN_MS = 200;
    private final CallBack mCallBack;
    private final EventEmitter mEventEmitter;
    private final Handler mHandler;
    private long mLastUpdateTimeStamp;
    private final HashSet<CellInfo> mLastVisibleCells = new HashSet<>();
    private final RecyclerView mRecyclerView;
    private final Rect mScreenRect;
    private final int[] mViewLocationOnScreen;
    private final Rect mViewRect;

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void holderAttached(ListViewHolder listViewHolder) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListNodeAttached(ListViewHolder listViewHolder) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListNodeDetached(ListViewHolder listViewHolder) {
    }

    public AppearEventCourierImplV2(EventEmitter eventEmitter, RecyclerView recyclerView) {
        Rect rect = new Rect();
        this.mScreenRect = rect;
        this.mViewLocationOnScreen = new int[2];
        this.mViewRect = new Rect();
        this.mLastUpdateTimeStamp = 0L;
        DisplayMetrics realScreenDisplayMetrics = DisplayMetricsHolder.getRealScreenDisplayMetrics(recyclerView.getContext());
        rect.set(0, 0, realScreenDisplayMetrics.widthPixels, realScreenDisplayMetrics.heightPixels);
        this.mEventEmitter = eventEmitter;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mCallBack = new CallBack();
        this.mRecyclerView = recyclerView;
        recyclerView.addOnScrollListener(new ListScrollListener());
        addTreeObserver();
    }

    @Override // com.lynx.tasm.behavior.p000ui.list.AppearEventCourierInterface
    public void onListLayout() {
        onListContentChange(false);
    }

    private void addTreeObserver() {
        ViewTreeObserver viewTreeObserver = this.mRecyclerView.getViewTreeObserver();
        viewTreeObserver.addOnDrawListener(new ViewTreeObserver.OnDrawListener() { // from class: com.lynx.tasm.behavior.ui.list.AppearEventCourierImplV2.1
            @Override // android.view.ViewTreeObserver.OnDrawListener
            public void onDraw() {
                AppearEventCourierImplV2.this.onListContentChange(false);
            }
        });
        viewTreeObserver.addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.lynx.tasm.behavior.ui.list.AppearEventCourierImplV2.2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                AppearEventCourierImplV2.this.onListContentChange(false);
            }
        });
    }

    private void sendNodeEvent(String str, CellInfo cellInfo) {
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "sendNodeEvent " + str + "  " + cellInfo.mPosition + " " + cellInfo.mKey);
        }
        LynxListEvent createListEvent = LynxListEvent.createListEvent(cellInfo.mSign, str);
        createListEvent.addDetail(PropsConstants.POSITION, Integer.valueOf(cellInfo.mPosition));
        createListEvent.addDetail(AppLog.KEY_ENCRYPT_RESP_KEY, cellInfo.mKey);
        this.mEventEmitter.sendCustomEvent(createListEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListContentChange(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis - this.mLastUpdateTimeStamp >= INTERVAL_IN_MS) {
            this.mLastUpdateTimeStamp = currentTimeMillis;
            this.mHandler.removeCallbacks(this.mCallBack);
            long nanoTime = System.nanoTime();
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.mRecyclerView.getChildCount(); i++) {
                View childAt = this.mRecyclerView.getChildAt(i);
                ListViewHolder listViewHolder = (ListViewHolder) this.mRecyclerView.getChildViewHolder(childAt);
                UIComponent uIComponent = listViewHolder.getUIComponent();
                if (((uIComponent == null || uIComponent.getEvents() == null) ? false : uIComponent.getEvents().containsKey(LynxListEvent.EVENT_NODE_APPEAR) | uIComponent.getEvents().containsKey(LynxListEvent.EVENT_NODE_DISAPPEAR)) && checkViewAppearedOnScreen(childAt)) {
                    CellInfo cellInfo = new CellInfo(listViewHolder.getUIComponent().getSign(), listViewHolder.getLayoutPosition(), listViewHolder.getUIComponent().getItemKey());
                    hashSet.add(cellInfo);
                    if (!this.mLastVisibleCells.contains(cellInfo)) {
                        arrayList.add(cellInfo);
                    }
                }
            }
            this.mLastVisibleCells.removeAll(hashSet);
            Iterator<CellInfo> it = this.mLastVisibleCells.iterator();
            while (it.hasNext()) {
                sendNodeEvent(LynxListEvent.EVENT_NODE_DISAPPEAR, it.next());
            }
            this.mLastVisibleCells.clear();
            this.mLastVisibleCells.addAll(hashSet);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                sendNodeEvent(LynxListEvent.EVENT_NODE_APPEAR, (CellInfo) it2.next());
            }
            if (UIList.DEBUG) {
                LLog.i(UIList.TAG, "onListContentChange time " + ((System.nanoTime() - nanoTime) / 1000) + " us");
            }
            if (z) {
                return;
            }
            this.mHandler.postDelayed(this.mCallBack, INTERVAL_IN_MS);
        }
    }

    private boolean checkViewAppearedOnScreen(View view) {
        this.mViewRect.set(0, 0, view.getWidth(), view.getHeight());
        view.getLocationOnScreen(this.mViewLocationOnScreen);
        Rect rect = this.mViewRect;
        int[] iArr = this.mViewLocationOnScreen;
        rect.offset(iArr[0], iArr[1]);
        return this.mViewRect.intersect(this.mScreenRect);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class ListScrollListener extends RecyclerView.OnScrollListener {
        private ListScrollListener() {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            AppearEventCourierImplV2.this.onListContentChange(false);
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (i == 0) {
                AppearEventCourierImplV2.this.onListContentChange(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CallBack implements Runnable {
        private CallBack() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppearEventCourierImplV2.this.onListContentChange(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class CellInfo {
        String mKey;
        int mPosition;
        int mSign;

        public CellInfo(int i, int i2, String str) {
            this.mSign = i;
            this.mPosition = i2;
            this.mKey = str;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CellInfo)) {
                return false;
            }
            CellInfo cellInfo = (CellInfo) obj;
            return cellInfo.mSign == this.mSign && cellInfo.mPosition == this.mPosition && TextUtils.equals(cellInfo.mKey, this.mKey);
        }

        public int hashCode() {
            return this.mSign << (this.mPosition + 16);
        }
    }
}

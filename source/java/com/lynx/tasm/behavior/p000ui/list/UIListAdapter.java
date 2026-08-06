package com.lynx.tasm.behavior.p000ui.list;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.list.ListLayoutManager;
import com.lynx.tasm.behavior.p000ui.list.ListViewHolder;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.utils.PixelUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    HashMap<String, Integer> itemKeyMap;
    private JavaOnlyArray mComponentEstimatedHeight;
    private JavaOnlyArray mComponentEstimatedHeightPx;
    private final AppearEventCourier mCourier;
    private JavaOnlyArray mFiberFullSpans;
    private JavaOnlyArray mFiberStickyBottomItems;
    private JavaOnlyArray mFiberStickyTopItems;
    private JavaOnlyArray mFullSpans;
    JavaOnlyArray mItemKeys;
    private final UIList mList;
    private JavaOnlyArray mStickyBottomItems;
    private JavaOnlyArray mStickyTopItems;
    JavaOnlyArray mViewNames;
    boolean mNewArch = false;
    boolean mDiffResultConsumed = false;
    boolean mComponentInitMeasure = false;
    boolean isAsync = false;
    private int mBaseOperationId = 0;
    private boolean mAppearNotificationEnable = false;
    private boolean mDisAppearNotificationEnable = false;
    private boolean mReuseNotificationEnable = false;
    boolean shouldInitCache = false;
    private final Runnable mDispatchOpRunnable = new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.UIListAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                UIListAdapter.this.mOperationDispatcher.dispatch();
            } catch (IllegalStateException e) {
                LLog.e(UIList.TAG, "operationDispatcher.dispatch() leads to the IllegalStateException : " + e.getMessage());
            }
        }
    };
    private final Runnable mNotifyDataSetChangedRunnable = new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.UIListAdapter.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                UIListAdapter.this.notifyDataSetChanged();
            } catch (IllegalStateException e) {
                LLog.e(UIList.TAG, "notifyDataSetChanged leads to the IllegalStateException : " + e.getMessage());
            }
        }
    };
    private ArrayList<HashMap<Integer, Integer>> mItemHeightInfo = new ArrayList<>();
    private HashMap<String, Integer> mAsyncItemSizeCache = new HashMap<>();
    private final HashMap<String, Integer> mTypesToInt = new HashMap<>();
    private final HashMap<Long, ListViewHolder> mLayoutMap = new HashMap<>();
    private final OperationDispatcher mOperationDispatcher = new OperationDispatcher();

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((ListViewHolder) viewHolder, i, (List<Object>) list);
    }

    public UIListAdapter(UIList uIList, AppearEventCourier appearEventCourier) {
        this.mList = uIList;
        this.mCourier = appearEventCourier;
    }

    public final boolean getNewArch() {
        return this.mNewArch;
    }

    public final JavaOnlyArray getFullSpans() {
        return this.mFullSpans;
    }

    public final JavaOnlyArray getStickyTopItems() {
        return this.mStickyTopItems;
    }

    public final JavaOnlyArray getStickyBottomItems() {
        return this.mStickyBottomItems;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initItemHeightData() {
        this.mItemHeightInfo.clear();
        for (int i = 0; i < this.mList.mColumnCount; i++) {
            this.mItemHeightInfo.add(new HashMap<>());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateChildrenInfo(JavaOnlyMap javaOnlyMap) {
        JavaOnlyArray javaOnlyArray = this.mViewNames;
        boolean z = (javaOnlyArray == null || this.mFullSpans == null || javaOnlyArray.size() != this.mFullSpans.size()) ? false : true;
        if (javaOnlyMap == null || javaOnlyMap.isEmpty()) {
            return;
        }
        JavaOnlyArray array = javaOnlyMap.getArray("itemkeys");
        if (array instanceof JavaOnlyArray) {
            this.mItemKeys = array;
        }
        this.itemKeyMap = new HashMap<>();
        for (int i = 0; i < this.mItemKeys.size(); i++) {
            this.itemKeyMap.put(this.mItemKeys.getString(i), Integer.valueOf(i));
        }
        JavaOnlyArray array2 = javaOnlyMap.getArray("fullspan");
        if (array2 instanceof JavaOnlyArray) {
            this.mFullSpans = array2;
        }
        JavaOnlyArray array3 = javaOnlyMap.getArray("viewTypes");
        if (array3 instanceof JavaOnlyArray) {
            this.mViewNames = array3;
        }
        JavaOnlyArray array4 = javaOnlyMap.getArray("stickyTop");
        if (array4 instanceof JavaOnlyArray) {
            this.mStickyTopItems = array4;
        }
        JavaOnlyArray array5 = javaOnlyMap.getArray("stickyBottom");
        if (array5 instanceof JavaOnlyArray) {
            this.mStickyBottomItems = array5;
        }
        JavaOnlyArray array6 = javaOnlyMap.getArray("estimatedHeight");
        if (array6 instanceof JavaOnlyArray) {
            this.mComponentEstimatedHeight = array6;
        }
        JavaOnlyArray array7 = javaOnlyMap.getArray("estimatedHeightPx");
        if (array7 instanceof JavaOnlyArray) {
            this.mComponentEstimatedHeightPx = array7;
        }
        boolean z2 = javaOnlyMap.getBoolean("diffable");
        this.mNewArch = javaOnlyMap.getBoolean("newarch");
        generateTypesToIntMap();
        if (!z && z2 && this.mDiffResultConsumed) {
            ReadableMap map = javaOnlyMap.getMap("diffResult");
            if (map != null && map.size() > 0) {
                this.shouldInitCache = true;
            }
            this.mOperationDispatcher.update(map);
            dispatchOperationSafely();
            return;
        }
        this.shouldInitCache = true;
        cleanAsyncItemSizeCache();
        notifyDataSetChangeSafely();
    }

    private void dispatchOperationSafely() {
        if (shouldPostWhenComputingLayout()) {
            UIThreadUtils.runOnUiThread(this.mDispatchOpRunnable);
        } else {
            this.mDispatchOpRunnable.run();
        }
    }

    private void notifyDataSetChangeSafely() {
        if (shouldPostWhenComputingLayout()) {
            UIThreadUtils.runOnUiThread(this.mNotifyDataSetChangedRunnable);
        } else {
            this.mNotifyDataSetChangedRunnable.run();
        }
    }

    private boolean shouldPostWhenComputingLayout() {
        UIList uIList;
        return this.mNewArch && (uIList = this.mList) != null && uIList.getView() != 0 && ((RecyclerView) this.mList.getView()).isComputingLayout();
    }

    private void initPlatformData() {
        if (this.mItemKeys == null) {
            this.mItemKeys = new JavaOnlyArray();
        }
        if (this.mViewNames == null) {
            this.mViewNames = new JavaOnlyArray();
        }
        if (this.mFullSpans == null) {
            this.mFullSpans = new JavaOnlyArray();
        }
        if (this.mFiberFullSpans == null) {
            this.mFiberFullSpans = new JavaOnlyArray();
        }
        if (this.mFiberStickyTopItems == null) {
            this.mFiberStickyTopItems = new JavaOnlyArray();
        }
        if (this.mStickyTopItems == null) {
            this.mStickyTopItems = new JavaOnlyArray();
        }
        if (this.mFiberStickyBottomItems == null) {
            this.mFiberStickyBottomItems = new JavaOnlyArray();
        }
        if (this.mStickyBottomItems == null) {
            this.mStickyBottomItems = new JavaOnlyArray();
        }
        if (this.mComponentEstimatedHeightPx == null) {
            this.mComponentEstimatedHeightPx = new JavaOnlyArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateListActionInfo(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        this.mNewArch = true;
        ReadableArray array = readableMap.getArray("updateAction");
        ReadableArray array2 = readableMap.getArray("insertAction");
        ReadableArray array3 = readableMap.getArray("removeAction");
        if (array == null && array2 == null && array3 == null) {
            return;
        }
        initPlatformData();
        this.mOperationDispatcher.dispatchUpdateActions(array3, array2, array);
        this.mOperationDispatcher.transformExtraData();
        if (readableMap.getBoolean("reloadAll", false)) {
            notifyDataSetChangeSafely();
        } else {
            this.mOperationDispatcher.flushNODiffActions(array3, array2, array);
        }
    }

    private void generateTypesToIntMap() {
        for (int i = 0; i < this.mViewNames.size(); i++) {
            String string = this.mViewNames.getString(i);
            if (!this.mTypesToInt.containsKey(string)) {
                HashMap<String, Integer> hashMap = this.mTypesToInt;
                hashMap.put(string, Integer.valueOf(hashMap.size()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long generateOperationId() {
        long sign = this.mList.getSign() << 32;
        int i = this.mBaseOperationId;
        this.mBaseOperationId = i + 1;
        return sign + i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getReuseNotificationEnabled() {
        return this.mReuseNotificationEnable;
    }

    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "Adapter onCreateViewHolder " + i);
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        ListViewHolder.WrapView wrapView = new ListViewHolder.WrapView(viewGroup.getContext());
        wrapView.setLayoutParams(layoutParams);
        wrapView.setComponentInitMeasure(this.mComponentInitMeasure);
        wrapView.setLayoutDirection(((RecyclerView) this.mList.getView()).getLayoutDirection());
        return new ListViewHolder(wrapView);
    }

    private void bindMeasureListener(ListViewHolder listViewHolder) {
        if (listViewHolder == null || listViewHolder.mRootView == null || listViewHolder.mRootView.getMeasureListener() != null) {
            return;
        }
        listViewHolder.mRootView.setMeasureListener(new ListViewHolder.MeasureListener() { // from class: com.lynx.tasm.behavior.ui.list.UIListAdapter.3
            @Override // com.lynx.tasm.behavior.ui.list.ListViewHolder.MeasureListener
            public void onMeasureCompleted(String str, int i, int i2) {
                if (TextUtils.isEmpty(str) || UIListAdapter.this.itemKeyMap == null || !UIListAdapter.this.itemKeyMap.containsKey(str)) {
                    return;
                }
                for (int i3 = 0; i3 < UIListAdapter.this.mItemHeightInfo.size(); i3++) {
                    int intValue = UIListAdapter.this.itemKeyMap.get(str).intValue();
                    if (UIListAdapter.this.mItemHeightInfo.get(i3) != null && ((HashMap) UIListAdapter.this.mItemHeightInfo.get(i3)).containsKey(Integer.valueOf(intValue))) {
                        ((HashMap) UIListAdapter.this.mItemHeightInfo.get(i3)).put(Integer.valueOf(intValue), Integer.valueOf(i2));
                    }
                }
            }
        });
    }

    public void onBindViewHolder(ListViewHolder listViewHolder, int i, List<Object> list) {
        bindMeasureListener(listViewHolder);
        if (this.mNewArch) {
            if (!list.isEmpty()) {
                i = ((Integer) list.get(list.size() - 1)).intValue();
            }
            bindViewHolderOnNewArch(listViewHolder, Integer.valueOf(i).intValue());
        } else {
            if (list.isEmpty()) {
                onBindViewHolder(listViewHolder, i);
                return;
            }
            if (listViewHolder.getUIComponent() == null) {
                return;
            }
            long generateOperationId = generateOperationId();
            Integer num = (Integer) list.get(list.size() - 1);
            this.mLayoutMap.put(Long.valueOf(generateOperationId), listViewHolder);
            this.mCourier.onListNodeDetached(listViewHolder);
            listViewHolder.mRootView.mLayoutStatus = 1;
            this.mList.updateChild(listViewHolder.getUIComponent(), num.intValue(), generateOperationId);
            this.mCourier.onListNodeAttached(listViewHolder);
            setComponentEstimatedSizeFromDataSource(listViewHolder, i);
        }
    }

    public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
        bindMeasureListener(listViewHolder);
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "Adapter onBindViewHolder " + i);
        }
        if (this.mNewArch) {
            bindViewHolderOnNewArch(listViewHolder, i);
            return;
        }
        long generateOperationId = generateOperationId();
        this.mLayoutMap.put(Long.valueOf(generateOperationId), listViewHolder);
        if (listViewHolder.getUIComponent() == null) {
            UIComponent uIComponent = (UIComponent) this.mList.renderChild(i, generateOperationId);
            if (uIComponent != null) {
                listViewHolder.setUIComponent(uIComponent);
                this.mCourier.holderAttached(listViewHolder);
            } else {
                LLog.i(UIList.TAG, "Adapter onBindViewHolder " + i + "child null");
            }
        } else {
            listViewHolder.mRootView.mLayoutStatus = 1;
            this.mList.updateChild(listViewHolder.getUIComponent(), i, generateOperationId);
        }
        JavaOnlyArray javaOnlyArray = this.mComponentEstimatedHeightPx;
        if (javaOnlyArray != null && javaOnlyArray.size() > i) {
            listViewHolder.setEstimatedHeight((int) PixelUtils.dipToPx(this.mComponentEstimatedHeightPx.getInt(i)));
        }
        JavaOnlyArray javaOnlyArray2 = this.mComponentEstimatedHeight;
        if (javaOnlyArray2 == null || javaOnlyArray2.size() <= i) {
            return;
        }
        listViewHolder.setEstimatedHeight(this.mComponentEstimatedHeight.getInt(i));
    }

    public void onViewAttachedToWindow(ListViewHolder listViewHolder) {
        if (listViewHolder.getUIComponent() == null && (!this.isAsync || !this.mLayoutMap.containsValue(listViewHolder))) {
            if (this.mNewArch) {
                bindViewHolderOnNewArch(listViewHolder, listViewHolder.getAdapterPosition());
            } else {
                onBindViewHolder(listViewHolder, listViewHolder.getAdapterPosition());
            }
        }
        if (!this.isAsync) {
            this.mCourier.onListNodeAttached(listViewHolder);
        }
        if (this.mNewArch && listViewHolder.getUIComponent() != null && this.mAppearNotificationEnable) {
            listViewHolder.getUIComponent().onListCellAppear(listViewHolder.getUIComponent().getItemKey(), this.mList);
        }
        int adapterPosition = listViewHolder.getAdapterPosition();
        boolean z = true;
        int itemCount = (getItemCount() - listViewHolder.getAdapterPosition()) - 1;
        if (itemCount != 0 && (itemCount >= this.mList.mColumnCount || getSectionFooterForPosition(adapterPosition) != -1)) {
            z = false;
        }
        if (!z) {
            listViewHolder.mRootView.mMainAxisGap = this.mList.getMainAxisGap();
        } else {
            listViewHolder.mRootView.mMainAxisGap = 0;
        }
        StaggeredGridLayoutManager.LayoutParams layoutParams = (RecyclerView.LayoutParams) listViewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams.setFullSpan(isFullSpan(adapterPosition));
        }
        saveItemHeightInfo(listViewHolder, adapterPosition);
    }

    public void onViewDetachedFromWindow(ListViewHolder listViewHolder) {
        this.mCourier.onListNodeDetached(listViewHolder);
        if (this.mNewArch) {
            if (listViewHolder.getUIComponent() != null && this.mDisAppearNotificationEnable) {
                JavaOnlyArray javaOnlyArray = this.mItemKeys;
                listViewHolder.getUIComponent().onListCellDisAppear(listViewHolder.getUIComponent().getItemKey(), this.mList, javaOnlyArray == null ? false : javaOnlyArray.contains(listViewHolder.getUIComponent().getItemKey()));
            }
            if (this.isAsync) {
                return;
            }
            recycleHolderComponent(listViewHolder);
        }
    }

    public int getItemCount() {
        JavaOnlyArray javaOnlyArray = this.mViewNames;
        if (javaOnlyArray != null) {
            return javaOnlyArray.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        Integer num = this.mTypesToInt.get(this.mViewNames.getString(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public long getItemId(int i) {
        if (hasStableIds()) {
            return i;
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.view.View] */
    public void onLayoutFinishAsync(UIComponent uIComponent, long j) {
        ListViewHolder listViewHolder = this.mLayoutMap.get(Long.valueOf(j));
        updateItemSizeCacheIfNeeded(uIComponent);
        if (listViewHolder == null || listViewHolder.operationID != j) {
            if (UIList.DEBUG) {
                LLog.i(UIList.TAG, "the component is not valid. itemKey:" + uIComponent.getItemKey() + " hashCode:" + uIComponent.hashCode() + " operationId:" + j);
            }
            if (this.mList.mPreloadCache != null) {
                int findFirstListItem = this.mList.findFirstListItem();
                int findLastListItem = this.mList.findLastListItem();
                HashMap<String, Integer> hashMap = this.itemKeyMap;
                if (hashMap == null || !hashMap.containsKey(uIComponent.getItemKey())) {
                    recycleHolderComponent(uIComponent);
                    return;
                }
                int intValue = this.itemKeyMap.get(uIComponent.getItemKey()).intValue();
                boolean z = findFirstListItem != -1 && intValue <= findFirstListItem;
                boolean z2 = (z || findLastListItem == -1 || intValue < findLastListItem) ? false : true;
                if (intValue < findFirstListItem - this.mList.mPreloadBufferCount || intValue > findLastListItem + this.mList.mPreloadBufferCount) {
                    return;
                }
                if (z) {
                    if (this.mList.mPreloadCache.contains(uIComponent.getItemKey())) {
                        return;
                    }
                    this.mList.mPreloadCache.addComponent(uIComponent, true);
                    return;
                } else {
                    if (!z2 || this.mList.mPreloadCache.contains(uIComponent.getItemKey())) {
                        return;
                    }
                    this.mList.mPreloadCache.addComponent(uIComponent, false);
                    return;
                }
            }
            recycleHolderComponent(uIComponent);
            return;
        }
        this.mLayoutMap.remove(Long.valueOf(j));
        if (this.mList.mPreloadCache != null) {
            if (listViewHolder.getUIComponent() == uIComponent && uIComponent.getView() != 0 && listViewHolder.itemView == ((AndroidView) uIComponent.getView()).getParent()) {
                if (UIList.DEBUG) {
                    LLog.i(UIList.TAG, "the component is the same. itemKey:" + uIComponent.getItemKey() + " hashCode:" + uIComponent.hashCode() + " operationId:" + j);
                }
                this.mCourier.onListNodeAttached(listViewHolder);
                listViewHolder.mRootView.mLayoutStatus = 2;
                listViewHolder.itemView.requestLayout();
                return;
            }
        } else if (listViewHolder.getUIComponent() == uIComponent) {
            if (UIList.DEBUG) {
                LLog.i(UIList.TAG, "the component is the same. itemKey:" + uIComponent.getItemKey() + " hashCode:" + uIComponent.hashCode() + " operationId:" + j);
            }
            this.mCourier.onListNodeAttached(listViewHolder);
            listViewHolder.mRootView.mLayoutStatus = 2;
            listViewHolder.itemView.requestLayout();
            return;
        }
        if (listViewHolder.getUIComponent() != null) {
            recycleHolderComponent(listViewHolder);
        }
        if (uIComponent != null && ((AndroidView) uIComponent.getView()).getParent() != null) {
            ((ViewGroup) ((AndroidView) uIComponent.getView()).getParent()).removeView(uIComponent.getView());
        }
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "onLayoutFinishAsync: setUIComponent:" + uIComponent.getItemKey() + RomUtils.SEPARATOR + uIComponent.hashCode() + RomUtils.SEPARATOR + j + RomUtils.SEPARATOR + listViewHolder.hashCode() + RomUtils.SEPARATOR + listViewHolder.getLayoutPosition());
        }
        listViewHolder.mRootView.mLayoutStatus = 2;
        listViewHolder.setUIComponent(uIComponent);
        this.mCourier.onListNodeAttached(listViewHolder);
        if (uIComponent != null) {
            uIComponent.setTop(0);
            uIComponent.setLeft(0);
            uIComponent.requestLayout();
            updateItemSizeCacheIfNeeded(uIComponent);
            listViewHolder.itemView.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLayoutFinish(long j) {
        ListViewHolder remove;
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "Adapter onLayoutFinish " + (65535 & j));
        }
        if (this.isAsync || (remove = this.mLayoutMap.remove(Long.valueOf(j))) == null) {
            return;
        }
        UIComponent uIComponent = remove.getUIComponent();
        if (uIComponent != null) {
            uIComponent.setTop(0);
            uIComponent.setLeft(0);
            uIComponent.requestLayout();
            boolean z = uIComponent.getWidth() != remove.itemView.getWidth();
            boolean z2 = uIComponent.getHeight() != remove.itemView.getHeight();
            if (z || z2) {
                remove.itemView.requestLayout();
            }
            if (UIList.DEBUG) {
                LLog.i(UIList.TAG, String.format("UIComponent layout finish, position %d (w %d, h %d)", Integer.valueOf(remove.getAdapterPosition()), Integer.valueOf(uIComponent.getWidth()), Integer.valueOf(uIComponent.getHeight())));
            }
            if (this.mList.mEnableSizeCache && this.mList.isPartOnLayoutThreadStrategy()) {
                updateItemSizeCacheIfNeeded(uIComponent);
            }
        }
        remove.mRootView.mLayoutStatus = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFullSpan(int i) {
        return this.mFullSpans.contains(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStickyTopItem(int i) {
        return this.mStickyTopItems.contains(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStickyBottomItem(int i) {
        return this.mStickyBottomItems.contains(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSectionHeaderForPosition(int i) {
        for (int size = this.mFullSpans.size() - 1; size >= 0; size--) {
            Integer num = (Integer) this.mFullSpans.get(size);
            if (num.intValue() <= i) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStickySectionHeaderForPosition(int i) {
        for (int size = this.mFullSpans.size() - 1; size >= 0; size--) {
            Integer num = (Integer) this.mFullSpans.get(size);
            if (num.intValue() <= i && isStickyTopItem(num.intValue())) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextStickySectionHeaderForPosition(int i) {
        if (this.mStickyTopItems == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.mStickyTopItems.size(); i2++) {
            int i3 = this.mStickyTopItems.getInt(i2);
            if (i3 >= i) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSectionFooterForPosition(int i) {
        for (int i2 = 0; i2 < this.mFullSpans.size(); i2++) {
            Integer num = (Integer) this.mFullSpans.get(i2);
            if (num.intValue() >= i) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStickySectionFooterForPosition(int i) {
        for (int i2 = 0; i2 < this.mFullSpans.size(); i2++) {
            Integer num = (Integer) this.mFullSpans.get(i2);
            if (num.intValue() >= i && isStickyBottomItem(num.intValue())) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public final class OperationDispatcher {
        private ReadableArray mInsertions;
        private ReadableArray mMoveFrom;
        private ReadableArray mMoveTo;
        private ReadableArray mRemovals;
        private ReadableArray mUpdateFrom;
        private ReadableArray mUpdateTo;

        private OperationDispatcher() {
        }

        void update(ReadableMap readableMap) {
            this.mInsertions = readableMap.getArray("insertions");
            this.mRemovals = readableMap.getArray("removals");
            this.mUpdateFrom = readableMap.getArray("updateFrom");
            this.mUpdateTo = readableMap.getArray("updateTo");
            this.mMoveFrom = readableMap.getArray("moveFrom");
            this.mMoveTo = readableMap.getArray("moveTo");
            if (isNotEmpty(this.mInsertions) || isNotEmpty(this.mRemovals) || isNotEmpty(this.mUpdateFrom) || isNotEmpty(this.mUpdateTo) || isNotEmpty(this.mMoveFrom) || isNotEmpty(this.mMoveTo)) {
                UIListAdapter.this.mDiffResultConsumed = false;
            }
        }

        private boolean isNotEmpty(ReadableArray readableArray) {
            return readableArray != null && readableArray.size() > 0;
        }

        void dispatch() {
            if (this.mUpdateFrom != null) {
                for (int i = 0; i < this.mUpdateFrom.size(); i++) {
                    UIListAdapter.this.notifyItemChanged(this.mUpdateFrom.getInt(i), Integer.valueOf(this.mUpdateTo.getInt(i)));
                }
            }
            if (this.mMoveFrom != null) {
                for (int i2 = 0; i2 < this.mMoveFrom.size(); i2++) {
                    UIListAdapter.this.notifyItemMoved(this.mMoveFrom.getInt(i2), this.mMoveTo.getInt(i2));
                }
            }
            ReadableArray readableArray = this.mRemovals;
            if (readableArray != null) {
                for (int size = readableArray.size() - 1; size >= 0; size--) {
                    UIListAdapter.this.notifyItemRemoved(this.mRemovals.getInt(size));
                }
            }
            if (this.mInsertions != null) {
                for (int i3 = 0; i3 < this.mInsertions.size(); i3++) {
                    UIListAdapter.this.notifyItemInserted(this.mInsertions.getInt(i3));
                }
            }
        }

        void dispatchUpdateActions(ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3) {
            if (readableArray != null) {
                for (int size = readableArray.size() - 1; size >= 0; size--) {
                    int i = readableArray.getInt(size);
                    if (i >= 0) {
                        UIListAdapter.this.mItemKeys.remove(i);
                        UIListAdapter.this.mViewNames.remove(i);
                        UIListAdapter.this.mComponentEstimatedHeightPx.remove(i);
                        UIListAdapter.this.mFiberFullSpans.remove(i);
                        UIListAdapter.this.mFiberStickyTopItems.remove(i);
                        UIListAdapter.this.mFiberStickyBottomItems.remove(i);
                    }
                }
            }
            int i2 = -1;
            boolean z = false;
            if (readableArray2 != null) {
                int i3 = 0;
                while (i3 < readableArray2.size()) {
                    ReadableMap map = readableArray2.getMap(i3);
                    if (map != null) {
                        int i4 = map.getInt(PropsConstants.POSITION);
                        String string = map.getString(PropsConstants.ITEM_KEY);
                        String string2 = map.getString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
                        boolean z2 = map.getBoolean("full-span", false);
                        boolean z3 = map.getBoolean("sticky-top", false);
                        boolean z4 = map.getBoolean("sticky-bottom", false);
                        int i5 = map.getInt("estimated-height-px", i2);
                        UIListAdapter.this.mItemKeys.add(i4, string);
                        UIListAdapter.this.mViewNames.add(i4, string2);
                        if (!UIListAdapter.this.mTypesToInt.containsKey(string2)) {
                            UIListAdapter.this.mTypesToInt.put(string2, Integer.valueOf(UIListAdapter.this.mTypesToInt.size()));
                        }
                        UIListAdapter.this.mFiberFullSpans.add(i4, Boolean.valueOf(z2));
                        UIListAdapter.this.mFiberStickyTopItems.add(i4, Boolean.valueOf(z3));
                        UIListAdapter.this.mFiberStickyBottomItems.add(i4, Boolean.valueOf(z4));
                        UIListAdapter.this.mComponentEstimatedHeightPx.add(i4, Integer.valueOf(i5));
                    }
                    i3++;
                    i2 = -1;
                }
            }
            if (readableArray3 != null) {
                int i6 = 0;
                while (i6 < readableArray3.size()) {
                    ReadableMap map2 = readableArray3.getMap(i6);
                    if (map2 != null) {
                        int i7 = map2.getInt(FrescoMonitorConst.URI_QUERY_PARAM_FROM);
                        map2.getInt("to");
                        String string3 = map2.getString(PropsConstants.ITEM_KEY);
                        String string4 = map2.getString(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
                        boolean z5 = map2.getBoolean("full-span", z);
                        boolean z6 = map2.getBoolean("sticky-top", z);
                        boolean z7 = map2.getBoolean("sticky-bottom", z);
                        int i8 = map2.getInt("estimated-height-px", -1);
                        UIListAdapter.this.mItemKeys.set(i7, string3);
                        UIListAdapter.this.mViewNames.set(i7, string4);
                        if (!UIListAdapter.this.mTypesToInt.containsKey(string4)) {
                            UIListAdapter.this.mTypesToInt.put(string4, Integer.valueOf(UIListAdapter.this.mTypesToInt.size()));
                        }
                        UIListAdapter.this.mFiberFullSpans.set(i7, Boolean.valueOf(z5));
                        UIListAdapter.this.mFiberStickyTopItems.set(i7, Boolean.valueOf(z6));
                        UIListAdapter.this.mFiberStickyBottomItems.set(i7, Boolean.valueOf(z7));
                        UIListAdapter.this.mComponentEstimatedHeightPx.set(i7, Integer.valueOf(i8));
                    }
                    i6++;
                    z = false;
                }
            }
        }

        void transformExtraData() {
            transformFullSpans();
            transformStickTopItems();
            transformStickBottomItems();
        }

        private void transformFullSpans() {
            UIListAdapter.this.mFullSpans.clear();
            for (int i = 0; i < UIListAdapter.this.mFiberFullSpans.size(); i++) {
                if (UIListAdapter.this.mFiberFullSpans.getBoolean(i)) {
                    UIListAdapter.this.mFullSpans.add(Integer.valueOf(i));
                }
            }
        }

        private void transformStickTopItems() {
            UIListAdapter.this.mStickyTopItems.clear();
            for (int i = 0; i < UIListAdapter.this.mFiberStickyTopItems.size(); i++) {
                if (UIListAdapter.this.mFiberStickyTopItems.getBoolean(i)) {
                    UIListAdapter.this.mStickyTopItems.add(Integer.valueOf(i));
                }
            }
        }

        private void transformStickBottomItems() {
            UIListAdapter.this.mStickyBottomItems.clear();
            for (int i = 0; i < UIListAdapter.this.mFiberStickyBottomItems.size(); i++) {
                if (UIListAdapter.this.mFiberStickyBottomItems.getBoolean(i)) {
                    UIListAdapter.this.mStickyBottomItems.add(Integer.valueOf(i));
                }
            }
        }

        void flushNODiffActions(ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3) {
            if (readableArray != null) {
                for (int size = readableArray.size() - 1; size >= 0; size--) {
                    int i = readableArray.getInt(size);
                    if (i >= 0) {
                        UIListAdapter.this.notifyItemRemoved(i);
                    }
                }
            }
            if (readableArray2 != null) {
                for (int i2 = 0; i2 < readableArray2.size(); i2++) {
                    ReadableMap map = readableArray2.getMap(i2);
                    if (map != null) {
                        UIListAdapter.this.notifyItemInserted(map.getInt(PropsConstants.POSITION));
                    }
                }
            }
            if (readableArray3 != null) {
                for (int i3 = 0; i3 < readableArray3.size(); i3++) {
                    ReadableMap map2 = readableArray3.getMap(i3);
                    if (map2 != null) {
                        int i4 = map2.getInt(FrescoMonitorConst.URI_QUERY_PARAM_FROM);
                        int i5 = map2.getInt("to");
                        if (map2.getBoolean("flush", false)) {
                            UIListAdapter.this.notifyItemChanged(i4, Integer.valueOf(i5));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v37, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.view.View] */
    public void bindViewHolderOnNewArch(ListViewHolder listViewHolder, int i) {
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "bindViewHolderOnNewArch position=" + i + ", itemKey=" + this.mItemKeys.get(i) + ", viewHolder=" + listViewHolder.hashCode());
        }
        UIComponent removeComponent = this.mList.mPreloadCache != null ? this.mList.mPreloadCache.removeComponent(this.mItemKeys.getString(i)) : null;
        if (removeComponent == null) {
            long generateOperationId = generateOperationId();
            if (UIList.DEBUG) {
                LLog.i(UIList.TAG, "bindViewHolderOnNewArch  pos:" + i + " itemKey: " + this.mItemKeys.get(i) + " id:" + generateOperationId);
            }
            this.mLayoutMap.put(Long.valueOf(generateOperationId), listViewHolder);
            if (this.isAsync) {
                if (this.mList.mItemHolderType == UIList.ITEM_HOLDER_TYPE_CLEAR || (this.mList.mItemHolderType == UIList.ITEM_HOLDER_TYPE_DEFAULT && listViewHolder.getUIComponent() != null && !TextUtils.isEmpty(listViewHolder.getUIComponent().getItemKey()) && !listViewHolder.getUIComponent().getItemKey().equals(this.mItemKeys.getString(i)))) {
                    listViewHolder.removeUIComponent();
                }
                listViewHolder.operationID = generateOperationId;
                this.mList.obtainChildAsync(i, generateOperationId);
                StaggeredGridLayoutManager.LayoutParams layoutParams = listViewHolder.itemView.getLayoutParams();
                if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                    layoutParams.setFullSpan(isFullSpan(i));
                }
                String str = (String) this.mItemKeys.get(i);
                listViewHolder.mRootView.mLayoutStatus = 0;
                if (this.mList.mEnableSizeCache && this.mAsyncItemSizeCache.containsKey(str)) {
                    setEstimatedSizeInternal(listViewHolder, this.mAsyncItemSizeCache.get(str).intValue());
                    return;
                } else {
                    setComponentEstimatedSizeFromDataSource(listViewHolder, i);
                    return;
                }
            }
            removeComponent = (UIComponent) this.mList.obtainChild(i, generateOperationId, this.mReuseNotificationEnable);
            if (removeComponent == null) {
                this.mLayoutMap.remove(Long.valueOf(generateOperationId));
                return;
            }
            if (!this.mList.mIgnoreAttachForBinding && ViewCompat.isAttachedToWindow((View) removeComponent.getView())) {
                this.mLayoutMap.remove(Long.valueOf(generateOperationId));
                return;
            } else if (removeComponent != listViewHolder.getUIComponent()) {
                if (((AndroidView) removeComponent.getView()).getParent() != null) {
                    ((ViewGroup) ((AndroidView) removeComponent.getView()).getParent()).removeView(removeComponent.getView());
                }
                recycleHolderComponent(listViewHolder);
                listViewHolder.setUIComponent(removeComponent);
                this.mCourier.holderAttached(listViewHolder);
            }
        } else {
            if (UIList.DEBUG) {
                LLog.i(UIList.TAG, " the child is cached. bindViewHolder " + i + " itemKey:" + removeComponent.getItemKey());
            }
            listViewHolder.mRootView.mLayoutStatus = 2;
            if (removeComponent != listViewHolder.getUIComponent()) {
                if (removeComponent.getView() != 0 && ((AndroidView) removeComponent.getView()).getParent() != null) {
                    ((ViewGroup) ((AndroidView) removeComponent.getView()).getParent()).removeView(removeComponent.getView());
                }
                recycleHolderComponent(listViewHolder);
                listViewHolder.mRootView.mLayoutStatus = 2;
                listViewHolder.setUIComponent(removeComponent);
                removeComponent.requestLayout();
                listViewHolder.itemView.forceLayout();
                this.mCourier.holderAttached(listViewHolder);
            } else {
                listViewHolder.itemView.requestLayout();
            }
            if (this.mList.mPreloadCache != null) {
                this.mList.mPreloadCache.preloadNextComponent(listViewHolder);
            }
        }
        if (this.mList.mEnableSizeCache && this.mList.isPartOnLayoutThreadStrategy()) {
            removeComponent.setOnUpdateListener(new UIComponent.OnUpdateListener() { // from class: com.lynx.tasm.behavior.ui.list.UIListAdapter.4
                @Override // com.lynx.tasm.behavior.ui.view.UIComponent.OnUpdateListener
                public void onLayoutUpdated(UIComponent uIComponent) {
                    if (uIComponent == null || uIComponent.getItemKey() == null) {
                        return;
                    }
                    UIListAdapter.this.updateItemSizeCacheIfNeeded(uIComponent);
                }
            });
        }
        bindViewHolderOnNewArchWithExtraInfo(listViewHolder, i);
    }

    private void bindViewHolderOnNewArchWithExtraInfo(ListViewHolder listViewHolder, int i) {
        UIComponent uIComponent;
        StaggeredGridLayoutManager.LayoutParams layoutParams = listViewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams.setFullSpan(isFullSpan(i));
        }
        if (this.mList.mEnableSizeCache && this.mList.isPartOnLayoutThreadStrategy() && (uIComponent = listViewHolder.getUIComponent()) != null && this.mAsyncItemSizeCache.containsKey(uIComponent.getItemKey())) {
            int intValue = this.mAsyncItemSizeCache.get(uIComponent.getItemKey()).intValue();
            if (this.mList.isVertical() && intValue != uIComponent.getHeight()) {
                uIComponent.setHeight(intValue);
            } else if (!this.mList.isVertical() && intValue != uIComponent.getWidth()) {
                uIComponent.setWidth(intValue);
            }
        }
        setComponentEstimatedSizeFromDataSource(listViewHolder, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycleHolderComponent(ListViewHolder listViewHolder) {
        UIComponent uIComponent = listViewHolder.getUIComponent();
        if (uIComponent != null) {
            listViewHolder.removeUIComponent();
            if (this.mList.mPreloadCache != null && (isComponentUsedByViewHolder(uIComponent) || isComponentUsedByBuffer(uIComponent))) {
                LLog.i(UIList.TAG, "when recycling the child asynchronously,if the view of the component is used, you cannot recycle the component. the itemKey is :" + uIComponent.getItemKey() + " position:" + listViewHolder.getAdapterPosition());
            } else if (this.isAsync) {
                this.mList.recycleChildAsync(uIComponent);
                listViewHolder.mRootView.mLayoutStatus = 0;
            } else {
                this.mList.recycleChild(uIComponent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycleHolderComponent(UIComponent uIComponent) {
        if (uIComponent != null) {
            if (this.mList.mPreloadCache != null && (isComponentUsedByViewHolder(uIComponent) || isComponentUsedByBuffer(uIComponent))) {
                LLog.i(UIList.TAG, "recycleHolderComponent the component is used. itemKey :" + uIComponent.getItemKey());
            } else if (this.isAsync) {
                this.mList.recycleChildAsync(uIComponent);
            } else {
                this.mList.recycleChild(uIComponent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalCellAppearNotification(boolean z) {
        this.mAppearNotificationEnable = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalCellDisappearNotification(boolean z) {
        this.mDisAppearNotificationEnable = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalCellPrepareForReuseNotification(boolean z) {
        this.mReuseNotificationEnable = z;
    }

    private void saveItemHeightInfo(ListViewHolder listViewHolder, int i) {
        if (this.mItemHeightInfo.isEmpty()) {
            return;
        }
        int i2 = 0;
        int height = listViewHolder.getUIComponent() == null ? 0 : listViewHolder.getUIComponent().getHeight();
        if (((RecyclerView) this.mList.getView()).getLayoutManager() instanceof ListLayoutManager.ListLinearLayoutManager) {
            this.mItemHeightInfo.get(0).put(Integer.valueOf(i), Integer.valueOf(height));
            return;
        }
        if (((RecyclerView) this.mList.getView()).getLayoutManager() instanceof ListLayoutManager.ListStaggeredGridLayoutManager) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = listViewHolder.itemView.getLayoutParams();
            if (isFullSpan(i)) {
                while (i2 < this.mItemHeightInfo.size()) {
                    this.mItemHeightInfo.get(i2).put(Integer.valueOf(i), Integer.valueOf(height));
                    i2++;
                }
                return;
            } else {
                while (i2 < this.mItemHeightInfo.size()) {
                    if (layoutParams.getSpanIndex() == i2) {
                        this.mItemHeightInfo.get(i2).put(Integer.valueOf(i), Integer.valueOf(height));
                    } else {
                        this.mItemHeightInfo.get(i2).remove(Integer.valueOf(i));
                    }
                    i2++;
                }
                return;
            }
        }
        if (((RecyclerView) this.mList.getView()).getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = ((RecyclerView) this.mList.getView()).getLayoutManager();
            int spanIndex = layoutManager.getSpanSizeLookup().getSpanIndex(i, layoutManager.getSpanCount());
            if (isFullSpan(i)) {
                while (i2 < this.mItemHeightInfo.size()) {
                    this.mItemHeightInfo.get(i2).put(Integer.valueOf(i), Integer.valueOf(height));
                    i2++;
                }
            } else {
                while (i2 < this.mItemHeightInfo.size()) {
                    if (spanIndex == i2) {
                        this.mItemHeightInfo.get(i2).put(Integer.valueOf(i), Integer.valueOf(height));
                    } else {
                        this.mItemHeightInfo.get(i2).remove(Integer.valueOf(i));
                    }
                    i2++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getScrollY() {
        ListViewHolder listViewHolder;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) this.mList.getView()).getLayoutManager();
        if (this.mItemHeightInfo.isEmpty()) {
            return 0;
        }
        if (layoutManager instanceof ListLayoutManager.ListLinearLayoutManager) {
            ListLayoutManager.ListLinearLayoutManager listLinearLayoutManager = (ListLayoutManager.ListLinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = listLinearLayoutManager.findFirstVisibleItemPosition();
            View findViewByPosition = listLinearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            int i = findViewByPosition != null ? -((int) findViewByPosition.getY()) : 0;
            HashMap<Integer, Integer> hashMap = this.mItemHeightInfo.get(0);
            for (int i2 = 0; i2 < findFirstVisibleItemPosition; i2++) {
                i += hashMap.get(Integer.valueOf(i2)) == null ? 0 : hashMap.get(Integer.valueOf(i2)).intValue();
            }
            return i;
        }
        if (layoutManager instanceof ListLayoutManager.ListGridLayoutManager) {
            try {
                ListLayoutManager.ListGridLayoutManager listGridLayoutManager = (ListLayoutManager.ListGridLayoutManager) layoutManager;
                int i3 = 0;
                for (int i4 = 0; i4 < this.mItemHeightInfo.size(); i4++) {
                    View childAt = listGridLayoutManager.getChildAt(i4);
                    if (childAt != null) {
                        int position = listGridLayoutManager.getPosition(childAt);
                        int i5 = -((int) childAt.getY());
                        HashMap<Integer, Integer> hashMap2 = this.mItemHeightInfo.get(i4);
                        for (int i6 = 0; i6 < position; i6++) {
                            i5 += hashMap2.get(Integer.valueOf(i6)) == null ? 0 : hashMap2.get(Integer.valueOf(i6)).intValue();
                        }
                        i3 = Math.max(i3, i5);
                    }
                }
                return i3;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        int i7 = this.mList.mColumnCount;
        int[] iArr = new int[i7];
        View[] viewArr = new View[this.mList.mColumnCount];
        ((ListLayoutManager.ListStaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(iArr);
        for (int i8 = 0; i8 < i7; i8++) {
            int i9 = 0;
            while (true) {
                if (i9 >= ((RecyclerView) this.mList.getView()).getChildCount()) {
                    break;
                }
                View childAt2 = ((RecyclerView) this.mList.getView()).getChildAt(i9);
                if (childAt2 != null && (listViewHolder = (ListViewHolder) ((RecyclerView) this.mList.getView()).getChildViewHolder(childAt2)) != null && iArr[i8] == listViewHolder.getAdapterPosition()) {
                    viewArr[i8] = childAt2;
                    break;
                }
                i9++;
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < i7 && i11 < this.mItemHeightInfo.size(); i11++) {
            View view = viewArr[i11];
            if (view != null) {
                int i12 = -((int) view.getY());
                HashMap<Integer, Integer> hashMap3 = this.mItemHeightInfo.get(i11);
                for (int i13 = 0; i13 < iArr[i11]; i13++) {
                    i12 += hashMap3.get(Integer.valueOf(i13)) == null ? 0 : hashMap3.get(Integer.valueOf(i13)).intValue();
                }
                i10 = Math.max(i10, i12);
            }
        }
        return i10;
    }

    private void setComponentEstimatedSizeFromDataSource(ListViewHolder listViewHolder, int i) {
        JavaOnlyArray javaOnlyArray = this.mComponentEstimatedHeightPx;
        if (javaOnlyArray != null && javaOnlyArray.size() > i) {
            setEstimatedSizeInternal(listViewHolder, (int) PixelUtils.dipToPx(this.mComponentEstimatedHeightPx.getInt(i)));
        }
        JavaOnlyArray javaOnlyArray2 = this.mComponentEstimatedHeight;
        if (javaOnlyArray2 == null || javaOnlyArray2.size() <= i) {
            return;
        }
        setEstimatedSizeInternal(listViewHolder, this.mComponentEstimatedHeight.getInt(i));
    }

    boolean isComponentUsedByViewHolder(UIComponent uIComponent) {
        RecyclerView recyclerView;
        UIComponent uIComponent2;
        UIList uIList = this.mList;
        if (uIList != null && (recyclerView = uIList.getRecyclerView()) != null) {
            for (int i = 0; i < recyclerView.getChildCount(); i++) {
                View childAt = recyclerView.getChildAt(i);
                if ((childAt instanceof ListViewHolder.WrapView) && (uIComponent2 = ((ListViewHolder.WrapView) childAt).getUIComponent()) != null && uIComponent2.getItemKey() != null && uIComponent2.getItemKey().equals(uIComponent.getItemKey())) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isComponentUsedByBuffer(UIComponent uIComponent) {
        return this.mList.mPreloadCache != null && this.mList.mPreloadCache.contains(uIComponent.getItemKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateItemSizeCacheIfNeeded(UIComponent uIComponent) {
        if (!this.mList.mEnableSizeCache || uIComponent == null) {
            return;
        }
        String itemKey = uIComponent.getItemKey();
        if (TextUtils.isEmpty(itemKey)) {
            return;
        }
        int height = this.mList.isVertical() ? uIComponent.getHeight() : uIComponent.getWidth();
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "updateItemSizeCacheIfNeeded: itemKey = " + itemKey + ", itemSize = " + height);
        }
        this.mAsyncItemSizeCache.put(uIComponent.getItemKey(), Integer.valueOf(height));
    }

    private void setEstimatedSizeInternal(ListViewHolder listViewHolder, int i) {
        if (listViewHolder == null) {
            return;
        }
        if (this.mList.isVertical()) {
            listViewHolder.setEstimatedHeight(i);
        } else {
            listViewHolder.setEstimatedWidth(i);
        }
    }

    private void cleanAsyncItemSizeCache() {
        this.mAsyncItemSizeCache.clear();
    }
}

package com.lynx.tasm.behavior.p000ui.list;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.p000ui.list.ListViewHolder;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ListPreloadCache {
    private int mCacheCount;
    private UIList mUIList;
    public ArrayList<UIComponent> upperCache = new ArrayList<>();
    public ArrayList<UIComponent> lowerCache = new ArrayList<>();
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.lynx.tasm.behavior.ui.list.ListPreloadCache.1
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (recyclerView == null || ListPreloadCache.this.mUIList == null || ListPreloadCache.this.mUIList.getAdapter() == null || i != 0) {
                return;
            }
            for (int i2 = 0; i2 < recyclerView.getChildCount(); i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt instanceof ListViewHolder.WrapView) {
                    ListViewHolder.WrapView wrapView = (ListViewHolder.WrapView) childAt;
                    if (wrapView.getUIComponent() == null) {
                        LLog.i(UIList.TAG, "the scroll state of recyclerView is idle, the component is null. position is :" + wrapView.mAdapterPosition);
                        ListPreloadCache.this.mUIList.getAdapter().notifyItemChanged(wrapView.mAdapterPosition);
                    }
                }
            }
        }
    };

    boolean isValidRange(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    public ListPreloadCache(UIList uIList, int i) {
        this.mCacheCount = 0;
        this.mUIList = uIList;
        this.mCacheCount = i;
        initScrollListener();
    }

    private void initScrollListener() {
        UIList uIList = this.mUIList;
        if (uIList == null || uIList.getView() == 0) {
            return;
        }
        ((RecyclerView) this.mUIList.getView()).addOnScrollListener(this.onScrollListener);
    }

    public void setCacheCount(int i) {
        this.mCacheCount = i;
    }

    public void addComponent(UIComponent uIComponent, boolean z) {
        UIComponent remove;
        UIComponent remove2;
        if (this.mCacheCount <= 0 || uIComponent == null) {
            return;
        }
        if (z) {
            if (this.upperCache.size() > this.mCacheCount && (remove2 = this.upperCache.remove(0)) != null) {
                this.mUIList.getAdapter().recycleHolderComponent(remove2);
            }
            this.upperCache.add(uIComponent);
            return;
        }
        if (this.lowerCache.size() > this.mCacheCount && (remove = this.lowerCache.remove(0)) != null) {
            this.mUIList.getAdapter().recycleHolderComponent(remove);
        }
        this.lowerCache.add(uIComponent);
    }

    public UIComponent removeComponent(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.upperCache.size(); i++) {
            UIComponent uIComponent = this.upperCache.get(i);
            if (uIComponent != null && str.equals(uIComponent.getItemKey())) {
                this.upperCache.remove(uIComponent);
                return uIComponent;
            }
        }
        for (int i2 = 0; i2 < this.lowerCache.size(); i2++) {
            UIComponent uIComponent2 = this.lowerCache.get(i2);
            if (uIComponent2 != null && str.equals(uIComponent2.getItemKey())) {
                this.lowerCache.remove(uIComponent2);
                return uIComponent2;
            }
        }
        return null;
    }

    public boolean contains(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.upperCache.size(); i++) {
            UIComponent uIComponent = this.upperCache.get(i);
            if (uIComponent != null && str.equals(uIComponent.getItemKey())) {
                return true;
            }
        }
        for (int i2 = 0; i2 < this.lowerCache.size(); i2++) {
            UIComponent uIComponent2 = this.lowerCache.get(i2);
            if (uIComponent2 != null && str.equals(uIComponent2.getItemKey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void preloadNextComponent(ListViewHolder listViewHolder) {
        UIList uIList = this.mUIList;
        if (uIList == null || uIList.getAdapter() == null || this.mUIList.getAdapter().mItemKeys == null || listViewHolder == null) {
            return;
        }
        UIListAdapter adapter = this.mUIList.getAdapter();
        int findFirstListItem = this.mUIList.findFirstListItem();
        int findLastListItem = this.mUIList.findLastListItem();
        if (listViewHolder.getUIComponent() != null) {
            if (findFirstListItem != -1 && listViewHolder.getAdapterPosition() < findFirstListItem) {
                if (!isValidIndex(findFirstListItem - this.mCacheCount) || adapter.mItemKeys == null || contains(adapter.mItemKeys.getString(findFirstListItem - this.mCacheCount))) {
                    return;
                }
                preloadComponent(findFirstListItem - this.mCacheCount);
                return;
            }
            if (findLastListItem == -1 || listViewHolder.getAdapterPosition() < findLastListItem || !isValidIndex(this.mCacheCount + findLastListItem)) {
                return;
            }
            if ((adapter.mItemKeys != null) && (!contains(adapter.mItemKeys.getString(this.mCacheCount + findLastListItem)))) {
                preloadComponent(findLastListItem + this.mCacheCount);
            }
        }
    }

    void preloadComponent(int i) {
        UIList uIList = this.mUIList;
        if (uIList == null || uIList.getAdapter() == null || !isValidIndex(i)) {
            return;
        }
        this.mUIList.obtainChildAsync(i, this.mUIList.getAdapter().generateOperationId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueueComponentFromRecyclerPool(ListViewHolder listViewHolder) {
        UIList uIList = this.mUIList;
        if (uIList == null || uIList.getAdapter() == null || this.mUIList.getAdapter().itemKeyMap == null || listViewHolder == null) {
            return;
        }
        UIListAdapter adapter = this.mUIList.getAdapter();
        if (adapter.itemKeyMap != null && this.mCacheCount > 0) {
            int findFirstListItem = this.mUIList.findFirstListItem();
            int findLastListItem = this.mUIList.findLastListItem();
            if (listViewHolder.getUIComponent() != null) {
                if (adapter.itemKeyMap.containsKey(listViewHolder.getUIComponent().getItemKey())) {
                    int intValue = adapter.itemKeyMap.get(listViewHolder.getUIComponent().getItemKey()).intValue();
                    int i = this.mCacheCount;
                    if (isValidRange(intValue, findFirstListItem - i, i + findLastListItem)) {
                        if (findFirstListItem != -1 && listViewHolder.getLayoutPosition() <= findFirstListItem) {
                            if (contains(listViewHolder.getUIComponent().getItemKey())) {
                                return;
                            }
                            addComponent(listViewHolder.getUIComponent(), true);
                            return;
                        } else {
                            if (findLastListItem == -1 || listViewHolder.getLayoutPosition() < findLastListItem || contains(listViewHolder.getUIComponent().getItemKey())) {
                                return;
                            }
                            addComponent(listViewHolder.getUIComponent(), false);
                            return;
                        }
                    }
                }
                this.mUIList.getAdapter().recycleHolderComponent(listViewHolder.getUIComponent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initCache() {
        int i;
        int i2;
        UIList uIList = this.mUIList;
        if (uIList == null || uIList.getAdapter() == null) {
            return;
        }
        JavaOnlyArray javaOnlyArray = this.mUIList.getAdapter().mItemKeys;
        HashMap<String, Integer> hashMap = this.mUIList.getAdapter().itemKeyMap;
        if (javaOnlyArray == null || hashMap == null) {
            return;
        }
        int findFirstListItem = this.mUIList.findFirstListItem();
        int findLastListItem = this.mUIList.findLastListItem();
        this.lowerCache.clear();
        this.upperCache.clear();
        for (int i3 = 1; i3 <= this.mCacheCount; i3++) {
            if (findFirstListItem != -1 && (i2 = findFirstListItem - i3) >= 0 && i2 < javaOnlyArray.size() && !contains(javaOnlyArray.getString(i2))) {
                long generateOperationId = this.mUIList.getAdapter().generateOperationId();
                if (isValidIndex(i2)) {
                    this.mUIList.obtainChildAsync(i2, generateOperationId);
                }
            }
            if (findLastListItem != -1 && (i = findLastListItem + i3) < javaOnlyArray.size() && i >= 0 && !contains(javaOnlyArray.getString(i))) {
                long generateOperationId2 = this.mUIList.getAdapter().generateOperationId();
                if (isValidIndex(i)) {
                    this.mUIList.obtainChildAsync(i, generateOperationId2);
                }
            }
        }
    }

    boolean isValidIndex(int i) {
        UIList uIList = this.mUIList;
        return (uIList == null || uIList.getAdapter() == null || this.mUIList.getAdapter().mItemKeys == null || !isValidRange(i, 0, this.mUIList.getAdapter().mItemKeys.size() - 1)) ? false : true;
    }

    public void clear() {
        this.upperCache.clear();
        this.lowerCache.clear();
    }

    public void destroy() {
        clear();
        UIList uIList = this.mUIList;
        if (uIList == null || uIList.getView() == 0) {
            return;
        }
        ((RecyclerView) this.mUIList.getView()).removeOnScrollListener(this.onScrollListener);
    }
}

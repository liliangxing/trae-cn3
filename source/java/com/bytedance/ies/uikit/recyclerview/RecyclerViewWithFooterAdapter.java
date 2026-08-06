package com.bytedance.ies.uikit.recyclerview;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class RecyclerViewWithFooterAdapter extends RecyclerView.Adapter {
    private static final int TYPE_FOOTER = Integer.MIN_VALUE;
    protected boolean mShowFooter = true;

    public abstract int getBasicItemCount();

    public int getBasicItemViewType(int i) {
        return 0;
    }

    public abstract void onBindBasicViewHolder(RecyclerView.ViewHolder viewHolder, int i);

    public abstract void onBindFooterViewHolder(RecyclerView.ViewHolder viewHolder);

    public abstract RecyclerView.ViewHolder onCreateBasicViewHolder(ViewGroup viewGroup, int i);

    public abstract RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup viewGroup);

    public void setShowFooter(boolean z) {
        this.mShowFooter = z;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (Integer.MIN_VALUE == i) {
            return onCreateFooterViewHolder(viewGroup);
        }
        return onCreateBasicViewHolder(viewGroup, i);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == Integer.MIN_VALUE) {
            onBindFooterViewHolder(viewHolder);
        } else {
            onBindBasicViewHolder(viewHolder, i);
        }
    }

    public int getItemCount() {
        return this.mShowFooter ? getBasicItemCount() + 1 : getBasicItemCount();
    }

    public final int getItemViewType(int i) {
        if (this.mShowFooter && i == getBasicItemCount()) {
            return Integer.MIN_VALUE;
        }
        return getBasicItemViewType(i);
    }
}

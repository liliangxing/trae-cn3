package com.lynx.tasm.behavior.p000ui.list;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GapItemDecoration extends RecyclerView.ItemDecoration {
    private static final int DEFAULT_COLUMN_COUNT = 1;
    private boolean mIsVertical = true;
    private boolean mIsRTL = false;
    private int mColumnCount = 0;
    private int mMainAxisGap = 0;
    private int mCrossAxisGap = 0;

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        if ((adapter instanceof UIListAdapter) && (childViewHolder instanceof ListViewHolder)) {
            UIListAdapter uIListAdapter = (UIListAdapter) adapter;
            ListViewHolder listViewHolder = (ListViewHolder) childViewHolder;
            int adapterPosition = listViewHolder.getAdapterPosition();
            UpdateMainAxisOutRect(rect, adapterPosition == 0 || (adapterPosition < this.mColumnCount && uIListAdapter.getSectionHeaderForPosition(adapterPosition) == -1));
            if (this.mColumnCount <= 1 || listViewHolder.itemView == null) {
                return;
            }
            GridLayoutManager.LayoutParams layoutParams = listViewHolder.itemView.getLayoutParams();
            if (layoutParams instanceof GridLayoutManager.LayoutParams) {
                GridLayoutManager.LayoutParams layoutParams2 = layoutParams;
                UpdateCrossAxisOutRect(rect, layoutParams2.getSpanSize() == this.mColumnCount, layoutParams2.getSpanIndex());
            } else if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams layoutParams3 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
                UpdateCrossAxisOutRect(rect, layoutParams3.isFullSpan(), layoutParams3.getSpanIndex());
            }
        }
    }

    private void UpdateMainAxisOutRect(Rect rect, boolean z) {
        if (this.mIsVertical) {
            rect.top = z ? 0 : this.mMainAxisGap;
        } else if (this.mIsRTL) {
            rect.right = z ? 0 : this.mMainAxisGap;
        } else {
            rect.left = z ? 0 : this.mMainAxisGap;
        }
    }

    private void UpdateCrossAxisOutRect(Rect rect, boolean z, int i) {
        if (z) {
            return;
        }
        int i2 = this.mCrossAxisGap;
        int i3 = this.mColumnCount;
        int i4 = (i2 * (i3 - 1)) / i3;
        if (i == 0) {
            if (this.mIsVertical) {
                rect.right = i4;
                return;
            } else {
                rect.bottom = i4;
                return;
            }
        }
        if (i == i3 - 1) {
            if (this.mIsVertical) {
                rect.left = i4;
                return;
            } else {
                rect.top = i4;
                return;
            }
        }
        if (this.mIsVertical) {
            int i5 = i4 / 2;
            rect.left = i5;
            rect.right = i5;
        } else {
            int i6 = i4 / 2;
            rect.top = i6;
            rect.bottom = i6;
        }
    }

    public void setIsRTL(boolean z) {
        this.mIsRTL = z;
    }

    public void setIsVertical(boolean z) {
        this.mIsVertical = z;
    }

    public void setColumnCount(int i) {
        this.mColumnCount = i;
    }

    public void setMainAxisGap(int i) {
        this.mMainAxisGap = i;
    }

    public void setCrossAxisGap(int i) {
        this.mCrossAxisGap = i;
    }
}

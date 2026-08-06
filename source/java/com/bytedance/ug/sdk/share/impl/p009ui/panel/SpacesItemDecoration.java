package com.bytedance.ug.sdk.share.impl.p009ui.panel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int padding;
    private int space;

    public SpacesItemDecoration(int i, int i2) {
        this.space = i;
        this.padding = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Object tag = view.getTag();
        if (tag instanceof PanelItemViewHolder) {
            int position = ((PanelItemViewHolder) tag).getPosition();
            if (position == 0) {
                rect.left = this.padding;
            }
            if (position != state.getItemCount() - 1) {
                rect.right = this.space;
            } else {
                rect.right = this.padding;
            }
        }
    }
}

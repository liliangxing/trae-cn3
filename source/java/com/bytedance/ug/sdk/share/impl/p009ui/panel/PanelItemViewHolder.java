package com.bytedance.ug.sdk.share.impl.p009ui.panel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.share_ui.R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PanelItemViewHolder extends RecyclerView.ViewHolder {
    public ImageView icon;
    public TextView text;

    public PanelItemViewHolder(View view) {
        super(view);
        this.icon = (ImageView) view.findViewById(R.id.icon);
        this.text = (TextView) view.findViewById(R.id.text);
    }
}

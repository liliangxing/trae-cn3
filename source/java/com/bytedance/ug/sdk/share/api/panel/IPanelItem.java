package com.bytedance.ug.sdk.share.api.panel;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import java.io.Serializable;

/* loaded from: classes4.dex */
public interface IPanelItem extends Serializable {
    int getIconId();

    String getIconUrl();

    PanelItemType getItemType();

    int getTextId();

    String getTextStr();

    void onItemClick(Context context, View view, ShareContent shareContent);

    void setItemView(View view, ImageView imageView, TextView textView);
}

package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ItemConversationPluginBinding implements ViewBinding {
    public final SimpleDraweeView ivPluginIcon;
    private final LinearLayout rootView;
    public final TextView tvPluginName;

    private ItemConversationPluginBinding(LinearLayout linearLayout, SimpleDraweeView simpleDraweeView, TextView textView) {
        this.rootView = linearLayout;
        this.ivPluginIcon = simpleDraweeView;
        this.tvPluginName = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemConversationPluginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemConversationPluginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.item_conversation_plugin, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemConversationPluginBinding bind(View view) {
        int i = C0637R.id.iv_plugin_icon;
        SimpleDraweeView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = C0637R.id.tv_plugin_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new ItemConversationPluginBinding((LinearLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

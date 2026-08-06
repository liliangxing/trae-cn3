package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemChatTagBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvTag;

    private TraeItemChatTagBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.tvTag = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static TraeItemChatTagBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemChatTagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_chat_tag, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemChatTagBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new TraeItemChatTagBinding(textView, textView);
    }
}

package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeItemVoiceHistoryUserBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView tvVoiceHistoryContent;

    private TraeItemVoiceHistoryUserBinding(FrameLayout frameLayout, TextView textView) {
        this.rootView = frameLayout;
        this.tvVoiceHistoryContent = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemVoiceHistoryUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemVoiceHistoryUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_voice_history_user, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemVoiceHistoryUserBinding bind(View view) {
        int i = R.id.tv_voice_history_content;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new TraeItemVoiceHistoryUserBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

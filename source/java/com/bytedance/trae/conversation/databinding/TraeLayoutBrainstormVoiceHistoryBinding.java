package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeLayoutBrainstormVoiceHistoryBinding implements ViewBinding {
    public final ImageView ivVoiceHistoryClose;
    public final LinearLayout llVoiceHistoryEmpty;
    private final LinearLayout rootView;
    public final RecyclerView rvVoiceHistory;
    public final TextView tvVoiceHistoryStatus;
    public final TextView tvVoiceHistoryTitle;

    private TraeLayoutBrainstormVoiceHistoryBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivVoiceHistoryClose = imageView;
        this.llVoiceHistoryEmpty = linearLayout2;
        this.rvVoiceHistory = recyclerView;
        this.tvVoiceHistoryStatus = textView;
        this.tvVoiceHistoryTitle = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeLayoutBrainstormVoiceHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeLayoutBrainstormVoiceHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_layout_brainstorm_voice_history, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeLayoutBrainstormVoiceHistoryBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.iv_voice_history_close;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0637R.id.ll_voice_history_empty;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_voice_history))) != null) {
                i = C0637R.id.tv_voice_history_status;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.tv_voice_history_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new TraeLayoutBrainstormVoiceHistoryBinding((LinearLayout) view, imageView, linearLayout, findChildViewById, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

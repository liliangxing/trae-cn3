package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeItemUserMessageBinding implements ViewBinding {
    public final FrameLayout flTextContainer;
    public final LinearLayout llMessageContainer;
    private final LinearLayout rootView;
    public final RecyclerView rvImages;
    public final TextView tvMessage;
    public final TextView tvShowMore;
    public final View vGradientMask;

    private TraeItemUserMessageBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, View view) {
        this.rootView = linearLayout;
        this.flTextContainer = frameLayout;
        this.llMessageContainer = linearLayout2;
        this.rvImages = recyclerView;
        this.tvMessage = textView;
        this.tvShowMore = textView2;
        this.vGradientMask = view;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemUserMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemUserMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_item_user_message, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemUserMessageBinding bind(View view) {
        RecyclerView findChildViewById;
        View findChildViewById2;
        int i = C0637R.id.fl_text_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0637R.id.ll_message_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_images))) != null) {
                i = C0637R.id.tv_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.tv_show_more;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0637R.id.v_gradient_mask))) != null) {
                        return new TraeItemUserMessageBinding((LinearLayout) view, frameLayout, linearLayout, findChildViewById, textView, textView2, findChildViewById2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

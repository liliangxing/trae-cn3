package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;

/* loaded from: classes5.dex */
public final class TraeExpressPassPopWindowBinding implements ViewBinding {
    public final LinearLayout expressPassClose;
    private final FrameLayout rootView;
    public final TextView tvExpressPassSubtitle;
    public final TextView tvExpressPassTitle;

    private TraeExpressPassPopWindowBinding(FrameLayout frameLayout, LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.expressPassClose = linearLayout;
        this.tvExpressPassSubtitle = textView;
        this.tvExpressPassTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeExpressPassPopWindowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeExpressPassPopWindowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_express_pass_pop_window, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeExpressPassPopWindowBinding bind(View view) {
        int i = R.id.express_pass_close;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.tv_express_pass_subtitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_express_pass_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new TraeExpressPassPopWindowBinding((FrameLayout) view, linearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

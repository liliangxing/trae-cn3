package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class ItemSiteMessageBinding implements ViewBinding {
    public final TextView btnCta;
    public final LinearLayout btnDelete;
    public final FrameLayout layoutContent;
    public final LinearLayout layoutSwipeActions;
    private final FrameLayout rootView;
    public final TextView tvBody;
    public final TextView tvTime;
    public final TextView tvTitle;
    public final View vUnreadDot;

    private ItemSiteMessageBinding(FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, FrameLayout frameLayout2, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, View view) {
        this.rootView = frameLayout;
        this.btnCta = textView;
        this.btnDelete = linearLayout;
        this.layoutContent = frameLayout2;
        this.layoutSwipeActions = linearLayout2;
        this.tvBody = textView2;
        this.tvTime = textView3;
        this.tvTitle = textView4;
        this.vUnreadDot = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemSiteMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemSiteMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_site_message, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemSiteMessageBinding bind(View view) {
        View findChildViewById;
        int i = R.id.btn_cta;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_delete;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.layout_content;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.layout_swipe_actions;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = R.id.tv_body;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_time;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                i = R.id.tv_title;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.v_unread_dot))) != null) {
                                    return new ItemSiteMessageBinding((FrameLayout) view, textView, linearLayout, frameLayout, linearLayout2, textView2, textView3, textView4, findChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

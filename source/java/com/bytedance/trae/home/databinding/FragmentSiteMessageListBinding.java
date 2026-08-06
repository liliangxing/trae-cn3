package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentSiteMessageListBinding implements ViewBinding {
    public final View dimOverlay;
    public final LinearLayout emptyState;
    public final ImageView floatingCard;
    public final FrameLayout rootContainer;
    private final FrameLayout rootView;
    public final RecyclerView rvMessages;
    public final SwipeRefreshLayout swipeRefresh;
    public final TraeTitleBar titleBar;
    public final TextView tvEmpty;

    private FragmentSiteMessageListBinding(FrameLayout frameLayout, View view, LinearLayout linearLayout, ImageView imageView, FrameLayout frameLayout2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TraeTitleBar traeTitleBar, TextView textView) {
        this.rootView = frameLayout;
        this.dimOverlay = view;
        this.emptyState = linearLayout;
        this.floatingCard = imageView;
        this.rootContainer = frameLayout2;
        this.rvMessages = recyclerView;
        this.swipeRefresh = swipeRefreshLayout;
        this.titleBar = traeTitleBar;
        this.tvEmpty = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSiteMessageListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSiteMessageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_site_message_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentSiteMessageListBinding bind(View view) {
        SwipeRefreshLayout findChildViewById;
        int i = C0820R.id.dim_overlay;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            i = C0820R.id.empty_state;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = C0820R.id.floating_card;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = C0820R.id.rv_messages;
                    RecyclerView findChildViewById3 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.swipe_refresh))) != null) {
                        i = C0820R.id.title_bar;
                        TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                        if (traeTitleBar != null) {
                            i = C0820R.id.tv_empty;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new FragmentSiteMessageListBinding(frameLayout, findChildViewById2, linearLayout, imageView, frameLayout, findChildViewById3, findChildViewById, traeTitleBar, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

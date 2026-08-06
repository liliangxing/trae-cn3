package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeLoadingView;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentConversationDetailBinding implements ViewBinding {
    public final ImageView btnScrollToBottom;
    public final TraeLoadingView progressNewerPageLoading;
    public final TraeLoadingView progressOlderPageLoading;
    private final FrameLayout rootView;
    public final RecyclerView rvMessages;

    private TraeFragmentConversationDetailBinding(FrameLayout frameLayout, ImageView imageView, TraeLoadingView traeLoadingView, TraeLoadingView traeLoadingView2, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.btnScrollToBottom = imageView;
        this.progressNewerPageLoading = traeLoadingView;
        this.progressOlderPageLoading = traeLoadingView2;
        this.rvMessages = recyclerView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentConversationDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentConversationDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_conversation_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentConversationDetailBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.btn_scroll_to_bottom;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0637R.id.progress_newer_page_loading;
            TraeLoadingView traeLoadingView = (TraeLoadingView) ViewBindings.findChildViewById(view, i);
            if (traeLoadingView != null) {
                i = C0637R.id.progress_older_page_loading;
                TraeLoadingView traeLoadingView2 = (TraeLoadingView) ViewBindings.findChildViewById(view, i);
                if (traeLoadingView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_messages))) != null) {
                    return new TraeFragmentConversationDetailBinding((FrameLayout) view, imageView, traeLoadingView, traeLoadingView2, findChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.R;
import com.bytedance.trae.conversation.brainstorm.widget.ShimmerTextView;

/* loaded from: classes5.dex */
public final class TraeItemBrainstormSubtitleFooterBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ShimmerTextView tvFooterShimmer;

    private TraeItemBrainstormSubtitleFooterBinding(LinearLayout linearLayout, ShimmerTextView shimmerTextView) {
        this.rootView = linearLayout;
        this.tvFooterShimmer = shimmerTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemBrainstormSubtitleFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemBrainstormSubtitleFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_brainstorm_subtitle_footer, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemBrainstormSubtitleFooterBinding bind(View view) {
        int i = R.id.tv_footer_shimmer;
        ShimmerTextView shimmerTextView = (ShimmerTextView) ViewBindings.findChildViewById(view, i);
        if (shimmerTextView != null) {
            return new TraeItemBrainstormSubtitleFooterBinding((LinearLayout) view, shimmerTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

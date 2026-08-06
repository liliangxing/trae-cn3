package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentAgentDetailBinding implements ViewBinding {
    public final FrameLayout flAgentHeader;
    public final LinearLayout llContent;
    private final NestedScrollView rootView;

    private TraeFragmentAgentDetailBinding(NestedScrollView nestedScrollView, FrameLayout frameLayout, LinearLayout linearLayout) {
        this.rootView = nestedScrollView;
        this.flAgentHeader = frameLayout;
        this.llContent = linearLayout;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static TraeFragmentAgentDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentAgentDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_agent_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentAgentDetailBinding bind(View view) {
        int i = C0637R.id.fl_agent_header;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0637R.id.ll_content;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                return new TraeFragmentAgentDetailBinding((NestedScrollView) view, frameLayout, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

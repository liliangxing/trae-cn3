package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentToolcallGroupDetailBinding implements ViewBinding {
    public final LinearLayout llContent;
    private final NestedScrollView rootView;
    public final TextView tvSummary;

    private TraeFragmentToolcallGroupDetailBinding(NestedScrollView nestedScrollView, LinearLayout linearLayout, TextView textView) {
        this.rootView = nestedScrollView;
        this.llContent = linearLayout;
        this.tvSummary = textView;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static TraeFragmentToolcallGroupDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentToolcallGroupDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_toolcall_group_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentToolcallGroupDetailBinding bind(View view) {
        int i = C0637R.id.ll_content;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0637R.id.tv_summary;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new TraeFragmentToolcallGroupDetailBinding((NestedScrollView) view, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

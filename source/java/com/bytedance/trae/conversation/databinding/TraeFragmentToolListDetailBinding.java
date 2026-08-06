package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentToolListDetailBinding implements ViewBinding {
    public final LinearLayout llToolList;
    private final NestedScrollView rootView;

    private TraeFragmentToolListDetailBinding(NestedScrollView nestedScrollView, LinearLayout linearLayout) {
        this.rootView = nestedScrollView;
        this.llToolList = linearLayout;
    }

    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static TraeFragmentToolListDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentToolListDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_tool_list_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentToolListDetailBinding bind(View view) {
        int i = C0637R.id.ll_tool_list;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            return new TraeFragmentToolListDetailBinding((NestedScrollView) view, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

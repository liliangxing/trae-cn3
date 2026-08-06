package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BottomSheetPluginsBinding implements ViewBinding {
    public final LinearLayout emptyStateContainer;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TraeTitleBar titleBar;
    public final TextView tvEmptyState;

    private BottomSheetPluginsBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, RecyclerView recyclerView, TraeTitleBar traeTitleBar, TextView textView) {
        this.rootView = constraintLayout;
        this.emptyStateContainer = linearLayout;
        this.recyclerView = recyclerView;
        this.titleBar = traeTitleBar;
        this.tvEmptyState = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetPluginsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetPluginsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.bottom_sheet_plugins, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetPluginsBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.empty_state_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.recycler_view))) != null) {
            i = C0637R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                i = C0637R.id.tv_empty_state;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new BottomSheetPluginsBinding((ConstraintLayout) view, linearLayout, findChildViewById, traeTitleBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

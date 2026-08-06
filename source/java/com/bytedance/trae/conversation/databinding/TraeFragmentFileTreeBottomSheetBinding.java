package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentFileTreeBottomSheetBinding implements ViewBinding {
    public final LinearLayout bottomSheetContainer;
    private final LinearLayout rootView;
    public final RecyclerView rvFiles;
    public final TraeTitleBar titleBar;

    private TraeFragmentFileTreeBottomSheetBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, TraeTitleBar traeTitleBar) {
        this.rootView = linearLayout;
        this.bottomSheetContainer = linearLayout2;
        this.rvFiles = recyclerView;
        this.titleBar = traeTitleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentFileTreeBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentFileTreeBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_file_tree_bottom_sheet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentFileTreeBottomSheetBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = C0637R.id.rv_files;
        RecyclerView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = C0637R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                return new TraeFragmentFileTreeBottomSheetBinding(linearLayout, linearLayout, findChildViewById, traeTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

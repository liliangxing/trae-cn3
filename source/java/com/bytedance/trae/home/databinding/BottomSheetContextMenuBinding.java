package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.R;

/* loaded from: classes5.dex */
public final class BottomSheetContextMenuBinding implements ViewBinding {
    public final LinearLayout llDelete;
    public final LinearLayout llRename;
    private final LinearLayout rootView;

    private BottomSheetContextMenuBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.llDelete = linearLayout2;
        this.llRename = linearLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetContextMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetContextMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_context_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetContextMenuBinding bind(View view) {
        int i = R.id.ll_delete;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.ll_rename;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                return new BottomSheetContextMenuBinding((LinearLayout) view, linearLayout, linearLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

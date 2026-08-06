package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BottomSheetDeviceTargetSelectBinding implements ViewBinding {
    public final IncludeDeviceTargetSelectItemBinding itemIde;
    public final IncludeDeviceTargetSelectItemBinding itemWork;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;

    private BottomSheetDeviceTargetSelectBinding(LinearLayout linearLayout, IncludeDeviceTargetSelectItemBinding includeDeviceTargetSelectItemBinding, IncludeDeviceTargetSelectItemBinding includeDeviceTargetSelectItemBinding2, TraeTitleBar traeTitleBar) {
        this.rootView = linearLayout;
        this.itemIde = includeDeviceTargetSelectItemBinding;
        this.itemWork = includeDeviceTargetSelectItemBinding2;
        this.titleBar = traeTitleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BottomSheetDeviceTargetSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BottomSheetDeviceTargetSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.bottom_sheet_device_target_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BottomSheetDeviceTargetSelectBinding bind(View view) {
        int i = C0637R.id.item_ide;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            IncludeDeviceTargetSelectItemBinding bind = IncludeDeviceTargetSelectItemBinding.bind(findChildViewById);
            int i2 = C0637R.id.item_work;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i2);
            if (findChildViewById2 != null) {
                IncludeDeviceTargetSelectItemBinding bind2 = IncludeDeviceTargetSelectItemBinding.bind(findChildViewById2);
                int i3 = C0637R.id.title_bar;
                TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i3);
                if (traeTitleBar != null) {
                    return new BottomSheetDeviceTargetSelectBinding((LinearLayout) view, bind, bind2, traeTitleBar);
                }
                i = i3;
            } else {
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

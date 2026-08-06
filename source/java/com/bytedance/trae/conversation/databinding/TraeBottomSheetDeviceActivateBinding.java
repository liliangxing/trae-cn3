package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeBottomSheetDeviceActivateBinding implements ViewBinding {
    public final ImageView ivDeviceActivate;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;
    public final TextView tvDeviceActivateDescription;
    public final TextView tvDeviceActivateTitle;

    private TraeBottomSheetDeviceActivateBinding(LinearLayout linearLayout, ImageView imageView, TraeTitleBar traeTitleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivDeviceActivate = imageView;
        this.titleBar = traeTitleBar;
        this.tvDeviceActivateDescription = textView;
        this.tvDeviceActivateTitle = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeBottomSheetDeviceActivateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeBottomSheetDeviceActivateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_bottom_sheet_device_activate, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeBottomSheetDeviceActivateBinding bind(View view) {
        int i = C0637R.id.iv_device_activate;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0637R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                i = C0637R.id.tv_device_activate_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0637R.id.tv_device_activate_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new TraeBottomSheetDeviceActivateBinding((LinearLayout) view, imageView, traeTitleBar, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common.widget.UrlSpanTextView;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentAddDevicesBinding implements ViewBinding {
    public final ImageView btnCopyUrl;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;
    public final UrlSpanTextView tvStep1Url;

    private FragmentAddDevicesBinding(LinearLayout linearLayout, ImageView imageView, TraeTitleBar traeTitleBar, UrlSpanTextView urlSpanTextView) {
        this.rootView = linearLayout;
        this.btnCopyUrl = imageView;
        this.titleBar = traeTitleBar;
        this.tvStep1Url = urlSpanTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAddDevicesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAddDevicesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_add_devices, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentAddDevicesBinding bind(View view) {
        int i = C0820R.id.btn_copy_url;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0820R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                i = C0820R.id.tv_step1_url;
                UrlSpanTextView urlSpanTextView = (UrlSpanTextView) ViewBindings.findChildViewById(view, i);
                if (urlSpanTextView != null) {
                    return new FragmentAddDevicesBinding((LinearLayout) view, imageView, traeTitleBar, urlSpanTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

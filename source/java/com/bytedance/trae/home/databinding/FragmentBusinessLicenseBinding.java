package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentBusinessLicenseBinding implements ViewBinding {
    public final ImageView ivLicense;
    private final LinearLayout rootView;
    public final TraeTitleBar titleBar;

    private FragmentBusinessLicenseBinding(LinearLayout linearLayout, ImageView imageView, TraeTitleBar traeTitleBar) {
        this.rootView = linearLayout;
        this.ivLicense = imageView;
        this.titleBar = traeTitleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBusinessLicenseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBusinessLicenseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_business_license, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentBusinessLicenseBinding bind(View view) {
        int i = C0820R.id.iv_license;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0820R.id.title_bar;
            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
            if (traeTitleBar != null) {
                return new FragmentBusinessLicenseBinding((LinearLayout) view, imageView, traeTitleBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

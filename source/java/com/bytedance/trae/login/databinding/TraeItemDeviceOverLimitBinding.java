package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.R;

/* loaded from: classes4.dex */
public final class TraeItemDeviceOverLimitBinding implements ViewBinding {
    public final TextView btnLogoutDevice;
    public final ImageView ivDeviceIcon;
    private final LinearLayout rootView;
    public final TextView tvDeviceName;
    public final TextView tvLoginTime;
    public final TextView tvOsVersion;

    private TraeItemDeviceOverLimitBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.btnLogoutDevice = textView;
        this.ivDeviceIcon = imageView;
        this.tvDeviceName = textView2;
        this.tvLoginTime = textView3;
        this.tvOsVersion = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeItemDeviceOverLimitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeItemDeviceOverLimitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_item_device_over_limit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeItemDeviceOverLimitBinding bind(View view) {
        int i = R.id.btn_logout_device;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.iv_device_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.tv_device_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_login_time;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        i = R.id.tv_os_version;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView4 != null) {
                            return new TraeItemDeviceOverLimitBinding((LinearLayout) view, textView, imageView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

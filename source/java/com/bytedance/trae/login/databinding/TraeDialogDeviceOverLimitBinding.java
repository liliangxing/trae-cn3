package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeDialogDeviceOverLimitBinding implements ViewBinding {
    public final FrameLayout btnLoginCurrent;
    public final ImageView ivClose;
    public final TextView loginCurrentText;
    private final LinearLayout rootView;
    public final RecyclerView rvDevices;
    public final TextView tvDescription;
    public final TextView tvTitle;

    private TraeDialogDeviceOverLimitBinding(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, TextView textView, RecyclerView recyclerView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnLoginCurrent = frameLayout;
        this.ivClose = imageView;
        this.loginCurrentText = textView;
        this.rvDevices = recyclerView;
        this.tvDescription = textView2;
        this.tvTitle = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeDialogDeviceOverLimitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeDialogDeviceOverLimitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_dialog_device_over_limit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeDialogDeviceOverLimitBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0820R.id.btn_login_current;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0820R.id.iv_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C0820R.id.login_current_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.rv_devices))) != null) {
                    i = C0820R.id.tv_description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C0820R.id.tv_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new TraeDialogDeviceOverLimitBinding((LinearLayout) view, frameLayout, imageView, textView, findChildViewById, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

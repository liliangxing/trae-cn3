package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeActivityDouyinBindPhoneBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    public final ImageView ivBack;
    public final FrameLayout loadingOverlay;
    public final ConstraintLayout navBar;
    private final ConstraintLayout rootView;

    private TraeActivityDouyinBindPhoneBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.fragmentContainer = frameLayout;
        this.ivBack = imageView;
        this.loadingOverlay = frameLayout2;
        this.navBar = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityDouyinBindPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityDouyinBindPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_activity_douyin_bind_phone, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityDouyinBindPhoneBinding bind(View view) {
        ConstraintLayout findChildViewById;
        int i = C0820R.id.fragment_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0820R.id.iv_back;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C0820R.id.loading_overlay;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.nav_bar))) != null) {
                    return new TraeActivityDouyinBindPhoneBinding((ConstraintLayout) view, frameLayout, imageView, frameLayout2, findChildViewById);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

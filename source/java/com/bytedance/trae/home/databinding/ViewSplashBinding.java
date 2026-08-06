package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ViewSplashBinding implements ViewBinding {
    public final ImageView logoImage;
    private final ConstraintLayout rootView;
    public final TextView sloganText;
    public final ConstraintLayout splashContainer;

    private ViewSplashBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.logoImage = imageView;
        this.sloganText = textView;
        this.splashContainer = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewSplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewSplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.view_splash, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewSplashBinding bind(View view) {
        int i = C0820R.id.logo_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0820R.id.slogan_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new ViewSplashBinding(constraintLayout, imageView, textView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

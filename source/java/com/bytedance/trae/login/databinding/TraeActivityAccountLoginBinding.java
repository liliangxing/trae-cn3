package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.R;

/* loaded from: classes4.dex */
public final class TraeActivityAccountLoginBinding implements ViewBinding {
    public final FrameLayout fragmentContainer;
    public final FrameLayout loginLoadingOverlay;
    private final FrameLayout rootView;

    private TraeActivityAccountLoginBinding(FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.fragmentContainer = frameLayout2;
        this.loginLoadingOverlay = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityAccountLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityAccountLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_activity_account_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityAccountLoginBinding bind(View view) {
        int i = R.id.fragment_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.login_loading_overlay;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout2 != null) {
                return new TraeActivityAccountLoginBinding((FrameLayout) view, frameLayout, frameLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

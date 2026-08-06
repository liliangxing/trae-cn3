package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.widget.VerifyCodeInputView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeActivityVerifyCodeBinding implements ViewBinding {
    public final ImageView ivBack;
    public final FrameLayout loadingOverlay;
    public final ConstraintLayout navBar;
    private final ConstraintLayout rootView;
    public final TextView tvPhone;
    public final TextView tvResend;
    public final TextView tvSubtitle;
    public final VerifyCodeInputView verifyCodeInput;

    private TraeActivityVerifyCodeBinding(ConstraintLayout constraintLayout, ImageView imageView, FrameLayout frameLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, VerifyCodeInputView verifyCodeInputView) {
        this.rootView = constraintLayout;
        this.ivBack = imageView;
        this.loadingOverlay = frameLayout;
        this.navBar = constraintLayout2;
        this.tvPhone = textView;
        this.tvResend = textView2;
        this.tvSubtitle = textView3;
        this.verifyCodeInput = verifyCodeInputView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityVerifyCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityVerifyCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_activity_verify_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityVerifyCodeBinding bind(View view) {
        ConstraintLayout findChildViewById;
        int i = C0820R.id.iv_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0820R.id.loading_overlay;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.nav_bar))) != null) {
                i = C0820R.id.tv_phone;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0820R.id.tv_resend;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C0820R.id.tv_subtitle;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = C0820R.id.verify_code_input;
                            VerifyCodeInputView verifyCodeInputView = (VerifyCodeInputView) ViewBindings.findChildViewById(view, i);
                            if (verifyCodeInputView != null) {
                                return new TraeActivityVerifyCodeBinding((ConstraintLayout) view, imageView, frameLayout, findChildViewById, textView, textView2, textView3, verifyCodeInputView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

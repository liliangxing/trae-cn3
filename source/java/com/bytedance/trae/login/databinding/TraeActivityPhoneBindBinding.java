package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.widget.VerifyCodeInputView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeActivityPhoneBindBinding implements ViewBinding {
    public final TextView btnSendCode;
    public final TextView btnSendCodeOld;
    public final EditText etOldPhone;
    public final EditText etPhone;
    public final ImageView ivBack;
    public final FrameLayout loadingOverlay;
    public final LinearLayout navBar;
    private final ConstraintLayout rootView;
    public final TextView tvNavTitle;
    public final TextView tvNewPhoneTitle;
    public final TextView tvResendNew;
    public final TextView tvResendOld;
    public final TextView tvVerifyNewHint;
    public final TextView tvVerifyOldHint;
    public final VerifyCodeInputView verifyNewInput;
    public final VerifyCodeInputView verifyOldInput;
    public final ViewFlipper viewFlipper;

    private TraeActivityPhoneBindBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, EditText editText, EditText editText2, ImageView imageView, FrameLayout frameLayout, LinearLayout linearLayout, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, VerifyCodeInputView verifyCodeInputView, VerifyCodeInputView verifyCodeInputView2, ViewFlipper viewFlipper) {
        this.rootView = constraintLayout;
        this.btnSendCode = textView;
        this.btnSendCodeOld = textView2;
        this.etOldPhone = editText;
        this.etPhone = editText2;
        this.ivBack = imageView;
        this.loadingOverlay = frameLayout;
        this.navBar = linearLayout;
        this.tvNavTitle = textView3;
        this.tvNewPhoneTitle = textView4;
        this.tvResendNew = textView5;
        this.tvResendOld = textView6;
        this.tvVerifyNewHint = textView7;
        this.tvVerifyOldHint = textView8;
        this.verifyNewInput = verifyCodeInputView;
        this.verifyOldInput = verifyCodeInputView2;
        this.viewFlipper = viewFlipper;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeActivityPhoneBindBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityPhoneBindBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_activity_phone_bind, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityPhoneBindBinding bind(View view) {
        int i = C0820R.id.btn_send_code;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0820R.id.btn_send_code_old;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C0820R.id.et_old_phone;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText != null) {
                    i = C0820R.id.et_phone;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText2 != null) {
                        i = C0820R.id.iv_back;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = C0820R.id.loading_overlay;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = C0820R.id.nav_bar;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = C0820R.id.tv_nav_title;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = C0820R.id.tv_new_phone_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = C0820R.id.tv_resend_new;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView5 != null) {
                                                i = C0820R.id.tv_resend_old;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = C0820R.id.tv_verify_new_hint;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView7 != null) {
                                                        i = C0820R.id.tv_verify_old_hint;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView8 != null) {
                                                            i = C0820R.id.verify_new_input;
                                                            VerifyCodeInputView verifyCodeInputView = (VerifyCodeInputView) ViewBindings.findChildViewById(view, i);
                                                            if (verifyCodeInputView != null) {
                                                                i = C0820R.id.verify_old_input;
                                                                VerifyCodeInputView verifyCodeInputView2 = (VerifyCodeInputView) ViewBindings.findChildViewById(view, i);
                                                                if (verifyCodeInputView2 != null) {
                                                                    i = C0820R.id.view_flipper;
                                                                    ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, i);
                                                                    if (viewFlipper != null) {
                                                                        return new TraeActivityPhoneBindBinding((ConstraintLayout) view, textView, textView2, editText, editText2, imageView, frameLayout, linearLayout, textView3, textView4, textView5, textView6, textView7, textView8, verifyCodeInputView, verifyCodeInputView2, viewFlipper);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.UrlSpanTextView;
import com.bytedance.trae.login.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeFragmentOneClickLoginBinding implements ViewBinding {
    public final FrameLayout btnContainer;
    public final Button btnOneClickLogin;
    public final ImageView ivAgreementCheck;
    public final ProgressBar pbLoading;
    public final UrlSpanTextView privacyPolicyText;
    private final ScrollView rootView;
    public final TextView tvMaskedPhone;
    public final TextView tvSwitch;
    public final TextView tvTitle;

    private TraeFragmentOneClickLoginBinding(ScrollView scrollView, FrameLayout frameLayout, Button button, ImageView imageView, ProgressBar progressBar, UrlSpanTextView urlSpanTextView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = scrollView;
        this.btnContainer = frameLayout;
        this.btnOneClickLogin = button;
        this.ivAgreementCheck = imageView;
        this.pbLoading = progressBar;
        this.privacyPolicyText = urlSpanTextView;
        this.tvMaskedPhone = textView;
        this.tvSwitch = textView2;
        this.tvTitle = textView3;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static TraeFragmentOneClickLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentOneClickLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_fragment_one_click_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentOneClickLoginBinding bind(View view) {
        UrlSpanTextView findChildViewById;
        int i = C0820R.id.btn_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0820R.id.btn_one_click_login;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = C0820R.id.iv_agreement_check;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C0820R.id.pb_loading;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.privacy_policy_text))) != null) {
                        i = C0820R.id.tv_masked_phone;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = C0820R.id.tv_switch;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = C0820R.id.tv_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new TraeFragmentOneClickLoginBinding((ScrollView) view, frameLayout, button, imageView, progressBar, findChildViewById, textView, textView2, textView3);
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

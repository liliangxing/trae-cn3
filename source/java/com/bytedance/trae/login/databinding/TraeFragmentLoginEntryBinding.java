package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.UrlSpanTextView;
import com.bytedance.trae.login.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeFragmentLoginEntryBinding implements ViewBinding {
    public final LinearLayout agreementContainer;
    public final LinearLayout bottomLoginContainer;
    public final TextView btnBytecloudSso;
    public final FrameLayout btnDouyinLogin;
    public final TextView btnEnterpriseLogin;
    public final FrameLayout btnPhoneLogin;
    public final View dividerLoginLinks;
    public final ImageView ivAgreementCheck;
    public final UrlSpanTextView privacyPolicyText;
    private final LinearLayout rootView;

    private TraeFragmentLoginEntryBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, FrameLayout frameLayout, TextView textView2, FrameLayout frameLayout2, View view, ImageView imageView, UrlSpanTextView urlSpanTextView) {
        this.rootView = linearLayout;
        this.agreementContainer = linearLayout2;
        this.bottomLoginContainer = linearLayout3;
        this.btnBytecloudSso = textView;
        this.btnDouyinLogin = frameLayout;
        this.btnEnterpriseLogin = textView2;
        this.btnPhoneLogin = frameLayout2;
        this.dividerLoginLinks = view;
        this.ivAgreementCheck = imageView;
        this.privacyPolicyText = urlSpanTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentLoginEntryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentLoginEntryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_fragment_login_entry, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentLoginEntryBinding bind(View view) {
        View findChildViewById;
        UrlSpanTextView findChildViewById2;
        int i = C0820R.id.agreement_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C0820R.id.bottom_login_container;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = C0820R.id.btn_bytecloud_sso;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C0820R.id.btn_douyin_login;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = C0820R.id.btn_enterprise_login;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = C0820R.id.btn_phone_login;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.divider_login_links))) != null) {
                                i = C0820R.id.iv_agreement_check;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = C0820R.id.privacy_policy_text))) != null) {
                                    return new TraeFragmentLoginEntryBinding((LinearLayout) view, linearLayout, linearLayout2, textView, frameLayout, textView2, frameLayout2, findChildViewById, imageView, findChildViewById2);
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

package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.UrlSpanTextView;
import com.bytedance.trae.login.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeFragmentLoginPhoneBinding implements ViewBinding {
    public final ImageView btnBack;
    public final FrameLayout btnContainer;
    public final Button btnGetCode;
    public final CheckBox cbAgreement;
    public final EditText etPhone;
    public final ImageView ivClear;
    public final LinearLayout llPhoneInput;
    public final ProgressBar pbLoading;
    public final UrlSpanTextView privacyPolicyText;
    private final ScrollView rootView;
    public final TextView tvCountryCode;
    public final TextView tvTitle;

    private TraeFragmentLoginPhoneBinding(ScrollView scrollView, ImageView imageView, FrameLayout frameLayout, Button button, CheckBox checkBox, EditText editText, ImageView imageView2, LinearLayout linearLayout, ProgressBar progressBar, UrlSpanTextView urlSpanTextView, TextView textView, TextView textView2) {
        this.rootView = scrollView;
        this.btnBack = imageView;
        this.btnContainer = frameLayout;
        this.btnGetCode = button;
        this.cbAgreement = checkBox;
        this.etPhone = editText;
        this.ivClear = imageView2;
        this.llPhoneInput = linearLayout;
        this.pbLoading = progressBar;
        this.privacyPolicyText = urlSpanTextView;
        this.tvCountryCode = textView;
        this.tvTitle = textView2;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static TraeFragmentLoginPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentLoginPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_fragment_login_phone, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentLoginPhoneBinding bind(View view) {
        UrlSpanTextView findChildViewById;
        int i = C0820R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0820R.id.btn_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = C0820R.id.btn_get_code;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = C0820R.id.cb_agreement;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, i);
                    if (checkBox != null) {
                        i = C0820R.id.et_phone;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText != null) {
                            i = C0820R.id.iv_clear;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = C0820R.id.ll_phone_input;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = C0820R.id.pb_loading;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                    if (progressBar != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.privacy_policy_text))) != null) {
                                        i = C0820R.id.tv_country_code;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = C0820R.id.tv_title;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                return new TraeFragmentLoginPhoneBinding((ScrollView) view, imageView, frameLayout, button, checkBox, editText, imageView2, linearLayout, progressBar, findChildViewById, textView, textView2);
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

package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.R;

/* loaded from: classes4.dex */
public final class TraeFragmentDouyinBindPhoneInputBinding implements ViewBinding {
    public final TextView btnSendCode;
    public final EditText etPhone;
    public final ProgressBar pbLoading;
    public final LinearLayout phoneInputGroup;
    private final LinearLayout rootView;
    public final TextView tvCountryCode;
    public final TextView tvTitle;

    private TraeFragmentDouyinBindPhoneInputBinding(LinearLayout linearLayout, TextView textView, EditText editText, ProgressBar progressBar, LinearLayout linearLayout2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnSendCode = textView;
        this.etPhone = editText;
        this.pbLoading = progressBar;
        this.phoneInputGroup = linearLayout2;
        this.tvCountryCode = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentDouyinBindPhoneInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentDouyinBindPhoneInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_fragment_douyin_bind_phone_input, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentDouyinBindPhoneInputBinding bind(View view) {
        int i = R.id.btn_send_code;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.et_phone;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.pb_loading;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = R.id.phone_input_group;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.tv_country_code;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new TraeFragmentDouyinBindPhoneInputBinding((LinearLayout) view, textView, editText, progressBar, linearLayout, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

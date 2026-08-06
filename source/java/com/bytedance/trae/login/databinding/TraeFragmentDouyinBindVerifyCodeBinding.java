package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.widget.VerifyCodeInputView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeFragmentDouyinBindVerifyCodeBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvCodeHint;
    public final TextView tvMaskedPhone;
    public final TextView tvResend;
    public final LinearLayout verifyCodeGroup;
    public final VerifyCodeInputView verifyCodeInput;

    private TraeFragmentDouyinBindVerifyCodeBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout2, VerifyCodeInputView verifyCodeInputView) {
        this.rootView = linearLayout;
        this.tvCodeHint = textView;
        this.tvMaskedPhone = textView2;
        this.tvResend = textView3;
        this.verifyCodeGroup = linearLayout2;
        this.verifyCodeInput = verifyCodeInputView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentDouyinBindVerifyCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentDouyinBindVerifyCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_fragment_douyin_bind_verify_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentDouyinBindVerifyCodeBinding bind(View view) {
        int i = C0820R.id.tv_code_hint;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0820R.id.tv_masked_phone;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C0820R.id.tv_resend;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = C0820R.id.verify_code_group;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = C0820R.id.verify_code_input;
                        VerifyCodeInputView verifyCodeInputView = (VerifyCodeInputView) ViewBindings.findChildViewById(view, i);
                        if (verifyCodeInputView != null) {
                            return new TraeFragmentDouyinBindVerifyCodeBinding((LinearLayout) view, textView, textView2, textView3, linearLayout, verifyCodeInputView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

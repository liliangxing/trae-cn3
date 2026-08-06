package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeFragmentVerifyCodeBinding implements ViewBinding {
    public final EditText etCode1;
    public final EditText etCode2;
    public final EditText etCode3;
    public final EditText etCode4;
    public final EditText etCode5;
    public final EditText etCode6;
    public final ImageView ivBack;
    public final ConstraintLayout navBar;
    private final ConstraintLayout rootView;
    public final TextView tvPhone;
    public final TextView tvResend;
    public final TextView tvSubtitle;

    private TraeFragmentVerifyCodeBinding(ConstraintLayout constraintLayout, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, EditText editText6, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.etCode1 = editText;
        this.etCode2 = editText2;
        this.etCode3 = editText3;
        this.etCode4 = editText4;
        this.etCode5 = editText5;
        this.etCode6 = editText6;
        this.ivBack = imageView;
        this.navBar = constraintLayout2;
        this.tvPhone = textView;
        this.tvResend = textView2;
        this.tvSubtitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentVerifyCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentVerifyCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_fragment_verify_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentVerifyCodeBinding bind(View view) {
        ConstraintLayout findChildViewById;
        int i = C0820R.id.et_code_1;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
        if (editText != null) {
            i = C0820R.id.et_code_2;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText2 != null) {
                i = C0820R.id.et_code_3;
                EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                if (editText3 != null) {
                    i = C0820R.id.et_code_4;
                    EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                    if (editText4 != null) {
                        i = C0820R.id.et_code_5;
                        EditText editText5 = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText5 != null) {
                            i = C0820R.id.et_code_6;
                            EditText editText6 = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText6 != null) {
                                i = C0820R.id.iv_back;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0820R.id.nav_bar))) != null) {
                                    i = C0820R.id.tv_phone;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = C0820R.id.tv_resend;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = C0820R.id.tv_subtitle;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                return new TraeFragmentVerifyCodeBinding((ConstraintLayout) view, editText, editText2, editText3, editText4, editText5, editText6, imageView, findChildViewById, textView, textView2, textView3);
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

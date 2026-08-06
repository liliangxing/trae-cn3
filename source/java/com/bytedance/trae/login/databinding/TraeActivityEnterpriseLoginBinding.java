package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.R;

/* loaded from: classes4.dex */
public final class TraeActivityEnterpriseLoginBinding implements ViewBinding {
    public final ImageView btnBack;
    public final ImageView btnBackPassword;
    public final Button btnContinue;
    public final Button btnLogin;
    public final FrameLayout btnSsoLogin;
    public final EditText etEmailStep1;
    public final EditText etPassword;
    public final ImageView ivClearEmail;
    public final ImageView ivClearPassword;
    public final ImageView ivTogglePassword;
    public final LinearLayout layoutEmailInput;
    public final LinearLayout layoutErrorEmail;
    public final LinearLayout layoutErrorPassword;
    public final LinearLayout layoutOrDivider;
    public final LinearLayout layoutPasswordInput;
    public final LinearLayout layoutStepEmail;
    public final LinearLayout layoutStepPassword;
    public final ProgressBar pbLoading;
    public final ProgressBar pbLoadingEmail;
    private final ScrollView rootView;
    public final TextView tvEmailDisplay;
    public final TextView tvError;
    public final TextView tvErrorEmail;
    public final TextView tvForgotPassword;
    public final TextView tvStep2Title;

    private TraeActivityEnterpriseLoginBinding(ScrollView scrollView, ImageView imageView, ImageView imageView2, Button button, Button button2, FrameLayout frameLayout, EditText editText, EditText editText2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, ProgressBar progressBar, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = scrollView;
        this.btnBack = imageView;
        this.btnBackPassword = imageView2;
        this.btnContinue = button;
        this.btnLogin = button2;
        this.btnSsoLogin = frameLayout;
        this.etEmailStep1 = editText;
        this.etPassword = editText2;
        this.ivClearEmail = imageView3;
        this.ivClearPassword = imageView4;
        this.ivTogglePassword = imageView5;
        this.layoutEmailInput = linearLayout;
        this.layoutErrorEmail = linearLayout2;
        this.layoutErrorPassword = linearLayout3;
        this.layoutOrDivider = linearLayout4;
        this.layoutPasswordInput = linearLayout5;
        this.layoutStepEmail = linearLayout6;
        this.layoutStepPassword = linearLayout7;
        this.pbLoading = progressBar;
        this.pbLoadingEmail = progressBar2;
        this.tvEmailDisplay = textView;
        this.tvError = textView2;
        this.tvErrorEmail = textView3;
        this.tvForgotPassword = textView4;
        this.tvStep2Title = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static TraeActivityEnterpriseLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityEnterpriseLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.trae_activity_enterprise_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityEnterpriseLoginBinding bind(View view) {
        int i = R.id.btn_back;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btn_back_password;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.btn_continue;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = R.id.btn_login;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button2 != null) {
                        i = R.id.btn_sso_login;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = R.id.et_email_step1;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                            if (editText != null) {
                                i = R.id.et_password;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText2 != null) {
                                    i = R.id.iv_clear_email;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.iv_clear_password;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = R.id.iv_toggle_password;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = R.id.layout_email_input;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    i = R.id.layout_error_email;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout2 != null) {
                                                        i = R.id.layout_error_password;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.layout_or_divider;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout4 != null) {
                                                                i = R.id.layout_password_input;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout5 != null) {
                                                                    i = R.id.layout_step_email;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout6 != null) {
                                                                        i = R.id.layout_step_password;
                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout7 != null) {
                                                                            i = R.id.pb_loading;
                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                            if (progressBar != null) {
                                                                                i = R.id.pb_loading_email;
                                                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                if (progressBar2 != null) {
                                                                                    i = R.id.tv_email_display;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView != null) {
                                                                                        i = R.id.tv_error;
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.tv_error_email;
                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView3 != null) {
                                                                                                i = R.id.tv_forgot_password;
                                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView4 != null) {
                                                                                                    i = R.id.tv_step2_title;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView5 != null) {
                                                                                                        return new TraeActivityEnterpriseLoginBinding((ScrollView) view, imageView, imageView2, button, button2, frameLayout, editText, editText2, imageView3, imageView4, imageView5, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, progressBar, progressBar2, textView, textView2, textView3, textView4, textView5);
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

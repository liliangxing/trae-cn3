package com.bytedance.trae.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.widget.VerifyCodeInputView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeActivityForgotPasswordBinding implements ViewBinding {
    public final ImageView btnBackStep1;
    public final ImageView btnBackStep2;
    public final ImageView btnBackStep3;
    public final ImageView btnBackStep4;
    public final Button btnGoLogin;
    public final Button btnSendCode;
    public final Button btnSetPassword;
    public final EditText etConfirmPassword;
    public final EditText etEmailStep1;
    public final EditText etNewPassword;
    public final ImageView ivClearEmailStep1;
    public final ImageView ivToggleConfirmPassword;
    public final ImageView ivToggleNewPassword;
    public final LinearLayout layoutConfirmPasswordInput;
    public final LinearLayout layoutEmailInputStep1;
    public final LinearLayout layoutErrorStep1;
    public final LinearLayout layoutErrorStep2;
    public final LinearLayout layoutErrorStep3;
    public final LinearLayout layoutNewPasswordInput;
    public final LinearLayout layoutStepNewPassword;
    public final LinearLayout layoutStepSendCode;
    public final LinearLayout layoutStepSuccess;
    public final LinearLayout layoutStepVerifyCode;
    public final ProgressBar pbLoadingStep1;
    public final ProgressBar pbLoadingStep2;
    public final ProgressBar pbLoadingStep3;
    private final ScrollView rootView;
    public final TextView tvErrorStep1;
    public final TextView tvErrorStep2;
    public final TextView tvErrorStep3;
    public final TextView tvResendCode;
    public final TextView tvVerifyDesc;
    public final VerifyCodeInputView verifyCodeInput;

    private TraeActivityForgotPasswordBinding(ScrollView scrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, Button button, Button button2, Button button3, EditText editText, EditText editText2, EditText editText3, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, VerifyCodeInputView verifyCodeInputView) {
        this.rootView = scrollView;
        this.btnBackStep1 = imageView;
        this.btnBackStep2 = imageView2;
        this.btnBackStep3 = imageView3;
        this.btnBackStep4 = imageView4;
        this.btnGoLogin = button;
        this.btnSendCode = button2;
        this.btnSetPassword = button3;
        this.etConfirmPassword = editText;
        this.etEmailStep1 = editText2;
        this.etNewPassword = editText3;
        this.ivClearEmailStep1 = imageView5;
        this.ivToggleConfirmPassword = imageView6;
        this.ivToggleNewPassword = imageView7;
        this.layoutConfirmPasswordInput = linearLayout;
        this.layoutEmailInputStep1 = linearLayout2;
        this.layoutErrorStep1 = linearLayout3;
        this.layoutErrorStep2 = linearLayout4;
        this.layoutErrorStep3 = linearLayout5;
        this.layoutNewPasswordInput = linearLayout6;
        this.layoutStepNewPassword = linearLayout7;
        this.layoutStepSendCode = linearLayout8;
        this.layoutStepSuccess = linearLayout9;
        this.layoutStepVerifyCode = linearLayout10;
        this.pbLoadingStep1 = progressBar;
        this.pbLoadingStep2 = progressBar2;
        this.pbLoadingStep3 = progressBar3;
        this.tvErrorStep1 = textView;
        this.tvErrorStep2 = textView2;
        this.tvErrorStep3 = textView3;
        this.tvResendCode = textView4;
        this.tvVerifyDesc = textView5;
        this.verifyCodeInput = verifyCodeInputView;
    }

    public ScrollView getRoot() {
        return this.rootView;
    }

    public static TraeActivityForgotPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeActivityForgotPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.trae_activity_forgot_password, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeActivityForgotPasswordBinding bind(View view) {
        int i = C0820R.id.btn_back_step1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C0820R.id.btn_back_step2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = C0820R.id.btn_back_step3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = C0820R.id.btn_back_step4;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = C0820R.id.btn_go_login;
                        Button button = (Button) ViewBindings.findChildViewById(view, i);
                        if (button != null) {
                            i = C0820R.id.btn_send_code;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                            if (button2 != null) {
                                i = C0820R.id.btn_set_password;
                                Button button3 = (Button) ViewBindings.findChildViewById(view, i);
                                if (button3 != null) {
                                    i = C0820R.id.et_confirm_password;
                                    EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText != null) {
                                        i = C0820R.id.et_email_step1;
                                        EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                        if (editText2 != null) {
                                            i = C0820R.id.et_new_password;
                                            EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText3 != null) {
                                                i = C0820R.id.iv_clear_email_step1;
                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView5 != null) {
                                                    i = C0820R.id.iv_toggle_confirm_password;
                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView6 != null) {
                                                        i = C0820R.id.iv_toggle_new_password;
                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView7 != null) {
                                                            i = C0820R.id.layout_confirm_password_input;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                            if (linearLayout != null) {
                                                                i = C0820R.id.layout_email_input_step1;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout2 != null) {
                                                                    i = C0820R.id.layout_error_step1;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = C0820R.id.layout_error_step2;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout4 != null) {
                                                                            i = C0820R.id.layout_error_step3;
                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout5 != null) {
                                                                                i = C0820R.id.layout_new_password_input;
                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout6 != null) {
                                                                                    i = C0820R.id.layout_step_new_password;
                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout7 != null) {
                                                                                        i = C0820R.id.layout_step_send_code;
                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout8 != null) {
                                                                                            i = C0820R.id.layout_step_success;
                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout9 != null) {
                                                                                                i = C0820R.id.layout_step_verify_code;
                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout10 != null) {
                                                                                                    i = C0820R.id.pb_loading_step1;
                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                    if (progressBar != null) {
                                                                                                        i = C0820R.id.pb_loading_step2;
                                                                                                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                        if (progressBar2 != null) {
                                                                                                            i = C0820R.id.pb_loading_step3;
                                                                                                            ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                            if (progressBar3 != null) {
                                                                                                                i = C0820R.id.tv_error_step1;
                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView != null) {
                                                                                                                    i = C0820R.id.tv_error_step2;
                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView2 != null) {
                                                                                                                        i = C0820R.id.tv_error_step3;
                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView3 != null) {
                                                                                                                            i = C0820R.id.tv_resend_code;
                                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView4 != null) {
                                                                                                                                i = C0820R.id.tv_verify_desc;
                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView5 != null) {
                                                                                                                                    i = C0820R.id.verify_code_input;
                                                                                                                                    VerifyCodeInputView verifyCodeInputView = (VerifyCodeInputView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (verifyCodeInputView != null) {
                                                                                                                                        return new TraeActivityForgotPasswordBinding((ScrollView) view, imageView, imageView2, imageView3, imageView4, button, button2, button3, editText, editText2, editText3, imageView5, imageView6, imageView7, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, linearLayout7, linearLayout8, linearLayout9, linearLayout10, progressBar, progressBar2, progressBar3, textView, textView2, textView3, textView4, textView5, verifyCodeInputView);
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

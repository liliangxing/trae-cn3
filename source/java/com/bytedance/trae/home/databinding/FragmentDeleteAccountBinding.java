package com.bytedance.trae.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.home.C0820R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FragmentDeleteAccountBinding implements ViewBinding {
    public final TextView btnCancelConfirm;
    public final TextView btnCancelOauth;
    public final TextView btnCancelPwd;
    public final TextView btnCancelSms;
    public final TextView btnCancelVerify;
    public final TextView btnConfirmDelete;
    public final TextView btnGoogleVerify;
    public final TextView btnOkCountdown;
    public final TextView btnPwdVerify;
    public final TextView btnSendCode;
    public final TextView btnSmsSendCode;
    public final TextView btnSmsVerify;
    public final TextView btnVerify;
    public final EditText etEmail;
    public final EditText etPassword;
    public final EditText etSmsCode;
    public final EditText etVerificationCode;
    public final ProgressBar progressLoading;
    private final LinearLayout rootView;
    public final ScrollView scrollContent;
    public final LinearLayout stepConfirm;
    public final LinearLayout stepEmailVerify;
    public final LinearLayout stepOauthVerify;
    public final LinearLayout stepPwdVerify;
    public final LinearLayout stepSmsVerify;
    public final LinearLayout stepSubmitted;
    public final TraeTitleBar titleBar;
    public final TextView tvConfirmUserInfo;
    public final TextView tvEmailVerifyHint;
    public final TextView tvOauthNickname;
    public final TextView tvOauthUnsupported;
    public final TextView tvOauthVerifyHint;
    public final TextView tvPwdVerifyHint;
    public final TextView tvSmsVerifyHint;

    private FragmentDeleteAccountBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, EditText editText, EditText editText2, EditText editText3, EditText editText4, ProgressBar progressBar, ScrollView scrollView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TraeTitleBar traeTitleBar, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20) {
        this.rootView = linearLayout;
        this.btnCancelConfirm = textView;
        this.btnCancelOauth = textView2;
        this.btnCancelPwd = textView3;
        this.btnCancelSms = textView4;
        this.btnCancelVerify = textView5;
        this.btnConfirmDelete = textView6;
        this.btnGoogleVerify = textView7;
        this.btnOkCountdown = textView8;
        this.btnPwdVerify = textView9;
        this.btnSendCode = textView10;
        this.btnSmsSendCode = textView11;
        this.btnSmsVerify = textView12;
        this.btnVerify = textView13;
        this.etEmail = editText;
        this.etPassword = editText2;
        this.etSmsCode = editText3;
        this.etVerificationCode = editText4;
        this.progressLoading = progressBar;
        this.scrollContent = scrollView;
        this.stepConfirm = linearLayout2;
        this.stepEmailVerify = linearLayout3;
        this.stepOauthVerify = linearLayout4;
        this.stepPwdVerify = linearLayout5;
        this.stepSmsVerify = linearLayout6;
        this.stepSubmitted = linearLayout7;
        this.titleBar = traeTitleBar;
        this.tvConfirmUserInfo = textView14;
        this.tvEmailVerifyHint = textView15;
        this.tvOauthNickname = textView16;
        this.tvOauthUnsupported = textView17;
        this.tvOauthVerifyHint = textView18;
        this.tvPwdVerifyHint = textView19;
        this.tvSmsVerifyHint = textView20;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDeleteAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDeleteAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0820R.layout.fragment_delete_account, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentDeleteAccountBinding bind(View view) {
        int i = C0820R.id.btn_cancel_confirm;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C0820R.id.btn_cancel_oauth;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C0820R.id.btn_cancel_pwd;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = C0820R.id.btn_cancel_sms;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = C0820R.id.btn_cancel_verify;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = C0820R.id.btn_confirm_delete;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView6 != null) {
                                i = C0820R.id.btn_google_verify;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView7 != null) {
                                    i = C0820R.id.btn_ok_countdown;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView8 != null) {
                                        i = C0820R.id.btn_pwd_verify;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView9 != null) {
                                            i = C0820R.id.btn_send_code;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView10 != null) {
                                                i = C0820R.id.btn_sms_send_code;
                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView11 != null) {
                                                    i = C0820R.id.btn_sms_verify;
                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView12 != null) {
                                                        i = C0820R.id.btn_verify;
                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView13 != null) {
                                                            i = C0820R.id.et_email;
                                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                            if (editText != null) {
                                                                i = C0820R.id.et_password;
                                                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                if (editText2 != null) {
                                                                    i = C0820R.id.et_sms_code;
                                                                    EditText editText3 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                    if (editText3 != null) {
                                                                        i = C0820R.id.et_verification_code;
                                                                        EditText editText4 = (EditText) ViewBindings.findChildViewById(view, i);
                                                                        if (editText4 != null) {
                                                                            i = C0820R.id.progress_loading;
                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                            if (progressBar != null) {
                                                                                i = C0820R.id.scroll_content;
                                                                                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                                if (scrollView != null) {
                                                                                    i = C0820R.id.step_confirm;
                                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (linearLayout != null) {
                                                                                        i = C0820R.id.step_email_verify;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout2 != null) {
                                                                                            i = C0820R.id.step_oauth_verify;
                                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout3 != null) {
                                                                                                i = C0820R.id.step_pwd_verify;
                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout4 != null) {
                                                                                                    i = C0820R.id.step_sms_verify;
                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout5 != null) {
                                                                                                        i = C0820R.id.step_submitted;
                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (linearLayout6 != null) {
                                                                                                            i = C0820R.id.title_bar;
                                                                                                            TraeTitleBar traeTitleBar = (TraeTitleBar) ViewBindings.findChildViewById(view, i);
                                                                                                            if (traeTitleBar != null) {
                                                                                                                i = C0820R.id.tv_confirm_user_info;
                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView14 != null) {
                                                                                                                    i = C0820R.id.tv_email_verify_hint;
                                                                                                                    TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView15 != null) {
                                                                                                                        i = C0820R.id.tv_oauth_nickname;
                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView16 != null) {
                                                                                                                            i = C0820R.id.tv_oauth_unsupported;
                                                                                                                            TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView17 != null) {
                                                                                                                                i = C0820R.id.tv_oauth_verify_hint;
                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView18 != null) {
                                                                                                                                    i = C0820R.id.tv_pwd_verify_hint;
                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView19 != null) {
                                                                                                                                        i = C0820R.id.tv_sms_verify_hint;
                                                                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView20 != null) {
                                                                                                                                            return new FragmentDeleteAccountBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, editText, editText2, editText3, editText4, progressBar, scrollView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, traeTitleBar, textView14, textView15, textView16, textView17, textView18, textView19, textView20);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}

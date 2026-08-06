package com.bytedance.trae.login.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.fragment.TraceFragment;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common_ui.R;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.DeviceOverLimitDialog;
import com.bytedance.trae.login.activity.DouyinBindPhoneActivity;
import com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding;
import com.bytedance.trae.login.service.AccountHelper;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.ListDevicesResult;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.login.widget.VerifyCodeInputView;
import com.bytedance.trae.multilanguage.C0882R;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: DouyinBindVerifyCodeFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000fH\u0002J \u0010)\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010(\u001a\u00020\u000fH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J\b\u0010/\u001a\u00020\u001aH\u0002J\"\u00100\u001a\u00020\u001a2\u0018\u00101\u001a\u0014\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a02H\u0002J\b\u00103\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;", "Lcom/bytedance/trae/common/fragment/TraceFragment;", "<init>", "()V", "_binding", "Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;", "binding", "getBinding", "()Lcom/bytedance/trae/login/databinding/TraeFragmentDouyinBindVerifyCodeBinding;", "phoneNumber", "", "profileKey", "countDownTimer", "Landroid/os/CountDownTimer;", "isSubmitting", "", "isResending", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupViews", "maskPhone", TraeAuthManager.PLATFORM_PHONE, "resendCode", "submitBind", "code", "isVerifyCodeError", "errorMsg", "showPhoneConflictDialog", "activity", "Lcom/bytedance/trae/login/activity/DouyinBindPhoneActivity;", "handleDeviceOverLimit", "isNewUser", "showDeviceOverLimitDialog", "result", "Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", "continueLoginAfterDeviceLimit", "startCountdown", "setResendSending", "setResendReady", "runOnHost", "block", "Lkotlin/Function2;", "onDestroyView", "autoLogEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinBindVerifyCodeFragment extends TraceFragment {
    private static final String ARG_PHONE_NUMBER = "arg_phone_number";
    private static final String ARG_PROFILE_KEY = "arg_profile_key";
    private static final int CODE_LENGTH = 6;
    private static final int COUNTDOWN_SECONDS = 60;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ERROR_CODE_PHONE_ALREADY_BOUND = 1007;
    private static final int ERROR_CODE_PHONE_ALREADY_BOUND_2 = 1041;
    private static final int ERROR_CODE_SMS_CODE_ERROR = 1202;
    private static final int ERROR_CODE_SMS_CODE_EXPIRED = 1203;
    private static final int ERROR_CODE_SMS_CODE_MISSING = 1201;
    private static final int ERROR_CODE_SMS_CODE_TYPE_ERROR = 1204;
    private static final String PLATFORM_ID = "23081";
    private static final String STAGE_DEVICE_LIMIT_CONTINUE = "device_limit_continue";
    private static final String STAGE_DEVICE_LIMIT_LIST = "device_limit_list";
    private static final String STAGE_SUBMIT_BIND_PHONE = "submit_bind_phone";
    private static final String STAGE_TRAE_AUTH_AFTER_BIND = "trae_auth_after_bind";
    private TraeFragmentDouyinBindVerifyCodeBinding _binding;
    private CountDownTimer countDownTimer;
    private boolean isResending;
    private boolean isSubmitting;
    private String phoneNumber = "";
    private String profileKey = "";

    public boolean autoLogEnterPage() {
        return false;
    }

    /* compiled from: DouyinBindVerifyCodeFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment$Companion;", "", "<init>", "()V", "ARG_PHONE_NUMBER", "", "ARG_PROFILE_KEY", "PLATFORM_ID", "COUNTDOWN_SECONDS", "", "CODE_LENGTH", "ERROR_CODE_PHONE_ALREADY_BOUND", "ERROR_CODE_PHONE_ALREADY_BOUND_2", "ERROR_CODE_SMS_CODE_MISSING", "ERROR_CODE_SMS_CODE_ERROR", "ERROR_CODE_SMS_CODE_EXPIRED", "ERROR_CODE_SMS_CODE_TYPE_ERROR", "STAGE_SUBMIT_BIND_PHONE", "STAGE_TRAE_AUTH_AFTER_BIND", "STAGE_DEVICE_LIMIT_LIST", "STAGE_DEVICE_LIMIT_CONTINUE", "newInstance", "Lcom/bytedance/trae/login/fragment/DouyinBindVerifyCodeFragment;", "phoneNumber", "profileKey", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DouyinBindVerifyCodeFragment newInstance(String phoneNumber, String profileKey) {
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            Intrinsics.checkNotNullParameter(profileKey, "profileKey");
            DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment = new DouyinBindVerifyCodeFragment();
            Bundle bundle = new Bundle();
            bundle.putString(DouyinBindVerifyCodeFragment.ARG_PHONE_NUMBER, phoneNumber);
            bundle.putString(DouyinBindVerifyCodeFragment.ARG_PROFILE_KEY, profileKey);
            douyinBindVerifyCodeFragment.setArguments(bundle);
            return douyinBindVerifyCodeFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final TraeFragmentDouyinBindVerifyCodeBinding get_binding() {
        return this._binding;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TraeFragmentDouyinBindVerifyCodeBinding.inflate(inflater, container, false);
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding = get_binding();
        return traeFragmentDouyinBindVerifyCodeBinding != null ? traeFragmentDouyinBindVerifyCodeBinding.getRoot() : null;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_PHONE_NUMBER) : null;
        if (string == null) {
            string = "";
        }
        this.phoneNumber = string;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(ARG_PROFILE_KEY) : null;
        this.profileKey = string2 != null ? string2 : "";
        if (!(this.phoneNumber.length() == 0)) {
            if (!(this.profileKey.length() == 0)) {
                setupViews();
                startCountdown();
                return;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void setupViews() {
        VerifyCodeInputView verifyCodeInputView;
        VerifyCodeInputView verifyCodeInputView2;
        TextView textView;
        VerifyCodeInputView verifyCodeInputView3;
        TextView textView2;
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding != null && (textView2 = traeFragmentDouyinBindVerifyCodeBinding.tvMaskedPhone) != null) {
            textView2.setText(maskPhone(this.phoneNumber));
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding2 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding2 != null && (verifyCodeInputView3 = traeFragmentDouyinBindVerifyCodeBinding2.verifyCodeInput) != null) {
            verifyCodeInputView3.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$setupViews$1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    boolean z;
                    String obj = s != null ? s.toString() : null;
                    if (obj == null) {
                        obj = "";
                    }
                    if (obj.length() == 6) {
                        z = DouyinBindVerifyCodeFragment.this.isSubmitting;
                        if (z) {
                            return;
                        }
                        DouyinBindVerifyCodeFragment.this.submitBind(obj);
                    }
                }
            });
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding3 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding3 != null && (textView = traeFragmentDouyinBindVerifyCodeBinding3.tvResend) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DouyinBindVerifyCodeFragment.this.resendCode();
                }
            });
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding4 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding4 != null && (verifyCodeInputView2 = traeFragmentDouyinBindVerifyCodeBinding4.verifyCodeInput) != null) {
            verifyCodeInputView2.requestFocus();
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding5 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding5 == null || (verifyCodeInputView = traeFragmentDouyinBindVerifyCodeBinding5.verifyCodeInput) == null) {
            return;
        }
        verifyCodeInputView.post(new Runnable() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                DouyinBindVerifyCodeFragment.setupViews$lambda$1(DouyinBindVerifyCodeFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupViews$lambda$1(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment) {
        if (!douyinBindVerifyCodeFragment.isAdded() || douyinBindVerifyCodeFragment.get_binding() == null) {
            return;
        }
        Object systemService = douyinBindVerifyCodeFragment.requireContext().getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding = douyinBindVerifyCodeFragment.get_binding();
            inputMethodManager.showSoftInput((View) (traeFragmentDouyinBindVerifyCodeBinding != null ? traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput : null), 1);
        }
    }

    private final String maskPhone(String phone) {
        if (phone.length() < 7) {
            return phone;
        }
        StringBuilder sb = new StringBuilder();
        String substring = phone.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        StringBuilder append = sb.append(substring).append("****");
        String substring2 = phone.substring(7);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return append.append(substring2).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resendCode() {
        if (this.isResending) {
            return;
        }
        this.isResending = true;
        setResendSending();
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_RESEND_CODE, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is6Digits", "1");
        linkedHashMap.put("app_name", AppHost.Companion.getAppName());
        BDAccountAPIV3Impl.instance().sendCode2(this.phoneNumber, 24, linkedHashMap, new DouyinBindVerifyCodeFragment$resendCode$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitBind(String code) {
        VerifyCodeInputView verifyCodeInputView;
        this.isSubmitting = true;
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding != null && (verifyCodeInputView = traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput) != null) {
            verifyCodeInputView.setEnabled(false);
        }
        DouyinBindPhoneActivity activity = getActivity();
        DouyinBindPhoneActivity douyinBindPhoneActivity = activity instanceof DouyinBindPhoneActivity ? activity : null;
        if (douyinBindPhoneActivity != null) {
            douyinBindPhoneActivity.setBindLoading(true);
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_SUBMIT, "douyin", null, null, null, null, null, null, null, null, null, 2044, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("app_name", AppHost.Companion.getAppName());
        linkedHashMap.put("platform_app_id", PLATFORM_ID);
        BDAccountAPIV3Impl.instance().bindLogin(this.phoneNumber, code, this.profileKey, (String) null, linkedHashMap, new DouyinBindVerifyCodeFragment$submitBind$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isVerifyCodeError(String errorMsg) {
        String lowerCase = errorMsg.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = lowerCase;
        return StringsKt.contains$default(str, "验证码", false, 2, (Object) null) || StringsKt.contains$default(str, "verification code", false, 2, (Object) null) || StringsKt.contains$default(str, "sms code", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showPhoneConflictDialog(final DouyinBindPhoneActivity activity) {
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_PHONE_CONFLICT, "douyin", null, null, null, null, null, null, null, SccResult.MESSAGE_FAIL, STAGE_SUBMIT_BIND_PHONE, 508, null);
        String string = getString(C0820R.string.trae_douyin_bind_phone_conflict_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0820R.string.trae_douyin_bind_phone_conflict_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(C0820R.string.trae_douyin_bind_phone_conflict_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomConfirmDialog.Companion.delete$default(CustomConfirmDialog.Companion, (Context) activity, string, string2, (String) null, string3, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 0, 0, new Function0() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda3
            public final Object invoke() {
                Unit showPhoneConflictDialog$lambda$2;
                showPhoneConflictDialog$lambda$2 = DouyinBindVerifyCodeFragment.showPhoneConflictDialog$lambda$2(DouyinBindPhoneActivity.this);
                return showPhoneConflictDialog$lambda$2;
            }
        }, (Function0) null, 98280, (Object) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPhoneConflictDialog$lambda$2(DouyinBindPhoneActivity douyinBindPhoneActivity) {
        douyinBindPhoneActivity.popToPhoneInput();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDeviceOverLimit(boolean isNewUser) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1(this, isNewUser, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showDeviceOverLimitDialog(DouyinBindPhoneActivity activity, ListDevicesResult result, final boolean isNewUser) {
        DeviceOverLimitDialog.INSTANCE.show((Activity) activity, result, DeviceOverLimitDialog.Scene.LOGIN, new DeviceOverLimitDialog.Callback() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda4
            @Override // com.bytedance.trae.login.DeviceOverLimitDialog.Callback
            public final void onResult(boolean z) {
                DouyinBindVerifyCodeFragment.showDeviceOverLimitDialog$lambda$4(DouyinBindVerifyCodeFragment.this, isNewUser, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeviceOverLimitDialog$lambda$4(final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, boolean z, boolean z2) {
        if (z2) {
            douyinBindVerifyCodeFragment.continueLoginAfterDeviceLimit(z);
            return;
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DEVICE_LIMIT_DISMISSED, "douyin", null, STAGE_DEVICE_LIMIT_CONTINUE, null, TraeAuthManager.STAGE_DEVICE_LIMIT_DISMISSED, null, null, null, SccResult.MESSAGE_FAIL, STAGE_DEVICE_LIMIT_CONTINUE, 468, null);
        LoginTracker.trackDouyinBindPhoneResult$default(LoginTracker.INSTANCE, false, STAGE_DEVICE_LIMIT_CONTINUE, null, TraeAuthManager.STAGE_DEVICE_LIMIT_DISMISSED, 4, null);
        douyinBindVerifyCodeFragment.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit showDeviceOverLimitDialog$lambda$4$lambda$3;
                showDeviceOverLimitDialog$lambda$4$lambda$3 = DouyinBindVerifyCodeFragment.showDeviceOverLimitDialog$lambda$4$lambda$3(DouyinBindVerifyCodeFragment.this, (DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                return showDeviceOverLimitDialog$lambda$4$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showDeviceOverLimitDialog$lambda$4$lambda$3(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "host");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "binding");
        douyinBindVerifyCodeFragment.isSubmitting = false;
        douyinBindPhoneActivity.setBindLoading(false);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        Toast.makeText((Context) douyinBindPhoneActivity, douyinBindVerifyCodeFragment.getString(C0882R.string.trae_device_over_limit), 0).show();
        return Unit.INSTANCE;
    }

    private final void continueLoginAfterDeviceLimit(boolean isNewUser) {
        AccountHelper.INSTANCE.setIsNewUser(isNewUser);
        runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit continueLoginAfterDeviceLimit$lambda$5;
                continueLoginAfterDeviceLimit$lambda$5 = DouyinBindVerifyCodeFragment.continueLoginAfterDeviceLimit$lambda$5((DouyinBindPhoneActivity) obj, (TraeFragmentDouyinBindVerifyCodeBinding) obj2);
                return continueLoginAfterDeviceLimit$lambda$5;
            }
        });
        TraeAuthManager.INSTANCE.onLoginContinueByDeviceLimit(new DouyinBindVerifyCodeFragment$continueLoginAfterDeviceLimit$2(this), "douyin");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit continueLoginAfterDeviceLimit$lambda$5(DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        Intrinsics.checkNotNullParameter(douyinBindPhoneActivity, "activity");
        Intrinsics.checkNotNullParameter(traeFragmentDouyinBindVerifyCodeBinding, "binding");
        douyinBindPhoneActivity.setBindLoading(true);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$startCountdown$1] */
    public final void startCountdown() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding != null && (textView3 = traeFragmentDouyinBindVerifyCodeBinding.tvResend) != null) {
            textView3.setClickable(false);
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding2 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding2 != null && (textView2 = traeFragmentDouyinBindVerifyCodeBinding2.tvResend) != null) {
            textView2.setTextColor(ContextCompat.getColor(context, R.color.trae_text_text_disabled));
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding3 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding3 != null && (textView = traeFragmentDouyinBindVerifyCodeBinding3.tvResend) != null) {
            textView.setText(getString(C0820R.string.trae_douyin_bind_resend_countdown, new Object[]{60}));
        }
        this.countDownTimer = new CountDownTimer() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$startCountdown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding4;
                TextView textView4;
                int i = (int) (millisUntilFinished / BytePatchException.ErrorCode.paramsError);
                traeFragmentDouyinBindVerifyCodeBinding4 = DouyinBindVerifyCodeFragment.this.get_binding();
                if (traeFragmentDouyinBindVerifyCodeBinding4 == null || (textView4 = traeFragmentDouyinBindVerifyCodeBinding4.tvResend) == null) {
                    return;
                }
                textView4.setText(DouyinBindVerifyCodeFragment.this.getString(C0820R.string.trae_douyin_bind_resend_countdown, new Object[]{Integer.valueOf(i)}));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                DouyinBindVerifyCodeFragment.this.setResendReady();
            }
        }.start();
    }

    private final void setResendSending() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding != null && (textView3 = traeFragmentDouyinBindVerifyCodeBinding.tvResend) != null) {
            textView3.setClickable(false);
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding2 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding2 != null && (textView2 = traeFragmentDouyinBindVerifyCodeBinding2.tvResend) != null) {
            textView2.setTextColor(ContextCompat.getColor(context, R.color.trae_text_text_disabled));
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding3 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding3 == null || (textView = traeFragmentDouyinBindVerifyCodeBinding3.tvResend) == null) {
            return;
        }
        textView.setText(getString(C0820R.string.trae_douyin_bind_sending_code));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setResendReady() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        this.isResending = false;
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding != null && (textView3 = traeFragmentDouyinBindVerifyCodeBinding.tvResend) != null) {
            textView3.setClickable(true);
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding2 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding2 != null && (textView2 = traeFragmentDouyinBindVerifyCodeBinding2.tvResend) != null) {
            textView2.setTextColor(ContextCompat.getColor(context, R.color.trae_text_text_default));
        }
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding3 = get_binding();
        if (traeFragmentDouyinBindVerifyCodeBinding3 == null || (textView = traeFragmentDouyinBindVerifyCodeBinding3.tvResend) == null) {
            return;
        }
        textView.setText(C0820R.string.trae_phone_resend_ready);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runOnHost(final Function2<? super DouyinBindPhoneActivity, ? super TraeFragmentDouyinBindVerifyCodeBinding, Unit> block) {
        DouyinBindPhoneActivity activity = getActivity();
        final DouyinBindPhoneActivity douyinBindPhoneActivity = activity instanceof DouyinBindPhoneActivity ? activity : null;
        if (douyinBindPhoneActivity == null) {
            return;
        }
        douyinBindPhoneActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                DouyinBindVerifyCodeFragment.runOnHost$lambda$6(DouyinBindVerifyCodeFragment.this, douyinBindPhoneActivity, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnHost$lambda$6(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, DouyinBindPhoneActivity douyinBindPhoneActivity, Function2 function2) {
        TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding = douyinBindVerifyCodeFragment.get_binding();
        if (!douyinBindVerifyCodeFragment.isAdded() || douyinBindPhoneActivity.isFinishing() || douyinBindPhoneActivity.isDestroyed() || traeFragmentDouyinBindVerifyCodeBinding == null) {
            return;
        }
        function2.invoke(douyinBindPhoneActivity, traeFragmentDouyinBindVerifyCodeBinding);
    }

    public void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = null;
        this._binding = null;
    }
}

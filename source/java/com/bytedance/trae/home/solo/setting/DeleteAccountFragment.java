package com.bytedance.trae.home.solo.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.IAccountCancelApi;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: DeleteAccountFragment.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0012\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0003Z[\\B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u00104\u001a\u0004\u0018\u00010 2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020 2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010>\u001a\u00020<H\u0016J\u0010\u0010?\u001a\u00020<2\u0006\u0010=\u001a\u00020 H\u0002J\u0010\u0010@\u001a\u00020<2\u0006\u0010=\u001a\u00020 H\u0002J\b\u0010A\u001a\u00020<H\u0002J\b\u0010B\u001a\u00020<H\u0002J\b\u0010C\u001a\u00020<H\u0002J\b\u0010D\u001a\u00020<H\u0002J\b\u0010E\u001a\u00020<H\u0002J\b\u0010F\u001a\u00020<H\u0002J\b\u0010G\u001a\u00020<H\u0002J\b\u0010H\u001a\u00020<H\u0002J\u001e\u0010I\u001a\u00020<2\u0014\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0KH\u0002J\u000e\u0010L\u001a\u00020<H\u0082@¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020<H\u0002J\b\u0010O\u001a\u00020<H\u0002J\b\u0010P\u001a\u00020<H\u0002J\b\u0010Q\u001a\u00020<H\u0002J\u0010\u0010R\u001a\u00020<2\u0006\u0010S\u001a\u00020\u0005H\u0002J\u0010\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u00020\u000fH\u0002J\u0010\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020\tH\u0002J\u0010\u0010X\u001a\u00020\t2\u0006\u0010Y\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "currentStep", "Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;", "authType", "Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;", "valueTicket", "", "cancelTicket", "verifyToken", "nickname", "userMobile", "isLoading", "", "sendCodeCountdown", "", "sendCodeJob", "Lkotlinx/coroutines/Job;", "finishCountdownJob", "loginService", "Lcom/bytedance/trae/login/api/ILoginService;", "googleSignInLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "progressLoading", "Landroid/widget/ProgressBar;", "scrollContent", "Landroid/widget/ScrollView;", "stepEmailVerify", "Landroid/view/View;", "etEmail", "Landroid/widget/EditText;", "etVerificationCode", "btnSendCode", "Landroid/widget/TextView;", "btnVerify", "stepOauthVerify", "tvOauthNickname", "tvOauthUnsupported", "btnGoogleVerify", "stepSmsVerify", "tvSmsVerifyHint", "etSmsCode", "btnSmsSendCode", "btnSmsVerify", "stepConfirm", "tvConfirmUserInfo", "stepSubmitted", "btnOkCountdown", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "bindViews", "setupListeners", "init", "sendVerificationCode", "startSendCodeCountdown", "verifyEmailCode", "sendSmsVerificationCode", "startSmsSendCodeCountdown", "verifySmsCode", "verifyGoogleAuth", "handleGoogleAuthSuccess", "authInfo", "", "performCancelCheckAndProceed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showFinalConfirmDialog", "confirmDelete", "startFinishCountdown", "navigateToLogin", "showStep", "step", "showLoading", "loading", "showToast", "message", "maskPhone", "phone", "Step", "AuthType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteAccountFragment extends Fragment {
    private static final String TAG = "DeleteAccountFragment";
    private AuthType authType;
    private TextView btnGoogleVerify;
    private TextView btnOkCountdown;
    private TextView btnSendCode;
    private TextView btnSmsSendCode;
    private TextView btnSmsVerify;
    private TextView btnVerify;
    private String cancelTicket;
    private Step currentStep = Step.VERIFY;
    private EditText etEmail;
    private EditText etSmsCode;
    private EditText etVerificationCode;
    private Job finishCountdownJob;
    private final ActivityResultLauncher<Intent> googleSignInLauncher;
    private boolean isLoading;
    private ILoginService loginService;
    private String nickname;
    private ProgressBar progressLoading;
    private ScrollView scrollContent;
    private int sendCodeCountdown;
    private Job sendCodeJob;
    private View stepConfirm;
    private View stepEmailVerify;
    private View stepOauthVerify;
    private View stepSmsVerify;
    private View stepSubmitted;
    private TextView tvConfirmUserInfo;
    private TextView tvOauthNickname;
    private TextView tvOauthUnsupported;
    private TextView tvSmsVerifyHint;
    private String userMobile;
    private String valueTicket;
    private String verifyToken;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: DeleteAccountFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AuthType.values().length];
            try {
                iArr[AuthType.EMAIL_CODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthType.SMS_CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AuthType.GOOGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AuthType.GITHUB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Step.values().length];
            try {
                iArr2[Step.VERIFY.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Step.CONFIRM.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Step.SUBMITTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DeleteAccountFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda5
            public final void onActivityResult(Object obj) {
                DeleteAccountFragment.googleSignInLauncher$lambda$0(DeleteAccountFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.googleSignInLauncher = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DeleteAccountFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Step;", "", "<init>", "(Ljava/lang/String;I)V", "VERIFY", "CONFIRM", "SUBMITTED", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Step {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Step[] $VALUES;
        public static final Step VERIFY = new Step("VERIFY", 0);
        public static final Step CONFIRM = new Step("CONFIRM", 1);
        public static final Step SUBMITTED = new Step("SUBMITTED", 2);

        private static final /* synthetic */ Step[] $values() {
            return new Step[]{VERIFY, CONFIRM, SUBMITTED};
        }

        public static EnumEntries<Step> getEntries() {
            return $ENTRIES;
        }

        private Step(String str, int i) {
        }

        static {
            Step[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Step valueOf(String str) {
            return (Step) Enum.valueOf(Step.class, str);
        }

        public static Step[] values() {
            return (Step[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DeleteAccountFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$AuthType;", "", "<init>", "(Ljava/lang/String;I)V", "EMAIL_CODE", "SMS_CODE", "GOOGLE", "GITHUB", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AuthType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AuthType[] $VALUES;
        public static final AuthType EMAIL_CODE = new AuthType("EMAIL_CODE", 0);
        public static final AuthType SMS_CODE = new AuthType("SMS_CODE", 1);
        public static final AuthType GOOGLE = new AuthType("GOOGLE", 2);
        public static final AuthType GITHUB = new AuthType("GITHUB", 3);

        private static final /* synthetic */ AuthType[] $values() {
            return new AuthType[]{EMAIL_CODE, SMS_CODE, GOOGLE, GITHUB};
        }

        public static EnumEntries<AuthType> getEntries() {
            return $ENTRIES;
        }

        private AuthType(String str, int i) {
        }

        static {
            AuthType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static AuthType valueOf(String str) {
            return (AuthType) Enum.valueOf(AuthType.class, str);
        }

        public static AuthType[] values() {
            return (AuthType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void googleSignInLauncher$lambda$0(DeleteAccountFragment deleteAccountFragment, ActivityResult activityResult) {
        FLogger.INSTANCE.i(TAG, "googleSignInLauncher result: resultCode=" + activityResult.getResultCode() + ", hasData=" + (activityResult.getData() != null));
        ILoginService iLoginService = deleteAccountFragment.loginService;
        TextView textView = null;
        Map<String, String> parseGoogleSignInResult = iLoginService != null ? iLoginService.parseGoogleSignInResult(activityResult.getData()) : null;
        if (parseGoogleSignInResult != null) {
            deleteAccountFragment.handleGoogleAuthSuccess(parseGoogleSignInResult);
            return;
        }
        deleteAccountFragment.isLoading = false;
        TextView textView2 = deleteAccountFragment.btnGoogleVerify;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnGoogleVerify");
        } else {
            textView = textView2;
        }
        textView.setEnabled(true);
        if (activityResult.getData() == null) {
            FLogger.INSTANCE.i(TAG, "Google sign-in cancelled by user");
            return;
        }
        String string = deleteAccountFragment.getString(C0820R.string.trae_delete_verify_failed);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        deleteAccountFragment.showToast(string);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_delete_account, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        ILoginService iLoginService;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        try {
            iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        } catch (Exception unused) {
            iLoginService = null;
        }
        this.loginService = iLoginService;
        bindViews(view);
        setupListeners(view);
        init();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Job job = this.sendCodeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.finishCountdownJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    private final void bindViews(View view) {
        View findViewById = view.findViewById(C0820R.id.progress_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.progressLoading = (ProgressBar) findViewById;
        View findViewById2 = view.findViewById(C0820R.id.scroll_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.scrollContent = (ScrollView) findViewById2;
        View findViewById3 = view.findViewById(C0820R.id.step_email_verify);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.stepEmailVerify = findViewById3;
        View findViewById4 = view.findViewById(C0820R.id.et_email);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.etEmail = (EditText) findViewById4;
        View findViewById5 = view.findViewById(C0820R.id.et_verification_code);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.etVerificationCode = (EditText) findViewById5;
        View findViewById6 = view.findViewById(C0820R.id.btn_send_code);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.btnSendCode = (TextView) findViewById6;
        View findViewById7 = view.findViewById(C0820R.id.btn_verify);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.btnVerify = (TextView) findViewById7;
        View findViewById8 = view.findViewById(C0820R.id.step_oauth_verify);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.stepOauthVerify = findViewById8;
        View findViewById9 = view.findViewById(C0820R.id.tv_oauth_nickname);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.tvOauthNickname = (TextView) findViewById9;
        View findViewById10 = view.findViewById(C0820R.id.tv_oauth_unsupported);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.tvOauthUnsupported = (TextView) findViewById10;
        View findViewById11 = view.findViewById(C0820R.id.btn_google_verify);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.btnGoogleVerify = (TextView) findViewById11;
        View findViewById12 = view.findViewById(C0820R.id.step_sms_verify);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.stepSmsVerify = findViewById12;
        View findViewById13 = view.findViewById(C0820R.id.tv_sms_verify_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.tvSmsVerifyHint = (TextView) findViewById13;
        View findViewById14 = view.findViewById(C0820R.id.et_sms_code);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.etSmsCode = (EditText) findViewById14;
        View findViewById15 = view.findViewById(C0820R.id.btn_sms_send_code);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.btnSmsSendCode = (TextView) findViewById15;
        View findViewById16 = view.findViewById(C0820R.id.btn_sms_verify);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
        this.btnSmsVerify = (TextView) findViewById16;
        View findViewById17 = view.findViewById(C0820R.id.step_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
        this.stepConfirm = findViewById17;
        View findViewById18 = view.findViewById(C0820R.id.tv_confirm_user_info);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(...)");
        this.tvConfirmUserInfo = (TextView) findViewById18;
        View findViewById19 = view.findViewById(C0820R.id.step_submitted);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(...)");
        this.stepSubmitted = findViewById19;
        View findViewById20 = view.findViewById(C0820R.id.btn_ok_countdown);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(...)");
        this.btnOkCountdown = (TextView) findViewById20;
    }

    private final void setupListeners(View view) {
        ((TraeTitleBar) view.findViewById(C0820R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.setupListeners$lambda$1(DeleteAccountFragment.this, view2);
            }
        });
        TextView textView = this.btnSendCode;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.this.sendVerificationCode();
            }
        });
        TextView textView3 = this.btnVerify;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnVerify");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.this.verifyEmailCode();
            }
        });
        view.findViewById(C0820R.id.btn_cancel_verify).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.setupListeners$lambda$4(DeleteAccountFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_cancel_oauth).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.setupListeners$lambda$5(DeleteAccountFragment.this, view2);
            }
        });
        TextView textView4 = this.btnGoogleVerify;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnGoogleVerify");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.this.verifyGoogleAuth();
            }
        });
        TextView textView5 = this.btnSmsSendCode;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSmsSendCode");
            textView5 = null;
        }
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.this.sendSmsVerificationCode();
            }
        });
        TextView textView6 = this.btnSmsVerify;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSmsVerify");
            textView6 = null;
        }
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.this.verifySmsCode();
            }
        });
        view.findViewById(C0820R.id.btn_cancel_sms).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.setupListeners$lambda$9(DeleteAccountFragment.this, view2);
            }
        });
        view.findViewById(C0820R.id.btn_confirm_delete).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.this.showFinalConfirmDialog();
            }
        });
        view.findViewById(C0820R.id.btn_cancel_confirm).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.setupListeners$lambda$11(DeleteAccountFragment.this, view2);
            }
        });
        TextView textView7 = this.btnOkCountdown;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnOkCountdown");
        } else {
            textView2 = textView7;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeleteAccountFragment.setupListeners$lambda$12(DeleteAccountFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$1(DeleteAccountFragment deleteAccountFragment, View view) {
        deleteAccountFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$4(DeleteAccountFragment deleteAccountFragment, View view) {
        deleteAccountFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$5(DeleteAccountFragment deleteAccountFragment, View view) {
        deleteAccountFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$9(DeleteAccountFragment deleteAccountFragment, View view) {
        deleteAccountFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$11(DeleteAccountFragment deleteAccountFragment, View view) {
        deleteAccountFragment.getParentFragmentManager().popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$12(DeleteAccountFragment deleteAccountFragment, View view) {
        Job job = deleteAccountFragment.finishCountdownJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        deleteAccountFragment.navigateToLogin();
    }

    private final void init() {
        showLoading(true);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$init$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendVerificationCode() {
        EditText editText = this.etEmail;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmail");
            editText = null;
        }
        String obj = StringsKt.trim(editText.getText().toString()).toString();
        String str = obj;
        if ((str.length() == 0) || !Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            EditText editText3 = this.etEmail;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etEmail");
            } else {
                editText2 = editText3;
            }
            editText2.requestFocus();
            return;
        }
        if (this.sendCodeCountdown > 0 || this.isLoading) {
            return;
        }
        this.isLoading = true;
        TextView textView = this.btnSendCode;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
            textView = null;
        }
        textView.setEnabled(false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$sendVerificationCode$1(obj, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSendCodeCountdown() {
        this.sendCodeCountdown = 60;
        TextView textView = this.btnSendCode;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
            textView = null;
        }
        textView.setEnabled(false);
        Job job = this.sendCodeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.sendCodeJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$startSendCodeCountdown$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyEmailCode() {
        EditText editText = this.etVerificationCode;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etVerificationCode");
            editText = null;
        }
        String obj = StringsKt.trim(editText.getText().toString()).toString();
        if (obj.length() == 0) {
            EditText editText3 = this.etVerificationCode;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etVerificationCode");
            } else {
                editText2 = editText3;
            }
            editText2.requestFocus();
            return;
        }
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        TextView textView = this.btnVerify;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnVerify");
            textView = null;
        }
        textView.setEnabled(false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$verifyEmailCode$1(obj, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSmsVerificationCode() {
        String str = this.userMobile;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            String string = getString(C0820R.string.trae_delete_sms_no_phone);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showToast(string);
        } else {
            if (this.sendCodeCountdown > 0 || this.isLoading) {
                return;
            }
            this.isLoading = true;
            TextView textView = this.btnSmsSendCode;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnSmsSendCode");
                textView = null;
            }
            textView.setEnabled(false);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$sendSmsVerificationCode$1(str, this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSmsSendCodeCountdown() {
        this.sendCodeCountdown = 60;
        TextView textView = this.btnSmsSendCode;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSmsSendCode");
            textView = null;
        }
        textView.setEnabled(false);
        Job job = this.sendCodeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.sendCodeJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$startSmsSendCodeCountdown$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifySmsCode() {
        EditText editText = this.etSmsCode;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etSmsCode");
            editText = null;
        }
        String obj = StringsKt.trim(editText.getText().toString()).toString();
        if (obj.length() == 0) {
            EditText editText3 = this.etSmsCode;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etSmsCode");
            } else {
                editText2 = editText3;
            }
            editText2.requestFocus();
            return;
        }
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        TextView textView = this.btnSmsVerify;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSmsVerify");
            textView = null;
        }
        textView.setEnabled(false);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$verifySmsCode$1(obj, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void verifyGoogleAuth() {
        Activity activity = getActivity();
        if (activity == null || this.isLoading) {
            return;
        }
        this.isLoading = true;
        TextView textView = this.btnGoogleVerify;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnGoogleVerify");
            textView = null;
        }
        textView.setEnabled(false);
        ILoginService iLoginService = this.loginService;
        Intent googleSignInIntent = iLoginService != null ? iLoginService.getGoogleSignInIntent(activity) : null;
        if (googleSignInIntent == null) {
            this.isLoading = false;
            TextView textView3 = this.btnGoogleVerify;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnGoogleVerify");
            } else {
                textView2 = textView3;
            }
            textView2.setEnabled(true);
            String string = getString(C0820R.string.trae_delete_verify_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showToast(string);
            return;
        }
        this.googleSignInLauncher.launch(googleSignInIntent);
    }

    private final void handleGoogleAuthSuccess(Map<String, String> authInfo) {
        if (isAdded()) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$handleGoogleAuthSuccess$1(authInfo, this, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:11:0x0030, B:12:0x0051, B:14:0x0059, B:18:0x0074, B:20:0x007a, B:21:0x0080), top: B:10:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074 A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:11:0x0030, B:12:0x0051, B:14:0x0059, B:18:0x0074, B:20:0x007a, B:21:0x0080), top: B:10:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object performCancelCheckAndProceed(Continuation<? super Unit> continuation) {
        DeleteAccountFragment$performCancelCheckAndProceed$1 deleteAccountFragment$performCancelCheckAndProceed$1;
        int i;
        DeleteAccountFragment deleteAccountFragment;
        CancelCheckResponse cancelCheckResponse;
        if (continuation instanceof DeleteAccountFragment$performCancelCheckAndProceed$1) {
            deleteAccountFragment$performCancelCheckAndProceed$1 = (DeleteAccountFragment$performCancelCheckAndProceed$1) continuation;
            if ((deleteAccountFragment$performCancelCheckAndProceed$1.label & Integer.MIN_VALUE) != 0) {
                deleteAccountFragment$performCancelCheckAndProceed$1.label -= Integer.MIN_VALUE;
                Object obj = deleteAccountFragment$performCancelCheckAndProceed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = deleteAccountFragment$performCancelCheckAndProceed$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        IAccountCancelApi.Companion companion = IAccountCancelApi.INSTANCE;
                        String str = this.valueTicket;
                        deleteAccountFragment$performCancelCheckAndProceed$1.L$0 = this;
                        deleteAccountFragment$performCancelCheckAndProceed$1.label = 1;
                        obj = companion.cancelCheck(str, deleteAccountFragment$performCancelCheckAndProceed$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        deleteAccountFragment = this;
                    } catch (Exception e) {
                        e = e;
                        deleteAccountFragment = this;
                        FLogger.INSTANCE.w(TAG, "cancelCheck error: " + e.getMessage() + ", proceeding without cancel_ticket");
                        deleteAccountFragment.showStep(Step.CONFIRM);
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    deleteAccountFragment = (DeleteAccountFragment) deleteAccountFragment$performCancelCheckAndProceed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e2) {
                        e = e2;
                        FLogger.INSTANCE.w(TAG, "cancelCheck error: " + e.getMessage() + ", proceeding without cancel_ticket");
                        deleteAccountFragment.showStep(Step.CONFIRM);
                        return Unit.INSTANCE;
                    }
                }
                cancelCheckResponse = (CancelCheckResponse) obj;
                if (cancelCheckResponse.getErrorCode() == 0) {
                    FLogger.INSTANCE.w(TAG, "cancelCheck failed: " + cancelCheckResponse.getMessage() + ", proceeding without cancel_ticket");
                } else {
                    CancelCheckData data = cancelCheckResponse.getData();
                    deleteAccountFragment.cancelTicket = data != null ? data.getCancelTicket() : null;
                }
                deleteAccountFragment.showStep(Step.CONFIRM);
                return Unit.INSTANCE;
            }
        }
        deleteAccountFragment$performCancelCheckAndProceed$1 = new DeleteAccountFragment$performCancelCheckAndProceed$1(this, continuation);
        Object obj2 = deleteAccountFragment$performCancelCheckAndProceed$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = deleteAccountFragment$performCancelCheckAndProceed$1.label;
        if (i != 0) {
        }
        cancelCheckResponse = (CancelCheckResponse) obj2;
        if (cancelCheckResponse.getErrorCode() == 0) {
        }
        deleteAccountFragment.showStep(Step.CONFIRM);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFinalConfirmDialog() {
        CustomConfirmDialog delete;
        Context context = getContext();
        if (context == null) {
            return;
        }
        AuthType authType = this.authType;
        int i = authType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[authType.ordinal()];
        String str = "";
        if (i != -1) {
            EditText editText = null;
            if (i == 1) {
                EditText editText2 = this.etEmail;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etEmail");
                } else {
                    editText = editText2;
                }
                str = StringsKt.trim(editText.getText().toString()).toString();
            } else if (i == 2) {
                String str2 = this.userMobile;
                String maskPhone = str2 != null ? maskPhone(str2) : null;
                if (maskPhone != null) {
                    str = maskPhone;
                }
            } else {
                if (i != 3 && i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                String str3 = this.nickname;
                if (str3 != null) {
                    str = str3;
                }
            }
        }
        CustomConfirmDialog.Companion companion = CustomConfirmDialog.INSTANCE;
        String string = getString(C0820R.string.trae_delete_dialog_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0820R.string.trae_delete_dialog_message, new Object[]{str});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(C0820R.string.trae_setting_cancel);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(C0820R.string.trae_delete_confirm_delete);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        delete = companion.delete(context, string, string2, (r38 & 8) != 0 ? "" : string3, string4, (r38 & 32) != 0 ? null : null, (r38 & 64) != 0 ? null : null, (r38 & 128) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (r38 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : null, (r38 & 1024) != 0 ? null : null, (r38 & 2048) != 0 ? null : null, (r38 & 4096) != 0 ? null : null, (r38 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? 0 : 0, (r38 & 16384) != 0 ? C0591R.drawable.trae_bg_custom_dialog_btn_primary : 0, new Function0() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit showFinalConfirmDialog$lambda$14;
                showFinalConfirmDialog$lambda$14 = DeleteAccountFragment.showFinalConfirmDialog$lambda$14(DeleteAccountFragment.this);
                return showFinalConfirmDialog$lambda$14;
            }
        }, (r38 & 65536) != 0 ? new Function0() { // from class: com.bytedance.trae.common.widget.CustomConfirmDialog$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : null);
        delete.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showFinalConfirmDialog$lambda$14(DeleteAccountFragment deleteAccountFragment) {
        deleteAccountFragment.confirmDelete();
        return Unit.INSTANCE;
    }

    private final void confirmDelete() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$confirmDelete$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startFinishCountdown() {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 5;
        TextView textView = this.btnOkCountdown;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnOkCountdown");
            textView = null;
        }
        textView.setText(getString(C0820R.string.trae_delete_ok_countdown, new Object[]{Integer.valueOf(intRef.element)}));
        this.finishCountdownJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new DeleteAccountFragment$startFinishCountdown$1(intRef, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToLogin() {
        if (isAdded()) {
            DatabaseManager.INSTANCE.onUserLogout();
            ILoginService iLoginService = this.loginService;
            if (iLoginService != null) {
                iLoginService.logout(true, new IAccountCallback() { // from class: com.bytedance.trae.home.solo.setting.DeleteAccountFragment$navigateToLogin$1
                    public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
                    }

                    public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
                    }

                    public void onSuccess(LoginPlatform platform, String businessScene, Boolean isNewUserLogin) {
                    }
                }, "account_deleted");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a1, code lost:
    
        if (r15 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a4, code lost:
    
        r10 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b0, code lost:
    
        if (r15 == null) goto L57;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v73, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r15v8, types: [android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showStep(Step step) {
        String str;
        String maskPhone;
        this.currentStep = step;
        View view = this.stepEmailVerify;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepEmailVerify");
            view = null;
        }
        view.setVisibility(8);
        View view2 = this.stepSmsVerify;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepSmsVerify");
            view2 = null;
        }
        view2.setVisibility(8);
        View view3 = this.stepOauthVerify;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepOauthVerify");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.stepConfirm;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepConfirm");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = this.stepSubmitted;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepSubmitted");
            view5 = null;
        }
        view5.setVisibility(8);
        int i = WhenMappings.$EnumSwitchMapping$1[step.ordinal()];
        str = "";
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                ?? r15 = this.stepSubmitted;
                if (r15 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("stepSubmitted");
                } else {
                    textView = r15;
                }
                textView.setVisibility(0);
                return;
            }
            View view6 = this.stepConfirm;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stepConfirm");
                view6 = null;
            }
            view6.setVisibility(0);
            AuthType authType = this.authType;
            int i2 = authType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[authType.ordinal()];
            if (i2 != -1) {
                if (i2 == 1) {
                    EditText editText = this.etEmail;
                    if (editText == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("etEmail");
                        editText = null;
                    }
                    str = StringsKt.trim(editText.getText().toString()).toString();
                } else if (i2 == 2) {
                    String str2 = this.userMobile;
                    maskPhone = str2 != null ? maskPhone(str2) : null;
                } else {
                    if (i2 != 3 && i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    maskPhone = this.nickname;
                }
            }
            TextView textView2 = this.tvConfirmUserInfo;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvConfirmUserInfo");
            } else {
                textView = textView2;
            }
            textView.setText(str);
            return;
        }
        AuthType authType2 = this.authType;
        int i3 = authType2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[authType2.ordinal()];
        if (i3 == -1) {
            getParentFragmentManager().popBackStack();
            return;
        }
        if (i3 == 1) {
            ?? r152 = this.stepEmailVerify;
            if (r152 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("stepEmailVerify");
            } else {
                textView = r152;
            }
            textView.setVisibility(0);
            return;
        }
        if (i3 == 2) {
            View view7 = this.stepSmsVerify;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stepSmsVerify");
                view7 = null;
            }
            view7.setVisibility(0);
            String str3 = this.userMobile;
            String maskPhone2 = str3 != null ? maskPhone(str3) : null;
            str = maskPhone2 != null ? maskPhone2 : "";
            TextView textView3 = this.tvSmsVerifyHint;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvSmsVerifyHint");
            } else {
                textView = textView3;
            }
            textView.setText(getString(C0820R.string.trae_delete_sms_verify_hint, new Object[]{str}));
            return;
        }
        if (i3 == 3) {
            View view8 = this.stepOauthVerify;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stepOauthVerify");
                view8 = null;
            }
            view8.setVisibility(0);
            TextView textView4 = this.tvOauthNickname;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvOauthNickname");
                textView4 = null;
            }
            textView4.setText(this.nickname);
            TextView textView5 = this.tvOauthUnsupported;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvOauthUnsupported");
                textView5 = null;
            }
            textView5.setVisibility(8);
            TextView textView6 = this.btnGoogleVerify;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnGoogleVerify");
            } else {
                textView = textView6;
            }
            textView.setVisibility(0);
            return;
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        View view9 = this.stepOauthVerify;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stepOauthVerify");
            view9 = null;
        }
        view9.setVisibility(0);
        TextView textView7 = this.tvOauthNickname;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvOauthNickname");
            textView7 = null;
        }
        textView7.setText(this.nickname);
        TextView textView8 = this.tvOauthUnsupported;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvOauthUnsupported");
            textView8 = null;
        }
        textView8.setVisibility(0);
        TextView textView9 = this.tvOauthUnsupported;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvOauthUnsupported");
        } else {
            textView = textView9;
        }
        textView.setText(getString(C0820R.string.trae_delete_oauth_unsupported, new Object[]{"GitHub"}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading(boolean loading) {
        ProgressBar progressBar = this.progressLoading;
        ScrollView scrollView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressLoading");
            progressBar = null;
        }
        progressBar.setVisibility(loading ? 0 : 8);
        ScrollView scrollView2 = this.scrollContent;
        if (scrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollContent");
        } else {
            scrollView = scrollView2;
        }
        scrollView.setVisibility(loading ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showToast(String message) {
        if (isAdded()) {
            Toast.makeText(requireContext(), message, 0).show();
        }
    }

    private final String maskPhone(String phone) {
        if (phone.length() <= 4) {
            return phone;
        }
        String substring = phone.substring(0, (phone.length() - 4) - RangesKt.coerceAtMost(3, phone.length() - 4));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String takeLast = StringsKt.takeLast(phone, 4);
        return substring + StringsKt.repeat("*", (phone.length() - substring.length()) - takeLast.length()) + takeLast;
    }

    /* compiled from: DeleteAccountFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/bytedance/trae/home/solo/setting/DeleteAccountFragment;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteAccountFragment newInstance() {
            return new DeleteAccountFragment();
        }
    }
}

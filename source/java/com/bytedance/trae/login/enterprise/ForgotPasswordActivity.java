package com.bytedance.trae.login.enterprise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common_ui.R;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.login.widget.VerifyCodeInputView;
import com.bytedance.trae.multilanguage.C0882R;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: ForgotPasswordActivity.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 N2\u00020\u0001:\u0001NB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u000202H\u0014J\b\u00106\u001a\u000202H\u0002J\b\u00107\u001a\u000202H\u0002J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0002J\b\u0010:\u001a\u000202H\u0002J\b\u0010;\u001a\u000202H\u0002J\b\u0010<\u001a\u000202H\u0002J\b\u0010=\u001a\u000202H\u0002J\b\u0010>\u001a\u000202H\u0002J\b\u0010?\u001a\u000202H\u0002J\b\u0010@\u001a\u000202H\u0002J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\nH\u0002J\u0010\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020\u0005H\u0002J\b\u0010E\u001a\u000202H\u0002J\u0010\u0010F\u001a\u0002022\u0006\u0010B\u001a\u00020\nH\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010D\u001a\u00020\u0005H\u0002J\b\u0010H\u001a\u000202H\u0002J\u0010\u0010I\u001a\u0002022\u0006\u0010B\u001a\u00020\nH\u0002J\u0010\u0010J\u001a\u0002022\u0006\u0010D\u001a\u00020\u0005H\u0002J\b\u0010K\u001a\u000202H\u0002J\b\u0010L\u001a\u000202H\u0002J\b\u0010M\u001a\u000202H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "email", "", "verificationCode", "countDownTimer", "Landroid/os/CountDownTimer;", "isCountdownActive", "", "layoutStepSendCode", "Landroid/view/View;", "layoutEmailInputStep1", "etEmailStep1", "Landroid/widget/EditText;", "ivClearEmailStep1", "Landroid/widget/ImageView;", "btnSendCode", "Landroid/widget/Button;", "pbLoadingStep1", "Landroid/widget/ProgressBar;", "layoutErrorStep1", "tvErrorStep1", "Landroid/widget/TextView;", "layoutStepVerifyCode", "tvVerifyDesc", "verifyCodeInput", "Lcom/bytedance/trae/login/widget/VerifyCodeInputView;", "pbLoadingStep2", "layoutErrorStep2", "tvErrorStep2", "tvResendCode", "layoutStepNewPassword", "layoutNewPasswordInput", "layoutConfirmPasswordInput", "etNewPassword", "etConfirmPassword", "btnSetPassword", "pbLoadingStep3", "layoutErrorStep3", "tvErrorStep3", "ivToggleNewPassword", "ivToggleConfirmPassword", "layoutStepSuccess", "btnGoLogin", "isNewPasswordVisible", "isConfirmPasswordVisible", "isLoading", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "initViews", "setupListeners", "setupBackHandler", "startResendCountdown", "performSendCode", "performVerifyCode", "performSetPassword", "goToStep1", "goToStep2", "goToStep3", "goToStep4", "setStep1Loading", "loading", "showStep1Error", "message", "clearStep1Error", "setStep2Loading", "showStep2Error", "clearStep2Error", "setStep3Loading", "showStep3Error", "clearStep3Error", "updateSetPasswordButtonState", "finishWithEmail", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForgotPasswordActivity extends TraeCommonAppCompatActivity {
    private static final long COUNTDOWN_MILLIS = 60000;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMAIL = "extra_email";
    public static final String RESULT_EMAIL_KEY = "result_email";
    private static final String TAG = "ForgotPasswordActivity";
    private Button btnGoLogin;
    private Button btnSendCode;
    private Button btnSetPassword;
    private CountDownTimer countDownTimer;
    private String email;
    private EditText etConfirmPassword;
    private EditText etEmailStep1;
    private EditText etNewPassword;
    private boolean isConfirmPasswordVisible;
    private boolean isCountdownActive;
    private boolean isLoading;
    private boolean isNewPasswordVisible;
    private ImageView ivClearEmailStep1;
    private ImageView ivToggleConfirmPassword;
    private ImageView ivToggleNewPassword;
    private View layoutConfirmPasswordInput;
    private View layoutEmailInputStep1;
    private View layoutErrorStep1;
    private View layoutErrorStep2;
    private View layoutErrorStep3;
    private View layoutNewPasswordInput;
    private View layoutStepNewPassword;
    private View layoutStepSendCode;
    private View layoutStepSuccess;
    private View layoutStepVerifyCode;
    private ProgressBar pbLoadingStep1;
    private ProgressBar pbLoadingStep2;
    private ProgressBar pbLoadingStep3;
    private TextView tvErrorStep1;
    private TextView tvErrorStep2;
    private TextView tvErrorStep3;
    private TextView tvResendCode;
    private TextView tvVerifyDesc;
    private String verificationCode = "";
    private VerifyCodeInputView verifyCodeInput;

    /* renamed from: com_bytedance_trae_login_enterprise_ForgotPasswordActivity__onStop$___twin___ */
    public void m412x55ffe931() {
        super.onStop();
    }

    protected void onStop() {
        m411x75fa636a(this);
    }

    /* compiled from: ForgotPasswordActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/login/enterprise/ForgotPasswordActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_EMAIL", "RESULT_EMAIL_KEY", "COUNTDOWN_MILLIS", "", TraeAuthManager.STAGE_START, "", "context", "Landroid/content/Context;", "email", "createIntent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Context context, String email) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(email, "email");
            Intent intent = new Intent(context, (Class<?>) ForgotPasswordActivity.class);
            intent.putExtra(ForgotPasswordActivity.EXTRA_EMAIL, email);
            context.startActivity(intent);
        }

        public final Intent createIntent(Context context, String email) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(email, "email");
            Intent intent = new Intent(context, (Class<?>) ForgotPasswordActivity.class);
            intent.putExtra(ForgotPasswordActivity.EXTRA_EMAIL, email);
            return intent;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0820R.layout.trae_activity_forgot_password);
        String stringExtra = getIntent().getStringExtra(EXTRA_EMAIL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.email = stringExtra;
        if (stringExtra == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
            stringExtra = null;
        }
        if (stringExtra.length() == 0) {
            finish();
            return;
        }
        initViews();
        setupListeners();
        setupBackHandler();
    }

    protected void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private final void initViews() {
        View findViewById = findViewById(C0820R.id.layout_step_send_code);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.layoutStepSendCode = findViewById;
        View findViewById2 = findViewById(C0820R.id.layout_email_input_step1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.layoutEmailInputStep1 = findViewById2;
        View findViewById3 = findViewById(C0820R.id.et_email_step1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.etEmailStep1 = (EditText) findViewById3;
        View findViewById4 = findViewById(C0820R.id.iv_clear_email_step1);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.ivClearEmailStep1 = (ImageView) findViewById4;
        View findViewById5 = findViewById(C0820R.id.btn_send_code);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.btnSendCode = (Button) findViewById5;
        View findViewById6 = findViewById(C0820R.id.pb_loading_step1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.pbLoadingStep1 = (ProgressBar) findViewById6;
        View findViewById7 = findViewById(C0820R.id.layout_error_step1);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.layoutErrorStep1 = findViewById7;
        View findViewById8 = findViewById(C0820R.id.tv_error_step1);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.tvErrorStep1 = (TextView) findViewById8;
        EditText editText = this.etEmailStep1;
        VerifyCodeInputView verifyCodeInputView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            editText = null;
        }
        String str = this.email;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
            str = null;
        }
        editText.setText(str);
        View findViewById9 = findViewById(C0820R.id.layout_step_verify_code);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.layoutStepVerifyCode = findViewById9;
        View findViewById10 = findViewById(C0820R.id.tv_verify_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.tvVerifyDesc = (TextView) findViewById10;
        Object findViewById11 = findViewById(C0820R.id.verify_code_input);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        VerifyCodeInputView verifyCodeInputView2 = (VerifyCodeInputView) findViewById11;
        this.verifyCodeInput = verifyCodeInputView2;
        if (verifyCodeInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
        } else {
            verifyCodeInputView = verifyCodeInputView2;
        }
        verifyCodeInputView.setAlphanumeric(true);
        View findViewById12 = findViewById(C0820R.id.pb_loading_step2);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.pbLoadingStep2 = (ProgressBar) findViewById12;
        View findViewById13 = findViewById(C0820R.id.layout_error_step2);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.layoutErrorStep2 = findViewById13;
        View findViewById14 = findViewById(C0820R.id.tv_error_step2);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.tvErrorStep2 = (TextView) findViewById14;
        View findViewById15 = findViewById(C0820R.id.tv_resend_code);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.tvResendCode = (TextView) findViewById15;
        View findViewById16 = findViewById(C0820R.id.layout_step_new_password);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
        this.layoutStepNewPassword = findViewById16;
        View findViewById17 = findViewById(C0820R.id.layout_new_password_input);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
        this.layoutNewPasswordInput = findViewById17;
        View findViewById18 = findViewById(C0820R.id.layout_confirm_password_input);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(...)");
        this.layoutConfirmPasswordInput = findViewById18;
        View findViewById19 = findViewById(C0820R.id.et_new_password);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(...)");
        this.etNewPassword = (EditText) findViewById19;
        View findViewById20 = findViewById(C0820R.id.et_confirm_password);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(...)");
        this.etConfirmPassword = (EditText) findViewById20;
        View findViewById21 = findViewById(C0820R.id.btn_set_password);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "findViewById(...)");
        this.btnSetPassword = (Button) findViewById21;
        View findViewById22 = findViewById(C0820R.id.pb_loading_step3);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "findViewById(...)");
        this.pbLoadingStep3 = (ProgressBar) findViewById22;
        View findViewById23 = findViewById(C0820R.id.layout_error_step3);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "findViewById(...)");
        this.layoutErrorStep3 = findViewById23;
        View findViewById24 = findViewById(C0820R.id.tv_error_step3);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "findViewById(...)");
        this.tvErrorStep3 = (TextView) findViewById24;
        View findViewById25 = findViewById(C0820R.id.iv_toggle_new_password);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "findViewById(...)");
        this.ivToggleNewPassword = (ImageView) findViewById25;
        View findViewById26 = findViewById(C0820R.id.iv_toggle_confirm_password);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "findViewById(...)");
        this.ivToggleConfirmPassword = (ImageView) findViewById26;
        View findViewById27 = findViewById(C0820R.id.layout_step_success);
        Intrinsics.checkNotNullExpressionValue(findViewById27, "findViewById(...)");
        this.layoutStepSuccess = findViewById27;
        View findViewById28 = findViewById(C0820R.id.btn_go_login);
        Intrinsics.checkNotNullExpressionValue(findViewById28, "findViewById(...)");
        this.btnGoLogin = (Button) findViewById28;
    }

    private final void setupListeners() {
        findViewById(C0820R.id.btn_back_step1).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.this.finish();
            }
        });
        ImageView imageView = this.ivClearEmailStep1;
        Button button = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClearEmailStep1");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.setupListeners$lambda$1(ForgotPasswordActivity.this, view);
            }
        });
        Button button2 = this.btnSendCode;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.this.performSendCode();
            }
        });
        EditText editText = this.etEmailStep1;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$setupListeners$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                View view;
                view = ForgotPasswordActivity.this.layoutErrorStep1;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep1");
                    view = null;
                }
                if (view.getVisibility() == 0) {
                    ForgotPasswordActivity.this.clearStep1Error();
                }
            }
        });
        findViewById(C0820R.id.btn_back_step2).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.this.goToStep1();
            }
        });
        VerifyCodeInputView verifyCodeInputView = this.verifyCodeInput;
        if (verifyCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
            verifyCodeInputView = null;
        }
        verifyCodeInputView.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$setupListeners$6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                View view;
                boolean z;
                view = ForgotPasswordActivity.this.layoutErrorStep2;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep2");
                    view = null;
                }
                if (view.getVisibility() == 0) {
                    ForgotPasswordActivity.this.clearStep2Error();
                }
                boolean z2 = false;
                if (s != null && s.length() == 6) {
                    z2 = true;
                }
                if (z2) {
                    z = ForgotPasswordActivity.this.isLoading;
                    if (z) {
                        return;
                    }
                    ForgotPasswordActivity.this.performVerifyCode();
                }
            }
        });
        TextView textView = this.tvResendCode;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.setupListeners$lambda$4(ForgotPasswordActivity.this, view);
            }
        });
        findViewById(C0820R.id.btn_back_step3).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.this.goToStep2();
            }
        });
        TextWatcher textWatcher = new TextWatcher() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$setupListeners$passwordWatcher$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                View view;
                ForgotPasswordActivity.this.updateSetPasswordButtonState();
                view = ForgotPasswordActivity.this.layoutErrorStep3;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep3");
                    view = null;
                }
                if (view.getVisibility() == 0) {
                    ForgotPasswordActivity.this.clearStep3Error();
                }
            }
        };
        EditText editText2 = this.etNewPassword;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
            editText2 = null;
        }
        TextWatcher textWatcher2 = textWatcher;
        editText2.addTextChangedListener(textWatcher2);
        EditText editText3 = this.etConfirmPassword;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
            editText3 = null;
        }
        editText3.addTextChangedListener(textWatcher2);
        Button button3 = this.btnSetPassword;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSetPassword");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.this.performSetPassword();
            }
        });
        ImageView imageView2 = this.ivToggleNewPassword;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivToggleNewPassword");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.setupListeners$lambda$7(ForgotPasswordActivity.this, view);
            }
        });
        ImageView imageView3 = this.ivToggleConfirmPassword;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivToggleConfirmPassword");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.setupListeners$lambda$8(ForgotPasswordActivity.this, view);
            }
        });
        findViewById(C0820R.id.btn_back_step4).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.this.finishWithEmail();
            }
        });
        Button button4 = this.btnGoLogin;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnGoLogin");
        } else {
            button = button4;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ForgotPasswordActivity.this.finishWithEmail();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$1(ForgotPasswordActivity forgotPasswordActivity, View view) {
        EditText editText = forgotPasswordActivity.etEmailStep1;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            editText = null;
        }
        editText.getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$4(ForgotPasswordActivity forgotPasswordActivity, View view) {
        TextView textView = forgotPasswordActivity.tvResendCode;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
            textView = null;
        }
        if (textView.isEnabled()) {
            forgotPasswordActivity.performSendCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$7(ForgotPasswordActivity forgotPasswordActivity, View view) {
        boolean z = !forgotPasswordActivity.isNewPasswordVisible;
        forgotPasswordActivity.isNewPasswordVisible = z;
        EditText editText = null;
        if (z) {
            EditText editText2 = forgotPasswordActivity.etNewPassword;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
                editText2 = null;
            }
            editText2.setInputType(145);
            ImageView imageView = forgotPasswordActivity.ivToggleNewPassword;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToggleNewPassword");
                imageView = null;
            }
            imageView.setImageResource(C0820R.drawable.trae_ic_eye_open);
        } else {
            EditText editText3 = forgotPasswordActivity.etNewPassword;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
                editText3 = null;
            }
            editText3.setInputType(129);
            ImageView imageView2 = forgotPasswordActivity.ivToggleNewPassword;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToggleNewPassword");
                imageView2 = null;
            }
            imageView2.setImageResource(C0820R.drawable.trae_ic_eye_slash);
        }
        EditText editText4 = forgotPasswordActivity.etNewPassword;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
            editText4 = null;
        }
        EditText editText5 = forgotPasswordActivity.etNewPassword;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
        } else {
            editText = editText5;
        }
        editText4.setSelection(editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$8(ForgotPasswordActivity forgotPasswordActivity, View view) {
        boolean z = !forgotPasswordActivity.isConfirmPasswordVisible;
        forgotPasswordActivity.isConfirmPasswordVisible = z;
        EditText editText = null;
        if (z) {
            EditText editText2 = forgotPasswordActivity.etConfirmPassword;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
                editText2 = null;
            }
            editText2.setInputType(145);
            ImageView imageView = forgotPasswordActivity.ivToggleConfirmPassword;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToggleConfirmPassword");
                imageView = null;
            }
            imageView.setImageResource(C0820R.drawable.trae_ic_eye_open);
        } else {
            EditText editText3 = forgotPasswordActivity.etConfirmPassword;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
                editText3 = null;
            }
            editText3.setInputType(129);
            ImageView imageView2 = forgotPasswordActivity.ivToggleConfirmPassword;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToggleConfirmPassword");
                imageView2 = null;
            }
            imageView2.setImageResource(C0820R.drawable.trae_ic_eye_slash);
        }
        EditText editText4 = forgotPasswordActivity.etConfirmPassword;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
            editText4 = null;
        }
        EditText editText5 = forgotPasswordActivity.etConfirmPassword;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
        } else {
            editText = editText5;
        }
        editText4.setSelection(editText.getText().length());
    }

    private final void setupBackHandler() {
        getOnBackPressedDispatcher().addCallback((LifecycleOwner) this, new OnBackPressedCallback() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$setupBackHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            public void handleOnBackPressed() {
                View view;
                view = ForgotPasswordActivity.this.layoutStepSuccess;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutStepSuccess");
                    view = null;
                }
                if (view.getVisibility() == 0) {
                    ForgotPasswordActivity.this.finishWithEmail();
                } else {
                    ForgotPasswordActivity.this.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.trae.login.enterprise.ForgotPasswordActivity$startResendCountdown$1] */
    public final void startResendCountdown() {
        TextView textView = this.tvResendCode;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
            textView = null;
        }
        textView.setEnabled(false);
        this.isCountdownActive = true;
        TextView textView3 = this.tvResendCode;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
            textView3 = null;
        }
        TextView textView4 = this.tvResendCode;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
        } else {
            textView2 = textView4;
        }
        textView3.setPaintFlags(textView2.getPaintFlags() & (-9));
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = new CountDownTimer() { // from class: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$startResendCountdown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TextView textView5;
                TextView textView6;
                long j = millisUntilFinished / BytePatchException.ErrorCode.paramsError;
                textView5 = ForgotPasswordActivity.this.tvResendCode;
                TextView textView7 = null;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
                    textView5 = null;
                }
                textView5.setText(ForgotPasswordActivity.this.getString(C0882R.string.trae_forgot_password_resend_countdown, new Object[]{Long.valueOf(j)}));
                textView6 = ForgotPasswordActivity.this.tvResendCode;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
                } else {
                    textView7 = textView6;
                }
                textView7.setTextColor(ForgotPasswordActivity.this.getColor(R.color.trae_text_text_disabled));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TextView textView5;
                TextView textView6;
                TextView textView7;
                TextView textView8;
                TextView textView9;
                ForgotPasswordActivity.this.isCountdownActive = false;
                textView5 = ForgotPasswordActivity.this.tvResendCode;
                TextView textView10 = null;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
                    textView5 = null;
                }
                textView5.setEnabled(true);
                textView6 = ForgotPasswordActivity.this.tvResendCode;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
                    textView6 = null;
                }
                textView6.setText(ForgotPasswordActivity.this.getString(C0882R.string.trae_forgot_password_resend_code));
                textView7 = ForgotPasswordActivity.this.tvResendCode;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
                    textView7 = null;
                }
                textView7.setTextColor(ForgotPasswordActivity.this.getColor(R.color.trae_text_text_default));
                textView8 = ForgotPasswordActivity.this.tvResendCode;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
                    textView8 = null;
                }
                textView9 = ForgotPasswordActivity.this.tvResendCode;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
                } else {
                    textView10 = textView9;
                }
                textView8.setPaintFlags(textView10.getPaintFlags() | 8);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performSendCode() {
        EditText editText = this.etEmailStep1;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            editText = null;
        }
        String obj = StringsKt.trim(editText.getText().toString()).toString();
        this.email = obj;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
            obj = null;
        }
        if (obj.length() == 0) {
            return;
        }
        setStep1Loading(true);
        clearStep1Error();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ForgotPasswordActivity$performSendCode$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performVerifyCode() {
        VerifyCodeInputView verifyCodeInputView = this.verifyCodeInput;
        if (verifyCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
            verifyCodeInputView = null;
        }
        String obj = StringsKt.trim(String.valueOf(verifyCodeInputView.getText())).toString();
        if (obj.length() != 6) {
            return;
        }
        setStep2Loading(true);
        clearStep2Error();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ForgotPasswordActivity$performVerifyCode$1(this, obj, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performSetPassword() {
        EditText editText = this.etNewPassword;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
            editText = null;
        }
        String obj = editText.getText().toString();
        EditText editText2 = this.etConfirmPassword;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
            editText2 = null;
        }
        if (!Intrinsics.areEqual(obj, editText2.getText().toString())) {
            String string = getString(C0882R.string.trae_forgot_password_mismatch);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showStep3Error(string);
        } else {
            setStep3Loading(true);
            clearStep3Error();
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new ForgotPasswordActivity$performSetPassword$1(this, obj, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToStep1() {
        View view = this.layoutStepVerifyCode;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepVerifyCode");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.layoutStepNewPassword;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepNewPassword");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.layoutStepSuccess;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepSuccess");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = this.layoutStepSendCode;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepSendCode");
        } else {
            view2 = view5;
        }
        view2.setVisibility(0);
        setStep1Loading(false);
        clearStep1Error();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToStep2() {
        View view = this.layoutStepSendCode;
        VerifyCodeInputView verifyCodeInputView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepSendCode");
            view = null;
        }
        view.setVisibility(8);
        View view2 = this.layoutStepNewPassword;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepNewPassword");
            view2 = null;
        }
        view2.setVisibility(8);
        View view3 = this.layoutStepSuccess;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepSuccess");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.layoutStepVerifyCode;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepVerifyCode");
            view4 = null;
        }
        view4.setVisibility(0);
        TextView textView = this.tvVerifyDesc;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvVerifyDesc");
            textView = null;
        }
        String str = this.email;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
            str = null;
        }
        textView.setText(str);
        setStep2Loading(false);
        clearStep2Error();
        VerifyCodeInputView verifyCodeInputView2 = this.verifyCodeInput;
        if (verifyCodeInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
            verifyCodeInputView2 = null;
        }
        Editable text = verifyCodeInputView2.getText();
        if (text != null) {
            text.clear();
        }
        VerifyCodeInputView verifyCodeInputView3 = this.verifyCodeInput;
        if (verifyCodeInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
        } else {
            verifyCodeInputView = verifyCodeInputView3;
        }
        verifyCodeInputView.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToStep3() {
        View view = this.layoutStepSendCode;
        EditText editText = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepSendCode");
            view = null;
        }
        view.setVisibility(8);
        View view2 = this.layoutStepVerifyCode;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepVerifyCode");
            view2 = null;
        }
        view2.setVisibility(8);
        View view3 = this.layoutStepNewPassword;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepNewPassword");
            view3 = null;
        }
        view3.setVisibility(0);
        View view4 = this.layoutStepSuccess;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepSuccess");
            view4 = null;
        }
        view4.setVisibility(8);
        setStep3Loading(false);
        TextView textView = this.tvErrorStep3;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvErrorStep3");
            textView = null;
        }
        textView.setVisibility(8);
        EditText editText2 = this.etNewPassword;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
            editText2 = null;
        }
        editText2.getText().clear();
        EditText editText3 = this.etConfirmPassword;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
            editText3 = null;
        }
        editText3.getText().clear();
        EditText editText4 = this.etNewPassword;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
        } else {
            editText = editText4;
        }
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToStep4() {
        View view = this.layoutStepSendCode;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepSendCode");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.layoutStepVerifyCode;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepVerifyCode");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.layoutStepNewPassword;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepNewPassword");
            view4 = null;
        }
        view4.setVisibility(8);
        View view5 = this.layoutStepSuccess;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepSuccess");
        } else {
            view2 = view5;
        }
        view2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStep1Loading(boolean loading) {
        String string;
        this.isLoading = loading;
        ProgressBar progressBar = this.pbLoadingStep1;
        Button button = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbLoadingStep1");
            progressBar = null;
        }
        progressBar.setVisibility(loading ? 0 : 8);
        Button button2 = this.btnSendCode;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
            button2 = null;
        }
        if (loading) {
            string = "";
        } else {
            string = getString(C0882R.string.trae_forgot_password_send_code);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        button2.setText(string);
        Button button3 = this.btnSendCode;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
        } else {
            button = button3;
        }
        button.setEnabled(!loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStep1Error(String message) {
        TextView textView = this.tvErrorStep1;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvErrorStep1");
            textView = null;
        }
        textView.setText(message);
        View view2 = this.layoutErrorStep1;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep1");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.layoutEmailInputStep1;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutEmailInputStep1");
        } else {
            view = view3;
        }
        view.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearStep1Error() {
        View view = this.layoutErrorStep1;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep1");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.layoutEmailInputStep1;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutEmailInputStep1");
        } else {
            view2 = view3;
        }
        view2.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_new);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStep2Loading(boolean loading) {
        this.isLoading = loading;
        ProgressBar progressBar = this.pbLoadingStep2;
        TextView textView = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbLoadingStep2");
            progressBar = null;
        }
        boolean z = false;
        progressBar.setVisibility(loading ? 0 : 8);
        VerifyCodeInputView verifyCodeInputView = this.verifyCodeInput;
        if (verifyCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
            verifyCodeInputView = null;
        }
        verifyCodeInputView.setEnabled(!loading);
        TextView textView2 = this.tvResendCode;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendCode");
        } else {
            textView = textView2;
        }
        if (!loading && !this.isCountdownActive) {
            z = true;
        }
        textView.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStep2Error(String message) {
        TextView textView = this.tvErrorStep2;
        VerifyCodeInputView verifyCodeInputView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvErrorStep2");
            textView = null;
        }
        textView.setText(message);
        View view = this.layoutErrorStep2;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep2");
            view = null;
        }
        view.setVisibility(0);
        VerifyCodeInputView verifyCodeInputView2 = this.verifyCodeInput;
        if (verifyCodeInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
        } else {
            verifyCodeInputView = verifyCodeInputView2;
        }
        verifyCodeInputView.setError(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearStep2Error() {
        View view = this.layoutErrorStep2;
        VerifyCodeInputView verifyCodeInputView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep2");
            view = null;
        }
        view.setVisibility(8);
        VerifyCodeInputView verifyCodeInputView2 = this.verifyCodeInput;
        if (verifyCodeInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
        } else {
            verifyCodeInputView = verifyCodeInputView2;
        }
        verifyCodeInputView.setError(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStep3Loading(boolean loading) {
        String string;
        this.isLoading = loading;
        ProgressBar progressBar = this.pbLoadingStep3;
        EditText editText = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbLoadingStep3");
            progressBar = null;
        }
        progressBar.setVisibility(loading ? 0 : 8);
        Button button = this.btnSetPassword;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSetPassword");
            button = null;
        }
        if (loading) {
            string = "";
        } else {
            string = getString(C0882R.string.trae_forgot_password_set_password_btn);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        button.setText(string);
        Button button2 = this.btnSetPassword;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSetPassword");
            button2 = null;
        }
        button2.setEnabled(!loading);
        EditText editText2 = this.etNewPassword;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
            editText2 = null;
        }
        editText2.setEnabled(!loading);
        EditText editText3 = this.etConfirmPassword;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
        } else {
            editText = editText3;
        }
        editText.setEnabled(!loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStep3Error(String message) {
        TextView textView = this.tvErrorStep3;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvErrorStep3");
            textView = null;
        }
        textView.setText(message);
        View view2 = this.layoutErrorStep3;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep3");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.layoutNewPasswordInput;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutNewPasswordInput");
            view3 = null;
        }
        view3.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_error);
        View view4 = this.layoutConfirmPasswordInput;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutConfirmPasswordInput");
        } else {
            view = view4;
        }
        view.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearStep3Error() {
        View view = this.layoutErrorStep3;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorStep3");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.layoutNewPasswordInput;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutNewPasswordInput");
            view3 = null;
        }
        view3.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_new);
        View view4 = this.layoutConfirmPasswordInput;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutConfirmPasswordInput");
        } else {
            view2 = view4;
        }
        view2.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_new);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
    
        if (r5.isLoading == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateSetPasswordButtonState() {
        EditText editText = this.etNewPassword;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etNewPassword");
            editText = null;
        }
        String obj = editText.getText().toString();
        EditText editText2 = this.etConfirmPassword;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etConfirmPassword");
            editText2 = null;
        }
        String obj2 = editText2.getText().toString();
        Button button2 = this.btnSetPassword;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSetPassword");
        } else {
            button = button2;
        }
        boolean z = true;
        if (obj.length() > 0) {
            if (obj2.length() > 0) {
            }
        }
        z = false;
        button.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishWithEmail() {
        Intent intent = new Intent();
        String str = this.email;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("email");
            str = null;
        }
        setResult(-1, intent.putExtra(RESULT_EMAIL_KEY, str));
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_enterprise_ForgotPasswordActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m411x75fa636a(ForgotPasswordActivity forgotPasswordActivity) {
        forgotPasswordActivity.m412x55ffe931();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) forgotPasswordActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}

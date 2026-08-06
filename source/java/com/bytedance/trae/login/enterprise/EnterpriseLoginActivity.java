package com.bytedance.trae.login.enterprise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.enterprise.EnterpriseAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: EnterpriseLoginActivity.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020,H\u0002J\b\u00101\u001a\u00020,H\u0002J\b\u00102\u001a\u00020,H\u0002J\u0018\u00103\u001a\u00020,2\u0006\u00104\u001a\u00020%2\u0006\u00105\u001a\u000206H\u0002J\u0018\u00107\u001a\u00020,2\u0006\u00104\u001a\u00020%2\u0006\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020,H\u0002J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020%H\u0002J\u0010\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020!H\u0002J\b\u0010>\u001a\u00020,H\u0002J\b\u0010?\u001a\u00020,H\u0002J\u0010\u0010@\u001a\u00020,2\u0006\u0010=\u001a\u00020!H\u0002J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020%H\u0002J\b\u0010C\u001a\u00020,H\u0002J\u0010\u0010D\u001a\u00020,2\u0006\u0010B\u001a\u00020%H\u0002J\b\u0010E\u001a\u00020,H\u0002J\b\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020,H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseLoginActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "layoutStepEmail", "Landroid/view/View;", "layoutEmailInput", "etEmailStep1", "Landroid/widget/EditText;", "ivClearEmail", "Landroid/widget/ImageView;", "btnContinue", "Landroid/widget/Button;", "pbLoadingEmail", "Landroid/widget/ProgressBar;", "layoutErrorEmail", "tvErrorEmail", "Landroid/widget/TextView;", "layoutStepPassword", "layoutPasswordInput", "tvStep2Title", "tvEmailDisplay", "etPassword", "btnLogin", "pbLoading", "layoutErrorPassword", "tvError", "ivTogglePassword", "ivClearPassword", "btnSsoLogin", "layoutOrDivider", "tvForgotPassword", "isPasswordVisible", "", "isLoading", "loginSuccess", "ssoAuthUrl", "", "currentEmail", "forgotPasswordLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "setupStep1Listeners", "setupStep2Listeners", "performCheckLoginConfig", "handleCheckLoginConfigResult", "email", "result", "Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;", "showPasswordStep", "showSsoEntry", "goBackToStep1", "openSsoUrl", "url", "setEmailStepLoading", "loading", "updateLoginButtonState", "performLogin", "setLoginLoading", "showError", "message", "clearPasswordError", "showEmailError", "clearEmailError", "navigateToMain", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseLoginActivity extends TraeCommonAppCompatActivity {
    private static final String MAIN_ACTIVITY_CLASS = "com.bytedance.trae.home.MainActivity";
    private static final String TAG = "EnterpriseLoginActivity";
    private Button btnContinue;
    private Button btnLogin;
    private View btnSsoLogin;
    private String currentEmail = "";
    private EditText etEmailStep1;
    private EditText etPassword;
    private final ActivityResultLauncher<Intent> forgotPasswordLauncher;
    private boolean isLoading;
    private boolean isPasswordVisible;
    private ImageView ivClearEmail;
    private ImageView ivClearPassword;
    private ImageView ivTogglePassword;
    private View layoutEmailInput;
    private View layoutErrorEmail;
    private View layoutErrorPassword;
    private View layoutOrDivider;
    private View layoutPasswordInput;
    private View layoutStepEmail;
    private View layoutStepPassword;
    private boolean loginSuccess;
    private ProgressBar pbLoading;
    private ProgressBar pbLoadingEmail;
    private String ssoAuthUrl;
    private TextView tvEmailDisplay;
    private TextView tvError;
    private TextView tvErrorEmail;
    private TextView tvForgotPassword;
    private TextView tvStep2Title;

    /* renamed from: com_bytedance_trae_login_enterprise_EnterpriseLoginActivity__onStop$___twin___ */
    public void m408xd5ae53a1() {
        super.onStop();
    }

    protected void onStop() {
        m407x940abefa(this);
    }

    public EnterpriseLoginActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda6
            public final void onActivityResult(Object obj) {
                EnterpriseLoginActivity.forgotPasswordLauncher$lambda$0(EnterpriseLoginActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.forgotPasswordLauncher = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forgotPasswordLauncher$lambda$0(EnterpriseLoginActivity enterpriseLoginActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            EditText editText = null;
            String stringExtra = data != null ? data.getStringExtra(ForgotPasswordActivity.RESULT_EMAIL_KEY) : null;
            String str = stringExtra;
            if (str == null || str.length() == 0) {
                return;
            }
            enterpriseLoginActivity.currentEmail = stringExtra;
            EditText editText2 = enterpriseLoginActivity.etEmailStep1;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            } else {
                editText = editText2;
            }
            editText.setText(str);
            enterpriseLoginActivity.goBackToStep1();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0820R.layout.trae_activity_enterprise_login);
        initViews();
        setupStep1Listeners();
        setupStep2Listeners();
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_PAGE_SHOWN, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
        EditText editText = this.etEmailStep1;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            editText = null;
        }
        editText.requestFocus();
        getWindow().setSoftInputMode(4);
    }

    private final void initViews() {
        View findViewById = findViewById(C0820R.id.layout_step_email);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.layoutStepEmail = findViewById;
        View findViewById2 = findViewById(C0820R.id.layout_email_input);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.layoutEmailInput = findViewById2;
        View findViewById3 = findViewById(C0820R.id.et_email_step1);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.etEmailStep1 = (EditText) findViewById3;
        View findViewById4 = findViewById(C0820R.id.iv_clear_email);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.ivClearEmail = (ImageView) findViewById4;
        View findViewById5 = findViewById(C0820R.id.btn_continue);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.btnContinue = (Button) findViewById5;
        View findViewById6 = findViewById(C0820R.id.pb_loading_email);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.pbLoadingEmail = (ProgressBar) findViewById6;
        View findViewById7 = findViewById(C0820R.id.layout_error_email);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.layoutErrorEmail = findViewById7;
        View findViewById8 = findViewById(C0820R.id.tv_error_email);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.tvErrorEmail = (TextView) findViewById8;
        findViewById(C0820R.id.btn_back).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterpriseLoginActivity.this.finish();
            }
        });
        View findViewById9 = findViewById(C0820R.id.layout_step_password);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.layoutStepPassword = findViewById9;
        View findViewById10 = findViewById(C0820R.id.layout_password_input);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.layoutPasswordInput = findViewById10;
        View findViewById11 = findViewById(C0820R.id.tv_step2_title);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.tvStep2Title = (TextView) findViewById11;
        View findViewById12 = findViewById(C0820R.id.tv_email_display);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.tvEmailDisplay = (TextView) findViewById12;
        View findViewById13 = findViewById(C0820R.id.et_password);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.etPassword = (EditText) findViewById13;
        View findViewById14 = findViewById(C0820R.id.btn_login);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.btnLogin = (Button) findViewById14;
        View findViewById15 = findViewById(C0820R.id.pb_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.pbLoading = (ProgressBar) findViewById15;
        View findViewById16 = findViewById(C0820R.id.layout_error_password);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
        this.layoutErrorPassword = findViewById16;
        View findViewById17 = findViewById(C0820R.id.tv_error);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
        this.tvError = (TextView) findViewById17;
        View findViewById18 = findViewById(C0820R.id.iv_toggle_password);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(...)");
        this.ivTogglePassword = (ImageView) findViewById18;
        View findViewById19 = findViewById(C0820R.id.iv_clear_password);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(...)");
        this.ivClearPassword = (ImageView) findViewById19;
        View findViewById20 = findViewById(C0820R.id.btn_sso_login);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(...)");
        this.btnSsoLogin = findViewById20;
        View findViewById21 = findViewById(C0820R.id.layout_or_divider);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "findViewById(...)");
        this.layoutOrDivider = findViewById21;
        View findViewById22 = findViewById(C0820R.id.tv_forgot_password);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "findViewById(...)");
        TextView textView = (TextView) findViewById22;
        this.tvForgotPassword = textView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvForgotPassword");
            textView = null;
        }
        TextView textView3 = this.tvForgotPassword;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvForgotPassword");
        } else {
            textView2 = textView3;
        }
        textView.setPaintFlags(textView2.getPaintFlags() | 8);
        findViewById(C0820R.id.btn_back_password).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterpriseLoginActivity.this.goBackToStep1();
            }
        });
    }

    private final void setupStep1Listeners() {
        EditText editText = this.etEmailStep1;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$setupStep1Listeners$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
            
                if (r4 == false) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void afterTextChanged(Editable s) {
                boolean z;
                Button button2;
                ImageView imageView;
                boolean z2;
                String obj;
                String obj2;
                boolean z3 = true;
                if (s != null && (obj = s.toString()) != null && (obj2 = StringsKt.trim(obj).toString()) != null) {
                    if (obj2.length() > 0) {
                        z = true;
                        button2 = EnterpriseLoginActivity.this.btnContinue;
                        ImageView imageView2 = null;
                        if (button2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
                            button2 = null;
                        }
                        if (z) {
                            z2 = EnterpriseLoginActivity.this.isLoading;
                        }
                        z3 = false;
                        button2.setEnabled(z3);
                        imageView = EnterpriseLoginActivity.this.ivClearEmail;
                        if (imageView != null) {
                            Intrinsics.throwUninitializedPropertyAccessException("ivClearEmail");
                        } else {
                            imageView2 = imageView;
                        }
                        imageView2.setVisibility(z ? 0 : 8);
                        EnterpriseLoginActivity.this.clearEmailError();
                    }
                }
                z = false;
                button2 = EnterpriseLoginActivity.this.btnContinue;
                ImageView imageView22 = null;
                if (button2 == null) {
                }
                if (z) {
                }
                z3 = false;
                button2.setEnabled(z3);
                imageView = EnterpriseLoginActivity.this.ivClearEmail;
                if (imageView != null) {
                }
                imageView22.setVisibility(z ? 0 : 8);
                EnterpriseLoginActivity.this.clearEmailError();
            }
        });
        ImageView imageView = this.ivClearEmail;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClearEmail");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterpriseLoginActivity.setupStep1Listeners$lambda$3(EnterpriseLoginActivity.this, view);
            }
        });
        Button button2 = this.btnContinue;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
        } else {
            button = button2;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterpriseLoginActivity.this.performCheckLoginConfig();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupStep1Listeners$lambda$3(EnterpriseLoginActivity enterpriseLoginActivity, View view) {
        EditText editText = enterpriseLoginActivity.etEmailStep1;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            editText = null;
        }
        editText.getText().clear();
    }

    private final void setupStep2Listeners() {
        EditText editText = this.etPassword;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$setupStep2Listeners$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
            
                if ((r4.length() > 0) == true) goto L14;
             */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void afterTextChanged(Editable s) {
                ImageView imageView;
                boolean z;
                EnterpriseLoginActivity.this.updateLoginButtonState();
                imageView = EnterpriseLoginActivity.this.ivClearPassword;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivClearPassword");
                    imageView = null;
                }
                if (s != null) {
                    z = true;
                }
                z = false;
                imageView.setVisibility(z ? 0 : 8);
                EnterpriseLoginActivity.this.clearPasswordError();
            }
        });
        ImageView imageView = this.ivClearPassword;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClearPassword");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterpriseLoginActivity.setupStep2Listeners$lambda$5(EnterpriseLoginActivity.this, view);
            }
        });
        ImageView imageView2 = this.ivTogglePassword;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivTogglePassword");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterpriseLoginActivity.setupStep2Listeners$lambda$6(EnterpriseLoginActivity.this, view);
            }
        });
        Button button = this.btnLogin;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLogin");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EnterpriseLoginActivity.this.performLogin();
            }
        });
        View view = this.btnSsoLogin;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSsoLogin");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EnterpriseLoginActivity.setupStep2Listeners$lambda$9(EnterpriseLoginActivity.this, view2);
            }
        });
        TextView textView2 = this.tvForgotPassword;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvForgotPassword");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EnterpriseLoginActivity.setupStep2Listeners$lambda$10(EnterpriseLoginActivity.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupStep2Listeners$lambda$5(EnterpriseLoginActivity enterpriseLoginActivity, View view) {
        EditText editText = enterpriseLoginActivity.etPassword;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
            editText = null;
        }
        editText.getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupStep2Listeners$lambda$6(EnterpriseLoginActivity enterpriseLoginActivity, View view) {
        boolean z = !enterpriseLoginActivity.isPasswordVisible;
        enterpriseLoginActivity.isPasswordVisible = z;
        EditText editText = null;
        if (z) {
            EditText editText2 = enterpriseLoginActivity.etPassword;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etPassword");
                editText2 = null;
            }
            editText2.setInputType(145);
            ImageView imageView = enterpriseLoginActivity.ivTogglePassword;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivTogglePassword");
                imageView = null;
            }
            imageView.setImageResource(C0820R.drawable.trae_ic_eye_open);
        } else {
            EditText editText3 = enterpriseLoginActivity.etPassword;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etPassword");
                editText3 = null;
            }
            editText3.setInputType(129);
            ImageView imageView2 = enterpriseLoginActivity.ivTogglePassword;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivTogglePassword");
                imageView2 = null;
            }
            imageView2.setImageResource(C0820R.drawable.trae_ic_eye_slash);
        }
        EditText editText4 = enterpriseLoginActivity.etPassword;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
            editText4 = null;
        }
        EditText editText5 = enterpriseLoginActivity.etPassword;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
        } else {
            editText = editText5;
        }
        editText4.setSelection(editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupStep2Listeners$lambda$9(EnterpriseLoginActivity enterpriseLoginActivity, View view) {
        String str = enterpriseLoginActivity.ssoAuthUrl;
        if (str != null) {
            enterpriseLoginActivity.openSsoUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setupStep2Listeners$lambda$10(EnterpriseLoginActivity enterpriseLoginActivity, View view) {
        if (enterpriseLoginActivity.currentEmail.length() > 0) {
            enterpriseLoginActivity.forgotPasswordLauncher.launch(ForgotPasswordActivity.INSTANCE.createIntent((Context) enterpriseLoginActivity, enterpriseLoginActivity.currentEmail));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performCheckLoginConfig() {
        EditText editText = this.etEmailStep1;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
            editText = null;
        }
        String obj = StringsKt.trim(editText.getText().toString()).toString();
        String str = obj;
        if (str.length() == 0) {
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            String string = getString(C0882R.string.trae_enterprise_login_email_invalid);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showEmailError(string);
        } else {
            setEmailStepLoading(true);
            clearEmailError();
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_EMAIL_SUBMITTED, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new EnterpriseLoginActivity$performCheckLoginConfig$1(this, obj, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCheckLoginConfigResult(String email, CheckLoginConfigResult result) {
        String str;
        setEmailStepLoading(false);
        if (result.isDefaultDomainLoginBlocked()) {
            str = "blocked";
        } else {
            str = result.isSsoLoginRequired() ? "sso_required" : "password";
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_CHECK_CONFIG_RESULT, "enterprise", null, null, null, null, null, null, null, str, null, 1532, null);
        if (result.isDefaultDomainLoginBlocked()) {
            String string = getString(C0882R.string.trae_enterprise_login_blocked_domain);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            showEmailError(string);
            return;
        }
        if (result.isSsoLoginRequired()) {
            this.currentEmail = email;
            if (result.isEnableSso()) {
                String ssoAuthUrl = result.getSsoAuthUrl();
                if (!(ssoAuthUrl == null || ssoAuthUrl.length() == 0)) {
                    openSsoUrl(result.getSsoAuthUrl());
                    return;
                }
            }
            String string2 = getString(C0882R.string.trae_enterprise_login_service_error);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            showEmailError(string2);
            return;
        }
        this.ssoAuthUrl = result.getSsoAuthUrl();
        if (result.isEnableSso()) {
            String ssoAuthUrl2 = result.getSsoAuthUrl();
            if (!(ssoAuthUrl2 == null || ssoAuthUrl2.length() == 0)) {
                r2 = true;
            }
        }
        showPasswordStep(email, r2);
    }

    private final void showPasswordStep(String email, boolean showSsoEntry) {
        this.currentEmail = email;
        View view = this.layoutStepEmail;
        EditText editText = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepEmail");
            view = null;
        }
        view.setVisibility(8);
        View view2 = this.layoutStepPassword;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepPassword");
            view2 = null;
        }
        view2.setVisibility(0);
        TextView textView = this.tvEmailDisplay;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvEmailDisplay");
            textView = null;
        }
        textView.setText(email);
        float f = getResources().getDisplayMetrics().density;
        if (showSsoEntry) {
            TextView textView2 = this.tvStep2Title;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvStep2Title");
                textView2 = null;
            }
            textView2.setText(getString(C0882R.string.trae_enterprise_login_choose_method));
            View view3 = this.btnSsoLogin;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnSsoLogin");
                view3 = null;
            }
            view3.setVisibility(0);
            View view4 = this.layoutOrDivider;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutOrDivider");
                view4 = null;
            }
            view4.setVisibility(0);
            TextView textView3 = this.tvStep2Title;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvStep2Title");
                textView3 = null;
            }
            ViewGroup.LayoutParams layoutParams = textView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) (40 * f);
            View view5 = this.layoutPasswordInput;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutPasswordInput");
                view5 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = view5.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).topMargin = (int) (14 * f);
        } else {
            TextView textView4 = this.tvStep2Title;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvStep2Title");
                textView4 = null;
            }
            textView4.setText(getString(C0882R.string.trae_enterprise_login_subtitle_password));
            View view6 = this.btnSsoLogin;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnSsoLogin");
                view6 = null;
            }
            view6.setVisibility(8);
            View view7 = this.layoutOrDivider;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutOrDivider");
                view7 = null;
            }
            view7.setVisibility(8);
            TextView textView5 = this.tvStep2Title;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvStep2Title");
                textView5 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = textView5.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams3).topMargin = (int) (80 * f);
            View view8 = this.layoutPasswordInput;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutPasswordInput");
                view8 = null;
            }
            ViewGroup.LayoutParams layoutParams4 = view8.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams4).topMargin = (int) (24 * f);
        }
        EditText editText2 = this.etPassword;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
            editText2 = null;
        }
        editText2.requestFocus();
        EditText editText3 = this.etPassword;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
        } else {
            editText = editText3;
        }
        editText.post(new Runnable() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                EnterpriseLoginActivity.showPasswordStep$lambda$11(EnterpriseLoginActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPasswordStep$lambda$11(EnterpriseLoginActivity enterpriseLoginActivity) {
        Object systemService = enterpriseLoginActivity.getSystemService("input_method");
        EditText editText = null;
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            EditText editText2 = enterpriseLoginActivity.etPassword;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etPassword");
            } else {
                editText = editText2;
            }
            inputMethodManager.showSoftInput(editText, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goBackToStep1() {
        View view = this.layoutStepPassword;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepPassword");
            view = null;
        }
        view.setVisibility(8);
        View view2 = this.layoutStepEmail;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStepEmail");
            view2 = null;
        }
        view2.setVisibility(0);
        EditText editText = this.etPassword;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
            editText = null;
        }
        editText.getText().clear();
        clearPasswordError();
        View view3 = this.btnSsoLogin;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSsoLogin");
            view3 = null;
        }
        view3.setVisibility(8);
        View view4 = this.layoutOrDivider;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutOrDivider");
            view4 = null;
        }
        view4.setVisibility(8);
        this.ssoAuthUrl = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void openSsoUrl(String url) {
        FLogger.INSTANCE.mo428i(TAG, "Opening SSO URL in WebView");
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_SSO_OPENED, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
        EnterpriseSsoWebViewActivity.INSTANCE.start((Context) this, url, this.currentEmail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setEmailStepLoading(boolean loading) {
        String string;
        this.isLoading = loading;
        ProgressBar progressBar = this.pbLoadingEmail;
        EditText editText = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbLoadingEmail");
            progressBar = null;
        }
        progressBar.setVisibility(loading ? 0 : 8);
        Button button = this.btnContinue;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
            button = null;
        }
        if (loading) {
            string = "";
        } else {
            string = getString(C0882R.string.trae_enterprise_login_continue);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        button.setText(string);
        Button button2 = this.btnContinue;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnContinue");
            button2 = null;
        }
        button2.setEnabled(!loading);
        EditText editText2 = this.etEmailStep1;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etEmailStep1");
        } else {
            editText = editText2;
        }
        editText.setEnabled(!loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLoginButtonState() {
        EditText editText = this.etPassword;
        Button button = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
            editText = null;
        }
        String obj = editText.getText().toString();
        Button button2 = this.btnLogin;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLogin");
        } else {
            button = button2;
        }
        button.setEnabled((obj.length() > 0) && !this.isLoading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void performLogin() {
        EditText editText = this.etPassword;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
            editText = null;
        }
        String obj = editText.getText().toString();
        if (this.currentEmail.length() == 0) {
            return;
        }
        if (obj.length() == 0) {
            return;
        }
        setLoginLoading(true);
        clearPasswordError();
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_METHOD_SELECTED, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_PASSWORD_SUBMITTED, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
        EnterpriseAuthManager.INSTANCE.login((CoroutineScope) LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), this.currentEmail, obj, new EnterpriseAuthManager.Callback() { // from class: com.bytedance.trae.login.enterprise.EnterpriseLoginActivity$performLogin$1
            @Override // com.bytedance.trae.login.enterprise.EnterpriseAuthManager.Callback
            public void onSuccess() {
                FLogger.INSTANCE.mo428i("EnterpriseLoginActivity", "Enterprise login success");
                EnterpriseLoginActivity.this.loginSuccess = true;
                EnterpriseLoginActivity.this.navigateToMain();
            }

            @Override // com.bytedance.trae.login.enterprise.EnterpriseAuthManager.Callback
            public void onFailure(String errorMessage) {
                FLogger.INSTANCE.mo426e("EnterpriseLoginActivity", "Enterprise login failed: " + errorMessage);
                EnterpriseLoginActivity.this.setLoginLoading(false);
                EnterpriseLoginActivity enterpriseLoginActivity = EnterpriseLoginActivity.this;
                if (errorMessage == null) {
                    errorMessage = enterpriseLoginActivity.getString(C0882R.string.trae_enterprise_error_login_failed);
                    Intrinsics.checkNotNullExpressionValue(errorMessage, "getString(...)");
                }
                enterpriseLoginActivity.showError(errorMessage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLoginLoading(boolean loading) {
        String string;
        this.isLoading = loading;
        ProgressBar progressBar = this.pbLoading;
        EditText editText = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbLoading");
            progressBar = null;
        }
        progressBar.setVisibility(loading ? 0 : 8);
        Button button = this.btnLogin;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLogin");
            button = null;
        }
        if (loading) {
            string = "";
        } else {
            string = getString(C0882R.string.trae_enterprise_login_btn);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        button.setText(string);
        Button button2 = this.btnLogin;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLogin");
            button2 = null;
        }
        button2.setEnabled(!loading);
        EditText editText2 = this.etPassword;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPassword");
        } else {
            editText = editText2;
        }
        editText.setEnabled(!loading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showError(String message) {
        TextView textView = this.tvError;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvError");
            textView = null;
        }
        textView.setText(message);
        View view2 = this.layoutErrorPassword;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorPassword");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.layoutPasswordInput;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutPasswordInput");
        } else {
            view = view3;
        }
        view.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPasswordError() {
        View view = this.layoutErrorPassword;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorPassword");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.layoutPasswordInput;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutPasswordInput");
        } else {
            view2 = view3;
        }
        view2.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_new);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmailError(String message) {
        TextView textView = this.tvErrorEmail;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvErrorEmail");
            textView = null;
        }
        textView.setText(message);
        View view2 = this.layoutErrorEmail;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorEmail");
            view2 = null;
        }
        view2.setVisibility(0);
        View view3 = this.layoutEmailInput;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutEmailInput");
        } else {
            view = view3;
        }
        view.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearEmailError() {
        View view = this.layoutErrorEmail;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutErrorEmail");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.layoutEmailInput;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutEmailInput");
        } else {
            view2 = view3;
        }
        view2.setBackgroundResource(C0820R.drawable.trae_login_bg_edit_new);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void navigateToMain() {
        Intent intent = new Intent();
        intent.setClassName((Context) this, MAIN_ACTIVITY_CLASS);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.loginSuccess) {
            return;
        }
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_ENTERPRISE_PAGE_EXIT, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_enterprise_EnterpriseLoginActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m407x940abefa(EnterpriseLoginActivity enterpriseLoginActivity) {
        enterpriseLoginActivity.m408xd5ae53a1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) enterpriseLoginActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}

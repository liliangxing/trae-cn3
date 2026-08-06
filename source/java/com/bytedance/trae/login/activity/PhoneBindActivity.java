package com.bytedance.trae.login.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.appcompat.widget.AppCompatEditText;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.monitor.fluency.FluencyHelper;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.sdk.account.helper.BindMobileHelper;
import com.bytedance.sdk.account.helper.ChangeMobileHelper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common.widget.CustomConfirmDialog;
import com.bytedance.trae.common_ui.R;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.login.widget.VerifyCodeInputView;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* compiled from: PhoneBindActivity.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002J\b\u0010*\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020#H\u0002J\u0010\u00100\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0017H\u0002J\u0016\u00101\u001a\u00020#2\f\u00102\u001a\b\u0012\u0004\u0012\u00020#03H\u0002J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020#H\u0002J\u001a\u0010;\u001a\u0002092\u0006\u0010<\u001a\u0002062\b\u0010=\u001a\u0004\u0018\u00010\u0017H\u0002J5\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u00172\n\b\u0002\u0010<\u001a\u0004\u0018\u0001062\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020#H\u0002J\b\u0010D\u001a\u00020#H\u0002J\b\u0010E\u001a\u00020#H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/trae/login/activity/PhoneBindActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "viewFlipper", "Landroid/widget/ViewFlipper;", "loadingOverlay", "Landroid/widget/FrameLayout;", "etOldPhone", "Landroid/widget/EditText;", "btnSendCodeOld", "Landroid/widget/TextView;", "tvVerifyOldHint", "verifyOldInput", "Lcom/bytedance/trae/login/widget/VerifyCodeInputView;", "tvResendOld", "tvNewPhoneTitle", "etPhone", "btnSendCode", "tvVerifyNewHint", "verifyNewInput", "tvResendNew", "mode", "", EventConstants.PARAM_SOURCE, "maskedPhone", "ticket", "oldPhoneNumber", "newPhoneNumber", "countDownTimerOld", "Landroid/os/CountDownTimer;", "countDownTimerNew", "isSendingCode", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "startFlow", "onSendCodeOldClicked", "checkSafeEnv", "sendCodeToOldPhone", "validateOldPhone", "code", "sendCodeToNewPhone", "goToVerifyNewStep", "resendCodeToNewPhone", "submitFinal", "runOnUiThreadSafe", "block", "Lkotlin/Function0;", "showStep", "step", "", "showLoading", IMessageCallbackService.EVENT_TYPE_SHOW, "", "showPhoneConflictDialog", "isPhoneAlreadyBoundError", "errorCode", "errorMsg", "trackSettingsPhoneBindingResult", "result", FluencyHelper.STAGE, "failReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "startCountdownOld", "startCountdownNew", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneBindActivity extends TraeCommonAppCompatActivity {
    private static final int COUNTDOWN_SECONDS = 60;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ERROR_CODE_PHONE_ALREADY_BOUND = 1007;
    private static final int ERROR_CODE_PHONE_ALREADY_BOUND_2 = 1041;
    private static final int ERROR_CODE_PHONE_ALREADY_BOUND_3 = 1001;
    private static final String EVENT_ACCOUNT_BINDING_RESULT = "icube_account_binding_result";
    public static final String EXTRA_MODE = "extra_mode";
    public static final String EXTRA_NEW_PHONE = "extra_new_phone";
    public static final String EXTRA_PHONE_MASKED = "extra_phone_masked";
    private static final String EXTRA_SOURCE = "extra_source";
    public static final String MODE_BIND = "bind";
    public static final String MODE_CHANGE = "change";
    private static final int NEW_CODE_LENGTH = 4;
    private static final int OLD_CODE_LENGTH = 4;
    private static final String RESULT_FAIL = "fail";
    private static final String RESULT_SUCCESS = "success";
    private static final String SOURCE_SETTINGS = "settings";
    private TextView btnSendCode;
    private TextView btnSendCodeOld;
    private CountDownTimer countDownTimerNew;
    private CountDownTimer countDownTimerOld;
    private EditText etOldPhone;
    private EditText etPhone;
    private FrameLayout loadingOverlay;
    private TextView tvNewPhoneTitle;
    private TextView tvResendNew;
    private TextView tvResendOld;
    private TextView tvVerifyNewHint;
    private TextView tvVerifyOldHint;
    private VerifyCodeInputView verifyNewInput;
    private VerifyCodeInputView verifyOldInput;
    private ViewFlipper viewFlipper;
    private String mode = MODE_BIND;
    private String source = "";
    private String maskedPhone = "";
    private String ticket = "";
    private String oldPhoneNumber = "";
    private String newPhoneNumber = "";
    private final AtomicBoolean isSendingCode = new AtomicBoolean(false);

    /* renamed from: com_bytedance_trae_login_activity_PhoneBindActivity__onStop$___twin___ */
    public void m402x8ce21e10() {
        super.onStop();
    }

    protected void onStop() {
        m401xd31f1deb(this);
    }

    /* compiled from: PhoneBindActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/login/activity/PhoneBindActivity$Companion;", "", "<init>", "()V", "EXTRA_MODE", "", "EXTRA_PHONE_MASKED", "EXTRA_SOURCE", "MODE_BIND", "MODE_CHANGE", "EXTRA_NEW_PHONE", "SOURCE_SETTINGS", "EVENT_ACCOUNT_BINDING_RESULT", "RESULT_SUCCESS", "RESULT_FAIL", "COUNTDOWN_SECONDS", "", "OLD_CODE_LENGTH", "NEW_CODE_LENGTH", "ERROR_CODE_PHONE_ALREADY_BOUND", "ERROR_CODE_PHONE_ALREADY_BOUND_2", "ERROR_CODE_PHONE_ALREADY_BOUND_3", TraeAuthManager.STAGE_START, "", "context", "Landroid/app/Activity;", "mode", "maskedPhone", "requestCode", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Activity activity, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            companion.start(activity, str, str2, i);
        }

        public final void start(Activity context, String mode, String maskedPhone, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent(context, (Class<?>) PhoneBindActivity.class);
            intent.putExtra(PhoneBindActivity.EXTRA_MODE, mode);
            if (maskedPhone != null) {
                intent.putExtra(PhoneBindActivity.EXTRA_PHONE_MASKED, maskedPhone);
            }
            context.startActivityForResult(intent, requestCode);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0820R.layout.trae_activity_phone_bind);
        String stringExtra = getIntent().getStringExtra(EXTRA_MODE);
        if (stringExtra == null) {
            stringExtra = MODE_BIND;
        }
        this.mode = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(EXTRA_SOURCE);
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.source = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra(EXTRA_PHONE_MASKED);
        this.maskedPhone = stringExtra3 != null ? stringExtra3 : "";
        initViews();
        startFlow();
    }

    private final void initViews() {
        findViewById(C0820R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBindActivity.this.finish();
            }
        });
        View findViewById = findViewById(C0820R.id.view_flipper);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.viewFlipper = (ViewFlipper) findViewById;
        View findViewById2 = findViewById(C0820R.id.loading_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.loadingOverlay = (FrameLayout) findViewById2;
        ((TextView) findViewById(C0820R.id.tv_nav_title)).setText(getString(Intrinsics.areEqual(this.mode, MODE_CHANGE) ? C0820R.string.trae_phone_change_title : C0820R.string.trae_phone_bind_title));
        View findViewById3 = findViewById(C0820R.id.et_old_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.etOldPhone = (EditText) findViewById3;
        View findViewById4 = findViewById(C0820R.id.btn_send_code_old);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.btnSendCodeOld = (TextView) findViewById4;
        View findViewById5 = findViewById(C0820R.id.tv_verify_old_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.tvVerifyOldHint = (TextView) findViewById5;
        Object findViewById6 = findViewById(C0820R.id.verify_old_input);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        VerifyCodeInputView verifyCodeInputView = (VerifyCodeInputView) findViewById6;
        this.verifyOldInput = verifyCodeInputView;
        TextView textView = null;
        if (verifyCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOldInput");
            verifyCodeInputView = null;
        }
        verifyCodeInputView.setBoxCount(4);
        View findViewById7 = findViewById(C0820R.id.tv_resend_old);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.tvResendOld = (TextView) findViewById7;
        View findViewById8 = findViewById(C0820R.id.tv_new_phone_title);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.tvNewPhoneTitle = (TextView) findViewById8;
        View findViewById9 = findViewById(C0820R.id.et_phone);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.etPhone = (EditText) findViewById9;
        View findViewById10 = findViewById(C0820R.id.btn_send_code);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.btnSendCode = (TextView) findViewById10;
        View findViewById11 = findViewById(C0820R.id.tv_verify_new_hint);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.tvVerifyNewHint = (TextView) findViewById11;
        Object findViewById12 = findViewById(C0820R.id.verify_new_input);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        VerifyCodeInputView verifyCodeInputView2 = (VerifyCodeInputView) findViewById12;
        this.verifyNewInput = verifyCodeInputView2;
        if (verifyCodeInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyNewInput");
            verifyCodeInputView2 = null;
        }
        verifyCodeInputView2.setBoxCount(4);
        View findViewById13 = findViewById(C0820R.id.tv_resend_new);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.tvResendNew = (TextView) findViewById13;
        EditText editText = this.etOldPhone;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etOldPhone");
            editText = null;
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$initViews$2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                TextView textView2;
                TextView textView3;
                boolean z = (s != null ? s.length() : 0) >= 11;
                textView2 = PhoneBindActivity.this.btnSendCodeOld;
                TextView textView4 = null;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSendCodeOld");
                    textView2 = null;
                }
                textView2.setEnabled(z);
                textView3 = PhoneBindActivity.this.btnSendCodeOld;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSendCodeOld");
                } else {
                    textView4 = textView3;
                }
                textView4.setTextColor(PhoneBindActivity.this.getColor(z ? R.color.trae_text_text_onaccent : R.color.trae_text_text_disabled));
            }
        });
        TextView textView2 = this.btnSendCodeOld;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSendCodeOld");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBindActivity.this.onSendCodeOldClicked();
            }
        });
        VerifyCodeInputView verifyCodeInputView3 = this.verifyOldInput;
        if (verifyCodeInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOldInput");
            verifyCodeInputView3 = null;
        }
        verifyCodeInputView3.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$initViews$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String obj = s != null ? s.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                if (obj.length() == 4) {
                    PhoneBindActivity.this.validateOldPhone(obj);
                }
            }
        });
        TextView textView3 = this.tvResendOld;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendOld");
            textView3 = null;
        }
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBindActivity.this.sendCodeToOldPhone();
            }
        });
        EditText editText2 = this.etPhone;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhone");
            editText2 = null;
        }
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$initViews$6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                TextView textView4;
                TextView textView5;
                boolean z = (s != null ? s.length() : 0) >= 11;
                textView4 = PhoneBindActivity.this.btnSendCode;
                TextView textView6 = null;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
                    textView4 = null;
                }
                textView4.setEnabled(z);
                textView5 = PhoneBindActivity.this.btnSendCode;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
                } else {
                    textView6 = textView5;
                }
                textView6.setTextColor(PhoneBindActivity.this.getColor(z ? R.color.trae_text_text_onaccent : R.color.trae_text_text_disabled));
            }
        });
        TextView textView4 = this.btnSendCode;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
            textView4 = null;
        }
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBindActivity.this.sendCodeToNewPhone();
            }
        });
        VerifyCodeInputView verifyCodeInputView4 = this.verifyNewInput;
        if (verifyCodeInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyNewInput");
            verifyCodeInputView4 = null;
        }
        verifyCodeInputView4.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$initViews$8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                String obj = s != null ? s.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                if (obj.length() == 4) {
                    PhoneBindActivity.this.submitFinal(obj);
                }
            }
        });
        TextView textView5 = this.tvResendNew;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendNew");
        } else {
            textView = textView5;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneBindActivity.this.resendCodeToNewPhone();
            }
        });
    }

    private final void startFlow() {
        TextView textView = null;
        if (Intrinsics.areEqual(this.mode, MODE_CHANGE)) {
            TextView textView2 = this.tvNewPhoneTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvNewPhoneTitle");
            } else {
                textView = textView2;
            }
            textView.setText(C0820R.string.trae_phone_input_new_title);
            showStep(0);
            return;
        }
        TextView textView3 = this.tvNewPhoneTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNewPhoneTitle");
        } else {
            textView = textView3;
        }
        textView.setText(C0820R.string.trae_phone_bind_title);
        showStep(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void onSendCodeOldClicked() {
        EditText editText = this.etOldPhone;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etOldPhone");
            editText = null;
        }
        String obj = StringsKt.trim(editText.getText().toString()).toString();
        if (!new Regex("^1\\d{10}$").matches(obj)) {
            Toast.makeText((Context) this, C0820R.string.trae_phone_invalid, 0).show();
        } else {
            this.oldPhoneNumber = obj;
            checkSafeEnv();
        }
    }

    private final void checkSafeEnv() {
        showLoading(true);
        ChangeMobileHelper.checkSafeEnvBeforeSendCodeToOld(new PhoneBindActivity$checkSafeEnv$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendCodeToOldPhone() {
        showLoading(true);
        ChangeMobileHelper.sendCodeToOld(this.oldPhoneNumber, new PhoneBindActivity$sendCodeToOldPhone$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateOldPhone(String code) {
        showLoading(true);
        VerifyCodeInputView verifyCodeInputView = this.verifyOldInput;
        if (verifyCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyOldInput");
            verifyCodeInputView = null;
        }
        verifyCodeInputView.setEnabled(false);
        ChangeMobileHelper.validateOld(code, true, new PhoneBindActivity$validateOldPhone$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void sendCodeToNewPhone() {
        EditText editText = this.etPhone;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhone");
            editText = null;
        }
        String obj = StringsKt.trim(editText.getText().toString()).toString();
        if (!new Regex("^1\\d{10}$").matches(obj)) {
            Toast.makeText((Context) this, C0820R.string.trae_phone_invalid, 0).show();
            return;
        }
        if (this.isSendingCode.compareAndSet(false, true)) {
            this.newPhoneNumber = obj;
            if (Intrinsics.areEqual(this.mode, MODE_BIND)) {
                BindMobileHelper.sendCode(obj, new PhoneBindActivity$sendCodeToNewPhone$1(this));
            } else {
                ChangeMobileHelper.sendCodeToNew(obj, this.ticket, false, new PhoneBindActivity$sendCodeToNewPhone$2(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToVerifyNewStep() {
        TextView textView = this.tvVerifyNewHint;
        AppCompatEditText appCompatEditText = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvVerifyNewHint");
            textView = null;
        }
        textView.setText(getString(C0820R.string.trae_phone_code_sent_to, new Object[]{this.newPhoneNumber}));
        showStep(3);
        startCountdownNew();
        VerifyCodeInputView verifyCodeInputView = this.verifyNewInput;
        if (verifyCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyNewInput");
            verifyCodeInputView = null;
        }
        verifyCodeInputView.requestFocus();
        Object systemService = getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            AppCompatEditText appCompatEditText2 = this.verifyNewInput;
            if (appCompatEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verifyNewInput");
            } else {
                appCompatEditText = appCompatEditText2;
            }
            inputMethodManager.showSoftInput((View) appCompatEditText, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resendCodeToNewPhone() {
        sendCodeToNewPhone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void submitFinal(String code) {
        showLoading(true);
        VerifyCodeInputView verifyCodeInputView = this.verifyNewInput;
        if (verifyCodeInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("verifyNewInput");
            verifyCodeInputView = null;
        }
        verifyCodeInputView.setEnabled(false);
        if (Intrinsics.areEqual(this.mode, MODE_BIND)) {
            BindMobileHelper.bindMobile(this.newPhoneNumber, code, (String) null, false, new PhoneBindActivity$submitFinal$1(this));
        } else {
            ChangeMobileHelper.changeBind(this.newPhoneNumber, code, this.ticket, new PhoneBindActivity$submitFinal$2(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runOnUiThreadSafe(final Function0<Unit> block) {
        runOnUiThread(new Runnable() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PhoneBindActivity.runOnUiThreadSafe$lambda$5(PhoneBindActivity.this, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runOnUiThreadSafe$lambda$5(PhoneBindActivity phoneBindActivity, Function0 function0) {
        if (phoneBindActivity.isFinishing() || phoneBindActivity.isDestroyed()) {
            return;
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showStep(int step) {
        ViewFlipper viewFlipper = this.viewFlipper;
        if (viewFlipper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewFlipper");
            viewFlipper = null;
        }
        viewFlipper.setDisplayedChild(step);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading(boolean show) {
        FrameLayout frameLayout = this.loadingOverlay;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingOverlay");
            frameLayout = null;
        }
        frameLayout.setVisibility(show ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void showPhoneConflictDialog() {
        String string = getString(C0820R.string.trae_douyin_bind_phone_conflict_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(C0820R.string.trae_douyin_bind_phone_conflict_message);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(C0820R.string.trae_douyin_bind_phone_conflict_button);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        CustomConfirmDialog.Companion.delete$default(CustomConfirmDialog.Companion, (Context) this, string, string2, (String) null, string3, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 0, 0, new Function0() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit showPhoneConflictDialog$lambda$6;
                showPhoneConflictDialog$lambda$6 = PhoneBindActivity.showPhoneConflictDialog$lambda$6(PhoneBindActivity.this);
                return showPhoneConflictDialog$lambda$6;
            }
        }, (Function0) null, 98280, (Object) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showPhoneConflictDialog$lambda$6(PhoneBindActivity phoneBindActivity) {
        EditText editText = phoneBindActivity.etPhone;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhone");
            editText = null;
        }
        editText.setText("");
        phoneBindActivity.showStep(2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPhoneAlreadyBoundError(int errorCode, String errorMsg) {
        if (errorCode == 1001 || errorCode == 1007 || errorCode == ERROR_CODE_PHONE_ALREADY_BOUND_2) {
            return true;
        }
        return errorMsg != null && StringsKt.contains$default(errorMsg, "已被绑定到其他账号", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void trackSettingsPhoneBindingResult$default(PhoneBindActivity phoneBindActivity, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        phoneBindActivity.trackSettingsPhoneBindingResult(str, str2, num, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackSettingsPhoneBindingResult(String result, String stage, Integer errorCode, String failReason) {
        if (Intrinsics.areEqual(this.source, "settings")) {
            IApplog.Companion companion = IApplog.Companion;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("current_page", "settings");
            jSONObject.put("type", TraeAuthManager.PLATFORM_PHONE);
            String str = this.mode;
            String str2 = MODE_CHANGE;
            if (!Intrinsics.areEqual(str, MODE_CHANGE)) {
                str2 = MODE_BIND;
            }
            jSONObject.put("action", str2);
            jSONObject.put("result", result);
            jSONObject.put(FluencyHelper.STAGE, stage);
            if (errorCode != null) {
                jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, String.valueOf(errorCode.intValue()));
            }
            if (failReason != null) {
                jSONObject.put("fail_reason", failReason);
            }
            Unit unit = Unit.INSTANCE;
            companion.reportEvent(EVENT_ACCOUNT_BINDING_RESULT, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.trae.login.activity.PhoneBindActivity$startCountdownOld$1] */
    public final void startCountdownOld() {
        CountDownTimer countDownTimer = this.countDownTimerOld;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        TextView textView = this.tvResendOld;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendOld");
            textView = null;
        }
        textView.setClickable(false);
        TextView textView3 = this.tvResendOld;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendOld");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(getColor(R.color.trae_text_text_disabled));
        this.countDownTimerOld = new CountDownTimer() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$startCountdownOld$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TextView textView4;
                if (PhoneBindActivity.this.isFinishing() || PhoneBindActivity.this.isDestroyed()) {
                    return;
                }
                textView4 = PhoneBindActivity.this.tvResendOld;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendOld");
                    textView4 = null;
                }
                textView4.setText(PhoneBindActivity.this.getString(C0820R.string.trae_phone_resend, new Object[]{Integer.valueOf((int) (millisUntilFinished / BytePatchException.ErrorCode.paramsError))}));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TextView textView4;
                TextView textView5;
                TextView textView6;
                if (PhoneBindActivity.this.isFinishing() || PhoneBindActivity.this.isDestroyed()) {
                    return;
                }
                textView4 = PhoneBindActivity.this.tvResendOld;
                TextView textView7 = null;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendOld");
                    textView4 = null;
                }
                textView4.setText(C0820R.string.trae_phone_resend_ready);
                textView5 = PhoneBindActivity.this.tvResendOld;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendOld");
                    textView5 = null;
                }
                textView5.setClickable(true);
                textView6 = PhoneBindActivity.this.tvResendOld;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendOld");
                } else {
                    textView7 = textView6;
                }
                textView7.setTextColor(PhoneBindActivity.this.getColor(C0820R.color.trae_login_enable));
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.trae.login.activity.PhoneBindActivity$startCountdownNew$1] */
    private final void startCountdownNew() {
        CountDownTimer countDownTimer = this.countDownTimerNew;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        TextView textView = this.tvResendNew;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendNew");
            textView = null;
        }
        textView.setClickable(false);
        TextView textView3 = this.tvResendNew;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvResendNew");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(getColor(R.color.trae_text_text_disabled));
        this.countDownTimerNew = new CountDownTimer() { // from class: com.bytedance.trae.login.activity.PhoneBindActivity$startCountdownNew$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                TextView textView4;
                if (PhoneBindActivity.this.isFinishing() || PhoneBindActivity.this.isDestroyed()) {
                    return;
                }
                textView4 = PhoneBindActivity.this.tvResendNew;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendNew");
                    textView4 = null;
                }
                textView4.setText(PhoneBindActivity.this.getString(C0820R.string.trae_phone_resend, new Object[]{Integer.valueOf((int) (millisUntilFinished / BytePatchException.ErrorCode.paramsError))}));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                TextView textView4;
                TextView textView5;
                TextView textView6;
                if (PhoneBindActivity.this.isFinishing() || PhoneBindActivity.this.isDestroyed()) {
                    return;
                }
                textView4 = PhoneBindActivity.this.tvResendNew;
                TextView textView7 = null;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendNew");
                    textView4 = null;
                }
                textView4.setText(C0820R.string.trae_phone_resend_ready);
                textView5 = PhoneBindActivity.this.tvResendNew;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendNew");
                    textView5 = null;
                }
                textView5.setClickable(true);
                textView6 = PhoneBindActivity.this.tvResendNew;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvResendNew");
                } else {
                    textView7 = textView6;
                }
                textView7.setTextColor(PhoneBindActivity.this.getColor(C0820R.color.trae_login_enable));
            }
        }.start();
    }

    protected void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.countDownTimerOld;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.countDownTimerNew;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_login_activity_PhoneBindActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m401xd31f1deb(PhoneBindActivity phoneBindActivity) {
        phoneBindActivity.m402x8ce21e10();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) phoneBindActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}

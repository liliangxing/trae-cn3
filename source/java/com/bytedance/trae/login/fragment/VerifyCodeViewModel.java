package com.bytedance.trae.login.fragment;

import android.os.CountDownTimer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.login.IVerificationCodeCallback;
import com.bytedance.trae.login.PhoneLogin;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.fragment.VerifyCodeViewModel;
import com.bytedance.trae.login.service.AccountHelper;
import com.bytedance.trae.login.traeauth.ListDevicesResult;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;

/* compiled from: VerifyCodeViewModel.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 92\u00020\u0001:\u000489:;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\bJ\u000e\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020(J\u0006\u00102\u001a\u00020(J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020(H\u0002J\u0010\u00106\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0002J\b\u00107\u001a\u00020(H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00190\u00190\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\fR \u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020!0 0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\fR\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\fR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "phoneLogin", "Lcom/bytedance/trae/login/PhoneLogin;", "_phoneNumber", "Landroidx/lifecycle/MutableLiveData;", "", "phoneNumber", "Landroidx/lifecycle/LiveData;", "getPhoneNumber", "()Landroidx/lifecycle/LiveData;", "_maskedPhone", "maskedPhone", "getMaskedPhone", "codeDigits", "", "[Ljava/lang/String;", "_countdownSeconds", "", "kotlin.jvm.PlatformType", "countdownSeconds", "getCountdownSeconds", "_isResendEnabled", "", "isResendEnabled", "_loginState", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;", "loginState", "getLoginState", "_loginExtras", "", "Ljava/lang/Object;", "_resendState", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState;", "resendState", "getResendState", "_clearInputEvent", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;", "", "clearInputEvent", "getClearInputEvent", "countDownTimer", "Landroid/os/CountDownTimer;", EventConstants.PARAM_SOURCE_INIT, TraeAuthManager.PLATFORM_PHONE, "onCodeChanged", "text", "onDeviceLimitLoginContinue", "resendCode", "submitCode", "clearCodeInput", "startCountdown", "maskPhoneNumber", "onCleared", "Event", "Companion", "LoginState", "ResendState", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class VerifyCodeViewModel extends ViewModel {
    private static final int CODE_LENGTH = 6;
    private static final int COUNTDOWN_TOTAL_SECONDS = 60;
    private final MutableLiveData<Event<Unit>> _clearInputEvent;
    private final MutableLiveData<Integer> _countdownSeconds;
    private final MutableLiveData<Boolean> _isResendEnabled;
    private final MutableLiveData<Map<String, Object>> _loginExtras;
    private final MutableLiveData<LoginState> _loginState;
    private final MutableLiveData<String> _maskedPhone;
    private final MutableLiveData<String> _phoneNumber;
    private final MutableLiveData<ResendState> _resendState;
    private final LiveData<Event<Unit>> clearInputEvent;
    private final String[] codeDigits;
    private CountDownTimer countDownTimer;
    private final LiveData<Integer> countdownSeconds;
    private final LiveData<Boolean> isResendEnabled;
    private final LiveData<LoginState> loginState;
    private final LiveData<String> maskedPhone;
    private final PhoneLogin phoneLogin = new PhoneLogin();
    private final LiveData<String> phoneNumber;
    private final LiveData<ResendState> resendState;

    public VerifyCodeViewModel() {
        LiveData<String> mutableLiveData = new MutableLiveData<>();
        this._phoneNumber = mutableLiveData;
        this.phoneNumber = mutableLiveData;
        LiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._maskedPhone = mutableLiveData2;
        this.maskedPhone = mutableLiveData2;
        String[] strArr = new String[6];
        for (int i = 0; i < 6; i++) {
            strArr[i] = "";
        }
        this.codeDigits = strArr;
        LiveData<Integer> mutableLiveData3 = new MutableLiveData<>(60);
        this._countdownSeconds = mutableLiveData3;
        this.countdownSeconds = mutableLiveData3;
        LiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(false);
        this._isResendEnabled = mutableLiveData4;
        this.isResendEnabled = mutableLiveData4;
        LiveData<LoginState> mutableLiveData5 = new MutableLiveData<>();
        this._loginState = mutableLiveData5;
        this.loginState = mutableLiveData5;
        this._loginExtras = new MutableLiveData<>();
        LiveData<ResendState> mutableLiveData6 = new MutableLiveData<>();
        this._resendState = mutableLiveData6;
        this.resendState = mutableLiveData6;
        LiveData<Event<Unit>> mutableLiveData7 = new MutableLiveData<>();
        this._clearInputEvent = mutableLiveData7;
        this.clearInputEvent = mutableLiveData7;
    }

    /* compiled from: VerifyCodeViewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\nR\u0010\u0010\u0003\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$Event;", "T", "", "content", "<init>", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "hasBeenHandled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getContentIfNotHandled", "()Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Event<T> {
        private final T content;
        private final AtomicBoolean hasBeenHandled = new AtomicBoolean(false);

        public Event(T t) {
            this.content = t;
        }

        public final T getContentIfNotHandled() {
            if (this.hasBeenHandled.compareAndSet(false, true)) {
                return this.content;
            }
            return null;
        }
    }

    public final LiveData<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    public final LiveData<String> getMaskedPhone() {
        return this.maskedPhone;
    }

    public final LiveData<Integer> getCountdownSeconds() {
        return this.countdownSeconds;
    }

    public final LiveData<Boolean> isResendEnabled() {
        return this.isResendEnabled;
    }

    public final LiveData<LoginState> getLoginState() {
        return this.loginState;
    }

    public final LiveData<ResendState> getResendState() {
        return this.resendState;
    }

    public final LiveData<Event<Unit>> getClearInputEvent() {
        return this.clearInputEvent;
    }

    public final void init(String phone) {
        Intrinsics.checkNotNullParameter(phone, TraeAuthManager.PLATFORM_PHONE);
        this._phoneNumber.setValue(phone);
        this._maskedPhone.setValue(maskPhoneNumber(phone));
        startCountdown();
    }

    public final void onCodeChanged(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        boolean z = false;
        for (int i = 0; i < 6; i++) {
            String[] strArr = this.codeDigits;
            Character orNull = StringsKt.getOrNull(text, i);
            String ch = orNull != null ? orNull.toString() : null;
            if (ch == null) {
                ch = "";
            }
            strArr[i] = ch;
        }
        String[] strArr2 = this.codeDigits;
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (!(strArr2[i2].length() > 0)) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            submitCode();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x0015, B:12:0x0020, B:14:0x002a, B:15:0x0030), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDeviceLimitLoginContinue() {
        boolean z;
        boolean z2 = false;
        try {
            if (this._loginExtras.getValue() != null) {
                Map map = (Map) this._loginExtras.getValue();
                if (map != null) {
                    z = true;
                    if (map.containsKey("is_new_user")) {
                        if (z) {
                            Map map2 = (Map) this._loginExtras.getValue();
                            Object obj = map2 != null ? map2.get("is_new_user") : null;
                            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                            z2 = ((Boolean) obj).booleanValue();
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
        } catch (Throwable unused) {
        }
        AccountHelper.INSTANCE.setIsNewUser(z2);
        TraeAuthManager.INSTANCE.onLoginContinueByDeviceLimit(new TraeAuthManager.TraeAuthCallback() { // from class: com.bytedance.trae.login.fragment.VerifyCodeViewModel$onDeviceLimitLoginContinue$1
            @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
            public void deviceOverLimit(String token) {
            }

            @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
            public void onSuccess() {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                AccountHelper.INSTANCE.loginStatusChanged(AccountStatus.LOGGED_IN, "", LoginPlatform.PHONE);
                mutableLiveData = VerifyCodeViewModel.this._loginExtras;
                mutableLiveData.setValue((Object) null);
                mutableLiveData2 = VerifyCodeViewModel.this._loginState;
                mutableLiveData2.postValue(VerifyCodeViewModel.LoginState.Success.INSTANCE);
            }

            @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
            public void onFailure(String errorCode, String errorMessage) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                mutableLiveData = VerifyCodeViewModel.this._loginExtras;
                mutableLiveData.setValue((Object) null);
                IApplog.Companion companion = IApplog.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ISignalReportConstants.KEY_REASON, errorMessage == null ? "sms_verify_failed" : errorMessage);
                jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, String.valueOf(errorCode));
                jSONObject.put("login_platform", TraeAuthManager.PLATFORM_PHONE);
                Unit unit = Unit.INSTANCE;
                companion.reportEvent("icube_login_failure", jSONObject);
                mutableLiveData2 = VerifyCodeViewModel.this._loginState;
                mutableLiveData2.postValue(new VerifyCodeViewModel.LoginState.Error(-1, errorMessage));
                VerifyCodeViewModel.this.clearCodeInput();
                mutableLiveData3 = VerifyCodeViewModel.this._countdownSeconds;
                Integer num = (Integer) mutableLiveData3.getValue();
                boolean z3 = num != null && num.intValue() == 0;
                mutableLiveData4 = VerifyCodeViewModel.this._isResendEnabled;
                mutableLiveData4.postValue(Boolean.valueOf(z3));
            }
        }, TraeAuthManager.PLATFORM_PHONE);
    }

    public final void resendCode() {
        String str;
        if (Intrinsics.areEqual(this._isResendEnabled.getValue(), true) && (str = (String) this._phoneNumber.getValue()) != null) {
            this._resendState.setValue(ResendState.Loading.INSTANCE);
            this.phoneLogin.sendCode(str, new IVerificationCodeCallback() { // from class: com.bytedance.trae.login.fragment.VerifyCodeViewModel$resendCode$1
                @Override // com.bytedance.trae.login.IVerificationCodeCallback
                public void onSendSuccess() {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    mutableLiveData = VerifyCodeViewModel.this._resendState;
                    mutableLiveData.postValue(VerifyCodeViewModel.ResendState.Success.INSTANCE);
                    mutableLiveData2 = VerifyCodeViewModel.this._loginState;
                    mutableLiveData2.postValue(VerifyCodeViewModel.LoginState.Idle.INSTANCE);
                    VerifyCodeViewModel.this.clearCodeInput();
                    VerifyCodeViewModel.this.startCountdown();
                }

                @Override // com.bytedance.trae.login.IVerificationCodeCallback
                public void onSendFailure(int errorCode, String errorMessage, Integer originErrorCode, String originErrorMsg) {
                    MutableLiveData mutableLiveData;
                    IApplog.Companion companion = IApplog.Companion;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ISignalReportConstants.KEY_REASON, errorMessage == null ? "sms_resend_failed" : errorMessage);
                    jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, String.valueOf(errorCode));
                    jSONObject.put("login_platform", TraeAuthManager.PLATFORM_PHONE);
                    Unit unit = Unit.INSTANCE;
                    companion.reportEvent("icube_login_failure", jSONObject);
                    TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_SMS_RESEND_ERROR, TraeAuthManager.PLATFORM_PHONE, null, null, String.valueOf(errorCode), errorMessage == null ? "sms_resend_failed" : errorMessage, null, null, null, null, null, 1996, null);
                    mutableLiveData = VerifyCodeViewModel.this._resendState;
                    mutableLiveData.postValue(new VerifyCodeViewModel.ResendState.Error(errorCode, errorMessage));
                }
            }, false, null, true, true);
        }
    }

    private final void submitCode() {
        String str;
        if ((this._loginState.getValue() instanceof LoginState.Loading) || (str = (String) this._phoneNumber.getValue()) == null) {
            return;
        }
        String joinToString$default = ArraysKt.joinToString$default(this.codeDigits, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (joinToString$default.length() != 6) {
            return;
        }
        this._loginState.setValue(LoginState.Loading.INSTANCE);
        this._isResendEnabled.setValue(false);
        this.phoneLogin.doPhoneLogin(LoginPlatform.PHONE, str, joinToString$default, new IAccountCallback() { // from class: com.bytedance.trae.login.fragment.VerifyCodeViewModel$submitCode$1
            @Override // com.bytedance.trae.login.api.IAccountCallback
            public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(VerifyCodeViewModel.this), (CoroutineContext) null, (CoroutineStart) null, new VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1(VerifyCodeViewModel.this, extras, null), 3, (Object) null);
            }

            @Override // com.bytedance.trae.login.api.IAccountCallback
            public void onSuccess(LoginPlatform platform, String businessScene, Boolean isNewUserLogin) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = VerifyCodeViewModel.this._loginExtras;
                mutableLiveData.setValue((Object) null);
                mutableLiveData2 = VerifyCodeViewModel.this._loginState;
                mutableLiveData2.postValue(VerifyCodeViewModel.LoginState.Success.INSTANCE);
            }

            @Override // com.bytedance.trae.login.api.IAccountCallback
            public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                MutableLiveData mutableLiveData5;
                mutableLiveData = VerifyCodeViewModel.this._loginExtras;
                mutableLiveData.setValue((Object) null);
                if (errorCode == 1075) {
                    Object obj = ext != null ? ext.get("cancel_token") : null;
                    String str2 = obj instanceof String ? (String) obj : null;
                    String str3 = str2;
                    if (!(str3 == null || str3.length() == 0)) {
                        mutableLiveData5 = VerifyCodeViewModel.this._loginState;
                        mutableLiveData5.postValue(new VerifyCodeViewModel.LoginState.DeletionPending(str2));
                        return;
                    }
                }
                IApplog.Companion companion = IApplog.Companion;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ISignalReportConstants.KEY_REASON, errorMessage == null ? "sms_verify_failed" : errorMessage);
                jSONObject.put(CDNLoader.DIAGNOSE_ERROR_CODE, String.valueOf(errorCode));
                jSONObject.put("login_platform", TraeAuthManager.PLATFORM_PHONE);
                Unit unit = Unit.INSTANCE;
                companion.reportEvent("icube_login_failure", jSONObject);
                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_PASSPORT_FAIL, TraeAuthManager.PLATFORM_PHONE, null, null, String.valueOf(errorCode), errorMessage == null ? "sms_verify_failed" : errorMessage, null, null, null, null, null, 1996, null);
                mutableLiveData2 = VerifyCodeViewModel.this._loginState;
                mutableLiveData2.postValue(new VerifyCodeViewModel.LoginState.Error(errorCode, errorMessage));
                VerifyCodeViewModel.this.clearCodeInput();
                mutableLiveData3 = VerifyCodeViewModel.this._countdownSeconds;
                Integer num = (Integer) mutableLiveData3.getValue();
                boolean z = num != null && num.intValue() == 0;
                mutableLiveData4 = VerifyCodeViewModel.this._isResendEnabled;
                mutableLiveData4.postValue(Boolean.valueOf(z));
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearCodeInput() {
        this._clearInputEvent.postValue(new Event(Unit.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.trae.login.fragment.VerifyCodeViewModel$startCountdown$1] */
    public final void startCountdown() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this._isResendEnabled.postValue(false);
        this._countdownSeconds.postValue(60);
        this.countDownTimer = new CountDownTimer() { // from class: com.bytedance.trae.login.fragment.VerifyCodeViewModel$startCountdown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                MutableLiveData mutableLiveData;
                mutableLiveData = VerifyCodeViewModel.this._countdownSeconds;
                mutableLiveData.postValue(Integer.valueOf((int) (millisUntilFinished / BytePatchException.ErrorCode.paramsError)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = VerifyCodeViewModel.this._countdownSeconds;
                mutableLiveData.postValue(0);
                mutableLiveData2 = VerifyCodeViewModel.this._isResendEnabled;
                mutableLiveData2.postValue(true);
            }
        }.start();
    }

    private final String maskPhoneNumber(String phone) {
        if (phone.length() < 7) {
            return phone;
        }
        StringBuilder sb = new StringBuilder();
        String substring = phone.substring(0, 3);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        StringBuilder append = sb.append(substring).append("****");
        String substring2 = phone.substring(phone.length() - 4);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        return append.append(substring2).toString();
    }

    protected void onCleared() {
        super.onCleared();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* compiled from: VerifyCodeViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;", "", "<init>", "()V", "Idle", "Loading", "Success", "Error", "DeletionPending", "DeviceOverLimit", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeletionPending;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeviceOverLimit;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Idle;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Loading;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Success;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class LoginState {
        public /* synthetic */ LoginState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Idle;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Idle extends LoginState {
            public static final Idle INSTANCE = new Idle();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Idle)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -861285619;
            }

            public String toString() {
                return "Idle";
            }

            private Idle() {
                super(null);
            }
        }

        private LoginState() {
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Loading;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Loading extends LoginState {
            public static final Loading INSTANCE = new Loading();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1752869021;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Success;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Success extends LoginState {
            public static final Success INSTANCE = new Success();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 338277930;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
                super(null);
            }
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$Error;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;", "errorCode", "", "errorMessage", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Error extends LoginState {
            private final int errorCode;
            private final String errorMessage;

            public static /* synthetic */ Error copy$default(Error error, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.errorCode;
                }
                if ((i2 & 2) != 0) {
                    str = error.errorMessage;
                }
                return error.copy(i, str);
            }

            /* renamed from: component1, reason: from getter */
            public final int getErrorCode() {
                return this.errorCode;
            }

            /* renamed from: component2, reason: from getter */
            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public final Error copy(int errorCode, String errorMessage) {
                return new Error(errorCode, errorMessage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return this.errorCode == error.errorCode && Intrinsics.areEqual(this.errorMessage, error.errorMessage);
            }

            public int hashCode() {
                int hashCode = Integer.hashCode(this.errorCode) * 31;
                String str = this.errorMessage;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "Error(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
            }

            public Error(int i, String str) {
                super(null);
                this.errorCode = i;
                this.errorMessage = str;
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeletionPending;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;", "token", "", "<init>", "(Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class DeletionPending extends LoginState {
            private final String token;

            public static /* synthetic */ DeletionPending copy$default(DeletionPending deletionPending, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = deletionPending.token;
                }
                return deletionPending.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getToken() {
                return this.token;
            }

            public final DeletionPending copy(String token) {
                Intrinsics.checkNotNullParameter(token, "token");
                return new DeletionPending(token);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DeletionPending) && Intrinsics.areEqual(this.token, ((DeletionPending) other).token);
            }

            public int hashCode() {
                return this.token.hashCode();
            }

            public String toString() {
                return "DeletionPending(token=" + this.token + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DeletionPending(String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "token");
                this.token = str;
            }

            public final String getToken() {
                return this.token;
            }
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState$DeviceOverLimit;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$LoginState;", "result", "Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", "<init>", "(Lcom/bytedance/trae/login/traeauth/ListDevicesResult;)V", "getResult", "()Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class DeviceOverLimit extends LoginState {
            private final ListDevicesResult result;

            public static /* synthetic */ DeviceOverLimit copy$default(DeviceOverLimit deviceOverLimit, ListDevicesResult listDevicesResult, int i, Object obj) {
                if ((i & 1) != 0) {
                    listDevicesResult = deviceOverLimit.result;
                }
                return deviceOverLimit.copy(listDevicesResult);
            }

            /* renamed from: component1, reason: from getter */
            public final ListDevicesResult getResult() {
                return this.result;
            }

            public final DeviceOverLimit copy(ListDevicesResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                return new DeviceOverLimit(result);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DeviceOverLimit) && Intrinsics.areEqual(this.result, ((DeviceOverLimit) other).result);
            }

            public int hashCode() {
                return this.result.hashCode();
            }

            public String toString() {
                return "DeviceOverLimit(result=" + this.result + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DeviceOverLimit(ListDevicesResult listDevicesResult) {
                super(null);
                Intrinsics.checkNotNullParameter(listDevicesResult, "result");
                this.result = listDevicesResult;
            }

            public final ListDevicesResult getResult() {
                return this.result;
            }
        }
    }

    /* compiled from: VerifyCodeViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState;", "", "<init>", "()V", "Loading", "Success", "Error", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Error;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Loading;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Success;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class ResendState {
        public /* synthetic */ ResendState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Loading;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Loading extends ResendState {
            public static final Loading INSTANCE = new Loading();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1611129431;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        private ResendState() {
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Success;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Success extends ResendState {
            public static final Success INSTANCE = new Success();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -592690914;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
                super(null);
            }
        }

        /* compiled from: VerifyCodeViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState$Error;", "Lcom/bytedance/trae/login/fragment/VerifyCodeViewModel$ResendState;", "errorCode", "", "errorMessage", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Error extends ResendState {
            private final int errorCode;
            private final String errorMessage;

            public static /* synthetic */ Error copy$default(Error error, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.errorCode;
                }
                if ((i2 & 2) != 0) {
                    str = error.errorMessage;
                }
                return error.copy(i, str);
            }

            /* renamed from: component1, reason: from getter */
            public final int getErrorCode() {
                return this.errorCode;
            }

            /* renamed from: component2, reason: from getter */
            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public final Error copy(int errorCode, String errorMessage) {
                return new Error(errorCode, errorMessage);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return this.errorCode == error.errorCode && Intrinsics.areEqual(this.errorMessage, error.errorMessage);
            }

            public int hashCode() {
                int hashCode = Integer.hashCode(this.errorCode) * 31;
                String str = this.errorMessage;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "Error(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ')';
            }

            public Error(int i, String str) {
                super(null);
                this.errorCode = i;
                this.errorMessage = str;
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }
        }
    }
}

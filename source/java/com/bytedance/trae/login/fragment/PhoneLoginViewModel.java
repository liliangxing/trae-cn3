package com.bytedance.trae.login.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.trae.login.IVerificationCodeCallback;
import com.bytedance.trae.login.PhoneLogin;
import com.bytedance.trae.login.fragment.PhoneLoginViewModel;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: PhoneLoginViewModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0010J\b\u0010 \u001a\u00020\u001cH\u0002J\u0006\u0010!\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000e¨\u0006#"}, d2 = {"Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "phoneLogin", "Lcom/bytedance/trae/login/PhoneLogin;", "phoneRegex", "Lkotlin/text/Regex;", "_phoneNumber", "Landroidx/lifecycle/MutableLiveData;", "", "phoneNumber", "Landroidx/lifecycle/LiveData;", "getPhoneNumber", "()Landroidx/lifecycle/LiveData;", "_isPhoneValid", "", "kotlin.jvm.PlatformType", "isPhoneValid", "_isAgreementChecked", "isAgreementChecked", "_sendCodeState", "Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState;", "sendCodeState", "getSendCodeState", "_isButtonEnabled", "isButtonEnabled", "onPhoneNumberChanged", "", TraeAuthManager.PLATFORM_PHONE, "onAgreementCheckedChanged", "checked", "updateButtonState", "sendVerificationCode", "SendCodeState", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneLoginViewModel extends ViewModel {
    private final MutableLiveData<Boolean> _isAgreementChecked;
    private final MutableLiveData<Boolean> _isButtonEnabled;
    private final MutableLiveData<Boolean> _isPhoneValid;
    private final MutableLiveData<String> _phoneNumber;
    private final MutableLiveData<SendCodeState> _sendCodeState;
    private final LiveData<Boolean> isAgreementChecked;
    private final LiveData<Boolean> isButtonEnabled;
    private final LiveData<Boolean> isPhoneValid;
    private final LiveData<String> phoneNumber;
    private final LiveData<SendCodeState> sendCodeState;
    private final PhoneLogin phoneLogin = new PhoneLogin();
    private final Regex phoneRegex = new Regex("^1\\d{10}$");

    public PhoneLoginViewModel() {
        LiveData<String> mutableLiveData = new MutableLiveData<>();
        this._phoneNumber = mutableLiveData;
        this.phoneNumber = mutableLiveData;
        LiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(false);
        this._isPhoneValid = mutableLiveData2;
        this.isPhoneValid = mutableLiveData2;
        LiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(false);
        this._isAgreementChecked = mutableLiveData3;
        this.isAgreementChecked = mutableLiveData3;
        LiveData<SendCodeState> mutableLiveData4 = new MutableLiveData<>();
        this._sendCodeState = mutableLiveData4;
        this.sendCodeState = mutableLiveData4;
        LiveData<Boolean> mutableLiveData5 = new MutableLiveData<>(false);
        this._isButtonEnabled = mutableLiveData5;
        this.isButtonEnabled = mutableLiveData5;
    }

    public final LiveData<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    public final LiveData<Boolean> isPhoneValid() {
        return this.isPhoneValid;
    }

    public final LiveData<Boolean> isAgreementChecked() {
        return this.isAgreementChecked;
    }

    public final LiveData<SendCodeState> getSendCodeState() {
        return this.sendCodeState;
    }

    public final LiveData<Boolean> isButtonEnabled() {
        return this.isButtonEnabled;
    }

    public final void onPhoneNumberChanged(String phone) {
        Intrinsics.checkNotNullParameter(phone, TraeAuthManager.PLATFORM_PHONE);
        this._phoneNumber.setValue(phone);
        this._isPhoneValid.setValue(Boolean.valueOf(this.phoneRegex.matches(phone)));
        updateButtonState();
    }

    public final void onAgreementCheckedChanged(boolean checked) {
        this._isAgreementChecked.setValue(Boolean.valueOf(checked));
        updateButtonState();
    }

    private final void updateButtonState() {
        this._isButtonEnabled.setValue(Boolean.valueOf(Intrinsics.areEqual(this._isPhoneValid.getValue(), true)));
    }

    public final void sendVerificationCode() {
        String str = (String) this._phoneNumber.getValue();
        if (str != null && Intrinsics.areEqual(this._isButtonEnabled.getValue(), true)) {
            this._sendCodeState.setValue(SendCodeState.Loading.INSTANCE);
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_METHOD_SELECTED, TraeAuthManager.PLATFORM_PHONE, null, null, null, null, null, null, null, null, null, 2044, null);
            this.phoneLogin.sendCode(str, new IVerificationCodeCallback() { // from class: com.bytedance.trae.login.fragment.PhoneLoginViewModel$sendVerificationCode$1
                @Override // com.bytedance.trae.login.IVerificationCodeCallback
                public void onSendSuccess() {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = PhoneLoginViewModel.this._sendCodeState;
                    mutableLiveData.postValue(PhoneLoginViewModel.SendCodeState.Success.INSTANCE);
                }

                @Override // com.bytedance.trae.login.IVerificationCodeCallback
                public void onSendFailure(int errorCode, String errorMessage, Integer originErrorCode, String originErrorMsg) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = PhoneLoginViewModel.this._sendCodeState;
                    mutableLiveData.postValue(new PhoneLoginViewModel.SendCodeState.Error(errorCode, errorMessage));
                }
            }, false, null, true, true);
        }
    }

    /* compiled from: PhoneLoginViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState;", "", "<init>", "()V", "Loading", "Success", "Error", "Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Error;", "Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Loading;", "Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Success;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class SendCodeState {
        public /* synthetic */ SendCodeState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PhoneLoginViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Loading;", "Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Loading extends SendCodeState {
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
                return -1434663096;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        private SendCodeState() {
        }

        /* compiled from: PhoneLoginViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Success;", "Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Success extends SendCodeState {
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
                return 656483855;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
                super(null);
            }
        }

        /* compiled from: PhoneLoginViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState$Error;", "Lcom/bytedance/trae/login/fragment/PhoneLoginViewModel$SendCodeState;", "errorCode", "", "errorMessage", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final /* data */ class Error extends SendCodeState {
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

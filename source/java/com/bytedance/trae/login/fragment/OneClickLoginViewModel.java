package com.bytedance.trae.login.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OneClickLoginViewModel.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\u0016J'\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0016H\u0002J\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\n¨\u0006$"}, d2 = {"Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_maskedPhone", "Landroidx/lifecycle/MutableLiveData;", "", "maskedPhone", "Landroidx/lifecycle/LiveData;", "getMaskedPhone", "()Landroidx/lifecycle/LiveData;", "_isAgreementChecked", "", "kotlin.jvm.PlatformType", "isAgreementChecked", "_isButtonEnabled", "isButtonEnabled", "_loginState", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState;", "loginState", "getLoginState", EventConstants.PARAM_SOURCE_INIT, "", "onAgreementCheckedChanged", "checked", "onOneClickLogin", "onLoginResult", "success", "errorCode", "", "errorMessage", "(ZLjava/lang/Integer;Ljava/lang/String;)V", "updateButtonState", "onDeviceLimitLoginContinue", "resetToIdle", "LoginState", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class OneClickLoginViewModel extends ViewModel {
    private final MutableLiveData<Boolean> _isAgreementChecked;
    private final MutableLiveData<Boolean> _isButtonEnabled;
    private final MutableLiveData<LoginState> _loginState;
    private final MutableLiveData<String> _maskedPhone;
    private final LiveData<Boolean> isAgreementChecked;
    private final LiveData<Boolean> isButtonEnabled;
    private final LiveData<LoginState> loginState;
    private final LiveData<String> maskedPhone;

    public OneClickLoginViewModel() {
        LiveData<String> mutableLiveData = new MutableLiveData<>();
        this._maskedPhone = mutableLiveData;
        this.maskedPhone = mutableLiveData;
        LiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(false);
        this._isAgreementChecked = mutableLiveData2;
        this.isAgreementChecked = mutableLiveData2;
        LiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(false);
        this._isButtonEnabled = mutableLiveData3;
        this.isButtonEnabled = mutableLiveData3;
        LiveData<LoginState> mutableLiveData4 = new MutableLiveData<>();
        this._loginState = mutableLiveData4;
        this.loginState = mutableLiveData4;
    }

    public final LiveData<String> getMaskedPhone() {
        return this.maskedPhone;
    }

    public final LiveData<Boolean> isAgreementChecked() {
        return this.isAgreementChecked;
    }

    public final LiveData<Boolean> isButtonEnabled() {
        return this.isButtonEnabled;
    }

    public final LiveData<LoginState> getLoginState() {
        return this.loginState;
    }

    public final void init(String maskedPhone) {
        Intrinsics.checkNotNullParameter(maskedPhone, "maskedPhone");
        this._maskedPhone.setValue(maskedPhone);
        updateButtonState();
    }

    public final void onAgreementCheckedChanged(boolean checked) {
        this._isAgreementChecked.setValue(Boolean.valueOf(checked));
        updateButtonState();
    }

    public final void onOneClickLogin() {
        if (Intrinsics.areEqual(this._isButtonEnabled.getValue(), true)) {
            this._loginState.setValue(LoginState.Loading.INSTANCE);
        }
    }

    public final void onLoginResult(boolean success, Integer errorCode, String errorMessage) {
        if (success) {
            this._loginState.setValue(LoginState.Success.INSTANCE);
        } else {
            this._loginState.setValue(new LoginState.Error(errorCode != null ? errorCode.intValue() : -1, errorMessage));
        }
    }

    private final void updateButtonState() {
        this._isButtonEnabled.setValue(Boolean.valueOf(Intrinsics.areEqual(this._isAgreementChecked.getValue(), true)));
    }

    public final void onDeviceLimitLoginContinue() {
        if (Intrinsics.areEqual(this._isButtonEnabled.getValue(), true)) {
            this._loginState.setValue(LoginState.Loading.INSTANCE);
        }
    }

    /* compiled from: OneClickLoginViewModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState;", "", "<init>", "()V", "Idle", "Loading", "Success", "Error", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Error;", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Idle;", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Loading;", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Success;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class LoginState {
        public /* synthetic */ LoginState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: OneClickLoginViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Idle;", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                return -2050573178;
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

        /* compiled from: OneClickLoginViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Loading;", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                return 1661652810;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        /* compiled from: OneClickLoginViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Success;", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                return -542167535;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
                super(null);
            }
        }

        /* compiled from: OneClickLoginViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState$Error;", "Lcom/bytedance/trae/login/fragment/OneClickLoginViewModel$LoginState;", "errorCode", "", "errorMessage", "", "<init>", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
    }

    public final void resetToIdle() {
        this._loginState.setValue(LoginState.Idle.INSTANCE);
    }
}

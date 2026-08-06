package com.bytedance.trae.login;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.api.response.LoginByTicketResponse;
import com.bytedance.sdk.account.impl.BDAccountAPIV3Impl;
import com.bytedance.sdk.account.mobile.query.QuickLoginQueryObj;
import com.bytedance.sdk.account.mobile.query.SendCodeQueryObj;
import com.bytedance.sdk.account.mobile.thread.call.QuickLoginCallback;
import com.bytedance.sdk.account.mobile.thread.call.SendCodeCallback;
import com.bytedance.sdk.account.platform.OnekeyLoginAdapter;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.IVerificationCodeCallback;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.service.AccountHelper;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PhoneLogin.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rJ0\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0016\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0019\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/login/PhoneLogin;", "", "<init>", "()V", "authOppoSite", "", "sendCode", "", "account", "", "callback", "Lcom/bytedance/trae/login/IVerificationCodeCallback;", "enableAgeGate", "", "businessScene", "enableAutoRead", "is6Digit", "doPhoneLogin", "platform", "Lcom/bytedance/trae/login/api/LoginPlatform;", "code", "Lcom/bytedance/trae/login/api/IAccountCallback;", "getPhoneInfo", "Lcom/bytedance/trae/login/IPhoneOneKeyCallback;", "doOneKeyLogin", "providePlatform", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PhoneLogin {
    private final int authOppoSite = 1;

    public final void sendCode(String account, final IVerificationCodeCallback callback, boolean enableAgeGate, String businessScene, boolean enableAutoRead, boolean is6Digit) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("is6Digits", is6Digit ? "1" : ViewVisibleBridge.INVISIBLE);
        linkedHashMap.put("app_name", AppHost.Companion.getAppName());
        if (enableAutoRead) {
            linkedHashMap.put("auto_read", "1");
        }
        BDAccountAPIV3Impl.instance().sendCode2(account, 24, linkedHashMap, new SendCodeCallback() { // from class: com.bytedance.trae.login.PhoneLogin$sendCode$1
            public void onSuccess(MobileApiResponse<SendCodeQueryObj> response) {
                IVerificationCodeCallback.this.onSendSuccess();
            }

            public void onError(MobileApiResponse<SendCodeQueryObj> response, int error) {
                IVerificationCodeCallback.DefaultImpls.onSendFailure$default(IVerificationCodeCallback.this, error, response != null ? response.errorMsg : null, null, null, 12, null);
            }
        });
    }

    public final void doPhoneLogin(final LoginPlatform platform, String account, String code, final IAccountCallback callback, final String businessScene) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("app_name", AppHost.Companion.getAppName());
        BDAccountAPIV3Impl.instance().quickLogin(account, code, Integer.valueOf(this.authOppoSite), (String) null, linkedHashMap, new QuickLoginCallback() { // from class: com.bytedance.trae.login.PhoneLogin$doPhoneLogin$1
            public void onSuccess(MobileApiResponse<QuickLoginQueryObj> response) {
                QuickLoginQueryObj quickLoginQueryObj;
                IBDAccountUserEntity iBDAccountUserEntity;
                final boolean z = (response == null || (quickLoginQueryObj = response.mobileObj) == null || (iBDAccountUserEntity = quickLoginQueryObj.mUserInfo) == null || !iBDAccountUserEntity.isNewUser) ? false : true;
                AccountHelper.INSTANCE.setIsNewUser(z);
                TraeAuthManager traeAuthManager = TraeAuthManager.INSTANCE;
                final IAccountCallback iAccountCallback = IAccountCallback.this;
                final String str = businessScene;
                final LoginPlatform loginPlatform = platform;
                final PhoneLogin phoneLogin = this;
                traeAuthManager.onPassportLoginSuccess(TraeAuthManager.PLATFORM_PHONE, new TraeAuthManager.TraeAuthCallback() { // from class: com.bytedance.trae.login.PhoneLogin$doPhoneLogin$1$onSuccess$1
                    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
                    public void deviceOverLimit(String token) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("is_new_user", Boolean.valueOf(z));
                        iAccountCallback.onDeviceOverLimit(token, hashMap);
                    }

                    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
                    public void onSuccess() {
                        AccountHelper accountHelper = AccountHelper.INSTANCE;
                        AccountStatus accountStatus = AccountStatus.LOGGED_IN;
                        String str2 = str;
                        if (str2 == null) {
                            str2 = "";
                        }
                        accountHelper.loginStatusChanged(accountStatus, str2, loginPlatform);
                        iAccountCallback.onSuccess(phoneLogin.providePlatform(), str, Boolean.valueOf(z));
                        Log.i("PhoneLogin", "Trae auth flow completed successfully:");
                    }

                    @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
                    public void onFailure(String errorCode, String errorMessage) {
                        Integer intOrNull;
                        Log.e("PhoneLogin", "Trae auth flow failed: " + errorCode + ' ' + errorMessage);
                        IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, loginPlatform, (errorCode == null || (intOrNull = StringsKt.toIntOrNull(errorCode)) == null) ? -1 : intOrNull.intValue(), errorMessage == null ? "Trae auth flow failed" : errorMessage, str, null, null, null, null, null, 480, null);
                    }
                });
            }

            public void onError(MobileApiResponse<QuickLoginQueryObj> response, int error) {
                String str;
                QuickLoginQueryObj quickLoginQueryObj;
                String str2;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                if (response != null && (quickLoginQueryObj = response.mobileObj) != null && (str2 = quickLoginQueryObj.mCancelToken) != null) {
                    if (str2.length() > 0) {
                        linkedHashMap2.put("cancel_token", str2);
                    }
                }
                IAccountCallback iAccountCallback = IAccountCallback.this;
                LoginPlatform loginPlatform = platform;
                if (response == null || (str = response.errorMsg) == null) {
                    str = "";
                }
                String str3 = str;
                String str4 = businessScene;
                if (linkedHashMap2.isEmpty()) {
                    linkedHashMap2 = null;
                }
                IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, loginPlatform, error, str3, str4, null, null, null, null, linkedHashMap2, 224, null);
            }
        });
    }

    public final void getPhoneInfo(LoginPlatform platform, final IPhoneOneKeyCallback callback) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final IOnekeyLoginService service = AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (service == null) {
            callback.onGetPhoneOneKeyInfoFailure(-1, "-1", "IOnekeyLoginService not available");
        } else {
            service.getPhoneInfo(new AuthorizeCallback() { // from class: com.bytedance.trae.login.PhoneLogin$getPhoneInfo$1
                public void onSuccess(Bundle bundle) {
                    PhoneOneKeyPlatform phoneOneKeyPlatform;
                    String string = bundle != null ? bundle.getString("security_phone") : null;
                    String carrier = service.getCarrier();
                    if (carrier != null) {
                        int hashCode = carrier.hashCode();
                        if (hashCode != -1429363305) {
                            if (hashCode != -1068855134) {
                                if (hashCode == -840542575 && carrier.equals("unicom")) {
                                    phoneOneKeyPlatform = PhoneOneKeyPlatform.UNICOM;
                                }
                            } else if (carrier.equals("mobile")) {
                                phoneOneKeyPlatform = PhoneOneKeyPlatform.MOBILE;
                            }
                        } else if (carrier.equals("telecom")) {
                            phoneOneKeyPlatform = PhoneOneKeyPlatform.TELECOM;
                        }
                        callback.onGetPhoneOneKeyInfoSuccess(new PhoneOneKeyInfo(string, phoneOneKeyPlatform));
                    }
                    phoneOneKeyPlatform = PhoneOneKeyPlatform.UNKNOWN;
                    callback.onGetPhoneOneKeyInfoSuccess(new PhoneOneKeyInfo(string, phoneOneKeyPlatform));
                }

                public void onError(AuthorizeErrorResponse msg) {
                    String str;
                    String str2;
                    IPhoneOneKeyCallback iPhoneOneKeyCallback = callback;
                    if (msg == null || (str = msg.platformErrorCode) == null) {
                        str = "-1";
                    }
                    if (msg == null || (str2 = msg.platformErrorMsg) == null) {
                        str2 = "";
                    }
                    iPhoneOneKeyCallback.onGetPhoneOneKeyInfoFailure(-1, str, str2);
                }
            });
        }
    }

    public final void doOneKeyLogin(final IAccountCallback callback, final String businessScene) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        IOnekeyLoginService service = AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (service == null) {
            IAccountCallback.DefaultImpls.onFailed$default(callback, providePlatform(), -1, "IOnekeyLoginService not available", businessScene, null, null, null, null, null, 480, null);
        } else {
            final Application application = AppHost.Companion.getApplication();
            service.getAuthToken(new OnekeyLoginAdapter(businessScene, this, application) { // from class: com.bytedance.trae.login.PhoneLogin$doOneKeyLogin$1
                final /* synthetic */ String $businessScene;
                final /* synthetic */ PhoneLogin this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(application);
                }

                public void onLoginSuccess(LoginByTicketResponse response) {
                    IBDAccountUserEntity userInfo;
                    final boolean z = false;
                    if (response != null && (userInfo = response.getUserInfo()) != null && userInfo.isNewUser) {
                        z = true;
                    }
                    AccountHelper.INSTANCE.setIsNewUser(z);
                    TraeAuthManager traeAuthManager = TraeAuthManager.INSTANCE;
                    final IAccountCallback iAccountCallback = IAccountCallback.this;
                    final String str = this.$businessScene;
                    final PhoneLogin phoneLogin = this.this$0;
                    traeAuthManager.onPassportLoginSuccess(TraeAuthManager.PLATFORM_ONE_CLICK, new TraeAuthManager.TraeAuthCallback() { // from class: com.bytedance.trae.login.PhoneLogin$doOneKeyLogin$1$onLoginSuccess$1
                        @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
                        public void deviceOverLimit(String token) {
                            try {
                                Log.e("TraeAuthManager", "deviceOverLimit");
                                HashMap hashMap = new HashMap();
                                hashMap.put("is_new_user", Boolean.valueOf(z));
                                iAccountCallback.onDeviceOverLimit(token, hashMap);
                            } catch (Throwable th) {
                                Log.e("TraeAuthManager", "deviceOverLimit", th);
                            }
                        }

                        @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
                        public void onSuccess() {
                            AccountHelper accountHelper = AccountHelper.INSTANCE;
                            AccountStatus accountStatus = AccountStatus.LOGGED_IN;
                            String str2 = str;
                            if (str2 == null) {
                                str2 = "";
                            }
                            accountHelper.loginStatusChanged(accountStatus, str2, phoneLogin.providePlatform());
                            iAccountCallback.onSuccess(phoneLogin.providePlatform(), str, Boolean.valueOf(z));
                            Log.i("PhoneLogin", "OneKey login + Trae auth flow completed successfully");
                        }

                        @Override // com.bytedance.trae.login.traeauth.TraeAuthManager.TraeAuthCallback
                        public void onFailure(String errorCode, String errorMessage) {
                            Integer intOrNull;
                            IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, phoneLogin.providePlatform(), (errorCode == null || (intOrNull = StringsKt.toIntOrNull(errorCode)) == null) ? -1 : intOrNull.intValue(), errorMessage == null ? "Trae auth flow failed" : errorMessage, str, null, null, null, null, null, 480, null);
                            Log.e("PhoneLogin", "OneKey login Trae auth failed: " + errorCode + ' ' + errorMessage);
                        }
                    });
                }

                public void onLoginError(AuthorizeErrorResponse response) {
                    int i;
                    String str;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (response instanceof OnekeyLoginErrorResponse) {
                        OnekeyLoginErrorResponse onekeyLoginErrorResponse = (OnekeyLoginErrorResponse) response;
                        i = onekeyLoginErrorResponse.error;
                        String str2 = onekeyLoginErrorResponse.mCancelToken;
                        if (str2 != null) {
                            if (str2.length() > 0) {
                                linkedHashMap.put("cancel_token", str2);
                            }
                        }
                    } else {
                        i = -1;
                    }
                    IAccountCallback iAccountCallback = IAccountCallback.this;
                    LoginPlatform providePlatform = this.this$0.providePlatform();
                    if (response == null || (str = response.platformErrorMsg) == null) {
                        str = "OneKey login failed";
                    }
                    IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, providePlatform, i, str, this.$businessScene, null, null, null, null, linkedHashMap.isEmpty() ? null : linkedHashMap, 224, null);
                    Log.e("PhoneLogin", "OneKey login error: error=" + i + ", code=" + (response != null ? response.platformErrorCode : null) + ", msg=" + (response != null ? response.platformErrorMsg : null));
                }
            });
        }
    }

    public final LoginPlatform providePlatform() {
        return LoginPlatform.PHONE;
    }
}

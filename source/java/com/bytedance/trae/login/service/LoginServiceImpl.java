package com.bytedance.trae.login.service;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.sdk.account.information.BDInformationAPIImpl;
import com.bytedance.sdk.account.information.method.update_user_info.UpdateUserInfoCallback;
import com.bytedance.sdk.account.information.method.update_user_info.UpdateUserInfoResponse;
import com.bytedance.sdk.account.information.method.upload_avatar.UploadAvatarCallback;
import com.bytedance.sdk.account.information.method.upload_avatar.UploadAvatarResponse;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.IAccountStatusListener;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.api.LoginDeviceListResult;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.auth.GoogleAuthHelper;
import com.bytedance.trae.login.auth.GoogleAuthInfo;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.login.enterprise.EnterpriseProfileRefresher;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.login.user.BytecloudUserInfoFetcher;
import com.bytedance.trae.login.user.BytecloudUserInfoResult;
import com.bytedance.trae.login.user.TraeUserInfoResult;
import com.bytedance.trae.login.user.UserInfo;
import com.bytedance.trae.login.user.UserInfoFetcher;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* compiled from: LoginServiceImpl.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016JX\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00050\u001a2#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001aH\u0016JX\u0010!\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00050\u001a2#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001aH\u0002JM\u0010\"\u001a\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0$2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050%2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001aH\u0016JM\u0010'\u001a\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0$2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050%2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001aH\u0002JM\u0010(\u001a\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0$2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050%2!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110&¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u001aH\u0002J\u001c\u0010)\u001a\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0$H\u0002J,\u0010,\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%H\u0016JA\u0010-\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00050\u001a2#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00050\u001aH\u0016J:\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%H\u0082@¢\u0006\u0002\u00102J:\u00103\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%H\u0082@¢\u0006\u0002\u00102J:\u00104\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010%H\u0082@¢\u0006\u0002\u00102J\"\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020&2\u0006\u00107\u001a\u00020&2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020<H\u0016J\"\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010$2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010>\u001a\u00020\u0005H\u0016R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/bytedance/trae/login/service/LoginServiceImpl;", "Lcom/bytedance/trae/login/api/ILoginService;", "<init>", "()V", "logout", "", "forceLogout", "", "callback", "Lcom/bytedance/trae/login/api/IAccountCallback;", "businessScene", "", "registerAccountStatusChangeListener", "Lcom/bytedance/trae/login/api/IAccountStatusListener;", "isSticky", "(Lcom/bytedance/trae/login/api/IAccountStatusListener;Ljava/lang/Boolean;)V", "unregisterAccountStatusChangeListener", "getAccountInfo", "Lcom/bytedance/trae/login/api/AccountInfo;", "getXTToken", "getCloudideSession", "isNewUser", "isTraeLoggedIn", "uploadAvatar", "path", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "onFail", "", "errorCode", "uploadAvatarOversea", "updateUserProfile", "params", "", "Lkotlin/Function0;", "", "updateUserProfileEnterprise", "updateUserProfileOversea", "syncLocalUserInfo", "scope", "Lkotlinx/coroutines/CoroutineScope;", "refreshUserInfo", "listLoginDevices", "Lcom/bytedance/trae/login/api/LoginDeviceListResult;", "errorMessage", "refreshPublicUserInfo", "jwtToken", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshEnterpriseUserInfo", "refreshBytecloudUserInfo", "handleGoogleAuthResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getGoogleSignInIntent", "activity", "Landroid/app/Activity;", "parseGoogleSignInResult", "cleanupGoogleAuth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LoginServiceImpl implements ILoginService {
    private static final String TAG = "LoginServiceImpl";
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));

    @Override // com.bytedance.trae.login.api.ILoginService
    public void logout(boolean forceLogout, final IAccountCallback callback, String businessScene) {
        final LoginPlatform accountPlatform = AccountHelper.INSTANCE.getAccountPlatform();
        if (Intrinsics.areEqual(TraeAuthStorage.INSTANCE.getLoginPlatform(), "enterprise")) {
            FLogger.INSTANCE.mo428i(TAG, "logout: enterprise user, do passport logout + local cleanup");
            AccountHelper.INSTANCE.doLogoutCommon(forceLogout, accountPlatform, new IAccountCallback() { // from class: com.bytedance.trae.login.service.LoginServiceImpl$logout$1
                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
                }

                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onSuccess(LoginPlatform platform, String businessScene2, Boolean isNewUserLogin) {
                    IAccountCallback iAccountCallback = IAccountCallback.this;
                    if (iAccountCallback != null) {
                        if (platform == null) {
                            platform = accountPlatform;
                        }
                        IAccountCallback.DefaultImpls.onSuccess$default(iAccountCallback, platform, businessScene2, null, 4, null);
                    }
                }

                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene2, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
                    FLogger.INSTANCE.mo426e("LoginServiceImpl", "logout: enterprise passport logout failed (code=" + errorCode + "), fallback to local cleanup");
                    AccountHelper.INSTANCE.loginStatusChanged(AccountStatus.LOGGED_OUT, businessScene2 == null ? "" : businessScene2, accountPlatform);
                    IAccountCallback iAccountCallback = IAccountCallback.this;
                    if (iAccountCallback != null) {
                        IAccountCallback.DefaultImpls.onSuccess$default(iAccountCallback, accountPlatform, businessScene2, null, 4, null);
                    }
                }
            }, businessScene);
        } else if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            FLogger.INSTANCE.mo428i(TAG, "logout: bytecloud user, do passport logout + local cleanup");
            AccountHelper.INSTANCE.doLogoutCommon(forceLogout, accountPlatform, new IAccountCallback() { // from class: com.bytedance.trae.login.service.LoginServiceImpl$logout$2
                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
                }

                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onSuccess(LoginPlatform platform, String businessScene2, Boolean isNewUserLogin) {
                    IAccountCallback iAccountCallback = IAccountCallback.this;
                    if (iAccountCallback != null) {
                        if (platform == null) {
                            platform = accountPlatform;
                        }
                        IAccountCallback.DefaultImpls.onSuccess$default(iAccountCallback, platform, businessScene2, null, 4, null);
                    }
                }

                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene2, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
                    FLogger.INSTANCE.mo426e("LoginServiceImpl", "logout: passport logout failed (code=" + errorCode + "), fallback to local cleanup");
                    AccountHelper.INSTANCE.loginStatusChanged(AccountStatus.LOGGED_OUT, businessScene2 == null ? "" : businessScene2, accountPlatform);
                    IAccountCallback iAccountCallback = IAccountCallback.this;
                    if (iAccountCallback != null) {
                        IAccountCallback.DefaultImpls.onSuccess$default(iAccountCallback, accountPlatform, businessScene2, null, 4, null);
                    }
                }
            }, businessScene);
        } else {
            AccountHelper.INSTANCE.doLogoutCommon(forceLogout, accountPlatform, new IAccountCallback() { // from class: com.bytedance.trae.login.service.LoginServiceImpl$logout$3
                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onDeviceOverLimit(String token, Map<String, ? extends Object> extras) {
                }

                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onSuccess(LoginPlatform platform, String businessScene2, Boolean isNewUserLogin) {
                    IAccountCallback iAccountCallback = IAccountCallback.this;
                    if (iAccountCallback != null) {
                        if (platform == null) {
                            platform = accountPlatform;
                        }
                        IAccountCallback.DefaultImpls.onSuccess$default(iAccountCallback, platform, businessScene2, null, 4, null);
                    }
                }

                @Override // com.bytedance.trae.login.api.IAccountCallback
                public void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene2, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext) {
                    IAccountCallback iAccountCallback = IAccountCallback.this;
                    if (iAccountCallback != null) {
                        IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, platform, errorCode, errorMessage, businessScene2, throwable, null, null, null, null, 480, null);
                    }
                }
            }, businessScene);
        }
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public void registerAccountStatusChangeListener(IAccountStatusListener callback, Boolean isSticky) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AccountStatusManager.INSTANCE.addAccountStatusCallback(callback, Intrinsics.areEqual(isSticky, true));
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public void unregisterAccountStatusChangeListener(IAccountStatusListener callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AccountStatusManager.INSTANCE.removeAccountStatusCallback(callback);
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public AccountInfo getAccountInfo() {
        try {
            Result.Companion companion = Result.Companion;
            LoginServiceImpl loginServiceImpl = this;
            UserInfo userInfo = TraeAuthStorage.INSTANCE.getUserInfo();
            if (userInfo == null) {
                return new AccountInfo(false, "", "", "", 0, "", "", null, null, null, null, 0, null, null, null, 32640, null);
            }
            return new AccountInfo(TraeAuthStorage.INSTANCE.getJwtToken().length() > 0, TraeAuthStorage.INSTANCE.getLoginPlatform(), userInfo.getUserId(), "", 0, userInfo.getAvatarUrl(), userInfo.getScreenName(), userInfo.getEmail(), userInfo.getPhoneNumber(), userInfo.getTenantId(), userInfo.getAiRegion(), userInfo.getProductType(), null, userInfo.getTenantName(), userInfo.getSaasPrivacyMode(), 4096, null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            if (Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th))) != null) {
                return new AccountInfo(false, "", "", "", 0, "", "", null, null, null, null, 0, null, null, null, 32640, null);
            }
            return new AccountInfo(false, "", "", "", 0, "", "", null, null, null, null, 0, null, null, null, 32640, null);
        }
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public String getXTToken() {
        return TraeAuthStorage.INSTANCE.getJwtToken();
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public String getCloudideSession() {
        return TraeAuthStorage.INSTANCE.getCloudideSession();
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public boolean isNewUser() {
        return AccountHelper.INSTANCE.isNewUser();
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public boolean isTraeLoggedIn() {
        return TraeAuthStorage.INSTANCE.getJwtToken().length() > 0;
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public void uploadAvatar(String path, final Function1<? super String, Unit> onSuccess, final Function1<? super Long, Unit> onFail) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFail, "onFail");
        if (AppHost.Companion.isOversea()) {
            uploadAvatarOversea(path, onSuccess, onFail);
        } else {
            BDInformationAPIImpl.instance().uploadAvatar(path, new UploadAvatarCallback() { // from class: com.bytedance.trae.login.service.LoginServiceImpl$uploadAvatar$1
                public void onSuccess(UploadAvatarResponse response) {
                    String str;
                    boolean z = false;
                    if (response != null && (str = response.webUri) != null) {
                        if (str.length() > 0) {
                            z = true;
                        }
                    }
                    if (z) {
                        Function1<String, Unit> function1 = onSuccess;
                        String str2 = response.webUri;
                        Intrinsics.checkNotNullExpressionValue(str2, "webUri");
                        function1.invoke(str2);
                        return;
                    }
                    onFail.invoke(-1L);
                }

                public void onError(UploadAvatarResponse response, int error) {
                    onFail.invoke(Long.valueOf(error));
                }
            });
        }
    }

    private final void uploadAvatarOversea(String path, Function1<? super String, Unit> onSuccess, Function1<? super Long, Unit> onFail) {
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LoginServiceImpl$uploadAvatarOversea$1(path, onFail, this, onSuccess, null), 3, (Object) null);
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public void updateUserProfile(final Map<String, String> params, final Function0<Unit> onSuccess, final Function1<? super Integer, Unit> onFail) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFail, "onFail");
        if (EnterpriseProfileRefresher.INSTANCE.isEnterpriseLogin()) {
            updateUserProfileEnterprise(params, onSuccess, onFail);
        } else if (AppHost.Companion.isOversea()) {
            updateUserProfileOversea(params, onSuccess, onFail);
        } else {
            BDInformationAPIImpl.instance().updateUserInfo(params, (JSONObject) null, new UpdateUserInfoCallback() { // from class: com.bytedance.trae.login.service.LoginServiceImpl$updateUserProfile$1
                public void onSuccess(UpdateUserInfoResponse response) {
                    LoginServiceImpl.this.syncLocalUserInfo(params);
                    onSuccess.invoke();
                }

                public void onError(UpdateUserInfoResponse response, int error) {
                    onFail.invoke(Integer.valueOf(error));
                }
            });
        }
    }

    private final void updateUserProfileEnterprise(Map<String, String> params, Function0<Unit> onSuccess, Function1<? super Integer, Unit> onFail) {
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LoginServiceImpl$updateUserProfileEnterprise$1(params, this, onSuccess, onFail, null), 3, (Object) null);
    }

    private final void updateUserProfileOversea(Map<String, String> params, Function0<Unit> onSuccess, Function1<? super Integer, Unit> onFail) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = params.get("name");
        if (str != null) {
            linkedHashMap.put("name", str);
        }
        String str2 = params.get("avatar");
        if (str2 != null) {
            linkedHashMap.put("avatar", str2);
        }
        if (linkedHashMap.isEmpty()) {
            onFail.invoke(-1);
        } else {
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LoginServiceImpl$updateUserProfileOversea$3(linkedHashMap, this, params, onSuccess, onFail, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncLocalUserInfo(Map<String, String> params) {
        try {
            Result.Companion companion = Result.Companion;
            LoginServiceImpl loginServiceImpl = this;
            UserInfo userInfo = TraeAuthStorage.INSTANCE.getUserInfo();
            if (userInfo == null) {
                return;
            }
            String str = params.get("name");
            if (str != null) {
                userInfo = userInfo.copy((r26 & 1) != 0 ? userInfo.userId : null, (r26 & 2) != 0 ? userInfo.screenName : str, (r26 & 4) != 0 ? userInfo.avatarUrl : null, (r26 & 8) != 0 ? userInfo.gender : null, (r26 & 16) != 0 ? userInfo.email : null, (r26 & 32) != 0 ? userInfo.phoneNumber : null, (r26 & 64) != 0 ? userInfo.tenantId : null, (r26 & 128) != 0 ? userInfo.tenantName : null, (r26 & 256) != 0 ? userInfo.productType : 0, (r26 & 512) != 0 ? userInfo.aiRegion : null, (r26 & 1024) != 0 ? userInfo.employeeId : null, (r26 & 2048) != 0 ? userInfo.saasPrivacyMode : null);
            }
            UserInfo userInfo2 = userInfo;
            String str2 = params.get("avatar");
            if (str2 != null) {
                userInfo2 = userInfo2.copy((r26 & 1) != 0 ? userInfo2.userId : null, (r26 & 2) != 0 ? userInfo2.screenName : null, (r26 & 4) != 0 ? userInfo2.avatarUrl : str2, (r26 & 8) != 0 ? userInfo2.gender : null, (r26 & 16) != 0 ? userInfo2.email : null, (r26 & 32) != 0 ? userInfo2.phoneNumber : null, (r26 & 64) != 0 ? userInfo2.tenantId : null, (r26 & 128) != 0 ? userInfo2.tenantName : null, (r26 & 256) != 0 ? userInfo2.productType : 0, (r26 & 512) != 0 ? userInfo2.aiRegion : null, (r26 & 1024) != 0 ? userInfo2.employeeId : null, (r26 & 2048) != 0 ? userInfo2.saasPrivacyMode : null);
            }
            TraeAuthStorage.INSTANCE.saveUserInfo(userInfo2);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public void refreshUserInfo(Function1<? super AccountInfo, Unit> onSuccess, Function0<Unit> onFail) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        String jwtToken = TraeAuthStorage.INSTANCE.getJwtToken();
        if (!(jwtToken.length() == 0)) {
            BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LoginServiceImpl$refreshUserInfo$1(this, jwtToken, onSuccess, onFail, null), 3, (Object) null);
        } else if (onFail != null) {
            onFail.invoke();
        }
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public void listLoginDevices(Function1<? super LoginDeviceListResult, Unit> onSuccess, Function1<? super String, Unit> onFail) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFail, "onFail");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LoginServiceImpl$listLoginDevices$1(onSuccess, onFail, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshPublicUserInfo(String str, Function1<? super AccountInfo, Unit> function1, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        LoginServiceImpl$refreshPublicUserInfo$1 loginServiceImpl$refreshPublicUserInfo$1;
        int i;
        Function1<? super AccountInfo, Unit> function12;
        Function0<Unit> function02;
        TraeUserInfoResult result;
        if (continuation instanceof LoginServiceImpl$refreshPublicUserInfo$1) {
            loginServiceImpl$refreshPublicUserInfo$1 = (LoginServiceImpl$refreshPublicUserInfo$1) continuation;
            if ((loginServiceImpl$refreshPublicUserInfo$1.label & Integer.MIN_VALUE) != 0) {
                loginServiceImpl$refreshPublicUserInfo$1.label -= Integer.MIN_VALUE;
                Object obj = loginServiceImpl$refreshPublicUserInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loginServiceImpl$refreshPublicUserInfo$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    UserInfoFetcher userInfoFetcher = UserInfoFetcher.INSTANCE;
                    loginServiceImpl$refreshPublicUserInfo$1.L$0 = function1;
                    loginServiceImpl$refreshPublicUserInfo$1.L$1 = function0;
                    loginServiceImpl$refreshPublicUserInfo$1.label = 1;
                    obj = userInfoFetcher.doFetch(str, loginServiceImpl$refreshPublicUserInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function1;
                    function02 = function0;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function02 = (Function0) loginServiceImpl$refreshPublicUserInfo$1.L$1;
                    function12 = (Function1) loginServiceImpl$refreshPublicUserInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                UserInfoFetcher.UserInfoResponse userInfoResponse = (UserInfoFetcher.UserInfoResponse) obj;
                result = userInfoResponse == null ? userInfoResponse.getResult() : null;
                if (result != null) {
                    String userId = result.getUserId();
                    if (userId != null && userId.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        UserInfo from = UserInfo.INSTANCE.from(result);
                        TraeAuthStorage.INSTANCE.saveUserInfo(from);
                        function12.invoke(new AccountInfo(true, "", from.getUserId(), "", 0, from.getAvatarUrl(), from.getScreenName(), from.getEmail(), from.getPhoneNumber(), null, null, 0, null, null, null, 32256, null));
                        return Unit.INSTANCE;
                    }
                }
                if (function02 != null) {
                    function02.invoke();
                }
                return Unit.INSTANCE;
            }
        }
        loginServiceImpl$refreshPublicUserInfo$1 = new LoginServiceImpl$refreshPublicUserInfo$1(this, continuation);
        Object obj2 = loginServiceImpl$refreshPublicUserInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loginServiceImpl$refreshPublicUserInfo$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        UserInfoFetcher.UserInfoResponse userInfoResponse2 = (UserInfoFetcher.UserInfoResponse) obj2;
        if (userInfoResponse2 == null) {
        }
        if (result != null) {
        }
        if (function02 != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshEnterpriseUserInfo(String str, Function1<? super AccountInfo, Unit> function1, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        LoginServiceImpl$refreshEnterpriseUserInfo$1 loginServiceImpl$refreshEnterpriseUserInfo$1;
        int i;
        AccountInfo accountInfo;
        if (continuation instanceof LoginServiceImpl$refreshEnterpriseUserInfo$1) {
            loginServiceImpl$refreshEnterpriseUserInfo$1 = (LoginServiceImpl$refreshEnterpriseUserInfo$1) continuation;
            if ((loginServiceImpl$refreshEnterpriseUserInfo$1.label & Integer.MIN_VALUE) != 0) {
                loginServiceImpl$refreshEnterpriseUserInfo$1.label -= Integer.MIN_VALUE;
                Object obj = loginServiceImpl$refreshEnterpriseUserInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loginServiceImpl$refreshEnterpriseUserInfo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!EnterpriseProfileRefresher.INSTANCE.hasRefreshProvider()) {
                        FLogger.INSTANCE.mo430w(TAG, "refreshEnterpriseUserInfo failed: refresh provider is not registered");
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                    EnterpriseProfileRefresher enterpriseProfileRefresher = EnterpriseProfileRefresher.INSTANCE;
                    loginServiceImpl$refreshEnterpriseUserInfo$1.L$0 = function1;
                    loginServiceImpl$refreshEnterpriseUserInfo$1.L$1 = function0;
                    loginServiceImpl$refreshEnterpriseUserInfo$1.label = 1;
                    obj = enterpriseProfileRefresher.refresh(str, loginServiceImpl$refreshEnterpriseUserInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function0 = (Function0) loginServiceImpl$refreshEnterpriseUserInfo$1.L$1;
                    function1 = (Function1) loginServiceImpl$refreshEnterpriseUserInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                accountInfo = (AccountInfo) obj;
                if (!(accountInfo == null && accountInfo.getIsLogin())) {
                    function1.invoke(accountInfo);
                } else {
                    FLogger.INSTANCE.mo430w(TAG, "refreshEnterpriseUserInfo failed: provider returned invalid account info");
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
                return Unit.INSTANCE;
            }
        }
        loginServiceImpl$refreshEnterpriseUserInfo$1 = new LoginServiceImpl$refreshEnterpriseUserInfo$1(this, continuation);
        Object obj2 = loginServiceImpl$refreshEnterpriseUserInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loginServiceImpl$refreshEnterpriseUserInfo$1.label;
        if (i != 0) {
        }
        accountInfo = (AccountInfo) obj2;
        if (!(accountInfo == null && accountInfo.getIsLogin())) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00da, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object refreshBytecloudUserInfo(String str, Function1<? super AccountInfo, Unit> function1, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        LoginServiceImpl$refreshBytecloudUserInfo$1 loginServiceImpl$refreshBytecloudUserInfo$1;
        int i;
        Function1<? super AccountInfo, Unit> function12;
        Function0<Unit> function02;
        BytecloudUserInfoResult result;
        String str2;
        String email;
        String str3;
        String organization;
        String str4;
        String region;
        String aiRegion;
        String employeeId;
        if (continuation instanceof LoginServiceImpl$refreshBytecloudUserInfo$1) {
            loginServiceImpl$refreshBytecloudUserInfo$1 = (LoginServiceImpl$refreshBytecloudUserInfo$1) continuation;
            if ((loginServiceImpl$refreshBytecloudUserInfo$1.label & Integer.MIN_VALUE) != 0) {
                loginServiceImpl$refreshBytecloudUserInfo$1.label -= Integer.MIN_VALUE;
                Object obj = loginServiceImpl$refreshBytecloudUserInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loginServiceImpl$refreshBytecloudUserInfo$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    BytecloudUserInfoFetcher bytecloudUserInfoFetcher = BytecloudUserInfoFetcher.INSTANCE;
                    loginServiceImpl$refreshBytecloudUserInfo$1.L$0 = function1;
                    loginServiceImpl$refreshBytecloudUserInfo$1.L$1 = function0;
                    loginServiceImpl$refreshBytecloudUserInfo$1.label = 1;
                    obj = bytecloudUserInfoFetcher.doFetch(str, loginServiceImpl$refreshBytecloudUserInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function12 = function1;
                    function02 = function0;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function02 = (Function0) loginServiceImpl$refreshBytecloudUserInfo$1.L$1;
                    function12 = (Function1) loginServiceImpl$refreshBytecloudUserInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                BytecloudUserInfoFetcher.BytecloudUserInfoResponse bytecloudUserInfoResponse = (BytecloudUserInfoFetcher.BytecloudUserInfoResponse) obj;
                result = bytecloudUserInfoResponse == null ? bytecloudUserInfoResponse.getResult() : null;
                if (result != null) {
                    String username = result.getUsername();
                    if (username != null && username.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        UserInfo userInfo = TraeAuthStorage.INSTANCE.getUserInfo();
                        String username2 = result.getUsername();
                        String username3 = result.getUsername();
                        String avatarUrl = result.getAvatarUrl();
                        if (avatarUrl == null) {
                            avatarUrl = userInfo != null ? userInfo.getAvatarUrl() : null;
                            if (avatarUrl == null) {
                                str2 = "";
                                email = result.getEmail();
                                if (email == null) {
                                    email = userInfo != null ? userInfo.getEmail() : null;
                                    if (email == null) {
                                        str3 = "";
                                        organization = result.getOrganization();
                                        if (organization == null) {
                                            organization = userInfo != null ? userInfo.getTenantId() : null;
                                            if (organization == null) {
                                                str4 = "";
                                                region = result.getRegion();
                                                if (region != null) {
                                                    aiRegion = region.toUpperCase(Locale.ROOT);
                                                    Intrinsics.checkNotNullExpressionValue(aiRegion, "toUpperCase(...)");
                                                }
                                                aiRegion = userInfo == null ? userInfo.getAiRegion() : null;
                                                if (aiRegion == null) {
                                                    aiRegion = "";
                                                }
                                                employeeId = result.getEmployeeId();
                                                if (employeeId == null) {
                                                    employeeId = userInfo != null ? userInfo.getEmployeeId() : null;
                                                    if (employeeId == null) {
                                                        employeeId = "";
                                                    }
                                                }
                                                UserInfo userInfo2 = new UserInfo(username2, username3, str2, null, str3, null, str4, null, 0, aiRegion, employeeId, null, 2472, null);
                                                TraeAuthStorage.INSTANCE.saveUserInfo(userInfo2);
                                                function12.invoke(new AccountInfo(true, "bytecloud", userInfo2.getUserId(), "", 0, userInfo2.getAvatarUrl(), userInfo2.getScreenName(), userInfo2.getEmail(), "", userInfo2.getTenantId(), userInfo2.getAiRegion(), userInfo2.getProductType(), null, null, null, 28672, null));
                                                return Unit.INSTANCE;
                                            }
                                        }
                                        str4 = organization;
                                        region = result.getRegion();
                                        if (region != null) {
                                        }
                                        if (userInfo == null) {
                                        }
                                        if (aiRegion == null) {
                                        }
                                        employeeId = result.getEmployeeId();
                                        if (employeeId == null) {
                                        }
                                        UserInfo userInfo22 = new UserInfo(username2, username3, str2, null, str3, null, str4, null, 0, aiRegion, employeeId, null, 2472, null);
                                        TraeAuthStorage.INSTANCE.saveUserInfo(userInfo22);
                                        function12.invoke(new AccountInfo(true, "bytecloud", userInfo22.getUserId(), "", 0, userInfo22.getAvatarUrl(), userInfo22.getScreenName(), userInfo22.getEmail(), "", userInfo22.getTenantId(), userInfo22.getAiRegion(), userInfo22.getProductType(), null, null, null, 28672, null));
                                        return Unit.INSTANCE;
                                    }
                                }
                                str3 = email;
                                organization = result.getOrganization();
                                if (organization == null) {
                                }
                                str4 = organization;
                                region = result.getRegion();
                                if (region != null) {
                                }
                                if (userInfo == null) {
                                }
                                if (aiRegion == null) {
                                }
                                employeeId = result.getEmployeeId();
                                if (employeeId == null) {
                                }
                                UserInfo userInfo222 = new UserInfo(username2, username3, str2, null, str3, null, str4, null, 0, aiRegion, employeeId, null, 2472, null);
                                TraeAuthStorage.INSTANCE.saveUserInfo(userInfo222);
                                function12.invoke(new AccountInfo(true, "bytecloud", userInfo222.getUserId(), "", 0, userInfo222.getAvatarUrl(), userInfo222.getScreenName(), userInfo222.getEmail(), "", userInfo222.getTenantId(), userInfo222.getAiRegion(), userInfo222.getProductType(), null, null, null, 28672, null));
                                return Unit.INSTANCE;
                            }
                        }
                        str2 = avatarUrl;
                        email = result.getEmail();
                        if (email == null) {
                        }
                        str3 = email;
                        organization = result.getOrganization();
                        if (organization == null) {
                        }
                        str4 = organization;
                        region = result.getRegion();
                        if (region != null) {
                        }
                        if (userInfo == null) {
                        }
                        if (aiRegion == null) {
                        }
                        employeeId = result.getEmployeeId();
                        if (employeeId == null) {
                        }
                        UserInfo userInfo2222 = new UserInfo(username2, username3, str2, null, str3, null, str4, null, 0, aiRegion, employeeId, null, 2472, null);
                        TraeAuthStorage.INSTANCE.saveUserInfo(userInfo2222);
                        function12.invoke(new AccountInfo(true, "bytecloud", userInfo2222.getUserId(), "", 0, userInfo2222.getAvatarUrl(), userInfo2222.getScreenName(), userInfo2222.getEmail(), "", userInfo2222.getTenantId(), userInfo2222.getAiRegion(), userInfo2222.getProductType(), null, null, null, 28672, null));
                        return Unit.INSTANCE;
                    }
                }
                if (function02 != null) {
                    function02.invoke();
                }
                return Unit.INSTANCE;
            }
        }
        loginServiceImpl$refreshBytecloudUserInfo$1 = new LoginServiceImpl$refreshBytecloudUserInfo$1(this, continuation);
        Object obj2 = loginServiceImpl$refreshBytecloudUserInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loginServiceImpl$refreshBytecloudUserInfo$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        BytecloudUserInfoFetcher.BytecloudUserInfoResponse bytecloudUserInfoResponse2 = (BytecloudUserInfoFetcher.BytecloudUserInfoResponse) obj2;
        if (bytecloudUserInfoResponse2 == null) {
        }
        if (result != null) {
        }
        if (function02 != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public void handleGoogleAuthResult(int requestCode, int resultCode, Intent data) {
        GoogleAuthHelper.INSTANCE.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public Intent getGoogleSignInIntent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        GoogleAuthHelper.INSTANCE.initIfNeeded(activity);
        return GoogleAuthHelper.INSTANCE.getSignInIntent(activity);
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public Map<String, String> parseGoogleSignInResult(Intent data) {
        GoogleAuthInfo parseSignInResult = GoogleAuthHelper.INSTANCE.parseSignInResult(data);
        if (parseSignInResult == null) {
            return null;
        }
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put("platform", parseSignInResult.getPlatform());
        createMapBuilder.put("platform_app_id", parseSignInResult.getPlatformAppId());
        String idToken = parseSignInResult.getIdToken();
        if (idToken != null) {
        }
        String serverAuthCode = parseSignInResult.getServerAuthCode();
        if (serverAuthCode != null) {
        }
        String accessToken = parseSignInResult.getAccessToken();
        if (accessToken != null) {
        }
        if (parseSignInResult.getExpiresIn() > 0) {
            createMapBuilder.put("expires_in", String.valueOf(parseSignInResult.getExpiresIn()));
        }
        String uid = parseSignInResult.getUid();
        if (uid != null) {
            createMapBuilder.put("uid", uid);
        }
        return MapsKt.build(createMapBuilder);
    }

    @Override // com.bytedance.trae.login.api.ILoginService
    public void cleanupGoogleAuth() {
        GoogleAuthHelper.INSTANCE.onDestroy();
    }
}

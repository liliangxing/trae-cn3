package com.bytedance.trae.login.service;

import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.keva.Keva;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.LogoutApiResponse;
import com.bytedance.sdk.account.impl.BDAccountCoreApiImpl;
import com.bytedance.trae.keva.KevaRepos;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountCallback;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountHelper.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013J \u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J,\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/trae/login/service/AccountHelper;", "", "<init>", "()V", "LOGIN_PLATFORM", "", "LOGIN_PLATFORM_PHONE", "LOGIN_PLATFORM_GOOGLE", "LOGIN_PLATFORM_GITHUB", "LOGIN_PLATFORM_ENTERPRISE", "KEVA_DEFAULT_KEY", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "Lcom/bytedance/keva/Keva;", "isNewUser", "", "transformLoginPlatformToString", "platform", "Lcom/bytedance/trae/login/api/LoginPlatform;", "transformStringToLoginPlatform", "saveAccountPlatform", "", "getAccountPlatform", "loginStatusChanged", "status", "Lcom/bytedance/trae/login/api/AccountStatus;", "businessScene", "doLogoutCommon", "forceLogout", "callback", "Lcom/bytedance/trae/login/api/IAccountCallback;", "setIsNewUser", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AccountHelper {
    private static final String LOGIN_PLATFORM = "login_platform";
    private static final String LOGIN_PLATFORM_ENTERPRISE = "login_platform_enterprise";
    private static final String LOGIN_PLATFORM_GITHUB = "login_platform_github";
    private static final String LOGIN_PLATFORM_GOOGLE = "login_platform_google";
    private static final String LOGIN_PLATFORM_PHONE = "login_platform_phone";
    private static volatile boolean isNewUser;
    public static final AccountHelper INSTANCE = new AccountHelper();
    private static final String KEVA_DEFAULT_KEY = DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME;
    private static final Keva keva = Keva.getRepo(DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME, 0);

    /* compiled from: AccountHelper.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginPlatform.values().length];
            try {
                iArr[LoginPlatform.PHONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoginPlatform.GOOGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoginPlatform.GITHUB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoginPlatform.ENTERPRISE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AccountHelper() {
    }

    private final String transformLoginPlatformToString(LoginPlatform platform) {
        int i = platform == null ? -1 : WhenMappings.$EnumSwitchMapping$0[platform.ordinal()];
        if (i == 1) {
            return LOGIN_PLATFORM_PHONE;
        }
        if (i == 2) {
            return LOGIN_PLATFORM_GOOGLE;
        }
        if (i == 3) {
            return LOGIN_PLATFORM_GITHUB;
        }
        if (i == 4) {
            return LOGIN_PLATFORM_ENTERPRISE;
        }
        if (platform != null) {
            return platform.name();
        }
        return null;
    }

    private final LoginPlatform transformStringToLoginPlatform(String platform) {
        Object obj;
        if (platform != null) {
            switch (platform.hashCode()) {
                case -898945959:
                    if (platform.equals(LOGIN_PLATFORM_GITHUB)) {
                        return LoginPlatform.GITHUB;
                    }
                    break;
                case -893555025:
                    if (platform.equals(LOGIN_PLATFORM_GOOGLE)) {
                        return LoginPlatform.GOOGLE;
                    }
                    break;
                case 949110328:
                    if (platform.equals(LOGIN_PLATFORM_PHONE)) {
                        return LoginPlatform.PHONE;
                    }
                    break;
                case 1741166807:
                    if (platform.equals(LOGIN_PLATFORM_ENTERPRISE)) {
                        return LoginPlatform.ENTERPRISE;
                    }
                    break;
            }
        }
        String str = platform;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            AccountHelper accountHelper = this;
            obj = Result.constructor-impl(LoginPlatform.valueOf(platform));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (LoginPlatform) (Result.isFailure-impl(obj) ? null : obj);
    }

    public final void saveAccountPlatform(LoginPlatform platform) {
        keva.storeString(LOGIN_PLATFORM, transformLoginPlatformToString(platform));
    }

    public final LoginPlatform getAccountPlatform() {
        try {
            return transformStringToLoginPlatform(keva.getString(LOGIN_PLATFORM, ""));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void loginStatusChanged(AccountStatus status, String businessScene, LoginPlatform platform) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(businessScene, "businessScene");
        if (status == AccountStatus.LOGGED_IN) {
            INSTANCE.saveAccountPlatform(platform);
        } else {
            INSTANCE.saveAccountPlatform(null);
            TraeAuthManager.INSTANCE.clearAuthData();
            KevaRepos.INSTANCE.getDefaultRepo().storeBoolean("key_has_profile_overview_data", false);
            KevaRepos.INSTANCE.getDefaultRepo().storeString("key_profile_overview_data", "");
        }
        AccountStatusManager.INSTANCE.loginStatusChanged(status, businessScene);
    }

    public final void doLogoutCommon(final boolean forceLogout, final LoginPlatform platform, final IAccountCallback callback, final String businessScene) {
        BDAccountCoreApiImpl.instance().logout("user_logout", (Map) null, new AbsApiCall<LogoutApiResponse>() { // from class: com.bytedance.trae.login.service.AccountHelper$doLogoutCommon$1
            public void onResponse(LogoutApiResponse response) {
                if (response != null) {
                    boolean z = forceLogout;
                    IAccountCallback iAccountCallback = callback;
                    LoginPlatform loginPlatform = platform;
                    String str = businessScene;
                    if (!response.success && !z) {
                        if (iAccountCallback != null) {
                            IAccountCallback.DefaultImpls.onFailed$default(iAccountCallback, loginPlatform, response.mDetailErrorCode, response.errorMsg, str, null, null, null, null, null, 480, null);
                            return;
                        }
                        return;
                    }
                    if (iAccountCallback != null) {
                        IAccountCallback.DefaultImpls.onSuccess$default(iAccountCallback, loginPlatform, str, null, 4, null);
                    }
                    AccountHelper accountHelper = AccountHelper.INSTANCE;
                    AccountStatus accountStatus = AccountStatus.LOGGED_OUT;
                    if (str == null) {
                        str = "";
                    }
                    accountHelper.loginStatusChanged(accountStatus, str, loginPlatform);
                }
            }
        });
    }

    public final void setIsNewUser(boolean isNewUser2) {
        isNewUser = isNewUser2;
    }

    public final boolean isNewUser() {
        return isNewUser;
    }
}

package com.bytedance.trae.login.enterprise;

import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.LoginPlatform;
import com.bytedance.trae.login.enterprise.EnterprisePassportLogin;
import com.bytedance.trae.login.service.AccountHelper;
import com.bytedance.trae.login.traeauth.TraeAuthException;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.login.traeauth.TraeExchangeTokenResult;
import com.bytedance.trae.login.user.UserInfo;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ttnet.http.RequestContext;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: EnterpriseAuthManager.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001FB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016J&\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001eH\u0002J\u0018\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010\u001c\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010$J\"\u0010%\u001a\u00020\r2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050'H\u0082@¢\u0006\u0002\u0010(J\u001e\u0010)\u001a\u0004\u0018\u00010*2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050'H\u0002J&\u0010+\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0006\u0012\u0004\u0018\u00010\u00050,2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0005H\u0002J\u000e\u00103\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0005J\u001e\u00107\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005J\u001a\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u0005H\u0002J*\u0010;\u001a\b\u0012\u0004\u0012\u0002H=0<\"\u0004\b\u0000\u0010=2\u0006\u0010>\u001a\u00020\u00052\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H=0@H\u0002J\u0010\u0010A\u001a\u00020B2\u0006\u00102\u001a\u00020\u0005H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u00020DH\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u00020DH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager;", "", "<init>", "()V", "TAG", "", "TOB_SESSION_COOKIE_NAME", "PLATFORM_ENTERPRISE", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "registerProvider", "", "isEnterpriseLogin", "", "checkLoginConfig", "Lcom/bytedance/trae/login/enterprise/CheckLoginConfigResult;", "email", "loginWithSsoSession", "callerScope", "Lkotlinx/coroutines/CoroutineScope;", "tobSession", "callback", "Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;", "login", "password", "completeTokenFlow", "fetchUserInfo", "Lcom/bytedance/trae/login/enterprise/EnterpriseGetUserInfoData;", "token", "buildUserInfo", "Lcom/bytedance/trae/login/user/UserInfo;", "data", "toAccountInfo", "Lcom/bytedance/trae/login/api/AccountInfo;", "userInfo", "refreshEnterpriseUserInfo", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEnterpriseUserProfile", "params", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildSetUserInfoRequest", "Lcom/bytedance/trae/login/enterprise/SetUserInfoRequest;", "doAccountLogin", "Lkotlin/Pair;", "Lcom/bytedance/trae/login/enterprise/EnterpriseAccountLoginResult;", "doGetRefreshToken", "Lcom/bytedance/trae/login/enterprise/EnterpriseGetRefreshTokenResult;", "doExchangeToken", "Lcom/bytedance/trae/login/enterprise/EnterpriseExchangeTokenResult;", "refreshToken", "sendEmailVerification", "getCodeInfo", "Lcom/bytedance/trae/login/enterprise/GetCodeInfoResult;", "code", "setUserPassword", "extractCookieValue", "cookieString", "cookieName", "parseEnterpriseResponse", "Lcom/bytedance/trae/login/enterprise/EnterpriseResponse;", "T", "bodyStr", "clazz", "Ljava/lang/Class;", "exchangeTokenForRefresh", "Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;", "mapEnterpriseCodeToAuthCode", "", "mapErrorCodeToMessage", "Callback", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseAuthManager {
    private static final String PLATFORM_ENTERPRISE = "enterprise";
    private static final String TAG = "EnterpriseAuthManager";
    private static final String TOB_SESSION_COOKIE_NAME = "X-Cloudide-Tob-Session";
    public static final EnterpriseAuthManager INSTANCE = new EnterpriseAuthManager();
    private static final CoroutineExceptionHandler exceptionHandler = new C0831x118d8ace(CoroutineExceptionHandler.Key);

    /* compiled from: EnterpriseAuthManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseAuthManager$Callback;", "", "onSuccess", "", "onFailure", "errorMessage", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Callback {
        void onFailure(String errorMessage);

        void onSuccess();
    }

    private final String mapEnterpriseCodeToAuthCode(int code) {
        if (code == 30011) {
            return "20101";
        }
        if (code == 30021 || code == 30022) {
            return "20311";
        }
        return null;
    }

    private EnterpriseAuthManager() {
    }

    public final void registerProvider() {
        TraeAuthManager.INSTANCE.setEnterpriseExchangeProvider(new EnterpriseAuthManager$registerProvider$1(this));
        EnterpriseProfileRefresher.INSTANCE.setRefreshProvider(new EnterpriseAuthManager$registerProvider$2(this));
        EnterpriseProfileRefresher.INSTANCE.setUpdateProfileProvider(new EnterpriseAuthManager$registerProvider$3(this));
    }

    public final boolean isEnterpriseLogin() {
        return Intrinsics.areEqual(TraeAuthStorage.INSTANCE.getLoginPlatform(), "enterprise");
    }

    public final CheckLoginConfigResult checkLoginConfig(String email) {
        String str;
        Intrinsics.checkNotNullParameter(email, "email");
        String str2 = null;
        EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), null, false, 52, null);
        RequestContext requestContext = new RequestContext();
        requestContext.force_handle_response = true;
        SsResponse<String> execute = enterpriseAuthApi.checkLoginConfig(new CheckLoginConfigRequest(email, 0, 2, null), requestContext).execute();
        String body = execute.body();
        if (body == null) {
            TypedInput errorBody = execute.errorBody();
            if (errorBody != null) {
                InputStream mo349in = errorBody.mo349in();
                Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    body = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            } else {
                body = null;
            }
        }
        if (body == null) {
            String string = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            throw new EnterpriseAuthException("checkLoginConfig response body is null", string, 0, null, 12, null);
        }
        EnterpriseResponse parseEnterpriseResponse = parseEnterpriseResponse(body, CheckLoginConfigResult.class);
        if (parseEnterpriseResponse.getCode() != 0) {
            String mapErrorCodeToMessage = mapErrorCodeToMessage(parseEnterpriseResponse.getCode());
            if (mapErrorCodeToMessage == null) {
                String message = parseEnterpriseResponse.getMessage();
                if (message != null) {
                    if (message.length() > 0) {
                        str2 = message;
                    }
                }
                if (str2 == null) {
                    mapErrorCodeToMessage = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
                    Intrinsics.checkNotNullExpressionValue(mapErrorCodeToMessage, "getString(...)");
                } else {
                    str = str2;
                    throw new EnterpriseAuthException("checkLoginConfig business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
                }
            }
            str = mapErrorCodeToMessage;
            throw new EnterpriseAuthException("checkLoginConfig business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
        }
        CheckLoginConfigResult checkLoginConfigResult = (CheckLoginConfigResult) parseEnterpriseResponse.getData();
        if (checkLoginConfigResult != null) {
            return checkLoginConfigResult;
        }
        String string2 = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        throw new EnterpriseAuthException("checkLoginConfig data is null", string2, 0, null, 12, null);
    }

    public final void loginWithSsoSession(CoroutineScope callerScope, String email, String tobSession, Callback callback) {
        Intrinsics.checkNotNullParameter(callerScope, "callerScope");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(tobSession, "tobSession");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt.launch$default(callerScope, Dispatchers.getIO().plus(exceptionHandler), (CoroutineStart) null, new EnterpriseAuthManager$loginWithSsoSession$1(email, tobSession, callback, null), 2, (Object) null);
    }

    public final void login(CoroutineScope callerScope, String email, String password, Callback callback) {
        Intrinsics.checkNotNullParameter(callerScope, "callerScope");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt.launch$default(callerScope, Dispatchers.getIO().plus(exceptionHandler), (CoroutineStart) null, new EnterpriseAuthManager$login$1(email, password, callback, null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void completeTokenFlow(String email, String tobSession) {
        long currentTimeMillis = System.currentTimeMillis();
        EnterpriseGetRefreshTokenResult doGetRefreshToken = doGetRefreshToken(tobSession);
        TraeAuthManager.INSTANCE.reportStepDuration("getRefreshToken", "enterprise", System.currentTimeMillis() - currentTimeMillis);
        String refreshToken = doGetRefreshToken.getRefreshToken();
        String str = refreshToken;
        if (str == null || str.length() == 0) {
            String string = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            throw new EnterpriseAuthException("refreshToken is empty", string, 0, "getRefreshToken", 4, null);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        EnterpriseExchangeTokenResult doExchangeToken = doExchangeToken(refreshToken);
        TraeAuthManager.INSTANCE.reportStepDuration("exchangeToken", "enterprise", System.currentTimeMillis() - currentTimeMillis2);
        String token = doExchangeToken.getToken();
        String str2 = token;
        if (str2 == null || str2.length() == 0) {
            String string2 = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            throw new EnterpriseAuthException("exchange token is empty", string2, 0, "exchangeToken", 4, null);
        }
        TraeAuthStorage.INSTANCE.saveJwtToken(token, doExchangeToken.getTokenExpireAt());
        String refreshToken2 = doExchangeToken.getRefreshToken();
        if (refreshToken2 != null) {
            TraeAuthStorage.INSTANCE.saveRefreshToken(refreshToken2, doExchangeToken.getRefreshExpireAt());
        }
        TraeAuthStorage.INSTANCE.saveLoginPlatform("enterprise");
        TraeAuthStorage.INSTANCE.saveLastExchangeSuccessAt(System.currentTimeMillis() / BytePatchException.ErrorCode.paramsError);
        long currentTimeMillis3 = System.currentTimeMillis();
        EnterpriseGetUserInfoData fetchUserInfo = fetchUserInfo(token);
        TraeAuthManager.INSTANCE.reportStepDuration("fetchUserInfo", "enterprise", System.currentTimeMillis() - currentTimeMillis3);
        TraeAuthStorage.INSTANCE.saveUserInfo(buildUserInfo(email, fetchUserInfo));
        AccountHelper.INSTANCE.loginStatusChanged(AccountStatus.LOGGED_IN, "", LoginPlatform.ENTERPRISE);
        EnterprisePassportLogin.INSTANCE.login(token, new EnterprisePassportLogin.Callback() { // from class: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$completeTokenFlow$2
            @Override // com.bytedance.trae.login.enterprise.EnterprisePassportLogin.Callback
            public void onSuccess(long userId) {
                FLogger.INSTANCE.mo428i("EnterpriseAuthManager", "Enterprise passport login success, userId=" + userId);
            }

            @Override // com.bytedance.trae.login.enterprise.EnterprisePassportLogin.Callback
            public void onError(int errorCode, String errorMessage) {
                FLogger.INSTANCE.mo426e("EnterpriseAuthManager", "Enterprise passport login failed (degraded): code=" + errorCode + ", msg=" + errorMessage);
            }
        });
    }

    private final EnterpriseGetUserInfoData fetchUserInfo(String token) {
        try {
            EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), MapsKt.mapOf(TuplesKt.to("x-cloudide-token", token)), false, 36, null);
            RequestContext requestContext = new RequestContext();
            requestContext.force_handle_response = true;
            SsResponse<String> execute = enterpriseAuthApi.getUserInfo(requestContext).execute();
            String body = execute.body();
            if (body == null) {
                TypedInput errorBody = execute.errorBody();
                if (errorBody != null) {
                    InputStream mo349in = errorBody.mo349in();
                    Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                    Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        body = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                    } finally {
                    }
                } else {
                    body = null;
                }
            }
            if (body == null) {
                FLogger.INSTANCE.mo430w(TAG, "getUserInfo: response body is null");
                return null;
            }
            EnterpriseResponse parseEnterpriseResponse = parseEnterpriseResponse(body, EnterpriseGetUserInfoData.class);
            if (parseEnterpriseResponse.getCode() != 0) {
                FLogger.INSTANCE.mo430w(TAG, "getUserInfo: business error code=" + parseEnterpriseResponse.getCode());
                return null;
            }
            return (EnterpriseGetUserInfoData) parseEnterpriseResponse.getData();
        } catch (Exception e) {
            FLogger.INSTANCE.mo430w(TAG, "getUserInfo failed (degraded): " + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final UserInfo buildUserInfo(String email, EnterpriseGetUserInfoData data) {
        String str;
        String str2;
        String str3;
        String tenantId;
        String str4;
        String aiRegion;
        Integer productType;
        String tenantName;
        String email2;
        String avatar;
        String name;
        String userId;
        EnterpriseUserInfo userInfo = data != null ? data.getUserInfo() : null;
        EnterpriseTenantInfo tenantInfoBase = data != null ? data.getTenantInfoBase() : null;
        int i = 0;
        if (userInfo != null && (userId = userInfo.getUserId()) != null) {
            if (!(userId.length() > 0)) {
                userId = null;
            }
            if (userId != null) {
                str = userId;
                if (userInfo != null && (name = userInfo.getName()) != null) {
                    if (!(name.length() <= 0)) {
                        name = null;
                    }
                    if (name != null) {
                        str2 = name;
                        String str5 = (userInfo != null || (avatar = userInfo.getAvatar()) == null) ? "" : avatar;
                        if (userInfo != null && (email2 = userInfo.getEmail()) != null) {
                            if (!(email2.length() > 0)) {
                                email2 = null;
                            }
                            if (email2 != null) {
                                str3 = email2;
                                if (tenantInfoBase != null || (tenantId = tenantInfoBase.getTenantId()) == null) {
                                    tenantId = userInfo == null ? userInfo.getTenantId() : null;
                                    if (tenantId == null) {
                                        str4 = "";
                                        String str6 = (tenantInfoBase != null || (tenantName = tenantInfoBase.getTenantName()) == null) ? "" : tenantName;
                                        if (tenantInfoBase != null && (productType = tenantInfoBase.getProductType()) != null) {
                                            i = productType.intValue();
                                        }
                                        return new UserInfo(str, str2, str5, null, str3, null, str4, str6, i, (userInfo != null || (aiRegion = userInfo.getAiRegion()) == null) ? "" : aiRegion, null, data != null ? data.getPrivacyMode() : null, 1064, null);
                                    }
                                }
                                str4 = tenantId;
                                if (tenantInfoBase != null) {
                                }
                                if (tenantInfoBase != null) {
                                    i = productType.intValue();
                                }
                                return new UserInfo(str, str2, str5, null, str3, null, str4, str6, i, (userInfo != null || (aiRegion = userInfo.getAiRegion()) == null) ? "" : aiRegion, null, data != null ? data.getPrivacyMode() : null, 1064, null);
                            }
                        }
                        str3 = email;
                        if (tenantInfoBase != null) {
                        }
                        if (userInfo == null) {
                        }
                        if (tenantId == null) {
                        }
                        str4 = tenantId;
                        if (tenantInfoBase != null) {
                        }
                        if (tenantInfoBase != null) {
                        }
                        return new UserInfo(str, str2, str5, null, str3, null, str4, str6, i, (userInfo != null || (aiRegion = userInfo.getAiRegion()) == null) ? "" : aiRegion, null, data != null ? data.getPrivacyMode() : null, 1064, null);
                    }
                }
                str2 = email;
                if (userInfo != null) {
                }
                if (userInfo != null) {
                    if (!(email2.length() > 0)) {
                    }
                    if (email2 != null) {
                    }
                }
                str3 = email;
                if (tenantInfoBase != null) {
                }
                if (userInfo == null) {
                }
                if (tenantId == null) {
                }
                str4 = tenantId;
                if (tenantInfoBase != null) {
                }
                if (tenantInfoBase != null) {
                }
                return new UserInfo(str, str2, str5, null, str3, null, str4, str6, i, (userInfo != null || (aiRegion = userInfo.getAiRegion()) == null) ? "" : aiRegion, null, data != null ? data.getPrivacyMode() : null, 1064, null);
            }
        }
        str = email;
        if (userInfo != null) {
            if (!(name.length() <= 0)) {
            }
            if (name != null) {
            }
        }
        str2 = email;
        if (userInfo != null) {
        }
        if (userInfo != null) {
        }
        str3 = email;
        if (tenantInfoBase != null) {
        }
        if (userInfo == null) {
        }
        if (tenantId == null) {
        }
        str4 = tenantId;
        if (tenantInfoBase != null) {
        }
        if (tenantInfoBase != null) {
        }
        return new UserInfo(str, str2, str5, null, str3, null, str4, str6, i, (userInfo != null || (aiRegion = userInfo.getAiRegion()) == null) ? "" : aiRegion, null, data != null ? data.getPrivacyMode() : null, 1064, null);
    }

    private final AccountInfo toAccountInfo(UserInfo userInfo) {
        return new AccountInfo(true, "enterprise", userInfo.getUserId(), "", 0, userInfo.getAvatarUrl(), userInfo.getScreenName(), userInfo.getEmail(), "", userInfo.getTenantId(), userInfo.getAiRegion(), userInfo.getProductType(), null, userInfo.getTenantName(), userInfo.getSaasPrivacyMode(), 4096, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object refreshEnterpriseUserInfo(String str, Continuation<? super AccountInfo> continuation) {
        UserInfo userInfo = TraeAuthStorage.INSTANCE.getUserInfo();
        EnterpriseGetUserInfoData fetchUserInfo = fetchUserInfo(str);
        if (fetchUserInfo == null) {
            return null;
        }
        String email = userInfo != null ? userInfo.getEmail() : null;
        if (email == null) {
            email = "";
        }
        UserInfo buildUserInfo = buildUserInfo(email, fetchUserInfo);
        TraeAuthStorage.INSTANCE.saveUserInfo(buildUserInfo);
        return toAccountInfo(buildUserInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateEnterpriseUserProfile(Map<String, String> map, Continuation<? super Boolean> continuation) {
        EnterpriseResponse parseEnterpriseResponse;
        SetUserInfoRequest buildSetUserInfoRequest = buildSetUserInfoRequest(map);
        boolean z = false;
        if (buildSetUserInfoRequest == null) {
            return Boxing.boxBoolean(false);
        }
        String jwtToken = TraeAuthStorage.INSTANCE.getJwtToken();
        String str = null;
        if (!(!StringsKt.isBlank(jwtToken))) {
            jwtToken = null;
        }
        if (jwtToken == null) {
            return Boxing.boxBoolean(false);
        }
        EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), MapsKt.mapOf(TuplesKt.to("X-Cloudide-Token", jwtToken)), false, 36, null);
        RequestContext requestContext = new RequestContext();
        requestContext.force_handle_response = true;
        try {
            SsResponse<String> execute = enterpriseAuthApi.setUserInfo(buildSetUserInfoRequest, requestContext).execute();
            String body = execute.body();
            if (body == null) {
                TypedInput errorBody = execute.errorBody();
                if (errorBody != null) {
                    InputStream mo349in = errorBody.mo349in();
                    Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                    Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    try {
                        String readText = TextStreamsKt.readText(bufferedReader);
                        CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                        str = readText;
                    } finally {
                    }
                }
            } else {
                str = body;
            }
        } catch (Exception e) {
            e = e;
        }
        if (str == null) {
            FLogger.INSTANCE.mo430w(TAG, "setUserInfo response body is null");
            return Boxing.boxBoolean(false);
        }
        try {
            parseEnterpriseResponse = parseEnterpriseResponse(str, Object.class);
        } catch (Exception e2) {
            e = e2;
            FLogger.INSTANCE.mo430w(TAG, "setUserInfo failed: " + e.getMessage());
            return Boxing.boxBoolean(z);
        }
        if (parseEnterpriseResponse.getCode() != 0) {
            FLogger.INSTANCE.mo430w(TAG, "setUserInfo business error: code=" + parseEnterpriseResponse.getCode() + ", message=" + parseEnterpriseResponse.getMessage());
            return Boxing.boxBoolean(false);
        }
        z = true;
        return Boxing.boxBoolean(z);
    }

    private final SetUserInfoRequest buildSetUserInfoRequest(Map<String, String> params) {
        String str = params.get("name");
        if (str == null || !(!StringsKt.isBlank(str))) {
            str = null;
        }
        String str2 = params.get("avatar");
        if (str2 == null || !(!StringsKt.isBlank(str2))) {
            str2 = null;
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new SetUserInfoRequest(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<EnterpriseAccountLoginResult, String> doAccountLogin(String email, String password) {
        String str;
        String str2;
        String str3;
        EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), null, false, 52, null);
        RequestContext requestContext = new RequestContext();
        requestContext.force_handle_response = true;
        SsResponse<String> execute = enterpriseAuthApi.accountLogin(new EnterpriseAccountLoginRequest(email, password), requestContext).execute();
        execute.code();
        List<Header> headers = execute.headers();
        Intrinsics.checkNotNullExpressionValue(headers, "headers(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : headers) {
            if (StringsKt.equals(((Header) obj).getName(), "Set-Cookie", true)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            Header header = (Header) it.next();
            EnterpriseAuthManager enterpriseAuthManager = INSTANCE;
            String value = header.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            str2 = enterpriseAuthManager.extractCookieValue(value, TOB_SESSION_COOKIE_NAME);
            if (str2 != null) {
                break;
            }
        }
        String body = execute.body();
        if (body == null) {
            TypedInput errorBody = execute.errorBody();
            if (errorBody != null) {
                InputStream mo349in = errorBody.mo349in();
                Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    body = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            } else {
                body = null;
            }
        }
        if (body == null) {
            String string = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            throw new EnterpriseAuthException("accountLogin response body is null", string, 0, null, 12, null);
        }
        EnterpriseResponse parseEnterpriseResponse = parseEnterpriseResponse(body, EnterpriseAccountLoginResult.class);
        if (parseEnterpriseResponse.getCode() != 0) {
            String mapErrorCodeToMessage = mapErrorCodeToMessage(parseEnterpriseResponse.getCode());
            if (mapErrorCodeToMessage == null) {
                String message = parseEnterpriseResponse.getMessage();
                if (message != null) {
                    if (message.length() > 0) {
                        str = message;
                    }
                }
                if (str == null) {
                    mapErrorCodeToMessage = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
                    Intrinsics.checkNotNullExpressionValue(mapErrorCodeToMessage, "getString(...)");
                } else {
                    str3 = str;
                    throw new EnterpriseAuthException("accountLogin business error: code=" + parseEnterpriseResponse.getCode(), str3, 0, null, 12, null);
                }
            }
            str3 = mapErrorCodeToMessage;
            throw new EnterpriseAuthException("accountLogin business error: code=" + parseEnterpriseResponse.getCode(), str3, 0, null, 12, null);
        }
        EnterpriseAccountLoginResult enterpriseAccountLoginResult = (EnterpriseAccountLoginResult) parseEnterpriseResponse.getData();
        if (enterpriseAccountLoginResult == null) {
            String string2 = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            throw new EnterpriseAuthException("accountLogin data is null", string2, 0, null, 12, null);
        }
        return new Pair<>(enterpriseAccountLoginResult, str2);
    }

    private final EnterpriseGetRefreshTokenResult doGetRefreshToken(String tobSession) {
        EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), MapsKt.mapOf(new Pair[]{TuplesKt.to("Cookie", "X-Cloudide-Tob-Session=" + tobSession), TuplesKt.to(TOB_SESSION_COOKIE_NAME, tobSession)}), false, 36, null);
        RequestContext requestContext = new RequestContext();
        requestContext.force_handle_response = true;
        String deviceId = IApplog.Companion.getDeviceId();
        String str = null;
        if (!(!StringsKt.isBlank(deviceId))) {
            deviceId = null;
        }
        if (deviceId == null) {
            deviceId = IApplog.Companion.getClientDid();
            if (!(!StringsKt.isBlank(deviceId))) {
                deviceId = null;
            }
            if (deviceId == null) {
                deviceId = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(deviceId, "toString(...)");
            }
        }
        SsResponse<String> execute = enterpriseAuthApi.getRefreshToken(new EnterpriseGetRefreshTokenRequest(deviceId, 0, 2, null), requestContext).execute();
        String body = execute.body();
        if (body == null) {
            TypedInput errorBody = execute.errorBody();
            if (errorBody != null) {
                InputStream mo349in = errorBody.mo349in();
                Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    body = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            } else {
                body = null;
            }
        }
        if (body == null) {
            String string = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            throw new EnterpriseAuthException("getRefreshToken response body is null", string, 0, null, 12, null);
        }
        EnterpriseResponse parseEnterpriseResponse = parseEnterpriseResponse(body, EnterpriseGetRefreshTokenResult.class);
        if (parseEnterpriseResponse.getCode() != 0) {
            String mapErrorCodeToMessage = mapErrorCodeToMessage(parseEnterpriseResponse.getCode());
            if (mapErrorCodeToMessage == null) {
                String message = parseEnterpriseResponse.getMessage();
                if (message != null) {
                    if (message.length() > 0) {
                        str = message;
                    }
                }
                if (str == null) {
                    mapErrorCodeToMessage = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
                    Intrinsics.checkNotNullExpressionValue(mapErrorCodeToMessage, "getString(...)");
                }
                throw new EnterpriseAuthException("getRefreshToken business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
            }
            str = mapErrorCodeToMessage;
            throw new EnterpriseAuthException("getRefreshToken business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
        }
        EnterpriseGetRefreshTokenResult enterpriseGetRefreshTokenResult = (EnterpriseGetRefreshTokenResult) parseEnterpriseResponse.getData();
        if (enterpriseGetRefreshTokenResult != null) {
            return enterpriseGetRefreshTokenResult;
        }
        String string2 = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        throw new EnterpriseAuthException("getRefreshToken data is null", string2, 0, null, 12, null);
    }

    private final EnterpriseExchangeTokenResult doExchangeToken(String refreshToken) {
        String str;
        EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), null, false, 52, null);
        RequestContext requestContext = new RequestContext();
        requestContext.force_handle_response = true;
        SsResponse<String> execute = enterpriseAuthApi.exchangeToken(new EnterpriseExchangeTokenRequest(refreshToken), requestContext).execute();
        String body = execute.body();
        String str2 = null;
        if (body == null) {
            TypedInput errorBody = execute.errorBody();
            if (errorBody != null) {
                InputStream mo349in = errorBody.mo349in();
                Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    body = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            } else {
                body = null;
            }
        }
        if (body == null) {
            String string = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            throw new EnterpriseAuthException("exchangeToken response body is null", string, 0, null, 12, null);
        }
        EnterpriseResponse parseEnterpriseResponse = parseEnterpriseResponse(body, EnterpriseExchangeTokenResult.class);
        if (parseEnterpriseResponse.getCode() != 0) {
            String mapErrorCodeToMessage = mapErrorCodeToMessage(parseEnterpriseResponse.getCode());
            if (mapErrorCodeToMessage == null) {
                String message = parseEnterpriseResponse.getMessage();
                if (message != null) {
                    if (message.length() > 0) {
                        str2 = message;
                    }
                }
                if (str2 == null) {
                    mapErrorCodeToMessage = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
                    Intrinsics.checkNotNullExpressionValue(mapErrorCodeToMessage, "getString(...)");
                } else {
                    str = str2;
                    throw new EnterpriseAuthException("exchangeToken business error: code=" + parseEnterpriseResponse.getCode(), str, parseEnterpriseResponse.getCode(), null, 8, null);
                }
            }
            str = mapErrorCodeToMessage;
            throw new EnterpriseAuthException("exchangeToken business error: code=" + parseEnterpriseResponse.getCode(), str, parseEnterpriseResponse.getCode(), null, 8, null);
        }
        EnterpriseExchangeTokenResult enterpriseExchangeTokenResult = (EnterpriseExchangeTokenResult) parseEnterpriseResponse.getData();
        if (enterpriseExchangeTokenResult != null) {
            return enterpriseExchangeTokenResult;
        }
        String string2 = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        throw new EnterpriseAuthException("exchangeToken data is null", string2, 0, null, 12, null);
    }

    public final void sendEmailVerification(String email) {
        String str;
        Intrinsics.checkNotNullParameter(email, "email");
        String str2 = null;
        EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), null, false, 52, null);
        RequestContext requestContext = new RequestContext();
        requestContext.force_handle_response = true;
        SsResponse<String> execute = enterpriseAuthApi.sendEmailVerification(new SendEmailVerificationRequest(email, 0, 2, null), requestContext).execute();
        String body = execute.body();
        if (body == null) {
            TypedInput errorBody = execute.errorBody();
            if (errorBody != null) {
                InputStream mo349in = errorBody.mo349in();
                Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    body = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            } else {
                body = null;
            }
        }
        if (body == null) {
            String string = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            throw new EnterpriseAuthException("sendEmailVerification response body is null", string, 0, null, 12, null);
        }
        EnterpriseResponse parseEnterpriseResponse = parseEnterpriseResponse(body, Object.class);
        if (parseEnterpriseResponse.getCode() != 0) {
            String mapErrorCodeToMessage = mapErrorCodeToMessage(parseEnterpriseResponse.getCode());
            if (mapErrorCodeToMessage == null) {
                String message = parseEnterpriseResponse.getMessage();
                if (message != null) {
                    if (message.length() > 0) {
                        str2 = message;
                    }
                }
                if (str2 == null) {
                    mapErrorCodeToMessage = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
                    Intrinsics.checkNotNullExpressionValue(mapErrorCodeToMessage, "getString(...)");
                } else {
                    str = str2;
                    throw new EnterpriseAuthException("sendEmailVerification business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
                }
            }
            str = mapErrorCodeToMessage;
            throw new EnterpriseAuthException("sendEmailVerification business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
        }
    }

    public final GetCodeInfoResult getCodeInfo(String code) {
        String str;
        Intrinsics.checkNotNullParameter(code, "code");
        String str2 = null;
        EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), null, false, 52, null);
        RequestContext requestContext = new RequestContext();
        requestContext.force_handle_response = true;
        SsResponse<String> execute = enterpriseAuthApi.getCodeInfo(new GetCodeInfoRequest(code, 0, 2, null), requestContext).execute();
        String body = execute.body();
        if (body == null) {
            TypedInput errorBody = execute.errorBody();
            if (errorBody != null) {
                InputStream mo349in = errorBody.mo349in();
                Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    body = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            } else {
                body = null;
            }
        }
        if (body == null) {
            String string = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            throw new EnterpriseAuthException("getCodeInfo response body is null", string, 0, null, 12, null);
        }
        EnterpriseResponse parseEnterpriseResponse = parseEnterpriseResponse(body, GetCodeInfoResult.class);
        if (parseEnterpriseResponse.getCode() != 0) {
            String mapErrorCodeToMessage = mapErrorCodeToMessage(parseEnterpriseResponse.getCode());
            if (mapErrorCodeToMessage == null) {
                String message = parseEnterpriseResponse.getMessage();
                if (message != null) {
                    if (message.length() > 0) {
                        str2 = message;
                    }
                }
                if (str2 == null) {
                    mapErrorCodeToMessage = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
                    Intrinsics.checkNotNullExpressionValue(mapErrorCodeToMessage, "getString(...)");
                } else {
                    str = str2;
                    throw new EnterpriseAuthException("getCodeInfo business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
                }
            }
            str = mapErrorCodeToMessage;
            throw new EnterpriseAuthException("getCodeInfo business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
        }
        GetCodeInfoResult getCodeInfoResult = (GetCodeInfoResult) parseEnterpriseResponse.getData();
        if (getCodeInfoResult != null) {
            return getCodeInfoResult;
        }
        String string2 = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        throw new EnterpriseAuthException("getCodeInfo data is null", string2, 0, null, 12, null);
    }

    public final void setUserPassword(String email, String password, String code) {
        String str;
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(code, "code");
        EnterpriseAuthApi enterpriseAuthApi = (EnterpriseAuthApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_auth", EnterpriseAuthApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), null, false, 52, null);
        RequestContext requestContext = new RequestContext();
        requestContext.force_handle_response = true;
        SsResponse<String> execute = enterpriseAuthApi.setUserPassword(new SetUserPasswordRequest(email, password, code), requestContext).execute();
        String body = execute.body();
        String str2 = null;
        if (body == null) {
            TypedInput errorBody = execute.errorBody();
            if (errorBody != null) {
                InputStream mo349in = errorBody.mo349in();
                Intrinsics.checkNotNullExpressionValue(mo349in, "in(...)");
                Reader inputStreamReader = new InputStreamReader(mo349in, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    body = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, (Throwable) null);
                } finally {
                }
            } else {
                body = null;
            }
        }
        if (body == null) {
            String string = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            throw new EnterpriseAuthException("setUserPassword response body is null", string, 0, null, 12, null);
        }
        EnterpriseResponse parseEnterpriseResponse = parseEnterpriseResponse(body, Object.class);
        if (parseEnterpriseResponse.getCode() != 0) {
            String mapErrorCodeToMessage = mapErrorCodeToMessage(parseEnterpriseResponse.getCode());
            if (mapErrorCodeToMessage == null) {
                String message = parseEnterpriseResponse.getMessage();
                if (message != null) {
                    if (message.length() > 0) {
                        str2 = message;
                    }
                }
                if (str2 == null) {
                    mapErrorCodeToMessage = AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_service);
                    Intrinsics.checkNotNullExpressionValue(mapErrorCodeToMessage, "getString(...)");
                } else {
                    str = str2;
                    throw new EnterpriseAuthException("setUserPassword business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
                }
            }
            str = mapErrorCodeToMessage;
            throw new EnterpriseAuthException("setUserPassword business error: code=" + parseEnterpriseResponse.getCode(), str, 0, null, 12, null);
        }
    }

    private final String extractCookieValue(String cookieString, String cookieName) {
        Iterator it = StringsKt.split$default(cookieString, new String[]{";"}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            String obj = StringsKt.trim((String) it.next()).toString();
            if (StringsKt.startsWith(obj, cookieName + '=', true)) {
                return StringsKt.substringAfter(obj, "=", "");
            }
        }
        return null;
    }

    private final <T> EnterpriseResponse<T> parseEnterpriseResponse(String bodyStr, Class<T> clazz) {
        Object fromJson = TraeHttpConnection.INSTANCE.getHttpGson().fromJson(bodyStr, TypeToken.getParameterized(EnterpriseResponse.class, new Type[]{clazz}).getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        return (EnterpriseResponse) fromJson;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: Exception -> 0x004c, TraeAuthException -> 0x0073, EnterpriseAuthException -> 0x0075, TryCatch #2 {EnterpriseAuthException -> 0x0075, TraeAuthException -> 0x0073, Exception -> 0x004c, blocks: (B:2:0x0000, B:4:0x000c, B:9:0x0018, B:12:0x0039, B:13:0x004b), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[Catch: Exception -> 0x004c, TraeAuthException -> 0x0073, EnterpriseAuthException -> 0x0075, TryCatch #2 {EnterpriseAuthException -> 0x0075, TraeAuthException -> 0x0073, Exception -> 0x004c, blocks: (B:2:0x0000, B:4:0x000c, B:9:0x0018, B:12:0x0039, B:13:0x004b), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final TraeExchangeTokenResult exchangeTokenForRefresh(String refreshToken) {
        boolean z;
        try {
            EnterpriseExchangeTokenResult doExchangeToken = doExchangeToken(refreshToken);
            String token = doExchangeToken.getToken();
            if (token != null && token.length() != 0) {
                z = false;
                if (!z) {
                    throw new TraeAuthException(null, "exchangeTokenForRefresh returned empty token", true, null, null, null, null, null, 248, null);
                }
                return new TraeExchangeTokenResult(null, null, doExchangeToken.getToken(), doExchangeToken.getTokenExpireAt(), doExchangeToken.getRefreshToken(), doExchangeToken.getRefreshExpireAt(), doExchangeToken.getTokenExpireDuration(), null, 131, null);
            }
            z = true;
            if (!z) {
            }
        } catch (EnterpriseAuthException e) {
            throw new TraeAuthException(mapEnterpriseCodeToAuthCode(e.getErrorCode()), "exchangeTokenForRefresh: " + e.getMessage(), false, null, e.getUserMessage(), null, null, null, 232, null);
        } catch (TraeAuthException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new TraeAuthException(null, "exchangeTokenForRefresh network error: " + e3.getMessage(), false, e3, null, null, null, null, 240, null);
        }
    }

    private final String mapErrorCodeToMessage(int code) {
        int i;
        if (code == 2001) {
            i = C0882R.string.trae_enterprise_error_service;
        } else if (code == 30001) {
            i = C0882R.string.trae_enterprise_error_email_registered;
        } else if (code == 30003) {
            i = C0882R.string.trae_enterprise_error_seat_over_limit;
        } else if (code == 30036) {
            i = C0882R.string.trae_enterprise_error_too_many_attempts;
        } else if (code == 30040 || code == 30048) {
            i = C0882R.string.trae_enterprise_error_email_rate_limit;
        } else if (code == 30015) {
            i = C0882R.string.trae_enterprise_error_password_not_match;
        } else if (code == 30016) {
            i = C0882R.string.trae_enterprise_error_subscription_expired;
        } else if (code == 30024) {
            i = C0882R.string.trae_enterprise_error_code_invalid;
        } else if (code == 30025) {
            i = C0882R.string.trae_enterprise_error_code_expired;
        } else if (code == 30028) {
            i = C0882R.string.trae_enterprise_error_sso_not_enabled;
        } else if (code == 30029) {
            i = C0882R.string.trae_enterprise_error_link_expired;
        } else if (code == 30031) {
            i = C0882R.string.trae_enterprise_error_sso_email_not_match;
        } else if (code != 30032) {
            switch (code) {
                case 30005:
                    i = C0882R.string.trae_enterprise_error_code_invalid_or_expired;
                    break;
                case 30006:
                    i = C0882R.string.trae_enterprise_error_code_invalid;
                    break;
                case 30007:
                    i = C0882R.string.trae_enterprise_error_account_not_exist;
                    break;
                case 30008:
                    i = C0882R.string.trae_enterprise_error_account_belong_other;
                    break;
                case 30009:
                    i = C0882R.string.trae_enterprise_error_account_status;
                    break;
                case 30010:
                    i = C0882R.string.trae_enterprise_error_session_expired;
                    break;
                case 30011:
                    i = C0882R.string.trae_enterprise_error_not_login;
                    break;
                case 30012:
                    i = C0882R.string.trae_enterprise_error_use_sso;
                    break;
                case 30013:
                    i = C0882R.string.trae_enterprise_error_subscription_expired;
                    break;
                default:
                    switch (code) {
                        case 30019:
                            i = C0882R.string.trae_enterprise_error_password_invalid;
                            break;
                        case 30020:
                            i = C0882R.string.trae_enterprise_error_sso_account_not_exist;
                            break;
                        case 30021:
                            i = C0882R.string.trae_enterprise_error_token_invalid;
                            break;
                        case 30022:
                            i = C0882R.string.trae_enterprise_error_token_expired;
                            break;
                        default:
                            i = C0882R.string.trae_enterprise_error_service;
                            break;
                    }
            }
        } else {
            i = C0882R.string.trae_enterprise_error_account_not_active;
        }
        return AppHost.Companion.getApplication().getString(i);
    }
}

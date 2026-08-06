package com.bytedance.sdk.account.platform.douyin;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.platform.base.Request;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.authorize.model.VerifyObject;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
import java.lang.ref.SoftReference;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class Douyin {
    public static final String ERROR_INVALID_RESPONSE = "invalid_response";
    public static final String ERROR_RESPONSE_NULL = "response null";
    static final String PLATFORM = "aweme";
    private static SoftReference<Request> currentRequest = null;
    public static boolean didCallback = true;
    private static SoftReference<AuthorizeCallback> sAuthorizeCallBack;

    public static boolean authorize(DouYinOpenApi douYinOpenApi, Request request, AuthorizeCallback authorizeCallback) {
        didCallback = false;
        try {
            if (douYinOpenApi == null) {
                reset();
                return false;
            }
            sAuthorizeCallBack = new SoftReference<>(authorizeCallback);
            currentRequest = new SoftReference<>(request);
            Authorization.Request buildRequest = buildRequest(request);
            if (douYinOpenApi.isAppSupportAuthorization()) {
                return douYinOpenApi.authorize(buildRequest);
            }
            return douYinOpenApi.authorizeWeb(buildRequest);
        } catch (Exception e) {
            reset();
            e.printStackTrace();
            return false;
        }
    }

    public static boolean authorizeWeb(DouYinOpenApi douYinOpenApi, Request request, AuthorizeCallback authorizeCallback) {
        didCallback = false;
        try {
            if (douYinOpenApi == null) {
                reset();
                return false;
            }
            sAuthorizeCallBack = new SoftReference<>(authorizeCallback);
            currentRequest = new SoftReference<>(request);
            return douYinOpenApi.authorizeWeb(buildRequest(request));
        } catch (Exception e) {
            reset();
            e.printStackTrace();
            return false;
        }
    }

    public static boolean authorizeInThirdApp(DouYinOpenApi douYinOpenApi, Request request, AuthorizeCallback authorizeCallback) {
        didCallback = false;
        try {
            if (douYinOpenApi == null) {
                reset();
                return false;
            }
            sAuthorizeCallBack = new SoftReference<>(authorizeCallback);
            currentRequest = new SoftReference<>(request);
            return douYinOpenApi.authorizeInThirdApp(buildRequest(request));
        } catch (Exception e) {
            reset();
            e.printStackTrace();
            return false;
        }
    }

    private static Authorization.Request buildRequest(Request request) {
        Authorization.Request request2 = new Authorization.Request();
        String scopes = getScopes(request.scopes);
        String scopes2 = getScopes(request.optionalScopes0);
        String scopes3 = getScopes(request.optionalScopes1);
        String str = request.callerLocalEntry;
        String str2 = request.state;
        if (!TextUtils.isEmpty(scopes)) {
            request2.scope = scopes;
        }
        if (!TextUtils.isEmpty(scopes2)) {
            request2.optionalScope0 = scopes2;
        }
        if (!TextUtils.isEmpty(scopes3)) {
            request2.optionalScope1 = scopes3;
        }
        if (!TextUtils.isEmpty(str2)) {
            request2.state = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            request2.callerLocalEntry = str;
        }
        request2.extras = request.extra;
        request2.verifyObject = new VerifyObject(request.extra.getString(IDouYin2Service.Extra.VERIFY_SCOPE), request.extra.getString(IDouYin2Service.Extra.VERIFY_TIC), request.extra.getString(IDouYin2Service.Extra.VERIFY_OPENID));
        request2.isThridAuthDialog = request.extra.getBoolean(IDouYin2Service.Extra.IS_THIRD_AUTH_DIALOG);
        request2.authTicket = request.authTicket;
        request2.maskPhoneNumber = request.maskPhoneNumber;
        request2.isSkipUIInThirdAuth = request.extra.getBoolean(IDouYin2Service.Extra.IS_SKIP_UI_IN_THIRD_AUTH);
        request2.thirdAuthScene = request.extra.getString(IDouYin2Service.Extra.THIRD_AUTH_SCENE);
        request2.commentId = request.extra.getString("comment_id");
        return request2;
    }

    private static String getScopes(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb.append(IWeiboService.Scope.EMPTY_SCOPE);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }

    public static void authorizeCallback(Authorization.Response response) {
        AuthorizeCallback authorizeCallback;
        didCallback = true;
        if (response == null) {
            onAuthorizeFailed(Integer.MAX_VALUE, "response null", null);
            return;
        }
        int i = response.errorCode;
        if (i == 0) {
            String str = response.authCode;
            String str2 = response.state;
            String str3 = response.grantedPermissions;
            if (str != null) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("auth_code", str);
                        bundle.putString("state", str2);
                        bundle.putString("granted_permission", str3);
                        bundle.putBundle("extras", response.extras);
                        AuthorizeMonitorUtil.onPlatformAuthEvent(PLATFORM, 1, null, null, false, getMonitorExtra());
                        SoftReference<AuthorizeCallback> softReference = sAuthorizeCallBack;
                        if (softReference != null && (authorizeCallback = softReference.get()) != null) {
                            authorizeCallback.onSuccess(bundle);
                        }
                        reset();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            onAuthorizeFailed(Integer.MAX_VALUE, "invalid_response", response.extras);
            return;
        }
        onAuthorizeFailed(i, response.errorMsg, response.extras);
    }

    private static void onAuthorizeFailed(int i, String str, Bundle bundle) {
        AuthorizeCallback authorizeCallback;
        AuthorizeErrorResponse authorizeErrorResponse = new AuthorizeErrorResponse(i, str);
        if (i == -2) {
            authorizeErrorResponse.isCancel = true;
        }
        JSONObject monitorExtra = getMonitorExtra();
        if (bundle != null) {
            authorizeErrorResponse.extras = bundle;
            try {
                for (String str2 : bundle.keySet()) {
                    monitorExtra.put(str2, bundle.get(str2));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AuthorizeMonitorUtil.onPlatformAuthEvent(PLATFORM, 0, authorizeErrorResponse.platformErrorCode, authorizeErrorResponse.platformErrorMsg, authorizeErrorResponse.isCancel, monitorExtra);
        SoftReference<AuthorizeCallback> softReference = sAuthorizeCallBack;
        if (softReference != null && (authorizeCallback = softReference.get()) != null) {
            authorizeCallback.onError(authorizeErrorResponse);
        }
        reset();
    }

    private static JSONObject getMonitorExtra() {
        Request request;
        JSONObject jSONObject = new JSONObject();
        try {
            SoftReference<Request> softReference = currentRequest;
            if (softReference != null && (request = softReference.get()) != null) {
                jSONObject.put("auth_type", request.authType);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void reset() {
        sAuthorizeCallBack = null;
        currentRequest = null;
    }
}

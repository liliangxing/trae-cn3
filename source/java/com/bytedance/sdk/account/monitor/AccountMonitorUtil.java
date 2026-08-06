package com.bytedance.sdk.account.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.LogoutApiResponse;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.trace.TraceManager;
import com.bytedance.sdk.account.utils.IMonitor;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.account.TTAccountInit;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class AccountMonitorUtil {
    public static void eventFinalize(String str, String str2, boolean z, int i, String str3, JSONObject jSONObject) {
        event(AccountMonitorConstants.EVENT_LOGIN_FINALIZE, null, str, str2, z, i, str3, jSONObject);
    }

    public static void authCallback(String str, boolean z, int i, String str2, JSONObject jSONObject) {
        event("passport_oauth_callback", null, str, "auth", z, i, str2, jSONObject);
    }

    public static void eventSwitchBindCancel(String str, JSONObject jSONObject) {
        event(AccountMonitorConstants.EventPlatform.OAUTH_SWITCH_CLICK, null, str, "cancel", false, 0, null, jSONObject);
    }

    public static void loginUiShow(String str, String str2, boolean z, int i, JSONObject jSONObject) {
        event(AccountMonitorConstants.EventPlatform.DIALOG_SHOW, null, str, str2, z, i, null, jSONObject);
    }

    public static void loginEntranceShowEvent(String str, JSONObject jSONObject) {
        onLoginEvent(AccountMonitorConstants.EventPlatform.LOGIN_ENTRANCE_EVENT, str, null, null, null, jSONObject);
    }

    public static void loginPageShowEvent(String str, String str2, String str3, JSONObject jSONObject) {
        onLoginEvent(AccountMonitorConstants.EventPlatform.LOGIN_PAGE_SHOW_EVENT, str, str2, str3, null, jSONObject);
    }

    public static void loginClickEvent(String str, String str2, String str3, JSONObject jSONObject) {
        onLoginEvent(AccountMonitorConstants.EventPlatform.LOGIN_CLICK_EVENT, str, str2, null, str3, jSONObject);
    }

    public static void loginResultEvent(String str, String str2, String str3, boolean z, int i, String str4, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_POSITION, str);
        jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_PAGE, str2);
        jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_PLATFORM, str3);
        if (z) {
            jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_RESULT, "success");
        } else {
            jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_RESULT, "fail");
            jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_ERROR_CODE, i);
            jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_ERROR_MSG, str4);
        }
        jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
        jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
        onEventV3(AccountMonitorConstants.EventPlatform.LOGIN_CLICK_RESULT_EVENT, jSONObject);
    }

    public static void sendCodeClickEvent(String str, boolean z, int i, String str2, JSONObject jSONObject) {
        onSendCodeEvent(AccountMonitorConstants.EventPlatform.MOBILE_CODE_CLICK_EVENT, str, z, i, str2, jSONObject);
    }

    public static void inputCodeEvent(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put(AccountMonitorConstants.CommonParameter.SENDCODE_POSITION, str);
        jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
        jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
        onEventV3(AccountMonitorConstants.EventPlatform.MOBILE_CODE_INPUT_EVENT, jSONObject);
    }

    public static void submitCodeEvent(String str, boolean z, int i, String str2, JSONObject jSONObject) {
        onSendCodeEvent(AccountMonitorConstants.EventPlatform.MOBILE_CODE_SUBMIT_EVENT, str, z, i, str2, jSONObject);
    }

    public static void onLoginEvent(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_POSITION, str2);
        jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_PAGE, str3);
        jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_PLATFORM, str5);
        jSONObject.put(AccountMonitorConstants.CommonParameter.LOGIN_PLATFORM_LIST, str4);
        jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
        jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
        onEventV3(str, jSONObject);
    }

    public static void onSendCodeEvent(String str, String str2, boolean z, int i, String str3, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put(AccountMonitorConstants.CommonParameter.SENDCODE_POSITION, str2);
        if (z) {
            jSONObject.put(AccountMonitorConstants.CommonParameter.SENDCODE_RESULT, 1);
        } else {
            jSONObject.put(AccountMonitorConstants.CommonParameter.SENDCODE_RESULT, 0);
            jSONObject.put(AccountMonitorConstants.CommonParameter.SENDCODE_ERROR_CODE, i);
            jSONObject.put(AccountMonitorConstants.CommonParameter.SENDCODE_ERROR_MSG, str3);
        }
        jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
        jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
        onEventV3(str, jSONObject);
    }

    public static void event(String str, String str2, String str3, String str4, boolean z, int i, String str5, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put("platform", str3);
        jSONObject.put("scene", str4);
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(AccountMonitorConstants.CommonParameter.URLPATH, str2);
        }
        if (z) {
            jSONObject.put("result", 1);
        } else {
            jSONObject.put("result", 0);
            jSONObject.put(AccountMonitorConstants.CommonParameter.ERROR, i);
            if (str5 != null) {
                jSONObject.put("errDesc", str5);
            }
        }
        jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
        jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
        onEventV3(str, jSONObject);
    }

    public static void onEvent(String str, String str2, String str3, BaseApiResponse baseApiResponse, AbsApiCall absApiCall) {
        event(str, str2, str3, baseApiResponse, absApiCall != null ? absApiCall.onSendEvent(str) : null);
    }

    public static void event(String str, String str2, String str3, BaseApiResponse baseApiResponse, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (baseApiResponse != null) {
            String str4 = baseApiResponse.errorMsg;
            if (TextUtils.isEmpty(str4)) {
                str4 = baseApiResponse.mDetailErrorMsg;
            }
            String str5 = str4;
            if (jSONObject == null) {
                try {
                    jSONObject2 = new JSONObject();
                } catch (JSONException e) {
                    e = e;
                    jSONObject2 = jSONObject;
                    e.printStackTrace();
                    event(str, baseApiResponse.mRequestUrl, str2, str3, baseApiResponse.success, baseApiResponse.mDetailErrorCode, str5, jSONObject2);
                    return;
                }
            } else {
                jSONObject2 = jSONObject;
            }
            try {
                jSONObject2.put(AccountMonitorConstants.CommonParameter.LOGID, baseApiResponse.logId);
                if (baseApiResponse instanceof LogoutApiResponse) {
                    String str6 = ((LogoutApiResponse) baseApiResponse).mLogoutScene;
                    if (!TextUtils.isEmpty(str6)) {
                        jSONObject2.put(AccountMonitorConstants.CommonParameter.LOGOUT_SCENE, str6);
                    }
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                event(str, baseApiResponse.mRequestUrl, str2, str3, baseApiResponse.success, baseApiResponse.mDetailErrorCode, str5, jSONObject2);
                return;
            }
            event(str, baseApiResponse.mRequestUrl, str2, str3, baseApiResponse.success, baseApiResponse.mDetailErrorCode, str5, jSONObject2);
            return;
        }
        event(str, null, str2, str3, false, -1, null, jSONObject);
    }

    public static void platformEvent(String str, String str2, String str3, int i, String str4, String str5, boolean z, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put("platform", str2);
        jSONObject.put("result", i);
        jSONObject.put("scene", str3);
        if (str4 != null) {
            jSONObject.put("errCode", str4);
        }
        if (str5 != null) {
            jSONObject.put("errDesc", str5);
        }
        if (i == 0 && z) {
            jSONObject.put("errorCancel", z);
        }
        jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
        jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
        onEventV3(str, jSONObject);
    }

    public static void platformAuthEvent(String str, String str2, int i, String str3, String str4, boolean z, JSONObject jSONObject) {
        platformEvent("passport_oauth_callback", str, str2, i, str3, str4, z, jSONObject);
    }

    public static void onGetLoginInfoEvent(String str, BaseApiResponse baseApiResponse, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        if (baseApiResponse.success) {
            jSONObject.put("result", 1);
        } else {
            jSONObject.put("result", 0);
            jSONObject.put("errCode", baseApiResponse.error);
            jSONObject.put("errDesc", baseApiResponse.errorMsg);
        }
        onEventV3(str, jSONObject);
    }

    public static void onSessionExpriedEvent(String str, String str2, String str3, String str4) {
        onSessionExpiredEvent(str, str2, str3, str4, BDAccountDelegateInner.instance(TTAccountInit.getConfig().getApplicationContext()).isLogin());
    }

    public static void onSessionExpiredEvent(String str, String str2, String str3, String str4, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(AccountMonitorConstants.CommonParameter.LOGID, str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(AccountMonitorConstants.CommonParameter.URLPATH, str2);
            }
            jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("extra", str4);
            }
            jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
            jSONObject.put(AccountMonitorConstants.CommonParameter.USER_WAS_LOGIN, z ? "1" : "0");
            jSONObject.put("result", 0);
            onEventV3(str, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void onTokenEvent(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
        jSONObject.put("result", 0);
        onEventV3(str, jSONObject);
    }

    public static void sessionEvent(String str, String str2, String str3, JSONObject jSONObject) {
        event(str, str2, null, null, false, -1, str3, jSONObject);
    }

    public static void onRecentOneLoginEvent(String str, BaseApiResponse baseApiResponse, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        if (baseApiResponse.success) {
            jSONObject.put("result", 1);
        } else {
            jSONObject.put("result", 0);
            jSONObject.put("errCode", baseApiResponse.error);
            jSONObject.put("errDesc", baseApiResponse.errorMsg);
        }
        onEventV3(str, jSONObject);
    }

    public static void onSyncLoginStatusError() {
        onEventV3(AccountMonitorConstants.EventAccount.SYNC_LOGIN_STATUS_ERROR, null);
    }

    public static void onNeverCallTokenInit() {
        onEventV3(AccountMonitorConstants.EventAccount.NEVER_CALL_TOKEN_INIT, null);
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        IMonitor monitor = TTAccountInit.getConfig().getMonitor();
        if (monitor != null) {
            if (jSONObject != null) {
                try {
                    if (!jSONObject.has(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION)) {
                        jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
                    }
                    String traceId = TraceManager.getTraceId();
                    if (!TextUtils.isEmpty(traceId)) {
                        jSONObject.put("trace_id", traceId);
                    }
                    if (!jSONObject.has("passport_sdk_version")) {
                        jSONObject.put("passport_sdk_version", 505180);
                    }
                    jSONObject.put("params_for_special", "uc_login");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            monitor.onEvent(str, jSONObject);
        }
    }

    public static void netExceptionEvent(String str, Throwable th, int i, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AccountMonitorConstants.CommonParameter.URLPATH, new URI(str).getPath().toLowerCase());
            if (th != null) {
                jSONObject.put("exception_stack_trace", Log.getStackTraceString(th));
                jSONObject.put("exception_msg", th.getMessage());
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("exception_msg", str2);
            }
            jSONObject.put(AccountMonitorConstants.CommonParameter.ERROR, i);
            jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
            jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
            onEventV3("passport_net_err", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void netEvent(String str, String str2, long j, int i, String str3, String str4, boolean z, int i2, boolean z2, boolean z3, boolean z4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PermissionConfigParser.WEBCAST_HOST_NAMESPACE, str);
            jSONObject.put("path", str2);
            jSONObject.put(ReportConstant.COMMON_INIT_DURATION, j);
            jSONObject.put("error_code", i);
            jSONObject.put("error_desc", str3);
            jSONObject.put(AccountMonitorConstants.CommonParameter.LOGID, str4);
            int i3 = 1;
            jSONObject.put("request_x_tt_token", z ? 1 : 0);
            jSONObject.put("request_csrf_token", i2);
            jSONObject.put("response_x_tt_token", z2 ? 1 : 0);
            jSONObject.put("response_csrf_token", z3 ? 1 : 0);
            if (!z4) {
                i3 = 0;
            }
            jSONObject.put("csrf_token_status", i3);
            onEventV3("passport_net_request_result", jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void eventLoadUserInfo(boolean z, boolean z2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = 1;
            jSONObject.put("is_login", z ? 1 : 0);
            if (!z2) {
                i = 0;
            }
            jSONObject.put("user_info", i);
            jSONObject.put("user_id", str);
            onEventV3("passport_load_user_info", jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void eventTokenError(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PermissionConfigParser.WEBCAST_HOST_NAMESPACE, str);
            jSONObject.put("path", str2);
            jSONObject.put(AccountMonitorConstants.CommonParameter.LOGID, str3);
            onEventV3("passport_xtttoken_error", jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void commonExceptionEvent(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (th != null) {
                jSONObject.put("exception_stack_trace", Log.getStackTraceString(th));
                jSONObject.put("exception_msg", th.getMessage());
            }
            jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
            jSONObject.put(AccountMonitorConstants.NEW_SDK_VERSION_KEY, 2);
            onEventV3("passport_common_err", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

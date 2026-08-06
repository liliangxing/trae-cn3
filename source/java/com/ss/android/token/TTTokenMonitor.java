package com.ss.android.token;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.ProviderRequestContent;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.sdk.account.ticketguard.TokenGuardSettingManager;
import com.bytedance.sdk.account.utils.ActivityStack;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.constant.Downloads;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTTokenMonitor {
    public static final String PASSPORT_LOGIN_TOKEN_UPDATE = "passport_login_token_update";
    public static final String PASSPORT_REQUEST_WITHOUT_X_TT_TOKEN = "passport_request_without_x_tt_token";
    public static final String PASSPORT_TOKEN_GUARD_FAIL = "passport_token_guard_fail";
    public static final String PASSPORT_USE_TICKET_REQUEST = "passport_use_ticket_request";
    public static final String PASSPORT_USE_TICKET_RESPONSE = "passport_use_ticket_response";
    public static final String SDK_SESSION_LAUNCH = "sdk_session_launch";
    public static final String TT_LOGID_KEY = "X-TT-LOGID";
    public static final String TT_SESSION_EXPIRE = "tt_token_logout";
    public static final String TT_TOKEN_BEAT = "tt_token_beat";
    public static final String TT_TOKEN_CHANGE = "tt_token_change";
    public static final String TT_TOKEN_CONFIG_ERROR = "tt_token_config_error";
    public static final String TT_TOKEN_CONFIG_ERROR_V2 = "token_config_err_v2";
    public static final String TT_TOKEN_DECRYPT_ERR = "tt_token_decrypt_err";
    public static final String TT_TOKEN_EXCEPTION = "tt_token_exception";
    private static final String TT_TOKEN_LOST = "x_tt_token_lost";
    public static final String TT_TOKEN_NOT_ADD_TO_HOST = "tt_account_request_without_x_tt_token";
    public static final String TT_TOKEN_NOT_CALL_ADD_HOST_LIST = "tt_token_not_call_add_host_list";
    private static HashSet<String> reportedHostSet = new HashSet<>();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum SessionExpiredHandleResult {
        ignore,
        logout
    }

    public static void monitorTokenLost(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("urlpath", getUrlPath(str));
            onTokenEvent(TT_TOKEN_LOST, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void monitorDecryptError(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("tokenSign", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("token", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put(Downloads.Impl.COLUMN_ERROR_MSG, str4);
            }
            onTokenEvent(TT_TOKEN_DECRYPT_ERR, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorToken(String str, List<TTTokenHeader> list, int i, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error_code", i);
            jSONObject.put("error_code_msg", str2);
            StringBuilder sb = new StringBuilder();
            if (list != null && !list.isEmpty()) {
                for (TTTokenHeader tTTokenHeader : list) {
                    if (tTTokenHeader instanceof TTTokenHeader) {
                        jSONObject.put(tTTokenHeader.getName(), tTTokenHeader.getValue());
                    } else if (tTTokenHeader != null) {
                        sb.append(tTTokenHeader.toString());
                        sb.append(";");
                    }
                }
            }
            jSONObject.put("extra", sb.toString());
            onTokenEvent(str, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void monitorSessionExpire(String str, List list) {
        monitorSessionExpired(str, list, TTTokenManager.isLogin());
    }

    public static void monitorSessionExpired(String str, List list, boolean z) {
        try {
            String str2 = "";
            StringBuilder sb = new StringBuilder();
            if (list != null && !list.isEmpty()) {
                for (Object obj : list) {
                    if (obj instanceof TTTokenHeader) {
                        if (TT_LOGID_KEY.equalsIgnoreCase(((TTTokenHeader) obj).getName())) {
                            str2 = ((TTTokenHeader) obj).getValue();
                        }
                    } else if (obj != null) {
                        sb.append(obj.toString());
                        sb.append(";");
                    }
                }
            }
            onSessionExpiredEvent(TT_SESSION_EXPIRE, getUrlPath(str), str2, sb.toString(), z);
        } catch (Exception e) {
            monitorError(e);
        }
    }

    public static void monitorSessionExpiredResult(String str, String str2, String str3, String str4, SessionExpiredHandleResult sessionExpiredHandleResult) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TokenConstants.SCENE_KEY, str);
            jSONObject.put("from_host", str2);
            jSONObject.put("from_path", str3);
            jSONObject.put("from_logid", str4);
            jSONObject.put("handle", sessionExpiredHandleResult.name());
            onEvent("passport_session_expired_result", jSONObject);
        } catch (Exception e) {
            monitorError(e);
        }
    }

    public static void onSessionExpriedEvent(String str, String str2, String str3, String str4) {
        onSessionExpiredEvent(str, str2, str3, str4, TTTokenManager.isLogin());
    }

    public static void onSessionExpiredEvent(String str, String str2, String str3, String str4, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("logid", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("urlpath", str2);
            }
            jSONObject.put("sdkVersion", 2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("extra", str4);
            }
            jSONObject.put("user_was_login", z ? PushClient.DEFAULT_REQUEST_ID : "0");
            jSONObject.put(IAssociationStartMonitorEventService.KEY_RESULT, 0);
            onEvent(str, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static String getUrlPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                URI uri = new URI(str);
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(uri.getHost())) {
                    sb.append(uri.getHost());
                }
                if (!TextUtils.isEmpty(uri.getPath())) {
                    sb.append(uri.getPath());
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static void monitorConfigError(String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject.put("error_name", str);
        jSONObject.put(PushMessageHelper.ERROR_MESSAGE, str2);
        int i = 1;
        jSONObject.put("network_available", TTTokenManager.isNetworkAvailable() ? 1 : 0);
        if (!ActivityStack.isAppForeground()) {
            i = 0;
        }
        jSONObject.put("app_in_foreground", i);
        onTokenEvent(TT_TOKEN_CONFIG_ERROR_V2, jSONObject);
    }

    public static void monitorTokenChange(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", TokenFactory.getMixVal(str));
            jSONObject.put("logid", str2);
            onTokenEvent(TT_TOKEN_CHANGE, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void monitorError(Throwable th) {
        try {
            th.printStackTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception_msg", th.getMessage());
            jSONObject.put("exception_stack_trace", Log.getStackTraceString(th));
            onTokenEvent(TT_TOKEN_EXCEPTION, jSONObject);
            TTTokenManager.onException(th);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void monitorNotAddToken(String str, Set<String> set) {
        try {
            JSONObject jSONObject = new JSONObject();
            URI uri = new URI(str);
            String host = uri.getHost();
            if (uri.getPath().startsWith("passport/") && !reportedHostSet.contains(host)) {
                reportedHostSet.add(host);
                jSONObject.put("host", host);
                jSONObject.put("tt_account_share_token_domains", set.toString());
                onTokenEvent(PASSPORT_REQUEST_WITHOUT_X_TT_TOKEN, jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void monitorNotCallAddHostList() {
        onTokenEvent(TT_TOKEN_NOT_CALL_ADD_HOST_LIST, null);
    }

    public static void onSyncLoginStatusError() {
        onEvent("syn_login_status_error", null);
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
        jSONObject.put(IAssociationStartMonitorEventService.KEY_RESULT, 0);
        onEvent(str, jSONObject);
    }

    public static void monitorSdkSessionLaunch() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_aid", 71769);
            jSONObject.put(RegistrationHeaderHelper.KEY_SDK_VERSION, "0.5.5-alpha.160-doubao");
        } catch (Exception e) {
            e.printStackTrace();
        }
        onEvent(SDK_SESSION_LAUNCH, jSONObject);
    }

    public static void eventLoadToken(boolean z, boolean z2, boolean z3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = 1;
            jSONObject.put("is_login", z ? 1 : 0);
            if (!z2) {
                i = 0;
            }
            jSONObject.put(TokenConstants.COOKIE_KEY_SESSION_ID, i);
            jSONObject.put("xtttoken_location", z3 ? DownloadSettingKeys.BugFix.DEFAULT : com.lynx.trace.BuildConfig.enable_trace);
            jSONObject.put("csrf_token_location", str);
            onEvent("passport_load_login_token", jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorTokenGuardFail(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DownloadConstants.PATH_KEY, str);
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, str2);
            jSONObject.put("error_code", str3);
            jSONObject.put("error_desc", str4);
            onEvent(PASSPORT_TOKEN_GUARD_FAIL, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorUseTicketRequest(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, str);
            jSONObject.put(DownloadConstants.PATH_KEY, str2);
            onEvent(PASSPORT_USE_TICKET_REQUEST, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorUseTicketResponse(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, str);
            jSONObject.put(IAssociationStartMonitorEventService.KEY_RESULT, str2);
            jSONObject.put(DownloadConstants.PATH_KEY, str3);
            jSONObject.put("logid", str4);
            onEvent(PASSPORT_USE_TICKET_RESPONSE, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorUpdateToken(String str, String str2, String str3, RequestContent requestContent, TokenObject tokenObject) {
        ProviderRequestContent providerRequestContent;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("host", str);
            jSONObject.put(DownloadConstants.PATH_KEY, str2);
            jSONObject.put("log_id", str3);
            int i = 1;
            if (requestContent != null && (providerRequestContent = requestContent.ticketProviderRequestContent) != null && providerRequestContent.getHeaders() != null && !providerRequestContent.getHeaders().isEmpty()) {
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                for (Pair pair : providerRequestContent.getHeaders()) {
                    if (pair != null) {
                        if (TextUtils.equals("bd-ticket-guard-client-csr", (CharSequence) pair.first)) {
                            i2 = !TextUtils.isEmpty((CharSequence) pair.second) ? 1 : 0;
                        } else if (TextUtils.equals("bd-ticket-guard-client-cert", (CharSequence) pair.first)) {
                            i3 = !TextUtils.isEmpty((CharSequence) pair.second) ? 1 : 0;
                        } else if (TextUtils.equals("bd-ticket-guard-ree-public-key", (CharSequence) pair.first)) {
                            i4 = !TextUtils.isEmpty((CharSequence) pair.second) ? 1 : 0;
                        }
                    }
                }
                jSONObject.put("csr", i2);
                jSONObject.put("client_cert", i3);
                jSONObject.put("ree_public_key", i4);
            }
            jSONObject.put("token", !TextUtils.isEmpty(tokenObject.token) ? 1 : 0);
            if (TextUtils.isEmpty(tokenObject.tsSign)) {
                i = 0;
            }
            jSONObject.put("tssign", i);
            onEvent(PASSPORT_LOGIN_TOKEN_UPDATE, jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void monitorPassportNotMarkGetTicket(String str, String str2, String str3) {
        if (TokenGuardSettingManager.isEnableFullLog()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("host", str);
                jSONObject.put(DownloadConstants.PATH_KEY, str2);
                jSONObject.put(BaseConstants.DownloadManager.COLUMN_REASON, str3);
                TicketGuardEventHelper.INSTANCE.monitorFullLog("account_not_mark_get", "all", 0, str2 + " not mark get ticket", jSONObject.toString(), (Function0) null);
            } catch (Exception unused) {
            }
        }
    }

    public static void monitorWaitTicketInitResult(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DownloadConstants.PATH_KEY, str);
            jSONObject.put("inited", z ? 1 : 0);
            TicketGuardEventHelper.INSTANCE.monitorFullLog("account_wait_ticket_init", "all", 0, (String) null, jSONObject.toString(), (Function0) null);
        } catch (Exception unused) {
        }
    }

    public static void monitorHttpRequest(String str, String str2, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("host", str);
            jSONObject.put(DownloadConstants.PATH_KEY, str2);
            jSONObject.put("xtoken", z ? 1 : 0);
            onEvent("passport_http_with_xtoken", jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onEvent(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put(TokenConstants.ACCOUNT_SDK_VERSION, 505180);
            jSONObject.put("params_for_special", "uc_login");
        } catch (Exception e) {
            e.printStackTrace();
        }
        TTTokenManager.onEvent(str, jSONObject);
    }
}

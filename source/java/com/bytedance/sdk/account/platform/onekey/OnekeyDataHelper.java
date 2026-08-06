package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.platform.base.OneLoginCallback;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class OnekeyDataHelper {

    @Deprecated
    public static final String CARRIER_APP_ID = "carrier_app_id";
    public static final String CM_EVENT_CARRIER = "china_mobile";
    public static final String CT_EVENT_CARRIER = "china_telecom";
    public static final String CU_EVENT_CARRIER = "china_unicom";
    public static final String GET_CARRIER_EVENT = "one_click_carrier_response";
    public static final String GET_NETWORK_STATUS_EVENT = "one_click_network_response";
    public static final String GET_PHONE_EVENT = "one_click_number_request_response";
    public static final String GET_PHONE_SEND_EVENT = "one_click_number_request_send";
    public static final String GET_SUBSCRIPTION_ID_FAIL_EVENT = "one_click_get_subscription_id_fail";
    public static final String GET_TOKEN_EVENT = "one_click_login_token_response";
    public static final String GET_TOKEN_SEND_EVENT = "one_click_login_token_send";
    public static final String GET_VALIDATE_TOKEN_EVENT = "one_click_validate_token_response";
    public static final String GET_VALIDATE_TOKEN_SEND_EVENT = "one_click_validate_token_send";
    public static final int VERSION_CODE = 505180;

    public static OnekeyLoginErrorResponse getErrorResponse(String str, String str2, String str3, int i, int i2, JSONObject jSONObject) {
        OnekeyLoginErrorResponse onekeyLoginErrorResponse = new OnekeyLoginErrorResponse();
        onekeyLoginErrorResponse.netType = str3;
        onekeyLoginErrorResponse.netStatus = i;
        onekeyLoginErrorResponse.platformErrorCode = str;
        onekeyLoginErrorResponse.platformErrorMsg = str2;
        onekeyLoginErrorResponse.errorType = i2;
        onekeyLoginErrorResponse.rawResult = jSONObject;
        return onekeyLoginErrorResponse;
    }

    public static JSONObject generateGetCarrierEvent(Context context, String str) {
        JSONObject generateCommonJson = generateCommonJson(context);
        try {
            generateCommonJson.put("carrier", str);
            generateCommonJson.put("carrier_log", NetworkTypeHelper.getCarrierLog(context));
        } catch (JSONException unused) {
        }
        return generateCommonJson;
    }

    public static JSONObject generateGetNetStatusEvent(Context context, int i) {
        JSONObject generateCommonJson = generateCommonJson(context);
        try {
            generateCommonJson.put("network", CommonUtils.getNetStatusName(i));
            generateCommonJson.put("network_log", NetworkTypeHelper.getNetTypeLog(context));
        } catch (JSONException unused) {
        }
        return generateCommonJson;
    }

    public static JSONObject getMonitorJson(Context context, String str, String str2, String str3, int i, AuthorizeCallback authorizeCallback) {
        JSONObject generateCommonJson = generateCommonJson(context);
        try {
            if (!TextUtils.isEmpty(str3)) {
                generateCommonJson.put("network_type_detail", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                generateCommonJson.put("request_scene", str2);
            }
            generateCommonJson.put("carrier", str);
            generateCommonJson.put("network_type", CommonUtils.getNetStatusName(i));
        } catch (JSONException unused) {
        }
        if (authorizeCallback instanceof OneLoginCallback) {
            setExtraJsonData((OneLoginCallback) authorizeCallback, generateCommonJson);
        }
        return generateCommonJson;
    }

    public static JSONObject generateMonitorJson(Context context, boolean z, String str, String str2, long j, String str3, String str4, String str5, String str6, int i, AuthorizeCallback authorizeCallback) {
        JSONObject generateCommonJson = generateCommonJson(context);
        if (!z) {
            try {
                generateCommonJson.put("error_code", str);
                generateCommonJson.put("error_msg", str2);
            } catch (JSONException unused) {
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            generateCommonJson.put("carrier_sdk_logId", str3);
        }
        if (!TextUtils.isEmpty(str5)) {
            generateCommonJson.put("request_scene", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            generateCommonJson.put("network_type_detail", str6);
        }
        generateCommonJson.put(AccountMonitorConstants.CommonParameter.SENDCODE_RESULT, z ? 1 : 0);
        generateCommonJson.put("carrier", str4);
        generateCommonJson.put(ReportConstant.COMMON_INIT_DURATION, j);
        generateCommonJson.put("network_type", CommonUtils.getNetStatusName(i));
        if (authorizeCallback instanceof OneLoginCallback) {
            setExtraJsonData((OneLoginCallback) authorizeCallback, generateCommonJson);
        }
        return generateCommonJson;
    }

    private static JSONObject generateCommonJson(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("permission", CommonUtils.hasPermission(context, "android.permission.READ_PHONE_STATE") ? 1 : 0);
            jSONObject.put(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
            jSONObject.put("params_for_special", "uc_login");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private static void setExtraJsonData(OneLoginCallback oneLoginCallback, JSONObject jSONObject) {
        if (jSONObject == null || oneLoginCallback == null) {
            return;
        }
        try {
            JSONObject onSendEvent = oneLoginCallback.onSendEvent();
            if (onSendEvent == null || onSendEvent.length() <= 0) {
                return;
            }
            Iterator<String> keys = onSendEvent.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.put(next, onSendEvent.getString(next));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static String getCarrierEvent(String str) {
        String str2;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1856351708:
                if (str.equals(OnekeyLoginConstants.TELECOM_V2)) {
                    c = 0;
                    break;
                }
                break;
            case -1429363305:
                if (str.equals(OnekeyLoginConstants.TELECOM)) {
                    c = 1;
                    break;
                }
                break;
            case -1068855134:
                if (str.equals("mobile")) {
                    c = 2;
                    break;
                }
                break;
            case -944421142:
                if (str.equals(OnekeyLoginConstants.UNICOM_V2)) {
                    c = 3;
                    break;
                }
                break;
            case -840542575:
                if (str.equals(OnekeyLoginConstants.UNICOM)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                str2 = CT_EVENT_CARRIER;
                break;
            case 2:
                str2 = CM_EVENT_CARRIER;
                break;
            case 3:
            case 4:
                str2 = CU_EVENT_CARRIER;
                break;
            default:
                str2 = "";
                break;
        }
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }
}

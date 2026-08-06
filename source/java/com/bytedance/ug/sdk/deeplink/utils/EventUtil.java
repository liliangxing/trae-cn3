package com.bytedance.ug.sdk.deeplink.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.UriType;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsCacheHelper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class EventUtil {
    private static final String TAG = "EventUtil";
    public static long registerLifecycleCost;

    public static void sendActivationEvent(UriType uriType, String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject schemeParams = getSchemeParams(uriType, str);
        JSONObject parseExtraParam = parseExtraParam(str);
        if (parseExtraParam != null) {
            Iterator<String> keys = parseExtraParam.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    schemeParams.put(next, parseExtraParam.opt(next));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (jSONObject != null) {
            Iterator<String> keys2 = jSONObject.keys();
            while (keys2.hasNext()) {
                try {
                    String next2 = keys2.next();
                    schemeParams.put(next2, jSONObject.optString(next2));
                } catch (Throwable th2) {
                    Logger.m448e(TAG, "setOtherSchemeParams error= ", th2);
                }
            }
        }
        onEvent(EventConstants.EVENT_ZLINK_ACTIVATION, schemeParams);
    }

    public static void sendClipboardVerifyEvent(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        onEvent(EventConstants.EVENT_ZLINK_CLIPBOARD_VERIFY, jSONObject);
    }

    public static void sendTokenVerifyEvent(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        onEvent(EventConstants.EVENT_ZLINK_TOKEN_VERIFY, jSONObject);
    }

    public static void sendZlinkSdkInitEvent(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.PARAM_REGISTER_LIFECYCLE_COST, registerLifecycleCost).put(EventConstants.PARAM_TIME_CONSUME, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(EventConstants.EVENT_ZLINK_SDK_INIT, jSONObject);
    }

    public static void sendParseAppLinkEvent(int i, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i).put(EventConstants.PARAM_REQUEST_URL, str).put(EventConstants.PARAM_REQUEST_METHOD, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(EventConstants.EVENT_ZLINK_PARSE_APPLINK, jSONObject);
    }

    public static void sendFingerPrintEvent(long j, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.PARAM_TIME_CONSUME, System.currentTimeMillis() - j).put("result", i).put("message", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(EventConstants.EVENT_ZLINK_FINGERPRINT, jSONObject);
    }

    public static void sendNetworkTimeConsumingEvent(String str, int i, long j, int i2, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.PARAM_REQUEST_URL, str).put(EventConstants.PARAM_RESPONSE_CODE, i).put(EventConstants.PARAM_TIME_CONSUME, j).put(EventConstants.PARAM_TIME_OUT, i2).put(EventConstants.PARAM_REQUEST_METHOD, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(EventConstants.EVENT_ZLINK_NETWORK_TIME_CONSUMING, jSONObject);
    }

    public static void sendFirstSettingResultEvent(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(EventConstants.EVENT_ZLINK_FIRST_SETTING_RESULT, jSONObject);
    }

    public static void sendEverySettingResultEvent(int i, long j, String str) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        long lastestUpdateTime = ZlinkSettingsCacheHelper.getLastestUpdateTime(GlobalContext.INSTANCE.getApplication()) - j;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i).put(EventConstants.PARAM_TIME_CONSUME, currentTimeMillis).put(EventConstants.PARAM_KEY_SETTINGS_INTERVAL, lastestUpdateTime).put(EventConstants.PARAM_SOURCE, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(EventConstants.EVENT_ZLINK_EVERY_SETTING_RESULT, jSONObject);
    }

    public static void sendHuaweiReferResultEvent(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        onEvent(EventConstants.EVENT_ZLINK_HUAWEI_REFER_RESULT, jSONObject);
    }

    public static void sendGetClipboardEvent() {
        onEvent(EventConstants.EVENT_ZLINK_GET_CLIPBOARD, new JSONObject());
    }

    private static JSONObject getSchemeParams(UriType uriType, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(EventConstants.PARAM_KEY_ACT_URI, str);
            jSONObject.put(EventConstants.PARAM_KEY_ACT_URI_TYPE, uriType.toString());
            jSONObject.put(EventConstants.PARAM_KEY_ACT_TIME, String.valueOf(System.currentTimeMillis() / 1000));
            jSONObject.put(EventConstants.PARAM_KEY_GROWTH_DEEPEVENT, "1");
        } catch (Throwable th) {
            Logger.m448e(TAG, "EventData getSchemeParams error", th);
        }
        return jSONObject;
    }

    public static boolean onEvent(String str, JSONObject jSONObject) {
        Logger.m446d(TAG, "onEvent event=" + str + ",jsonObject=" + jSONObject);
        if (HostCommonServices.getZlinkDepend() == null) {
            return false;
        }
        HostCommonServices.getZlinkDepend().onEvent(str, jSONObject);
        return true;
    }

    public static JSONObject parseExtraParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return parseExtraParam(Uri.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject parseExtraParam(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            String queryParameter = uri.getQueryParameter(CommonConstants.ZLINK_DATA);
            if (TextUtils.isEmpty(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("scheme");
                if (TextUtils.isEmpty(queryParameter2)) {
                    return null;
                }
                queryParameter = Uri.parse(queryParameter2).getQueryParameter(CommonConstants.ZLINK_DATA);
            }
            if (TextUtils.isEmpty(queryParameter)) {
                return null;
            }
            return new JSONObject(queryParameter);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}

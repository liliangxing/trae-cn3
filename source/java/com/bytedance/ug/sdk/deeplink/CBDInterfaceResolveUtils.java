package com.bytedance.ug.sdk.deeplink;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.settings.SettingsConstant;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.JSONUtils;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.NetworkUtils;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CBDInterfaceResolveUtils {
    private static final String SECURITY_CHECK_URL = "https://zlink.toutiao.com/api/cb_d";
    private static final String TAG = "ClipboardSecurityUtils";

    public static String parseClipboardContent(String str, JSONObject jSONObject) {
        return TextUtils.isEmpty(str) ? str : requestScheme("", str, jSONObject);
    }

    public static String parseZLinkToken(String str, JSONObject jSONObject) {
        return TextUtils.isEmpty(str) ? "" : requestScheme(str, "", jSONObject);
    }

    private static String requestScheme(String str, String str2, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (!TextUtils.isEmpty(str)) {
            jSONObject2 = new JSONObject();
            JSONUtils.safePutString(jSONObject2, CommonConstants.ZLINK_TOKEN, str);
        } else if (TextUtils.isEmpty(str2)) {
            jSONObject2 = null;
        } else {
            jSONObject2 = new JSONObject();
            JSONUtils.safePutString(jSONObject2, CommonConstants.CLIPBOARD_CONTENT, str2);
        }
        String str3 = "";
        if (jSONObject2 == null) {
            return "";
        }
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend != null) {
            JSONUtils.safePutString(jSONObject2, CommonConstants.ZLINK_UPDATE_VERSION_CODE, String.valueOf(zlinkDepend.getUpdateVersionCode()));
        }
        byte[] bytes = jSONObject2.toString().getBytes();
        Uri.Builder buildUpon = Uri.parse(SECURITY_CHECK_URL).buildUpon();
        if (buildUpon != null) {
            buildUpon.appendQueryParameter(CommonConstants.KEY_DEVICE_PLATFORM, "android");
            buildUpon.appendQueryParameter(CommonConstants.KEY_OS_VERSION, Build.VERSION.RELEASE);
            buildUpon.appendQueryParameter(CommonConstants.SDK_VERSION, "1.1.6");
            if (zlinkDepend != null) {
                buildUpon.appendQueryParameter("app_id", zlinkDepend.getAppId());
                buildUpon.appendQueryParameter(CommonConstants.KEY_DID, zlinkDepend.getDeviceId());
            }
            str3 = buildUpon.toString();
        }
        long timeoutForClipboardVerify = ZlinkSettingsApi.getTimeoutForClipboardVerify(GlobalContext.INSTANCE.getApplication());
        long currentTimeMillis = System.currentTimeMillis();
        String executePostRequest = NetworkUtils.getInstance().executePostRequest(str3, new HashMap(), bytes, timeoutForClipboardVerify, jSONObject);
        JSONUtils.safePutLong(jSONObject, CommonConstants.TOTAL_DURATION, System.currentTimeMillis() - currentTimeMillis);
        JSONUtils.safePutLong(jSONObject, SettingsConstant.KEY_CLIPBOARD_VERIFY_TIMEOUT, timeoutForClipboardVerify);
        return parseResponse(executePostRequest, jSONObject, str2);
    }

    private static String parseResponse(String str, JSONObject jSONObject, String str2) {
        String str3;
        JSONObject jSONObject2;
        str3 = "";
        if (TextUtils.isEmpty(str)) {
            saveTTCBCache(str2);
            return "";
        }
        try {
            jSONObject2 = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject2 = null;
        }
        if (jSONObject2 == null) {
            return "";
        }
        int optInt = jSONObject2.optInt("code", -1);
        if (optInt == 0) {
            JSONObject optJSONObject = jSONObject2.optJSONObject("data");
            str3 = optJSONObject != null ? optJSONObject.optString("scheme") : "";
            UGZlinkLogger.onRequestSchemeSuccess(str3);
        } else {
            String optString = jSONObject2.optString("message");
            UGZlinkLogger.onRequestSchemeError(optInt, optString);
            Logger.m446d(TAG, "the request of clipboard check is failed, the message is : " + optString);
        }
        removeTTCBSave(str2);
        JSONUtils.safePutString(jSONObject, "code", String.valueOf(optInt));
        JSONUtils.safePutString(jSONObject, "scheme", str3);
        return str3;
    }

    private static void saveTTCBCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ClipboardSaveHelper.INSTANCE.saveTTCB(GlobalContext.INSTANCE.getApplication(), str);
    }

    private static void removeTTCBSave(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ClipboardSaveHelper.INSTANCE.removeTTCBSave(GlobalContext.INSTANCE.getApplication());
    }
}

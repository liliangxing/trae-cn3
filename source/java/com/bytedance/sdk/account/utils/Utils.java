package com.bytedance.sdk.account.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.CookieSyncManager;
import com.bytedance.sdk.account.bpea.BpeaManager;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.ss.android.token.TTTokenManager;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class Utils {
    private static final String TAG = "Utils";

    public static String getUrl(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2).append("/");
        return sb.toString();
    }

    public static String[] getCookieArray(String str) {
        String str2;
        try {
            str2 = (String) BpeaManager.invokeDeviceInfoApi(null, BpeaManager.SERVICE_CookieManager, BpeaManager.getCookie, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = null;
        }
        String[] split = TextUtils.isEmpty(str2) ? null : str2.split(";");
        if (split != null) {
            for (int i = 0; i < split.length; i++) {
                String str3 = split[i];
                if (str3 != null) {
                    split[i] = str3.trim();
                }
            }
        }
        return split;
    }

    public static String getSpecialCookieInfo(String str, String str2) {
        String str3;
        String[] cookieArray = getCookieArray(str);
        if (cookieArray == null || cookieArray.length == 0) {
            return "";
        }
        for (String str4 : cookieArray) {
            if (!TextUtils.isEmpty(str4)) {
                String[] split = str4.split("=");
                if (split.length >= 2 && (str3 = split[0]) != null && str3.trim().equalsIgnoreCase(str2)) {
                    return split[1];
                }
            }
        }
        return "";
    }

    public static String getAllCookieKeys(String str) {
        String[] cookieArray;
        if (TextUtils.isEmpty(str) || (cookieArray = getCookieArray(str)) == null || cookieArray.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str2 : cookieArray) {
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("=");
                if (split.length >= 2) {
                    if (i > 0) {
                        sb.append(IWeiboService.Scope.EMPTY_SCOPE);
                    }
                    sb.append(split[0].trim());
                    i++;
                }
            }
        }
        return sb.toString();
    }

    public static String getAllCookieKeysForDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String host = Uri.parse(str).getHost();
        TTTokenManager.log(TAG, String.format("getAllCookieForDomainKeys, domain for %s is %s", str, host));
        return getAllCookieKeys(host);
    }

    public static void flushCookie() {
        try {
            CookieSyncManager.getInstance().sync();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null || obj.getClass() != obj2.getClass()) {
            return false;
        }
        if (obj instanceof JSONObject) {
            return isJsonObjectEquals((JSONObject) obj, (JSONObject) obj2);
        }
        return obj.equals(obj2);
    }

    public static boolean isJsonObjectEquals(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == jSONObject2) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            Object opt2 = jSONObject2.opt(next);
            if (opt2 != null && opt.getClass() == opt2.getClass()) {
                if (opt instanceof JSONObject) {
                    if (!isJsonObjectEquals((JSONObject) opt, (JSONObject) opt2)) {
                        return false;
                    }
                } else if (!opt.equals(opt2)) {
                }
            }
            return false;
        }
        return true;
    }

    public static JSONArray jsonArrayRemoveAtIndex(JSONArray jSONArray, int i) throws JSONException {
        jSONArray.remove(i);
        return jSONArray;
    }

    public static boolean sendSms(Context context, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(String.format("smsto:%s", str)));
        intent.putExtra("sms_body", str2);
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(context);
        if (!TextUtils.isEmpty(defaultSmsPackage)) {
            intent.setPackage(defaultSmsPackage);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            Log.d(TAG, "sendSms: 失败, 无法打开系统发送短信activity, exception=" + Log.getStackTraceString(e));
            return false;
        }
    }

    public static String getFormattedTime(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(j));
    }

    public static List<Pair<String, String>> parseRequestBody(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                arrayList.add(new Pair(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8")));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }
}

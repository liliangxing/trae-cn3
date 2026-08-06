package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.util.JSONUtils;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class UploaderUrl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String urlAppendParam(String str, String str2) {
        try {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str + "?";
                }
            } else if (!str.endsWith("&")) {
                str = str + "&";
            }
            return str + str2;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String appendUrlParamsByMonitor(String str, EventMonitor eventMonitor) {
        HashMap hashMap = new HashMap();
        hashMap.put("aid", eventMonitor.getAppId());
        hashMap.put("version_code", String.valueOf(eventMonitor.getVersionCode()));
        hashMap.put("update_version_code", String.valueOf(eventMonitor.getUpdateVersionCode()));
        hashMap.put("app_version", String.valueOf(eventMonitor.getVersionName()));
        if (!TextUtils.isEmpty(eventMonitor.getChannel())) {
            hashMap.put("channel", eventMonitor.getChannel());
        }
        hashMap.put("device_id", eventMonitor.getDeviceId("0"));
        return appendUrlParamsByHeader(str, new JSONObject(hashMap));
    }

    public static String appendUrlParamsByHeader(String str, JSONObject jSONObject) {
        return appendParamsToURL(str, getSubMapKeyValuePair(JSONUtils.toMap(jSONObject), "aid", "4444", "os", "Android", "update_version_code", "000000", "channel", "unknown", "app_version", "0.0.0", "sdk_version", NpthBuildConfig.VERSION_NAME, "device_id", GeneralInfoManager.getRandomDeviceId()));
    }

    public static Map<String, String> getSubMapKeyValuePair(Map<String, Object> map, String... strArr) {
        HashMap hashMap = new HashMap();
        if (strArr == null || strArr.length == 0 || strArr.length % 2 != 0) {
            NpthMonitor.reportInnerException(new IllegalArgumentException("err keyValuePair:" + Arrays.toString(strArr)));
            return hashMap;
        }
        for (int i = 0; i < strArr.length; i += 2) {
            String str = strArr[i];
            Object obj = map.get(str);
            hashMap.put(str, obj != null ? String.valueOf(obj) : strArr[i + 1]);
        }
        return hashMap;
    }

    public static String appendParamToURL(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str3 == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        }
        try {
            if (!sb.toString().endsWith("?")) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str2, UrlUtils.UTF_8));
            sb.append("=");
            sb.append(URLEncoder.encode(str3, UrlUtils.UTF_8));
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static String appendParamsToURL(String str, Map map) {
        if (TextUtils.isDigitsOnly(str) || map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (!str.contains("?")) {
            sb.append("?");
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    if (!sb.toString().endsWith("?")) {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(entry.getKey().toString(), UrlUtils.UTF_8));
                    sb.append("=");
                    sb.append(URLEncoder.encode(entry.getValue().toString(), UrlUtils.UTF_8));
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    static String getUrlByCrashType(CrashType crashType) {
        if (crashType == CrashType.NATIVE) {
            return NetConfig.getNativeCrashUploadUrl();
        }
        if (crashType == CrashType.ANR || crashType == CrashType.JAVA || crashType == CrashType.DART) {
            return NetConfig.getJavaCrashUploadUrl();
        }
        if (crashType == CrashType.LAUNCH) {
            return NetConfig.getLaunchCrashUploadUrl();
        }
        if (crashType == CrashType.ASAN) {
            return NetConfig.getAsanReportUploadUrl();
        }
        if (crashType == CrashType.COREDUMP) {
            return NetConfig.getCoreDumpUrl();
        }
        if (crashType == CrashType.NATIVE_CUSTOMIZE) {
            return NetConfig.getExceptionZipUploadUrl();
        }
        return NetConfig.getJavaCrashUploadUrl();
    }

    public static String getUrlByCrashTypeAndHeader(CrashType crashType, JSONObject jSONObject) {
        String urlByCrashType = getUrlByCrashType(crashType);
        return !JSONUtils.isEmpty(jSONObject) ? appendUrlParamsByHeader(urlByCrashType, jSONObject) : urlByCrashType;
    }

    public static String appendAlogUrlParams(String str, int i, String str2, String str3, long j) {
        return appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(str, "aid", String.valueOf(i)), "device_id", str2), "os", "Android"), "update_version_code", String.valueOf(j)), "channel", "unknown"), "app_version", str3), "sdk_version", NpthBuildConfig.VERSION_NAME);
    }

    public static String appendAlogUrlParams(String str, String str2, String str3, String str4, long j) {
        return appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(appendParamToURL(str, "aid", str2), "device_id", str3), "os", "Android"), "update_version_code", String.valueOf(j)), "channel", "unknown"), "app_version", str4), "sdk_version", NpthBuildConfig.VERSION_NAME);
    }
}

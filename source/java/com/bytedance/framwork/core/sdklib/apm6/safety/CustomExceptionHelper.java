package com.bytedance.framwork.core.sdklib.apm6.safety;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdklib.apm6.SDKContext;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.bytedance.framwork.core.sdklib.util.JsonUtil;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.bytedance.framwork.core.sdkmonitor.MonitorNetUtil;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class CustomExceptionHelper {
    private static final String EXCEPTION_TYPE = "exception";
    private static final String KEY_EVENT_TYPE = "event_type";
    private static final String KEY_EXCEPTION_TYPE = "exception_type";
    private static final String KEY_FILTERS = "filters";
    private static final String KEY_INTERNAL_ERROR_KEY = "apm_sdk";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_STACK = "stack";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final int MAX_REPORT_COUNT = 3;
    public static final String PATH = "/monitor/collect/c/exception";
    private static final String TAG_INTERNAL_VALUE = "apm6_error";
    private static String url;
    private static AtomicInteger innerExceptionReportCount = new AtomicInteger(0);
    private static boolean enableReport = true;

    public static void setEnableReport(boolean z) {
        enableReport = z;
    }

    public static void setExceptionUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        url = str;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        url = str + "/monitor/collect/c/exception";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportSlardarIfNeed(final String str, final String str2, final Throwable th) {
        if (!TextUtils.isEmpty(url) && enableReport && innerExceptionReportCount.get() < 3) {
            innerExceptionReportCount.incrementAndGet();
            AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.framwork.core.sdklib.apm6.safety.CustomExceptionHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    CustomExceptionHelper.reportException(str, str2, th);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportException(String str, String str2, Throwable th) {
        ApmSDKInternalException apmSDKInternalException = new ApmSDKInternalException("tag=" + str + " message=" + str2, th);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", EXCEPTION_TYPE);
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put(KEY_STACK, getThrowableStack(apmSDKInternalException));
            jSONObject.put(KEY_EXCEPTION_TYPE, 1);
            jSONObject.put(KEY_MESSAGE, str + "_" + str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_INTERNAL_ERROR_KEY, TAG_INTERNAL_VALUE);
            jSONObject.put(KEY_FILTERS, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject3.put(Constants.KEY_DATA, jSONArray);
            JSONObject deepCopy = JsonUtil.deepCopy(SDKContext.getHeader());
            if (deepCopy != null) {
                deepCopy.put(MonitorConstants.KEY_AID, "44444");
            }
            jSONObject3.put(Constants.KEY_HEADER, deepCopy);
            if (SDKContext.isDebugMode()) {
                Log.e(Constants.TAG, "tag:" + str + " message:" + str2, apmSDKInternalException);
            }
            sendLog(url, jSONObject3.toString().getBytes());
        } catch (Throwable unused) {
            if (SDKContext.isDebugMode()) {
                Log.e(Constants.TAG, "tag:" + str + " message:" + str2, apmSDKInternalException);
            }
        }
    }

    private static void sendLog(String str, byte[] bArr) {
        if (!NetworkUtils.isNetworkAvailable(SDKContext.getContext())) {
            if (SDKContext.isDebugMode()) {
                com.bytedance.apm6.util.log.Logger.d(Constants.TAG, "network unreachable");
                return;
            }
            return;
        }
        if (bArr == null || bArr.length == 0) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            byte[] compress = MonitorNetUtil.compress(bArr, hashMap);
            HashMap hashMap2 = new HashMap(SDKContext.getCommonParams());
            hashMap2.put(MonitorConstants.KEY_AID, "44444");
            String addParamsToURL = UrlUtils.addParamsToURL(str, hashMap2);
            if (SDKContext.isDebugMode()) {
                com.bytedance.apm6.util.log.Logger.d(Constants.TAG, "http request:url:" + addParamsToURL);
            }
            SDKContext.doPost(addParamsToURL, hashMap, compress);
        } catch (Throwable th) {
            if (SDKContext.isDebugMode()) {
                th.printStackTrace();
            }
        }
    }

    private static String getThrowableStack(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        Throwable cause = th.getCause();
        if (cause != null) {
            cause.printStackTrace(printWriter);
            Throwable cause2 = cause.getCause();
            if (cause2 != null) {
                cause2.printStackTrace(printWriter);
            }
        }
        String stringWriter2 = stringWriter.toString();
        printWriter.close();
        return stringWriter2;
    }
}

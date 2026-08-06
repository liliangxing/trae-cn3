package com.bytedance.apm6.foundation.safety;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.service.http.HttpRequest;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CustomExceptionHelper {
    private static final int AID = 2085;
    private static final String EXCEPTION_TYPE = "exception";
    private static final String HOST_APP_ID = "host_aid";
    private static final String KEY_EVENT_TYPE = "event_type";
    private static final String KEY_EXCEPTION_TYPE = "exception_type";
    private static final String KEY_FILTERS = "filters";
    private static final String KEY_INTERNAL_ERROR_KEY = "apm_sdk";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_STACK = "stack";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final int MAX_REPORT_COUNT = 3;
    private static final String TAG = "APM-CustomException";
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reportSlardarIfNeed(final String str, final String str2, final Throwable th) {
        ApmAlogHelper.m76e(str, str2);
        if (!enableReport || innerExceptionReportCount.get() >= 3) {
            return;
        }
        innerExceptionReportCount.incrementAndGet();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AsyncTask() { // from class: com.bytedance.apm6.foundation.safety.CustomExceptionHelper.1
            @Override // java.lang.Runnable
            public void run() {
                CustomExceptionHelper.reportException(str, str2, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportException(String str, String str2, Throwable th) {
        ApmInternalException apmInternalException = new ApmInternalException("tag=" + str + " message=" + str2, th);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "exception");
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("stack", getThrowableStack(apmInternalException));
            jSONObject.put("exception_type", 1);
            jSONObject.put("message", str + "_" + str2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(KEY_INTERNAL_ERROR_KEY, TAG_INTERNAL_VALUE);
            jSONObject2.put(HOST_APP_ID, String.valueOf(ApmContext.getAid()));
            jSONObject.put("filters", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            jSONObject3.put("data", jSONArray);
            JSONObject jSONObject4 = new JSONObject();
            JsonUtils.copyJson2(jSONObject4, ApmContext.getStableHeaderExtras());
            ApmContextAdapter apmContextAdapter = ApmContext.getApmContextAdapter();
            if (apmContextAdapter != null) {
                JsonUtils.copyJson2(jSONObject4, apmContextAdapter.getDynamicHeaderExtras());
            }
            jSONObject4.put("os", "Android");
            jSONObject4.put("aid", AID);
            jSONObject4.put("device_id", ApmContext.getDeviceId());
            jSONObject4.put("channel", ApmContext.getChannel());
            jSONObject4.put("version_code", ApmContext.getVersionCode());
            jSONObject4.put("update_version_code", ApmContext.getUpdateVersionCode());
            jSONObject4.put("device_id", ApmContext.getDeviceId());
            jSONObject4.put("uid", ApmContext.getUserID());
            jSONObject4.put("process_name", ApmContext.getCurrentProcessName());
            jSONObject3.put("header", jSONObject4);
            if (ApmContext.isDebugMode()) {
                Log.e(TAG, "tag:" + str + " message:" + str2, apmInternalException);
            }
            sendLog(url, jSONObject3.toString().getBytes());
        } catch (Throwable unused) {
        }
    }

    private static void sendLog(String str, byte[] bArr) {
        if (!NetworkUtils.isNetworkAvailable(ApmContext.getContext())) {
            if (ApmContext.isDebugMode()) {
                Logger.m119d(TAG, "network unreachable");
            }
        } else {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                HttpRequest createRequest = createRequest(str, bArr);
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(TAG, "http request:url:" + createRequest.url + " headers:" + createRequest.headerMap);
                }
                ApmContext.doPost(createRequest.url, createRequest.headerMap, createRequest.data);
            } catch (Throwable th) {
                if (ApmContext.isDebugMode()) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static HttpRequest createRequest(String str, byte[] bArr) {
        HashMap hashMap = new HashMap();
        if (bArr.length > 128) {
            try {
                byte[] compress = compress(bArr);
                hashMap.put("Content-Encoding", "gzip");
                bArr = compress;
            } catch (IOException unused) {
            }
        }
        return new HttpRequest(UrlUtils.addParamsToURL(str, ApmContext.getUrlParams()), hashMap, bArr);
    }

    private static byte[] compress(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                IOUtils.closeQuietly(gZIPOutputStream2);
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream = gZIPOutputStream2;
                IOUtils.closeQuietly(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
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

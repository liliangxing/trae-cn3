package com.bytedance.apm.logging;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Logger {
    private static ILogger debugLog;
    private static ILogger sApmLogImp;

    /* JADX INFO: Access modifiers changed from: private */
    public static String wrap(String... strArr) {
        StringBuilder sb = new StringBuilder(400);
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    static {
        ILogger iLogger = new ILogger() { // from class: com.bytedance.apm.logging.Logger.1
            @Override // com.bytedance.apm.logging.ILogger
            public void v(String str, String... strArr) {
                Log.v(str, Logger.wrap(strArr));
            }

            @Override // com.bytedance.apm.logging.ILogger
            public void i(String str, String... strArr) {
                Log.i(str, Logger.wrap(strArr));
            }

            @Override // com.bytedance.apm.logging.ILogger
            public void d(String str, String... strArr) {
                Log.d(str, Logger.wrap(strArr));
            }

            @Override // com.bytedance.apm.logging.ILogger
            public void w(String str, String... strArr) {
                Log.w(str, Logger.wrap(strArr));
            }

            @Override // com.bytedance.apm.logging.ILogger
            public void e(String str, String... strArr) {
                Log.e(str, Logger.wrap(strArr));
            }

            @Override // com.bytedance.apm.logging.ILogger
            public void printErrStackTrace(String str, Throwable th, String... strArr) {
                String wrap = Logger.wrap(strArr);
                if (wrap == null) {
                    wrap = "";
                }
                Log.e(str, wrap + "  " + Log.getStackTraceString(th));
            }
        };
        debugLog = iLogger;
        sApmLogImp = iLogger;
    }

    private Logger() {
    }

    public static void seApmLogImp(ILogger iLogger) {
        sApmLogImp = iLogger;
    }

    public static ILogger getImpl() {
        return sApmLogImp;
    }

    public static void v(String str, String... strArr) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.v(str, strArr);
        }
    }

    public static void e(String str, String... strArr) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.e(str, strArr);
        }
    }

    public static void w(String str, String... strArr) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.w(str, strArr);
        }
    }

    public static void i(String str, String... strArr) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.i(str, strArr);
        }
    }

    public static void iJson(String str, Object... objArr) {
        if (sApmLogImp != null) {
            JSONObject jSONObject = new JSONObject();
            int length = objArr.length;
            if (length % 2 != 0) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < length; i += 2) {
                try {
                    jSONObject.put(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            sApmLogImp.i(str, jSONObject.toString());
        }
    }

    public static void d(String str, String... strArr) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.d(str, strArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String... strArr) {
        ILogger iLogger = sApmLogImp;
        if (iLogger != null) {
            iLogger.printErrStackTrace(str, th, strArr);
        }
    }
}

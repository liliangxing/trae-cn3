package com.bytedance.apm.alog;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.util.StackUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AlogMonitor {
    public static final String ALOG_RESULT = "success";
    public static final String ALOG_RESULT_CODE = "code";
    public static final int ALOG_RESULT_CODE_CONTEXT = 0;
    public static final int ALOG_RESULT_CODE_FILE_NULL = 2;
    public static final int ALOG_RESULT_CODE_IO_FAIL = 8;
    public static final int ALOG_RESULT_CODE_JSON_FAIL = 7;
    public static final int ALOG_RESULT_CODE_NET_FAIL = 6;
    public static final int ALOG_RESULT_CODE_NET_FAIL_NULL_RESPONSE = 11;
    public static final int ALOG_RESULT_CODE_NOT_ALLOW_ALOG = 9;
    public static final int ALOG_RESULT_CODE_NO_ALOG = 4;
    public static final int ALOG_RESULT_CODE_NO_ALOG_UPLOAD_STRATEGY = 12;
    public static final int ALOG_RESULT_CODE_NO_CONFIG_FILE = 1;
    public static final int ALOG_RESULT_CODE_NO_FLUSH = 3;
    public static final int ALOG_RESULT_CODE_NO_PARAM = 5;
    public static final int ALOG_RESULT_CODE_RESTRICT_BY_SERVER = 13;
    public static final int ALOG_RESULT_CODE_SUCCESS = -1;
    public static final int ALOG_RESULT_CODE_UNKNOWN_FAIL = 10;
    public static final String ALOG_RESULT_EXCEPTION = "exception";
    public static final String ALOG_RESULT_EXCEPTION_OBJECT = "exception_object";
    public static final String ALOG_RESULT_INFO = "info";
    public static final String ALOG_UPLOAD = "AlogUploadTag";

    public static void log(String str, Throwable th) {
        if (ApmContext.isDebugMode()) {
            String[] strArr = new String[2];
            strArr[0] = str;
            strArr[1] = th != null ? th.getMessage() : "";
            Logger.m88i(ALOG_UPLOAD, strArr);
        }
    }

    public static void log(String str) {
        log(str, null);
    }

    public static JSONObject getResult(boolean z, int i, Exception exc, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("success", z);
            jSONObject.put(ALOG_RESULT_CODE, i);
            if (exc != null) {
                jSONObject.put("exception", exc.getMessage() + StackUtils.getStack(exc));
                jSONObject.put(ALOG_RESULT_EXCEPTION_OBJECT, exc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

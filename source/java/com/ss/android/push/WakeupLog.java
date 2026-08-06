package com.ss.android.push;

import android.content.Context;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.message.log.PushLog;
import com.ss.android.message.util.ToolUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class WakeupLog {
    public static String LABEL_PREVENT_WAKEUP = "label_prevent_wakeup";
    public static String LABEL_WAKEUP_BY_THIRD = "label_wakeup_by_third";
    public static String TAG = "Wakeup";
    private static boolean isWakeUp;

    public static void wakeupLog(Context context, String str, long j, long j2, JSONObject jSONObject) {
        PushLog.onEvent(context, "event_v1", TAG, str, j, j2, jSONObject);
    }

    public static void preventWakeup(Context context, String str, String str2, JSONObject... jSONObjectArr) {
        JSONObject jSONObject;
        if (jSONObjectArr != null) {
            try {
                if (jSONObjectArr.length > 0) {
                    jSONObject = jSONObjectArr[0];
                    JSONObject jSONObject2 = jSONObject;
                    jSONObject2.put("package", str);
                    jSONObject2.put(FrescoMonitorConst.URI_QUERY_PARAM_FROM, str2);
                    wakeupLog(context, LABEL_PREVENT_WAKEUP, ToolUtils.currentTimeMillis(), 0L, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject = new JSONObject();
        JSONObject jSONObject22 = jSONObject;
        jSONObject22.put("package", str);
        jSONObject22.put(FrescoMonitorConst.URI_QUERY_PARAM_FROM, str2);
        wakeupLog(context, LABEL_PREVENT_WAKEUP, ToolUtils.currentTimeMillis(), 0L, jSONObject22);
    }

    public static void wakeupByOther(Context context, String str, String str2, JSONObject... jSONObjectArr) {
        JSONObject jSONObject;
        if (jSONObjectArr != null) {
            try {
                if (jSONObjectArr.length > 0) {
                    jSONObject = jSONObjectArr[0];
                    JSONObject jSONObject2 = jSONObject;
                    jSONObject2.put("package", str);
                    jSONObject2.put(FrescoMonitorConst.URI_QUERY_PARAM_FROM, str2);
                    wakeupLog(context, LABEL_WAKEUP_BY_THIRD, ToolUtils.currentTimeMillis(), 0L, jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        jSONObject = new JSONObject();
        JSONObject jSONObject22 = jSONObject;
        jSONObject22.put("package", str);
        jSONObject22.put(FrescoMonitorConst.URI_QUERY_PARAM_FROM, str2);
        wakeupLog(context, LABEL_WAKEUP_BY_THIRD, ToolUtils.currentTimeMillis(), 0L, jSONObject22);
    }

    public static boolean isWakeUp() {
        return isWakeUp;
    }

    public static void setIsWakeUp(boolean z) {
        isWakeUp = z;
    }
}

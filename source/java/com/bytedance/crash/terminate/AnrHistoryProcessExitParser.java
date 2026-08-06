package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.text.TextUtils;
import com.bytedance.crash.constants.Constants;
import com.ss.android.update.UpdateDialogNewBase;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AnrHistoryProcessExitParser {
    public static void parseProcessExitReason(JSONObject jSONObject) {
        try {
            List<ApplicationExitInfo> processExitReasons = AppExitInfoUtils.getProcessExitReasons();
            if (processExitReasons == null) {
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("custom");
            long optLong = jSONObject.optLong("crash_time");
            int optInt = jSONObject.optInt("pid");
            String optString = jSONObject.optString("process_name");
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (ApplicationExitInfo applicationExitInfo : processExitReasons) {
                if (applicationExitInfo.getProcessName().equals(optString) && optInt == applicationExitInfo.getPid()) {
                    long timestamp = applicationExitInfo.getTimestamp() - optLong;
                    if (timestamp > 0 && timestamp <= 30000) {
                        if (applicationExitInfo.getReason() == 6) {
                            sb3.append(applicationExitInfo.getDescription() + ",");
                        }
                        sb.append(applicationExitInfo.getReason() + ",");
                        sb2.append("timestamp=" + applicationExitInfo.getTimestamp());
                        sb2.append(" crash_pid=" + optInt);
                        sb2.append(" crash_time=" + optLong + " \n");
                        sb2.append(applicationExitInfo);
                        sb2.append(UpdateDialogNewBase.TYPE);
                    }
                }
            }
            if (sb2.length() > 0) {
                optJSONObject.put("history_exit_process_list", sb2);
            }
            jSONObject.put(Constants.EXIT_REASON, sb);
            if (sb3.length() > 0) {
                jSONObject.put(Constants.PROCESS_EXIT_ANR_REASON, sb3);
            }
        } catch (Throwable unused) {
        }
    }

    public static void pushToFilters(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            String optString = jSONObject.optString(Constants.EXIT_REASON);
            if (!TextUtils.isEmpty(optString)) {
                jSONObject2.put(Constants.EXIT_REASON, optString);
            }
            String optString2 = jSONObject.optString(Constants.PROCESS_EXIT_ANR_REASON);
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            jSONObject2.put(Constants.PROCESS_EXIT_ANR_REASON, optString2);
        } catch (Throwable unused) {
        }
    }
}

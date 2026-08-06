package com.bytedance.crash.terminate;

import android.app.ApplicationExitInfo;
import android.icu.text.SimpleDateFormat;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.Stack;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.ss.android.update.UpdateDialogNewBase;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppExitInfo {
    private String mDescription;
    private int mImportance;
    private int mPid;
    private String mProcessName;
    private String mPss;
    private long mRealPss;
    private long mRealRss;
    private String mReason;
    private String mRss;
    private int mStatus;
    private String mSubReason;
    private long mTimestamp;

    public static AppExitInfo get(ApplicationExitInfo applicationExitInfo) {
        AppExitInfo appExitInfo = new AppExitInfo();
        appExitInfo.mProcessName = applicationExitInfo.getProcessName();
        appExitInfo.mTimestamp = applicationExitInfo.getTimestamp();
        appExitInfo.mPid = applicationExitInfo.getPid();
        appExitInfo.mImportance = applicationExitInfo.getImportance();
        appExitInfo.mReason = AppExitInfoUtils.reasonCodeToString(applicationExitInfo.getReason());
        appExitInfo.mStatus = applicationExitInfo.getStatus();
        appExitInfo.mRealPss = applicationExitInfo.getPss();
        appExitInfo.mRealRss = applicationExitInfo.getRss();
        appExitInfo.mPss = (applicationExitInfo.getPss() / 1024) + "M";
        appExitInfo.mRss = (applicationExitInfo.getRss() / 1024) + "M";
        appExitInfo.mDescription = applicationExitInfo.getDescription();
        try {
            appExitInfo.mSubReason = AppExitInfoUtils.subreasonToString(((Integer) JavaCalls.callMethod(applicationExitInfo, "getSubReason", new Object[0])).intValue());
        } catch (Throwable unused) {
            appExitInfo.mSubReason = "UNKNOWN";
        }
        return appExitInfo;
    }

    public String getNativeStack(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mReason);
        sb.append("\npid:");
        sb.append(this.mPid);
        sb.append(" process:");
        sb.append(this.mProcessName);
        sb.append(" alive_time:");
        sb.append(this.mTimestamp - j);
        sb.append(" last_alive_time:");
        sb.append(this.mTimestamp - j);
        sb.append("\n#exitInfo\n");
        sb.append(new SimpleDateFormat().format(new Date(this.mTimestamp))).append(UpdateDialogNewBase.TYPE);
        sb.append("importance=").append(this.mImportance).append("\nsub_reason=");
        sb.append(this.mSubReason).append("\nstatus=");
        sb.append(this.mStatus).append("\ndescription=");
        sb.append(this.mDescription).append("\npss=");
        sb.append(this.mPss).append("\nreason=");
        sb.append(this.mReason).append("\nprocess=");
        sb.append(this.mProcessName).append("\nrss=");
        sb.append(this.mRss).append(UpdateDialogNewBase.TYPE);
        return sb.toString();
    }

    public JSONObject toJson(long j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exit_status", String.valueOf(getStatus()));
        hashMap.put("exit_pss", AppExitInfoUtils.memValueToRange(getRealPss()));
        hashMap.put("exit_rss", AppExitInfoUtils.memValueToRange(getRealRss()));
        hashMap.put("has_exit_info", RouterConstants.TRUE);
        hashMap.put(Constants.EXIT_REASON, getReason());
        hashMap.put("exit_sub_reason", getSubReason());
        HashMap hashMap2 = new HashMap(hashMap);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", "exception");
            jSONObject.put("crash_time", this.mTimestamp);
            jSONObject.put("log_type", "PROCESS_DIED");
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("message", "PROCESS_DIED");
            jSONObject.put(CrashBody.CRASH_THREAD_NAME, "UNKNOW");
            jSONObject.put("crash_md5", Digest.getMD5(str));
            jSONObject.put("process_name", getProcessName());
            jSONObject.put("app_start_time", j);
            jSONObject.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, 1);
            jSONObject.put("pid", this.mPid);
            jSONObject.put(EnsureReportData.CLASS_REF, "Native");
            jSONObject.put("method", "Native");
            jSONObject.put("is_core", 1);
            jSONObject.put(EnsureReportData.LINE_NUM, -1);
            jSONObject.put(EnsureReportData.ENSURE_TYPE, EnsureDeliverer.ENSURE_NOT_REACH_HERE);
            jSONObject.put("stack", str);
            jSONObject.put(Constants.HAS_DUMP, RouterConstants.TRUE);
            jSONObject.put("java_data", Stack.DIED_PROCESS_STACK);
            appendCustomData(jSONObject, hashMap);
            appendFilters(jSONObject, hashMap2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private void appendCustomData(JSONObject jSONObject, Map<String, String> map) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            if (JSONUtils.isEmpty(jSONObject2)) {
                return;
            }
            jSONObject.put("custom", jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public void appendFilters(JSONObject jSONObject, Map<String, String> map) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
            }
            if (JSONUtils.isEmpty(jSONObject2)) {
                return;
            }
            jSONObject.put("filters", jSONObject2);
        } catch (Throwable unused) {
        }
    }

    public static void append(JSONObject jSONObject, String str, String str2) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("filters");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.put("filters", optJSONObject);
            }
            optJSONObject.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public String getReason() {
        return this.mReason;
    }

    public String getSubReason() {
        return this.mSubReason;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getPid() {
        return this.mPid;
    }

    public int getImportance() {
        return this.mImportance;
    }

    public String getPss() {
        return this.mPss;
    }

    public String getRss() {
        return this.mRss;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public long getRealPss() {
        return this.mRealPss;
    }

    public long getRealRss() {
        return this.mRealRss;
    }

    public String toString() {
        return "AppExitInfo{mProcessName='" + this.mProcessName + "', mTimestamp=" + this.mTimestamp + ", mPid=" + this.mPid + ", mReason='" + this.mReason + "', mStatus=" + this.mStatus + ", mImportance=" + this.mImportance + ", mPss='" + this.mPss + "', mRss='" + this.mRss + "', mDescription='" + this.mDescription + "', mRealPss=" + this.mRealPss + ", mRealRss=" + this.mRealRss + ", subReason='" + this.mSubReason + "'}";
    }
}

package com.bytedance.apm.battery.stats.info;

import android.os.SystemClock;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AlarmInfo extends BaseHookInfo {
    public String intentInfo;
    public long interval;
    public int type;

    public long getUTCTriggerAtMillis() {
        int i = this.type;
        if (i == 1 || i == 0) {
            return this.startTime;
        }
        return (this.startTime + System.currentTimeMillis()) - SystemClock.elapsedRealtime();
    }

    public boolean isWakeUpAlarm() {
        int i = this.type;
        return i == 2 || i == 0;
    }

    public String toString() {
        return "AlarmInfo{type=" + this.type + ", interval=" + this.interval + ", intentInfo=" + this.intentInfo + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadName=" + this.threadName + ", threadStack=" + getStackDetails() + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_time", this.startTime);
            jSONObject.put("end_time", this.endTime);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, this.threadName);
            jSONObject.put("thread_stack", getStackDetails());
            jSONObject.put("interval", this.interval);
            jSONObject.put("type", this.type);
            jSONObject.put("intent_info", this.intentInfo);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}

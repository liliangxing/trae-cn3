package com.bytedance.apm.battery.stats.info;

import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class WakeLockInfo extends BaseHookInfo {
    public int flags;
    public String tag;

    public String toString() {
        return "WakeLockInfo{flags=" + this.flags + ", tag=" + this.tag + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadName=" + this.threadName + ", threadStack=" + getStackDetails() + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(RouterConstants.QUERY_KEY_FLAGS, this.flags);
            jSONObject.put("tag", this.tag);
            jSONObject.put("start_time", this.startTime);
            jSONObject.put("end_time", this.endTime);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, this.threadName);
            jSONObject.put("thread_stack", getStackDetails());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}

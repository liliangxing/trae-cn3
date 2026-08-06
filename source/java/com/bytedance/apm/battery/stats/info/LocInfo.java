package com.bytedance.apm.battery.stats.info;

import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LocInfo extends BaseHookInfo {
    public String request;

    public String toString() {
        return "LocInfo{request=" + this.request + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", threadName=" + this.threadName + ", threadStack=" + getStackDetails() + AbstractJsonLexerKt.END_OBJ;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("start_time", this.startTime);
            jSONObject.put("end_time", this.endTime);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, this.threadName);
            jSONObject.put("thread_stack", getStackDetails());
            jSONObject.put(OauthTokenTriggerScene.REQUEST, this.request);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}

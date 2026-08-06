package com.bytedance.applog.monitor.p006v3;

import android.text.TextUtils;
import com.bytedance.applog.priority.original.SqliteDatabaseKt;
import com.bytedance.applog.server.Api;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class StageEventBasic {
    public String eventName;
    public StageEventType eventType;
    public int groupId;
    public final String monitorId;
    public String priorityName;

    /* renamed from: ts */
    public long f59ts;

    public StageEventBasic(String str, String str2, long j, StageEventType stageEventType) {
        this(null, -1, str, str2, j, stageEventType);
    }

    public StageEventBasic(JSONObject jSONObject) {
        this(jSONObject.optString("priority_name"), jSONObject.optInt("group_id", -1), jSONObject.optString("event_name"), jSONObject.optString(SqliteDatabaseKt.colMonitorId), jSONObject.optLong(Api.KEY_LOCAL_TIME_MS), StageEventType.parse(jSONObject.optString("type")));
    }

    public StageEventBasic(String str, int i, String str2, String str3, long j, StageEventType stageEventType) {
        this.priorityName = str;
        this.groupId = i;
        this.eventName = str2;
        this.monitorId = str3;
        this.f59ts = j;
        this.eventType = stageEventType;
    }

    public void merge(StageEventBasic stageEventBasic) {
        StageEventType stageEventType;
        int i;
        if (TextUtils.equals(this.monitorId, stageEventBasic.monitorId)) {
            if (TextUtils.isEmpty(this.priorityName) && !TextUtils.isEmpty(stageEventBasic.priorityName)) {
                this.priorityName = stageEventBasic.priorityName;
            }
            if (this.groupId < 0 && (i = stageEventBasic.groupId) >= 0) {
                this.groupId = i;
            }
            if (TextUtils.isEmpty(this.eventName) && !TextUtils.isEmpty(stageEventBasic.eventName)) {
                this.eventName = stageEventBasic.eventName;
            }
            if (this.f59ts <= 0) {
                long j = stageEventBasic.f59ts;
                if (j > 0) {
                    this.f59ts = j;
                }
            }
            if (this.eventType != null || (stageEventType = stageEventBasic.eventType) == null) {
                return;
            }
            this.eventType = stageEventType;
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_name", this.eventName);
            jSONObject.put(SqliteDatabaseKt.colMonitorId, this.monitorId);
            StageEventType stageEventType = this.eventType;
            if (stageEventType != null) {
                jSONObject.put("type", stageEventType.name());
            }
            long j = this.f59ts;
            if (j > 0) {
                jSONObject.put(Api.KEY_LOCAL_TIME_MS, j);
            }
            String str = this.priorityName;
            if (str != null && !str.isEmpty()) {
                jSONObject.put("priority_name", this.priorityName);
            }
            int i = this.groupId;
            if (i >= 0) {
                jSONObject.put("group_id", i);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}

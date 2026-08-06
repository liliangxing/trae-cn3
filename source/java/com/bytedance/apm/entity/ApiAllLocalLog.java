package com.bytedance.apm.entity;

import com.bytedance.apm.constant.TrafficConsts;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ApiAllLocalLog extends LocalLog {
    public int front;
    public int hitRules;

    /* renamed from: net, reason: collision with root package name */
    public int f1104net;
    public long sid;
    public long trafficValue;

    public ApiAllLocalLog() {
    }

    public ApiAllLocalLog(long j, String str, long j2, JSONObject jSONObject) {
        super(j, str, j2, jSONObject);
    }

    public ApiAllLocalLog(long j, String str, long j2, String str2) {
        super(j, str, j2, str2);
    }

    @Override // com.bytedance.apm.entity.LocalLog
    public LocalLog setData(JSONObject jSONObject) {
        this.front = jSONObject.optInt("front");
        this.sid = jSONObject.optLong("sid");
        this.f1104net = jSONObject.optInt("network_type");
        this.hitRules = jSONObject.optInt("hit_rules");
        this.trafficValue = jSONObject.optLong(TrafficConsts.KEY_SENT_BYTES, 0L) + jSONObject.optLong(TrafficConsts.KEY_RECEIVED_BYTES, 0L);
        return super.setData(jSONObject);
    }
}

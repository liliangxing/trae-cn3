package com.bytedance.falconx.statistic;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class DefaultStatisticMonitor implements IStatisticMonitor {
    public abstract void monitorEvent(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, Boolean bool);

    @Override // com.bytedance.falconx.statistic.IStatisticMonitor
    public abstract void upload(String str, JSONObject jSONObject);
}

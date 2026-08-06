package com.bytedance.apm6.java_alloc.model;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ReportData {
    public JSONObject config;
    public long duration;
    public List<ReportInfo> infoList;

    public ReportData(List<ReportInfo> list, long j, JSONObject jSONObject) {
        this.infoList = list;
        this.duration = j;
        this.config = jSONObject;
    }
}

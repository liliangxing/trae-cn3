package com.xiaomi.push;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.ca */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1521ca {

    /* renamed from: a */
    private int f1135a;

    /* renamed from: a */
    private long f1136a;

    /* renamed from: a */
    private String f1137a;

    /* renamed from: b */
    private long f1138b;

    /* renamed from: c */
    private long f1139c;

    public C1521ca() {
        this(0, 0L, 0L, null);
    }

    public C1521ca(int i, long j, long j2, Exception exc) {
        this.f1135a = i;
        this.f1136a = j;
        this.f1139c = j2;
        this.f1138b = System.currentTimeMillis();
        if (exc != null) {
            this.f1137a = exc.getClass().getSimpleName();
        }
    }

    /* renamed from: a */
    public int m1774a() {
        return this.f1135a;
    }

    /* renamed from: a */
    public JSONObject m1776a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f1136a);
        jSONObject.put(MonitorConstants.SIZE, this.f1139c);
        jSONObject.put("ts", this.f1138b);
        jSONObject.put("wt", this.f1135a);
        jSONObject.put("expt", this.f1137a);
        return jSONObject;
    }

    /* renamed from: a */
    public C1521ca m1775a(JSONObject jSONObject) {
        this.f1136a = jSONObject.getLong("cost");
        this.f1139c = jSONObject.getLong(MonitorConstants.SIZE);
        this.f1138b = jSONObject.getLong("ts");
        this.f1135a = jSONObject.getInt("wt");
        this.f1137a = jSONObject.optString("expt");
        return this;
    }
}

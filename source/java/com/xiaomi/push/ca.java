package com.xiaomi.push;

import org.json.JSONObject;

/* loaded from: classes7.dex */
public class ca {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private long f235a;

    /* renamed from: a, reason: collision with other field name */
    private String f236a;
    private long b;
    private long c;

    public ca() {
        this(0, 0L, 0L, null);
    }

    public ca(int i, long j, long j2, Exception exc) {
        this.a = i;
        this.f235a = j;
        this.c = j2;
        this.b = System.currentTimeMillis();
        if (exc != null) {
            this.f236a = exc.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public JSONObject m9695a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f235a);
        jSONObject.put("size", this.c);
        jSONObject.put("ts", this.b);
        jSONObject.put("wt", this.a);
        jSONObject.put("expt", this.f236a);
        return jSONObject;
    }

    public ca a(JSONObject jSONObject) {
        this.f235a = jSONObject.getLong("cost");
        this.c = jSONObject.getLong("size");
        this.b = jSONObject.getLong("ts");
        this.a = jSONObject.getInt("wt");
        this.f236a = jSONObject.optString("expt");
        return this;
    }
}

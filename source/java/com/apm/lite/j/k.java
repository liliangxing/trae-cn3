package com.apm.lite.j;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public class k {
    private final int a;
    private String b;
    private JSONObject c;
    private byte[] d;

    public k(int i) {
        this.a = i;
    }

    public k(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public k(int i, Throwable th) {
        this.a = i;
        if (th != null) {
            this.b = th.getMessage();
        }
    }

    public k(int i, JSONObject jSONObject) {
        this.a = i;
        this.c = jSONObject;
    }

    public k(int i, byte[] bArr) {
        this.a = i;
        this.d = bArr;
    }

    public boolean a() {
        return this.a != 207;
    }

    public byte[] b() {
        return this.d;
    }
}

package com.apm.lite.p022j;

import org.json.JSONObject;

/* renamed from: com.apm.lite.j.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0776k {

    /* renamed from: a */
    private final int f564a;

    /* renamed from: b */
    private String f565b;

    /* renamed from: c */
    private JSONObject f566c;

    /* renamed from: d */
    private byte[] f567d;

    public C0776k(int i) {
        this.f564a = i;
    }

    public C0776k(int i, String str) {
        this.f564a = i;
        this.f565b = str;
    }

    public C0776k(int i, Throwable th) {
        this.f564a = i;
        if (th != null) {
            this.f565b = th.getMessage();
        }
    }

    public C0776k(int i, JSONObject jSONObject) {
        this.f564a = i;
        this.f566c = jSONObject;
    }

    public C0776k(int i, byte[] bArr) {
        this.f564a = i;
        this.f567d = bArr;
    }

    /* renamed from: a */
    public boolean m732a() {
        return this.f564a != 207;
    }

    /* renamed from: b */
    public byte[] m733b() {
        return this.f567d;
    }
}

package com.cmic.sso.sdk.p003c.p007d;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HttpSuccessResponse.java */
/* renamed from: com.cmic.sso.sdk.c.d.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0127b {

    /* renamed from: a */
    private int f274a;

    /* renamed from: b */
    private Map<String, List<String>> f275b;

    /* renamed from: c */
    private String f276c;

    public C0127b(int i, Map<String, List<String>> map, String str) {
        this.f274a = i;
        this.f275b = map;
        this.f276c = str;
    }

    /* renamed from: a */
    public int m280a() {
        return this.f274a;
    }

    /* renamed from: b */
    public Map<String, List<String>> m281b() {
        Map<String, List<String>> map = this.f275b;
        return map == null ? new HashMap() : map;
    }

    /* renamed from: c */
    public String m282c() {
        String str = this.f276c;
        return str == null ? "" : str;
    }

    /* renamed from: d */
    public boolean m283d() {
        int i = this.f274a;
        return i == 302 || i == 301;
    }
}

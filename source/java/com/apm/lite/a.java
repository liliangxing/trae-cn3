package com.apm.lite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class a {
    private Map<CrashType, List<AttachUserData>> a = new HashMap();
    private Map<CrashType, List<AttachUserData>> b = new HashMap();
    private Map<String, String> c = new HashMap();
    private ICrashFilter d = null;

    public List<AttachUserData> a(CrashType crashType) {
        return this.a.get(crashType);
    }

    public Map<String, String> a() {
        return this.c;
    }

    public ICrashFilter b() {
        return this.d;
    }

    public List<AttachUserData> b(CrashType crashType) {
        return this.b.get(crashType);
    }
}

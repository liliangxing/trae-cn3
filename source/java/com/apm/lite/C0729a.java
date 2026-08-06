package com.apm.lite;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.apm.lite.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0729a {

    /* renamed from: a */
    private Map<CrashType, List<AttachUserData>> f339a = new HashMap();

    /* renamed from: b */
    private Map<CrashType, List<AttachUserData>> f340b = new HashMap();

    /* renamed from: c */
    private Map<String, String> f341c = new HashMap();

    /* renamed from: d */
    private ICrashFilter f342d = null;

    /* renamed from: a */
    public List<AttachUserData> m374a(CrashType crashType) {
        return this.f339a.get(crashType);
    }

    /* renamed from: a */
    public Map<String, String> m375a() {
        return this.f341c;
    }

    /* renamed from: b */
    public ICrashFilter m376b() {
        return this.f342d;
    }

    /* renamed from: b */
    public List<AttachUserData> m377b(CrashType crashType) {
        return this.f340b.get(crashType);
    }
}

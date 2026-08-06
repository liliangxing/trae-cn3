package com.vivo.push.p018i;

import java.util.ArrayList;

/* compiled from: TestManager.java */
/* renamed from: com.vivo.push.i.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1302a {

    /* renamed from: a */
    private static String[] f505a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};

    /* renamed from: b */
    private ArrayList<String> f506b;

    /* synthetic */ C1302a(byte b) {
        this();
    }

    /* renamed from: a */
    public static C1302a m750a() {
        return a.f507a;
    }

    /* compiled from: TestManager.java */
    /* renamed from: com.vivo.push.i.a$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class a {

        /* renamed from: a */
        private static C1302a f507a = new C1302a(0);
    }

    private C1302a() {
        this.f506b = null;
        this.f506b = new ArrayList<>();
    }

    /* renamed from: b */
    public final boolean m751b() {
        ArrayList<String> arrayList = this.f506b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }
}

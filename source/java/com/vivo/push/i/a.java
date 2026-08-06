package com.vivo.push.i;

import java.util.ArrayList;

/* compiled from: TestManager.java */
/* loaded from: classes7.dex */
public final class a {
    private static String[] a = {"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};
    private ArrayList<String> b;

    /* synthetic */ a(byte b) {
        this();
    }

    public static a a() {
        return C0172a.a;
    }

    /* compiled from: TestManager.java */
    /* renamed from: com.vivo.push.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0172a {
        private static a a = new a(0);
    }

    private a() {
        this.b = null;
        this.b = new ArrayList<>();
    }

    public final boolean b() {
        ArrayList<String> arrayList = this.b;
        return (arrayList == null || arrayList.size() == 0) ? false : true;
    }
}

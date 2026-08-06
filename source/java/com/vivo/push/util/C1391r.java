package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.vivo.push.p009a.C1200a;
import com.vivo.push.p010b.C1217n;
import com.vivo.push.p018i.C1302a;

/* compiled from: LogController.java */
/* renamed from: com.vivo.push.util.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1391r implements InterfaceC1392s {

    /* renamed from: a */
    private static final String f720a = "(" + Process.myPid() + ")";

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: a */
    public final int mo1023a(String str, String str2) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f720a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: a */
    public final int mo1025a(String str, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: a */
    public final int mo1024a(String str, String str2, Throwable th) {
        return Log.e("VivoPush.Client.".concat(String.valueOf(str)), f720a + str2, th);
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: b */
    public final int mo1027b(String str, String str2) {
        return Log.w("VivoPush.Client.".concat(String.valueOf(str)), f720a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: c */
    public final int mo1030c(String str, String str2) {
        return Log.d("VivoPush.Client.".concat(String.valueOf(str)), f720a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: d */
    public final int mo1032d(String str, String str2) {
        if (C1393t.m1040a()) {
            return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f720a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: b */
    public final int mo1028b(String str, String str2, Throwable th) {
        if (C1393t.m1040a()) {
            return Log.i("VivoPush.Client.".concat(String.valueOf(str)), f720a + str2, th);
        }
        return -1;
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: e */
    public final int mo1033e(String str, String str2) {
        if (C1393t.m1040a()) {
            return Log.v("VivoPush.Client.".concat(String.valueOf(str)), f720a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: a */
    public final void mo1026a(Context context, String str) {
        if (m1022a()) {
            m1021a(context, str, 0);
        }
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: b */
    public final void mo1029b(Context context, String str) {
        if (m1022a()) {
            m1021a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.InterfaceC1392s
    /* renamed from: c */
    public final void mo1031c(Context context, String str) {
        if (m1022a()) {
            m1021a(context, str, 2);
        }
    }

    /* renamed from: a */
    private void m1021a(Context context, String str, int i) {
        C1217n c1217n = new C1217n();
        c1217n.m602b(str);
        c1217n.m601a(i);
        if (i > 0) {
            mo1032d("LogController", str);
        }
        c1217n.m606h();
        C1200a.m576a(context, c1217n, context.getPackageName());
    }

    /* renamed from: a */
    private static boolean m1022a() {
        C1393t.m1040a();
        return C1302a.m750a().m751b();
    }
}

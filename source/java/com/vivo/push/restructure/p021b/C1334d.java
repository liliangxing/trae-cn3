package com.vivo.push.restructure.p021b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.PushConfig;
import com.vivo.push.model.C1307a;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1380g;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.C1399z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PushRelyImpl.java */
/* renamed from: com.vivo.push.restructure.b.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1334d implements InterfaceC1331a {

    /* renamed from: a */
    private static Map<String, C1333c> f589a = new ConcurrentHashMap();

    /* renamed from: b */
    private String f590b;

    /* renamed from: c */
    private C1399z f591c;

    /* renamed from: d */
    private volatile PushConfig f592d;

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: l */
    public final int mo872l() {
        return 31;
    }

    public C1334d(C1399z c1399z) {
        this.f591c = c1399z;
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: a */
    public final String mo855a(Context context, String str) {
        if (!TextUtils.isEmpty(this.f590b)) {
            return this.f590b;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            C1393t.m1034a("PushRelyImpl", "getReceiverClassName() params error, context = " + context + ", action = " + str);
            return "";
        }
        String packageName = context.getPackageName();
        String m878a = m878a(context, packageName, str);
        this.f590b = m878a;
        if (TextUtils.isEmpty(m878a)) {
            C1393t.m1048d("PushRelyImpl", " reflectReceiver error: receiver for: " + str + " not found, package: " + packageName);
        }
        return this.f590b;
    }

    /* renamed from: a */
    private static String m878a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e) {
            C1393t.m1034a("PushRelyImpl", "error  " + e.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: a */
    public final String mo854a() {
        C1333c c1333c = f589a.get(C1313a.m810a().m812b().getPackageName());
        if (c1333c != null) {
            String m874a = c1333c.m874a();
            if (!TextUtils.isEmpty(m874a)) {
                return m874a;
            }
        }
        String m1059c = this.f591c.m1059c();
        if (!TextUtils.isEmpty(m1059c)) {
            if (c1333c == null) {
                c1333c = new C1333c();
            }
            c1333c.m875a(m1059c);
            f589a.put(C1313a.m810a().m812b().getPackageName(), c1333c);
        }
        return m1059c;
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: b */
    public final void mo858b() {
        mo857a("");
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: c */
    public final String mo860c() {
        C1333c c1333c = f589a.get(C1313a.m810a().m812b().getPackageName());
        if (c1333c != null) {
            String m876b = c1333c.m876b();
            if (!TextUtils.isEmpty(m876b)) {
                return m876b;
            }
        }
        String m1060d = this.f591c.m1060d();
        if (!TextUtils.isEmpty(m1060d)) {
            if (c1333c == null) {
                c1333c = new C1333c();
            }
            c1333c.m877b(m1060d);
            f589a.put(C1313a.m810a().m812b().getPackageName(), c1333c);
        }
        return m1060d;
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: a */
    public final void mo857a(String str) {
        this.f591c.m986a("APP_APPID", str);
        C1333c c1333c = f589a.get(C1313a.m810a().m812b().getPackageName());
        if (c1333c == null) {
            c1333c = new C1333c();
        }
        c1333c.m875a(str);
        f589a.put(C1313a.m810a().m812b().getPackageName(), c1333c);
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: b */
    public final void mo859b(String str) {
        this.f591c.m986a("APP_APIKEY", str);
        C1333c c1333c = f589a.get(C1313a.m810a().m812b().getPackageName());
        if (c1333c == null) {
            c1333c = new C1333c();
        }
        c1333c.m877b(str);
        f589a.put(C1313a.m810a().m812b().getPackageName(), c1333c);
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: d */
    public final void mo862d() {
        mo859b("");
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: e */
    public final void mo864e() {
        this.f591c.m990b();
        f589a.clear();
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: f */
    public final String mo866f() {
        return this.f591c.m989b("APP_TOKEN", (String) null);
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: c */
    public final void mo861c(String str) {
        this.f591c.m986a("APP_TOKEN", str);
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: g */
    public final String mo867g() {
        return this.f591c.m989b("APP_TAGS", (String) null);
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: d */
    public final void mo863d(String str) {
        this.f591c.m986a("APP_TAGS", str);
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: h */
    public final void mo868h() {
        this.f591c.m992c("APP_TAGS");
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: i */
    public final String mo869i() {
        return this.f591c.m989b("APP_ALIAS", (String) null);
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: e */
    public final void mo865e(String str) {
        this.f591c.m986a("APP_ALIAS", str);
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: j */
    public final void mo870j() {
        this.f591c.m992c("APP_ALIAS");
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: k */
    public final String mo871k() {
        C1307a m924a = C1366aa.m924a(C1313a.m810a().m812b(), C1313a.m810a().m816f());
        if (m924a == null || m924a.m808c()) {
            return null;
        }
        return m924a.m802a();
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: m */
    public final PushConfig mo873m() {
        if (this.f592d != null) {
            return this.f592d;
        }
        int m987b = this.f591c.m987b("PUSH_CLIENT_CONFIG", 1);
        return new PushConfig.Builder().agreePrivacyStatement((m987b & 1) != 0).openMultiUserMode((m987b & 2) != 0).build();
    }

    @Override // com.vivo.push.restructure.p021b.InterfaceC1331a
    /* renamed from: a */
    public final void mo856a(PushConfig pushConfig) {
        int i;
        if (pushConfig == null) {
            return;
        }
        this.f592d = pushConfig;
        Context m812b = C1313a.m810a().m812b();
        if (pushConfig == null) {
            i = 1;
        } else {
            i = (pushConfig.isAgreePrivacyStatement() ? 1 : 0) | (pushConfig.isOpenMultiUser() ? 2 : 0);
        }
        this.f591c.m984a("PUSH_CLIENT_CONFIG", i);
        C1380g.m996a().execute(new RunnableC1335e(this, m812b, pushConfig));
    }
}

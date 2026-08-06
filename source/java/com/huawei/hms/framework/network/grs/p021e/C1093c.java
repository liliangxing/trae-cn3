package com.huawei.hms.framework.network.grs.p021e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.lynx.tasm.animation.AnimationConstant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.e.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1093c {

    /* renamed from: b */
    private static final String f1295b = "c";

    /* renamed from: c */
    private static final Map<String, PLSharedPreferences> f1296c = new ConcurrentHashMap(16);

    /* renamed from: a */
    private final PLSharedPreferences f1297a;

    public C1093c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.m1181d(f1295b, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = f1296c;
        if (map.containsKey(str + packageName)) {
            this.f1297a = map.get(str + packageName);
        } else {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(context, str + packageName);
            this.f1297a = pLSharedPreferences;
            map.put(str + packageName, pLSharedPreferences);
        }
        m1243a(context);
    }

    /* renamed from: a */
    private void m1243a(Context context) {
        String str = f1295b;
        Logger.m1185i(str, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String l = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), AnimationConstant.PROP_MAX_WIDTH).versionCode);
            String m1244a = m1244a("version", "");
            if (l.equals(m1244a)) {
                return;
            }
            Logger.m1186i(str, "app version changed! old version{%s} and new version{%s}", m1244a, l);
            m1247b();
            m1248b("version", l);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.m1189w(f1295b, "get app version failed and catch NameNotFoundException");
        }
    }

    /* renamed from: a */
    public String m1244a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.f1297a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.f1297a.getString(str, str2);
        }
        return string;
    }

    /* renamed from: a */
    public Map<String, ?> m1245a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f1297a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.f1297a.getAll();
        }
        return all;
    }

    /* renamed from: a */
    public void m1246a(String str) {
        PLSharedPreferences pLSharedPreferences = this.f1297a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f1297a.remove(str);
        }
    }

    /* renamed from: b */
    public void m1247b() {
        PLSharedPreferences pLSharedPreferences = this.f1297a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f1297a.clear();
        }
    }

    /* renamed from: b */
    public void m1248b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.f1297a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f1297a.putString(str, str2);
        }
    }
}

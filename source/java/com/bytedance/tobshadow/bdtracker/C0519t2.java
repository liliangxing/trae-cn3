package com.bytedance.tobshadow.bdtracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.applog.migrate.MigrateDetectorActivity;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;

/* renamed from: com.bytedance.tobshadow.bdtracker.t2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0519t2 {

    /* renamed from: e */
    public static volatile C0519t2 f1048e;

    /* renamed from: a */
    public final PackageManager f1049a;

    /* renamed from: b */
    public final ComponentName f1050b;

    /* renamed from: c */
    public final boolean f1051c;

    /* renamed from: d */
    public final IKVStore f1052d;

    public C0519t2(Context context) {
        boolean z;
        int componentEnabledSetting;
        int i;
        Context applicationContext = context.getApplicationContext();
        IKVStore m438a = C0424f5.m438a(applicationContext, "bdtracker_dr_migrate_detector");
        this.f1052d = m438a;
        PackageManager packageManager = applicationContext.getPackageManager();
        this.f1049a = packageManager;
        ComponentName componentName = new ComponentName(context, (Class<?>) MigrateDetectorActivity.class);
        this.f1050b = componentName;
        try {
            componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            i = m438a.getInt("component_state", 0);
            LoggerImpl.global().debug(C0380a.m252a("MigrateDetector#isMigrateInternal cs=").append(m671a(componentEnabledSetting)).append(" ss=").append(m671a(i)).toString(), new Object[0]);
        } catch (Exception unused) {
        }
        if (componentEnabledSetting == 0 && i == 2) {
            z = true;
            this.f1051c = z;
            LoggerImpl.global().debug(C0380a.m252a("MigrateDetector#constructor migrate=").append(z).toString(), new Object[0]);
        }
        z = false;
        this.f1051c = z;
        LoggerImpl.global().debug(C0380a.m252a("MigrateDetector#constructor migrate=").append(z).toString(), new Object[0]);
    }

    /* renamed from: a */
    public static C0519t2 m670a(Context context) {
        if (f1048e == null) {
            synchronized (C0519t2.class) {
                if (f1048e == null) {
                    f1048e = new C0519t2(context);
                }
            }
        }
        return f1048e;
    }

    /* renamed from: a */
    public static String m671a(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "STATE_DISABLED" : "STATE_ENABLED" : "STATE_DEFAULT";
    }

    /* renamed from: a */
    public void m672a() {
        LoggerImpl.global().debug("MigrateDetector#disableComponent", new Object[0]);
        this.f1049a.setComponentEnabledSetting(this.f1050b, 2, 1);
        this.f1052d.putInt("component_state", 2);
    }
}

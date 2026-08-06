package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: NotInstalledHmsResolveMgr.java */
/* renamed from: com.huawei.hms.availableupdate.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1038b {

    /* renamed from: b */
    public static final C1038b f1104b = new C1038b();

    /* renamed from: c */
    private static final Object f1105c = new Object();

    /* renamed from: a */
    private final List<Activity> f1106a = new ArrayList(1);

    /* renamed from: a */
    public void m1033a(Activity activity) {
        synchronized (f1105c) {
            for (Activity activity2 : this.f1106a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f1106a.add(activity);
        }
    }

    /* renamed from: b */
    public void m1034b(Activity activity) {
        synchronized (f1105c) {
            this.f1106a.remove(activity);
        }
    }
}

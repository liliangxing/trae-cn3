package com.huawei.hms.availableupdate;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AppSpoofResolveMgr.java */
/* renamed from: com.huawei.hms.availableupdate.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1037a {

    /* renamed from: c */
    public static final C1037a f1100c = new C1037a();

    /* renamed from: d */
    private static final Object f1101d = new Object();

    /* renamed from: a */
    private final AtomicBoolean f1102a = new AtomicBoolean(false);

    /* renamed from: b */
    private final List<Activity> f1103b = new ArrayList(1);

    /* renamed from: a */
    public void m1030a(Activity activity) {
        synchronized (f1101d) {
            for (Activity activity2 : this.f1103b) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.f1103b.add(activity);
        }
    }

    /* renamed from: b */
    public void m1032b(Activity activity) {
        synchronized (f1101d) {
            this.f1103b.remove(activity);
        }
    }

    /* renamed from: a */
    public void m1031a(boolean z) {
        this.f1102a.set(z);
    }

    /* renamed from: a */
    public AtomicBoolean m1029a() {
        return this.f1102a;
    }
}

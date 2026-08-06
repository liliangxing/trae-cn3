package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* compiled from: UpdateAdapterMgr.java */
/* renamed from: com.huawei.hms.availableupdate.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1039c {

    /* renamed from: b */
    public static final C1039c f1107b = new C1039c();

    /* renamed from: a */
    private WeakReference<Activity> f1108a;

    /* renamed from: a */
    public void m1036a(Activity activity) {
        HMSLog.m2120i("UpdateAdapterMgr", "onActivityCreate");
        Activity m1035a = m1035a();
        if (m1035a != null) {
            m1035a.finish();
            HMSLog.m2120i("UpdateAdapterMgr", "finish old activity.");
        }
        this.f1108a = new WeakReference<>(activity);
    }

    /* renamed from: b */
    public boolean m1038b() {
        Activity m1035a = m1035a();
        if (m1035a == null) {
            return true;
        }
        if (m1035a.isTaskRoot()) {
            return false;
        }
        m1035a.finish();
        HMSLog.m2120i("UpdateAdapterMgr", " finish old activity.");
        return true;
    }

    /* renamed from: a */
    private Activity m1035a() {
        Activity activity;
        WeakReference<Activity> weakReference = this.f1108a;
        if (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    /* renamed from: b */
    public void m1037b(Activity activity) {
        HMSLog.m2120i("UpdateAdapterMgr", "onActivityDestroy");
        Activity m1035a = m1035a();
        if (activity == null || !activity.equals(m1035a)) {
            return;
        }
        HMSLog.m2120i("UpdateAdapterMgr", "reset");
        this.f1108a = null;
    }
}

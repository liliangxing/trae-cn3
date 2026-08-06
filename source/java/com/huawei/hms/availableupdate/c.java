package com.huawei.hms.availableupdate;

import android.app.Activity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

/* compiled from: UpdateAdapterMgr.java */
/* loaded from: classes6.dex */
public class c {
    public static final c b = new c();
    private WeakReference<Activity> a;

    public void a(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityCreate");
        Activity a = a();
        if (a != null) {
            a.finish();
            HMSLog.i("UpdateAdapterMgr", "finish old activity.");
        }
        this.a = new WeakReference<>(activity);
    }

    public boolean b() {
        Activity a = a();
        if (a == null) {
            return true;
        }
        if (a.isTaskRoot()) {
            return false;
        }
        a.finish();
        HMSLog.i("UpdateAdapterMgr", " finish old activity.");
        return true;
    }

    private Activity a() {
        Activity activity;
        WeakReference<Activity> weakReference = this.a;
        if (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    public void b(Activity activity) {
        HMSLog.i("UpdateAdapterMgr", "onActivityDestroy");
        Activity a = a();
        if (activity == null || !activity.equals(a)) {
            return;
        }
        HMSLog.i("UpdateAdapterMgr", "reset");
        this.a = null;
    }
}

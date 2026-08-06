package com.huawei.hms.api;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
class BindingFailedResolveMgr {
    static final BindingFailedResolveMgr b = new BindingFailedResolveMgr();
    private static final Object c = new Object();
    List<Activity> a = new ArrayList(1);

    BindingFailedResolveMgr() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity) {
        synchronized (c) {
            for (Activity activity2 : this.a) {
                if (activity2 != null && activity2 != activity && !activity2.isFinishing()) {
                    activity2.finish();
                }
            }
            this.a.add(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Activity activity) {
        synchronized (c) {
            this.a.remove(activity);
        }
    }
}

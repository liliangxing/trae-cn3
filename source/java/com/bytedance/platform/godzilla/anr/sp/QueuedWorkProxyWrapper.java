package com.bytedance.platform.godzilla.anr.sp;

import android.os.Build;

/* loaded from: classes4.dex */
public final class QueuedWorkProxyWrapper {
    private QueuedWorkProxyWrapper() {
    }

    public static void hookQueuedWork() {
        if (Build.VERSION.SDK_INT < 26) {
            QueuedWorkProxyBelowAndroid0.replaceQueueWorkPendingWorkFinishers();
        } else {
            QueuedWorkProxyAboveOrEqualsAndroid0.replacesFinishersAndsWork();
        }
    }
}

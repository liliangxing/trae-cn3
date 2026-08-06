package com.bytedance.platform.godzilla.anr.p005sp;

import android.os.Build;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
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

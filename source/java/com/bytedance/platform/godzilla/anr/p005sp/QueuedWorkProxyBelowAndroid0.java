package com.bytedance.platform.godzilla.anr.p005sp;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class QueuedWorkProxyBelowAndroid0 {
    private static final String CLASS_NAME = "android.app.QueuedWork";
    private static final String FILE_NAME_PENDING_WORK_FINISH = "sPendingWorkFinishers";
    private static final String TAG = "QueuedWkProxyBAndroid0";

    private QueuedWorkProxyBelowAndroid0() {
    }

    public static void replaceQueueWorkPendingWorkFinishers() {
        Field field;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Log.d(TAG, "start hook, time stamp = " + System.currentTimeMillis());
        try {
            field = Class.forName(CLASS_NAME).getDeclaredField(FILE_NAME_PENDING_WORK_FINISH);
            try {
                field.setAccessible(true);
                concurrentLinkedQueue = (ConcurrentLinkedQueue) field.get(null);
                if (concurrentLinkedQueue != null) {
                    try {
                        field.set(null, new ConcurrentLinkedQueueProxy(concurrentLinkedQueue));
                        Log.d(TAG, "Below android 0,replaceQueueWorkPendingWorkFinishers success.");
                    } catch (Exception e) {
                        e = e;
                        if (concurrentLinkedQueue != null && field != null) {
                            try {
                                field.set(null, concurrentLinkedQueue);
                            } catch (Exception unused) {
                            }
                        }
                        Log.e(TAG, "Below android 0,,hook sPendingWorkFinishers fail.", e);
                        Log.d(TAG, "end hook, time stamp = " + System.currentTimeMillis());
                    }
                }
            } catch (Exception e2) {
                e = e2;
                concurrentLinkedQueue = null;
            }
        } catch (Exception e3) {
            e = e3;
            field = null;
            concurrentLinkedQueue = null;
        }
        Log.d(TAG, "end hook, time stamp = " + System.currentTimeMillis());
    }
}

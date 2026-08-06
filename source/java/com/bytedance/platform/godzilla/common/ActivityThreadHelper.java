package com.bytedance.platform.godzilla.common;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.platform.godzilla.utils.MethodUtils;

/* loaded from: classes4.dex */
public final class ActivityThreadHelper {
    private static final long WAIT_TIME = 5000;
    private static Object sActivityThread;
    private static Class sClassForActivityThread;

    private ActivityThreadHelper() {
    }

    public static Object currentActivityThread() {
        if (sActivityThread == null) {
            try {
                synchronized (ActivityThreadHelper.class) {
                    if (sActivityThread == null) {
                        if (sClassForActivityThread == null) {
                            sClassForActivityThread = Class.forName("android.app.ActivityThread");
                        }
                        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);
                    }
                    if (sActivityThread == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.platform.godzilla.common.ActivityThreadHelper.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    Object unused = ActivityThreadHelper.sActivityThread = MethodUtils.invokeStaticMethod(ActivityThreadHelper.sClassForActivityThread, "currentActivityThread", new Object[0]);
                                    synchronized (obj) {
                                        obj.notify();
                                    }
                                } catch (Exception unused2) {
                                    synchronized (obj) {
                                        obj.notify();
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (sActivityThread == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sActivityThread;
    }
}

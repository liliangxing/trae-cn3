package com.bytedance.apm.profiler;

import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* loaded from: classes3.dex */
public class Profiler {
    private static final String TAG = "unwind";
    private static volatile boolean enabled;
    private static volatile boolean inited;
    private static final AtomicReference<Boolean> sIsCompatible = new AtomicReference<>(null);
    private static volatile boolean bench = false;

    private static native boolean nAttachThread(int i);

    private static native boolean nCheck();

    private static native void nClear();

    private static native boolean nDetachThread(int i);

    private static native String nDump(long j, long j2);

    private static native String nGetStack(int i);

    private static native boolean nInit();

    private static native void nSetAlog(long j);

    private static native boolean nStart(int i);

    private static native boolean nStop();

    private Profiler() {
    }

    /* loaded from: classes3.dex */
    private static class Holder {
        private static final Profiler instance = new Profiler();

        private Holder() {
        }
    }

    public static Profiler getInstance() {
        return Holder.instance;
    }

    public synchronized void init() {
        if (!inited && isCompactVersion()) {
            try {
                ShadowHook.init();
                System.loadLibrary("profiler");
                inited = nInit();
            } catch (Throwable th) {
                inited = false;
                th.printStackTrace();
            }
            Log.e(TAG, "init profiler status " + inited);
        }
    }

    private static boolean isCompactVersion() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public void setAlog(long j) {
        if (inited) {
            nSetAlog(j);
        }
    }

    boolean isCompatible() {
        boolean z;
        AtomicReference<Boolean> atomicReference = sIsCompatible;
        Boolean bool = atomicReference.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        if (isCompactVersion() && nCheck()) {
            z = true;
        } else {
            Log.e(TAG, "not compatible");
            z = false;
        }
        return UByte$$ExternalSyntheticBackport0.m((AtomicReference) atomicReference, (Object) null, (Object) Boolean.valueOf(z)) ? z : atomicReference.get().booleanValue();
    }

    public void attachThread(int i) {
        if (inited && isCompatible()) {
            nAttachThread(i);
        }
    }

    public void detachThread(int i) {
        if (inited && isCompatible()) {
            nDetachThread(i);
        }
    }

    public String dumpStack(long j, long j2) {
        return (inited && isCompatible()) ? nDump(j, j2) : "not enabled";
    }

    public synchronized void start(int i) {
        if (inited && isCompatible() && !enabled && nStart(i)) {
            enabled = true;
        }
    }

    public synchronized void stop() {
        if (inited && isCompatible() && enabled && nStop()) {
            enabled = false;
        }
    }

    public synchronized String getStackTrace(int i) {
        if (!inited || !isCompatible()) {
            return "not compact";
        }
        return nGetStack(i);
    }

    public synchronized void clear() {
        if (inited && isCompatible()) {
            nClear();
        }
    }

    public synchronized void benchMark() {
        if (!bench) {
            init();
            start(20);
            attachThread(Process.myPid());
            new Thread(new Runnable() { // from class: com.bytedance.apm.profiler.Profiler.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        Profiler.this.getStackTrace(Process.myPid());
                        try {
                            Thread.sleep(300L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "xp_get_stack").start();
            new Thread(new Runnable() { // from class: com.bytedance.apm.profiler.Profiler.2
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        Profiler.this.dumpStack(SystemClock.uptimeMillis() - 1000, SystemClock.uptimeMillis());
                        try {
                            Thread.sleep(300L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "xp_dump").start();
            new Thread(new Runnable() { // from class: com.bytedance.apm.profiler.Profiler.3
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        Arrays.toString(Looper.getMainLooper().getThread().getStackTrace());
                        try {
                            Thread.sleep(300L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "xp_fake_loop").start();
            bench = true;
        }
    }
}

package com.bytedance.vmsdk.jsbridge.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes6.dex */
public class SystemThread {
    private Thread mAndroidThread;
    private long mNativeThread;

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeRun(long j);

    private SystemThread(long j, String str, int i) {
        this.mNativeThread = j;
        createAndroidThread(str, i);
    }

    private void createAndroidThread(String str, int i) {
        Thread thread = new Thread(new Runnable() { // from class: com.bytedance.vmsdk.jsbridge.utils.SystemThread.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                SystemThread.nativeRun(SystemThread.this.mNativeThread);
                Looper.loop();
            }
        }, str);
        this.mAndroidThread = thread;
        thread.setPriority(i);
        this.mAndroidThread.start();
    }

    public static SystemThread create(long j, String str, int i) {
        return new SystemThread(j, str, i);
    }

    public static void attachMainThread(final long j) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            nativeRun(j);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.vmsdk.jsbridge.utils.SystemThread.2
                @Override // java.lang.Runnable
                public void run() {
                    SystemThread.nativeRun(j);
                }
            });
        }
    }

    public void stop() {
        Looper myLooper = Looper.myLooper();
        if (Thread.currentThread() != this.mAndroidThread || myLooper == null) {
            return;
        }
        myLooper.quit();
    }

    public void join() {
        try {
            this.mAndroidThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

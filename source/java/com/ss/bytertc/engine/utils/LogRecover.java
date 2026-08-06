package com.ss.bytertc.engine.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes7.dex */
public class LogRecover {
    private static LogRecover instance;
    private static boolean isRunning;
    private static Timer timer;

    public static native void nativeSendLogRecoverRequest();

    public static LogRecover getInstance() {
        if (instance == null) {
            synchronized (LogRecover.class) {
                if (instance == null) {
                    instance = new LogRecover();
                    try {
                        timer = new Timer();
                        isRunning = false;
                    } catch (OutOfMemoryError unused) {
                        throw new IllegalStateException("LogRecover timer create failed as out of memory");
                    }
                }
            }
        }
        return instance;
    }

    public synchronized void startTimer() {
        if (isRunning) {
            return;
        }
        timer.schedule(new TimerTask() { // from class: com.ss.bytertc.engine.utils.LogRecover.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                LogRecover.this.runOnUIThread(new Runnable() { // from class: com.ss.bytertc.engine.utils.LogRecover.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LogRecover.nativeSendLogRecoverRequest();
                    }
                });
            }
        }, 1000L, 600000L);
        isRunning = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnUIThread(Runnable r) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r.run();
        } else {
            new Handler(Looper.getMainLooper()).post(r);
        }
    }
}

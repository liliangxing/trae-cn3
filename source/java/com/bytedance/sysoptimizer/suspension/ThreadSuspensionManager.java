package com.bytedance.sysoptimizer.suspension;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes5.dex */
public class ThreadSuspensionManager {
    private static final long DEFAULT_SUSPENSION_TASK_DURATION = 180000;
    private static final int MSG_STOP_TASK = 0;
    private static final String SUSPEND_TASK_THREAD_NAME = "suspend_thread_task";
    private static final String TAG = "ThreadSuspensionManager";
    private static ThreadSuspensionHandler mHanderThread;
    private static final Handler mMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sysoptimizer.suspension.ThreadSuspensionManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                ThreadSuspensionManager.stopTask();
            }
            super.handleMessage(message);
        }
    };

    public static void start(SuspensionParam suspensionParam, ThreadSuspendedCallback threadSuspendedCallback, Runnable runnable) {
    }

    public static void stop() {
        Handler handler = mMainHandler;
        handler.removeMessages(0);
        Message obtain = Message.obtain();
        obtain.what = 0;
        handler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void stopTask() {
        ThreadSuspensionHandler threadSuspensionHandler = mHanderThread;
        if (threadSuspensionHandler != null) {
            threadSuspensionHandler.stopTask();
            mHanderThread = null;
        }
    }
}

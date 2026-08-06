package com.bytedance.push.monitor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes4.dex */
final class TimeOutScheduler implements Handler.Callback {
    private static final int MSG_TIMEOUT_SCHEDULER = 10101;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), this);

    public void runWhenTimeout(long j, Runnable runnable) {
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(10101, runnable), j);
    }

    public void cancelTimeout() {
        this.mHandler.removeMessages(10101);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message == null || message.what != 10101 || !(message.obj instanceof Runnable)) {
            return false;
        }
        ((Runnable) message.obj).run();
        return false;
    }
}

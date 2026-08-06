package com.bytedance.bdturing.senseless;

import com.bytedance.bdturing.VerifyTaskHandler;

/* loaded from: classes3.dex */
public class TimeOutWatchDog implements Runnable {
    private boolean isRunning = false;
    private final Listener mListener;

    /* loaded from: classes3.dex */
    public interface Listener {
        void onTimeOut();
    }

    public TimeOutWatchDog(Listener listener) {
        this.mListener = listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        Listener listener;
        if (this.isRunning && (listener = this.mListener) != null) {
            listener.onTimeOut();
        }
        this.isRunning = false;
    }

    public void start(long j) {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        VerifyTaskHandler.getInstance().postRunnableDelay(this, j);
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void cancel() {
        this.isRunning = false;
        VerifyTaskHandler.getInstance().removeRunnable(this);
    }
}

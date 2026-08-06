package com.bytedance.webx.seclink.setting;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes6.dex */
public class SettingUpdateHandler {
    private Handler mHandler;
    private HandlerThread mHandlerThread;

    /* loaded from: classes6.dex */
    private static class InstanceHolder {
        private static SettingUpdateHandler mInstance = new SettingUpdateHandler();

        private InstanceHolder() {
        }
    }

    private SettingUpdateHandler() {
        init();
    }

    public static SettingUpdateHandler getInstance() {
        return InstanceHolder.mInstance;
    }

    private void init() {
        if (this.mHandlerThread == null) {
            synchronized (SettingUpdateHandler.class) {
                if (this.mHandlerThread == null) {
                    HandlerThread handlerThread = new HandlerThread("sec_link_setting_thread");
                    this.mHandlerThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new Handler(this.mHandlerThread.getLooper());
                }
            }
        }
    }

    public Looper getLooper() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            return handlerThread.getLooper();
        }
        return null;
    }

    public void sendMessage(int i, Object obj) {
        Handler handler = this.mHandler;
        if (handler != null) {
            this.mHandler.sendMessage(handler.obtainMessage(i, obj));
        }
    }

    public void sendMessage(int i, int i2, int i3, Object obj) {
        Handler handler = this.mHandler;
        if (handler != null) {
            this.mHandler.sendMessage(handler.obtainMessage(i, i2, i3, obj));
        }
    }

    public void sendMessageDelay(int i, Object obj, long j) {
        Handler handler = this.mHandler;
        if (handler != null) {
            this.mHandler.sendMessageDelayed(handler.obtainMessage(i, obj), j);
        }
    }

    public void postRunnable(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void postRunnableDelay(Runnable runnable, long j) {
        Handler handler = this.mHandler;
        if (handler == null || runnable == null) {
            return;
        }
        handler.postDelayed(runnable, j);
    }

    public void removeRunnable(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler == null || runnable == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public void removeMessage(int i) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(i);
        }
    }
}

package com.bytedance.bdturing;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.bdturing.methods.JsCallParser;

/* loaded from: classes3.dex */
public class VerifyTaskHandler {
    public static final int CLEAR_MOTION_LIST = 3;
    public static final int DIALOG_CLEAR_RESOURCE = 1;
    public static final int JS_CALL_GET_TOUCH = 2;
    private MessageHandler mHandler;
    private HandlerThread mHandlerThread;

    /* loaded from: classes3.dex */
    private static class InstanceHolder {
        private static VerifyTaskHandler mInstance = new VerifyTaskHandler();

        private InstanceHolder() {
        }
    }

    private VerifyTaskHandler() {
    }

    public static VerifyTaskHandler getInstance() {
        return InstanceHolder.mInstance;
    }

    public void startHandleMessage() {
        if (this.mHandlerThread == null) {
            synchronized (VerifyTaskHandler.class) {
                if (this.mHandlerThread == null) {
                    HandlerThread handlerThread = new HandlerThread("TuringVerifyThread");
                    this.mHandlerThread = handlerThread;
                    handlerThread.start();
                    this.mHandler = new MessageHandler(this.mHandlerThread.getLooper());
                }
            }
        }
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }

    public void sendMessage(int i, Object obj) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler != null) {
            this.mHandler.sendMessage(messageHandler.obtainMessage(i, obj));
        }
    }

    public void sendMessage(int i, int i2, int i3, Object obj) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler != null) {
            this.mHandler.sendMessage(messageHandler.obtainMessage(i, i2, i3, obj));
        }
    }

    public void sendMessageDelay(int i, Object obj, long j) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler != null) {
            this.mHandler.sendMessageDelayed(messageHandler.obtainMessage(i, obj), j);
        }
    }

    public void postRunnable(Runnable runnable) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler != null) {
            messageHandler.post(runnable);
        }
    }

    public boolean postRunnableDelay(Runnable runnable, long j) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler == null || runnable == null) {
            return false;
        }
        return messageHandler.postDelayed(runnable, j);
    }

    public void removeRunnable(Runnable runnable) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler == null || runnable == null) {
            return;
        }
        messageHandler.removeCallbacks(runnable);
    }

    public void removeMessage(int i) {
        MessageHandler messageHandler = this.mHandler;
        if (messageHandler != null) {
            messageHandler.removeMessages(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dialogClearResource(Message message) {
        if (message.obj != null) {
            ((TuringVerifyInterface) message.obj).clearResource();
        }
    }

    /* loaded from: classes3.dex */
    private class MessageHandler extends Handler {
        private MessageHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                VerifyTaskHandler.this.dialogClearResource(message);
            } else if (i == 2) {
                UserMotionManager.responseGetTouchToJs((JsCallParser) message.obj);
            } else {
                if (i != 3) {
                    return;
                }
                UserMotionManager.clearMotionList();
            }
        }
    }
}

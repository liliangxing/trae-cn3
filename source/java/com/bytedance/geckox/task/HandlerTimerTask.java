package com.bytedance.geckox.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes3.dex */
public class HandlerTimerTask {
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private final String name;
    private final int priority;

    public HandlerTimerTask(String str, int i) {
        this.name = str;
        this.priority = i;
        initHandler();
    }

    public void schedule(HandlerTask handlerTask, long j) {
        if (j < 0) {
            return;
        }
        sched(handlerTask, j, 0L);
    }

    public void schedule(HandlerTask handlerTask, long j, long j2) {
        sched(handlerTask, j, j2);
    }

    public void cancel(int i) {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.removeMessages(i);
    }

    public void quit() {
        this.mHandlerThread.quitSafely();
        this.mHandler = null;
    }

    private void sched(HandlerTask handlerTask, long j, long j2) {
        initHandler();
        int taskType = handlerTask.taskType();
        handlerTask.period = j2;
        Message obtainMessage = this.mHandler.obtainMessage(taskType);
        obtainMessage.obj = handlerTask;
        obtainMessage.what = taskType;
        this.mHandler.sendMessageDelayed(obtainMessage, j);
    }

    private void initHandler() {
        if (this.mHandler == null || this.mHandlerThread.getLooper() == null) {
            HandlerThread handlerThread = new HandlerThread(this.name, this.priority);
            this.mHandlerThread = handlerThread;
            handlerThread.start();
            this.mHandler = new TimeHandler(this.mHandlerThread.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class TimeHandler extends Handler {
        public TimeHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HandlerTask handlerTask = (HandlerTask) message.obj;
            handlerTask.execute();
            if (handlerTask.period > 0) {
                Message obtainMessage = HandlerTimerTask.this.mHandler.obtainMessage(message.what);
                obtainMessage.obj = handlerTask;
                HandlerTimerTask.this.mHandler.sendMessageDelayed(obtainMessage, handlerTask.period);
            }
        }
    }
}

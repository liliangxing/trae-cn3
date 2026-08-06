package com.bytedance.framwork.core.sdklib.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class ThreadWithHandler {
    static final ListUtils.ComparableDiffType<MessageEntity, Runnable> compareEntityRunnable = new ListUtils.ComparableDiffType<MessageEntity, Runnable>() { // from class: com.bytedance.framwork.core.sdklib.thread.ThreadWithHandler.1
        @Override // com.bytedance.framwork.core.sdklib.util.ListUtils.ComparableDiffType
        public boolean equals(MessageEntity messageEntity, Runnable runnable) {
            return runnable == null ? messageEntity == null || messageEntity.msg == null || messageEntity.msg.getCallback() == null : (messageEntity == null || messageEntity.msg == null || !runnable.equals(messageEntity.msg.getCallback())) ? false : true;
        }
    };
    static final ListUtils.ComparableDiffType<Message, Runnable> compareMessageRunnable = new ListUtils.ComparableDiffType<Message, Runnable>() { // from class: com.bytedance.framwork.core.sdklib.thread.ThreadWithHandler.2
        @Override // com.bytedance.framwork.core.sdklib.util.ListUtils.ComparableDiffType
        public boolean equals(Message message, Runnable runnable) {
            return runnable == null ? message == null || message.getCallback() == null : message != null && runnable.equals(message.getCallback());
        }
    };
    private volatile Handler mRealHandler;
    private final HandlerThread mThread;
    private final Queue<MessageEntity> mCacheQueue = new ConcurrentLinkedQueue();
    private final Queue<Message> mFrontCacheQueue = new ConcurrentLinkedQueue();
    private final Object lock = new Object();

    public ThreadWithHandler(String str, int i) {
        this.mThread = new InnerThread(str, i);
    }

    public ThreadWithHandler(String str) {
        this.mThread = new InnerThread(str);
    }

    public void start() {
        this.mThread.start();
    }

    private Message getPostMessage(Runnable runnable) {
        return Message.obtain(this.mRealHandler, runnable);
    }

    private Message getPostMessage(Runnable runnable, Object obj) {
        Message obtain = Message.obtain(this.mRealHandler, runnable);
        obtain.obj = obj;
        return obtain;
    }

    public final boolean post(Runnable runnable) {
        return sendMessageDelayed(getPostMessage(runnable), 0L);
    }

    public final boolean postAtTime(Runnable runnable, long j) {
        return sendMessageAtTime(getPostMessage(runnable), j);
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j) {
        return sendMessageAtTime(getPostMessage(runnable, obj), j);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return sendMessageDelayed(getPostMessage(runnable), j);
    }

    public final boolean postDelayed(Runnable runnable, Object obj, long j) {
        return sendMessageDelayed(getPostMessage(runnable, obj), j);
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return sendMessageAtFrontOfQueue(getPostMessage(runnable));
    }

    public final void removeCallbacks(Runnable runnable) {
        if (!this.mCacheQueue.isEmpty() || !this.mFrontCacheQueue.isEmpty()) {
            ListUtils.removeAll(this.mCacheQueue, runnable, compareEntityRunnable);
            ListUtils.removeAll(this.mFrontCacheQueue, runnable, compareMessageRunnable);
        }
        if (this.mRealHandler != null) {
            this.mRealHandler.removeCallbacks(runnable);
        }
    }

    public final boolean sendMessage(Message message) {
        return sendMessageDelayed(message, 0L);
    }

    public final boolean sendEmptyMessage(int i) {
        return sendEmptyMessageDelayed(i, 0L);
    }

    public final boolean sendEmptyMessageDelayed(int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = i;
        return sendMessageDelayed(obtain, j);
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = i;
        return sendMessageAtTime(obtain, j);
    }

    public final boolean sendMessageDelayed(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return sendMessageAtTime(message, SystemClock.uptimeMillis() + j);
    }

    public final boolean sendMessageAtTime(Message message, long j) {
        if (this.mRealHandler == null) {
            synchronized (this.lock) {
                if (this.mRealHandler == null) {
                    this.mCacheQueue.add(new MessageEntity(message, j));
                    return true;
                }
            }
        }
        return this.mRealHandler.sendMessageAtTime(message, j);
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        if (this.mRealHandler == null) {
            synchronized (this.lock) {
                if (this.mRealHandler == null) {
                    this.mFrontCacheQueue.add(message);
                    return true;
                }
            }
        }
        return this.mRealHandler.sendMessageAtFrontOfQueue(message);
    }

    /* loaded from: classes2.dex */
    class InnerThread extends HandlerThread {
        InnerThread(String str) {
            super(str);
        }

        InnerThread(String str, int i) {
            super(str, i);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (ThreadWithHandler.this.lock) {
                ThreadWithHandler.this.mRealHandler = new Handler();
            }
            ThreadWithHandler.this.mRealHandler.post(new CheckCacheRunnable());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class CheckCacheRunnable implements Runnable {
        CheckCacheRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            solveFrontCacheQueue();
            solveNormalCacheQueue();
        }

        void solveNormalCacheQueue() {
            while (!ThreadWithHandler.this.mCacheQueue.isEmpty()) {
                MessageEntity messageEntity = (MessageEntity) ThreadWithHandler.this.mCacheQueue.poll();
                if (ThreadWithHandler.this.mRealHandler != null) {
                    ThreadWithHandler.this.mRealHandler.sendMessageAtTime(messageEntity.msg, messageEntity.time);
                }
            }
        }

        void solveFrontCacheQueue() {
            while (!ThreadWithHandler.this.mFrontCacheQueue.isEmpty()) {
                if (ThreadWithHandler.this.mRealHandler != null) {
                    ThreadWithHandler.this.mRealHandler.sendMessageAtFrontOfQueue((Message) ThreadWithHandler.this.mFrontCacheQueue.poll());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class MessageEntity {
        Message msg;
        long time;

        MessageEntity(Message message, long j) {
            this.msg = message;
            this.time = j;
        }
    }
}

package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.crash.diagnose.NpthMonitor;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Deprecated
/* loaded from: classes3.dex */
public class ThreadWithHandler {
    private static final ComparableDiffType<MessageEntity, Runnable> compareEntityRunnable = new ComparableDiffType<MessageEntity, Runnable>() { // from class: com.bytedance.crash.runtime.ThreadWithHandler.1
        @Override // com.bytedance.crash.runtime.ThreadWithHandler.ComparableDiffType
        public boolean equals(MessageEntity messageEntity, Runnable runnable) {
            return runnable == null ? messageEntity == null || messageEntity.msg == null || messageEntity.msg.getCallback() == null : (messageEntity == null || messageEntity.msg == null || !runnable.equals(messageEntity.msg.getCallback())) ? false : true;
        }
    };
    private static final ComparableDiffType<Message, Runnable> compareMessageRunnable = new ComparableDiffType<Message, Runnable>() { // from class: com.bytedance.crash.runtime.ThreadWithHandler.2
        @Override // com.bytedance.crash.runtime.ThreadWithHandler.ComparableDiffType
        public boolean equals(Message message, Runnable runnable) {
            return runnable == null ? message == null || message.getCallback() == null : message != null && runnable.equals(message.getCallback());
        }
    };
    private final Queue<MessageEntity> mCacheQueue = new ConcurrentLinkedQueue();
    private final Queue<Message> mFrontCacheQueue = new ConcurrentLinkedQueue();
    private final Object mLock = new Object();
    private volatile Handler mRealHandler;
    private final HandlerThread mThread;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface ComparableDiffType<A, B> {
        boolean equals(A a, B b);
    }

    public ThreadWithHandler(String str, int i) {
        this.mThread = new InnerThread(str, i);
    }

    public ThreadWithHandler(String str) {
        this.mThread = new InnerThread(str);
    }

    public Handler getHandler() {
        return this.mRealHandler;
    }

    public void start() {
        this.mThread.start();
    }

    public HandlerThread getThread() {
        return this.mThread;
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
            removeAll(this.mCacheQueue, runnable, compareEntityRunnable);
            removeAll(this.mFrontCacheQueue, runnable, compareMessageRunnable);
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

    private boolean sendEmptyMessageDelayed(int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = i;
        return sendMessageDelayed(obtain, j);
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = i;
        return sendMessageAtTime(obtain, j);
    }

    private boolean sendMessageDelayed(Message message, long j) {
        if (j < 0) {
            j = 0;
        }
        return sendMessageAtTime(message, SystemClock.uptimeMillis() + j);
    }

    private boolean sendMessageAtTime(Message message, long j) {
        if (this.mRealHandler == null) {
            synchronized (this.mLock) {
                if (this.mRealHandler == null) {
                    this.mCacheQueue.add(new MessageEntity(message, j));
                    return true;
                }
            }
        }
        try {
            return this.mRealHandler.sendMessageAtTime(message, j);
        } catch (Throwable unused) {
            return true;
        }
    }

    private boolean sendMessageAtFrontOfQueue(Message message) {
        if (this.mRealHandler == null) {
            synchronized (this.mLock) {
                if (this.mRealHandler == null) {
                    this.mFrontCacheQueue.add(message);
                    return true;
                }
            }
        }
        try {
            return this.mRealHandler.sendMessageAtFrontOfQueue(message);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    class InnerThread extends HandlerThread {
        static final int MAX_CRASH_TIME = 5;
        volatile int mCrashTimes;
        volatile boolean mUploadTimes;

        InnerThread(String str) {
            super(str);
        }

        InnerThread(String str, int i) {
            super(str, i);
        }

        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            synchronized (ThreadWithHandler.this.mLock) {
                ThreadWithHandler.this.mRealHandler = new Handler();
            }
            ThreadWithHandler.this.mRealHandler.post(new CheckCacheRunnable());
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    try {
                        if (this.mCrashTimes < 5) {
                            NpthMonitor.reportInnerException(th);
                        } else if (!this.mUploadTimes) {
                            this.mUploadTimes = true;
                            NpthMonitor.reportInnerException("NPTH_ERR_MAX", new RuntimeException());
                        }
                        this.mCrashTimes++;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    try {
                        ThreadWithHandler.this.mRealHandler.sendMessageAtTime(messageEntity.msg, messageEntity.time);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        void solveFrontCacheQueue() {
            while (!ThreadWithHandler.this.mFrontCacheQueue.isEmpty()) {
                if (ThreadWithHandler.this.mRealHandler != null) {
                    try {
                        ThreadWithHandler.this.mRealHandler.sendMessageAtFrontOfQueue((Message) ThreadWithHandler.this.mFrontCacheQueue.poll());
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class MessageEntity {
        Message msg;
        long time;

        MessageEntity(Message message, long j) {
            this.msg = message;
            this.time = j;
        }
    }

    private static <L, O> boolean removeAll(Collection<L> collection, O o, ComparableDiffType<? super L, O> comparableDiffType) {
        boolean z = false;
        if (collection != null && !collection.isEmpty() && comparableDiffType != null) {
            try {
                Iterator<L> it = collection.iterator();
                while (it.hasNext()) {
                    if (comparableDiffType.equals(it.next(), o)) {
                        it.remove();
                        z = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z;
    }
}

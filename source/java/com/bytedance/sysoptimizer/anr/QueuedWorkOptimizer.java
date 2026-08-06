package com.bytedance.sysoptimizer.anr;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.sysoptimizer.java.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes5.dex */
public class QueuedWorkOptimizer {
    private static final String TAG = "QueuedWorkOptimizer";
    private static IAsyncWorker sAsyncWorker;
    private static IErrorListener sErrorListener;

    /* loaded from: classes5.dex */
    public interface IAsyncWorker {
        void run(Runnable runnable);
    }

    /* loaded from: classes5.dex */
    public interface IErrorListener {
        void onError(Throwable th);
    }

    /* loaded from: classes5.dex */
    private interface IQueuedWorkOptimizerHandler {
        void optimize();
    }

    /* loaded from: classes5.dex */
    public static class ProxyConcurrentLinkedQueue<T> extends ConcurrentLinkedQueue<T> {
        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
        public boolean add(T t) {
            return true;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return true;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return true;
        }
    }

    private static IQueuedWorkOptimizerHandler getOptimizer() {
        if (Build.VERSION.SDK_INT < 26) {
            return new QueuedWorkOptimizerBelowO();
        }
        return new QueuedWorkOptimizerAboveO();
    }

    public static void injectAsyncWorker(IAsyncWorker iAsyncWorker) {
        sAsyncWorker = iAsyncWorker;
    }

    public static void setErrorListener(IErrorListener iErrorListener) {
        sErrorListener = iErrorListener;
    }

    public static void optimize() {
        if (Build.VERSION.SDK_INT < 26) {
            IQueuedWorkOptimizerHandler optimizer = getOptimizer();
            if (optimizer != null) {
                optimizer.optimize();
                return;
            }
            return;
        }
        takeOverQueuedWorkHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class QueuedWorkOptimizerBelowO implements IQueuedWorkOptimizerHandler {
        private QueuedWorkOptimizerBelowO() {
        }

        @Override // com.bytedance.sysoptimizer.anr.QueuedWorkOptimizer.IQueuedWorkOptimizerHandler
        public void optimize() {
            try {
                Field declaredField = Class.forName("android.app.QueuedWork").getDeclaredField("sPendingWorkFinishers");
                declaredField.setAccessible(true);
                ReflectionUtils.removeFinal(declaredField);
                declaredField.set(null, new ProxyConcurrentLinkedQueue());
            } catch (Throwable th) {
                if (QueuedWorkOptimizer.sErrorListener != null) {
                    QueuedWorkOptimizer.sErrorListener.onError(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class QueuedWorkOptimizerAboveO implements IQueuedWorkOptimizerHandler {
        private QueuedWorkOptimizerAboveO() {
        }

        @Override // com.bytedance.sysoptimizer.anr.QueuedWorkOptimizer.IQueuedWorkOptimizerHandler
        public void optimize() {
            try {
                Class<?> cls = Class.forName("android.app.QueuedWork");
                Field declaredField = cls.getDeclaredField("sFinishers");
                ReflectionUtils.removeFinal(declaredField);
                declaredField.setAccessible(true);
                declaredField.set(null, new EmptyLinkedList());
                if (QueuedWorkOptimizer.sAsyncWorker != null) {
                    Field declaredField2 = cls.getDeclaredField("sWork");
                    ReflectionUtils.removeFinal(declaredField2);
                    declaredField2.setAccessible(true);
                    declaredField2.set(null, new MyLinkedList());
                }
            } catch (Throwable th) {
                if (QueuedWorkOptimizer.sErrorListener != null) {
                    QueuedWorkOptimizer.sErrorListener.onError(th);
                }
            }
        }

        /* loaded from: classes5.dex */
        private static class MyLinkedList extends LinkedList<Runnable> {
            private MyLinkedList() {
            }

            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
            public boolean add(Runnable runnable) {
                return super.add((MyLinkedList) new MyRunnable(runnable));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes5.dex */
        public static class MyRunnable implements Runnable {
            private final Runnable run;

            public MyRunnable(Runnable runnable) {
                this.run = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (QueuedWorkOptimizer.sAsyncWorker != null) {
                    QueuedWorkOptimizer.sAsyncWorker.run(this.run);
                }
            }
        }

        /* loaded from: classes5.dex */
        private static class EmptyLinkedList<T> extends LinkedList<T> {
            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
            public boolean add(T t) {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean isEmpty() {
                return true;
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public boolean remove(Object obj) {
                return true;
            }

            @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
            public int size() {
                return 0;
            }

            private EmptyLinkedList() {
            }

            @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public void clear() {
                super.clear();
            }
        }
    }

    private static void takeOverQueuedWorkHandler() {
        try {
            Class<?> cls = Class.forName("android.app.QueuedWork");
            Handler handler = (Handler) ReflectionUtils.invokeStaticMethod(cls, "getHandler");
            LinkedList linkedList = (LinkedList) ReflectionUtils.getStaticFieldObject("sWork", cls);
            if (handler != null && linkedList != null) {
                ReflectionUtils.setFieldObject(handler, "mCallback", new QueuedWorkCallback(handler, (Handler.Callback) ReflectionUtils.getFieldObject("android.os.Handler", "mCallback", handler), linkedList));
                return;
            }
            Log.e(TAG, "sHandler or sWork is null");
        } catch (Throwable th) {
            IErrorListener iErrorListener = sErrorListener;
            if (iErrorListener != null) {
                iErrorListener.onError(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class QueuedWorkCallback implements Handler.Callback {
        private static final int MSG_RUN = 1;
        private static LinkedList<Runnable> sWork;
        private Handler.Callback originCallBack;
        private Handler queuedWorkHandler;

        public QueuedWorkCallback(Handler handler, Handler.Callback callback, LinkedList<Runnable> linkedList) {
            this.queuedWorkHandler = handler;
            this.originCallBack = callback;
            sWork = linkedList;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                processPendingWork();
            }
            Handler.Callback callback = this.originCallBack;
            if (callback != null) {
                callback.handleMessage(message);
            }
            return true;
        }

        private void processPendingWork() {
            LinkedList<Runnable> linkedList;
            if (this.queuedWorkHandler == null || (linkedList = sWork) == null) {
                return;
            }
            LinkedList linkedList2 = (LinkedList) linkedList.clone();
            sWork.clear();
            this.queuedWorkHandler.removeMessages(1);
            if (linkedList2.size() > 0) {
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
        }
    }
}

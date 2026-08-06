package com.bytedance.frameworks.baselib.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class NetThreadPoolManager implements WeakHandler.IHandler {
    private static final int MSG_API_DELAY = 0;
    private static final int MSG_DOWNLOAD_DELAY = 1;
    private ThreadPoolExecutor mExecutorDownload;
    private ThreadPoolExecutor mExecutorImmediate;
    private ThreadPoolExecutor mExecutorLocal;
    private ThreadPoolExecutor mExecutorLowest;
    private ThreadPoolExecutor mExecutorNormal;
    private WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    private static AtomicInteger mSequenceGenerator = new AtomicInteger();
    static NetThreadPoolManager INSTANCE = new NetThreadPoolManager();

    private static int getSequenceNumber() {
        return mSequenceGenerator.incrementAndGet();
    }

    private NetThreadPoolManager() {
    }

    private ThreadPoolConfig getThreadPoolConfig() {
        return RequestQueue.getThreadPoolConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ExecutorService executorImmediateService() {
        if (this.mExecutorImmediate == null) {
            ThreadPoolExecutor immediateThreadPool = getThreadPoolConfig().getImmediateThreadPool();
            this.mExecutorImmediate = immediateThreadPool;
            if (immediateThreadPool == null) {
                this.mExecutorImmediate = new ThreadPoolExecutor(getThreadPoolConfig().getCoreImmediateThreadSize(), Integer.MAX_VALUE, getThreadPoolConfig().getImmediateAliveTime(), TimeUnit.SECONDS, new SynchronousQueue(), new ApiThreadFactory("NetImmediate"));
            }
        }
        return this.mExecutorImmediate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ExecutorService executorApiService() {
        if (this.mExecutorNormal == null) {
            ThreadPoolExecutor normalThreadPool = getThreadPoolConfig().getNormalThreadPool();
            this.mExecutorNormal = normalThreadPool;
            if (normalThreadPool == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(getThreadPoolConfig().getCoreApiThreadSize(), getThreadPoolConfig().getMaxApiThreadSize(), getThreadPoolConfig().getApiAliveTime(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ApiThreadFactory("NetNormal"));
                this.mExecutorNormal = threadPoolExecutor;
                threadPoolExecutor.allowCoreThreadTimeOut(RequestQueue.getThreadPoolConfig().isDynamicAdjust());
            }
        }
        return this.mExecutorNormal;
    }

    private synchronized ExecutorService executorDownloadService() {
        if (this.mExecutorDownload == null) {
            ThreadPoolExecutor downloadThreadPool = getThreadPoolConfig().getDownloadThreadPool();
            this.mExecutorDownload = downloadThreadPool;
            if (downloadThreadPool == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(getThreadPoolConfig().getCoreDownloadThreadSize(), getThreadPoolConfig().getMaxDownloadThreadSize(), getThreadPoolConfig().getDownloadAliveTime(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ApiThreadFactory("NetDownload"));
                this.mExecutorDownload = threadPoolExecutor;
                threadPoolExecutor.allowCoreThreadTimeOut(RequestQueue.getThreadPoolConfig().isDynamicAdjust());
            }
        }
        return this.mExecutorDownload;
    }

    private synchronized ExecutorService executorLowestService() {
        if (this.mExecutorLowest == null) {
            ThreadPoolExecutor lowestThreadPool = getThreadPoolConfig().getLowestThreadPool();
            this.mExecutorLowest = lowestThreadPool;
            if (lowestThreadPool == null) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(getThreadPoolConfig().getCoreLowestThreadSize(), getThreadPoolConfig().getCoreLowestThreadSize(), getThreadPoolConfig().getLowestAliveTime(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ApiThreadFactory("NetLowest"));
                this.mExecutorLowest = threadPoolExecutor;
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
        }
        return this.mExecutorLowest;
    }

    private synchronized ExecutorService executorLocalService() {
        if (this.mExecutorLocal == null) {
            ThreadPoolExecutor localThreadPool = getThreadPoolConfig().getLocalThreadPool();
            this.mExecutorLocal = localThreadPool;
            if (localThreadPool == null) {
                this.mExecutorLocal = new ThreadPoolExecutor(1, 1, getThreadPoolConfig().getImmediateAliveTime(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new ApiThreadFactory("NetLocal"));
            }
        }
        return this.mExecutorLocal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void executeDownload(IApiTask iApiTask) {
        if (iApiTask == null || iApiTask.isCanceled()) {
            return;
        }
        iApiTask.setSequence(getSequenceNumber());
        if (iApiTask.getPriority() == IRequest.Priority.IMMEDIATE) {
            executorImmediateService().execute(iApiTask);
            return;
        }
        if (iApiTask.getPriority() == IRequest.Priority.LOWEST) {
            executorLowestService().execute(iApiTask);
            return;
        }
        long delayTime = iApiTask.getDelayTime();
        if (delayTime > 0) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = iApiTask;
            this.mHandler.sendMessageDelayed(obtain, delayTime);
            return;
        }
        setBlockingQueueSize(this.mExecutorDownload, iApiTask);
        executorDownloadService().execute(iApiTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void executeApi(IApiTask iApiTask) {
        if (iApiTask == null || iApiTask.isCanceled()) {
            return;
        }
        iApiTask.setSequence(getSequenceNumber());
        if (iApiTask.needTryLocal()) {
            executorLocalService().execute(getLocalRunnable(iApiTask));
            return;
        }
        if (iApiTask.getPriority() == IRequest.Priority.IMMEDIATE) {
            executorImmediateService().execute(iApiTask);
            return;
        }
        if (iApiTask.getPriority() == IRequest.Priority.LOWEST) {
            executorLowestService().execute(iApiTask);
            return;
        }
        long delayTime = iApiTask.getDelayTime();
        if (delayTime > 0) {
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = iApiTask;
            this.mHandler.sendMessageDelayed(obtain, delayTime);
            return;
        }
        setBlockingQueueSize(this.mExecutorNormal, iApiTask);
        executorApiService().execute(iApiTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public abstract class AbstractLocalRunnable implements Runnable, Comparable<AbstractLocalRunnable> {
        private IApiTask apiTask;

        public AbstractLocalRunnable(IApiTask iApiTask) {
            this.apiTask = iApiTask;
        }
    }

    private AbstractLocalRunnable getLocalRunnable(final IApiTask iApiTask) {
        return new AbstractLocalRunnable(iApiTask) { // from class: com.bytedance.frameworks.baselib.network.dispatcher.NetThreadPoolManager.1
            @Override // java.lang.Comparable
            public int compareTo(AbstractLocalRunnable abstractLocalRunnable) {
                IApiTask iApiTask2 = iApiTask;
                if (iApiTask2 != null) {
                    return iApiTask2.compareTo(abstractLocalRunnable.apiTask);
                }
                return 0;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (iApiTask.run4Local()) {
                    return;
                }
                if (iApiTask.getPriority() == IRequest.Priority.IMMEDIATE) {
                    NetThreadPoolManager.this.executorImmediateService().execute(iApiTask);
                } else {
                    NetThreadPoolManager.this.executorApiService().execute(iApiTask);
                }
            }
        };
    }

    public void handleMsg(Message message) {
        if (message == null || !(message.obj instanceof Runnable)) {
            return;
        }
        try {
            int i = message.what;
            if (i == 0) {
                setBlockingQueueSize(this.mExecutorNormal, (IApiTask) message.obj);
                executorApiService().execute((Runnable) message.obj);
            } else if (i == 1) {
                setBlockingQueueSize(this.mExecutorDownload, (IApiTask) message.obj);
                executorImmediateService().execute((Runnable) message.obj);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class ApiThreadFactory implements ThreadFactory {
        private final AtomicInteger mCount = new AtomicInteger(1);
        private String mThreadName;

        ApiThreadFactory(String str) {
            this.mThreadName = "ApiExecutor";
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mThreadName = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.mThreadName + "#" + this.mCount.getAndIncrement()) { // from class: com.bytedance.frameworks.baselib.network.dispatcher.NetThreadPoolManager.ApiThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            thread.setDaemon(false);
            return thread;
        }
    }

    private static void setBlockingQueueSize(ThreadPoolExecutor threadPoolExecutor, IApiTask iApiTask) {
        if (threadPoolExecutor == null || !(iApiTask instanceof ApiTask)) {
            return;
        }
        ((ApiTask) iApiTask).setBlockingQueueSize(threadPoolExecutor.getQueue().size());
    }
}

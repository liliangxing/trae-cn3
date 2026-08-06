package com.bytedance.sdk.account.network.dispatcher;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.sdk.account.network.dispatcher.IRequest;
import com.ss.android.LogHelper;
import java.lang.Thread;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RequestQueue {
    private static final int DEFAULT_DOWNLOAD_THREAD_POOL_SIZE = 4;
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 4;
    private static volatile RequestQueue sRequestQueue;
    private ApiDispatcher[] mDispatchers;
    private DownloadDispatcher[] mDownloadDispatchers;
    private final PriorityBlockingQueue<IRequest> mDownloadQueue;
    private int mInitDownloadThreadPoolSize;
    private int mInitThreadPoolSize;
    private volatile long mLastExpandDownloadRequestQueueTime;
    private volatile long mLastExpandRequestQueueTime;
    private volatile long mLastShrinkDownloadRequestQueueTime;
    private volatile long mLastShrinkRequestQueueTime;
    private ApiLocalDispatcher mLocalDispatcher;
    private final PriorityBlockingQueue<IRequest> mLocalQueue;
    private final PriorityBlockingQueue<IRequest> mQueue;
    private volatile boolean mStarted;
    private static AtomicInteger sSequenceGenerator = new AtomicInteger();
    private static volatile boolean sDynamicAdjustThreadPoolSizeOpen = true;

    public static void setDynamicAdjustThreadPoolSizeOpen(boolean z) {
        sDynamicAdjustThreadPoolSizeOpen = z;
    }

    public static RequestQueue getDefaultRequestQueue() {
        if (sRequestQueue == null) {
            synchronized (RequestQueue.class) {
                if (sRequestQueue == null) {
                    sRequestQueue = new RequestQueue(false);
                }
            }
        }
        return sRequestQueue;
    }

    public static int getSequenceNumber() {
        return sSequenceGenerator.incrementAndGet();
    }

    public RequestQueue() {
        this(4, 4, true);
    }

    public RequestQueue(boolean z) {
        this(4, 0, z);
    }

    public RequestQueue(int i, int i2, boolean z) {
        this.mStarted = false;
        this.mLocalQueue = new PriorityBlockingQueue<>();
        this.mQueue = new PriorityBlockingQueue<>();
        this.mDownloadQueue = new PriorityBlockingQueue<>();
        this.mLastExpandRequestQueueTime = 0L;
        this.mLastExpandDownloadRequestQueueTime = 0L;
        this.mLastShrinkRequestQueueTime = 0L;
        this.mLastShrinkDownloadRequestQueueTime = 0L;
        this.mInitThreadPoolSize = i;
        this.mDispatchers = new ApiDispatcher[i * 4];
        if (z) {
            this.mInitDownloadThreadPoolSize = i2;
            this.mDownloadDispatchers = new DownloadDispatcher[i2 * 4];
        }
    }

    public synchronized void addDownload(ApiThread apiThread) {
        if (apiThread == null) {
            return;
        }
        apiThread.setSequence(getSequenceNumber());
        if (!this.mStarted) {
            start();
        }
        if (apiThread.getPriority() == IRequest.Priority.IMMEDIATE) {
            ThreadPlus.submitRunnable(apiThread);
        } else {
            apiThread.sendEnDownloadQueueExpireMsg();
            this.mDownloadQueue.add(apiThread);
        }
    }

    public synchronized void add(ApiThread apiThread) {
        if (apiThread == null) {
            return;
        }
        apiThread.setSequence(getSequenceNumber());
        if (!this.mStarted) {
            start();
        }
        if (apiThread.needTryLocal()) {
            this.mLocalQueue.add(apiThread);
        } else if (apiThread.getPriority() == IRequest.Priority.IMMEDIATE) {
            ThreadPlus.submitRunnable(apiThread);
        } else {
            apiThread.sendEnQueueExpireMsg();
            this.mQueue.add(apiThread);
        }
    }

    public synchronized void start() {
        stop();
        ApiLocalDispatcher apiLocalDispatcher = new ApiLocalDispatcher(this.mLocalQueue, this.mQueue);
        this.mLocalDispatcher = apiLocalDispatcher;
        apiLocalDispatcher.start();
        for (int i = 0; i < this.mInitThreadPoolSize; i++) {
            ApiDispatcher apiDispatcher = new ApiDispatcher(this.mQueue, "Account-ApiDispatcher-Thread", "ApiDispatcher");
            this.mDispatchers[i] = apiDispatcher;
            apiDispatcher.start();
        }
        if (this.mDownloadDispatchers != null) {
            for (int i2 = 0; i2 < this.mInitDownloadThreadPoolSize; i2++) {
                DownloadDispatcher downloadDispatcher = new DownloadDispatcher(this.mDownloadQueue, "Account-DownloadDispatcher-Thread", "DownloadDispatcher");
                this.mDownloadDispatchers[i2] = downloadDispatcher;
                downloadDispatcher.start();
            }
        }
        this.mStarted = true;
    }

    public synchronized void stop() {
        int i = 0;
        this.mStarted = false;
        ApiLocalDispatcher apiLocalDispatcher = this.mLocalDispatcher;
        if (apiLocalDispatcher != null) {
            apiLocalDispatcher.quit();
        }
        int i2 = 0;
        while (true) {
            ApiDispatcher[] apiDispatcherArr = this.mDispatchers;
            if (i2 >= apiDispatcherArr.length) {
                break;
            }
            ApiDispatcher apiDispatcher = apiDispatcherArr[i2];
            if (apiDispatcher != null) {
                apiDispatcher.quit();
                this.mDispatchers[i2] = null;
            }
            i2++;
        }
        if (this.mDownloadDispatchers != null) {
            while (true) {
                DownloadDispatcher[] downloadDispatcherArr = this.mDownloadDispatchers;
                if (i >= downloadDispatcherArr.length) {
                    break;
                }
                DownloadDispatcher downloadDispatcher = downloadDispatcherArr[i];
                if (downloadDispatcher != null) {
                    downloadDispatcher.quit();
                    this.mDownloadDispatchers[i] = null;
                }
                i++;
            }
        }
    }

    public synchronized void handleExpandRequestQueueSize() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (sDynamicAdjustThreadPoolSizeOpen) {
            LogHelper.d("RequestQueue", "handleExpandRequestQueueSize");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastExpandRequestQueueTime > currentTimeMillis) {
                this.mLastExpandRequestQueueTime = currentTimeMillis;
            }
            if (currentTimeMillis - this.mLastExpandRequestQueueTime <= 1000) {
                LogHelper.d("RequestQueue", "handleExpandRequestQueueSize (now - mLastExpandRequestQueueTime) <= ApiThread.ENQUEUE_EXPIRE");
                return;
            }
            this.mLastExpandRequestQueueTime = currentTimeMillis;
            int i = 0;
            int i2 = 0;
            while (true) {
                ApiDispatcher[] apiDispatcherArr = this.mDispatchers;
                if (i >= apiDispatcherArr.length) {
                    break;
                }
                if (apiDispatcherArr[i] == null) {
                    i2++;
                    if (i2 > this.mInitThreadPoolSize) {
                        break;
                    }
                    ApiDispatcher apiDispatcher = new ApiDispatcher(this.mQueue, "Account-ApiDispatcher-Thread", "ApiDispatcher");
                    LogHelper.d("RequestQueue", "apiDispatcher : " + apiDispatcher.toString() + " create");
                    this.mDispatchers[i] = apiDispatcher;
                    apiDispatcher.start();
                }
                i++;
            }
        }
    }

    public synchronized void handleExpandDownloadRequestQueueSize() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (sDynamicAdjustThreadPoolSizeOpen) {
            LogHelper.d("RequestQueue", "handleExpandDownloadRequestQueueSize");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastExpandDownloadRequestQueueTime > currentTimeMillis) {
                this.mLastExpandDownloadRequestQueueTime = currentTimeMillis;
            }
            if (currentTimeMillis - this.mLastExpandDownloadRequestQueueTime <= 1000) {
                LogHelper.d("RequestQueue", "handleExpandDownloadRequestQueueSize (now - mLastExpandDownloadRequestQueueTime) <= ApiThread.ENQUEUE_EXPIRE");
                return;
            }
            this.mLastExpandDownloadRequestQueueTime = currentTimeMillis;
            if (this.mDownloadDispatchers == null) {
                return;
            }
            int i = 0;
            int i2 = 0;
            while (true) {
                DownloadDispatcher[] downloadDispatcherArr = this.mDownloadDispatchers;
                if (i >= downloadDispatcherArr.length) {
                    break;
                }
                if (downloadDispatcherArr[i] == null) {
                    i2++;
                    if (i2 > this.mInitDownloadThreadPoolSize) {
                        break;
                    }
                    DownloadDispatcher downloadDispatcher = new DownloadDispatcher(this.mDownloadQueue, "Account-DownloadDispatcher-Thread", "DownloadDispatcher");
                    LogHelper.d("RequestQueue", "downloadDispatcher : " + downloadDispatcher.toString() + " create");
                    this.mDownloadDispatchers[i] = downloadDispatcher;
                    downloadDispatcher.start();
                }
                i++;
            }
        }
    }

    public synchronized void handleShrinkRequestQueueSize() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (sDynamicAdjustThreadPoolSizeOpen) {
            LogHelper.d("RequestQueue", "handleShrinkRequestQueueSize");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastShrinkRequestQueueTime > currentTimeMillis) {
                this.mLastShrinkRequestQueueTime = currentTimeMillis;
            }
            if (currentTimeMillis - this.mLastShrinkRequestQueueTime <= 2000) {
                LogHelper.d("RequestQueue", "handleShrinkRequestQueueSize (now - mLastShrinkRequestQueueTime) <= ApiDispatcher.SHRINK_EXPIRE");
                return;
            }
            boolean z = true;
            boolean z2 = true;
            for (int length = this.mDispatchers.length - 1; length >= this.mInitThreadPoolSize; length--) {
                ApiDispatcher apiDispatcher = this.mDispatchers[length];
                if (apiDispatcher != null && apiDispatcher.isRunning()) {
                    z = false;
                }
                if (apiDispatcher != null) {
                    z2 = false;
                }
            }
            this.mLastShrinkRequestQueueTime = currentTimeMillis;
            if (z && !z2) {
                for (int length2 = this.mDispatchers.length - 1; length2 >= this.mInitThreadPoolSize; length2--) {
                    try {
                        ApiDispatcher apiDispatcher2 = this.mDispatchers[length2];
                        if (apiDispatcher2 != null && apiDispatcher2.getState() != Thread.State.RUNNABLE && !apiDispatcher2.isRunning()) {
                            LogHelper.d("RequestQueue", "apiDispatcher : " + apiDispatcher2.toString() + " quit");
                            apiDispatcher2.quit();
                            this.mDispatchers[length2] = null;
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return;
            }
            LogHelper.d("RequestQueue", "handleShrinkRequestQueueSize shouldShrink = " + z + " allNull = " + z2);
        }
    }

    public synchronized void handleShrinkDownloadRequestQueueSize() {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (sDynamicAdjustThreadPoolSizeOpen) {
            LogHelper.d("RequestQueue", "handleShrinkDownloadRequestQueueSize");
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mLastShrinkDownloadRequestQueueTime > currentTimeMillis) {
                this.mLastShrinkDownloadRequestQueueTime = currentTimeMillis;
            }
            if (currentTimeMillis - this.mLastShrinkDownloadRequestQueueTime <= 2000) {
                LogHelper.d("RequestQueue", "handleShrinkDownloadRequestQueueSize (now - mLastShrinkDownloadRequestQueueTime) <= ApiDispatcher.SHRINK_EXPIRE");
                return;
            }
            DownloadDispatcher[] downloadDispatcherArr = this.mDownloadDispatchers;
            if (downloadDispatcherArr == null) {
                return;
            }
            boolean z = true;
            boolean z2 = true;
            for (int length = downloadDispatcherArr.length - 1; length >= this.mInitDownloadThreadPoolSize; length--) {
                DownloadDispatcher downloadDispatcher = this.mDownloadDispatchers[length];
                if (downloadDispatcher != null && downloadDispatcher.isRunning()) {
                    z = false;
                }
                if (downloadDispatcher != null) {
                    z2 = false;
                }
            }
            this.mLastShrinkDownloadRequestQueueTime = currentTimeMillis;
            if (z && !z2) {
                for (int length2 = this.mDownloadDispatchers.length - 1; length2 >= this.mInitDownloadThreadPoolSize; length2--) {
                    try {
                        DownloadDispatcher downloadDispatcher2 = this.mDownloadDispatchers[length2];
                        if (downloadDispatcher2 != null && downloadDispatcher2.getState() != Thread.State.RUNNABLE && !downloadDispatcher2.isRunning()) {
                            LogHelper.d("RequestQueue", "apiDispatcher : " + downloadDispatcher2.toString() + " quit");
                            downloadDispatcher2.quit();
                            this.mDownloadDispatchers[length2] = null;
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                return;
            }
            LogHelper.d("RequestQueue", "handleShrinkDownloadRequestQueueSize shouldShrink " + z + " allNull = " + z2);
        }
    }
}

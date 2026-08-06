package com.bytedance.frameworks.baselib.network.dispatcher;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class RequestQueue implements IRequestQueue {
    private static final int DEFAULT_DOWNLOAD_THREAD_POOL_SIZE = 8;
    private static final int DEFAULT_NETWORK_THREAD_POOL_SIZE = 8;
    private static volatile boolean sDynamicAdjustThreadPoolSizeOpen = true;
    private static volatile RequestQueue sRequestQueue;
    private static volatile ThreadPoolConfig sThreadConfig;

    public static synchronized void setDynamicAdjustThreadPoolSizeOpen(boolean z) {
        synchronized (RequestQueue.class) {
            sDynamicAdjustThreadPoolSizeOpen = z;
            if (sThreadConfig != null) {
                sThreadConfig.setDynamicAdjust(sDynamicAdjustThreadPoolSizeOpen);
            }
        }
    }

    public static synchronized void setThreadPoolConfig(ThreadPoolConfig threadPoolConfig) {
        synchronized (RequestQueue.class) {
            sThreadConfig = threadPoolConfig;
            sThreadConfig.setDynamicAdjust(sDynamicAdjustThreadPoolSizeOpen);
        }
    }

    public static synchronized ThreadPoolConfig getThreadPoolConfig() {
        ThreadPoolConfig threadPoolConfig;
        synchronized (RequestQueue.class) {
            if (sThreadConfig == null) {
                sThreadConfig = ThreadPoolConfig.newBuilder().setApiThreadSize(8, 8).setDownloadThreadSize(8, 8).setApiAliveTime(30L).setImmediateAliveTime(10L).setDownloadAliveTime(10L).setDynamicAdjust(true).build();
            }
            threadPoolConfig = sThreadConfig;
        }
        return threadPoolConfig;
    }

    public static boolean isDynamicAdjustThredPool() {
        return sDynamicAdjustThreadPoolSizeOpen;
    }

    @Deprecated
    public static RequestQueue getDefaultRequestQueue() {
        if (sRequestQueue == null) {
            synchronized (RequestQueue.class) {
                if (sRequestQueue == null) {
                    sRequestQueue = new RequestQueue();
                }
            }
        }
        return sRequestQueue;
    }

    public RequestQueue() {
        this(8, 8);
    }

    @Deprecated
    public RequestQueue(int i, int i2) {
        if (sThreadConfig == null) {
            sThreadConfig = ThreadPoolConfig.newBuilder().setApiThreadSize(8, 8).setDownloadThreadSize(8, 8).setApiAliveTime(30L).setImmediateAliveTime(10L).setDownloadAliveTime(10L).setDynamicAdjust(true).build();
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void addDownload(IApiTask iApiTask) {
        if (iApiTask != null) {
            NetThreadPoolManager.INSTANCE.executeDownload(iApiTask);
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void addDownload(ApiThread apiThread) {
        if (apiThread != null) {
            NetThreadPoolManager.INSTANCE.executeDownload(apiThread);
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void add(IApiTask iApiTask) {
        if (iApiTask != null) {
            NetThreadPoolManager.INSTANCE.executeApi(iApiTask);
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue
    public synchronized void add(ApiThread apiThread) {
        if (apiThread != null) {
            NetThreadPoolManager.INSTANCE.executeApi(apiThread);
        }
    }
}

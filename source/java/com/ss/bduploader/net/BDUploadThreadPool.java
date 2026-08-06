package com.ss.bduploader.net;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class BDUploadThreadPool {
    private static final String TAG = "BDUploadThreadPool";
    private static final int THREADPOOL_ALIVE_TIME_SEC = 300;
    private static final int THREADPOOL_CORE_POOL_SIZE = 3;
    private static final int THREADPOOL_MAX_POOL_SIZE = Integer.MAX_VALUE;
    private static volatile ThreadPoolExecutor mExecutorInstance;

    public static ThreadPoolExecutor getExecutorInstance() {
        if (mExecutorInstance == null) {
            synchronized (BDUploadThreadPool.class) {
                if (mExecutorInstance == null) {
                    mExecutorInstance = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 300L, TimeUnit.SECONDS, new SynchronousQueue());
                }
            }
        }
        return mExecutorInstance;
    }

    public static Future addExecuteTask(Runnable runnable) {
        if (mExecutorInstance == null) {
            getExecutorInstance();
        }
        return mExecutorInstance.submit(runnable);
    }

    public static int getPoolSize() {
        if (mExecutorInstance == null) {
            getExecutorInstance();
        }
        return mExecutorInstance.getPoolSize();
    }

    public static void shutdown() {
        if (mExecutorInstance != null) {
            mExecutorInstance.shutdown();
        }
    }
}

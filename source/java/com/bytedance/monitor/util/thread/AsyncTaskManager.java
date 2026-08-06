package com.bytedance.monitor.util.thread;

import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory;
import com.bytedance.monitor.util.thread.inner.ApmInnerThreadPool;
import com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class AsyncTaskManager implements IAsyncTaskManager {
    private static final int CORE_POOL_SIZE_IO = 1;
    private static final int CORE_POOL_SIZE_LIGHT_WEIGHT = 1;
    private static final int CORE_POOL_SIZE_TIME_SENSITIVE = 1;
    public static final String TAG = "AsyncTaskManager";
    private static final String THREAD_NAME_IO_TASK = "io-task";
    private static final String THREAD_NAME_LIGHT_WEIGHT_TASK = "light-weight-task";
    private static final String THREAD_NAME_TIME_SENSITIVE_TASK = "time-sensitive-task";
    private IAsyncTaskManager.ExceptionListener mExceptionListener;
    private volatile ApmInnerThreadPool mIOTaskExecutor;
    private volatile ApmInnerThreadPool mLightWeightTaskHandler;
    private ThreadLogListener mLogListener;
    private volatile ApmInnerThreadPool mTimeSensitiveTaskHandler;
    private Map<AsyncTaskType, Long> mTypeThreadIdMap = new ConcurrentHashMap(3);
    private static final Object IO_LOCK = new Object();
    private static final Object LIGHT_WEIGHT_LOCK = new Object();
    private static final Object TIME_SENSITIVE_LOCK = new Object();

    /* loaded from: classes4.dex */
    private static final class Holder {
        static final AsyncTaskManager INSTANCE = new AsyncTaskManager();

        private Holder() {
        }
    }

    public static AsyncTaskManager getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void post(TaskRunnable taskRunnable) {
        if (taskRunnable == null) {
            return;
        }
        try {
            getHandlerByTaskType(taskRunnable).post(taskRunnable);
        } catch (Throwable th) {
            directReportError(th, "Apm-Async-task-post");
        }
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void postDelayed(TaskRunnable taskRunnable, long j) {
        if (taskRunnable == null) {
            return;
        }
        try {
            getHandlerByTaskType(taskRunnable).postDelayed(taskRunnable, j);
        } catch (Throwable th) {
            directReportError(th, "Apm-Async-task-postDelayed");
        }
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void removeTask(TaskRunnable taskRunnable) {
        if (taskRunnable == null) {
            return;
        }
        try {
            getHandlerByTaskType(taskRunnable).removeTask(taskRunnable);
        } catch (Throwable th) {
            directReportError(th, "Apm-Async-task-removeTask");
        }
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void scheduleWithFixedDelay(TaskRunnable taskRunnable, long j, long j2) {
        if (taskRunnable == null) {
            return;
        }
        try {
            getHandlerByTaskType(taskRunnable).scheduleWithFixedDelay(taskRunnable, j, j2);
        } catch (Throwable th) {
            directReportError(th, "Apm-Async-task-removeTask");
        }
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public ExecutorService getIOExecutor() {
        return getIOTaskExecutor();
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public ThreadLogListener getThreadLogListener() {
        return this.mLogListener;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public long getWorkThreadId(AsyncTaskType asyncTaskType) {
        Long l = this.mTypeThreadIdMap.get(asyncTaskType);
        if (l != null) {
            return l.longValue();
        }
        return -1L;
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setTaskOverTime(AsyncTaskType asyncTaskType, int i) {
        if (asyncTaskType == AsyncTaskType.IO) {
            getIOTaskExecutor().setTaskOverTime(i);
        } else if (asyncTaskType == AsyncTaskType.TIME_SENSITIVE) {
            getTimeSensitiveHandlerThread().setTaskOverTime(i);
        } else {
            getLightWeightHandlerThread().setTaskOverTime(i);
        }
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void directReportError(Throwable th, String str) {
        IAsyncTaskManager.ExceptionListener exceptionListener = this.mExceptionListener;
        if (exceptionListener != null) {
            exceptionListener.directReportError(th, str);
        }
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void release() {
        try {
            getIOTaskExecutor().release();
            getLightWeightHandlerThread().release();
            getTimeSensitiveHandlerThread().release();
        } catch (Throwable th) {
            directReportError(th, "Apm-Async-task-release");
        }
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void setThreadLogListener(ThreadLogListener threadLogListener) {
        this.mLogListener = threadLogListener;
        getIOTaskExecutor().setThreadLogListener(threadLogListener);
        getLightWeightHandlerThread().setThreadLogListener(threadLogListener);
        getTimeSensitiveHandlerThread().setThreadLogListener(threadLogListener);
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public boolean isPending(TaskRunnable taskRunnable) {
        try {
            return getHandlerByTaskType(taskRunnable).isPending(taskRunnable);
        } catch (Throwable th) {
            directReportError(th, "Apm-Async-task-isPending");
            return false;
        }
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setIOExecutor(ExecutorService executorService) {
        getIOTaskExecutor().setOuterExecutor(executorService);
    }

    private IAsyncTaskHandler getHandlerByTaskType(TaskRunnable taskRunnable) {
        AsyncTaskType taskType = taskRunnable.getTaskType();
        if (taskType == AsyncTaskType.IO) {
            return getIOTaskExecutor();
        }
        if (taskType == AsyncTaskType.TIME_SENSITIVE) {
            return getTimeSensitiveHandlerThread();
        }
        return getLightWeightHandlerThread();
    }

    public ApmInnerThreadPool getLightWeightHandlerThread() {
        if (this.mLightWeightTaskHandler == null) {
            synchronized (LIGHT_WEIGHT_LOCK) {
                if (this.mLightWeightTaskHandler == null) {
                    initLightWeightTaskHandler(this.mLogListener);
                }
            }
        }
        return this.mLightWeightTaskHandler;
    }

    public ApmInnerThreadPool getIOTaskExecutor() {
        if (this.mIOTaskExecutor == null) {
            synchronized (IO_LOCK) {
                if (this.mIOTaskExecutor == null) {
                    initIOTaskExecutor(this.mLogListener);
                }
            }
        }
        return this.mIOTaskExecutor;
    }

    public ApmInnerThreadPool getTimeSensitiveHandlerThread() {
        if (this.mTimeSensitiveTaskHandler == null) {
            synchronized (TIME_SENSITIVE_LOCK) {
                if (this.mTimeSensitiveTaskHandler == null) {
                    initTimeSensitiveHandlerThread(this.mLogListener);
                }
            }
        }
        return this.mTimeSensitiveTaskHandler;
    }

    private void initIOTaskExecutor(ThreadLogListener threadLogListener) {
        synchronized (IO_LOCK) {
            if (this.mIOTaskExecutor == null) {
                ApmInnerThreadFactory apmInnerThreadFactory = new ApmInnerThreadFactory(THREAD_NAME_IO_TASK);
                apmInnerThreadFactory.setLogListener(threadLogListener);
                apmInnerThreadFactory.setThreadIdCallback(new ApmInnerThreadFactory.IThreadIdCallback() { // from class: com.bytedance.monitor.util.thread.AsyncTaskManager.1
                    @Override // com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory.IThreadIdCallback
                    public void onTid(long j) {
                        AsyncTaskManager.this.mTypeThreadIdMap.put(AsyncTaskType.IO, Long.valueOf(j));
                    }
                });
                ApmInnerThreadPool apmInnerThreadPool = new ApmInnerThreadPool(1, apmInnerThreadFactory);
                apmInnerThreadPool.setThreadLogListener(threadLogListener);
                this.mIOTaskExecutor = apmInnerThreadPool;
            }
        }
    }

    private void initLightWeightTaskHandler(ThreadLogListener threadLogListener) {
        synchronized (LIGHT_WEIGHT_LOCK) {
            if (this.mLightWeightTaskHandler == null) {
                ApmInnerThreadFactory apmInnerThreadFactory = new ApmInnerThreadFactory(THREAD_NAME_LIGHT_WEIGHT_TASK);
                apmInnerThreadFactory.setLogListener(threadLogListener);
                apmInnerThreadFactory.setThreadIdCallback(new ApmInnerThreadFactory.IThreadIdCallback() { // from class: com.bytedance.monitor.util.thread.AsyncTaskManager.2
                    @Override // com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory.IThreadIdCallback
                    public void onTid(long j) {
                        AsyncTaskManager.this.mTypeThreadIdMap.put(AsyncTaskType.LIGHT_WEIGHT, Long.valueOf(j));
                    }
                });
                ApmInnerThreadPool apmInnerThreadPool = new ApmInnerThreadPool(1, apmInnerThreadFactory);
                apmInnerThreadPool.setThreadLogListener(threadLogListener);
                this.mLightWeightTaskHandler = apmInnerThreadPool;
            }
        }
    }

    private void initTimeSensitiveHandlerThread(ThreadLogListener threadLogListener) {
        synchronized (TIME_SENSITIVE_LOCK) {
            if (this.mTimeSensitiveTaskHandler == null) {
                ApmInnerThreadFactory apmInnerThreadFactory = new ApmInnerThreadFactory(THREAD_NAME_TIME_SENSITIVE_TASK);
                apmInnerThreadFactory.setLogListener(threadLogListener);
                apmInnerThreadFactory.setThreadIdCallback(new ApmInnerThreadFactory.IThreadIdCallback() { // from class: com.bytedance.monitor.util.thread.AsyncTaskManager.3
                    @Override // com.bytedance.monitor.util.thread.inner.ApmInnerThreadFactory.IThreadIdCallback
                    public void onTid(long j) {
                        AsyncTaskManager.this.mTypeThreadIdMap.put(AsyncTaskType.TIME_SENSITIVE, Long.valueOf(j));
                    }
                });
                ApmInnerThreadPool apmInnerThreadPool = new ApmInnerThreadPool(1, apmInnerThreadFactory);
                apmInnerThreadPool.setThreadLogListener(threadLogListener);
                this.mTimeSensitiveTaskHandler = apmInnerThreadPool;
            }
        }
    }

    @Override // com.bytedance.monitor.util.thread.IAsyncTaskManager
    public void setExceptionListener(IAsyncTaskManager.ExceptionListener exceptionListener) {
        this.mExceptionListener = exceptionListener;
    }
}

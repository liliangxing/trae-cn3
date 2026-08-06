package com.bytedance.monitor.util.thread;

import java.util.Locale;

/* loaded from: classes4.dex */
public class AsyncTaskUtil {
    public static IAsyncTaskManager getAsyncTaskManagerInstance() {
        return AsyncTaskManager.getInstance();
    }

    public static String getTaskInfo(TaskRunnable taskRunnable) {
        return taskRunnable == null ? "null" : taskRunnable.getTaskName() + ", " + taskRunnable.getTaskType();
    }

    public static TaskRunnable wrapLightWeightTask(String str, Runnable runnable) {
        return wrapRunnable(AsyncTaskType.LIGHT_WEIGHT, str, runnable);
    }

    public static TaskRunnable wrapLightWeightTaskNoName(Runnable runnable) {
        return wrapRunnable(AsyncTaskType.LIGHT_WEIGHT, "no-name", runnable);
    }

    public static TaskRunnable wrapIOTask(String str, Runnable runnable) {
        return wrapRunnable(AsyncTaskType.IO, str, runnable);
    }

    public static TaskRunnable wrapTimeSensitiveTask(String str, Runnable runnable) {
        return wrapRunnable(AsyncTaskType.TIME_SENSITIVE, str, runnable);
    }

    public static TaskRunnable wrapRunnable(final AsyncTaskType asyncTaskType, final String str, final Runnable runnable) {
        return new TaskRunnable() { // from class: com.bytedance.monitor.util.thread.AsyncTaskUtil.1
            @Override // com.bytedance.monitor.util.thread.TaskRunnable
            public String getTaskName() {
                return str;
            }

            @Override // com.bytedance.monitor.util.thread.TaskRunnable
            public AsyncTaskType getTaskType() {
                return asyncTaskType;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                        IAsyncTaskManager asyncTaskManagerInstance = AsyncTaskUtil.getAsyncTaskManagerInstance();
                        if (asyncTaskManagerInstance == null || asyncTaskManagerInstance.getThreadLogListener() == null || !asyncTaskManagerInstance.getThreadLogListener().isDebug()) {
                            return;
                        }
                        AsyncTaskUtil.logd(asyncTaskManagerInstance.getThreadLogListener(), "AsyncTaskUtil", "task execute: " + asyncTaskType + "  /  " + str);
                    }
                } catch (Throwable th) {
                    AsyncTaskUtil.getAsyncTaskManagerInstance().directReportError(th, "APM_INNER_ERROR_async_task");
                }
            }
        };
    }

    public static void logd(ThreadLogListener threadLogListener, String str, String str2) {
        if (threadLogListener == null || !threadLogListener.isDebug()) {
            return;
        }
        threadLogListener.onLog(str, String.format(Locale.CHINA, "[callerThread: %s] \n %s", Thread.currentThread().getName(), str2));
    }

    public static void loge(ThreadLogListener threadLogListener, String str, String str2) {
        if (threadLogListener != null) {
            threadLogListener.onError(str, String.format(Locale.CHINA, "[callerThread: %s] \n %s", Thread.currentThread().getName(), str2));
        }
    }
}

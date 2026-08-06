package com.bytedance.monitor.util.thread.inner;

import android.util.Pair;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.monitor.util.thread.ThreadLogListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class ApmInnerThreadPool extends ScheduledThreadPoolExecutor implements IAsyncTaskHandler {
    public final String TAG;
    private ThreadLogListener mDebugLogListener;
    private final Map<ScheduledFuture<?>, Pair<Integer, Boolean>> mFutureTaskMap;
    private ThreadPoolExecutor mOuterExecutorOriginal;
    private ExecutorService mOuterExecutorProxy;
    private RunningTask mRunningTask;
    private final Map<Integer, List<ScheduledFuture<?>>> mTaskFutureMap;
    private int mTaskOverTime;
    private boolean mTestDebug;

    public ApmInnerThreadPool(int i, ThreadFactory threadFactory) {
        super(i, threadFactory);
        this.TAG = "ApmInnerThreadPool";
        this.mTestDebug = false;
        this.mTaskFutureMap = new ConcurrentHashMap();
        this.mFutureTaskMap = new ConcurrentHashMap();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (this.mOuterExecutorProxy != null) {
            if (openDebug()) {
                log("submit task to outer-executor: " + getTaskName(runnable));
            }
            return this.mOuterExecutorProxy.submit(runnable);
        }
        return super.submit(runnable);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (this.mOuterExecutorProxy != null) {
            if (openDebug()) {
                log("submit task to outer-executor: " + callable);
            }
            return this.mOuterExecutorProxy.submit(callable);
        }
        return super.submit(callable);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (this.mOuterExecutorProxy != null) {
            if (openDebug()) {
                log("submit task to outer-executor: " + getTaskName(runnable));
            }
            return this.mOuterExecutorProxy.submit(runnable, t);
        }
        return super.submit(runnable, t);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        checkTaskOverTime(true, runnable, thread);
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        ScheduledFuture scheduledFuture;
        Pair<Integer, Boolean> pair;
        super.afterExecute(runnable, th);
        checkTaskOverTime(false, runnable, null);
        if (!(runnable instanceof ScheduledFuture) || (pair = this.mFutureTaskMap.get((scheduledFuture = (ScheduledFuture) runnable))) == null || pair.first == null) {
            return;
        }
        int intValue = ((Integer) pair.first).intValue();
        Boolean bool = (Boolean) pair.second;
        if (bool == null || bool.booleanValue()) {
            return;
        }
        if (openDebug()) {
            log("z-debug postDelay or scheduled task: " + runnable + ", taskHashCode: " + intValue + ", in map? " + this.mTaskFutureMap.containsKey(Integer.valueOf(intValue)));
        }
        removeMapRecord(Integer.valueOf(intValue), scheduledFuture);
    }

    private void checkTaskOverTime(boolean z, Runnable runnable, Thread thread) {
        if (needCheckTaskOverTime()) {
            if (z) {
                this.mRunningTask = new RunningTask(runnable, thread, this.mTaskOverTime);
            } else {
                this.mRunningTask = null;
            }
        }
    }

    private boolean needCheckTaskOverTime() {
        return this.mTaskOverTime > 0;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void terminated() {
        super.terminated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean openDebug() {
        ThreadLogListener threadLogListener;
        return this.mTestDebug && (threadLogListener = this.mDebugLogListener) != null && threadLogListener.isDebug();
    }

    public void setOuterExecutor(final ExecutorService executorService) {
        if (executorService == null) {
            this.mOuterExecutorProxy = null;
            this.mOuterExecutorOriginal = null;
        } else {
            if (executorService instanceof ThreadPoolExecutor) {
                this.mOuterExecutorOriginal = (ThreadPoolExecutor) executorService;
            }
            this.mOuterExecutorProxy = (ExecutorService) Proxy.newProxyInstance(executorService.getClass().getClassLoader(), new Class[]{ExecutorService.class}, new InvocationHandler() { // from class: com.bytedance.monitor.util.thread.inner.ApmInnerThreadPool.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                    Object invoke = method.invoke(executorService, objArr);
                    if (ApmInnerThreadPool.this.openDebug()) {
                        String str = "null";
                        if (objArr != null) {
                            for (Object obj2 : objArr) {
                                str = str + obj2;
                            }
                        }
                        ApmInnerThreadPool.this.log("call outer-executor " + method.getName() + ", args: " + str);
                        if ("submit".equals(method.getName())) {
                            ApmInnerThreadPool.this.log("call outer-executor " + method.getName() + ", args: " + str);
                        }
                    }
                    return invoke;
                }
            });
        }
    }

    private String getTaskName(Runnable runnable) {
        if (runnable instanceof TaskRunnable) {
            return ((TaskRunnable) runnable).getTaskName();
        }
        return runnable == null ? "null" : runnable.toString();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void post(TaskRunnable taskRunnable) {
        if (openDebug()) {
            log("post " + AsyncTaskUtil.getTaskInfo(taskRunnable));
        }
        submit(taskRunnable);
        cancelRunningTaskIfOverTime();
        if (this.mOuterExecutorProxy == null && openDebug()) {
            log("current task count: " + getQueue().size());
        }
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void removeTask(TaskRunnable taskRunnable) {
        ThreadPoolExecutor threadPoolExecutor = this.mOuterExecutorOriginal;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.remove(taskRunnable);
        }
        if (cancelByFuture(taskRunnable) || !openDebug()) {
            return;
        }
        log("z-debug-removeTask " + AsyncTaskUtil.getTaskInfo(taskRunnable) + ", remove failed");
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void release() {
        ExecutorService executorService = this.mOuterExecutorProxy;
        if (executorService != null) {
            executorService.shutdown();
        }
        shutdown();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void postDelayed(TaskRunnable taskRunnable, long j) {
        if (taskRunnable == null) {
            return;
        }
        if (openDebug()) {
            log("postDelayed " + AsyncTaskUtil.getTaskInfo(taskRunnable));
        }
        saveToMap(schedule(taskRunnable, j, TimeUnit.MILLISECONDS), taskRunnable.hashCode(), false);
        cancelRunningTaskIfOverTime();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void scheduleWithFixedDelay(TaskRunnable taskRunnable, long j, long j2) {
        if (taskRunnable == null) {
            return;
        }
        if (openDebug()) {
            log("scheduleWithFixedDelay " + AsyncTaskUtil.getTaskInfo(taskRunnable) + ", initialDelay: " + j + ", delayInMillis: " + j2 + "\n task count: " + getQueue().size());
        }
        cancelByFuture(taskRunnable);
        saveToMap(scheduleWithFixedDelay(taskRunnable, j, j2, TimeUnit.MILLISECONDS), taskRunnable.hashCode(), true);
        cancelRunningTaskIfOverTime();
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public void setThreadLogListener(ThreadLogListener threadLogListener) {
        this.mDebugLogListener = threadLogListener;
    }

    @Override // com.bytedance.monitor.util.thread.inner.IAsyncTaskHandler
    public boolean isPending(TaskRunnable taskRunnable) {
        boolean z;
        ThreadPoolExecutor threadPoolExecutor = this.mOuterExecutorOriginal;
        if (threadPoolExecutor != null && threadPoolExecutor.getQueue().contains(taskRunnable)) {
            return true;
        }
        boolean contains = getQueue().contains(taskRunnable);
        List<ScheduledFuture<?>> list = this.mTaskFutureMap.get(Integer.valueOf(taskRunnable.hashCode()));
        if (list != null && !list.isEmpty()) {
            Iterator<ScheduledFuture<?>> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().isCancelled()) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return contains || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        AsyncTaskUtil.logd(this.mDebugLogListener, "ApmInnerThreadPool", str);
    }

    public void setTaskOverTime(int i) {
        this.mTaskOverTime = i;
    }

    private void cancelRunningTaskIfOverTime() {
        RunningTask runningTask = this.mRunningTask;
        if (runningTask == null || !runningTask.isOverTime()) {
            return;
        }
        this.mRunningTask.cancel();
        this.mRunningTask = null;
    }

    /* loaded from: classes4.dex */
    public class RunningTask {
        public Runnable runnable;
        public long startTime = System.currentTimeMillis();
        public int taskOverTime;
        public Thread thread;

        public RunningTask(Runnable runnable, Thread thread, int i) {
            this.runnable = runnable;
            this.thread = thread;
            this.taskOverTime = i;
        }

        public boolean isOverTime() {
            return System.currentTimeMillis() - this.startTime > ((long) this.taskOverTime);
        }

        public void cancel() {
            Runnable runnable = this.runnable;
            if (runnable != null && (runnable instanceof FutureTask)) {
                boolean cancel = ((FutureTask) runnable).cancel(true);
                if (ApmInnerThreadPool.this.openDebug()) {
                    ApmInnerThreadPool.this.log("TimeSensitive + mCancelOverTimeTaskRunnable run ------------ cancel FutureTask, canceled?" + cancel);
                }
            }
        }
    }

    private boolean cancelByFuture(TaskRunnable taskRunnable) {
        boolean z = false;
        if (taskRunnable == null) {
            return false;
        }
        int hashCode = taskRunnable.hashCode();
        List<ScheduledFuture<?>> list = this.mTaskFutureMap.get(Integer.valueOf(hashCode));
        log("z-debug scheduledFutures in ?" + (list != null));
        if (list != null && !list.isEmpty()) {
            if (openDebug()) {
                log("z-debug-removeTask from mTaskFutureMap" + AsyncTaskUtil.getTaskInfo(taskRunnable));
                log("z-debug scheduledFutures size:" + list.size());
            }
            for (ScheduledFuture<?> scheduledFuture : list) {
                if (!scheduledFuture.isCancelled()) {
                    if (scheduledFuture.cancel(true)) {
                        z = true;
                    }
                    removeMapRecord(Integer.valueOf(hashCode), scheduledFuture);
                }
            }
        }
        return z;
    }

    private void saveToMap(ScheduledFuture<?> scheduledFuture, int i, boolean z) {
        List<ScheduledFuture<?>> list = this.mTaskFutureMap.get(Integer.valueOf(i));
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.mTaskFutureMap.put(Integer.valueOf(i), list);
        }
        list.add(scheduledFuture);
        this.mFutureTaskMap.put(scheduledFuture, new Pair<>(Integer.valueOf(i), Boolean.valueOf(z)));
        if (openDebug()) {
            log("z-debug saveToMap -current task count: " + getQueue().size() + ", thread-count; " + getActiveCount());
            log("z-debug saveToMap >>>>>> mTaskFutureMap size: " + this.mTaskFutureMap.size() + ", mFutureTaskMap size: " + this.mFutureTaskMap.size());
            log("z-debug saveToMap >>>>>> sameHashCodeFutures size: " + list.size());
        }
    }

    private void removeMapRecord(Integer num, ScheduledFuture scheduledFuture) {
        boolean z;
        List<ScheduledFuture<?>> list = this.mTaskFutureMap.get(num);
        if (list != null) {
            z = list.remove(scheduledFuture);
            if (list.isEmpty()) {
                this.mTaskFutureMap.remove(num);
            }
        } else {
            z = false;
        }
        this.mFutureTaskMap.remove(scheduledFuture);
        if (openDebug()) {
            log("z-debug removeMapRecord: " + scheduledFuture + ", removed: " + z);
        }
    }

    public void setTestDebug(boolean z) {
        this.mTestDebug = z;
    }
}

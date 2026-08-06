package com.bytedance.ies.bullet.prefetchv2;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/TaskManager;", "", "()V", "lockObj", "Ljava/lang/Object;", "runningTask", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchTask;", "enqueue", "", "task", PrefetchRequestConfig.METHOD_GET, "request", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", "isTaskRunning", "", "remove", "removeAndFinish", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TaskManager {
    public static final TaskManager INSTANCE = new TaskManager();
    private static final ConcurrentHashMap<String, PrefetchTask> runningTask = new ConcurrentHashMap<>(16);
    private static final Object lockObj = new Object();

    private TaskManager() {
    }

    public final boolean isTaskRunning(PrefetchRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return runningTask.containsKey(request.getRequestKey());
    }

    public final PrefetchTask get(PrefetchRequest request) {
        PrefetchTask prefetchTask;
        Intrinsics.checkNotNullParameter(request, "request");
        synchronized (lockObj) {
            ConcurrentHashMap<String, PrefetchTask> concurrentHashMap = runningTask;
            if (!concurrentHashMap.containsKey(request.getRequestKey())) {
                PrefetchLogger.INSTANCE.m36d("Prefetch任务查找失败，" + request.getRequestKey() + ", runningTask: " + concurrentHashMap);
            }
            prefetchTask = concurrentHashMap.get(request.getRequestKey());
        }
        return prefetchTask;
    }

    public final void enqueue(PrefetchTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (lockObj) {
            PrefetchRequest request = task.getRequest();
            ConcurrentHashMap<String, PrefetchTask> concurrentHashMap = runningTask;
            if (concurrentHashMap.containsKey(request.getRequestKey())) {
                PrefetchLogger.INSTANCE.m36d("已有进行中的prefetch task，跳过, url: " + request.getRequestKey());
                return;
            }
            concurrentHashMap.put(request.getRequestKey(), task);
            PrefetchLogger.INSTANCE.m36d("开始prefetch请求，" + task.getRequest().getRequestKey());
            task.run$anniex_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void remove(PrefetchRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        synchronized (lockObj) {
            runningTask.remove(request.getRequestKey());
        }
    }

    public final void removeAndFinish(PrefetchRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        synchronized (lockObj) {
            PrefetchTask remove = runningTask.remove(request.getRequestKey());
            if (remove != null) {
                remove.finish();
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}

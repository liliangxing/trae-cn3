package com.bytedance.ies.bullet.service.monitor.task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoaderTasksPerfMetric.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006#"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/task/LoaderTasksPerfMetric;", "", "()V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "isLoaderTasksReady", "", "()Ljava/lang/Boolean;", "setLoaderTasksReady", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "loaderResult", "getLoaderResult", "setLoaderResult", "loaderTaskDurationsCollection", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getLoaderTaskDurationsCollection", "()Ljava/util/concurrent/ConcurrentHashMap;", "setLoaderTaskDurationsCollection", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "loaderTaskReadyCollection", "getLoaderTaskReadyCollection", "setLoaderTaskReadyCollection", "getLoaderPerfMetric", "", "recordTaskDuration", "", "taskName", "recordTaskIsReady", "isReady", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LoaderTasksPerfMetric {
    private long duration;
    private Boolean isLoaderTasksReady;
    private Boolean loaderResult;
    private ConcurrentHashMap<String, Long> loaderTaskDurationsCollection;
    private ConcurrentHashMap<String, Boolean> loaderTaskReadyCollection;

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    /* renamed from: isLoaderTasksReady, reason: from getter */
    public final Boolean getIsLoaderTasksReady() {
        return this.isLoaderTasksReady;
    }

    public final void setLoaderTasksReady(Boolean bool) {
        this.isLoaderTasksReady = bool;
    }

    public final Boolean getLoaderResult() {
        return this.loaderResult;
    }

    public final void setLoaderResult(Boolean bool) {
        this.loaderResult = bool;
    }

    public final ConcurrentHashMap<String, Boolean> getLoaderTaskReadyCollection() {
        return this.loaderTaskReadyCollection;
    }

    public final void setLoaderTaskReadyCollection(ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        this.loaderTaskReadyCollection = concurrentHashMap;
    }

    public final ConcurrentHashMap<String, Long> getLoaderTaskDurationsCollection() {
        return this.loaderTaskDurationsCollection;
    }

    public final void setLoaderTaskDurationsCollection(ConcurrentHashMap<String, Long> concurrentHashMap) {
        this.loaderTaskDurationsCollection = concurrentHashMap;
    }

    public final void recordTaskIsReady(String taskName, boolean isReady) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        if (this.loaderTaskReadyCollection == null) {
            this.loaderTaskReadyCollection = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.loaderTaskReadyCollection;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(taskName + "_is_ready", Boolean.valueOf(isReady));
        }
    }

    public final void recordTaskDuration(String taskName, long duration) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        if (this.loaderTaskDurationsCollection == null) {
            this.loaderTaskDurationsCollection = new ConcurrentHashMap<>();
        }
        ConcurrentHashMap<String, Long> concurrentHashMap = this.loaderTaskDurationsCollection;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(taskName + "_duration", Long.valueOf(duration));
        }
    }

    public final Map<String, Object> getLoaderPerfMetric() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ConcurrentHashMap<String, Boolean> concurrentHashMap = this.loaderTaskReadyCollection;
        if (concurrentHashMap != null) {
            linkedHashMap.putAll(concurrentHashMap);
        }
        ConcurrentHashMap<String, Long> concurrentHashMap2 = this.loaderTaskDurationsCollection;
        if (concurrentHashMap2 != null) {
            linkedHashMap.putAll(concurrentHashMap2);
        }
        return linkedHashMap;
    }
}

package com.bytedance.forest.interceptor;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalInterceptor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u001d\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\b\"J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000fJ\u000e\u0010'\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0007J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0011\u0010\u000b¨\u0006)"}, d2 = {"Lcom/bytedance/forest/interceptor/GlobalInterceptor;", "", "()V", "TAG", "", "interceptorLists", "", "Lcom/bytedance/forest/interceptor/ForestInterceptor;", "interceptorLocker", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getInterceptorLocker", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "interceptorLocker$delegate", "Lkotlin/Lazy;", "monitorLists", "Lcom/bytedance/forest/interceptor/ForestMonitor;", "monitorLocker", "getMonitorLocker", "monitorLocker$delegate", "onFetchFinished", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "onFetchFinished$forest_release", "onFetchStart", "url", "requestParams", "Lcom/bytedance/forest/model/RequestParams;", "onFetchStart$forest_release", "onRequestCreated", "request", "Lcom/bytedance/forest/model/Request;", "onRequestCreated$forest_release", "registerHook", "interceptor", "registerMonitor", "monitor", "unregisterHook", "unregisterMonitor", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GlobalInterceptor {
    public static final String TAG = "GlobalInterceptor";
    public static final GlobalInterceptor INSTANCE = new GlobalInterceptor();
    private static final List<ForestMonitor> monitorLists = new ArrayList();
    private static final List<ForestInterceptor> interceptorLists = new ArrayList();

    /* renamed from: monitorLocker$delegate, reason: from kotlin metadata */
    private static final Lazy monitorLocker = LazyKt.lazy(new Function0<ReentrantReadWriteLock>() { // from class: com.bytedance.forest.interceptor.GlobalInterceptor$monitorLocker$2
        public final ReentrantReadWriteLock invoke() {
            return new ReentrantReadWriteLock();
        }
    });

    /* renamed from: interceptorLocker$delegate, reason: from kotlin metadata */
    private static final Lazy interceptorLocker = LazyKt.lazy(new Function0<ReentrantReadWriteLock>() { // from class: com.bytedance.forest.interceptor.GlobalInterceptor$interceptorLocker$2
        public final ReentrantReadWriteLock invoke() {
            return new ReentrantReadWriteLock();
        }
    });

    private final ReentrantReadWriteLock getInterceptorLocker() {
        return (ReentrantReadWriteLock) interceptorLocker.getValue();
    }

    private final ReentrantReadWriteLock getMonitorLocker() {
        return (ReentrantReadWriteLock) monitorLocker.getValue();
    }

    private GlobalInterceptor() {
    }

    public final void onRequestCreated$forest_release(Request request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        ReentrantReadWriteLock.ReadLock readLock = getInterceptorLocker().readLock();
        readLock.lock();
        try {
            for (int size = interceptorLists.size() - 1; size >= 0; size--) {
                try {
                    interceptorLists.get(size).onRequestCreated(request);
                } catch (Throwable th) {
                    LogUtils.INSTANCE.m289e(TAG, "intercept onLoadStart error", th);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    public final void onFetchStart$forest_release(String url, RequestParams requestParams) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(requestParams, "requestParams");
        ReentrantReadWriteLock.ReadLock readLock = getMonitorLocker().readLock();
        readLock.lock();
        try {
            for (int size = monitorLists.size() - 1; size >= 0; size--) {
                try {
                    monitorLists.get(size).onLoadStart(url, requestParams);
                } catch (Throwable th) {
                    LogUtils.INSTANCE.m289e(TAG, "monitor onLoadStart error", th);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    public final void onFetchFinished$forest_release(Response response, ForestPipelineContext context) {
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(context, "context");
        response.getPerformanceInfo().putAll(context.getPerformanceInfo$forest_release());
        ReentrantReadWriteLock.ReadLock readLock = getMonitorLocker().readLock();
        readLock.lock();
        try {
            for (int size = monitorLists.size() - 1; size >= 0; size--) {
                try {
                    monitorLists.get(size).onLoadFinished(response);
                } catch (Throwable th) {
                    LogUtils.INSTANCE.m289e(TAG, "monitor onLoadFinished error", th);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            readLock.unlock();
        }
    }

    public final void registerMonitor(ForestMonitor monitor) {
        Intrinsics.checkParameterIsNotNull(monitor, "monitor");
        ReentrantReadWriteLock monitorLocker2 = getMonitorLocker();
        ReentrantReadWriteLock.ReadLock readLock = monitorLocker2.readLock();
        int i = 0;
        int readHoldCount = monitorLocker2.getWriteHoldCount() == 0 ? monitorLocker2.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = monitorLocker2.writeLock();
        writeLock.lock();
        try {
            monitorLists.add(monitor);
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final void registerHook(ForestInterceptor interceptor) {
        Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
        ReentrantReadWriteLock interceptorLocker2 = getInterceptorLocker();
        ReentrantReadWriteLock.ReadLock readLock = interceptorLocker2.readLock();
        int i = 0;
        int readHoldCount = interceptorLocker2.getWriteHoldCount() == 0 ? interceptorLocker2.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = interceptorLocker2.writeLock();
        writeLock.lock();
        try {
            interceptorLists.add(interceptor);
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final void unregisterMonitor(ForestMonitor monitor) {
        Intrinsics.checkParameterIsNotNull(monitor, "monitor");
        ReentrantReadWriteLock monitorLocker2 = getMonitorLocker();
        ReentrantReadWriteLock.ReadLock readLock = monitorLocker2.readLock();
        int i = 0;
        int readHoldCount = monitorLocker2.getWriteHoldCount() == 0 ? monitorLocker2.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = monitorLocker2.writeLock();
        writeLock.lock();
        try {
            monitorLists.remove(monitor);
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }

    public final void unregisterHook(ForestInterceptor interceptor) {
        Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
        ReentrantReadWriteLock interceptorLocker2 = getInterceptorLocker();
        ReentrantReadWriteLock.ReadLock readLock = interceptorLocker2.readLock();
        int i = 0;
        int readHoldCount = interceptorLocker2.getWriteHoldCount() == 0 ? interceptorLocker2.getReadHoldCount() : 0;
        for (int i2 = 0; i2 < readHoldCount; i2++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = interceptorLocker2.writeLock();
        writeLock.lock();
        try {
            interceptorLists.remove(interceptor);
        } finally {
            while (i < readHoldCount) {
                readLock.lock();
                i++;
            }
            writeLock.unlock();
        }
    }
}

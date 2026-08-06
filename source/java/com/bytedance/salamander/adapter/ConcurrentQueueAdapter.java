package com.bytedance.salamander.adapter;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: thread.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/salamander/adapter/ConcurrentQueueAdapter;", "Lcom/bytedance/salamander/adapter/QueueAdapter;", "name", "", "priority", "", "(Ljava/lang/String;I)V", "executor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "post", "", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "shutdown", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
final class ConcurrentQueueAdapter implements QueueAdapter {
    private final ScheduledThreadPoolExecutor executor;

    public ConcurrentQueueAdapter(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.executor = new ScheduledThreadPoolExecutor(4, new PriorityThreadFactory(i, name));
    }

    public /* synthetic */ ConcurrentQueueAdapter(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i);
    }

    @Override // com.bytedance.salamander.adapter.QueueAdapter
    public boolean post(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.executor.execute(runnable);
        return true;
    }

    @Override // com.bytedance.salamander.adapter.QueueAdapter
    public boolean postDelayed(Runnable runnable, long delayMillis) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.executor.schedule(runnable, delayMillis, TimeUnit.MILLISECONDS);
        return true;
    }

    public final void shutdown() {
        this.executor.shutdown();
    }
}

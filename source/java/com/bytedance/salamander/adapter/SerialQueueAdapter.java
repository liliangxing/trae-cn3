package com.bytedance.salamander.adapter;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: thread.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/salamander/adapter/SerialQueueAdapter;", "Lcom/bytedance/salamander/adapter/QueueAdapter;", "name", "", "priority", "", "(Ljava/lang/String;I)V", "handler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "post", "", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "shutdown", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
final class SerialQueueAdapter implements QueueAdapter {
    private final Handler handler;
    private final HandlerThread handlerThread;

    public SerialQueueAdapter(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        HandlerThread handlerThread = new HandlerThread(name, i);
        handlerThread.start();
        this.handlerThread = handlerThread;
        this.handler = new Handler(handlerThread.getLooper());
    }

    public /* synthetic */ SerialQueueAdapter(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i);
    }

    @Override // com.bytedance.salamander.adapter.QueueAdapter
    public boolean post(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return this.handler.post(runnable);
    }

    @Override // com.bytedance.salamander.adapter.QueueAdapter
    public boolean postDelayed(Runnable runnable, long delayMillis) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        return this.handler.postDelayed(runnable, delayMillis);
    }

    public final void shutdown() {
        this.handlerThread.quitSafely();
    }
}

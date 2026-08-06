package com.bytedance.salamander.adapter;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: thread.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/salamander/adapter/MainQueueAdapter;", "Lcom/bytedance/salamander/adapter/QueueAdapter;", "()V", "handler", "Landroid/os/Handler;", "post", "", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
final class MainQueueAdapter implements QueueAdapter {
    private final Handler handler = new Handler(Looper.getMainLooper());

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
}

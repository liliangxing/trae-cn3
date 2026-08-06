package com.bytedance.forest.utils;

import android.os.Looper;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;

/* compiled from: ThreadUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "run"}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
final class ThreadUtils$handleIfMessageQueueIsNull$1 implements Runnable {
    final /* synthetic */ Runnable $runnable;

    ThreadUtils$handleIfMessageQueueIsNull$1(Runnable runnable) {
        this.$runnable = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        ThreadUtils.messageQueue = Looper.myQueue();
        ThreadUtils.INSTANCE.postIdleTask(this.$runnable);
    }
}

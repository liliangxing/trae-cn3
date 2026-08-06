package com.bytedance.trae.praise;

import com.bytedance.praisedialoglib.depend.IPraiseDialogAsyncThreadConfig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PraiseDialogAsyncThreadImpl.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/praise/PraiseDialogAsyncThreadImpl;", "Lcom/bytedance/praisedialoglib/depend/IPraiseDialogAsyncThreadConfig;", "<init>", "()V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "execute", "", "runnable", "Ljava/lang/Runnable;", "praise_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PraiseDialogAsyncThreadImpl implements IPraiseDialogAsyncThreadConfig {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    @Override // com.bytedance.praisedialoglib.depend.IPraiseDialogAsyncThreadConfig
    public void execute(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.executor.execute(runnable);
    }
}

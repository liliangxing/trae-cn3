package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.original.Model;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.bytedance.applog.priority.original.Worker$coroutineScope$2$invoke$$inlined$CoroutineExceptionHandler$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C0470x802a39fb extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ Worker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0470x802a39fb(CoroutineExceptionHandler.Key key, Worker worker) {
        super((CoroutineContext.Key) key);
        this.this$0 = worker;
    }

    public void handleException(CoroutineContext context, Throwable exception) {
        Model.PriorityContext priorityContext;
        Model.PriorityContext priorityContext2;
        priorityContext = this.this$0.priorityContext;
        priorityContext.getLogger().err("Worker {} CoroutineScope error: {}", this.this$0, exception);
        priorityContext2 = this.this$0.priorityContext;
        priorityContext2.getCallback().monitorError("Worker " + this.this$0 + " CoroutineScope error", exception.toString());
    }
}

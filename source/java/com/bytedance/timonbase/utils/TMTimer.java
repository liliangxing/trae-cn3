package com.bytedance.timonbase.utils;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMTimer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u0006J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0006\u0010\u0010\u001a\u00020\u0006R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/timonbase/utils/TMTimer;", "", "intervalMs", "", "task", "Lkotlin/Function0;", "", "(JLkotlin/jvm/functions/Function0;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "cancel", "next", "start", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMTimer {

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private final Lazy handler;
    private final long intervalMs;
    private final Function0<Unit> task;

    private final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    public TMTimer(long j, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "task");
        this.intervalMs = j;
        this.task = function0;
        this.handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.timonbase.utils.TMTimer$handler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m1085invoke() {
                return new Handler(TMThreadUtils.INSTANCE.getHandlerThread().getLooper());
            }
        });
    }

    public final void start() {
        next();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void next() {
        getHandler().postDelayed(new Runnable() { // from class: com.bytedance.timonbase.utils.TMTimer$next$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0 function0;
                function0 = TMTimer.this.task;
                function0.invoke();
                TMTimer.this.next();
            }
        }, this.intervalMs);
    }

    public final void cancel() {
        getHandler().removeCallbacksAndMessages(null);
    }
}

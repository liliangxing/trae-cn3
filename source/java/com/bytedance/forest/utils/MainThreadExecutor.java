package com.bytedance.forest.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.forest.utils.ThreadUtils;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/forest/utils/MainThreadExecutor;", "", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "highPriorityQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/lang/Runnable;", "submit", "", "task", "priority", "Lcom/bytedance/forest/utils/ThreadUtils$Priority;", "submit$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MainThreadExecutor {

    /* renamed from: handler$delegate, reason: from kotlin metadata */
    private final Lazy handler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.forest.utils.MainThreadExecutor$handler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m533invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private final ConcurrentLinkedQueue<Runnable> highPriorityQueue = new ConcurrentLinkedQueue<>();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThreadUtils.Priority.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ThreadUtils.Priority.HIGH.ordinal()] = 1;
        }
    }

    private final Handler getHandler() {
        return (Handler) this.handler.getValue();
    }

    public static /* synthetic */ boolean submit$forest_release$default(MainThreadExecutor mainThreadExecutor, Runnable runnable, ThreadUtils.Priority priority, int i, Object obj) {
        if ((i & 2) != 0) {
            priority = ThreadUtils.Priority.NORMAL;
        }
        return mainThreadExecutor.submit$forest_release(runnable, priority);
    }

    public final boolean submit$forest_release(Runnable task, ThreadUtils.Priority priority) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(priority, "priority");
        if (WhenMappings.$EnumSwitchMapping$0[priority.ordinal()] == 1) {
            this.highPriorityQueue.add(task);
            return getHandler().postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.forest.utils.MainThreadExecutor$submit$1
                @Override // java.lang.Runnable
                public final void run() {
                    ConcurrentLinkedQueue concurrentLinkedQueue;
                    try {
                        Result.Companion companion = Result.Companion;
                        concurrentLinkedQueue = MainThreadExecutor.this.highPriorityQueue;
                        ((Runnable) concurrentLinkedQueue.remove()).run();
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                }
            });
        }
        return getHandler().post(task);
    }
}

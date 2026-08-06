package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FoundationThread.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/salamander/adapter/SLThread;", "", "()V", "Companion", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SLThread {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: FoundationThread.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J9\u0010\u0005\u001a\u00020\u00062%\u0010\u0007\u001a!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\bj\u0002`\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016JA\u0010\u000f\u001a\u00020\u00062%\u0010\u0007\u001a!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\bj\u0002`\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/salamander/adapter/SLThread$Companion;", "", "()V", "inMainThread", "", "runOnMainThread", "", "workload", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isCancelled", "Lcom/bytedance/salamander/adapter/Workload;", "after", "", "runOnThread", "queue", "Lcom/bytedance/salamander/adapter/Queue;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public boolean inMainThread() {
            return ThreadKt.isMainThreadImpl();
        }

        public static /* synthetic */ void runOnMainThread$default(Companion companion, Function1 function1, double d, int i, Object obj) {
            if ((i & 2) != 0) {
                d = 0.0d;
            }
            companion.runOnMainThread(function1, d);
        }

        public void runOnMainThread(Function1<? super Boolean, Unit> workload, double after) {
            Intrinsics.checkNotNullParameter(workload, "workload");
            SLThread.INSTANCE.runOnThread(workload, Queue.INSTANCE.getMain(), after);
        }

        public static /* synthetic */ void runOnThread$default(Companion companion, Function1 function1, Queue queue, double d, int i, Object obj) {
            if ((i & 4) != 0) {
                d = 0.0d;
            }
            companion.runOnThread(function1, queue, d);
        }

        public void runOnThread(Function1<? super Boolean, Unit> workload, Queue queue, double after) {
            Intrinsics.checkNotNullParameter(workload, "workload");
            Intrinsics.checkNotNullParameter(queue, "queue");
            ThreadKt.runOnThreadImpl(workload, after, queue);
        }
    }
}

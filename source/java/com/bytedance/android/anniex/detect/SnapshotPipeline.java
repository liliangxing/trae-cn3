package com.bytedance.android.anniex.detect;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/detect/SnapshotPipeline;", "", "steps", "", "Lcom/bytedance/android/anniex/detect/SnapShotStep;", "shouldInterrupt", "Lkotlin/Function1;", "Lcom/bytedance/android/anniex/detect/SnapShotResult;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "run", "context", "Lcom/bytedance/android/anniex/detect/SnapShotContext;", "(Lcom/bytedance/android/anniex/detect/SnapShotContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SnapshotPipeline {
    private final Function1<SnapShotResult, Boolean> shouldInterrupt;
    private final List<SnapShotStep> steps;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotPipeline(List<? extends SnapShotStep> list, Function1<? super SnapShotResult, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "steps");
        Intrinsics.checkNotNullParameter(function1, "shouldInterrupt");
        this.steps = list;
        this.shouldInterrupt = function1;
    }

    public /* synthetic */ SnapshotPipeline(List list, C08581 c08581, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? new Function1<SnapShotResult, Boolean>() { // from class: com.bytedance.android.anniex.detect.SnapshotPipeline.1
            public final Boolean invoke(SnapShotResult snapShotResult) {
                Intrinsics.checkNotNullParameter(snapShotResult, "it");
                return Boolean.valueOf(!snapShotResult.isSuccess());
            }
        } : c08581);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0066 -> B:10:0x0069). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object run(SnapShotContext snapShotContext, Continuation<? super SnapShotResult> continuation) {
        SnapshotPipeline$run$1 snapshotPipeline$run$1;
        int i;
        SnapshotPipeline snapshotPipeline;
        SnapShotContext snapShotContext2;
        Iterator<SnapShotStep> it;
        if (continuation instanceof SnapshotPipeline$run$1) {
            snapshotPipeline$run$1 = (SnapshotPipeline$run$1) continuation;
            if ((snapshotPipeline$run$1.label & Integer.MIN_VALUE) != 0) {
                snapshotPipeline$run$1.label -= Integer.MIN_VALUE;
                Object obj = snapshotPipeline$run$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = snapshotPipeline$run$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    snapshotPipeline = this;
                    snapShotContext2 = snapShotContext;
                    it = this.steps.iterator();
                    if (!it.hasNext()) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) snapshotPipeline$run$1.L$2;
                    SnapShotContext snapShotContext3 = (SnapShotContext) snapshotPipeline$run$1.L$1;
                    snapshotPipeline = (SnapshotPipeline) snapshotPipeline$run$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    SnapShotResult snapShotResult = (SnapShotResult) obj;
                    if (!((Boolean) snapshotPipeline.shouldInterrupt.invoke(snapShotResult)).booleanValue()) {
                        return snapShotResult;
                    }
                    snapShotContext2 = snapShotContext3;
                    if (!it.hasNext()) {
                        SnapShotStep next = it.next();
                        snapshotPipeline$run$1.L$0 = snapshotPipeline;
                        snapshotPipeline$run$1.L$1 = snapShotContext2;
                        snapshotPipeline$run$1.L$2 = it;
                        snapshotPipeline$run$1.label = 1;
                        Object execute = next.execute(snapShotContext2, snapshotPipeline$run$1);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        snapShotContext3 = snapShotContext2;
                        obj = execute;
                        SnapShotResult snapShotResult2 = (SnapShotResult) obj;
                        if (!((Boolean) snapshotPipeline.shouldInterrupt.invoke(snapShotResult2)).booleanValue()) {
                        }
                    } else {
                        return new SnapShotResult(true, null);
                    }
                }
            }
        }
        snapshotPipeline$run$1 = new SnapshotPipeline$run$1(this, continuation);
        Object obj2 = snapshotPipeline$run$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = snapshotPipeline$run$1.label;
        if (i != 0) {
        }
    }
}

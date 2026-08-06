package androidx.compose.runtime.snapshots;

import androidx.compose.p002ui.graphics.Fields;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: SnapshotIdSet.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {252, Fields.RotationX, 263}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Long>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Long> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00cf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x00fc -> B:7:0x0100). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x00ff -> B:7:0x0100). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x009b -> B:21:0x00bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00b8 -> B:21:0x00bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0078 -> B:33:0x007b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1;
        SequenceScope sequenceScope2;
        int length;
        long[] jArr;
        int i;
        SequenceScope sequenceScope3;
        int i2;
        SequenceScope sequenceScope4;
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$12;
        int i3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        long j = 1;
        long j2 = 0;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            long[] jArr2 = this.this$0.belowBound;
            if (jArr2 == null) {
                snapshotIdSet$iterator$1 = this;
                if (snapshotIdSet$iterator$1.this$0.lowerSet != 0) {
                }
                if (snapshotIdSet$iterator$1.this$0.upperSet != 0) {
                }
                return Unit.INSTANCE;
            }
            snapshotIdSet$iterator$1 = this;
            sequenceScope2 = sequenceScope;
            length = jArr2.length;
            jArr = jArr2;
            i = 0;
            if (i < length) {
            }
        } else if (i4 == 1) {
            length = this.I$1;
            i = this.I$0;
            jArr = (long[]) this.L$1;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            snapshotIdSet$iterator$1 = this;
            i++;
            if (i < length) {
                Long boxLong = Boxing.boxLong(jArr[i]);
                snapshotIdSet$iterator$1.L$0 = sequenceScope2;
                snapshotIdSet$iterator$1.L$1 = jArr;
                snapshotIdSet$iterator$1.I$0 = i;
                snapshotIdSet$iterator$1.I$1 = length;
                snapshotIdSet$iterator$1.label = 1;
                if (sequenceScope2.yield(boxLong, snapshotIdSet$iterator$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i++;
                if (i < length) {
                    sequenceScope = sequenceScope2;
                    if (snapshotIdSet$iterator$1.this$0.lowerSet != 0) {
                        sequenceScope3 = sequenceScope;
                        i2 = 0;
                        if (i2 >= 64) {
                        }
                    }
                    if (snapshotIdSet$iterator$1.this$0.upperSet != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
        } else {
            if (i4 != 2) {
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i5 = this.I$0;
                sequenceScope4 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                i3 = i5;
                snapshotIdSet$iterator$12 = this;
                i3++;
                j2 = 0;
                if (i3 < 64) {
                    if ((snapshotIdSet$iterator$12.this$0.upperSet & (1 << i3)) != j2) {
                        snapshotIdSet$iterator$12.L$0 = sequenceScope4;
                        snapshotIdSet$iterator$12.L$1 = null;
                        snapshotIdSet$iterator$12.I$0 = i3;
                        snapshotIdSet$iterator$12.label = 3;
                        if (sequenceScope4.yield(Boxing.boxLong(snapshotIdSet$iterator$12.this$0.lowerBound + i3 + 64), (Continuation) snapshotIdSet$iterator$12) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    i3++;
                    j2 = 0;
                    if (i3 < 64) {
                    }
                }
                return Unit.INSTANCE;
            }
            i2 = this.I$0;
            sequenceScope3 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            snapshotIdSet$iterator$1 = this;
            i2++;
            j = 1;
            if (i2 >= 64) {
                sequenceScope = sequenceScope3;
                if (snapshotIdSet$iterator$1.this$0.upperSet != 0) {
                    sequenceScope4 = sequenceScope;
                    snapshotIdSet$iterator$12 = snapshotIdSet$iterator$1;
                    i3 = 0;
                    if (i3 < 64) {
                    }
                }
                return Unit.INSTANCE;
            }
            if ((snapshotIdSet$iterator$1.this$0.lowerSet & (j << i2)) != 0) {
                snapshotIdSet$iterator$1.L$0 = sequenceScope3;
                snapshotIdSet$iterator$1.L$1 = null;
                snapshotIdSet$iterator$1.I$0 = i2;
                snapshotIdSet$iterator$1.label = 2;
                if (sequenceScope3.yield(Boxing.boxLong(snapshotIdSet$iterator$1.this$0.lowerBound + i2), (Continuation) snapshotIdSet$iterator$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            i2++;
            j = 1;
            if (i2 >= 64) {
            }
        }
    }
}

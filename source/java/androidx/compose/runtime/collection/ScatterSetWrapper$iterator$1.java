package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ScatterSetWrapper.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.collection.ScatterSetWrapper$iterator$1", f = "ScatterSetWrapper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {31}, m = "invokeSuspend", n = {"$this$iterator", "elements$iv", "m$iv$iv", "lastIndex$iv$iv", "i$iv$iv", "slot$iv$iv", "bitCount$iv$iv", "j$iv$iv"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "J$0", "I$2", "I$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class ScatterSetWrapper$iterator$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScatterSetWrapper<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScatterSetWrapper$iterator$1(ScatterSetWrapper<T> scatterSetWrapper, Continuation<? super ScatterSetWrapper$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = scatterSetWrapper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> scatterSetWrapper$iterator$1 = new ScatterSetWrapper$iterator$1<>(this.this$0, continuation);
        scatterSetWrapper$iterator$1.L$0 = obj;
        return scatterSetWrapper$iterator$1;
    }

    public final Object invoke(SequenceScope<? super T> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a8, code lost:
    
        if (0 != 0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0072  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x009e -> B:5:0x00a3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005c -> B:20:0x00b2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005e -> B:7:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        Object[] objArr;
        long[] jArr;
        int length;
        ScatterSetWrapper$iterator$1<T> scatterSetWrapper$iterator$1;
        int i;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            ScatterSet<T> set$runtime = this.this$0.getSet$runtime();
            objArr = set$runtime.elements;
            jArr = set$runtime.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                scatterSetWrapper$iterator$1 = this;
                i = 0;
                j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                }
                if (i != length) {
                }
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i3 = this.I$3;
        int i4 = this.I$2;
        long j2 = this.J$0;
        i = this.I$1;
        int i5 = this.I$0;
        long[] jArr2 = (long[]) this.L$2;
        Object[] objArr2 = (Object[]) this.L$1;
        SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        SequenceScope sequenceScope3 = sequenceScope2;
        Object[] objArr3 = objArr2;
        ScatterSetWrapper$iterator$1<T> scatterSetWrapper$iterator$12 = this;
        ScatterSetWrapper$iterator$1<T> scatterSetWrapper$iterator$13 = scatterSetWrapper$iterator$12;
        long[] jArr3 = jArr2;
        ScatterSetWrapper$iterator$1<T> scatterSetWrapper$iterator$14 = scatterSetWrapper$iterator$13;
        j2 >>= 8;
        i3++;
        if (i3 < i4) {
            if (i4 == 8) {
                length = i5;
                scatterSetWrapper$iterator$1 = scatterSetWrapper$iterator$14;
                jArr = jArr3;
                objArr = objArr3;
                sequenceScope = sequenceScope3;
                if (i != length) {
                    i++;
                    j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        sequenceScope3 = sequenceScope;
                        i3 = 0;
                        jArr3 = jArr;
                        scatterSetWrapper$iterator$14 = scatterSetWrapper$iterator$1;
                        i4 = 8 - ((~(i - length)) >>> 31);
                        objArr3 = objArr;
                        i5 = length;
                        j2 = j;
                        if (i3 < i4) {
                            if ((255 & j2) < 128) {
                                if (1 != 0) {
                                    Object obj2 = objArr3[(i << 3) + i3];
                                    scatterSetWrapper$iterator$14.L$0 = sequenceScope3;
                                    scatterSetWrapper$iterator$14.L$1 = objArr3;
                                    scatterSetWrapper$iterator$14.L$2 = jArr3;
                                    scatterSetWrapper$iterator$14.I$0 = i5;
                                    scatterSetWrapper$iterator$14.I$1 = i;
                                    scatterSetWrapper$iterator$14.J$0 = j2;
                                    scatterSetWrapper$iterator$14.I$2 = i4;
                                    scatterSetWrapper$iterator$14.I$3 = i3;
                                    scatterSetWrapper$iterator$14.label = 1;
                                    if (sequenceScope3.yield(obj2, scatterSetWrapper$iterator$14) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    long[] jArr4 = jArr3;
                                    scatterSetWrapper$iterator$12 = scatterSetWrapper$iterator$14;
                                    jArr2 = jArr4;
                                    ScatterSetWrapper$iterator$1<T> scatterSetWrapper$iterator$132 = scatterSetWrapper$iterator$12;
                                    long[] jArr32 = jArr2;
                                    ScatterSetWrapper$iterator$1<T> scatterSetWrapper$iterator$142 = scatterSetWrapper$iterator$132;
                                }
                            }
                            j2 >>= 8;
                            i3++;
                            if (i3 < i4) {
                            }
                        }
                    }
                    if (i != length) {
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}

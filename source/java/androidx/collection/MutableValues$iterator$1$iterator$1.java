package androidx.collection;

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

/* compiled from: ScatterMap.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "K", "V", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableValues$iterator$1$iterator$1", f = "ScatterMap.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1696}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$1", "I$0", "I$1", "J$0", "I$2", "I$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class MutableValues$iterator$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MutableValues<K, V> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableValues$iterator$1$iterator$1(MutableValues<K, V> mutableValues, Continuation<? super MutableValues$iterator$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = mutableValues;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> mutableValues$iterator$1$iterator$1 = new MutableValues$iterator$1$iterator$1(this.this$0, continuation);
        mutableValues$iterator$1$iterator$1.L$0 = obj;
        return mutableValues$iterator$1$iterator$1;
    }

    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        if (0 != 0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0071  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x009d -> B:5:0x00a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0058 -> B:20:0x00b1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005a -> B:7:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        MutableScatterMap mutableScatterMap;
        long[] jArr;
        int length;
        MutableValues$iterator$1$iterator$1 mutableValues$iterator$1$iterator$1;
        int i;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            mutableScatterMap = ((MutableValues) this.this$0).parent;
            jArr = mutableScatterMap.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                mutableValues$iterator$1$iterator$1 = this;
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
        int i5 = this.I$1;
        int i6 = this.I$0;
        long[] jArr2 = (long[]) this.L$1;
        SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        SequenceScope sequenceScope3 = sequenceScope2;
        long[] jArr3 = jArr2;
        MutableValues$iterator$1$iterator$1 mutableValues$iterator$1$iterator$12 = this;
        MutableValues$iterator$1$iterator$1 mutableValues$iterator$1$iterator$13 = mutableValues$iterator$1$iterator$12;
        int i7 = i6;
        MutableValues$iterator$1$iterator$1 mutableValues$iterator$1$iterator$14 = mutableValues$iterator$1$iterator$13;
        j2 >>= 8;
        i3++;
        if (i3 < i4) {
            if (i4 == 8) {
                i = i5;
                mutableValues$iterator$1$iterator$1 = mutableValues$iterator$1$iterator$14;
                length = i7;
                jArr = jArr3;
                sequenceScope = sequenceScope3;
                if (i != length) {
                    i++;
                    j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        sequenceScope3 = sequenceScope;
                        i3 = 0;
                        jArr3 = jArr;
                        i4 = 8 - ((~(i - length)) >>> 31);
                        i7 = length;
                        mutableValues$iterator$1$iterator$14 = mutableValues$iterator$1$iterator$1;
                        i5 = i;
                        j2 = j;
                        if (i3 < i4) {
                            if ((255 & j2) < 128) {
                                if (1 != 0) {
                                    Integer boxInt = Boxing.boxInt((i5 << 3) + i3);
                                    mutableValues$iterator$1$iterator$14.L$0 = sequenceScope3;
                                    mutableValues$iterator$1$iterator$14.L$1 = jArr3;
                                    mutableValues$iterator$1$iterator$14.I$0 = i7;
                                    mutableValues$iterator$1$iterator$14.I$1 = i5;
                                    mutableValues$iterator$1$iterator$14.J$0 = j2;
                                    mutableValues$iterator$1$iterator$14.I$2 = i4;
                                    mutableValues$iterator$1$iterator$14.I$3 = i3;
                                    mutableValues$iterator$1$iterator$14.label = 1;
                                    if (sequenceScope3.yield(boxInt, mutableValues$iterator$1$iterator$14) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    int i8 = i7;
                                    mutableValues$iterator$1$iterator$12 = mutableValues$iterator$1$iterator$14;
                                    i6 = i8;
                                    MutableValues$iterator$1$iterator$1 mutableValues$iterator$1$iterator$132 = mutableValues$iterator$1$iterator$12;
                                    int i72 = i6;
                                    MutableValues$iterator$1$iterator$1 mutableValues$iterator$1$iterator$142 = mutableValues$iterator$1$iterator$132;
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

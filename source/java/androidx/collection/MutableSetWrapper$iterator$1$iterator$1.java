package androidx.collection;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ScatterSet.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1188}, m = "invokeSuspend", n = {"$this$iterator", "m$iv", "lastIndex$iv", "i$iv", "slot$iv", "bitCount$iv", "j$iv"}, s = {"L$0", "L$3", "I$0", "I$1", "J$0", "I$2", "I$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class MutableSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableSetWrapper<E> this$0;
    final /* synthetic */ MutableSetWrapper$iterator$1 this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableSetWrapper$iterator$1$iterator$1(MutableSetWrapper<E> mutableSetWrapper, MutableSetWrapper$iterator$1 mutableSetWrapper$iterator$1, Continuation<? super MutableSetWrapper$iterator$1$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = mutableSetWrapper;
        this.this$1 = mutableSetWrapper$iterator$1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> mutableSetWrapper$iterator$1$iterator$1 = new MutableSetWrapper$iterator$1$iterator$1<>(this.this$0, this.this$1, continuation);
        mutableSetWrapper$iterator$1$iterator$1.L$0 = obj;
        return mutableSetWrapper$iterator$1$iterator$1;
    }

    public final Object invoke(SequenceScope<? super E> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c7, code lost:
    
        if (0 != 0) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0082  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00bd -> B:5:0x00c1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0064 -> B:20:0x00d6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0066 -> B:7:0x0080). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        MutableScatterSet mutableScatterSet;
        MutableSetWrapper$iterator$1 mutableSetWrapper$iterator$1;
        MutableSetWrapper<E> mutableSetWrapper;
        long[] jArr;
        int length;
        MutableSetWrapper$iterator$1$iterator$1<E> mutableSetWrapper$iterator$1$iterator$1;
        int i;
        long j;
        MutableScatterSet mutableScatterSet2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        int i3 = 8;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            mutableScatterSet = ((MutableSetWrapper) this.this$0).parent;
            mutableSetWrapper$iterator$1 = this.this$1;
            mutableSetWrapper = this.this$0;
            jArr = mutableScatterSet.metadata;
            length = jArr.length - 2;
            if (length >= 0) {
                mutableSetWrapper$iterator$1$iterator$1 = this;
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
        int i4 = this.I$3;
        int i5 = this.I$2;
        long j2 = this.J$0;
        int i6 = this.I$1;
        int i7 = this.I$0;
        long[] jArr2 = (long[]) this.L$3;
        MutableSetWrapper<E> mutableSetWrapper2 = (MutableSetWrapper) this.L$2;
        MutableSetWrapper$iterator$1 mutableSetWrapper$iterator$12 = (MutableSetWrapper$iterator$1) this.L$1;
        SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        MutableSetWrapper$iterator$1$iterator$1<E> mutableSetWrapper$iterator$1$iterator$12 = this;
        SequenceScope sequenceScope3 = sequenceScope2;
        MutableSetWrapper$iterator$1 mutableSetWrapper$iterator$13 = mutableSetWrapper$iterator$12;
        MutableSetWrapper<E> mutableSetWrapper3 = mutableSetWrapper2;
        MutableSetWrapper$iterator$1$iterator$1<E> mutableSetWrapper$iterator$1$iterator$13 = mutableSetWrapper$iterator$1$iterator$12;
        i3 = 8;
        j2 >>= i3;
        i4++;
        if (i4 < i5) {
            if (i5 == i3) {
                jArr = jArr2;
                mutableSetWrapper$iterator$1$iterator$1 = mutableSetWrapper$iterator$1$iterator$13;
                mutableSetWrapper = mutableSetWrapper3;
                mutableSetWrapper$iterator$1 = mutableSetWrapper$iterator$13;
                sequenceScope = sequenceScope3;
                int i8 = i7;
                i = i6;
                length = i8;
                if (i != length) {
                    i++;
                    j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        sequenceScope3 = sequenceScope;
                        i4 = 0;
                        MutableSetWrapper$iterator$1$iterator$1<E> mutableSetWrapper$iterator$1$iterator$14 = mutableSetWrapper$iterator$1$iterator$1;
                        jArr2 = jArr;
                        i5 = 8 - ((~(i - length)) >>> 31);
                        mutableSetWrapper$iterator$13 = mutableSetWrapper$iterator$1;
                        mutableSetWrapper3 = mutableSetWrapper;
                        mutableSetWrapper$iterator$1$iterator$13 = mutableSetWrapper$iterator$1$iterator$14;
                        j2 = j;
                        int i9 = i;
                        i7 = length;
                        i6 = i9;
                        if (i4 < i5) {
                            if ((j2 & 255) < 128) {
                                if (1 != 0) {
                                    int i10 = (i6 << 3) + i4;
                                    mutableSetWrapper$iterator$13.setCurrent(i10);
                                    mutableScatterSet2 = ((MutableSetWrapper) mutableSetWrapper3).parent;
                                    Object obj2 = mutableScatterSet2.elements[i10];
                                    mutableSetWrapper$iterator$1$iterator$13.L$0 = sequenceScope3;
                                    mutableSetWrapper$iterator$1$iterator$13.L$1 = mutableSetWrapper$iterator$13;
                                    mutableSetWrapper$iterator$1$iterator$13.L$2 = mutableSetWrapper3;
                                    mutableSetWrapper$iterator$1$iterator$13.L$3 = jArr2;
                                    mutableSetWrapper$iterator$1$iterator$13.I$0 = i7;
                                    mutableSetWrapper$iterator$1$iterator$13.I$1 = i6;
                                    mutableSetWrapper$iterator$1$iterator$13.J$0 = j2;
                                    mutableSetWrapper$iterator$1$iterator$13.I$2 = i5;
                                    mutableSetWrapper$iterator$1$iterator$13.I$3 = i4;
                                    mutableSetWrapper$iterator$1$iterator$13.label = 1;
                                    if (sequenceScope3.yield(obj2, mutableSetWrapper$iterator$1$iterator$13) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    mutableSetWrapper$iterator$1$iterator$12 = mutableSetWrapper$iterator$1$iterator$13;
                                    mutableSetWrapper2 = mutableSetWrapper3;
                                    mutableSetWrapper$iterator$12 = mutableSetWrapper$iterator$13;
                                    sequenceScope2 = sequenceScope3;
                                    SequenceScope sequenceScope32 = sequenceScope2;
                                    MutableSetWrapper$iterator$1 mutableSetWrapper$iterator$132 = mutableSetWrapper$iterator$12;
                                    MutableSetWrapper<E> mutableSetWrapper32 = mutableSetWrapper2;
                                    MutableSetWrapper$iterator$1$iterator$1<E> mutableSetWrapper$iterator$1$iterator$132 = mutableSetWrapper$iterator$1$iterator$12;
                                    i3 = 8;
                                }
                            }
                            j2 >>= i3;
                            i4++;
                            if (i4 < i5) {
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

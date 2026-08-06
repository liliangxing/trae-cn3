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

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: OrderedScatterSet.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "androidx.collection.OrderedSetWrapper$iterator$1", f = "OrderedScatterSet.kt", i = {0, 0, 0, 0}, l = {1454}, m = "invokeSuspend", n = {"$this$iterator", "elements$iv", "nodes$iv", "previousNode$iv"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class OrderedSetWrapper$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ OrderedSetWrapper<E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderedSetWrapper$iterator$1(OrderedSetWrapper<E> orderedSetWrapper, Continuation<? super OrderedSetWrapper$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = orderedSetWrapper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> orderedSetWrapper$iterator$1 = new OrderedSetWrapper$iterator$1<>(this.this$0, continuation);
        orderedSetWrapper$iterator$1.L$0 = obj;
        return orderedSetWrapper$iterator$1;
    }

    public final Object invoke(SequenceScope<? super E> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        OrderedScatterSet orderedScatterSet;
        int i;
        SequenceScope sequenceScope;
        OrderedSetWrapper$iterator$1<E> orderedSetWrapper$iterator$1;
        Object[] objArr;
        long[] jArr;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            orderedScatterSet = ((OrderedSetWrapper) this.this$0).parent;
            Object[] objArr2 = orderedScatterSet.elements;
            long[] jArr2 = orderedScatterSet.nodes;
            i = orderedScatterSet.tail;
            sequenceScope = sequenceScope2;
            orderedSetWrapper$iterator$1 = this;
            objArr = objArr2;
            jArr = jArr2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            jArr = (long[]) this.L$2;
            objArr = (Object[]) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            orderedSetWrapper$iterator$1 = this;
        }
        while (i != Integer.MAX_VALUE) {
            int i3 = (int) ((jArr[i] >> 31) & SieveCacheKt.NodeLinkMask);
            Object obj2 = objArr[i];
            orderedSetWrapper$iterator$1.L$0 = sequenceScope;
            orderedSetWrapper$iterator$1.L$1 = objArr;
            orderedSetWrapper$iterator$1.L$2 = jArr;
            orderedSetWrapper$iterator$1.I$0 = i3;
            orderedSetWrapper$iterator$1.label = 1;
            if (sequenceScope.yield(obj2, orderedSetWrapper$iterator$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i3;
        }
        return Unit.INSTANCE;
    }
}

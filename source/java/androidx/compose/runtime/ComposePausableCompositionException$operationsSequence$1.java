package androidx.compose.runtime;

import androidx.collection.IntList;
import androidx.collection.ObjectList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PausableComposition.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.ComposePausableCompositionException$operationsSequence$1", f = "PausableComposition.kt", i = {0, 0, 0, 0}, l = {554}, m = "invokeSuspend", n = {"$this$sequence", "currentOperation", "currentInstance", "currentReused"}, s = {"L$0", "I$0", "I$1", "I$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ComposePausableCompositionException$operationsSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ComposePausableCompositionException this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposePausableCompositionException$operationsSequence$1(ComposePausableCompositionException composePausableCompositionException, Continuation<? super ComposePausableCompositionException$operationsSequence$1> continuation) {
        super(2, continuation);
        this.this$0 = composePausableCompositionException;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> composePausableCompositionException$operationsSequence$1 = new ComposePausableCompositionException$operationsSequence$1(this.this$0, continuation);
        composePausableCompositionException$operationsSequence$1.L$0 = obj;
        return composePausableCompositionException$operationsSequence$1;
    }

    public final Object invoke(SequenceScope<? super String> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0053. Please report as an issue. */
    /* JADX WARN: Incorrect condition in loop: B:7:0x0043 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        ComposePausableCompositionException$operationsSequence$1 composePausableCompositionException$operationsSequence$1;
        SequenceScope sequenceScope;
        int i2;
        int i3;
        int i4;
        IntList intList;
        IntList intList2;
        String str;
        ObjectList objectList;
        IntList intList3;
        IntList intList4;
        IntList intList5;
        IntList intList6;
        IntList intList7;
        IntList intList8;
        int i5;
        ObjectList objectList2;
        int i6;
        String str2;
        IntList intList9;
        ObjectList objectList3;
        ObjectList objectList4;
        ObjectList objectList5;
        ObjectList objectList6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = this.label;
        if (i7 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            composePausableCompositionException$operationsSequence$1 = this;
            sequenceScope = (SequenceScope) this.L$0;
            i2 = 0;
            i3 = 0;
        } else {
            if (i7 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i8 = this.I$2;
            int i9 = this.I$1;
            int i10 = this.I$0;
            sequenceScope = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i2 = i9;
            i3 = i8;
            i = i10;
            composePausableCompositionException$operationsSequence$1 = this;
        }
        while (i < Math.min(i4, intList._size)) {
            intList2 = composePausableCompositionException$operationsSequence$1.this$0.operations;
            int i11 = i + 1;
            int i12 = intList2.get(i);
            switch (i12) {
                case 0:
                    str = "up";
                    break;
                case 1:
                    objectList = composePausableCompositionException$operationsSequence$1.this$0.instances;
                    str = "down " + objectList.get(i2);
                    i2++;
                    break;
                case 2:
                    intList3 = composePausableCompositionException$operationsSequence$1.this$0.operations;
                    int i13 = i11 + 1;
                    int i14 = intList3.get(i11);
                    intList4 = composePausableCompositionException$operationsSequence$1.this$0.operations;
                    str = "remove " + i14 + ' ' + intList4.get(i13);
                    i11 = i13 + 1;
                    break;
                case 3:
                    intList5 = composePausableCompositionException$operationsSequence$1.this$0.operations;
                    int i15 = i11 + 1;
                    int i16 = intList5.get(i11);
                    intList6 = composePausableCompositionException$operationsSequence$1.this$0.operations;
                    int i17 = i15 + 1;
                    int i18 = intList6.get(i15);
                    intList7 = composePausableCompositionException$operationsSequence$1.this$0.operations;
                    str = "move " + i16 + ' ' + i18 + ' ' + intList7.get(i17);
                    i11 = i17 + 1;
                    break;
                case 4:
                    str = "clear";
                    break;
                case 5:
                    intList8 = composePausableCompositionException$operationsSequence$1.this$0.operations;
                    i5 = i11 + 1;
                    int i19 = intList8.get(i11);
                    objectList2 = composePausableCompositionException$operationsSequence$1.this$0.instances;
                    i6 = i2 + 1;
                    str2 = "insertBottomUp " + i19 + ' ' + objectList2.get(i2);
                    str = str2;
                    i11 = i5;
                    i2 = i6;
                    break;
                case 6:
                    intList9 = composePausableCompositionException$operationsSequence$1.this$0.operations;
                    i5 = i11 + 1;
                    int i20 = intList9.get(i11);
                    objectList3 = composePausableCompositionException$operationsSequence$1.this$0.instances;
                    i6 = i2 + 1;
                    str2 = "insertTopDown " + i20 + ' ' + objectList3.get(i2);
                    str = str2;
                    i11 = i5;
                    i2 = i6;
                    break;
                case 7:
                    objectList4 = composePausableCompositionException$operationsSequence$1.this$0.instances;
                    int i21 = i2 + 1;
                    Object obj2 = objectList4.get(i2);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
                    Function2 function2 = (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj2, 2);
                    objectList5 = composePausableCompositionException$operationsSequence$1.this$0.instances;
                    i6 = i21 + 1;
                    str = "apply " + function2 + ' ' + objectList5.get(i21);
                    i2 = i6;
                    break;
                case 8:
                    StringBuilder sb = new StringBuilder("reuse ");
                    objectList6 = composePausableCompositionException$operationsSequence$1.this$0.reused;
                    str = sb.append(objectList6.get(i3)).toString();
                    i3++;
                    break;
                default:
                    str = "unknown op: " + i12;
                    break;
            }
            composePausableCompositionException$operationsSequence$1.L$0 = sequenceScope;
            composePausableCompositionException$operationsSequence$1.I$0 = i11;
            composePausableCompositionException$operationsSequence$1.I$1 = i2;
            composePausableCompositionException$operationsSequence$1.I$2 = i3;
            composePausableCompositionException$operationsSequence$1.label = 1;
            if (sequenceScope.yield(i + ": " + str, (Continuation) composePausableCompositionException$operationsSequence$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i11;
        }
        return Unit.INSTANCE;
    }
}

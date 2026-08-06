package com.github.alexzhirkevich.customqrgenerator;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: QrCodeGenerator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.ThreadPolicy$DoubleThread$invoke$2$1$1", f = "QrCodeGenerator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class ThreadPolicy$DoubleThread$invoke$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<IntRange, IntRange, Unit> $block;
    final /* synthetic */ Pair<IntRange, IntRange> $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadPolicy$DoubleThread$invoke$2$1$1(Function2<? super IntRange, ? super IntRange, Unit> function2, Pair<IntRange, IntRange> pair, Continuation<? super ThreadPolicy$DoubleThread$invoke$2$1$1> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$it = pair;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThreadPolicy$DoubleThread$invoke$2$1$1(this.$block, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$block.invoke(this.$it.getFirst(), this.$it.getSecond());
        return Unit.INSTANCE;
    }
}

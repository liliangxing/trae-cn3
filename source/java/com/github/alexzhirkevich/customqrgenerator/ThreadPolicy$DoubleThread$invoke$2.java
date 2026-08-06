package com.github.alexzhirkevich.customqrgenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: QrCodeGenerator.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.github.alexzhirkevich.customqrgenerator.ThreadPolicy$DoubleThread$invoke$2", f = "QrCodeGenerator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class ThreadPolicy$DoubleThread$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Job>>, Object> {
    final /* synthetic */ Function2<IntRange, IntRange, Unit> $block;
    final /* synthetic */ int $height;
    final /* synthetic */ int $width;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadPolicy$DoubleThread$invoke$2(int i, int i2, Function2<? super IntRange, ? super IntRange, Unit> function2, Continuation<? super ThreadPolicy$DoubleThread$invoke$2> continuation) {
        super(2, continuation);
        this.$width = i;
        this.$height = i2;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> threadPolicy$DoubleThread$invoke$2 = new ThreadPolicy$DoubleThread$invoke$2(this.$width, this.$height, this.$block, continuation);
        threadPolicy$DoubleThread$invoke$2.L$0 = obj;
        return threadPolicy$DoubleThread$invoke$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Job>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntRange until = RangesKt.until(0, this.$width);
            int i = this.$height;
            List listOf = CollectionsKt.listOf(new Pair[]{TuplesKt.to(RangesKt.until(0, this.$width), RangesKt.until(0, this.$height / 2)), TuplesKt.to(until, RangesKt.until(i / 2, i))});
            Function2<IntRange, IntRange, Unit> function2 = this.$block;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                arrayList.add(BuildersKt.launch$default(coroutineScope, Dispatchers.getDefault(), (CoroutineStart) null, new ThreadPolicy$DoubleThread$invoke$2$1$1(function2, (Pair) it.next(), null), 2, (Object) null));
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

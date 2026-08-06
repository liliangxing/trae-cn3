package com.bytedance.kmp.image.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: AsyncCache.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "V", "K", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.image.utils.AsyncCache$getOrLoad$2$deferred$1$1", f = "AsyncCache.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class AsyncCache$getOrLoad$2$deferred$1$1<V> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super V>, Object> {
    final /* synthetic */ Function1<Continuation<? super V>, Object> $load;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncCache$getOrLoad$2$deferred$1$1(Function1<? super Continuation<? super V>, ? extends Object> function1, Continuation<? super AsyncCache$getOrLoad$2$deferred$1$1> continuation) {
        super(2, continuation);
        this.$load = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncCache$getOrLoad$2$deferred$1$1<>(this.$load, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super V> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super V>, Object> function1 = this.$load;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}

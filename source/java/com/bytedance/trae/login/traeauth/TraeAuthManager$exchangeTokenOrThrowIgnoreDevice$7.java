package com.bytedance.trae.login.traeauth;

import com.bytedance.trae.login.traeauth.TraeAuthManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7", f = "TraeAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TraeAuthManager.TraeAuthCallback $callback;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7(TraeAuthManager.TraeAuthCallback traeAuthCallback, Continuation<? super TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7> continuation) {
        super(2, continuation);
        this.$callback = traeAuthCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TraeAuthManager$exchangeTokenOrThrowIgnoreDevice$7(this.$callback, continuation);
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
        TraeAuthManager.TraeAuthCallback traeAuthCallback = this.$callback;
        if (traeAuthCallback == null) {
            return null;
        }
        traeAuthCallback.onSuccess();
        return Unit.INSTANCE;
    }
}

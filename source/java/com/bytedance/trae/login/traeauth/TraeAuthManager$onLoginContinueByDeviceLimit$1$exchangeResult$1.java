package com.bytedance.trae.login.traeauth;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1", f = "TraeAuthManager.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1 extends SuspendLambda implements Function1<Continuation<? super TraeExchangeTokenResult>, Object> {
    final /* synthetic */ TraeGetRefreshTokenResult $refreshResult;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1(TraeGetRefreshTokenResult traeGetRefreshTokenResult, Continuation<? super TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1> continuation) {
        super(1, continuation);
        this.$refreshResult = traeGetRefreshTokenResult;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TraeAuthManager$onLoginContinueByDeviceLimit$1$exchangeResult$1(this.$refreshResult, continuation);
    }

    public final Object invoke(Continuation<? super TraeExchangeTokenResult> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TraeAuthManager traeAuthManager = TraeAuthManager.INSTANCE;
            String refreshToken = this.$refreshResult.getRefreshToken();
            Intrinsics.checkNotNull(refreshToken);
            this.label = 1;
            obj = traeAuthManager.doExchangeTokenOrThrow(refreshToken, (Continuation) this);
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

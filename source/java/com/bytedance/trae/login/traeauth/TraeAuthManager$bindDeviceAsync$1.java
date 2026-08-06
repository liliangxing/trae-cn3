package com.bytedance.trae.login.traeauth;

import com.bytedance.trae.utils.logger.FLogger;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.TraeAuthManager$bindDeviceAsync$1", f = "TraeAuthManager.kt", i = {}, l = {1295}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthManager$bindDeviceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<BindDeviceResult, Unit> $onResult;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TraeAuthManager$bindDeviceAsync$1(Function1<? super BindDeviceResult, Unit> function1, Continuation<? super TraeAuthManager$bindDeviceAsync$1> continuation) {
        super(2, continuation);
        this.$onResult = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TraeAuthManager$bindDeviceAsync$1(this.$onResult, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String refreshToken = TraeAuthStorage.INSTANCE.getRefreshToken();
                if (refreshToken.length() == 0) {
                    FLogger.INSTANCE.mo430w("TraeAuthManager", "bindDeviceAsync: no refresh token, skip");
                    return Unit.INSTANCE;
                }
                this.label = 1;
                obj = TraeAuthManager.bindDevice$default(TraeAuthManager.INSTANCE, refreshToken, TraeAuthDeviceManager.INSTANCE.getDeviceInfo(), null, (Continuation) this, 4, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BindDeviceResult bindDeviceResult = (BindDeviceResult) obj;
            FLogger.INSTANCE.mo428i("TraeAuthManager", "bindDeviceAsync: success, boundDeviceId=" + bindDeviceResult.getBoundDeviceId() + ", status=" + bindDeviceResult.getDeviceBindStatus());
            Function1<BindDeviceResult, Unit> function1 = this.$onResult;
            if (function1 != null) {
                function1.invoke(bindDeviceResult);
            }
        } catch (TraeAuthException e) {
            FLogger.INSTANCE.mo426e("TraeAuthManager", "bindDeviceAsync failed: [" + e.getCode() + "] " + e.getMessage());
        } catch (Exception e2) {
            FLogger.INSTANCE.mo426e("TraeAuthManager", "bindDeviceAsync unexpected error: " + e2.getMessage());
        }
        return Unit.INSTANCE;
    }
}

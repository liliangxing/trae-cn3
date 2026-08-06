package com.bytedance.kmp.network;

import com.bytedance.kmp.network.requet.Request;
import com.bytedance.kmp.network.response.ResponseCallback;
import com.bytedance.ug.sdk.share.api.entity.ToastCode;
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
/* compiled from: KmpNetworkManagerImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.KmpNetworkManagerImpl$executeStream$2", f = "KmpNetworkManagerImpl.kt", i = {}, l = {ToastCode.VK_NOT_INSTALL, 230}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpNetworkManagerImpl$executeStream$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResponseCallback $callback;
    final /* synthetic */ Request $request;
    int label;
    final /* synthetic */ KmpNetworkManagerImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KmpNetworkManagerImpl$executeStream$2(KmpNetworkManagerImpl kmpNetworkManagerImpl, Request request, ResponseCallback responseCallback, Continuation<? super KmpNetworkManagerImpl$executeStream$2> continuation) {
        super(2, continuation);
        this.this$0 = kmpNetworkManagerImpl;
        this.$request = request;
        this.$callback = responseCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KmpNetworkManagerImpl$executeStream$2(this.this$0, this.$request, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IKmpNetworkService iKmpNetworkService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.preprocessRequest(this.$request, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 kmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 = new KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1(this.$callback, this.this$0);
        iKmpNetworkService = this.this$0.service;
        this.label = 2;
        if (iKmpNetworkService.executeStream((Request) obj, kmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}

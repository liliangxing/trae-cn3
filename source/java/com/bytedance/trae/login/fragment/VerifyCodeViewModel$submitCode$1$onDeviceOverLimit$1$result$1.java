package com.bytedance.trae.login.fragment;

import com.bytedance.trae.login.traeauth.ListDevicesResult;
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

/* compiled from: VerifyCodeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/login/traeauth/ListDevicesResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.fragment.VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1$result$1", f = "VerifyCodeViewModel.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListDevicesResult>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1$result$1(Continuation<? super VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1$result$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1$result$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListDevicesResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = TraeAuthManager.INSTANCE.listDevices((Continuation) this);
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

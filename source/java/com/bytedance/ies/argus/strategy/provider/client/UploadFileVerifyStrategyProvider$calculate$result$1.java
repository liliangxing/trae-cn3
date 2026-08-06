package com.bytedance.ies.argus.strategy.provider.client;

import android.app.Application;
import com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UploadFileVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/ies/argus/strategy/provider/client/UploadFileVerifyStrategyProvider$DetectResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider$calculate$result$1", f = "UploadFileVerifyStrategyProvider.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class UploadFileVerifyStrategyProvider$calculate$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UploadFileVerifyStrategyProvider.DetectResult>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ UploadFileVerifyStrategyProvider.Detector $detector;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadFileVerifyStrategyProvider$calculate$result$1(UploadFileVerifyStrategyProvider.Detector detector, Application application, Continuation<? super UploadFileVerifyStrategyProvider$calculate$result$1> continuation) {
        super(2, continuation);
        this.$detector = detector;
        this.$application = application;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadFileVerifyStrategyProvider$calculate$result$1(this.$detector, this.$application, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UploadFileVerifyStrategyProvider.DetectResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.$detector.detectFile(this.$application, (Continuation) this);
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

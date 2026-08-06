package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ConfirmTaskRequest;
import com.bytedance.trae.im.service.ConfirmTaskResponse;
import com.bytedance.trae.im.service.IConfirmTaskApi;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: QueuingBannerView.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ConfirmTaskResponse;", "Lcom/bytedance/trae/im/service/IConfirmTaskApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$useFastRequest$1$result$1", f = "QueuingBannerView.kt", i = {}, l = {325}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class QueuingBannerView$useFastRequest$1$result$1 extends SuspendLambda implements Function2<IConfirmTaskApi, Continuation<? super BizResponse<ConfirmTaskResponse>>, Object> {
    final /* synthetic */ ConfirmTaskRequest $request;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueuingBannerView$useFastRequest$1$result$1(ConfirmTaskRequest confirmTaskRequest, Continuation<? super QueuingBannerView$useFastRequest$1$result$1> continuation) {
        super(2, continuation);
        this.$request = confirmTaskRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> queuingBannerView$useFastRequest$1$result$1 = new QueuingBannerView$useFastRequest$1$result$1(this.$request, continuation);
        queuingBannerView$useFastRequest$1$result$1.L$0 = obj;
        return queuingBannerView$useFastRequest$1$result$1;
    }

    public final Object invoke(IConfirmTaskApi iConfirmTaskApi, Continuation<? super BizResponse<ConfirmTaskResponse>> continuation) {
        return create(iConfirmTaskApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IConfirmTaskApi) this.L$0).confirmTask(this.$request, (Continuation) this);
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

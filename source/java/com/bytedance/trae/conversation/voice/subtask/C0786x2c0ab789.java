package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ISubTaskResultApi;
import com.bytedance.trae.im.service.SubTaskResultRequest;
import com.bytedance.trae.im.service.SubTaskResultResponse;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/SubTaskResultResponse;", "Lcom/bytedance/trae/im/service/ISubTaskResultApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1$httpResult$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {2685}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$postSubTaskResultOnceAsync$1$httpResult$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class C0786x2c0ab789 extends SuspendLambda implements Function2<ISubTaskResultApi, Continuation<? super BizResponse<SubTaskResultResponse>>, Object> {
    final /* synthetic */ SubTaskResultRequest $request;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0786x2c0ab789(SubTaskResultRequest subTaskResultRequest, Continuation<? super C0786x2c0ab789> continuation) {
        super(2, continuation);
        this.$request = subTaskResultRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0786x2c0ab789 = new C0786x2c0ab789(this.$request, continuation);
        c0786x2c0ab789.L$0 = obj;
        return c0786x2c0ab789;
    }

    public final Object invoke(ISubTaskResultApi iSubTaskResultApi, Continuation<? super BizResponse<SubTaskResultResponse>> continuation) {
        return create(iSubTaskResultApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((ISubTaskResultApi) this.L$0).postSubTaskResult(this.$request, (Continuation) this);
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

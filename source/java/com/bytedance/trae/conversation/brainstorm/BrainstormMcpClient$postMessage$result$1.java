package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ISendMessageService;
import com.bytedance.trae.im.service.SendMessageRequest;
import com.bytedance.trae.im.service.SendMessageResponse;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: BrainstormMcpClient.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/SendMessageResponse;", "Lcom/bytedance/trae/im/service/ISendMessageService;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormMcpClient$postMessage$result$1", f = "BrainstormMcpClient.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class BrainstormMcpClient$postMessage$result$1 extends SuspendLambda implements Function2<ISendMessageService, Continuation<? super BizResponse<SendMessageResponse>>, Object> {
    final /* synthetic */ String $query;
    final /* synthetic */ String $sessionId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormMcpClient$postMessage$result$1(String str, String str2, Continuation<? super BrainstormMcpClient$postMessage$result$1> continuation) {
        super(2, continuation);
        this.$sessionId = str;
        this.$query = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> brainstormMcpClient$postMessage$result$1 = new BrainstormMcpClient$postMessage$result$1(this.$sessionId, this.$query, continuation);
        brainstormMcpClient$postMessage$result$1.L$0 = obj;
        return brainstormMcpClient$postMessage$result$1;
    }

    public final Object invoke(ISendMessageService iSendMessageService, Continuation<? super BizResponse<SendMessageResponse>> continuation) {
        return create(iSendMessageService, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((ISendMessageService) this.L$0).sendMessage(this.$sessionId, new SendMessageRequest(null, this.$query, null, "solo_work_remote", null, 21, null), (Continuation) this);
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

package com.bytedance.trae.im.service;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: IMService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/ListEventsResponse;", "Lcom/bytedance/trae/im/service/IListEventsService;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.IMService$triggerFetchEvents$1$result$1", f = "IMService.kt", i = {}, l = {486}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class IMService$triggerFetchEvents$1$result$1 extends SuspendLambda implements Function2<IListEventsService, Continuation<? super BizResponse<ListEventsResponse>>, Object> {
    final /* synthetic */ Ref.IntRef $fromSeqNum;
    final /* synthetic */ String $taskId;
    final /* synthetic */ int $toSeqNum;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMService$triggerFetchEvents$1$result$1(String str, int i, Ref.IntRef intRef, Continuation<? super IMService$triggerFetchEvents$1$result$1> continuation) {
        super(2, continuation);
        this.$taskId = str;
        this.$toSeqNum = i;
        this.$fromSeqNum = intRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iMService$triggerFetchEvents$1$result$1 = new IMService$triggerFetchEvents$1$result$1(this.$taskId, this.$toSeqNum, this.$fromSeqNum, continuation);
        iMService$triggerFetchEvents$1$result$1.L$0 = obj;
        return iMService$triggerFetchEvents$1$result$1;
    }

    public final Object invoke(IListEventsService iListEventsService, Continuation<? super BizResponse<ListEventsResponse>> continuation) {
        return create(iListEventsService, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IListEventsService) this.L$0).listEvents(this.$taskId, Boxing.boxInt(this.$toSeqNum), Boxing.boxInt(this.$fromSeqNum.element), 52428800, (Continuation) this);
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

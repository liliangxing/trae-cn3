package com.bytedance.trae.network;

import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: HubNetFallbackApi.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/network/FallbackPollResponse;", "Lcom/bytedance/trae/network/HubNetFallbackApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetFallbackApi$Companion$pollRawCall$2", f = "HubNetFallbackApi.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class HubNetFallbackApi$Companion$pollRawCall$2 extends SuspendLambda implements Function2<HubNetFallbackApi, Continuation<? super BizResponse<FallbackPollResponse>>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ Long $fromDownSeqId;
    final /* synthetic */ long $frontierId;
    final /* synthetic */ Integer $limit;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetFallbackApi$Companion$pollRawCall$2(long j, String str, Long l, Integer num, Continuation<? super HubNetFallbackApi$Companion$pollRawCall$2> continuation) {
        super(2, continuation);
        this.$frontierId = j;
        this.$deviceId = str;
        this.$fromDownSeqId = l;
        this.$limit = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hubNetFallbackApi$Companion$pollRawCall$2 = new HubNetFallbackApi$Companion$pollRawCall$2(this.$frontierId, this.$deviceId, this.$fromDownSeqId, this.$limit, continuation);
        hubNetFallbackApi$Companion$pollRawCall$2.L$0 = obj;
        return hubNetFallbackApi$Companion$pollRawCall$2;
    }

    public final Object invoke(HubNetFallbackApi hubNetFallbackApi, Continuation<? super BizResponse<FallbackPollResponse>> continuation) {
        return create(hubNetFallbackApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((HubNetFallbackApi) this.L$0).poll(this.$frontierId, this.$deviceId, this.$fromDownSeqId, this.$limit, 52428800, (Continuation) this);
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

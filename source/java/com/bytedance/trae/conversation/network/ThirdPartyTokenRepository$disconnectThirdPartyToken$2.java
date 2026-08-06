package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.SsResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/network/ThirdPartyTokenEnvelope;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.ThirdPartyTokenRepository$disconnectThirdPartyToken$2", f = "ThirdPartyTokenRepository.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ThirdPartyTokenRepository$disconnectThirdPartyToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ThirdPartyTokenEnvelope>, Object> {
    final /* synthetic */ String $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartyTokenRepository$disconnectThirdPartyToken$2(String str, Continuation<? super ThirdPartyTokenRepository$disconnectThirdPartyToken$2> continuation) {
        super(2, continuation);
        this.$type = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThirdPartyTokenRepository$disconnectThirdPartyToken$2(this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ThirdPartyTokenEnvelope> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IThirdPartyTokenApi createService;
        ThirdPartyTokenEnvelope parseEnvelopeOrThrow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            createService = ThirdPartyTokenRepository.INSTANCE.createService();
            this.label = 1;
            obj = createService.disconnectThirdPartyToken(new DisconnectThirdPartyTokenRequest(this.$type), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        parseEnvelopeOrThrow = ThirdPartyTokenRepository.INSTANCE.parseEnvelopeOrThrow((SsResponse) obj);
        return parseEnvelopeOrThrow;
    }
}

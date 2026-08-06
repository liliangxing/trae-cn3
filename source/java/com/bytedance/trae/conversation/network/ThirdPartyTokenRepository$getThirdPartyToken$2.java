package com.bytedance.trae.conversation.network;

import com.bytedance.retrofit2.SsResponse;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.ThirdPartyTokenRepository$getThirdPartyToken$2", f = "ThirdPartyTokenRepository.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThirdPartyTokenRepository$getThirdPartyToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartyTokenRepository$getThirdPartyToken$2(String str, Continuation<? super ThirdPartyTokenRepository$getThirdPartyToken$2> continuation) {
        super(2, continuation);
        this.$type = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThirdPartyTokenRepository$getThirdPartyToken$2(this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IThirdPartyTokenApi createService;
        ThirdPartyTokenEnvelope parseEnvelopeOrThrow;
        Object obj2;
        String accessToken;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            createService = ThirdPartyTokenRepository.INSTANCE.createService();
            this.label = 1;
            obj = createService.getThirdPartyToken(new GetThirdPartyTokenRequest(CollectionsKt.listOf(this.$type)), (Continuation) this);
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
        List<ThirdPartyTokenResult> result = parseEnvelopeOrThrow.getResult();
        if (result == null) {
            return null;
        }
        String str = this.$type;
        Iterator<T> it = result.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (StringsKt.equals(((ThirdPartyTokenResult) obj2).getType(), str, true)) {
                break;
            }
        }
        ThirdPartyTokenResult thirdPartyTokenResult = (ThirdPartyTokenResult) obj2;
        if (thirdPartyTokenResult == null || (accessToken = thirdPartyTokenResult.getAccessToken()) == null || !(!StringsKt.isBlank(accessToken))) {
            return null;
        }
        return accessToken;
    }
}

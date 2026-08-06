package com.bytedance.trae.conversation.git;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.conversation.network.IGithubAccessApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThirdPartyTokenClient.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.ThirdPartyTokenClient$disconnectThirdPartyToken$2", f = "ThirdPartyTokenClient.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThirdPartyTokenClient$disconnectThirdPartyToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ ThirdPartyTokenClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartyTokenClient$disconnectThirdPartyToken$2(ThirdPartyTokenClient thirdPartyTokenClient, String str, Continuation<? super ThirdPartyTokenClient$disconnectThirdPartyToken$2> continuation) {
        super(2, continuation);
        this.this$0 = thirdPartyTokenClient;
        this.$type = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ThirdPartyTokenClient$disconnectThirdPartyToken$2(this.this$0, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super JSONObject> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        JSONObject parseTraeEnvelopeOrThrow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IGithubAccessApi.INSTANCE.safeCallPost(new ThirdPartyTokenClient$disconnectThirdPartyToken$2$response$1(this.$type, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        parseTraeEnvelopeOrThrow = this.this$0.parseTraeEnvelopeOrThrow((SsResponse) obj);
        return parseTraeEnvelopeOrThrow;
    }
}

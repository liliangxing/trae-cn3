package com.bytedance.trae.conversation.git;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.conversation.network.GetThirdPartyTokenRequest;
import com.bytedance.trae.conversation.network.IGithubAccessApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ThirdPartyTokenClient.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/retrofit2/SsResponse;", "", "Lcom/bytedance/trae/conversation/network/IGithubAccessApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.ThirdPartyTokenClient$getThirdPartyToken$2$response$1", f = "ThirdPartyTokenClient.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ThirdPartyTokenClient$getThirdPartyToken$2$response$1 extends SuspendLambda implements Function2<IGithubAccessApi, Continuation<? super SsResponse<String>>, Object> {
    final /* synthetic */ String $type;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartyTokenClient$getThirdPartyToken$2$response$1(String str, Continuation<? super ThirdPartyTokenClient$getThirdPartyToken$2$response$1> continuation) {
        super(2, continuation);
        this.$type = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> thirdPartyTokenClient$getThirdPartyToken$2$response$1 = new ThirdPartyTokenClient$getThirdPartyToken$2$response$1(this.$type, continuation);
        thirdPartyTokenClient$getThirdPartyToken$2$response$1.L$0 = obj;
        return thirdPartyTokenClient$getThirdPartyToken$2$response$1;
    }

    public final Object invoke(IGithubAccessApi iGithubAccessApi, Continuation<? super SsResponse<String>> continuation) {
        return create(iGithubAccessApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IGithubAccessApi) this.L$0).getThirdPartyToken(new GetThirdPartyTokenRequest(CollectionsKt.listOf(this.$type)), (Continuation) this);
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

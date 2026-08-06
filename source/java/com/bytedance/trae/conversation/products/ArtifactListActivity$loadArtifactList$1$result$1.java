package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.network.response.BizResponse;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ArtifactListActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/conversation/products/GetArtifactListData;", "Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactListActivity$loadArtifactList$1$result$1", f = "ArtifactListActivity.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ArtifactListActivity$loadArtifactList$1$result$1 extends SuspendLambda implements Function2<IGetArtifactListApi, Continuation<? super BizResponse<GetArtifactListData>>, Object> {
    final /* synthetic */ String $conversationId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactListActivity$loadArtifactList$1$result$1(String str, Continuation<? super ArtifactListActivity$loadArtifactList$1$result$1> continuation) {
        super(2, continuation);
        this.$conversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> artifactListActivity$loadArtifactList$1$result$1 = new ArtifactListActivity$loadArtifactList$1$result$1(this.$conversationId, continuation);
        artifactListActivity$loadArtifactList$1$result$1.L$0 = obj;
        return artifactListActivity$loadArtifactList$1$result$1;
    }

    public final Object invoke(IGetArtifactListApi iGetArtifactListApi, Continuation<? super BizResponse<GetArtifactListData>> continuation) {
        return create(iGetArtifactListApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IGetArtifactListApi iGetArtifactListApi = (IGetArtifactListApi) this.L$0;
            Pair[] pairArr = {TuplesKt.to("conversation_id", this.$conversationId), TuplesKt.to("check_exist", "true")};
            this.label = 1;
            obj = iGetArtifactListApi.getArtifactList(MapsKt.mapOf(pairArr), (Continuation) this);
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

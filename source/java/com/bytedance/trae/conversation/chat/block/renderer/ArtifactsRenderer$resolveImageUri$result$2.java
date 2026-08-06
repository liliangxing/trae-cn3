package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/GetDownloadUrlData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$resolveImageUri$result$2", f = "ArtifactsRenderer.kt", i = {}, l = {2149}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ArtifactsRenderer$resolveImageUri$result$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpDataResult<? extends GetDownloadUrlData>>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $target;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsRenderer$resolveImageUri$result$2(String str, String str2, String str3, Continuation<? super ArtifactsRenderer$resolveImageUri$result$2> continuation) {
        super(2, continuation);
        this.$target = str;
        this.$conversationId = str2;
        this.$messageId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactsRenderer$resolveImageUri$result$2(this.$target, this.$conversationId, this.$messageId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpDataResult<GetDownloadUrlData>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IGetDownloadUrlApi.INSTANCE.getDownloadUrlRawCall(new GetDownloadUrlRequest(CollectionsKt.listOf(this.$target), this.$conversationId, this.$messageId, Boxing.boxBoolean(true)), (Continuation) this);
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

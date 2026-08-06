package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ChatSessionResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity$fetchArtifactImageUrls$1$result$1", f = "MultiImagePreviewActivity.kt", i = {}, l = {499}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class MultiImagePreviewActivity$fetchArtifactImageUrls$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpDataResult<? extends ChatSessionResponse>>, Object> {
    int label;
    final /* synthetic */ MultiImagePreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$fetchArtifactImageUrls$1$result$1(MultiImagePreviewActivity multiImagePreviewActivity, Continuation<? super MultiImagePreviewActivity$fetchArtifactImageUrls$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = multiImagePreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiImagePreviewActivity$fetchArtifactImageUrls$1$result$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpDataResult<ChatSessionResponse>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IChatSessionApi.Companion companion = IChatSessionApi.INSTANCE;
            str = this.this$0.chatSessionId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSessionId");
                str = null;
            }
            this.label = 1;
            obj = companion.getChatSessionRawCall(str, (Continuation) this);
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

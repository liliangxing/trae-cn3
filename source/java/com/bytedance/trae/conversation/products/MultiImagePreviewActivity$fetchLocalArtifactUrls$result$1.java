package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.List;
import java.util.Map;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/GetDownloadUrlData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1", f = "MultiImagePreviewActivity.kt", i = {}, l = {462}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpDataResult<? extends GetDownloadUrlData>>, Object> {
    final /* synthetic */ Map<String, String> $requestTargets;
    int label;
    final /* synthetic */ MultiImagePreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1(Map<String, String> map, MultiImagePreviewActivity multiImagePreviewActivity, Continuation<? super MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1> continuation) {
        super(2, continuation);
        this.$requestTargets = map;
        this.this$0 = multiImagePreviewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiImagePreviewActivity$fetchLocalArtifactUrls$result$1(this.$requestTargets, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpDataResult<GetDownloadUrlData>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IGetDownloadUrlApi.Companion companion = IGetDownloadUrlApi.INSTANCE;
            List distinct = CollectionsKt.distinct(this.$requestTargets.values());
            str = this.this$0.conversationId;
            String str3 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("conversationId");
                str = null;
            }
            str2 = this.this$0.messageId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("messageId");
            } else {
                str3 = str2;
            }
            this.label = 1;
            obj = companion.getDownloadUrlRawCall(new GetDownloadUrlRequest(distinct, str, str3, Boxing.boxBoolean(true)), (Continuation) this);
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

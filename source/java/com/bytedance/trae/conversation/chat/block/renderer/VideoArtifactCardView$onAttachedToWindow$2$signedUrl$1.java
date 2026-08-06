package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.fileupload.BizType;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlResponse;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VideoArtifactCardView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1", f = "VideoArtifactCardView.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $lastFrameUri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoArtifactCardView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1(VideoArtifactCardView videoArtifactCardView, String str, Continuation<? super VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1> continuation) {
        super(2, continuation);
        this.this$0 = videoArtifactCardView;
        this.$lastFrameUri = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> videoArtifactCardView$onAttachedToWindow$2$signedUrl$1 = new VideoArtifactCardView$onAttachedToWindow$2$signedUrl$1(this.this$0, this.$lastFrameUri, continuation);
        videoArtifactCardView$onAttachedToWindow$2$signedUrl$1.L$0 = obj;
        return videoArtifactCardView$onAttachedToWindow$2$signedUrl$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        ConversationCopilotResourceUploadApi resourceUploadApi;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                VideoArtifactCardView videoArtifactCardView = this.this$0;
                String str2 = this.$lastFrameUri;
                Result.Companion companion = Result.Companion;
                resourceUploadApi = videoArtifactCardView.getResourceUploadApi();
                GetResourceUrlRequest getResourceUrlRequest = new GetResourceUrlRequest(CollectionsKt.listOf(str2), BizType.Image);
                this.L$0 = str2;
                this.label = 1;
                obj = resourceUploadApi.getResourceUrl(getResourceUrlRequest, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = str2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            obj2 = Result.constructor-impl(((GetResourceUrlResponse) obj).getUrlMap().get(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj2)) {
            return null;
        }
        return obj2;
    }
}

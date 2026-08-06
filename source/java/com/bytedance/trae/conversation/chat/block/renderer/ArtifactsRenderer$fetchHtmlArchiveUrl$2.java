package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.HtmlArtifactDownloadTarget;
import com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveResolveMode;
import com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver;
import com.bytedance.trae.im.service.CliType;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactsRenderer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer$fetchHtmlArchiveUrl$2", f = "ArtifactsRenderer.kt", i = {}, l = {1285, 1292}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactsRenderer$fetchHtmlArchiveUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ ArtifactsRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsRenderer$fetchHtmlArchiveUrl$2(String str, String str2, String str3, ArtifactsRenderer artifactsRenderer, String str4, String str5, Continuation<? super ArtifactsRenderer$fetchHtmlArchiveUrl$2> continuation) {
        super(2, continuation);
        this.$cliType = str;
        this.$chatSessionId = str2;
        this.$path = str3;
        this.this$0 = artifactsRenderer;
        this.$conversationId = str4;
        this.$messageId = str5;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactsRenderer$fetchHtmlArchiveUrl$2(this.$cliType, this.$chatSessionId, this.$path, this.this$0, this.$conversationId, this.$messageId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return (String) obj;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (String) obj;
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(this.$cliType, CliType.REMOTE.getValue())) {
            this.label = 1;
            obj = new HtmlArtifactRemoteArchiveUrlResolver(null, null, 0L, null, 15, null).resolve(this.$chatSessionId, this.$path, HtmlArtifactRemoteArchiveResolveMode.ENSURE_SANDBOX_READY, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (String) obj;
        }
        HtmlArtifactDownloadTarget fromPreviewPath = HtmlArtifactDownloadTarget.INSTANCE.fromPreviewPath(this.$path);
        this.label = 2;
        obj = this.this$0.fetchHtmlDownloadUrlWithRetry(fromPreviewPath.getLocalRequestPath(), this.$conversationId, this.$messageId, (Continuation) this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return (String) obj;
    }
}

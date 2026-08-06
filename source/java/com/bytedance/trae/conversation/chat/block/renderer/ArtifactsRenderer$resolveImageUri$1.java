package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.im.model.MessagePart;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactsRenderer.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer", f = "ArtifactsRenderer.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3}, l = {2116, AccountErrorCode.ERROR_REUSED_MOBILE_VERIFY, 2163, 2189}, m = "resolveImageUri", n = {"this", MessagePart.TYPE_FILE, "extras", "context", "conversationId", "messageId", "extras", "target", IWeixinService.ResponseConstants.URL, "attempt", "context", "conversationId", "messageId", "extras", "target", IWeixinService.ResponseConstants.URL, "attempt", "extras"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactsRenderer$resolveImageUri$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactsRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsRenderer$resolveImageUri$1(ArtifactsRenderer artifactsRenderer, Continuation<? super ArtifactsRenderer$resolveImageUri$1> continuation) {
        super(continuation);
        this.this$0 = artifactsRenderer;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolveImageUri;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolveImageUri = this.this$0.resolveImageUri(null, null, null, null, null, null, (Continuation) this);
        return resolveImageUri;
    }
}

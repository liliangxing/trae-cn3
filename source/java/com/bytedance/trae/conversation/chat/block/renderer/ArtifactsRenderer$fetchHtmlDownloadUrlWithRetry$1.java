package com.bytedance.trae.conversation.chat.block.renderer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactsRenderer.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactsRenderer", f = "ArtifactsRenderer.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {1302, 1314}, m = "fetchHtmlDownloadUrlWithRetry", n = {"filePath", "conversationId", "messageId", "attempt", "filePath", "conversationId", "messageId", "attempt"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactsRenderer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1(ArtifactsRenderer artifactsRenderer, Continuation<? super ArtifactsRenderer$fetchHtmlDownloadUrlWithRetry$1> continuation) {
        super(continuation);
        this.this$0 = artifactsRenderer;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchHtmlDownloadUrlWithRetry;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchHtmlDownloadUrlWithRetry = this.this$0.fetchHtmlDownloadUrlWithRetry(null, null, null, (Continuation) this);
        return fetchHtmlDownloadUrlWithRetry;
    }
}

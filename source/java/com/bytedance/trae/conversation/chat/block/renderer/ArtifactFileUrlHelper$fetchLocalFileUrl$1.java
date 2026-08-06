package com.bytedance.trae.conversation.chat.block.renderer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactFileUrlHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper", f = "ArtifactFileUrlHelper.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {109, 133}, m = "fetchLocalFileUrl", n = {"this", "path", "conversationId", "messageId", "extras", "attempt", "this", "path", "conversationId", "messageId", "extras", "attempt"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactFileUrlHelper$fetchLocalFileUrl$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactFileUrlHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactFileUrlHelper$fetchLocalFileUrl$1(ArtifactFileUrlHelper artifactFileUrlHelper, Continuation<? super ArtifactFileUrlHelper$fetchLocalFileUrl$1> continuation) {
        super(continuation);
        this.this$0 = artifactFileUrlHelper;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchLocalFileUrl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchLocalFileUrl = this.this$0.fetchLocalFileUrl(null, null, null, (Continuation) this);
        return fetchLocalFileUrl;
    }
}

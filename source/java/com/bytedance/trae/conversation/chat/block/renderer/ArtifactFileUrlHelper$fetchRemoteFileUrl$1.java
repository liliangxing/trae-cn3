package com.bytedance.trae.conversation.chat.block.renderer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactFileUrlHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper", f = "ArtifactFileUrlHelper.kt", i = {0, 0, 0}, l = {62}, m = "fetchRemoteFileUrl", n = {"this", "chatSessionId", "path"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactFileUrlHelper$fetchRemoteFileUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactFileUrlHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactFileUrlHelper$fetchRemoteFileUrl$1(ArtifactFileUrlHelper artifactFileUrlHelper, Continuation<? super ArtifactFileUrlHelper$fetchRemoteFileUrl$1> continuation) {
        super(continuation);
        this.this$0 = artifactFileUrlHelper;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchRemoteFileUrl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchRemoteFileUrl = this.this$0.fetchRemoteFileUrl(null, null, (Continuation) this);
        return fetchRemoteFileUrl;
    }
}

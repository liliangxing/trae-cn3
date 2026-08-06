package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactPreviewActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactPreviewActivity", f = "ArtifactPreviewActivity.kt", i = {0, 0, 0, 1, 1, 1}, l = {362, 428}, m = "fetchFileUrl", n = {"this", "paramsMap", "fetchStartTime", "this", "paramsMap", "fetchStartTime"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactPreviewActivity$fetchFileUrl$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ArtifactPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactPreviewActivity$fetchFileUrl$1(ArtifactPreviewActivity artifactPreviewActivity, Continuation<? super ArtifactPreviewActivity$fetchFileUrl$1> continuation) {
        super(continuation);
        this.this$0 = artifactPreviewActivity;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchFileUrl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchFileUrl = this.this$0.fetchFileUrl((Continuation) this);
        return fetchFileUrl;
    }
}

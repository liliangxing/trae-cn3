package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiImagePreviewActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MultiImagePreviewActivity", f = "MultiImagePreviewActivity.kt", i = {0, 0}, l = {426}, m = "fetchRemoteResourceUrls", n = {"this", "resourceUris"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MultiImagePreviewActivity$fetchRemoteResourceUrls$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiImagePreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiImagePreviewActivity$fetchRemoteResourceUrls$1(MultiImagePreviewActivity multiImagePreviewActivity, Continuation<? super MultiImagePreviewActivity$fetchRemoteResourceUrls$1> continuation) {
        super(continuation);
        this.this$0 = multiImagePreviewActivity;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchRemoteResourceUrls;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchRemoteResourceUrls = this.this$0.fetchRemoteResourceUrls(null, (Continuation) this);
        return fetchRemoteResourceUrls;
    }
}

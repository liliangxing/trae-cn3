package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewWebViewActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.PreviewWebViewActivity", f = "PreviewWebViewActivity.kt", i = {0, 0, 0, 1, 1}, l = {315, 328}, m = "resolvePreviewUrl", n = {"this", "chatSessionId", "parsed", "this", "rebasedUrl"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PreviewWebViewActivity$resolvePreviewUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewWebViewActivity$resolvePreviewUrl$1(PreviewWebViewActivity previewWebViewActivity, Continuation<? super PreviewWebViewActivity$resolvePreviewUrl$1> continuation) {
        super(continuation);
        this.this$0 = previewWebViewActivity;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolvePreviewUrl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolvePreviewUrl = this.this$0.resolvePreviewUrl(null, null, null, (Continuation) this);
        return resolvePreviewUrl;
    }
}

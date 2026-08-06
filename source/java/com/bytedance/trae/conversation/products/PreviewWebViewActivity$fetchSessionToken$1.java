package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewWebViewActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.PreviewWebViewActivity", f = "PreviewWebViewActivity.kt", i = {}, l = {394}, m = "fetchSessionToken", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PreviewWebViewActivity$fetchSessionToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreviewWebViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewWebViewActivity$fetchSessionToken$1(PreviewWebViewActivity previewWebViewActivity, Continuation<? super PreviewWebViewActivity$fetchSessionToken$1> continuation) {
        super(continuation);
        this.this$0 = previewWebViewActivity;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchSessionToken;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchSessionToken = this.this$0.fetchSessionToken(null, (Continuation) this);
        return fetchSessionToken;
    }
}

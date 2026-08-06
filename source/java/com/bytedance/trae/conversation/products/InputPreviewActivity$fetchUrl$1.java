package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputPreviewActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.InputPreviewActivity", f = "InputPreviewActivity.kt", i = {0}, l = {878}, m = "fetchUrl", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InputPreviewActivity$fetchUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InputPreviewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputPreviewActivity$fetchUrl$1(InputPreviewActivity inputPreviewActivity, Continuation<? super InputPreviewActivity$fetchUrl$1> continuation) {
        super(continuation);
        this.this$0 = inputPreviewActivity;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchUrl;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchUrl = this.this$0.fetchUrl((Continuation) this);
        return fetchUrl;
    }
}

package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiffViewActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.DiffViewActivity", f = "DiffViewActivity.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {262, 294}, m = "fetchDownloadUrlWithRetry", n = {"this", "filePath", "baseExtra", "attempt", "this", "filePath", "baseExtra", "attempt"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DiffViewActivity$fetchDownloadUrlWithRetry$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiffViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffViewActivity$fetchDownloadUrlWithRetry$1(DiffViewActivity diffViewActivity, Continuation<? super DiffViewActivity$fetchDownloadUrlWithRetry$1> continuation) {
        super(continuation);
        this.this$0 = diffViewActivity;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchDownloadUrlWithRetry;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchDownloadUrlWithRetry = this.this$0.fetchDownloadUrlWithRetry(null, (Continuation) this);
        return fetchDownloadUrlWithRetry;
    }
}

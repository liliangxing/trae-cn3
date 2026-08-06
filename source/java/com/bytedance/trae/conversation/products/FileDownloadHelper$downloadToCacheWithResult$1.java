package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDownloadHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.FileDownloadHelper", f = "FileDownloadHelper.kt", i = {0, 0, 0}, l = {172}, m = "downloadToCacheWithResult$conversation_mainlandRelease", n = {"this", "cacheFile", "needDecode"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileDownloadHelper$downloadToCacheWithResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileDownloadHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDownloadHelper$downloadToCacheWithResult$1(FileDownloadHelper fileDownloadHelper, Continuation<? super FileDownloadHelper$downloadToCacheWithResult$1> continuation) {
        super(continuation);
        this.this$0 = fileDownloadHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadToCacheWithResult$conversation_mainlandRelease(null, null, null, null, false, 0L, (Continuation) this);
    }
}

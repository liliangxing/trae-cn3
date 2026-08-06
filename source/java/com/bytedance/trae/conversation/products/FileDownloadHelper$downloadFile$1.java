package com.bytedance.trae.conversation.products;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDownloadHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.FileDownloadHelper", f = "FileDownloadHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {513}, m = "downloadFile", n = {"this", "context", "sessionId", "path", "existingPath", "cacheFile", "timeFile", "needDecode", "createTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileDownloadHelper$downloadFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileDownloadHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDownloadHelper$downloadFile$1(FileDownloadHelper fileDownloadHelper, Continuation<? super FileDownloadHelper$downloadFile$1> continuation) {
        super(continuation);
        this.this$0 = fileDownloadHelper;
    }

    public final Object invokeSuspend(Object obj) {
        Object downloadFile;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        downloadFile = this.this$0.downloadFile(null, null, null, null, false, 0L, (Continuation) this);
        return downloadFile;
    }
}

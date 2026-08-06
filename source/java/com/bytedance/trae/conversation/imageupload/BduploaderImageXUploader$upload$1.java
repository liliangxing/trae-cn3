package com.bytedance.trae.conversation.imageupload;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BduploaderImageXUploader.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.BduploaderImageXUploader", f = "BduploaderImageXUploader.kt", i = {0, 0, 0}, l = {179}, m = "upload", n = {"this", "onProgress", "uploader"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BduploaderImageXUploader$upload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BduploaderImageXUploader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BduploaderImageXUploader$upload$1(BduploaderImageXUploader bduploaderImageXUploader, Continuation<? super BduploaderImageXUploader$upload$1> continuation) {
        super(continuation);
        this.this$0 = bduploaderImageXUploader;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.upload(null, null, null, null, null, (Continuation) this);
    }
}

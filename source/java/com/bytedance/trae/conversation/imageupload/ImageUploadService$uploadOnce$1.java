package com.bytedance.trae.conversation.imageupload;

import com.bytedance.trae.im.model.MessagePart;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageUploadService.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.ImageUploadService", f = "ImageUploadService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5}, l = {171, 174, 177, 188, 196, 196}, m = "uploadOnce", n = {"this", MessagePart.TYPE_FILE, "dim", "onProgress", "region", "timeoutMs", "this", MessagePart.TYPE_FILE, "dim", "onProgress", "region", "imagexPrefix", "timeoutMs", "this", MessagePart.TYPE_FILE, "this", MessagePart.TYPE_FILE, "tosUri", "this", MessagePart.TYPE_FILE, "tosUri", "cdnUrl", "this", MessagePart.TYPE_FILE, "tosUri", "cdnUrl"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageUploadService$uploadOnce$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageUploadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageUploadService$uploadOnce$1(ImageUploadService imageUploadService, Continuation<? super ImageUploadService$uploadOnce$1> continuation) {
        super(continuation);
        this.this$0 = imageUploadService;
    }

    public final Object invokeSuspend(Object obj) {
        Object uploadOnce;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        uploadOnce = this.this$0.uploadOnce(null, null, null, 0L, (Continuation) this);
        return uploadOnce;
    }
}

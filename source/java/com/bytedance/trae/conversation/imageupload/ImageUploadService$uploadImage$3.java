package com.bytedance.trae.conversation.imageupload;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageUploadService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.ImageUploadService$uploadImage$3", f = "ImageUploadService.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageUploadService$uploadImage$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageUploadResult>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ Function1<Integer, Unit> $onProgress;
    final /* synthetic */ long $timeoutMs;
    int label;
    final /* synthetic */ ImageUploadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageUploadService$uploadImage$3(File file, ImageUploadService imageUploadService, Function1<? super Integer, Unit> function1, long j, Continuation<? super ImageUploadService$uploadImage$3> continuation) {
        super(2, continuation);
        this.$file = file;
        this.this$0 = imageUploadService;
        this.$onProgress = function1;
        this.$timeoutMs = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageUploadService$uploadImage$3(this.$file, this.this$0, this.$onProgress, this.$timeoutMs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageUploadResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ImageCompressor imageCompressor;
        Pair pair;
        ImageCompressor imageCompressor2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Pair<FileValidationResult, ImageDimension> validateFile = ImageValidation.INSTANCE.validateFile(this.$file);
            FileValidationResult fileValidationResult = (FileValidationResult) validateFile.component1();
            ImageDimension imageDimension = (ImageDimension) validateFile.component2();
            if (fileValidationResult.getValid()) {
                imageCompressor = this.this$0.compressor;
                if (imageCompressor != null) {
                    imageCompressor2 = this.this$0.compressor;
                    CompressionResult compressIfNeeded$default = ImageCompressor.compressIfNeeded$default(imageCompressor2, this.$file, imageDimension, null, 4, null);
                    pair = TuplesKt.to(compressIfNeeded$default.getFile(), new ImageDimension(compressIfNeeded$default.getWidth(), compressIfNeeded$default.getHeight()));
                } else {
                    File file = this.$file;
                    Intrinsics.checkNotNull(imageDimension);
                    pair = TuplesKt.to(file, imageDimension);
                }
                File file2 = (File) pair.component1();
                ImageDimension imageDimension2 = (ImageDimension) pair.component2();
                this.label = 1;
                obj = this.this$0.uploadWithRetry(file2, imageDimension2, this.$onProgress, this.$timeoutMs, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                ImageUploadErrorCode errorCode = fileValidationResult.getErrorCode();
                if (errorCode == null) {
                    errorCode = ImageUploadErrorCode.UNKNOWN;
                }
                ImageUploadErrorCode imageUploadErrorCode = errorCode;
                String errorMessage = fileValidationResult.getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = "Invalid file";
                }
                throw new ImageUploadException(imageUploadErrorCode, errorMessage, null, 4, null);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}

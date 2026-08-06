package com.bytedance.trae.conversation.imageupload;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageUploadService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.ImageUploadService$uploadOnce$tosUri$1", f = "ImageUploadService.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageUploadService$uploadOnce$tosUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ Function1<Integer, Unit> $onProgress;
    final /* synthetic */ String $storeKey;
    final /* synthetic */ StsTokenData $token;
    int label;
    final /* synthetic */ ImageUploadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageUploadService$uploadOnce$tosUri$1(ImageUploadService imageUploadService, File file, String str, StsTokenData stsTokenData, Function1<? super Integer, Unit> function1, Continuation<? super ImageUploadService$uploadOnce$tosUri$1> continuation) {
        super(2, continuation);
        this.this$0 = imageUploadService;
        this.$file = file;
        this.$storeKey = str;
        this.$token = stsTokenData;
        this.$onProgress = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageUploadService$uploadOnce$tosUri$1(this.this$0, this.$file, this.$storeKey, this.$token, this.$onProgress, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ImageXUploader imageXUploader;
        ImageUploadSdkConfig imageUploadSdkConfig;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            imageXUploader = this.this$0.uploader;
            File file = this.$file;
            String str = this.$storeKey;
            StsTokenData stsTokenData = this.$token;
            imageUploadSdkConfig = this.this$0.sdkConfig;
            this.label = 1;
            obj = imageXUploader.upload(file, str, stsTokenData, imageUploadSdkConfig.getUploaderConfig(), this.$onProgress, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
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

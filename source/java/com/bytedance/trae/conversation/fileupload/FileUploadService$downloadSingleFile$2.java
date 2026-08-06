package com.bytedance.trae.conversation.fileupload;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.trae.conversation.fileupload.FileUploadService;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileUploadService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.fileupload.FileUploadService$downloadSingleFile$2", f = "FileUploadService.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FileUploadService$downloadSingleFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ BizType $bizType;
    final /* synthetic */ boolean $enableMagic;
    final /* synthetic */ String $oid;
    int label;
    final /* synthetic */ FileUploadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUploadService$downloadSingleFile$2(FileUploadService fileUploadService, String str, BizType bizType, boolean z, Continuation<? super FileUploadService$downloadSingleFile$2> continuation) {
        super(2, continuation);
        this.this$0 = fileUploadService;
        this.$oid = str;
        this.$bizType = bizType;
        this.$enableMagic = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FileUploadService$downloadSingleFile$2(this.this$0, this.$oid, this.$bizType, this.$enableMagic, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ResourceUploadApi resourceUploadApi;
        FileUploadService.IObjectStoreApi createObjectStoreApi;
        byte[] readAllBytes;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            resourceUploadApi = this.this$0.api;
            this.label = 1;
            obj = resourceUploadApi.getResourceUrl(new GetResourceUrlRequest(CollectionsKt.listOf(this.$oid), this.$bizType), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str = ((GetResourceUrlResponse) obj).getUrlMap().get(this.$oid);
        if (str != null) {
            createObjectStoreApi = this.this$0.createObjectStoreApi();
            SsResponse execute = createObjectStoreApi.get(str, MapsKt.emptyMap()).execute();
            Intrinsics.checkNotNullExpressionValue(execute, "execute(...)");
            if (!execute.isSuccessful()) {
                throw new IllegalStateException("Download failed with status " + execute.code());
            }
            TypedInput typedInput = (TypedInput) execute.body();
            if (typedInput == null) {
                return new byte[0];
            }
            FileUploadService fileUploadService = this.this$0;
            InputStream in = typedInput.in();
            Intrinsics.checkNotNullExpressionValue(in, "in(...)");
            readAllBytes = fileUploadService.readAllBytes(in);
            return this.$enableMagic ? ResourceUploadUtilKt.decodeContent(readAllBytes) : readAllBytes;
        }
        throw new IllegalStateException("No URL found for oid: " + this.$oid);
    }
}

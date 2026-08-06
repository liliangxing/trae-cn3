package com.bytedance.trae.conversation.imageupload;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageUploadService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lkotlin/Result;", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.ImageUploadService$uploadBatch$2$jobs$1$1", f = "ImageUploadService.kt", i = {0, 1}, l = {237, 82}, m = "invokeSuspend", n = {"$this$withPermit$iv", "$this$withPermit$iv"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageUploadService$uploadBatch$2$jobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ImageUploadResult>>, Object> {

    /* renamed from: $f */
    final /* synthetic */ File f1307$f;
    final /* synthetic */ int $idx;
    final /* synthetic */ Function2<Integer, Integer, Unit> $onItemProgress;
    final /* synthetic */ Semaphore $sem;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ImageUploadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageUploadService$uploadBatch$2$jobs$1$1(Semaphore semaphore, ImageUploadService imageUploadService, File file, Function2<? super Integer, ? super Integer, Unit> function2, int i, Continuation<? super ImageUploadService$uploadBatch$2$jobs$1$1> continuation) {
        super(2, continuation);
        this.$sem = semaphore;
        this.this$0 = imageUploadService;
        this.f1307$f = file;
        this.$onItemProgress = function2;
        this.$idx = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageUploadService$uploadBatch$2$jobs$1$1(this.$sem, this.this$0, this.f1307$f, this.$onItemProgress, this.$idx, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<ImageUploadResult>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(1:(1:(7:5|6|7|8|9|10|11)(2:21|22))(1:23))(2:33|(1:35)(1:36))|24|25|26|(1:28)(5:29|8|9|10|11)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
    
        r0 = r14;
        r14 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Semaphore semaphore;
        ImageUploadService imageUploadService;
        File file;
        final Function2<Integer, Integer, Unit> function2;
        final int i;
        Semaphore semaphore2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            semaphore = this.$sem;
            imageUploadService = this.this$0;
            file = this.f1307$f;
            Function2<Integer, Integer, Unit> function22 = this.$onItemProgress;
            int i3 = this.$idx;
            this.L$0 = semaphore;
            this.L$1 = imageUploadService;
            this.L$2 = file;
            this.L$3 = function22;
            this.I$0 = i3;
            this.label = 1;
            if (semaphore.acquire((Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            function2 = function22;
            i = i3;
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                semaphore2 = (Semaphore) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.constructor-impl((ImageUploadResult) obj);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    try {
                        Result.Companion companion2 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                        return Result.box-impl(obj2);
                    } finally {
                        semaphore2.release();
                    }
                }
                return Result.box-impl(obj2);
            }
            i = this.I$0;
            function2 = (Function2) this.L$3;
            file = (File) this.L$2;
            imageUploadService = (ImageUploadService) this.L$1;
            Semaphore semaphore3 = (Semaphore) this.L$0;
            ResultKt.throwOnFailure(obj);
            semaphore = semaphore3;
        }
        ImageUploadService imageUploadService2 = imageUploadService;
        File file2 = file;
        Function1 function1 = new Function1() { // from class: com.bytedance.trae.conversation.imageupload.ImageUploadService$uploadBatch$2$jobs$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj3) {
                Unit invokeSuspend$lambda$1$lambda$0;
                invokeSuspend$lambda$1$lambda$0 = ImageUploadService$uploadBatch$2$jobs$1$1.invokeSuspend$lambda$1$lambda$0(function2, i, ((Integer) obj3).intValue());
                return invokeSuspend$lambda$1$lambda$0;
            }
        };
        this.L$0 = semaphore;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        Object uploadImage$default = ImageUploadService.uploadImage$default(imageUploadService2, file2, function1, 0L, this, 4, null);
        if (uploadImage$default == coroutine_suspended) {
            return coroutine_suspended;
        }
        semaphore2 = semaphore;
        obj = uploadImage$default;
        Result.Companion companion3 = Result.Companion;
        obj2 = Result.constructor-impl((ImageUploadResult) obj);
        return Result.box-impl(obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1$lambda$0(Function2 function2, int i, int i2) {
        if (function2 != null) {
            function2.invoke(Integer.valueOf(i), Integer.valueOf(i2));
        }
        return Unit.INSTANCE;
    }
}

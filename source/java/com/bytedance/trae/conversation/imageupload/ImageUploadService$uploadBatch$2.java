package com.bytedance.trae.conversation.imageupload;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* compiled from: ImageUploadService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00010\u00020\u0001*\u00020\u0006H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lkotlin/Pair;", "", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;", "Ljava/io/File;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.ImageUploadService$uploadBatch$2", f = "ImageUploadService.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"toUpload"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class ImageUploadService$uploadBatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends ImageUploadResult>, ? extends List<? extends Pair<? extends File, ? extends Throwable>>>>, Object> {
    final /* synthetic */ int $concurrency;
    final /* synthetic */ int $currentCount;
    final /* synthetic */ List<File> $files;
    final /* synthetic */ Function2<Integer, Integer, Unit> $onItemProgress;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImageUploadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageUploadService$uploadBatch$2(int i, List<? extends File> list, int i2, ImageUploadService imageUploadService, Function2<? super Integer, ? super Integer, Unit> function2, Continuation<? super ImageUploadService$uploadBatch$2> continuation) {
        super(2, continuation);
        this.$currentCount = i;
        this.$files = list;
        this.$concurrency = i2;
        this.this$0 = imageUploadService;
        this.$onItemProgress = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> imageUploadService$uploadBatch$2 = new ImageUploadService$uploadBatch$2(this.$currentCount, this.$files, this.$concurrency, this.this$0, this.$onItemProgress, continuation);
        imageUploadService$uploadBatch$2.L$0 = obj;
        return imageUploadService$uploadBatch$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<ImageUploadResult>, ? extends List<? extends Pair<? extends File, ? extends Throwable>>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object awaitAll;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 0;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Pair<FileValidationResult, Integer> validateImageCount = ImageValidation.INSTANCE.validateImageCount(this.$currentCount, this.$files.size());
            FileValidationResult fileValidationResult = (FileValidationResult) validateImageCount.component1();
            List take = CollectionsKt.take(this.$files, ((Number) validateImageCount.component2()).intValue());
            if (!fileValidationResult.getValid()) {
                List emptyList = CollectionsKt.emptyList();
                List<File> list2 = this.$files;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (File file : list2) {
                    ImageUploadErrorCode errorCode = fileValidationResult.getErrorCode();
                    Intrinsics.checkNotNull(errorCode);
                    String errorMessage = fileValidationResult.getErrorMessage();
                    Intrinsics.checkNotNull(errorMessage);
                    arrayList.add(TuplesKt.to(file, new ImageUploadException(errorCode, errorMessage, null, 4, null)));
                }
                return TuplesKt.to(emptyList, arrayList);
            }
            Semaphore Semaphore$default = SemaphoreKt.Semaphore$default(this.$concurrency, 0, 2, (Object) null);
            List list3 = take;
            ImageUploadService imageUploadService = this.this$0;
            Function2<Integer, Integer, Unit> function2 = this.$onItemProgress;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            int i3 = 0;
            for (Object obj2 : list3) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ImageUploadService$uploadBatch$2$jobs$1$1(Semaphore$default, imageUploadService, (File) obj2, function2, i3, null), 3, (Object) null));
                function2 = function2;
                imageUploadService = imageUploadService;
                arrayList2 = arrayList3;
                i3 = i4;
            }
            this.L$0 = take;
            this.label = 1;
            awaitAll = AwaitKt.awaitAll(arrayList2, (Continuation) this);
            if (awaitAll == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = take;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            awaitAll = obj;
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj3 : (List) awaitAll) {
            int i5 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Object obj4 = ((Result) obj3).unbox-impl();
            Throwable th = Result.exceptionOrNull-impl(obj4);
            if (th == null) {
                arrayList4.add((ImageUploadResult) obj4);
            } else {
                arrayList5.add(TuplesKt.to(list.get(i2), th));
            }
            i2 = i5;
        }
        return TuplesKt.to(arrayList4, arrayList5);
    }
}

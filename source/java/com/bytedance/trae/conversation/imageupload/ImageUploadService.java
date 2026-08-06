package com.bytedance.trae.conversation.imageupload;

import android.util.Base64;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.MessagePart;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: ImageUploadService.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0090\u0001\u0010\u001c\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001e\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001f0\u001d0\u001e0\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\b\b\u0002\u0010!\u001a\u00020\u00172\b\b\u0002\u0010\"\u001a\u00020\u00172:\b\u0002\u0010#\u001a4\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u0018\u0018\u00010$H\u0086@¢\u0006\u0002\u0010)J:\u0010*\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fH\u0002J:\u00101\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010-J\u0018\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000fH\u0002J\u0006\u00105\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageUploadService;", "", "sdkConfig", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;", "tokenManager", "Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;", "uploader", "Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;", "compressor", "Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;", "<init>", "(Lcom/bytedance/trae/conversation/imageupload/ImageUploadSdkConfig;Lcom/bytedance/trae/conversation/imageupload/StsTokenManager;Lcom/bytedance/trae/conversation/imageupload/ImageXUploader;Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;)V", "defaultIsCnRegion", "", "getRegionOrDefault", "", "isCn", "uploadImage", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadResult;", MessagePart.TYPE_FILE, "Ljava/io/File;", "onProgress", "Lkotlin/Function1;", "", "", "timeoutMs", "", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadBatch", "Lkotlin/Pair;", "", "", "files", "currentCount", "concurrency", "onItemProgress", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "percent", "(Ljava/util/List;IILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadWithRetry", "dim", "Lcom/bytedance/trae/conversation/imageupload/ImageDimension;", "(Ljava/io/File;Lcom/bytedance/trae/conversation/imageupload/ImageDimension;Lkotlin/jvm/functions/Function1;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapThrowable", "Lcom/bytedance/trae/conversation/imageupload/ImageUploadException;", "t", "uploadOnce", "fallbackUrl", "imageHost", "tosUri", "close", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageUploadService {
    private final ImageCompressor compressor;
    private final ImageUploadSdkConfig sdkConfig;
    private final StsTokenManager tokenManager;
    private final ImageXUploader uploader;

    /* compiled from: ImageUploadService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageUploadErrorCode.values().length];
            try {
                iArr[ImageUploadErrorCode.INVALID_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageUploadErrorCode.FILE_TOO_LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageUploadErrorCode.DIMENSION_TOO_SMALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageUploadErrorCode.PIXEL_COUNT_INVALID.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ImageUploadErrorCode.ASPECT_RATIO_INVALID.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ImageUploadErrorCode.CONTENT_CHECK_FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ImageUploadErrorCode.TOO_MANY_IMAGES.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final boolean defaultIsCnRegion() {
        return true;
    }

    public ImageUploadService(ImageUploadSdkConfig imageUploadSdkConfig, StsTokenManager stsTokenManager, ImageXUploader imageXUploader, ImageCompressor imageCompressor) {
        Intrinsics.checkNotNullParameter(imageUploadSdkConfig, "sdkConfig");
        Intrinsics.checkNotNullParameter(stsTokenManager, "tokenManager");
        Intrinsics.checkNotNullParameter(imageXUploader, "uploader");
        this.sdkConfig = imageUploadSdkConfig;
        this.tokenManager = stsTokenManager;
        this.uploader = imageXUploader;
        this.compressor = imageCompressor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageUploadService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/imageupload/StsTokenResponse;", "userId", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.imageupload.ImageUploadService$1", f = "ImageUploadService.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.imageupload.ImageUploadService$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07311 extends SuspendLambda implements Function2<String, Continuation<? super StsTokenResponse>, Object> {
        final /* synthetic */ ImageUploadSdkConfig $sdkConfig;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07311(ImageUploadSdkConfig imageUploadSdkConfig, Continuation<? super C07311> continuation) {
            super(2, continuation);
            this.$sdkConfig = imageUploadSdkConfig;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c07311 = new C07311(this.$sdkConfig, continuation);
            c07311.L$0 = obj;
            return c07311;
        }

        public final Object invoke(String str, Continuation<? super StsTokenResponse> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                this.label = 1;
                obj = this.$sdkConfig.getApi().getStsToken(str, (Continuation) this);
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

    public /* synthetic */ ImageUploadService(final ImageUploadSdkConfig imageUploadSdkConfig, StsTokenManager stsTokenManager, BduploaderImageXUploader bduploaderImageXUploader, ImageCompressor imageCompressor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageUploadSdkConfig, (i & 2) != 0 ? new StsTokenManager(new C07311(imageUploadSdkConfig, null), new Function0() { // from class: com.bytedance.trae.conversation.imageupload.ImageUploadService$$ExternalSyntheticLambda0
            public final Object invoke() {
                String _init_$lambda$0;
                _init_$lambda$0 = ImageUploadService._init_$lambda$0(ImageUploadSdkConfig.this);
                return _init_$lambda$0;
            }
        }) : stsTokenManager, (i & 4) != 0 ? new BduploaderImageXUploader() : bduploaderImageXUploader, (i & 8) != 0 ? null : imageCompressor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0(ImageUploadSdkConfig imageUploadSdkConfig) {
        return imageUploadSdkConfig.getUploaderConfig().getDefaultServiceId();
    }

    private final String getRegionOrDefault(boolean isCn) {
        String str;
        Function0<String> getRegion = this.sdkConfig.getGetRegion();
        if (getRegion != null && (str = (String) getRegion.invoke()) != null) {
            if (!(!StringsKt.isBlank(str))) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        return isCn ? "cn" : "i18n";
    }

    public static /* synthetic */ Object uploadImage$default(ImageUploadService imageUploadService, File file, Function1 function1, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: com.bytedance.trae.conversation.imageupload.ImageUploadService$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit uploadImage$lambda$2;
                    uploadImage$lambda$2 = ImageUploadService.uploadImage$lambda$2(((Integer) obj2).intValue());
                    return uploadImage$lambda$2;
                }
            };
        }
        Function1 function12 = function1;
        if ((i & 4) != 0) {
            j = 60000;
        }
        return imageUploadService.uploadImage(file, function12, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit uploadImage$lambda$2(int i) {
        return Unit.INSTANCE;
    }

    public final Object uploadImage(File file, Function1<? super Integer, Unit> function1, long j, Continuation<? super ImageUploadResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageUploadService$uploadImage$3(file, this, function1, j, null), continuation);
    }

    public static /* synthetic */ Object uploadBatch$default(ImageUploadService imageUploadService, List list, int i, int i2, Function2 function2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = 3;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            function2 = null;
        }
        return imageUploadService.uploadBatch(list, i4, i5, function2, continuation);
    }

    public final Object uploadBatch(List<? extends File> list, int i, int i2, Function2<? super Integer, ? super Integer, Unit> function2, Continuation<? super Pair<? extends List<ImageUploadResult>, ? extends List<? extends Pair<? extends File, ? extends Throwable>>>> continuation) {
        return CoroutineScopeKt.coroutineScope(new ImageUploadService$uploadBatch$2(i, list, i2, this, function2, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00fa -> B:11:0x0101). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object uploadWithRetry(File file, ImageDimension imageDimension, Function1<? super Integer, Unit> function1, long j, Continuation<? super ImageUploadResult> continuation) {
        ImageUploadService$uploadWithRetry$1 imageUploadService$uploadWithRetry$1;
        ImageUploadService imageUploadService;
        int i;
        Function1<? super Integer, Unit> function12;
        long j2;
        ImageUploadService$uploadWithRetry$1 imageUploadService$uploadWithRetry$12;
        ImageUploadService imageUploadService2;
        Object obj;
        Throwable th;
        int i2;
        File file2;
        ImageDimension imageDimension2;
        ImageUploadService imageUploadService3;
        File file3;
        ImageDimension imageDimension3;
        Throwable th2;
        int i3;
        Function1<? super Integer, Unit> function13;
        ImageUploadException mapThrowable;
        boolean z;
        String str;
        if (continuation instanceof ImageUploadService$uploadWithRetry$1) {
            imageUploadService$uploadWithRetry$1 = (ImageUploadService$uploadWithRetry$1) continuation;
            if ((imageUploadService$uploadWithRetry$1.label & Integer.MIN_VALUE) != 0) {
                imageUploadService$uploadWithRetry$1.label -= Integer.MIN_VALUE;
                imageUploadService = this;
                Object obj2 = imageUploadService$uploadWithRetry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = imageUploadService$uploadWithRetry$1.label;
                Object obj3 = null;
                if (i == 0) {
                    if (i == 1) {
                        i3 = imageUploadService$uploadWithRetry$1.I$0;
                        j2 = imageUploadService$uploadWithRetry$1.J$0;
                        Function1<? super Integer, Unit> function14 = (Function1) imageUploadService$uploadWithRetry$1.L$3;
                        imageDimension3 = (ImageDimension) imageUploadService$uploadWithRetry$1.L$2;
                        file3 = (File) imageUploadService$uploadWithRetry$1.L$1;
                        ImageUploadService imageUploadService4 = (ImageUploadService) imageUploadService$uploadWithRetry$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                        } catch (Throwable th3) {
                            imageUploadService3 = imageUploadService4;
                            th2 = th3;
                            function13 = function14;
                            mapThrowable = imageUploadService3.mapThrowable(th2);
                            switch (WhenMappings.$EnumSwitchMapping$0[mapThrowable.getCode().ordinal()]) {
                            }
                            if (z) {
                            }
                        }
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = imageUploadService$uploadWithRetry$1.I$0;
                    j2 = imageUploadService$uploadWithRetry$1.J$0;
                    Throwable th4 = (Throwable) imageUploadService$uploadWithRetry$1.L$4;
                    Function1<? super Integer, Unit> function15 = (Function1) imageUploadService$uploadWithRetry$1.L$3;
                    ImageDimension imageDimension4 = (ImageDimension) imageUploadService$uploadWithRetry$1.L$2;
                    File file4 = (File) imageUploadService$uploadWithRetry$1.L$1;
                    ImageUploadService imageUploadService5 = (ImageUploadService) imageUploadService$uploadWithRetry$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    Object obj4 = coroutine_suspended;
                    th = th4;
                    imageDimension2 = imageDimension4;
                    imageUploadService$uploadWithRetry$12 = imageUploadService$uploadWithRetry$1;
                    file2 = file4;
                    imageUploadService2 = imageUploadService5;
                    i2 = i3 + 1;
                    function12 = function15;
                    obj3 = null;
                    obj = obj4;
                    if (i2 < 1) {
                        try {
                        } catch (Throwable th5) {
                            imageUploadService3 = imageUploadService2;
                            ImageUploadService$uploadWithRetry$1 imageUploadService$uploadWithRetry$13 = imageUploadService$uploadWithRetry$12;
                            th2 = th5;
                            function13 = function12;
                            i3 = i2;
                            file3 = file2;
                            imageUploadService$uploadWithRetry$1 = imageUploadService$uploadWithRetry$13;
                            Object obj5 = obj;
                            imageDimension3 = imageDimension2;
                            coroutine_suspended = obj5;
                            mapThrowable = imageUploadService3.mapThrowable(th2);
                            switch (WhenMappings.$EnumSwitchMapping$0[mapThrowable.getCode().ordinal()]) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                    z = false;
                                    break;
                                default:
                                    z = true;
                                    break;
                            }
                            if (z) {
                                throw mapThrowable;
                            }
                            if (i3 == 0) {
                                throw mapThrowable;
                            }
                            imageUploadService$uploadWithRetry$1.L$0 = imageUploadService3;
                            imageUploadService$uploadWithRetry$1.L$1 = file3;
                            imageUploadService$uploadWithRetry$1.L$2 = imageDimension3;
                            imageUploadService$uploadWithRetry$1.L$3 = function13;
                            imageUploadService$uploadWithRetry$1.L$4 = th2;
                            imageUploadService$uploadWithRetry$1.J$0 = j2;
                            imageUploadService$uploadWithRetry$1.I$0 = i3;
                            imageUploadService$uploadWithRetry$1.label = 2;
                            if (DelayKt.delay((1 << i3) * 1000, imageUploadService$uploadWithRetry$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj4 = coroutine_suspended;
                            imageDimension2 = imageDimension3;
                            imageUploadService2 = imageUploadService3;
                            function15 = function13;
                            th = th2;
                            imageUploadService$uploadWithRetry$12 = imageUploadService$uploadWithRetry$1;
                            file2 = file3;
                            i2 = i3 + 1;
                            function12 = function15;
                            obj3 = null;
                            obj = obj4;
                            if (i2 < 1) {
                            }
                        }
                        imageUploadService$uploadWithRetry$12.L$0 = imageUploadService2;
                        imageUploadService$uploadWithRetry$12.L$1 = file2;
                        imageUploadService$uploadWithRetry$12.L$2 = imageDimension2;
                        imageUploadService$uploadWithRetry$12.L$3 = function12;
                        imageUploadService$uploadWithRetry$12.L$4 = obj3;
                        imageUploadService$uploadWithRetry$12.J$0 = j2;
                        imageUploadService$uploadWithRetry$12.I$0 = i2;
                        imageUploadService$uploadWithRetry$12.label = 1;
                        obj2 = imageUploadService2.uploadOnce(file2, imageDimension2, function12, j2, imageUploadService$uploadWithRetry$12);
                        return obj2 == obj ? obj : obj2;
                    }
                    if (th == null || (str = th.getMessage()) == null) {
                        str = "Retry failed";
                    }
                    throw new ImageUploadException(ImageUploadErrorCode.UNKNOWN, str, th);
                }
                ResultKt.throwOnFailure(obj2);
                function12 = function1;
                j2 = j;
                imageUploadService$uploadWithRetry$12 = imageUploadService$uploadWithRetry$1;
                imageUploadService2 = imageUploadService;
                obj = coroutine_suspended;
                th = null;
                i2 = 0;
                file2 = file;
                imageDimension2 = imageDimension;
                if (i2 < 1) {
                }
            }
        }
        imageUploadService = this;
        imageUploadService$uploadWithRetry$1 = new ImageUploadService$uploadWithRetry$1(imageUploadService, continuation);
        Object obj22 = imageUploadService$uploadWithRetry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = imageUploadService$uploadWithRetry$1.label;
        Object obj32 = null;
        if (i == 0) {
        }
    }

    private final ImageUploadException mapThrowable(Throwable t) {
        if (t instanceof ImageUploadException) {
            return (ImageUploadException) t;
        }
        if (t instanceof TimeoutCancellationException) {
            return new ImageUploadException(ImageUploadErrorCode.TIMEOUT, "Upload timeout", t);
        }
        ImageUploadErrorCode imageUploadErrorCode = ImageUploadErrorCode.UNKNOWN;
        String message = t.getMessage();
        if (message == null) {
            message = "Unknown";
        }
        return new ImageUploadException(imageUploadErrorCode, message, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|100|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0132, code lost:
    
        if (r11 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01be, code lost:
    
        r1 = r8.fallbackUrl(r8.sdkConfig.getUploaderConfig().getImageHost(), r4);
        r4 = r4;
        r5 = r5;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0028. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0251 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f5 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #2 {all -> 0x005d, blocks: (B:38:0x0058, B:39:0x01f1, B:41:0x01f5), top: B:37:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01af A[Catch: all -> 0x01be, TRY_LEAVE, TryCatch #3 {all -> 0x01be, blocks: (B:49:0x006f, B:50:0x01a5, B:52:0x01af, B:65:0x018b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r1v42, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v30, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r8v25, types: [java.lang.Object, com.bytedance.trae.conversation.imageupload.ImageUploadService] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.bytedance.trae.conversation.imageupload.ImageUploadService] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object uploadOnce(File file, ImageDimension imageDimension, Function1<? super Integer, Unit> function1, long j, Continuation<? super ImageUploadResult> continuation) {
        ImageUploadService$uploadOnce$1 imageUploadService$uploadOnce$1;
        ?? r4;
        String fallbackUrl;
        File file2;
        String str;
        String str2;
        ImageUploadService imageUploadService;
        Object checkImageContent;
        ImageUploadService imageUploadService2;
        File file3;
        String str3;
        String str4;
        ContentCheckResult contentCheckResult;
        ?? r8;
        Function2<String, ImageCacheData, Unit> onImageCached;
        ImageDimension imageDimension2;
        Function1<? super Integer, Unit> function12;
        long j2;
        File file4;
        ImageUploadService imageUploadService3;
        String str5;
        Function0<String> getImagexPrefix;
        String str6;
        Function1<? super Integer, Unit> function13;
        String str7;
        long j3;
        ImageUploadService imageUploadService4;
        String str8;
        File file5;
        ImageDimension imageDimension3;
        File file6;
        ImageUploadService imageUploadService5;
        if (continuation instanceof ImageUploadService$uploadOnce$1) {
            imageUploadService$uploadOnce$1 = (ImageUploadService$uploadOnce$1) continuation;
            if ((imageUploadService$uploadOnce$1.label & Integer.MIN_VALUE) != 0) {
                imageUploadService$uploadOnce$1.label -= Integer.MIN_VALUE;
                Object obj = imageUploadService$uploadOnce$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                r4 = imageUploadService$uploadOnce$1.label;
                ?? r5 = 1;
                ContentCheckResult contentCheckResult2 = null;
                switch (r4) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Function0<Boolean> isCnRegion = this.sdkConfig.isCnRegion();
                        if (isCnRegion != null) {
                            ((Boolean) isCnRegion.invoke()).booleanValue();
                        } else {
                            defaultIsCnRegion();
                        }
                        String str9 = AppHost.INSTANCE.isOversea() ? "i18n" : "cn";
                        Function1<Continuation<? super String>, Object> getUserId = this.sdkConfig.getGetUserId();
                        imageUploadService$uploadOnce$1.L$0 = this;
                        imageUploadService$uploadOnce$1.L$1 = file;
                        imageDimension2 = imageDimension;
                        imageUploadService$uploadOnce$1.L$2 = imageDimension2;
                        function12 = function1;
                        imageUploadService$uploadOnce$1.L$3 = function12;
                        imageUploadService$uploadOnce$1.L$4 = str9;
                        imageUploadService$uploadOnce$1.J$0 = j;
                        imageUploadService$uploadOnce$1.label = 1;
                        Object invoke = getUserId.invoke(imageUploadService$uploadOnce$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        j2 = j;
                        file4 = file;
                        imageUploadService3 = this;
                        str5 = str9;
                        obj = invoke;
                        String str10 = (String) obj;
                        getImagexPrefix = imageUploadService3.sdkConfig.getGetImagexPrefix();
                        if (getImagexPrefix != null && (str6 = (String) getImagexPrefix.invoke()) != null) {
                            if (!(true ^ StringsKt.isBlank(str6))) {
                                str6 = null;
                                break;
                            }
                        }
                        str6 = str10;
                        StsTokenManager stsTokenManager = imageUploadService3.tokenManager;
                        imageUploadService$uploadOnce$1.L$0 = imageUploadService3;
                        imageUploadService$uploadOnce$1.L$1 = file4;
                        imageUploadService$uploadOnce$1.L$2 = imageDimension2;
                        imageUploadService$uploadOnce$1.L$3 = function12;
                        imageUploadService$uploadOnce$1.L$4 = str5;
                        imageUploadService$uploadOnce$1.L$5 = str6;
                        imageUploadService$uploadOnce$1.J$0 = j2;
                        imageUploadService$uploadOnce$1.label = 2;
                        obj = stsTokenManager.getToken(str10, imageUploadService$uploadOnce$1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function13 = function12;
                        ImageDimension imageDimension4 = imageDimension2;
                        str7 = str5;
                        j3 = j2;
                        imageUploadService4 = imageUploadService3;
                        str8 = str6;
                        file5 = file4;
                        imageDimension3 = imageDimension4;
                        String generate = StoreKeyGenerator.INSTANCE.generate(file5, str8, str7, imageDimension3);
                        ImageUploadService imageUploadService6 = imageUploadService4;
                        File file7 = file5;
                        ImageUploadService$uploadOnce$tosUri$1 imageUploadService$uploadOnce$tosUri$1 = new ImageUploadService$uploadOnce$tosUri$1(imageUploadService4, file5, generate, (StsTokenData) obj, function13, null);
                        imageUploadService$uploadOnce$1.L$0 = imageUploadService6;
                        imageUploadService$uploadOnce$1.L$1 = file7;
                        imageUploadService$uploadOnce$1.L$2 = null;
                        imageUploadService$uploadOnce$1.L$3 = null;
                        imageUploadService$uploadOnce$1.L$4 = null;
                        imageUploadService$uploadOnce$1.L$5 = null;
                        imageUploadService$uploadOnce$1.label = 3;
                        obj = TimeoutKt.withTimeout(j3, imageUploadService$uploadOnce$tosUri$1, imageUploadService$uploadOnce$1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        file6 = file7;
                        imageUploadService5 = imageUploadService6;
                        String str11 = (String) obj;
                        ImageUploadApi api = imageUploadService5.sdkConfig.getApi();
                        List<String> listOf = CollectionsKt.listOf(str11);
                        imageUploadService$uploadOnce$1.L$0 = imageUploadService5;
                        imageUploadService$uploadOnce$1.L$1 = file6;
                        imageUploadService$uploadOnce$1.L$2 = str11;
                        imageUploadService$uploadOnce$1.label = 4;
                        obj = api.getImageUrls(listOf, imageUploadService$uploadOnce$1);
                        r4 = str11;
                        r5 = file6;
                        r8 = imageUploadService5;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fallbackUrl = (String) ((Map) obj).get(r4);
                        str = r4;
                        file2 = r5;
                        if (fallbackUrl == null) {
                            fallbackUrl = r8.fallbackUrl(r8.sdkConfig.getUploaderConfig().getImageHost(), r4);
                            str = r4;
                            file2 = r5;
                        }
                        if (r8.sdkConfig.getEnableContentCheck()) {
                            try {
                                ImageUploadApi api2 = r8.sdkConfig.getApi();
                                imageUploadService$uploadOnce$1.L$0 = r8;
                                imageUploadService$uploadOnce$1.L$1 = file2;
                                imageUploadService$uploadOnce$1.L$2 = str;
                                imageUploadService$uploadOnce$1.L$3 = fallbackUrl;
                                imageUploadService$uploadOnce$1.label = 5;
                                checkImageContent = api2.checkImageContent(str, imageUploadService$uploadOnce$1);
                            } catch (Throwable unused) {
                                str2 = fallbackUrl;
                                imageUploadService = r8;
                                r8 = imageUploadService;
                                fallbackUrl = str2;
                                str = str;
                                file2 = file2;
                                if (contentCheckResult2 != null) {
                                }
                                onImageCached = r8.sdkConfig.getOnImageCached();
                                if (onImageCached != null) {
                                }
                                return new ImageUploadResult(fallbackUrl, str);
                            }
                            if (checkImageContent == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            imageUploadService2 = r8;
                            file3 = file2;
                            str3 = str;
                            str4 = fallbackUrl;
                            obj = checkImageContent;
                            contentCheckResult = (ContentCheckResult) obj;
                            if (contentCheckResult != null) {
                                ImageUploadApi api3 = imageUploadService2.sdkConfig.getApi();
                                imageUploadService$uploadOnce$1.L$0 = imageUploadService2;
                                imageUploadService$uploadOnce$1.L$1 = file3;
                                imageUploadService$uploadOnce$1.L$2 = str3;
                                imageUploadService$uploadOnce$1.L$3 = str4;
                                imageUploadService$uploadOnce$1.label = 6;
                                obj = api3.checkImageContent(str4, imageUploadService$uploadOnce$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                str2 = str4;
                                str = str3;
                                file2 = file3;
                                imageUploadService = imageUploadService2;
                                contentCheckResult2 = (ContentCheckResult) obj;
                                imageUploadService2 = imageUploadService;
                                file3 = file2;
                                str3 = str;
                                str4 = str2;
                                fallbackUrl = str4;
                                str = str3;
                                file2 = file3;
                                r8 = imageUploadService2;
                                if (contentCheckResult2 != null && contentCheckResult2.getCode() == 0 && Intrinsics.areEqual(contentCheckResult2.getPass(), Boxing.boxBoolean(false))) {
                                    throw new ImageUploadException(ImageUploadErrorCode.CONTENT_CHECK_FAILED, "Image content does not meet requirements", null, 4, null);
                                }
                            } else {
                                contentCheckResult2 = contentCheckResult;
                                fallbackUrl = str4;
                                str = str3;
                                file2 = file3;
                                r8 = imageUploadService2;
                                if (contentCheckResult2 != null) {
                                    throw new ImageUploadException(ImageUploadErrorCode.CONTENT_CHECK_FAILED, "Image content does not meet requirements", null, 4, null);
                                }
                            }
                        }
                        onImageCached = r8.sdkConfig.getOnImageCached();
                        if (onImageCached != null) {
                            try {
                                String encodeToString = Base64.encodeToString(FilesKt.readBytes(file2), 2);
                                Intrinsics.checkNotNull(encodeToString);
                                onImageCached.invoke(str, new ImageCacheData(encodeToString, fallbackUrl));
                            } catch (Throwable unused2) {
                            }
                        }
                        return new ImageUploadResult(fallbackUrl, str);
                    case 1:
                        long j4 = imageUploadService$uploadOnce$1.J$0;
                        str5 = (String) imageUploadService$uploadOnce$1.L$4;
                        function12 = (Function1) imageUploadService$uploadOnce$1.L$3;
                        ImageDimension imageDimension5 = (ImageDimension) imageUploadService$uploadOnce$1.L$2;
                        file4 = (File) imageUploadService$uploadOnce$1.L$1;
                        ImageUploadService imageUploadService7 = (ImageUploadService) imageUploadService$uploadOnce$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        imageDimension2 = imageDimension5;
                        imageUploadService3 = imageUploadService7;
                        j2 = j4;
                        String str102 = (String) obj;
                        getImagexPrefix = imageUploadService3.sdkConfig.getGetImagexPrefix();
                        if (getImagexPrefix != null) {
                            if (!(true ^ StringsKt.isBlank(str6))) {
                            }
                            break;
                        }
                        str6 = str102;
                        StsTokenManager stsTokenManager2 = imageUploadService3.tokenManager;
                        imageUploadService$uploadOnce$1.L$0 = imageUploadService3;
                        imageUploadService$uploadOnce$1.L$1 = file4;
                        imageUploadService$uploadOnce$1.L$2 = imageDimension2;
                        imageUploadService$uploadOnce$1.L$3 = function12;
                        imageUploadService$uploadOnce$1.L$4 = str5;
                        imageUploadService$uploadOnce$1.L$5 = str6;
                        imageUploadService$uploadOnce$1.J$0 = j2;
                        imageUploadService$uploadOnce$1.label = 2;
                        obj = stsTokenManager2.getToken(str102, imageUploadService$uploadOnce$1);
                        if (obj != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        j3 = imageUploadService$uploadOnce$1.J$0;
                        str8 = (String) imageUploadService$uploadOnce$1.L$5;
                        str7 = (String) imageUploadService$uploadOnce$1.L$4;
                        Function1<? super Integer, Unit> function14 = (Function1) imageUploadService$uploadOnce$1.L$3;
                        imageDimension3 = (ImageDimension) imageUploadService$uploadOnce$1.L$2;
                        File file8 = (File) imageUploadService$uploadOnce$1.L$1;
                        imageUploadService4 = (ImageUploadService) imageUploadService$uploadOnce$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        function13 = function14;
                        file5 = file8;
                        String generate2 = StoreKeyGenerator.INSTANCE.generate(file5, str8, str7, imageDimension3);
                        ImageUploadService imageUploadService62 = imageUploadService4;
                        File file72 = file5;
                        ImageUploadService$uploadOnce$tosUri$1 imageUploadService$uploadOnce$tosUri$12 = new ImageUploadService$uploadOnce$tosUri$1(imageUploadService4, file5, generate2, (StsTokenData) obj, function13, null);
                        imageUploadService$uploadOnce$1.L$0 = imageUploadService62;
                        imageUploadService$uploadOnce$1.L$1 = file72;
                        imageUploadService$uploadOnce$1.L$2 = null;
                        imageUploadService$uploadOnce$1.L$3 = null;
                        imageUploadService$uploadOnce$1.L$4 = null;
                        imageUploadService$uploadOnce$1.L$5 = null;
                        imageUploadService$uploadOnce$1.label = 3;
                        obj = TimeoutKt.withTimeout(j3, imageUploadService$uploadOnce$tosUri$12, imageUploadService$uploadOnce$1);
                        if (obj != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        File file9 = (File) imageUploadService$uploadOnce$1.L$1;
                        ImageUploadService imageUploadService8 = (ImageUploadService) imageUploadService$uploadOnce$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        imageUploadService5 = imageUploadService8;
                        file6 = file9;
                        String str112 = (String) obj;
                        ImageUploadApi api4 = imageUploadService5.sdkConfig.getApi();
                        List<String> listOf2 = CollectionsKt.listOf(str112);
                        imageUploadService$uploadOnce$1.L$0 = imageUploadService5;
                        imageUploadService$uploadOnce$1.L$1 = file6;
                        imageUploadService$uploadOnce$1.L$2 = str112;
                        imageUploadService$uploadOnce$1.label = 4;
                        obj = api4.getImageUrls(listOf2, imageUploadService$uploadOnce$1);
                        r4 = str112;
                        r5 = file6;
                        r8 = imageUploadService5;
                        if (obj == coroutine_suspended) {
                        }
                        fallbackUrl = (String) ((Map) obj).get(r4);
                        str = r4;
                        file2 = r5;
                        if (fallbackUrl == null) {
                        }
                        if (r8.sdkConfig.getEnableContentCheck()) {
                        }
                        onImageCached = r8.sdkConfig.getOnImageCached();
                        if (onImageCached != null) {
                        }
                        return new ImageUploadResult(fallbackUrl, str);
                    case 4:
                        String str12 = (String) imageUploadService$uploadOnce$1.L$2;
                        File file10 = (File) imageUploadService$uploadOnce$1.L$1;
                        ImageUploadService imageUploadService9 = (ImageUploadService) imageUploadService$uploadOnce$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        r4 = str12;
                        r5 = file10;
                        r8 = imageUploadService9;
                        fallbackUrl = (String) ((Map) obj).get(r4);
                        str = r4;
                        file2 = r5;
                        if (fallbackUrl == null) {
                        }
                        if (r8.sdkConfig.getEnableContentCheck()) {
                        }
                        onImageCached = r8.sdkConfig.getOnImageCached();
                        if (onImageCached != null) {
                        }
                        return new ImageUploadResult(fallbackUrl, str);
                    case 5:
                        str4 = (String) imageUploadService$uploadOnce$1.L$3;
                        str3 = (String) imageUploadService$uploadOnce$1.L$2;
                        file3 = (File) imageUploadService$uploadOnce$1.L$1;
                        imageUploadService2 = (ImageUploadService) imageUploadService$uploadOnce$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            contentCheckResult = (ContentCheckResult) obj;
                            if (contentCheckResult != null) {
                            }
                        } catch (Throwable unused3) {
                            str2 = str4;
                            str = str3;
                            file2 = file3;
                            imageUploadService = imageUploadService2;
                            r8 = imageUploadService;
                            fallbackUrl = str2;
                            str = str;
                            file2 = file2;
                            if (contentCheckResult2 != null) {
                            }
                            onImageCached = r8.sdkConfig.getOnImageCached();
                            if (onImageCached != null) {
                            }
                            return new ImageUploadResult(fallbackUrl, str);
                        }
                        break;
                    case 6:
                        str2 = (String) imageUploadService$uploadOnce$1.L$3;
                        str = (String) imageUploadService$uploadOnce$1.L$2;
                        file2 = (File) imageUploadService$uploadOnce$1.L$1;
                        imageUploadService = (ImageUploadService) imageUploadService$uploadOnce$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            str = str;
                            file2 = file2;
                            contentCheckResult2 = (ContentCheckResult) obj;
                            imageUploadService2 = imageUploadService;
                            file3 = file2;
                            str3 = str;
                            str4 = str2;
                            fallbackUrl = str4;
                            str = str3;
                            file2 = file3;
                            r8 = imageUploadService2;
                        } catch (Throwable unused4) {
                            r8 = imageUploadService;
                            fallbackUrl = str2;
                            str = str;
                            file2 = file2;
                            if (contentCheckResult2 != null) {
                            }
                            onImageCached = r8.sdkConfig.getOnImageCached();
                            if (onImageCached != null) {
                            }
                            return new ImageUploadResult(fallbackUrl, str);
                        }
                        if (contentCheckResult2 != null) {
                        }
                        onImageCached = r8.sdkConfig.getOnImageCached();
                        if (onImageCached != null) {
                        }
                        return new ImageUploadResult(fallbackUrl, str);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        imageUploadService$uploadOnce$1 = new ImageUploadService$uploadOnce$1(this, continuation);
        Object obj2 = imageUploadService$uploadOnce$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r4 = imageUploadService$uploadOnce$1.label;
        ?? r52 = 1;
        ContentCheckResult contentCheckResult22 = null;
        switch (r4) {
        }
    }

    private final String fallbackUrl(String imageHost, String tosUri) {
        if (!StringsKt.startsWith$default(imageHost, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(imageHost, "https://", false, 2, (Object) null)) {
            imageHost = "https://" + imageHost;
        }
        return imageHost + '/' + tosUri;
    }

    public final void close() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new ImageUploadService$close$1(this, null), 3, (Object) null);
    }
}

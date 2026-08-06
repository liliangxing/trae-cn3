package coil3.decode;

import android.content.res.AssetFileDescriptor;
import android.graphics.ImageDecoder;
import android.util.Size;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.decode.Decoder;
import coil3.decode.ImageSource;
import coil3.decode.StaticImageDecoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_commonKt;
import coil3.request.Options;
import coil3.size.Scale;
import coil3.util.BitmapsKt;
import coil3.util.IntPair;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.FileSystem;
import okio.Path;

/* compiled from: StaticImageDecoder.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0014B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0006j\u0002`\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00060\u0006j\u0002`\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil3/decode/StaticImageDecoder;", "Lcoil3/decode/Decoder;", "source", "Landroid/graphics/ImageDecoder$Source;", "closeable", "Lkotlin/AutoCloseable;", "Ljava/lang/AutoCloseable;", "options", "Lcoil3/request/Options;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "<init>", "(Landroid/graphics/ImageDecoder$Source;Ljava/lang/AutoCloseable;Lcoil3/request/Options;Lkotlinx/coroutines/sync/Semaphore;)V", "Ljava/lang/AutoCloseable;", "decode", "Lcoil3/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureImageDecoderProperties", "", "Landroid/graphics/ImageDecoder;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class StaticImageDecoder implements Decoder {
    private final AutoCloseable closeable;
    private final Options options;
    private final Semaphore parallelismLock;
    private final ImageDecoder.Source source;

    public StaticImageDecoder(ImageDecoder.Source source, AutoCloseable autoCloseable, Options options, Semaphore semaphore) {
        this.source = source;
        this.closeable = autoCloseable;
        this.options = options;
        this.parallelismLock = semaphore;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: all -> 0x0094, DONT_GENERATE, TryCatch #1 {all -> 0x0094, blocks: (B:11:0x004e, B:14:0x0072, B:16:0x0078, B:17:0x007b, B:23:0x0085, B:25:0x008b, B:26:0x008e, B:27:0x0093, B:13:0x0058), top: B:10:0x004e, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // coil3.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object decode(Continuation<? super DecodeResult> continuation) {
        StaticImageDecoder$decode$1 staticImageDecoder$decode$1;
        int i;
        final StaticImageDecoder staticImageDecoder;
        Semaphore semaphore;
        final Ref.ObjectRef objectRef;
        try {
            try {
                if (continuation instanceof StaticImageDecoder$decode$1) {
                    staticImageDecoder$decode$1 = (StaticImageDecoder$decode$1) continuation;
                    if ((staticImageDecoder$decode$1.label & Integer.MIN_VALUE) != 0) {
                        staticImageDecoder$decode$1.label -= Integer.MIN_VALUE;
                        Object obj = staticImageDecoder$decode$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = staticImageDecoder$decode$1.label;
                        if (i != 0) {
                            ResultKt.throwOnFailure(obj);
                            Semaphore semaphore2 = this.parallelismLock;
                            staticImageDecoder$decode$1.L$0 = this;
                            staticImageDecoder$decode$1.L$1 = semaphore2;
                            staticImageDecoder$decode$1.label = 1;
                            if (semaphore2.acquire(staticImageDecoder$decode$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            staticImageDecoder = this;
                            semaphore = semaphore2;
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            semaphore = (Semaphore) staticImageDecoder$decode$1.L$1;
                            staticImageDecoder = (StaticImageDecoder) staticImageDecoder$decode$1.L$0;
                            ResultKt.throwOnFailure(obj);
                        }
                        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                        objectRef = new Ref.ObjectRef();
                        return new DecodeResult(Image_androidKt.asImage(ImageDecoder.decodeBitmap(staticImageDecoder.source, new ImageDecoder.OnHeaderDecodedListener() { // from class: coil3.decode.StaticImageDecoder$decode$lambda$1$$inlined$decodeBitmap$1
                            /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
                            
                                if (r2.getPrecision() == coil3.size.Precision.EXACT) goto L15;
                             */
                            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                                Options options;
                                Options options2;
                                Options options3;
                                Options options4;
                                Options options5;
                                objectRef.element = imageDecoder;
                                Size size = imageInfo.getSize();
                                int width = size.getWidth();
                                int height = size.getHeight();
                                options = staticImageDecoder.options;
                                coil3.size.Size size2 = options.getSize();
                                options2 = staticImageDecoder.options;
                                Scale scale = options2.getScale();
                                options3 = staticImageDecoder.options;
                                long m3237computeDstSizesEdh43o = DecodeUtils.m3237computeDstSizesEdh43o(width, height, size2, scale, ImageRequests_commonKt.getMaxBitmapSize(options3));
                                int m3278getFirstimpl = IntPair.m3278getFirstimpl(m3237computeDstSizesEdh43o);
                                int m3279getSecondimpl = IntPair.m3279getSecondimpl(m3237computeDstSizesEdh43o);
                                if (width > 0 && height > 0 && (width != m3278getFirstimpl || height != m3279getSecondimpl)) {
                                    options4 = staticImageDecoder.options;
                                    double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, m3278getFirstimpl, m3279getSecondimpl, options4.getScale());
                                    booleanRef.element = computeSizeMultiplier < 1.0d;
                                    if (!booleanRef.element) {
                                        options5 = staticImageDecoder.options;
                                    }
                                    imageDecoder.setTargetSize(MathKt.roundToInt(width * computeSizeMultiplier), MathKt.roundToInt(computeSizeMultiplier * height));
                                }
                                staticImageDecoder.configureImageDecoderProperties(imageDecoder);
                            }
                        }), true), booleanRef.element);
                    }
                }
                return new DecodeResult(Image_androidKt.asImage(ImageDecoder.decodeBitmap(staticImageDecoder.source, new ImageDecoder.OnHeaderDecodedListener() { // from class: coil3.decode.StaticImageDecoder$decode$lambda$1$$inlined$decodeBitmap$1
                    /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
                    
                        if (r2.getPrecision() == coil3.size.Precision.EXACT) goto L15;
                     */
                    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        Options options;
                        Options options2;
                        Options options3;
                        Options options4;
                        Options options5;
                        objectRef.element = imageDecoder;
                        Size size = imageInfo.getSize();
                        int width = size.getWidth();
                        int height = size.getHeight();
                        options = staticImageDecoder.options;
                        coil3.size.Size size2 = options.getSize();
                        options2 = staticImageDecoder.options;
                        Scale scale = options2.getScale();
                        options3 = staticImageDecoder.options;
                        long m3237computeDstSizesEdh43o = DecodeUtils.m3237computeDstSizesEdh43o(width, height, size2, scale, ImageRequests_commonKt.getMaxBitmapSize(options3));
                        int m3278getFirstimpl = IntPair.m3278getFirstimpl(m3237computeDstSizesEdh43o);
                        int m3279getSecondimpl = IntPair.m3279getSecondimpl(m3237computeDstSizesEdh43o);
                        if (width > 0 && height > 0 && (width != m3278getFirstimpl || height != m3279getSecondimpl)) {
                            options4 = staticImageDecoder.options;
                            double computeSizeMultiplier = DecodeUtils.computeSizeMultiplier(width, height, m3278getFirstimpl, m3279getSecondimpl, options4.getScale());
                            booleanRef.element = computeSizeMultiplier < 1.0d;
                            if (!booleanRef.element) {
                                options5 = staticImageDecoder.options;
                            }
                            imageDecoder.setTargetSize(MathKt.roundToInt(width * computeSizeMultiplier), MathKt.roundToInt(computeSizeMultiplier * height));
                        }
                        staticImageDecoder.configureImageDecoderProperties(imageDecoder);
                    }
                }), true), booleanRef.element);
            } finally {
                ImageDecoder imageDecoder = (ImageDecoder) objectRef.element;
                if (imageDecoder != null) {
                    imageDecoder.close();
                }
                staticImageDecoder.closeable.close();
            }
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            objectRef = new Ref.ObjectRef();
        } finally {
            semaphore.release();
        }
        staticImageDecoder$decode$1 = new StaticImageDecoder$decode$1(this, continuation);
        Object obj2 = staticImageDecoder$decode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = staticImageDecoder$decode$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureImageDecoderProperties(ImageDecoder imageDecoder) {
        imageDecoder.setAllocator(BitmapsKt.isHardware(ImageRequestsKt.getBitmapConfig(this.options)) ? 3 : 1);
        imageDecoder.setMemorySizePolicy(!ImageRequestsKt.getAllowRgb565(this.options) ? 1 : 0);
        if (ImageRequestsKt.getColorSpace(this.options) != null) {
            imageDecoder.setTargetColorSpace(ImageRequestsKt.getColorSpace(this.options));
        }
        imageDecoder.setUnpremultipliedRequired(!ImageRequestsKt.getPremultipliedAlpha(this.options));
    }

    /* compiled from: StaticImageDecoder.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcoil3/decode/StaticImageDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "parallelismLock", "Lkotlinx/coroutines/sync/Semaphore;", "<init>", "(Lkotlinx/coroutines/sync/Semaphore;)V", "create", "Lcoil3/decode/Decoder;", StrategyConstants.RESULT, "Lcoil3/fetch/SourceFetchResult;", "options", "Lcoil3/request/Options;", "imageLoader", "Lcoil3/ImageLoader;", "imageDecoderSourceOrNull", "Landroid/graphics/ImageDecoder$Source;", "Lcoil3/decode/ImageSource;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Factory implements Decoder.Factory {
        private final Semaphore parallelismLock;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Factory() {
            this(r0, 1, r0);
            Semaphore semaphore = null;
        }

        public Factory(Semaphore semaphore) {
            this.parallelismLock = semaphore;
        }

        public /* synthetic */ Factory(Semaphore semaphore, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? SemaphoreKt.Semaphore$default(4, 0, 2, (Object) null) : semaphore);
        }

        @Override // coil3.decode.Decoder.Factory
        public Decoder create(SourceFetchResult result, Options options, ImageLoader imageLoader) {
            ImageDecoder.Source imageDecoderSourceOrNull = imageDecoderSourceOrNull(result.getSource(), options);
            if (imageDecoderSourceOrNull == null) {
                return null;
            }
            return new StaticImageDecoder(imageDecoderSourceOrNull, result.getSource(), options, this.parallelismLock);
        }

        private final ImageDecoder.Source imageDecoderSourceOrNull(ImageSource imageSource, Options options) {
            Path fileOrNull;
            if (Intrinsics.areEqual(imageSource.getFileSystem(), FileSystem.SYSTEM) && (fileOrNull = imageSource.fileOrNull()) != null) {
                return ImageDecoder.createSource(fileOrNull.toFile());
            }
            final ImageSource.Metadata metadata = imageSource.getMetadata();
            if (metadata instanceof AssetMetadata) {
                return ImageDecoder.createSource(options.getContext().getAssets(), ((AssetMetadata) metadata).getFilePath());
            }
            if (metadata instanceof ContentMetadata) {
                return ImageDecoder.createSource((Callable<AssetFileDescriptor>) new Callable() { // from class: coil3.decode.StaticImageDecoder$Factory$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        AssetFileDescriptor imageDecoderSourceOrNull$lambda$0;
                        imageDecoderSourceOrNull$lambda$0 = StaticImageDecoder.Factory.imageDecoderSourceOrNull$lambda$0(ImageSource.Metadata.this);
                        return imageDecoderSourceOrNull$lambda$0;
                    }
                });
            }
            if (metadata instanceof ResourceMetadata) {
                ResourceMetadata resourceMetadata = (ResourceMetadata) metadata;
                if (Intrinsics.areEqual(resourceMetadata.getPackageName(), options.getContext().getPackageName())) {
                    return ImageDecoder.createSource(options.getContext().getResources(), resourceMetadata.getResId());
                }
            }
            if (metadata instanceof ByteBufferMetadata) {
                return ImageDecoder.createSource(((ByteBufferMetadata) metadata).getByteBuffer());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AssetFileDescriptor imageDecoderSourceOrNull$lambda$0(ImageSource.Metadata metadata) {
            return ((ContentMetadata) metadata).getAssetFileDescriptor();
        }
    }
}

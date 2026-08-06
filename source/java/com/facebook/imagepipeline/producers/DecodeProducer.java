package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import com.bytedance.webx.addr.AddressParam;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageOOMOptStrategy;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveAwebpParser;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.exception.BDErrorCodeConst;
import com.facebook.imagepipeline.exception.BDException;
import com.facebook.imagepipeline.exception.IBDException;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PieDecoder;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.HeifFormatUtil;
import com.facebook.imageutils.JfifUtil;
import com.huawei.hms.android.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DecodeProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_BITMAP_CONFIG = "extra_bitmap_config";
    public static final String EXTRA_BITMAP_RAM_SIZE = "bitmapRamSize";
    public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
    public static final String EXTRA_BLACK_SUSPECTED = "black_suspected";
    public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
    public static final String EXTRA_HDR_TYPE = "hdr_type";
    public static final String EXTRA_HEIC_CUSTOM_DECODER = "heic_custom_decoder";
    public static final String EXTRA_HEIC_DECODE_ERROR = "heic_decode_error";
    public static final String EXTRA_HEIC_SYS_FIRST = "heic_sys_first";
    public static final String EXTRA_IMAGE_COUNT = "imageCount";
    public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
    public static final String EXTRA_IMAGE_QUALITY = "imageQuality";
    public static final String EXTRA_IS_CROP = "isCrop";
    public static final String EXTRA_IS_FINAL = "isFinal";
    public static final String EXTRA_NORMAL = "normal";
    public static final String EXTRA_NOT_STATIC_IMAGE = "not_static_image";
    public static final String EXTRA_PREVIEW_ALGO = "preview_algo";
    public static final String EXTRA_PREVIEW_DECODE_END = "preview_decode_end";
    public static final String EXTRA_PREVIEW_DECODE_TIME = "preview_hash_decode_duration";
    public static final String EXTRA_PREVIEW_DURATION = "preview_duration";
    public static final String EXTRA_PREVIEW_ERROR = "preview_error";
    public static final String EXTRA_PREVIEW_USED = "preview_used";
    public static final String EXTRA_REGION_TO_DECODE = "regionToDecode";
    public static final String EXTRA_THUMB_DECODE_DURATION = "thumb_decode_duration";
    public static final String EXTRA_THUMB_FILE_SIZE = "thumb_file_size";
    public static final String EXTRA_TRANSPARENT_SUSPECTED = "transparent_suspected";
    public static final String EXTRA_WHITE_SUSPECTED = "white_suspected";
    public static final String PRODUCER_NAME = "DecodeProducer";
    public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
    public static final String SAMPLE_SIZE = "sampleSize";
    private final ByteArrayPool mByteArrayPool;
    private final boolean mDecodeCancellationEnabled;
    private final boolean mDownsampleEnabled;
    private final boolean mDownsampleEnabledForNetwork;
    private final Executor mExecutor;
    private final ImageDecoder mImageDecoder;
    private final Producer<EncodedImage> mInputProducer;
    private final int mMaxBitmapSize;
    private final boolean mOomOptEnabled;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer, int i) {
        this(byteArrayPool, executor, imageDecoder, progressiveJpegConfig, z, z2, z3, producer, i, false);
    }

    public DecodeProducer(ByteArrayPool byteArrayPool, Executor executor, ImageDecoder imageDecoder, ProgressiveJpegConfig progressiveJpegConfig, boolean z, boolean z2, boolean z3, Producer<EncodedImage> producer, int i, boolean z4) {
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mImageDecoder = (ImageDecoder) Preconditions.checkNotNull(imageDecoder);
        this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
        this.mDownsampleEnabled = z;
        this.mDownsampleEnabledForNetwork = z2;
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mDecodeCancellationEnabled = z3;
        this.mMaxBitmapSize = i;
        this.mOomOptEnabled = z4;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        Consumer<EncodedImage> networkImagesProgressiveDecoder;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DecodeProducer#produceResults");
            }
            if (!UriUtil.isNetworkUri(producerContext.getImageRequest().getSourceUri())) {
                networkImagesProgressiveDecoder = new LocalImagesProgressiveDecoder(consumer, producerContext, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
            } else {
                networkImagesProgressiveDecoder = new NetworkImagesProgressiveDecoder(consumer, producerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, new ProgressiveAwebpParser(this.mByteArrayPool), this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
            }
            this.mInputProducer.produceResults(networkImagesProgressiveDecoder, producerContext);
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private abstract class ProgressiveDecoder extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>> {
        private static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
        private final String TAG;
        private final ImageDecodeOptions mImageDecodeOptions;
        private boolean mIsFinished;
        private AtomicBoolean mIsFirstJob;
        private final JobScheduler mJobScheduler;
        private final ProducerContext mProducerContext;
        private final ProducerListener mProducerListener;

        protected abstract int getIntermediateImageEndOffset(EncodedImage encodedImage);

        protected abstract QualityInfo getQualityInfo();

        public ProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, final ProducerContext producerContext, final boolean z, final int i) {
            super(consumer);
            this.TAG = "ProgressiveDecoder";
            this.mIsFirstJob = new AtomicBoolean(true);
            this.mProducerContext = producerContext;
            this.mProducerListener = producerContext.getListener();
            ImageDecodeOptions imageDecodeOptions = producerContext.getImageRequest().getImageDecodeOptions();
            this.mImageDecodeOptions = imageDecodeOptions;
            this.mIsFinished = false;
            this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, new JobScheduler.PriorityJobRunnable(producerContext.getPriority()) { // from class: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, int i2) {
                    if (encodedImage != null) {
                        ProgressiveDecoder.this.setDecodeStatus(encodedImage, i2);
                        if (DecodeProducer.this.mDownsampleEnabled && !BaseConsumer.statusHasFlag(i2, 16)) {
                            ImageRequest imageRequest = producerContext.getImageRequest();
                            if (DecodeProducer.this.mDownsampleEnabledForNetwork || !UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                                ResizeOptions resizeOptions = imageRequest.getResizeOptions();
                                if (resizeOptions == null && ImageResizeOptionStrategy.getStrategy() != null) {
                                    resizeOptions = ImageResizeOptionStrategy.getStrategy().getResizeConfig(imageRequest.getSourceUri(), encodedImage.getViewWidth(), encodedImage.getViewHeight(), encodedImage.getWidth(), encodedImage.getHeight(), encodedImage.hasAlpha() || encodedImage.is10Bit(), encodedImage.getImageFormat());
                                }
                                if (imageRequest.getSampleSize() != -1) {
                                    encodedImage.setSampleSize(imageRequest.getSampleSize());
                                } else {
                                    encodedImage.setSampleSize(DownsampleUtil.determineSampleSize(imageRequest.getRotationOptions(), resizeOptions, encodedImage, i));
                                }
                            }
                        }
                        ProgressiveDecoder.this.doDecode(encodedImage, i2);
                    }
                }
            }, imageDecodeOptions.minDecodeIntervalMs);
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder.2
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
                        ProgressiveDecoder.this.mJobScheduler.scheduleJob();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    if (z) {
                        ProgressiveDecoder.this.handleCancellation();
                    }
                }
            });
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            boolean isTracing;
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("DecodeProducer#onNewResultImpl");
                }
                boolean isLast = isLast(i);
                if (isLast && !EncodedImage.isValid(encodedImage)) {
                    handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
                    if (isTracing) {
                        return;
                    } else {
                        return;
                    }
                }
                if (!updateDecodeJob(encodedImage, i)) {
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                        return;
                    }
                    return;
                }
                boolean statusHasFlag = statusHasFlag(i, 4);
                if (isLast || statusHasFlag || this.mProducerContext.isIntermediateResultExpected()) {
                    this.mJobScheduler.scheduleJob();
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } finally {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onProgressUpdateImpl(float f) {
            super.onProgressUpdateImpl(f * 0.99f);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            handleError(th);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            handleCancellation();
        }

        protected boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            return this.mJobScheduler.updateJob(encodedImage, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:100:0x0504  */
        /* JADX WARN: Removed duplicated region for block: B:103:0x0510  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x0513  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0507  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x03f4  */
        /* JADX WARN: Removed duplicated region for block: B:128:0x0410 A[Catch: all -> 0x0114, TryCatch #14 {all -> 0x0114, blocks: (B:31:0x010f, B:35:0x0126, B:240:0x0140, B:242:0x0144, B:245:0x014b, B:246:0x0155, B:224:0x0170, B:226:0x017c, B:228:0x0190, B:230:0x0196, B:56:0x0230, B:58:0x0238, B:60:0x0240, B:62:0x0248, B:65:0x0286, B:147:0x0260, B:149:0x026c, B:151:0x0272, B:153:0x0278, B:155:0x027e, B:177:0x02bc, B:193:0x031e, B:194:0x032b, B:160:0x0354, B:161:0x036f, B:118:0x03de, B:121:0x03f6, B:125:0x03fd, B:126:0x03fe, B:128:0x0410, B:129:0x0417, B:137:0x045e, B:139:0x0472, B:81:0x0484, B:83:0x048a, B:87:0x04ad, B:70:0x03a1, B:73:0x03bc, B:74:0x03d2, B:47:0x01b3, B:49:0x01b9, B:51:0x01c5, B:53:0x021f, B:215:0x01d3, B:217:0x01df, B:219:0x01f5, B:221:0x020b), top: B:30:0x010f }] */
        /* JADX WARN: Removed duplicated region for block: B:133:0x044f A[Catch: all -> 0x051e, TryCatch #20 {all -> 0x051e, blocks: (B:185:0x02fe, B:187:0x0304, B:131:0x0449, B:133:0x044f, B:135:0x0455, B:91:0x04e5, B:93:0x04eb, B:95:0x04f1), top: B:38:0x013e }] */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0472 A[Catch: all -> 0x0114, TRY_LEAVE, TryCatch #14 {all -> 0x0114, blocks: (B:31:0x010f, B:35:0x0126, B:240:0x0140, B:242:0x0144, B:245:0x014b, B:246:0x0155, B:224:0x0170, B:226:0x017c, B:228:0x0190, B:230:0x0196, B:56:0x0230, B:58:0x0238, B:60:0x0240, B:62:0x0248, B:65:0x0286, B:147:0x0260, B:149:0x026c, B:151:0x0272, B:153:0x0278, B:155:0x027e, B:177:0x02bc, B:193:0x031e, B:194:0x032b, B:160:0x0354, B:161:0x036f, B:118:0x03de, B:121:0x03f6, B:125:0x03fd, B:126:0x03fe, B:128:0x0410, B:129:0x0417, B:137:0x045e, B:139:0x0472, B:81:0x0484, B:83:0x048a, B:87:0x04ad, B:70:0x03a1, B:73:0x03bc, B:74:0x03d2, B:47:0x01b3, B:49:0x01b9, B:51:0x01c5, B:53:0x021f, B:215:0x01d3, B:217:0x01df, B:219:0x01f5, B:221:0x020b), top: B:30:0x010f }] */
        /* JADX WARN: Removed duplicated region for block: B:158:0x034e  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x02a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0484 A[Catch: all -> 0x0114, TRY_ENTER, TryCatch #14 {all -> 0x0114, blocks: (B:31:0x010f, B:35:0x0126, B:240:0x0140, B:242:0x0144, B:245:0x014b, B:246:0x0155, B:224:0x0170, B:226:0x017c, B:228:0x0190, B:230:0x0196, B:56:0x0230, B:58:0x0238, B:60:0x0240, B:62:0x0248, B:65:0x0286, B:147:0x0260, B:149:0x026c, B:151:0x0272, B:153:0x0278, B:155:0x027e, B:177:0x02bc, B:193:0x031e, B:194:0x032b, B:160:0x0354, B:161:0x036f, B:118:0x03de, B:121:0x03f6, B:125:0x03fd, B:126:0x03fe, B:128:0x0410, B:129:0x0417, B:137:0x045e, B:139:0x0472, B:81:0x0484, B:83:0x048a, B:87:0x04ad, B:70:0x03a1, B:73:0x03bc, B:74:0x03d2, B:47:0x01b3, B:49:0x01b9, B:51:0x01c5, B:53:0x021f, B:215:0x01d3, B:217:0x01df, B:219:0x01f5, B:221:0x020b), top: B:30:0x010f }] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x04ad A[Catch: all -> 0x0114, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0114, blocks: (B:31:0x010f, B:35:0x0126, B:240:0x0140, B:242:0x0144, B:245:0x014b, B:246:0x0155, B:224:0x0170, B:226:0x017c, B:228:0x0190, B:230:0x0196, B:56:0x0230, B:58:0x0238, B:60:0x0240, B:62:0x0248, B:65:0x0286, B:147:0x0260, B:149:0x026c, B:151:0x0272, B:153:0x0278, B:155:0x027e, B:177:0x02bc, B:193:0x031e, B:194:0x032b, B:160:0x0354, B:161:0x036f, B:118:0x03de, B:121:0x03f6, B:125:0x03fd, B:126:0x03fe, B:128:0x0410, B:129:0x0417, B:137:0x045e, B:139:0x0472, B:81:0x0484, B:83:0x048a, B:87:0x04ad, B:70:0x03a1, B:73:0x03bc, B:74:0x03d2, B:47:0x01b3, B:49:0x01b9, B:51:0x01c5, B:53:0x021f, B:215:0x01d3, B:217:0x01df, B:219:0x01f5, B:221:0x020b), top: B:30:0x010f }] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x04eb A[Catch: all -> 0x051e, TryCatch #20 {all -> 0x051e, blocks: (B:185:0x02fe, B:187:0x0304, B:131:0x0449, B:133:0x044f, B:135:0x0455, B:91:0x04e5, B:93:0x04eb, B:95:0x04f1), top: B:38:0x013e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void doDecode(EncodedImage encodedImage, int i) {
            String str;
            String str2;
            Throwable th;
            int size;
            Throwable th2;
            QualityInfo qualityInfo;
            OutOfMemoryError outOfMemoryError;
            CloseableImage closeableImage;
            String str3;
            CloseableImage closeableImage2;
            ImageOOMOptStrategy strategy;
            Map<String, String> extraMap;
            Exception exc;
            Map<String, String> extraMap2;
            DecodeException decodeException;
            CloseableImage closeableImage3;
            CloseableImage closeableImage4;
            CloseableImage decode;
            CloseableImage closeableImage5;
            int targetWidth;
            int targetHeight;
            SizeDeterminer sizeDeterminer;
            View view;
            ProgressiveDecoder progressiveDecoder = this;
            int i2 = i;
            if (encodedImage.getImageFormat() != DefaultImageFormats.JPEG && encodedImage.getImageFormat() != DefaultImageFormats.WEBP_ANIMATED && !canParseThumbDataAndSet(encodedImage, i) && isNotLast(i)) {
                return;
            }
            if (isFinished() || !EncodedImage.isValid(encodedImage)) {
                return;
            }
            ImageFormat imageFormat = encodedImage.getImageFormat();
            String name = imageFormat != null ? imageFormat.getName() : SystemUtils.UNKNOWN;
            String str4 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
            String valueOf = String.valueOf(encodedImage.getSampleSize());
            boolean isLast = isLast(i);
            boolean z = isLast && !statusHasFlag(i2, 8);
            boolean statusHasFlag = statusHasFlag(i2, 4);
            boolean isCrop = progressiveDecoder.isCrop(encodedImage, progressiveDecoder.mImageDecodeOptions);
            Rect regionToDecode = progressiveDecoder.getRegionToDecode(encodedImage, progressiveDecoder.mImageDecodeOptions);
            ResizeOptions resizeOptions = progressiveDecoder.mProducerContext.getImageRequest().getResizeOptions();
            boolean previewUsed = progressiveDecoder.mProducerContext.getImageRequest().getPreviewUsed();
            int previewAlgo = progressiveDecoder.mProducerContext.getImageRequest().getPreviewAlgo();
            long previewDecodeTime = progressiveDecoder.mProducerContext.getImageRequest().getPreviewDecodeTime();
            long previewDecodeEnd = progressiveDecoder.mProducerContext.getImageRequest().getPreviewDecodeEnd();
            progressiveDecoder.mProducerContext.getImageRequest().getPreviewDuration();
            String previewError = progressiveDecoder.mProducerContext.getImageRequest().getPreviewError();
            if (resizeOptions != null) {
                str = "internalDecode result is null,empty pixel data., heic_decode_error is ";
                str2 = resizeOptions.width + "x" + resizeOptions.height;
            } else {
                str = "internalDecode result is null,empty pixel data., heic_decode_error is ";
                str2 = SystemUtils.UNKNOWN;
            }
            try {
                long queuedTime = progressiveDecoder.mJobScheduler.getQueuedTime();
                String valueOf2 = String.valueOf(progressiveDecoder.mProducerContext.getImageRequest().getSourceUri());
                if (z || statusHasFlag) {
                    size = encodedImage.getSize();
                } else {
                    try {
                        size = getIntermediateImageEndOffset(encodedImage);
                    } catch (Throwable th3) {
                        th2 = th3;
                        th = th2;
                        EncodedImage.closeSafely(encodedImage);
                        throw th;
                    }
                }
                int i3 = size;
                if (z || statusHasFlag) {
                    qualityInfo = ImmutableQualityInfo.FULL_QUALITY;
                } else {
                    qualityInfo = getQualityInfo();
                }
                String str5 = str2;
                progressiveDecoder.mProducerListener.onProducerStart(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME);
                try {
                    if (isLast) {
                        try {
                            if (imageFormat == ImageFormat.UNKNOWN || SystemUtils.UNKNOWN.equals(name)) {
                                throw new BDException(BDErrorCodeConst.BD_ERROR_CODE_IMAGE_FORMAT, BDErrorCodeConst.BD_ERROR_MSG_IMAGE_FORMAT);
                            }
                        } catch (Exception e) {
                            e = e;
                            str3 = DecodeProducer.PRODUCER_NAME;
                            closeableImage2 = null;
                            exc = e;
                            if (exc instanceof IBDException) {
                            }
                            Exception exc2 = exc;
                            String str6 = str3;
                            extraMap2 = getExtraMap(closeableImage2, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                            if (closeableImage2 != null) {
                            }
                            try {
                                this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), str6, r34 == null ? r34 : exc2, extraMap2);
                                handleError(r34 == null ? r34 : exc2);
                                EncodedImage.closeSafely(encodedImage);
                                return;
                            } catch (Throwable th4) {
                                th = th4;
                                th = th;
                                EncodedImage.closeSafely(encodedImage);
                                throw th;
                            }
                        } catch (OutOfMemoryError e2) {
                            outOfMemoryError = e2;
                            closeableImage = null;
                            str3 = DecodeProducer.PRODUCER_NAME;
                            strategy = ImageOOMOptStrategy.getStrategy();
                            BDException bDException = new BDException(BDErrorCodeConst.BD_ERROR_CODE_OUT_OF_MEMORY, BDErrorCodeConst.BD_ERROR_MSG_OUT_OF_MEMORY, outOfMemoryError);
                            if (!DecodeProducer.this.mOomOptEnabled) {
                            }
                            String str7 = str3;
                            extraMap = getExtraMap(closeableImage, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                            if (closeableImage != null) {
                            }
                            this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), str7, bDException, extraMap);
                            handleError(bDException);
                            if (strategy != null) {
                            }
                            EncodedImage.closeSafely(encodedImage);
                            return;
                        }
                    }
                    try {
                        try {
                            if (FrescoCacheMonitorUtil.isOptHardWareForSRProcessor()) {
                                try {
                                    if (progressiveDecoder.mProducerContext.getImageRequest().getPostprocessor() != null && "SRPostProcessor".equalsIgnoreCase(progressiveDecoder.mProducerContext.getImageRequest().getPostprocessor().getName()) && Build.VERSION.SDK_INT > 29) {
                                        progressiveDecoder.mImageDecodeOptions.bitmapConfig = Bitmap.Config.HARDWARE;
                                        progressiveDecoder.mImageDecodeOptions.isSelectBitmapConfig = true;
                                        if (progressiveDecoder.mImageDecodeOptions.heicSROptions != null && progressiveDecoder.mImageDecodeOptions.heicSROptions.isAdaptiveSr && (progressiveDecoder.mImageDecodeOptions.heicSROptions.targetWidth < 0 || progressiveDecoder.mImageDecodeOptions.heicSROptions.targetHeight < 0)) {
                                            targetWidth = progressiveDecoder.mProducerContext.getImageRequest().getTargetWidth();
                                            targetHeight = progressiveDecoder.mProducerContext.getImageRequest().getTargetHeight();
                                            if ((targetWidth > 0 || targetHeight <= 0) && (sizeDeterminer = progressiveDecoder.mProducerContext.getImageRequest().getSizeDeterminer()) != null && (view = sizeDeterminer.getView()) != null && view.getWidth() > 0 && view.getHeight() > 0) {
                                                targetWidth = view.getWidth();
                                                targetHeight = view.getHeight();
                                            }
                                            progressiveDecoder.mImageDecodeOptions.heicSROptions.targetWidth = targetWidth;
                                            progressiveDecoder.mImageDecodeOptions.heicSROptions.targetHeight = targetHeight;
                                        }
                                        decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, i3, qualityInfo, progressiveDecoder.mImageDecodeOptions);
                                        if (decode != null) {
                                            closeableImage5 = decode;
                                            str3 = DecodeProducer.PRODUCER_NAME;
                                            try {
                                                throw new BDException(BDErrorCodeConst.BD_ERROR_CODE_EMPTY_PIXEL_DATA, str + encodedImage.getHeifDecError());
                                            } catch (DecodeException e3) {
                                                decodeException = e3;
                                                closeableImage3 = closeableImage5;
                                                try {
                                                    EncodedImage encodedImage2 = decodeException.getEncodedImage();
                                                    Object[] objArr = new Object[4];
                                                    objArr[0] = decodeException.getMessage();
                                                    objArr[1] = valueOf2;
                                                    closeableImage4 = closeableImage3;
                                                    try {
                                                        objArr[2] = encodedImage2.getFirstBytesAsHexString(10);
                                                        objArr[3] = Integer.valueOf(encodedImage2.getSize());
                                                        FLog.m484w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", objArr);
                                                        throw decodeException;
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        closeableImage2 = closeableImage4;
                                                        exc = e;
                                                        BDException bDException2 = ((exc instanceof IBDException) && encodedImage.getHeifDecError() == 0) ? new BDException(BDErrorCodeConst.BD_ERROR_CODE_EMPTY_PIXEL_DATA, exc.getMessage(), exc) : null;
                                                        Exception exc22 = exc;
                                                        String str62 = str3;
                                                        extraMap2 = getExtraMap(closeableImage2, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                                                        if (closeableImage2 != null && closeableImage2.getExtraMap() != null) {
                                                            extraMap2.putAll(closeableImage2.getExtraMap());
                                                        }
                                                        this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), str62, bDException2 == null ? bDException2 : exc22, extraMap2);
                                                        handleError(bDException2 == null ? bDException2 : exc22);
                                                        EncodedImage.closeSafely(encodedImage);
                                                        return;
                                                    } catch (OutOfMemoryError e5) {
                                                        e = e5;
                                                        closeableImage = closeableImage4;
                                                        outOfMemoryError = e;
                                                        strategy = ImageOOMOptStrategy.getStrategy();
                                                        BDException bDException3 = new BDException(BDErrorCodeConst.BD_ERROR_CODE_OUT_OF_MEMORY, BDErrorCodeConst.BD_ERROR_MSG_OUT_OF_MEMORY, outOfMemoryError);
                                                        if (!DecodeProducer.this.mOomOptEnabled) {
                                                            if (strategy == null) {
                                                                throw bDException3;
                                                            }
                                                            if (!strategy.isEnableOOMOpt()) {
                                                                throw bDException3;
                                                            }
                                                        }
                                                        String str72 = str3;
                                                        extraMap = getExtraMap(closeableImage, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                                                        if (closeableImage != null && closeableImage.getExtraMap() != null) {
                                                            extraMap.putAll(closeableImage.getExtraMap());
                                                        }
                                                        this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), str72, bDException3, extraMap);
                                                        handleError(bDException3);
                                                        if (strategy != null) {
                                                            strategy.optMemoryWhenOOM();
                                                        }
                                                        EncodedImage.closeSafely(encodedImage);
                                                        return;
                                                    }
                                                } catch (Exception e6) {
                                                    e = e6;
                                                    closeableImage4 = closeableImage3;
                                                } catch (OutOfMemoryError e7) {
                                                    e = e7;
                                                    closeableImage4 = closeableImage3;
                                                }
                                            } catch (Exception e8) {
                                                e = e8;
                                                exc = e;
                                                closeableImage2 = closeableImage5;
                                                if (exc instanceof IBDException) {
                                                }
                                                Exception exc222 = exc;
                                                String str622 = str3;
                                                extraMap2 = getExtraMap(closeableImage2, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                                                if (closeableImage2 != null) {
                                                    extraMap2.putAll(closeableImage2.getExtraMap());
                                                }
                                                this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), str622, bDException2 == null ? bDException2 : exc222, extraMap2);
                                                handleError(bDException2 == null ? bDException2 : exc222);
                                                EncodedImage.closeSafely(encodedImage);
                                                return;
                                            } catch (OutOfMemoryError e9) {
                                                e = e9;
                                                outOfMemoryError = e;
                                                closeableImage = closeableImage5;
                                                strategy = ImageOOMOptStrategy.getStrategy();
                                                BDException bDException32 = new BDException(BDErrorCodeConst.BD_ERROR_CODE_OUT_OF_MEMORY, BDErrorCodeConst.BD_ERROR_MSG_OUT_OF_MEMORY, outOfMemoryError);
                                                if (!DecodeProducer.this.mOomOptEnabled) {
                                                }
                                                String str722 = str3;
                                                extraMap = getExtraMap(closeableImage, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                                                if (closeableImage != null) {
                                                    extraMap.putAll(closeableImage.getExtraMap());
                                                }
                                                this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), str722, bDException32, extraMap);
                                                handleError(bDException32);
                                                if (strategy != null) {
                                                }
                                                EncodedImage.closeSafely(encodedImage);
                                                return;
                                            }
                                        } else {
                                            try {
                                                if (encodedImage.getSampleSize() != 1) {
                                                    i2 |= 16;
                                                }
                                                int i4 = i2;
                                                try {
                                                    Map<String, String> extraMap3 = getExtraMap(decode, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                                                    if (decode != null && decode.getExtraMap() != null) {
                                                        extraMap3.putAll(decode.getExtraMap());
                                                    }
                                                    progressiveDecoder = this;
                                                    try {
                                                        progressiveDecoder.mProducerListener.onProducerFinishWithSuccess(progressiveDecoder.mProducerContext.getId(), DecodeProducer.PRODUCER_NAME, extraMap3);
                                                        if (decode != null) {
                                                            decode.copyImageFromTrace(encodedImage);
                                                            decode.setFileSize(encodedImage.getSize());
                                                        }
                                                        progressiveDecoder.handleResult(decode, i4);
                                                        EncodedImage.closeSafely(encodedImage);
                                                        return;
                                                    } catch (Throwable th5) {
                                                        th2 = th5;
                                                        th = th2;
                                                        EncodedImage.closeSafely(encodedImage);
                                                        throw th;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    th = th;
                                                    EncodedImage.closeSafely(encodedImage);
                                                    throw th;
                                                }
                                            } catch (Exception e10) {
                                                e = e10;
                                                closeableImage5 = decode;
                                                str3 = DecodeProducer.PRODUCER_NAME;
                                                exc = e;
                                                closeableImage2 = closeableImage5;
                                                if (exc instanceof IBDException) {
                                                }
                                                Exception exc2222 = exc;
                                                String str6222 = str3;
                                                extraMap2 = getExtraMap(closeableImage2, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                                                if (closeableImage2 != null) {
                                                }
                                                this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), str6222, bDException2 == null ? bDException2 : exc2222, extraMap2);
                                                handleError(bDException2 == null ? bDException2 : exc2222);
                                                EncodedImage.closeSafely(encodedImage);
                                                return;
                                            } catch (OutOfMemoryError e11) {
                                                e = e11;
                                                closeableImage5 = decode;
                                                str3 = DecodeProducer.PRODUCER_NAME;
                                                outOfMemoryError = e;
                                                closeableImage = closeableImage5;
                                                strategy = ImageOOMOptStrategy.getStrategy();
                                                BDException bDException322 = new BDException(BDErrorCodeConst.BD_ERROR_CODE_OUT_OF_MEMORY, BDErrorCodeConst.BD_ERROR_MSG_OUT_OF_MEMORY, outOfMemoryError);
                                                if (!DecodeProducer.this.mOomOptEnabled) {
                                                }
                                                String str7222 = str3;
                                                extraMap = getExtraMap(closeableImage, queuedTime, qualityInfo, isLast, name, str4, str5, valueOf, isCrop, regionToDecode, encodedImage.isHeicSysFirst(), encodedImage.getHeicCustomDecoder(), encodedImage.getThumbDecodeDuration(), encodedImage.isDecodeThumb() ? encodedImage.getSize() : -1L, encodedImage.getHeifDecError(), previewUsed, previewAlgo, previewDecodeTime, previewDecodeEnd, previewError, encodedImage.getHdrType());
                                                if (closeableImage != null) {
                                                }
                                                this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext.getId(), str7222, bDException322, extraMap);
                                                handleError(bDException322);
                                                if (strategy != null) {
                                                }
                                                EncodedImage.closeSafely(encodedImage);
                                                return;
                                            }
                                        }
                                    }
                                } catch (DecodeException e12) {
                                    decodeException = e12;
                                    closeableImage3 = null;
                                    str3 = DecodeProducer.PRODUCER_NAME;
                                    EncodedImage encodedImage22 = decodeException.getEncodedImage();
                                    Object[] objArr2 = new Object[4];
                                    objArr2[0] = decodeException.getMessage();
                                    objArr2[1] = valueOf2;
                                    closeableImage4 = closeableImage3;
                                    objArr2[2] = encodedImage22.getFirstBytesAsHexString(10);
                                    objArr2[3] = Integer.valueOf(encodedImage22.getSize());
                                    FLog.m484w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", objArr2);
                                    throw decodeException;
                                }
                            }
                            if ((Build.VERSION.SDK_INT == 28 && DefaultImageFormats.isStaticWebpFormat(imageFormat) && (ImagePipelineFactory.getInstance().getPlatformDecoder() instanceof PieDecoder) && progressiveDecoder.mImageDecodeOptions.bitmapConfig != Bitmap.Config.ARGB_8888) || (FrescoCacheMonitorUtil.isOptRgbaForPostProcessor() && progressiveDecoder.mProducerContext.getImageRequest().getPostprocessor() != null && ("IterativeBoxBlurPostProcessor".equalsIgnoreCase(progressiveDecoder.mProducerContext.getImageRequest().getPostprocessor().getName()) || "SharpPostProcessor".equalsIgnoreCase(progressiveDecoder.mProducerContext.getImageRequest().getPostprocessor().getName()) || "SRPostProcessor".equalsIgnoreCase(progressiveDecoder.mProducerContext.getImageRequest().getPostprocessor().getName())))) {
                                progressiveDecoder.mImageDecodeOptions.bitmapConfig = Bitmap.Config.ARGB_8888;
                                progressiveDecoder.mImageDecodeOptions.isSelectBitmapConfig = true;
                            }
                            if (progressiveDecoder.mImageDecodeOptions.heicSROptions != null) {
                                targetWidth = progressiveDecoder.mProducerContext.getImageRequest().getTargetWidth();
                                targetHeight = progressiveDecoder.mProducerContext.getImageRequest().getTargetHeight();
                                if (targetWidth > 0) {
                                }
                                targetWidth = view.getWidth();
                                targetHeight = view.getHeight();
                                progressiveDecoder.mImageDecodeOptions.heicSROptions.targetWidth = targetWidth;
                                progressiveDecoder.mImageDecodeOptions.heicSROptions.targetHeight = targetHeight;
                            }
                            decode = DecodeProducer.this.mImageDecoder.decode(encodedImage, i3, qualityInfo, progressiveDecoder.mImageDecodeOptions);
                            if (decode != null) {
                            }
                        } catch (Throwable th7) {
                            th2 = th7;
                        }
                    } catch (DecodeException e13) {
                        str3 = DecodeProducer.PRODUCER_NAME;
                        decodeException = e13;
                        closeableImage3 = null;
                    } catch (Exception e14) {
                        str3 = DecodeProducer.PRODUCER_NAME;
                        exc = e14;
                        closeableImage2 = null;
                    } catch (OutOfMemoryError e15) {
                        str3 = DecodeProducer.PRODUCER_NAME;
                        outOfMemoryError = e15;
                        closeableImage = null;
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (Throwable th9) {
                th = th9;
            }
        }

        private boolean canParseThumbDataAndSet(EncodedImage encodedImage, int i) {
            boolean z = false;
            if (isLast(i)) {
                return false;
            }
            FLog.m430d("ProgressiveDecoder", "fresco_canParseThumbDataAndSet start");
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            if (imageRequest.getHasDecodedThumb()) {
                return false;
            }
            boolean canParseThumbDataAndSet = HeifFormatUtil.canParseThumbDataAndSet(encodedImage);
            boolean isDecodeThumb = encodedImage.isDecodeThumb();
            imageRequest.setHasDecodedThumb(isDecodeThumb);
            if (canParseThumbDataAndSet && !isDecodeThumb) {
                z = true;
            }
            imageRequest.setThumbDataInFetch(z);
            FLog.m430d("ProgressiveDecoder", "fresco_canParseThumbData end hasThumb:" + canParseThumbDataAndSet + " isDecodeThumb:" + isDecodeThumb + " url:" + imageRequest.getSourceUri());
            return isDecodeThumb;
        }

        private boolean isCrop(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
            Rect regionToDecode = encodedImage.getRegionToDecode();
            if (regionToDecode != null) {
                if (!imageDecodeOptions.useSmartCrop) {
                    regionToDecode = imageDecodeOptions.regionToDecode;
                }
            } else {
                regionToDecode = imageDecodeOptions.regionToDecode;
            }
            return regionToDecode != null;
        }

        private Rect getRegionToDecode(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
            Rect regionToDecode = encodedImage.getRegionToDecode();
            if (regionToDecode != null) {
                return imageDecodeOptions.useSmartCrop ? regionToDecode : imageDecodeOptions.regionToDecode;
            }
            return imageDecodeOptions.regionToDecode;
        }

        private Map<String, String> getExtraMap(@Nullable CloseableImage closeableImage, long j, QualityInfo qualityInfo, boolean z, String str, String str2, String str3, String str4, boolean z2, @Nullable Rect rect, boolean z3, int i, long j2, long j3, int i2, boolean z4, int i3, long j4, long j5, String str5, int i4) {
            if (!this.mProducerListener.requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            String valueOf = String.valueOf(j);
            String valueOf2 = String.valueOf(qualityInfo.isOfGoodEnoughQuality());
            String valueOf3 = String.valueOf(z);
            if (closeableImage instanceof CloseableStaticBitmap) {
                Bitmap underlyingBitmap = ((CloseableStaticBitmap) closeableImage).getUnderlyingBitmap();
                String str6 = underlyingBitmap.getWidth() + "x" + underlyingBitmap.getHeight();
                HashMap hashMap = new HashMap(25);
                hashMap.put(DecodeProducer.EXTRA_PREVIEW_USED, z4 ? "1" : AddressParam.TYPE_DISAPPROVE);
                hashMap.put(DecodeProducer.EXTRA_PREVIEW_ALGO, String.valueOf(i3));
                hashMap.put(DecodeProducer.EXTRA_PREVIEW_DECODE_TIME, String.valueOf(j4));
                hashMap.put(DecodeProducer.EXTRA_PREVIEW_DURATION, String.valueOf(SystemClock.uptimeMillis() - j5));
                hashMap.put(DecodeProducer.EXTRA_PREVIEW_ERROR, str5);
                hashMap.put(DecodeProducer.EXTRA_HDR_TYPE, String.valueOf(i4));
                hashMap.put(DecodeProducer.EXTRA_BITMAP_SIZE, str6);
                hashMap.put("queueTime", valueOf);
                hashMap.put(DecodeProducer.EXTRA_HAS_GOOD_QUALITY, valueOf2);
                hashMap.put(DecodeProducer.EXTRA_IS_FINAL, valueOf3);
                hashMap.put("encodedImageSize", str2);
                hashMap.put("imageFormat", str);
                hashMap.put(DecodeProducer.REQUESTED_IMAGE_SIZE, str3);
                hashMap.put(DecodeProducer.SAMPLE_SIZE, str4);
                hashMap.put(DecodeProducer.EXTRA_BITMAP_RAM_SIZE, String.valueOf(BitmapUtil.getSizeInBytes(underlyingBitmap)));
                hashMap.put(DecodeProducer.EXTRA_IS_CROP, z2 ? "1" : AddressParam.TYPE_DISAPPROVE);
                hashMap.put(DecodeProducer.EXTRA_BITMAP_CONFIG, BitmapUtil.getBitmapConfigName(underlyingBitmap));
                hashMap.put(DecodeProducer.EXTRA_HEIC_SYS_FIRST, z3 ? "1" : AddressParam.TYPE_DISAPPROVE);
                hashMap.put(DecodeProducer.EXTRA_HEIC_CUSTOM_DECODER, String.valueOf(i));
                if (i2 != 0) {
                    hashMap.put(DecodeProducer.EXTRA_HEIC_DECODE_ERROR, String.valueOf(i2));
                }
                if (rect != null) {
                    hashMap.put("regionToDecode", rect.flattenToString());
                }
                hashMap.put(DecodeProducer.EXTRA_IMAGE_COUNT, String.valueOf(closeableImage.getImageCount()));
                hashMap.put(DecodeProducer.EXTRA_IMAGE_QUALITY, getImageQuality(underlyingBitmap));
                if (j2 != -1) {
                    hashMap.put(DecodeProducer.EXTRA_THUMB_DECODE_DURATION, String.valueOf(j2));
                    hashMap.put(DecodeProducer.EXTRA_THUMB_FILE_SIZE, String.valueOf(j3));
                }
                return ImmutableMap.copyOf((Map) hashMap);
            }
            HashMap hashMap2 = new HashMap(21);
            hashMap2.put(DecodeProducer.EXTRA_PREVIEW_USED, z4 ? "1" : AddressParam.TYPE_DISAPPROVE);
            hashMap2.put(DecodeProducer.EXTRA_PREVIEW_ALGO, String.valueOf(i3));
            hashMap2.put(DecodeProducer.EXTRA_PREVIEW_DECODE_TIME, String.valueOf(j4));
            hashMap2.put(DecodeProducer.EXTRA_PREVIEW_DECODE_END, String.valueOf(j5));
            hashMap2.put(DecodeProducer.EXTRA_PREVIEW_DURATION, String.valueOf(SystemClock.uptimeMillis() - j5));
            hashMap2.put(DecodeProducer.EXTRA_PREVIEW_ERROR, str5);
            hashMap2.put(DecodeProducer.EXTRA_HDR_TYPE, String.valueOf(i4));
            hashMap2.put("queueTime", valueOf);
            hashMap2.put(DecodeProducer.EXTRA_HAS_GOOD_QUALITY, valueOf2);
            hashMap2.put(DecodeProducer.EXTRA_IS_FINAL, valueOf3);
            hashMap2.put("encodedImageSize", str2);
            hashMap2.put("imageFormat", str);
            hashMap2.put(DecodeProducer.REQUESTED_IMAGE_SIZE, str3);
            hashMap2.put(DecodeProducer.SAMPLE_SIZE, str4);
            hashMap2.put(DecodeProducer.EXTRA_IS_CROP, z2 ? "1" : AddressParam.TYPE_DISAPPROVE);
            hashMap2.put(DecodeProducer.EXTRA_HEIC_SYS_FIRST, z3 ? "1" : AddressParam.TYPE_DISAPPROVE);
            hashMap2.put(DecodeProducer.EXTRA_HEIC_CUSTOM_DECODER, String.valueOf(i));
            if (i2 != 0) {
                hashMap2.put(DecodeProducer.EXTRA_HEIC_DECODE_ERROR, String.valueOf(i2));
            }
            if (rect != null) {
                hashMap2.put("regionToDecode", rect.flattenToString());
            }
            hashMap2.put(DecodeProducer.EXTRA_IMAGE_COUNT, closeableImage == null ? "-1" : String.valueOf(closeableImage.getImageCount()));
            hashMap2.put(DecodeProducer.EXTRA_IMAGE_QUALITY, DecodeProducer.EXTRA_NOT_STATIC_IMAGE);
            return ImmutableMap.copyOf((Map) hashMap2);
        }

        private synchronized boolean isFinished() {
            return this.mIsFinished;
        }

        private void maybeFinish(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.mIsFinished) {
                        getConsumer().onProgressUpdate(1.0f);
                        this.mIsFinished = true;
                        this.mJobScheduler.clearJob();
                    }
                }
            }
        }

        private void handleResult(CloseableImage closeableImage, int i) {
            CloseableReference<CloseableImage> m496of = CloseableReference.m496of(closeableImage);
            try {
                maybeFinish(isLast(i));
                getConsumer().onNewResult(m496of, i);
            } finally {
                CloseableReference.closeSafely(m496of);
            }
        }

        private void handleError(Throwable th) {
            maybeFinish(true);
            getConsumer().onFailure(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleCancellation() {
            maybeFinish(true);
            getConsumer().onCancellation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDecodeStatus(EncodedImage encodedImage, int i) {
            boolean compareAndSet = this.mIsFirstJob.compareAndSet(true, false);
            boolean isLast = isLast(i);
            if (compareAndSet && isLast) {
                encodedImage.setDecodeStatus(0);
                return;
            }
            if (compareAndSet && !isLast) {
                encodedImage.setDecodeStatus(1);
                return;
            }
            if (!compareAndSet && !isLast) {
                encodedImage.setDecodeStatus(2);
            } else {
                if (compareAndSet || !isLast) {
                    return;
                }
                encodedImage.setDecodeStatus(3);
            }
        }

        private String getImageQuality(Bitmap bitmap) {
            ArrayList<Integer> colors = getColors(bitmap);
            return isWhite(colors) ? DecodeProducer.EXTRA_WHITE_SUSPECTED : isBlack(colors) ? DecodeProducer.EXTRA_BLACK_SUSPECTED : isTransparent(colors) ? DecodeProducer.EXTRA_TRANSPARENT_SUSPECTED : DecodeProducer.EXTRA_NORMAL;
        }

        private ArrayList<Integer> getColors(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            ArrayList<Integer> arrayList = new ArrayList<>();
            Random random = new Random();
            Random random2 = new Random();
            int pixelsToPick = ImagePipelineConfig.getDefaultImageRequestConfig().getPixelsToPick();
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DecodeProducer#getColors");
            }
            for (int i = 0; i < pixelsToPick; i++) {
                if (Build.VERSION.SDK_INT >= 26 && bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                    arrayList.add(Integer.valueOf(bitmap.getPixel(random.nextInt(width), random2.nextInt(height))));
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return arrayList;
        }

        private boolean isWhite(ArrayList<Integer> arrayList) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (((next.intValue() >> 16) & JfifUtil.MARKER_FIRST_BYTE) > 253 && ((next.intValue() >> 8) & JfifUtil.MARKER_FIRST_BYTE) > 253 && (next.intValue() & JfifUtil.MARKER_FIRST_BYTE) > 253) {
                    return true;
                }
            }
            return false;
        }

        private boolean isBlack(ArrayList<Integer> arrayList) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (((next.intValue() >> 16) & JfifUtil.MARKER_FIRST_BYTE) < 2 && ((next.intValue() >> 8) & JfifUtil.MARKER_FIRST_BYTE) < 2 && (next.intValue() & JfifUtil.MARKER_FIRST_BYTE) < 2) {
                    return true;
                }
            }
            return false;
        }

        private boolean isTransparent(ArrayList<Integer> arrayList) {
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().intValue() != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class LocalImagesProgressiveDecoder extends ProgressiveDecoder {
        public LocalImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, boolean z, int i) {
            super(consumer, producerContext, z, i);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            if (isNotLast(i)) {
                return false;
            }
            return super.updateDecodeJob(encodedImage, i);
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            return encodedImage.getSize();
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected QualityInfo getQualityInfo() {
            return ImmutableQualityInfo.m504of(0, false, false);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class NetworkImagesProgressiveDecoder extends ProgressiveDecoder {
        private int mLastScheduledScanNumber;
        private final ProducerContext mProducerContext;
        private final ProgressiveAwebpParser mProgressiveAwebpParser;
        private final ProgressiveJpegConfig mProgressiveJpegConfig;
        private final ProgressiveJpegParser mProgressiveJpegParser;

        public NetworkImagesProgressiveDecoder(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext, ProgressiveJpegParser progressiveJpegParser, ProgressiveJpegConfig progressiveJpegConfig, ProgressiveAwebpParser progressiveAwebpParser, boolean z, int i) {
            super(consumer, producerContext, z, i);
            this.mProgressiveJpegParser = (ProgressiveJpegParser) Preconditions.checkNotNull(progressiveJpegParser);
            this.mProgressiveJpegConfig = (ProgressiveJpegConfig) Preconditions.checkNotNull(progressiveJpegConfig);
            this.mProgressiveAwebpParser = (ProgressiveAwebpParser) Preconditions.checkNotNull(progressiveAwebpParser);
            this.mProducerContext = (ProducerContext) Preconditions.checkNotNull(producerContext);
            this.mLastScheduledScanNumber = 0;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected synchronized boolean updateDecodeJob(EncodedImage encodedImage, int i) {
            boolean updateDecodeJob = super.updateDecodeJob(encodedImage, i);
            if ((isNotLast(i) || statusHasFlag(i, 8)) && !statusHasFlag(i, 4) && EncodedImage.isValid(encodedImage)) {
                if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                    if (!this.mProducerContext.getImageRequest().getProgressiveRenderingEnabled()) {
                        return false;
                    }
                    if (!this.mProgressiveJpegParser.parseMoreData(encodedImage)) {
                        return false;
                    }
                    int bestScanNumber = this.mProgressiveJpegParser.getBestScanNumber();
                    int i2 = this.mLastScheduledScanNumber;
                    if (bestScanNumber <= i2) {
                        return false;
                    }
                    if (bestScanNumber < this.mProgressiveJpegConfig.getNextScanNumberToDecode(i2) && !this.mProgressiveJpegParser.isEndMarkerRead()) {
                        return false;
                    }
                    this.mLastScheduledScanNumber = bestScanNumber;
                } else if (encodedImage.getImageFormat() == DefaultImageFormats.WEBP_ANIMATED) {
                    if (!this.mProducerContext.getImageRequest().getProgressiveRenderingAnimatedEnabled()) {
                        return false;
                    }
                    if (!this.mProgressiveAwebpParser.parseMoreData(encodedImage)) {
                        return false;
                    }
                    int bestScanNumber2 = this.mProgressiveAwebpParser.getBestScanNumber();
                    if (bestScanNumber2 - this.mLastScheduledScanNumber < this.mProducerContext.getImageRequest().getAwebpScanNumber() && this.mLastScheduledScanNumber != 0) {
                        return false;
                    }
                    this.mLastScheduledScanNumber = bestScanNumber2;
                } else if (DefaultImageFormats.isHeifFormat(encodedImage.getImageFormat()) && !this.mProducerContext.getImageRequest().getProgressiveRenderingHeicEnabled()) {
                    return false;
                }
            }
            return updateDecodeJob;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected int getIntermediateImageEndOffset(EncodedImage encodedImage) {
            if (encodedImage.getImageFormat() == DefaultImageFormats.JPEG) {
                return this.mProgressiveJpegParser.getBestScanEndOffset();
            }
            if (encodedImage.getImageFormat() == DefaultImageFormats.WEBP_ANIMATED) {
                return this.mProgressiveAwebpParser.getBestScanEndOffset();
            }
            return 0;
        }

        @Override // com.facebook.imagepipeline.producers.DecodeProducer.ProgressiveDecoder
        protected QualityInfo getQualityInfo() {
            return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
        }
    }
}

package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ResizedImageDiskCacheWriteProducer implements Producer<EncodedImage> {
    private static final String INPUT_IMAGE_FORMAT = "Image format";
    static final int MIN_TRANSFORM_INTERVAL_MS = 100;
    private static final String ORIGINAL_SIZE_KEY = "Original size";
    private static final String PRODUCER_NAME = "ResizedImageDiskCacheWriteProducer";
    private static final String REQUESTED_SIZE_KEY = "Requested size";
    private static final String TRANSCODER_ID = "Transcoder id";
    private static final String TRANSCODING_RESULT = "Transcoding result";
    private final CacheKeyFactory mCacheKeyFactory;
    private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Executor mExecutor;
    private final ImageTranscoderFactory mImageTranscoderFactory;
    private final Producer<EncodedImage> mInputProducer;
    private final boolean mIsResizingEnabled;
    private final PooledByteBufferFactory mPooledByteBufferFactory;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public ResizedImageDiskCacheWriteProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer, boolean z, ImageTranscoderFactory imageTranscoderFactory, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
        this.mImageTranscoderFactory = (ImageTranscoderFactory) Preconditions.checkNotNull(imageTranscoderFactory);
        this.mIsResizingEnabled = z;
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCustomImageBufferedDiskCacheMap = hashMap;
        this.mCacheKeyFactory = cacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new ResizedImageDiskCacheWriteConsumer(consumer, producerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCustomImageBufferedDiskCacheMap, this.mCacheKeyFactory), producerContext);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class ResizedImageDiskCacheWriteConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final CacheKeyFactory mCacheKeyFactory;
        private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
        private final BufferedDiskCache mDefaultBufferedDiskCache;
        private final ImageTranscoderFactory mImageTranscoderFactory;
        private boolean mIsCancelled;
        private final boolean mIsResizingEnabled;
        private final JobScheduler mJobScheduler;
        private final ProducerContext mProducerContext;
        private final BufferedDiskCache mSmallImageBufferedDiskCache;

        ResizedImageDiskCacheWriteConsumer(final Consumer<EncodedImage> consumer, ProducerContext producerContext, boolean z, ImageTranscoderFactory imageTranscoderFactory, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory) {
            super(consumer);
            this.mIsCancelled = false;
            this.mProducerContext = producerContext;
            this.mIsResizingEnabled = z;
            this.mImageTranscoderFactory = imageTranscoderFactory;
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
            this.mCustomImageBufferedDiskCacheMap = hashMap;
            this.mCacheKeyFactory = cacheKeyFactory;
            this.mJobScheduler = new JobScheduler(ResizedImageDiskCacheWriteProducer.this.mExecutor, new JobScheduler.PriorityJobRunnable(producerContext.getPriority()) { // from class: com.facebook.imagepipeline.producers.ResizedImageDiskCacheWriteProducer.ResizedImageDiskCacheWriteConsumer.1
                @Override // com.facebook.imagepipeline.producers.JobScheduler.JobRunnable
                public void run(EncodedImage encodedImage, int i) {
                    ResizedImageDiskCacheWriteConsumer resizedImageDiskCacheWriteConsumer = ResizedImageDiskCacheWriteConsumer.this;
                    resizedImageDiskCacheWriteConsumer.doTransformAndCache(encodedImage, i, (ImageTranscoder) Preconditions.checkNotNull(resizedImageDiskCacheWriteConsumer.mImageTranscoderFactory.createImageTranscoder(encodedImage.getImageFormat(), ResizedImageDiskCacheWriteConsumer.this.mIsResizingEnabled)));
                }
            }, 100);
            producerContext.addCallbacks(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ResizedImageDiskCacheWriteProducer.ResizedImageDiskCacheWriteConsumer.2
                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onIsIntermediateResultExpectedChanged() {
                    if (ResizedImageDiskCacheWriteConsumer.this.mProducerContext.isIntermediateResultExpected()) {
                        ResizedImageDiskCacheWriteConsumer.this.mJobScheduler.scheduleJob();
                    }
                }

                @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                public void onCancellationRequested() {
                    ResizedImageDiskCacheWriteConsumer.this.mJobScheduler.clearJob();
                    ResizedImageDiskCacheWriteConsumer.this.mIsCancelled = true;
                    consumer.onCancellation();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(@Nullable EncodedImage encodedImage, int i) {
            if (this.mIsCancelled) {
                return;
            }
            boolean isLast = isLast(i);
            if (encodedImage == null) {
                if (isLast) {
                    getConsumer().onNewResult(null, 1);
                    return;
                }
                return;
            }
            TriState shouldTransform = ResizedImageDiskCacheWriteProducer.shouldTransform(this.mProducerContext.getImageRequest(), encodedImage, (ImageTranscoder) Preconditions.checkNotNull(this.mImageTranscoderFactory.createImageTranscoder(encodedImage.getImageFormat(), this.mIsResizingEnabled)));
            if (isLast || shouldTransform != TriState.UNSET) {
                if (shouldTransform != TriState.YES) {
                    if (!this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered() && encodedImage.getRotationAngle() != 0 && encodedImage.getRotationAngle() != -1) {
                        encodedImage = moveImage(encodedImage);
                        encodedImage.setRotationAngle(0);
                    }
                    getConsumer().onNewResult(encodedImage, i);
                    return;
                }
                if (this.mJobScheduler.updateJob(encodedImage, i)) {
                    if (isLast || this.mProducerContext.isIntermediateResultExpected()) {
                        this.mJobScheduler.scheduleJob();
                    }
                }
            }
        }

        private EncodedImage moveImage(EncodedImage encodedImage) {
            EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
            encodedImage.close();
            return cloneOrNull;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void doTransformAndCache(EncodedImage encodedImage, int i, ImageTranscoder imageTranscoder) {
            this.mProducerContext.getListener().onProducerStart(this.mProducerContext.getId(), ResizedImageDiskCacheWriteProducer.PRODUCER_NAME);
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            PooledByteBufferOutputStream newOutputStream = ResizedImageDiskCacheWriteProducer.this.mPooledByteBufferFactory.newOutputStream();
            try {
                ImageTranscodeResult transcode = imageTranscoder.transcode(encodedImage, newOutputStream, imageRequest.getRotationOptions(), imageRequest.getResizeOptions(), null, 85);
                if (transcode.getTranscodeStatus() == 2) {
                    throw new RuntimeException("Error while transcoding the image");
                }
                Map<String, String> extraMap = getExtraMap(encodedImage, imageRequest.getResizeOptions(), transcode, imageTranscoder.getIdentifier());
                CloseableReference m496of = CloseableReference.m496of(newOutputStream.toByteBuffer());
                try {
                    EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) m496of);
                    encodedImage2.setImageFormat(DefaultImageFormats.JPEG);
                    try {
                        encodedImage2.parseMetaData();
                        writeDiskCache(encodedImage2, i);
                        this.mProducerContext.getListener().onProducerFinishWithSuccess(this.mProducerContext.getId(), ResizedImageDiskCacheWriteProducer.PRODUCER_NAME, extraMap);
                        if (transcode.getTranscodeStatus() != 1) {
                            i |= 16;
                        }
                        getConsumer().onNewResult(encodedImage2, i);
                    } finally {
                        EncodedImage.closeSafely(encodedImage2);
                    }
                } finally {
                    CloseableReference.closeSafely((CloseableReference<?>) m496of);
                }
            } catch (Exception e) {
                this.mProducerContext.getListener().onProducerFinishWithFailure(this.mProducerContext.getId(), ResizedImageDiskCacheWriteProducer.PRODUCER_NAME, e, null);
                if (isLast(i)) {
                    getConsumer().onFailure(e);
                }
            } finally {
                newOutputStream.close();
            }
        }

        private Map<String, String> getExtraMap(EncodedImage encodedImage, @Nullable ResizeOptions resizeOptions, @Nullable ImageTranscodeResult imageTranscodeResult, @Nullable String str) {
            if (!this.mProducerContext.getListener().requiresExtraMap(this.mProducerContext.getId())) {
                return null;
            }
            String str2 = encodedImage.getWidth() + "x" + encodedImage.getHeight();
            String str3 = resizeOptions != null ? resizeOptions.width + "x" + resizeOptions.height : "Unspecified";
            HashMap hashMap = new HashMap();
            hashMap.put(ResizedImageDiskCacheWriteProducer.INPUT_IMAGE_FORMAT, String.valueOf(encodedImage.getImageFormat()));
            hashMap.put(ResizedImageDiskCacheWriteProducer.ORIGINAL_SIZE_KEY, str2);
            hashMap.put(ResizedImageDiskCacheWriteProducer.REQUESTED_SIZE_KEY, str3);
            hashMap.put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
            hashMap.put(ResizedImageDiskCacheWriteProducer.TRANSCODER_ID, str);
            hashMap.put(ResizedImageDiskCacheWriteProducer.TRANSCODING_RESULT, String.valueOf(imageTranscodeResult));
            return ImmutableMap.copyOf((Map) hashMap);
        }

        private void writeDiskCache(EncodedImage encodedImage, int i) {
            if (isNotLast(i) || encodedImage == null || statusHasAnyFlag(i, 10) || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
                return;
            }
            ImageRequest imageRequest = this.mProducerContext.getImageRequest();
            if (imageRequest.isResizedImageDiskCacheActuallyEnabled()) {
                CacheKey resizedImageCacheKey = this.mCacheKeyFactory.getResizedImageCacheKey(imageRequest, this.mProducerContext.getCallerContext());
                if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
                    this.mSmallImageBufferedDiskCache.put(resizedImageCacheKey, encodedImage);
                    return;
                }
                if (imageRequest.getCacheChoice() == ImageRequest.CacheChoice.CUSTOM) {
                    BufferedDiskCache bufferedDiskCache = this.mCustomImageBufferedDiskCacheMap.get(imageRequest.getCustomCacheName());
                    if (bufferedDiskCache != null) {
                        bufferedDiskCache.put(resizedImageCacheKey, encodedImage);
                        return;
                    }
                    return;
                }
                this.mDefaultBufferedDiskCache.put(resizedImageCacheKey, encodedImage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TriState shouldTransform(ImageRequest imageRequest, EncodedImage encodedImage, ImageTranscoder imageTranscoder) {
        if (encodedImage == null || encodedImage.getImageFormat() == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        }
        if (!imageTranscoder.canTranscode(encodedImage.getImageFormat())) {
            return TriState.NO;
        }
        return TriState.valueOf(shouldRotate(imageRequest.getRotationOptions(), encodedImage) || imageTranscoder.canResize(encodedImage, imageRequest.getRotationOptions(), imageRequest.getResizeOptions()));
    }

    private static boolean shouldRotate(RotationOptions rotationOptions, EncodedImage encodedImage) {
        return !rotationOptions.canDeferUntilRendered() && (JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage) != 0 || shouldRotateUsingExifOrientation(rotationOptions, encodedImage));
    }

    private static boolean shouldRotateUsingExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        if (!rotationOptions.rotationEnabled() || rotationOptions.canDeferUntilRendered()) {
            encodedImage.setExifOrientation(0);
            return false;
        }
        return JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(encodedImage.getExifOrientation()));
    }
}

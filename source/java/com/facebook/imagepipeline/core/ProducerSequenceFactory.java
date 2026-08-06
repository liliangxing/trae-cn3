package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Build;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ProducerSequenceFactory {
    Producer<EncodedImage> mBackgroundLocalContentUriFetchToEncodedMemorySequence;
    Producer<EncodedImage> mBackgroundLocalFileFetchToEncodedMemorySequence;
    Producer<EncodedImage> mBackgroundNetworkFetchToEncodedMemorySequence;
    private Producer<EncodedImage> mCommonNetworkFetchToEncodedMemorySequence;
    private final ContentResolver mContentResolver;
    Producer<CloseableReference<CloseableImage>> mDataFetchSequence;
    private final boolean mDiskCacheEnabled;
    Producer<CloseableReference<CloseableImage>> mDiskCachedResizedImageFileFetchSequence;
    Producer<CloseableReference<CloseableImage>> mDiskCachedResizedImageLocalContentUriFetchSequence;
    private final boolean mDownsampleEnabled;
    private final ImageTranscoderFactory mImageTranscoderFactory;
    Producer<CloseableReference<CloseableImage>> mLocalAssetFetchSequence;
    Producer<CloseableReference<PooledByteBuffer>> mLocalContentUriEncodedImageProducerSequence;
    Producer<CloseableReference<CloseableImage>> mLocalContentUriFetchSequence;
    Producer<CloseableReference<PooledByteBuffer>> mLocalFileEncodedImageProducerSequence;
    Producer<Void> mLocalFileFetchToEncodedMemoryPrefetchSequence;
    Producer<CloseableReference<CloseableImage>> mLocalImageFileFetchSequence;
    Producer<CloseableReference<CloseableImage>> mLocalResourceFetchSequence;
    Producer<CloseableReference<CloseableImage>> mLocalVideoFileFetchSequence;
    Producer<CloseableReference<PooledByteBuffer>> mNetworkEncodedImageProducerSequence;
    Producer<CloseableReference<CloseableImage>> mNetworkFetchSequence;
    Producer<Void> mNetworkFetchToEncodedMemoryPrefetchSequence;
    private NetworkFetcher mNetworkFetcher;
    private final boolean mPartialImageCachingEnabled;
    private final ProducerFactory mProducerFactory;
    Producer<CloseableReference<CloseableImage>> mQualifiedResourceFetchSequence;
    private final boolean mResizeAndRotateEnabledForNetwork;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
    private final boolean mUseBitmapPrepareToDraw;
    private final boolean mWebpSupportEnabled;
    private NetworkFetcher newNetworkFetcher;
    Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mPostprocessorSequences = new HashMap();
    Map<Producer<CloseableReference<CloseableImage>>, Producer<Void>> mCloseableImagePrefetchSequences = new HashMap();
    Map<Producer<CloseableReference<CloseableImage>>, Producer<CloseableReference<CloseableImage>>> mBitmapPrepareSequences = new HashMap();

    public ProducerSequenceFactory(ContentResolver contentResolver, ProducerFactory producerFactory, NetworkFetcher networkFetcher, boolean z, boolean z2, ThreadHandoffProducerQueue threadHandoffProducerQueue, boolean z3, boolean z4, boolean z5, boolean z6, ImageTranscoderFactory imageTranscoderFactory) {
        this.mContentResolver = contentResolver;
        this.mProducerFactory = producerFactory;
        this.mNetworkFetcher = networkFetcher;
        this.mResizeAndRotateEnabledForNetwork = z;
        this.mWebpSupportEnabled = z2;
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mDownsampleEnabled = z3;
        this.mUseBitmapPrepareToDraw = z4;
        this.mPartialImageCachingEnabled = z5;
        this.mDiskCacheEnabled = z6;
        this.mImageTranscoderFactory = imageTranscoderFactory;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getEncodedImageProducerSequence(ImageRequest imageRequest) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getEncodedImageProducerSequence");
            }
            validateEncodedImageRequest(imageRequest);
            Uri sourceUri = imageRequest.getSourceUri();
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                Producer<CloseableReference<PooledByteBuffer>> networkFetchEncodedImageProducerSequence = getNetworkFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return networkFetchEncodedImageProducerSequence;
            }
            if (sourceUriType == 2 || sourceUriType == 3) {
                Producer<CloseableReference<PooledByteBuffer>> localFileFetchEncodedImageProducerSequence = getLocalFileFetchEncodedImageProducerSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return localFileFetchEncodedImageProducerSequence;
            }
            if (sourceUriType != 4 && sourceUriType != 9 && sourceUriType != 10) {
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(sourceUri));
            }
            return getLocalContentUriFetchEncodedImageProducerSequence();
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public Producer<CloseableReference<PooledByteBuffer>> getNetworkFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence");
            }
            if (this.mNetworkEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchEncodedImageProducerSequence:init");
                }
                this.mNetworkEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mNetworkEncodedImageProducerSequence;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getLocalFileFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence");
            }
            if (this.mLocalFileEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchEncodedImageProducerSequence:init");
                }
                this.mLocalFileEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mLocalFileEncodedImageProducerSequence;
    }

    public Producer<CloseableReference<PooledByteBuffer>> getLocalContentUriFetchEncodedImageProducerSequence() {
        synchronized (this) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence");
            }
            if (this.mLocalContentUriEncodedImageProducerSequence == null) {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalContentUriFetchEncodedImageProducerSequence:init");
                }
                this.mLocalContentUriEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundLocalContentUriFetchToEncodeMemorySequence());
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        return this.mLocalContentUriEncodedImageProducerSequence;
    }

    public Producer<Void> getEncodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        validateEncodedImageRequest(imageRequest);
        int sourceUriType = imageRequest.getSourceUriType();
        if (sourceUriType == 0) {
            return getNetworkFetchToEncodedMemoryPrefetchSequence();
        }
        if (sourceUriType == 2 || sourceUriType == 3) {
            return getLocalFileFetchToEncodedMemoryPrefetchSequence();
        }
        throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + getShortenedUriString(imageRequest.getSourceUri()));
    }

    private static void validateEncodedImageRequest(ImageRequest imageRequest) {
        Preconditions.checkNotNull(imageRequest);
        Preconditions.checkArgument(imageRequest.getLowestPermittedRequestLevel().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public Producer<CloseableReference<CloseableImage>> getDecodedImageProducerSequence(ImageRequest imageRequest) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getDecodedImageProducerSequence");
        }
        Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (imageRequest.getPostprocessor() != null) {
            basicDecodedImageSequence = getPostprocessorSequence(basicDecodedImageSequence);
        }
        if (this.mUseBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return basicDecodedImageSequence;
    }

    public Producer<Void> getDecodedImagePrefetchProducerSequence(ImageRequest imageRequest) {
        Producer<CloseableReference<CloseableImage>> basicDecodedImageSequence = getBasicDecodedImageSequence(imageRequest);
        if (this.mUseBitmapPrepareToDraw) {
            basicDecodedImageSequence = getBitmapPrepareSequence(basicDecodedImageSequence);
        }
        return getDecodedImagePrefetchSequence(basicDecodedImageSequence);
    }

    private Producer<CloseableReference<CloseableImage>> getBasicDecodedImageSequence(ImageRequest imageRequest) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBasicDecodedImageSequence");
            }
            Preconditions.checkNotNull(imageRequest);
            Uri sourceUri = imageRequest.getSourceUri();
            Preconditions.checkNotNull(sourceUri, "Uri is null.");
            int sourceUriType = imageRequest.getSourceUriType();
            if (sourceUriType == 0) {
                Producer<CloseableReference<CloseableImage>> networkFetchSequence = getNetworkFetchSequence();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return networkFetchSequence;
            }
            switch (sourceUriType) {
                case 2:
                case 9:
                    Producer<CloseableReference<CloseableImage>> localVideoFileFetchSequence = getLocalVideoFileFetchSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return localVideoFileFetchSequence;
                case 3:
                    if (imageRequest.isResizedImageDiskCacheActuallyEnabled()) {
                        Producer<CloseableReference<CloseableImage>> diskCachedResizedImageFileFetchSequence = getDiskCachedResizedImageFileFetchSequence();
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return diskCachedResizedImageFileFetchSequence;
                    }
                    Producer<CloseableReference<CloseableImage>> localImageFileFetchSequence = getLocalImageFileFetchSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return localImageFileFetchSequence;
                case 4:
                    if (MediaUtils.isVideo(this.mContentResolver.getType(sourceUri))) {
                        Producer<CloseableReference<CloseableImage>> localVideoFileFetchSequence2 = getLocalVideoFileFetchSequence();
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return localVideoFileFetchSequence2;
                    }
                    Producer<CloseableReference<CloseableImage>> localContentUriFetchSequence = getLocalContentUriFetchSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return localContentUriFetchSequence;
                case 5:
                    Producer<CloseableReference<CloseableImage>> localAssetFetchSequence = getLocalAssetFetchSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return localAssetFetchSequence;
                case 6:
                    Producer<CloseableReference<CloseableImage>> localResourceFetchSequence = getLocalResourceFetchSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return localResourceFetchSequence;
                case 7:
                    Producer<CloseableReference<CloseableImage>> dataFetchSequence = getDataFetchSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return dataFetchSequence;
                case 8:
                    Producer<CloseableReference<CloseableImage>> qualifiedResourceFetchSequence = getQualifiedResourceFetchSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return qualifiedResourceFetchSequence;
                case 10:
                    if (imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()) {
                        return getLocalContentUriThumbnailBitmapSequence();
                    }
                    if (imageRequest.isResizedImageDiskCacheActuallyEnabled()) {
                        Producer<CloseableReference<CloseableImage>> diskCachedResizedImageLocalContentUriFetchSequence = getDiskCachedResizedImageLocalContentUriFetchSequence(1);
                        if (FrescoSystrace.isTracing()) {
                            FrescoSystrace.endSection();
                        }
                        return diskCachedResizedImageLocalContentUriFetchSequence;
                    }
                    Producer<CloseableReference<CloseableImage>> localContentUriFetchSequence2 = getLocalContentUriFetchSequence();
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return localContentUriFetchSequence2;
                default:
                    throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + getShortenedUriString(sourceUri));
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getNetworkFetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence");
        }
        if (this.mNetworkFetchSequence == null || this.newNetworkFetcher != null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchSequence:init");
            }
            this.mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
            this.newNetworkFetcher = null;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mNetworkFetchSequence;
    }

    private synchronized Producer<EncodedImage> getBackgroundNetworkFetchToEncodedMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");
        }
        if (this.mBackgroundNetworkFetchToEncodedMemorySequence == null || this.newNetworkFetcher != null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
            }
            this.mBackgroundNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence(), this.mThreadHandoffProducerQueue);
            this.newNetworkFetcher = null;
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundNetworkFetchToEncodedMemorySequence;
    }

    private synchronized Producer<Void> getNetworkFetchToEncodedMemoryPrefetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.mNetworkFetchToEncodedMemoryPrefetchSequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mNetworkFetchToEncodedMemoryPrefetchSequence;
    }

    private synchronized Producer<EncodedImage> getCommonNetworkFetchToEncodedMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        }
        if (this.mCommonNetworkFetchToEncodedMemorySequence == null || this.newNetworkFetcher != null) {
            NetworkFetcher networkFetcher = this.newNetworkFetcher;
            if (networkFetcher != null) {
                this.mNetworkFetcher = networkFetcher;
                this.newNetworkFetcher = null;
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");
            }
            AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newNetworkFetchProducer(this.mNetworkFetcher)));
            this.mCommonNetworkFetchToEncodedMemorySequence = newAddImageTransformMetaDataProducer;
            this.mCommonNetworkFetchToEncodedMemorySequence = this.mProducerFactory.newResizeAndRotateProducer(newAddImageTransformMetaDataProducer, this.mResizeAndRotateEnabledForNetwork && !this.mDownsampleEnabled, this.mImageTranscoderFactory);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mCommonNetworkFetchToEncodedMemorySequence;
    }

    private synchronized Producer<Void> getLocalFileFetchToEncodedMemoryPrefetchSequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.mLocalFileFetchToEncodedMemoryPrefetchSequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.mLocalFileFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundLocalFileFetchToEncodeMemorySequence());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mLocalFileFetchToEncodedMemoryPrefetchSequence;
    }

    private synchronized Producer<EncodedImage> getBackgroundLocalFileFetchToEncodeMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        }
        if (this.mBackgroundLocalFileFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");
            }
            this.mBackgroundLocalFileFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalFileFetchProducer()), this.mThreadHandoffProducerQueue);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundLocalFileFetchToEncodedMemorySequence;
    }

    private synchronized Producer<EncodedImage> getBackgroundLocalContentUriFetchToEncodeMemorySequence() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence");
        }
        if (this.mBackgroundLocalContentUriFetchToEncodedMemorySequence == null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ProducerSequenceFactory#getBackgroundLocalContentUriFetchToEncodeMemorySequence:init");
            }
            this.mBackgroundLocalContentUriFetchToEncodedMemorySequence = this.mProducerFactory.newBackgroundThreadHandoffProducer(newEncodedCacheMultiplexToTranscodeSequence(this.mProducerFactory.newLocalContentUriFetchProducer()), this.mThreadHandoffProducerQueue);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return this.mBackgroundLocalContentUriFetchToEncodedMemorySequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalImageFileFetchSequence() {
        if (this.mLocalImageFileFetchSequence == null) {
            this.mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalFileFetchProducer());
        }
        return this.mLocalImageFileFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getDiskCachedResizedImageFileFetchSequence() {
        if (this.mDiskCachedResizedImageFileFetchSequence == null) {
            this.mDiskCachedResizedImageFileFetchSequence = m501xd2e26f65(this.mProducerFactory.newLocalFileFetchProducer());
        }
        return this.mDiskCachedResizedImageFileFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getDiskCachedResizedImageLocalContentUriFetchSequence(int i) {
        if (i == 1) {
            if (this.mDiskCachedResizedImageLocalContentUriFetchSequence == null) {
                this.mDiskCachedResizedImageLocalContentUriFetchSequence = m501xd2e26f65(this.mProducerFactory.newLocalContentUriFetchProducer());
            }
            return this.mDiskCachedResizedImageLocalContentUriFetchSequence;
        }
        return getLocalContentUriFetchSequence();
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalVideoFileFetchSequence() {
        if (this.mLocalVideoFileFetchSequence == null) {
            this.mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalVideoThumbnailProducer());
        }
        return this.mLocalVideoFileFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalContentUriFetchSequence() {
        if (this.mLocalContentUriFetchSequence == null) {
            this.mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalContentUriFetchProducer(), new ThumbnailProducer[]{this.mProducerFactory.newLocalContentUriThumbnailFetchProducer(), this.mProducerFactory.newLocalExifThumbnailProducer()});
        }
        return this.mLocalContentUriFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalContentUriThumbnailBitmapSequence() {
        if (Build.VERSION.SDK_INT >= 29) {
        } else {
            throw new IllegalStateException("Unreachable exception. Just to make linter happy");
        }
        return newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newLocalContentUriThumbnailProducer());
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getQualifiedResourceFetchSequence() {
        if (this.mQualifiedResourceFetchSequence == null) {
            this.mQualifiedResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newQualifiedResourceFetchProducer());
        }
        return this.mQualifiedResourceFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalResourceFetchSequence() {
        if (this.mLocalResourceFetchSequence == null) {
            this.mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalResourceFetchProducer());
        }
        return this.mLocalResourceFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getLocalAssetFetchSequence() {
        if (this.mLocalAssetFetchSequence == null) {
            this.mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(this.mProducerFactory.newLocalAssetFetchProducer());
        }
        return this.mLocalAssetFetchSequence;
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getDataFetchSequence() {
        if (this.mDataFetchSequence == null) {
            Producer<EncodedImage> newDataFetchProducer = this.mProducerFactory.newDataFetchProducer();
            if (WebpSupportStatus.sIsWebpSupportRequired && (!this.mWebpSupportEnabled || WebpSupportStatus.sWebpBitmapFactory == null)) {
                newDataFetchProducer = this.mProducerFactory.newWebpTranscodeProducer(newDataFetchProducer);
            }
            this.mDataFetchSequence = newBitmapCacheGetToDecodeSequence(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(newDataFetchProducer), true, this.mImageTranscoderFactory));
        }
        return this.mDataFetchSequence;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer) {
        return newBitmapCacheGetToLocalTransformSequence(producer, new ThumbnailProducer[]{this.mProducerFactory.newLocalExifThumbnailProducer()});
    }

    /* renamed from: newBitmapCacheGetToDiskCachedResizedImageToLocalTransformSequence */
    private Producer<CloseableReference<CloseableImage>> m501xd2e26f65(Producer<EncodedImage> producer) {
        return m502xd2e26f65(producer, new ThumbnailProducer[]{this.mProducerFactory.newLocalContentUriThumbnailFetchProducer(), this.mProducerFactory.newLocalExifThumbnailProducer()});
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToLocalTransformSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(producer), thumbnailProducerArr));
    }

    /* renamed from: newBitmapCacheGetToDiskCachedResizedImageToLocalTransformSequence */
    private Producer<CloseableReference<CloseableImage>> m502xd2e26f65(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return newBitmapCacheGetToDecodeSequence(m503xca5cf188(newEncodedCacheMultiplexToTranscodeSequence(producer), thumbnailProducerArr));
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToDecodeSequence(Producer<EncodedImage> producer) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        }
        Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence = newBitmapCacheGetToBitmapCacheSequence(this.mProducerFactory.newDecodeProducer(producer));
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return newBitmapCacheGetToBitmapCacheSequence;
    }

    private Producer<EncodedImage> newEncodedCacheMultiplexToTranscodeSequence(Producer<EncodedImage> producer) {
        if (WebpSupportStatus.sIsWebpSupportRequired && (!this.mWebpSupportEnabled || WebpSupportStatus.sWebpBitmapFactory == null)) {
            producer = this.mProducerFactory.newWebpTranscodeProducer(producer);
        }
        if (this.mDiskCacheEnabled) {
            producer = newDiskCacheSequence(producer);
        }
        return this.mProducerFactory.newEncodedCacheKeyMultiplexProducer(this.mProducerFactory.newEncodedMemoryCacheProducer(producer));
    }

    private Producer<EncodedImage> newDiskCacheSequence(Producer<EncodedImage> producer) {
        DiskCacheWriteProducer newDiskCacheWriteProducer;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ProducerSequenceFactory#newDiskCacheSequence");
        }
        if (this.mPartialImageCachingEnabled) {
            newDiskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(this.mProducerFactory.newPartialDiskCacheProducer(producer));
        } else {
            newDiskCacheWriteProducer = this.mProducerFactory.newDiskCacheWriteProducer(producer);
        }
        DiskCacheReadProducer newDiskCacheReadProducer = this.mProducerFactory.newDiskCacheReadProducer(newDiskCacheWriteProducer);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return newDiskCacheReadProducer;
    }

    private Producer<CloseableReference<CloseableImage>> newBitmapCacheGetToBitmapCacheSequence(Producer<CloseableReference<CloseableImage>> producer) {
        return this.mProducerFactory.newBitmapMemoryCacheGetProducer(this.mProducerFactory.newBackgroundThreadHandoffProducer(this.mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(this.mProducerFactory.newBitmapMemoryCacheProducer(producer)), this.mThreadHandoffProducerQueue));
    }

    private Producer<EncodedImage> newLocalTransformationsSequence(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return ProducerFactory.newBranchOnSeparateImagesProducer(newLocalThumbnailProducer(thumbnailProducerArr), this.mProducerFactory.newThrottlingProducer(this.mProducerFactory.newResizeAndRotateProducer(ProducerFactory.newAddImageTransformMetaDataProducer(producer), true, this.mImageTranscoderFactory)));
    }

    /* renamed from: newResizedImageMultiplexToDiskCacheToLocalTransformationsSequence */
    private Producer<EncodedImage> m503xca5cf188(Producer<EncodedImage> producer, ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return this.mProducerFactory.newResizedImageCacheKeyMultiplexProducer(this.mProducerFactory.newResizedImageDiskCacheReadProducer(ProducerFactory.newBranchOnSeparateImagesProducer(newDiskCachedLocalThumbnailProducer(thumbnailProducerArr), this.mProducerFactory.newThrottlingProducer(this.mProducerFactory.newResizedImageDiskCacheWriteProducer(ProducerFactory.newAddImageTransformMetaDataProducer(producer), true, this.mImageTranscoderFactory)))));
    }

    private Producer<EncodedImage> newLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return this.mProducerFactory.newResizeAndRotateProducer(this.mProducerFactory.newThumbnailBranchProducer(thumbnailProducerArr), true, this.mImageTranscoderFactory);
    }

    private Producer<EncodedImage> newDiskCachedLocalThumbnailProducer(ThumbnailProducer<EncodedImage>[] thumbnailProducerArr) {
        return this.mProducerFactory.newResizedImageDiskCacheWriteProducer(this.mProducerFactory.newThumbnailBranchProducer(thumbnailProducerArr), true, this.mImageTranscoderFactory);
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getPostprocessorSequence(Producer<CloseableReference<CloseableImage>> producer) {
        if (!this.mPostprocessorSequences.containsKey(producer)) {
            this.mPostprocessorSequences.put(producer, this.mProducerFactory.newPostprocessorBitmapMemoryCacheProducer(this.mProducerFactory.newPostprocessorProducer(producer)));
        }
        return this.mPostprocessorSequences.get(producer);
    }

    private synchronized Producer<Void> getDecodedImagePrefetchSequence(Producer<CloseableReference<CloseableImage>> producer) {
        if (!this.mCloseableImagePrefetchSequences.containsKey(producer)) {
            this.mCloseableImagePrefetchSequences.put(producer, ProducerFactory.newSwallowResultProducer(producer));
        }
        return this.mCloseableImagePrefetchSequences.get(producer);
    }

    private synchronized Producer<CloseableReference<CloseableImage>> getBitmapPrepareSequence(Producer<CloseableReference<CloseableImage>> producer) {
        Producer<CloseableReference<CloseableImage>> producer2;
        producer2 = this.mBitmapPrepareSequences.get(producer);
        if (producer2 == null) {
            producer2 = this.mProducerFactory.newBitmapPrepareProducer(producer);
            this.mBitmapPrepareSequences.put(producer, producer2);
        }
        return producer2;
    }

    private static String getShortenedUriString(Uri uri) {
        String valueOf = String.valueOf(uri);
        return valueOf.length() > 30 ? valueOf.substring(0, 30) + "..." : valueOf;
    }

    public void setNetworkFetcher(NetworkFetcher networkFetcher) {
        this.newNetworkFetcher = networkFetcher;
    }
}

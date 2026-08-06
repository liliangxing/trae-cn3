package com.facebook.imagepipeline.core;

import android.graphics.Bitmap;
import android.net.Uri;
import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.alog.middleware.ALogService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ImagePipeline {
    private final MemoryCache<CacheKey, CloseableImage> mAnimBitmapMemoryCache;
    private final MemoryCache<CacheKey, Bitmap> mAnimatedHeifFrameMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mBigImgBitmapMemoryCache;
    private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private final CacheKeyFactory mCacheKeyFactory;
    private final HashMap<String, BufferedDiskCache> mCustomImageBufferedDiskCacheMap;
    private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private AtomicLong mIdCounter;
    private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    private final Supplier<Boolean> mLazyDataSource;
    private final BufferedDiskCache mMainBufferedDiskCache;
    private final MemoryCache<CacheKey, CloseableImage> mPrefetchImgBitmapMemoryCache;
    private final ProducerSequenceFactory mProducerSequenceFactory;
    private final RequestListener mRequestListener;
    private final MemoryCache<CacheKey, CloseableImage> mSingleBitmapMemoryCache;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;
    private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
    private final WebpOptSwitch webpOptSwitch;
    private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    private static boolean isOpenDebug = false;
    public static int CLEAR_BITMAP_MEM = 1;
    public static int CLEAR_ANIM_BITMAP_MEM = 2;
    public static int CLEAR_BIG_BITMAP_MEM = 4;
    public static int CLEAR_PREFETCH_BITMAP_MEM = 8;
    public static int CLEAR_SINGLE_BITMAP_MEM = 16;

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, Bitmap> memoryCache2, MemoryCache<CacheKey, PooledByteBuffer> memoryCache3, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3) {
        this(producerSequenceFactory, set, supplier, memoryCache, null, memoryCache2, memoryCache3, bufferedDiskCache, bufferedDiskCache2, hashMap, cacheKeyFactory, threadHandoffProducerQueue, supplier2, supplier3);
    }

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, CloseableImage> memoryCache2, MemoryCache<CacheKey, Bitmap> memoryCache3, MemoryCache<CacheKey, PooledByteBuffer> memoryCache4, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, HashMap<String, BufferedDiskCache> hashMap, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3) {
        this.mIdCounter = new AtomicLong();
        this.mProducerSequenceFactory = producerSequenceFactory;
        this.mRequestListener = new ForwardingRequestListener(set);
        this.mIsPrefetchEnabledSupplier = supplier;
        this.mBitmapMemoryCache = memoryCache;
        this.mSingleBitmapMemoryCache = ImagePipelineFactory.getInstance().isEnableSingleCache() ? ImagePipelineFactory.getInstance().getSingleBitmapMemoryCache() : null;
        this.mBigImgBitmapMemoryCache = ImagePipelineFactory.getInstance().isEnableBigImgCache() ? ImagePipelineFactory.getInstance().getBigImgBitmapMemoryCache() : null;
        this.mPrefetchImgBitmapMemoryCache = ImagePipelineFactory.getInstance().isSplitPrefetchCache() ? ImagePipelineFactory.getInstance().getPrefetchImgBitmapMemoryCache() : null;
        this.mAnimBitmapMemoryCache = memoryCache2;
        this.mAnimatedHeifFrameMemoryCache = memoryCache3;
        this.mEncodedMemoryCache = memoryCache4;
        this.mMainBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCustomImageBufferedDiskCacheMap = hashMap;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mSuppressBitmapPrefetchingSupplier = supplier2;
        this.mLazyDataSource = supplier3;
        this.webpOptSwitch = new WebpOptSwitch();
    }

    public static void openDebug(boolean z) {
        isOpenDebug = z;
    }

    public WebpOptSwitch getWebpOptSwitch() {
        return this.webpOptSwitch;
    }

    private String generateUniqueFutureId() {
        return String.valueOf(this.mIdCounter.getAndIncrement());
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object obj, final ImageRequest.RequestLevel requestLevel) {
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, obj, requestLevel);
            }

            public String toString() {
                return Objects.toStringHelper(this).add(LynxResourceModule.URI_KEY, imageRequest.getSourceUri()).toString();
            }
        };
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object obj, final ImageRequest.RequestLevel requestLevel, @Nullable final RequestListener requestListener) {
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, obj, requestLevel, requestListener);
            }

            public String toString() {
                return Objects.toStringHelper(this).add(LynxResourceModule.URI_KEY, imageRequest.getSourceUri()).toString();
            }
        };
    }

    public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest imageRequest, final Object obj) {
        return new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.common.internal.Supplier
            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                return ImagePipeline.this.fetchEncodedImage(imageRequest, obj);
            }

            public String toString() {
                return Objects.toStringHelper(this).add(LynxResourceModule.URI_KEY, imageRequest.getSourceUri()).toString();
            }
        };
    }

    public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, @Nullable RequestListener requestListener) {
        return fetchDecodedImage(imageRequest, obj, ImageRequest.RequestLevel.FULL_FETCH, requestListener);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel) {
        return fetchDecodedImage(imageRequest, obj, requestLevel, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener) {
        return fetchDecodedImage(imageRequest, obj, requestLevel, requestListener, getPriority(imageRequest));
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, @Nullable RequestListener requestListener, Priority priority) {
        try {
            return submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, requestLevel, obj, requestListener, priority);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj) {
        return fetchEncodedImage(imageRequest, obj, null);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj, @Nullable RequestListener requestListener) {
        Preconditions.checkNotNull(imageRequest.getSourceUri());
        try {
            Producer<CloseableReference<PooledByteBuffer>> encodedImageProducerSequence = this.mProducerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
            }
            return submitFetchRequest(encodedImageProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, requestListener);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object obj) {
        Producer<Void> decodedImagePrefetchProducerSequence;
        if (!this.mIsPrefetchEnabledSupplier.get().booleanValue()) {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            if (this.mSuppressBitmapPrefetchingSupplier.get().booleanValue()) {
                decodedImagePrefetchProducerSequence = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
            } else {
                decodedImagePrefetchProducerSequence = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
            }
            return submitPrefetchRequest(decodedImagePrefetchProducerSequence, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, getPriority(imageRequest));
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj) {
        return prefetchToDiskCache(imageRequest, obj, getPriority(imageRequest));
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.mIsPrefetchEnabledSupplier.get().booleanValue()) {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            return submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e) {
            return DataSources.immediateFailedDataSource(e);
        }
    }

    public void evictFromMemoryCache(Uri uri) {
        ImageRequest fromUri = ImageRequest.fromUri(uri);
        if (fromUri == null) {
            return;
        }
        final Uri parse = Uri.parse(DefaultCacheKeyFactory.getInstance().getBitmapCacheKey(fromUri, null).getUriString());
        Predicate<CacheKey> predicate = new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.4
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return cacheKey.containsUri(parse);
            }
        };
        this.mBitmapMemoryCache.removeAll(predicate);
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.mSingleBitmapMemoryCache;
        if (memoryCache != null) {
            memoryCache.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache2 = this.mBigImgBitmapMemoryCache;
        if (memoryCache2 != null) {
            memoryCache2.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache3 = this.mAnimBitmapMemoryCache;
        if (memoryCache3 != null) {
            memoryCache3.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache4 = this.mPrefetchImgBitmapMemoryCache;
        if (memoryCache4 != null) {
            memoryCache4.removeAll(predicate);
        }
        this.mEncodedMemoryCache.removeAll(predicate);
    }

    public void evictFromDiskCache(Uri uri) {
        evictFromDiskCache(ImageRequest.fromUri(uri));
    }

    public void evictFromDiskCache(ImageRequest imageRequest) {
        BufferedDiskCache bufferedDiskCache;
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        this.mMainBufferedDiskCache.remove(encodedCacheKey);
        this.mSmallImageBufferedDiskCache.remove(encodedCacheKey);
        if (isCustomCacheMapNullOrEmpty() || imageRequest == null || (bufferedDiskCache = this.mCustomImageBufferedDiskCacheMap.get(imageRequest.getCustomCacheName())) == null) {
            return;
        }
        bufferedDiskCache.remove(encodedCacheKey);
    }

    public void evictFromCache(Uri uri) {
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public void clearMemoryCaches() {
        Predicate<CacheKey> predicate = new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.5
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return true;
            }
        };
        this.mBitmapMemoryCache.removeAll(predicate);
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.mSingleBitmapMemoryCache;
        if (memoryCache != null) {
            memoryCache.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache2 = this.mBigImgBitmapMemoryCache;
        if (memoryCache2 != null) {
            memoryCache2.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache3 = this.mAnimBitmapMemoryCache;
        if (memoryCache3 != null) {
            memoryCache3.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache4 = this.mPrefetchImgBitmapMemoryCache;
        if (memoryCache4 != null) {
            memoryCache4.removeAll(predicate);
        }
        this.mEncodedMemoryCache.removeAll(predicate);
    }

    public void clearBitmapMemoryCaches() {
        Predicate<CacheKey> predicate = new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.6
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return true;
            }
        };
        this.mBitmapMemoryCache.removeAll(predicate);
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.mSingleBitmapMemoryCache;
        if (memoryCache != null) {
            memoryCache.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache2 = this.mBigImgBitmapMemoryCache;
        if (memoryCache2 != null) {
            memoryCache2.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache3 = this.mAnimBitmapMemoryCache;
        if (memoryCache3 != null) {
            memoryCache3.removeAll(predicate);
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache4 = this.mPrefetchImgBitmapMemoryCache;
        if (memoryCache4 != null) {
            memoryCache4.removeAll(predicate);
        }
    }

    public void clearBitmapMemoryCaches(int i) {
        MemoryCache<CacheKey, CloseableImage> memoryCache;
        MemoryCache<CacheKey, CloseableImage> memoryCache2;
        MemoryCache<CacheKey, CloseableImage> memoryCache3;
        MemoryCache<CacheKey, CloseableImage> memoryCache4;
        Predicate<CacheKey> predicate = new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.7
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return true;
            }
        };
        if ((CLEAR_BITMAP_MEM | i) > 0) {
            this.mBitmapMemoryCache.removeAll(predicate);
        }
        if ((CLEAR_SINGLE_BITMAP_MEM | i) > 0 && (memoryCache4 = this.mSingleBitmapMemoryCache) != null) {
            memoryCache4.removeAll(predicate);
        }
        if ((CLEAR_BIG_BITMAP_MEM | i) > 0 && (memoryCache3 = this.mBigImgBitmapMemoryCache) != null) {
            memoryCache3.removeAll(predicate);
        }
        if ((CLEAR_ANIM_BITMAP_MEM | i) > 0 && (memoryCache2 = this.mAnimBitmapMemoryCache) != null) {
            memoryCache2.removeAll(predicate);
        }
        if ((i | CLEAR_PREFETCH_BITMAP_MEM) <= 0 || (memoryCache = this.mPrefetchImgBitmapMemoryCache) == null) {
            return;
        }
        memoryCache.removeAll(predicate);
    }

    public void clearEncodeMemoryCaches() {
        this.mEncodedMemoryCache.removeAll(new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.8
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return true;
            }
        });
    }

    public void clearHeifMemoryCaches() {
        Predicate<CacheKey> predicate = new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.9
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return true;
            }
        };
        MemoryCache<CacheKey, Bitmap> memoryCache = this.mAnimatedHeifFrameMemoryCache;
        if (memoryCache != null) {
            memoryCache.removeAll(predicate);
        }
    }

    public void clearDiskCaches() {
        this.mMainBufferedDiskCache.clearAll();
        this.mSmallImageBufferedDiskCache.clearAll();
        if (isCustomCacheMapNullOrEmpty()) {
            return;
        }
        Iterator<String> it = this.mCustomImageBufferedDiskCacheMap.keySet().iterator();
        while (it.hasNext()) {
            BufferedDiskCache bufferedDiskCache = this.mCustomImageBufferedDiskCacheMap.get(it.next());
            if (bufferedDiskCache != null) {
                bufferedDiskCache.clearAll();
            }
        }
    }

    public void clearMainDiskCacheByPercentage(Double d) {
        this.mMainBufferedDiskCache.clearByPercentage(d);
    }

    public void clearSmallDiskCacheByPercentage(Double d) {
        this.mSmallImageBufferedDiskCache.clearByPercentage(d);
    }

    public void clearCustomDiskCacheByPercentage(Double d) {
        if (isCustomCacheMapNullOrEmpty()) {
            return;
        }
        Iterator<String> it = this.mCustomImageBufferedDiskCacheMap.keySet().iterator();
        while (it.hasNext()) {
            BufferedDiskCache bufferedDiskCache = this.mCustomImageBufferedDiskCacheMap.get(it.next());
            if (bufferedDiskCache != null) {
                bufferedDiskCache.clearByPercentage(d);
            }
        }
    }

    public void clearMainDiskCacheByTimestamp(long j) {
        this.mMainBufferedDiskCache.clearByTimestamp(j);
    }

    public void clearSmallDiskCacheByTimestamp(long j) {
        this.mSmallImageBufferedDiskCache.clearByTimestamp(j);
    }

    public void clearAllCustomDiskCacheByTimestamp(long j) {
        if (isCustomCacheMapNullOrEmpty()) {
            return;
        }
        Iterator<String> it = this.mCustomImageBufferedDiskCacheMap.keySet().iterator();
        while (it.hasNext()) {
            BufferedDiskCache bufferedDiskCache = this.mCustomImageBufferedDiskCacheMap.get(it.next());
            if (bufferedDiskCache != null) {
                bufferedDiskCache.clearByTimestamp(j);
            }
        }
    }

    public void clearCustomDiskCacheByTimestamp(String str, long j) {
        BufferedDiskCache bufferedDiskCache;
        this.mSmallImageBufferedDiskCache.clearByTimestamp(j);
        if (isCustomCacheMapNullOrEmpty() || (bufferedDiskCache = this.mCustomImageBufferedDiskCacheMap.get(str)) == null) {
            return;
        }
        bufferedDiskCache.clearByTimestamp(j);
    }

    public void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public boolean isInBitmapMemoryCache(Uri uri) {
        if (uri == null) {
            return false;
        }
        return isInBitmapMemoryCache(ImageRequest.fromUri(uri));
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.mBitmapMemoryCache;
    }

    public MemoryCache<CacheKey, CloseableImage> getBigImgBitmapMemoryCache() {
        return this.mBigImgBitmapMemoryCache;
    }

    public MemoryCache<CacheKey, CloseableImage> getAnimBitmapMemoryCache() {
        return this.mAnimBitmapMemoryCache;
    }

    public boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
        MemoryCache<CacheKey, CloseableImage> memoryCache;
        MemoryCache<CacheKey, CloseableImage> memoryCache2;
        MemoryCache<CacheKey, CloseableImage> memoryCache3;
        if (imageRequest == null) {
            return false;
        }
        CacheKey bitmapCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(imageRequest, null);
        CloseableReference<CloseableImage> closeableReference = this.mBitmapMemoryCache.get(bitmapCacheKey);
        if (closeableReference == null && ImagePipelineFactory.getInstance().isEnableSingleCache() && (memoryCache3 = this.mSingleBitmapMemoryCache) != null) {
            closeableReference = memoryCache3.get(bitmapCacheKey);
        }
        if (closeableReference == null && ImagePipelineFactory.getInstance().isEnableBigImgCache() && (memoryCache2 = this.mBigImgBitmapMemoryCache) != null) {
            closeableReference = memoryCache2.get(bitmapCacheKey);
        }
        if (closeableReference == null && ImagePipelineFactory.getInstance().isSplitPrefetchCache() && (memoryCache = this.mPrefetchImgBitmapMemoryCache) != null) {
            closeableReference = memoryCache.get(bitmapCacheKey);
        }
        try {
            return CloseableReference.isValid(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public boolean isInDiskCacheSync(Uri uri) {
        return isInDiskCacheSync(uri, ImageRequest.CacheChoice.SMALL) || isInDiskCacheSync(uri, ImageRequest.CacheChoice.DEFAULT);
    }

    public boolean isInDiskCacheSync(Uri uri, ImageRequest.CacheChoice cacheChoice) {
        return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build());
    }

    public boolean isInDiskCacheSync(ImageRequest imageRequest) {
        BufferedDiskCache bufferedDiskCache;
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        int i = C027814.f362x9ce557aa[imageRequest.getCacheChoice().ordinal()];
        if (i == 1) {
            return this.mMainBufferedDiskCache.diskCheckSync(encodedCacheKey);
        }
        if (i == 2) {
            return this.mSmallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
        }
        if (i != 3 || isCustomCacheMapNullOrEmpty() || (bufferedDiskCache = this.mCustomImageBufferedDiskCacheMap.get(imageRequest.getCustomCacheName())) == null) {
            return false;
        }
        return bufferedDiskCache.diskCheckSync(encodedCacheKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.imagepipeline.core.ImagePipeline$14 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static /* synthetic */ class C027814 {

        /* renamed from: $SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice */
        static final /* synthetic */ int[] f362x9ce557aa;

        static {
            int[] iArr = new int[ImageRequest.CacheChoice.values().length];
            f362x9ce557aa = iArr;
            try {
                iArr[ImageRequest.CacheChoice.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f362x9ce557aa[ImageRequest.CacheChoice.SMALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f362x9ce557aa[ImageRequest.CacheChoice.CUSTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public DataSource<Boolean> isInDiskCache(Uri uri) {
        return isInDiskCache(ImageRequest.fromUri(uri));
    }

    public DataSource<Boolean> isInDiskCache(final ImageRequest imageRequest) {
        final CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final SimpleDataSource create = SimpleDataSource.create();
        this.mMainBufferedDiskCache.contains(encodedCacheKey).continueWithTask(new Continuation<Boolean, Task<Boolean>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.12
            /* renamed from: then, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2641then(Task task) throws Exception {
                return then((Task<Boolean>) task);
            }

            public Task<Boolean> then(Task<Boolean> task) throws Exception {
                if (task.isCancelled() || task.isFaulted() || !((Boolean) task.getResult()).booleanValue()) {
                    return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(encodedCacheKey);
                }
                return Task.forResult(true);
            }
        }).continueWithTask(new Continuation<Boolean, Task<Boolean>>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.11
            /* renamed from: then, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2640then(Task task) throws Exception {
                return then((Task<Boolean>) task);
            }

            public Task<Boolean> then(Task<Boolean> task) throws Exception {
                BufferedDiskCache bufferedDiskCache;
                if (task.isCancelled() || task.isFaulted() || !((Boolean) task.getResult()).booleanValue()) {
                    if (!ImagePipeline.this.isCustomCacheMapNullOrEmpty() && (bufferedDiskCache = (BufferedDiskCache) ImagePipeline.this.mCustomImageBufferedDiskCacheMap.get(imageRequest.getCustomCacheName())) != null) {
                        return bufferedDiskCache.contains(encodedCacheKey);
                    }
                    return Task.forResult(false);
                }
                return Task.forResult(true);
            }
        }).continueWith(new Continuation<Boolean, Void>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.10
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m2639then((Task<Boolean>) task);
            }

            /* renamed from: then, reason: collision with other method in class */
            public Void m2639then(Task<Boolean> task) throws Exception {
                create.setResult(Boolean.valueOf((task.isCancelled() || task.isFaulted() || !((Boolean) task.getResult()).booleanValue()) ? false : true));
                return null;
            }
        });
        return create;
    }

    @Nullable
    public CacheKey getCacheKey(ImageRequest imageRequest, Object obj) {
        CacheKeyFactory cacheKeyFactory = this.mCacheKeyFactory;
        if (cacheKeyFactory == null || imageRequest == null) {
            return null;
        }
        if (imageRequest.getPostprocessor() != null) {
            return cacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, obj);
        }
        return cacheKeyFactory.getBitmapCacheKey(imageRequest, obj);
    }

    @Nullable
    public CloseableReference<CloseableImage> getCachedImage(@Nullable CacheKey cacheKey) {
        MemoryCache<CacheKey, CloseableImage> memoryCache = this.mBitmapMemoryCache;
        if (memoryCache == null || cacheKey == null) {
            return null;
        }
        MemoryCache<CacheKey, CloseableImage> memoryCache2 = this.mBigImgBitmapMemoryCache;
        MemoryCache<CacheKey, CloseableImage> memoryCache3 = this.mSingleBitmapMemoryCache;
        MemoryCache<CacheKey, CloseableImage> memoryCache4 = this.mPrefetchImgBitmapMemoryCache;
        CloseableReference<CloseableImage> closeableReference = (!ImagePipelineFactory.getInstance().isEnableSingleCache() || memoryCache3 == null) ? null : memoryCache3.get(cacheKey);
        if (closeableReference == null && ImagePipelineFactory.getInstance().isEnableBigImgCache() && memoryCache2 != null) {
            closeableReference = memoryCache2.get(cacheKey);
        }
        if (closeableReference == null) {
            closeableReference = memoryCache.get(cacheKey);
        }
        if (closeableReference == null && ImagePipelineFactory.getInstance().isSplitPrefetchCache() && memoryCache4 != null) {
            closeableReference = memoryCache4.get(cacheKey);
        }
        if (closeableReference == null || closeableReference.get().getQualityInfo().isOfFullQuality()) {
            return closeableReference;
        }
        closeableReference.close();
        return null;
    }

    private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable RequestListener requestListener) {
        return submitFetchRequest(producer, imageRequest, requestLevel, obj, requestListener, getPriority(imageRequest));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, @Nullable RequestListener requestListener, Priority priority) {
        boolean z;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipeline#submitFetchRequest");
        }
        RequestListener requestListenerForRequest = getRequestListenerForRequest(imageRequest, requestListener);
        try {
            try {
                ImageRequest.RequestLevel max = ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
                String generateUniqueFutureId = generateUniqueFutureId();
                boolean isPrefetch = imageRequest.isPrefetch();
                if (!imageRequest.getProgressiveRenderingEnabled() && !imageRequest.getProgressiveRenderingAnimatedEnabled() && UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                    z = false;
                    DataSource<CloseableReference<T>> create = CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId, requestListenerForRequest, obj, max, isPrefetch, z, priority), requestListenerForRequest);
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return create;
                }
                z = true;
                DataSource<CloseableReference<T>> create2 = CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId, requestListenerForRequest, obj, max, isPrefetch, z, priority), requestListenerForRequest);
                if (FrescoSystrace.isTracing()) {
                }
                return create2;
            } catch (Exception e) {
                DataSource<CloseableReference<T>> immediateFailedDataSource = DataSources.immediateFailedDataSource(e);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return immediateFailedDataSource;
            }
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    private DataSource<Void> submitPrefetchRequest(Producer<Void> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        RequestListener requestListenerForRequest = getRequestListenerForRequest(imageRequest, null);
        if (imageRequest != null) {
            try {
                imageRequest.setPrefetchMark(true);
            } catch (Exception e) {
                return DataSources.immediateFailedDataSource(e);
            }
        }
        return ProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId(), requestListenerForRequest, obj, ImageRequest.RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel), true, false, Priority.getLowerPriority(priority, Priority.MEDIUM)), requestListenerForRequest);
    }

    public RequestListener getRequestListenerForRequest(ImageRequest imageRequest, @Nullable RequestListener requestListener) {
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.mRequestListener;
            }
            return new ForwardingRequestListener(this.mRequestListener, imageRequest.getRequestListener());
        }
        if (imageRequest.getRequestListener() == null) {
            return new ForwardingRequestListener(this.mRequestListener, requestListener);
        }
        return new ForwardingRequestListener(this.mRequestListener, requestListener, imageRequest.getRequestListener());
    }

    private Predicate<CacheKey> predicateForUri(final Uri uri) {
        return new Predicate<CacheKey>() { // from class: com.facebook.imagepipeline.core.ImagePipeline.13
            @Override // com.facebook.common.internal.Predicate
            public boolean apply(CacheKey cacheKey) {
                return cacheKey.containsUri(uri);
            }
        };
    }

    public void pause() {
        if (isOpenDebug) {
            ALogService.iSafely("Fresco", "ImagePipeline pause!");
        }
        this.mThreadHandoffProducerQueue.startQueueing();
    }

    public void resume() {
        if (isOpenDebug) {
            ALogService.iSafely("Fresco", "ImagePipeline resume!");
        }
        this.mThreadHandoffProducerQueue.stopQueuing();
    }

    public boolean isPaused() {
        return this.mThreadHandoffProducerQueue.isQueueing();
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.mLazyDataSource;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }

    private Priority getPriority(ImageRequest imageRequest) {
        return imageRequest != null ? imageRequest.getPriority() : Priority.HIGH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCustomCacheMapNullOrEmpty() {
        HashMap<String, BufferedDiskCache> hashMap = this.mCustomImageBufferedDiskCacheMap;
        return hashMap == null || hashMap.isEmpty();
    }

    public void setNetWorkFetcher(NetworkFetcher networkFetcher) {
        this.mProducerSequenceFactory.setNetworkFetcher(networkFetcher);
    }
}

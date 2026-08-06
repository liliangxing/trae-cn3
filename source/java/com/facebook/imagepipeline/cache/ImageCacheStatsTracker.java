package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface ImageCacheStatsTracker {
    void onBitmapCacheHit(CacheKey cacheKey);

    void onBitmapCacheMiss();

    void onBitmapCachePut();

    void onDiskCacheGetFail();

    void onDiskCacheHit(CacheKey cacheKey);

    void onDiskCacheMiss();

    void onMemoryCacheHit(CacheKey cacheKey);

    void onMemoryCacheMiss();

    void onMemoryCachePut();

    void onStagingAreaHit(CacheKey cacheKey);

    void onStagingAreaMiss();

    void registerBitmapMemoryCache(CountingMemoryCache<?, ?> countingMemoryCache);

    void registerEncodedMemoryCache(CountingMemoryCache<?, ?> countingMemoryCache);

    void registerHashMapMemoryCache(HashMapMemoryCache<?, ?> hashMapMemoryCache);
}

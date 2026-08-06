package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.vcloud.strategy.StrategyCenter;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.HashMapMemoryCache;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AnimatedHeifFrameCache {
    private final HashMapMemoryCache<CacheKey, Bitmap> mAnimatedHeifBackingCache;
    private final CacheKey mImageCacheKey;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class FrameKey implements CacheKey {
        private final int mFrameIndex;
        private final CacheKey mImageCacheKey;

        @Override // com.facebook.cache.common.CacheKey
        public String getUriString() {
            return null;
        }

        public FrameKey(CacheKey cacheKey, int i) {
            this.mImageCacheKey = cacheKey;
            this.mFrameIndex = i;
        }

        @Override // com.facebook.cache.common.CacheKey
        public String toString() {
            return Objects.toStringHelper(this).add("imageCacheKey", this.mImageCacheKey).add("frameIndex", this.mFrameIndex).toString();
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FrameKey)) {
                return false;
            }
            FrameKey frameKey = (FrameKey) obj;
            return this.mFrameIndex == frameKey.mFrameIndex && this.mImageCacheKey.equals(frameKey.mImageCacheKey);
        }

        @Override // com.facebook.cache.common.CacheKey
        public int hashCode() {
            return (this.mImageCacheKey.hashCode() * StrategyCenter.DEVICE_THERMAL_MODE) + this.mFrameIndex;
        }

        @Override // com.facebook.cache.common.CacheKey
        public boolean containsUri(Uri uri) {
            return this.mImageCacheKey.containsUri(uri);
        }
    }

    public AnimatedHeifFrameCache(CacheKey cacheKey, HashMapMemoryCache<CacheKey, Bitmap> hashMapMemoryCache) {
        this.mImageCacheKey = cacheKey;
        this.mAnimatedHeifBackingCache = hashMapMemoryCache;
    }

    @Nullable
    public CloseableReference<Bitmap> cache(int i, CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.isValid(closeableReference)) {
            return null;
        }
        CloseableReference<Bitmap> cloneOrNull = CloseableReference.cloneOrNull(closeableReference);
        this.mAnimatedHeifBackingCache.cache(keyFor(i), cloneOrNull);
        return cloneOrNull;
    }

    @Nullable
    public CloseableReference<Bitmap> get(int i) {
        return this.mAnimatedHeifBackingCache.get(keyFor(i));
    }

    public boolean contains(int i) {
        return CloseableReference.isValid(this.mAnimatedHeifBackingCache.get(keyFor(i)));
    }

    public void clear() {
        this.mAnimatedHeifBackingCache.clearForCacheKey(this.mImageCacheKey);
    }

    private FrameKey keyFor(int i) {
        return new FrameKey(this.mImageCacheKey, i);
    }
}

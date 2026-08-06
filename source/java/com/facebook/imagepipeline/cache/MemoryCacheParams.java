package com.facebook.imagepipeline.cache;

/* loaded from: classes6.dex */
public class MemoryCacheParams {
    public static final int CACHE_TYPE_BITMAP_ANIM = 3;
    public static final int CACHE_TYPE_BITMAP_BIG = 4;
    public static final int CACHE_TYPE_BITMAP_NORMAL = 2;
    public static final int CACHE_TYPE_BITMAP_PREFETCH = 5;
    public static final int CACHE_TYPE_BITMAP_SINGLE = 6;
    public static final int CACHE_TYPE_DEFAULT = 0;
    public static final int CACHE_TYPE_ENCODE = 1;
    public int mCacheType;
    private ImageDynamicCacheStrategy mImageDynamicCacheStrategy;
    public final boolean mMemoryCacheOpt;
    public final boolean mOptReuseMemoryCache;
    public final int maxCacheEntries;
    public final int maxCacheEntrySize;
    private int maxCacheSize;
    public final int maxEvictionQueueEntries;
    public final int maxEvictionQueueSize;
    public final int maxOptEntrySize;

    public int getMaxCacheSize() {
        if (this.mImageDynamicCacheStrategy == null) {
            this.mImageDynamicCacheStrategy = ImageDynamicCacheStrategy.getStrategy();
        }
        if (this.mImageDynamicCacheStrategy != null) {
            int i = this.mCacheType;
            if (i == 1) {
                return ImageDynamicCacheStrategy.getStrategy().AdjustEncodeMemoryCacheSize(this.maxCacheSize);
            }
            if (i == 2) {
                return ImageDynamicCacheStrategy.getStrategy().AdjustNormalBitmapMemoryCacheSize(this.maxCacheSize);
            }
            if (i == 3) {
                return ImageDynamicCacheStrategy.getStrategy().AdjustAnimBitmapMemoryCacheSize(this.maxCacheSize);
            }
            if (i == 4) {
                return ImageDynamicCacheStrategy.getStrategy().AdjustBigBitmapMemoryCacheSize(this.maxCacheSize);
            }
            if (i == 5) {
                return ImageDynamicCacheStrategy.getStrategy().AdjustPrefetchBitmapMemoryCacheSize(this.maxCacheSize);
            }
            return this.maxCacheSize;
        }
        return this.maxCacheSize;
    }

    public MemoryCacheParams(int i, int i2, int i3, int i4, int i5) {
        this(0, i, i2, i3, i4, i5, false, 0, false);
    }

    public MemoryCacheParams(int i, int i2, int i3, int i4, int i5, boolean z, int i6) {
        this(0, i, i2, i3, i4, i5, z, i6, false);
    }

    public MemoryCacheParams(int i, int i2, int i3, int i4, int i5, boolean z, int i6, boolean z2) {
        this(0, i, i2, i3, i4, i5, z, i6, z2);
    }

    public MemoryCacheParams(int i, int i2, int i3, int i4, int i5, int i6, boolean z, int i7, boolean z2) {
        this.mCacheType = i;
        this.maxCacheSize = i2;
        this.maxCacheEntries = i3;
        this.maxEvictionQueueSize = i4;
        this.maxEvictionQueueEntries = i5;
        this.maxCacheEntrySize = i6;
        this.mMemoryCacheOpt = z;
        this.maxOptEntrySize = i7;
        this.mOptReuseMemoryCache = z2;
    }
}

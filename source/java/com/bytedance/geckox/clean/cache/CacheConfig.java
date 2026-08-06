package com.bytedance.geckox.clean.cache;

@Deprecated
/* loaded from: classes3.dex */
public class CacheConfig {
    private final CachePolicy mCachePolicy;
    final CleanListener mCleanListener;
    final int mLimitCount;

    private CacheConfig(Builder builder) {
        this.mLimitCount = builder.mLimitCount;
        this.mCachePolicy = builder.mCachePolicy;
        this.mCleanListener = builder.mCleanListener;
    }

    public CachePolicy getCachePolicy() {
        return this.mCachePolicy;
    }

    public int getLimitCount() {
        return this.mLimitCount;
    }

    public CleanListener getCleanListener() {
        return this.mCleanListener;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private CachePolicy mCachePolicy = CachePolicy.NONE;
        private CleanListener mCleanListener;
        private int mLimitCount;

        public Builder limitCount(int i) {
            this.mLimitCount = i;
            return this;
        }

        public Builder cachePolicy(CachePolicy cachePolicy) {
            if (cachePolicy == null) {
                cachePolicy = CachePolicy.NONE;
            }
            this.mCachePolicy = cachePolicy;
            return this;
        }

        public Builder cleanListener(CleanListener cleanListener) {
            this.mCleanListener = cleanListener;
            return this;
        }

        public CacheConfig build() {
            return new CacheConfig(this);
        }
    }
}

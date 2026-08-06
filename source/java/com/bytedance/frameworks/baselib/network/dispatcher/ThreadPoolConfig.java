package com.bytedance.frameworks.baselib.network.dispatcher;

import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
public class ThreadPoolConfig {
    private long mApiAliveTime;
    private int mCoreApiThreadSize;
    private int mCoreDownloadThreadSize;
    private int mCoreImmediateThreadSize;
    private int mCoreLowestThreadSize;
    private long mDownloadAliveTime;
    private ThreadPoolExecutor mDownloadThreadPool;
    private long mImmediateAliveTime;
    private ThreadPoolExecutor mImmediateThreadPool;
    private boolean mIsDynamicAdjust;
    private ThreadPoolExecutor mLocalThreadPool;
    private long mLowestAliveTime;
    private ThreadPoolExecutor mLowestThreadPool;
    private int mMaxApiThreadSize;
    private int mMaxDownloadThreadSize;
    private ThreadPoolExecutor mNormalThreadPool;

    private ThreadPoolConfig(Builder builder) {
        this.mCoreImmediateThreadSize = 0;
        this.mCoreApiThreadSize = 8;
        this.mCoreDownloadThreadSize = 8;
        this.mCoreLowestThreadSize = 1;
        this.mMaxApiThreadSize = 8;
        this.mMaxDownloadThreadSize = 8;
        this.mImmediateAliveTime = 10L;
        this.mApiAliveTime = 30L;
        this.mDownloadAliveTime = 10L;
        this.mLowestAliveTime = 10L;
        this.mIsDynamicAdjust = true;
        if (builder.mImmediateThreadPool != null) {
            this.mImmediateThreadPool = builder.mImmediateThreadPool;
        }
        if (builder.mLocalThreadPool != null) {
            this.mLocalThreadPool = builder.mLocalThreadPool;
        }
        if (builder.mNormalThreadPool != null) {
            this.mNormalThreadPool = builder.mNormalThreadPool;
        }
        if (builder.mDownloadThreadPool != null) {
            this.mDownloadThreadPool = builder.mDownloadThreadPool;
        }
        if (builder.mLowestThreadPool != null) {
            this.mLowestThreadPool = builder.mLowestThreadPool;
        }
        if (builder.mMaxApiThreadSize > 0) {
            this.mMaxApiThreadSize = builder.mMaxApiThreadSize;
        }
        if (builder.mMaxDownloadThreadSize > 0) {
            this.mMaxDownloadThreadSize = builder.mMaxDownloadThreadSize;
        }
        if (builder.mCoreApiThreadSize > 0) {
            this.mCoreApiThreadSize = builder.mCoreApiThreadSize;
        }
        if (builder.mCoreDownloadThreadSize > 0) {
            this.mCoreDownloadThreadSize = builder.mCoreDownloadThreadSize;
        }
        if (builder.mApiAliveTime > 0) {
            this.mApiAliveTime = builder.mApiAliveTime;
        }
        if (builder.mDownloadAliveTime > 0) {
            this.mDownloadAliveTime = builder.mDownloadAliveTime;
        }
        if (builder.mImmediateAliveTime > 0) {
            this.mImmediateAliveTime = builder.mImmediateAliveTime;
        }
        if (builder.mCoreImmediateThreadSize >= 0) {
            this.mCoreImmediateThreadSize = builder.mCoreImmediateThreadSize;
        }
        if (builder.mCoreLowestThreadSize > 0) {
            this.mCoreLowestThreadSize = builder.mCoreLowestThreadSize;
        }
        if (builder.mLowestAliveTime > 0) {
            this.mLowestAliveTime = builder.mLowestAliveTime;
        }
        this.mIsDynamicAdjust = builder.mIsDynamicAdjust;
    }

    public void setDynamicAdjust(boolean z) {
        this.mIsDynamicAdjust = z;
    }

    public ThreadPoolExecutor getImmediateThreadPool() {
        return this.mImmediateThreadPool;
    }

    public ThreadPoolExecutor getLocalThreadPool() {
        return this.mLocalThreadPool;
    }

    public ThreadPoolExecutor getNormalThreadPool() {
        return this.mNormalThreadPool;
    }

    public ThreadPoolExecutor getDownloadThreadPool() {
        return this.mDownloadThreadPool;
    }

    public ThreadPoolExecutor getLowestThreadPool() {
        return this.mLowestThreadPool;
    }

    public int getMaxApiThreadSize() {
        return this.mMaxApiThreadSize;
    }

    public int getMaxDownloadThreadSize() {
        return this.mMaxDownloadThreadSize;
    }

    public int getCoreLowestThreadSize() {
        return this.mCoreLowestThreadSize;
    }

    public long getLowestAliveTime() {
        return this.mLowestAliveTime;
    }

    public int getCoreApiThreadSize() {
        return this.mCoreApiThreadSize;
    }

    public int getCoreDownloadThreadSize() {
        return this.mCoreDownloadThreadSize;
    }

    public long getApiAliveTime() {
        return this.mApiAliveTime;
    }

    public long getDownloadAliveTime() {
        return this.mDownloadAliveTime;
    }

    public long getImmediateAliveTime() {
        return this.mImmediateAliveTime;
    }

    public int getCoreImmediateThreadSize() {
        return this.mCoreImmediateThreadSize;
    }

    public boolean isDynamicAdjust() {
        return this.mIsDynamicAdjust;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private long mApiAliveTime;
        private int mCoreApiThreadSize;
        private int mCoreDownloadThreadSize;
        private int mCoreImmediateThreadSize;
        private int mCoreLowestThreadSize;
        private long mDownloadAliveTime;
        private ThreadPoolExecutor mDownloadThreadPool;
        private long mImmediateAliveTime;
        private ThreadPoolExecutor mImmediateThreadPool;
        private boolean mIsDynamicAdjust = true;
        private ThreadPoolExecutor mLocalThreadPool;
        private long mLowestAliveTime;
        private ThreadPoolExecutor mLowestThreadPool;
        private int mMaxApiThreadSize;
        private int mMaxDownloadThreadSize;
        private ThreadPoolExecutor mNormalThreadPool;

        public Builder setImmediateThreadPool(ThreadPoolExecutor threadPoolExecutor) {
            this.mImmediateThreadPool = threadPoolExecutor;
            return this;
        }

        public Builder setLocalThreadPool(ThreadPoolExecutor threadPoolExecutor) {
            this.mLocalThreadPool = threadPoolExecutor;
            return this;
        }

        public Builder setNormalThreadPool(ThreadPoolExecutor threadPoolExecutor) {
            this.mNormalThreadPool = threadPoolExecutor;
            return this;
        }

        public Builder setDownloadThreadPool(ThreadPoolExecutor threadPoolExecutor) {
            this.mDownloadThreadPool = threadPoolExecutor;
            return this;
        }

        public Builder setLowestThreadPool(ThreadPoolExecutor threadPoolExecutor) {
            this.mLowestThreadPool = threadPoolExecutor;
            return this;
        }

        public Builder setApiThreadSize(int i, int i2) {
            if (i2 <= 0 || i <= 0) {
                throw new IllegalArgumentException("Api thread size must set > 0.");
            }
            if (i > i2) {
                throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
            }
            this.mMaxApiThreadSize = i2;
            this.mCoreApiThreadSize = i;
            return this;
        }

        public Builder setDownloadThreadSize(int i, int i2) {
            if (i2 <= 0 || i <= 0) {
                throw new IllegalArgumentException("Download thread size must set > 0.");
            }
            if (i > i2) {
                throw new IllegalArgumentException("Core thread size must set less equal than Max thread size.");
            }
            this.mMaxDownloadThreadSize = i2;
            this.mCoreDownloadThreadSize = i;
            return this;
        }

        public Builder setLowestThreadSize(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("Lowest thread size must set > 0.");
            }
            this.mCoreLowestThreadSize = i;
            return this;
        }

        public Builder setApiAliveTime(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("Api keep alive time must set > 0 when allow core thread timeout.");
            }
            this.mApiAliveTime = j;
            return this;
        }

        public Builder setDownloadAliveTime(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("Download keep alive time must set > 0 when allow core thread timeout.");
            }
            this.mDownloadAliveTime = j;
            return this;
        }

        public Builder setImmediateAliveTime(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("Immediate keep alive time must set > 0 when allow core thread timeout.");
            }
            this.mImmediateAliveTime = j;
            return this;
        }

        public Builder setLowestAliveTime(long j) {
            if (j <= 0) {
                throw new IllegalArgumentException("Immediate keep alive time must set > 0 when allow core thread timeout.");
            }
            this.mLowestAliveTime = j;
            return this;
        }

        public Builder setImmediateThreadSize(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Immdeiate core size must set > 0");
            }
            this.mCoreImmediateThreadSize = i;
            return this;
        }

        public Builder setDynamicAdjust(boolean z) {
            this.mIsDynamicAdjust = z;
            return this;
        }

        public ThreadPoolConfig build() {
            return new ThreadPoolConfig(this);
        }
    }
}

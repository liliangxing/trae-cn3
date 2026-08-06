package com.ss.android.socialbase.downloader.core.module.pcdn;

/* loaded from: classes7.dex */
public class PCDNRetryPolicy {
    private int mCurrentRetryCount;
    private int mMaxRetryCount;

    public PCDNRetryPolicy(int i) {
        this.mMaxRetryCount = i;
    }

    public boolean canRetry(boolean z) {
        int i = this.mCurrentRetryCount;
        if (i >= this.mMaxRetryCount) {
            return false;
        }
        if (z) {
            this.mCurrentRetryCount = i + 1;
        }
        return true;
    }

    public boolean isRetry() {
        return this.mCurrentRetryCount > 0;
    }
}

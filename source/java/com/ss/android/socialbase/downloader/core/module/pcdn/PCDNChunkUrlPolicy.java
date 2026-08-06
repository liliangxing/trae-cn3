package com.ss.android.socialbase.downloader.core.module.pcdn;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class PCDNChunkUrlPolicy {
    public static final int TYPE_CDN = 2;
    public static final int TYPE_PCDN = 1;
    private int mType;
    private List<String> mCdnUrls = new ArrayList();
    private List<String> mPcdnUrls = new ArrayList();
    private int mCdnIndex = -1;
    private int mPcdnIndex = -1;

    public PCDNChunkUrlPolicy(List<String> list, List<String> list2) {
        if (list != null && !list.isEmpty()) {
            this.mPcdnUrls.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            this.mCdnUrls.addAll(list2);
        }
        if (!this.mPcdnUrls.isEmpty()) {
            this.mType = 1;
        } else {
            this.mType = 2;
        }
    }

    public String obtainUrl() {
        int i = this.mType;
        if (i == 1) {
            if (this.mPcdnIndex < 0) {
                this.mPcdnIndex = 0;
            }
            List<String> list = this.mPcdnUrls;
            return list.get(this.mPcdnIndex % list.size());
        }
        if (i != 2) {
            return null;
        }
        if (this.mCdnIndex < 0) {
            this.mCdnIndex = 0;
        }
        List<String> list2 = this.mCdnUrls;
        return list2.get(this.mCdnIndex % list2.size());
    }

    public boolean switchToCdn() {
        if (this.mCdnUrls.isEmpty() || this.mType == 2) {
            return false;
        }
        this.mType = 2;
        return true;
    }

    public boolean isPCDN() {
        return this.mType == 1;
    }

    public void onError() {
        if (isPCDN() && !this.mPcdnUrls.isEmpty() && (this.mPcdnIndex < this.mPcdnUrls.size() - 1 || this.mCdnUrls.isEmpty())) {
            this.mPcdnIndex++;
        } else {
            if (this.mCdnUrls.isEmpty()) {
                return;
            }
            this.mCdnIndex++;
            this.mType = 2;
        }
    }

    public PCDNChunkUrlPolicy copy() {
        PCDNChunkUrlPolicy pCDNChunkUrlPolicy = new PCDNChunkUrlPolicy(this.mPcdnUrls, this.mCdnUrls);
        pCDNChunkUrlPolicy.mType = this.mType;
        pCDNChunkUrlPolicy.mPcdnIndex = this.mPcdnIndex;
        pCDNChunkUrlPolicy.mCdnIndex = this.mCdnIndex;
        return pCDNChunkUrlPolicy;
    }
}

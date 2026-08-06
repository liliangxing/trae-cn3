package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PCDNChunkAllocater {
    private DownloadInfo mDownloadInfo;
    private int mIndex;
    private long mMaxChunkLength;
    private long mStartOffset;

    public PCDNChunkAllocater(DownloadInfo downloadInfo, long j) {
        this.mDownloadInfo = downloadInfo;
        this.mMaxChunkLength = j;
        this.mStartOffset = DownloadHelper.getFirstOffset(downloadInfo) + downloadInfo.getStartOffset();
    }

    public PCDNChunk obtainPCDNChunk() {
        synchronized (this) {
            if (this.mStartOffset >= this.mDownloadInfo.getTotalBytes()) {
                return null;
            }
            PCDNChunk pCDNChunk = new PCDNChunk();
            pCDNChunk.mIndex = this.mIndex;
            pCDNChunk.mStartOffset = this.mStartOffset;
            long j = (this.mStartOffset + this.mMaxChunkLength) - 1;
            if (j < this.mDownloadInfo.getTotalBytes()) {
                pCDNChunk.mEndOffset = j;
            } else {
                pCDNChunk.mEndOffset = (this.mDownloadInfo.getStartOffset() + this.mDownloadInfo.getTotalBytes()) - 1;
            }
            this.mStartOffset += this.mMaxChunkLength;
            this.mIndex++;
            return pCDNChunk;
        }
    }
}

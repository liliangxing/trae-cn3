package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PCDNChunkProgressManager {
    private Map<Integer, ChunkCacheItem> mCacheDownloadedSize = new HashMap();
    private int mChunkProgressIndex;
    private IDownloadCache mDownloadCache;
    private DownloadInfo mDownloadInfo;
    private IDownloadRunnableCallback mDownloadRunnableCallback;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class ChunkCacheItem {
        private long downloadSize;
        private boolean isFinished;

        private ChunkCacheItem() {
        }
    }

    public PCDNChunkProgressManager(IDownloadRunnableCallback iDownloadRunnableCallback, IDownloadCache iDownloadCache, DownloadInfo downloadInfo) {
        this.mDownloadRunnableCallback = iDownloadRunnableCallback;
        this.mDownloadCache = iDownloadCache;
        this.mDownloadInfo = downloadInfo;
    }

    public void onDownloadChunkFinish(int i) {
        synchronized (this) {
            int i2 = this.mChunkProgressIndex;
            if (i != i2) {
                if (this.mCacheDownloadedSize.containsKey(Integer.valueOf(i))) {
                    ChunkCacheItem chunkCacheItem = this.mCacheDownloadedSize.get(Integer.valueOf(i));
                    chunkCacheItem.isFinished = true;
                    this.mCacheDownloadedSize.put(Integer.valueOf(i), chunkCacheItem);
                }
                return;
            }
            this.mChunkProgressIndex = i2 + 1;
            long j = 0;
            while (true) {
                ChunkCacheItem chunkCacheItem2 = this.mCacheDownloadedSize.get(Integer.valueOf(this.mChunkProgressIndex));
                if (chunkCacheItem2 == null) {
                    break;
                }
                j += chunkCacheItem2.downloadSize;
                if (!chunkCacheItem2.isFinished) {
                    chunkCacheItem2.downloadSize = 0L;
                    this.mCacheDownloadedSize.put(Integer.valueOf(this.mChunkProgressIndex), chunkCacheItem2);
                    break;
                } else {
                    this.mCacheDownloadedSize.remove(Integer.valueOf(this.mChunkProgressIndex));
                    this.mChunkProgressIndex++;
                }
            }
            if (j <= 0) {
                return;
            }
            try {
                this.mDownloadRunnableCallback.onProgress(j);
                this.mDownloadInfo.updateRealDownloadTime(true);
                this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean onProgress(int i, long j) throws BaseException {
        synchronized (this) {
            if (i == this.mChunkProgressIndex) {
                return this.mDownloadRunnableCallback.onProgress(j);
            }
            ChunkCacheItem chunkCacheItem = this.mCacheDownloadedSize.get(Integer.valueOf(i));
            if (chunkCacheItem == null) {
                chunkCacheItem = new ChunkCacheItem();
            }
            chunkCacheItem.downloadSize += j;
            this.mCacheDownloadedSize.put(Integer.valueOf(i), chunkCacheItem);
            return false;
        }
    }
}

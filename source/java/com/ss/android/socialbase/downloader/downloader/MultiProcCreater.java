package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.impls.IndependentDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.IndependentProcessDownloadHandler;
import com.ss.android.socialbase.downloader.p005db.SqlDownloadCacheAidlWrapper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MultiProcCreater implements DownloadComponentManager.IndependentHolderCreator {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public IDownloadServiceHandler createServiceHandler() {
        return new IndependentDownloadServiceHandler();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public IDownloadProxy createProxy() {
        return new IndependentProcessDownloadHandler();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.IndependentHolderCreator
    public ISqlDownloadCache createCache(DownloadComponentManager.IndependentHolderCreator.OnMainProcessRebindErrorListener onMainProcessRebindErrorListener) {
        SqlDownloadCacheAidlWrapper sqlDownloadCacheAidlWrapper = new SqlDownloadCacheAidlWrapper();
        sqlDownloadCacheAidlWrapper.setOnMainProcessRebindErrorCallback(onMainProcessRebindErrorListener);
        return sqlDownloadCacheAidlWrapper;
    }
}

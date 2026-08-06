package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.depend.AbsDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadMimeTypeInterceptModule extends AbsDownloadModule {
    private static final String TAG = "DownloadMimeTypeInterceptModule";

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams downloadCommonParams) {
        if (checkModuleEnabled(downloadCommonParams.mDownloadInfo)) {
            return super.init(downloadCommonParams);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        if (!TextUtils.isEmpty(this.mDownloadInfo.getMimeType()) && checkGlobalIntercept(this.mDownloadInfo)) {
            throw new BaseException(1083, "download global intercept mimeType");
        }
        iDownloadModuleChain.proceed();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        if (r3 == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkGlobalIntercept(DownloadInfo downloadInfo) {
        boolean z;
        if (!checkModuleEnabled(downloadInfo)) {
            return false;
        }
        try {
            IDownloadInterceptor downloadInterceptor = DownloadComponentManager.getDownloadInterceptor();
            z = downloadInterceptor.intercepte();
            if (!z) {
                try {
                    if (downloadInterceptor instanceof AbsDownloadInterceptor) {
                        z = ((AbsDownloadInterceptor) downloadInterceptor).intercept(downloadInfo);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                    } finally {
                        if (z) {
                            downloadInfo.setInterceptFlag(1);
                        } else {
                            downloadInfo.setInterceptFlag(0);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    private static boolean checkModuleEnabled(DownloadInfo downloadInfo) {
        return (downloadInfo.isFastDownload() || DownloadComponentManager.getDownloadInterceptor() == null || downloadInfo.isIgnoreInterceptor()) ? false : true;
    }
}

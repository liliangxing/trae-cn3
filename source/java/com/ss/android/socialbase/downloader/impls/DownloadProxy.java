package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadProxy {
    private static volatile IDownloadProxy downloadIndependentProxy;
    private static volatile IDownloadProxy downloadProxy;

    public static IDownloadProxy get(boolean z) {
        DownloadComponentManager.IndependentHolderCreator independentHolderCreator;
        if (z && DownloadComponentManager.supportMultiProc()) {
            if (downloadIndependentProxy == null) {
                synchronized (DownloadProxy.class) {
                    if (downloadIndependentProxy == null && (independentHolderCreator = DownloadComponentManager.getIndependentHolderCreator()) != null) {
                        downloadIndependentProxy = independentHolderCreator.createProxy();
                    }
                }
            }
            if (downloadIndependentProxy != null) {
                return downloadIndependentProxy;
            }
        }
        return getDefaultDownloadProxy();
    }

    private static IDownloadProxy getDefaultDownloadProxy() {
        if (downloadProxy == null) {
            synchronized (DownloadProxy.class) {
                if (downloadProxy == null) {
                    downloadProxy = new ProcessDownloadHandler();
                }
            }
        }
        return downloadProxy;
    }
}

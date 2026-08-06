package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadInterceptorAdaptor extends AbsDownloadInterceptor {
    private BaseDownloadListenerAdaptor<IDownloadInterceptor, AbsDownloadInterceptor> mBaseAdapter;

    private DownloadInterceptorAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SingletonInstance {
        private static final DownloadInterceptorAdaptor INSTANCE = new DownloadInterceptorAdaptor();

        private SingletonInstance() {
        }
    }

    public static DownloadInterceptorAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadInterceptor, com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
    @Deprecated
    public boolean intercepte() {
        IDownloadInterceptor defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.intercepte();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadInterceptor
    public boolean intercept(DownloadInfo downloadInfo) {
        AbsDownloadInterceptor bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            return bizListener.intercept(downloadInfo);
        }
        IDownloadInterceptor defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener == null || !(defaultListener instanceof AbsDownloadInterceptor)) {
            return false;
        }
        return ((AbsDownloadInterceptor) defaultListener).intercept(downloadInfo);
    }

    public IDownloadInterceptor addListener(IDownloadInterceptor iDownloadInterceptor) {
        if (!(iDownloadInterceptor instanceof AbsDownloadInterceptor ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IDownloadInterceptor, AbsDownloadInterceptor>) iDownloadInterceptor) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IDownloadInterceptor, AbsDownloadInterceptor>) iDownloadInterceptor);
        }
        return this;
    }
}

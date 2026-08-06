package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BeforeAppInstallInterceptorAdaptor extends AbsBeforeAppInstallInterceptor {
    private BaseDownloadListenerAdaptor<IBeforeAppInstallInterceptor, AbsBeforeAppInstallInterceptor> mBaseAdapter;

    private BeforeAppInstallInterceptorAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonInstance {
        private static final BeforeAppInstallInterceptorAdaptor INSTANCE = new BeforeAppInstallInterceptorAdaptor();

        private SingletonInstance() {
        }
    }

    public static BeforeAppInstallInterceptorAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor
    public void intercept(DownloadInfo downloadInfo, IAppInstallInterceptCallback iAppInstallInterceptCallback) {
        AbsBeforeAppInstallInterceptor bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            bizListener.intercept(downloadInfo, iAppInstallInterceptCallback);
            return;
        }
        IBeforeAppInstallInterceptor defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.intercept(downloadInfo, iAppInstallInterceptCallback);
        }
    }

    public IBeforeAppInstallInterceptor addListener(IBeforeAppInstallInterceptor iBeforeAppInstallInterceptor) {
        if (!(iBeforeAppInstallInterceptor instanceof AbsBeforeAppInstallInterceptor ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IBeforeAppInstallInterceptor, AbsBeforeAppInstallInterceptor>) iBeforeAppInstallInterceptor) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IBeforeAppInstallInterceptor, AbsBeforeAppInstallInterceptor>) iBeforeAppInstallInterceptor);
        }
        return this;
    }
}

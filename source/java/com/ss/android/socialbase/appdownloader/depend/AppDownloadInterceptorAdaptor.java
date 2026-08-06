package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppDownloadInterceptorAdaptor extends AbsAppDownloadInterceptor {
    private BaseDownloadListenerAdaptor<IAppDownloadInterceptor, AbsAppDownloadInterceptor> mBaseAdapter;

    private AppDownloadInterceptorAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonInstance {
        private static final AppDownloadInterceptorAdaptor INSTANCE = new AppDownloadInterceptorAdaptor();

        private SingletonInstance() {
        }
    }

    public static AppDownloadInterceptorAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadInterceptor
    public boolean intercept(AppTaskBuilder appTaskBuilder) {
        AbsAppDownloadInterceptor bizListener = this.mBaseAdapter.getBizListener(appTaskBuilder.getMonitorScene());
        if (bizListener != null) {
            return bizListener.intercept(appTaskBuilder);
        }
        IAppDownloadInterceptor defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.intercept(appTaskBuilder);
        }
        return false;
    }

    public IAppDownloadInterceptor addListener(IAppDownloadInterceptor iAppDownloadInterceptor) {
        if (!(iAppDownloadInterceptor instanceof AbsAppDownloadInterceptor ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadInterceptor, AbsAppDownloadInterceptor>) iAppDownloadInterceptor) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadInterceptor, AbsAppDownloadInterceptor>) iAppDownloadInterceptor);
        }
        return this;
    }
}

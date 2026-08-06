package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppDownloadEventHandlerAdaptor extends AbsAppDownloadEventHandler {
    private BaseDownloadListenerAdaptor<IAppDownloadEventHandler, AbsAppDownloadEventHandler> mBaseAdapter;

    private AppDownloadEventHandlerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonInstance {
        private static final AppDownloadEventHandlerAdaptor INSTANCE = new AppDownloadEventHandlerAdaptor();

        private SingletonInstance() {
        }
    }

    public static AppDownloadEventHandlerAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleAppInstalled(Context context, String str) {
        handleAppInstalled(null, context, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public boolean isForbidInvalidatePackageInstall() {
        return isForbidInvalidatePackageInstall(null);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler
    public void handleAppInstalled(DownloadInfo downloadInfo, Context context, String str) {
        AbsAppDownloadEventHandler bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            bizListener.handleAppInstalled(context, str);
            return;
        }
        IAppDownloadEventHandler defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.handleAppInstalled(context, str);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleDownloadEvent(int i, int i2, String str, int i3, long j) {
        AbsAppDownloadEventHandler bizListener = this.mBaseAdapter.getBizListener(Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i));
        if (bizListener != null) {
            bizListener.handleDownloadEvent(i, i2, str, i3, j);
            return;
        }
        IAppDownloadEventHandler defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.handleDownloadEvent(i, i2, str, i3, j);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public boolean installIntercept(int i, boolean z) {
        AbsAppDownloadEventHandler bizListener = this.mBaseAdapter.getBizListener(Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i));
        if (bizListener != null) {
            return bizListener.installIntercept(i, z);
        }
        IAppDownloadEventHandler defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.installIntercept(i, z);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleDownloadCancel(DownloadInfo downloadInfo) {
        AbsAppDownloadEventHandler bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            bizListener.handleDownloadCancel(downloadInfo);
            return;
        }
        IAppDownloadEventHandler defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.handleDownloadCancel(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler, com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleAppInstallError(int i, int i2, String str, String str2, String str3) {
        AbsAppDownloadEventHandler bizListener = this.mBaseAdapter.getBizListener(Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i));
        if (bizListener != null) {
            bizListener.handleAppInstallError(i, i2, str, str2, str3);
            return;
        }
        IAppDownloadEventHandler defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.handleAppInstallError(i, i2, str, str2, str3);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler
    public boolean isForbidInvalidatePackageInstall(DownloadInfo downloadInfo) {
        AbsAppDownloadEventHandler bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            return bizListener.isForbidInvalidatePackageInstall();
        }
        IAppDownloadEventHandler defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.isForbidInvalidatePackageInstall();
        }
        return false;
    }

    public IAppDownloadEventHandler addListener(IAppDownloadEventHandler iAppDownloadEventHandler) {
        if (!(iAppDownloadEventHandler instanceof AbsAppDownloadEventHandler ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadEventHandler, AbsAppDownloadEventHandler>) iAppDownloadEventHandler) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadEventHandler, AbsAppDownloadEventHandler>) iAppDownloadEventHandler);
        }
        return this;
    }
}

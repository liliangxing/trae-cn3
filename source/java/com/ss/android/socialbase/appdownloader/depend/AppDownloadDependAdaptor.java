package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppDownloadDependAdaptor extends AbsAppDownloadDepend {
    private BaseDownloadListenerAdaptor<IAppDownloadDepend, AbsAppDownloadDepend> mBaseAdapter;

    private AppDownloadDependAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonInstance {
        private static final AppDownloadDependAdaptor INSTANCE = new AppDownloadDependAdaptor();

        private SingletonInstance() {
        }
    }

    public static AppDownloadDependAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend, com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public boolean getAllowNetwork(Context context) {
        return getAllowNetwork(0, context);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend, com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend
    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(Context context) {
        return getThemedAlertDlgBuilder(0, context);
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend
    public boolean getAllowNetwork(int i, Context context) {
        AbsAppDownloadDepend bizListener = this.mBaseAdapter.getBizListener(i != 0 ? Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i) : null);
        if (bizListener != null) {
            return bizListener.getAllowNetwork(context);
        }
        IAppDownloadDepend defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.getAllowNetwork(context);
        }
        return true;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend
    public IDownloadAlertDialogBuilder getThemedAlertDlgBuilder(int i, Context context) {
        AbsAppDownloadDepend bizListener = this.mBaseAdapter.getBizListener(i != 0 ? Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i) : null);
        if (bizListener != null) {
            return bizListener.getThemedAlertDlgBuilder(context);
        }
        IAppDownloadDepend defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.getThemedAlertDlgBuilder(context);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend
    public boolean isForbiddenInstallForInvalidatePackageName(DownloadInfo downloadInfo) {
        AbsAppDownloadDepend bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            return bizListener.isForbiddenInstallForInvalidatePackageName(downloadInfo);
        }
        IAppDownloadDepend defaultListener = this.mBaseAdapter.getDefaultListener();
        if (bizListener == null || !(defaultListener instanceof AbsAppDownloadDepend)) {
            return false;
        }
        return bizListener.isForbiddenInstallForInvalidatePackageName(downloadInfo);
    }

    public IAppDownloadDepend addListener(IAppDownloadDepend iAppDownloadDepend) {
        if (!(iAppDownloadDepend instanceof AbsAppDownloadDepend ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadDepend, AbsAppDownloadDepend>) iAppDownloadDepend) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadDepend, AbsAppDownloadDepend>) iAppDownloadDepend);
        }
        return this;
    }
}

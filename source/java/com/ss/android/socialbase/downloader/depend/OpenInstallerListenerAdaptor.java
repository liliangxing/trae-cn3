package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class OpenInstallerListenerAdaptor extends AbsOpenInstallerListener {
    private BaseDownloadListenerAdaptor<IOpenInstallerListener, AbsOpenInstallerListener> mBaseAdapter;

    private OpenInstallerListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SingletonInstance {
        private static final OpenInstallerListenerAdaptor INSTANCE = new OpenInstallerListenerAdaptor();

        private SingletonInstance() {
        }
    }

    public static OpenInstallerListenerAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IOpenInstallerListener
    public void onOpenInstaller(DownloadInfo downloadInfo, String str) {
        AbsOpenInstallerListener bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            bizListener.onOpenInstaller(downloadInfo, str);
            return;
        }
        IOpenInstallerListener defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.onOpenInstaller(downloadInfo, str);
        }
    }

    public IOpenInstallerListener addListener(IOpenInstallerListener iOpenInstallerListener) {
        if (!(iOpenInstallerListener instanceof AbsOpenInstallerListener ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IOpenInstallerListener, AbsOpenInstallerListener>) iOpenInstallerListener) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IOpenInstallerListener, AbsOpenInstallerListener>) iOpenInstallerListener);
        }
        return this;
    }
}

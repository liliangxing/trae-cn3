package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppDownloadMonitorListenerAdaptor extends AbsAppDownloadMonitorListener {
    private BaseDownloadListenerAdaptor<IAppDownloadMonitorListener, AbsAppDownloadMonitorListener> mBaseAdapter;

    private AppDownloadMonitorListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonInstance {
        private static final AppDownloadMonitorListenerAdaptor INSTANCE = new AppDownloadMonitorListenerAdaptor();

        private SingletonInstance() {
        }
    }

    public static AppDownloadMonitorListenerAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener
    public void onAppDownloadMonitorSend(DownloadInfo downloadInfo, BaseException baseException, int i) {
        AbsAppDownloadMonitorListener bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            bizListener.onAppDownloadMonitorSend(downloadInfo, baseException, i);
            return;
        }
        IAppDownloadMonitorListener defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.onAppDownloadMonitorSend(downloadInfo, baseException, i);
        }
    }

    public IAppDownloadMonitorListener addListener(IAppDownloadMonitorListener iAppDownloadMonitorListener) {
        if (!(iAppDownloadMonitorListener instanceof AbsAppDownloadMonitorListener ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadMonitorListener, AbsAppDownloadMonitorListener>) iAppDownloadMonitorListener) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IAppDownloadMonitorListener, AbsAppDownloadMonitorListener>) iAppDownloadMonitorListener);
        }
        return this;
    }
}

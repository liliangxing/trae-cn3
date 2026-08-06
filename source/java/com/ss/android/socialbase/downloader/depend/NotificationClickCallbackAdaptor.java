package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NotificationClickCallbackAdaptor extends AbsNotificationClickCallback {
    private BaseDownloadListenerAdaptor<INotificationClickCallback, AbsNotificationClickCallback> mBaseAdapter;

    private NotificationClickCallbackAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SingletonInstance {
        private static final NotificationClickCallbackAdaptor INSTANCE = new NotificationClickCallbackAdaptor();

        private SingletonInstance() {
        }
    }

    public static NotificationClickCallbackAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
    public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) {
        AbsNotificationClickCallback bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            return bizListener.onClickWhenUnSuccess(downloadInfo);
        }
        INotificationClickCallback defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.onClickWhenUnSuccess(downloadInfo);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
    public boolean onClickWhenSuccess(DownloadInfo downloadInfo) {
        AbsNotificationClickCallback bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            return bizListener.onClickWhenSuccess(downloadInfo);
        }
        INotificationClickCallback defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.onClickWhenSuccess(downloadInfo);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
    public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
        AbsNotificationClickCallback bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            return bizListener.onClickWhenInstalled(downloadInfo);
        }
        INotificationClickCallback defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.onClickWhenInstalled(downloadInfo);
        }
        return false;
    }

    public INotificationClickCallback addListener(INotificationClickCallback iNotificationClickCallback) {
        if (!(iNotificationClickCallback instanceof AbsNotificationClickCallback ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<INotificationClickCallback, AbsNotificationClickCallback>) iNotificationClickCallback) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<INotificationClickCallback, AbsNotificationClickCallback>) iNotificationClickCallback);
        }
        return this;
    }
}

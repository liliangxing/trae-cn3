package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MockNotificationProgressHandlerAdaptor extends AbsMockNotificationProgressHandler {
    private BaseDownloadListenerAdaptor<IMockNotificationProgressHandler, AbsMockNotificationProgressHandler> mBaseAdapter;

    private MockNotificationProgressHandlerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonInstance {
        private static final MockNotificationProgressHandlerAdaptor INSTANCE = new MockNotificationProgressHandlerAdaptor();

        private SingletonInstance() {
        }
    }

    public static MockNotificationProgressHandlerAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler
    public long onNotificationUpdate(int i, long j, long j2) {
        AbsMockNotificationProgressHandler bizListener = this.mBaseAdapter.getBizListener(Downloader.getInstance(DownloadComponentManager.getAppContext()).getDownloadInfo(i));
        if (bizListener != null) {
            return bizListener.onNotificationUpdate(i, j, j2);
        }
        IMockNotificationProgressHandler defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            return defaultListener.onNotificationUpdate(i, j, j2);
        }
        return 0L;
    }

    public IMockNotificationProgressHandler addListener(IMockNotificationProgressHandler iMockNotificationProgressHandler) {
        if (!(iMockNotificationProgressHandler instanceof AbsMockNotificationProgressHandler ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IMockNotificationProgressHandler, AbsMockNotificationProgressHandler>) iMockNotificationProgressHandler) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IMockNotificationProgressHandler, AbsMockNotificationProgressHandler>) iMockNotificationProgressHandler);
        }
        return this;
    }
}

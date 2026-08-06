package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ReserveWifiStatusListenerAdaptor extends AbsReserveWifiStatusListener {
    private BaseDownloadListenerAdaptor<IReserveWifiStatusListener, AbsReserveWifiStatusListener> mBaseAdapter;

    private ReserveWifiStatusListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class SingletonInstance {
        private static final ReserveWifiStatusListenerAdaptor INSTANCE = new ReserveWifiStatusListenerAdaptor();

        private SingletonInstance() {
        }
    }

    public static ReserveWifiStatusListenerAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener
    public void onStatusChanged(DownloadInfo downloadInfo, int i, int i2) {
        AbsReserveWifiStatusListener bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            bizListener.onStatusChanged(downloadInfo, i, i2);
            return;
        }
        IReserveWifiStatusListener defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.onStatusChanged(downloadInfo, i, i2);
        }
    }

    public IReserveWifiStatusListener addListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        if (!(iReserveWifiStatusListener instanceof AbsReserveWifiStatusListener ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IReserveWifiStatusListener, AbsReserveWifiStatusListener>) iReserveWifiStatusListener) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<IReserveWifiStatusListener, AbsReserveWifiStatusListener>) iReserveWifiStatusListener);
        }
        return this;
    }
}

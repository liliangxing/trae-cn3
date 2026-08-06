package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.AhAttempt;
import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.downloader.depend.BaseDownloadListenerAdaptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class OnAhAttemptListenerAdaptor extends AbsOnAhAttemptListener {
    private BaseDownloadListenerAdaptor<AhUtils.OnAhAttemptListener, AbsOnAhAttemptListener> mBaseAdapter;

    private OnAhAttemptListenerAdaptor() {
        this.mBaseAdapter = new BaseDownloadListenerAdaptor<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonInstance {
        private static final OnAhAttemptListenerAdaptor INSTANCE = new OnAhAttemptListenerAdaptor();

        private SingletonInstance() {
        }
    }

    public static OnAhAttemptListenerAdaptor getInstance() {
        return SingletonInstance.INSTANCE;
    }

    @Override // com.ss.android.socialbase.appdownloader.AhUtils.OnAhAttemptListener
    public void onAhAttemptResult(DownloadInfo downloadInfo, AhAttempt ahAttempt) {
        AbsOnAhAttemptListener bizListener = this.mBaseAdapter.getBizListener(downloadInfo);
        if (bizListener != null) {
            bizListener.onAhAttemptResult(downloadInfo, ahAttempt);
            return;
        }
        AhUtils.OnAhAttemptListener defaultListener = this.mBaseAdapter.getDefaultListener();
        if (defaultListener != null) {
            defaultListener.onAhAttemptResult(downloadInfo, ahAttempt);
        }
    }

    public AhUtils.OnAhAttemptListener addListener(AhUtils.OnAhAttemptListener onAhAttemptListener) {
        if (!(onAhAttemptListener instanceof AbsOnAhAttemptListener ? this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<AhUtils.OnAhAttemptListener, AbsOnAhAttemptListener>) onAhAttemptListener) : false)) {
            this.mBaseAdapter.addListener((BaseDownloadListenerAdaptor<AhUtils.OnAhAttemptListener, AbsOnAhAttemptListener>) onAhAttemptListener);
        }
        return this;
    }
}

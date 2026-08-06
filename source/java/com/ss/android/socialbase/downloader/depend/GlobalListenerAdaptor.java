package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GlobalListenerAdaptor {
    private static final String TAG = "GlobalListenerAdaptor";
    private static AtomicBoolean sRunSetter = new AtomicBoolean(false);
    protected static volatile boolean sEnabled = false;

    public static IOpenInstallerListener addListener(IOpenInstallerListener iOpenInstallerListener) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "OpenInstallerListener sEnabled:" + sEnabled);
        }
        return !isEnabled(iOpenInstallerListener) ? iOpenInstallerListener : OpenInstallerListenerAdaptor.getInstance().addListener(iOpenInstallerListener);
    }

    public static IReserveWifiStatusListener addListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "ReserveWifiStatusListener sEnabled:" + sEnabled);
        }
        return !isEnabled(iReserveWifiStatusListener) ? iReserveWifiStatusListener : ReserveWifiStatusListenerAdaptor.getInstance().addListener(iReserveWifiStatusListener);
    }

    public static InnerEventListener addListener(InnerEventListener innerEventListener) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "InnerEventListener sEnabled:" + sEnabled);
        }
        return !isEnabled(innerEventListener) ? innerEventListener : InnerEventListenerAdaptor.getInstance().addEventListener(innerEventListener);
    }

    public static IDownloadInterceptor addListener(IDownloadInterceptor iDownloadInterceptor) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "DownloadInterceptor sEnabled:" + sEnabled);
        }
        return !isEnabled(iDownloadInterceptor) ? iDownloadInterceptor : DownloadInterceptorAdaptor.getInstance().addListener(iDownloadInterceptor);
    }

    public static INotificationClickCallback addListener(INotificationClickCallback iNotificationClickCallback) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "NotificationClickCallback sEnabled:" + sEnabled);
        }
        return !isEnabled(iNotificationClickCallback) ? iNotificationClickCallback : NotificationClickCallbackAdaptor.getInstance().addListener(iNotificationClickCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isEnabled(Object obj) {
        sRunSetter.compareAndSet(false, true);
        return sEnabled && obj != null;
    }

    public static void setEnabled(boolean z) {
        if (sRunSetter.compareAndSet(false, true)) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "setEnabled", "First Run:" + z);
            }
            sEnabled = z;
        } else if (Logger.debug()) {
            Logger.globalDebug(TAG, "setEnabled", "Run:" + z);
        }
    }
}

package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler;
import com.ss.android.socialbase.downloader.depend.GlobalListenerAdaptor;
import com.ss.android.socialbase.downloader.logger.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppGlobalListenerAdaptor extends GlobalListenerAdaptor {
    private static final String TAG = "AppGlobalListenerAdaptor";

    public static IAppDownloadDepend addListener(IAppDownloadDepend iAppDownloadDepend) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "AppDownloadDepend sEnabled:" + sEnabled);
        }
        return !isEnabled(iAppDownloadDepend) ? iAppDownloadDepend : AppDownloadDependAdaptor.getInstance().addListener(iAppDownloadDepend);
    }

    public static IAppDownloadEventHandler addListener(IAppDownloadEventHandler iAppDownloadEventHandler) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "AppDownloadEventHandler sEnabled:" + sEnabled);
        }
        return !isEnabled(iAppDownloadEventHandler) ? iAppDownloadEventHandler : AppDownloadEventHandlerAdaptor.getInstance().addListener(iAppDownloadEventHandler);
    }

    public static IAppDownloadInterceptor addListener(IAppDownloadInterceptor iAppDownloadInterceptor) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "AppDownloadInterceptor sEnabled:" + sEnabled);
        }
        return !isEnabled(iAppDownloadInterceptor) ? iAppDownloadInterceptor : AppDownloadInterceptorAdaptor.getInstance().addListener(iAppDownloadInterceptor);
    }

    public static IAppDownloadLaunchResumeListener addListener(IAppDownloadLaunchResumeListener iAppDownloadLaunchResumeListener) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "AppDownloadLaunchResumeListener sEnabled:" + sEnabled);
        }
        return !isEnabled(iAppDownloadLaunchResumeListener) ? iAppDownloadLaunchResumeListener : AppDownloadLaunchResumeListenerAdaptor.getInstance().addListener(iAppDownloadLaunchResumeListener);
    }

    public static IAppDownloadMonitorListener addListener(IAppDownloadMonitorListener iAppDownloadMonitorListener) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "AppDownloadMonitorListener sEnabled:" + sEnabled);
        }
        return !isEnabled(iAppDownloadMonitorListener) ? iAppDownloadMonitorListener : AppDownloadMonitorListenerAdaptor.getInstance().addListener(iAppDownloadMonitorListener);
    }

    public static IBeforeAppInstallInterceptor addListener(IBeforeAppInstallInterceptor iBeforeAppInstallInterceptor) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "BeforeAppInstallInterceptor sEnabled:" + sEnabled);
        }
        return !isEnabled(iBeforeAppInstallInterceptor) ? iBeforeAppInstallInterceptor : BeforeAppInstallInterceptorAdaptor.getInstance().addListener(iBeforeAppInstallInterceptor);
    }

    public static IMockNotificationProgressHandler addListener(IMockNotificationProgressHandler iMockNotificationProgressHandler) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "MockNotificationProgressHandler sEnabled:" + sEnabled);
        }
        return !isEnabled(iMockNotificationProgressHandler) ? iMockNotificationProgressHandler : MockNotificationProgressHandlerAdaptor.getInstance().addListener(iMockNotificationProgressHandler);
    }

    public static AhUtils.OnAhAttemptListener addListener(AhUtils.OnAhAttemptListener onAhAttemptListener) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "addListener", "AhUtils_OnAhAttemptListener sEnabled:" + sEnabled);
        }
        return !isEnabled(onAhAttemptListener) ? onAhAttemptListener : OnAhAttemptListenerAdaptor.getInstance().addListener(onAhAttemptListener);
    }
}

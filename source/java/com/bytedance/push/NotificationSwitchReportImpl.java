package com.bytedance.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.helper.SysDialogActivityLifecycleObserver;
import com.bytedance.push.interfaze.INotificationSwitchReport;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.settings.notification.PollingNotificationReport;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.pushmanager.setting.PushSetting;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationSwitchReportImpl implements INotificationSwitchReport {
    private static final String TAG = "Polling";
    private static int enableType;
    private static PollingNotificationReport pollingNotificationReport;
    private PollRunnable mPollRunnable;
    private boolean mHasPerformedForegroundAction = false;
    private final int ENABLE_POLLING_REPORTING = 1;
    private final int ENABLE_BACK_TO_FORE_REPORTING = 2;
    private WeakReference<Activity> mLastPausedNormalActivity = null;

    @Override // com.bytedance.push.interfaze.INotificationSwitchReport
    public void tryUpdateNoticeStateByPolling(final Context context, final ISupport iSupport) {
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.NotificationSwitchReportImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (NotificationSwitchReportImpl.pollingNotificationReport == null) {
                    PollingNotificationReport unused = NotificationSwitchReportImpl.pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();
                }
                if (NotificationSwitchReportImpl.pollingNotificationReport.enableReportingTiming || NotificationSwitchReportImpl.pollingNotificationReport.enableOriginalReporting) {
                    boolean z = NotificationSwitchReportImpl.pollingNotificationReport.enableBackToForeNotificationReport;
                    boolean z2 = NotificationSwitchReportImpl.pollingNotificationReport.enablePolling;
                    if (z || z2) {
                        int i = (z ? 2 : 0) + (z2 ? 1 : 0);
                        Logger.m268d(NotificationSwitchReportImpl.TAG, "start to register foreground listener");
                        NotificationSwitchReportImpl.this.registerForegroundListener(context, iSupport, i);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerForegroundListener(final Context context, final ISupport iSupport, int i) {
        enableType = i;
        SysDialogActivityLifecycleObserver.getIns().addActivityLifeCycleListener(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.push.NotificationSwitchReportImpl.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Activity activity2 = NotificationSwitchReportImpl.this.mLastPausedNormalActivity != null ? (Activity) NotificationSwitchReportImpl.this.mLastPausedNormalActivity.get() : null;
                if (activity2 == null || activity2 == activity) {
                    NotificationSwitchReportImpl.this.mLastPausedNormalActivity = null;
                    if ((NotificationSwitchReportImpl.enableType == 2 || NotificationSwitchReportImpl.enableType == 3) && !NotificationSwitchReportImpl.this.mHasPerformedForegroundAction) {
                        NotificationSwitchReportImpl.performForegroundAction(context, iSupport);
                        Logger.m268d(NotificationSwitchReportImpl.TAG, "report switch status when app go to foreground");
                    }
                    NotificationSwitchReportImpl.this.mHasPerformedForegroundAction = true;
                    if (NotificationSwitchReportImpl.this.mPollRunnable != null) {
                        NotificationSwitchReportImpl.this.mPollRunnable.cancelPolling(true);
                        NotificationSwitchReportImpl.this.mPollRunnable = null;
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                NotificationSwitchReportImpl.this.mHasPerformedForegroundAction = false;
                NotificationSwitchReportImpl.this.mLastPausedNormalActivity = new WeakReference(activity);
            }
        });
        ActivityLifecycleObserver.getIns().addObserver(new Observer() { // from class: com.bytedance.push.NotificationSwitchReportImpl.3
            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    NotificationSwitchReportImpl.this.mHasPerformedForegroundAction = false;
                    if (NotificationSwitchReportImpl.enableType == 1 || NotificationSwitchReportImpl.enableType == 3) {
                        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.NotificationSwitchReportImpl.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (NotificationSwitchReportImpl.pollingNotificationReport == null) {
                                    PollingNotificationReport unused = NotificationSwitchReportImpl.pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();
                                }
                                if (NotificationSwitchReportImpl.pollingNotificationReport.pollingInterval > 0) {
                                    NotificationSwitchReportImpl.this.initForegroundPolling(context, iSupport, NotificationSwitchReportImpl.pollingNotificationReport.pollingInterval * 1000);
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void performForegroundAction(final Context context, final ISupport iSupport) {
        try {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.NotificationSwitchReportImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    if (NotificationSwitchReportImpl.pollingNotificationReport == null) {
                        PollingNotificationReport unused = NotificationSwitchReportImpl.pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();
                    }
                    if (NotificationSwitchReportImpl.pollingNotificationReport.enableReportingTiming) {
                        ISupport.this.getNotificationService().trySyncNoticeStateOnceWithReportingTiming(context, "performForegroundAction");
                    }
                    if (NotificationSwitchReportImpl.pollingNotificationReport.enableOriginalReporting) {
                        ISupport.this.getNotificationService().trySyncNoticeStateOnce(context);
                    }
                }
            });
        } catch (Exception e) {
            Logger.m272e(TAG, "performForegroundAction：Failed to report the switch status", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initForegroundPolling(Context context, ISupport iSupport, long j) {
        PollRunnable pollRunnable = this.mPollRunnable;
        if (pollRunnable != null) {
            pollRunnable.cancelPolling(true);
            this.mPollRunnable = null;
        }
        this.mPollRunnable = new PollRunnable(iSupport, context, j);
        PushThreadHandlerManager.inst().postRunnable(this.mPollRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class PollRunnable implements Runnable {
        private final Context mContext;
        private boolean mPollCancelled = false;
        private final long mPollInterval;
        private final ISupport mSupport;

        PollRunnable(ISupport iSupport, Context context, long j) {
            this.mSupport = iSupport;
            this.mContext = context;
            this.mPollInterval = j;
        }

        void cancelPolling(boolean z) {
            this.mPollCancelled = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NotificationSwitchReportImpl.pollingNotificationReport == null) {
                PollingNotificationReport unused = NotificationSwitchReportImpl.pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();
            }
            try {
                if (this.mPollCancelled) {
                    Logger.m268d(NotificationSwitchReportImpl.TAG, "Polling is cancelled");
                    return;
                }
                try {
                    Logger.m268d(NotificationSwitchReportImpl.TAG, "polling to report switch status");
                    if (NotificationSwitchReportImpl.pollingNotificationReport.enableOriginalReporting) {
                        this.mSupport.getNotificationService().trySyncNoticeStateOnce(this.mContext);
                    }
                    if (NotificationSwitchReportImpl.pollingNotificationReport.enableReportingTiming) {
                        this.mSupport.getNotificationService().trySyncNoticeStateOnceWithReportingTiming(this.mContext, "pollingAction");
                    }
                    if (this.mPollCancelled) {
                        return;
                    }
                } catch (Exception e) {
                    Logger.m272e(NotificationSwitchReportImpl.TAG, "Polling failed", e);
                    if (this.mPollCancelled) {
                        return;
                    }
                }
                PushThreadHandlerManager.inst().postRunnable(this, this.mPollInterval);
            } catch (Throwable th) {
                if (!this.mPollCancelled) {
                    PushThreadHandlerManager.inst().postRunnable(this, this.mPollInterval);
                }
                throw th;
            }
        }
    }

    @Override // com.bytedance.push.interfaze.INotificationSwitchReport
    public void tryUpdateNoticeStateByAlliance(final Context context) {
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.NotificationSwitchReportImpl.5
            @Override // java.lang.Runnable
            public void run() {
                if (NotificationSwitchReportImpl.pollingNotificationReport == null) {
                    PollingNotificationReport unused = NotificationSwitchReportImpl.pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();
                }
                if (NotificationSwitchReportImpl.pollingNotificationReport.enableAllianceReport) {
                    if (NotificationSwitchReportImpl.pollingNotificationReport.enableOriginalReporting) {
                        PushSupporter.get().getNotificationService().trySyncNoticeStateOnce(context);
                    }
                    if (NotificationSwitchReportImpl.pollingNotificationReport.enableReportingTiming) {
                        PushSupporter.get().getNotificationService().trySyncNoticeStateOnceWithReportingTiming(context, "allianceAction");
                    }
                    Logger.m268d(NotificationSwitchReportImpl.TAG, "try to sync notice state once");
                }
            }
        });
    }
}

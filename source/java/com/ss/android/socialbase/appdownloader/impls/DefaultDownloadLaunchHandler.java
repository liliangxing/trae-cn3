package com.ss.android.socialbase.appdownloader.impls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadLaunchResumeListener;
import com.ss.android.socialbase.appdownloader.notification.AppNotificationItem;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DefaultDownloadLaunchHandler implements IDownloadLaunchHandler {
    private static final String TAG = "LaunchResume";
    private BroadcastReceiver mReceiver;
    private List<Integer> mWaitingWifiTasks;

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public List<String> getResumeMimeTypes() {
        return AppDownloadUtils.getApplicationMimeTypes();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler
    public void onLaunchResume(final List<DownloadInfo> list, final int i) {
        if (DownloadUtils.isMainThread()) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.impls.DefaultDownloadLaunchHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DefaultDownloadLaunchHandler.this.launchResumeInSubThread(list, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            launchResumeInSubThread(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void launchResumeInSubThread(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        IAppDownloadLaunchResumeListener appDownloadLaunchResumeListener = AppDownloader.getInstance().getAppDownloadLaunchResumeListener();
        if (appDownloadLaunchResumeListener != null) {
            appDownloadLaunchResumeListener.onLaunchResume(list);
        }
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        boolean isWifi = DownloadUtils.isWifi(appContext);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            doLaunchResume(appContext, it.next(), isWifi, i);
        }
        if (AppInstallStatsReporter.isEnabled()) {
            AppInstallStatsReporter.report();
        }
        List<Integer> list2 = this.mWaitingWifiTasks;
        if (list2 == null || list2.isEmpty() || this.mReceiver != null) {
            return;
        }
        this.mReceiver = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.impls.DefaultDownloadLaunchHandler.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (DownloadUtils.isWifi(applicationContext)) {
                    if (Logger.debug()) {
                        Logger.globalDebug(DefaultDownloadLaunchHandler.TAG, "onReceive", "Wifi connected");
                    }
                    DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.impls.DefaultDownloadLaunchHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (DefaultDownloadLaunchHandler.this.mWaitingWifiTasks != null && !DefaultDownloadLaunchHandler.this.mWaitingWifiTasks.isEmpty()) {
                                    int size = DefaultDownloadLaunchHandler.this.mWaitingWifiTasks.size();
                                    Integer[] numArr = new Integer[size];
                                    DefaultDownloadLaunchHandler.this.mWaitingWifiTasks.toArray(numArr);
                                    DefaultDownloadLaunchHandler.this.mWaitingWifiTasks.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo != null && (downloadInfo.getRealStatus() == -5 || (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()))) {
                                            DefaultDownloadLaunchHandler.this.doLaunchResume(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    try {
                        m112x505af34c(applicationContext, DefaultDownloadLaunchHandler.this.mReceiver);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    DefaultDownloadLaunchHandler.this.mReceiver = null;
                }
            }

            @Proxy("unregisterReceiver")
            @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
            /* renamed from: INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_impls_DefaultDownloadLaunchHandler$2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
            public static void m112x505af34c(Context context, BroadcastReceiver broadcastReceiver) {
                ReceiverRegisterLancet.loge(broadcastReceiver, false);
                context.unregisterReceiver(broadcastReceiver);
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            m111xa1dcae81(appContext, this.mReceiver, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.mReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0249  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doLaunchResume(Context context, DownloadInfo downloadInfo, boolean z, int i) {
        int i2;
        String str;
        int i3;
        String str2;
        String str3;
        String str4;
        String str5;
        DownloadInfo downloadInfo2;
        String str6;
        String str7;
        String str8;
        String str9;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        int i6;
        DownloadSetting downloadSetting;
        boolean z4;
        DownloadSetting downloadSetting2;
        DownloadInfo downloadInfo3;
        boolean z5;
        int i7;
        IAppDownloadLaunchResumeListener appDownloadLaunchResumeListener;
        int i8;
        boolean z6;
        if (downloadInfo == null || !downloadInfo.isShowNotification()) {
            return;
        }
        int realStatus = downloadInfo.getRealStatus();
        if (realStatus == -5) {
            i2 = realStatus;
            if (Constants.MIME_PATCH.equalsIgnoreCase(downloadInfo.getMimeType()) || !downloadInfo.isDownloaded()) {
                DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
                int optInt = obtain.optInt(DownloadSettingKeys.FAILED_RESUME_MAX_COUNT, 0);
                double optDouble = obtain.optDouble(DownloadSettingKeys.FAILED_RESUME_MAX_HOURS, 72.0d);
                double optDouble2 = obtain.optDouble(DownloadSettingKeys.FAILED_RESUME_MIN_HOURS, 12.0d);
                long currentTimeMillis = System.currentTimeMillis();
                if (downloadInfo.getFailedResumeCount() < optInt) {
                    downloadSetting = obtain;
                    if (currentTimeMillis - downloadInfo.getLastDownloadTime() < optDouble * 3600000.0d && currentTimeMillis - downloadInfo.getLastFailedResumeTime() > 3600000.0d * optDouble2) {
                        z4 = true;
                        if (downloadInfo.isPauseReserveOnWifi() && z) {
                            z4 = true;
                        }
                        if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                            downloadSetting2 = downloadSetting;
                        } else {
                            StringBuilder sb = new StringBuilder("PAUSED_BY_DB_INIT");
                            sb.append(" name:" + downloadInfo.getName());
                            sb.append(" packagename:" + downloadInfo.getPackageName());
                            sb.append(" failedResumeMaxCount:" + optInt);
                            sb.append(" failedResumeMaxHours:" + optDouble);
                            sb.append(" failedResumeMinHours:" + optDouble2);
                            sb.append(" failedResumeCount:" + downloadInfo.getFailedResumeCount());
                            sb.append(" lastDownloadTime:" + downloadInfo.getLastDownloadTime());
                            sb.append(" lastFailedResumeTime:" + downloadInfo.getLastFailedResumeTime());
                            sb.append(" isWifi:" + z);
                            downloadSetting2 = downloadSetting;
                            sb.append(" failedResumeNeedWifi:" + downloadSetting2.optInt(DownloadSettingKeys.FAILED_RESUME_NEED_WIFI, 1));
                            sb.append(" failedResumeNeedWaitWifi:" + downloadSetting2.optInt(DownloadSettingKeys.FAILED_RESUME_NEED_WAIT_WIFI, 0));
                            sb.append(" curBytes:" + downloadInfo.getCurBytes());
                            sb.append(" totalBytes:" + downloadInfo.getTotalBytes());
                            sb.append(" dbInitStatus:" + downloadInfo.getDBInitStatus());
                            sb.append(" canResume:" + z4);
                            sb.append(" pauseReserveOnWifi:" + downloadInfo.isPauseReserveOnWifi());
                            sb.append(" downloaded:" + downloadInfo.isDownloaded());
                            AppInstallStatsReporter.addStats(downloadInfo.getId(), "DefaultDownloadLaunchHandler_doLaunchResume1", sb.toString());
                        }
                        if (z4) {
                            downloadInfo3 = downloadInfo;
                            z5 = false;
                            i7 = 3;
                        } else {
                            if (downloadSetting2.optInt(DownloadSettingKeys.FAILED_RESUME_NEED_WIFI, 1) == 1) {
                                z6 = true;
                                i8 = 0;
                            } else {
                                i8 = 0;
                                z6 = false;
                            }
                            boolean z7 = downloadSetting2.optInt(DownloadSettingKeys.FAILED_RESUME_NEED_WAIT_WIFI, i8) == 1;
                            if (z || !z6 || !z7) {
                                downloadInfo3 = downloadInfo;
                                AppDownloadUtils.createDownloadTask(downloadInfo3, true, z6);
                                downloadInfo3.setLastFailedResumeTime(currentTimeMillis);
                                downloadInfo3.setFailedResumeCount(downloadInfo.getFailedResumeCount() + 1);
                                downloadInfo.updateSpData();
                                if (downloadInfo.isPauseReserveOnWifi() && z) {
                                    downloadInfo3.setDownloadFromReserveWifi(true);
                                    IReserveWifiStatusListener reserveWifiStatusListener = AppDownloader.getInstance().getReserveWifiStatusListener();
                                    if (reserveWifiStatusListener != null) {
                                        reserveWifiStatusListener.onStatusChanged(downloadInfo3, 5, i);
                                    }
                                }
                                z5 = true;
                                i7 = 1;
                            } else {
                                if (this.mWaitingWifiTasks == null) {
                                    this.mWaitingWifiTasks = new ArrayList();
                                }
                                int id = downloadInfo.getId();
                                if (!this.mWaitingWifiTasks.contains(Integer.valueOf(id))) {
                                    this.mWaitingWifiTasks.add(Integer.valueOf(id));
                                }
                                downloadInfo3 = downloadInfo;
                                downloadInfo3.setOnlyWifi(true);
                                RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo3);
                                z5 = false;
                                i7 = 2;
                            }
                        }
                        if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" downloadResumed:" + z5);
                            sb2.append(" state:" + i7);
                            AppInstallStatsReporter.addStats(downloadInfo.getId(), "DefaultDownloadLaunchHandler_doLaunchResume2", sb2.toString());
                        }
                        if (Logger.debugScene(downloadInfo)) {
                            Logger.taskDebug(TAG, downloadInfo3, "doLaunchResume", "LaunchResume name = " + downloadInfo.getTitle() + ", canShowNotification = " + z4 + ", downloadResumed = " + z5);
                        }
                        appDownloadLaunchResumeListener = AppDownloader.getInstance().getAppDownloadLaunchResumeListener();
                        if (appDownloadLaunchResumeListener == null) {
                            appDownloadLaunchResumeListener.onResumeDownload(downloadInfo3, z5);
                            return;
                        }
                        return;
                    }
                } else {
                    downloadSetting = obtain;
                }
                z4 = false;
                if (downloadInfo.isPauseReserveOnWifi()) {
                    z4 = true;
                }
                if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                }
                if (z4) {
                }
                if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                }
                if (Logger.debugScene(downloadInfo)) {
                }
                appDownloadLaunchResumeListener = AppDownloader.getInstance().getAppDownloadLaunchResumeListener();
                if (appDownloadLaunchResumeListener == null) {
                }
            } else {
                i3 = i;
                str8 = " state:";
                str4 = " pauseReserveOnWifi:";
                str5 = " downloaded:";
                str = " isWifi:";
                str2 = "doLaunchResume";
                str3 = ", canShowNotification = ";
                downloadInfo2 = downloadInfo;
                str6 = TAG;
                str7 = " totalBytes:";
            }
        } else {
            i2 = realStatus;
            str = " isWifi:";
            i3 = i;
            str2 = "doLaunchResume";
            str3 = ", canShowNotification = ";
            str4 = " pauseReserveOnWifi:";
            str5 = " downloaded:";
            downloadInfo2 = downloadInfo;
            str6 = TAG;
            str7 = " totalBytes:";
            str8 = " state:";
        }
        int i9 = i2;
        if (i9 == -3) {
            str9 = str;
            if (DownloadUtils.isFileDownloaded(downloadInfo2, false, downloadInfo.getMd5())) {
                DownloadSetting obtain2 = DownloadSetting.obtain(downloadInfo.getId());
                if (AppDownloadUtils.isApkInstalled(context, downloadInfo)) {
                    return;
                }
                int optInt2 = obtain2.optInt(DownloadSettingKeys.UNINSTALL_RESUME_MAX_COUNT, 0);
                String str10 = str6;
                double optDouble3 = obtain2.optDouble(DownloadSettingKeys.UNINSTALL_RESUME_MAX_HOURS, 72.0d);
                String str11 = str4;
                String str12 = str5;
                double optDouble4 = obtain2.optDouble(DownloadSettingKeys.UNINSTALL_RESUME_MIN_HOURS, 12.0d);
                String str13 = str7;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (downloadInfo.getUninstallResumeCount() < optInt2) {
                    i5 = optInt2;
                    if (currentTimeMillis2 - downloadInfo.getLastDownloadTime() < optDouble3 * 3600000.0d && currentTimeMillis2 - downloadInfo.getLastUninstallResumeTime() > 3600000.0d * optDouble4) {
                        z2 = true;
                        if (Logger.debugScene(downloadInfo)) {
                            Logger.taskDebug(str10, downloadInfo2, str2, "UninstallResume, name = " + downloadInfo.getTitle() + str3 + z2);
                        }
                        if (z2) {
                            if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                                StringBuilder sb3 = new StringBuilder("SUCCESS");
                                sb3.append(" name:" + downloadInfo.getName());
                                sb3.append(" packagename:" + downloadInfo.getPackageName());
                                sb3.append(" uninstallResumeCount:" + downloadInfo.getUninstallResumeCount());
                                sb3.append(" lastDownloadTime:" + downloadInfo.getLastDownloadTime());
                                sb3.append(" lastUninstallResumeTime:" + downloadInfo.getLastUninstallResumeTime());
                                sb3.append(" uninstallResumeMaxCount:" + i5);
                                sb3.append(" uninstallResumeMaxHours:" + optDouble3);
                                sb3.append(" uninstallResumeMinHours:" + optDouble4);
                                sb3.append(" curBytes:" + downloadInfo.getCurBytes());
                                sb3.append(str13 + downloadInfo.getTotalBytes());
                                sb3.append(str11 + downloadInfo.isPauseReserveOnWifi());
                                sb3.append(str12 + downloadInfo.isDownloaded());
                                AppInstallStatsReporter.addStats(downloadInfo.getId(), "DefaultDownloadLaunchHandler_doLaunchResume3", sb3.toString());
                            }
                            AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
                            if (notificationItem == null) {
                                z3 = false;
                                i6 = 1;
                                notificationItem = new AppNotificationItem(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                                DownloadNotificationManager.getInstance().addNotification(notificationItem);
                            } else {
                                z3 = false;
                                i6 = 1;
                                notificationItem.updateNotificationItem(downloadInfo2);
                            }
                            notificationItem.setTotalBytes(downloadInfo.getTotalBytes());
                            notificationItem.setCurBytes(downloadInfo.getTotalBytes());
                            notificationItem.refreshStatus(downloadInfo.getStatus(), null, z3, z3);
                            downloadInfo2.setLastUninstallResumeTime(currentTimeMillis2);
                            downloadInfo2.setUninstallResumeCount(downloadInfo.getUninstallResumeCount() + i6);
                            downloadInfo.updateSpData();
                        }
                    }
                } else {
                    i5 = optInt2;
                }
                z2 = false;
                if (Logger.debugScene(downloadInfo)) {
                }
                if (z2) {
                }
            }
        } else {
            str9 = str;
        }
        String str14 = str7;
        String str15 = str4;
        String str16 = str5;
        if (i9 == -2) {
            if (!downloadInfo.isPauseReserveOnWifi()) {
                notifyInPausedResume(downloadInfo2, context);
                i4 = 3;
            } else if (z) {
                AppDownloadUtils.createDownloadTask(downloadInfo2, true, true);
                downloadInfo.updateSpData();
                downloadInfo2.setDownloadFromReserveWifi(true);
                IAppDownloadLaunchResumeListener appDownloadLaunchResumeListener2 = AppDownloader.getInstance().getAppDownloadLaunchResumeListener();
                if (appDownloadLaunchResumeListener2 != null) {
                    appDownloadLaunchResumeListener2.onResumeDownload(downloadInfo2, true);
                }
                IReserveWifiStatusListener reserveWifiStatusListener2 = AppDownloader.getInstance().getReserveWifiStatusListener();
                if (reserveWifiStatusListener2 != null) {
                    reserveWifiStatusListener2.onStatusChanged(downloadInfo2, 5, i3);
                }
                if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                    StringBuilder sb4 = new StringBuilder("PAUSED");
                    sb4.append(" name:" + downloadInfo.getName());
                    sb4.append(" packagename:" + downloadInfo.getPackageName());
                    sb4.append(" uninstallResumeCount:" + downloadInfo.getUninstallResumeCount());
                    sb4.append(" lastDownloadTime:" + downloadInfo.getLastDownloadTime());
                    sb4.append(" lastUninstallResumeTime:" + downloadInfo.getLastUninstallResumeTime());
                    sb4.append(" curBytes:" + downloadInfo.getCurBytes());
                    sb4.append(str14 + downloadInfo.getTotalBytes());
                    sb4.append(str15 + downloadInfo.isPauseReserveOnWifi());
                    sb4.append(str16 + downloadInfo.isDownloaded());
                    sb4.append(str9 + z);
                    AppInstallStatsReporter.addStats(downloadInfo.getId(), "DefaultDownloadLaunchHandler_doLaunchResume4", sb4.toString());
                }
                i4 = 1;
            } else {
                if (this.mWaitingWifiTasks == null) {
                    this.mWaitingWifiTasks = new ArrayList();
                }
                int id2 = downloadInfo.getId();
                if (!this.mWaitingWifiTasks.contains(Integer.valueOf(id2))) {
                    this.mWaitingWifiTasks.add(Integer.valueOf(id2));
                }
                RetryScheduler.getInstance().tryStartScheduleRetry(downloadInfo2);
                notifyInPausedResume(downloadInfo2, context);
                i4 = 2;
            }
            if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str8 + i4);
                AppInstallStatsReporter.addStats(downloadInfo.getId(), "DefaultDownloadLaunchHandler_doLaunchResume5", sb5.toString());
            }
        }
    }

    private void notifyInPausedResume(DownloadInfo downloadInfo, Context context) {
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
        int optInt = obtain.optInt(DownloadSettingKeys.PAUSED_RESUME_MAX_COUNT, 0);
        double optDouble = obtain.optDouble(DownloadSettingKeys.PAUSED_RESUME_MAX_HOURS, 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        boolean z = pausedResumeCount < optInt && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < 3600000.0d * optDouble;
        if (AppInstallStatsReporter.isEnabled(downloadInfo.getMonitorScene())) {
            StringBuilder sb = new StringBuilder("PAUSED");
            sb.append(" name:" + downloadInfo.getName());
            sb.append(" packagename:" + downloadInfo.getPackageName());
            sb.append(" uninstallResumeCount:" + downloadInfo.getUninstallResumeCount());
            sb.append(" lastDownloadTime:" + downloadInfo.getLastDownloadTime());
            sb.append(" lastUninstallResumeTime:" + downloadInfo.getLastUninstallResumeTime());
            sb.append(" curBytes:" + downloadInfo.getCurBytes());
            sb.append(" totalBytes:" + downloadInfo.getTotalBytes());
            sb.append(" pauseReserveOnWifi:" + downloadInfo.isPauseReserveOnWifi());
            sb.append(" downloaded:" + downloadInfo.isDownloaded());
            sb.append(" pausedResumeMaxCount:" + optInt);
            sb.append(" pausedResumeMaxHours:" + optDouble);
            sb.append(" pausedResumeCount:" + pausedResumeCount);
            sb.append(" lastDownloadTime:" + downloadInfo.getLastDownloadTime());
            sb.append(" canResume:" + z);
            AppInstallStatsReporter.addStats(downloadInfo.getId(), "DefaultDownloadLaunchHandler_notifyInPausedResume", sb.toString());
        }
        if (z) {
            AbsNotificationItem notificationItem = DownloadNotificationManager.getInstance().getNotificationItem(downloadInfo.getId());
            if (notificationItem == null) {
                notificationItem = new AppNotificationItem(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                DownloadNotificationManager.getInstance().addNotification(notificationItem);
            } else {
                notificationItem.updateNotificationItem(downloadInfo);
            }
            notificationItem.setTotalBytes(downloadInfo.getTotalBytes());
            notificationItem.setCurBytes(downloadInfo.getCurBytes());
            notificationItem.refreshStatus(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_android_socialbase_appdownloader_impls_DefaultDownloadLaunchHandler_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m111xa1dcae81(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}

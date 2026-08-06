package com.ss.android.socialbase.appdownloader;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RetryJobSchedulerServiceImpl {
    private static final String TAG = "RetryJobSchedulerServiceImpl";

    public static boolean onStartJob(JobParameters jobParameters) {
        if (jobParameters == null) {
            return false;
        }
        int jobId = jobParameters.getJobId();
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "onStartJob", "Id: " + jobId);
        }
        RetryScheduler.getInstance().doSchedulerRetry(jobId);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008c A[Catch: all -> 0x00ce, TryCatch #1 {all -> 0x00ce, blocks: (B:15:0x0030, B:24:0x004f, B:25:0x005b, B:28:0x007b, B:30:0x008c, B:31:0x008f, B:33:0x0099, B:35:0x009f, B:37:0x00ad, B:39:0x00b2, B:41:0x00b8, B:50:0x0045, B:19:0x003c), top: B:14:0x0030, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void tryStartScheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i) {
        Context appContext;
        long j2;
        long j3;
        int schedule;
        IReserveWifiStatusListener reserveWifiStatusListener;
        IReserveWifiStatusListener reserveWifiStatusListener2;
        if (downloadInfo == null || j <= 0 || (appContext = DownloadComponentManager.getAppContext()) == null) {
            return;
        }
        int i2 = 2;
        if (downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener2 = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
            reserveWifiStatusListener2.onStatusChanged(downloadInfo, 2, 3);
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) appContext.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            try {
                jobScheduler.cancel(downloadInfo.getId());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (i != 0 && (!z || i == 2)) {
                j3 = j + 60000;
                j2 = j;
                JobInfo.Builder minimumLatency = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(appContext.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j2);
                if (z) {
                    i2 = 1;
                }
                JobInfo.Builder requiresDeviceIdle = minimumLatency.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
                if (j3 > 0) {
                    requiresDeviceIdle.setOverrideDeadline(j3);
                }
                schedule = jobScheduler.schedule(requiresDeviceIdle.build());
                if (schedule > 0 && downloadInfo.isPauseReserveOnWifi() && (reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.onStatusChanged(downloadInfo, 3, 3);
                }
                if (schedule <= 0 || !Logger.debug()) {
                }
                Logger.globalDebug(TAG, "tryStartScheduleRetry", "ErrCode: " + schedule);
                return;
            }
            j2 = 1000;
            j3 = 0;
            JobInfo.Builder minimumLatency2 = new JobInfo.Builder(downloadInfo.getId(), new ComponentName(appContext.getPackageName(), RetryJobSchedulerService.class.getName())).setMinimumLatency(j2);
            if (z) {
            }
            JobInfo.Builder requiresDeviceIdle2 = minimumLatency2.setRequiredNetworkType(i2).setRequiresCharging(false).setRequiresDeviceIdle(false);
            if (j3 > 0) {
            }
            schedule = jobScheduler.schedule(requiresDeviceIdle2.build());
            if (schedule > 0) {
                reserveWifiStatusListener.onStatusChanged(downloadInfo, 3, 3);
            }
            if (schedule <= 0) {
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void tryCancelScheduleRetry(int i) {
        Context appContext = DownloadComponentManager.getAppContext();
        if (appContext == null) {
            return;
        }
        try {
            JobScheduler jobScheduler = (JobScheduler) appContext.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                return;
            }
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

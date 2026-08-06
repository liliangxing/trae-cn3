package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadLaunchHandler;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RetrySchedulerImpl implements Handler.Callback, AppStatusManager.AppStatusChangeListener {
    private static final int MIN_INTERVAL_MS = 3000;
    private static final int MIN_INTERVAL_MS_ACCELERATION = 5000;
    public static final int RETRY_SCHEDULE_NORMAL = 1;
    public static final int RETRY_SCHEDULE_WHEN_APP_BACKGROUND = 3;
    public static final int RETRY_SCHEDULE_WHEN_APP_FOREGROUND = 4;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_CONNECTED = 5;
    public static final int RETRY_SCHEDULE_WHEN_OTHER_SUCCEED = 2;
    private static final int SCHEDULE_ALL_TASK_RETRY_DELAY = 2000;
    private static final int SCHEDULE_ALL_TASK_RETRY_MIN_INTERVAL = 10000;
    private static final String TAG = "RetryScheduler";
    private static volatile RetrySchedulerImpl sInstance;
    private static RetryScheduler.RetryScheduleHandler sRetryScheduleHandler;
    private ConnectivityManager mConnectivityManager;
    private final boolean mIsDownloaderProcess;
    private long mLastHandleAllTaskTime;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<RetryInfo> mRetryInfoList = new SparseArray<>();
    private int mWaitingRetryTasksCount = 0;
    private final Context mContext = DownloadComponentManager.getAppContext();

    private RetrySchedulerImpl() {
        registerNetworkCallback();
        this.mIsDownloaderProcess = DownloadHelper.isDownloaderProcess();
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static RetrySchedulerImpl getInstance() {
        if (sInstance == null) {
            synchronized (RetrySchedulerImpl.class) {
                if (sInstance == null) {
                    sInstance = new RetrySchedulerImpl();
                }
            }
        }
        return sInstance;
    }

    public static void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler retryScheduleHandler) {
        sRetryScheduleHandler = retryScheduleHandler;
    }

    private void registerNetworkCallback() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.USE_NETWORK_CALLBACK, 0) != 1) {
            return;
        }
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetrySchedulerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (RetrySchedulerImpl.this.mContext != null) {
                        RetrySchedulerImpl retrySchedulerImpl = RetrySchedulerImpl.this;
                        retrySchedulerImpl.mConnectivityManager = (ConnectivityManager) retrySchedulerImpl.mContext.getApplicationContext().getSystemService("connectivity");
                        RetrySchedulerImpl.this.mConnectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.RetrySchedulerImpl.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                if (Logger.debug()) {
                                    Logger.globalDebug(RetrySchedulerImpl.TAG, "onAvailable", "network onAvailable");
                                }
                                RetrySchedulerImpl.this.scheduleAllTaskRetry(1, true);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void tryStartScheduleRetry(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(DownloadConstants.MIME_APK) || !DownloadConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
            return;
        }
        tryStartScheduleRetry(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), getNetWorkType());
    }

    private void tryStartScheduleRetry(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        RetryInfo obtainRetryInfo = obtainRetryInfo(downloadInfo.getId());
        if (obtainRetryInfo.mRetryCount.get() > obtainRetryInfo.maxCount) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "tryStartScheduleRetry", "Id = " + obtainRetryInfo.f73id + ", mRetryCount = " + obtainRetryInfo.mRetryCount + ", maxCount = " + obtainRetryInfo.maxCount);
                return;
            }
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!DownloadUtils.isInsufficientSpaceError(failedException) && !DownloadUtils.isNetworkError(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!canRetryForAllowErrorCode(obtainRetryInfo, errorCode)) {
                return;
            }
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "tryStartScheduleRetry", "Allow error code, id = " + obtainRetryInfo.f73id + ", error code = " + errorCode);
            }
        }
        obtainRetryInfo.mNeedWifi = z;
        synchronized (this.mRetryInfoList) {
            if (!obtainRetryInfo.mIsWaitingRetry) {
                obtainRetryInfo.mIsWaitingRetry = true;
                this.mWaitingRetryTasksCount++;
            }
        }
        int currentRetryIntervalMs = obtainRetryInfo.getCurrentRetryIntervalMs();
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "tryStartScheduleRetry", "Id = " + obtainRetryInfo.f73id + ", delayTimeMills = " + currentRetryIntervalMs + ", mWaitingRetryTasks = " + this.mWaitingRetryTasksCount);
        }
        if (!obtainRetryInfo.useJobScheduler) {
            if (z) {
                return;
            }
            this.mHandler.removeMessages(downloadInfo.getId());
            this.mHandler.sendEmptyMessageDelayed(downloadInfo.getId(), currentRetryIntervalMs);
            return;
        }
        if (i == 0) {
            obtainRetryInfo.resetRetryInterval();
        }
        RetryScheduler.RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
        if (retryScheduleHandler != null) {
            retryScheduleHandler.scheduleRetry(downloadInfo, currentRetryIntervalMs, z, i);
        }
        if (this.mIsDownloaderProcess) {
            obtainRetryInfo.updateRetryTimeStamp(System.currentTimeMillis());
            obtainRetryInfo.increaseRetryCount();
            obtainRetryInfo.increaseRetryInterval();
        }
    }

    public void tryCancelScheduleRetry(int i) {
        synchronized (this.mRetryInfoList) {
            RetryInfo retryInfo = this.mRetryInfoList.get(i);
            if (retryInfo == null) {
                return;
            }
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i2 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i2;
                if (i2 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            if (retryInfo.useJobScheduler) {
                RetryScheduler.RetryScheduleHandler retryScheduleHandler = sRetryScheduleHandler;
                if (retryScheduleHandler != null) {
                    retryScheduleHandler.cancelRetry(i);
                    return;
                }
                return;
            }
            this.mHandler.removeMessages(i);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            doScheduleAllTaskRetry(message.arg1, message.arg2 == 1);
        } else {
            if (Logger.debug()) {
                Logger.taskDebug(TAG, message.what, "handleMessage", "DoSchedulerRetry");
            }
            doSchedulerRetry(message.what);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleAllTaskRetry(int i, boolean z) {
        if (this.mWaitingRetryTasksCount <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                if (currentTimeMillis - this.mLastHandleAllTaskTime < 10000) {
                    return;
                }
            }
            this.mLastHandleAllTaskTime = currentTimeMillis;
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "scheduleAllTaskRetry", "level = [" + i + "], force = [" + z + "]");
            }
            if (z) {
                this.mHandler.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i;
            obtain.arg2 = z ? 1 : 0;
            this.mHandler.sendMessageDelayed(obtain, 2000L);
        }
    }

    private void doScheduleAllTaskRetry(final int i, final boolean z) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetrySchedulerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int netWorkType;
                try {
                    if (RetrySchedulerImpl.this.mWaitingRetryTasksCount > 0 && (netWorkType = RetrySchedulerImpl.this.getNetWorkType()) != 0) {
                        if (Logger.debug()) {
                            Logger.globalDebug(RetrySchedulerImpl.TAG, "doScheduleAllTaskRetry", "WaitingRetryTasksCount = " + RetrySchedulerImpl.this.mWaitingRetryTasksCount);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (RetrySchedulerImpl.this.mRetryInfoList) {
                            for (int i2 = 0; i2 < RetrySchedulerImpl.this.mRetryInfoList.size(); i2++) {
                                RetryInfo retryInfo = (RetryInfo) RetrySchedulerImpl.this.mRetryInfoList.valueAt(i2);
                                if (retryInfo != null && retryInfo.canRetry(currentTimeMillis, i, netWorkType, z)) {
                                    if (z) {
                                        retryInfo.resetRetryInterval();
                                    }
                                    arrayList.add(retryInfo);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                RetrySchedulerImpl.this.doSchedulerRetryInSubThread(((RetryInfo) it.next()).f73id, netWorkType, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void doSchedulerRetry(final int i) {
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.RetrySchedulerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    RetrySchedulerImpl retrySchedulerImpl = RetrySchedulerImpl.this;
                    retrySchedulerImpl.doSchedulerRetryInSubThread(i, retrySchedulerImpl.getNetWorkType(), true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSchedulerRetryInSubThread(int i, int i2, boolean z) {
        IReserveWifiStatusListener reserveWifiStatusListener;
        boolean z2;
        Context context = this.mContext;
        if (context == null) {
            return;
        }
        synchronized (this.mRetryInfoList) {
            RetryInfo retryInfo = this.mRetryInfoList.get(i);
            if (retryInfo == null) {
                return;
            }
            boolean z3 = true;
            if (retryInfo.mIsWaitingRetry) {
                retryInfo.mIsWaitingRetry = false;
                int i3 = this.mWaitingRetryTasksCount - 1;
                this.mWaitingRetryTasksCount = i3;
                if (i3 < 0) {
                    this.mWaitingRetryTasksCount = 0;
                }
            }
            if (Logger.debug()) {
                Logger.taskDebug(TAG, i, "doSchedulerRetryInSubThread", "RetryCount = " + retryInfo.mRetryCount + ", mWaitingRetryTasksCount = " + this.mWaitingRetryTasksCount);
            }
            DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            if (downloadInfo == null) {
                removeRetryInfo(i);
                return;
            }
            int realStatus = downloadInfo.getRealStatus();
            if (realStatus == -3 || realStatus == -4) {
                removeRetryInfo(i);
                return;
            }
            if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener()) != null) {
                    reserveWifiStatusListener.onStatusChanged(downloadInfo, 4, 3);
                }
                IDownloadLaunchHandler downloadLaunchHandler = DownloadComponentManager.getDownloadLaunchHandler();
                if (downloadLaunchHandler != null) {
                    downloadLaunchHandler.onLaunchResume(Collections.singletonList(downloadInfo), 3);
                }
                removeRetryInfo(i);
                return;
            }
            if (realStatus != -1) {
                return;
            }
            if (i2 != 0) {
                z2 = true;
            } else if (!retryInfo.useJobScheduler) {
                return;
            } else {
                z2 = false;
            }
            BaseException failedException = downloadInfo.getFailedException();
            if (z2 && DownloadUtils.isInsufficientSpaceError(failedException)) {
                z2 = canRetryWhenInsufficientSpace(downloadInfo, failedException);
            }
            retryInfo.increaseRetryCount();
            if (z2) {
                if (Logger.debug()) {
                    Logger.taskDebug(TAG, i, "doSchedulerRetryInSubThread", "doSchedulerRetry: restart task, ****** id = " + retryInfo.f73id);
                }
                retryInfo.updateRetryTimeStamp(System.currentTimeMillis());
                if (z) {
                    retryInfo.increaseRetryInterval();
                }
                downloadInfo.setRetryScheduleCount(retryInfo.mRetryCount.get());
                if (downloadInfo.getStatus() == -1) {
                    Downloader.getInstance(context).restart(downloadInfo.getId());
                    return;
                }
                return;
            }
            if (z) {
                retryInfo.increaseRetryInterval();
            }
            if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                z3 = false;
            }
            tryStartScheduleRetry(downloadInfo, z3, i2);
        }
    }

    private boolean canRetryForAllowErrorCode(RetryInfo retryInfo, int i) {
        int[] iArr = retryInfo.allowErrorCode;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private RetryInfo obtainRetryInfo(int i) {
        RetryInfo retryInfo = this.mRetryInfoList.get(i);
        if (retryInfo == null) {
            synchronized (this.mRetryInfoList) {
                retryInfo = this.mRetryInfoList.get(i);
                if (retryInfo == null) {
                    retryInfo = createRetryInfo(i);
                }
                this.mRetryInfoList.put(i, retryInfo);
            }
        }
        return retryInfo;
    }

    private void removeRetryInfo(int i) {
        synchronized (this.mRetryInfoList) {
            this.mRetryInfoList.remove(i);
        }
    }

    private RetryInfo createRetryInfo(int i) {
        int[] iArr;
        int i2;
        int i3;
        boolean z;
        DownloadSetting obtain = DownloadSetting.obtain(i);
        boolean z2 = false;
        int optInt = obtain.optInt(DownloadSettingKeys.RETRY_SCHEDULE, 0);
        JSONObject optJSONObject = obtain.optJSONObject(DownloadSettingKeys.RETRY_SCHEDULE_CONFIG);
        int i4 = 60;
        if (optJSONObject != null) {
            int optInt2 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.MAX_COUNT, 60);
            int optInt3 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC, 60);
            int optInt4 = optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.INTERVAL_SEC_ACCELERATION, 60);
            if (sRetryScheduleHandler != null && optJSONObject.optInt(DownloadSettingKeys.RetryScheduleConfig.USE_JOB_SCHEDULER, 0) == 1) {
                z2 = true;
            }
            iArr = parserAllowErrorCode(optJSONObject.optString(DownloadSettingKeys.RetryScheduleConfig.ALLOW_ERROR_CODE));
            i2 = optInt4;
            z = z2;
            i3 = optInt2;
            i4 = optInt3;
        } else {
            iArr = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new RetryInfo(i, optInt, i3, i4 * 1000, i2 * 1000, z, iArr);
    }

    private int[] parserAllowErrorCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = Integer.parseInt(split[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        scheduleAllTaskRetry(4, false);
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
        scheduleAllTaskRetry(3, false);
    }

    public void scheduleRetryWhenHasTaskSucceed() {
        scheduleAllTaskRetry(2, true);
    }

    public void scheduleRetryWhenHasTaskConnected() {
        scheduleAllTaskRetry(5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNetWorkType() {
        try {
            if (this.mConnectivityManager == null) {
                this.mConnectivityManager = (ConnectivityManager) this.mContext.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.mConnectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private boolean canRetryWhenInsufficientSpace(DownloadInfo downloadInfo, BaseException baseException) {
        long j;
        long totalBytes;
        try {
            j = DownloadUtils.getAvailableSpaceBytes(downloadInfo.getTempPath());
        } catch (BaseException e) {
            e.printStackTrace();
            j = 0;
        }
        if (baseException instanceof DownloadOutOfSpaceException) {
            totalBytes = ((DownloadOutOfSpaceException) baseException).getRequiredSpaceBytes();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (j < totalBytes) {
            DownloadSetting obtain = DownloadSetting.obtain(downloadInfo.getId());
            if (obtain.optInt(DownloadSettingKeys.SPACE_FILL_PART_DOWNLOAD, 0) == 1) {
                if (j > 0) {
                    int optInt = obtain.optInt(DownloadSettingKeys.SPACE_FILL_MIN_KEEP_MB, 100);
                    if (optInt > 0) {
                        long j2 = j - (optInt * 1048576);
                        if (Logger.debugScene(downloadInfo)) {
                            Logger.taskDebug(TAG, downloadInfo, "canRetryWhenInsufficientSpace", "Retry schedule: available = " + (j > 0) + ", minKeep = " + optInt + "MB, canDownload = " + (j2 > 0));
                        }
                        if (j2 <= 0) {
                            if (Logger.debugScene(downloadInfo)) {
                                Logger.taskDebug(TAG, downloadInfo, "canRetryWhenInsufficientSpace", "CanDownload <= 0 , canRetry = false");
                            }
                            return false;
                        }
                    }
                } else if (obtain.optInt(DownloadSettingKeys.DOWNLOAD_WHEN_SPACE_NEGATIVE, 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class RetryInfo {
        final int[] allowErrorCode;

        /* renamed from: id */
        final int f73id;
        final int intervalMs;
        final int intervalMsAcceleration;
        final int level;
        private AtomicInteger mCurrentIntervalMs;
        private boolean mIsWaitingRetry;
        private AtomicLong mLastRetryTime;
        private boolean mNeedWifi;
        private AtomicInteger mRetryCount;
        final int maxCount;
        final boolean useJobScheduler;

        RetryInfo(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.f73id = i;
            this.level = i2;
            this.maxCount = i3;
            this.intervalMs = i4;
            this.intervalMsAcceleration = i5;
            this.useJobScheduler = z;
            this.allowErrorCode = iArr;
            this.mCurrentIntervalMs = new AtomicInteger(i4);
            this.mLastRetryTime = new AtomicLong(0L);
            this.mRetryCount = new AtomicInteger(0);
        }

        boolean canRetry(long j, int i, int i2, boolean z) {
            if (!this.mIsWaitingRetry) {
                if (Logger.debug()) {
                    Logger.taskDebug(RetrySchedulerImpl.TAG, this.f73id, "canRetry", "IsWaitingRetry is false, return false");
                }
                return false;
            }
            if (this.level < i || this.mRetryCount.get() >= this.maxCount) {
                return false;
            }
            if (!this.mNeedWifi || i2 == 2) {
                return z || j - this.mLastRetryTime.get() >= ((long) this.intervalMs);
            }
            return false;
        }

        void increaseRetryInterval() {
            this.mCurrentIntervalMs.addAndGet(this.intervalMsAcceleration);
        }

        void updateRetryTimeStamp(long j) {
            this.mLastRetryTime.set(j);
        }

        void increaseRetryCount() {
            this.mRetryCount.incrementAndGet();
        }

        void resetRetryInterval() {
            this.mCurrentIntervalMs.set(this.intervalMs);
        }

        int getCurrentRetryIntervalMs() {
            return this.mCurrentIntervalMs.get();
        }
    }
}

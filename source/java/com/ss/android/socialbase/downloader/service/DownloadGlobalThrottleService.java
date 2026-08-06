package com.ss.android.socialbase.downloader.service;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadGlobalThrottleService implements IDownloadGlobalThrottleService {
    private final String TAG = "globalThrottle";
    private final int NO_TASK_THROTTLE_VALUE_DEFAULT = 2097152;
    private final int SPEED_THRESHOLD_MIN = 512000;
    private final int TASK_SPEED_THRESHOLD_MIN = 51200;
    private final int STOP_THROTTLE = 0;
    private final int DYNAMIC_AND_FIXED_THROTTLE = -1;
    private final int ONLY_DYNAMIC_THROTTLE = -2;
    private final double THROTTLE_FACTOR_LOW = 0.5d;
    private final int DOWNLOADER_VALID_TIME = 2000;
    private final int VALID_NET_BANDWIDTH_MIN = 204800;
    private final SparseArray<DownloadTask> mAllTask = new SparseArray<>();
    private volatile int mThrottleSpeed = 0;
    private volatile int mPriority = 0;

    private void deleteTaskAndThrottleSpeedReset(DownloadTask downloadTask) {
        synchronized (this.mAllTask) {
            this.mAllTask.remove(downloadTask.getDownloadId());
            if (Logger.debugScene(downloadTask.getDownloadInfo())) {
                Logger.taskDebug("globalThrottle", downloadTask.getDownloadInfo(), "deleteTaskAndThrottleSpeedReset", "taskCount=" + this.mAllTask.size() + ",mThrottleSpeed=" + this.mThrottleSpeed);
            }
            if (this.mThrottleSpeed == 0) {
                return;
            }
            throttleSpeedReset();
        }
    }

    private void stopThrottle() {
        if (Logger.debug()) {
            Logger.globalDebug("globalThrottle", "stopThrottle", "stop throttle!");
        }
        for (int i = 0; i < this.mAllTask.size(); i++) {
            DownloadTask valueAt = this.mAllTask.valueAt(i);
            valueAt.getDownloadInfo().setThrottleNetSpeed(0L);
            if (Logger.debug()) {
                Logger.globalDebug("globalThrottle", "stopThrottle", "TTNet api set speed=0");
            }
            Downloader.getInstance(DownloadComponentManager.getAppContext()).setThrottleNetSpeed(valueAt.getDownloadId(), 0L);
        }
    }

    private int getThrottleTaskSize() {
        if (this.mAllTask.size() == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.mAllTask.size(); i2++) {
            if (this.mAllTask.valueAt(i2).getTaskPriority() <= this.mPriority) {
                i++;
            }
        }
        if (Logger.debug()) {
            Logger.globalDebug("globalThrottle", "getThrottleTaskSize", "throttle task size=" + i);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005d, code lost:
    
        if (r1 < 51200) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void throttleSpeedReset() {
        int i;
        int i2;
        int throttleTaskSize = getThrottleTaskSize();
        if (this.mThrottleSpeed > 0 && throttleTaskSize > 0) {
            i = this.mThrottleSpeed / throttleTaskSize;
        } else {
            i = this.mThrottleSpeed == 0 ? 0 : 2097152;
        }
        if (Logger.debug()) {
            Logger.globalDebug("globalThrottle", "throttleSpeedReset", "mThrottleSpeed=" + this.mThrottleSpeed + ",taskCount=" + throttleTaskSize);
        }
        for (int i3 = 0; i3 < this.mAllTask.size(); i3++) {
            DownloadTask valueAt = this.mAllTask.valueAt(i3);
            if (valueAt.getTaskPriority() <= this.mPriority) {
                if (i != 0) {
                    i2 = 51200;
                }
                i2 = i;
                if (Logger.debug()) {
                    Logger.globalDebug("globalThrottle", "throttleSpeedReset", "TTNet api set speed=" + i2);
                }
                long j = i2;
                valueAt.getDownloadInfo().setThrottleNetSpeed(j);
                Downloader.getInstance(DownloadComponentManager.getAppContext()).setThrottleNetSpeed(valueAt.getDownloadId(), j);
            }
        }
    }

    private void addTaskAndThrottleSpeedReset(DownloadTask downloadTask) {
        if (Logger.debugScene(downloadTask.getDownloadInfo())) {
            Logger.taskDebug("globalThrottle", downloadTask.getDownloadInfo(), "addTaskAndThrottleSpeedReset", "add to map!");
        }
        if (downloadTask.getTaskPriority() > this.mPriority) {
            return;
        }
        synchronized (this.mAllTask) {
            this.mAllTask.put(downloadTask.getDownloadId(), downloadTask);
            if (this.mThrottleSpeed <= 0) {
                return;
            }
            throttleSpeedReset();
        }
    }

    private int getBandwidth() {
        int max = Math.max(DownloadHelper.convertToBytes(NetTrafficManager.getInstance().getRealTimeSpeed()), DownloadHelper.convertToBytes(NetTrafficManager.getInstance().getDownloadKBitsPerSecond()));
        if (max < 0) {
            return 0;
        }
        return max;
    }

    private int getGlobalThrottleSpeed() {
        int throttleTaskSize;
        synchronized (this.mAllTask) {
            throttleTaskSize = getThrottleTaskSize();
        }
        int bandwidth = getBandwidth();
        if (Logger.debug()) {
            Logger.globalDebug("globalThrottle", "getGlobalThrottleSpeed", "bandwidth=" + bandwidth + ",taskRunningTime=" + NetTrafficManager.getInstance().getTaskRunningTime() + ",taskCount=" + throttleTaskSize);
        }
        double d = (throttleTaskSize <= 0 || (NetTrafficManager.getInstance().getTaskRunningTime() < 2000 && bandwidth < 204800)) ? 2097152.0d : bandwidth * 0.5d;
        if (d < 512000.0d) {
            d = 512000.0d;
        }
        if (Logger.debug()) {
            Logger.globalDebug("globalThrottle", "getGlobalThrottleSpeed", "throttleSpeed=" + d);
        }
        return (int) d;
    }

    private void dynamicThrottle() {
        for (int i = 0; i < this.mAllTask.size(); i++) {
            DownloadTask valueAt = this.mAllTask.valueAt(i);
            if (valueAt.getTaskPriority() <= this.mPriority) {
                long j = -1;
                valueAt.getDownloadInfo().setThrottleNetSpeed(j);
                Downloader.getInstance(DownloadComponentManager.getAppContext()).setThrottleNetSpeed(valueAt.getDownloadId(), j);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public void start(final DownloadTask downloadTask) {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_GLOBAL_THROTTLE_ENABLE, 0) <= 0) {
            return;
        }
        if (Logger.debugScene(downloadTask.getDownloadInfo())) {
            Logger.taskDebug("globalThrottle", downloadTask.getDownloadInfo(), "start", "start throttle!");
        }
        if (DownloadUtils.isMainThread()) {
            DownloadComponentManager.getGlobalThrottleThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.service.DownloadGlobalThrottleService.1
                @Override // java.lang.Runnable
                public void run() {
                    DownloadGlobalThrottleService.this.startInternal(downloadTask);
                }
            });
        } else {
            startInternal(downloadTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal(DownloadTask downloadTask) {
        addTaskAndThrottleSpeedReset(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public void end(final DownloadTask downloadTask) {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_GLOBAL_THROTTLE_ENABLE, 0) <= 0) {
            return;
        }
        DownloadComponentManager.getGlobalThrottleThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.service.DownloadGlobalThrottleService.2
            @Override // java.lang.Runnable
            public void run() {
                DownloadGlobalThrottleService.this.endInternal(downloadTask);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endInternal(DownloadTask downloadTask) {
        if (Logger.debugScene(downloadTask.getDownloadInfo())) {
            Logger.taskDebug("globalThrottle", downloadTask.getDownloadInfo(), "endInternal", "task end!");
        }
        deleteTaskAndThrottleSpeedReset(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public void setGlobalThrottle(final int i, final int i2) {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_GLOBAL_THROTTLE_ENABLE, 0) <= 0) {
            return;
        }
        if (DownloadUtils.isMainThread()) {
            DownloadComponentManager.getGlobalThrottleThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.service.DownloadGlobalThrottleService.3
                @Override // java.lang.Runnable
                public void run() {
                    DownloadGlobalThrottleService.this.setGlobalThrottleInternal(i, i2);
                }
            });
        } else {
            setGlobalThrottleInternal(i, i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
    public void setGlobalThrottleTaskPriority(final int i, final int i2) {
        if (DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_IS_GLOBAL_THROTTLE_ENABLE, 0) <= 0) {
            return;
        }
        DownloadComponentManager.getGlobalThrottleThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.service.DownloadGlobalThrottleService.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DownloadGlobalThrottleService.this.mAllTask) {
                    DownloadTask downloadTask = (DownloadTask) DownloadGlobalThrottleService.this.mAllTask.get(i);
                    if (downloadTask == null) {
                        return;
                    }
                    int taskPriority = downloadTask.getTaskPriority();
                    downloadTask.setTaskPriority(i2);
                    if (DownloadGlobalThrottleService.this.mThrottleSpeed > 0) {
                        if (taskPriority > DownloadGlobalThrottleService.this.mPriority || i2 <= DownloadGlobalThrottleService.this.mPriority) {
                            if (taskPriority > DownloadGlobalThrottleService.this.mPriority && i2 <= DownloadGlobalThrottleService.this.mPriority) {
                                if (Logger.debug()) {
                                    Logger.globalDebug("globalThrottle", "setGlobalThrottleTaskPriority", "oldPriority=" + taskPriority + ",priority=" + i2 + ",downloadId=" + i + ",start throttle!");
                                }
                                DownloadGlobalThrottleService.this.throttleSpeedReset();
                            }
                        } else {
                            if (Logger.debug()) {
                                Logger.globalDebug("globalThrottle", "setGlobalThrottleTaskPriority", "oldPriority=" + taskPriority + ",priority=" + i2 + ",stop throttle!");
                            }
                            downloadTask.getDownloadInfo().setThrottleNetSpeed(0L);
                            Downloader.getInstance(DownloadComponentManager.getAppContext()).setThrottleNetSpeed(downloadTask.getDownloadId(), 0L);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGlobalThrottleInternal(int i, int i2) {
        if (Logger.debug()) {
            Logger.globalDebug("globalThrottle", "setGlobalThrottleInternal", "global throttle speed=" + i + ",priority=" + i2);
        }
        this.mThrottleSpeed = i;
        if (i == -1) {
            this.mThrottleSpeed = getGlobalThrottleSpeed();
        }
        this.mPriority = i2;
        synchronized (this.mAllTask) {
            if (i > 0 || i == -1) {
                throttleSpeedReset();
            } else if (i == -2) {
                dynamicThrottle();
            } else {
                this.mThrottleSpeed = 0;
                stopThrottle();
            }
        }
    }
}

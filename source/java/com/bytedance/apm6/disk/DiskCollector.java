package com.bytedance.apm6.disk;

import android.content.SharedPreferences;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm6.disk.config.DiskConfig;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DiskCollector {
    private static final String KEY_DISK_CHECK_TIME = "check_disk_last_time";
    private static final String KEY_SP = "monitor_config";
    private static DiskCollector instance = new DiskCollector();
    private AsyncTask asyncTask;
    private DiskConfig config;
    private volatile boolean isAlreadyCollected;
    private volatile boolean isInited;

    public static DiskCollector getInstance() {
        return instance;
    }

    public void init() {
        if (this.isInited) {
            return;
        }
        this.isInited = true;
        DiskConfigService diskConfigService = (DiskConfigService) ServiceManager.getService(DiskConfigService.class);
        if (diskConfigService != null) {
            updateConfig(diskConfigService.getConfig());
        }
    }

    public synchronized void updateConfig(DiskConfig diskConfig) {
        if (diskConfig == null) {
            return;
        }
        this.config = diskConfig;
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "updateConfig:" + diskConfig);
        }
        if (this.isInited) {
            ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
            if (activityLifecycleService != null && !activityLifecycleService.isForeground()) {
                collect();
            }
        }
    }

    public void setDiskCheckListener(IStorageCheckListener iStorageCheckListener) {
        DiskStatistics.getInstance().setListener(iStorageCheckListener);
    }

    private synchronized void collect() {
        if (this.isAlreadyCollected) {
            return;
        }
        DiskConfig diskConfig = this.config;
        if (diskConfig != null && diskConfig.isSample()) {
            if (ApmContext.isMainProcess()) {
                this.isAlreadyCollected = true;
                this.asyncTask = new AsyncTask() { // from class: com.bytedance.apm6.disk.DiskCollector.1
                    @Override // java.lang.Runnable
                    public void run() {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (ApmContext.isDebugMode()) {
                            Logger.m119d(Constants.TAG, "startCollect:");
                        }
                        SharedPreferences sharedPreferences = ApmContext.getContext().getSharedPreferences("monitor_config", 0);
                        long currentTimeMillis2 = System.currentTimeMillis() - (sharedPreferences != null ? sharedPreferences.getLong("check_disk_last_time", 0L) : 0L);
                        if (ApmContext.isDebugMode()) {
                            Logger.m119d(Constants.TAG, "durationMs:" + currentTimeMillis2);
                        }
                        if (currentTimeMillis2 >= 86400000) {
                            DiskReportEvent collect = DiskStatistics.getInstance().collect(DiskCollector.this.config);
                            if (ApmContext.isDebugMode()) {
                                Logger.m119d(Constants.TAG, "durationMs:" + collect.toJsonObject());
                            }
                            Monitor.record(collect);
                            sharedPreferences.edit().putLong("check_disk_last_time", System.currentTimeMillis()).commit();
                        }
                        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(DiskCollector.this.asyncTask);
                        if (ApmContext.isDebugMode()) {
                            Logger.m119d(Constants.TAG, "collect end and cost time:" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                    }
                };
                AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.asyncTask);
            }
        }
    }
}

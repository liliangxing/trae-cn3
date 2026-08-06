package com.bytedance.apm6.p005fd;

import android.os.Process;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.p005fd.config.FdConfig;
import com.bytedance.apm6.p005fd.config.IFdConfigService;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.apm.api.IFdCheck;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FdCollector {
    private static final long DEFAULT_DELAY_CHECK_MS = 1200000;
    private static FdCollector instance = new FdCollector();
    private FdConfig config;
    private AsyncTask delayTask;
    private IFdCheck fdChecker;
    private volatile boolean isInited;
    private volatile boolean isReady = false;
    private volatile boolean isStarted;

    public static FdCollector getInstance() {
        return instance;
    }

    public void init() {
        if (this.isInited) {
            return;
        }
        this.isInited = true;
        IFdConfigService iFdConfigService = (IFdConfigService) ServiceManager.getService(IFdConfigService.class);
        if (iFdConfigService != null) {
            updateConfig(iFdConfigService.getConfig());
        }
        this.delayTask = new AsyncTask(1200000L) { // from class: com.bytedance.apm6.fd.FdCollector.1
            @Override // java.lang.Runnable
            public void run() {
                AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(FdCollector.this.delayTask);
                FdCollector.this.delayTask = null;
                FdCollector.this.isReady = true;
                FdCollector.this.start();
            }
        };
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.delayTask);
    }

    public synchronized void updateConfig(FdConfig fdConfig) {
        if (fdConfig == null) {
            return;
        }
        this.config = fdConfig;
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "updateConfig:" + fdConfig);
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void start() {
        FdConfig fdConfig;
        if (this.isReady && (fdConfig = this.config) != null && fdConfig.isSampled() && !this.isStarted) {
            this.isStarted = true;
            AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(new AsyncTask(0L, this.config.getCollectIntervalMs()) { // from class: com.bytedance.apm6.fd.FdCollector.2
                @Override // java.lang.Runnable
                public void run() {
                    FdCollector.this.collect();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void collect() {
        if (this.config == null) {
            return;
        }
        ActivityLifecycleService activityLifecycleService = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        boolean isForeground = activityLifecycleService != null ? activityLifecycleService.isForeground() : false;
        int fdCount = getFdCount();
        if (fdCount > 0 && fdCount < this.config.getFdCountThreshold()) {
            Monitor.record(new FdEvent(fdCount, null, isForeground));
            return;
        }
        IFdCheck fdChecker = getFdChecker();
        if (fdChecker == null) {
            return;
        }
        Monitor.record(new FdEvent(fdCount, fdChecker.getFdList(), isForeground));
    }

    private int getFdCount() {
        try {
            return new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
        } catch (Exception unused) {
            return 0;
        }
    }

    private IFdCheck getFdChecker() {
        if (this.fdChecker == null) {
            this.fdChecker = (IFdCheck) com.bytedance.news.common.service.manager.ServiceManager.getService(IFdCheck.class);
        }
        return this.fdChecker;
    }
}

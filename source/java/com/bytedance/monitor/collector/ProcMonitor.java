package com.bytedance.monitor.collector;

import android.util.Pair;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.TaskRunnable;
import com.bytedance.reparo.core.exception.PatchException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProcMonitor extends AbsMonitor {
    private int bufferSize;
    private boolean mALogCollectMode;
    TaskRunnable mCollectTask;
    private int mInterval;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcMonitor(int i) {
        super(i, MonitorType.PROC_MONITOR);
        this.bufferSize = 200;
        this.mInterval = BytePatchException.ErrorCode.paramsError;
        this.mALogCollectMode = true;
        this.mCollectTask = AsyncTaskUtil.wrapLightWeightTask("collect-proc", new Runnable() { // from class: com.bytedance.monitor.collector.ProcMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                ProcMonitor.this.collect();
            }
        });
    }

    public static void init() {
        try {
            if (PerfMonitorManager.soLoaded) {
                MonitorJni.doInit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void start() {
        super.start();
        try {
            if (PerfMonitorManager.soLoaded && this.mRunMode != 0) {
                boolean z = this.mALogCollectMode;
                if (z) {
                    this.mInterval = 5000;
                } else {
                    this.mInterval = BytePatchException.ErrorCode.paramsError;
                }
                MonitorJni.keepProcHyperOpen(z);
                MonitorJni.doStart();
                if (this.mAsyncTaskManager != null) {
                    this.mAsyncTaskManager.scheduleWithFixedDelay(this.mCollectTask, 0L, this.mInterval);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void collect() {
        if (PerfMonitorManager.soLoaded) {
            MonitorJni.doCollect();
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void stop() {
        super.stop();
        try {
            if (PerfMonitorManager.soLoaded) {
                if (this.mAsyncTaskManager != null) {
                    this.mAsyncTaskManager.removeTask(this.mCollectTask);
                }
                MonitorJni.doStop();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    protected void updateConfig(int i) {
        try {
            if (PerfMonitorManager.soLoaded) {
                stop();
                if (i != 0) {
                    if (i == 1) {
                        this.bufferSize = 200;
                        this.mInterval = BytePatchException.ErrorCode.paramsError;
                        MonitorJni.setBufferSize(200);
                    } else if (i == 2 || i == 3) {
                        this.bufferSize = PatchException.ERR_INSTALL_PARSE_IO;
                        this.mInterval = BytePatchException.ErrorCode.paramsError;
                        MonitorJni.setBufferSize(PatchException.ERR_INSTALL_PARSE_IO);
                    }
                    start();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void destroy() {
        super.destroy();
        try {
            if (PerfMonitorManager.soLoaded) {
                MonitorJni.doDestroy();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public synchronized Pair<String, String> dumpInfo() {
        try {
            if (!PerfMonitorManager.soLoaded) {
                return null;
            }
            return new Pair<>(this.mCollectorType, MonitorJni.getProcInfos());
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public synchronized Pair<String, String> dumpInfosRange(long j, long j2) {
        try {
            if (!PerfMonitorManager.soLoaded) {
                return null;
            }
            return new Pair<>(this.mCollectorType, MonitorJni.getProcInfoTimeRange(j, j2));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void dumpInfosToALog(long j, long j2, long j3) {
        try {
            if (PerfMonitorManager.soLoaded && !this.mALogCollectMode) {
                MonitorJni.dumpProcInfoTimeRangeToALog(j - j3, j2);
            }
        } catch (Throwable unused) {
        }
    }

    public static long getCpuTime(int i) {
        try {
            if (PerfMonitorManager.soLoaded) {
                return MonitorJni.doGetCpuTime(i) * Sysconf.getJiffyMills();
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String getThreadSchedInfo(int i) {
        return !PerfMonitorManager.soLoaded ? "" : MonitorJni.doGetSchedInfo(i);
    }

    public void setALogCollectMode(boolean z) {
        if (z == this.mALogCollectMode) {
            return;
        }
        this.mALogCollectMode = z;
        start();
    }
}

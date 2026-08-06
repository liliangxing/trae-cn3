package com.bytedance.monitor.collector;

import android.util.Pair;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AtraceMonitor extends AbsMonitor {
    @Override // com.bytedance.monitor.collector.AbsMonitor
    protected void updateConfig(int i) {
    }

    public AtraceMonitor(int i) {
        super(i, MonitorType.ATRACE_MONITOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair<String, ?> dumpInfo() {
        try {
            if (PerfMonitorManager.soLoaded) {
                return new Pair<>(this.mCollectorType, dumpAtrace());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public Pair<String, ?> dumpInfosRange(long j, long j2) {
        try {
            if (PerfMonitorManager.soLoaded) {
                return new Pair<>(this.mCollectorType, dumpAtraceRange(j, j2));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.monitor.collector.AbsMonitor
    public void dumpInfosToALog(long j, long j2, long j3) {
        try {
            if (PerfMonitorManager.soLoaded) {
                if (j2 - j > 250) {
                    j2 = j + 250;
                }
                MonitorJni.doDumpAtraceRangeToALog(j, j2);
            }
        } catch (Throwable unused) {
        }
    }

    public void enableAtrace(long j) {
        try {
            if (PerfMonitorManager.soLoaded) {
                MonitorJni.doEnableAtrace(this.mRunMode, j);
            }
        } catch (Throwable unused) {
        }
    }

    public void disableAtrace() {
        try {
            if (PerfMonitorManager.soLoaded) {
                MonitorJni.doDisableAtrace();
            }
        } catch (Throwable unused) {
        }
    }

    private String dumpAtrace() {
        if (PerfMonitorManager.soLoaded) {
            return MonitorJni.doDumpAtrace();
        }
        return null;
    }

    private String dumpAtraceRange(long j, long j2) {
        if (PerfMonitorManager.soLoaded) {
            return MonitorJni.doDumpAtraceRange(j, j2);
        }
        return null;
    }
}

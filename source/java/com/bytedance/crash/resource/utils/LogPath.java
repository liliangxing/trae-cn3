package com.bytedance.crash.resource.utils;

import com.bytedance.crash.config.LogPathConfig;
import java.io.File;

/* loaded from: classes3.dex */
public class LogPath {
    private static final String FD_TRACK_DIR = "FdTrack";
    private static final String GWP_ASAN_LOG_DIR = "xasanReport";
    private static final String NATIVE_HEAP_TRACKER_DIR = "NativeHeapReport";
    private static final String PRIO_MONITOR_DIR = "PriorityMonitor";
    private static final String REF_MONITOR_DIR = "RefMonitor";
    private static final String TLS_MONITOR_DIR = "TLSMonitor";
    private static final String VM_MONITOR_DIR = "VmMonitor";
    private static final LogPath sInstance = new LogPath();
    private File mFdTrack;
    private File mGwpReport;
    private File mHeapTrack;
    private File mNpthRootDir = LogPathConfig.getNpthRootPath();
    private File mPrioMonitor;
    private File mRefMonitor;
    private File mTLSMonitor;
    private File mVmMonitor;

    private static LogPath get() {
        return sInstance;
    }

    private LogPath() {
        updateFilePath();
    }

    public void updateFilePath() {
        this.mGwpReport = new File(this.mNpthRootDir, GWP_ASAN_LOG_DIR);
        this.mHeapTrack = new File(this.mNpthRootDir, NATIVE_HEAP_TRACKER_DIR);
        this.mVmMonitor = new File(this.mNpthRootDir, VM_MONITOR_DIR);
        this.mFdTrack = new File(this.mNpthRootDir, FD_TRACK_DIR);
        this.mRefMonitor = new File(this.mNpthRootDir, REF_MONITOR_DIR);
        this.mTLSMonitor = new File(this.mNpthRootDir, TLS_MONITOR_DIR);
        this.mPrioMonitor = new File(this.mNpthRootDir, "PriorityMonitor");
    }

    public static File getNativeHeapTrackerPath() {
        return get().mHeapTrack;
    }

    public static File getGwpAsanLogPath() {
        return get().mGwpReport;
    }

    public static File getVmMonitorPath() {
        return get().mVmMonitor;
    }

    public static File getFdTrackPath() {
        return get().mFdTrack;
    }

    public static File getRefMonitorPath() {
        return get().mRefMonitor;
    }

    public static File getTLSMonitorPath() {
        return get().mTLSMonitor;
    }

    public static File getPriorityMonitorPath() {
        return get().mPrioMonitor;
    }
}

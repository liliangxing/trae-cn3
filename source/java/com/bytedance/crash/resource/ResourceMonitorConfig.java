package com.bytedance.crash.resource;

import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;

/* loaded from: classes3.dex */
public class ResourceMonitorConfig {
    protected static final int TYPE_FD = 2;
    protected static final int TYPE_GWP_ASAN = 0;
    protected static final int TYPE_HEAP_TRACK = 1;
    protected static final int TYPE_PRIO = 6;
    protected static final int TYPE_REF = 5;
    protected static final int TYPE_TLS = 4;
    protected static final int TYPE_VMM = 3;
    protected int mApiLevelMax;
    protected int mApiLevelMin;
    protected int mResourceType;
    protected String mGuardFileName = null;
    protected String mLibName = null;
    protected String mConfigName = null;
    protected File mReportDir = null;

    private static String getConfigName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "ref_monitor.config" : "tls_monitor.config" : "vmm.config" : "fd_track.config" : "heap_track.config" : "xasan.config";
    }

    private static String getGuardFileName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "ref_monitor.guard" : "tls_monitor.guard" : "vm_monitor.guard" : "fd_track.guard" : "heap_track.guard" : "gwp_asan.guard";
    }

    private static String getLibName(int i) {
        switch (i) {
            case 0:
                return "npth_xasan";
            case 1:
                return "npth_heap_tracker";
            case 2:
                return "npth_fd_tracker";
            case 3:
                return "npth_vm_monitor";
            case 4:
                return "npth_tls_monitor";
            case 5:
                return "npth_ref_monitor";
            case 6:
                return "npth_setpriority";
            default:
                return "unknown";
        }
    }

    public String toString() {
        return "";
    }

    public ResourceMonitorConfig(int i, int i2, int i3) {
        this.mApiLevelMax = i2;
        this.mApiLevelMin = i;
        this.mResourceType = i3;
    }

    public int getmApiLevelMax() {
        return this.mApiLevelMax;
    }

    public int getmApiLevelMin() {
        return this.mApiLevelMin;
    }

    public String getGuardFileName() {
        if (this.mGuardFileName == null) {
            this.mGuardFileName = getGuardFileName(this.mResourceType);
        }
        return this.mGuardFileName;
    }

    public String getLibName() {
        if (this.mLibName == null) {
            this.mLibName = getLibName(this.mResourceType);
        }
        return this.mLibName;
    }

    public String getConfigName() {
        if (this.mConfigName == null) {
            this.mConfigName = getConfigName(this.mResourceType);
        }
        return this.mConfigName;
    }

    public String getFullSoName() {
        return LibrarianImpl.Constants.LIB_PREFIX + getLibName() + LibrarianImpl.Constants.SO_SUFFIX;
    }

    public int getResourceType() {
        return this.mResourceType;
    }

    public File getReportDir() {
        if (this.mReportDir == null) {
            this.mReportDir = getReportDir(this.mResourceType);
        }
        return this.mReportDir;
    }

    public static File getReportDir(int i) {
        switch (i) {
            case 0:
                return LogPath.getGwpAsanLogPath();
            case 1:
                return LogPath.getNativeHeapTrackerPath();
            case 2:
                return LogPath.getFdTrackPath();
            case 3:
                return LogPath.getVmMonitorPath();
            case 4:
                return LogPath.getTLSMonitorPath();
            case 5:
                return LogPath.getRefMonitorPath();
            case 6:
                return LogPath.getPriorityMonitorPath();
            default:
                return null;
        }
    }
}

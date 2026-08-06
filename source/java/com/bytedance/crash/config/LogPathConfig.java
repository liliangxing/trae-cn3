package com.bytedance.crash.config;

import android.content.Context;
import com.bytedance.crash.Global;
import java.io.File;

/* loaded from: classes3.dex */
public class LogPathConfig {
    public static final String CORE_DUMP_LOG_DIR = "asdawd";
    public static final String NPTH_LIB_DIR = "selflib";
    public static final String PRIO_MONITOR_DIR = "PriorityMonitor";
    private static final LogPathConfig sInstance = new LogPathConfig();
    private File mCoreDump;
    private File mNpthLib;
    private File mNpthRoot;
    private File mPrioMonitor;
    private final String mAppRootDirStr = getAppRootDirectory();
    private String mNpthRootDirStr = "npth";

    private static LogPathConfig get() {
        return sInstance;
    }

    private void updateRootDir(String str) {
        this.mNpthRootDirStr = str;
        updateFilePath();
    }

    private LogPathConfig() {
        updateFilePath();
        if (this.mNpthRoot.exists()) {
            return;
        }
        this.mNpthRoot.mkdirs();
    }

    private String getAppRootDirectory() {
        try {
            Context context = Global.getContext();
            return context != null ? context.getFilesDir().getAbsolutePath() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void updateFilePath() {
        this.mNpthRoot = new File(this.mAppRootDirStr, this.mNpthRootDirStr);
        this.mCoreDump = new File(this.mNpthRoot, CORE_DUMP_LOG_DIR);
        this.mNpthLib = new File(this.mNpthRoot, NPTH_LIB_DIR);
        this.mPrioMonitor = new File(this.mNpthRoot, PRIO_MONITOR_DIR);
    }

    public static File getNpthRootPath() {
        return get().mNpthRoot;
    }

    public static File getCoreDumpPath() {
        return get().mCoreDump;
    }

    public static File getNpthLibDir() {
        return get().mNpthLib;
    }

    public static File getPrioMonitorPath() {
        return get().mPrioMonitor;
    }
}

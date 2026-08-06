package com.bytedance.android.monitor.debug;

import android.app.Application;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.logger.MonitorLog;
import com.bytedance.android.monitor.util.ExceptionUtil;
import com.bytedance.android.monitor.util.FileUtils;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorDebugConfig {
    public static boolean AB_TEST;
    private static boolean DEBUG;
    private static boolean OUTPUT_FILE;

    public static void init(Application application) {
        if (application != null) {
            try {
                File externalAppDir = FileUtils.getExternalAppDir(application, "monitor_data_switch");
                File file = new File(externalAppDir, "is_debug");
                if (file.isFile() && file.exists()) {
                    setDebuggable(true);
                }
                File file2 = new File(externalAppDir, "is_output_file");
                if (file2.isFile() && file2.exists()) {
                    setOutputFile(true);
                }
            } catch (Throwable th) {
                ExceptionUtil.handleException(th);
            }
        }
    }

    public static void setDebuggable(boolean z) {
        setDebuggable(z, false);
    }

    public static void setDebuggable(boolean z, boolean z2) {
        DEBUG = z;
        Application application = HybridMonitor.getInstance().getApplication();
        if (z2 && application != null) {
            File file = new File(FileUtils.getExternalAppDir(application, "monitor_data_switch"), "is_debug");
            if (z) {
                FileUtils.makeSureFileExist(file);
            } else {
                FileUtils.delete(file);
            }
        }
        if (z) {
            MonitorLog.setLogEnable(true);
        }
    }

    public static boolean isDebuggable() {
        return DEBUG;
    }

    public static void setOutputFile(boolean z) {
        setOutputFile(z, false);
    }

    public static void setOutputFile(boolean z, boolean z2) {
        OUTPUT_FILE = z;
        Application application = HybridMonitor.getInstance().getApplication();
        if (!z2 || application == null) {
            return;
        }
        File file = new File(FileUtils.getExternalAppDir(application, "monitor_data_switch"), "is_output_file");
        if (z) {
            FileUtils.makeSureFileExist(file);
        } else {
            FileUtils.delete(file);
        }
    }

    public static boolean isOutputFile() {
        return OUTPUT_FILE;
    }

    public void setAbTestEnable(boolean z) {
        AB_TEST = z;
    }

    public boolean isAbTestEnable() {
        return AB_TEST;
    }
}

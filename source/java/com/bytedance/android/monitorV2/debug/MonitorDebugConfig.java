package com.bytedance.android.monitorV2.debug;

import android.app.Application;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.FileUtils;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorDebugConfig {
    private static boolean DEBUG = false;
    private static boolean OUTPUT_FILE = false;
    private static boolean SAMPLE_OFF = false;
    private static boolean SKIP_WHITELIST_INJECT_CHECK = false;
    public static final String SP_KEY_HDT_IMMEDIATE = "monitor_immediate_switch";
    public static final String SP_KEY_HDT_SAMPLE = "monitor_hdt_ignore_sample";
    public static final String SP_KEY_HDT_SKIP_INJECT_CHECK = "monitor_skip_inject_check";
    public static final String SP_KEY_HDT_VALIDATION = "monitor_validation_switch";

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
        Application application = HybridMultiMonitor.getInstance().getApplication();
        if (z2 && application != null) {
            File file = new File(FileUtils.getExternalAppDir(application, "monitor_data_switch"), "is_debug");
            if (z) {
                FileUtils.makeSureFileExist(file);
            } else {
                FileUtils.delete(file);
            }
        }
        if (z) {
            MonitorLog.setLogVerbose(true);
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
        Application application = HybridMultiMonitor.getInstance().getApplication();
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

    public static void setSampleOff(boolean z) {
        SAMPLE_OFF = z;
    }

    public static boolean isSampleOff() {
        return SAMPLE_OFF;
    }

    public static void setSkipWhiteListInjectCheck(boolean z) {
        SKIP_WHITELIST_INJECT_CHECK = z;
    }

    public static boolean skipWhiteListInjectCheck() {
        return SKIP_WHITELIST_INJECT_CHECK;
    }
}

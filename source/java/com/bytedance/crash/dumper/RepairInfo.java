package com.bytedance.crash.dumper;

import com.bytedance.crash.repair.RepairAdapter;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RepairInfo {
    private static final String SIGNAL_FILE_NAME = "signal_monitor.txt";

    public static void dumpSignalMonitorInfo(File file) {
        try {
            RepairAdapter.dumpRepairInfo(2, new File(file, SIGNAL_FILE_NAME).getAbsolutePath());
        } catch (Throwable unused) {
        }
    }
}

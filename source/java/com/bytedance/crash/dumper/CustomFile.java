package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.FileUtils;
import java.io.File;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CustomFile {
    private static final int SIZE_LIMIT = 1048576;
    private static int cacheFileSize = 1048576;
    private static volatile boolean isEnable = true;

    public static void updateConfig(boolean z, int i) {
        isEnable = z;
        if (i > 0) {
            cacheFileSize = i;
        }
    }

    public static void dump(File file, CrashType crashType) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null || !isEnable) {
            return;
        }
        try {
            Iterator<CrashInfoCallback> it = appMonitor.getUserDataCenter().getCrashInfoCallback(crashType).iterator();
            int i = 0;
            while (it.hasNext()) {
                File[] crashFileList = it.next().crashFileList(crashType);
                if (crashFileList != null) {
                    for (File file2 : crashFileList) {
                        File file3 = new File(file, file2.getName());
                        if (!file3.exists()) {
                            i = (int) (i + file2.length());
                            if (i > cacheFileSize) {
                                break;
                            } else {
                                FileUtils.copy(file2, file3);
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}

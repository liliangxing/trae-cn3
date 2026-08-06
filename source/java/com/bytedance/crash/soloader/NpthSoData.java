package com.bytedance.crash.soloader;

import android.content.Context;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.constants.SoName;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NpthSoData {
    private static boolean sShouldCheckSo;
    private static HashMap<String, String> sSoVersions;

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSoPath(String str) {
        return LogPathConfig.getNpthLibDir().getAbsolutePath() + "/lib" + str + ".so";
    }

    private static String getSoDir() {
        return LogPathConfig.getNpthLibDir().getAbsolutePath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSoVersionPath(String str) {
        return LogPathConfig.getNpthLibDir().getAbsolutePath() + "/" + str + ".ver";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkSoList() {
        if (sSoVersions != null) {
            return;
        }
        sSoVersions = new HashMap<>();
        File npthLibDir = LogPathConfig.getNpthLibDir();
        String[] list = npthLibDir.list();
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (str.endsWith(".ver")) {
                try {
                    sSoVersions.put(str.substring(0, str.length() - 4), FileUtils.readFile(npthLibDir.getAbsolutePath() + "/" + str));
                } catch (Throwable th) {
                    NpthMonitor.reportInnerException(th);
                }
            } else if (!str.endsWith(".so")) {
                FileUtils.deleteFile(new File(npthLibDir, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkSoAvailable(String str, String str2) {
        if (str2.equals(sSoVersions.get(str))) {
            return new File(getSoPath(str)).exists();
        }
        return false;
    }

    private static void checkAndUpdateSo(final String str, final String str2) {
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.soloader.NpthSoData.1
            @Override // java.lang.Runnable
            public void run() {
                NpthSoData.checkSoList();
                if (NpthSoData.checkSoAvailable(str, str2)) {
                    return;
                }
                File file = new File(NpthSoData.getSoPath(str));
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                NpthLog.m235w("doUnpackLibrary: " + str);
                Context context = Global.getContext();
                if (context != null && SafelyLibraryLoader.unpackLibrary(context, str, file) == null) {
                    NpthSoData.sSoVersions.put(file.getName(), str2);
                    try {
                        FileUtils.writeFile(new File(NpthSoData.getSoVersionPath(str)), str2, false);
                    } catch (Throwable th) {
                        NpthMonitor.reportInnerException(th);
                    }
                }
            }
        });
    }

    private static boolean updateSo(String str, File file, Context context) {
        File file2 = new File(file, "lib" + str + ".so.tmp");
        String unpackLibrary = SafelyLibraryLoader.unpackLibrary(context, str, file2);
        if (unpackLibrary != null) {
            NpthLog.m235w(str + " unpack error: " + unpackLibrary);
            return false;
        }
        return file2.renameTo(new File(file, "lib" + str + ".so"));
    }

    public static boolean checkDumperFile() {
        Context context = Global.getContext();
        if (context == null) {
            return false;
        }
        if (new File(context.getApplicationInfo().nativeLibraryDir, SoName.NPTH_DUMPER_FILE_NAME).exists()) {
            return true;
        }
        File file = new File(LogPathConfig.getNpthLibDir(), String.valueOf(4020260));
        if (!file.exists()) {
            file.mkdirs();
        }
        if (new File(file, SoName.NPTH_DUMPER_FILE_NAME).exists()) {
            return true;
        }
        return updateSo("c++_shared", file, context) && updateSo("npth_unwind", file, context) && updateSo(SoName.NPTH_DUMPER_NAME, file, context);
    }

    public static void checkSoFile(String str, String str2) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return;
        }
        appMonitor.getUserDataCenter().registerInnerSdkInfo(str + ".so", str2);
        if (sShouldCheckSo) {
            checkAndUpdateSo(str, str2);
        }
    }
}

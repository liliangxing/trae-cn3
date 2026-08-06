package com.bytedance.crash.dumper;

import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileUtils;
import java.io.File;
import java.io.FilenameFilter;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EvilDumpFile {
    private static CrashInfoCallback sCallback;

    public static void setANRCallback(CrashInfoCallback crashInfoCallback) {
        sCallback = crashInfoCallback;
    }

    public static void push(File file, final JSONObject jSONObject) {
        try {
            file.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.dumper.EvilDumpFile.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str) {
                    try {
                        if (!str.contains("evil_trace")) {
                            return false;
                        }
                        jSONObject.put("has_evil_trace_file", String.valueOf(true));
                        return false;
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        } catch (Throwable th) {
            NpthMonitor.directReportInnerException("pushEvilFile", th);
        }
    }

    public static void dump(File file) {
        File[] crashFileList;
        CrashInfoCallback crashInfoCallback = sCallback;
        if (crashInfoCallback == null || (crashFileList = crashInfoCallback.crashFileList(CrashType.ANR)) == null) {
            return;
        }
        for (File file2 : crashFileList) {
            File file3 = new File(file, file2.getName());
            if (!file3.exists()) {
                FileUtils.copy(file2, file3);
            }
        }
    }
}

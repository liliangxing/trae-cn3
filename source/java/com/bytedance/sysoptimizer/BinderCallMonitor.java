package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes5.dex */
public class BinderCallMonitor {
    private static final int MAX_TASK_COMM_LEN = 16;
    private static final String TAG = "BinderCallMonitor";
    private static char[] sComm;

    private static native void nStart(int i, boolean z);

    private static String getThreadName(int i) {
        File file = new File("/proc/self/task/" + i + "/comm");
        if (!file.exists()) {
            return "Unknown";
        }
        try {
            FileReader fileReader = new FileReader(file);
            try {
                int read = fileReader.read(sComm);
                if (read <= 0 || read > 16) {
                    fileReader.close();
                    return "Unknown";
                }
                String str = new String(sComm, 0, read - 1);
                fileReader.close();
                return str;
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    public static void start(Context context, String str, boolean z) {
        File[] listFiles;
        if (str == null || !SysOptimizer.loadOptimizerLibrary(context)) {
            return;
        }
        ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
        ByteHook.init();
        sComm = new char[16];
        File file = new File("/proc/self/task");
        int i = 0;
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            int length = listFiles.length;
            int i2 = 0;
            while (i < length) {
                int parseInt = Integer.parseInt(listFiles[i].getName());
                if (str.equals(getThreadName(parseInt))) {
                    Log.i(TAG, "targetThread founded! tid " + parseInt);
                    i2 = parseInt;
                }
                i++;
            }
            i = i2;
        }
        if (i > 0) {
            nStart(i, z);
        }
    }
}

package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes5.dex */
public class GCThreadPrioOptWhenBlockGC {
    private static native void nStart(int i, int i2);

    private static String getThreadName(int i) {
        File file = new File("/proc/self/task/" + i + "/comm");
        if (!file.exists()) {
            return "Unknown";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                return readLine;
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Unknown";
        }
    }

    private static int getGCThreadTid() {
        File[] listFiles;
        File file = new File("/proc/self/task");
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                int parseInt = Integer.parseInt(file2.getName());
                if ("HeapTaskDaemon".equals(getThreadName(parseInt))) {
                    return parseInt;
                }
            }
        }
        return 0;
    }

    public static void startOpt(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
            int gCThreadTid = getGCThreadTid();
            if (gCThreadTid != 0) {
                nStart(gCThreadTid, i);
            }
        }
    }
}

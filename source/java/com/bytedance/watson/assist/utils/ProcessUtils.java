package com.bytedance.watson.assist.utils;

import android.os.Process;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class ProcessUtils {
    public static int MAIN_THREAD_ID = -1;

    private static ArrayList<Long> numericFolderItems(String str) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (File file : new File(str).listFiles(new FilenameFilter() { // from class: com.bytedance.watson.assist.utils.ProcessUtils.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                try {
                    Long.parseLong(str2);
                    return true;
                } catch (NumberFormatException unused) {
                    return false;
                }
            }
        })) {
            arrayList.add(Long.valueOf(Long.parseLong(file.getName())));
        }
        return arrayList;
    }

    public static ArrayList<Long> threadListFromProcFs() {
        return numericFolderItems("/proc/self/task/");
    }

    public static int getMainThreadId() {
        if (MAIN_THREAD_ID == -1) {
            MAIN_THREAD_ID = Process.myPid();
        }
        return MAIN_THREAD_ID;
    }
}

package com.bytedance.memory.dump;

import com.bytedance.memory.common.MemoryExecutorSupplier;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.heap.HeapSaver;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DumpFileController {
    public static final long HOUR = 3600000;
    private static final int MAX_STORE_SHRINK_DAY = 7;
    private static final int MAX_STORE_SHRINK_SIZE = 524288000;
    private static volatile DumpFileController sDumpFileController;

    private DumpFileController() {
    }

    public static DumpFileController getInstance() {
        if (sDumpFileController == null) {
            synchronized (DumpFileController.class) {
                if (sDumpFileController == null) {
                    sDumpFileController = new DumpFileController();
                }
            }
        }
        return sDumpFileController;
    }

    public void checkWidgetFolder() {
        MemoryExecutorSupplier.NORMAL_SERVICE.execute(new Runnable() { // from class: com.bytedance.memory.dump.DumpFileController.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long lastDumpTime = HeapSaver.getInstance().getLastDumpTime();
                    if (lastDumpTime == 0 || System.currentTimeMillis() - lastDumpTime <= 259200000) {
                        return;
                    }
                    HeapSaver.getInstance().deleteCache();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, "DumpFileController-checkWidgetFolder");
    }

    private void deleteFolder(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            deleteExpireFile(file);
            deleteExceedFile(file);
        }
    }

    private boolean folderExceed(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return false;
        }
        long j = 0;
        for (File file2 : listFiles) {
            j += file2.length();
        }
        return j > 524288000;
    }

    private void deleteExceedFile(File file) {
        if (folderExceed(file)) {
            File[] listFiles = file.listFiles();
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.memory.dump.DumpFileController.2
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return file2.lastModified() - file3.lastModified() > 0 ? 1 : 0;
                }
            });
            for (File file2 : listFiles) {
                if (folderExceed(file) || file2.length() == 0) {
                    if (file2.delete()) {
                        MemoryLog.m101i("delete ExceedFile succeed", new Object[0]);
                    } else {
                        MemoryLog.m101i("delete ExceedFile failed", new Object[0]);
                    }
                }
            }
        }
    }

    public void deleteExpireFile(File file) {
        File[] listFiles;
        if (file.isFile()) {
            if (canDeleteShrink(file) || file.length() == 0) {
                file.delete();
                return;
            }
            return;
        }
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            deleteExpireFile(file2);
        }
    }

    private boolean canDeleteShrink(File file) {
        MemoryLog.m101i("lastModified %d now %d", Long.valueOf(file.lastModified()), Long.valueOf(System.currentTimeMillis()));
        return System.currentTimeMillis() - file.lastModified() > 604800000;
    }
}

package com.ss.android.common.applog;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.ss.android.common.util.TLog;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class LogDebugUtil {
    private static final int LOG_LIMIT = 500;
    private static final int PUEGE_QUEUE_SIZE = 100;
    private static boolean sEnabled = false;
    private static int sLogCount = -1;
    private static LinkedList<File> sPurgeQueue;

    public static void trackLogInsert(Context context, long j, String str) {
        if (sEnabled && Logger.debug() && context != null && j > 0 && str != null && str.length() > 0 && str.indexOf("item_impression") > 0) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(context.getExternalCacheDir(), "log_" + j + "_.log"));
                try {
                    fileOutputStream2.write(str.getBytes());
                    fileOutputStream2.close();
                    synchronized (LogDebugUtil.class) {
                        int i = sLogCount;
                        if (i >= 0) {
                            sLogCount = i + 1;
                        }
                    }
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                }
            } catch (Throwable unused2) {
            }
            safeClose(fileOutputStream);
            tryShrink(context);
            LinkedList<File> linkedList = sPurgeQueue;
            TLog.d("LogDebugUtil logCount: " + sLogCount + ", purgeQueueSize: " + (linkedList != null ? linkedList.size() : -1));
        }
    }

    public static void trackLogDiscard(Context context, long j) {
        if (!sEnabled || !Logger.debug() || context == null || j <= 0) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(context.getExternalCacheDir(), "discard_logs.log"), true);
            try {
                fileOutputStream2.write((j + new Date().toString() + UpdateDialogNewBase.TYPE).getBytes());
                safeClose(fileOutputStream2);
            } catch (Throwable unused) {
                fileOutputStream = fileOutputStream2;
                safeClose(fileOutputStream);
            }
        } catch (Throwable unused2) {
        }
    }

    private static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static synchronized void tryShrink(Context context) {
        synchronized (LogDebugUtil.class) {
            try {
                if (sLogCount < 0) {
                    loadPurgeQueue(context);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (sLogCount < 500) {
                return;
            }
            if (sPurgeQueue == null) {
                loadPurgeQueue(context);
            }
            if (sPurgeQueue == null) {
                return;
            }
            while (sLogCount > 500 && sPurgeQueue.size() > 0) {
                sPurgeQueue.removeFirst().delete();
                sLogCount--;
            }
            if (sLogCount < 0) {
                sLogCount = -1;
            }
            if (sPurgeQueue.isEmpty()) {
                sPurgeQueue = null;
            }
        }
    }

    private static void loadPurgeQueue(Context context) {
        File[] sortedList = getSortedList(context.getExternalCacheDir());
        sLogCount = sortedList.length;
        if (sortedList.length >= 500) {
            LinkedList<File> linkedList = new LinkedList<>();
            sPurgeQueue = linkedList;
            linkedList.addAll(Arrays.asList(sortedList).subList(0, sortedList.length <= 100 ? sortedList.length : 100));
        }
    }

    private static File[] getSortedList(File file) {
        final Pattern compile = Pattern.compile("^log_[0-9]+_\\.log$");
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.ss.android.common.applog.LogDebugUtil.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2 != null ? file2.getName() : null;
                if (name != null && name.startsWith("log_") && file2.isFile()) {
                    return compile.matcher(name).matches();
                }
                return false;
            }
        });
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.ss.android.common.applog.LogDebugUtil.2
            @Override // java.util.Comparator
            public int compare(File file2, File file3) {
                long lastModified = file2.lastModified();
                long lastModified2 = file3.lastModified();
                if (lastModified < lastModified2) {
                    return -1;
                }
                return lastModified == lastModified2 ? 0 : 1;
            }
        });
        return listFiles;
    }
}

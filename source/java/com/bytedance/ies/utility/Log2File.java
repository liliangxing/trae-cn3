package com.bytedance.ies.utility;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class Log2File {
    private static final boolean CONFIG = false;
    private static ExecutorService sExecutorService = null;
    private static String sFileName = "notify.log";
    private static String sPath;
    private static SimpleDateFormat sSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static synchronized void writeLog(Context context, String str) {
        synchronized (Log2File.class) {
            try {
                ExecutorService executorService = sExecutorService;
                if (executorService != null) {
                    executorService.shutdown();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: com.bytedance.ies.utility.Log2File$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$log;

        AnonymousClass1(String str) {
            this.val$log = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PrintWriter printWriter;
            Throwable th;
            IOException e;
            File GetFileFromPath;
            PrintWriter printWriter2 = null;
            try {
                try {
                    GetFileFromPath = Log2File.GetFileFromPath(Log2File.sPath, Log2File.sFileName);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        printWriter.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (IOException e2) {
                printWriter = null;
                e = e2;
            } catch (Throwable th3) {
                printWriter = null;
                th = th3;
                printWriter.close();
                throw th;
            }
            if (GetFileFromPath == null || !GetFileFromPath.exists()) {
                try {
                    printWriter2.close();
                    throw null;
                } catch (Exception unused2) {
                    return;
                }
            }
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(GetFileFromPath, true)));
            try {
                try {
                    printWriter.print(Log2File.sSimpleDateFormat.format(new Date(System.currentTimeMillis())));
                    printWriter.print("     ");
                    printWriter.print(this.val$log);
                    printWriter.println();
                    printWriter.flush();
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    printWriter.close();
                }
                printWriter.close();
            } catch (Exception unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static File GetFileFromPath(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Logger.e("Error", "The path of Log file is Null.");
            return null;
        }
        File file = new File(str + str2);
        boolean exists = file.exists();
        boolean canWrite = file.canWrite();
        if (!exists) {
            try {
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    Logger.i("Success", "The Log file was successfully created! -" + file.getAbsolutePath());
                } else {
                    Logger.i("Success", "The Log file exist! -" + file.getAbsolutePath());
                }
                if (!file.canWrite()) {
                    Logger.e("Error", "The Log file can not be written.");
                }
            } catch (IOException e) {
                Logger.e("Error", "Failed to create The Log file.");
                throw e;
            }
        } else if (!canWrite) {
            Logger.e("Error", "The Log file can not be written.");
        }
        return file;
    }
}

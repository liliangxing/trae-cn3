package com.bytedance.memory.common;

import android.content.ComponentName;
import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;

/* loaded from: classes4.dex */
public class MemoryUtils {
    private static final int DEFAULT_MEMORY = -1;
    private static long sMaxMemory = -1;

    public static float getMemoryRate() {
        float doubleValue = ((float) new BigDecimal(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()).divide(new BigDecimal(getAppMaxMemory()), 4, 4).doubleValue()) * 100.0f;
        MemoryLog.i("currentRate %f", Float.valueOf(doubleValue));
        return doubleValue;
    }

    public static long getAppUsedMemory() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    private static long getAppMaxMemory() {
        long j = sMaxMemory;
        if (j != -1) {
            return j;
        }
        long maxMemory = Runtime.getRuntime().maxMemory();
        sMaxMemory = maxMemory;
        return maxMemory;
    }

    public static void copyFile(File file, File file2) throws IOException {
        FileChannel fileChannel;
        if (file == null || file2 == null || !file.exists()) {
            MemoryLog.i("copy file failed", new Object[0]);
            return;
        }
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                fileChannel2.transferFrom(channel, 0L, channel.size());
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel3;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    public static void deleteFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (file.isDirectory()) {
                    deleteFile(file2);
                }
            }
        }
        file.delete();
    }

    public static boolean isApkInDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void saveStringToFile(String str, String str2) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(str));
            printWriter.println(str2);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setEnabledBlocking(Context context, Class<?> cls, boolean z) {
        if (cls != null) {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls), z ? 1 : 2, 1);
        }
    }
}

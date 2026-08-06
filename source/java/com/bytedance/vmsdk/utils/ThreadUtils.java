package com.bytedance.vmsdk.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.vmsdk.jsbridge.utils.Assertions;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class ThreadUtils {
    private static final int CMDLINE_BUFFER_SIZE = 64;
    private static Handler sMainHandler;
    private static String sProcessName;
    private static boolean sProcessNameRead;

    public static boolean isOnUiThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void assertOnUiThread() {
        Assertions.assertCondition(isOnUiThread(), "Expected to run on UI thread!");
    }

    public static void assertNotOnUiThread() {
        Assertions.assertCondition(!isOnUiThread(), "Expected not to run on UI thread!");
    }

    public static void runOnUiThread(Runnable runnable) {
        synchronized (ThreadUtils.class) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
        }
        sMainHandler.post(runnable);
    }

    public static void runOnUiThreadImmediately(Runnable runnable) {
        if (isOnUiThread()) {
            runnable.run();
        } else {
            runOnUiThread(runnable);
        }
    }

    public static void runOnUiThread(Runnable runnable, long j) {
        synchronized (ThreadUtils.class) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
        }
        sMainHandler.postDelayed(runnable, j);
    }

    public static void runOnUiThreadAtTime(Runnable runnable, Object obj, long j) {
        synchronized (ThreadUtils.class) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
        }
        sMainHandler.postAtTime(runnable, obj, j);
    }

    public static void removeCallbacks(Runnable runnable, Object obj) {
        synchronized (ThreadUtils.class) {
            if (sMainHandler == null) {
                sMainHandler = new Handler(Looper.getMainLooper());
            }
        }
        sMainHandler.removeCallbacks(runnable, obj);
    }

    public static synchronized String getProcessName() {
        String str;
        synchronized (ThreadUtils.class) {
            if (!sProcessNameRead) {
                sProcessNameRead = true;
                try {
                    sProcessName = readProcessName();
                } catch (IOException unused) {
                }
            }
            str = sProcessName;
        }
        return str;
    }

    private static String readProcessName() throws IOException {
        byte[] bArr = new byte[64];
        FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
        try {
            int read = fileInputStream.read(bArr);
            int indexOf = indexOf(bArr, 0, read, (byte) 0);
            if (indexOf > 0) {
                read = indexOf;
            }
            return new String(bArr, 0, read);
        } finally {
            fileInputStream.close();
        }
    }

    private static int indexOf(byte[] bArr, int i, int i2, byte b) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (bArr[i3] == b) {
                return i3;
            }
        }
        return -1;
    }
}

package com.ss.ttm.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: classes7.dex */
public class MemoryInfo {
    private static long[] mRomMemroy;
    private static long mTotalMemorySize;

    public static long[] getRomMemroy() {
        if (mRomMemroy == null) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mRomMemroy = new long[]{getTotalInternalMemorySize(), statFs.getBlockSize() * statFs.getAvailableBlocks()};
        }
        return mRomMemroy;
    }

    public static long getTotalInternalMemorySize() {
        if (mTotalMemorySize == 0) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mTotalMemorySize = statFs.getBlockCount() * statFs.getBlockSize();
        }
        return mTotalMemorySize;
    }

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x001b -> B:9:0x002d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getTolalMemory() {
        BufferedReader bufferedReader;
        String str = null;
        str = null;
        str = null;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8);
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        str = readLine != null ? readLine : null;
                        bufferedReader.close();
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim());
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        return Integer.parseInt(str.substring(str.indexOf(58) + 1, str.indexOf(107)).trim());
    }
}

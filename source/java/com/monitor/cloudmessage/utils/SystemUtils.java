package com.monitor.cloudmessage.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes7.dex */
public class SystemUtils {
    public static long getUseMemory() {
        return (Runtime.getRuntime().totalMemory() / 1024) / 1024;
    }

    public static long getTotalMemory() {
        return (Runtime.getRuntime().maxMemory() / 1024) / 1024;
    }

    public static long[] getSDCardMemory() {
        File externalRootDir;
        long[] jArr = new long[2];
        if (!"mounted".equals(Environment.getExternalStorageState()) || (externalRootDir = com.bytedance.apm.util.FileUtils.getExternalRootDir(ApmContext.getContext())) == null) {
            return jArr;
        }
        StatFs statFs = new StatFs(externalRootDir.getPath());
        long blockSize = statFs.getBlockSize();
        long blockCount = statFs.getBlockCount();
        long availableBlocks = statFs.getAvailableBlocks();
        jArr[0] = ((blockCount * blockSize) / 1024) / 1024;
        jArr[1] = ((blockSize * availableBlocks) / 1024) / 1024;
        return jArr;
    }

    public static String[] getVersion() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String[] strArr = {"null", "null", "null", "null"};
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/version");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused2) {
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            strArr[0] = bufferedReader.readLine().split("\\s+")[2];
            IOUtils.closeQuietly(bufferedReader);
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            IOUtils.closeQuietly(bufferedReader2);
            IOUtils.closeQuietly(fileReader);
            strArr[1] = Build.VERSION.RELEASE;
            strArr[2] = Build.MODEL;
            strArr[3] = Build.DISPLAY;
            return strArr;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            IOUtils.closeQuietly(bufferedReader2);
            IOUtils.closeQuietly(fileReader);
            throw th;
        }
        IOUtils.closeQuietly(fileReader);
        strArr[1] = Build.VERSION.RELEASE;
        strArr[2] = Build.MODEL;
        strArr[3] = Build.DISPLAY;
        return strArr;
    }

    public static String[] getCpuInfo() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String[] strArr = {"", ""};
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused2) {
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            String[] split = bufferedReader.readLine().split("\\s+");
            for (int i = 2; i < split.length; i++) {
                strArr[0] = strArr[0] + split[i] + " ";
            }
            strArr[1] = strArr[1] + bufferedReader.readLine().split("\\s+")[2];
            IOUtils.closeQuietly(bufferedReader);
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            IOUtils.closeQuietly(bufferedReader2);
            IOUtils.closeQuietly(fileReader);
            return strArr;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            IOUtils.closeQuietly(bufferedReader2);
            IOUtils.closeQuietly(fileReader);
            throw th;
        }
        IOUtils.closeQuietly(fileReader);
        return strArr;
    }
}

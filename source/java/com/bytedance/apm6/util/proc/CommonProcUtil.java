package com.bytedance.apm6.util.proc;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.apm6.util.IOUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class CommonProcUtil {
    public static final int BUFFER_SIZE = 8192;
    public static final String CACHE = "cache";
    public static final long DEFAULT_CLOCK_TICKS_PER_SECOND = 100;
    private static final int ERROR_RESULT = -1;
    public static final long KB = 1024;
    public static final String MEMORY_INFO_PATH = "/proc/meminfo";
    public static final String OUTSIDE_STORAGE = "/Android/data/";
    public static final String PROC_STAT_FILE = "/proc/stat";
    private static int isSysProcCanRead = 0;
    private static long sClkTck = -1;

    public static boolean isProcStatCanRead() {
        int i = isSysProcCanRead;
        if (i != 0) {
            return i == 1;
        }
        File file = new File("/proc/stat");
        if (file.exists() && file.canRead()) {
            isSysProcCanRead = 1;
            return true;
        }
        isSysProcCanRead = 2;
        return false;
    }

    public static long getTotalCPUTime() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                String[] split = readLine.split(" ");
                long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[5]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
                IOUtils.safeClose(bufferedReader2);
                return parseLong;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                IOUtils.safeClose(bufferedReader);
                return -1L;
            }
        } catch (Throwable unused2) {
        }
    }

    public static long getAppCPUTime() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                String[] split = readLine.split(" ");
                long parseLong = Long.parseLong(split[13]) + Long.parseLong(split[14]);
                IOUtils.safeClose(bufferedReader2);
                return parseLong;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                IOUtils.safeClose(bufferedReader);
                return -1L;
            }
        } catch (Throwable unused2) {
        }
    }

    public static long getAppCpuActiveTime() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                String[] split = readLine.split(" ");
                long parseLong = Long.parseLong(split[13]) + Long.parseLong(split[14]);
                IOUtils.safeClose(bufferedReader2);
                return parseLong;
            } catch (Exception unused) {
                bufferedReader = bufferedReader2;
                IOUtils.safeClose(bufferedReader);
                return -1L;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                IOUtils.safeClose(bufferedReader);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long getVmSize() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(getMyPid()))).trim().split(UpdateDialogNewBase.TYPE);
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        return Long.parseLong(matcher.group());
                    }
                }
            }
            if (split.length > 12) {
                Matcher matcher2 = Pattern.compile("\\d+").matcher(split[12]);
                if (matcher2.find()) {
                    return Long.parseLong(matcher2.group());
                }
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public static int getMyPid() {
        return Process.myPid();
    }

    public static String getStringFromFile(String str) throws Exception {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = convertStreamToString(fileInputStream);
                fileInputStream.close();
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static String convertStreamToString(InputStream inputStream) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine).append('\n');
                    } else {
                        bufferedReader2.close();
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long getIdleCPUTime() {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            long parseLong = Long.parseLong(readLine.split(" ")[5]);
            IOUtils.safeClose(bufferedReader);
            return parseLong;
        } catch (Exception unused2) {
            bufferedReader2 = bufferedReader;
            IOUtils.safeClose(bufferedReader2);
            return -1L;
        } catch (Throwable th3) {
            th = th3;
            IOUtils.safeClose(bufferedReader);
            throw th;
        }
    }

    public static long getTotalMemory(Context context) {
        if (context == null) {
            return -1L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem / 1024;
    }
}

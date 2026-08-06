package com.bytedance.apm.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.Logger;
import com.bytedance.monitor.util.IoUtil;
import com.bytedance.platform.godzilla.common.Constant;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CommonMonitorUtil {
    public static final int BUFFER_SIZE = 8192;
    public static final String CACHE = "cache";
    public static final long DEFAULT_CLOCK_TICKS_PER_SECOND = 100;
    private static final int ERROR_RESULT = -1;
    public static final long KB = 1024;
    public static final String MEMORY_INFO_PATH = "/proc/meminfo";
    public static final String OUTSIDE_STORAGE = "/Android/data/";
    private static final String PATH_PREFIX = "/sys/devices/system/cpu/cpu";
    private static final String PATH_SUFFIX = "/cpufreq/stats/time_in_state";
    public static final String PROC_STAT_FILE = "/proc/stat";
    private static int isSysProcCanRead = 0;
    private static long sClkTck = -1;
    private static int sCpuCoreNum = 0;
    private static long sMaxMemory = -1;

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
                IoUtil.safeClose(bufferedReader2);
                return parseLong;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                IoUtil.safeClose(bufferedReader);
                return -1L;
            }
        } catch (Throwable unused2) {
        }
    }

    public static long getTotalCPUTimeByTimeInStat() {
        int cpuCoreNum = getCpuCoreNum();
        long j = -1;
        if (cpuCoreNum <= 0) {
            return -1L;
        }
        for (int i = 0; i < cpuCoreNum; i++) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(PATH_PREFIX + i + PATH_SUFFIX), 50);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null && !readLine.isEmpty()) {
                            String[] split = readLine.split("\\s+");
                            if (split.length == 2) {
                                j += Long.parseLong(split[1]);
                            }
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
                try {
                    bufferedReader2.close();
                } catch (Throwable unused) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return j;
    }

    public static synchronized int getCpuCoreNum() {
        BufferedReader bufferedReader;
        Throwable th;
        synchronized (CommonMonitorUtil.class) {
            int i = sCpuCoreNum;
            if (i != 0) {
                return i;
            }
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 50);
                    int i2 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.startsWith("processor")) {
                                i2++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader == null) {
                                throw th;
                            }
                            bufferedReader.close();
                            throw th;
                        }
                    }
                    bufferedReader.close();
                    sCpuCoreNum = i2;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                }
            } catch (Throwable unused) {
            }
            return sCpuCoreNum;
        }
    }

    public static long getAppCPUTime() {
        return getPidCPUTime(Process.myPid());
    }

    public static long getPidCPUTime(int i) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i + "/stat")), 1000);
            try {
                String readLine = bufferedReader2.readLine();
                bufferedReader2.close();
                String[] split = readLine.split(" ");
                long parseLong = Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16]);
                IoUtil.safeClose(bufferedReader2);
                return parseLong;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                IoUtil.safeClose(bufferedReader);
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
                IoUtil.safeClose(bufferedReader2);
                return parseLong;
            } catch (Exception unused) {
                bufferedReader = bufferedReader2;
                IoUtil.safeClose(bufferedReader);
                return -1L;
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                IoUtil.safeClose(bufferedReader);
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
            IoUtil.safeClose(bufferedReader);
            return parseLong;
        } catch (Exception unused2) {
            bufferedReader2 = bufferedReader;
            IoUtil.safeClose(bufferedReader2);
            return -1L;
        } catch (Throwable th3) {
            th = th3;
            IoUtil.safeClose(bufferedReader);
            throw th;
        }
    }

    public static int getAPPMemLimit(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return -1;
        }
        return activityManager.getMemoryClass();
    }

    public static long getRuntimeMaxMemory() {
        if (sMaxMemory == -1) {
            try {
                sMaxMemory = Runtime.getRuntime().maxMemory();
            } catch (Exception unused) {
            }
        }
        return sMaxMemory;
    }

    public static int getPidMemorySize(int i, Context context) {
        if (context == null) {
            return -1;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return -1;
            }
            return activityManager.getProcessMemoryInfo(new int[]{i})[0].dalvikPss;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static Debug.MemoryInfo getPidMemoryInfo(int i, Context context) {
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            return activityManager.getProcessMemoryInfo(new int[]{i})[0];
        } catch (Exception unused) {
            return null;
        }
    }

    public static long getFreeMemory(Context context) {
        if (context == null) {
            return -1L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
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

    public static void getMemMonitorInfo(JSONObject jSONObject, Context context, int i) {
        ActivityManager activityManager;
        if (jSONObject == null || context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return;
        }
        Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{i});
        try {
            jSONObject.put("total_mem", getTotalMemory(context));
            jSONObject.put("mem_class", getAPPMemLimit(context));
            jSONObject.put("dalvik_used_mem", processMemoryInfo[0].dalvikPss / 1024);
            jSONObject.put("native_heap_size", processMemoryInfo[0].nativePss / 1024);
        } catch (JSONException unused) {
        }
    }

    public static long getUsedStorageSize(Context context) {
        File file;
        if (context == null) {
            return -1L;
        }
        try {
            file = new File(context.getFilesDir().getParent());
        } catch (Throwable unused) {
        }
        if (!file.exists()) {
            return -1L;
        }
        long fileDirSize = getFileDirSize(file);
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File parentFile = externalFilesDir.getParentFile();
            return fileDirSize + (parentFile.exists() ? getFileDirSize(parentFile) : 0L);
        }
        return -1L;
    }

    public static long getDiskTotalSize() {
        return getExternalStorageSize() + getFileTotalSize(Environment.getRootDirectory());
    }

    protected static long getExternalStorageSize() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return getFileTotalSize(FileUtils.getExternalRootDir(ApmContext.getContext()));
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long getFileTotalSize(File file) {
        try {
            return new StatFs(file.getPath()).getTotalBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long getFileDirSize(File file) {
        long length;
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = getFileDirSize(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    public static long getUsedCacheSize(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            if (TextUtils.isEmpty(context.getPackageName())) {
                return -1L;
            }
            File cacheDir = context.getCacheDir();
            long fileDirSize = cacheDir.exists() ? getFileDirSize(cacheDir) : 0L;
            File externalCacheDir = ApmContext.getContext().getExternalCacheDir();
            return fileDirSize + (externalCacheDir.exists() ? getFileDirSize(externalCacheDir) : 0L);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static Pair<Long, Long> getTrafficBytes(Context context) {
        int myUid = Process.myUid();
        Iterator<String> it = TrafficUtils.readFile2List(new File("/proc/net/xt_qtaguid/stats"), Constant.CHARSET_UTF_8).iterator();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        while (it.hasNext()) {
            String[] split = it.next().split(" ");
            try {
                if (myUid == Integer.parseInt(split[3])) {
                    long parseLong = Long.parseLong(split[5]);
                    long parseLong2 = Long.parseLong(split[7]);
                    if (Long.valueOf(split[4]).longValue() == 0) {
                        j3 += parseLong;
                        j4 += parseLong2;
                    } else {
                        j += parseLong;
                        j2 += parseLong2;
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        long j5 = j + j2;
        long j6 = j3 + j4;
        if (j5 < 0) {
            j5 = 0;
        }
        return new Pair<>(Long.valueOf(j5), Long.valueOf(j6 >= 0 ? j6 : 0L));
    }

    public static long getScClkTck(long j) {
        if (sClkTck == -1) {
            long sysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
            if (sysconf > 0) {
                j = sysconf;
            }
            sClkTck = j;
        }
        return sClkTck;
    }

    private static long fromLibcore(long j) {
        try {
            int i = Class.forName("libcore.io.OsConstants").getField("_SC_CLK_TCK").getInt(null);
            Class<?> cls = Class.forName("libcore.io.Libcore");
            Class<?> cls2 = Class.forName("libcore.io.Os");
            return ((Long) cls2.getMethod("sysconf", Integer.TYPE).invoke(cls.getField("os").get(null), Integer.valueOf(i))).longValue();
        } catch (Exception unused) {
            return j;
        }
    }

    public static LinkedList<ThreadTimeItem> getThreadInfo(int i) {
        return getThreadInfo(i, false, 0L);
    }

    public static LinkedList<ThreadTimeItem> getThreadInfo(int i, boolean z, long j) {
        BufferedReader bufferedReader;
        File[] listFiles = new File("/proc/" + i + "/task/").listFiles();
        LinkedList<ThreadTimeItem> linkedList = new LinkedList<>();
        BufferedReader bufferedReader2 = null;
        for (File file : listFiles) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file.getPath() + "/stat")), 1000);
            } catch (FileNotFoundException unused) {
                IoUtil.safeClose(bufferedReader2);
            } catch (Exception unused2) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                String readLine = bufferedReader.readLine();
                int lastIndexOf = readLine.lastIndexOf(41);
                String substring = readLine.substring(0, lastIndexOf);
                String substring2 = readLine.substring(lastIndexOf + 4);
                int indexOf = substring.indexOf(40);
                int intValue = Integer.valueOf(substring.substring(0, indexOf - 1)).intValue();
                String substring3 = substring.substring(indexOf + 1);
                String[] split = substring2.split(" ");
                long parseLong = Long.parseLong(split[10]);
                long parseLong2 = Long.parseLong(split[11]);
                long parseLong3 = Long.parseLong(split[18]);
                if (z && parseLong + parseLong2 > 0) {
                    ThreadTimeItem threadTimeItem = new ThreadTimeItem(intValue, substring3, parseLong, parseLong2, parseLong3);
                    if (intValue == Process.myPid() && j > 0 && threadTimeItem.startDuration > 2 * j) {
                        if (ApmContext.isDebugMode()) {
                            Logger.w("CommonMonitorUtil", "origin thread starttime error:" + threadTimeItem.startDuration + " new:" + j);
                        }
                        threadTimeItem.startDuration = j;
                        threadTimeItem.threadUsage = (((float) threadTimeItem.threadTime) * 1.0f) / ((float) threadTimeItem.startDuration);
                    }
                    linkedList.add(threadTimeItem);
                }
                IoUtil.safeClose(bufferedReader);
                bufferedReader2 = bufferedReader;
            } catch (Exception unused3) {
                bufferedReader2 = bufferedReader;
                IoUtil.safeClose(bufferedReader2);
                return null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                IoUtil.safeClose(bufferedReader2);
                throw th;
            }
        }
        return linkedList;
    }
}

package com.bytedance.crash.general;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.crash.Global;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.NpthLog;
import com.huawei.hms.utils.FileUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public class HardwareInfoHelper {
    private static final long DEFAULT_TICKS = 100;
    private static final String UNKNOWN = "unknown";

    public static long getJiffies() {
        return 1000 / getScClkTck();
    }

    private static long getScClkTck() {
        long sysconf = Os.sysconf(OsConstants._SC_CLK_TCK);
        if (sysconf > 0) {
            return sysconf;
        }
        return 100L;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0038 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuAbi() {
        StringBuilder sb;
        Exception e;
        String[] strArr;
        StringBuilder sb2 = new StringBuilder();
        try {
            strArr = Build.SUPPORTED_ABIS;
        } catch (Exception e2) {
            sb = sb2;
            e = e2;
        }
        if (strArr.length > 0) {
            sb = new StringBuilder();
            for (int i = 0; i < strArr.length; i++) {
                try {
                    sb.append(strArr[i]);
                    if (i != strArr.length - 1) {
                        sb.append(", ");
                    }
                } catch (Exception e3) {
                    e = e3;
                    NpthLog.w(e);
                    sb2 = sb;
                    String sb3 = sb2.toString();
                    if (!TextUtils.isEmpty(sb3)) {
                    }
                }
            }
            sb2 = sb;
        }
        String sb32 = sb2.toString();
        return !TextUtils.isEmpty(sb32) ? "unknown" : sb32;
    }

    public static String getCpuHardware() {
        return TextUtils.isEmpty(Build.HARDWARE) ? "unknown" : Build.HARDWARE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r0 = r1[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r2.close();
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        com.bytedance.crash.util.NpthLog.e(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0085 A[Catch: IOException -> 0x0081, TRY_LEAVE, TryCatch #3 {IOException -> 0x0081, blocks: (B:58:0x007d, B:51:0x0085), top: B:57:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCpuModel() {
        BufferedReader bufferedReader;
        String str;
        FileReader fileReader = null;
        try {
            try {
                FileReader fileReader2 = new FileReader("/proc/cpuinfo");
                try {
                    bufferedReader = new BufferedReader(fileReader2);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                fileReader2.close();
                                bufferedReader.close();
                                break;
                            }
                            if (readLine.contains(Constants.COLON_SEPARATOR)) {
                                String[] split = readLine.split(Constants.COLON_SEPARATOR);
                                if (split[0].contains("Hardware") || split[0].contains("model name")) {
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            e = e;
                            fileReader = fileReader2;
                            try {
                                NpthLog.e(e);
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                if (Build.BOARD != null) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (fileReader != null) {
                                    try {
                                        fileReader.close();
                                    } catch (IOException e2) {
                                        NpthLog.e(e2);
                                        throw th;
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileReader = fileReader2;
                            if (fileReader != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (IOException e4) {
                NpthLog.e(e4);
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
        return Build.BOARD != null ? "unknown" : Build.BOARD;
        return str;
    }

    public static String getVendorManufacturer() {
        return TextUtils.isEmpty(Build.MANUFACTURER) ? "unknown" : Build.MANUFACTURER;
    }

    public static String getVendorBrand() {
        return TextUtils.isEmpty(Build.BRAND) ? "unknown" : Build.BRAND;
    }

    public static String getVendorModel() {
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        return TextUtils.isEmpty(str2) ? str == null ? "unknown" : str : (str == null || str2.contains(str)) ? str2 : str + ' ' + str2;
    }

    public static String getDisplayResolution(DisplayMetrics displayMetrics) {
        return displayMetrics.heightPixels + "x" + displayMetrics.widthPixels;
    }

    public static int getDisplayDensityInt(DisplayMetrics displayMetrics) {
        return displayMetrics.densityDpi;
    }

    public static String getDisplayDensityStr(DisplayMetrics displayMetrics) {
        int i = displayMetrics.densityDpi;
        return i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
    }

    private static long getTotalMemorySizeFromFile() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"));
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine == null || !readLine.startsWith("MemTotal:")) {
                    FileSystemUtils.close(bufferedReader2);
                    return 0L;
                }
                long parseLong = Long.parseLong(readLine.substring(9).trim().split(" ")[0]) * 1024;
                FileSystemUtils.close(bufferedReader2);
                return parseLong;
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                FileSystemUtils.close(bufferedReader);
                return 0L;
            }
        } catch (Throwable unused2) {
        }
    }

    private static long getTotalMemorySizeFromActivityManager() {
        Context context = Global.getContext();
        if (context == null) {
            return 0L;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    static String sizeToTag(long j) {
        if (j <= 0) {
            return "Invalid";
        }
        long[] jArr = {256, 512, 1024, 2048, 3072, 4096, 5120, 6144, PlaybackStateCompat.ACTION_PLAY_FROM_URI, FileUtil.LOCAL_REPORT_FILE_MAX_SIZE, 12288, 16384, 24576, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID, 49152, PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, PlaybackStateCompat.ACTION_PREPARE_FROM_URI, PlaybackStateCompat.ACTION_SET_REPEAT_MODE, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, 1048576};
        String[] strArr = {"256MB", "512MB", "1GB", "2GB", "3GB", "4GB", "5GB", "6GB", "8GB", "10GB", "12GB", "16GB", "24GB", "32GB", "48GB", "64GB", "128GB", "256GB", "512GB", "1TB"};
        for (int i = 0; i < 20; i++) {
            if (j < jArr[i] * 1024 * 1024) {
                return strArr[i];
            }
        }
        return "1TB+";
    }

    public static String getRamSize() {
        long totalMemorySizeFromFile = getTotalMemorySizeFromFile();
        if (totalMemorySizeFromFile == 0) {
            totalMemorySizeFromFile = getTotalMemorySizeFromActivityManager();
        }
        return sizeToTag(totalMemorySizeFromFile);
    }
}

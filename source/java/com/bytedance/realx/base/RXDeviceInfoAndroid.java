package com.bytedance.realx.base;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.MatchResult;

/* loaded from: classes4.dex */
public class RXDeviceInfoAndroid {
    public static final int BUFFER_SIZE = 8192;
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.bytedance.realx.base.RXDeviceInfoAndroid.1
        @Override // java.io.FileFilter
        public boolean accept(File pathname) {
            String name = pathname.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };
    private static final String CPU_MANUFACTURER_PATTERN = "Hardware[\\s]*:[\\s]*([\\S\\s]*)\n";
    public static final int DEVICE_INFO_UNKNOWN = -1;
    private static final int ERROR_RESULT = -1;
    private static final String MEMORY_INFO_PATH = "/proc/meminfo";
    public static final String MEMTOTAL_PATTERN = "MemTotal[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";
    private static String RomVersion = "";
    private static final String TAG = "DeviceInfo";
    private static String sCpuModel = "";

    public static String getRomVersionName() {
        if (TextUtils.isEmpty(RomVersion)) {
            RomVersion = RXDeviceUtil.getPhoneSystem(Build.BRAND);
        }
        return RomVersion;
    }

    public static int getMemSize() {
        try {
            Context applicationContext = ContextUtils.getApplicationContext();
            if (applicationContext == null) {
                return -1;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService("activity");
            if (activityManager == null) {
                return -1;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return (int) Math.ceil((((memoryInfo.totalMem * 1.024d) / 1024.0d) / 1024.0d) / 1024.0d);
        } catch (Exception e) {
            e.printStackTrace();
            return (int) Math.ceil(((((-1) * 1.024d) / 1024.0d) / 1024.0d) / 1024.0d);
        }
    }

    public static int getNumberOfCPUCores() {
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            if (coresFromFileInfo != -1) {
                return coresFromFileInfo;
            }
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER);
            if (listFiles != null) {
                return listFiles.length;
            }
            return -1;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static int getCpuThreads() {
        return getNumberOfCPUCores();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Process, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String GetCpuModel() {
        Process process;
        StringBuilder sb;
        if (!sCpuModel.isEmpty()) {
            return sCpuModel;
        }
        String str = "";
        ?? r6 = 0;
        r6 = 0;
        try {
            try {
                process = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
                try {
                    r6 = process.getInputStream();
                    if (r6 != 0) {
                        Scanner scanner = new Scanner((InputStream) r6, "UTF-8");
                        if (scanner.findWithinHorizon(CPU_MANUFACTURER_PATTERN, 3000) != null) {
                            MatchResult match = scanner.match();
                            if (match.groupCount() > 0) {
                                try {
                                    str = match.group(1);
                                } catch (NumberFormatException e) {
                                    Log.i(TAG, "GetCpuModel NumberFormatException:" + e.getMessage());
                                }
                            }
                        }
                        scanner.close();
                    }
                    if (r6 != 0) {
                        try {
                            r6.close();
                        } catch (Exception e2) {
                            Log.i(TAG, "GetCpuModel close input stream fail:" + e2.getMessage());
                        }
                    }
                    if (process != null) {
                        try {
                            process.destroy();
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder("GetCpuModel close process fail:");
                            Log.i(TAG, sb.append(e.getMessage()).toString());
                            if (str.isEmpty()) {
                            }
                            sCpuModel = str;
                            return str;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    Log.i(TAG, "GetCpuModel IOException:" + e.getMessage());
                    if (r6 != 0) {
                        try {
                            r6.close();
                        } catch (Exception e5) {
                            Log.i(TAG, "GetCpuModel close input stream fail:" + e5.getMessage());
                        }
                    }
                    if (process != null) {
                        try {
                            process.destroy();
                        } catch (Exception e6) {
                            e = e6;
                            sb = new StringBuilder("GetCpuModel close process fail:");
                            Log.i(TAG, sb.append(e.getMessage()).toString());
                            if (str.isEmpty()) {
                                str = Build.SOC_MODEL;
                            }
                            sCpuModel = str;
                            return str;
                        }
                    }
                    if (str.isEmpty()) {
                    }
                    sCpuModel = str;
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        r6.close();
                    } catch (Exception e7) {
                        Log.i(TAG, "GetCpuModel close input stream fail:" + e7.getMessage());
                    }
                }
                if (0 == 0) {
                    try {
                        r6.destroy();
                        throw th;
                    } catch (Exception e8) {
                        Log.i(TAG, "GetCpuModel close process fail:" + e8.getMessage());
                        throw th;
                    }
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            process = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            if (0 == 0) {
            }
        }
        if (str.isEmpty() && Build.VERSION.SDK_INT >= 31) {
            str = Build.SOC_MODEL;
        }
        sCpuModel = str;
        return str;
    }

    public static String getCpuName() {
        String GetCpuModel = GetCpuModel();
        if (GetCpuModel == null || GetCpuModel.isEmpty()) {
            if (Build.VERSION.SDK_INT >= 31) {
                return Build.SOC_MODEL + ";" + Build.HARDWARE;
            }
            return Build.HARDWARE;
        }
        return GetCpuModel + ";" + Build.HARDWARE;
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    public static String getSystemDefaultLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getSdkVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getAppRootPath() {
        try {
            Context applicationContext = ContextUtils.getApplicationContext();
            return applicationContext == null ? "" : applicationContext.getFilesDir().getAbsolutePath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String GetDeviceBrand() {
        return Build.MANUFACTURER == null ? "" : Build.MANUFACTURER;
    }

    public static String GetDeviceModel() {
        return Build.MODEL == null ? "" : Build.MODEL;
    }

    public static int getCPUMaxFrequency() {
        int read;
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < getNumberOfCPUCores(); i3++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            read = fileInputStream.read(bArr);
                        } catch (NumberFormatException e) {
                            Log.e(TAG, "getCPUMaxFrequency failed!", e);
                        }
                        if (read == -1 || read > 128) {
                            throw new NumberFormatException();
                            break;
                        }
                        int i4 = 0;
                        while (Character.isDigit(bArr[i4]) && i4 < 128) {
                            i4++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i4, "UTF-8")));
                        if (valueOf.intValue() > i2) {
                            i2 = valueOf.intValue();
                        }
                    } finally {
                        fileInputStream.close();
                    }
                }
            } catch (IOException unused) {
            }
        }
        if (i2 == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int parseFileForValue = parseFileForValue("cpu MHz", fileInputStream2) * 1000;
                if (parseFileForValue > i2) {
                    i2 = parseFileForValue;
                }
                fileInputStream2.close();
            } catch (Throwable th) {
                fileInputStream2.close();
                throw th;
            }
        }
        i = i2;
        return i / 1000;
    }

    private static int parseFileForValue(String textToMatch, FileInputStream stream) {
        byte[] bArr = new byte[1024];
        try {
            int read = stream.read(bArr);
            int i = 0;
            while (i < read) {
                byte b = bArr[i];
                if (b == 10 || i == 0) {
                    if (b == 10) {
                        i++;
                    }
                    for (int i2 = i; i2 < read; i2++) {
                        int i3 = i2 - i;
                        if (bArr[i2] != textToMatch.charAt(i3)) {
                            break;
                        }
                        if (i3 == textToMatch.length() - 1) {
                            return extractValue(bArr, i2);
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private static int extractValue(byte[] buffer, int index) {
        byte b;
        while (index < buffer.length && (b = buffer[index]) != 10) {
            if (Character.isDigit(b)) {
                int i = index + 1;
                while (i < buffer.length && Character.isDigit(buffer[i])) {
                    i++;
                }
                return Integer.parseInt(new String(buffer, 0, index, i - index));
            }
            index++;
        }
        return -1;
    }

    public static String getGpuName() {
        String gPURenderer = GPUUtil.getGPURenderer();
        return gPURenderer == null ? "null-null" : gPURenderer;
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getAndroidBuildId() {
        return Build.ID;
    }

    public static String getBuildType() {
        return Build.TYPE;
    }

    public static String getBuildRelease() {
        return Build.VERSION.RELEASE;
    }

    private static int getCoresFromFileInfo(String fileLocation) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(fileLocation);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2, "UTF-8"));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int coresFromFileString = getCoresFromFileString(readLine);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return coresFromFileString;
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return -1;
                }
                try {
                    fileInputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int getCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        r7 = r1[1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0038, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x003c, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x003d, code lost:
    
        r6.printStackTrace();
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0045 -> B:22:0x0068). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getValueFromCpuInfoFile(String key, String defaultValue) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/cpuinfo");
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, Charset.defaultCharset()));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    if (readLine.contains(Constants.COLON_SEPARATOR)) {
                                        String[] split = readLine.split(Constants.COLON_SEPARATOR);
                                        if (split.length > 1 && split[0].contains(key)) {
                                            break;
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e = e;
                                bufferedReader = bufferedReader2;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return defaultValue;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                        throw th;
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                        throw th;
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } catch (Exception e7) {
            e = e7;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        return defaultValue;
        fileInputStream.close();
        return defaultValue;
    }
}

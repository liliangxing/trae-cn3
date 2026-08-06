package com.bytedance.crash.util;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
/* loaded from: classes3.dex */
public class Device {
    private static int cpuCores = -1;
    private static final Pattern cpu_nums_pattern = Pattern.compile("^0-([\\d]+)$");
    static boolean isMiui;
    private static boolean sIsInited;

    private Device() {
    }

    public static boolean isEmui(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getEmuiInfo();
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (TextUtils.isEmpty(str) || !(lowerCase.startsWith("emotionui") || lowerCase.startsWith("magicui"))) {
            return isHWDevice();
        }
        return true;
    }

    public static String getEmuiInfo() {
        return getSystemProperty("ro.build.version.emui");
    }

    public static boolean isHWDevice() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("hua")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("hua")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isMiui() {
        if (!sIsInited) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    isMiui = true;
                }
            } catch (Exception unused) {
            }
            sIsInited = true;
        }
        return isMiui;
    }

    public static boolean isFlyme() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    private static String getSystemProperty(String str) {
        return RomUtils.getSystemProperty(str);
    }

    public static int getCpuCoreNumbers() {
        int i = cpuCores;
        if (i > 0) {
            return i;
        }
        int cpuCoreNumberFromFile = getCpuCoreNumberFromFile("/sys/devices/system/cpu/possible");
        if (cpuCoreNumberFromFile <= 0) {
            cpuCoreNumberFromFile = getCpuCoreNumberFromFile("/sys/devices/system/cpu/present");
        }
        if (cpuCoreNumberFromFile <= 0) {
            cpuCoreNumberFromFile = getCpuCoreNumberFromCpuFiles("/sys/devices/system/cpu/");
        }
        if (cpuCoreNumberFromFile <= 0) {
            cpuCoreNumberFromFile = Runtime.getRuntime().availableProcessors();
        }
        if (cpuCoreNumberFromFile <= 0) {
            cpuCoreNumberFromFile = 1;
        }
        cpuCores = cpuCoreNumberFromFile;
        return cpuCoreNumberFromFile;
    }

    private static int getCpuCoreNumberFromFile(String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return -1;
                    }
                    bufferedReader2.close();
                    return -1;
                }
            } catch (Throwable unused2) {
            }
            if (readLine == null) {
                bufferedReader.close();
                return -1;
            }
            int cpuCoreNumberFromString = getCpuCoreNumberFromString(readLine);
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
            return cpuCoreNumberFromString;
        } catch (Throwable unused4) {
            return -1;
        }
    }

    private static int getCpuCoreNumberFromString(String str) {
        Matcher matcher = cpu_nums_pattern.matcher(str);
        if (matcher.matches()) {
            try {
                return Integer.parseInt(matcher.group(1)) + 1;
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    private static int getCpuCoreNumberFromCpuFiles(String str) {
        try {
            File[] listFiles = new File(str).listFiles(new FilenameFilter() { // from class: com.bytedance.crash.util.Device.1
                private final Pattern cpuFilePattern = Pattern.compile("^cpu[\\d]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return this.cpuFilePattern.matcher(str2).matches();
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                return -1;
            }
            return listFiles.length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}

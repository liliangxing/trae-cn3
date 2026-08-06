package com.apm.lite.k;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class d {
    private static boolean a = false;
    private static int b = -1;
    private static final Pattern c = Pattern.compile("^0-([\\d]+)$");

    public static String a() {
        return b("ro.build.version.emui");
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return b();
        }
        return true;
    }

    private static String b(String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            bufferedReader.close();
            k.a(bufferedReader);
            return str2;
        } catch (Throwable unused2) {
            k.a(bufferedReader);
            return str2;
        }
    }

    public static boolean b() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int c(String str) {
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
            } catch (IOException unused2) {
                return -1;
            }
        } catch (Throwable unused3) {
        }
        if (readLine == null) {
            bufferedReader.close();
            return -1;
        }
        int d = d(readLine);
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return d;
    }

    public static boolean c() {
        if (!a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.apm.lite.j.e.a = true;
                    a = true;
                    return com.apm.lite.j.e.a;
                }
            } catch (Exception unused) {
            }
            a = true;
        }
        return com.apm.lite.j.e.a;
    }

    private static int d(String str) {
        Matcher matcher = c.matcher(str);
        if (matcher.matches()) {
            try {
                return Integer.parseInt(matcher.group(1)) + 1;
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static boolean d() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static int e() {
        int i = b;
        if (i > 0) {
            return i;
        }
        int c2 = c("/sys/devices/system/cpu/possible");
        if (c2 <= 0) {
            c2 = c("/sys/devices/system/cpu/present");
        }
        if (c2 <= 0) {
            c2 = e("/sys/devices/system/cpu/");
        }
        if (c2 <= 0) {
            c2 = Runtime.getRuntime().availableProcessors();
        }
        if (c2 <= 0) {
            c2 = 1;
        }
        b = c2;
        return c2;
    }

    private static int e(String str) {
        try {
            File[] listFiles = new File(str).listFiles(new FilenameFilter() { // from class: com.apm.lite.k.d.1
                private final Pattern a = Pattern.compile("^cpu[\\d]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return this.a.matcher(str2).matches();
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

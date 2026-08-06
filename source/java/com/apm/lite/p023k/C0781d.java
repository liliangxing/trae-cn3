package com.apm.lite.p023k;

import android.os.Build;
import android.text.TextUtils;
import com.apm.lite.p022j.C0770e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.apm.lite.k.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0781d {

    /* renamed from: a */
    private static boolean f575a = false;

    /* renamed from: b */
    private static int f576b = -1;

    /* renamed from: c */
    private static final Pattern f577c = Pattern.compile("^0-([\\d]+)$");

    /* renamed from: a */
    public static String m760a() {
        return m762b("ro.build.version.emui");
    }

    /* renamed from: a */
    public static boolean m761a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = m760a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return m763b();
        }
        return true;
    }

    /* renamed from: b */
    private static String m762b(String str) {
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
            C0788k.m813a(bufferedReader);
            return str2;
        } catch (Throwable unused2) {
            C0788k.m813a(bufferedReader);
            return str2;
        }
    }

    /* renamed from: b */
    public static boolean m763b() {
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

    /* renamed from: c */
    private static int m764c(String str) {
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
        int m766d = m766d(readLine);
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return m766d;
    }

    /* renamed from: c */
    public static boolean m765c() {
        if (!f575a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    C0770e.f533a = true;
                    f575a = true;
                    return C0770e.f533a;
                }
            } catch (Exception unused) {
            }
            f575a = true;
        }
        return C0770e.f533a;
    }

    /* renamed from: d */
    private static int m766d(String str) {
        Matcher matcher = f577c.matcher(str);
        if (matcher.matches()) {
            try {
                return Integer.parseInt(matcher.group(1)) + 1;
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    /* renamed from: d */
    public static boolean m767d() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    /* renamed from: e */
    public static int m768e() {
        int i = f576b;
        if (i > 0) {
            return i;
        }
        int m764c = m764c("/sys/devices/system/cpu/possible");
        if (m764c <= 0) {
            m764c = m764c("/sys/devices/system/cpu/present");
        }
        if (m764c <= 0) {
            m764c = m769e("/sys/devices/system/cpu/");
        }
        if (m764c <= 0) {
            m764c = Runtime.getRuntime().availableProcessors();
        }
        if (m764c <= 0) {
            m764c = 1;
        }
        f576b = m764c;
        return m764c;
    }

    /* renamed from: e */
    private static int m769e(String str) {
        try {
            File[] listFiles = new File(str).listFiles(new FilenameFilter() { // from class: com.apm.lite.k.d.1

                /* renamed from: a */
                private final Pattern f578a = Pattern.compile("^cpu[\\d]+$");

                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return this.f578a.matcher(str2).matches();
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

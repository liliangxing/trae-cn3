package com.apm.lite.k;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes2.dex */
public class o {
    private static String a;
    private static File b;
    private static File c;
    private static File d;

    public static File a() {
        File file = c;
        return file == null ? d(com.apm.lite.e.g()) : file;
    }

    public static File a(Context context) {
        return new File(j(context), "apmlite/CrashLogJava");
    }

    public static File a(Context context, String str) {
        return new File(j(context) + "/apmlite/CrashCommonLog/" + str);
    }

    public static File a(File file) {
        return new File(file, "flog.txt");
    }

    public static File a(File file, String str) {
        return new File(file, file.getName() + str);
    }

    public static File a(String str) {
        return new File(a(com.apm.lite.e.g(), str), "fds.txt");
    }

    public static File b(Context context) {
        return new File(j(context), "apmlite/CrashLogSimple");
    }

    public static File b(Context context, String str) {
        return new File(j(context) + "/apmlite/CustomFile/" + str);
    }

    public static File b(File file) {
        return new File(file, "tombstone.txt");
    }

    public static File b(String str) {
        return new File(a(com.apm.lite.e.g(), str), "threads.txt");
    }

    public static String b() {
        return "anr_" + com.apm.lite.e.e();
    }

    public static File c(Context context) {
        return new File(j(context), "apmlite/RuntimeContext");
    }

    public static File c(File file) {
        return new File(file, "header.bin");
    }

    public static File c(String str) {
        return new File(a(com.apm.lite.e.g(), str), "meminfo.txt");
    }

    public static File d(Context context) {
        if (c == null) {
            if (context == null) {
                context = com.apm.lite.e.g();
            }
            c = new File(j(context), "apmlite/CrashLogNative");
        }
        return c;
    }

    public static File d(File file) {
        return new File(a(com.apm.lite.e.g(), file.getName()), "maps.txt");
    }

    public static File d(String str) {
        return new File(a(com.apm.lite.e.g(), str), "pthreads.txt");
    }

    public static File e(Context context) {
        if (d == null) {
            d = new File(j(context) + "/apmlite/CrashCommonLog/" + com.apm.lite.e.f());
        }
        return d;
    }

    public static File e(File file) {
        return new File(file, "callback.json");
    }

    public static File e(String str) {
        return new File(a(com.apm.lite.e.g(), str), "rountines.txt");
    }

    public static File f(Context context) {
        return new File(j(context), "apmlite/CrashCommonLog");
    }

    public static File f(File file) {
        return new File(file, "upload.json");
    }

    public static File f(String str) {
        return new File(a(com.apm.lite.e.g(), str), "leakd_threads.txt");
    }

    public static File g(Context context) {
        return new File(j(context), "apmlite/issueCrashTimes");
    }

    public static File g(File file) {
        return new File(file, "javastack.txt");
    }

    public static File h(Context context) {
        return new File(j(context) + "/apmlite/issueCrashTimes/current.times");
    }

    public static File h(File file) {
        return new File(a(com.apm.lite.e.g(), file.getName()), "logcat.txt");
    }

    public static File i(Context context) {
        return new File(j(context), "apmlite/alogCrash");
    }

    public static File i(File file) {
        return new File(a(com.apm.lite.e.g(), file.getName()), "fds.txt");
    }

    public static File j(File file) {
        return new File(a(com.apm.lite.e.g(), file.getName()), "threads.txt");
    }

    public static String j(Context context) {
        if (TextUtils.isEmpty(a)) {
            try {
                a = context.getFilesDir().getAbsolutePath();
            } catch (Exception e) {
                a = "/sdcard/";
                e.printStackTrace();
            }
        }
        return a;
    }

    public static File k(Context context) {
        return new File(j(context) + "/apmlite/CustomFile/" + com.apm.lite.e.f());
    }

    public static File k(File file) {
        return new File(a(com.apm.lite.e.g(), file.getName()), "meminfo.txt");
    }

    public static File l(Context context) {
        return new File(j(context), "apmlite/CustomFile");
    }

    public static File l(File file) {
        return new File(a(com.apm.lite.e.g(), file.getName()), "pthreads.txt");
    }

    public static File m(File file) {
        return new File(a(com.apm.lite.e.g(), file.getName()), "rountines.txt");
    }

    public static File n(File file) {
        return new File(a(com.apm.lite.e.g(), file.getName()), "leakd_threads.txt");
    }

    public static File o(File file) {
        return new File(file, "abortmsg.txt");
    }
}

package com.apm.lite.p023k;

import android.content.Context;
import android.text.TextUtils;
import com.apm.lite.C0749e;
import java.io.File;

/* renamed from: com.apm.lite.k.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0792o {

    /* renamed from: a */
    private static String f593a;

    /* renamed from: b */
    private static File f594b;

    /* renamed from: c */
    private static File f595c;

    /* renamed from: d */
    private static File f596d;

    /* renamed from: a */
    public static File m845a() {
        File file = f595c;
        return file == null ? m859d(C0749e.m565g()) : file;
    }

    /* renamed from: a */
    public static File m846a(Context context) {
        return new File(m875j(context), "apmlite/CrashLogJava");
    }

    /* renamed from: a */
    public static File m847a(Context context, String str) {
        return new File(m875j(context) + "/apmlite/CrashCommonLog/" + str);
    }

    /* renamed from: a */
    public static File m848a(File file) {
        return new File(file, "flog.txt");
    }

    /* renamed from: a */
    public static File m849a(File file, String str) {
        return new File(file, file.getName() + str);
    }

    /* renamed from: a */
    public static File m850a(String str) {
        return new File(m847a(C0749e.m565g(), str), "fds.txt");
    }

    /* renamed from: b */
    public static File m851b(Context context) {
        return new File(m875j(context), "apmlite/CrashLogSimple");
    }

    /* renamed from: b */
    public static File m852b(Context context, String str) {
        return new File(m875j(context) + "/apmlite/CustomFile/" + str);
    }

    /* renamed from: b */
    public static File m853b(File file) {
        return new File(file, "tombstone.txt");
    }

    /* renamed from: b */
    public static File m854b(String str) {
        return new File(m847a(C0749e.m565g(), str), "threads.txt");
    }

    /* renamed from: b */
    public static String m855b() {
        return "anr_" + C0749e.m563e();
    }

    /* renamed from: c */
    public static File m856c(Context context) {
        return new File(m875j(context), "apmlite/RuntimeContext");
    }

    /* renamed from: c */
    public static File m857c(File file) {
        return new File(file, "header.bin");
    }

    /* renamed from: c */
    public static File m858c(String str) {
        return new File(m847a(C0749e.m565g(), str), "meminfo.txt");
    }

    /* renamed from: d */
    public static File m859d(Context context) {
        if (f595c == null) {
            if (context == null) {
                context = C0749e.m565g();
            }
            f595c = new File(m875j(context), "apmlite/CrashLogNative");
        }
        return f595c;
    }

    /* renamed from: d */
    public static File m860d(File file) {
        return new File(m847a(C0749e.m565g(), file.getName()), "maps.txt");
    }

    /* renamed from: d */
    public static File m861d(String str) {
        return new File(m847a(C0749e.m565g(), str), "pthreads.txt");
    }

    /* renamed from: e */
    public static File m862e(Context context) {
        if (f596d == null) {
            f596d = new File(m875j(context) + "/apmlite/CrashCommonLog/" + C0749e.m564f());
        }
        return f596d;
    }

    /* renamed from: e */
    public static File m863e(File file) {
        return new File(file, "callback.json");
    }

    /* renamed from: e */
    public static File m864e(String str) {
        return new File(m847a(C0749e.m565g(), str), "rountines.txt");
    }

    /* renamed from: f */
    public static File m865f(Context context) {
        return new File(m875j(context), "apmlite/CrashCommonLog");
    }

    /* renamed from: f */
    public static File m866f(File file) {
        return new File(file, "upload.json");
    }

    /* renamed from: f */
    public static File m867f(String str) {
        return new File(m847a(C0749e.m565g(), str), "leakd_threads.txt");
    }

    /* renamed from: g */
    public static File m868g(Context context) {
        return new File(m875j(context), "apmlite/issueCrashTimes");
    }

    /* renamed from: g */
    public static File m869g(File file) {
        return new File(file, "javastack.txt");
    }

    /* renamed from: h */
    public static File m870h(Context context) {
        return new File(m875j(context) + "/apmlite/issueCrashTimes/current.times");
    }

    /* renamed from: h */
    public static File m871h(File file) {
        return new File(m847a(C0749e.m565g(), file.getName()), "logcat.txt");
    }

    /* renamed from: i */
    public static File m872i(Context context) {
        return new File(m875j(context), "apmlite/alogCrash");
    }

    /* renamed from: i */
    public static File m873i(File file) {
        return new File(m847a(C0749e.m565g(), file.getName()), "fds.txt");
    }

    /* renamed from: j */
    public static File m874j(File file) {
        return new File(m847a(C0749e.m565g(), file.getName()), "threads.txt");
    }

    /* renamed from: j */
    public static String m875j(Context context) {
        if (TextUtils.isEmpty(f593a)) {
            try {
                f593a = context.getFilesDir().getAbsolutePath();
            } catch (Exception e) {
                f593a = "/sdcard/";
                e.printStackTrace();
            }
        }
        return f593a;
    }

    /* renamed from: k */
    public static File m876k(Context context) {
        return new File(m875j(context) + "/apmlite/CustomFile/" + C0749e.m564f());
    }

    /* renamed from: k */
    public static File m877k(File file) {
        return new File(m847a(C0749e.m565g(), file.getName()), "meminfo.txt");
    }

    /* renamed from: l */
    public static File m878l(Context context) {
        return new File(m875j(context), "apmlite/CustomFile");
    }

    /* renamed from: l */
    public static File m879l(File file) {
        return new File(m847a(C0749e.m565g(), file.getName()), "pthreads.txt");
    }

    /* renamed from: m */
    public static File m880m(File file) {
        return new File(m847a(C0749e.m565g(), file.getName()), "rountines.txt");
    }

    /* renamed from: n */
    public static File m881n(File file) {
        return new File(m847a(C0749e.m565g(), file.getName()), "leakd_threads.txt");
    }

    /* renamed from: o */
    public static File m882o(File file) {
        return new File(file, "abortmsg.txt");
    }
}

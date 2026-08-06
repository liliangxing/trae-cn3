package com.apm.lite.p023k;

import com.apm.lite.C0749e;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.runtime.C0810a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* renamed from: com.apm.lite.k.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0783f {
    /* renamed from: a */
    public static File m770a(String str, int i, int i2) {
        File file = new File(C0792o.m847a(C0749e.m565g(), str), "logcat.txt");
        if (file.exists() && file.length() > 0) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.dumpLogcat(file.getAbsolutePath(), String.valueOf(i), String.valueOf(i2));
        return file;
    }

    /* renamed from: a */
    public static void m771a() {
        try {
            m770a(C0749e.m564f(), C0749e.m567i().getLogcatDumpCount(), C0749e.m567i().getLogcatLevel());
            if (C0749e.m577s()) {
                m772b();
                m774d();
                m773c();
                m775e();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static File m772b() {
        File file = new File(C0792o.m862e(C0749e.m565g()), "maps.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.dumpMaps(file.getAbsolutePath());
        return file;
    }

    /* renamed from: c */
    public static File m773c() {
        File file = new File(C0792o.m862e(C0749e.m565g()), "meminfo.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.dumpMemInfo(file.getAbsolutePath());
        return file;
    }

    /* renamed from: d */
    public static File m774d() {
        File file = new File(C0792o.m862e(C0749e.m565g()), "fds.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.dumpFds(file.getAbsolutePath());
        return file;
    }

    /* renamed from: e */
    public static File m775e() {
        File file = new File(C0792o.m862e(C0749e.m565g()), "threads.txt");
        if (file.exists()) {
            return file;
        }
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        NativeImpl.dumpThreads(file.getAbsolutePath());
        return file;
    }

    /* renamed from: f */
    public static File m776f() {
        BufferedWriter bufferedWriter;
        File file = new File(C0792o.m862e(C0749e.m565g()), "anr_trace.txt");
        if (file.exists() || !C0810a.m1027f()) {
            return file;
        }
        File file2 = new File("/data/anr/traces.txt");
        if (!file2.exists()) {
            return file;
        }
        BufferedReader bufferedReader = null;
        try {
            file.getParentFile().mkdirs();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                int i = 0;
                do {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        bufferedWriter.write(readLine);
                        bufferedWriter.write(10);
                        i += readLine.length();
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        C0788k.m813a(bufferedReader);
                        C0788k.m813a(bufferedWriter);
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        C0788k.m813a(bufferedReader);
                        C0788k.m813a(bufferedWriter);
                        throw th;
                    }
                } while (i < 1048576);
                C0788k.m813a(bufferedReader2);
            } catch (IOException unused2) {
                bufferedWriter = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = null;
            }
        } catch (IOException unused3) {
            bufferedWriter = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
        }
        C0788k.m813a(bufferedWriter);
        return file;
    }
}

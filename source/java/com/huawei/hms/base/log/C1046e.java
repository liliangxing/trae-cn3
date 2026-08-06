package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: LogRecord.java */
/* renamed from: com.huawei.hms.base.log.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1046e {

    /* renamed from: b */
    private String f1116b;

    /* renamed from: c */
    private String f1117c;

    /* renamed from: d */
    private int f1118d;

    /* renamed from: g */
    private String f1121g;

    /* renamed from: h */
    private int f1122h;

    /* renamed from: i */
    private int f1123i;

    /* renamed from: j */
    private int f1124j;

    /* renamed from: a */
    private final StringBuilder f1115a = new StringBuilder();

    /* renamed from: e */
    private long f1119e = 0;

    /* renamed from: f */
    private long f1120f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1046e(int i, String str, int i2, String str2) {
        this.f1117c = "HMS";
        this.f1124j = i;
        this.f1116b = str;
        this.f1118d = i2;
        if (str2 != null) {
            this.f1117c = str2;
        }
        m1053b();
    }

    /* renamed from: a */
    public static String m1051a(int i) {
        return i != 3 ? i != 4 ? i != 5 ? i != 6 ? String.valueOf(i) : "E" : "W" : "I" : "D";
    }

    /* renamed from: b */
    private C1046e m1053b() {
        this.f1119e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f1120f = currentThread.getId();
        this.f1122h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i = this.f1124j;
        if (length > i) {
            StackTraceElement stackTraceElement = stackTrace[i];
            this.f1121g = stackTraceElement.getFileName();
            this.f1123i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    /* renamed from: c */
    public String m1058c() {
        StringBuilder sb = new StringBuilder();
        m1054b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        m1054b(sb);
        m1052a(sb);
        return sb.toString();
    }

    /* renamed from: a */
    public <T> C1046e m1055a(T t) {
        this.f1115a.append(t);
        return this;
    }

    /* renamed from: a */
    public C1046e m1056a(Throwable th) {
        m1055a((C1046e) '\n').m1055a((C1046e) Log.getStackTraceString(th));
        return this;
    }

    /* renamed from: a */
    public String m1057a() {
        StringBuilder sb = new StringBuilder();
        m1052a(sb);
        return sb.toString();
    }

    /* renamed from: a */
    private StringBuilder m1052a(StringBuilder sb) {
        sb.append(' ').append(this.f1115a.toString());
        return sb;
    }

    /* renamed from: b */
    private StringBuilder m1054b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append('[');
        sb.append(simpleDateFormat.format(Long.valueOf(this.f1119e)));
        sb.append(' ').append(m1051a(this.f1118d)).append('/').append(this.f1117c).append('/').append(this.f1116b);
        sb.append(' ').append(this.f1122h).append(':').append(this.f1120f);
        sb.append(' ').append(this.f1121g).append(':').append(this.f1123i);
        sb.append(']');
        return sb;
    }
}

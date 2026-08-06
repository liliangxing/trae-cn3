package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: LogRecord.java */
/* loaded from: classes6.dex */
public class e {
    private String b;
    private String c;
    private int d;
    private String g;
    private int h;
    private int i;
    private int j;
    private final StringBuilder a = new StringBuilder();
    private long e = 0;
    private long f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, String str, int i2, String str2) {
        this.c = "HMS";
        this.j = i;
        this.b = str;
        this.d = i2;
        if (str2 != null) {
            this.c = str2;
        }
        b();
    }

    public static String a(int i) {
        return i != 3 ? i != 4 ? i != 5 ? i != 6 ? String.valueOf(i) : ExifInterface.LONGITUDE_EAST : ExifInterface.LONGITUDE_WEST : TextAttributes.INLINE_IMAGE_PLACEHOLDER : "D";
    }

    private e b() {
        this.e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f = currentThread.getId();
        this.h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i = this.j;
        if (length > i) {
            StackTraceElement stackTraceElement = stackTrace[i];
            this.g = stackTraceElement.getFileName();
            this.i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        a(sb);
        return sb.toString();
    }

    public <T> e a(T t) {
        this.a.append(t);
        return this;
    }

    public e a(Throwable th) {
        a((e) '\n').a((e) Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    private StringBuilder a(StringBuilder sb) {
        sb.append(' ').append(this.a.toString());
        return sb;
    }

    private StringBuilder b(StringBuilder sb) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(simpleDateFormat.format(Long.valueOf(this.e)));
        sb.append(' ').append(a(this.d)).append('/').append(this.c).append('/').append(this.b);
        sb.append(' ').append(this.h).append(AbstractJsonLexerKt.COLON).append(this.f);
        sb.append(' ').append(this.g).append(AbstractJsonLexerKt.COLON).append(this.i);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb;
    }
}

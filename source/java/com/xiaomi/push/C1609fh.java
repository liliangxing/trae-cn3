package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.xiaomi.push.fh */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1609fh extends Exception {

    /* renamed from: a */
    private C1618fq f1753a;

    /* renamed from: a */
    private C1619fr f1754a;

    /* renamed from: a */
    private Throwable f1755a;

    public C1609fh() {
        this.f1753a = null;
        this.f1754a = null;
        this.f1755a = null;
    }

    public C1609fh(String str) {
        super(str);
        this.f1753a = null;
        this.f1754a = null;
        this.f1755a = null;
    }

    public C1609fh(Throwable th) {
        this.f1753a = null;
        this.f1754a = null;
        this.f1755a = th;
    }

    public C1609fh(C1618fq c1618fq) {
        this.f1754a = null;
        this.f1755a = null;
        this.f1753a = c1618fq;
    }

    public C1609fh(String str, Throwable th) {
        super(str);
        this.f1753a = null;
        this.f1754a = null;
        this.f1755a = th;
    }

    /* renamed from: a */
    public Throwable m2560a() {
        return this.f1755a;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f1755a != null) {
            printStream.println("Nested Exception: ");
            this.f1755a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f1755a != null) {
            printWriter.println("Nested Exception: ");
            this.f1755a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        C1618fq c1618fq;
        C1619fr c1619fr;
        String message = super.getMessage();
        if (message != null || (c1619fr = this.f1754a) == null) {
            return (message != null || (c1618fq = this.f1753a) == null) ? message : c1618fq.toString();
        }
        return c1619fr.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        C1619fr c1619fr = this.f1754a;
        if (c1619fr != null) {
            sb.append(c1619fr);
        }
        C1618fq c1618fq = this.f1753a;
        if (c1618fq != null) {
            sb.append(c1618fq);
        }
        if (this.f1755a != null) {
            sb.append("\n  -- caused by: ").append(this.f1755a);
        }
        return sb.toString();
    }
}

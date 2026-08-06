package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes7.dex */
public class fh extends Exception {
    private fq a;

    /* renamed from: a, reason: collision with other field name */
    private fr f508a;

    /* renamed from: a, reason: collision with other field name */
    private Throwable f509a;

    public fh() {
        this.a = null;
        this.f508a = null;
        this.f509a = null;
    }

    public fh(String str) {
        super(str);
        this.a = null;
        this.f508a = null;
        this.f509a = null;
    }

    public fh(Throwable th) {
        this.a = null;
        this.f508a = null;
        this.f509a = th;
    }

    public fh(fq fqVar) {
        this.f508a = null;
        this.f509a = null;
        this.a = fqVar;
    }

    public fh(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f508a = null;
        this.f509a = th;
    }

    public Throwable a() {
        return this.f509a;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f509a != null) {
            printStream.println("Nested Exception: ");
            this.f509a.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f509a != null) {
            printWriter.println("Nested Exception: ");
            this.f509a.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        fq fqVar;
        fr frVar;
        String message = super.getMessage();
        if (message != null || (frVar = this.f508a) == null) {
            return (message != null || (fqVar = this.a) == null) ? message : fqVar.toString();
        }
        return frVar.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message).append(": ");
        }
        fr frVar = this.f508a;
        if (frVar != null) {
            sb.append(frVar);
        }
        fq fqVar = this.a;
        if (fqVar != null) {
            sb.append(fqVar);
        }
        if (this.f509a != null) {
            sb.append("\n  -- caused by: ").append(this.f509a);
        }
        return sb.toString();
    }
}

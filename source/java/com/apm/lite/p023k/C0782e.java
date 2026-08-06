package com.apm.lite.p023k;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* renamed from: com.apm.lite.k.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0782e extends PrintWriter {

    /* renamed from: a */
    private MessageDigest f579a;

    /* renamed from: b */
    private Charset f580b;

    /* renamed from: c */
    private a f581c;

    /* renamed from: com.apm.lite.k.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {
        /* renamed from: a */
        public boolean mo605a(String str) {
            return true;
        }
    }

    public C0782e(OutputStream outputStream, MessageDigest messageDigest, a aVar) {
        super(outputStream);
        this.f580b = null;
        this.f579a = messageDigest;
        this.f581c = aVar;
        if (messageDigest != null) {
            this.f580b = Charset.defaultCharset();
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int i) {
        super.write(i);
        MessageDigest messageDigest = this.f579a;
        if (messageDigest != null) {
            messageDigest.update((byte) i);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str, int i, int i2) {
        super.write(str, i, i2);
        if (this.f579a != null) {
            a aVar = this.f581c;
            if (aVar == null || aVar.mo605a(str)) {
                this.f579a.update(this.f580b.encode(CharBuffer.wrap(str, i, i2 + i)).array());
            }
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        super.write(cArr, i, i2);
        MessageDigest messageDigest = this.f579a;
        if (messageDigest != null) {
            messageDigest.update(this.f580b.encode(CharBuffer.wrap(cArr)).array());
        }
    }
}

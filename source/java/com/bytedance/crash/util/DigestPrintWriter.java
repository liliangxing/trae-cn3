package com.bytedance.crash.util;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class DigestPrintWriter extends PrintWriter {
    private Charset mCharset;
    private MessageDigest mDigest;
    private IShouldDigest mShouldDigest;

    /* loaded from: classes3.dex */
    public static class IShouldDigest {
        public boolean shouldDigest(String str) {
            return true;
        }
    }

    public DigestPrintWriter(Writer writer, MessageDigest messageDigest) {
        super(writer);
        this.mDigest = messageDigest;
        if (messageDigest != null) {
            this.mCharset = Charset.defaultCharset();
        }
    }

    public DigestPrintWriter(OutputStream outputStream, MessageDigest messageDigest, IShouldDigest iShouldDigest) {
        super(outputStream);
        this.mDigest = messageDigest;
        this.mShouldDigest = iShouldDigest;
        if (messageDigest != null) {
            this.mCharset = Charset.defaultCharset();
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        super.write(cArr, i, i2);
        MessageDigest messageDigest = this.mDigest;
        if (messageDigest != null) {
            messageDigest.update(this.mCharset.encode(CharBuffer.wrap(cArr)).array());
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(int i) {
        super.write(i);
        MessageDigest messageDigest = this.mDigest;
        if (messageDigest != null) {
            messageDigest.update((byte) i);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str, int i, int i2) {
        super.write(str, i, i2);
        if (this.mDigest != null) {
            IShouldDigest iShouldDigest = this.mShouldDigest;
            if (iShouldDigest == null || iShouldDigest.shouldDigest(str)) {
                this.mDigest.update(this.mCharset.encode(CharBuffer.wrap(str, i, i2 + i)).array());
            }
        }
    }

    public static String getMd5(String str) {
        return Digest.getMD5(str);
    }
}

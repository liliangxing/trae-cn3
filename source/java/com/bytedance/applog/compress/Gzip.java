package com.bytedance.applog.compress;

import com.bytedance.applog.log.LoggerImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public class Gzip {
    public static byte[] compress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(8192);
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                if (bArr != null) {
                    try {
                        gZIPOutputStream.write(bArr);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            LoggerImpl.global().error(14, "compress with gzip failed", th, new Object[0]);
                            return null;
                        } finally {
                            Utils.safeClose(gZIPOutputStream);
                            Utils.safeClose(byteArrayOutputStream);
                        }
                    }
                }
                Utils.safeClose(gZIPOutputStream);
                Utils.safeClose(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        LoggerImpl.global().error(14, "uncompress gzip failed", th, new Object[0]);
                        Utils.safeClose(gZIPInputStream);
                        Utils.safeClose(byteArrayInputStream);
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th3) {
                        Utils.safeClose(gZIPInputStream);
                        Utils.safeClose(byteArrayInputStream);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPInputStream = null;
            }
        } catch (Throwable th5) {
            byteArrayInputStream = null;
            th = th5;
            gZIPInputStream = null;
        }
        Utils.safeClose(gZIPInputStream);
        Utils.safeClose(byteArrayInputStream);
        return byteArrayOutputStream.toByteArray();
    }
}

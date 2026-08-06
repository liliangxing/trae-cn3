package com.bytedance.push.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;

/* loaded from: classes4.dex */
public class ZlibUtil {
    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";

    public static String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    public static String uncompressToString(byte[] bArr, String str) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr, 0, bArr.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            try {
                try {
                    byte[] bArr2 = new byte[1024];
                    while (!inflater.finished()) {
                        byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                byteArrayOutputStream.close();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        inflater.end();
        return new String(bArr);
    }
}

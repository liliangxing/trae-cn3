package com.ttnet.org.chromium.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes7.dex */
public class ByteArrayGenerator {
    public byte[] getBytes(int i) throws IOException, GeneralSecurityException {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream("/dev/urandom");
            try {
                byte[] bArr = new byte[i];
                if (i != fileInputStream2.read(bArr)) {
                    throw new GeneralSecurityException("Not enough random data available");
                }
                fileInputStream2.close();
                return bArr;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

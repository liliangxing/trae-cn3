package com.lynx.tasm.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes7.dex */
public class StringUtils {
    public static String streamToString(InputStream inputStream) {
        byte[] streamToBytes = streamToBytes(inputStream);
        if (streamToBytes == null) {
            return null;
        }
        return new String(streamToBytes);
    }

    public static byte[] streamToBytes(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 2048);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (IOException unused) {
                return null;
            }
        }
    }
}

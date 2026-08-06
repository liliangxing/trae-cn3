package com.bytedance.push.img;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
class Utils {
    private static final String WEBP_FILE_HEADER_RIFF = "RIFF";
    private static final int WEBP_FILE_HEADER_SIZE = 12;
    private static final String WEBP_FILE_HEADER_WEBP = "WEBP";

    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isWebPFile(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        return inputStream.read(bArr, 0, 12) == 12 && WEBP_FILE_HEADER_RIFF.equals(new String(bArr, 0, 4, "US-ASCII")) && WEBP_FILE_HEADER_WEBP.equals(new String(bArr, 8, 4, "US-ASCII"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}

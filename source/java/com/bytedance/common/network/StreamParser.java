package com.bytedance.common.network;

import com.bytedance.push.utils.Logger;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: classes3.dex */
public class StreamParser {
    public static final String CONTENT_TYPE_OCTET = "application/octet-stream";
    private static final int MAX_API_RESPONSE_LENGTH = 5242880;
    private static final String TAG = "NetworkUtils";

    public static boolean testIsSSBinary(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf("application/octet-stream");
        if (indexOf >= 0) {
            indexOf = str.indexOf("ssmix=", indexOf + 24);
        }
        return indexOf > 0;
    }

    public static void decodeSSBinary(byte[] bArr, int i) throws IOException {
        if (bArr == null || i <= 0) {
            return;
        }
        byte[] bArr2 = {-99, -114, Byte.MAX_VALUE, 90};
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % 4]);
        }
    }

    public static void safeClose(Closeable closeable) {
        safeClose(closeable, null);
    }

    private static void safeClose(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                if (!Logger.debug() || str == null) {
                    return;
                }
                Logger.d(TAG, str + " " + e);
            }
        }
    }

    public static byte[] response2buf(boolean z, int i, InputStream inputStream, int[] iArr, RequestHandler requestHandler) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] readResponse = readResponse(z, i, inputStream, iArr);
            if (readResponse == null || iArr[0] <= 0) {
                return null;
            }
            return readResponse;
        } catch (Exception e) {
            if (requestHandler != null) {
                try {
                    requestHandler.abort();
                } catch (Throwable unused) {
                }
            }
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
    
        if (r5 <= 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
    
        r11[0] = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0093, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0097, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readResponse(boolean z, int i, InputStream inputStream, int[] iArr) throws IOException {
        if (i <= 0) {
            i = 5242880;
        }
        if (i < 1048576) {
            i = 1048576;
        }
        if (inputStream == null) {
            return null;
        }
        if (z) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } finally {
                safeClose(inputStream);
            }
        }
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            try {
                if (i2 + 4096 > bArr.length) {
                    byte[] bArr2 = new byte[bArr.length * 2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    bArr = bArr2;
                }
                int read = inputStream.read(bArr, i2, 4096);
                if (read <= 0) {
                    break;
                }
                i2 += read;
                if (i > 0 && i2 > i) {
                    Logger.d(TAG, "entity length did exceed given maxLength");
                    return null;
                }
            } catch (EOFException e) {
                if (z && i2 > 0) {
                    Logger.d(TAG, "ungzip got exception " + e);
                } else {
                    throw e;
                }
            } catch (IOException e2) {
                String message = e2.getMessage();
                if (z && i2 > 0 && ("CRC mismatch".equals(message) || "Size mismatch".equals(message))) {
                    Logger.d(TAG, "ungzip got exception " + e2);
                } else {
                    throw e2;
                }
            }
        }
    }
}

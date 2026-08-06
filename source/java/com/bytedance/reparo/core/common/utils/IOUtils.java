package com.bytedance.reparo.core.common.utils;

import androidx.collection.SieveCacheKt;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public class IOUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final int EOF = -1;

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        long copyLarge = copyLarge(inputStream, outputStream);
        if (copyLarge > SieveCacheKt.NodeLinkMask) {
            return -1;
        }
        return (int) copyLarge;
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream) throws IOException {
        return copy(inputStream, outputStream, 4096);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        return copyLarge(inputStream, outputStream, new byte[i]);
    }

    public static long copyLarge(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }
}

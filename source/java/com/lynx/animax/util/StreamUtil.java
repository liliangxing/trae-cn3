package com.lynx.animax.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class StreamUtil {
    private static final int BUFFER_MAX_SIZE = 8192;
    private static final int BUFFER_MIN_SIZE = 1024;
    private static final String TAG = "AnimaXStreamUtil";

    public static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static void copyStreamImpl(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        while (true) {
            int read = inputStream.read(bArr, 0, i);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            AnimaXLog.e(TAG, "Failed to close resource: " + e);
        }
    }

    private static boolean copyStream(InputStream inputStream, OutputStream outputStream, int i) {
        try {
            try {
            } catch (IOException e) {
                AnimaXLog.e(TAG, "Failed to copy input stream to output stream, reason: " + e);
            }
            if (inputStream == null || outputStream == null) {
                AnimaXLog.e(TAG, "Invalid input stream or output stream");
                return false;
            }
            copyStreamImpl(inputStream, outputStream, clamp(i, 1024, 8192));
            closeQuietly(inputStream);
            closeQuietly(outputStream);
            return true;
        } finally {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
        }
    }

    private static int tryGetAvailableBytesFromInputStream(InputStream inputStream) {
        try {
            return inputStream.available();
        } catch (IOException unused) {
            return 0;
        }
    }

    public static byte[] getByteArrayFromInputStream(InputStream inputStream) {
        return getByteArrayFromInputStream(inputStream, tryGetAvailableBytesFromInputStream(inputStream));
    }

    public static byte[] getByteArrayFromInputStream(InputStream inputStream, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (copyStream(inputStream, byteArrayOutputStream, i)) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public static boolean saveFileFromInputStream(InputStream inputStream, String str) {
        return saveFileFromInputStream(inputStream, tryGetAvailableBytesFromInputStream(inputStream), str);
    }

    public static boolean saveFileFromInputStream(InputStream inputStream, int i, String str) {
        BufferedOutputStream bufferedOutputStream;
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        } catch (IOException unused) {
            AnimaXLog.e(TAG, "Failed to create FileOutputStream for file: " + str);
            bufferedOutputStream = null;
        }
        return copyStream(inputStream, bufferedOutputStream, i);
    }

    public static FileInputStream createFileInputStream(String str) {
        if (str == null || !new File(str).exists()) {
            return null;
        }
        try {
            return new FileInputStream(str);
        } catch (Exception e) {
            AnimaXLog.e(TAG, "createFileInputStream error: " + e);
            return null;
        }
    }
}

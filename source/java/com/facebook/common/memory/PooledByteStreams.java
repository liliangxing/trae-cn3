package com.facebook.common.memory;

import android.text.TextUtils;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import kotlin.UByte;

/* loaded from: classes6.dex */
public class PooledByteStreams {
    private static final int DEFAULT_TEMP_BUF_SIZE = 16384;
    private final ByteArrayPool mByteArrayPool;
    private final int mTempBufSize;

    public PooledByteStreams(ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 16384);
    }

    public PooledByteStreams(ByteArrayPool byteArrayPool, int i) {
        Preconditions.checkArgument(i > 0);
        this.mTempBufSize = i;
        this.mByteArrayPool = byteArrayPool;
    }

    public long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = this.mByteArrayPool.get(this.mTempBufSize);
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.mTempBufSize);
                if (read == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, read);
                j += read;
            } finally {
                this.mByteArrayPool.release(bArr);
            }
        }
    }

    public long copy(InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        long j2 = 0;
        Preconditions.checkState(j > 0);
        byte[] bArr = this.mByteArrayPool.get(this.mTempBufSize);
        while (j2 < j) {
            try {
                int read = inputStream.read(bArr, 0, (int) Math.min(this.mTempBufSize, j - j2));
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j2 += read;
            } finally {
                this.mByteArrayPool.release(bArr);
            }
        }
        return j2;
    }

    public long copy(InputStream inputStream, OutputStream outputStream, String str) throws IOException {
        MessageDigest messageDigest;
        byte[] bArr = this.mByteArrayPool.get(this.mTempBufSize);
        long j = 0;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Exception unused) {
            messageDigest = null;
        }
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, this.mTempBufSize);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                j += read;
                if (messageDigest != null && read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            } finally {
                this.mByteArrayPool.release(bArr);
            }
        }
        String bytesToHexString = messageDigest != null ? bytesToHexString(messageDigest.digest()) : null;
        if (TextUtils.isEmpty(bytesToHexString)) {
            FLog.w(getClass(), "the image md5 should not be null, you should check the image is valid or not");
        } else if (str == null) {
            FLog.w(getClass(), "the target md5 should not be null, you should check the md5 file has been remove or not");
        } else if (!str.equals(bytesToHexString)) {
            this.mByteArrayPool.release(bArr);
            return -1L;
        }
        return j;
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            int i = b & UByte.MAX_VALUE;
            if (i < 16) {
                sb.append(0);
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }
}

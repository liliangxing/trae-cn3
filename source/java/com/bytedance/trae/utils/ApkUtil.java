package com.bytedance.trae.utils;

import android.text.TextUtils;
import androidx.collection.SieveCacheKt;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class ApkUtil {
    public static final int APK_CHANNEL_BLOCK_ID = 1903654775;
    public static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    public static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    public static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    private static final int APK_SIG_BLOCK_MIN_SIZE = 32;
    public static final int APK_TRACE_INFO = 1903654776;
    public static final String DEFAULT_CHARSET = "UTF-8";
    private static final int UINT16_MAX_VALUE = 65535;
    private static final int ZIP_EOCD_COMMENT_LENGTH_FIELD_OFFSET = 20;
    private static final int ZIP_EOCD_REC_MIN_SIZE = 22;
    private static final int ZIP_EOCD_REC_SIG = 101010256;

    private ApkUtil() {
    }

    public static long getCommentLength(FileChannel fileChannel) throws IOException {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j = size - 22;
        long min = Math.min(j, 65535L);
        int i = 0;
        while (true) {
            long j2 = i;
            if (j2 <= min) {
                long j3 = j - j2;
                ByteBuffer allocate = ByteBuffer.allocate(4);
                fileChannel.position(j3);
                fileChannel.read(allocate);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                if (allocate.getInt(0) == ZIP_EOCD_REC_SIG) {
                    ByteBuffer allocate2 = ByteBuffer.allocate(2);
                    fileChannel.position(j3 + 20);
                    fileChannel.read(allocate2);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    short s = allocate2.getShort(0);
                    if (s == i) {
                        return s;
                    }
                }
                i++;
            } else {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
        }
    }

    public static long findCentralDirStartOffset(FileChannel fileChannel) throws IOException {
        return findCentralDirStartOffset(fileChannel, getCommentLength(fileChannel));
    }

    public static long findCentralDirStartOffset(FileChannel fileChannel, long j) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position((fileChannel.size() - j) - 6);
        fileChannel.read(allocate);
        return allocate.getInt(0);
    }

    public static Pair<ByteBuffer, Long> findApkSigningBlock(FileChannel fileChannel) throws IOException, SignatureNotFoundException {
        return findApkSigningBlock(fileChannel, findCentralDirStartOffset(fileChannel));
    }

    public static Pair<ByteBuffer, Long> findApkSigningBlock(FileChannel fileChannel, long j) throws IOException, SignatureNotFoundException {
        if (j < 32) {
            throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }
        fileChannel.position(j - 24);
        ByteBuffer allocate = ByteBuffer.allocate(24);
        fileChannel.read(allocate);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (allocate.getLong(8) != APK_SIG_BLOCK_MAGIC_LO || allocate.getLong(16) != APK_SIG_BLOCK_MAGIC_HI) {
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        long j2 = allocate.getLong(0);
        if (j2 < allocate.capacity() || j2 > 2147483639) {
            throw new SignatureNotFoundException("APK Signing Block size out of range: " + j2);
        }
        int i = (int) (8 + j2);
        long j3 = j - i;
        if (j3 < 0) {
            throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j3);
        }
        fileChannel.position(j3);
        ByteBuffer allocate2 = ByteBuffer.allocate(i);
        fileChannel.read(allocate2);
        allocate2.order(ByteOrder.LITTLE_ENDIAN);
        long j4 = allocate2.getLong(0);
        if (j4 != j2) {
            throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.of(allocate2, Long.valueOf(j3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        if (r0 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String findIdStringValue(String str, int i) {
        RandomAccessFile randomAccessFile;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(str, DownloadFileUtils.MODE_READ);
            try {
                Map<Integer, ByteBuffer> findIdValues = findIdValues(findApkSigningBlock(randomAccessFile.getChannel()).getFirst());
                if (findIdValues.containsKey(Integer.valueOf(i))) {
                    String str2 = new String(getBytes(findIdValues.get(Integer.valueOf(i))));
                    try {
                        randomAccessFile.close();
                    } catch (Throwable unused) {
                    }
                    return str2;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                } catch (Throwable th2) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        try {
            randomAccessFile.close();
        } catch (Throwable unused3) {
            return null;
        }
    }

    private static byte[] getBytes(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static Map<Integer, ByteBuffer> findIdValues(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        while (sliceFromTo.hasRemaining()) {
            i++;
            if (sliceFromTo.remaining() < 8) {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
            }
            long j = sliceFromTo.getLong();
            if (j < 4 || j > SieveCacheKt.NodeLinkMask) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int position = sliceFromTo.position() + i2;
            if (i2 > sliceFromTo.remaining()) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + sliceFromTo.remaining());
            }
            linkedHashMap.put(Integer.valueOf(sliceFromTo.getInt()), getByteBuffer(sliceFromTo, i2 - 4));
            sliceFromTo.position(position);
        }
        return linkedHashMap;
    }

    private static ByteBuffer sliceFromTo(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    private static ByteBuffer getByteBuffer(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i < 0) {
            throw new IllegalArgumentException("size: " + i);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    private static void checkByteOrderLittleEndian(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class Pair<A, B> {
        private final A mFirst;
        private final B mSecond;

        private Pair(A a, B b) {
            this.mFirst = a;
            this.mSecond = b;
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<>(a, b);
        }

        public A getFirst() {
            return this.mFirst;
        }

        public B getSecond() {
            return this.mSecond;
        }

        public int hashCode() {
            A a = this.mFirst;
            int hashCode = ((a == null ? 0 : a.hashCode()) + 31) * 31;
            B b = this.mSecond;
            return hashCode + (b != null ? b.hashCode() : 0);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            A a = this.mFirst;
            if (a == null) {
                if (pair.mFirst != null) {
                    return false;
                }
            } else if (!a.equals(pair.mFirst)) {
                return false;
            }
            B b = this.mSecond;
            if (b == null) {
                if (pair.mSecond != null) {
                    return false;
                }
            } else if (!b.equals(pair.mSecond)) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static class SignatureNotFoundException extends Exception {
        private static final long serialVersionUID = 1;

        public SignatureNotFoundException(String str) {
            super(str);
        }

        public SignatureNotFoundException(String str, Throwable th) {
            super(str, th);
        }
    }
}

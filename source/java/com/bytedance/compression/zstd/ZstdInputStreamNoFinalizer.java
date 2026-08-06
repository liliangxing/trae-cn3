package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class ZstdInputStreamNoFinalizer extends FilterInputStream {
    private static final int srcBuffSize;
    private final BufferPool bufferPool;
    private long dstPos;
    private boolean frameFinished;
    private boolean isClosed;
    private boolean isContinuous;
    private boolean needRead;
    private final byte[] src;
    private final ByteBuffer srcByteBuffer;
    private long srcPos;
    private long srcSize;
    private final long stream;

    private static native long createDStream();

    private native int decompressStream(long j, byte[] bArr, int i, byte[] bArr2, int i2);

    private static native int freeDStream(long j);

    private native int initDStream(long j);

    public static native long recommendedDInSize();

    public static native long recommendedDOutSize();

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    static {
        Native.load();
        srcBuffSize = (int) recommendedDInSize();
    }

    public ZstdInputStreamNoFinalizer(InputStream inputStream) throws IOException {
        this(inputStream, NoPool.INSTANCE);
    }

    public ZstdInputStreamNoFinalizer(InputStream inputStream, BufferPool bufferPool) throws IOException {
        super(inputStream);
        this.dstPos = 0L;
        this.srcPos = 0L;
        this.srcSize = 0L;
        this.needRead = true;
        this.isContinuous = false;
        this.frameFinished = true;
        this.isClosed = false;
        this.bufferPool = bufferPool;
        int i = srcBuffSize;
        ByteBuffer byteBuffer = bufferPool.get(i);
        this.srcByteBuffer = byteBuffer;
        if (byteBuffer == null) {
            throw new IOException("Cannot get ByteBuffer of size " + i + " from the BufferPool");
        }
        this.src = Zstd.extractArray(byteBuffer);
        synchronized (this) {
            long createDStream = createDStream();
            this.stream = createDStream;
            initDStream(createDStream);
        }
    }

    public synchronized ZstdInputStreamNoFinalizer setContinuous(boolean z) {
        this.isContinuous = z;
        return this;
    }

    public synchronized boolean getContinuous() {
        return this.isContinuous;
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(byte[] bArr) throws IOException {
        long loadDictDecompress = ZstdDecompress.loadDictDecompress(this.stream, bArr, bArr.length);
        if (Zstd.isError(loadDictDecompress)) {
            throw new IOException("Decompression error: " + Zstd.getErrorName(loadDictDecompress));
        }
        return this;
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(ZstdDictDecompress zstdDictDecompress) throws IOException {
        zstdDictDecompress.acquireSharedLock();
        try {
            long loadFastDictDecompress = ZstdDecompress.loadFastDictDecompress(this.stream, zstdDictDecompress);
            if (Zstd.isError(loadFastDictDecompress)) {
                throw new IOException("Decompression error: " + Zstd.getErrorName(loadFastDictDecompress));
            }
        } finally {
            zstdDictDecompress.releaseSharedLock();
        }
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        if (i >= 0) {
            if (i2 <= bArr.length - i) {
                int i3 = 0;
                if (i2 == 0) {
                    return 0;
                }
                while (i3 == 0) {
                    i3 = readInternal(bArr, i, i2);
                }
                return i3;
            }
        }
        throw new IndexOutOfBoundsException("Requested length " + i2 + " from offset " + i + " in buffer of size " + bArr.length);
    }

    int readInternal(byte[] bArr, int i, int i2) throws IOException {
        long j;
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (i < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("Requested length " + i2 + " from offset " + i + " in buffer of size " + bArr.length);
        }
        int i3 = i + i2;
        long j2 = i;
        this.dstPos = j2;
        long j3 = -1;
        while (true) {
            j = this.dstPos;
            long j4 = i3;
            if (j >= j4 || j3 >= j) {
                break;
            }
            if (this.needRead && (this.in.available() > 0 || this.dstPos == j2)) {
                long read = this.in.read(this.src, 0, srcBuffSize);
                this.srcSize = read;
                this.srcPos = 0L;
                if (read < 0) {
                    this.srcSize = 0L;
                    if (this.frameFinished) {
                        return -1;
                    }
                    if (this.isContinuous) {
                        long j5 = (int) (this.dstPos - j2);
                        this.srcSize = j5;
                        if (j5 > 0) {
                            return (int) j5;
                        }
                        return -1;
                    }
                    throw new IOException("Read error or truncated source");
                }
                this.frameFinished = false;
            }
            long j6 = this.dstPos;
            int decompressStream = decompressStream(this.stream, bArr, i3, this.src, (int) this.srcSize);
            long j7 = decompressStream;
            if (Zstd.isError(j7)) {
                throw new IOException("Decompression error: " + Zstd.getErrorName(j7));
            }
            if (decompressStream == 0) {
                this.frameFinished = true;
                this.needRead = this.srcPos == this.srcSize;
                return (int) (this.dstPos - j2);
            }
            if (this.dstPos < j4) {
                r14 = true;
            }
            this.needRead = r14;
            j3 = j6;
        }
        return (int) (j - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = new byte[1];
        int i = 0;
        while (i == 0) {
            i = readInternal(bArr, 0, 1);
        }
        if (i != 1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (!this.needRead) {
            return 1;
        }
        return this.in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (j <= 0) {
            return 0L;
        }
        int recommendedDOutSize = (int) recommendedDOutSize();
        if (recommendedDOutSize > j) {
            recommendedDOutSize = (int) j;
        }
        ByteBuffer byteBuffer = this.bufferPool.get(recommendedDOutSize);
        try {
            byte[] extractArray = Zstd.extractArray(byteBuffer);
            long j2 = j;
            while (j2 > 0) {
                int read = read(extractArray, 0, (int) Math.min(recommendedDOutSize, j2));
                if (read < 0) {
                    break;
                }
                j2 -= read;
            }
            return j - j2;
        } finally {
            this.bufferPool.release(byteBuffer);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.bufferPool.release(this.srcByteBuffer);
        freeDStream(this.stream);
        this.in.close();
    }
}

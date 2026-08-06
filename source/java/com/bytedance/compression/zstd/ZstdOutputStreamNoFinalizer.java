package com.bytedance.compression.zstd;

import com.bytedance.compression.zstd.util.Native;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class ZstdOutputStreamNoFinalizer extends FilterOutputStream {
    private static final int dstSize;
    private final BufferPool bufferPool;
    private boolean closeFrameOnFlush;
    private final byte[] dst;
    private final ByteBuffer dstByteBuffer;
    private long dstPos;
    private boolean frameClosed;
    private boolean isClosed;
    private long srcPos;
    private final long stream;

    private native int compressStream(long j, byte[] bArr, int i, byte[] bArr2, int i2);

    private static native long createCStream();

    private native int endStream(long j, byte[] bArr, int i);

    private native int flushStream(long j, byte[] bArr, int i);

    private static native int freeCStream(long j);

    public static native long recommendedCOutSize();

    private native int resetCStream(long j);

    static {
        Native.load();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream outputStream, int i) throws IOException {
        this(outputStream, NoPool.INSTANCE);
        ZstdCompress.setCompressionLevel(this.stream, i);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream outputStream) throws IOException {
        this(outputStream, NoPool.INSTANCE);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream outputStream, BufferPool bufferPool, int i) throws IOException {
        this(outputStream, bufferPool);
        ZstdCompress.setCompressionLevel(this.stream, i);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream outputStream, BufferPool bufferPool) throws IOException {
        super(outputStream);
        this.srcPos = 0L;
        this.dstPos = 0L;
        this.isClosed = false;
        this.closeFrameOnFlush = false;
        this.frameClosed = true;
        this.stream = createCStream();
        this.bufferPool = bufferPool;
        int i = dstSize;
        ByteBuffer byteBuffer = bufferPool.get(i);
        this.dstByteBuffer = byteBuffer;
        if (byteBuffer == null) {
            throw new IOException("Cannot get ByteBuffer of size " + i + " from the BufferPool");
        }
        this.dst = Zstd.extractArray(byteBuffer);
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean z) throws IOException {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        long compressionChecksums = ZstdCompress.setCompressionChecksums(this.stream, z);
        if (Zstd.isError(compressionChecksums)) {
            throw new IOException("Compression param: " + Zstd.getErrorName(compressionChecksums));
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        long compressionLevel = ZstdCompress.setCompressionLevel(this.stream, i);
        if (Zstd.isError(compressionLevel)) {
            throw new IOException("Compression param: " + Zstd.getErrorName(compressionLevel));
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        long compressionLong = ZstdCompress.setCompressionLong(this.stream, i);
        if (Zstd.isError(compressionLong)) {
            throw new IOException("Compression param: " + Zstd.getErrorName(compressionLong));
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        long compressionWorkers = ZstdCompress.setCompressionWorkers(this.stream, i);
        if (Zstd.isError(compressionWorkers)) {
            throw new IOException("Compression param: " + Zstd.getErrorName(compressionWorkers));
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean z) throws IOException {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        this.closeFrameOnFlush = z;
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] bArr) throws IOException {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        long loadDictCompress = ZstdCompress.loadDictCompress(this.stream, bArr, bArr.length);
        if (Zstd.isError(loadDictCompress)) {
            throw new IOException("Compression param: " + Zstd.getErrorName(loadDictCompress));
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress zstdDictCompress) throws IOException {
        if (!this.frameClosed) {
            throw new IOException("Change of parameter on initialized stream");
        }
        long loadFastDictCompress = ZstdCompress.loadFastDictCompress(this.stream, zstdDictCompress);
        if (Zstd.isError(loadFastDictCompress)) {
            throw new IOException("Compression param: " + Zstd.getErrorName(loadFastDictCompress));
        }
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (this.frameClosed) {
            long resetCStream = resetCStream(this.stream);
            if (Zstd.isError(resetCStream)) {
                throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(resetCStream));
            }
            this.frameClosed = false;
        }
        int i3 = i2 + i;
        this.srcPos = i;
        while (this.srcPos < i3) {
            long compressStream = compressStream(this.stream, this.dst, dstSize, bArr, i3);
            if (Zstd.isError(compressStream)) {
                throw new IOException("Compression error: " + Zstd.getErrorName(compressStream));
            }
            if (this.dstPos > 0) {
                this.out.write(this.dst, 0, (int) this.dstPos);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (com.bytedance.compression.zstd.Zstd.isError(r2) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r6.out.write(r6.dst, 0, (int) r6.dstPos);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r0 > 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        r6.frameClosed = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
    
        r6.out.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        throw new java.io.IOException("Compression error: " + com.bytedance.compression.zstd.Zstd.getErrorName(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
    
        r0 = flushStream(r6.stream, r6.dst, com.bytedance.compression.zstd.ZstdOutputStreamNoFinalizer.dstSize);
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if (com.bytedance.compression.zstd.Zstd.isError(r2) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
    
        r6.out.write(r6.dst, 0, (int) r6.dstPos);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (r0 > 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008b, code lost:
    
        throw new java.io.IOException("Compression error: " + com.bytedance.compression.zstd.Zstd.getErrorName(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        if (r6.closeFrameOnFlush != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        r0 = endStream(r6.stream, r6.dst, com.bytedance.compression.zstd.ZstdOutputStreamNoFinalizer.dstSize);
        r2 = r0;
     */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void flush() throws IOException {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (!this.frameClosed) {
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        close(true);
    }

    public synchronized void closeWithoutClosingParentStream() throws IOException {
        close(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (com.bytedance.compression.zstd.Zstd.isError(r2) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        r6.out.write(r6.dst, 0, (int) r6.dstPos);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (r1 > 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        throw new java.io.IOException("Compression error: " + com.bytedance.compression.zstd.Zstd.getErrorName(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r7 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        r6.out.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0008, code lost:
    
        if (r6.frameClosed == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000a, code lost:
    
        r1 = endStream(r6.stream, r6.dst, com.bytedance.compression.zstd.ZstdOutputStreamNoFinalizer.dstSize);
        r2 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void close(boolean z) throws IOException {
        if (this.isClosed) {
            return;
        }
        try {
        } finally {
            this.isClosed = true;
            this.bufferPool.release(this.dstByteBuffer);
            freeCStream(this.stream);
        }
    }
}

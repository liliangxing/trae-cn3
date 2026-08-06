package com.bytedance.pia.core.misc;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.UByte;

/* loaded from: classes4.dex */
public class CopyableInputStream extends InputStream {
    private static final int BLOCK_SIZE = 1024;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private int mark;
    private int position;
    private final InternalReader reader;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public CopyableInputStream(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public CopyableInputStream(InputStream inputStream, int i) {
        this(new InternalReader(inputStream, i).ref());
    }

    private CopyableInputStream(InternalReader internalReader) {
        this.position = 0;
        this.mark = 0;
        this.reader = internalReader;
    }

    public CopyableInputStream copy() {
        return new CopyableInputStream(this.reader.ref());
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.reader.isReleased()) {
            throw new IOException();
        }
        if (this.position >= this.reader.buffer.getEnd()) {
            this.reader.readMore();
        }
        if (this.reader.noMore() && this.position >= this.reader.buffer.getEnd()) {
            return -1;
        }
        ChunkedRingBuffer chunkedRingBuffer = this.reader.buffer;
        int i = this.position;
        this.position = i + 1;
        return chunkedRingBuffer.read(i) & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        bArr.getClass();
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        if (this.reader.isReleased()) {
            throw new IOException();
        }
        int min = Math.min(bArr.length - i, i2);
        int i3 = 0;
        while (i3 < min) {
            if (this.position >= this.reader.buffer.getEnd()) {
                if (i3 > 0) {
                    return i3;
                }
                if (this.reader.noMore()) {
                    return -1;
                }
                this.reader.readMore();
            }
            int read = this.reader.getBuffer().read(this.position, bArr, i + i3, min - i3);
            i3 += read;
            this.position += read;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int available() {
        return Math.max(this.reader.buffer.getEnd() - this.position, 2);
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.mark = this.position;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.position = this.mark;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.unRef();
    }

    /* loaded from: classes4.dex */
    private static final class InternalReader {
        private final ChunkedRingBuffer buffer;
        private final AtomicBoolean finished = new AtomicBoolean(false);
        private final AtomicInteger ref = new AtomicInteger(0);
        private final InputStream stream;

        public InternalReader(InputStream inputStream, int i) {
            this.buffer = new ChunkedRingBuffer(i);
            this.stream = inputStream;
        }

        public ChunkedRingBuffer getBuffer() {
            return this.buffer;
        }

        public int available() throws IOException {
            return this.stream.available();
        }

        public boolean noMore() {
            return this.finished.get();
        }

        public void readMore() throws IOException {
            if (this.finished.get()) {
                return;
            }
            int end = this.buffer.getEnd();
            synchronized (this.stream) {
                if (end < this.buffer.getEnd()) {
                    return;
                }
                int available = this.stream.available();
                if (available < 2) {
                    available = 1024;
                }
                byte[] bArr = new byte[Math.min(available, 1024)];
                while (true) {
                    int read = this.stream.read(bArr);
                    if (read == -1) {
                        this.finished.set(true);
                        break;
                    } else {
                        getBuffer().write(bArr, read);
                        if (read != 0) {
                            break;
                        }
                    }
                }
            }
        }

        public InternalReader ref() {
            this.ref.incrementAndGet();
            return this;
        }

        public void unRef() throws IOException {
            if (this.ref.decrementAndGet() <= 0) {
                this.stream.close();
                ChunkedRingBuffer chunkedRingBuffer = this.buffer;
                chunkedRingBuffer.clear(chunkedRingBuffer.getEnd());
            }
        }

        public boolean isReleased() {
            return this.ref.get() <= 0;
        }
    }
}

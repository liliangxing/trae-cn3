package com.bytedance.apm.agent.instrumentation.io;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class CInputStreamPParent extends InputStream implements StreamCompleteListenerSource {
    protected static final int DEFAULT_LIMIT_OF_RESPONSE_BODY_BYTES = 2048;
    protected static final AgentLog sLog = AgentLogManager.getAgentLog();
    protected final ByteBuffer buf;
    protected long c;
    protected boolean cac;
    protected final StreamCompleteListenerManager callback;
    protected final InputStream impl;

    public String getBufferAsString() {
        String str;
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null) {
            return "";
        }
        synchronized (byteBuffer) {
            byte[] bArr = new byte[this.buf.limit()];
            for (int i = 0; i < this.buf.limit(); i++) {
                bArr[i] = this.buf.get(i);
            }
            str = new String(bArr);
        }
        return str;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.cac) {
            synchronized (this.buf) {
                if (isBufferLargerThan(j)) {
                    this.buf.position((int) j);
                    this.c += j;
                    return j;
                }
                j -= this.buf.remaining();
                if (j > 0) {
                    ByteBuffer byteBuffer = this.buf;
                    byteBuffer.position(byteBuffer.remaining());
                } else {
                    throw new IOException("Failed to partial read from buffer (skip)");
                }
            }
        }
        try {
            long skip = this.impl.skip(j);
            this.c += skip;
            return skip;
        } catch (IOException e) {
            notifyError(e);
            throw e;
        }
    }

    private boolean isBufferEmpty() {
        return !this.buf.hasRemaining();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = 0;
        if (this.cac) {
            synchronized (this.buf) {
                if (isBufferLargerThan(i2)) {
                    int readBuffer = readBuffer(bArr, i, i2);
                    if (readBuffer >= 0) {
                        this.c += readBuffer;
                        return readBuffer;
                    }
                    throw new IOException("Failed to readBuffer()");
                }
                int remaining = this.buf.remaining();
                if (remaining > 0) {
                    i3 = readBuffer(bArr, i, remaining);
                    if (i3 < 0) {
                        throw new IOException("Failed to partial read from buffer");
                    }
                    i2 -= i3;
                    this.c += i3;
                } else {
                    i3 = 0;
                }
            }
        } else {
            i3 = 0;
        }
        try {
            InputStream inputStream = this.impl;
            if (inputStream != null) {
                i4 = inputStream.read(bArr, i + i3, i2);
            }
            if (i4 >= 0) {
                this.c += i4;
                return i4 + i3;
            }
            if (i3 > 0) {
                return i3;
            }
            notifyComplete();
            return i4;
        } catch (IOException e) {
            notifyError(e);
            throw e;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            InputStream inputStream = this.impl;
            if (inputStream != null) {
                inputStream.close();
            }
            notifyComplete();
        } catch (IOException e) {
            notifyError(e);
            throw e;
        }
    }

    private void notifyError(Exception exc) {
        if (this.callback.isComplete()) {
            return;
        }
        this.callback.notifyStreamError(new StreamCompleteEvent(this, this.c, exc));
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (markSupported()) {
            this.impl.mark(i);
        }
    }

    public void fillBuffer() {
        int i;
        ByteBuffer byteBuffer = this.buf;
        if (byteBuffer == null || !byteBuffer.hasArray()) {
            return;
        }
        synchronized (this.buf) {
            try {
                i = this.impl.read(this.buf.array(), 0, this.buf.capacity());
            } catch (IOException e) {
                sLog.error(e.toString());
                i = 0;
            }
            if (i <= 0) {
                this.buf.limit(0);
            } else if (i < this.buf.capacity()) {
                this.buf.limit(i);
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        try {
            return (this.cac ? this.buf.remaining() : 0) + this.impl.available();
        } catch (IOException e) {
            notifyError(e);
            throw e;
        }
    }

    public CInputStreamPParent(InputStream inputStream) {
        this(inputStream, false);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        if (markSupported()) {
            try {
                this.impl.reset();
            } catch (IOException e) {
                notifyError(e);
                throw e;
            }
        }
    }

    private void notifyComplete() {
        if (this.callback.isComplete()) {
            return;
        }
        this.callback.notifyStreamComplete(new StreamCompleteEvent(this, this.c));
    }

    private int readBuffer() {
        if (isBufferEmpty()) {
            return -1;
        }
        return this.buf.get();
    }

    private int readBuffer(byte[] bArr) {
        return readBuffer(bArr, 0, bArr.length);
    }

    private int readBuffer(byte[] bArr, int i, int i2) {
        if (isBufferEmpty()) {
            return -1;
        }
        int remaining = this.buf.remaining();
        this.buf.get(bArr, i, i2);
        return remaining - this.buf.remaining();
    }

    private boolean isBufferLargerThan(long j) {
        return ((long) this.buf.remaining()) >= j;
    }

    public CInputStreamPParent(InputStream inputStream, boolean z) {
        this.c = 0L;
        this.callback = new StreamCompleteListenerManager();
        this.impl = inputStream;
        this.cac = z;
        this.buf = !z ? null : ByteBuffer.allocate(2048);
        fillBuffer();
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void removeStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.callback.removeStreamCompleteListener(streamCompleteListener);
    }
}

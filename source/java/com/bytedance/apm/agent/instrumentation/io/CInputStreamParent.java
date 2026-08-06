package com.bytedance.apm.agent.instrumentation.io;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class CInputStreamParent extends CInputStreamPParent {
    private boolean isEmpty() {
        return !this.buf.hasRemaining();
    }

    protected void callError(Exception exc) {
        if (this.callback.isComplete()) {
            return;
        }
        this.callback.notifyStreamError(new StreamCompleteEvent(this, this.c, exc));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        if (this.cac) {
            synchronized (this.buf) {
                if (bufLT(length)) {
                    int rb = rb(bArr);
                    if (rb >= 0) {
                        this.c += rb;
                        return rb;
                    }
                    throw new IOException("CountingInputStream wrong");
                }
                int remaining = this.buf.remaining();
                if (remaining > 0) {
                    i = rb(bArr, 0, remaining);
                    if (i < 0) {
                        throw new IOException("CountingInputStream wrong2");
                    }
                    length -= i;
                    this.c += i;
                }
            }
        }
        try {
            int read = this.impl.read(bArr, i, length);
            if (read >= 0) {
                this.c += read;
                return read + i;
            }
            if (i > 0) {
                return i;
            }
            callComplete();
            return read;
        } catch (IOException e) {
            sLog.error(e.toString());
            if (ApmContext.isDebugMode()) {
                Logger.i("APM-Counting", "notify system err: " + e);
                e.printStackTrace();
            }
            callError(e);
            throw e;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.impl.markSupported();
    }

    public CInputStreamParent(InputStream inputStream) {
        this(inputStream, false);
    }

    protected void callComplete() {
        if (this.callback.isComplete()) {
            return;
        }
        this.callback.notifyStreamComplete(new StreamCompleteEvent(this, this.c));
    }

    protected int rb() {
        if (isEmpty()) {
            return -1;
        }
        return this.buf.get();
    }

    private int rb(byte[] bArr) {
        return rb(bArr, 0, bArr.length);
    }

    private int rb(byte[] bArr, int i, int i2) {
        if (isEmpty()) {
            return -1;
        }
        int remaining = this.buf.remaining();
        this.buf.get(bArr, i, i2);
        return remaining - this.buf.remaining();
    }

    protected boolean bufLT(long j) {
        return ((long) this.buf.remaining()) >= j;
    }

    public CInputStreamParent(InputStream inputStream, boolean z) {
        super(inputStream, z);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.cac) {
            synchronized (this.buf) {
                if (bufLT(1L)) {
                    int rb = rb();
                    if (rb >= 0) {
                        this.c++;
                    }
                    return rb;
                }
            }
        }
        try {
            int read = this.impl.read();
            if (read >= 0) {
                this.c++;
            } else {
                callComplete();
            }
            return read;
        } catch (IOException e) {
            callError(e);
            throw e;
        }
    }

    public void setBufferingEnabled(boolean z) {
        this.cac = z;
    }

    @Override // com.bytedance.apm.agent.instrumentation.io.StreamCompleteListenerSource
    public void addStreamCompleteListener(StreamCompleteListener streamCompleteListener) {
        this.callback.addStreamCompleteListener(streamCompleteListener);
    }
}

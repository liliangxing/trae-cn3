package com.ttnet.org.chromium.net.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CronetInputStream extends InputStream {
    private static final int READ_BUFFER_SIZE = 32768;
    private static final int READ_BUFFER_SIZE_MIN = 8192;
    private ByteBuffer mBuffer;
    protected IOException mException;
    protected final CronetHttpURLConnection mHttpURLConnection;
    private boolean mResponseDataCompleted;

    public CronetInputStream(CronetHttpURLConnection cronetHttpURLConnection) {
        this.mHttpURLConnection = cronetHttpURLConnection;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        getMoreDataIfNeeded();
        if (hasUnreadData()) {
            return this.mBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        getMoreDataIfNeeded();
        if (!hasUnreadData()) {
            return -1;
        }
        int min = Math.min(this.mBuffer.limit() - this.mBuffer.position(), i2);
        this.mBuffer.get(bArr, i, min);
        return min;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.mResponseDataCompleted) {
            IOException iOException = this.mException;
            if (iOException == null) {
                return 0;
            }
            throw iOException;
        }
        if (hasUnreadData()) {
            return this.mBuffer.remaining();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        CronetHttpURLConnection cronetHttpURLConnection = this.mHttpURLConnection;
        if (cronetHttpURLConnection != null) {
            cronetHttpURLConnection.disconnect();
        }
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setResponseDataCompleted(IOException iOException) {
        this.mException = iOException;
        this.mResponseDataCompleted = true;
        this.mBuffer = null;
    }

    private void getMoreDataIfNeeded() throws IOException {
        if (this.mResponseDataCompleted) {
            IOException iOException = this.mException;
            if (iOException != null) {
                throw iOException;
            }
        } else {
            if (hasUnreadData()) {
                return;
            }
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(this.mHttpURLConnection.getInputStreamBufferSize() >= 8192 ? this.mHttpURLConnection.getInputStreamBufferSize() : 32768);
            }
            this.mBuffer.clear();
            this.mHttpURLConnection.getMoreData(this.mBuffer);
            IOException iOException2 = this.mException;
            if (iOException2 != null) {
                throw iOException2;
            }
            ByteBuffer byteBuffer = this.mBuffer;
            if (byteBuffer != null) {
                byteBuffer.flip();
            }
        }
    }

    private boolean hasUnreadData() {
        ByteBuffer byteBuffer = this.mBuffer;
        return byteBuffer != null && byteBuffer.hasRemaining();
    }
}

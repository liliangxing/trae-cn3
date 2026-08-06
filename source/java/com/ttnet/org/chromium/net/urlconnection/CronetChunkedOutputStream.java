package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.net.UploadDataProvider;
import com.ttnet.org.chromium.net.UploadDataSink;
import java.io.IOException;
import java.net.HttpRetryException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class CronetChunkedOutputStream extends CronetOutputStream {
    private final ByteBuffer mBuffer;
    private final CronetHttpURLConnection mConnection;
    private boolean mLastChunk;
    private final MessageLoop mMessageLoop;
    private final UploadDataProvider mUploadDataProvider = new UploadDataProviderImpl();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void checkReceivedEnoughContent() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public void setConnected() throws IOException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CronetChunkedOutputStream(CronetHttpURLConnection cronetHttpURLConnection, int i, MessageLoop messageLoop) {
        cronetHttpURLConnection.getClass();
        if (i <= 0) {
            throw new IllegalArgumentException("chunkLength should be greater than 0");
        }
        this.mBuffer = ByteBuffer.allocate(i);
        this.mConnection = cronetHttpURLConnection;
        this.mMessageLoop = messageLoop;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        ensureBufferHasRemaining();
        this.mBuffer.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        checkNotClosed();
        if (bArr.length - i < i2 || i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        while (i3 > 0) {
            int min = Math.min(i3, this.mBuffer.remaining());
            this.mBuffer.put(bArr, (i + i2) - i3, min);
            i3 -= min;
            ensureBufferHasRemaining();
        }
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        if (this.mLastChunk) {
            return;
        }
        this.mLastChunk = true;
        this.mBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ttnet.org.chromium.net.urlconnection.CronetOutputStream
    public UploadDataProvider getUploadDataProvider() {
        return this.mUploadDataProvider;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class UploadDataProviderImpl extends UploadDataProvider {
        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public long getLength() {
            return -1L;
        }

        private UploadDataProviderImpl() {
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void read(UploadDataSink uploadDataSink, ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() >= CronetChunkedOutputStream.this.mBuffer.remaining()) {
                byteBuffer.put(CronetChunkedOutputStream.this.mBuffer);
                CronetChunkedOutputStream.this.mBuffer.clear();
                uploadDataSink.onReadSucceeded(CronetChunkedOutputStream.this.mLastChunk);
                if (CronetChunkedOutputStream.this.mLastChunk) {
                    return;
                }
                CronetChunkedOutputStream.this.mMessageLoop.quit();
                return;
            }
            int limit = CronetChunkedOutputStream.this.mBuffer.limit();
            CronetChunkedOutputStream.this.mBuffer.limit(CronetChunkedOutputStream.this.mBuffer.position() + byteBuffer.remaining());
            byteBuffer.put(CronetChunkedOutputStream.this.mBuffer);
            CronetChunkedOutputStream.this.mBuffer.limit(limit);
            uploadDataSink.onReadSucceeded(false);
        }

        @Override // com.ttnet.org.chromium.net.UploadDataProvider
        public void rewind(UploadDataSink uploadDataSink) {
            uploadDataSink.onRewindError(new HttpRetryException("Cannot retry streamed Http body", -1));
        }
    }

    private void ensureBufferHasRemaining() throws IOException {
        if (this.mBuffer.hasRemaining()) {
            return;
        }
        uploadBufferInternal();
    }

    private void executeMessageLoop(int i) throws IOException {
        try {
            this.mMessageLoop.loop(i);
        } catch (SocketTimeoutException unused) {
            CronetHttpURLConnection cronetHttpURLConnection = this.mConnection;
            if (cronetHttpURLConnection != null) {
                cronetHttpURLConnection.onUploadTimeout();
                this.mMessageLoop.reset();
                this.mMessageLoop.loop(i / 2);
            }
        } catch (Exception e) {
            CronetHttpURLConnection cronetHttpURLConnection2 = this.mConnection;
            if (cronetHttpURLConnection2 != null) {
                cronetHttpURLConnection2.cancelWithException("Unexpected request usage, caught in CronetChunkedOutputStream", e);
                this.mMessageLoop.reset();
                this.mMessageLoop.loop(i / 2);
            }
        }
    }

    private void uploadBufferInternal() throws IOException {
        checkNotClosed();
        this.mBuffer.flip();
        executeMessageLoop(this.mConnection.getReadTimeout());
        checkNoException();
    }
}

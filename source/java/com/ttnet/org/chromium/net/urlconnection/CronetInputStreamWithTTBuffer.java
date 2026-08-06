package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class CronetInputStreamWithTTBuffer extends CronetInputStream {
    private static final int MAX_LENGTH = 5242880;
    private boolean mReadDone;
    private TTBuffer mTTBuffer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CronetInputStreamWithTTBuffer(CronetHttpURLConnection cronetHttpURLConnection) {
        super(cronetHttpURLConnection);
        this.mReadDone = false;
    }

    private void ensureReadFromCronetDone() throws IOException {
        if (this.mReadDone) {
            return;
        }
        readAllBytesFromCronet();
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int read() throws IOException {
        ensureReadFromCronetDone();
        if (this.mTTBuffer.size > 0) {
            return this.mTTBuffer.get() & 255;
        }
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        ensureReadFromCronetDone();
        if (bArr.length == 0) {
            return 0;
        }
        if (this.mTTBuffer.size > 0) {
            return this.mTTBuffer.readToByteArray(bArr, i, i2);
        }
        return -1;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int available() throws IOException {
        ensureReadFromCronetDone();
        if (this.mTTBuffer.size == 0) {
            if (this.mException == null) {
                return 0;
            }
            this.mTTBuffer.releaseAllSegments();
            throw this.mException;
        }
        if (this.mTTBuffer.size > 0) {
            return this.mTTBuffer.size;
        }
        return 0;
    }

    private void readAllBytesFromCronet() throws IOException {
        if (this.mReadDone) {
            return;
        }
        if (Logger.debug()) {
            Logger.m287d("TTBuffer", "calling ensureReadFromCronetDone");
        }
        this.mTTBuffer = new TTBuffer();
        while (true) {
            Segment writableSegment = this.mTTBuffer.getWritableSegment();
            ByteBuffer innerBuffer = writableSegment.getInnerBuffer();
            if (Logger.debug()) {
                Logger.m287d("TTBuffer", "getMoreData");
            }
            int position = innerBuffer.position();
            this.mHttpURLConnection.getMoreData(innerBuffer);
            if (this.mException != null) {
                this.mTTBuffer.releaseAllSegments();
                throw this.mException;
            }
            int position2 = innerBuffer.position() - position;
            if (position2 != 0) {
                this.mTTBuffer.size += position2;
                if (this.mTTBuffer.size > 5242880) {
                    this.mTTBuffer.releaseAllSegments();
                    throw new IOException("Download too large " + this.mTTBuffer.size + " 5242880");
                }
                if (writableSegment.isWritable()) {
                    if (Logger.debug()) {
                        Logger.m287d("TTBuffer", "new data, continue read with this segment " + this.mTTBuffer.size + " remaining: " + innerBuffer.remaining());
                    }
                } else {
                    if (Logger.debug()) {
                        Logger.m287d("TTBuffer", "new data but full, will use new segment next " + this.mTTBuffer.size);
                    }
                    writableSegment.completeRead();
                }
            } else {
                if (position == 0) {
                    if (Logger.debug()) {
                        Logger.m287d("TTBuffer", "no new data, release empty segment " + this.mTTBuffer.size);
                    }
                    writableSegment.release();
                } else {
                    if (Logger.debug()) {
                        Logger.m287d("TTBuffer", "no new data, save this segment " + this.mTTBuffer.size);
                    }
                    writableSegment.completeRead();
                }
                this.mReadDone = true;
                return;
            }
        }
    }
}

package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.EOFException;

/* loaded from: classes7.dex */
public final class TTBuffer {
    private Segment head = null;
    public int size = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Segment getWritableSegment() {
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment2 = segment.prev;
        if (!segment2.isWritable()) {
            segment2.push(SegmentPool.take());
        }
        return this.head.prev;
    }

    public byte get() {
        if (this.size <= 0) {
            return (byte) 0;
        }
        byte[] bArr = new byte[1];
        read(bArr, 0, 1);
        return bArr[0];
    }

    public int readToByteArray(byte[] bArr, int i, int i2) throws EOFException {
        checkOffsetAndCount(bArr.length, i, i2);
        int min = Math.min(this.size, i2);
        if (Logger.debug()) {
            Logger.d("TTBuffer", "start get buffer, size is " + this.size + " byteCount is " + i2);
        }
        int i3 = i;
        while (min > 0) {
            int read = read(bArr, i3, min);
            if (read == -1) {
                throw new EOFException();
            }
            i3 += read;
            min -= read;
            if (Logger.debug()) {
                Logger.d("TTBuffer", "get segment buffer, n is " + read + " offset is " + i3 + " bytesRead is " + min);
            }
        }
        return i3 - i;
    }

    private int read(byte[] bArr, int i, int i2) {
        checkOffsetAndCount(bArr.length, i, i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int innerBufferTo = segment.getInnerBufferTo(bArr, i, i2);
        if (Logger.debug()) {
            Logger.d("TTBuffer", "head curReadLength is " + innerBufferTo);
        }
        this.size -= innerBufferTo;
        if (!segment.getInnerBuffer().hasRemaining()) {
            this.head = segment.release();
        }
        return innerBufferTo;
    }

    public void releaseAllSegments() {
        while (true) {
            Segment segment = this.head;
            if (segment == null) {
                return;
            } else {
                this.head = segment.release();
            }
        }
    }

    public static void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }
}

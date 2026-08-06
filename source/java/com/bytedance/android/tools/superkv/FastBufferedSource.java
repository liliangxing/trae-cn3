package com.bytedance.android.tools.superkv;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.UByte;

/* loaded from: classes3.dex */
public class FastBufferedSource {
    private static final int BYTE_CACHE_SIZE = 1024;
    private static final Charset CHARSET = Charset.forName("UTF-8");
    private int actualLength;
    private ByteBuffer byteBuffer;
    private byte[] bytesCache = new byte[1024];

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastBufferedSource setup(ByteBuffer byteBuffer, int i, int i2) {
        this.byteBuffer = byteBuffer;
        this.actualLength = i2 + i;
        byteBuffer.position(i);
        return this;
    }

    public boolean exhausted() {
        return this.actualLength - this.byteBuffer.position() <= 0;
    }

    public byte readByte() {
        return this.byteBuffer.get();
    }

    public int readIntLe() {
        this.byteBuffer.get(this.bytesCache, 0, 4);
        byte[] bArr = this.bytesCache;
        return (bArr[3] & UByte.MAX_VALUE) | ((bArr[0] & UByte.MAX_VALUE) << 24) | ((bArr[1] & UByte.MAX_VALUE) << 16) | ((bArr[2] & UByte.MAX_VALUE) << 8);
    }

    public long readLongLe() {
        this.byteBuffer.get(this.bytesCache, 0, 8);
        byte[] bArr = this.bytesCache;
        return ((bArr[0] & UByte.MAX_VALUE) << 56) | ((bArr[1] & UByte.MAX_VALUE) << 48) | ((bArr[2] & UByte.MAX_VALUE) << 40) | ((bArr[3] & UByte.MAX_VALUE) << 32) | ((bArr[4] & UByte.MAX_VALUE) << 24) | ((bArr[5] & UByte.MAX_VALUE) << 16) | ((bArr[6] & UByte.MAX_VALUE) << 8) | (bArr[7] & UByte.MAX_VALUE);
    }

    public void skip(long j) {
        this.byteBuffer.position((int) (r0.position() + j));
    }

    public byte[] readByteArray(long j) {
        byte[] bArr = new byte[(int) j];
        this.byteBuffer.get(bArr);
        return bArr;
    }

    public String readUtf8(long j) {
        return new String(readByteArrayWithCache(j), 0, (int) j, CHARSET);
    }

    private byte[] readByteArrayWithCache(long j) {
        if (j <= 1024) {
            this.byteBuffer.get(this.bytesCache, 0, (int) j);
            return this.bytesCache;
        }
        byte[] bArr = new byte[(int) j];
        this.byteBuffer.get(bArr);
        return bArr;
    }
}

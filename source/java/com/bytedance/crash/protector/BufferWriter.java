package com.bytedance.crash.protector;

import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes3.dex */
public class BufferWriter {
    private byte[] buf;
    private int index;

    public BufferWriter() {
        this(512);
    }

    public BufferWriter(int i) {
        this.buf = null;
        this.index = 0;
        if (i > 0) {
            this.buf = new byte[i];
        }
    }

    public byte[] data() {
        return this.buf;
    }

    public int remaining() {
        return this.buf.length - this.index;
    }

    public int position() {
        return this.index;
    }

    public void setPosition(int i) {
        this.index = i;
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) {
        ensureSpace(i2);
        System.arraycopy(bArr, i, this.buf, this.index, i2);
        this.index += i2;
    }

    public void writeInt32At(int i, int i2) {
        int i3 = this.index;
        this.index = i;
        writeInt32(i2);
        this.index = i3;
    }

    public void writeUleb128(long j) {
        ensureSpace(10);
        do {
            byte b = (byte) (127 & j);
            j >>>= 7;
            if (j != 0) {
                b = (byte) (b | ByteCompanionObject.MIN_VALUE);
            }
            byte[] bArr = this.buf;
            int i = this.index;
            this.index = i + 1;
            bArr[i] = b;
        } while (j != 0);
    }

    public void writeString(String str) {
        writeString(str.getBytes());
    }

    public void writeString(byte[] bArr) {
        writeUleb128(bArr.length);
        write(bArr);
        writeByte(0);
    }

    public void writeByte(int i) {
        ensureSpace(1);
        byte[] bArr = this.buf;
        int i2 = this.index;
        this.index = i2 + 1;
        bArr[i2] = (byte) (i & 255);
    }

    public void writeBoolean(boolean z) {
        writeByte(z ? 1 : 0);
    }

    public void writeInt16(int i) {
        align(2);
        ensureSpace(2);
        byte[] bArr = this.buf;
        int i2 = this.index;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        this.index = i3 + 1;
        bArr[i3] = (byte) ((i >>> 8) & 255);
    }

    public void writeInt32(int i) {
        align(4);
        ensureSpace(4);
        byte[] bArr = this.buf;
        int i2 = this.index;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 8) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 16) & 255);
        this.index = i5 + 1;
        bArr[i5] = (byte) ((i >>> 24) & 255);
    }

    public void writeInt64(long j) {
        align(8);
        writeInt32((int) (j & BodyPartID.bodyIdMax));
        writeInt32((int) ((j >>> 32) & BodyPartID.bodyIdMax));
    }

    public void writeFloat(float f) {
        writeInt32(Float.floatToIntBits(f));
    }

    public void writeDouble(double d) {
        writeInt64(Double.doubleToLongBits(d));
    }

    public int prependInt32(int i) {
        align(4);
        int position = position();
        writeInt32(i);
        return position;
    }

    public void align(int i) {
        int i2 = ((((r0 + i) - 1) / i) * i) - this.index;
        ensureSpace(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = this.buf;
            int i4 = this.index;
            this.index = i4 + 1;
            bArr[i4] = 0;
        }
    }

    private void ensureSpace(int i) {
        if (remaining() < i) {
            int length = this.buf.length;
            byte[] bArr = new byte[length + Math.max(length, i)];
            System.arraycopy(this.buf, 0, bArr, 0, this.index);
            this.buf = bArr;
        }
    }
}

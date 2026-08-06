package org.bouncycastle.mime;

import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
import org.bouncycastle.util.Strings;

/* loaded from: classes8.dex */
public class BoundaryLimitedInputStream extends InputStream {
    private final byte[] boundary;
    private final byte[] buf;
    private int bufOff;
    private int lastI;
    private final InputStream src;
    private int index = 0;
    private boolean ended = false;

    public BoundaryLimitedInputStream(InputStream inputStream, String str) {
        this.bufOff = 0;
        this.src = inputStream;
        this.boundary = Strings.toByteArray(str);
        this.buf = new byte[str.length() + 3];
        this.bufOff = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2  */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int read() throws IOException {
        int read;
        int read2;
        int read3;
        if (this.ended) {
            return -1;
        }
        int i = this.index;
        int i2 = this.bufOff;
        if (i < i2) {
            byte[] bArr = this.buf;
            int i3 = i + 1;
            this.index = i3;
            read = bArr[i] & UByte.MAX_VALUE;
            if (i3 < i2) {
                return read;
            }
            this.bufOff = 0;
            this.index = 0;
        } else {
            read = this.src.read();
        }
        this.lastI = read;
        if (read < 0) {
            return -1;
        }
        if (read == 13 || read == 10) {
            this.index = 0;
            if (read == 13) {
                read2 = this.src.read();
                if (read2 == 10) {
                    byte[] bArr2 = this.buf;
                    int i4 = this.bufOff;
                    this.bufOff = i4 + 1;
                    bArr2[i4] = 10;
                }
                if (read2 == 45) {
                    byte[] bArr3 = this.buf;
                    int i5 = this.bufOff;
                    this.bufOff = i5 + 1;
                    bArr3[i5] = 45;
                    read2 = this.src.read();
                }
                if (read2 != 45) {
                    byte[] bArr4 = this.buf;
                    int i6 = this.bufOff;
                    int i7 = i6 + 1;
                    this.bufOff = i7;
                    bArr4[i6] = 45;
                    while (true) {
                        if (this.bufOff - i7 == this.boundary.length || (read3 = this.src.read()) < 0) {
                            break;
                        }
                        byte[] bArr5 = this.buf;
                        int i8 = this.bufOff;
                        byte b = (byte) read3;
                        bArr5[i8] = b;
                        if (b != this.boundary[i8 - i7]) {
                            this.bufOff = i8 + 1;
                            break;
                        }
                        this.bufOff = i8 + 1;
                    }
                    if (this.bufOff - i7 == this.boundary.length) {
                        this.ended = true;
                        return -1;
                    }
                } else if (read2 >= 0) {
                    byte[] bArr6 = this.buf;
                    int i9 = this.bufOff;
                    this.bufOff = i9 + 1;
                    bArr6[i9] = (byte) read2;
                }
            }
            read2 = this.src.read();
            if (read2 == 45) {
            }
            if (read2 != 45) {
            }
        }
        return read;
    }
}

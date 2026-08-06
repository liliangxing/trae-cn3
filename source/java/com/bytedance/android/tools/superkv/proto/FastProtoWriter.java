package com.bytedance.android.tools.superkv.proto;

import com.ss.ttm.player.MediaPlayer;
import okio.Utf8;

/* loaded from: classes3.dex */
public class FastProtoWriter {
    private byte[] bytes;
    private int position;

    public static int varint32Size(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int varint64Size(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public FastProtoWriter setup(byte[] bArr, int i) {
        this.bytes = bArr;
        this.position = i;
        return this;
    }

    public void writeByteArray(byte[] bArr) {
        System.arraycopy(bArr, 0, this.bytes, this.position, bArr.length);
        this.position += bArr.length;
    }

    public void writeString(String str) {
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                byte[] bArr = this.bytes;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) charAt;
            } else if (charAt < 2048) {
                byte[] bArr2 = this.bytes;
                int i3 = this.position;
                int i4 = i3 + 1;
                bArr2[i3] = (byte) ((charAt >> 6) | 192);
                this.position = i4 + 1;
                bArr2[i4] = (byte) ((charAt & '?') | 128);
            } else if (charAt < 55296 || charAt > 57343) {
                byte[] bArr3 = this.bytes;
                int i5 = this.position;
                int i6 = i5 + 1;
                bArr3[i5] = (byte) ((charAt >> '\f') | MediaPlayer.MEDIA_PLAYER_OPTION_CLOCK_RESUME_RESET_EOF);
                int i7 = i6 + 1;
                bArr3[i6] = (byte) ((63 & (charAt >> 6)) | 128);
                this.position = i7 + 1;
                bArr3[i7] = (byte) ((charAt & '?') | 128);
            } else {
                int i8 = i + 1;
                char charAt2 = i8 < str.length() ? str.charAt(i8) : (char) 0;
                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                    byte[] bArr4 = this.bytes;
                    int i9 = this.position;
                    this.position = i9 + 1;
                    bArr4[i9] = Utf8.REPLACEMENT_BYTE;
                    i = i8;
                } else {
                    int i10 = (((charAt & 10239) << 10) | (9215 & charAt2)) + 65536;
                    byte[] bArr5 = this.bytes;
                    int i11 = this.position;
                    int i12 = i11 + 1;
                    bArr5[i11] = (byte) ((i10 >> 18) | 240);
                    int i13 = i12 + 1;
                    bArr5[i12] = (byte) (((i10 >> 12) & 63) | 128);
                    int i14 = i13 + 1;
                    bArr5[i13] = (byte) (((i10 >> 6) & 63) | 128);
                    this.position = i14 + 1;
                    bArr5[i14] = (byte) ((i10 & 63) | 128);
                    i += 2;
                }
            }
            i++;
        }
    }

    public void writeSignedVarint32(int i) {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64(i);
        }
    }

    public void writeVarint32(int i) {
        while ((i & (-128)) != 0) {
            byte[] bArr = this.bytes;
            int i2 = this.position;
            this.position = i2 + 1;
            bArr[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
        }
        byte[] bArr2 = this.bytes;
        int i3 = this.position;
        this.position = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    public void writeVarint64(long j) {
        while (((-128) & j) != 0) {
            byte[] bArr = this.bytes;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
            j >>>= 7;
        }
        byte[] bArr2 = this.bytes;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr2[i2] = (byte) j;
    }

    public void writeFixed32(int i) {
        byte[] bArr = this.bytes;
        int i2 = this.position;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        this.position = i5 + 1;
        bArr[i5] = (byte) (i & 255);
    }

    public void writeFixed64(long j) {
        byte[] bArr = this.bytes;
        int i = this.position;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        this.position = i8 + 1;
        bArr[i8] = (byte) (j & 255);
    }

    public static int utf8Length(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i3 += 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i3 += 3;
                } else if (charAt <= 56319 && (i = i2 + 1) < length && str.charAt(i) >= 56320 && str.charAt(i) <= 57343) {
                    i3 += 4;
                    i2 = i;
                }
                i2++;
            }
            i3++;
            i2++;
        }
        return i3;
    }

    public static int int32Size(int i) {
        if (i >= 0) {
            return varint32Size(i);
        }
        return 10;
    }
}

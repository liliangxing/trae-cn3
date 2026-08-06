package com.bytedance.memory.shrink;

import java.util.Arrays;
import kotlin.UByte;

/* loaded from: classes4.dex */
public final class HprofID {
    private final byte[] mIdBytes;

    public static HprofID createNullID(int i) {
        return new HprofID(new byte[i]);
    }

    public HprofID(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        this.mIdBytes = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }

    public byte[] getBytes() {
        return this.mIdBytes;
    }

    public int getSize() {
        return this.mIdBytes.length;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HprofID) {
            return Arrays.equals(this.mIdBytes, ((HprofID) obj).mIdBytes);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mIdBytes);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("0x");
        for (byte b : this.mIdBytes) {
            sb.append(Integer.toHexString(b & UByte.MAX_VALUE));
        }
        return sb.toString();
    }
}

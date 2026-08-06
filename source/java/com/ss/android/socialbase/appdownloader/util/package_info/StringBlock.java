package com.ss.android.socialbase.appdownloader.util.package_info;

import java.io.IOException;

/* loaded from: classes7.dex */
public class StringBlock {
    private int[] m_stringOffsets;
    private int[] m_strings;

    public static StringBlock read(IntReader intReader) throws IOException {
        ChunkUtil.readCheckType(intReader, 1835009);
        int readInt = intReader.readInt();
        int readInt2 = intReader.readInt();
        int readInt3 = intReader.readInt();
        intReader.readInt();
        int readInt4 = intReader.readInt();
        int readInt5 = intReader.readInt();
        StringBlock stringBlock = new StringBlock();
        stringBlock.m_stringOffsets = intReader.readIntArray(readInt2);
        if (readInt3 != 0) {
            intReader.readIntArray(readInt3);
        }
        int i = (readInt5 == 0 ? readInt : readInt5) - readInt4;
        if (i % 4 != 0) {
            throw new IOException("String data size is not multiple of 4 (" + i + ").");
        }
        stringBlock.m_strings = intReader.readIntArray(i / 4);
        if (readInt5 != 0) {
            int i2 = readInt - readInt5;
            if (i2 % 4 != 0) {
                throw new IOException("Style data size is not multiple of 4 (" + i2 + ").");
            }
            intReader.readIntArray(i2 / 4);
        }
        return stringBlock;
    }

    public String getString(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.m_stringOffsets) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int i3 = getShort(this.m_strings, i2);
        StringBuilder sb = new StringBuilder(i3);
        while (i3 != 0) {
            i2 += 2;
            sb.append((char) getShort(this.m_strings, i2));
            i3--;
        }
        return sb.toString();
    }

    public int find(String str) {
        if (str == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.m_stringOffsets;
            if (i == iArr.length) {
                return -1;
            }
            int i2 = iArr[i];
            int i3 = getShort(this.m_strings, i2);
            if (i3 == str.length()) {
                int i4 = 0;
                while (i4 != i3) {
                    i2 += 2;
                    if (str.charAt(i4) != getShort(this.m_strings, i2)) {
                        break;
                    }
                    i4++;
                }
                if (i4 == i3) {
                    return i;
                }
            }
            i++;
        }
    }

    private StringBlock() {
    }

    private static final int getShort(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }
}

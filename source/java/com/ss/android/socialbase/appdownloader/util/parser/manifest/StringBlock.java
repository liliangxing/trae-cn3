package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import kotlin.UByte;

/* loaded from: classes7.dex */
public class StringBlock {
    private static final Logger LOGGER = Logger.getLogger(StringBlock.class.getName());
    private static final int STRING_BLOCK_HEADER_SIZE = 28;
    private static final int UTF8_FLAG = 256;
    private boolean mIsUtf8;
    private int[] mStringOffsets;
    private byte[] mStrings;
    private int[] mStyleOffsets;
    private int[] mStyles;
    private final CharsetDecoder UTF16LE_DECODER = StandardCharsets.UTF_16LE.newDecoder();
    private final CharsetDecoder UTF8_DECODER = StandardCharsets.UTF_8.newDecoder();
    private final CharsetDecoder CESU8_DECODER = Charset.forName("CESU8").newDecoder();

    public static StringBlock readWithChunk(ExtCountingDataInput extCountingDataInput) throws IOException {
        int position = extCountingDataInput.position();
        extCountingDataInput.skipCheckShort((short) 1);
        return readWithoutChunk(extCountingDataInput, position, extCountingDataInput.readShort(), extCountingDataInput.readInt());
    }

    public static StringBlock readWithoutChunk(ExtCountingDataInput extCountingDataInput, int i, int i2, int i3) throws IOException {
        int readInt = extCountingDataInput.readInt();
        int readInt2 = extCountingDataInput.readInt();
        int readInt3 = extCountingDataInput.readInt();
        int readInt4 = extCountingDataInput.readInt();
        int readInt5 = extCountingDataInput.readInt();
        if (i2 > 28) {
            extCountingDataInput.skipBytes(i2 - 28);
        }
        StringBlock stringBlock = new StringBlock();
        boolean z = false;
        stringBlock.mIsUtf8 = (readInt3 & 256) != 0;
        stringBlock.mStringOffsets = extCountingDataInput.readSafeIntArray(readInt, i + readInt4);
        if (readInt2 != 0) {
            stringBlock.mStyleOffsets = extCountingDataInput.readSafeIntArray(readInt2, i + readInt5);
        }
        if (readInt5 != 0 && readInt2 != 0) {
            z = true;
        }
        int i4 = i3 - readInt4;
        if (readInt2 > 0) {
            i4 = readInt5 - readInt4;
        }
        byte[] bArr = new byte[i4];
        stringBlock.mStrings = bArr;
        extCountingDataInput.readFully(bArr);
        if (z) {
            i4 = i3 - readInt5;
            stringBlock.mStyles = extCountingDataInput.readIntArray(i4 / 4);
        }
        int i5 = i4 % 4;
        if (i5 >= 1) {
            while (true) {
                int i6 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                extCountingDataInput.readByte();
                i5 = i6;
            }
        }
        return stringBlock;
    }

    public String getString(int i) {
        int[] iArr;
        int i2;
        int[] iArr2;
        if (i < 0 || (iArr = this.mStringOffsets) == null || i >= iArr.length) {
            return null;
        }
        int i3 = iArr[i];
        if (this.mIsUtf8) {
            iArr2 = getUtf8(this.mStrings, i3);
            i2 = iArr2[0];
        } else {
            int[] utf16 = getUtf16(this.mStrings, i3);
            i2 = i3 + utf16[0];
            iArr2 = utf16;
        }
        return decodeString(i2, iArr2[1]);
    }

    public int find(String str) {
        if (str == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.mStringOffsets;
            if (i == iArr.length) {
                return -1;
            }
            int i2 = iArr[i];
            int i3 = getShort(this.mStrings, i2);
            if (i3 == str.length()) {
                int i4 = 0;
                while (i4 != i3) {
                    i2 += 2;
                    if (str.charAt(i4) != getShort(this.mStrings, i2)) {
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

    private int[] getStyle(int i) {
        int i2;
        int[] iArr = this.mStyleOffsets;
        int[] iArr2 = null;
        if (iArr != null && this.mStyles != null && i < iArr.length) {
            int i3 = iArr[i] / 4;
            int i4 = 0;
            int i5 = i3;
            int i6 = 0;
            while (true) {
                int[] iArr3 = this.mStyles;
                if (i5 >= iArr3.length || iArr3[i5] == -1) {
                    break;
                }
                i6++;
                i5++;
            }
            if (i6 != 0 && i6 % 3 == 0) {
                iArr2 = new int[i6];
                while (true) {
                    int[] iArr4 = this.mStyles;
                    if (i3 >= iArr4.length || (i2 = iArr4[i3]) == -1) {
                        break;
                    }
                    i3++;
                    iArr2[i4] = i2;
                    i4++;
                }
            }
        }
        return iArr2;
    }

    String decodeString(int i, int i2) {
        try {
            return (this.mIsUtf8 ? this.UTF8_DECODER : this.UTF16LE_DECODER).decode(ByteBuffer.wrap(this.mStrings, i, i2)).toString();
        } catch (IndexOutOfBoundsException unused) {
            if (!this.mIsUtf8) {
                LOGGER.warning("String extends outside of pool at  " + i + " of length " + i2);
                return null;
            }
            try {
                return this.CESU8_DECODER.decode(ByteBuffer.wrap(this.mStrings, i, i2)).toString();
            } catch (CharacterCodingException unused2) {
                LOGGER.warning("Failed to decode a string with CESU-8 decoder.");
                return null;
            }
        } catch (CharacterCodingException unused3) {
            if (!this.mIsUtf8) {
                LOGGER.warning("Failed to decode a string at offset " + i + " of length " + i2);
                return null;
            }
            return this.CESU8_DECODER.decode(ByteBuffer.wrap(this.mStrings, i, i2)).toString();
        }
    }

    private static int getShort(byte[] bArr, int i) {
        return (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int[] getUtf8(byte[] bArr, int i) {
        int i2 = (bArr[i] & 128) != 0 ? i + 2 : i + 1;
        int i3 = bArr[i2];
        int i4 = i2 + 1;
        if ((i3 & 128) != 0) {
            i3 = ((i3 & 127) << 8) + (bArr[i4] & 255);
            i4++;
        }
        return new int[]{i4, i3};
    }

    private static int[] getUtf16(byte[] bArr, int i) {
        int i2 = ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | (bArr[i] & UByte.MAX_VALUE);
        return (32768 & i2) != 0 ? new int[]{4, (((i2 & 32767) << 16) + ((bArr[i + 3] & UByte.MAX_VALUE) << 8) + (bArr[i + 2] & UByte.MAX_VALUE)) * 2} : new int[]{2, i2 * 2};
    }
}

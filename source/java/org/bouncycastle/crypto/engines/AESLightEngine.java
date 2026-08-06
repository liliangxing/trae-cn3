package org.bouncycastle.crypto.engines;

import java.lang.reflect.Array;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.math.ec.Tnaf;
import org.bouncycastle.util.Pack;

/* loaded from: classes8.dex */
public class AESLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int m1 = -2139062144;
    private static final int m2 = 2139062143;
    private static final int m3 = 27;
    private static final int m4 = -1061109568;
    private static final int m5 = 1061109567;
    private int C0;
    private int C1;
    private int C2;
    private int C3;
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ByteCompanionObject.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Tnaf.POW_2_WIDTH, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, Base64.padSymbol, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, Base64.padSymbol, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, Utf8.REPLACEMENT_BYTE, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, ByteCompanionObject.MIN_VALUE, -20, 95, 96, 81, Byte.MAX_VALUE, -87, 25, -75, 74, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};

    public AESLightEngine() {
    }

    private static int FFmulX(int i) {
        return (((i & m1) >>> 7) * 27) ^ ((m2 & i) << 1);
    }

    private static int FFmulX2(int i) {
        int i2 = (m5 & i) << 2;
        int i3 = i & m4;
        int i4 = i3 ^ (i3 >>> 1);
        return (i4 >>> 5) ^ (i2 ^ (i4 >>> 2));
    }

    private void decryptBlock(int[][] iArr) {
        int i = this.C0;
        int i2 = this.ROUNDS;
        int[] iArr2 = iArr[i2];
        int i3 = i ^ iArr2[0];
        int i4 = this.C1 ^ iArr2[1];
        int i5 = this.C2 ^ iArr2[2];
        int i6 = i2 - 1;
        int i7 = iArr2[3] ^ this.C3;
        while (true) {
            byte[] bArr = Si;
            int i8 = i3 & 255;
            if (i6 <= 1) {
                int inv_mcol = inv_mcol((((bArr[i8] & UByte.MAX_VALUE) ^ ((bArr[(i7 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i5 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i4 >> 24) & 255] << 24)) ^ iArr[i6][0];
                int inv_mcol2 = inv_mcol((((bArr[i4 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i7 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i5 >> 24) & 255] << 24)) ^ iArr[i6][1];
                int inv_mcol3 = inv_mcol((((bArr[i5 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i7 >> 24) & 255] << 24)) ^ iArr[i6][2];
                int inv_mcol4 = inv_mcol((bArr[(i3 >> 24) & 255] << 24) ^ (((bArr[i7 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i4 >> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ iArr[i6][3];
                int i9 = (((bArr[inv_mcol & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol2 >> 24) & 255] << 24);
                int[] iArr3 = iArr[0];
                this.C0 = i9 ^ iArr3[0];
                this.C1 = ((((bArr[inv_mcol2 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol4 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol3 >> 24) & 255] << 24)) ^ iArr3[1];
                this.C2 = ((((bArr[inv_mcol3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol4 >> 24) & 255] << 24)) ^ iArr3[2];
                this.C3 = iArr3[3] ^ ((((bArr[inv_mcol4 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol >> 24) & 255] << 24));
                return;
            }
            int inv_mcol5 = inv_mcol((((bArr[i8] & UByte.MAX_VALUE) ^ ((bArr[(i7 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i5 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i4 >> 24) & 255] << 24)) ^ iArr[i6][0];
            int inv_mcol6 = inv_mcol((((bArr[i4 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i7 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i5 >> 24) & 255] << 24)) ^ iArr[i6][1];
            int inv_mcol7 = inv_mcol((((bArr[i5 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i7 >> 24) & 255] << 24)) ^ iArr[i6][2];
            int inv_mcol8 = inv_mcol((bArr[(i3 >> 24) & 255] << 24) ^ (((bArr[i7 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i4 >> 16) & 255] & UByte.MAX_VALUE) << 16)));
            int i10 = i6 - 1;
            int i11 = inv_mcol8 ^ iArr[i6][3];
            int inv_mcol9 = inv_mcol((((bArr[inv_mcol5 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i11 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol7 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol6 >> 24) & 255] << 24)) ^ iArr[i10][0];
            i4 = inv_mcol((((bArr[inv_mcol6 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i11 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol7 >> 24) & 255] << 24)) ^ iArr[i10][1];
            i5 = inv_mcol((((bArr[inv_mcol7 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol6 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol5 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i11 >> 24) & 255] << 24)) ^ iArr[i10][2];
            int inv_mcol10 = inv_mcol((((bArr[i11 & 255] & UByte.MAX_VALUE) ^ ((bArr[(inv_mcol7 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(inv_mcol6 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(inv_mcol5 >> 24) & 255] << 24));
            int i12 = i10 - 1;
            i7 = iArr[i10][3] ^ inv_mcol10;
            i3 = inv_mcol9;
            i6 = i12;
        }
    }

    private void encryptBlock(int[][] iArr) {
        int i = this.C0;
        int[] iArr2 = iArr[0];
        int i2 = i ^ iArr2[0];
        int i3 = this.C1 ^ iArr2[1];
        int i4 = this.C2 ^ iArr2[2];
        int i5 = iArr2[3] ^ this.C3;
        int i6 = 1;
        while (i6 < this.ROUNDS - 1) {
            byte[] bArr = S;
            int mcol = mcol((((bArr[i2 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i4 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i5 >> 24) & 255] << 24)) ^ iArr[i6][0];
            int mcol2 = mcol((((bArr[i3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i5 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i2 >> 24) & 255] << 24)) ^ iArr[i6][1];
            int mcol3 = mcol((((bArr[i4 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i3 >> 24) & 255] << 24)) ^ iArr[i6][2];
            int mcol4 = mcol(((((bArr[(i2 >> 8) & 255] & UByte.MAX_VALUE) << 8) ^ (bArr[i5 & 255] & UByte.MAX_VALUE)) ^ ((bArr[(i3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i4 >> 24) & 255] << 24));
            int i7 = i6 + 1;
            int i8 = mcol4 ^ iArr[i6][3];
            int mcol5 = mcol((((bArr[mcol & 255] & UByte.MAX_VALUE) ^ ((bArr[(mcol2 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(mcol3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(i8 >> 24) & 255] << 24)) ^ iArr[i7][0];
            int mcol6 = mcol((((bArr[mcol2 & 255] & UByte.MAX_VALUE) ^ ((bArr[(mcol3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(i8 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(mcol >> 24) & 255] << 24)) ^ iArr[i7][1];
            int mcol7 = mcol((((bArr[mcol3 & 255] & UByte.MAX_VALUE) ^ ((bArr[(i8 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(mcol >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(mcol2 >> 24) & 255] << 24)) ^ iArr[i7][2];
            int mcol8 = mcol((((bArr[i8 & 255] & UByte.MAX_VALUE) ^ ((bArr[(mcol >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr[(mcol2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr[(mcol3 >> 24) & 255] << 24));
            int i9 = i7 + 1;
            i5 = iArr[i7][3] ^ mcol8;
            i2 = mcol5;
            i3 = mcol6;
            i4 = mcol7;
            i6 = i9;
        }
        byte[] bArr2 = S;
        int mcol9 = mcol((((bArr2[i2 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(i3 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(i4 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(i5 >> 24) & 255] << 24)) ^ iArr[i6][0];
        int mcol10 = mcol((((bArr2[i3 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(i4 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(i5 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(i2 >> 24) & 255] << 24)) ^ iArr[i6][1];
        int mcol11 = mcol((((bArr2[i4 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(i5 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(i2 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(i3 >> 24) & 255] << 24)) ^ iArr[i6][2];
        int mcol12 = mcol(((((bArr2[(i2 >> 8) & 255] & UByte.MAX_VALUE) << 8) ^ (bArr2[i5 & 255] & UByte.MAX_VALUE)) ^ ((bArr2[(i3 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(i4 >> 24) & 255] << 24)) ^ iArr[i6][3];
        int i10 = (((bArr2[mcol9 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(mcol10 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(mcol11 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(mcol12 >> 24) & 255] << 24);
        int[] iArr3 = iArr[i6 + 1];
        this.C0 = iArr3[0] ^ i10;
        this.C1 = ((((bArr2[mcol10 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(mcol11 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(mcol12 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(mcol9 >> 24) & 255] << 24)) ^ iArr3[1];
        this.C2 = ((((bArr2[mcol11 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(mcol12 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(mcol9 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(mcol10 >> 24) & 255] << 24)) ^ iArr3[2];
        this.C3 = iArr3[3] ^ ((((bArr2[mcol12 & 255] & UByte.MAX_VALUE) ^ ((bArr2[(mcol9 >> 8) & 255] & UByte.MAX_VALUE) << 8)) ^ ((bArr2[(mcol10 >> 16) & 255] & UByte.MAX_VALUE) << 16)) ^ (bArr2[(mcol11 >> 24) & 255] << 24));
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z) {
        int length = bArr.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i = length >>> 2;
        int i2 = i + 6;
        this.ROUNDS = i2;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i2 + 1, 4);
        int i3 = 8;
        char c = 3;
        if (i == 4) {
            int littleEndianToInt = Pack.littleEndianToInt(bArr, 0);
            iArr[0][0] = littleEndianToInt;
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
            iArr[0][1] = littleEndianToInt2;
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
            iArr[0][2] = littleEndianToInt3;
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
            iArr[0][3] = littleEndianToInt4;
            for (int i4 = 1; i4 <= 10; i4++) {
                littleEndianToInt ^= subWord(shift(littleEndianToInt4, 8)) ^ rcon[i4 - 1];
                int[] iArr2 = iArr[i4];
                iArr2[0] = littleEndianToInt;
                littleEndianToInt2 ^= littleEndianToInt;
                iArr2[1] = littleEndianToInt2;
                littleEndianToInt3 ^= littleEndianToInt2;
                iArr2[2] = littleEndianToInt3;
                littleEndianToInt4 ^= littleEndianToInt3;
                iArr2[3] = littleEndianToInt4;
            }
        } else if (i == 6) {
            int littleEndianToInt5 = Pack.littleEndianToInt(bArr, 0);
            iArr[0][0] = littleEndianToInt5;
            int littleEndianToInt6 = Pack.littleEndianToInt(bArr, 4);
            iArr[0][1] = littleEndianToInt6;
            int littleEndianToInt7 = Pack.littleEndianToInt(bArr, 8);
            iArr[0][2] = littleEndianToInt7;
            int littleEndianToInt8 = Pack.littleEndianToInt(bArr, 12);
            iArr[0][3] = littleEndianToInt8;
            int littleEndianToInt9 = Pack.littleEndianToInt(bArr, 16);
            int littleEndianToInt10 = Pack.littleEndianToInt(bArr, 20);
            int i5 = 1;
            int i6 = 1;
            while (true) {
                int[] iArr3 = iArr[i5];
                iArr3[0] = littleEndianToInt9;
                iArr3[1] = littleEndianToInt10;
                int subWord = subWord(shift(littleEndianToInt10, 8)) ^ i6;
                int i7 = i6 << 1;
                int i8 = littleEndianToInt5 ^ subWord;
                int[] iArr4 = iArr[i5];
                iArr4[2] = i8;
                int i9 = littleEndianToInt6 ^ i8;
                iArr4[3] = i9;
                int i10 = littleEndianToInt7 ^ i9;
                int[] iArr5 = iArr[i5 + 1];
                iArr5[0] = i10;
                int i11 = littleEndianToInt8 ^ i10;
                iArr5[1] = i11;
                int i12 = littleEndianToInt9 ^ i11;
                iArr5[2] = i12;
                int i13 = littleEndianToInt10 ^ i12;
                iArr5[3] = i13;
                int subWord2 = subWord(shift(i13, 8)) ^ i7;
                i6 = i7 << 1;
                littleEndianToInt5 = i8 ^ subWord2;
                int[] iArr6 = iArr[i5 + 2];
                iArr6[0] = littleEndianToInt5;
                littleEndianToInt6 = i9 ^ littleEndianToInt5;
                iArr6[1] = littleEndianToInt6;
                littleEndianToInt7 = i10 ^ littleEndianToInt6;
                iArr6[2] = littleEndianToInt7;
                littleEndianToInt8 = i11 ^ littleEndianToInt7;
                iArr6[3] = littleEndianToInt8;
                i5 += 3;
                if (i5 >= 13) {
                    break;
                }
                littleEndianToInt9 = i12 ^ littleEndianToInt8;
                littleEndianToInt10 = i13 ^ littleEndianToInt9;
            }
        } else {
            if (i != 8) {
                throw new IllegalStateException("Should never get here");
            }
            int littleEndianToInt11 = Pack.littleEndianToInt(bArr, 0);
            iArr[0][0] = littleEndianToInt11;
            int littleEndianToInt12 = Pack.littleEndianToInt(bArr, 4);
            iArr[0][1] = littleEndianToInt12;
            int littleEndianToInt13 = Pack.littleEndianToInt(bArr, 8);
            iArr[0][2] = littleEndianToInt13;
            int littleEndianToInt14 = Pack.littleEndianToInt(bArr, 12);
            iArr[0][3] = littleEndianToInt14;
            int littleEndianToInt15 = Pack.littleEndianToInt(bArr, 16);
            iArr[1][0] = littleEndianToInt15;
            int littleEndianToInt16 = Pack.littleEndianToInt(bArr, 20);
            iArr[1][1] = littleEndianToInt16;
            int littleEndianToInt17 = Pack.littleEndianToInt(bArr, 24);
            iArr[1][2] = littleEndianToInt17;
            int littleEndianToInt18 = Pack.littleEndianToInt(bArr, 28);
            iArr[1][3] = littleEndianToInt18;
            int i14 = 2;
            int i15 = 1;
            while (true) {
                int subWord3 = subWord(shift(littleEndianToInt18, i3)) ^ i15;
                i15 <<= 1;
                littleEndianToInt11 ^= subWord3;
                int[] iArr7 = iArr[i14];
                iArr7[0] = littleEndianToInt11;
                littleEndianToInt12 ^= littleEndianToInt11;
                iArr7[1] = littleEndianToInt12;
                littleEndianToInt13 ^= littleEndianToInt12;
                iArr7[2] = littleEndianToInt13;
                littleEndianToInt14 ^= littleEndianToInt13;
                iArr7[c] = littleEndianToInt14;
                int i16 = i14 + 1;
                if (i16 >= 15) {
                    break;
                }
                littleEndianToInt15 ^= subWord(littleEndianToInt14);
                int[] iArr8 = iArr[i16];
                iArr8[0] = littleEndianToInt15;
                littleEndianToInt16 ^= littleEndianToInt15;
                iArr8[1] = littleEndianToInt16;
                littleEndianToInt17 ^= littleEndianToInt16;
                iArr8[2] = littleEndianToInt17;
                littleEndianToInt18 ^= littleEndianToInt17;
                iArr8[3] = littleEndianToInt18;
                i14 = i16 + 1;
                i3 = 8;
                c = 3;
            }
        }
        if (!z) {
            for (int i17 = 1; i17 < this.ROUNDS; i17++) {
                for (int i18 = 0; i18 < 4; i18++) {
                    int[] iArr9 = iArr[i17];
                    iArr9[i18] = inv_mcol(iArr9[i18]);
                }
            }
        }
        return iArr;
    }

    private static int inv_mcol(int i) {
        int shift = shift(i, 8) ^ i;
        int FFmulX = i ^ FFmulX(shift);
        int FFmulX2 = shift ^ FFmulX2(FFmulX);
        return FFmulX ^ (FFmulX2 ^ shift(FFmulX2, 16));
    }

    private static int mcol(int i) {
        int shift = shift(i, 8);
        int i2 = i ^ shift;
        return FFmulX(i2) ^ (shift ^ shift(i2, 16));
    }

    private void packBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = this.C0;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.C1;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.C2;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.C3;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    private static int shift(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    private static int subWord(int i) {
        byte[] bArr = S;
        return (bArr[(i >> 24) & 255] << 24) | (bArr[i & 255] & UByte.MAX_VALUE) | ((bArr[(i >> 8) & 255] & UByte.MAX_VALUE) << 8) | ((bArr[(i >> 16) & 255] & UByte.MAX_VALUE) << 16);
    }

    private void unpackBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 8);
        int i5 = i3 + 1;
        int i6 = i4 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i7 = i5 + 1;
        this.C0 = i6 | (bArr[i5] << 24);
        int i8 = i7 + 1;
        int i9 = bArr[i7] & UByte.MAX_VALUE;
        int i10 = i8 + 1;
        int i11 = ((bArr[i8] & UByte.MAX_VALUE) << 8) | i9;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i10] & UByte.MAX_VALUE) << 16);
        int i14 = i12 + 1;
        this.C1 = i13 | (bArr[i12] << 24);
        int i15 = i14 + 1;
        int i16 = bArr[i14] & UByte.MAX_VALUE;
        int i17 = i15 + 1;
        int i18 = ((bArr[i15] & UByte.MAX_VALUE) << 8) | i16;
        int i19 = i17 + 1;
        int i20 = i18 | ((bArr[i17] & UByte.MAX_VALUE) << 16);
        int i21 = i19 + 1;
        this.C2 = i20 | (bArr[i19] << 24);
        int i22 = i21 + 1;
        int i23 = bArr[i21] & UByte.MAX_VALUE;
        int i24 = i22 + 1;
        int i25 = ((bArr[i22] & UByte.MAX_VALUE) << 8) | i23;
        int i26 = i25 | ((bArr[i24] & UByte.MAX_VALUE) << 16);
        this.C3 = (bArr[i24 + 1] << 24) | i26;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "AES";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
        }
        this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z);
        this.forEncryption = z;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.WorkingKey == null) {
            throw new IllegalStateException("AES engine not initialised");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        boolean z = this.forEncryption;
        unpackBlock(bArr, i);
        int[][] iArr = this.WorkingKey;
        if (z) {
            encryptBlock(iArr);
        } else {
            decryptBlock(iArr);
        }
        packBlock(bArr2, i2);
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}

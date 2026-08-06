package org.bouncycastle.cert.selector;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Pack;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class MSOutlookKeyIdCalculator {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static abstract class GeneralDigest {
        private static final int BYTE_LENGTH = 64;
        private long byteCount;
        private byte[] xBuf;
        private int xBufOff;

        protected GeneralDigest() {
            this.xBuf = new byte[4];
            this.xBufOff = 0;
        }

        protected GeneralDigest(GeneralDigest generalDigest) {
            this.xBuf = new byte[generalDigest.xBuf.length];
            copyIn(generalDigest);
        }

        protected void copyIn(GeneralDigest generalDigest) {
            byte[] bArr = generalDigest.xBuf;
            System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
            this.xBufOff = generalDigest.xBufOff;
            this.byteCount = generalDigest.byteCount;
        }

        public void finish() {
            long j = this.byteCount << 3;
            byte b = ByteCompanionObject.MIN_VALUE;
            while (true) {
                update(b);
                if (this.xBufOff == 0) {
                    processLength(j);
                    processBlock();
                    return;
                }
                b = 0;
            }
        }

        protected abstract void processBlock();

        protected abstract void processLength(long j);

        protected abstract void processWord(byte[] bArr, int i);

        public void reset() {
            this.byteCount = 0L;
            this.xBufOff = 0;
            int i = 0;
            while (true) {
                byte[] bArr = this.xBuf;
                if (i >= bArr.length) {
                    return;
                }
                bArr[i] = 0;
                i++;
            }
        }

        public void update(byte b) {
            byte[] bArr = this.xBuf;
            int i = this.xBufOff;
            int i2 = i + 1;
            this.xBufOff = i2;
            bArr[i] = b;
            if (i2 == bArr.length) {
                processWord(bArr, 0);
                this.xBufOff = 0;
            }
            this.byteCount++;
        }

        public void update(byte[] bArr, int i, int i2) {
            while (this.xBufOff != 0 && i2 > 0) {
                update(bArr[i]);
                i++;
                i2--;
            }
            while (i2 > this.xBuf.length) {
                processWord(bArr, i);
                byte[] bArr2 = this.xBuf;
                i += bArr2.length;
                i2 -= bArr2.length;
                this.byteCount += bArr2.length;
            }
            while (i2 > 0) {
                update(bArr[i]);
                i++;
                i2--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static class SHA1Digest extends GeneralDigest {
        private static final int DIGEST_LENGTH = 20;

        /* renamed from: Y1 */
        private static final int f591Y1 = 1518500249;

        /* renamed from: Y2 */
        private static final int f592Y2 = 1859775393;

        /* renamed from: Y3 */
        private static final int f593Y3 = -1894007588;

        /* renamed from: Y4 */
        private static final int f594Y4 = -899497514;

        /* renamed from: H1 */
        private int f595H1;

        /* renamed from: H2 */
        private int f596H2;

        /* renamed from: H3 */
        private int f597H3;

        /* renamed from: H4 */
        private int f598H4;

        /* renamed from: H5 */
        private int f599H5;

        /* renamed from: X */
        private int[] f600X = new int[80];
        private int xOff;

        public SHA1Digest() {
            reset();
        }

        /* renamed from: f */
        private int m235f(int i, int i2, int i3) {
            return ((~i) & i3) | (i2 & i);
        }

        /* renamed from: g */
        private int m236g(int i, int i2, int i3) {
            return (i & i3) | (i & i2) | (i2 & i3);
        }

        /* renamed from: h */
        private int m237h(int i, int i2, int i3) {
            return (i ^ i2) ^ i3;
        }

        public int doFinal(byte[] bArr, int i) {
            finish();
            Pack.intToBigEndian(this.f595H1, bArr, i);
            Pack.intToBigEndian(this.f596H2, bArr, i + 4);
            Pack.intToBigEndian(this.f597H3, bArr, i + 8);
            Pack.intToBigEndian(this.f598H4, bArr, i + 12);
            Pack.intToBigEndian(this.f599H5, bArr, i + 16);
            reset();
            return 20;
        }

        public String getAlgorithmName() {
            return McElieceCCA2KeyGenParameterSpec.SHA1;
        }

        public int getDigestSize() {
            return 20;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processBlock() {
            for (int i = 16; i < 80; i++) {
                int[] iArr = this.f600X;
                int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
                iArr[i] = (i2 >>> 31) | (i2 << 1);
            }
            int i3 = this.f595H1;
            int i4 = this.f596H2;
            int i5 = this.f597H3;
            int i6 = this.f598H4;
            int i7 = this.f599H5;
            int i8 = 0;
            int i9 = 0;
            while (i8 < 4) {
                int i10 = i9 + 1;
                int m235f = i7 + ((i3 << 5) | (i3 >>> 27)) + m235f(i4, i5, i6) + this.f600X[i9] + f591Y1;
                int i11 = (i4 >>> 2) | (i4 << 30);
                int i12 = i10 + 1;
                int m235f2 = i6 + ((m235f << 5) | (m235f >>> 27)) + m235f(i3, i11, i5) + this.f600X[i10] + f591Y1;
                int i13 = (i3 >>> 2) | (i3 << 30);
                int i14 = i12 + 1;
                int m235f3 = i5 + ((m235f2 << 5) | (m235f2 >>> 27)) + m235f(m235f, i13, i11) + this.f600X[i12] + f591Y1;
                i7 = (m235f >>> 2) | (m235f << 30);
                int i15 = i14 + 1;
                i4 = i11 + ((m235f3 << 5) | (m235f3 >>> 27)) + m235f(m235f2, i7, i13) + this.f600X[i14] + f591Y1;
                i6 = (m235f2 >>> 2) | (m235f2 << 30);
                i3 = i13 + ((i4 << 5) | (i4 >>> 27)) + m235f(m235f3, i6, i7) + this.f600X[i15] + f591Y1;
                i5 = (m235f3 >>> 2) | (m235f3 << 30);
                i8++;
                i9 = i15 + 1;
            }
            int i16 = 0;
            while (i16 < 4) {
                int i17 = i9 + 1;
                int m237h = i7 + ((i3 << 5) | (i3 >>> 27)) + m237h(i4, i5, i6) + this.f600X[i9] + f592Y2;
                int i18 = (i4 >>> 2) | (i4 << 30);
                int i19 = i17 + 1;
                int m237h2 = i6 + ((m237h << 5) | (m237h >>> 27)) + m237h(i3, i18, i5) + this.f600X[i17] + f592Y2;
                int i20 = (i3 >>> 2) | (i3 << 30);
                int i21 = i19 + 1;
                int m237h3 = i5 + ((m237h2 << 5) | (m237h2 >>> 27)) + m237h(m237h, i20, i18) + this.f600X[i19] + f592Y2;
                i7 = (m237h >>> 2) | (m237h << 30);
                int i22 = i21 + 1;
                i4 = i18 + ((m237h3 << 5) | (m237h3 >>> 27)) + m237h(m237h2, i7, i20) + this.f600X[i21] + f592Y2;
                i6 = (m237h2 >>> 2) | (m237h2 << 30);
                i3 = i20 + ((i4 << 5) | (i4 >>> 27)) + m237h(m237h3, i6, i7) + this.f600X[i22] + f592Y2;
                i5 = (m237h3 >>> 2) | (m237h3 << 30);
                i16++;
                i9 = i22 + 1;
            }
            int i23 = 0;
            while (i23 < 4) {
                int i24 = i9 + 1;
                int m236g = i7 + ((i3 << 5) | (i3 >>> 27)) + m236g(i4, i5, i6) + this.f600X[i9] + f593Y3;
                int i25 = (i4 >>> 2) | (i4 << 30);
                int i26 = i24 + 1;
                int m236g2 = i6 + ((m236g << 5) | (m236g >>> 27)) + m236g(i3, i25, i5) + this.f600X[i24] + f593Y3;
                int i27 = (i3 >>> 2) | (i3 << 30);
                int i28 = i26 + 1;
                int m236g3 = i5 + ((m236g2 << 5) | (m236g2 >>> 27)) + m236g(m236g, i27, i25) + this.f600X[i26] + f593Y3;
                i7 = (m236g >>> 2) | (m236g << 30);
                int i29 = i28 + 1;
                i4 = i25 + ((m236g3 << 5) | (m236g3 >>> 27)) + m236g(m236g2, i7, i27) + this.f600X[i28] + f593Y3;
                i6 = (m236g2 >>> 2) | (m236g2 << 30);
                i3 = i27 + ((i4 << 5) | (i4 >>> 27)) + m236g(m236g3, i6, i7) + this.f600X[i29] + f593Y3;
                i5 = (m236g3 >>> 2) | (m236g3 << 30);
                i23++;
                i9 = i29 + 1;
            }
            int i30 = 0;
            while (i30 <= 3) {
                int i31 = i9 + 1;
                int m237h4 = i7 + ((i3 << 5) | (i3 >>> 27)) + m237h(i4, i5, i6) + this.f600X[i9] + f594Y4;
                int i32 = (i4 >>> 2) | (i4 << 30);
                int i33 = i31 + 1;
                int m237h5 = i6 + ((m237h4 << 5) | (m237h4 >>> 27)) + m237h(i3, i32, i5) + this.f600X[i31] + f594Y4;
                int i34 = (i3 >>> 2) | (i3 << 30);
                int i35 = i33 + 1;
                int m237h6 = i5 + ((m237h5 << 5) | (m237h5 >>> 27)) + m237h(m237h4, i34, i32) + this.f600X[i33] + f594Y4;
                i7 = (m237h4 >>> 2) | (m237h4 << 30);
                int i36 = i35 + 1;
                i4 = i32 + ((m237h6 << 5) | (m237h6 >>> 27)) + m237h(m237h5, i7, i34) + this.f600X[i35] + f594Y4;
                i6 = (m237h5 >>> 2) | (m237h5 << 30);
                i3 = i34 + ((i4 << 5) | (i4 >>> 27)) + m237h(m237h6, i6, i7) + this.f600X[i36] + f594Y4;
                i5 = (m237h6 >>> 2) | (m237h6 << 30);
                i30++;
                i9 = i36 + 1;
            }
            this.f595H1 += i3;
            this.f596H2 += i4;
            this.f597H3 += i5;
            this.f598H4 += i6;
            this.f599H5 += i7;
            this.xOff = 0;
            for (int i37 = 0; i37 < 16; i37++) {
                this.f600X[i37] = 0;
            }
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processLength(long j) {
            if (this.xOff > 14) {
                processBlock();
            }
            int[] iArr = this.f600X;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) (j & (-1));
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        protected void processWord(byte[] bArr, int i) {
            int i2 = bArr[i] << 24;
            int i3 = i + 1;
            int i4 = i2 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
            int i5 = i3 + 1;
            int i6 = (bArr[i5 + 1] & UByte.MAX_VALUE) | i4 | ((bArr[i5] & UByte.MAX_VALUE) << 8);
            int[] iArr = this.f600X;
            int i7 = this.xOff;
            iArr[i7] = i6;
            int i8 = i7 + 1;
            this.xOff = i8;
            if (i8 == 16) {
                processBlock();
            }
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void reset() {
            super.reset();
            this.f595H1 = 1732584193;
            this.f596H2 = -271733879;
            this.f597H3 = -1732584194;
            this.f598H4 = 271733878;
            this.f599H5 = -1009589776;
            this.xOff = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.f600X;
                if (i == iArr.length) {
                    return;
                }
                iArr[i] = 0;
                i++;
            }
        }
    }

    MSOutlookKeyIdCalculator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] calculateKeyId(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        try {
            byte[] encoded = subjectPublicKeyInfo.getEncoded(ASN1Encoding.DER);
            sHA1Digest.update(encoded, 0, encoded.length);
            sHA1Digest.doFinal(bArr, 0);
            return bArr;
        } catch (IOException unused) {
            return new byte[0];
        }
    }
}

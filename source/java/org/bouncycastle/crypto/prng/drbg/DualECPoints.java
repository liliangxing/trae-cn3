package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.math.ec.ECPoint;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class DualECPoints {
    private final int cofactor;

    /* renamed from: p */
    private final ECPoint f1096p;

    /* renamed from: q */
    private final ECPoint f1097q;
    private final int securityStrength;

    public DualECPoints(int i, ECPoint eCPoint, ECPoint eCPoint2, int i2) {
        if (!eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            throw new IllegalArgumentException("points need to be on the same curve");
        }
        this.securityStrength = i;
        this.f1096p = eCPoint;
        this.f1097q = eCPoint2;
        this.cofactor = i2;
    }

    private static int log2(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public int getCofactor() {
        return this.cofactor;
    }

    public int getMaxOutlen() {
        return ((this.f1096p.getCurve().getFieldSize() - (log2(this.cofactor) + 13)) / 8) * 8;
    }

    public ECPoint getP() {
        return this.f1096p;
    }

    public ECPoint getQ() {
        return this.f1097q;
    }

    public int getSecurityStrength() {
        return this.securityStrength;
    }

    public int getSeedLen() {
        return this.f1096p.getCurve().getFieldSize();
    }
}

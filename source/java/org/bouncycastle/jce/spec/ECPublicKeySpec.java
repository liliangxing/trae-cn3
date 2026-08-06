package org.bouncycastle.jce.spec;

import org.bouncycastle.math.ec.ECPoint;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class ECPublicKeySpec extends ECKeySpec {

    /* renamed from: q */
    private ECPoint f1170q;

    public ECPublicKeySpec(ECPoint eCPoint, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f1170q = eCPoint.getCurve() != null ? eCPoint.normalize() : eCPoint;
    }

    public ECPoint getQ() {
        return this.f1170q;
    }
}

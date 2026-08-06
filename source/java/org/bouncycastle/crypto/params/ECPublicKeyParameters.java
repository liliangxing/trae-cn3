package org.bouncycastle.crypto.params;

import org.bouncycastle.math.ec.ECPoint;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class ECPublicKeyParameters extends ECKeyParameters {

    /* renamed from: q */
    private final ECPoint f1055q;

    public ECPublicKeyParameters(ECPoint eCPoint, ECDomainParameters eCDomainParameters) {
        super(false, eCDomainParameters);
        this.f1055q = eCDomainParameters.validatePublicPoint(eCPoint);
    }

    public ECPoint getQ() {
        return this.f1055q;
    }
}

package org.bouncycastle.jce.interfaces;

import java.security.PublicKey;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface ECPublicKey extends ECKey, PublicKey {
    ECPoint getQ();
}

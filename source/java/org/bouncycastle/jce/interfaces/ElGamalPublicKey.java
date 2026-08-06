package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;

/* loaded from: classes8.dex */
public interface ElGamalPublicKey extends ElGamalKey, DHPublicKey {
    BigInteger getY();
}

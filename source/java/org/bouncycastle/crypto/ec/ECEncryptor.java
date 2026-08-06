package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.ECPoint;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface ECEncryptor {
    ECPair encrypt(ECPoint eCPoint);

    void init(CipherParameters cipherParameters);
}

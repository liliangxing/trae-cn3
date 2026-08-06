package org.bouncycastle.operator.p010bc;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.operator.OperatorCreationException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface BcDigestProvider {
    ExtendedDigest get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException;
}

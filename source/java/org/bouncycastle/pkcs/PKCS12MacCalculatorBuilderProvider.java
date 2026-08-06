package org.bouncycastle.pkcs;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface PKCS12MacCalculatorBuilderProvider {
    PKCS12MacCalculatorBuilder get(AlgorithmIdentifier algorithmIdentifier);
}

package org.bouncycastle.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface MacCalculatorProvider {
    MacCalculator get(AlgorithmIdentifier algorithmIdentifier);
}

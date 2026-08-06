package org.bouncycastle.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* loaded from: classes8.dex */
public interface DigestAlgorithmIdentifierFinder {
    AlgorithmIdentifier find(String str);

    AlgorithmIdentifier find(AlgorithmIdentifier algorithmIdentifier);
}

package org.bouncycastle.cert;

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface X509ContentVerifierProviderBuilder {
    ContentVerifierProvider build(SubjectPublicKeyInfo subjectPublicKeyInfo) throws OperatorCreationException;

    ContentVerifierProvider build(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException;
}

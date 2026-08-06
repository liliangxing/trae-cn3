package org.bouncycastle.cms;

import org.bouncycastle.operator.OperatorCreationException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface SignerInformationVerifierProvider {
    SignerInformationVerifier get(SignerId signerId) throws OperatorCreationException;
}

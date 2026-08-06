package org.bouncycastle.openssl;

import org.bouncycastle.operator.OperatorCreationException;

/* loaded from: classes8.dex */
public interface PEMDecryptorProvider {
    PEMDecryptor get(String str) throws OperatorCreationException;
}

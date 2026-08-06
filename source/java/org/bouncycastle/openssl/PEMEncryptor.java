package org.bouncycastle.openssl;

/* loaded from: classes8.dex */
public interface PEMEncryptor {
    byte[] encrypt(byte[] bArr) throws PEMException;

    String getAlgorithm();

    byte[] getIV();
}

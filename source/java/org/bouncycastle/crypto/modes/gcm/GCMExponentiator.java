package org.bouncycastle.crypto.modes.gcm;

/* loaded from: classes8.dex */
public interface GCMExponentiator {
    void exponentiateX(long j, byte[] bArr);

    void init(byte[] bArr);
}

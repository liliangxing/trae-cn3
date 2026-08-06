package org.bouncycastle.pqc.crypto.lms;

/* loaded from: classes8.dex */
public interface LMSContextBasedVerifier {
    LMSContext generateLMSContext(byte[] bArr);

    boolean verify(LMSContext lMSContext);
}

package org.bouncycastle.crypto.prng;

/* loaded from: classes8.dex */
public interface EntropySource {
    int entropySize();

    byte[] getEntropy();

    boolean isPredictionResistant();
}

package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class DigestingStateAwareMessageSigner extends DigestingMessageSigner {
    private final StateAwareMessageSigner signer;

    public DigestingStateAwareMessageSigner(StateAwareMessageSigner stateAwareMessageSigner, Digest digest) {
        super(stateAwareMessageSigner, digest);
        this.signer = stateAwareMessageSigner;
    }

    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        return this.signer.getUpdatedPrivateKey();
    }
}

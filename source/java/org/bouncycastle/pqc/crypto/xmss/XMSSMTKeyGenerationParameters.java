package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class XMSSMTKeyGenerationParameters extends KeyGenerationParameters {
    private final XMSSMTParameters xmssmtParameters;

    public XMSSMTKeyGenerationParameters(XMSSMTParameters xMSSMTParameters, SecureRandom secureRandom) {
        super(secureRandom, -1);
        this.xmssmtParameters = xMSSMTParameters;
    }

    public XMSSMTParameters getParameters() {
        return this.xmssmtParameters;
    }
}

package org.bouncycastle.crypto.engines;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class AESWrapEngine extends RFC3394WrapEngine {
    public AESWrapEngine() {
        super(new AESEngine());
    }

    public AESWrapEngine(boolean z) {
        super(new AESEngine(), z);
    }
}

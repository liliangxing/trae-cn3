package org.bouncycastle.crypto.engines;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class AESWrapPadEngine extends RFC5649WrapEngine {
    public AESWrapPadEngine() {
        super(new AESEngine());
    }
}

package org.bouncycastle.crypto.engines;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class ARIAWrapEngine extends RFC3394WrapEngine {
    public ARIAWrapEngine() {
        super(new ARIAEngine());
    }

    public ARIAWrapEngine(boolean z) {
        super(new ARIAEngine(), z);
    }
}

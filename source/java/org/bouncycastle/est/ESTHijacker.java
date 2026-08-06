package org.bouncycastle.est;

import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface ESTHijacker {
    ESTResponse hijack(ESTRequest eSTRequest, Source source) throws IOException;
}

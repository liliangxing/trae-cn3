package org.bouncycastle.operator;

import java.io.OutputStream;

/* loaded from: classes8.dex */
public interface AADProcessor {
    OutputStream getAADStream();

    byte[] getMAC();
}

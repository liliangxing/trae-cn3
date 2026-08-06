package org.bouncycastle.jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes8.dex */
public interface XDHPrivateKey extends XDHKey, PrivateKey {
    XDHPublicKey getPublicKey();
}

package org.bouncycastle.est;

/* loaded from: classes8.dex */
public interface ESTClientProvider {
    boolean isTrusted();

    ESTClient makeClient() throws ESTException;
}

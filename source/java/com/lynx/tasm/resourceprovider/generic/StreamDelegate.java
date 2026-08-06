package com.lynx.tasm.resourceprovider.generic;

/* loaded from: classes7.dex */
public interface StreamDelegate {
    void onData(byte[] bArr, int i, int i2);

    void onEnd();

    void onError(String str);

    void onStart(int i);
}

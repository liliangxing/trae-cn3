package com.bytedance.vmsdk.inspector_new.server.websocket;

/* loaded from: classes6.dex */
public interface SimpleSession {
    void close(int i, String str);

    boolean isOpen();

    void sendBinary(byte[] bArr);

    void sendText(String str);
}

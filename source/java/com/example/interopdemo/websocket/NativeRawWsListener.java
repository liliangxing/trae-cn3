package com.example.interopdemo.websocket;

import kotlin.Metadata;

/* compiled from: NativeRawWsListener.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/example/interopdemo/websocket/NativeRawWsListener;", "", "onBinaryMessage", "", "data", "", "onTextMessage", "", "onConnectStateChange", "state", "Lcom/example/interopdemo/websocket/NativeConnectionState;", "json", "onConnectionError", "kmpNativeInterface_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface NativeRawWsListener {
    void onBinaryMessage(byte[] data);

    void onConnectStateChange(NativeConnectionState state, String json);

    void onConnectionError(String json);

    void onTextMessage(String data);
}

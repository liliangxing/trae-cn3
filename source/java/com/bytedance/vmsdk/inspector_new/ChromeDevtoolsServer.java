package com.bytedance.vmsdk.inspector_new;

import android.util.Log;
import com.bytedance.vmsdk.inspector_new.server.websocket.SimpleEndpoint;
import com.bytedance.vmsdk.inspector_new.server.websocket.SimpleSession;

/* loaded from: classes6.dex */
public class ChromeDevtoolsServer implements SimpleEndpoint {
    private static final String TAG = "ChromeDevtoolsServer";
    private final IInspectorSession mInspectorSession;

    public ChromeDevtoolsServer(IInspectorSession iInspectorSession) {
        this.mInspectorSession = iInspectorSession;
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleEndpoint
    public void onOpen(SimpleSession simpleSession) {
        Log.d(TAG, "onOpen: ");
        this.mInspectorSession.onOpen(simpleSession);
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleEndpoint
    public void onMessage(SimpleSession simpleSession, String str) {
        this.mInspectorSession.onProtocolMessage(simpleSession, str);
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleEndpoint
    public void onMessage(SimpleSession simpleSession, byte[] bArr, int i) {
        Log.e(TAG, "onMessage: byte");
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleEndpoint
    public void onClose(SimpleSession simpleSession, int i, String str) {
        Log.w(TAG, "onClose: " + str);
        this.mInspectorSession.onClose(simpleSession);
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.websocket.SimpleEndpoint
    public void onError(SimpleSession simpleSession, Throwable th) {
        Log.e(TAG, th.getMessage());
        this.mInspectorSession.onClose(simpleSession);
    }
}

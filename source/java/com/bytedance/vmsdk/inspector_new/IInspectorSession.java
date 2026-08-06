package com.bytedance.vmsdk.inspector_new;

import com.bytedance.vmsdk.inspector_new.server.websocket.SimpleSession;

/* loaded from: classes6.dex */
public interface IInspectorSession {
    void onClose(SimpleSession simpleSession);

    void onOpen(SimpleSession simpleSession);

    boolean onProtocolMessage(SimpleSession simpleSession, String str);
}

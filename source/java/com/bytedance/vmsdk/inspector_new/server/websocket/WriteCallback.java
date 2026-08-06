package com.bytedance.vmsdk.inspector_new.server.websocket;

import java.io.IOException;

/* loaded from: classes6.dex */
interface WriteCallback {
    void onFailure(IOException iOException);

    void onSuccess();
}

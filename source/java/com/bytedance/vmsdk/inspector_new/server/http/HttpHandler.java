package com.bytedance.vmsdk.inspector_new.server.http;

import com.bytedance.vmsdk.inspector_new.server.SocketLike;
import java.io.IOException;

/* loaded from: classes6.dex */
public interface HttpHandler {
    boolean handleRequest(SocketLike socketLike, LightHttpRequest lightHttpRequest, LightHttpResponse lightHttpResponse) throws IOException;
}

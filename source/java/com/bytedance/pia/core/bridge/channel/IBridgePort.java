package com.bytedance.pia.core.bridge.channel;

import com.bytedance.pia.core.api.utils.IConsumer;
import com.google.gson.JsonObject;

/* loaded from: classes4.dex */
public interface IBridgePort {
    void close();

    void postMessage(JsonObject jsonObject);

    void setOnMessage(IConsumer<JsonObject> iConsumer);
}

package com.bytedance.pia.core.api.bridge;

import com.bytedance.pia.core.api.utils.IConsumer;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes4.dex */
public interface IWorkerBridgeHandle {
    default void initialize(String str) {
    }

    void onDestroy();

    void onWorkerBridgeCall(String str, String str2, JSONObject jSONObject, IConsumer<JSONObject> iConsumer);
}

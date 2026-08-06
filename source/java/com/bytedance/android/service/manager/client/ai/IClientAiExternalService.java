package com.bytedance.android.service.manager.client.ai;

import com.bytedance.android.push.service.manager.annotation.ExternalService;
import org.json.JSONObject;

@ExternalService
/* loaded from: classes3.dex */
public interface IClientAiExternalService {
    void init();

    boolean isClientAiReady();

    void registerClientAICallback(IClientAICallback iClientAICallback);

    void runTask(JSONObject jSONObject);
}

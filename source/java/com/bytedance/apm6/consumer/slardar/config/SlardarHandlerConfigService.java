package com.bytedance.apm6.consumer.slardar.config;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface SlardarHandlerConfigService {
    SlardarHandlerConfig getConfig();

    void setOutsideConfig(JSONObject jSONObject);
}

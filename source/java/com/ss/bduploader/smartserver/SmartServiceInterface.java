package com.ss.bduploader.smartserver;

import com.ss.ugc.clientai.core.api.SmartInputData;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface SmartServiceInterface {
    void configServer();

    int getIntelligentInput(JSONObject jSONObject, SmartInputData smartInputData);

    void preloadEnv();

    void runAsync(Map map, SmartServiceListener smartServiceListener);

    float runAsyncJsonObject(JSONObject jSONObject, SmartServiceListener smartServiceListener);

    float runSync(Map map);

    float runSyncJsonObject(JSONObject jSONObject);

    boolean serviceEnabled();

    void setIntValue(int i, int i2);

    void setStringValue(int i, String str);
}

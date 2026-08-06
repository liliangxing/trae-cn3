package com.bytedance.services.slardar.config;

import com.bytedance.news.common.service.manager.IService;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IConfigManager extends IService {
    void fetchConfig();

    int getConfigInt(String str, int i);

    JSONObject getConfigJSON(String str);

    boolean getLogTypeSwitch(String str);

    boolean getMetricTypeSwitch(String str);

    boolean getServiceSwitch(String str);

    boolean getSwitch(String str);

    boolean isConfigReady();

    String queryConfig();

    void registerConfigListener(IConfigListener iConfigListener);

    void registerResponseConfigListener(IResponseConfigListener iResponseConfigListener);

    JSONObject retrieveSettingsParams();

    void unregisterConfigListener(IConfigListener iConfigListener);

    void unregisterResponseConfigListener(IResponseConfigListener iResponseConfigListener);

    boolean updateWithSpecificAidResult(JSONObject jSONObject);
}

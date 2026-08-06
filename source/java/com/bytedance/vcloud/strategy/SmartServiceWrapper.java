package com.bytedance.vcloud.strategy;

import android.util.Log;
import com.ss.ugc.clientai.core.api.SmartInputData;
import com.ss.ugc.clientai.core.api.SmartOutputData;
import com.ss.ugc.clientai.core.api.SmartService;
import com.ss.ugc.clientai.core.api.SmartServiceConfig;
import com.ss.ugc.clientai.core.api.SmartServiceManager;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class SmartServiceWrapper {
    private static final String LOG_TAG = "VCStrategy";
    private static final String SERVER_NAME = "vod_smart_speed";
    private SmartService mSmartServiceInstance;

    public Boolean configServer(String str) {
        SmartService commonService = SmartServiceManager.instance().getCommonService(SERVER_NAME);
        this.mSmartServiceInstance = commonService;
        if (commonService != null) {
            SmartServiceConfig smartServiceConfig = new SmartServiceConfig(SERVER_NAME);
            Map configMap = smartServiceConfig.configMap();
            configMap.put("engineType", "mlsdk");
            configMap.put("outputType", "regression");
            configMap.put("packageUrl", str);
            this.mSmartServiceInstance.configService(smartServiceConfig);
            return true;
        }
        return false;
    }

    public void preloadEnv() {
        SmartService smartService = this.mSmartServiceInstance;
        if (smartService != null) {
            smartService.preloadEnv();
        }
    }

    public float predictSmartSlice(JSONObject jSONObject) {
        SmartInputData smartInputData = new SmartInputData();
        if (-1 == getIntelligentInput(jSONObject, smartInputData)) {
            Log.d(LOG_TAG, "getIntelligentInput failed");
            return -1.0f;
        }
        SmartService smartService = this.mSmartServiceInstance;
        if (smartService == null) {
            if (smartService == null) {
                Log.d(LOG_TAG, "mSmartServiceInstance is null");
                return -1.0f;
            }
            Log.d(LOG_TAG, "mSmartServiceInstance is not ready");
            return -1.0f;
        }
        SmartOutputData runSync = smartService.runSync(smartInputData);
        if (runSync == null || !runSync.success() || runSync.getValue() == null) {
            return -1.0f;
        }
        return runSync.getValue().floatValue();
    }

    public float getLastResult() {
        SmartOutputData lastResult;
        SmartService smartService = this.mSmartServiceInstance;
        if (smartService == null || !smartService.isEnvReady() || (lastResult = this.mSmartServiceInstance.lastResult()) == null || !lastResult.success() || lastResult.getValue() == null) {
            return -1.0f;
        }
        return lastResult.getValue().floatValue();
    }

    public int getIntelligentInput(JSONObject jSONObject, SmartInputData smartInputData) {
        Map inputMap = smartInputData.inputMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if ((obj instanceof JSONArray) && ((JSONArray) obj).length() > 0) {
                    inputMap.put(next, jsonArray2FloatArray((JSONArray) obj));
                } else {
                    inputMap.put(next, obj);
                }
            }
            return 0;
        } catch (JSONException unused) {
            return -1;
        }
    }

    public float[] jsonArray2FloatArray(JSONArray jSONArray) {
        float[] fArr = new float[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            fArr[i] = (float) jSONArray.optDouble(i, 0.0d);
        }
        return fArr;
    }

    public float parseIntelligentInputFromJson(JSONObject jSONObject, String str) {
        try {
            return (float) jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return 0.0f;
        }
    }
}

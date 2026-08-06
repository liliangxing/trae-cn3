package com.ss.bduploader.smartserver;

import android.text.TextUtils;
import android.util.Log;
import com.ss.ugc.clientai.core.api.SmartInputData;
import com.ss.ugc.clientai.core.api.SmartOutputData;
import com.ss.ugc.clientai.core.api.SmartService;
import com.ss.ugc.clientai.core.api.SmartServiceConfig;
import com.ss.ugc.clientai.core.api.SmartServiceManager;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SmartServiceWrapper implements SmartServiceInterface {
    public static final int KEY_IS_MLSDK_ENGINE_TYPE = 1000;
    public static final int KEY_IS_MLSDK_OUTPUT_TYPE = 1002;
    public static final int KEY_IS_MLSDK_SERVICE_NAME = 1001;
    public static final int KEY_IS_MLSDK_URL = 1003;
    public static final int KeyIsIntelligentClassification = 1;
    public static final int KeyIsIntelligentRegression = 0;
    private SmartService mMLSDKService;
    private String mMLSDKEngineType = "";
    private String mMLSDKServiceName = "";
    private String mMLSDKOutputType = "";
    private String mIntelligentURL = "";

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void runAsync(Map map, SmartServiceListener smartServiceListener) {
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runAsyncJsonObject(JSONObject jSONObject, SmartServiceListener smartServiceListener) {
        return 0.0f;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runSyncJsonObject(JSONObject jSONObject) {
        return 0.0f;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void setIntValue(int i, int i2) {
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void setStringValue(int i, String str) {
        switch (i) {
            case 1000:
                this.mMLSDKEngineType = str;
                return;
            case 1001:
                this.mMLSDKServiceName = str;
                return;
            case 1002:
                this.mMLSDKOutputType = str;
                return;
            case 1003:
                this.mIntelligentURL = str;
                return;
            default:
                return;
        }
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void configServer() {
        if (TextUtils.isEmpty(this.mMLSDKEngineType) || TextUtils.isEmpty(this.mMLSDKOutputType) || TextUtils.isEmpty(this.mMLSDKServiceName) || TextUtils.isEmpty(this.mIntelligentURL)) {
            return;
        }
        SmartService commonService = SmartServiceManager.instance().getCommonService(this.mMLSDKServiceName);
        this.mMLSDKService = commonService;
        if (commonService != null) {
            Log.d("intelligent_wrapper", "service valid");
            SmartServiceConfig smartServiceConfig = new SmartServiceConfig(this.mMLSDKServiceName);
            Map configMap = smartServiceConfig.configMap();
            configMap.put("engineType", this.mMLSDKEngineType);
            configMap.put("outputType", this.mMLSDKOutputType);
            configMap.put("packageUrl", this.mIntelligentURL);
            this.mMLSDKService.configService(smartServiceConfig);
        }
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void preloadEnv() {
        SmartService smartService = this.mMLSDKService;
        if (smartService != null) {
            smartService.preloadEnv();
        }
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public boolean serviceEnabled() {
        SmartService smartService = this.mMLSDKService;
        return smartService != null && smartService.enable();
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runSync(Map map) {
        SmartOutputData runSync;
        Log.d("intelligent_wrapper", "syncMap" + map);
        SmartInputData smartInputData = new SmartInputData();
        Map inputMap = smartInputData.inputMap();
        for (Object obj : map.keySet()) {
            inputMap.put(obj, map.get(obj));
        }
        SmartService smartService = this.mMLSDKService;
        if (smartService == null || !smartService.enable() || (runSync = this.mMLSDKService.runSync(smartInputData)) == null || !runSync.success() || runSync.getValue() == null) {
            return -1.0f;
        }
        return runSync.getValue().floatValue();
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public int getIntelligentInput(JSONObject jSONObject, SmartInputData smartInputData) {
        Log.d("intelligent_speedtest", "speed test input info is " + jSONObject);
        Map inputMap = smartInputData.inputMap();
        try {
            if (jSONObject.getJSONObject("optimized_info") != null) {
                if (jSONObject.getInt("origin_speed_test") > 0) {
                    Log.d("intelligent_speedtest", "input is valid");
                    inputMap.put("origin_speed_test", Float.valueOf(parseIntelligentInputFloat(jSONObject, "origin_speed_test", 0)));
                    inputMap.put("init_rtt", Double.valueOf(parseIntelligentInputFloat(jSONObject, "init_rtt", 1) / 1000.0d));
                    inputMap.put("close_rtt", Double.valueOf(parseIntelligentInputFloat(jSONObject, "close_rtt", 1) / 1000.0d));
                    inputMap.put("mss", Float.valueOf(parseIntelligentInputFloat(jSONObject, "mss", 1)));
                    inputMap.put("inner_time", Double.valueOf(parseIntelligentInputFloat(jSONObject, "inner", 1) / 1000.0d));
                    inputMap.put("origin_time", Double.valueOf(parseIntelligentInputFloat(jSONObject, "origin", 1) / 1000.0d));
                    String parseIntelligentInputString = parseIntelligentInputString(jSONObject, "apply_start", 0);
                    String parseIntelligentInputString2 = parseIntelligentInputString(jSONObject, "apply_end", 0);
                    if (!parseIntelligentInputString2.isEmpty() && !parseIntelligentInputString.isEmpty()) {
                        float longValue = (float) (Long.valueOf(parseIntelligentInputString2).longValue() - Long.valueOf(parseIntelligentInputString).longValue());
                        if (longValue < 0.0f) {
                            return -1;
                        }
                        Log.d("intelligent_speedtest", "apply duration is valid");
                        inputMap.put("apply_duration", Float.valueOf(longValue));
                        String parseIntelligentInputString3 = parseIntelligentInputString(jSONObject, "node_type", 0);
                        parseIntelligentInputString3.hashCode();
                        if (parseIntelligentInputString3.equals("Origin")) {
                            inputMap.put("node_type", Float.valueOf(2.0f));
                        } else if (parseIntelligentInputString3.equals("Edge")) {
                            inputMap.put("node_type", Float.valueOf(1.0f));
                        } else {
                            inputMap.put("node_type", Float.valueOf(0.0f));
                        }
                        return 0;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    private float parseIntelligentInputFloat(JSONObject jSONObject, String str, int i) {
        double d;
        try {
            if (i == 1) {
                d = jSONObject.getJSONObject("optimized_info").getDouble(str);
            } else {
                d = jSONObject.getDouble(str);
            }
            return (float) d;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    private String parseIntelligentInputString(JSONObject jSONObject, String str, int i) {
        String string;
        try {
            if (i == 1) {
                string = jSONObject.getJSONObject("optimized_info").getString(str);
            } else {
                string = jSONObject.getString(str);
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }
}

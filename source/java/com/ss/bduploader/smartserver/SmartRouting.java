package com.ss.bduploader.smartserver;

import android.util.Log;
import com.bytedance.sdk.xbridge.cn.websocket.utils.TTNetWebSocketUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SmartRouting extends SmartAbstract {
    private static final String ENGINE_TYPE = "mlsdk";
    private static final String OUTPUT_TYPE = "regression";
    private static final String SERVER_NAME = "smart_upload_tcp_quic";
    private SmartServiceInterface mIntelligentService;
    private String mIntelligentURL = "";

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void init() {
        this.mIntelligentService = new SmartServiceWrapper();
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void configServer() {
        Log.d("intelligent_routing", "config_server engine_type: mlsdk outputType: regression service name: smart_upload_tcp_quic engineType: mlsdk model_url: " + this.mIntelligentURL);
        this.mIntelligentService.setStringValue(1000, ENGINE_TYPE);
        this.mIntelligentService.setStringValue(1001, SERVER_NAME);
        this.mIntelligentService.setStringValue(1002, OUTPUT_TYPE);
        this.mIntelligentService.setStringValue(1003, this.mIntelligentURL);
        this.mIntelligentService.configServer();
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void preloadEnv() {
        SmartServiceInterface smartServiceInterface = this.mIntelligentService;
        if (smartServiceInterface != null) {
            smartServiceInterface.preloadEnv();
        }
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public float predictSpeedSync(JSONObject jSONObject) {
        Log.d("intelligent_routing", "predict float value intelligent");
        if (!this.mIntelligentService.serviceEnabled()) {
            return -1.0f;
        }
        Log.d("intelligent_speedtest", "service is valid");
        Map hashMap = new HashMap();
        try {
            if (jSONObject.getInt("routing_using_vcn") == 1) {
                hashMap = getIntelligentInput(jSONObject);
            } else if (jSONObject.getInt("routing_using_vcn") == 0) {
                hashMap = getIntelligentInputTTNet(jSONObject);
            }
            if (hashMap == null) {
                Log.d("intelligent_speedtest", "input processing invalid");
                return -1.0f;
            }
            return this.mIntelligentService.runSync(hashMap);
        } catch (Exception unused) {
            return -1.0f;
        }
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void parseUrl(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Log.d("intelligent_routing", "parse url" + str);
            this.mIntelligentURL = jSONObject.getString("intelligent_model_url");
        } catch (Exception unused) {
            this.mIntelligentURL = "";
        }
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void setUrl(String str) {
        this.mIntelligentURL = str;
    }

    public Map getIntelligentInputTTNet(JSONObject jSONObject) {
        Log.d("intelligent_routing", "routing ttnet input info is " + jSONObject);
        HashMap hashMap = new HashMap();
        try {
            if (jSONObject.getInt("est_file_size") > 0 && jSONObject.getJSONObject("tcp_domain") != null && jSONObject.getJSONObject("quic_domain") != null) {
                List asList = Arrays.asList(TTNetWebSocketUtil.TRANSPORT_PROTOCOL_TCP, TTNetWebSocketUtil.TRANSPORT_PROTOCOL_QUIC);
                List<String> asList2 = Arrays.asList("SeverSpeed", "speed", "duration", "routing_request_log.timing.detailed_duration.inner", "routing_request_log.timing.detailed_duration.send", "routing_request_log.timing.detailed_duration.ttfb", "routing_request_log.timing.request.duration");
                List<String> asList3 = Arrays.asList("routing_request_log.nqe.http_rtt", "routing_request_log.nqe.tcp_rtt", "routing_request_log.nqe.downlink_throughput", "routing_request_log.nqe.real_net_type", "routing_request_log.nqe.effective_net_type");
                for (int i = 0; i < asList.size(); i++) {
                    String str = (String) asList.get(i);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str + "_domain");
                    for (String str2 : asList2) {
                        List list = asList;
                        String str3 = str + "_" + str2.split("\\.")[r9.length - 1].toLowerCase(Locale.US);
                        if (str2.equals("duration")) {
                            str3 = str3 + "_bd";
                        }
                        float valueForKey = getValueForKey(jSONObject2, str2);
                        if (valueForKey == -1.0f) {
                            return null;
                        }
                        hashMap.put(str3, Float.valueOf(valueForKey));
                        asList = list;
                    }
                }
                for (String str4 : asList3) {
                    hashMap.put(str4.split("\\.")[r7.length - 1].toLowerCase(Locale.US), Float.valueOf(getValueForKey(jSONObject.getJSONObject("tcp_domain"), str4)));
                }
                float parseIntelligentInputFloat = parseIntelligentInputFloat(jSONObject, "est_file_size", 0);
                if (parseIntelligentInputFloat <= 0.0f) {
                    return null;
                }
                hashMap.put("est_file_size", Float.valueOf(parseIntelligentInputFloat));
                return hashMap;
            }
            return null;
        } catch (Exception e) {
            Log.e("exception", String.valueOf(e));
            return null;
        }
    }

    public Map getIntelligentInput(JSONObject jSONObject) {
        Log.d("intelligent_routing", "speed test input info is " + jSONObject);
        HashMap hashMap = new HashMap();
        try {
            if (jSONObject.getInt("est_file_size") > 0 && jSONObject.getJSONObject("optimized_info") != null) {
                if (jSONObject.getInt("origin_speed_test") > 0) {
                    Log.d("intelligent_routing", "input is valid");
                    hashMap.put("origin_speed_test", Float.valueOf(parseIntelligentInputFloat(jSONObject, "origin_speed_test", 0)));
                    hashMap.put("speed_test_protocol", Float.valueOf(parseIntelligentInputFloat(jSONObject, "speed_test_protocol", 0)));
                    hashMap.put("init_rtt", Double.valueOf(parseIntelligentInputFloat(jSONObject, "init_rtt", 1) / 1000.0d));
                    hashMap.put("close_rtt", Double.valueOf(parseIntelligentInputFloat(jSONObject, "close_rtt", 1) / 1000.0d));
                    hashMap.put("mss", Float.valueOf(parseIntelligentInputFloat(jSONObject, "mss", 1)));
                    hashMap.put("inner_time", Double.valueOf(parseIntelligentInputFloat(jSONObject, "inner", 1) / 1000.0d));
                    hashMap.put("origin_time", Double.valueOf(parseIntelligentInputFloat(jSONObject, "origin", 1) / 1000.0d));
                    Log.d("intelligent_routing", "grab file_size info");
                    hashMap.put("est_file_size", Float.valueOf(parseIntelligentInputFloat(jSONObject, "est_file_size", 0)));
                    return hashMap;
                }
            }
        } catch (Exception unused) {
        }
        return null;
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

    private float getValueForKey(JSONObject jSONObject, String str) {
        String[] split = str.split("\\.");
        for (int i = 0; i < split.length - 1; i++) {
            try {
                jSONObject = jSONObject.getJSONObject(split[i]);
            } catch (Exception unused) {
                Log.e("intelligent_routing", "value of key" + split + "invalid" + jSONObject);
                return -1.0f;
            }
        }
        String str2 = split[split.length - 1];
        if (jSONObject.has(str2)) {
            return (float) jSONObject.getDouble(str2);
        }
        return -1.0f;
    }
}

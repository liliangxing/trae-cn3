package com.bytedance.apm6.consumer.slardar.send.downgrade;

import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.forest.model.PreloadConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DowngradeInfo {
    public static final String FIELD_DURATION = "duration";
    public static final String FIELD_EXPIRE_TIME = "expire_time";
    public long expireTime;
    public Map<LogType, SubInfo> mEventMap = new HashMap();

    /* loaded from: classes3.dex */
    static class SubInfo {
        public static final String FIELD_DEFAULT_RATE = "default";
        public Map<String, JSONObject> aidMap = new HashMap();
        public boolean defaultRate;

        SubInfo() {
        }

        public static SubInfo parse(JSONObject jSONObject) {
            JSONObject optJSONObject;
            SubInfo subInfo = new SubInfo();
            subInfo.defaultRate = jSONObject.optInt("default", 1) == 1;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.equals(next, "default") && (optJSONObject = jSONObject.optJSONObject(next)) != null) {
                    subInfo.aidMap.put(next, optJSONObject);
                }
            }
            return subInfo;
        }

        public JSONObject toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("default", this.defaultRate ? 1 : 0);
                for (Map.Entry<String, JSONObject> entry : this.aidMap.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    public static DowngradeInfo parse(JSONObject jSONObject) {
        if (ApmContext.isDebugMode()) {
            Logger.i(Constants.TAG, "DowngradeRule=" + jSONObject.toString());
        }
        DowngradeInfo downgradeInfo = new DowngradeInfo();
        long optLong = jSONObject.optLong("duration", 0L);
        long optLong2 = jSONObject.optLong("expire_time", 0L);
        if (optLong2 > 0) {
            downgradeInfo.expireTime = optLong2;
        } else {
            downgradeInfo.expireTime = System.currentTimeMillis() + (optLong * 1000);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(LogType.OTHER_LOG_TYPE.logType);
        if (optJSONObject != null) {
            downgradeInfo.mEventMap.put(LogType.OTHER_LOG_TYPE, SubInfo.parse(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject(LogType.SERVICE_MONITOR.logType);
        if (optJSONObject2 != null) {
            downgradeInfo.mEventMap.put(LogType.SERVICE_MONITOR, SubInfo.parse(optJSONObject2));
        }
        return downgradeInfo;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expire_time", this.expireTime);
            for (Map.Entry<LogType, SubInfo> entry : this.mEventMap.entrySet()) {
                jSONObject.put(entry.getKey().logType, entry.getValue().toJson());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public enum LogType {
        OTHER_LOG_TYPE(PreloadConfig.KEY_OTHER),
        SERVICE_MONITOR("service_monitor");

        public final String logType;

        LogType(String str) {
            this.logType = str;
        }
    }
}

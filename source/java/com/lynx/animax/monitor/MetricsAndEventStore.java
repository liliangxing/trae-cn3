package com.lynx.animax.monitor;

import com.huawei.hms.framework.common.ContainerUtils;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.base.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MetricsAndEventStore {
    private final ReadableMap mCategoryMap;
    private final ReadableMap mMetricsMap;

    public MetricsAndEventStore(ReadableMap readableMap, ReadableMap readableMap2, Map<String, Object> map, String str) {
        HashMap<String, Object> hashMap = readableMap == null ? new HashMap<>() : readableMap.asHashMap();
        HashMap<String, Object> hashMap2 = readableMap2 == null ? new HashMap<>() : readableMap2.asHashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                if (value instanceof Number) {
                    hashMap.put(key, value);
                } else if ((value instanceof String) || (value instanceof Boolean)) {
                    hashMap2.put(key, value);
                }
            }
        }
        if (str != null) {
            hashMap2.put("default", str);
        }
        this.mMetricsMap = JavaOnlyMap.from(hashMap);
        this.mCategoryMap = JavaOnlyMap.from(hashMap2);
    }

    public double getFps() {
        return this.mMetricsMap.getDouble(AnimaXMonitorUtil.KEY_FPS, 0.0d);
    }

    public Map<String, Object> getMetricsAsMap() {
        return new HashMap(this.mMetricsMap.asHashMap());
    }

    public JSONObject getMetricsAsJSON() {
        return AnimaXMonitorUtil.convertHashMapIntoJSON(getMetricsAsMap());
    }

    public Map<String, Object> getCategoryAsMap() {
        return new HashMap(this.mCategoryMap.asHashMap());
    }

    public JSONObject getCategoryAsJSON() {
        return AnimaXMonitorUtil.convertHashMapIntoJSON(getCategoryAsMap());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PerfMetrics{");
        for (Map.Entry<String, Object> entry : this.mMetricsMap.asHashMap().entrySet()) {
            if (entry.getValue() != null) {
                sb.append(entry.getKey()).append(ContainerUtils.KEY_VALUE_DELIMITER).append(entry.getValue()).append(",");
            }
        }
        for (Map.Entry<String, Object> entry2 : this.mCategoryMap.asHashMap().entrySet()) {
            if (entry2.getValue() != null) {
                sb.append(entry2.getKey()).append(ContainerUtils.KEY_VALUE_DELIMITER).append(entry2.getValue()).append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

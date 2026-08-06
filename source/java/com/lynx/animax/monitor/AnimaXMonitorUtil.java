package com.lynx.animax.monitor;

import android.net.Uri;
import com.lynx.animax.util.AnimaXLog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class AnimaXMonitorUtil {
    public static final String CLASS_PERF_METRICS = "PerfMetrics";
    public static final String ERROR_EVENT_NAME = "animax_error";
    public static final String KEY_CODE = "code";
    public static final String KEY_FPS = "FPS";
    public static final String KEY_MESSAGE = "msg";
    public static final String KEY_PAGE_URL = "page_url";
    public static final String KEY_SRC_URL = "src_url";
    public static final long MAXIMUM_PLAY_COUNT = 5;
    public static final long MINIMUM_INTERVAL_TIME = 300000;
    public static final String PERFORMANCE_EVENT_NAME = "animax_performance";
    public static final String PLATFORM_KEY_DISPLAY_MODE = "display_mode";
    public static final String PLATFORM_KEY_PLAY_COUNT = "play_count";
    public static final String PLATFORM_KEY_STAY_DURATION = "stay_duration";
    public static final String PLATFORM_KEY_TAG = "tag";
    public static final String TAG = "AnimaXMonitor";
    public static final String TRIGGER_DEFAULT = "default";
    public static final String TRIGGER_ON_PLAY = "onPlay";
    public static final String TRIGGER_ON_RELEASE = "onRelease";

    public static String clearUrlQuery(String str) {
        if (str == null) {
            return "unknown";
        }
        try {
            return !str.isEmpty() ? Uri.parse(str).buildUpon().clearQuery().build().toString() : "unknown";
        } catch (UnsupportedOperationException e) {
            AnimaXLog.e(TAG, "clearUrlQuery failed, error: " + e.toString());
            return "unknown";
        }
    }

    public static JSONObject convertHashMapIntoJSON(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            AnimaXLog.e(TAG, "Converting hashMap to JSON failed, error: " + e.toString());
        }
        return jSONObject;
    }
}

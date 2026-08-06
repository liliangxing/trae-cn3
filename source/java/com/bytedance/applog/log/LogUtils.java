package com.bytedance.applog.log;

import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.Event;
import com.bytedance.applog.store.EventMisc;
import com.bytedance.applog.store.EventV3;
import com.bytedance.applog.store.ForwardEvent;
import com.bytedance.applog.store.Launch;
import com.bytedance.applog.store.Page;
import com.bytedance.applog.store.Terminate;
import com.bytedance.applog.util.JsonUtils;
import com.bytedance.applog.util.Utils;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LogUtils {
    public static final String EVENT_TYPE_EVENT_V3 = "EVENT_V3";
    public static final String EVENT_TYPE_FORWARD_EVENT = "FORWARD_EVENT";
    public static final String EVENT_TYPE_LAUNCH = "LAUNCH";
    public static final String EVENT_TYPE_LOG_DATA = "LOG_DATA";
    public static final String EVENT_TYPE_PROFILE = "PROFILE";
    public static final String EVENT_TYPE_TERMINATE = "TERMINATE";
    public static final String EVENT_TYPE_TRACE = "TRACE";
    private static final String KEY_LOCAL_EVENT_ID = "$$EVENT_LOCAL_ID";
    private static volatile Boolean buzEnabled = false;

    public static void setEnable(boolean z) {
        buzEnabled = Boolean.valueOf(z);
    }

    public static boolean isDisabled() {
        return !buzEnabled.booleanValue();
    }

    public static void sendJsonFetcher(String str, EventBus.DataFetcher dataFetcher) {
        if (isDisabled() || Utils.isEmpty(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(wrapEvent(str), dataFetcher);
    }

    public static void sendString(String str, String str2) {
        if (isDisabled() || Utils.isEmpty(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(wrapEvent(str), str2);
    }

    public static void sendJson(String str, JSONObject jSONObject) {
        if (isDisabled() || Utils.isEmpty(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(wrapEvent(str), jSONObject);
    }

    public static void sendObject(String str, final Object obj) {
        if (isDisabled() || Utils.isEmpty(str)) {
            return;
        }
        if (obj instanceof BaseData) {
            EventBus.global.get(new Object[0]).emit(wrapEvent(str), new EventBus.DataFetcher() { // from class: com.bytedance.applog.log.LogUtils.1
                @Override // com.bytedance.applog.log.EventBus.DataFetcher
                public Object fetch() {
                    JSONObject packJson = ((BaseData) obj).toPackJson();
                    JSONObject jSONObject = new JSONObject();
                    JsonUtils.mergeJsonObject(packJson, jSONObject);
                    try {
                        jSONObject.put("$$APP_ID", ((BaseData) obj).getAppId());
                        jSONObject.put("$$EVENT_TYPE", LogUtils.extractEventType((BaseData) obj));
                        jSONObject.put("$$PRIORITY", ((BaseData) obj).getPriority());
                        jSONObject.put(LogUtils.KEY_LOCAL_EVENT_ID, ((BaseData) obj).eventId);
                    } catch (JSONException unused) {
                    }
                    return jSONObject;
                }
            });
        } else {
            EventBus.global.get(new Object[0]).emit(wrapEvent(str), obj);
        }
    }

    private static String wrapEvent(String str) {
        return "applog_" + str;
    }

    public static String extractEventType(BaseData baseData) {
        if (baseData == null) {
            return "";
        }
        if (baseData instanceof ForwardEvent) {
            return EVENT_TYPE_FORWARD_EVENT;
        }
        if (baseData instanceof EventV3) {
            return "applog_trace".equals(((EventV3) baseData).getEvent()) ? EVENT_TYPE_TRACE : EVENT_TYPE_EVENT_V3;
        }
        if (baseData instanceof Page) {
            return EVENT_TYPE_EVENT_V3;
        }
        if (baseData instanceof Event) {
            return ((Event) baseData).category.toUpperCase(Locale.ROOT);
        }
        return baseData instanceof Launch ? EVENT_TYPE_LAUNCH : baseData instanceof Terminate ? EVENT_TYPE_TERMINATE : baseData instanceof EventMisc ? EVENT_TYPE_LOG_DATA : "";
    }
}

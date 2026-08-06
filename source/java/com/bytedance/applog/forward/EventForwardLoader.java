package com.bytedance.applog.forward;

import android.content.SharedPreferences;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventForwardLoader {
    public static final long DEFAULT_INTERVAL = 60000;
    public static final String KEY_APPLOG_FORWARD = "applog_forward";
    public static final String KEY_EVENT_FORWARD_BATCH_EVENT_INTERVAL = "interval";
    public static final String KEY_EVENT_FORWARD_ENABLE = "enable";
    public static final String KEY_EVENT_FORWARD_EVENTS = "events";
    public static final String KEY_EVENT_FORWARD_HOST = "forward_report_host";
    public static final String KEY_EVENT_FORWARD_OPEN = "forward_open";
    public static final String KEY_EVENT_FORWARD_PATH = "forward_report_path";
    public static final String KEY_EVENT_FORWARD_VERSION = "version";

    public static EventForward parseFromServer(AppLogInstance appLogInstance, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(KEY_APPLOG_FORWARD);
        if (optJSONObject == null) {
            return null;
        }
        EventForward parseFromServerJson = EventForward.parseFromServerJson(optJSONObject);
        SharedPreferences.Editor edit = appLogInstance.getContext().getSharedPreferences(getSpName(appLogInstance), 0).edit();
        edit.putInt("version", parseFromServerJson.getVersion());
        edit.putLong("interval", parseFromServerJson.getInterval());
        edit.putStringSet(KEY_EVENT_FORWARD_EVENTS, parseFromServerJson.getEvents());
        edit.putString(KEY_EVENT_FORWARD_HOST, parseFromServerJson.getHost());
        edit.putString(KEY_EVENT_FORWARD_PATH, parseFromServerJson.getPath());
        edit.putInt(KEY_EVENT_FORWARD_OPEN, parseFromServerJson.getOpen());
        edit.apply();
        return parseFromServerJson;
    }

    public static EventForward parseFromLocal(AppLogInstance appLogInstance) {
        EventForward eventForward = new EventForward();
        SharedPreferences sharedPreferences = appLogInstance.getContext().getSharedPreferences(getSpName(appLogInstance), 0);
        int i = sharedPreferences.getInt("version", -1);
        if (i == -1) {
            return null;
        }
        eventForward.setVersion(i);
        eventForward.setInterval(sharedPreferences.getLong("interval", 60000L));
        eventForward.addEvents(sharedPreferences.getStringSet(KEY_EVENT_FORWARD_EVENTS, new HashSet()));
        eventForward.setPath(sharedPreferences.getString(KEY_EVENT_FORWARD_PATH, ""));
        eventForward.setHost(sharedPreferences.getString(KEY_EVENT_FORWARD_HOST, ""));
        eventForward.setOpen(sharedPreferences.getInt(KEY_EVENT_FORWARD_OPEN, 0));
        return eventForward;
    }

    private static String getSpName(AppLogInstance appLogInstance) {
        return AppLogHelper.getInstanceSpName(appLogInstance, KEY_APPLOG_FORWARD);
    }
}

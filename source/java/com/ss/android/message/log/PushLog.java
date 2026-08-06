package com.ss.android.message.log;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.app.MessageAppHooks;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PushLog {
    public static final String CATEGORY = "event_v1";
    public static final String EVENT_LABEL_TEST = "click_headline";
    public static final String EVENT_SIGN = "_event_v3";
    public static final String EVENT_TAG_TEST1 = "go_detail";
    public static final String EVENT_TAG_TEST2 = "video_play";
    public static final String EVENT_V3_CATEGORY = "event_v3";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_EXT_JSON = "ext_json";
    public static final String KEY_EXT_VALUE = "ext_value";
    public static final String KEY_LABEL = "label";
    public static final String KEY_TAG = "tag";
    public static final String KEY_VALUE = "value";

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        onEvent(context, str, str2, str3, j, j2, jSONObject, false);
    }

    public static void onEvent(final Context context, final String str, final String str2, final String str3, final long j, final long j2, final JSONObject jSONObject, boolean z) {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return;
        }
        if (!z && ToolUtils.isMainProcess(context)) {
            MessageAppHooks.getPushHook().onEvent(context, str, str2, str3, j, j2, jSONObject);
        } else {
            new ThreadPlus() { // from class: com.ss.android.message.log.PushLog.1
                @Override // com.bytedance.common.utility.concurrent.ThreadPlus, java.lang.Runnable
                public void run() {
                    try {
                        LogEvent logEvent = new LogEvent();
                        logEvent.category = str;
                        logEvent.tag = str2;
                        logEvent.label = str3;
                        logEvent.value = j;
                        logEvent.ext_value = j2;
                        JSONObject jSONObject2 = jSONObject;
                        if (jSONObject2 != null) {
                            logEvent.ext_json = jSONObject2.toString();
                        }
                        if (Logger.debug()) {
                            Logger.d("PushLog", "category = " + logEvent.category + " tag = " + logEvent.tag + " label = " + logEvent.label + " value = " + logEvent.value + " ext_value = " + j2 + " ext_json = " + logEvent.ext_json);
                        }
                        DBHelper dBHelper = DBHelper.getInstance(context);
                        if (dBHelper != null) {
                            dBHelper.insertEvent(logEvent);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public static void onEventNow(String str, JSONObject jSONObject) {
        try {
            jSONObject.put("_event_v3", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogEvent logEvent = new LogEvent();
        logEvent.category = "event_v3";
        logEvent.tag = str;
        logEvent.ext_json = jSONObject.toString();
        if (Logger.debug()) {
            Logger.d("PushLog", "category = " + logEvent.category + " tag = " + logEvent.tag + " label = " + logEvent.label + " value = " + logEvent.value + " ext_json = " + logEvent.ext_json);
        }
        DBHelper dBHelper = DBHelper.getInstance(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication);
        if (dBHelper != null) {
            dBHelper.insertEvent(logEvent);
        }
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2) {
        onEvent(context, str, str2, str3, j, j2, null);
    }

    public static void onEvent(Context context, String str, String str2, JSONObject... jSONObjectArr) {
        if (jSONObjectArr != null && jSONObjectArr.length > 0) {
            onEvent(context, "event_v1", str, str2, 0L, 0L, jSONObjectArr[0]);
        } else {
            onEvent(context, "event_v1", str, str2, 0L, 0L, null);
        }
    }

    public static void onEvent(Context context, String str, JSONObject... jSONObjectArr) {
        if (jSONObjectArr != null && jSONObjectArr.length > 0) {
            onEvent(context, "event_v1", str, null, 0L, 0L, jSONObjectArr[0]);
        } else {
            onEvent(context, "event_v1", str, null, 0L, 0L, null);
        }
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObject;
        try {
            jSONObject2.put("_event_v3", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(null, "event_v3", str, null, 0L, 0L, jSONObject2);
    }

    public static void onEventV3(Context context, String str, JSONObject jSONObject) {
        onEventV3(context, str, jSONObject, false);
    }

    public static void onEventV3(Context context, String str, JSONObject jSONObject, boolean z) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObject;
        try {
            jSONObject2.put("_event_v3", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onEvent(context, "event_v3", str, null, 0L, 0L, jSONObject2, z);
    }

    public static void onEventV3Bundle(String str, Bundle bundle) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_event_v3", 1);
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    jSONObject.put(str2, bundle.get(str2));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        onEvent(null, "event_v3", str, null, 0L, 0L, jSONObject);
    }

    public static void onEventV3Bundle(Context context, String str, Bundle bundle) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_event_v3", 1);
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    jSONObject.put(str2, bundle.get(str2));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        onEvent(context, "event_v3", str, null, 0L, 0L, jSONObject);
    }
}

package com.ss.android.common.applog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.util.IEventsSender;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EventVerify {
    public static final String TYPE_EVENT_V1 = "event";
    public static final String TYPE_EVENT_V3 = "event_v3";
    public static final String TYPE_ITEM_IMPRESSION = "item_impression";
    public static final String TYPE_LAUNCH = "launch";
    public static final String TYPE_LOG_DATA = "log_data";
    public static final String TYPE_TERMINATE = "terminate";
    private static volatile EventVerify sInstance;
    private IEventsSender mIEventsSender;

    private EventVerify() {
        if (AppLog.getSwitchToBdtracker()) {
            this.mIEventsSender = new EventVerifyBdtracker();
        } else {
            this.mIEventsSender = new EventVerifyWrapper();
        }
    }

    public static EventVerify inst() {
        if (sInstance == null) {
            synchronized (EventVerify.class) {
                if (sInstance == null) {
                    sInstance = new EventVerify();
                }
            }
        }
        return sInstance;
    }

    public void putEvent(String str, JSONArray jSONArray) {
        this.mIEventsSender.putEvent(str, jSONArray);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:(16:6|7|8|(1:10)|11|(1:13)(1:44)|14|15|(5:17|(1:19)|20|(1:22)|23)(6:34|(1:36)|37|(1:39)|40|(1:42))|24|(1:26)|27|(1:29)|30|31|32)|47|(0)|11|(0)(0)|14|15|(0)(0)|24|(0)|27|(0)|30|31|32) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[Catch: JSONException -> 0x00d3, TryCatch #1 {JSONException -> 0x00d3, blocks: (B:15:0x003c, B:17:0x0044, B:19:0x004a, B:20:0x0051, B:22:0x005f, B:23:0x0069, B:26:0x00aa, B:27:0x00b0, B:29:0x00ba, B:30:0x00c0, B:34:0x0079, B:36:0x008c, B:39:0x0097, B:42:0x00a1), top: B:14:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00aa A[Catch: JSONException -> 0x00d3, TryCatch #1 {JSONException -> 0x00d3, blocks: (B:15:0x003c, B:17:0x0044, B:19:0x004a, B:20:0x0051, B:22:0x005f, B:23:0x0069, B:26:0x00aa, B:27:0x00b0, B:29:0x00ba, B:30:0x00c0, B:34:0x0079, B:36:0x008c, B:39:0x0097, B:42:0x00a1), top: B:14:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba A[Catch: JSONException -> 0x00d3, TryCatch #1 {JSONException -> 0x00d3, blocks: (B:15:0x003c, B:17:0x0044, B:19:0x004a, B:20:0x0051, B:22:0x005f, B:23:0x0069, B:26:0x00aa, B:27:0x00b0, B:29:0x00ba, B:30:0x00c0, B:34:0x0079, B:36:0x008c, B:39:0x0097, B:42:0x00a1), top: B:14:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079 A[Catch: JSONException -> 0x00d3, TryCatch #1 {JSONException -> 0x00d3, blocks: (B:15:0x003c, B:17:0x0044, B:19:0x004a, B:20:0x0051, B:22:0x005f, B:23:0x0069, B:26:0x00aa, B:27:0x00b0, B:29:0x00ba, B:30:0x00c0, B:34:0x0079, B:36:0x008c, B:39:0x0097, B:42:0x00a1), top: B:14:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void putEvent(String str, String str2, String str3, long j, long j2, long j3, long j4, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String str4;
        String userUniqueId;
        if (isEnable()) {
            if (jSONObject != null) {
                try {
                    jSONObject2 = new JSONObject(jSONObject.toString());
                } catch (JSONException unused) {
                }
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                if ("event_v3".equals(str)) {
                    jSONObject3 = jSONObject2;
                    str4 = "event";
                } else {
                    jSONObject3 = new JSONObject();
                    str4 = "event_v3";
                }
                if (!"event_v3".equals(str)) {
                    if (jSONObject2.has("nt")) {
                        jSONObject3.put("nt", jSONObject2.optInt("nt"));
                    }
                    jSONObject2.remove("nt");
                    jSONObject2.remove("_event_v3");
                    if (jSONObject2.has(AppLog.KEY_AB_SDK_VERSION)) {
                        jSONObject3.put(AppLog.KEY_AB_SDK_VERSION, jSONObject2.optString(AppLog.KEY_AB_SDK_VERSION));
                        jSONObject2.remove(AppLog.KEY_AB_SDK_VERSION);
                    }
                    jSONObject3.put("event", str2);
                    jSONObject3.put("params", jSONObject2);
                    jSONObject3.put(AppLog.KEY_LOCAL_TIME_MS, j4);
                } else {
                    jSONObject3.put("category", str);
                    jSONObject3.put("tag", str2);
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject3.put("label", str3);
                    }
                    if (j != 0) {
                        jSONObject3.put("value", j);
                    }
                    if (j2 != 0) {
                        jSONObject3.put("ext_value", j2);
                    }
                }
                if (j3 > 0) {
                    jSONObject3.put("user_id", j3);
                }
                userUniqueId = AppLog.getUserUniqueId();
                if (!TextUtils.isEmpty(userUniqueId)) {
                    jSONObject3.put(AppLog.KEY_USER_UNIQUE_ID, userUniqueId);
                }
                jSONObject3.put(AppLog.KEY_SESSION_ID, AppLog.getCurrentSessionId());
                jSONObject3.put(AppLog.KEY_DATETIME, AppLog.formatDate(j4));
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject3);
                putEvent(str4, jSONArray);
            }
            jSONObject2 = null;
            if (jSONObject2 == null) {
            }
            if ("event_v3".equals(str)) {
            }
            if (!"event_v3".equals(str)) {
            }
            if (j3 > 0) {
            }
            userUniqueId = AppLog.getUserUniqueId();
            if (!TextUtils.isEmpty(userUniqueId)) {
            }
            jSONObject3.put(AppLog.KEY_SESSION_ID, AppLog.getCurrentSessionId());
            jSONObject3.put(AppLog.KEY_DATETIME, AppLog.formatDate(j4));
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject3);
            putEvent(str4, jSONArray2);
        }
    }

    public boolean isEnable() {
        return this.mIEventsSender.isEnable();
    }

    public void setEventVerifyUrl(String str) {
        this.mIEventsSender.setEventVerifyUrl(str);
    }

    public synchronized void setEnable(boolean z, Context context) {
        this.mIEventsSender.setEnable(z, context);
    }

    public void loginEtWithScheme(String str, Context context) {
        this.mIEventsSender.loginEtWithScheme(str, context);
    }

    private void setEventVerifyInterval(long j) {
        this.mIEventsSender.setEventVerifyInterval(j);
    }

    public void setSpecialKeys(List<String> list) {
        this.mIEventsSender.setSpecialKeys(list);
    }
}

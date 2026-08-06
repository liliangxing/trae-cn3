package com.bytedance.crash.entity;

import com.bytedance.crash.util.JSONUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashBody {
    public static final String ABORT_REASON = "abort_msg";
    public static final String APP_START_UP_TIME = "app_start_up_time";
    public static final String CRASH_LIB_UUID = "crash_lib_uuid";
    public static final String CRASH_PROCESS_NAME = "process_name";
    public static final String CRASH_THREAD_NAME = "crash_thread_name";
    public static final String CRASH_TIME = "crash_time";
    public static final String CUSTOM = "custom";
    public static final String DATA = "data";
    public static final String FILE_NAME = "crash_body.json";
    public static final String FILTERS = "filters";
    public static final String HEADER = "header";
    public static final String IS_NATIVE_CRASH = "is_native_crash";
    public static final String KEY_APP_CRASH_TIME = "crash_time";
    public static final String KEY_APP_START_TIME = "app_start_time";
    public static final String LAUNCH_MODE = "launch_mode";
    public static final String LAUNCH_TIME = "launch_time";
    public static final String LIB_NAME = "lib_name";
    public static final String LIB_UUID = "lib_uuid";
    public static final String LOGCAT_ANR_INFO = "logcat_anr_info";
    public static final String LOGCAT_GC_INFO = "logcat_gc_info";
    public static final String PID = "pid";
    public static final String STACK = "stack";
    public static final String STACK_MD5 = "crash_md5";
    public static final String START_PID = "start_pid";
    public static final String TID = "tid";
    private JSONObject mCrashJson;
    private Header mHeader;

    public CrashBody() {
        this.mCrashJson = new JSONObject();
        this.mHeader = new Header();
    }

    @Deprecated
    public CrashBody(JSONObject jSONObject) {
        this.mCrashJson = jSONObject;
    }

    public Header getHeader() {
        return this.mHeader;
    }

    public JSONObject getHeaderJson() {
        return this.mCrashJson.optJSONObject("header");
    }

    public JSONObject getJson() {
        return this.mCrashJson;
    }

    public void setJson(JSONObject jSONObject) {
        this.mCrashJson = jSONObject;
    }

    public CrashBody setHeader(Header header) {
        put("header", header.getJson());
        this.mHeader = header;
        return this;
    }

    public void put(String str, Object obj) {
        JSONUtils.put(this.mCrashJson, str, obj);
    }

    @Deprecated
    public CrashBody setAppStartTime(long j) {
        return setAppStartTime(j, 0L);
    }

    @Deprecated
    public CrashBody setAppStartTime(long j, long j2) {
        try {
            put("app_start_time", Long.valueOf(j));
            if (j2 != 0) {
                put(APP_START_UP_TIME, Long.valueOf(j2));
            }
            put("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Deprecated
    public CrashBody addCustom(String str, String str2) {
        putInJson(this.mCrashJson, "custom", str, str2);
        return this;
    }

    @Deprecated
    public CrashBody addFilter(String str, String str2) {
        putInJson(this.mCrashJson, "filters", str, str2);
        return this;
    }

    @Deprecated
    public static void putInJson(JSONObject jSONObject, String str, String str2, Object obj) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            JSONUtils.put(jSONObject, str, optJSONObject);
        }
        JSONUtils.put(optJSONObject, str2, obj);
    }

    public CrashBody addCustomLong(String str, List<String> list) {
        if (list == null) {
            return this;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        addCustomLong(str, jSONArray);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CrashBody addCustomLong(String str, JSONArray jSONArray) {
        CustomLong.add(getJson(), str, jSONArray);
        return this;
    }
}

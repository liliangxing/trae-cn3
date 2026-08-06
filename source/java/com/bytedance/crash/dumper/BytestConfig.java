package com.bytedance.crash.dumper;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BytestConfig {
    private static final String SETTINGS_KEY = "bytest_automation_info";
    private static volatile boolean isDump;
    private static BytestConfig sInstance;
    private final boolean mBytestDevice;
    private final String mBytraceId;
    private String mConfig;
    private final boolean mCoredumpEnabled;
    private final boolean mEnsureNoLimit;
    private final JSONObject mFilters;
    private final boolean mGwpasanEnabled;
    private final JSONObject mJson;

    private static BytestConfig get() {
        if (sInstance == null) {
            sInstance = new BytestConfig();
        }
        return sInstance;
    }

    BytestConfig() {
        JSONObject configs = getConfigs();
        this.mJson = configs;
        if (configs.length() != 0) {
            this.mBytestDevice = true;
            this.mFilters = configs.optJSONObject("slardar_filter");
        } else {
            this.mBytestDevice = false;
            this.mFilters = null;
        }
        JSONObject jSONObject = this.mFilters;
        if (jSONObject != null) {
            this.mGwpasanEnabled = RouterConstants.TRUE.equals(jSONObject.optString("gwp_asan_switch"));
            this.mCoredumpEnabled = RouterConstants.TRUE.equals(this.mFilters.optString("core_dump_switch"));
            this.mEnsureNoLimit = RouterConstants.TRUE.equals(this.mFilters.optString("is_all_exception_collected"));
            RuntimeConfig.setDebugMode(true);
        } else {
            this.mGwpasanEnabled = false;
            this.mCoredumpEnabled = false;
            this.mEnsureNoLimit = false;
        }
        String optString = configs.optString("bytrace_id_prefix");
        this.mBytraceId = TextUtils.isEmpty(optString) ? UUID.randomUUID() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid() : optString;
    }

    public static String getBytraceId() {
        return get().mBytraceId;
    }

    private JSONObject getConfigs() {
        try {
            Context context = Global.getContext();
            if (context != null) {
                this.mConfig = Settings.Global.getString(context.getContentResolver(), SETTINGS_KEY);
                return new JSONObject(this.mConfig);
            }
        } catch (Throwable unused) {
        }
        return new JSONObject();
    }

    public static void dump(File file) {
        if (isDump) {
            return;
        }
        isDump = true;
        try {
            String str = get().mConfig;
            if (str == null) {
                return;
            }
            FileUtils.writeFile(file, str, false);
        } catch (Throwable unused) {
        }
    }

    public static boolean isCoredumpEnabled() {
        return get().mCoredumpEnabled;
    }

    public static boolean isGwpasanEnabled() {
        return get().mGwpasanEnabled;
    }

    public static boolean isEnsureNoLimit() {
        return get().mEnsureNoLimit;
    }

    public static boolean isBytestDevcice() {
        return get().mBytestDevice;
    }

    public static void load(JSONObject jSONObject) {
        Object opt;
        JSONObject jSONObject2 = get().mJson;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!"slardar_filter".equals(next) && (opt = jSONObject2.opt(next)) != null) {
                try {
                    jSONObject.put(next, opt);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static void expandFilters(JSONObject jSONObject) {
        JSONObject jSONObject2 = get().mFilters;
        if (jSONObject2 == null || jSONObject2.length() == 0) {
            return;
        }
        JSONUtils.combineJson(jSONObject, jSONObject2);
    }

    public static void load(JSONObject jSONObject, JSONObject jSONObject2) {
        Object opt;
        if (jSONObject == null) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!"slardar_filter".equals(next) && (opt = jSONObject.opt(next)) != null) {
                    try {
                        jSONObject2.put(next, opt);
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    public static JSONObject expandFilters(File file, JSONObject jSONObject) {
        try {
            if (file.isFile() && file.exists()) {
                JSONObject jSONObject2 = new JSONObject(FileUtils.readFile(file));
                JSONObject optJSONObject = jSONObject2.optJSONObject("slardar_filter");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("filters");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    jSONObject.put("filters", optJSONObject2);
                }
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    if (RouterConstants.TRUE.equals(optJSONObject.optString("core_dump_switch"))) {
                        optJSONObject2.put("coredump_bytest", true);
                    }
                    JSONUtils.combineJson(optJSONObject2, optJSONObject);
                    return jSONObject2;
                }
                optJSONObject2.put("coredump_bytest", false);
                return jSONObject2;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}

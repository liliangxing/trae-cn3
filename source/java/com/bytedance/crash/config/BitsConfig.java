package com.bytedance.crash.config;

import android.content.Context;
import com.bytedance.crash.Global;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BitsConfig {
    private static final String KEY_RELEASE_BUILD = "release_build";
    private static final String PROPERTIES_PATH = "slardar.properties";
    private static volatile BitsConfig sInstance;
    private final Map<String, Object> mPropertiesMap = new HashMap();

    private static BitsConfig get() {
        if (sInstance == null) {
            sInstance = new BitsConfig();
        }
        return sInstance;
    }

    BitsConfig() {
        Context context = Global.getContext();
        if (context == null) {
            return;
        }
        Properties properties = new Properties();
        try {
            properties.load(context.getAssets().open(PROPERTIES_PATH));
            for (Map.Entry entry : properties.entrySet()) {
                this.mPropertiesMap.put(String.valueOf(entry.getKey()), entry.getValue());
            }
        } catch (Exception unused) {
        }
    }

    public static Map<String, Object> getPropertiesMap() {
        return get().mPropertiesMap;
    }

    public static String getReleaseBuild() {
        Object obj = getPropertiesMap().get("release_build");
        if (obj == null) {
            return "invalid";
        }
        String valueOf = String.valueOf(obj);
        return valueOf.length() >= 16 ? valueOf : "invalid";
    }

    public static void load(JSONObject jSONObject) {
        for (Map.Entry<String, Object> entry : getPropertiesMap().entrySet()) {
            if (!jSONObject.has(entry.getKey())) {
                try {
                    jSONObject.put(entry.getKey(), String.valueOf(entry.getValue()));
                } catch (Throwable unused) {
                }
            }
        }
    }
}

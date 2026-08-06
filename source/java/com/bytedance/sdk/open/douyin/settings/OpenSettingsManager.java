package com.bytedance.sdk.open.douyin.settings;

import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class OpenSettingsManager {
    private static final String TAG = "OpenSettingsManager";
    private static volatile OpenSettingsManager instance;
    private Gson mGson = new Gson();
    private final HashMap<String, Object> cache = new HashMap<>();

    /* loaded from: classes5.dex */
    public static class SDKConfig {

        @SerializedName("init_ticket_sdk")
        public int initTicketSDK = 1;

        @SerializedName("auth_entrance")
        public int authEntrance = 3;

        @SerializedName("share_entrance")
        public int shareEntrance = 7;
    }

    private OpenSettingsManager() {
    }

    private <T> T getValue(String str, Class cls) {
        try {
            return (T) this.cache.get(str);
        } catch (Exception e) {
            LogUtils.e(TAG, e);
            return null;
        }
    }

    public static OpenSettingsManager inst() {
        if (instance == null) {
            synchronized (OpenSettingsManager.class) {
                if (instance == null) {
                    instance = new OpenSettingsManager();
                }
            }
        }
        return instance;
    }

    public SDKConfig getSDKConfig() {
        try {
            SDKConfig sDKConfig = (SDKConfig) getValueSafely("open_sdk_config", SDKConfig.class);
            if (sDKConfig != null) {
                this.cache.put("open_sdk_config", sDKConfig);
                return sDKConfig;
            }
        } catch (Exception unused) {
        }
        return new SDKConfig();
    }

    public <T> T getValueSafely(String str, Class<T> cls) {
        T t;
        try {
            t = (T) getValue(str, cls);
        } catch (Throwable th) {
            th = th;
            t = null;
        }
        try {
            if (t == null) {
                try {
                    Object fromJson = this.mGson.fromJson(OpenSettings.get().opt(str).toString(), (Class<Object>) cls);
                    if (fromJson != null) {
                        this.cache.put(str, fromJson);
                        t = (T) fromJson;
                    }
                } catch (Exception e) {
                    LogUtils.e(TAG, e);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            LogUtils.e(TAG, th);
            return t;
        }
        return t;
    }
}

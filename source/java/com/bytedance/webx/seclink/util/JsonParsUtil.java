package com.bytedance.webx.seclink.util;

import android.text.TextUtils;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.webx.seclink.setting.SettingConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class JsonParsUtil {
    public static SettingConfig parseSettings(String str) {
        JSONObject optJSONObject;
        SettingConfig settingConfig = new SettingConfig();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("config");
            if (optJSONObject2 != null) {
                try {
                    SettingConfig.Config config = new SettingConfig.Config();
                    config.period = optJSONObject2.optLong("period", 8600L);
                    config.use_cache = optJSONObject2.optBoolean("use_cache", true);
                    config.seclink_settings_version = optJSONObject2.optString("seclink_settings_version", "");
                    config.error_overwhelming_count = optJSONObject2.optInt("error_overwhelming_count", 50);
                    config.error_overwhelming_duration = optJSONObject2.optLong("error_overwhelming_duration", LocalSettings.DEFAULT_PULL_REQUEST_INTERVAL_IN_SECOND);
                    config.safe_duration_after_overwhelming = optJSONObject2.optLong("safe_duration_after_overwhelming", LocalSettings.DEFAULT_PULL_REQUEST_INTERVAL_IN_SECOND);
                    config.sync_check_time_limit = optJSONObject2.optDouble("sync_check_time_limit", 1.0d);
                    config.custom_settings_biz_first = optJSONObject2.optBoolean("custom_settings_biz_first", true);
                    JSONArray optJSONArray = optJSONObject2.optJSONArray("settings_url_array");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                        config.settings_url_array = arrayList;
                    }
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("verify_host_array");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            arrayList2.add(optJSONArray2.optString(i2));
                        }
                        config.verify_host_array = arrayList2;
                    }
                    settingConfig.config = config;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("global");
            if (optJSONObject3 != null) {
                try {
                    SettingConfig.Global global = new SettingConfig.Global();
                    global.enable = optJSONObject3.optBoolean("enable", true);
                    global.async_mode = optJSONObject3.optBoolean("async_mode", true);
                    global.use_verify_mode_v2 = optJSONObject3.optBoolean("use_verify_mode_v2", true);
                    JSONArray optJSONArray3 = optJSONObject3.optJSONArray("scheme");
                    if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                        HashSet hashSet = new HashSet();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            hashSet.add(optJSONArray3.optString(i3));
                        }
                        global.scheme = hashSet;
                    }
                    settingConfig.global = global;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("scenes");
            if (optJSONObject4 != null) {
                try {
                    Iterator<String> keys = optJSONObject4.keys();
                    HashMap hashMap = new HashMap();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject4.optJSONObject(next)) != null) {
                            SettingConfig.SceneConfig sceneConfig = new SettingConfig.SceneConfig();
                            sceneConfig.name = next;
                            sceneConfig.use_verify_mode_v2 = optJSONObject.optBoolean("use_verify_mode_v2", true);
                            sceneConfig.enable = optJSONObject.optBoolean("enable", true);
                            sceneConfig.async_mode = optJSONObject.optBoolean("async_mode", true);
                            JSONArray optJSONArray4 = optJSONObject.optJSONArray("scheme");
                            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                                HashSet hashSet2 = new HashSet();
                                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                                    hashSet2.add(optJSONArray4.optString(i4));
                                }
                                sceneConfig.scheme = hashSet2;
                            }
                            hashMap.put(next, sceneConfig);
                        }
                    }
                    settingConfig.sceneCfgMap = hashMap;
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return settingConfig;
    }
}

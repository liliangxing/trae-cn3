package com.bytedance.dataplatform;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CacheRepository {
    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences getSharedPreferences(Context context, String name) {
        try {
            return context.getSharedPreferences(name, 0);
        } catch (Exception unused) {
            return context.createDeviceProtectedStorageContext().getSharedPreferences(name, 0);
        }
    }

    public static JSONObject getJSONObject(Context context, String name, String key) {
        try {
            return new JSONObject(getSharedPreferences(context, name).getString(key, ""));
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static Map<String, Integer> getAllInteger(Context context, String name) {
        SharedPreferences sharedPreferences = getSharedPreferences(context, name);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof Integer) {
                concurrentHashMap.put(entry.getKey(), (Integer) entry.getValue());
            }
        }
        return concurrentHashMap;
    }

    public static String getString(Context context, String name, String key) {
        return getSharedPreferences(context, name).getString(key, "");
    }

    public static Set<String> getStringSet(Context context, String name, String key) {
        return new ConcurrentSkipListSet(getSharedPreferences(context, name).getStringSet(key, new ConcurrentSkipListSet()));
    }

    public static Map<String, String> getAllString(Context context, String name) {
        SharedPreferences sharedPreferences = getSharedPreferences(context, name);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            if (entry.getValue() instanceof String) {
                concurrentHashMap.put(entry.getKey(), (String) entry.getValue());
            }
        }
        return concurrentHashMap;
    }

    public static void saveJSONObject(final Context context, final String name, final String key, final JSONObject jsonObject) {
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.CacheRepository.1
            @Override // java.lang.Runnable
            public void run() {
                CacheRepository.getSharedPreferences(context, name).edit().putString(key, jsonObject.toString()).apply();
            }
        });
    }

    public static void saveInt(final Context context, final String name, final String key, final int value) {
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.CacheRepository.2
            @Override // java.lang.Runnable
            public void run() {
                CacheRepository.getSharedPreferences(context, name).edit().putInt(key, value).apply();
            }
        });
    }

    public static void saveStringSet(final Context context, final String name, final String key, final Set<String> value) {
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.CacheRepository.3
            @Override // java.lang.Runnable
            public void run() {
                CacheRepository.getSharedPreferences(context, name).edit().putStringSet(key, value).apply();
            }
        });
    }

    public static void saveString(final Context context, final String name, final String key, final String value) {
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.CacheRepository.4
            @Override // java.lang.Runnable
            public void run() {
                if (value == null) {
                    CacheRepository.getSharedPreferences(context, name).edit().remove(key).apply();
                } else {
                    CacheRepository.getSharedPreferences(context, name).edit().putString(key, value).apply();
                }
            }
        });
    }

    public static void replaceAllString(final Context context, final String name, final Map<String, String> values) {
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.CacheRepository.5
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = CacheRepository.getSharedPreferences(context, name).edit();
                edit.clear().apply();
                for (String str : values.keySet()) {
                    edit.putString(str, (String) values.get(str));
                }
                edit.apply();
            }
        });
    }

    public static void removeKey(final Context context, final String name, final String key) {
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.CacheRepository.6
            @Override // java.lang.Runnable
            public void run() {
                CacheRepository.getSharedPreferences(context, name).edit().remove(key).apply();
            }
        });
    }
}

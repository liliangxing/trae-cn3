package com.bytedance.platform.settingsx.storage;

import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class StorageManager {
    private static Storage appStorage;
    private static Storage localStorage;

    public static Integer getInt(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            return appStorage.getInt(i, str, i2, false);
        }
        return localStorage.getInt(i, str, i2, false);
    }

    public static void putInt(int i, String str, Integer num, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("app settings not support put data");
        }
        localStorage.putInt(i, str, num, i2);
    }

    public static Long getLong(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            return appStorage.getLong(i, str, i2, false);
        }
        return localStorage.getLong(i, str, i2, false);
    }

    public static void putLong(int i, String str, Long l, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("app settings not support put data");
        }
        localStorage.putLong(i, str, l, i2);
    }

    public static Float getFloat(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            return appStorage.getFloat(i, str, i2, false);
        }
        return localStorage.getFloat(i, str, i2, false);
    }

    public static void putFloat(int i, String str, Float f, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("app settings not support put data");
        }
        localStorage.putFloat(i, str, f, i2);
    }

    public static Double getDouble(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            return appStorage.getDouble(i, str, i2, false);
        }
        return localStorage.getDouble(i, str, i2, false);
    }

    public static void putDouble(int i, String str, Double d, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("app settings not support put data");
        }
        localStorage.putDouble(i, str, d, i2);
    }

    public static Boolean getBoolean(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            return appStorage.getBoolean(i, str, i2, false);
        }
        return localStorage.getBoolean(i, str, i2, false);
    }

    public static void putBoolean(int i, String str, Boolean bool, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("app settings not support put data");
        }
        localStorage.putBoolean(i, str, bool, i2);
    }

    public static JSONObject getJsonObject(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            return appStorage.getJsonObject(i, str, i2, false);
        }
        return localStorage.getJsonObject(i, str, i2, false);
    }

    public static void putJsonObject(int i, String str, JSONObject jSONObject, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("app settings not support put data");
        }
        localStorage.putJsonObject(i, str, jSONObject, i2);
    }

    public static JSONArray getJsonArray(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            return appStorage.getJsonArray(i, str, i2, false);
        }
        return localStorage.getJsonArray(i, str, i2, false);
    }

    public static void putJsonArray(int i, String str, JSONArray jSONArray, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("app settings not support put data");
        }
        localStorage.putJsonArray(i, str, jSONArray, i2);
    }

    @Deprecated
    public static String getString(int i, String str) {
        return getString(i, str, StorageType.APP_SETTINGS);
    }

    @Deprecated
    public static String getString(int i, String str, StorageType storageType) {
        return getString(i, str, -1, storageType);
    }

    @Deprecated
    public static String getString(int i, String str, int i2) {
        return getString(i, str, i2, StorageType.APP_SETTINGS);
    }

    public static String getString(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            return appStorage.getString(i, str, i2, false);
        }
        return localStorage.getString(i, str, i2, false);
    }

    public static void putString(int i, String str, String str2, StorageType storageType) {
        throw new RuntimeException("调用废弃接口，请升级SettingsX的apt");
    }

    public static void putString(int i, String str, String str2, Object obj) {
        throw new RuntimeException("调用废弃接口，请升级SettingsX的apt");
    }

    public static void putString(int i, String str, String str2, int i2, StorageType storageType) {
        throw new RuntimeException("调用废弃接口，请升级SettingsX的apt");
    }

    public static String getStringLocal(int i, String str) {
        throw new RuntimeException("调用废弃接口，请升级SettingsX的apt");
    }

    public static String getStringLocal(int i, String str, int i2) {
        throw new RuntimeException("调用废弃接口，请升级SettingsX的apt");
    }

    public static boolean contains(int i, String str, int i2, StorageType storageType) {
        if (storageType == StorageType.APP_SETTINGS) {
            throw new RuntimeException("app settings not support contains function");
        }
        return localStorage.contains(i, str, i2);
    }

    public static void init(Storage storage, Storage storage2) {
        appStorage = storage;
        localStorage = storage2;
    }
}

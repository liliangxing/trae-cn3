package com.bytedance.android.live.core.setting;

import com.bytedance.android.live.core.setting.p027v2.p028vo.SettingCallback;
import com.google.gson.Gson;
import java.lang.reflect.Type;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SettingUtil {
    public static final String KEY_SERVER_SETTING_VALUES = "key_ttlive_sdk_setting";
    public static final String KEY_TT_APP_SETTING = "TT_APP_SETTING";
    public static final String KEY_TT_USER_SETTING = "TT_USER_SETTING";
    private static Gson gson = OldSettingGsonHelper.get();
    private static boolean isLocalTest;
    private static boolean sDebugMode;
    public static SettingCallback sTestSettingCallback;

    private SettingUtil() {
    }

    public static <T> T getValue(String str, String str2, Type type, T t) {
        return (T) SettingCache.getValue(str, str2, type, t, false);
    }

    public static <T> T getValue(String str, String str2, Type type, T t, boolean z) {
        return (T) SettingCache.getValue(str, str2, type, t, z);
    }

    public static <T> T getValue(String str, String str2, Type type, T t, T t2, boolean z) {
        return (T) SettingCache.getValue(str, str2, type, t, t2, z, false);
    }

    public static <T> T getValue(String str, String str2, Type type, T t, T t2, boolean z, boolean z2) {
        return (T) SettingCache.getValue(str, str2, type, t, t2, z, z2);
    }

    public static <T> T getValue(String str, String str2, Type type, T t, T t2, boolean z, boolean z2, boolean z3) {
        return (T) SettingCache.getValue(str, str2, type, t, t2, z, z2, z3);
    }

    public static Object getRawValue(String str, String str2) {
        return SettingCache.getRawValue(str, str2);
    }

    public static boolean updateLocal(SettingKey settingKey, String str) {
        return SettingCache.updateLocal(settingKey, str);
    }

    public static String getServerValue(SettingKey settingKey) {
        return SettingCache.getServerValue("key_ttlive_sdk_setting", settingKey);
    }

    public static String getLocalValue(SettingKey settingKey) {
        return SettingCache.getLocalValue(settingKey);
    }

    public static String getLocalValue(String str, String str2) {
        String localValue = SettingCache.getLocalValue(new SettingKey(str, str2));
        return localValue == null ? str2 : localValue;
    }

    public static String getSettingKeyName(SettingKey settingKey) {
        return settingKey.getName();
    }

    public static String getSettingKeyDescription(SettingKey settingKey) {
        return settingKey.getDescription();
    }

    public static Type getSettingKeyType(SettingKey settingKey) {
        return settingKey.getType();
    }

    public static String[] getSettingKeyOption(SettingKey settingKey) {
        return settingKey.getOption();
    }

    public static <T> T getDefaultValue(SettingKey<T> settingKey) {
        return settingKey.getDefaultValue();
    }

    public static <T> T getDebugValue(SettingKey<T> settingKey) {
        return settingKey.getDebugValue();
    }

    public static void setLocalTest(boolean z) {
        isLocalTest = z;
    }

    public static boolean isLocalTest() {
        return isLocalTest;
    }

    public static void setDebugMode(boolean z) {
        sDebugMode = z;
    }

    public static boolean isDebugMode() {
        return sDebugMode || LiveSettingOldContext.isSettingDebug();
    }

    public static Gson getGson() {
        return gson;
    }

    public static void setGson(Gson gson2) {
        gson = gson2;
    }
}

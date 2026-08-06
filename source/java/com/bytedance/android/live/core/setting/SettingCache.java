package com.bytedance.android.live.core.setting;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import com.bytedance.android.live.core.setting.p027v2.SettingCacheV2;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Type;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SettingCache {
    private static final String KEY_SERVER_SETTING_VALUES = "key_ttlive_sdk_setting";
    private static final String TAG = "SettingCache";
    public static PublishSubject<Boolean> update = PublishSubject.create();

    private SettingCache() {
    }

    @Deprecated
    public static JSONObject getABTest(String str) {
        try {
            return new JSONObject(SettingCacheV2.INSTANCE.getCacheMap());
        } catch (Exception e) {
            LiveSettingOldContext.m1270e("SettingCache#getABTest", e);
            return null;
        }
    }

    public static Object getRawValue(String str) {
        return getRawValue("key_ttlive_sdk_setting", str);
    }

    private static Object convertJsonRawValue(Object obj, String str) {
        try {
            Object originValue = SettingCacheV2.INSTANCE.getOriginValue(SettingCacheV2.PREFIX + str);
            if ((originValue instanceof Integer) && (obj instanceof String)) {
                int intValue = ((Integer) originValue).intValue();
                if (intValue == 0) {
                    return new JSONObject(String.valueOf(obj));
                }
                if (intValue == 1) {
                    return new JSONArray(String.valueOf(obj));
                }
            }
            return obj;
        } catch (Exception e) {
            LiveSettingOldContext.m1270e(TAG, e);
            return obj;
        }
    }

    public static Object getRawValue(String str, String str2) {
        if (useLocalSetting() && SettingCacheV2.INSTANCE.containsTestKey(str2)) {
            return convertJsonRawValue(SettingCacheV2.INSTANCE.getTestOriginValue(str2), str2);
        }
        return convertJsonRawValue(SettingCacheV2.INSTANCE.getOriginValue(str2), str2);
    }

    public static <T> T getValue(String str, Type type, T t, boolean z) {
        return (T) getValue("key_ttlive_sdk_setting", str, type, t, z);
    }

    public static <T> T getValue(String str, String str2, Type type, T t, boolean z) {
        return (T) getValue(str, str2, type, t, null, z, false);
    }

    public static <T> T getValue(String str, String str2, Type type, T t, T t2, boolean z, boolean z2) {
        if (z2) {
            return (T) SettingCacheV2.INSTANCE.getTransientValue(str2, type, LiveSettingOldContext.isLocalTest());
        }
        return (T) SettingCacheV2.INSTANCE.getValue(str2, t, type, z, LiveSettingOldContext.isLocalTest(), false);
    }

    public static <T> T getValue(String str, String str2, Type type, T t, T t2, boolean z, boolean z2, boolean z3) {
        if (z2) {
            return (T) SettingCacheV2.INSTANCE.getTransientValue(str2, type, LiveSettingOldContext.isLocalTest());
        }
        return (T) SettingCacheV2.INSTANCE.getValue(str2, t, type, z, LiveSettingOldContext.isLocalTest(), z3);
    }

    private static boolean useLocalSetting() {
        return SettingUtil.isLocalTest();
    }

    public static Context getContext() {
        if (LiveSettingOldContext.getApplication() == null) {
            return getApplicationUsingReflection();
        }
        return LiveSettingOldContext.getApplication();
    }

    private static Application getApplicationUsingReflection() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Exception e) {
            SettingGuard.sendUnCatchException("reflection application failed", e);
            return null;
        }
    }

    public static boolean updateLocal(SettingKey settingKey, String str) {
        try {
            return SettingCacheV2.INSTANCE.updateTestLocal(settingKey.getName(), str, settingKey.getType());
        } catch (NumberFormatException unused) {
            Toast.makeText(getContext(), String.format(Locale.US, "Illegal value of %s : %s", settingKey.getName(), String.valueOf(str)), 0).show();
            return false;
        }
    }

    public static String getServerValue(String str, SettingKey settingKey) {
        return OldSettingGsonHelper.get().toJson(SettingCacheV2.INSTANCE.getValue(settingKey.getName(), settingKey.getDefaultValue(), settingKey.getType(), settingKey.isSticky(), false, false));
    }

    public static String getLocalValue(SettingKey settingKey) {
        Object testUpdateValue = SettingCacheV2.INSTANCE.getTestUpdateValue(settingKey.getName(), settingKey.getDefaultValue(), settingKey.getType());
        if (testUpdateValue != null) {
            return OldSettingGsonHelper.get().toJson(testUpdateValue);
        }
        return null;
    }
}

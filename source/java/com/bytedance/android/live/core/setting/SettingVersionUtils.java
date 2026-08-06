package com.bytedance.android.live.core.setting;

import android.content.SharedPreferences;
import android.text.TextUtils;
import coil3.disk.DiskLruCache;
import com.bytedance.android.live.core.setting.p027v2.storage.SettingConfigConstant;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingVersionUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0007J\u0012\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/core/setting/SettingVersionUtils;", "", "()V", "KEY_DOLPHIN_EXTRA", "", "KEY_SETTING_SDK_VERSION", "LOCAL_SETTING_EXTRAS", "Landroid/content/SharedPreferences;", "SETTING_UPDATE_MODE_FULL", "SETTING_UPDATE_MODE_INCR", "SP_NAME", "VERSION_V1", "VERSION_V2", "previousColdSettingUpdateTime", "", "canRequestLite", "", "getLocalSettingExtrasSharedPreferences", "getSettingExtraParams", "", "isIncrUpdate", "settingElement", "Lcom/google/gson/JsonElement;", "removeSettingExtras", "", "setSettingSdkVersion", "version", "updateSettingExtras", "extras", "Lcom/google/gson/JsonObject;", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SettingVersionUtils {
    public static final SettingVersionUtils INSTANCE = new SettingVersionUtils();
    private static final String KEY_DOLPHIN_EXTRA = "dolphin_extra";
    private static final String KEY_SETTING_SDK_VERSION = "setting_sdk_version";
    private static SharedPreferences LOCAL_SETTING_EXTRAS = null;
    public static final String SETTING_UPDATE_MODE_FULL = "full";
    public static final String SETTING_UPDATE_MODE_INCR = "incr";
    private static final String SP_NAME = "ttlive_setting_extra";
    public static final String VERSION_V1 = "v1";
    public static final String VERSION_V2 = "v2";
    private static long previousColdSettingUpdateTime;

    private SettingVersionUtils() {
    }

    private final SharedPreferences getLocalSettingExtrasSharedPreferences() {
        if (LOCAL_SETTING_EXTRAS == null) {
            if (SettingCache.getContext() == null) {
                SettingGuard.sendUnCatchException("getLocalSettingExtrasSharedPreferences - context is null", new Exception("getLocalSettingExtrasSharedPreferences - context is null"));
                return null;
            }
            LOCAL_SETTING_EXTRAS = SettingCache.getContext().getSharedPreferences(SP_NAME, 0);
        }
        return LOCAL_SETTING_EXTRAS;
    }

    @JvmStatic
    public static final Map<String, String> getSettingExtraParams() {
        String string;
        HashMap hashMap = new HashMap();
        SharedPreferences localSettingExtrasSharedPreferences = INSTANCE.getLocalSettingExtrasSharedPreferences();
        if (localSettingExtrasSharedPreferences != null && (string = localSettingExtrasSharedPreferences.getString(KEY_DOLPHIN_EXTRA, "")) != null && !TextUtils.isEmpty(string)) {
            hashMap.put(KEY_DOLPHIN_EXTRA, string);
            SettingTracer.trace("get setting dolphin extra: " + string);
        }
        HashMap hashMap2 = hashMap;
        hashMap2.put("dolphin_incr", DiskLruCache.VERSION);
        return hashMap2;
    }

    @JvmStatic
    public static final void updateSettingExtras(JsonObject extras) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        if (extras == null || !extras.has(KEY_DOLPHIN_EXTRA)) {
            return;
        }
        JsonElement jsonElement = extras.get(KEY_DOLPHIN_EXTRA);
        Intrinsics.checkNotNullExpressionValue(jsonElement, "extras[KEY_DOLPHIN_EXTRA]");
        String asString = jsonElement.getAsString();
        SharedPreferences localSettingExtrasSharedPreferences = INSTANCE.getLocalSettingExtrasSharedPreferences();
        if (localSettingExtrasSharedPreferences != null && (edit = localSettingExtrasSharedPreferences.edit()) != null && (putString = edit.putString(KEY_DOLPHIN_EXTRA, asString)) != null) {
            putString.apply();
        }
        SettingTracer.trace("update dolphin extra: " + asString);
    }

    @JvmStatic
    public static final void removeSettingExtras() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        SharedPreferences localSettingExtrasSharedPreferences = INSTANCE.getLocalSettingExtrasSharedPreferences();
        if (localSettingExtrasSharedPreferences != null && (edit = localSettingExtrasSharedPreferences.edit()) != null && (remove = edit.remove(KEY_DOLPHIN_EXTRA)) != null) {
            remove.apply();
        }
        SettingTracer.trace("remove dolphin extra");
    }

    @JvmStatic
    public static final void setSettingSdkVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        previousColdSettingUpdateTime = System.currentTimeMillis();
        SettingTracer.trace("set setting sdk version: " + version);
    }

    @JvmStatic
    public static final boolean canRequestLite() {
        return previousColdSettingUpdateTime > 0 && System.currentTimeMillis() - previousColdSettingUpdateTime > ((long) 5000);
    }

    @JvmStatic
    public static final boolean isIncrUpdate(JsonElement settingElement) {
        JsonObject asJsonObject = settingElement != null ? settingElement.getAsJsonObject() : null;
        if (asJsonObject == null || !asJsonObject.has(SettingConfigConstant.SETTING_V2_SETTING_UPDATE_MODE)) {
            return false;
        }
        JsonElement jsonElement = asJsonObject.get(SettingConfigConstant.SETTING_V2_SETTING_UPDATE_MODE);
        Intrinsics.checkNotNullExpressionValue(jsonElement, "settingExtra[\"setting_update_mode\"]");
        return TextUtils.equals("incr", jsonElement.getAsString());
    }
}

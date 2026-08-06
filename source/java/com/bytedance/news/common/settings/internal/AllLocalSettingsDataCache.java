package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public class AllLocalSettingsDataCache {
    public static final String ALL_LOCAL_SETTINGS_STORAGE_NAME = "all_local_settings_storage";
    private static volatile AllLocalSettingsDataCache INSTANCE;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedP;

    public static AllLocalSettingsDataCache getInstance() {
        if (INSTANCE == null) {
            synchronized (AllLocalSettingsDataCache.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AllLocalSettingsDataCache(GlobalConfig.getContext());
                }
            }
        }
        return INSTANCE;
    }

    private AllLocalSettingsDataCache(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ALL_LOCAL_SETTINGS_STORAGE_NAME, 0);
        this.mSharedP = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    public synchronized void putString(String str, String str2) {
        this.mEditor.putString(str, str2);
        this.mEditor.apply();
    }

    public synchronized void putInt(String str, int i) {
        this.mEditor.putInt(str, i);
        this.mEditor.apply();
    }

    public synchronized void putLong(String str, long j) {
        this.mEditor.putLong(str, j);
        this.mEditor.apply();
    }

    public synchronized void putFloat(String str, float f) {
        this.mEditor.putFloat(str, f);
        this.mEditor.apply();
    }

    public synchronized void putBoolean(String str, boolean z) {
        this.mEditor.putBoolean(str, z);
        this.mEditor.apply();
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        this.mEditor.putStringSet(str, set);
        this.mEditor.apply();
    }

    public synchronized Map<String, ?> getAllLocalSettingsData() {
        return this.mSharedP.getAll();
    }
}

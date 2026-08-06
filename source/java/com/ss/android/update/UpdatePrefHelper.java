package com.ss.android.update;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class UpdatePrefHelper {
    private static final String DEFAULT_PREFS_FILE = "update_settings.prefs";
    private static Map<String, UpdatePrefHelper> sCachedHelpers = new HashMap();
    private SharedPreferences prefs;

    private UpdatePrefHelper(Context context, String str) {
        this.prefs = null;
        this.prefs = context.getSharedPreferences(str, 0);
    }

    public static UpdatePrefHelper getInstance(Context context) {
        return getInstance(context, DEFAULT_PREFS_FILE);
    }

    public static UpdatePrefHelper getInstance(Context context, String str) {
        UpdatePrefHelper updatePrefHelper = sCachedHelpers.get(str);
        if (updatePrefHelper == null) {
            synchronized (UpdatePrefHelper.class) {
                updatePrefHelper = sCachedHelpers.get(str);
                if (updatePrefHelper == null) {
                    updatePrefHelper = new UpdatePrefHelper(context, str);
                    sCachedHelpers.put(str, updatePrefHelper);
                }
            }
        }
        return updatePrefHelper;
    }

    public void setPref(String str, boolean z) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public void setPref(String str, String str2) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public void setPref(String str, Set<String> set) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public void setPref(String str, float f) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    public void setPref(String str, int i) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public void setPref(String str, long j) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public boolean getPref(String str, Boolean bool) {
        return this.prefs.getBoolean(str, bool.booleanValue());
    }

    public String getPref(String str, String str2) {
        return this.prefs.getString(str, str2);
    }

    public Set<String> getPref(String str, Set<String> set) {
        return this.prefs.getStringSet(str, set);
    }

    public int getPref(String str, int i) {
        return this.prefs.getInt(str, i);
    }

    public long getPref(String str, long j) {
        return this.prefs.getLong(str, j);
    }

    public float getPref(String str, float f) {
        return this.prefs.getFloat(str, f);
    }

    public boolean hasPrefWithKey(String str) {
        return this.prefs.contains(str);
    }

    public boolean removePref(String str) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.remove(str);
        return edit.commit();
    }
}

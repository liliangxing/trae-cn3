package com.bytedance.ug.sdk.deeplink.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class SharedPreferencesHelper {
    private static final String DEFAULT_PREFS_FILE_NAME = "zlink_sdk_sp.prefs";
    private static SharedPreferences mSharedPreferences;
    private static volatile SharedPreferencesHelper mSharedPreferencesHelper;

    private SharedPreferencesHelper(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            mSharedPreferences = context.getSharedPreferences(str, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static SharedPreferencesHelper getInstance(Context context) {
        return getInstance(context, DEFAULT_PREFS_FILE_NAME);
    }

    public static SharedPreferencesHelper getInstance(Context context, String str) {
        if (mSharedPreferencesHelper == null) {
            synchronized (SharedPreferencesHelper.class) {
                if (mSharedPreferencesHelper == null) {
                    mSharedPreferencesHelper = new SharedPreferencesHelper(context, str);
                }
            }
        }
        return mSharedPreferencesHelper;
    }

    public void putString(String str, String str2) {
        if (mSharedPreferences == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public String getString(String str, String str2) {
        return (mSharedPreferences == null || TextUtils.isEmpty(str)) ? str2 : mSharedPreferences.getString(str, str2);
    }

    public void putBoolean(String str, boolean z) {
        if (mSharedPreferences == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public boolean getBoolean(String str) {
        if (mSharedPreferences == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return mSharedPreferences.getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        return (mSharedPreferences == null || TextUtils.isEmpty(str)) ? z : mSharedPreferences.getBoolean(str, z);
    }

    public void putLong(String str, long j) {
        if (mSharedPreferences == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public long getLong(String str, long j) {
        if (mSharedPreferences == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        return mSharedPreferences.getLong(str, j);
    }

    public void remove(String str) {
        if (mSharedPreferences == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.remove(str);
        edit.apply();
    }
}

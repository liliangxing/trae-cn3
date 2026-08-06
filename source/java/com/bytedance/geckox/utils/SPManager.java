package com.bytedance.geckox.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class SPManager {
    private static final String SP_GECKO = "sp_gecko";
    private SharedPreferences mSharedPreferences;

    private SPManager() {
    }

    /* loaded from: classes3.dex */
    private static class SingletonHolder {
        private static SPManager instance = new SPManager();

        private SingletonHolder() {
        }
    }

    public static SPManager inst() {
        return SingletonHolder.instance;
    }

    public void putInt(Context context, String str, int i) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt(str, i).apply();
    }

    public void putLong(Context context, String str, long j) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(str, j).apply();
    }

    public void putString(Context context, String str, String str2) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(str, str2).apply();
    }

    public void delete(Context context, String str) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(str).apply();
    }

    public void putBoolean(Context context, String str, boolean z) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public int getInt(Context context, String str, int i) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences == null ? i : sharedPreferences.getInt(str, i);
    }

    public String getString(Context context, String str, String str2) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences == null ? str2 : sharedPreferences.getString(str, str2);
    }

    public boolean getBoolean(Context context, String str, boolean z) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences == null ? z : sharedPreferences.getBoolean(str, z);
    }

    public long getLong(Context context, String str, long j) {
        init(context);
        SharedPreferences sharedPreferences = this.mSharedPreferences;
        return sharedPreferences == null ? j : sharedPreferences.getLong(str, j);
    }

    private synchronized void init(Context context) {
        if (context != null) {
            if (this.mSharedPreferences == null) {
                this.mSharedPreferences = context.getSharedPreferences(SP_GECKO, 0);
            }
        }
    }
}

package com.bytedance.news.common.settings.api.cache;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes4.dex */
public class CtxInfoManager {
    private static final String KET_CTX_INFO = "key_ctx_info";
    private static final String KET_CTX_INFO_ID = "key_ctx_info_";
    private static final String KET_SETTINGS_TIME = "key_settings_time";
    private static final String KET_SETTINGS_TIME_ID = "key_settings_time_";
    private static volatile CtxInfoManager sInstance;
    private final SharedPreferences mCtxInfoSp;

    public static CtxInfoManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (CtxInfoManager.class) {
                if (sInstance == null) {
                    sInstance = new CtxInfoManager(context);
                }
            }
        }
        return sInstance;
    }

    private CtxInfoManager(Context context) {
        this.mCtxInfoSp = context.getSharedPreferences("__ctx_info.sp", 0);
    }

    public synchronized void updateCtxInfo(String str) {
        this.mCtxInfoSp.edit().putString(KET_CTX_INFO, str).apply();
    }

    public String getCtxInfo() {
        SharedPreferences sharedPreferences = this.mCtxInfoSp;
        return sharedPreferences == null ? "" : sharedPreferences.getString(KET_CTX_INFO, "");
    }

    public synchronized void updateSdkCtxInfo(String str, String str2) {
        this.mCtxInfoSp.edit().putString(KET_CTX_INFO_ID + str, str2).apply();
    }

    public String getSdkCtxInfo(String str) {
        SharedPreferences sharedPreferences = this.mCtxInfoSp;
        return sharedPreferences == null ? "" : sharedPreferences.getString(KET_CTX_INFO_ID + str, "");
    }

    public synchronized void updateSettingsTime(long j) {
        this.mCtxInfoSp.edit().putLong(KET_SETTINGS_TIME, j).apply();
    }

    public long geSettingsTime() {
        SharedPreferences sharedPreferences = this.mCtxInfoSp;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(KET_SETTINGS_TIME, 0L);
    }

    public synchronized void updateSdkSettingsTime(String str, long j) {
        this.mCtxInfoSp.edit().putLong(KET_SETTINGS_TIME_ID + str, j).apply();
    }

    public long geSdkSettingsTime(String str) {
        SharedPreferences sharedPreferences = this.mCtxInfoSp;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(KET_SETTINGS_TIME_ID + str, 0L);
    }
}

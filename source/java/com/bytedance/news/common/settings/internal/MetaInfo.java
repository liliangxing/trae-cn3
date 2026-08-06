package com.bytedance.news.common.settings.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;

/* loaded from: classes4.dex */
public class MetaInfo {
    private static volatile MetaInfo INSTANCE = null;
    private static final String KEY_LATEST_UPDATE_TOKEN = "key_latest_update_token";
    private static final String KEY_ONE_SP_MIGRATE = "key_one_sp_migrate_";
    private static final String KEY_PREFIX_VERSION = "key_prefix_version_";
    private SharedPreferences mSharedP;

    public static MetaInfo getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MetaInfo.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MetaInfo(context);
                }
            }
        }
        return INSTANCE;
    }

    private MetaInfo(Context context) {
        SettingsConfigProvider settingsConfigProvider = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (settingsConfigProvider != null && settingsConfigProvider.getConfig() != null) {
            this.mSharedP = settingsConfigProvider.getConfig().getSharedPreferences(context, "__settings_meta.sp", 0, false);
        }
        if (this.mSharedP == null) {
            this.mSharedP = context.getSharedPreferences("__settings_meta.sp", 0);
        }
    }

    public String getLatestUpdateToken(String str) {
        return this.mSharedP.getString(convertKey(KEY_LATEST_UPDATE_TOKEN, str), "");
    }

    public void setLatestUpdateToken(String str, String str2) {
        this.mSharedP.edit().putString(convertKey(KEY_LATEST_UPDATE_TOKEN, str2), str).apply();
    }

    public String getStorageKeyUpdateToken(String str) {
        return this.mSharedP.getString(str, "");
    }

    public void setStorageKeyUpdateToken(String str, String str2) {
        this.mSharedP.edit().putString(str, str2).apply();
    }

    public int getSettingsVersion(String str) {
        int i = 0;
        try {
            return this.mSharedP.getInt(KEY_PREFIX_VERSION + str, 0);
        } catch (ClassCastException e) {
            try {
                i = Integer.valueOf(this.mSharedP.getString(KEY_PREFIX_VERSION + str, "0")).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            e.printStackTrace();
            return i;
        }
    }

    public void setSettingsVersion(String str, int i) {
        try {
            this.mSharedP.edit().putInt(KEY_PREFIX_VERSION + str, i).apply();
        } catch (Exception e) {
            e.printStackTrace();
            this.mSharedP.edit().putString(KEY_PREFIX_VERSION + str, String.valueOf(i)).apply();
        }
    }

    public void setOneSpMigrateDone(String str) {
        try {
            this.mSharedP.edit().putBoolean(KEY_ONE_SP_MIGRATE + str, true).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isOneSpMigrateDone(String str) {
        return this.mSharedP.getBoolean(KEY_ONE_SP_MIGRATE + str, false);
    }

    public boolean needUpdate(String str, String str2) {
        return !getStorageKeyUpdateToken(str).equals(getLatestUpdateToken(str2));
    }

    private static String convertKey(String str, String str2) {
        return TextUtils.isEmpty(str2) ? str : str + "_" + str2;
    }
}

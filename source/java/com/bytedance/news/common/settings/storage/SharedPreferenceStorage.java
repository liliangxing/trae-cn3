package com.bytedance.news.common.settings.storage;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.api.SettingsLogService;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.internal.IEnsureWrapper;
import com.bytedance.services.apm.api.IEnsure;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class SharedPreferenceStorage implements Storage {
    private static final String TAG = "SharedPreferenceStorage";
    private SharedPreferences.Editor editor;
    private IEnsure iEnsure;
    private SharedPreferences preferences;

    public SharedPreferenceStorage(Context context, String str, boolean z) {
        SettingsLogService settingsLogService;
        SettingsConfigProvider settingsConfigProvider = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (settingsConfigProvider != null && settingsConfigProvider.getConfig() != null) {
            this.preferences = settingsConfigProvider.getConfig().getSharedPreferences(context, str + ".sp", 0, z);
        }
        try {
            if (this.preferences == null) {
                this.preferences = context.getSharedPreferences(str + ".sp", 0);
            }
        } catch (IllegalStateException e) {
            if (isDirectBootMode(context)) {
                Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                if (!createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str + ".sp") && settingsConfigProvider != null && settingsConfigProvider.getConfig() != null && (settingsLogService = settingsConfigProvider.getConfig().getSettingsLogService()) != null) {
                    settingsLogService.m130e(TAG, "Failed to migrate shared preferences = " + str + ".sp");
                }
                if (this.preferences == null) {
                    this.preferences = createDeviceProtectedStorageContext.getSharedPreferences(str + ".sp", 0);
                }
            } else {
                throw e;
            }
        }
        this.editor = this.preferences.edit();
    }

    private static boolean isDirectBootMode(Context context) {
        DevicePolicyManager devicePolicyManager;
        if (Build.VERSION.SDK_INT < 26 || (devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy")) == null) {
            return false;
        }
        try {
            int storageEncryptionStatus = devicePolicyManager.getStorageEncryptionStatus();
            return storageEncryptionStatus == 5 || storageEncryptionStatus == 3;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putString(String str, String str2) {
        this.editor.putString(str, str2);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putInt(String str, int i) {
        this.editor.putInt(str, i);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putLong(String str, long j) {
        this.editor.putLong(str, j);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putFloat(String str, float f) {
        this.editor.putFloat(str, f);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putBoolean(String str, boolean z) {
        this.editor.putBoolean(str, z);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void putStringSet(String str, Set<String> set) {
        this.editor.putStringSet(str, set);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public String getString(String str) {
        return getString(str, "");
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public String getString(String str, String str2) {
        try {
            return this.preferences.getString(str, str2);
        } catch (Exception e) {
            reportError(e);
            return str2;
        }
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public int getInt(String str, int i) {
        try {
            return this.preferences.getInt(str, i);
        } catch (Exception e) {
            reportError(e);
            return i;
        }
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public long getLong(String str) {
        return getLong(str, 0L);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public long getLong(String str, long j) {
        try {
            return this.preferences.getLong(str, j);
        } catch (Exception e) {
            reportError(e);
            return j;
        }
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public float getFloat(String str, float f) {
        try {
            return this.preferences.getFloat(str, f);
        } catch (Exception e) {
            reportError(e);
            return f;
        }
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.preferences.getBoolean(str, z);
        } catch (Exception e) {
            reportError(e);
            return z;
        }
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public Set<String> getStringSet(String str) {
        return getStringSet(str, new HashSet());
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.preferences.getStringSet(str, set);
        } catch (Exception e) {
            reportError(e);
            return set;
        }
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void remove(String str) {
        this.editor.remove(str);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void clear() {
        this.editor.clear();
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public boolean contains(String str) {
        return this.preferences.contains(str);
    }

    @Override // com.bytedance.news.common.settings.api.Storage
    public void apply() {
        this.editor.apply();
    }

    private void reportError(Exception exc) {
        if (this.iEnsure == null) {
            this.iEnsure = IEnsureWrapper.getInstance();
        }
        IEnsure iEnsure = this.iEnsure;
        if (iEnsure != null) {
            iEnsure.reportLogException(exc);
        }
    }
}

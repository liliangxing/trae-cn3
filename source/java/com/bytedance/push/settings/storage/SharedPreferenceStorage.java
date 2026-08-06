package com.bytedance.push.settings.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.push.settings.IDataChangedListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class SharedPreferenceStorage implements Storage {
    private Map<IDataChangedListener, SharedPreferences.OnSharedPreferenceChangeListener> listenerMap = new ConcurrentHashMap();
    private SharedPreferences preferences;

    private void reportError(Exception exc) {
    }

    public SharedPreferenceStorage(Context context, String str) {
        this.preferences = context.getSharedPreferences(str, 0);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public String getString(String str, String str2) {
        try {
            return this.preferences.getString(str, str2);
        } catch (Exception e) {
            reportError(e);
            return str2;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public int getInt(String str, int i) {
        try {
            return this.preferences.getInt(str, i);
        } catch (Exception e) {
            reportError(e);
            return i;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public long getLong(String str) {
        return getLong(str, 0L);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public long getLong(String str, long j) {
        try {
            return this.preferences.getLong(str, j);
        } catch (Exception e) {
            reportError(e);
            return j;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public float getFloat(String str, float f) {
        try {
            return this.preferences.getFloat(str, f);
        } catch (Exception e) {
            reportError(e);
            return f;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.preferences.getBoolean(str, z);
        } catch (Exception e) {
            reportError(e);
            return z;
        }
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public boolean contains(String str) {
        return this.preferences.contains(str);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public SharedPreferences.Editor edit() {
        return this.preferences.edit();
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public void registerValChanged(Context context, final String str, String str2, final IDataChangedListener iDataChangedListener) {
        if (iDataChangedListener == null) {
            return;
        }
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.bytedance.push.settings.storage.SharedPreferenceStorage.1
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str3) {
                if (TextUtils.equals(str, str3)) {
                    iDataChangedListener.onChange();
                }
            }
        };
        this.listenerMap.put(iDataChangedListener, onSharedPreferenceChangeListener);
        this.preferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.bytedance.push.settings.storage.Storage
    public void unregisterValChanged(IDataChangedListener iDataChangedListener) {
        SharedPreferences.OnSharedPreferenceChangeListener remove;
        if (iDataChangedListener == null || (remove = this.listenerMap.remove(iDataChangedListener)) == null) {
            return;
        }
        this.preferences.unregisterOnSharedPreferenceChangeListener(remove);
    }
}

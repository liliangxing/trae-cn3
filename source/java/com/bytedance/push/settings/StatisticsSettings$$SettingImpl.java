package com.bytedance.push.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.push.settings.storage.Storage;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class StatisticsSettings$$SettingImpl implements StatisticsSettings {
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.push.settings.StatisticsSettings$$SettingImpl.1
        @Override // com.bytedance.push.settings.InstanceCreator
        public <T> T create(Class<T> cls) {
            return null;
        }
    };

    public StatisticsSettings$$SettingImpl(Storage storage) {
        this.mStorage = storage;
    }

    @Override // com.bytedance.push.settings.StatisticsSettings
    public long statsForegroundInterval() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains(StatisticsSettings.KEY_STATS_FOREGROUND)) {
            return 300000L;
        }
        return this.mStorage.getLong(StatisticsSettings.KEY_STATS_FOREGROUND);
    }

    @Override // com.bytedance.push.settings.StatisticsSettings
    public long statsBackgroundInterval() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains(StatisticsSettings.KEY_STATS_BACKGROUND)) {
            return 300000L;
        }
        return this.mStorage.getLong(StatisticsSettings.KEY_STATS_BACKGROUND);
    }

    @Override // com.bytedance.push.settings.ISettings
    public void updateSettings(Context context, JSONObject jSONObject) {
        Storage storage;
        if (jSONObject == null || (storage = this.mStorage) == null) {
            return;
        }
        SharedPreferences.Editor edit = storage.edit();
        if (jSONObject != null) {
            if (jSONObject.has(StatisticsSettings.KEY_STATS_FOREGROUND)) {
                edit.putLong(StatisticsSettings.KEY_STATS_FOREGROUND, jSONObject.optLong(StatisticsSettings.KEY_STATS_FOREGROUND));
            }
            if (jSONObject.has(StatisticsSettings.KEY_STATS_BACKGROUND)) {
                edit.putLong(StatisticsSettings.KEY_STATS_BACKGROUND, jSONObject.optLong(StatisticsSettings.KEY_STATS_BACKGROUND));
            }
        }
        edit.apply();
    }

    @Override // com.bytedance.push.settings.ISettings
    public void registerValChanged(Context context, String str, String str2, IDataChangedListener iDataChangedListener) {
        Storage storage = this.mStorage;
        if (storage != null) {
            storage.registerValChanged(context, str, str2, iDataChangedListener);
        }
    }

    @Override // com.bytedance.push.settings.ISettings
    public void unregisterValChanged(IDataChangedListener iDataChangedListener) {
        Storage storage = this.mStorage;
        if (storage != null) {
            storage.unregisterValChanged(iDataChangedListener);
        }
    }
}

package com.bytedance.push.frontier.setting;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.push.settings.IDataChangedListener;
import com.bytedance.push.settings.InstanceCache;
import com.bytedance.push.settings.InstanceCreator;
import com.bytedance.push.settings.storage.Storage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FrontierLocalSetting$$SettingImpl implements FrontierLocalSetting {
    private Context mContext;
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.push.frontier.setting.FrontierLocalSetting$$SettingImpl.1
        @Override // com.bytedance.push.settings.InstanceCreator
        public <T> T create(Class<T> cls) {
            if (cls == FrontierSettingConverter.class) {
                return (T) new FrontierSettingConverter();
            }
            return null;
        }
    };
    private Storage mStorage;

    public FrontierLocalSetting$$SettingImpl(Context context, Storage storage) {
        this.mContext = context;
        this.mStorage = storage;
    }

    @Override // com.bytedance.push.frontier.setting.FrontierLocalSetting
    public long getLastRequestSettingTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains(FrontierLocalSetting.KEY_LAST_REQUEST_SETTING_TIME)) {
            return 0L;
        }
        return this.mStorage.getLong(FrontierLocalSetting.KEY_LAST_REQUEST_SETTING_TIME);
    }

    @Override // com.bytedance.push.frontier.setting.FrontierLocalSetting
    public void setLastRequestSettingTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong(FrontierLocalSetting.KEY_LAST_REQUEST_SETTING_TIME, j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.frontier.setting.FrontierLocalSetting
    public FrontierSetting getFrontierSetting() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains(FrontierLocalSetting.KEY_FRONTIER_SETTING)) {
            return ((FrontierSettingConverter) InstanceCache.obtain(FrontierSettingConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString(FrontierLocalSetting.KEY_FRONTIER_SETTING));
        }
        return ((FrontierSettingConverter) InstanceCache.obtain(FrontierSettingConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.frontier.setting.FrontierLocalSetting
    public void setFrontierSetting(FrontierSetting frontierSetting) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString(FrontierLocalSetting.KEY_FRONTIER_SETTING, ((FrontierSettingConverter) InstanceCache.obtain(FrontierSettingConverter.class, this.mInstanceCreator)).from(frontierSetting));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public void registerValChanged(Context context, String str, String str2, IDataChangedListener iDataChangedListener) {
        Storage storage = this.mStorage;
        if (storage != null) {
            storage.registerValChanged(context, str, str2, iDataChangedListener);
        }
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public void unregisterValChanged(IDataChangedListener iDataChangedListener) {
        Storage storage = this.mStorage;
        if (storage != null) {
            storage.unregisterValChanged(iDataChangedListener);
        }
    }
}

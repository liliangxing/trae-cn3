package com.xiaomi;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.push.settings.IDataChangedListener;
import com.bytedance.push.settings.InstanceCreator;
import com.bytedance.push.settings.storage.Storage;

/* loaded from: classes7.dex */
public class MiPushSettings$$SettingImpl implements MiPushSettings {
    private Context mContext;
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.xiaomi.MiPushSettings$$SettingImpl.1
        @Override // com.bytedance.push.settings.InstanceCreator
        public <T> T create(Class<T> cls) {
            return null;
        }
    };
    private Storage mStorage;

    public MiPushSettings$$SettingImpl(Context context, Storage storage) {
        this.mContext = context;
        this.mStorage = storage;
    }

    @Override // com.xiaomi.MiPushSettings
    public boolean hasUpgradeTo3616() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("mipush_upgrade_3616")) {
            return false;
        }
        return this.mStorage.getBoolean("mipush_upgrade_3616");
    }

    @Override // com.xiaomi.MiPushSettings
    public void setUpgradeTo3616(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("mipush_upgrade_3616", z);
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

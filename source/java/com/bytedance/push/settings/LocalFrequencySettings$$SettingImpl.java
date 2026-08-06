package com.bytedance.push.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.push.model.LocalRevokeCache;
import com.bytedance.push.model.TokenCache;
import com.bytedance.push.settings.storage.Storage;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LocalFrequencySettings$$SettingImpl implements LocalFrequencySettings {
    private Context mContext;
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.push.settings.LocalFrequencySettings$$SettingImpl.1
        @Override // com.bytedance.push.settings.InstanceCreator
        public <T> T create(Class<T> cls) {
            if (cls == TokenCacheConverter.class) {
                return (T) new TokenCacheConverter();
            }
            if (cls == LocalRevokeCacheConverter.class) {
                return (T) new LocalRevokeCacheConverter();
            }
            return null;
        }
    };
    private Storage mStorage;

    public LocalFrequencySettings$$SettingImpl(Context context, Storage storage) {
        this.mContext = context;
        this.mStorage = storage;
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public long getLastUpdateSenderTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_update_sender_time_mil")) {
            return 0L;
        }
        return this.mStorage.getLong("last_update_sender_time_mil");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastUpdateSenderTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_update_sender_time_mil", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastUpdateSenderDid() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_update_sender_did")) ? "" : this.mStorage.getString("last_update_sender_did");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastUpdateSenderDid(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_update_sender_did", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastUpdateSenderVersionCode() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_update_sender_vc")) ? "" : this.mStorage.getString("last_update_sender_vc");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastUpdateSenderVersionCode(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_update_sender_vc", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastUpdateSenderUpdateVersionCode() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_update_sender_gray_vc")) ? "" : this.mStorage.getString("last_update_sender_gray_vc");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastUpdateSenderUpdateVersionCode(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_update_sender_gray_vc", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastUpdateSenderChannel() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_update_sender_channel")) ? "" : this.mStorage.getString("last_update_sender_channel");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastUpdateSenderUpdateChannel(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_update_sender_channel", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getSupportSender() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_update_sender_supported")) ? "" : this.mStorage.getString("last_update_sender_supported");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setSupportSender(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_update_sender_supported", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public boolean isLastSendNotifyEnableSucc() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_send_switcher_stat")) {
            return false;
        }
        return this.mStorage.getBoolean("last_send_switcher_stat");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastSendNotifyEnableSucc(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("last_send_switcher_stat", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public int getSystemPushEnable() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("sys_switcher_stat")) {
            return -2;
        }
        return this.mStorage.getInt("sys_switcher_stat");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setSystemPushEnable(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt("sys_switcher_stat", i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public int getInnerPushEnable() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("inner_switcher_stat")) {
            return -1;
        }
        return this.mStorage.getInt("inner_switcher_stat");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setInnerPushEnable(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt("inner_switcher_stat", i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastNotificationChannelStatus() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("notify_channel_stat")) ? "" : this.mStorage.getString("notify_channel_stat");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastNotificationChannelStatus(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("notify_channel_stat", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public List<TokenCache> getTokenCache() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains("token_cache")) {
            return ((TokenCacheConverter) InstanceCache.obtain(TokenCacheConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("token_cache"));
        }
        return ((TokenCacheConverter) InstanceCache.obtain(TokenCacheConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setTokenCache(List<TokenCache> list) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("token_cache", ((TokenCacheConverter) InstanceCache.obtain(TokenCacheConverter.class, this.mInstanceCreator)).from(list));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public long getUploadSwitchTs() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_upload_switch_ts")) {
            return 0L;
        }
        return this.mStorage.getLong("last_upload_switch_ts");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setUploadSwitchTs(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_upload_switch_ts", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public List<LocalRevokeCache> getRevokeRidList() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains("revoke_rid_list")) {
            return ((LocalRevokeCacheConverter) InstanceCache.obtain(LocalRevokeCacheConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("revoke_rid_list"));
        }
        return ((LocalRevokeCacheConverter) InstanceCache.obtain(LocalRevokeCacheConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setRevokeRidList(List<LocalRevokeCache> list) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("revoke_rid_list", ((LocalRevokeCacheConverter) InstanceCache.obtain(LocalRevokeCacheConverter.class, this.mInstanceCreator)).from(list));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public long getLastRequestSettingsTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_request_settings_time_mil")) {
            return 0L;
        }
        return this.mStorage.getLong("last_request_settings_time_mil");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastRequestSettingsTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_request_settings_time_mil", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastUpdateSenderAlias() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_update_sender_alias")) ? "" : this.mStorage.getString("last_update_sender_alias");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastUpdateSenderAlias(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_update_sender_alias", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastRequestSettingsVersionCode() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_request_settings_vc")) ? "" : this.mStorage.getString("last_request_settings_vc");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastRequestSettingsVersionCode(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_request_settings_vc", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastRequestSettingsUpdateVersionCode() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_request_settings_gray_vc")) ? "" : this.mStorage.getString("last_request_settings_gray_vc");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastRequestSettingsUpdateVersionCode(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_request_settings_gray_vc", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public String getLastRequestSettingsChannel() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_request_settings_channel")) ? "" : this.mStorage.getString("last_request_settings_channel");
    }

    @Override // com.bytedance.push.settings.LocalFrequencySettings
    public void setLastRequestSettingsChannel(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_request_settings_channel", str);
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

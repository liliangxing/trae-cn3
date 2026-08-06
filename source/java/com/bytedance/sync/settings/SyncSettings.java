package com.bytedance.sync.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.Singleton;
import com.bytedance.sync.SyncConstants;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import com.bytedance.sync.logger.LogUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncSettings implements OnDataUpdateListener {
    private static final Singleton<SyncSettings> settingsSingleton = new Singleton<SyncSettings>() { // from class: com.bytedance.sync.settings.SyncSettings.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sync.Singleton
        public SyncSettings create(Object... objArr) {
            return new SyncSettings((Context) objArr[0]);
        }
    };
    private final Context mContext;
    private final List<OnDataUpdateListener> mListener;
    private final Singleton<SharedPreferences> mSp;
    private Singleton<ISettings> settings = new SettingSingleTon();

    public SyncSettings(Context context) {
        Singleton<SharedPreferences> singleton = new Singleton<SharedPreferences>() { // from class: com.bytedance.sync.settings.SyncSettings.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.sync.Singleton
            public SharedPreferences create(Object... objArr) {
                try {
                    return SyncSettings.this.mContext.getSharedPreferences(SyncConstants.SP_NAME, 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        };
        this.mSp = singleton;
        this.mListener = new ArrayList();
        this.mContext = context;
        singleton.get(new Object[0]);
    }

    public static SyncSettings inst(Context context) {
        return settingsSingleton.get(context);
    }

    @Override // com.bytedance.sync.interfaze.OnDataUpdateListener
    public void onDataUpdate(ISyncClient.Data data) {
        if (data == null) {
            return;
        }
        String str = null;
        try {
            if (data.data == null) {
                SDKMonitor.inst().monitorSettingError(null, "data is null");
                return;
            }
            String str2 = new String(data.data);
            try {
                new JSONObject(str2);
                LogUtils.m185d("update local settings : ".concat(str2));
                SharedPreferences sharedPreferences = this.mSp.get(new Object[0]);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString(SyncConstants.KEY_SETTING, str2).apply();
                }
                synchronized (this.mListener) {
                    int size = this.mListener.size();
                    OnDataUpdateListener[] onDataUpdateListenerArr = new OnDataUpdateListener[size];
                    this.mListener.toArray(onDataUpdateListenerArr);
                    for (int i = 0; i < size; i++) {
                        onDataUpdateListenerArr[i].onDataUpdate(data);
                    }
                }
            } catch (Exception e) {
                e = e;
                str = str2;
                e.printStackTrace();
                SDKMonitor.inst().monitorSettingError(str, Log.getStackTraceString(e));
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void addOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
        synchronized (this.mListener) {
            this.mListener.add(onDataUpdateListener);
        }
    }

    public void removeOnDataUpdateListener(OnDataUpdateListener onDataUpdateListener) {
        synchronized (this.mListener) {
            this.mListener.remove(onDataUpdateListener);
        }
    }

    public void setDid(String str) {
        SharedPreferences sharedPreferences = this.mSp.get(new Object[0]);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("device_id", str).apply();
        } else {
            LogUtils.m186e("sp is null when save did " + str);
        }
    }

    public String getSavedDid() {
        SharedPreferences sharedPreferences = this.mSp.get(new Object[0]);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("device_id", null);
        }
        return null;
    }

    public void setEnable(boolean z) {
        SharedPreferences sharedPreferences = this.mSp.get(new Object[0]);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(SyncConstants.SYNC_ENABLE, z).commit();
        } else {
            LogUtils.m186e("sp is null when set enable " + z);
        }
    }

    public boolean getEnable() {
        SharedPreferences sharedPreferences = this.mSp.get(new Object[0]);
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(SyncConstants.SYNC_ENABLE, true);
        }
        return true;
    }

    public ISettings getSettings() {
        return this.settings.get(new Object[0]);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private class SettingSingleTon extends Singleton<ISettings> {
        private SettingSingleTon() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.sync.Singleton
        public ISettings create(Object... objArr) {
            String string;
            SettingsV4 settingsV4 = new SettingsV4();
            try {
                SharedPreferences sharedPreferences = (SharedPreferences) SyncSettings.this.mSp.get(new Object[0]);
                if (sharedPreferences == null || (string = sharedPreferences.getString(SyncConstants.KEY_SETTING, null)) == null) {
                    return settingsV4;
                }
                ISettings iSettings = (ISettings) new Gson().fromJson(string, SettingsV4.class);
                return iSettings != null ? iSettings : settingsV4;
            } catch (Throwable th) {
                LogUtils.m186e("create settings err: " + th);
                return settingsV4;
            }
        }
    }
}

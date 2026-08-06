package com.bytedance.platform.settingsx.manager;

import android.text.TextUtils;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.api.ILocalSettings;
import com.bytedance.platform.settingsx.api.ISettings;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IndividualManager {
    private static final ConcurrentMap<String, IndividualManager> MANAGER_CACHE = new ConcurrentHashMap();
    private static final String TAG = "IndividualManager";
    private final SettingsCache mSettingsCache;
    private String mSettingsId;

    public static IndividualManager obtainManager(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("settingsId不能为空");
        }
        ConcurrentMap<String, IndividualManager> concurrentMap = MANAGER_CACHE;
        IndividualManager individualManager = concurrentMap.get(str);
        if (individualManager == null) {
            synchronized (IndividualManager.class) {
                individualManager = concurrentMap.get(str);
                if (individualManager == null) {
                    individualManager = new IndividualManager(str);
                    concurrentMap.putIfAbsent(str, individualManager);
                }
            }
        }
        return individualManager;
    }

    private IndividualManager(String str) {
        SettingsCache settingsCache = new SettingsCache();
        this.mSettingsCache = settingsCache;
        this.mSettingsId = str;
        settingsCache.init(str, 4);
    }

    public <T> T obtain(Class<T> cls) {
        if (ISettings.class.isAssignableFrom(cls)) {
            return (T) this.mSettingsCache.obtain(cls, this.mSettingsId);
        }
        if (ILocalSettings.class.isAssignableFrom(cls)) {
            return (T) this.mSettingsCache.obtainLocal(cls, this.mSettingsId);
        }
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    public void updateSettings(final JSONObject jSONObject) {
        GlobalConfig.getIOWritePool().execute(new Runnable() { // from class: com.bytedance.platform.settingsx.manager.IndividualManager.1
            @Override // java.lang.Runnable
            public void run() {
                IndividualManager.this.mSettingsCache.updateAppSettings(jSONObject);
            }
        });
    }
}

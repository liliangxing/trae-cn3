package com.bytedance.news.common.settings.internal;

import android.content.Context;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfig;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.SettingsIndexManager;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.StorageFactory;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.services.apm.api.EnsureManager;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingsCache {
    private static final String ALL_APP_SETTINGS_SP_NAME = "all_app_settings_sp";
    private static final String APP_SETTINGS_SP_NAME = "app_settings_sp_";
    private static final String TAG = "SettingsCache";
    private final ConcurrentHashMap<Class<? extends ISettings>, ISettings> SETTINGS_CACHE = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class<? extends ISettings>, Object> SETTINGS_CACHE_LOCKS = new ConcurrentHashMap<>();

    public synchronized String updateSingleAppSetting(JSONObject jSONObject, SettingsConfig settingsConfig) {
        String str;
        str = "";
        if (ExposedManager.sDebugTeller != null && ExposedManager.sDebugTeller.isDebug().booleanValue()) {
            String next = jSONObject.keys().next();
            this.SETTINGS_CACHE.clear();
            Context context = GlobalConfig.getContext();
            MetaInfo.getInstance(context).setLatestUpdateToken(UUID.randomUUID().toString(), settingsConfig.getId());
            LocalCache localCache = LocalCache.getInstance(context);
            str = localCache.getLocalSettingsData(settingsConfig.getId()).getAppSettings().optString(next, "");
            localCache.updateSingleSettingsData(jSONObject, settingsConfig.getId());
        }
        return str;
    }

    public synchronized void updateSettingsData(SettingsData settingsData, SettingsConfig settingsConfig, boolean z) {
        Iterator<ISettings> it = this.SETTINGS_CACHE.values().iterator();
        while (it.hasNext()) {
            it.next().updateSettings(settingsData);
        }
        Context context = GlobalConfig.getContext();
        MetaInfo.getInstance(context).setLatestUpdateToken(settingsData.getToken(), settingsConfig.getId());
        LocalCache.getInstance(context).setLocalSettingsData(settingsData, settingsConfig, z);
    }

    public <T extends ISettings> T obtain(Class<T> cls, SettingsConfig settingsConfig, String str) {
        Object obj;
        ISettings iSettings;
        T t = (T) this.SETTINGS_CACHE.get(cls);
        if (t == null) {
            Settings settings = (Settings) cls.getAnnotation(Settings.class);
            String str2 = settings == null ? "" : settings.settingsId();
            if (!str.equals(str2)) {
                throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + str2 + " - ");
            }
            synchronized (this.SETTINGS_CACHE_LOCKS) {
                obj = this.SETTINGS_CACHE_LOCKS.containsKey(cls) ? this.SETTINGS_CACHE_LOCKS.get(cls) : null;
                if (obj == null) {
                    obj = new Object();
                    this.SETTINGS_CACHE_LOCKS.put(cls, obj);
                }
            }
            synchronized (obj) {
                ISettings iSettings2 = this.SETTINGS_CACHE.get(cls);
                if (iSettings2 == null) {
                    iSettings = createInstance(cls, settingsConfig);
                    if (iSettings != null) {
                        this.SETTINGS_CACHE.put(cls, iSettings);
                    }
                } else {
                    iSettings = iSettings2;
                }
            }
            return (T) iSettings;
        }
        if (!this.SETTINGS_CACHE_LOCKS.containsKey(cls)) {
            return t;
        }
        this.SETTINGS_CACHE_LOCKS.remove(cls);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T extends ISettings> T createInstance(Class<T> cls, SettingsConfig settingsConfig) {
        boolean z;
        String storageKey;
        StorageFactory storageFactory = settingsConfig.getStorageFactory();
        T t = (T) SettingsCreator.create(cls, storageFactory);
        InvocationTargetException invocationTargetException = null;
        if (t != null) {
            t.updateSettings(null);
            return t;
        }
        try {
            Settings settings = (Settings) cls.getAnnotation(Settings.class);
            if (settings != null) {
                int maxAppSettingSpCount = settingsConfig.getMaxAppSettingSpCount();
                try {
                    z = ExposedManager.isUseOneSpForAppSettingsStatic();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    z = false;
                }
                String str = "";
                if (settingsConfig.useOneSpForAppSettings()) {
                    SettingsConfigProvider settingsConfigProvider = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
                    if (settingsConfigProvider != null && settingsConfigProvider.getConfig().useOneSpForAppSettings()) {
                        storageKey = ALL_APP_SETTINGS_SP_NAME;
                        if (!z) {
                            try {
                                ExposedManager.setUseOneSpForAppSettingsStatic(true);
                            } catch (RuntimeException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else if (maxAppSettingSpCount > 0) {
                        String storageKey2 = settings.storageKey();
                        if (storageKey2 != null) {
                            str = storageKey2;
                        }
                        storageKey = APP_SETTINGS_SP_NAME + (str.length() & maxAppSettingSpCount);
                    } else {
                        storageKey = settings.storageKey();
                        if (z) {
                            try {
                                ExposedManager.setUseOneSpForAppSettingsStatic(false);
                            } catch (RuntimeException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                } else if (maxAppSettingSpCount > 0) {
                    if (!z) {
                        try {
                            ExposedManager.setUseOneSpForAppSettingsStatic(true);
                        } catch (RuntimeException e4) {
                            e4.printStackTrace();
                        }
                    }
                    String storageKey3 = settings.storageKey();
                    if (storageKey3 != null) {
                        str = storageKey3;
                    }
                    storageKey = APP_SETTINGS_SP_NAME + (str.length() & maxAppSettingSpCount);
                } else {
                    storageKey = settings.storageKey();
                    if (z) {
                        try {
                            ExposedManager.setUseOneSpForAppSettingsStatic(false);
                        } catch (RuntimeException e5) {
                            e5.printStackTrace();
                        }
                    }
                }
                if (settingsConfig.useReflect()) {
                    return (T) createInstance(cls, storageFactory.create(storageKey, true));
                }
                Storage create = storageFactory.create(storageKey, true);
                T t2 = (T) SettingsIndexManager.getISettings(cls.getName(), create);
                if (t2 != null) {
                    t2.updateSettings(null);
                    return t2;
                }
                return (T) createInstance(cls, create);
            }
        } catch (ClassNotFoundException e6) {
            ClassNotFoundException classNotFoundException = e6;
            classNotFoundException.printStackTrace();
            EnsureManager.ensureNotReachHere(classNotFoundException, "获取settings实例失败，ClassNotFoundException");
            invocationTargetException = classNotFoundException;
        } catch (IllegalAccessException e7) {
            IllegalAccessException illegalAccessException = e7;
            illegalAccessException.printStackTrace();
            EnsureManager.ensureNotReachHere(illegalAccessException, "获取settings实例失败，IllegalAccessException");
            invocationTargetException = illegalAccessException;
        } catch (InstantiationException e8) {
            InstantiationException instantiationException = e8;
            instantiationException.printStackTrace();
            EnsureManager.ensureNotReachHere(instantiationException, "获取settings实例失败，InstantiationException");
            invocationTargetException = instantiationException;
        } catch (NoSuchMethodException e9) {
            NoSuchMethodException noSuchMethodException = e9;
            noSuchMethodException.printStackTrace();
            EnsureManager.ensureNotReachHere(noSuchMethodException, "获取settings实例失败，NoSuchMethodException");
            invocationTargetException = noSuchMethodException;
        } catch (InvocationTargetException e10) {
            InvocationTargetException invocationTargetException2 = e10;
            invocationTargetException2.printStackTrace();
            EnsureManager.ensureNotReachHere(invocationTargetException2, "获取settings实例失败，InvocationTargetException");
            invocationTargetException = invocationTargetException2;
        }
        if (invocationTargetException != null) {
            throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", invocationTargetException);
        }
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题");
    }

    private static <T extends ISettings> ISettings createInstance(Class<T> cls, Storage storage) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        ISettings iSettings = (ISettings) Class.forName(cls.getName() + "$$Impl", true, cls.getClassLoader()).getConstructor(Storage.class).newInstance(storage);
        iSettings.updateSettings(null);
        return iSettings;
    }

    public void clearCache() {
        synchronized (this.SETTINGS_CACHE_LOCKS) {
            this.SETTINGS_CACHE_LOCKS.clear();
            this.SETTINGS_CACHE.clear();
        }
    }
}

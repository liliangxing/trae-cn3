package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.settings.SettingsConfig;
import com.bytedance.news.common.settings.api.Storage;
import com.bytedance.news.common.settings.api.StorageFactory;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.Settings;
import com.bytedance.news.common.settings.api.exposed.ExposedManager;
import com.bytedance.news.common.settings.storage.LocalSettingsStorageFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LocalSettingsCache {
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> SETTINGS_CACHE = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, Object> LOCAL_SETTINGS_CACHE_LOCKS = new ConcurrentHashMap<>();

    public <T extends ILocalSettings> T obtain(Class<T> cls, SettingsConfig settingsConfig, String str) {
        Object obj;
        ILocalSettings iLocalSettings;
        T t = (T) this.SETTINGS_CACHE.get(cls);
        if (t == null) {
            Settings settings = (Settings) cls.getAnnotation(Settings.class);
            String str2 = settings == null ? "" : settings.settingsId();
            if (!str.equals(str2)) {
                throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + str2 + " - ");
            }
            synchronized (this.LOCAL_SETTINGS_CACHE_LOCKS) {
                obj = this.LOCAL_SETTINGS_CACHE_LOCKS.containsKey(cls) ? this.LOCAL_SETTINGS_CACHE_LOCKS.get(cls) : null;
                if (obj == null) {
                    obj = new Object();
                    this.LOCAL_SETTINGS_CACHE_LOCKS.put(cls, obj);
                }
            }
            synchronized (obj) {
                ILocalSettings iLocalSettings2 = this.SETTINGS_CACHE.get(cls);
                if (iLocalSettings2 == null) {
                    iLocalSettings = createInstance(cls, settingsConfig);
                    if (iLocalSettings != null) {
                        this.SETTINGS_CACHE.put(cls, iLocalSettings);
                    }
                } else {
                    iLocalSettings = iLocalSettings2;
                }
            }
            return (T) iLocalSettings;
        }
        if (!this.LOCAL_SETTINGS_CACHE_LOCKS.containsKey(cls)) {
            return t;
        }
        this.LOCAL_SETTINGS_CACHE_LOCKS.remove(cls);
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends ILocalSettings> T createInstance(Class<T> cls, SettingsConfig settingsConfig) {
        InvocationTargetException invocationTargetException;
        Constructor<?> constructor;
        Settings settings;
        Storage create;
        StorageFactory storageFactory = settingsConfig.getStorageFactory();
        T t = (T) SettingsCreator.create(cls, storageFactory);
        if (t != null) {
            return t;
        }
        try {
            constructor = Class.forName(cls.getName() + "$$Impl", true, cls.getClassLoader()).getConstructor(Storage.class);
            settings = (Settings) cls.getAnnotation(Settings.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            invocationTargetException = e;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            invocationTargetException = e2;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            invocationTargetException = e3;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            invocationTargetException = e4;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            invocationTargetException = e5;
        }
        if (settings != null) {
            if (ExposedManager.sDebugTeller != null && ExposedManager.sDebugTeller.isDebug().booleanValue() && settingsConfig.ifRecordLocalSettingsDataInOneCache()) {
                create = LocalSettingsStorageFactory.getInstance(storageFactory).create(settings.storageKey());
            } else {
                create = storageFactory.create(settings.storageKey());
            }
            return (T) constructor.newInstance(create);
        }
        invocationTargetException = null;
        throw new IllegalStateException("获取settings实例失败，检查warning日志确认问题", invocationTargetException);
    }
}

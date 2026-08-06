package com.bytedance.push.settings;

import android.content.Context;
import com.bytedance.push.settings.annotation.Settings;
import com.bytedance.push.settings.logger.SettingsLoggerHelper;
import com.bytedance.push.settings.storage.Storage;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class LocalSettingsCache {
    private final ConcurrentHashMap<Class<? extends ILocalSettings>, ILocalSettings> SETTINGS_CACHE = new ConcurrentHashMap<>();
    private final StorageFactory mStorageFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalSettingsCache(StorageFactory storageFactory) {
        this.mStorageFactory = storageFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T extends ILocalSettings> T obtain(Context context, Class<T> cls) {
        T t = (T) this.SETTINGS_CACHE.get(cls);
        if (t == null) {
            synchronized (this) {
                t = (T) this.SETTINGS_CACHE.get(cls);
                if (t == null) {
                    ILocalSettings createInstance = createInstance(context, cls);
                    this.SETTINGS_CACHE.put(cls, createInstance);
                    t = (T) createInstance;
                }
            }
        }
        return t;
    }

    private <T extends ILocalSettings> T createInstance(Context context, Class<T> cls) {
        StorageFactory storageFactory = this.mStorageFactory;
        T t = (T) SettingsCreator.create(cls, storageFactory);
        if (t != null) {
            return t;
        }
        try {
            Constructor<?> constructor = Class.forName(cls.getName() + "$$SettingImpl", true, cls.getClassLoader()).getConstructor(Context.class, Storage.class);
            Settings settings = (Settings) cls.getAnnotation(Settings.class);
            if (settings != null) {
                String storageKey = settings.storageKey();
                boolean supportMultiProcess = settings.supportMultiProcess();
                SettingsLoggerHelper.getInstance().d("createLocalSettingsInstance for " + storageKey);
                return (T) constructor.newInstance(context, storageFactory.create(context, supportMultiProcess, storageKey, null));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        throw new IllegalStateException("get settings instance error，please check warning log");
    }
}

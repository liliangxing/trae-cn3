package com.bytedance.push.settings;

import android.content.Context;
import com.bytedance.push.settings.annotation.Settings;
import com.bytedance.push.settings.storage.Storage;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingsCache {
    private final ConcurrentHashMap<Class<? extends ISettings>, ISettings> SETTINGS_CACHE = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Class<? extends ISettings>, Object> SETTINGS_CACHE_LOCKS = new ConcurrentHashMap<>();

    public synchronized void updateSettingsData(Context context, JSONObject jSONObject) {
        Iterator<ISettings> it = this.SETTINGS_CACHE.values().iterator();
        while (it.hasNext()) {
            it.next().updateSettings(context, jSONObject);
        }
    }

    public <T extends ISettings> T obtain(Context context, Class<T> cls) {
        Object obj;
        ISettings iSettings;
        T t = (T) this.SETTINGS_CACHE.get(cls);
        if (t == null) {
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
                    iSettings = createInstance(context, cls);
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
    private static <T extends ISettings> T createInstance(Context context, Class<T> cls) {
        StorageFactory storageFactory = SettingsManager.getStorageFactory();
        T t = (T) SettingsCreator.create(cls, storageFactory);
        InvocationTargetException invocationTargetException = null;
        if (t != null) {
            t.updateSettings(context, null);
            return t;
        }
        try {
            Settings settings = (Settings) cls.getAnnotation(Settings.class);
            if (settings != null) {
                return (T) createInstance(context, cls, storageFactory.create(context, settings.supportMultiProcess(), settings.storageKey(), null));
            }
        } catch (ClassNotFoundException e) {
            ClassNotFoundException classNotFoundException = e;
            classNotFoundException.printStackTrace();
            invocationTargetException = classNotFoundException;
        } catch (IllegalAccessException e2) {
            IllegalAccessException illegalAccessException = e2;
            illegalAccessException.printStackTrace();
            invocationTargetException = illegalAccessException;
        } catch (InstantiationException e3) {
            InstantiationException instantiationException = e3;
            instantiationException.printStackTrace();
            invocationTargetException = instantiationException;
        } catch (NoSuchMethodException e4) {
            NoSuchMethodException noSuchMethodException = e4;
            noSuchMethodException.printStackTrace();
            invocationTargetException = noSuchMethodException;
        } catch (InvocationTargetException e5) {
            InvocationTargetException invocationTargetException2 = e5;
            invocationTargetException2.printStackTrace();
            invocationTargetException = invocationTargetException2;
        }
        if (invocationTargetException != null) {
            throw new IllegalStateException("get settings instance error，please check warning log", invocationTargetException);
        }
        throw new IllegalStateException("get settings instance error，please check warning log");
    }

    private static <T extends ISettings> ISettings createInstance(Context context, Class<T> cls, Storage storage) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        ISettings iSettings = (ISettings) Class.forName(cls.getName() + "$$SettingImpl", true, cls.getClassLoader()).getConstructor(Storage.class).newInstance(storage);
        iSettings.updateSettings(context, null);
        return iSettings;
    }
}

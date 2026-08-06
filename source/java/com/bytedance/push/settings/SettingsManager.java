package com.bytedance.push.settings;

import android.content.Context;
import com.bytedance.push.settings.storage.SharedPreferenceStorageFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingsManager {
    public static boolean IS_PUSH_DEMO;
    public static boolean allowReadSettingsOnMain;
    public static boolean allowReadSettingsOnSmp;
    public static IEventService eventService;
    private static final SettingsCache mSettingsCache;
    private static final LocalSettingsCache sLocalSettingsCache;
    private static final SharedPreferenceStorageFactory sStorageFactory;

    static {
        SharedPreferenceStorageFactory sharedPreferenceStorageFactory = new SharedPreferenceStorageFactory();
        sStorageFactory = sharedPreferenceStorageFactory;
        sLocalSettingsCache = new LocalSettingsCache(sharedPreferenceStorageFactory);
        mSettingsCache = new SettingsCache();
        allowReadSettingsOnSmp = false;
        allowReadSettingsOnMain = false;
        IS_PUSH_DEMO = false;
    }

    public static <T> T obtain(Context context, Class<T> cls) {
        if (ISettings.class.isAssignableFrom(cls)) {
            return (T) mSettingsCache.obtain(context, cls);
        }
        if (ILocalSettings.class.isAssignableFrom(cls)) {
            return (T) sLocalSettingsCache.obtain(context, cls);
        }
        throw new IllegalArgumentException("tClass must be child of ISettings or ILocalSettings");
    }

    public static StorageFactory getStorageFactory() {
        return sStorageFactory;
    }
}

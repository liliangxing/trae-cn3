package com.bytedance.platform.settingsx.manager;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.Pair;
import com.bytedance.platform.settingsx.annotation.SettingsX;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.api.ILocalSettings;
import com.bytedance.platform.settingsx.api.ISettings;
import com.bytedance.platform.settingsx.api.map.MappedData;
import com.bytedance.platform.settingsx.map.DataMapManager;
import com.bytedance.platform.settingsx.storage.Storage;
import com.bytedance.platform.settingsx.storage.StorageManager;
import com.bytedance.platform.settingsx.storage.StorageType;
import com.bytedance.push.utils.RomVersionParamHelper;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingsCache {
    private static final String APP_PREFIX = "settingsx_app_";
    private static final String LOCAL_PREFIX = "settingsx_local_";
    private static final String TAG = "SettingsXCache";
    private final Map<String, ISettings> SETTINGS_CACHE = new ConcurrentHashMap();
    private final Map<String, ILocalSettings> LOCAL_SETTINGS_CACHE = new ConcurrentHashMap();
    private final Storage appStorage = new Storage(StorageType.APP_SETTINGS);
    private final Storage localStorage = new Storage(StorageType.LOCAL_SETTINGS);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            this.appStorage.init(APP_PREFIX, i, str);
            if (GlobalConfig.getConfig().enableLocalSettings) {
                this.localStorage.init(LOCAL_PREFIX, i, str);
            }
        } else {
            this.appStorage.init(APP_PREFIX + str + RomVersionParamHelper.SEPARATOR, i, str);
            if (GlobalConfig.getConfig().enableLocalSettings) {
                this.localStorage.init(LOCAL_PREFIX + str + RomVersionParamHelper.SEPARATOR, i, str);
            }
        }
        StorageManager.init(this.appStorage, this.localStorage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateAppSettings(JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        Pair<Map<Integer, List<MappedData>>, Map<Integer, Set<String>>> convert = DataMapManager.convert(jSONObject);
        this.appStorage.update((Map) convert.first, (Map) convert.second, jSONObject);
        Iterator<ISettings> it = this.SETTINGS_CACHE.values().iterator();
        while (it.hasNext()) {
            it.next().updateSettings();
        }
        Log.i(TAG, "更新完成,耗时=" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public <T extends ISettings> T obtain(Class<T> cls, String str) {
        if (ISettings.class.isAssignableFrom(cls)) {
            SettingsX settingsX = (SettingsX) cls.getAnnotation(SettingsX.class);
            String str2 = settingsX == null ? "" : settingsX.settingsId();
            if (!str.equals(str2)) {
                throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + str2 + " - ");
            }
            String name = cls.getName();
            if (this.SETTINGS_CACHE.get(name) == null) {
                synchronized (cls.getName()) {
                    ISettings instanceFromByteIndex = instanceFromByteIndex(name);
                    if (instanceFromByteIndex == null) {
                        instanceFromByteIndex = instanceFromReflect(cls);
                    }
                    if (instanceFromByteIndex == null) {
                        throw new IllegalStateException("获取[" + name + "]Settings实例失败,请检查是否生成[" + name + "$$ImplX]类");
                    }
                    this.SETTINGS_CACHE.put(name, instanceFromByteIndex);
                }
            }
        }
        return null;
    }

    public <T extends ILocalSettings> T obtainLocal(Class<T> cls, String str) {
        if (ILocalSettings.class.isAssignableFrom(cls)) {
            SettingsX settingsX = (SettingsX) cls.getAnnotation(SettingsX.class);
            String str2 = settingsX == null ? "" : settingsX.settingsId();
            if (!str.equals(str2)) {
                throw new IllegalArgumentException("Settings声明id与Manager不匹配：" + str2 + " - ");
            }
            String name = cls.getName();
            T t = (T) this.LOCAL_SETTINGS_CACHE.get(name);
            if (t == null) {
                synchronized (cls.getName()) {
                    t = instanceLocalSettingsFromIndex(name);
                    if (t == null) {
                        t = (T) instanceLocalSettingsFromReflect(cls);
                    }
                    if (t == null) {
                        throw new IllegalStateException("获取[" + name + "]Settings实例失败,请检查是否生成[" + name + "$$ImplX]类");
                    }
                    this.LOCAL_SETTINGS_CACHE.put(name, t);
                }
            }
            return (T) t;
        }
        return null;
    }

    private ISettings instanceFromByteIndex(String str) {
        return SettingsIndex.getSettings(str, new SettingContext(this.appStorage, false));
    }

    private ISettings instanceFromReflect(Class<?> cls) {
        try {
            String str = cls.getName() + "$$ImplX";
            Log.e(TAG, "反射创建Settings:" + str);
            return (ISettings) Class.forName(str, true, cls.getClassLoader()).getConstructor(SettingContext.class).newInstance(new SettingContext(this.appStorage, true));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private ILocalSettings instanceLocalSettingsFromIndex(String str) {
        return SettingsIndex.getLocalSettings(str, new SettingContext(this.localStorage, false));
    }

    private ILocalSettings instanceLocalSettingsFromReflect(Class<?> cls) {
        SettingContext settingContext = new SettingContext(this.localStorage, true);
        String str = cls.getName() + "$$ImplX";
        try {
            Log.e(TAG, "反射创建Settings:" + str);
            return (ILocalSettings) Class.forName(str, true, cls.getClassLoader()).getConstructor(SettingContext.class).newInstance(settingContext);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("获取[" + str + "]Settings实例失败,请检查是否生成[" + str + "$$ImplX]类", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("获取[" + str + "]Settings实例失败,请检查是否生成[" + str + "$$ImplX]类", e2);
        } catch (InstantiationException e3) {
            throw new IllegalStateException("获取[" + str + "]Settings实例失败,请检查是否生成[" + str + "$$ImplX]类", e3);
        } catch (NoSuchMethodException e4) {
            throw new IllegalStateException("获取[" + str + "]Settings实例失败,请检查是否生成[" + str + "$$ImplX]类", e4);
        } catch (InvocationTargetException e5) {
            throw new IllegalStateException("获取[" + str + "]Settings实例失败,请检查是否生成[" + str + "$$ImplX]类", e5);
        }
    }

    public void clearCache() {
        this.LOCAL_SETTINGS_CACHE.clear();
        this.SETTINGS_CACHE.clear();
    }
}

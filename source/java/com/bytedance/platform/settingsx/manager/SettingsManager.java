package com.bytedance.platform.settingsx.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.platform.godzilla.common.Constant;
import com.bytedance.platform.settingsx.api.Config;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.api.ILocalSettings;
import com.bytedance.platform.settingsx.api.ISettings;
import com.bytedance.platform.settingsx.api.ISettingsGetter;
import com.bytedance.platform.settingsx.api.ISharedPreferences;
import com.bytedance.platform.settingsx.api.Logger;
import com.bytedance.platform.settingsx.api.exposed.ExposedManagerX;
import com.bytedance.platform.settingsx.api.internal.ToolUtils;
import com.bytedance.platform.settingsx.api.storage.BlockCreator;
import com.bytedance.platform.settingsx.api.storage.IBlock;
import com.bytedance.platform.settingsx.monitor.SettingsXMonitor;
import com.bytedance.platform.settingsx.storage.PbFileBlock;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SettingsManager {
    private static final String TAG = "SettingsX";
    private static volatile boolean isInit;
    private static SettingsCache settingsCache = new SettingsCache();
    private static final ConcurrentHashMap<Class<?>, SettingsListenerInfo> LISTENERS = new ConcurrentHashMap<>();
    private static final Set<String> blackList = new HashSet();
    private static boolean sEnableLocalSettings = false;

    public static void init(Context context) {
        init(Config.with(context).build());
    }

    public static synchronized void init(Config config) {
        synchronized (SettingsManager.class) {
            if (isInit) {
                return;
            }
            createConfig(config);
            settingsCache.init("", 16);
            Logger.setLog(config.logImpl);
            Logger.setLogLevel(config.logLevel);
            Logger.setIsMainProcess(ToolUtils.isMainProcess(GlobalConfig.getContext()));
            Logger.setOnlyLogMainProcess(config.onlyMainProcessLog);
            SettingsXMonitor.setCallback(config.monitorCallback);
            SettingsXMonitor.setExecutor(config.workPool);
            initBlack();
            isInit = true;
            sEnableLocalSettings = config.enableLocalSettings;
            GlobalConfig.setManagerInit(true);
            checkSafeModeFixing(config.context);
            ExposedManagerX.getInstance(config.context).setEnable(true);
        }
    }

    private static void createConfig(Config config) {
        if (config.blockCreator == null) {
            config.blockCreator = new BlockCreator() { // from class: com.bytedance.platform.settingsx.manager.SettingsManager$$ExternalSyntheticLambda2
                @Override // com.bytedance.platform.settingsx.api.storage.BlockCreator
                public final IBlock create(String str) {
                    return new PbFileBlock(str);
                }
            };
        }
        if (config.sharedPreferences == null) {
            config.sharedPreferences = new ISharedPreferences() { // from class: com.bytedance.platform.settingsx.manager.SettingsManager$$ExternalSyntheticLambda3
                @Override // com.bytedance.platform.settingsx.api.ISharedPreferences
                public final SharedPreferences getSharedPreferences(Context context, String str, int i) {
                    SharedPreferences sharedPreferences;
                    sharedPreferences = context.getSharedPreferences(str, i);
                    return sharedPreferences;
                }
            };
        }
        GlobalConfig.init(config);
    }

    public static void reset(Executor executor, final Context context) {
        executor.execute(new Runnable() { // from class: com.bytedance.platform.settingsx.manager.SettingsManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MigrationHelper.clearAllMigrationFlag(context);
            }
        });
    }

    public static void migration(Config config, ISettingsGetter iSettingsGetter) {
        createConfig(config);
        MigrationHelper.migrationAppSettings(iSettingsGetter);
    }

    public static boolean isInit() {
        return isInit;
    }

    public static <T> T obtain(Class<T> cls) {
        if (ISettings.class.isAssignableFrom(cls)) {
            return (T) settingsCache.obtain(cls, "");
        }
        if (ILocalSettings.class.isAssignableFrom(cls)) {
            return (T) settingsCache.obtainLocal(cls, "");
        }
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    public static void updateAppSettingsAsync(final JSONObject jSONObject) {
        if (isInit) {
            GlobalConfig.getIOWritePool().execute(new Runnable() { // from class: com.bytedance.platform.settingsx.manager.SettingsManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    SettingsManager.lambda$updateAppSettingsAsync$2(jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateAppSettingsAsync$2(JSONObject jSONObject) {
        updateAppSettings(jSONObject);
        Log.e(TAG, "updateAppSettingsForDebug finish");
    }

    public static void updateAppSettingsForDebug(final JSONObject jSONObject) {
        if (isInit) {
            GlobalConfig.getIOWritePool().execute(new Runnable() { // from class: com.bytedance.platform.settingsx.manager.SettingsManager$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    SettingsManager.lambda$updateAppSettingsForDebug$3(jSONObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$updateAppSettingsForDebug$3(JSONObject jSONObject) {
        updateAppSettings(jSONObject);
        Log.e(TAG, "updateAppSettingsForDebug finish");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateAppSettings(JSONObject jSONObject) {
        settingsCache.updateAppSettings(jSONObject);
        updateFinish();
    }

    public static void registerListener(Class<?> cls, SettingsUpdateListener settingsUpdateListener) {
        registerListener(cls, settingsUpdateListener, false);
    }

    public static void registerListener(Class<?> cls, SettingsUpdateListener settingsUpdateListener, boolean z) {
        LISTENERS.put(cls, new SettingsListenerInfo(settingsUpdateListener, z));
    }

    public static void unregisterListener(Class<?> cls) {
        LISTENERS.remove(cls);
    }

    public static void initBlack() {
        Map<String, ?> all;
        if (!GlobalConfig.getConfig().openBlackList || (all = GlobalConfig.getSp().getSharedPreferences(GlobalConfig.getContext(), "settingsx_key_black_list", 0).getAll()) == null) {
            return;
        }
        blackList.addAll(all.keySet());
    }

    public static boolean isBlack(String str) {
        if (isInit && GlobalConfig.getConfig().openBlackList) {
            return blackList.contains(str);
        }
        return false;
    }

    public static void addBlack(String str) {
        if (isInit && GlobalConfig.getConfig().openBlackList) {
            blackList.add(str);
            GlobalConfig.getSp().getSharedPreferences(GlobalConfig.getContext(), "settingsx_key_black_list", 0).edit().putBoolean(str, true).apply();
        }
    }

    public static void removeBlack(String str) {
        if (isInit && GlobalConfig.getConfig().openBlackList) {
            blackList.remove(str);
            GlobalConfig.getSp().getSharedPreferences(GlobalConfig.getContext(), "settingsx_key_black_list", 0).edit().remove(str).apply();
        }
    }

    private static void updateFinish() {
        for (Map.Entry<Class<?>, SettingsListenerInfo> entry : LISTENERS.entrySet()) {
            SettingsListenerInfo value = entry.getValue();
            if (value != null) {
                value.listener.onSettingsUpdate((ISettings) obtain(entry.getKey()));
            }
        }
    }

    public static void setEnableLocalSettings(boolean z) {
        sEnableLocalSettings = z;
    }

    public static boolean isEnableLocalSettings() {
        return sEnableLocalSettings;
    }

    public static boolean isBackupLocalSettings() {
        return GlobalConfig.getConfig().isBackupLocalSettings;
    }

    public static boolean isMigrationLocalSettings() {
        return GlobalConfig.getConfig().isBackupLocalSettings;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void checkSafeModeFixing(Context context) {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        Throwable th;
        File file = new File(context.getFilesDir().getAbsolutePath() + "/safe_mode/settings_fixing_result.txt");
        if (!file.exists()) {
            return;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, Constant.CHARSET_UTF_8);
                try {
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else {
                            stringBuffer.append(new String(readLine.getBytes(), Constant.CHARSET_UTF_8));
                        }
                    }
                    settingsCache.updateAppSettings(new JSONObject(stringBuffer.toString()));
                    updateFinish();
                    if (file.exists()) {
                        file.delete();
                    }
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused) {
                    }
                } catch (Exception unused2) {
                    fileInputStream2 = fileInputStream;
                    if (file.exists()) {
                        file.delete();
                    }
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (inputStreamReader == null) {
                        return;
                    }
                    inputStreamReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    if (file.exists()) {
                        file.delete();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (inputStreamReader == null) {
                        try {
                            inputStreamReader.close();
                            throw th;
                        } catch (Throwable unused5) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
                inputStreamReader = null;
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                th = th;
                if (file.exists()) {
                }
                if (fileInputStream != null) {
                }
                if (inputStreamReader == null) {
                }
            }
        } catch (Exception unused7) {
            inputStreamReader = null;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            inputStreamReader = null;
        }
        try {
            inputStreamReader.close();
        } catch (Throwable unused8) {
        }
    }
}

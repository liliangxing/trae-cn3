package com.bytedance.platform.settingsx.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.platform.settingsx.api.GlobalConfig;
import com.bytedance.platform.settingsx.api.ISettingsGetter;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MigrationHelper {
    private static final String MIGRATION_APP_SETTINGS_FLAG = "app_settings_all";
    private static final String TAG = "SettingsX";
    private static File sMigrationDir;

    public static void migrationLocalSettings(String str) {
    }

    public static void migrationV2Async(String str) {
    }

    public static void migrationV2Async(String str, Class<?> cls) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void migrationAppSettings(final ISettingsGetter iSettingsGetter) {
        GlobalConfig.getIOWritePool().execute(new Runnable() { // from class: com.bytedance.platform.settingsx.manager.MigrationHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MigrationHelper.lambda$migrationAppSettings$0(ISettingsGetter.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$migrationAppSettings$0(ISettingsGetter iSettingsGetter) {
        boolean haveServerMigration = haveServerMigration(GlobalConfig.getContext());
        Log.e(TAG, "是否已经迁移过数据" + haveServerMigration);
        if (haveServerMigration) {
            return;
        }
        Log.e(TAG, "迁移数据开始");
        JSONObject appSettings = iSettingsGetter.getAppSettings();
        Log.e(TAG, "数据=" + appSettings);
        SettingsManager.updateAppSettings(appSettings);
        setServerMigration(GlobalConfig.getContext());
        Log.e(TAG, "迁移数据结束");
    }

    static boolean haveServerMigration(Context context) {
        initIfNeed(context);
        return new File(sMigrationDir, MIGRATION_APP_SETTINGS_FLAG).exists();
    }

    public static boolean haveMigration(String str) {
        return haveMigration(GlobalConfig.getContext(), str);
    }

    static boolean haveMigration(Context context, String str) {
        initIfNeed(context);
        return new File(sMigrationDir, str).exists();
    }

    static void setServerMigration(Context context) {
        initIfNeed(context);
        setMigration(context, MIGRATION_APP_SETTINGS_FLAG);
    }

    public static void setMigration(String str) {
        setMigration(GlobalConfig.getContext(), str);
    }

    public static void setMigration(Context context, String str) {
        initIfNeed(context);
        File file = new File(sMigrationDir, str);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearAllMigrationFlag(Context context) {
        initIfNeed(context);
        IOUtils.deletePath(sMigrationDir.getAbsolutePath());
    }

    static void clearServerMigration(Context context) {
        initIfNeed(context);
        clearMigration(context, MIGRATION_APP_SETTINGS_FLAG);
    }

    static void clearMigration(Context context, String str) {
        initIfNeed(context);
        File file = new File(sMigrationDir, str);
        if (file.exists()) {
            file.delete();
        }
    }

    static void clearLocalMigration(Context context) {
        initIfNeed(context);
        File[] listFiles = sMigrationDir.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!TextUtils.equals(file.getName(), MIGRATION_APP_SETTINGS_FLAG)) {
                    IOUtils.deleteFile(file.getAbsolutePath());
                }
            }
        }
    }

    private static void initIfNeed(Context context) {
        if (sMigrationDir == null) {
            File file = new File(context.getFilesDir(), "settingsx/migration");
            sMigrationDir = file;
            if (file.exists()) {
                return;
            }
            sMigrationDir.mkdirs();
        }
    }

    public static SharedPreferences getLocalSettingMigrationRecorder() {
        return GlobalConfig.getSp().getSharedPreferences(GlobalConfig.getContext(), "settingsx_local_settings_migration_metadata", 4);
    }
}

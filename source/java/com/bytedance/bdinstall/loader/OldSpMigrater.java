package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class OldSpMigrater {
    OldSpMigrater() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tryDoSDKMigrate(Context context, Env env, InstallOptions installOptions) {
        SharedPreferences commonSp = LocalConstants.getCommonSp(context, installOptions);
        SharedPreferences envIsolateSp = env.getEnvIsolateSp(installOptions);
        if (commonSp.getBoolean("dr_install_migrate", false)) {
            return;
        }
        migrateDidSp(installOptions, envIsolateSp);
        commonSp.edit().putBoolean("dr_install_migrate", true).apply();
    }

    private static void migrateDidSp(InstallOptions installOptions, SharedPreferences sharedPreferences) {
        boolean z;
        SharedPreferences sp = installOptions.getSp();
        String string = sp.getString("device_id", null);
        String string2 = sp.getString("bd_did", null);
        String string3 = sp.getString("install_id", null);
        String string4 = sp.getString("ssid", null);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        boolean z2 = true;
        if (TextUtils.isEmpty(string)) {
            z = false;
        } else {
            edit.putString("device_id", string);
            z = true;
        }
        if (!TextUtils.isEmpty(string2)) {
            edit.putString("bd_did", string2);
            z = true;
        }
        if (!TextUtils.isEmpty(string3)) {
            edit.putString("install_id", string3);
            z = true;
        }
        if (TextUtils.isEmpty(string4)) {
            z2 = z;
        } else {
            edit.putString("ssid", string4);
        }
        if (z2) {
            edit.apply();
        }
    }
}

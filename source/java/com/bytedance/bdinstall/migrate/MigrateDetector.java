package com.bytedance.bdinstall.migrate;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.LocalConstants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MigrateDetector {
    public static final String KEY_COMPONENT_STATE = "component_state";
    private static final int STATE_DEFAULT = 0;
    private static final int STATE_DISABLED = 2;
    private static final int STATE_ENABLED = 1;
    private static final int STATE_FLAG = 1;
    private static final int STATE_NOT_INITIALIZE = -1;
    private static int componentEnableStateCache = -1;
    private final ComponentName component;
    private final boolean migrate;

    /* renamed from: pm */
    private final PackageManager f89pm;

    /* renamed from: sp */
    private final SharedPreferences f90sp;

    private static String getComponentState(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "STATE_DISABLED" : "STATE_ENABLED" : "STATE_DEFAULT";
    }

    public MigrateDetector(Context context, InstallOptions installOptions) {
        Context applicationContext = context.getApplicationContext();
        this.f90sp = LocalConstants.getCommonSp(context, installOptions);
        this.f89pm = applicationContext.getPackageManager();
        this.component = new ComponentName(context, (Class<?>) MigrateDetectorActivity.class);
        boolean isMigrateInternal = isMigrateInternal();
        this.migrate = isMigrateInternal;
        DrLog.m139d("MigrateDetector#constructor migrate=" + isMigrateInternal);
    }

    public void disableComponent() {
        DrLog.m139d("MigrateDetector#disableComponent");
        try {
            this.f89pm.setComponentEnabledSetting(this.component, 2, 1);
            this.f90sp.edit().putInt(KEY_COMPONENT_STATE, 2).apply();
        } catch (Exception e) {
            e.printStackTrace();
            DrLog.m141e("MigrateDetector#disableComponent error", e);
        }
    }

    public boolean isMigrate() {
        return this.migrate;
    }

    private int getComponentEnabledSetting() {
        return this.f89pm.getComponentEnabledSetting(this.component);
    }

    private boolean isMigrateInternal() {
        int i = componentEnableStateCache;
        if (i == -1) {
            try {
                i = getComponentEnabledSetting();
                componentEnableStateCache = i;
            } catch (Exception unused) {
                return false;
            }
        }
        int i2 = this.f90sp.getInt(KEY_COMPONENT_STATE, 0);
        DrLog.m139d("MigrateDetector#isMigrateInternal cs=" + getComponentState(i) + " ss=" + getComponentState(i2));
        return i == 0 && i2 == 2;
    }

    public static void saveOldDid(Context context, InstallOptions installOptions, String str, boolean z) {
        SharedPreferences.Editor edit = LocalConstants.getCommonSp(context, installOptions).edit();
        edit.putString("old_did", str);
        if (z) {
            edit.putBoolean(Api.SP_KEY_IS_MIGRATE, true);
        } else {
            edit.remove(Api.SP_KEY_IS_MIGRATE);
        }
        edit.apply();
    }

    public static String getOldDid(Context context, InstallOptions installOptions) {
        return LocalConstants.getCommonSp(context, installOptions).getString("old_did", null);
    }

    public static boolean isThisDeviceMigrate(Context context, InstallOptions installOptions) {
        return LocalConstants.getCommonSp(context, installOptions).getBoolean(Api.SP_KEY_IS_MIGRATE, false);
    }
}

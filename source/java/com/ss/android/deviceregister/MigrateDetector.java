package com.ss.android.deviceregister;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;

/* loaded from: classes7.dex */
final class MigrateDetector {
    private static final String KEY_COMPONENT_STATE = "component_state";
    private static final String SP_FILE = "device_register_migrate_detector";
    private static final int STATE_DEFAULT = 0;
    private static final int STATE_DISABLED = 2;
    private static final int STATE_ENABLED = 1;
    private static final int STATE_FLAG = 1;
    private final ComponentName component;
    private final boolean migrate;
    private final PackageManager pm;
    private final SharedPreferences sp;

    private static String getComponentState(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "STATE_DISABLED" : "STATE_ENABLED" : "STATE_DEFAULT";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MigrateDetector(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.sp = applicationContext.getSharedPreferences(SP_FILE, 0);
        this.pm = applicationContext.getPackageManager();
        this.component = new ComponentName(context, (Class<?>) AActivity.class);
        boolean isMigrateInternal = isMigrateInternal();
        this.migrate = isMigrateInternal;
        LogUtils.d(LogUtils.TAG, "MigrateDetector#constructor migrate=" + isMigrateInternal);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void disableComponent() {
        LogUtils.d(LogUtils.TAG, "MigrateDetector#disableComponent");
        this.pm.setComponentEnabledSetting(this.component, 2, 1);
        this.sp.edit().putInt("component_state", 2).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isMigrate() {
        return this.migrate;
    }

    private int getComponentEnabledSetting() {
        return this.pm.getComponentEnabledSetting(this.component);
    }

    private boolean isMigrateInternal() {
        int componentEnabledSetting = getComponentEnabledSetting();
        int i = this.sp.getInt("component_state", 0);
        LogUtils.d(LogUtils.TAG, "MigrateDetector#isMigrateInternal cs=" + getComponentState(componentEnabledSetting) + " ss=" + getComponentState(i));
        return componentEnabledSetting == 0 && i == 2;
    }
}

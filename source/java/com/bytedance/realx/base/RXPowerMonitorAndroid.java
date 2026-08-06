package com.bytedance.realx.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RXPowerMonitorAndroid {
    private static String TAG = "RXPowerMonitorAndroid";
    private static Intent batteryStatus;
    private static Context context = ContextUtils.getApplicationContext();
    private static float batteryVolt = -1.0f;
    private static BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: com.bytedance.realx.base.RXPowerMonitorAndroid.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context2, Intent intent) {
            int unused = RXPowerMonitorAndroid.mChargeStatus = intent.getIntExtra("status", -1);
            int unused2 = RXPowerMonitorAndroid.mBatteryTemperature = intent.getIntExtra("temperature", -1);
            int unused3 = RXPowerMonitorAndroid.mBatteryLevel = intent.getIntExtra("level", -1);
        }
    };
    private static BroadcastReceiver batterySaverReceiver = new BroadcastReceiver() { // from class: com.bytedance.realx.base.RXPowerMonitorAndroid.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context2, Intent intent) {
            if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
                try {
                    int unused = RXPowerMonitorAndroid.mBatterySaveMode = Settings.System.getInt(context2.getContentResolver(), "POWER_SAVE_MODE_OPEN");
                } catch (Exception unused2) {
                }
            } else if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(intent.getAction())) {
                int unused3 = RXPowerMonitorAndroid.mBatterySaveMode = RXPowerMonitorAndroid.powerManager.isPowerSaveMode() ? 1 : 0;
            }
        }
    };
    private static int mCpuCoreCount = -1;
    private static int mChargeStatus = -1;
    private static int mBatteryLevel = -1;
    private static int mBatteryTemperature = -1;
    private static int mBatterySaveMode = -1;
    private static BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
    private static IntentFilter ifilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static PowerManager powerManager = (PowerManager) context.getSystemService("power");

    public static int getBatteryMaxCapacity() {
        return 0;
    }

    public static int getVoltage() {
        return -1;
    }

    static {
        try {
            batteryStatus = m289xc0f76997(context, mBroadcastReceiver, ifilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getBatteryDesignCapacity() {
        try {
            return (int) Math.round(((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", new Class[0]).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), new Object[0])).doubleValue());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getBatteryCurrentCapacity() {
        int i;
        BatteryManager batteryManager2;
        try {
            batteryManager2 = batteryManager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (batteryManager2 != null) {
            i = ((int) batteryManager2.getLongProperty(1)) / BytePatchException.ErrorCode.paramsError;
            if (i >= 0) {
                return -1;
            }
            return i;
        }
        i = -1;
        if (i >= 0) {
        }
    }

    public static int getChargeStatus() {
        BatteryManager batteryManager2;
        try {
            if (Build.VERSION.SDK_INT >= 26 && (batteryManager2 = batteryManager) != null && mChargeStatus == -1) {
                mChargeStatus = batteryManager2.getIntProperty(6);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = mChargeStatus;
        return (i == 5 || i == 2) ? 1 : 0;
    }

    public static int getBatteryLevel() {
        try {
            BatteryManager batteryManager2 = batteryManager;
            if (batteryManager2 != null && mBatteryLevel == -1) {
                mBatteryLevel = batteryManager2.getIntProperty(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mBatteryLevel;
    }

    public static int getBatterySaveStatus() {
        try {
        } catch (Exception e) {
            mBatterySaveMode = -1;
            e.printStackTrace();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && powerManager != null && mBatterySaveMode == -1) {
            mBatterySaveMode = Settings.System.getInt(context.getContentResolver(), "POWER_SAVE_MODE_OPEN");
            try {
                m289xc0f76997(context, batterySaverReceiver, new IntentFilter("miui.intent.action.POWER_SAVE_MODE_CHANGED"));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return mBatterySaveMode;
        }
        int i = 1;
        if (Build.MANUFACTURER.equalsIgnoreCase("Huawei")) {
            if (Settings.System.getInt(context.getContentResolver(), "SmartModeStatus") == 4) {
                mBatterySaveMode = 1;
            } else {
                mBatterySaveMode = 0;
            }
        } else if (powerManager != null && mBatterySaveMode == -1) {
            try {
                m289xc0f76997(context, batterySaverReceiver, new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED"));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            if (!powerManager.isPowerSaveMode()) {
                i = 0;
            }
            mBatterySaveMode = i;
        }
        return mBatterySaveMode;
        mBatterySaveMode = -1;
        e.printStackTrace();
        return mBatterySaveMode;
    }

    public static int getBatteryTemperature() {
        return mBatteryTemperature / 10;
    }

    public static int getScreenBrightness() {
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            return -1;
        }
        return (int) ((Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1) / 255.0d) * 100.0d);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_realx_base_RXPowerMonitorAndroid_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m289xc0f76997(Context context2, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context3 = context2;
                return context2.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context4 = context2;
                return ContextCompat.registerReceiver(context2, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context2.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}

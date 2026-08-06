package com.ss.mediakit.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.HashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AVMDLDeviceUtil {
    public static String sBoard;
    public static String sHardware;

    public static String getDeviceBoard() {
        try {
            if (sBoard == null) {
                sBoard = Build.BOARD;
            }
        } catch (Throwable unused) {
            sBoard = null;
        }
        return sBoard;
    }

    public static String getDeviceHardware() {
        try {
            if (sHardware == null) {
                sHardware = Build.HARDWARE;
            }
        } catch (Throwable unused) {
            sHardware = null;
        }
        return sHardware;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static long getTotalStorageSpaceKB() {
        StatFs sdcardState = getSdcardState();
        if (sdcardState != null) {
            return (sdcardState.getBlockSizeLong() * sdcardState.getBlockCountLong()) / 1024;
        }
        return 0L;
    }

    private static StatFs getSdcardState() {
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return new StatFs(Environment.getExternalStorageDirectory().getPath());
        }
        return null;
    }

    public static long getTotalFreeStorageKB() {
        if (getSdcardState() != null) {
            return (r0.getAvailableBlocks() * r0.getBlockSize()) / 1024;
        }
        return 0L;
    }

    public static int getBatteryPercentage(Context context) {
        return ((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4);
    }

    public static boolean isPowerSaveMode(Context context) {
        if (context == null) {
            return false;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                return powerManager.isPowerSaveMode();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static HashMap<String, Object> getChargingState(Context context) {
        Intent m234x4e01d0ae;
        if (context == null || (m234x4e01d0ae = m234x4e01d0ae(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return null;
        }
        int intExtra = m234x4e01d0ae.getIntExtra("status", -1);
        int i = (intExtra == 2 || intExtra == 5) ? 1 : 0;
        int intExtra2 = m234x4e01d0ae.getIntExtra("plugged", -1);
        int intExtra3 = (m234x4e01d0ae.getIntExtra("level", -1) * 100) / m234x4e01d0ae.getIntExtra("scale", -1);
        HashMap<String, Object> hashMap = new HashMap<>(3);
        hashMap.put("isCharging", Integer.valueOf(i));
        hashMap.put("chargePlug", Integer.valueOf(intExtra2));
        hashMap.put("power", Integer.valueOf(intExtra3));
        return hashMap;
    }

    public static boolean isOverHeat(Context context) {
        if (context != null && Build.VERSION.SDK_INT >= 29) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    return powerManager.getCurrentThermalStatus() >= 3;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_mediakit_utils_AVMDLDeviceUtil_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m234x4e01d0ae(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}

package com.ss.thor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes7.dex */
public class ThorUtils {
    private static IntentFilter ifilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static BatteryManager mBatteryManager;

    private static BatteryManager getBatteryManager(Context context) {
        if (mBatteryManager == null) {
            synchronized (ThorUtils.class) {
                if (mBatteryManager == null) {
                    mBatteryManager = (BatteryManager) context.getSystemService("batterymanager");
                }
            }
        }
        return mBatteryManager;
    }

    public static double getUseBattery(Context context) {
        return (getGalvanicNow(context) * 0.5d) / 3600.0d;
    }

    public static float getVoltage(Context context) {
        Intent INVOKEVIRTUAL_com_ss_thor_ThorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver;
        if (context == null || (INVOKEVIRTUAL_com_ss_thor_ThorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver = INVOKEVIRTUAL_com_ss_thor_ThorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        return INVOKEVIRTUAL_com_ss_thor_ThorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver.getIntExtra("voltage", -1) / 1000.0f;
    }

    public static float getGalvanicNow(Context context) {
        BatteryManager batteryManager;
        if (context == null || (batteryManager = getBatteryManager(context)) == null) {
            return -1.0f;
        }
        float longProperty = (float) batteryManager.getLongProperty(2);
        if (longProperty < -1.0E7f || longProperty > 1.0E7f) {
            return -1.0f;
        }
        if (!Utils.isSihi() && !Utils.isSamsung()) {
            return (!Utils.isOppo() || longProperty > 10000.0f) ? longProperty / 1000.0f : longProperty;
        }
        if (longProperty < -10000.0f) {
            longProperty /= 1000.0f;
        }
        return -longProperty;
    }

    public static float getGalvanicAvg(Context context) {
        BatteryManager batteryManager;
        if (context == null || (batteryManager = getBatteryManager(context)) == null) {
            return -1.0f;
        }
        float longProperty = (float) batteryManager.getLongProperty(3);
        if (!Utils.isSihi() && !Utils.isSamsung()) {
            return (!Utils.isOppo() || longProperty > 10000.0f) ? longProperty / 1000.0f : longProperty;
        }
        if (longProperty < -1.0E7f || longProperty > 1.0E7f) {
            return -1.0f;
        }
        if (longProperty < -10000.0f) {
            longProperty /= 1000.0f;
        }
        return -longProperty;
    }

    public static long getCapacity(Context context) {
        BatteryManager batteryManager;
        if (context == null || (batteryManager = getBatteryManager(context)) == null) {
            return -1L;
        }
        return batteryManager.getLongProperty(4);
    }

    public static double getEnergy(Context context) {
        BatteryManager batteryManager;
        if (context == null || (batteryManager = getBatteryManager(context)) == null) {
            return -1.0d;
        }
        return (batteryManager.getLongProperty(5) / 1.0E9d) / 1000.0d;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_ss_thor_ThorUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sProxyHandler, 2);
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

package com.bytedance.apm.battery.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryUtils {
    private static List<ChargeListener> chargeListeners = new ArrayList();
    private static boolean hasRegisterReceiver = false;
    private static boolean isCharging;
    private static PowerConnectionReceiver powerConnectionReceiver;
    static BatteryManager sBatteryManager;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface ChargeListener {
        void onChange(boolean z);
    }

    private static void ensureManager(Context context) {
        sBatteryManager = (BatteryManager) context.getSystemService("batterymanager");
    }

    public static long getCurrentNow(Context context) {
        ensureManager(context);
        return sBatteryManager.getLongProperty(2);
    }

    public static boolean isCharging(Context context) {
        int intExtra;
        if (hasRegisterReceiver) {
            return isCharging;
        }
        Intent m69x1146e9b0 = m69x1146e9b0(context, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return m69x1146e9b0 == null || (intExtra = m69x1146e9b0.getIntExtra("status", -1)) == 2 || intExtra == 5;
    }

    public static boolean addChargeListener(Context context, ChargeListener chargeListener) {
        if (chargeListener == null) {
            throw new IllegalArgumentException("chargeListener can't be null");
        }
        chargeListeners.add(chargeListener);
        if (!hasRegisterReceiver) {
            registerBatteryReceiver(context);
            hasRegisterReceiver = true;
        }
        return isCharging;
    }

    public static void removeListener(Context context, ChargeListener chargeListener) {
        if (chargeListener == null) {
            return;
        }
        chargeListeners.remove(chargeListener);
        if (chargeListeners.isEmpty()) {
            try {
                m70xc0009ec9(context, powerConnectionReceiver);
            } catch (Throwable unused) {
            }
            hasRegisterReceiver = false;
        }
    }

    private static void registerBatteryReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            PowerConnectionReceiver powerConnectionReceiver2 = new PowerConnectionReceiver();
            powerConnectionReceiver = powerConnectionReceiver2;
            m69x1146e9b0(context, powerConnectionReceiver2, intentFilter);
            isCharging = isCharging(context);
        } catch (Throwable unused) {
            isCharging = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class PowerConnectionReceiver extends BroadcastReceiver {
        private PowerConnectionReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(action)) {
                boolean unused = BatteryUtils.isCharging = true;
                Iterator it = BatteryUtils.chargeListeners.iterator();
                while (it.hasNext()) {
                    ((ChargeListener) it.next()).onChange(BatteryUtils.isCharging);
                }
                return;
            }
            if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                boolean unused2 = BatteryUtils.isCharging = false;
                Iterator it2 = BatteryUtils.chargeListeners.iterator();
                while (it2.hasNext()) {
                    ((ChargeListener) it2.next()).onChange(BatteryUtils.isCharging);
                }
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_apm_battery_util_BatteryUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m69x1146e9b0(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_bytedance_apm_battery_util_BatteryUtils_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m70xc0009ec9(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

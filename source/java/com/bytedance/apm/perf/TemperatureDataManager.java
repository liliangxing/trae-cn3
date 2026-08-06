package com.bytedance.apm.perf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TemperatureDataManager {
    private BroadcastReceiver batteryReceiver;
    private IntentFilter intentFilter;
    private boolean isRegistered;
    private int mPlugged;
    private int mStatus;
    private float mTemperature;

    private TemperatureDataManager() {
        onInit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Holder {
        private static final TemperatureDataManager INSTANCE = new TemperatureDataManager();

        private Holder() {
        }
    }

    public static TemperatureDataManager getInstance() {
        return Holder.INSTANCE;
    }

    private void onInit() {
        this.batteryReceiver = new BroadcastReceiver() { // from class: com.bytedance.apm.perf.TemperatureDataManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent == null) {
                    return;
                }
                TemperatureDataManager.this.mTemperature = intent.getIntExtra(CommonServiceName.MONITOR_TYPE_TEMPERATURE, 0) / 10.0f;
                TemperatureDataManager.this.mStatus = intent.getIntExtra("status", 1);
                TemperatureDataManager.this.mPlugged = intent.getIntExtra("plugged", -1);
            }
        };
        this.intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public synchronized void registerTemperatureReceiver() {
        if (this.isRegistered) {
            return;
        }
        try {
            this.isRegistered = true;
            m101x7392d79a(ApmContext.getContext(), this.batteryReceiver, this.intentFilter);
        } catch (Exception unused) {
        }
    }

    public synchronized void unRegisterTemperatureReceiver() {
        if (this.isRegistered) {
            try {
                m102xbf08ba33(ApmContext.getContext(), this.batteryReceiver);
                this.isRegistered = false;
            } catch (Exception unused) {
            }
        }
    }

    public float getTemperature() {
        return this.mTemperature;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int getPlugged() {
        return this.mPlugged;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_apm_perf_TemperatureDataManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m101x7392d79a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_bytedance_apm_perf_TemperatureDataManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m102xbf08ba33(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

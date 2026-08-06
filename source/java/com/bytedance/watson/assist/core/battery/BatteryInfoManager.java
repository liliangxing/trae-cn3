package com.bytedance.watson.assist.core.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.core.BaseInfoManager;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BatteryInfoManager extends BaseInfoManager {
    private static final long UPDATE_TIME = 5000;
    private int mBatteryLevel;
    private BatteryManager mBatteryManager;
    private int mBatteryStatus;
    private float mBatteryTemperature;
    private boolean mIsCharging;
    private long mLastUpdate;
    private PowerManager mPowerManager;

    public BatteryInfoManager(Context context, IAssistStat iAssistStat) {
        super(context, iAssistStat);
        this.mIsCharging = false;
        this.mBatteryStatus = -1;
        this.mBatteryLevel = 0;
        this.mBatteryTemperature = 0.0f;
        this.mLastUpdate = 0L;
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mBatteryManager = (BatteryManager) this.mContext.getSystemService("batterymanager");
    }

    public boolean isCharging() {
        updateBatteryIntent();
        return this.mIsCharging;
    }

    public int isPowerSaveMode() {
        return getPowerSaveModeState();
    }

    private int getPowerSaveModeState() {
        PowerManager powerManager = this.mPowerManager;
        if (powerManager != null) {
            return powerManager.isPowerSaveMode() ? 1 : 0;
        }
        return -1;
    }

    public int getBatteryLevel() {
        updateBatteryIntent();
        return this.mBatteryLevel;
    }

    public float getBatteryTemperature() {
        updateBatteryIntent();
        return this.mBatteryTemperature;
    }

    private synchronized void updateBatteryIntent() {
        boolean z;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.mLastUpdate;
        if (j == 0 || elapsedRealtime - j >= 5000) {
            this.mLastUpdate = elapsedRealtime;
            Intent m25xccc9a2b9 = m25xccc9a2b9(this.mContext, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (m25xccc9a2b9 == null) {
                return;
            }
            int intExtra = m25xccc9a2b9.getIntExtra("status", -1);
            this.mBatteryStatus = intExtra;
            if (intExtra != 2 && (intExtra != 5 || !isPowerPlugIn())) {
                z = false;
                this.mIsCharging = z;
                this.mBatteryLevel = m25xccc9a2b9.getIntExtra("level", 0);
                this.mBatteryTemperature = m25xccc9a2b9.getIntExtra("temperature", 0) / 10.0f;
            }
            z = true;
            this.mIsCharging = z;
            this.mBatteryLevel = m25xccc9a2b9.getIntExtra("level", 0);
            this.mBatteryTemperature = m25xccc9a2b9.getIntExtra("temperature", 0) / 10.0f;
        }
    }

    private boolean isPowerPlugIn() {
        BatteryManager batteryManager = this.mBatteryManager;
        if (batteryManager != null) {
            return batteryManager.isCharging();
        }
        return false;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_watson_assist_core_battery_BatteryInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m25xccc9a2b9(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

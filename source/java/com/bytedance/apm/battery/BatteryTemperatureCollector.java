package com.bytedance.apm.battery;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.type.PerfData;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.perf.AbstractPerfCollector;
import com.bytedance.apm.perf.CommonDataAssembly;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.bdturing.EventReport;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BatteryTemperatureCollector extends AbstractPerfCollector {
    private static final String TAG = "TemperatureCollector";
    private BroadcastReceiver batteryReceiver;
    private IntentFilter intentFilter;
    private boolean isRegistered;
    private List<ApmAgent.IBatteryDataListener> mBatteryDataListeners;
    private boolean mEnableLocalRecord;
    private long mLastReportTime;
    private boolean mIsSampled = false;
    private int mReportInterval = 60;

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected boolean isTimerMonitor() {
        return false;
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected long workInternalMs() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Holder {
        private static final BatteryTemperatureCollector INSTANCE = new BatteryTemperatureCollector();

        private Holder() {
        }
    }

    public static BatteryTemperatureCollector getInstance() {
        return Holder.INSTANCE;
    }

    public BatteryTemperatureCollector() {
        this.mCollectorSettingKey = "battery";
    }

    public void addBatteryDataListener(ApmAgent.IBatteryDataListener iBatteryDataListener) {
        if (iBatteryDataListener == null) {
            return;
        }
        if (this.mBatteryDataListeners == null) {
            this.mBatteryDataListeners = new ArrayList();
        }
        this.mBatteryDataListeners.add(iBatteryDataListener);
    }

    public void init(boolean z) {
        this.mEnableLocalRecord = z;
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void doConfig(JSONObject jSONObject) {
        super.doConfig(jSONObject);
        this.mIsSampled = jSONObject.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD, 0) == 1;
        this.mReportInterval = jSONObject.optInt(SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_UPLOAD_INTERVAL, 60);
        if (this.mIsSampled || this.mEnableLocalRecord) {
            return;
        }
        ActivityLifeObserver.getInstance().unregister(this);
        unRegisterBatteryReceiver();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    protected void onInit() {
        this.batteryReceiver = new BroadcastReceiver() { // from class: com.bytedance.apm.battery.BatteryTemperatureCollector.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - BatteryTemperatureCollector.this.mLastReportTime > ((long) (BatteryTemperatureCollector.this.mReportInterval * 1000))) {
                    if (BatteryTemperatureCollector.this.mIsSampled || BatteryTemperatureCollector.this.mEnableLocalRecord) {
                        BatteryTemperatureCollector.this.mLastReportTime = elapsedRealtime;
                        final float intExtra = intent.getIntExtra(CommonServiceName.MONITOR_TYPE_TEMPERATURE, 0) / 10.0f;
                        final float intExtra2 = (intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100);
                        final String topActivityClassName = ActivityLifeObserver.getInstance().getTopActivityClassName();
                        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.battery.BatteryTemperatureCollector.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put(Constants.KEY_BATTERY_TEMPERATURE, intExtra);
                                    jSONObject.put(Constants.KEY_BATTERY_REMAINING_ENERGY, intExtra2);
                                    if (BatteryTemperatureCollector.this.mIsSampled) {
                                        if (BatteryTemperatureCollector.this.mBatteryDataListeners != null && !BatteryTemperatureCollector.this.mBatteryDataListeners.isEmpty()) {
                                            Iterator it = BatteryTemperatureCollector.this.mBatteryDataListeners.iterator();
                                            while (it.hasNext()) {
                                                ((ApmAgent.IBatteryDataListener) it.next()).onData(intExtra2, intExtra, topActivityClassName);
                                            }
                                        }
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("scene", TextUtils.isEmpty(topActivityClassName) ? EventReport.DIALOG_BACKGROUND : topActivityClassName);
                                        PerfData perfData = new PerfData(CommonServiceName.MONITOR_TYPE_TEMPERATURE, "", jSONObject, jSONObject2, null);
                                        CommonDataAssembly.wrapFilters(perfData, false);
                                        CommonDataPipeline.getInstance().handle(perfData);
                                    }
                                    if (BatteryTemperatureCollector.this.mEnableLocalRecord) {
                                        ApmAlogHelper.m77i(Constants.TAG_BATTERY_LOCAL, jSONObject.toString());
                                    }
                                } catch (Exception unused) {
                                }
                            }
                        });
                    }
                }
            }
        };
        this.intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        registerBatteryReceiver();
    }

    private void registerBatteryReceiver() {
        if (this.isRegistered) {
            return;
        }
        try {
            m67xa6761b2b(ApmContext.getContext(), this.batteryReceiver, this.intentFilter);
            this.isRegistered = true;
        } catch (Exception unused) {
        }
    }

    private void unRegisterBatteryReceiver() {
        if (this.isRegistered) {
            try {
                m68xc6295d84(ApmContext.getContext(), this.batteryReceiver);
                this.isRegistered = false;
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onBackground(Activity activity) {
        super.onBackground(activity);
        unRegisterBatteryReceiver();
    }

    @Override // com.bytedance.apm.perf.AbstractPerfCollector
    public void onFront(Activity activity) {
        super.onFront(activity);
        registerBatteryReceiver();
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_apm_battery_BatteryTemperatureCollector_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m67xa6761b2b(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_bytedance_apm_battery_BatteryTemperatureCollector_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m68xc6295d84(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

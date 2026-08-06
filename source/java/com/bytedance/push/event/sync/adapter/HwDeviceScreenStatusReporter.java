package com.bytedance.push.event.sync.adapter;

import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.platform.thread.Constants;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.event.sync.ISignalReporter;
import com.bytedance.push.event.sync.SmpSignalReceiver;
import com.bytedance.push.model.HwScreenStatusSignalExtraConfig;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.helper.SettingsFileLockHelper;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.settings.signal.sync.SignalReportSettingsModel;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.kit.awareness.Awareness;
import com.huawei.hms.kit.awareness.barrier.AwarenessBarrier;
import com.huawei.hms.kit.awareness.barrier.BarrierQueryRequest;
import com.huawei.hms.kit.awareness.barrier.BarrierQueryResponse;
import com.huawei.hms.kit.awareness.barrier.BarrierStatus;
import com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest;
import com.huawei.hms.kit.awareness.barrier.ScreenBarrier;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HwDeviceScreenStatusReporter extends AbsSignalReporterAdapter {
    private final String TAG = "HwDeviceScreenStatusReporter";
    private final long API_INVOKE_TIMEOUT_IN_MILL = Constants.TASK_RUN_THRESHOLD;
    private String UNLOCK_BARRIER_KEY = "screen.status.signal.screen_unlock";
    private String SCREEN_ON_BARRIER_KEY = "screen.status.signal.screen_on";
    private String SCREEN_OFF_BARRIER_KEY = "screen.status.signal.screen_off";
    private long TIME_BARRIER_DURATION = Constants.TASK_RUN_THRESHOLD;

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    String getSignalName() {
        return ISignalReportConstants.SIGNAL_NAME_HW_SCREEN_STATUS;
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void unregister() {
        super.unregister();
        if (RomVersionParamHelper.isHarmonyOs()) {
            LocalSettings localSettings = PushSetting.getInstance().getLocalSettings();
            boolean hasBarrierHwAwarenessSignal = localSettings.hasBarrierHwAwarenessSignal();
            Logger.m268d("HwDeviceScreenStatusReporter", "[unregisterBarrier]hasBarrierHwAwarenessSignal:" + hasBarrierHwAwarenessSignal);
            if (hasBarrierHwAwarenessSignal) {
                deleteBarrier(AppProvider.getApp(), this.SCREEN_ON_BARRIER_KEY);
                deleteBarrier(AppProvider.getApp(), this.SCREEN_OFF_BARRIER_KEY);
                deleteBarrier(AppProvider.getApp(), this.UNLOCK_BARRIER_KEY);
                localSettings.setHasBarrierHwAwarenessSignal(false);
            }
        }
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        super.startSignalReport(str, signalReportConfig);
        try {
            if (RomVersionParamHelper.isHarmonyOs()) {
                HwScreenStatusSignalExtraConfig hwScreenStatusSignalExtraConfig = new HwScreenStatusSignalExtraConfig(signalReportConfig.extraConfig);
                if (!hwScreenStatusSignalExtraConfig.isValidConfig()) {
                    Logger.m268d("HwDeviceScreenStatusReporter", "[startSignalReport]hwScreenStatusSignalExtraConfig is invalid,unregister all");
                    unregister();
                    return;
                }
                String str2 = hwScreenStatusSignalExtraConfig.callbackIntent;
                Logger.m268d("HwDeviceScreenStatusReporter", "[startSignalReport]callbackIntent:" + str2);
                if (!allowAddAwarenessBarrier(hwScreenStatusSignalExtraConfig)) {
                    Logger.m278w("HwDeviceScreenStatusReporter", "[startSignalReport]do nothing because allowAddAwarenessBarrier is false");
                    unregister();
                    return;
                }
                long nextRegisterInterval = getNextRegisterInterval(hwScreenStatusSignalExtraConfig);
                if (nextRegisterInterval > 0) {
                    unregister();
                    Logger.m268d("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]startSignalReportFromSignalCallback because cur hasBeenFrequencyControl,nextRegisterInterval:" + nextRegisterInterval);
                    startSignalReportFromSignalCallback(this.mTriggerScene, signalReportConfig, nextRegisterInterval);
                    return;
                }
                Application app = AppProvider.getApp();
                Intent parseUri = Intent.parseUri(str2, 0);
                parseUri.setPackage(app.getPackageName());
                parseUri.setComponent(new ComponentName(app, (Class<?>) SmpSignalReceiver.class));
                parseUri.putExtra(ISignalReportConstants.KEY_SIGNAL_NAME, getSignalName());
                parseUri.putExtra(ISignalReportConstants.KEY_TRIGGER_SCENE, this.mTriggerScene);
                for (String str3 : hwScreenStatusSignalExtraConfig.screenAction) {
                    if (TextUtils.equals(str3, ISignalReportConstants.KEY_SCREEN_STATUS_SCREEN_ON)) {
                        addAwarenessBarrier(app, this.SCREEN_ON_BARRIER_KEY, ScreenBarrier.screenOn(), parseUri);
                    }
                    if (TextUtils.equals(str3, ISignalReportConstants.KEY_SCREEN_STATUS_SCREEN_OFF)) {
                        addAwarenessBarrier(app, this.SCREEN_OFF_BARRIER_KEY, ScreenBarrier.screenOff(), parseUri);
                    }
                    if (TextUtils.equals(str3, ISignalReportConstants.KEY_SCREEN_STATUS_UNLOCK)) {
                        addAwarenessBarrier(app, this.UNLOCK_BARRIER_KEY, ScreenBarrier.screenUnlock(), parseUri);
                    }
                }
            }
        } catch (Throwable th) {
            Logger.m271e("HwDeviceScreenStatusReporter", "[startSignalReport]error:" + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    private boolean enableAwarenessBarrier() {
        return !PushSetting.getInstance().getLocalSettings().serverDisableAwBarrier();
    }

    private boolean allowAddAwarenessBarrier(HwScreenStatusSignalExtraConfig hwScreenStatusSignalExtraConfig) {
        Logger.m268d("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]");
        Application app = AppProvider.getApp();
        try {
            if (!enableAwarenessBarrier()) {
                Logger.m278w("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]return false because enableAwarenessBarrier is false");
                return false;
            }
            long j = app.getApplicationContext().getPackageManager().getPackageInfo(app.getPackageName(), 0).firstInstallTime;
            long currentTimeMillis = System.currentTimeMillis() - j;
            Logger.m268d("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]app install time:" + j + " appInstallDuration:" + currentTimeMillis + " minInstallTimeInMill:" + hwScreenStatusSignalExtraConfig.minInstallTimeInMill);
            if (currentTimeMillis < hwScreenStatusSignalExtraConfig.minInstallTimeInMill) {
                Logger.m278w("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]return false because appInstallTime<minInstallTimeInMill");
                return false;
            }
            if (hwScreenStatusSignalExtraConfig.filterDebugDevice && PushServiceManager.get().getIAllianceService().isRiskDevice(app, hwScreenStatusSignalExtraConfig.filterSimCard)) {
                Logger.m278w("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]return false because cur is risk Device");
                return false;
            }
            Logger.m268d("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]return true");
            return true;
        } catch (Throwable th) {
            Logger.m272e("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]exception ", th);
            Logger.m278w("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]backup return false");
            return false;
        }
    }

    private long getNextRegisterInterval(HwScreenStatusSignalExtraConfig hwScreenStatusSignalExtraConfig) {
        long currentTimeMillis = System.currentTimeMillis();
        long lastUnlockAwarenessTime = PushSetting.getInstance().getLocalSettings().getLastUnlockAwarenessTime();
        long j = currentTimeMillis - lastUnlockAwarenessTime;
        Logger.m268d("HwDeviceScreenStatusReporter", "[allowAddAwarenessBarrier]lastUnlockAwarenessTime:" + lastUnlockAwarenessTime + " actualInterval:" + j + " minSignalIntervalInMill:" + hwScreenStatusSignalExtraConfig.minSignalIntervalInMill);
        return hwScreenStatusSignalExtraConfig.minSignalIntervalInMill - j;
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void onReceiveSignal(final Intent intent) {
        super.onReceiveSignal(intent);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.1
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0073, code lost:
            
                if (r4 == 0) goto L13;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                BarrierStatus extract = BarrierStatus.extract(intent);
                String barrierLabel = extract.getBarrierLabel();
                String stringExtra = intent.getStringExtra(ISignalReportConstants.KEY_TRIGGER_SCENE);
                SignalReportConfig screenStatusReportConfig = HwDeviceScreenStatusReporter.this.getScreenStatusReportConfig();
                if (screenStatusReportConfig == null) {
                    Logger.m278w("HwDeviceScreenStatusReporter", "[onReceiveSignal]do nothing because signalReportConfig is null");
                    HwDeviceScreenStatusReporter.this.unregister();
                    return;
                }
                HwScreenStatusSignalExtraConfig hwScreenStatusSignalExtraConfig = new HwScreenStatusSignalExtraConfig(screenStatusReportConfig.extraConfig);
                Logger.m268d("HwDeviceScreenStatusReporter", "[onReceiveSignal]killProcessMode:" + hwScreenStatusSignalExtraConfig.killProcessMode);
                boolean z = false;
                if (hwScreenStatusSignalExtraConfig.killProcessMode != 0) {
                    if (hwScreenStatusSignalExtraConfig.killProcessMode == 2) {
                        int notificationNum = PushServiceManager.get().getIPushNotificationService().getNotificationNum(AppProvider.getApp());
                        Logger.m268d("HwDeviceScreenStatusReporter", "[onReceiveSignal]curNotificationNum:" + notificationNum);
                    }
                    z = true;
                }
                Logger.m268d("HwDeviceScreenStatusReporter", "[onReceiveSignal]allowKillSmp:" + z);
                try {
                    Logger.m268d("HwDeviceScreenStatusReporter", "[onReceiveSignal]startProcessComponent:" + PushServiceManager.get().getAliveMonitorService().getProcessStartInfoObject(AppProvider.getApp()).optString("start_component") + " signalReceiverName:" + SmpSignalReceiver.class.getCanonicalName());
                } catch (Throwable th) {
                    Logger.m271e("HwDeviceScreenStatusReporter", "[onReceiveSignal]allowKillSmp exception:" + th.getLocalizedMessage());
                }
                Logger.m268d("HwDeviceScreenStatusReporter", "[onReceiveSignal]triggerScene:" + stringExtra + " barrierLabel:" + barrierLabel + " presentStatus:" + extract.getPresentStatus() + " allowKillSmp:" + z);
                if (!TextUtils.equals(barrierLabel, HwDeviceScreenStatusReporter.this.UNLOCK_BARRIER_KEY)) {
                    if (!TextUtils.equals(barrierLabel, HwDeviceScreenStatusReporter.this.SCREEN_ON_BARRIER_KEY)) {
                        if (TextUtils.equals(barrierLabel, HwDeviceScreenStatusReporter.this.SCREEN_OFF_BARRIER_KEY)) {
                            if (extract.getPresentStatus() == 1) {
                                Logger.m268d("HwDeviceScreenStatusReporter", "[onReceiveSignal]find screen off signal");
                                HwDeviceScreenStatusReporter.this.reportScreenStatusSignal(ISignalReportConstants.KEY_SCREEN_STATUS_SCREEN_OFF, stringExtra, z);
                                return;
                            } else {
                                if (z) {
                                    ToolUtils.killSelf();
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    }
                    if (extract.getPresentStatus() == 1) {
                        Logger.m268d("HwDeviceScreenStatusReporter", "[onReceiveSignal]find screen on signal");
                        HwDeviceScreenStatusReporter.this.reportScreenStatusSignal(ISignalReportConstants.KEY_SCREEN_STATUS_SCREEN_ON, stringExtra, z);
                        return;
                    } else {
                        if (z) {
                            ToolUtils.killSelf();
                            return;
                        }
                        return;
                    }
                }
                if (extract.getPresentStatus() == 1) {
                    Logger.m268d("HwDeviceScreenStatusReporter", "[onReceiveSignal]find screen unlock signal");
                    PushSetting.getInstance().getLocalSettings().setLastUnlockAwarenessTime(System.currentTimeMillis());
                    HwDeviceScreenStatusReporter.this.reportScreenStatusSignal(ISignalReportConstants.KEY_SCREEN_STATUS_UNLOCK, stringExtra, z);
                } else if (z) {
                    ToolUtils.killSelf();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportScreenStatusSignal(String str, String str2, boolean z) {
        Logger.m268d("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]action:" + str + " triggerScene:" + str2);
        SignalReportConfig screenStatusReportConfig = getScreenStatusReportConfig();
        if (screenStatusReportConfig == null) {
            Logger.m278w("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]do nothing because signalReportConfig is null");
            unregister();
            return;
        }
        HwScreenStatusSignalExtraConfig hwScreenStatusSignalExtraConfig = new HwScreenStatusSignalExtraConfig(screenStatusReportConfig.extraConfig);
        Application app = AppProvider.getApp();
        boolean curIsFirstProcess = SettingsFileLockHelper.getInstance().curIsFirstProcess(app);
        Logger.m268d("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]unregisterForUnRiskSignal:" + hwScreenStatusSignalExtraConfig.unregisterForRiskSignal);
        boolean z2 = false;
        if (hwScreenStatusSignalExtraConfig.unregisterForRiskSignal) {
            Boolean isMainProcessStart = ToolUtils.isMainProcessStart(app);
            if (curIsFirstProcess && (isMainProcessStart == null || !isMainProcessStart.booleanValue())) {
                z2 = true;
            }
            Logger.m268d("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]curIsRiskSignal:" + z2 + " unregisterForUnRiskSignal:" + hwScreenStatusSignalExtraConfig.unregisterForUnRiskSignal);
        }
        if (!z2) {
            z2 = hwScreenStatusSignalExtraConfig.unregisterForUnRiskSignal;
        }
        if (z2) {
            unregister();
        }
        long j = curIsFirstProcess ? hwScreenStatusSignalExtraConfig.delayReportInMill : 0L;
        Logger.m268d("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]report signal after :" + j + " killSelfDelayInMill:" + hwScreenStatusSignalExtraConfig.killSelfDelayInMill);
        PushThreadHandlerManager.inst().postRunnable(new RunnableC05762(str, screenStatusReportConfig, str2, z, System.currentTimeMillis(), hwScreenStatusSignalExtraConfig), j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class RunnableC05762 implements Runnable {
        final /* synthetic */ String val$action;
        final /* synthetic */ boolean val$allowKillSmp;
        final /* synthetic */ HwScreenStatusSignalExtraConfig val$hwScreenStatusSignalExtraConfig;
        final /* synthetic */ long val$signalReceiveTimeMillis;
        final /* synthetic */ SignalReportConfig val$signalReportConfig;
        final /* synthetic */ String val$triggerScene;

        RunnableC05762(String str, SignalReportConfig signalReportConfig, String str2, boolean z, long j, HwScreenStatusSignalExtraConfig hwScreenStatusSignalExtraConfig) {
            this.val$action = str;
            this.val$signalReportConfig = signalReportConfig;
            this.val$triggerScene = str2;
            this.val$allowKillSmp = z;
            this.val$signalReceiveTimeMillis = j;
            this.val$hwScreenStatusSignalExtraConfig = hwScreenStatusSignalExtraConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            HwDeviceScreenStatusReporter.this.add(jSONObject, HwScreenStatusSignalExtraConfig.KEY_SCREEN_ACTION, this.val$action);
            PushSupporter.get().getSignalReportService().getISignalReporter().reportSignal(this.val$signalReportConfig, HwDeviceScreenStatusReporter.this.getSignalName(), this.val$triggerScene, jSONObject, new ISignalReporter.ISignalReporterListener() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.2.1
                @Override // com.bytedance.push.event.sync.ISignalReporter.ISignalReporterListener
                public void onFinished(boolean z, String str) {
                    Logger.m268d("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]finished report signal,result :" + z + " msg:" + str + " allowKillSmp:" + RunnableC05762.this.val$allowKillSmp);
                    if (RunnableC05762.this.val$allowKillSmp) {
                        long currentTimeMillis = System.currentTimeMillis() - RunnableC05762.this.val$signalReceiveTimeMillis;
                        long j = RunnableC05762.this.val$hwScreenStatusSignalExtraConfig.killSelfDelayInMill - currentTimeMillis;
                        Logger.m268d("HwDeviceScreenStatusReporter", "[reportScreenStatusSignal]signal report time cost:" + currentTimeMillis + " killNeedDelay:" + j);
                        if (j < 0) {
                            j = 0;
                        }
                        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                HwDeviceScreenStatusReporter.this.killSelfIfNeed(RunnableC05762.this.val$hwScreenStatusSignalExtraConfig);
                            }
                        }, j);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SignalReportConfig getScreenStatusReportConfig() {
        List<SignalReportConfig> signalReportSettings;
        SignalReportSettingsModel signalSyncSettingsModel = PushSetting.getInstance().getPushOnLineSettings().getSignalSyncSettingsModel();
        if (signalSyncSettingsModel == null || (signalReportSettings = signalSyncSettingsModel.getSignalReportSettings()) == null) {
            return null;
        }
        for (SignalReportConfig signalReportConfig : signalReportSettings) {
            if (TextUtils.equals(signalReportConfig.signalName, ISignalReportConstants.SIGNAL_NAME_HW_SCREEN_STATUS)) {
                return signalReportConfig;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void killSelfIfNeed(HwScreenStatusSignalExtraConfig hwScreenStatusSignalExtraConfig) {
        Logger.m268d("HwDeviceScreenStatusReporter", "[killSelfIfNeed]killSelfAfterSignalReport:" + hwScreenStatusSignalExtraConfig.killSelfAfterSignalReport);
        if (hwScreenStatusSignalExtraConfig.killSelfAfterSignalReport) {
            ToolUtils.killSelf();
        }
    }

    private void startSignalReportFromSignalCallback(final String str, final SignalReportConfig signalReportConfig, long j) {
        Logger.m268d("HwDeviceScreenStatusReporter", "[startSignalReportFromSignalCallback]triggerScene:" + str);
        try {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.3
                @Override // java.lang.Runnable
                public void run() {
                    HwDeviceScreenStatusReporter.this.startSignalReport(str, signalReportConfig);
                }
            }, j);
        } catch (Throwable th) {
            Logger.m272e("HwDeviceScreenStatusReporter", "[startSignalReportFromSignalCallback]exception ", th);
        }
    }

    private boolean curHasBarrier(Context context, String str) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            final boolean[] zArr = {false};
            Awareness.getBarrierClient(context).queryBarriers(BarrierQueryRequest.forBarriers(new String[]{str})).addOnSuccessListener(new OnSuccessListener<BarrierQueryResponse>() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.5
                public void onSuccess(BarrierQueryResponse barrierQueryResponse) {
                    Set barrierLabels = barrierQueryResponse.getBarrierStatusMap().getBarrierLabels();
                    zArr[0] = (barrierLabels == null || barrierLabels.isEmpty() || !barrierLabels.contains(HwDeviceScreenStatusReporter.this.UNLOCK_BARRIER_KEY)) ? false : true;
                    Logger.m268d("HwDeviceScreenStatusReporter", "query barrier success,curHasUnLockBarrier:" + zArr[0]);
                    countDownLatch.countDown();
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.4
                public void onFailure(Exception exc) {
                    Logger.m268d("HwDeviceScreenStatusReporter", "query barrier failed");
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(Constants.TASK_RUN_THRESHOLD, TimeUnit.MILLISECONDS);
            return zArr[0];
        } catch (Throwable th) {
            Logger.m272e("HwDeviceScreenStatusReporter", "[curHasBarrier]exception ", th);
            return false;
        }
    }

    private void addAwarenessBarrier(Context context, final String str, AwarenessBarrier awarenessBarrier, Intent intent) {
        if (curHasBarrier(context, str)) {
            Logger.m268d("HwDeviceScreenStatusReporter", "do nothing because cur has barrier:" + str);
            return;
        }
        Awareness.getBarrierClient(context).updateBarriers(new BarrierUpdateRequest.Builder().addBarrier(str, awarenessBarrier, PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() % 2147483647L), intent, 134217728)).build()).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.7
            public void onSuccess(Void r2) {
                Logger.m268d("HwDeviceScreenStatusReporter", "[addAwarenessBarrier]add barrier success for " + str);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.6
            public void onFailure(Exception exc) {
                Logger.m272e("HwDeviceScreenStatusReporter", "[addAwarenessBarrier]add barrier failed for " + str + " ", exc);
            }
        });
        PushSetting.getInstance().getLocalSettings().setHasBarrierHwAwarenessSignal(true);
    }

    private void deleteBarrier(Context context, final String str) {
        try {
            Logger.m268d("HwDeviceScreenStatusReporter", "[deleteBarrier]barrierLabel:" + str);
            BarrierUpdateRequest build = new BarrierUpdateRequest.Builder().deleteBarrier(str).build();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Awareness.getBarrierClient(context).updateBarriers(build).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.9
                public void onSuccess(Void r2) {
                    Logger.m268d("HwDeviceScreenStatusReporter", "[deleteBarrier]delete barrier success,barrierLabel:" + str);
                    countDownLatch.countDown();
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter.8
                public void onFailure(Exception exc) {
                    Logger.m272e("HwDeviceScreenStatusReporter", "[deleteBarrier]delete barrier failed for " + str + " ", exc);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(Constants.TASK_RUN_THRESHOLD, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            Logger.m272e("HwDeviceScreenStatusReporter", "error when deleteBarrier for " + str + " ,reason ", th);
        }
    }
}

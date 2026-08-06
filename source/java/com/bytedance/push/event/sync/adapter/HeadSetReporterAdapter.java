package com.bytedance.push.event.sync.adapter;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.platform.thread.Constants;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.DynamicSignalReceiver;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.event.sync.ISignalReporter;
import com.bytedance.push.event.sync.SmpSignalReceiver;
import com.bytedance.push.model.HeadSetStatusExtraConfig;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.settings.signal.sync.SignalReportSettingsModel;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.kit.awareness.Awareness;
import com.huawei.hms.kit.awareness.barrier.AwarenessBarrier;
import com.huawei.hms.kit.awareness.barrier.BarrierStatus;
import com.huawei.hms.kit.awareness.barrier.BarrierUpdateRequest;
import com.huawei.hms.kit.awareness.barrier.HeadsetBarrier;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.BundleUtils;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HeadSetReporterAdapter extends AbsSignalReporterAdapter {
    private Context mContext;
    private HeadSetStatusExtraConfig mHeadSetStatusExtraConfig;
    private long registerTimeStamp;
    private final String TAG = "HeadSetReporterAdapter";
    private final long API_INVOKE_TIMEOUT_IN_MILL = Constants.TASK_RUN_THRESHOLD;
    private final String KEY_PRE_STATE = "android.bluetooth.profile.extra.PREVIOUS_STATE";
    private final String KEY_CUR_STATE = "android.bluetooth.profile.extra.STATE";
    private final String BARRIER_RECEIVER_ACTION_SUFFIX = ".HEADSET_BARRIER_RECEIVER_ACTION";
    private final String HEADSET_CONNECTING_BARRIER_LABEL = "headset.connecting.barrier";
    private final String HEADSET_CONNECTED_BARRIER_LABEL = "headset.connected.barrier";
    private final String KEY_STATE = "state";
    private final String KEY_ACTION_TYPE = "action_type";
    private final String KEY_HEADSET_TYPE = "headset_type";
    private final int WIRELESS_STATE_NOT_CONNECT = 0;
    private final int WIRELESS_STATE_CONNECTING = 1;
    private final int WIRELESS_STATE_CONNECTED = 2;
    private final int WIRED_STATE_CONNECTED = 1;
    private final int WIRED_STATE_NOT_CONNECTED = 0;
    private final long RECEIVER_DEDUPLICATION_TIME_INTERVAL = Constants.TASK_RUN_THRESHOLD;
    private final Map<Integer, String> stateTag = new HashMap();
    private volatile int reportingSignalCnt = 0;
    private final String HEADSET_TYPE_WIRED = "wired";
    private final String HEADSET_TYPE_WIRELESS = "wireless";
    private final String HEADSET_TYPE_UNKNOWN = "unknown";

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    String getSignalName() {
        return ISignalReportConstants.SIGNAL_NAME_HEAD_SET_STATUS;
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        super.startSignalReport(str, signalReportConfig);
        this.mContext = AppProvider.getApp();
        this.stateTag.put(0, "not_connect");
        this.stateTag.put(1, "connecting");
        this.stateTag.put(2, "connected");
        this.mHeadSetStatusExtraConfig = new HeadSetStatusExtraConfig(signalReportConfig.extraConfig);
        DynamicSignalReceiver dynamicSignalReceiver = new DynamicSignalReceiver();
        IntentFilter intentFilter = new IntentFilter();
        if (RomVersionParamHelper.isHarmonyOs() && TextUtils.equals(this.mHeadSetStatusExtraConfig.harmonyListenMethod, HeadSetStatusExtraConfig.HARMONY_LISTEN_METHOD_AWARENESS)) {
            Logger.m268d("HeadSetReporterAdapter", "[startSignalReport]listenByAwareness");
            listenByAwareness();
        } else {
            Logger.m268d("HeadSetReporterAdapter", "[startSignalReport]listenByAndroidBroadcast");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            Logger.m268d("HeadSetReporterAdapter", "[startSignalReport]finished register receiver:" + m235x9b68806c(this.mContext, dynamicSignalReceiver, intentFilter));
        }
        this.registerTimeStamp = System.currentTimeMillis();
    }

    private void listenByAwareness() {
        Intent intent;
        try {
            if (this.mHeadSetStatusExtraConfig.listenTypeList.isEmpty()) {
                Logger.m268d("HeadSetReporterAdapter", "[listenByAwareness]do nothing because listenTypeList is empty");
                return;
            }
            String str = this.mContext.getPackageName() + ".HEADSET_BARRIER_RECEIVER_ACTION";
            if (!TextUtils.isEmpty(this.mHeadSetStatusExtraConfig.callbackIntent)) {
                Logger.m268d("HeadSetReporterAdapter", "[listenByAwareness]use settings intent:" + this.mHeadSetStatusExtraConfig.callbackIntent);
                intent = Intent.parseUri(this.mHeadSetStatusExtraConfig.callbackIntent, 0);
                intent.setPackage(this.mContext.getPackageName());
                intent.setComponent(new ComponentName(this.mContext, (Class<?>) SmpSignalReceiver.class));
            } else {
                Logger.m268d("HeadSetReporterAdapter", "[listenByAwareness]use local intent");
                intent = new Intent(str);
                m235x9b68806c(this.mContext, new DynamicSignalReceiver(), new IntentFilter(str));
            }
            intent.putExtra(ISignalReportConstants.KEY_SIGNAL_NAME, getSignalName());
            intent.putExtra(ISignalReportConstants.KEY_TRIGGER_SCENE, this.mTriggerScene);
            if (this.mHeadSetStatusExtraConfig.listenTypeList.contains("connecting")) {
                updateBarriers(HeadsetBarrier.connecting(), PendingIntent.getBroadcast(this.mContext, (int) (System.currentTimeMillis() % 2147483647L), intent, 134217728), "headset.connecting.barrier");
            }
            if (this.mHeadSetStatusExtraConfig.listenTypeList.contains("connected")) {
                updateBarriers(HeadsetBarrier.keeping(1), PendingIntent.getBroadcast(this.mContext, (int) (System.currentTimeMillis() % 2147483647L), intent, 134217728), "headset.connected.barrier");
            }
        } catch (Throwable th) {
            Logger.m271e("HeadSetReporterAdapter", "[listenByAwareness]add barrier exception:" + th.getLocalizedMessage());
        }
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void unregister() {
        super.unregister();
        if (RomVersionParamHelper.isHarmonyOs()) {
            deleteBarrier(AppProvider.getApp(), "headset.connecting.barrier");
            deleteBarrier(AppProvider.getApp(), "headset.connected.barrier");
        }
    }

    private void deleteBarrier(Context context, final String str) {
        try {
            Logger.m268d("HeadSetReporterAdapter", "[deleteBarrier]barrierLabel:" + str);
            BarrierUpdateRequest build = new BarrierUpdateRequest.Builder().deleteBarrier(str).build();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Awareness.getBarrierClient(context).updateBarriers(build).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.bytedance.push.event.sync.adapter.HeadSetReporterAdapter.2
                public void onSuccess(Void r2) {
                    Logger.m268d("HeadSetReporterAdapter", "[deleteBarrier]delete barrier success,barrierLabel:" + str);
                    countDownLatch.countDown();
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.bytedance.push.event.sync.adapter.HeadSetReporterAdapter.1
                public void onFailure(Exception exc) {
                    Logger.m272e("HeadSetReporterAdapter", "[deleteBarrier]delete barrier failed for " + str + " ", exc);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await(Constants.TASK_RUN_THRESHOLD, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            Logger.m272e("HeadSetReporterAdapter", "error when deleteBarrier for " + str + " ,reason ", th);
        }
    }

    private void updateBarriers(AwarenessBarrier awarenessBarrier, PendingIntent pendingIntent, final String str) {
        Logger.m268d("HeadSetReporterAdapter", "[updateBarriers]targetBarrier:" + awarenessBarrier + " barrierLabel:" + str);
        Awareness.getBarrierClient(this.mContext).updateBarriers(new BarrierUpdateRequest.Builder().addBarrier(str, awarenessBarrier, pendingIntent).build()).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.bytedance.push.event.sync.adapter.HeadSetReporterAdapter.4
            public void onSuccess(Void r2) {
                Logger.m268d("HeadSetReporterAdapter", "[updateBarriers]add barrier success，barrierLabel:" + str);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.bytedance.push.event.sync.adapter.HeadSetReporterAdapter.3
            public void onFailure(Exception exc) {
                Logger.m271e("HeadSetReporterAdapter", "[updateBarriers]add barrier failed，barrierLabel:" + str + " exception:" + exc.getLocalizedMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initHeadSetStatusExtraConfig() {
        List<SignalReportConfig> signalReportSettings;
        if (this.mSignalReportConfig != null && this.mHeadSetStatusExtraConfig != null) {
            return true;
        }
        SignalReportSettingsModel signalSyncSettingsModel = PushSetting.getInstance().getPushOnLineSettings().getSignalSyncSettingsModel();
        if (signalSyncSettingsModel == null || (signalReportSettings = signalSyncSettingsModel.getSignalReportSettings()) == null) {
            return false;
        }
        for (SignalReportConfig signalReportConfig : signalReportSettings) {
            if (TextUtils.equals(signalReportConfig.signalName, getSignalName())) {
                this.mSignalReportConfig = signalReportConfig;
                this.mHeadSetStatusExtraConfig = new HeadSetStatusExtraConfig(this.mSignalReportConfig.extraConfig);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:36|(8:79|(1:81)|83|40|41|42|43|(2:45|(2:51|(2:57|(2:59|60)(1:61))(2:55|56))(2:49|50))(2:62|(2:64|(2:70|(2:72|73)(1:74))(2:68|69))(1:75)))(1:38)|39|40|41|42|43|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a2, code lost:
    
        com.bytedance.push.utils.Logger.m271e("HeadSetReporterAdapter", "[onReceiveSignal]allowKillSmp exception:" + r0.getLocalizedMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0154, code lost:
    
        if (r9 == 0) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0207 A[Catch: all -> 0x0284, TryCatch #1 {all -> 0x0284, blocks: (B:32:0x0106, B:34:0x010c, B:36:0x0112, B:40:0x0159, B:43:0x01b6, B:45:0x0207, B:47:0x020d, B:49:0x0214, B:51:0x021e, B:53:0x0225, B:55:0x022b, B:57:0x0234, B:59:0x0246, B:62:0x024a, B:64:0x0256, B:66:0x025c, B:68:0x0263, B:70:0x026c, B:72:0x0280, B:78:0x01a2, B:79:0x012d, B:81:0x0134, B:42:0x0169), top: B:31:0x0106, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x024a A[Catch: all -> 0x0284, TryCatch #1 {all -> 0x0284, blocks: (B:32:0x0106, B:34:0x010c, B:36:0x0112, B:40:0x0159, B:43:0x01b6, B:45:0x0207, B:47:0x020d, B:49:0x0214, B:51:0x021e, B:53:0x0225, B:55:0x022b, B:57:0x0234, B:59:0x0246, B:62:0x024a, B:64:0x0256, B:66:0x025c, B:68:0x0263, B:70:0x026c, B:72:0x0280, B:78:0x01a2, B:79:0x012d, B:81:0x0134, B:42:0x0169), top: B:31:0x0106, inners: #0 }] */
    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceiveSignal(Intent intent) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        BarrierStatus extract;
        super.onReceiveSignal(intent);
        Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]action:" + intent.getAction() + " " + BundleUtils.toStr(intent.getExtras()));
        if (TextUtils.equals(intent.getAction(), "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
            int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]find bluetooth ear phone state change,preState:" + this.stateTag.get(Integer.valueOf(intExtra)) + " curState:" + this.stateTag.get(Integer.valueOf(intExtra2)));
            if (intExtra == 0 && intExtra2 == 1) {
                reportSignalNow(this.mTriggerScene, "connecting", false);
                return;
            } else if (intExtra2 == 2) {
                reportSignalNow(this.mTriggerScene, "connected", false);
                return;
            } else {
                if (intExtra2 == 0) {
                    reportSignalNow(this.mTriggerScene, HeadSetStatusExtraConfig.VALUE_DISCONNECT, false);
                    return;
                }
                return;
            }
        }
        if (TextUtils.equals(intent.getAction(), "android.intent.action.HEADSET_PLUG")) {
            int intExtra3 = intent.getIntExtra("state", -1);
            str = "[onReceiveSignal]kill self from headset.connecting.barrier allowKillSmp:";
            Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]find ear phone state change,state:" + intExtra3);
            str2 = "connecting";
            if (System.currentTimeMillis() - this.registerTimeStamp <= Constants.TASK_RUN_THRESHOLD) {
                Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]cur signal is duplication,do nothing");
                return;
            } else {
                if (intExtra3 == 1) {
                    reportSignalNow(this.mTriggerScene, "connected", false);
                    return;
                }
                z = false;
                if (intExtra3 == 0) {
                    reportSignalNow(this.mTriggerScene, HeadSetStatusExtraConfig.VALUE_DISCONNECT, false);
                    return;
                }
            }
        } else {
            str = "[onReceiveSignal]kill self from headset.connecting.barrier allowKillSmp:";
            str2 = "connecting";
            z = false;
        }
        try {
            if (!initHeadSetStatusExtraConfig()) {
                Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]do nothing because initHeadSetStatusExtraConfig failed");
                return;
            }
            Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]killProcessMode:" + this.mHeadSetStatusExtraConfig.killProcessMode);
            if (this.mHeadSetStatusExtraConfig.killProcessMode != 0) {
                if (this.mHeadSetStatusExtraConfig.killProcessMode == 2) {
                    int notificationNum = PushServiceManager.get().getIPushNotificationService().getNotificationNum(AppProvider.getApp());
                    Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]curNotificationNum:" + notificationNum);
                }
                z2 = true;
                Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]allowKillSmp:" + z2);
                Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]startProcessComponent:" + PushServiceManager.get().getAliveMonitorService().getProcessStartInfoObject(AppProvider.getApp()).optString("start_component") + " signalReceiverName:" + SmpSignalReceiver.class.getCanonicalName());
                extract = BarrierStatus.extract(intent);
                Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]barrierLabel:" + extract.getBarrierLabel() + " curStatus:" + extract.getPresentStatus() + " preStatus:" + extract.getLastStatus() + " allowKillSmp:" + z2);
                String stringExtra = intent.getStringExtra(ISignalReportConstants.KEY_TRIGGER_SCENE);
                if (!TextUtils.equals(extract.getBarrierLabel(), "headset.connected.barrier")) {
                    if (extract.getLastStatus() == 0 && extract.getPresentStatus() == 1) {
                        Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]from disconnect to connect");
                        reportSignalNow(stringExtra, "connected", z2);
                        return;
                    } else if (extract.getLastStatus() == 1 && extract.getPresentStatus() == 0) {
                        Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]from connect to disconnect");
                        reportSignalNow(stringExtra, HeadSetStatusExtraConfig.VALUE_DISCONNECT, z2);
                        return;
                    } else {
                        Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]kill self from headset.connected.barrier allowKillSmp:" + z2);
                        if (z2) {
                            ToolUtils.killSelf();
                            return;
                        }
                        return;
                    }
                }
                if (TextUtils.equals(extract.getBarrierLabel(), "headset.connecting.barrier")) {
                    if (extract.getLastStatus() == 0 && extract.getPresentStatus() == 1) {
                        Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]start connecting");
                        reportSignalNow(stringExtra, str2, z2);
                        return;
                    } else {
                        Logger.m268d("HeadSetReporterAdapter", str + z2);
                        if (z2) {
                            ToolUtils.killSelf();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            z2 = z;
            Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]allowKillSmp:" + z2);
            Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]startProcessComponent:" + PushServiceManager.get().getAliveMonitorService().getProcessStartInfoObject(AppProvider.getApp()).optString("start_component") + " signalReceiverName:" + SmpSignalReceiver.class.getCanonicalName());
            extract = BarrierStatus.extract(intent);
            Logger.m268d("HeadSetReporterAdapter", "[onReceiveSignal]barrierLabel:" + extract.getBarrierLabel() + " curStatus:" + extract.getPresentStatus() + " preStatus:" + extract.getLastStatus() + " allowKillSmp:" + z2);
            String stringExtra2 = intent.getStringExtra(ISignalReportConstants.KEY_TRIGGER_SCENE);
            if (!TextUtils.equals(extract.getBarrierLabel(), "headset.connected.barrier")) {
            }
        } catch (Throwable th) {
            Logger.m271e("HeadSetReporterAdapter", "[onReceiveSignal]error when parse BarrierStatus:" + th.getLocalizedMessage());
        }
    }

    private void reportSignalNow(String str, String str2, boolean z) {
        Logger.m268d("HeadSetReporterAdapter", "[reportSignalNow]triggerScene:" + str + " actionType:" + str2);
        if (z) {
            synchronized (this) {
                this.reportingSignalCnt++;
            }
        }
        new Handler(Looper.getMainLooper()).post(new RunnableC05745(str2, str, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.push.event.sync.adapter.HeadSetReporterAdapter$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class RunnableC05745 implements Runnable {
        final /* synthetic */ String val$actionType;
        final /* synthetic */ boolean val$needKillSelfAfterSignalReport;
        final /* synthetic */ String val$triggerScene;

        RunnableC05745(String str, String str2, boolean z) {
            this.val$actionType = str;
            this.val$triggerScene = str2;
            this.val$needKillSelfAfterSignalReport = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            final AudioManager audioManager = (AudioManager) AppProvider.getApp().getSystemService("audio");
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.adapter.HeadSetReporterAdapter.5.1
                @Override // java.lang.Runnable
                public void run() {
                    if (HeadSetReporterAdapter.this.initHeadSetStatusExtraConfig()) {
                        if (HeadSetReporterAdapter.this.mHeadSetStatusExtraConfig.listenTypeList.contains(RunnableC05745.this.val$actionType)) {
                            String headSetType = HeadSetReporterAdapter.this.getHeadSetType(audioManager);
                            JSONObject jSONObject = new JSONObject();
                            HeadSetReporterAdapter.this.add(jSONObject, "action_type", RunnableC05745.this.val$actionType);
                            HeadSetReporterAdapter.this.add(jSONObject, "headset_type", headSetType);
                            PushSupporter.get().getSignalReportService().getISignalReporter().reportSignal(HeadSetReporterAdapter.this.mSignalReportConfig, HeadSetReporterAdapter.this.getSignalName(), RunnableC05745.this.val$triggerScene, jSONObject, new ISignalReporter.ISignalReporterListener() { // from class: com.bytedance.push.event.sync.adapter.HeadSetReporterAdapter.5.1.1
                                @Override // com.bytedance.push.event.sync.ISignalReporter.ISignalReporterListener
                                public void onFinished(boolean z, String str) {
                                    Logger.m268d("HeadSetReporterAdapter", "[reportSignalNow]finished report signal,actionType:" + RunnableC05745.this.val$actionType + " result :" + z + " msg:" + str + " needKillSelfAfterSignalReport:" + RunnableC05745.this.val$needKillSelfAfterSignalReport + " reportingSignalCnt:" + HeadSetReporterAdapter.this.reportingSignalCnt);
                                    if (RunnableC05745.this.val$needKillSelfAfterSignalReport) {
                                        synchronized (HeadSetReporterAdapter.this) {
                                            HeadSetReporterAdapter.this.reportingSignalCnt--;
                                            if (HeadSetReporterAdapter.this.reportingSignalCnt == 0) {
                                                ToolUtils.killSelf();
                                            }
                                        }
                                    }
                                }
                            });
                            return;
                        }
                        Logger.m268d("HeadSetReporterAdapter", "[reportSignalNow]not report because mHeadSetStatusExtraConfig.listenTypeList not contains " + RunnableC05745.this.val$actionType);
                        return;
                    }
                    Logger.m268d("HeadSetReporterAdapter", "[reportSignalNow]do nothing because  initHeadSetStatusExtraConfig failed");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getHeadSetType(AudioManager audioManager) {
        if (audioManager.isWiredHeadsetOn()) {
            return "wired";
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            int profileConnectionState = defaultAdapter.getProfileConnectionState(2);
            int profileConnectionState2 = defaultAdapter.getProfileConnectionState(1);
            int profileConnectionState3 = defaultAdapter.getProfileConnectionState(3);
            Logger.m268d("HeadSetReporterAdapter", "[getHeadSetType]a2dp:" + profileConnectionState + " headset:" + profileConnectionState2 + " health:" + profileConnectionState3);
            if (profileConnectionState == 2) {
                return "wireless_a2dp";
            }
            if (profileConnectionState2 == 2) {
                return "wireless_headset";
            }
            if (profileConnectionState3 == 2) {
                return "wireless_health";
            }
        }
        return "unknown";
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_push_event_sync_adapter_HeadSetReporterAdapter_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m235x9b68806c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

package com.bytedance.push.event.sync;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter;
import com.bytedance.push.event.sync.adapter.AppPositionReporter;
import com.bytedance.push.event.sync.adapter.ClientDisplayFeatureReporter;
import com.bytedance.push.event.sync.adapter.HeadSetReporterAdapter;
import com.bytedance.push.event.sync.adapter.HwDeviceScreenStatusReporter;
import com.bytedance.push.event.sync.adapter.NotificationClearReporter;
import com.bytedance.push.event.sync.adapter.PullDownNotificationBarAdapter;
import com.bytedance.push.event.sync.adapter.RingTonesInfoReporter;
import com.bytedance.push.event.sync.adapter.UserExitsSignalReporter;
import com.bytedance.push.interfaze.ISignalReportService;
import com.bytedance.push.settings.pull.PullSettingsModel;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.settings.signal.sync.SignalReportSettingsModel;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import com.ss.android.pushmanager.setting.PushSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SignalReportServiceImpl implements ISignalReportService, ISettingsUpdateListener {
    private ConcurrentHashMap<String, WeakReference<IBusinessExtraInfoProvider>> mBusinessExtraInfoProviderMap;
    private WeakReference<IUserExitsSignalInfoProvider> mIUserExitsValidityCheckerWeakReference;
    private volatile ISignalReporter mSignalReporter;
    private final String TAG = "SignalReportServiceImpl";
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    final Set<String> runningReporter = new HashSet();
    private Map<String, AbsSignalReporterAdapter> mStringISignalReporterMap = new HashMap();
    private Set<INotificationDeleteListener> mINotificationDeleteListenerSet = new HashSet();

    public SignalReportServiceImpl() {
        this.mStringISignalReporterMap.put(ISignalReportConstants.SIGNAL_NAME_USER_EXITS, new UserExitsSignalReporter());
        this.mStringISignalReporterMap.put(ISignalReportConstants.SIGNAL_NAME_RINGTONES_INFO, new RingTonesInfoReporter());
        this.mStringISignalReporterMap.put(ISignalReportConstants.SIGNAL_NAME_PULL_DOWN_NOTIFICATION_BAR, new PullDownNotificationBarAdapter());
        this.mStringISignalReporterMap.put(ISignalReportConstants.SIGNAL_NAME_CLEAR_NOTIFICATION, new NotificationClearReporter());
        this.mStringISignalReporterMap.put(ISignalReportConstants.SIGNAL_NAME_APP_POSITION, new AppPositionReporter());
        this.mStringISignalReporterMap.put(ISignalReportConstants.SIGNAL_NAME_HW_SCREEN_STATUS, new HwDeviceScreenStatusReporter());
        this.mStringISignalReporterMap.put(ISignalReportConstants.SIGNAL_NAME_HEAD_SET_STATUS, new HeadSetReporterAdapter());
        this.mStringISignalReporterMap.put(ISignalReportConstants.SIGNAL_NAME_USER_DISPLAY_INFO, new ClientDisplayFeatureReporter());
        this.mBusinessExtraInfoProviderMap = new ConcurrentHashMap<>();
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public boolean syncEventToPushServer(List<String> list, Map<String, String> map) {
        return syncEventToPushServerInternal(list, map);
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public void triggerSignalReport(final String str) {
        Logger.m268d("SignalReportServiceImpl", "[triggerSignalReport]triggerScene:" + str);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.SignalReportServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, PullSettingsModel.SCENE_COLD_LAUNCH)) {
                    if (ToolUtils.isMainProcess(AppProvider.getApp())) {
                        SignalReportServiceImpl.this.startSignalReportInternal(str);
                        return;
                    } else {
                        Logger.m278w("SignalReportServiceImpl", "[triggerSignalReport]invalid process for SIGNAL_SCENE_APP_LAUNCH,do nothing");
                        return;
                    }
                }
                if (TextUtils.equals(str, PullSettingsModel.SCENE_DEPTHS)) {
                    if (ToolUtils.isSmpProcess(AppProvider.getApp())) {
                        SignalReportServiceImpl.this.startSignalReportInternal(str);
                        return;
                    } else {
                        Logger.m278w("SignalReportServiceImpl", "[triggerSignalReport]invalid process for SIGNAL_SCENE_DEPTHS,do nothing");
                        return;
                    }
                }
                Logger.m278w("SignalReportServiceImpl", "[triggerSignalReport]invalid triggerScene,do nothing");
            }
        });
    }

    @Override // com.bytedance.push.event.sync.ISignalReportApi
    public void setBusinessExtraInfoProvider(String str, IBusinessExtraInfoProvider iBusinessExtraInfoProvider) {
        Logger.m268d("SignalReportServiceImpl", "[setBusinessExtraInfoProvider]businessName:" + str);
        this.mBusinessExtraInfoProviderMap.put(str, new WeakReference<>(iBusinessExtraInfoProvider));
    }

    @Override // com.bytedance.push.event.sync.ISignalReportApi
    public void setUserExitsSignalInfoProvider(IUserExitsSignalInfoProvider iUserExitsSignalInfoProvider) {
        Logger.m268d("SignalReportServiceImpl", "[setUserExitsSignalValidityChecker]");
        this.mIUserExitsValidityCheckerWeakReference = new WeakReference<>(iUserExitsSignalInfoProvider);
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public IUserExitsSignalInfoProvider getIUserExitsValidityChecker() {
        WeakReference<IUserExitsSignalInfoProvider> weakReference = this.mIUserExitsValidityCheckerWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public ConcurrentHashMap<String, WeakReference<IBusinessExtraInfoProvider>> getBusinessExtraInfoProviderMap() {
        return this.mBusinessExtraInfoProviderMap;
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public ISignalReporter getISignalReporter() {
        if (this.mSignalReporter == null) {
            synchronized (this) {
                if (this.mSignalReporter == null) {
                    this.mSignalReporter = new SignalReporterImpl();
                }
            }
        }
        return this.mSignalReporter;
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public void onNotificationDelete(long j) {
        Logger.m268d("SignalReportServiceImpl", "[onNotificationDelete]:" + j);
        for (Object obj : this.mINotificationDeleteListenerSet.toArray()) {
            ((INotificationDeleteListener) obj).onNotificationDelete(j);
        }
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public void registerNotificationDeleteListener(INotificationDeleteListener iNotificationDeleteListener) {
        this.mINotificationDeleteListenerSet.add(iNotificationDeleteListener);
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public void onReceiveSignal(Intent intent) {
        if (intent == null) {
            return;
        }
        if (TextUtils.equals(intent.getAction(), "android.intent.action.HEADSET_PLUG") || TextUtils.equals(intent.getAction(), "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
            AbsSignalReporterAdapter absSignalReporterAdapter = this.mStringISignalReporterMap.get(ISignalReportConstants.SIGNAL_NAME_HEAD_SET_STATUS);
            if (absSignalReporterAdapter != null) {
                absSignalReporterAdapter.onReceiveSignal(intent);
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra(ISignalReportConstants.KEY_SIGNAL_NAME);
        if (TextUtils.isEmpty(stringExtra)) {
            Logger.m268d("SignalReceiver", "do nothing because cur signalName is empty");
            return;
        }
        AbsSignalReporterAdapter absSignalReporterAdapter2 = this.mStringISignalReporterMap.get(stringExtra);
        if (absSignalReporterAdapter2 == null) {
            return;
        }
        absSignalReporterAdapter2.onReceiveSignal(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSignalReportInternal(String str) {
        if (this.mStarted.compareAndSet(false, true)) {
            Logger.m268d("SignalReportServiceImpl", "[startSignalReportInternal]triggerScene:" + str);
            HashSet hashSet = new HashSet(this.mStringISignalReporterMap.keySet());
            SignalReportSettingsModel signalSyncSettingsModel = PushSetting.getInstance().getPushOnLineSettings().getSignalSyncSettingsModel();
            if (signalSyncSettingsModel != null) {
                List<SignalReportConfig> signalReportSettings = signalSyncSettingsModel.getSignalReportSettings();
                if (signalReportSettings != null) {
                    Object[] array = signalReportSettings.toArray();
                    Logger.m268d("SignalReportServiceImpl", "[startSignalReportInternal]signalConfig size:" + array.length);
                    synchronized (this.runningReporter) {
                        for (Object obj : array) {
                            SignalReportConfig signalReportConfig = (SignalReportConfig) obj;
                            AbsSignalReporterAdapter absSignalReporterAdapter = this.mStringISignalReporterMap.get(signalReportConfig.signalName);
                            if (absSignalReporterAdapter != null) {
                                hashSet.remove(signalReportConfig.signalName);
                                if (signalReportConfig.signalScene.contains(str)) {
                                    absSignalReporterAdapter.startSignalReport(str, signalReportConfig);
                                    this.runningReporter.add(signalReportConfig.signalName);
                                }
                            } else {
                                Logger.m278w("SignalReportServiceImpl", "[startSignalReportInternal]report signal failed because not available ISignalReporter");
                            }
                        }
                    }
                } else {
                    Logger.m278w("SignalReportServiceImpl", "[startSignalReportInternal]signalReportSettings is null");
                }
            } else {
                Logger.m278w("SignalReportServiceImpl", "[startSignalReportInternal]signalSyncSettingsModel is null");
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                AbsSignalReporterAdapter absSignalReporterAdapter2 = this.mStringISignalReporterMap.get((String) it.next());
                if (absSignalReporterAdapter2 != null) {
                    absSignalReporterAdapter2.unregister();
                }
            }
            if (this.runningReporter.isEmpty()) {
                return;
            }
            Logger.m268d("SignalReportServiceImpl", "[startSignalReportInternal]register settings change listener because runningReporter is not empty,cur signalSyncSettingsModel:" + GsonUtils.toJson(signalSyncSettingsModel));
            PushSetting.getInstance().registerSettingsUpdateListener(this);
        }
    }

    private boolean syncEventToPushServerInternal(List<String> list, Map<String, String> map) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Logger.m271e("SignalReportServiceImpl", "[syncEventToPushServerInternal]don't invoke cur method in main thread! ");
            return false;
        }
        if (list == null || list.isEmpty()) {
            Logger.m271e("SignalReportServiceImpl", "[syncEventToPushServerInternal]events is empty,not request! ");
            return false;
        }
        Map httpCommonParams = PushCommonSupport.getInstance().getPushCommonParamService().getHttpCommonParams();
        String eventSyncUrl = MessageConstants.getEventSyncUrl();
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        reqContext.addCommonParams = false;
        String addUrlParam = ToolUtils.addUrlParam(eventSyncUrl, httpCommonParams);
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(ISignalReportService.BODY_KEY_EVENT, jSONArray.toString()));
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    arrayList.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
            String post = PushNetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext);
            if (TextUtils.isEmpty(post)) {
                Logger.m271e("SignalReportServiceImpl", "[syncEventToPushServerInternal]request failed because server return empty");
                return false;
            }
            if (!TextUtils.equals("success", new JSONObject(post).optString("message"))) {
                Logger.m271e("SignalReportServiceImpl", "[syncEventToPushServerInternal]request failed because server response is not success");
                return false;
            }
            Logger.m268d("SignalReportServiceImpl", "[syncEventToPushServerInternal]request success");
            return true;
        } catch (Throwable th) {
            Logger.m271e("SignalReportServiceImpl", String.format("[syncEventToPushServerInternal]request failed,errorCode: %s errorMsg: %s", Integer.valueOf(th instanceof CommonHttpException ? th.getResponseCode() : -100), th.getMessage()));
            return false;
        }
    }

    public void onSettingsUpdate() {
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.SignalReportServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SignalReportServiceImpl.this.runningReporter) {
                    if (SignalReportServiceImpl.this.runningReporter.isEmpty()) {
                        return;
                    }
                    SignalReportSettingsModel signalSyncSettingsModel = PushSetting.getInstance().getPushOnLineSettings().getSignalSyncSettingsModel();
                    HashSet<String> hashSet = new HashSet(SignalReportServiceImpl.this.runningReporter);
                    Logger.m268d("SignalReportServiceImpl", "[onSettingsChange]signalSyncSettingsModel:" + GsonUtils.toJson(signalSyncSettingsModel) + " needUnregisterReporter:" + hashSet.size());
                    if (signalSyncSettingsModel != null) {
                        List<SignalReportConfig> signalReportSettings = signalSyncSettingsModel.getSignalReportSettings();
                        if (signalReportSettings != null) {
                            Object[] array = signalReportSettings.toArray();
                            Logger.m268d("SignalReportServiceImpl", "[onSettingsChange]signalConfig size:" + array.length);
                            for (Object obj : array) {
                                SignalReportConfig signalReportConfig = (SignalReportConfig) obj;
                                if (((AbsSignalReporterAdapter) SignalReportServiceImpl.this.mStringISignalReporterMap.get(signalReportConfig.signalName)) != null) {
                                    hashSet.remove(signalReportConfig.signalName);
                                } else {
                                    Logger.m278w("SignalReportServiceImpl", "[onSettingsChange]report signal failed because not available ISignalReporter");
                                }
                            }
                        } else {
                            Logger.m278w("SignalReportServiceImpl", "[onSettingsChange]signalReportSettings is null");
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        for (String str : hashSet) {
                            Logger.m268d("SignalReportServiceImpl", "[onSettingsChange]unregister " + str);
                            AbsSignalReporterAdapter absSignalReporterAdapter = (AbsSignalReporterAdapter) SignalReportServiceImpl.this.mStringISignalReporterMap.get(str);
                            if (absSignalReporterAdapter != null) {
                                absSignalReporterAdapter.unregister();
                                SignalReportServiceImpl.this.runningReporter.remove(str);
                            }
                        }
                    }
                }
            }
        });
    }

    @Override // com.bytedance.push.interfaze.ISignalReportService
    public void onHwScreenConfigDisable() {
        synchronized (this.runningReporter) {
            AbsSignalReporterAdapter absSignalReporterAdapter = this.mStringISignalReporterMap.get(ISignalReportConstants.SIGNAL_NAME_HW_SCREEN_STATUS);
            if (absSignalReporterAdapter != null) {
                absSignalReporterAdapter.unregister();
                if (this.runningReporter.contains(absSignalReporterAdapter)) {
                    this.runningReporter.remove(absSignalReporterAdapter);
                }
            }
        }
    }
}

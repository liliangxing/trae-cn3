package com.bytedance.push.event.sync;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.ISignalReporter;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.signal.sync.ItemSignalReportHistory;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.settings.signal.sync.SignalReportHistory;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import com.ss.android.pushmanager.setting.PushSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SignalReporterImpl extends BaseJson implements ISignalReporter {
    private final String TAG = "SignalReporterImpl";

    @Override // com.bytedance.push.event.sync.ISignalReporter
    public void reportSignal(SignalReportConfig signalReportConfig, String str, String str2, JSONObject jSONObject) {
        reportSignal(signalReportConfig, str, str2, jSONObject, null);
    }

    @Override // com.bytedance.push.event.sync.ISignalReporter
    public void reportSignal(SignalReportConfig signalReportConfig, final String str, String str2, JSONObject jSONObject, final ISignalReporter.ISignalReporterListener iSignalReporterListener) {
        JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
        ConcurrentHashMap<String, WeakReference<IBusinessExtraInfoProvider>> businessExtraInfoProviderMap = PushSupporter.get().getSignalReportService().getBusinessExtraInfoProviderMap();
        Logger.m268d("SignalReporterImpl", "[reportSignal]signalName:" + str + " signalInfo:" + jSONObject2);
        PushServiceManager.get().getIAllianceService().startClientAccountRetryTask("signal$" + str);
        JSONObject jSONObject3 = new JSONObject();
        if (businessExtraInfoProviderMap != null) {
            Logger.m268d("SignalReporterImpl", "[reportSignal]businessExtraInfoProviderMap size is " + businessExtraInfoProviderMap.size());
            for (String str3 : businessExtraInfoProviderMap.keySet()) {
                WeakReference<IBusinessExtraInfoProvider> weakReference = businessExtraInfoProviderMap.get(str3);
                if (weakReference != null) {
                    IBusinessExtraInfoProvider iBusinessExtraInfoProvider = weakReference.get();
                    if (iBusinessExtraInfoProvider != null) {
                        String extraInfo = iBusinessExtraInfoProvider.getExtraInfo(str);
                        Logger.m278w("SignalReporterImpl", "[reportSignal]extraInfoString for " + str3 + " is " + extraInfo);
                        if (!TextUtils.isEmpty(extraInfo)) {
                            add(jSONObject3, str3, extraInfo);
                        }
                    } else {
                        Logger.m278w("SignalReporterImpl", "[reportSignal]iBusinessExtraInfoProvider for " + str3 + " is null");
                    }
                }
            }
        } else {
            Logger.m268d("SignalReporterImpl", "[reportSignal]businessExtraInfoProviderMap is null");
        }
        try {
            JSONObject jSONObject4 = jSONObject2.getJSONObject(ISignalReportConstants.KEY_BUSINESS_EXTRA_STRING);
            Iterator<String> keys = jSONObject4.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                add(jSONObject3, next, jSONObject4.get(next).toString());
            }
        } catch (JSONException e) {
            Logger.m271e("SignalReporterImpl", String.valueOf(e));
            e.printStackTrace();
        }
        add(jSONObject2, ISignalReportConstants.KEY_BUSINESS_EXTRA_STRING, jSONObject3.toString());
        if (signalReportConfig.signalReportInterval > 0) {
            Logger.m268d("SignalReporterImpl", "[reportSignal]need frequency control because signalReportInterval is " + signalReportConfig.signalReportInterval);
            LocalSettings localSettings = PushSetting.getInstance().getLocalSettings();
            SignalReportHistory signalReportHistory = localSettings.getSignalReportHistory();
            if (signalReportHistory == null) {
                Logger.m278w("SignalReporterImpl", "[reportSignal]signalReportHistory is null");
                signalReportHistory = new SignalReportHistory();
            }
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                if (signalReportHistory.history != null) {
                    ItemSignalReportHistory itemSignalReportHistory = signalReportHistory.history.get(str);
                    if (itemSignalReportHistory != null) {
                        Logger.m268d("SignalReporterImpl", "[reportSignal]itemSignalReportHistory:" + GsonUtils.toJson(itemSignalReportHistory));
                        long j = currentTimeMillis - itemSignalReportHistory.lastReportTime;
                        boolean equals = TextUtils.equals(jSONObject2.toString(), itemSignalReportHistory.lastSignalInfo);
                        boolean z = j < signalReportConfig.signalReportInterval;
                        Logger.m268d("SignalReporterImpl", "[reportSignal]dataIsSame:" + equals + " timeFrequencyControl:" + z);
                        if (equals && z) {
                            Logger.m268d("SignalReporterImpl", "[reportSignal]not report because frequency control");
                            callbackListener(iSignalReporterListener, false, "frequency control");
                            return;
                        }
                    } else {
                        Logger.m278w("SignalReporterImpl", "[reportSignal]itemSignalReportHistory is null");
                    }
                } else {
                    Logger.m278w("SignalReporterImpl", "[reportSignal]signalReportHistory.history is null");
                }
                Logger.m268d("SignalReporterImpl", "[reportSignal]not frequency control,write cur data to cache");
                if (signalReportHistory.history == null) {
                    signalReportHistory.history = new HashMap();
                }
                signalReportHistory.history.put(str, new ItemSignalReportHistory(jSONObject2.toString(), currentTimeMillis));
                localSettings.setSignalReportHistory(signalReportHistory);
            }
        } else {
            Logger.m268d("SignalReporterImpl", "[reportSignal]needn't frequency control because signalReportInterval is 0");
        }
        add(jSONObject2, "client_time", System.currentTimeMillis());
        add(jSONObject2, ISignalReportConstants.KEY_TRIGGER_SCENE, str2);
        final JSONObject jSONObject5 = new JSONObject();
        add(jSONObject5, ISignalReportConstants.KEY_SIGNAL_NAME, str);
        add(jSONObject5, ISignalReportConstants.KEY_EXTRA_INFO, jSONObject2);
        Logger.m268d("SignalReporterImpl", "[reportSignal]final_signal_data:" + jSONObject5);
        if ((signalReportConfig.signalType & 2) == 2) {
            Logger.m268d("SignalReporterImpl", "[reportSignal]report signal by applog");
            PushSupporter.get().getMultiProcessEventSenderService().onEventV3(ISignalReportConstants.EVENT_NAME_BDPUSH_CLIENT_SIGNAL, jSONObject5);
        }
        if ((signalReportConfig.signalType & 1) == 1) {
            Logger.m268d("SignalReporterImpl", "[reportSignal]report signal by http");
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.event.sync.SignalReporterImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    SignalReporterImpl.this.callbackListener(iSignalReporterListener, SignalReporterImpl.this.reporterSignalByHttp(str, jSONObject5), "reporterSignalByHttp");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackListener(ISignalReporter.ISignalReporterListener iSignalReporterListener, boolean z, String str) {
        if (iSignalReporterListener != null) {
            iSignalReporterListener.onFinished(z, str);
        }
    }

    @Override // com.bytedance.push.event.sync.ISignalReporter
    public boolean reporterSignalByHttp(String str, JSONObject jSONObject) {
        Logger.m268d("SignalReporterImpl", "[reporterSignalByHttp]signalData:" + jSONObject);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Logger.m271e("SignalReporterImpl", "[reporterSignalByHttp]don't invoke cur method in main thread! ");
            return false;
        }
        if (jSONObject == null) {
            Logger.m271e("SignalReporterImpl", "[reporterSignalByHttp]events is empty,not request! ");
            return false;
        }
        Map httpCommonParams = PushCommonSupport.getInstance().getPushCommonParamService().getHttpCommonParams();
        String eventSyncUrl = MessageConstants.getEventSyncUrl();
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        reqContext.addCommonParams = false;
        String addUrlParam = ToolUtils.addUrlParam(eventSyncUrl, httpCommonParams);
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(ISignalReportConstants.KEY_EVENT_VERSION, String.valueOf(1)));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    arrayList.add(new Pair(next, jSONObject.get(next).toString()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            add(jSONObject2, ISignalReportConstants.KEY_SIGNAL_NAME, str);
            String post = PushNetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext, jSONObject2);
            if (TextUtils.isEmpty(post)) {
                Logger.m271e("SignalReporterImpl", "[reporterSignalByHttp]request failed because server return empty");
                return false;
            }
            JSONObject jSONObject3 = new JSONObject(post);
            if (!TextUtils.equals("success", jSONObject3.optString("message"))) {
                Logger.m271e("SignalReporterImpl", "[reporterSignalByHttp]request failed because server response is not success");
                return false;
            }
            if (TextUtils.equals(str, ISignalReportConstants.SIGNAL_NAME_HW_SCREEN_STATUS)) {
                boolean optBoolean = jSONObject3.optBoolean(LocalSettings.SERVER_DISABLE_AW_BARRIER, false);
                PushSetting.getInstance().getLocalSettings().setServerDisableAwBarrier(optBoolean);
                if (optBoolean) {
                    PushSupporter.get().getSignalReportService().onHwScreenConfigDisable();
                }
            }
            Logger.m268d("SignalReporterImpl", "[reporterSignalByHttp]request success");
            return true;
        } catch (Throwable th2) {
            Logger.m271e("SignalReporterImpl", String.format("[reporterSignalByHttp]request failed,errorCode: %s errorMsg: %s", Integer.valueOf(th2 instanceof CommonHttpException ? th2.getResponseCode() : -100), th2.getMessage()));
            return false;
        }
    }
}

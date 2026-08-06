package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.LifeCycleMonitor;
import com.bytedance.common.wschannel.WschannelSdkInitParam;
import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl;
import com.bytedance.common.wschannel.heartbeat.BaseHeartBeatPolicy;
import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;
import com.bytedance.common.wschannel.heartbeat.monitor.HeartBeatMonitor;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.monitor.IWsSdkMonitor;
import com.bytedance.common.wschannel.server.PushChannelManager;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelSdk {
    private static final long DELAY_POST_APPSTATE_INETRVAL = 2000;
    private static Application sApplication;
    private static boolean sCalculateAppState;
    private static DelayParam sDelayParams;
    private static volatile boolean sInit;
    private static boolean sIsCurrentBackground;
    private static String sProcessName;
    private static final Object sLock = new Object();
    private static WsChannelApi impl = new WsChannelMultiProcessImpl();
    private static AppStateListener mAppStateChangedListener = new AppStateListener();
    private static MemTrimListener mMemTrimListener = null;
    private static Map<Integer, ChannelInfo> mRegisterMap = new ConcurrentHashMap();
    private static Map<Integer, BaseHeartBeatPolicy> sHeartbeatPolicy = new ConcurrentHashMap();

    private WsChannelSdk() {
    }

    public static Context getContext() {
        return sApplication;
    }

    public static void init(Application application, OnMessageReceiveListener onMessageReceiveListener) {
        doInit(application, onMessageReceiveListener, false, true, null);
    }

    public static void init(Application application, OnMessageReceiveListener onMessageReceiveListener, boolean z) {
        doInit(application, onMessageReceiveListener, z, true, null);
    }

    public static void init(Application application, OnMessageReceiveListener onMessageReceiveListener, OnBindWsChannelServiceListener onBindWsChannelServiceListener, boolean z) {
        doInit(application, onMessageReceiveListener, z, true, onBindWsChannelServiceListener);
    }

    public static void init(WschannelSdkInitParam wschannelSdkInitParam) {
        doInitWithParam(wschannelSdkInitParam);
    }

    public static void initWithoutLifeCycle(Application application, OnMessageReceiveListener onMessageReceiveListener) {
        doInit(application, onMessageReceiveListener, false, false, null);
    }

    public static void finishDelay() {
        checkInit();
        synchronized (sLock) {
            DelayParam delayParam = sDelayParams;
            if (delayParam != null && !delayParam.finishDelay) {
                sDelayParams.finishDelay = true;
                if (sDelayParams.mDelayMap.isEmpty()) {
                    impl.tryStartPushProcess(sApplication, true, true);
                } else {
                    Iterator it = sDelayParams.mDelayMap.values().iterator();
                    while (it.hasNext()) {
                        registerChannel((ChannelInfo) it.next());
                    }
                    sDelayParams.mDelayMap.clear();
                }
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.common.wschannel.WsChannelSdk.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WsChannelSdk.sIsCurrentBackground) {
                            WsChannelSdk.impl.onEnterToBackground(WsChannelSdk.sApplication);
                        } else {
                            WsChannelSdk.impl.onEnterToForeground(WsChannelSdk.sApplication);
                        }
                    }
                }, DELAY_POST_APPSTATE_INETRVAL);
            }
        }
    }

    public static void registerChannel(ChannelInfo channelInfo) {
        checkInit();
        synchronized (sLock) {
            DelayParam delayParam = sDelayParams;
            if (delayParam != null && !delayParam.finishDelay) {
                sDelayParams.mDelayMap.put(Integer.valueOf(channelInfo.channelId), channelInfo);
            }
            doRealRegisterOrParametersChangedMethod(channelInfo);
        }
    }

    private static void doRealRegisterOrParametersChangedMethod(ChannelInfo channelInfo) {
        mRegisterMap.put(Integer.valueOf(channelInfo.channelId), channelInfo);
        impl.registerApp(sApplication, createParameterMap(channelInfo));
    }

    @Deprecated
    public static void registerToutianChannel(ChannelInfo channelInfo, String str) {
        channelInfo.extra.put("sid", str);
        registerChannel(channelInfo);
    }

    public static void registerService(int i, int i2) {
        checkInit();
        impl.registerServiceId(sApplication, i, i2);
    }

    public static void unregisterService(int i, int i2) {
        checkInit();
        impl.unregisterServiceId(sApplication, i, i2);
        WsConstants.removeService(i, i2);
    }

    public static void unregisterChannel(int i) {
        checkInit();
        WsConstants.remove(i);
        mRegisterMap.remove(Integer.valueOf(i));
        synchronized (sLock) {
            DelayParam delayParam = sDelayParams;
            if (delayParam != null && !delayParam.finishDelay) {
                sDelayParams.mDelayMap.remove(Integer.valueOf(i));
            }
        }
        finishDelay();
        impl.unRegisterApp(sApplication, i);
    }

    public static void setEnable(Context context, boolean z) {
        boolean isEnable = WsChannelSettings.inst(context).isEnable();
        WsChannelSettings.inst(context).setEnable(z);
        if (isEnable || !z) {
            return;
        }
        Iterator<ChannelInfo> it = mRegisterMap.values().iterator();
        while (it.hasNext()) {
            registerChannel(it.next());
        }
    }

    public static void onParametersChanged(ChannelInfo channelInfo) {
        checkInit();
        synchronized (sLock) {
            DelayParam delayParam = sDelayParams;
            if (delayParam != null && !delayParam.finishDelay) {
                sDelayParams.mDelayMap.put(Integer.valueOf(channelInfo.channelId), channelInfo);
            }
            SsWsApp createParameterMap = createParameterMap(channelInfo);
            mRegisterMap.put(Integer.valueOf(channelInfo.channelId), channelInfo);
            impl.onParameterChange(sApplication, createParameterMap);
        }
    }

    @Deprecated
    public static void onToutiaoWsChannelParametersChanged(ChannelInfo channelInfo, String str) {
        channelInfo.extra.put("sid", str);
        onParametersChanged(channelInfo);
    }

    public static void sendPayload(WsChannelMsg wsChannelMsg) {
        checkInit();
        if (wsChannelMsg == null) {
            throw new IllegalArgumentException("WsChannelMsg can't be null");
        }
        if (wsChannelMsg.getChannelId() <= 0) {
            throw new IllegalArgumentException("illegal channelId");
        }
        if (wsChannelMsg.getService() < 0) {
            throw new IllegalArgumentException("illegal service");
        }
        if (wsChannelMsg.getMethod() <= 0) {
            throw new IllegalArgumentException("illegal method");
        }
        if (wsChannelMsg.getPayload() == null) {
            throw new IllegalArgumentException("illegal payload");
        }
        DelayParam delayParam = sDelayParams;
        if (delayParam != null && !delayParam.finishDelay) {
            finishDelay();
        }
        impl.sendPayload(sApplication, wsChannelMsg);
    }

    public static String sendPayloadWithAck(WsChannelMsg wsChannelMsg) {
        checkInit();
        if (wsChannelMsg == null) {
            throw new IllegalArgumentException("WsChannelMsg can't be null");
        }
        if (wsChannelMsg.getChannelId() <= 0) {
            throw new IllegalArgumentException("illegal channelId");
        }
        if (wsChannelMsg.getService() < 0) {
            throw new IllegalArgumentException("illegal service");
        }
        if (wsChannelMsg.getMethod() <= 0) {
            throw new IllegalArgumentException("illegal method");
        }
        if (wsChannelMsg.getPayload() == null) {
            throw new IllegalArgumentException("illegal payload");
        }
        DelayParam delayParam = sDelayParams;
        if (delayParam != null && !delayParam.finishDelay) {
            finishDelay();
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        wsChannelMsg.setUUID(replace);
        impl.sendPayload(sApplication, wsChannelMsg);
        return replace;
    }

    public static void enterToForeground() {
        if (sInit && !sCalculateAppState) {
            mAppStateChangedListener.onEnterToForeground();
        }
    }

    public static void enterToBackground() {
        if (sInit && !sCalculateAppState) {
            mAppStateChangedListener.onEnterToBackground();
        }
    }

    public static MemTrimListener getMemTrimListener() {
        return mMemTrimListener;
    }

    public static void setMemTrimListener(MemTrimListener memTrimListener) {
        mMemTrimListener = memTrimListener;
    }

    public static void onTrimMemory(int i) {
        if (sInit) {
            impl.onTrimMemory(sApplication, i);
        }
    }

    public static boolean isWsConnected(int i) {
        DelayParam delayParam = sDelayParams;
        if (delayParam == null || delayParam.finishDelay) {
            WsChannelApi wsChannelApi = impl;
            Application application = sApplication;
            wsChannelApi.tryStartPushProcess(application, Utils.isMainProcess(application, sProcessName));
        }
        return WsConstants.isWsChannelConnected(i);
    }

    public static boolean isPrivateProtocolEnabled(int i) {
        return WsConstants.isPrivateProtocolEnabled(i);
    }

    public static boolean isWsServiceConnected(int i, int i2) {
        return WsConstants.isServiceConnected(i, i2);
    }

    public static void setAutoConnectDisabledChannelIds(Context context, ArrayList<Integer> arrayList) {
        WsChannelSettings.inst(context).setAutoConnectDisabledChannelIds(arrayList);
    }

    public static boolean isOkChannelEnable(Context context) {
        return WsChannelSettings.inst(context).isOkChannelEnable();
    }

    public static boolean isEnable(Context context) {
        return WsChannelSettings.inst(context).isEnable();
    }

    public static void setEnableReportAppState(Context context, boolean z) {
        WsChannelSettings.inst(context).setReportAppStateEnable(z);
    }

    public static void setOkChannelEnable(Context context, boolean z) {
        WsChannelSettings.inst(context).setOKChannelEnable(z);
    }

    public static void setSocketLimit(Context context, long j) {
        WsChannelSettings.inst(context).setSocketReadLimitSize(j);
    }

    public static void setRetrySendMsgDelayTimeMillis(Context context, long j) {
        WsChannelSettings.inst(context).setRetrySendMsgDelay(j);
    }

    public static void setMonitorInPush(IWsSdkMonitor iWsSdkMonitor) {
        HeartBeatMonitor.getInstance().setHeartBeatMonitor(iWsSdkMonitor);
    }

    public static <T extends IHeartBeatMeta> void setHeartBeatPolicy(int i, BaseHeartBeatPolicy<T> baseHeartBeatPolicy) {
        sHeartbeatPolicy.put(Integer.valueOf(i), baseHeartBeatPolicy);
    }

    public static <T extends IHeartBeatMeta> BaseHeartBeatPolicy<T> getHeartBeatPolicy(int i) {
        return sHeartbeatPolicy.get(Integer.valueOf(i));
    }

    private static void doInitWithParam(WschannelSdkInitParam wschannelSdkInitParam) {
        WsChannelSettings inst;
        if (sInit) {
            return;
        }
        Application application = wschannelSdkInitParam.getApplication();
        OnMessageReceiveListener listener = wschannelSdkInitParam.getListener();
        boolean isCalculateAppState = wschannelSdkInitParam.isCalculateAppState();
        boolean isDelayStartPushProcess = wschannelSdkInitParam.isDelayStartPushProcess();
        OnBindWsChannelServiceListener onBindWsChannelServiceListener = wschannelSdkInitParam.bindWsChannelServiceListener;
        boolean isEnableOfflineDetect = wschannelSdkInitParam.isEnableOfflineDetect();
        sInit = true;
        sApplication = application;
        sCalculateAppState = isCalculateAppState;
        String curProcessName = Utils.getCurProcessName(application);
        sProcessName = curProcessName;
        boolean isMainProcess = Utils.isMainProcess(application, curProcessName);
        if (isDelayStartPushProcess && isMainProcess) {
            DelayParam delayParam = new DelayParam();
            sDelayParams = delayParam;
            delayParam.finishDelay = false;
        }
        if (isMainProcess) {
            if (isCalculateAppState) {
                LifeCycleMonitor lifeCycleMonitor = new LifeCycleMonitor();
                lifeCycleMonitor.setAppStateChangedListener(mAppStateChangedListener);
                application.registerActivityLifecycleCallbacks(lifeCycleMonitor);
            }
            WsConstants.setOnMessageReceiveListener(listener);
            WsConstants.setOptLogic(wschannelSdkInitParam.getOptLogic());
            WsConstants.setBindWsChannelServiceListener(onBindWsChannelServiceListener);
            if (application != null && (inst = WsChannelSettings.inst(application)) != null) {
                inst.setEnableOfflineDetect(isEnableOfflineDetect);
            }
        } else if (Utils.isMessageProcess(sProcessName)) {
            registerNetChangeReceiver();
        }
        if (sDelayParams == null) {
            impl.tryStartPushProcess(sApplication, isMainProcess, true);
        }
    }

    private static void doInit(Application application, OnMessageReceiveListener onMessageReceiveListener, boolean z, boolean z2, OnBindWsChannelServiceListener onBindWsChannelServiceListener) {
        doInitWithParam(new WschannelSdkInitParam.Builder().application(application).messageReceiveListener(onMessageReceiveListener).delayStartPushProcess(z).calculateAppState(z2).enableOfflineDetect(false).bindWsChannelServiceListener(onBindWsChannelServiceListener).build());
    }

    private static SsWsApp createParameterMap(ChannelInfo channelInfo) {
        Map<String, String> map = channelInfo.extra;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                arrayList.add(entry.getKey() + "=" + Uri.encode(entry.getValue()));
            }
        }
        int i = channelInfo.aid;
        if (i <= 0) {
            throw new IllegalArgumentException("aid == 0 ,please set aid first");
        }
        String str = channelInfo.deviceId;
        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("deviceId is empty ,please set deviceId first");
        }
        String str2 = channelInfo.installId;
        if (StringUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("installId is empty ,please set installId first");
        }
        int i2 = channelInfo.fpid;
        if (i2 <= 0) {
            throw new IllegalArgumentException("fpid <= 0 ,please set fpid first");
        }
        String str3 = channelInfo.appKey;
        if (StringUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("appKey is empty,please set appKey first");
        }
        int i3 = channelInfo.updateVersionCode;
        if (i3 <= 0) {
            throw new IllegalArgumentException("appVersion <= 0 ,please set appVersion first");
        }
        int i4 = channelInfo.channelId;
        if (i4 <= 0) {
            throw new IllegalArgumentException("channelId <= 0 ,please set channelId first");
        }
        boolean z = channelInfo.privateProtocolEnabled;
        List<Integer> list = channelInfo.serviceIdList;
        if (z && (list == null || list.isEmpty())) {
            throw new IllegalArgumentException("ServiceIdList cannot be empty when private protocol is enabled.");
        }
        boolean z2 = channelInfo.disableFallbackWs;
        WsConstants.initServiceState(i4, list);
        return new SsWsApp.SsWsAppBuilder().setAppId(i).setDeviceId(str).setInstallId(str2).setFPID(i2).setAppKey(str3).setConnectUrls(channelInfo.urls).setAppVersion(i3).setPlatform(0).setChannelId(i4).setExtra(TextUtils.join("&", arrayList.toArray())).setHeaders(channelInfo.headers).enableNewPrivateProtocol(z).setServiceIdList(list).setPrivateProtocolUrl(channelInfo.privateProtocolUrl).setTransportMode(channelInfo.transportMode.getTypeValue()).disableFallbackWS(z2).build();
    }

    private static void registerNetChangeReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            Application application = sApplication;
            Application application2 = sApplication;
            m218x8642ab9f(application, new WsChannelReceiver(application2, PushChannelManager.inst(application2)), intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkInit() {
        if (!sInit) {
            throw new IllegalStateException("please init first");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class AppStateListener implements LifeCycleMonitor.AppStateListener {
        private AppStateListener() {
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToForeground() {
            boolean unused = WsChannelSdk.sIsCurrentBackground = false;
            if (WsChannelSdk.sDelayParams == null || WsChannelSdk.sDelayParams.finishDelay) {
                WsChannelSdk.impl.onEnterToForeground(WsChannelSdk.sApplication);
            }
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToBackground() {
            boolean unused = WsChannelSdk.sIsCurrentBackground = true;
            if (WsChannelSdk.sDelayParams == null || WsChannelSdk.sDelayParams.finishDelay) {
                WsChannelSdk.impl.onEnterToBackground(WsChannelSdk.sApplication);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class DelayParam {
        private boolean finishDelay;
        private Map<Integer, ChannelInfo> mDelayMap;

        private DelayParam() {
            this.finishDelay = false;
            this.mDelayMap = new ConcurrentHashMap();
        }
    }

    public static JSONObject reportFrontierMessageMetrics(WsChannelMsg wsChannelMsg, int i) {
        ChannelInfo channelInfo = mRegisterMap.get(Integer.valueOf(i));
        if (channelInfo != null && wsChannelMsg != null) {
            try {
                JSONObject parseServerTiming = parseServerTiming(wsChannelMsg.getServerTiming());
                if (parseServerTiming == null) {
                    return null;
                }
                parseServerTiming.put("im_rt", true);
                parseServerTiming.put("msgid", wsChannelMsg.getMsgId());
                parseServerTiming.put("service_id", wsChannelMsg.getService());
                parseServerTiming.put(WsConstants.KEY_FPID, channelInfo.fpid);
                parseServerTiming.put("qid", channelInfo.aid);
                if (channelInfo.privateProtocolEnabled) {
                    parseServerTiming.put("mode", channelInfo.transportMode.getTypeValue());
                    parseServerTiming.put("host", channelInfo.privateProtocolUrl);
                } else {
                    parseServerTiming.put("mode", 4);
                    parseServerTiming.put("host", channelInfo.urls.get(0));
                }
                if (Logger.debug()) {
                    Logger.m190d("ttnet", "user_msg:" + parseServerTiming);
                }
                return parseServerTiming;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static JSONObject parseServerTiming(String str) throws Exception {
        boolean z;
        long j;
        String str2 = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!splitStringIntoKeyValueMap(str2, "=", ";", ",", linkedHashMap) || !linkedHashMap.containsKey("ttnet")) {
            return null;
        }
        Map map = (Map) linkedHashMap.get("ttnet");
        if (!map.containsKey("recv_time")) {
            return null;
        }
        long parseLong = Long.parseLong((String) map.get("recv_time"));
        if (parseLong < 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        long parseLong2 = map.containsKey("sta") ? Long.parseLong((String) map.get("sta")) : -1L;
        long currentTimeMillis = System.currentTimeMillis();
        if (parseLong2 > 0) {
            j = parseLong - parseLong2;
            z = true;
        } else {
            z = false;
            j = 0;
        }
        long j2 = currentTimeMillis - parseLong;
        jSONObject.put(WsConstants.KEY_IS_ACK, z);
        jSONObject.put("tt_dur", j);
        jSONObject.put("recv_call_dur", j2);
        String str3 = "";
        jSONObject.put("receive_time", parseLong + "");
        jSONObject.put("im_recv_time", currentTimeMillis);
        Iterator it = linkedHashMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str4 = (String) it.next();
            if (str4.startsWith("client_") && str4.length() > 7) {
                str3 = str4;
                break;
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            jSONObject.put("msg_type", str3.substring(7));
            Map map2 = (Map) linkedHashMap.get(str3);
            if (map2.containsKey("sta")) {
                long parseLong3 = Long.parseLong((String) map2.get("sta"));
                if (parseLong3 > 0) {
                    jSONObject.put("im_dur", currentTimeMillis - parseLong3);
                    jSONObject.put("send_call_dur", parseLong2 - parseLong3);
                }
            }
        }
        if (str2.substring(str.length() - 1) != ",") {
            str2 = str2 + ",";
        }
        jSONObject.put("server_timing", str2 + "im_recv;dur=" + j2);
        return jSONObject;
    }

    private static boolean splitStringIntoKeyValueMap(String str, String str2, String str3, String str4, Map<String, Map<String, String>> map) {
        String[] split;
        String[] split2;
        String[] split3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || map == null || (split = str.split(str4)) == null) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i]) && (split2 = split[i].trim().split(str3)) != null && split2.length >= 2) {
                String str5 = split2[0];
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (int i2 = 1; i2 < split2.length; i2++) {
                    if (!TextUtils.isEmpty(split2[i2]) && (split3 = split2[i2].trim().split(str2)) != null && split3.length == 2 && !TextUtils.isEmpty(split3[0]) && !TextUtils.isEmpty(split3[1])) {
                        linkedHashMap.put(split3[0], split3[1]);
                    }
                }
                if (linkedHashMap.size() > 0) {
                    map.put(str5, linkedHashMap);
                }
            }
        }
        return map.size() != 0;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_common_wschannel_WsChannelSdk_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m218x8642ab9f(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return application.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                return ContextCompat.registerReceiver(application, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return application.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
}

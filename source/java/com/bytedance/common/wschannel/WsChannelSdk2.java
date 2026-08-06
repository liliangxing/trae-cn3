package com.bytedance.common.wschannel;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.LifeCycleMonitor;
import com.bytedance.common.wschannel.app.OnMessageAckListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;
import com.bytedance.common.wschannel.app.OnServiceConnectListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.client.WsChannelSingleProcessImpl;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.server.MainChannelManager;
import com.bytedance.common.wschannel.server.WsChannelReceiver;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelSdk2 {
    private static WsChannelApi impl = new WsChannelSingleProcessImpl();
    private static Map<Integer, WsChannelImpl> mChannels = new ConcurrentHashMap();
    private static AtomicBoolean sInited = new AtomicBoolean(false);
    private static boolean sIsCurrentBackground = true;

    public static WsChannel registerChannel(Context context, ChannelInfo channelInfo, OnMessageReceiveListener onMessageReceiveListener, OnServiceConnectListener onServiceConnectListener, OnMessageAckListener onMessageAckListener) {
        tryInit(context.getApplicationContext());
        WsChannelImpl wsChannelImpl = new WsChannelImpl(context.getApplicationContext(), impl, channelInfo, onMessageReceiveListener, onServiceConnectListener, onMessageAckListener);
        mChannels.put(Integer.valueOf(channelInfo.channelId), wsChannelImpl);
        wsChannelImpl.register();
        return wsChannelImpl;
    }

    public static WsChannel registerChannel(Context context, ChannelInfo channelInfo, OnMessageReceiveListener onMessageReceiveListener) {
        return registerChannel(context.getApplicationContext(), channelInfo, onMessageReceiveListener, null, null);
    }

    private static void tryInit(Context context) {
        if (sInited.compareAndSet(false, true)) {
            if (sIsCurrentBackground) {
                impl.onEnterToBackground(context);
            } else {
                impl.onEnterToForeground(context);
            }
            registerNetChangeReceiver(context);
        }
    }

    private static void registerNetChangeReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            m219xd20c328f(context, new WsChannelReceiver(context, MainChannelManager.inst(context)), intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SsWsApp createParameterMap(ChannelInfo channelInfo) {
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
        return new SsWsApp.SsWsAppBuilder().setAppId(i).setDeviceId(str).setInstallId(str2).setFPID(i2).setAppKey(str3).setConnectUrls(channelInfo.urls).setAppVersion(i3).setPlatform(0).setChannelId(i4).setHeaders(channelInfo.headers).setExtra(TextUtils.join("&", arrayList.toArray())).enableNewPrivateProtocol(channelInfo.privateProtocolEnabled).setServiceIdList(channelInfo.serviceIdList).setPrivateProtocolUrl(channelInfo.privateProtocolUrl).setTransportMode(channelInfo.transportMode.getTypeValue()).disableFallbackWS(channelInfo.disableFallbackWs).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static WsChannelImpl getChannel(int i) {
        return mChannels.get(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void unregister(int i) {
        mChannels.remove(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void monitorLifeCycle(Context context) {
        Application application = (Application) context.getApplicationContext();
        LifeCycleMonitor lifeCycleMonitor = new LifeCycleMonitor();
        lifeCycleMonitor.setAppStateChangedListener(new AppStateListener(application));
        application.registerActivityLifecycleCallbacks(lifeCycleMonitor);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class AppStateListener implements LifeCycleMonitor.AppStateListener {
        private final Application mApp;

        AppStateListener(Application application) {
            this.mApp = application;
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToForeground() {
            boolean unused = WsChannelSdk2.sIsCurrentBackground = false;
            if (WsChannelSdk2.sInited.get()) {
                WsChannelSdk2.impl.onEnterToForeground(this.mApp);
            }
        }

        @Override // com.bytedance.common.wschannel.LifeCycleMonitor.AppStateListener
        public void onEnterToBackground() {
            boolean unused = WsChannelSdk2.sIsCurrentBackground = true;
            if (WsChannelSdk2.sInited.get()) {
                WsChannelSdk2.impl.onEnterToBackground(this.mApp);
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_common_wschannel_WsChannelSdk2_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m219xd20c328f(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

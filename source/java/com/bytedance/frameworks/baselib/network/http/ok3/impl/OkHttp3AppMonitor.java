package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.HttpDns;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class OkHttp3AppMonitor implements LifeCycleMonitor.AppStateListener {
    private static final String TAG = "OkHttp3AppMonitor";
    private LifeCycleMonitor mLifeCycleMonitor = new LifeCycleMonitor();
    private BroadcastReceiver mNetworkStateReceiver = new BroadcastReceiver() { // from class: com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3AppMonitor.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast() && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                HttpDns.getService().onNetworkChanged();
            }
        }
    };

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.AppStateListener
    public void onEnterToBackground() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.AppStateListener
    public void onEnterToForeground() {
        HttpDns.getService().onResume();
    }

    public void registerAppMonitorListener(Context context) {
        registerNetworkStateChanged(context);
        registerForeBackgroundCallback(context);
    }

    private void registerNetworkStateChanged(Context context) {
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            m1293xbd94aa40(context, this.mNetworkStateReceiver, intentFilter);
            if (Logger.debug()) {
                Logger.d(TAG, "register network state changed completed");
            }
        }
    }

    private void registerForeBackgroundCallback(Context context) {
        Application application;
        if (Logger.debug()) {
            Logger.d(TAG, "register activity forground and background switch Callback");
        }
        if (!(context instanceof Application) || (application = (Application) context) == null) {
            return;
        }
        this.mLifeCycleMonitor.setAppStateChangedListener(this);
        application.registerActivityLifecycleCallbacks(this.mLifeCycleMonitor);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_frameworks_baselib_network_http_ok3_impl_OkHttp3AppMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m1293xbd94aa40(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sProxyHandler, 2);
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

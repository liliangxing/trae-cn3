package com.bytedance.common.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.common.applog.NetUtilWrapper;
import com.ss.android.common.util.TLog;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NetworkStatusMonitor implements NetUtilWrapper.INetworkProvider {
    private static final String TAG = "NetworkStatusMonitor";
    private static NetworkStatusMonitor instance;
    public static final AtomicBoolean isStarted = new AtomicBoolean(false);
    private Context mContext;
    private NetworkUtils.NetworkType networkType = NetworkUtils.NetworkType.MOBILE;
    private BroadcastReceiver receiver;

    public static NetworkStatusMonitor getInstance(Context context) {
        if (instance == null) {
            synchronized (NetworkStatusMonitor.class) {
                if (instance == null) {
                    instance = new NetworkStatusMonitor(context);
                }
            }
        }
        return instance;
    }

    private NetworkStatusMonitor(Context context) {
        this.mContext = context;
        start();
    }

    private void start() {
        TLog.d("NetworkStatusMonitor enable monitor...");
        this.networkType = NetworkUtils.getNetworkType(this.mContext);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.bytedance.common.utility.NetworkStatusMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                NetworkStatusMonitor networkStatusMonitor = NetworkStatusMonitor.this;
                networkStatusMonitor.networkType = NetworkUtils.getNetworkType(networkStatusMonitor.mContext);
                NetworkStatusMonitor.isStarted.set(true);
                TLog.d("NetworkStatusMonitor get network type is " + NetworkStatusMonitor.this.networkType.name());
            }
        };
        this.receiver = broadcastReceiver;
        m207xc76a493d(this.mContext, broadcastReceiver, intentFilter);
    }

    public void stop() {
        if (this.receiver == null || !isStarted.get()) {
            return;
        }
        m208x7aca4f16(this.mContext, this.receiver);
        this.receiver = null;
        TLog.w("NetworkStatusMonitor stop monitor");
    }

    public NetworkUtils.NetworkType getNetworkType() {
        return this.networkType;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_common_utility_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m207xc76a493d(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_bytedance_common_utility_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m208x7aca4f16(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

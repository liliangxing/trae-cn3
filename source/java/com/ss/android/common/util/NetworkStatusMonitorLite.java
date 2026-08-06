package com.ss.android.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class NetworkStatusMonitorLite {
    private static final long ADJUST_INTERVAL = 5000;
    private static final String STATE_CHANGE = "android.net.wifi.STATE_CHANGE";
    static final String TAG = "NTStatusMonitorLite";
    private static final String WIFI_STATE_CHANGE = "android.net.wifi.WIFI_STATE_CHANGED";
    private static volatile NetworkStatusMonitorLite sNetworkStatusMonitor;
    private final Context mContext;
    private BroadcastReceiver mNetworkStateReceiver;
    private boolean mReceiverOn = false;
    private NetworkUtils.NetworkType mNetworkType = NetworkUtils.NetworkType.MOBILE;
    private long lastAdjustTime = 0;

    public static NetworkStatusMonitorLite getIns(Context context) {
        if (sNetworkStatusMonitor == null) {
            synchronized (NetworkStatusMonitor.class) {
                if (sNetworkStatusMonitor == null) {
                    sNetworkStatusMonitor = new NetworkStatusMonitorLite(context);
                }
            }
        }
        return sNetworkStatusMonitor;
    }

    private NetworkStatusMonitorLite(Context context) {
        this.mContext = context.getApplicationContext();
        start();
    }

    public void onResume() {
        start();
    }

    public void onPause() {
        stop();
    }

    public void onDestroy() {
        if (this.mReceiverOn) {
            this.mReceiverOn = false;
            try {
                m72x66d85343(this.mContext, this.mNetworkStateReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mNetworkStateReceiver = null;
        }
    }

    private void start() {
        if (!this.mReceiverOn) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(WIFI_STATE_CHANGE);
            intentFilter.addAction(STATE_CHANGE);
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.ss.android.common.util.NetworkStatusMonitorLite.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE") || TextUtils.equals(NetworkStatusMonitorLite.WIFI_STATE_CHANGE, intent.getAction()) || TextUtils.equals(NetworkStatusMonitorLite.STATE_CHANGE, intent.getAction())) {
                        try {
                            NetworkStatusMonitorLite networkStatusMonitorLite = NetworkStatusMonitorLite.this;
                            networkStatusMonitorLite.mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(networkStatusMonitorLite.mContext);
                        } catch (Exception e) {
                            Log.w(NetworkStatusMonitorLite.TAG, "receive connectivity exception: " + e);
                        }
                    }
                }
            };
            this.mNetworkStateReceiver = broadcastReceiver;
            this.mReceiverOn = true;
            try {
                m71x919574aa(this.mContext, broadcastReceiver, intentFilter);
            } catch (Throwable unused) {
            }
        }
        this.mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(this.mContext);
    }

    private void stop() {
        if (this.mReceiverOn) {
            this.mReceiverOn = false;
            try {
                m72x66d85343(this.mContext, this.mNetworkStateReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mNetworkStateReceiver = null;
        }
    }

    public NetworkUtils.NetworkType getNetworkType() {
        refreshNetStatus();
        return this.mNetworkType;
    }

    private void refreshNetStatus() {
        if (System.currentTimeMillis() - this.lastAdjustTime > ADJUST_INTERVAL) {
            this.mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(this.mContext);
            this.lastAdjustTime = System.currentTimeMillis();
        }
    }

    public boolean isWifiOn() {
        return NetworkUtils.NetworkType.WIFI == this.mNetworkType;
    }

    public boolean isNetworkOn() {
        refreshNetStatus();
        return NetworkUtils.NetworkType.NONE != this.mNetworkType;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_android_common_util_NetworkStatusMonitorLite_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m71x919574aa(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_ss_android_common_util_NetworkStatusMonitorLite_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m72x66d85343(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

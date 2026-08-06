package com.ss.android.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
public final class NetworkStatusMonitor {
    private static final long ADJUST_INTERVAL = 5000;
    static final String TAG = "NetworkStatusMonitor";
    private static Context mContext;
    private static BroadcastReceiver mNetworkStateReceiver;
    private static volatile NetworkUtils.NetworkType mNetworkType = NetworkUtils.NetworkType.MOBILE;
    static boolean mReceiverOn;
    private static volatile NetworkStatusMonitor sNetworkStatusMonitor;
    private long lastAdjustTime = 0;

    public void onDestroy() {
    }

    private NetworkStatusMonitor() {
    }

    public static NetworkStatusMonitor getIns(Context context) {
        if (sNetworkStatusMonitor == null) {
            synchronized (NetworkStatusMonitor.class) {
                if (sNetworkStatusMonitor == null) {
                    mContext = context.getApplicationContext();
                    sNetworkStatusMonitor = new NetworkStatusMonitor();
                    mNetworkStateReceiver = new BroadcastReceiver() { // from class: com.ss.android.common.util.NetworkStatusMonitor.1
                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context2, Intent intent) {
                            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") || "android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction()) || "android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                                try {
                                    NetworkUtils.NetworkType unused = NetworkStatusMonitor.mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(NetworkStatusMonitor.mContext);
                                } catch (Exception e) {
                                    Log.w(NetworkStatusMonitor.TAG, "receive connectivity exception: " + e);
                                }
                            }
                        }
                    };
                    start();
                }
            }
        }
        return sNetworkStatusMonitor;
    }

    private static void start() {
        if (!mReceiverOn) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            mReceiverOn = true;
            try {
                m69x1633f038(mContext.getApplicationContext(), mNetworkStateReceiver, intentFilter);
            } catch (Throwable unused) {
            }
        }
        mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(mContext);
    }

    private void stop() {
        if (mReceiverOn) {
            mReceiverOn = false;
            m70x3dc62351(mContext, mNetworkStateReceiver);
            mNetworkStateReceiver = null;
        }
    }

    public void onResume() {
        start();
    }

    public void onPause() {
        stop();
    }

    public NetworkUtils.NetworkType getNetworkType() {
        return mNetworkType;
    }

    public boolean isWifiOn() {
        return NetworkUtils.NetworkType.WIFI == mNetworkType;
    }

    public boolean isNetworkOn() {
        if (NetworkUtils.NetworkType.NONE == mNetworkType && System.currentTimeMillis() - this.lastAdjustTime > ADJUST_INTERVAL) {
            mNetworkType = com.bytedance.common.utility.NetworkUtils.getNetworkType(mContext);
            this.lastAdjustTime = System.currentTimeMillis();
        }
        return NetworkUtils.NetworkType.NONE != mNetworkType;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_android_common_util_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m69x1633f038(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_ss_android_common_util_NetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m70x3dc62351(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

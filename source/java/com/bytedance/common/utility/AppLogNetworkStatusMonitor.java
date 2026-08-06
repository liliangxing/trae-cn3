package com.bytedance.common.utility;

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

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppLogNetworkStatusMonitor {
    static final String TAG = "NetworkStatusMonitor";
    final Context mContext;
    BroadcastReceiver mNetworkStateReceiver;
    boolean mReceiverOn = false;
    NetworkUtils.NetworkType mNetworkType = NetworkUtils.NetworkType.MOBILE;

    public AppLogNetworkStatusMonitor(Context context) {
        this.mContext = context;
        start();
    }

    private void start() {
        if (!this.mReceiverOn) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.bytedance.common.utility.AppLogNetworkStatusMonitor.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        try {
                            AppLogNetworkStatusMonitor appLogNetworkStatusMonitor = AppLogNetworkStatusMonitor.this;
                            appLogNetworkStatusMonitor.mNetworkType = NetworkUtils.getNetworkType(appLogNetworkStatusMonitor.mContext);
                        } catch (Exception e) {
                            Log.w(AppLogNetworkStatusMonitor.TAG, "receive connectivity exception: " + e);
                        }
                    }
                }
            };
            this.mNetworkStateReceiver = broadcastReceiver;
            this.mReceiverOn = true;
            try {
                m185x9eb87b1a(this.mContext, broadcastReceiver, intentFilter);
            } catch (Throwable unused) {
            }
        }
        this.mNetworkType = NetworkUtils.getNetworkType(this.mContext);
    }

    private void stop() {
        if (this.mReceiverOn) {
            this.mReceiverOn = false;
            m186xb7537db3(this.mContext, this.mNetworkStateReceiver);
            this.mNetworkStateReceiver = null;
        }
    }

    public void onResume() {
        start();
    }

    public void onPause() {
        stop();
    }

    public void onDestroy() {
        stop();
    }

    public NetworkUtils.NetworkType getNetworkType() {
        return this.mNetworkType;
    }

    public boolean isWifiOn() {
        return NetworkUtils.NetworkType.WIFI == this.mNetworkType;
    }

    public boolean isNetworkOn() {
        return NetworkUtils.NetworkType.NONE != this.mNetworkType;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_common_utility_AppLogNetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m185x9eb87b1a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_bytedance_common_utility_AppLogNetworkStatusMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m186xb7537db3(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

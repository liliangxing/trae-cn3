package com.bytedance.bdinstall.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NetworkStatusProvider {
    public static final String TAG = "NetworkStatusProvider ";
    private static volatile NetworkStatusProvider instance;
    private static volatile BroadcastReceiver receiver;
    private Context mContext;
    private static volatile NetworkUtils.NetworkType networkType = NetworkUtils.NetworkType.MOBILE;
    private static final AtomicInteger sInit = new AtomicInteger(0);

    public static NetworkStatusProvider getInstance(Context context) {
        if (instance == null) {
            synchronized (NetworkStatusProvider.class) {
                if (instance == null) {
                    instance = new NetworkStatusProvider(context);
                }
            }
        }
        return instance;
    }

    public static NetworkStatusProvider instance() {
        return instance;
    }

    private NetworkStatusProvider(Context context) {
        this.mContext = context;
        init();
    }

    public static void incrementReferenceCount() {
        sInit.incrementAndGet();
        DrLog.m139d("NetworkStatusProvider increment reference count");
    }

    private void init() {
        DrLog.m139d("NetworkStatusProvider init monitor...");
        networkType = NetworkUtils.getNetworkType(this.mContext);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        receiver = new BroadcastReceiver() { // from class: com.bytedance.bdinstall.util.NetworkStatusProvider.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                NetworkUtils.NetworkType unused = NetworkStatusProvider.networkType = NetworkUtils.getNetworkType(NetworkStatusProvider.this.mContext);
                DrLog.m139d("NetworkStatusProvider init broadcast receive that network type is " + NetworkStatusProvider.networkType.name());
            }
        };
        m154xf9eb9e8(this.mContext, receiver, intentFilter);
    }

    public NetworkUtils.NetworkType getNetworkType() {
        return networkType;
    }

    public synchronized void stop() {
        AtomicInteger atomicInteger = sInit;
        if (atomicInteger.get() == 1 && receiver != null) {
            m155x87a54101(this.mContext, receiver);
            receiver = null;
            atomicInteger.decrementAndGet();
            DrLog.m139d("NetworkStatusProvider stop monitor");
        } else if (atomicInteger.get() > 0) {
            atomicInteger.decrementAndGet();
            DrLog.m139d("NetworkStatusProvider decrement reference count");
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_bdinstall_util_NetworkStatusProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m154xf9eb9e8(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_bytedance_bdinstall_util_NetworkStatusProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m155x87a54101(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

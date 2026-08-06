package com.bytedance.push.helper;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.push.utils.Logger;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.message.AppProvider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NetWorkStatusMonitorHelper extends BroadcastReceiver {
    private static volatile NetWorkStatusMonitorHelper sInstance;
    private final String TAG = "NetWorkStatusMonitorHelper";
    private String mLastNetWorkStatus = "";
    private final Set<INetworkStatusListener> mNetworkStatusListeners = new HashSet();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface INetworkStatusListener {
        void onAvailableNetworkTypeChanged(String str, String str2);
    }

    public static NetWorkStatusMonitorHelper getInstance() {
        if (sInstance == null) {
            synchronized (NetWorkStatusMonitorHelper.class) {
                if (sInstance == null) {
                    sInstance = new NetWorkStatusMonitorHelper();
                }
            }
        }
        return sInstance;
    }

    private NetWorkStatusMonitorHelper() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        if (intent != null) {
            String action = intent.getAction();
            Logger.m268d("NetWorkStatusMonitorHelper", "[onReceive]action:" + action);
            if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action) || (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) == null) {
                return;
            }
            if (networkInfo.isConnected()) {
                if (TextUtils.equals(networkInfo.getTypeName(), this.mLastNetWorkStatus)) {
                    return;
                }
                Logger.m274i("NetWorkStatusMonitorHelper", "[onReceive]network status chang to " + networkInfo.getTypeName());
                synchronized (this.mNetworkStatusListeners) {
                    Iterator<INetworkStatusListener> it = this.mNetworkStatusListeners.iterator();
                    while (it.hasNext()) {
                        it.next().onAvailableNetworkTypeChanged(this.mLastNetWorkStatus, networkInfo.getTypeName());
                    }
                }
                this.mLastNetWorkStatus = networkInfo.getTypeName();
                return;
            }
            Logger.m274i("NetWorkStatusMonitorHelper", "[onReceive]find network disconnect:" + this.mLastNetWorkStatus);
            this.mLastNetWorkStatus = "";
        }
    }

    public void addNetworkStatusListener(INetworkStatusListener iNetworkStatusListener) {
        Logger.m274i("NetWorkStatusMonitorHelper", "[addNetworkStatusListener]listener:" + iNetworkStatusListener);
        if (iNetworkStatusListener == null) {
            return;
        }
        synchronized (this.mNetworkStatusListeners) {
            if (this.mNetworkStatusListeners.size() == 0) {
                Logger.m274i("NetWorkStatusMonitorHelper", "[addNetworkStatusListener]register BroadcastReceiver");
                register();
            }
            this.mNetworkStatusListeners.add(iNetworkStatusListener);
        }
    }

    public void removeNetworkStatusListener(INetworkStatusListener iNetworkStatusListener) {
        if (iNetworkStatusListener == null) {
            return;
        }
        synchronized (this.mNetworkStatusListeners) {
            this.mNetworkStatusListeners.remove(iNetworkStatusListener);
            if (this.mNetworkStatusListeners.size() == 0) {
                Logger.m274i("NetWorkStatusMonitorHelper", "[addNetworkStatusListener]unregister BroadcastReceiver");
                unregister();
            }
        }
    }

    private void register() {
        Logger.m274i("NetWorkStatusMonitorHelper", "[register]");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) AppProvider.getApp().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            this.mLastNetWorkStatus = activeNetworkInfo.getTypeName();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        m237x21d2942e(AppProvider.getApp(), this, intentFilter);
        Logger.m274i("NetWorkStatusMonitorHelper", "[register]finished register,mLastNetWorkStatus:" + this.mLastNetWorkStatus);
    }

    private void unregister() {
        Logger.m274i("NetWorkStatusMonitorHelper", "[unregister]");
        m238xdc4ba1c7(AppProvider.getApp(), this);
        this.mLastNetWorkStatus = "";
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_push_helper_NetWorkStatusMonitorHelper_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m237x21d2942e(Application application, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_bytedance_push_helper_NetWorkStatusMonitorHelper_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m238xdc4ba1c7(Application application, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        application.unregisterReceiver(broadcastReceiver);
    }
}

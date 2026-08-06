package com.bytedance.sdk.account.platform.onekey;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DefaultDataSubscriptionReceiver extends BroadcastReceiver {
    private static final String ACTION_DEFAULT_DATA_SUBSCRIPTION_CHANGED = "android.intent.action.ACTION_DEFAULT_DATA_SUBSCRIPTION_CHANGED";
    private static final String TAG = "DefaultDataSubReceiver";
    private static boolean isRegistered;
    private static DefaultDataSubscriptionReceiver mReceiver;

    public static void register(Context context) {
        if (isRegistered || context == null) {
            return;
        }
        Log.d(TAG, "register ");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_DEFAULT_DATA_SUBSCRIPTION_CHANGED);
        if (mReceiver == null) {
            mReceiver = new DefaultDataSubscriptionReceiver();
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                m1xc150118(context, mReceiver, intentFilter, 0);
            } else {
                m0xc150118(context, mReceiver, intentFilter);
            }
            isRegistered = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unregister(Context context) {
        if (mReceiver != null && isRegistered) {
            Log.d(TAG, "unregister ");
            try {
                m2x3fa67c31(context, mReceiver);
            } catch (Exception unused) {
            }
        }
        isRegistered = false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive " + intent.getAction());
        CommonUtils.cleanSimCache();
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_sdk_account_platform_onekey_DefaultDataSubscriptionReceiver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m0xc150118(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_sdk_account_platform_onekey_DefaultDataSubscriptionReceiver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m1xc150118(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
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
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, i);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter, i);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, i);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_bytedance_sdk_account_platform_onekey_DefaultDataSubscriptionReceiver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m2x3fa67c31(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}

package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes7.dex */
public class l {
    private static volatile Handler a;

    /* renamed from: a, reason: collision with other field name */
    private static final Object f898a = new Object();
    private static volatile Handler b;

    private static Handler b() {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return a;
    }

    public static Handler a() {
        if (b == null) {
            synchronized (f898a) {
                if (b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return b;
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return a(context, broadcastReceiver, intentFilter, (String) null, i);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i) {
        return a(context, broadcastReceiver, intentFilter, str, b(), i);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return a(context, broadcastReceiver, intentFilter, str, handler, 2);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, intentFilter, str, handler, i);
        }
        return INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, intentFilter, str, handler);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    public static Intent INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    public static Intent INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        }
    }
}

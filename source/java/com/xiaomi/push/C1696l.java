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

/* renamed from: com.xiaomi.push.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1696l {

    /* renamed from: a */
    private static volatile Handler f2809a;

    /* renamed from: a */
    private static final Object f2810a = new Object();

    /* renamed from: b */
    private static volatile Handler f2811b;

    /* renamed from: b */
    private static Handler m3451b() {
        if (f2809a == null) {
            synchronized (C1696l.class) {
                if (f2809a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    f2809a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f2809a;
    }

    /* renamed from: a */
    public static Handler m3450a() {
        if (f2811b == null) {
            synchronized (f2810a) {
                if (f2811b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    f2811b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f2811b;
    }

    /* renamed from: a */
    public static Intent m3446a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return m3447a(context, broadcastReceiver, intentFilter, (String) null, i);
    }

    /* renamed from: a */
    public static Intent m3447a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, int i) {
        return m3449a(context, broadcastReceiver, intentFilter, str, m3451b(), i);
    }

    /* renamed from: a */
    public static Intent m3448a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return m3449a(context, broadcastReceiver, intentFilter, str, handler, 2);
    }

    /* renamed from: a */
    public static Intent m3449a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return m3445xd413c1bf(context, broadcastReceiver, intentFilter, str, handler, i);
        }
        return m3444xd413c1bf(context, broadcastReceiver, intentFilter, str, handler);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    /* renamed from: INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m3444xd413c1bf(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
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
    /* renamed from: INVOKEVIRTUAL_com_xiaomi_push_l_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m3445xd413c1bf(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
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

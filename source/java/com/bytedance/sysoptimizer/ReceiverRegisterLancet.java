package com.bytedance.sysoptimizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.lang.reflect.Field;
import java.util.Arrays;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

@Skip({"com.bytedance.thanos+"})
/* loaded from: classes5.dex */
public class ReceiverRegisterLancet {
    public static String TAG = "ReceiverRegisterLancet";
    public static Handler sMainHandler;
    public static Handler sProxyHandler;
    public static volatile Handler sReceiverHandler;
    public static HandlerThread sReceiverHandlerThread;

    public static void initHandler() {
        if (sReceiverHandler == null) {
            synchronized (ReceiverRegisterLancet.class) {
                if (sReceiverHandler == null) {
                    HandlerThread handlerThread = new HandlerThread("ReceiverHandler");
                    sReceiverHandlerThread = handlerThread;
                    handlerThread.start();
                    sMainHandler = new Handler(Looper.getMainLooper());
                    sReceiverHandler = new Handler(sReceiverHandlerThread.getLooper()) { // from class: com.bytedance.sysoptimizer.ReceiverRegisterLancet.1
                        @Override // android.os.Handler
                        public void dispatchMessage(Message message) {
                            Runnable callback = message.getCallback();
                            if (callback != null) {
                                try {
                                    Log.i(ReceiverRegisterLancet.TAG, "onReceive runnable is going run on ReceiveHandler");
                                    callback.run();
                                    return;
                                } catch (Exception unused) {
                                    Log.i(ReceiverRegisterLancet.TAG, "onReceive runnable failed, try MainHandler again");
                                    ReceiverRegisterLancet.sMainHandler.post(callback);
                                    return;
                                }
                            }
                            super.dispatchMessage(message);
                        }
                    };
                }
            }
        }
    }

    public static void initProxyHandler() {
        if (sProxyHandler == null) {
            synchronized (ReceiverRegisterLancet.class) {
                sProxyHandler = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sysoptimizer.ReceiverRegisterLancet.2
                    private Handler handler;

                    private void init() {
                        try {
                            if (this.handler == null) {
                                Class<?> cls = Class.forName("android.app.ActivityThread");
                                Field declaredField = cls.getDeclaredField("mH");
                                declaredField.setAccessible(true);
                                Field declaredField2 = cls.getDeclaredField("sCurrentActivityThread");
                                declaredField2.setAccessible(true);
                                Object obj = declaredField2.get(null);
                                if (obj != null) {
                                    this.handler = (Handler) declaredField.get(obj);
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }

                    @Override // android.os.Handler
                    public boolean sendMessageAtTime(Message message, long j) {
                        ReceiverRegisterCrashOptimizer.BroadcastReceiverRegisterCallback receiverRegisterHandler = ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler();
                        if (receiverRegisterHandler != null) {
                            receiverRegisterHandler.prePostMessage(message);
                        }
                        init();
                        Handler handler = this.handler;
                        if (handler == null) {
                            return super.sendMessageAtTime(message, j);
                        }
                        return handler.sendMessageAtTime(message, j);
                    }
                };
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                initHandler();
                return INVOKEVIRTUAL_com_bytedance_sysoptimizer_ReceiverRegisterLancet_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver((Context) This.get(), broadcastReceiver, intentFilter, null, sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                initProxyHandler();
                return ContextCompat.registerReceiver((Context) This.get(), broadcastReceiver, intentFilter, null, sProxyHandler, 2);
            }
            return (Intent) Origin.call();
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
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                initHandler();
                return INVOKEVIRTUAL_com_bytedance_sysoptimizer_ReceiverRegisterLancet_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver((Context) This.get(), broadcastReceiver, intentFilter, null, sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                initProxyHandler();
                return ContextCompat.registerReceiver((Context) This.get(), broadcastReceiver, intentFilter, null, sProxyHandler, i);
            }
            return (Intent) Origin.call();
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, i);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            return (Intent) Origin.call();
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
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            return (Intent) Origin.call();
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        loge(broadcastReceiver, false);
        Origin.callVoid();
    }

    public static void loge(BroadcastReceiver broadcastReceiver, boolean z) {
        if (ReceiverRegisterCrashOptimizer.sReceiverLogInterface == null || !ReceiverRegisterCrashOptimizer.sReceiverLogInterface.enable()) {
            return;
        }
        String obj = broadcastReceiver != null ? broadcastReceiver.toString() : "";
        if (TextUtils.isEmpty(obj)) {
            logCat("dy_receiver_monitor", Arrays.toString(Thread.currentThread().getStackTrace()));
        }
        if (z) {
            ReceiverRegisterCrashOptimizer.sReceiverLogInterface.onRegister(obj);
        } else {
            ReceiverRegisterCrashOptimizer.sReceiverLogInterface.onUnRegister(obj);
        }
    }

    public static int logCat(String str, String str2) {
        return Log.e(str, str2);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.iab.omid.library.bytedance.b.b"})
    public static Intent INVOKEVIRTUAL_com_bytedance_sysoptimizer_ReceiverRegisterLancet_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
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
}

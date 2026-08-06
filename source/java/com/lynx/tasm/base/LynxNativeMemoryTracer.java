package com.lynx.tasm.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.File;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxNativeMemoryTracer {
    private static final String ACTION_REPORT = "LYNX_MEMORY_TRACING_REPORT";
    private static final String ACTION_START = "LYNX_MEMORY_TRACING_START";
    private static final String ACTION_STOP = "LYNX_MEMORY_TRACING_STOP";
    private static boolean sInstalled = false;
    private static int sMinWatchedSize = 1;
    private static int sNextReportIndex;
    private static boolean sStarted;

    private static native void nativeStartTracing(int i);

    private static native void nativeStopTracing();

    private static native void nativeWriteRecordsToFile(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class TracingBroadcastReceiver extends BroadcastReceiver {
        TracingBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().endsWith(LynxNativeMemoryTracer.ACTION_START)) {
                int intExtra = intent.getIntExtra("min_watched_size", -1);
                if (intExtra > 0) {
                    LynxNativeMemoryTracer.startTracing(intExtra);
                    return;
                } else {
                    LynxNativeMemoryTracer.startTracing();
                    return;
                }
            }
            if (intent.getAction().endsWith(LynxNativeMemoryTracer.ACTION_STOP)) {
                LynxNativeMemoryTracer.stopTracing();
            } else if (intent.getAction().endsWith(LynxNativeMemoryTracer.ACTION_REPORT)) {
                String stringExtra = intent.getStringExtra("report_dir");
                if (stringExtra == null) {
                    stringExtra = context.getExternalFilesDir(null).getPath() + "/memory-reports";
                }
                LynxNativeMemoryTracer.writeMemoryRecordsToFile(stringExtra);
            }
        }
    }

    public static void setup(Context context, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("min watched size should be greater than 0");
        }
        sMinWatchedSize = i;
        setup(context);
    }

    public static void setup(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(context.getPackageName() + ".LYNX_MEMORY_TRACING_START");
        intentFilter.addAction(context.getPackageName() + ".LYNX_MEMORY_TRACING_STOP");
        intentFilter.addAction(context.getPackageName() + ".LYNX_MEMORY_TRACING_REPORT");
        TracingBroadcastReceiver tracingBroadcastReceiver = new TracingBroadcastReceiver();
        if (Build.VERSION.SDK_INT >= 34 && context.getApplicationInfo().targetSdkVersion >= 34) {
            m2582x14b471d0(context, tracingBroadcastReceiver, intentFilter, 4);
        } else {
            m2581x14b471d0(context, tracingBroadcastReceiver, intentFilter);
        }
        sInstalled = true;
    }

    public static void writeMemoryRecordsToFile(String str) {
        if (sStarted) {
            if (str == null) {
                throw new NullPointerException("filePath is null");
            }
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                throw new IllegalArgumentException(str + " is not a directory");
            }
            if (!file.exists() && !file.mkdirs()) {
                throw new IllegalArgumentException("can not create directory '" + str + "'");
            }
            String str2 = file.getPath() + "/lynx-native-memory-report-" + sNextReportIndex;
            sNextReportIndex++;
            nativeWriteRecordsToFile(str2);
        }
    }

    public static void startTracing(int i) {
        if (sInstalled) {
            sNextReportIndex = 0;
            nativeStartTracing(i);
            sStarted = true;
        }
    }

    public static void startTracing() {
        startTracing(sMinWatchedSize);
    }

    public static void stopTracing() {
        if (sStarted) {
            nativeStopTracing();
            sStarted = false;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_lynx_tasm_base_LynxNativeMemoryTracer_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m2581x14b471d0(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    /* renamed from: INVOKEVIRTUAL_com_lynx_tasm_base_LynxNativeMemoryTracer_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m2582x14b471d0(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
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
}

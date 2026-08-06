package com.bytedance.sdk.xbridge.cn.system;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.sdk.xbridge.cn.system.AbsXGetDeviceStatsMethodIDL;
import com.bytedance.sdk.xbridge.cn.system.XGetDeviceStatsMethod;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: XGetDeviceStatsMethod.kt */
@XBridgeMethod(name = "x.getDeviceStats")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J+\u0010\u000f\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J&\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XGetDeviceStatsMethod;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL;", "()V", "CPU_DETECT_MIN_GAP", "", "PATH_PREFIX", "", "PATH_SUFFIX", "lastCpuDetectTs", "latestCpuUsage", "", "getAppUseMSTime", "getBatteryTemperature", "ctx", "Landroid/content/Context;", "getCpuUsage", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cpuUsage", "getDeviceUseMSTime", "getMemory", "Lcom/bytedance/sdk/xbridge/cn/system/XGetDeviceStatsMethod$MemoryMbInfo;", "context", "params", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL$XGetDeviceStatsParamModel;", "handle", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/system/AbsXGetDeviceStatsMethodIDL$XGetDeviceStatsResultModel;", "MemoryMbInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XGetDeviceStatsMethod extends AbsXGetDeviceStatsMethodIDL {
    private final long CPU_DETECT_MIN_GAP = 360;
    private final String PATH_PREFIX = "/sys/devices/system/cpu/cpu";
    private final String PATH_SUFFIX = "/cpufreq/stats/time_in_state";
    private long lastCpuDetectTs;
    private float latestCpuUsage;

    /* compiled from: XGetDeviceStatsMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/system/XGetDeviceStatsMethod$MemoryMbInfo;", "", "()V", "all", "", "getAll", "()F", "setAll", "(F)V", "limit", "getLimit", "setLimit", "rest", "getRest", "setRest", "use", "getUse", "setUse", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class MemoryMbInfo {
        private float all;
        private float limit;
        private float rest;
        private float use;

        public final float getAll() {
            return this.all;
        }

        public final void setAll(float f) {
            this.all = f;
        }

        public final float getUse() {
            return this.use;
        }

        public final void setUse(float f) {
            this.use = f;
        }

        public final float getRest() {
            return this.rest;
        }

        public final void setRest(float f) {
            this.rest = f;
        }

        public final float getLimit() {
            return this.limit;
        }

        public final void setLimit(float f) {
            this.limit = f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MemoryMbInfo getMemory(Context context, AbsXGetDeviceStatsMethodIDL.XGetDeviceStatsParamModel params) {
        Object systemService = context != null ? context.getSystemService("activity") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        MemoryMbInfo memoryMbInfo = new MemoryMbInfo();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        memoryMbInfo.setAll(Intrinsics.areEqual(params.getMemory_all(), true) ? ((float) memoryInfo.totalMem) / 1048576.0f : -2.0f);
        memoryMbInfo.setRest(Intrinsics.areEqual(params.getMemory_rest(), true) ? ((float) memoryInfo.availMem) / 1048576.0f : -2.0f);
        if (Intrinsics.areEqual(params.getMemory_use(), true)) {
            Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
            Intrinsics.checkNotNullExpressionValue(processMemoryInfo, "activityManager.getProce…ArrayOf(Process.myPid()))");
            if (!(processMemoryInfo.length == 0)) {
                memoryMbInfo.setUse(processMemoryInfo[0].getTotalPss() / 1024.0f);
            } else {
                memoryMbInfo.setUse(-1.0f);
            }
        } else {
            memoryMbInfo.setUse(-2.0f);
        }
        if (Intrinsics.areEqual(params.getMemory_limit(), true)) {
            memoryMbInfo.setLimit(activityManager.getLargeMemoryClass());
        } else {
            memoryMbInfo.setLimit(-2.0f);
        }
        return memoryMbInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getBatteryTemperature(Context ctx) {
        Intent m155x746c6a31;
        if (ctx == null || (m155x746c6a31 = m155x746c6a31(ctx, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        return m155x746c6a31.getIntExtra("temperature", 0) / 10.0f;
    }

    private final void getCpuUsage(final Function1<? super Float, Unit> callback) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastCpuDetectTs < this.CPU_DETECT_MIN_GAP) {
            callback.invoke(Float.valueOf(this.latestCpuUsage));
        } else {
            this.lastCpuDetectTs = currentTimeMillis;
            ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new Function0<Unit>() { // from class: com.bytedance.sdk.xbridge.cn.system.XGetDeviceStatsMethod$getCpuUsage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m915invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m915invoke() {
                    long appUseMSTime;
                    long deviceUseMSTime;
                    long appUseMSTime2;
                    long deviceUseMSTime2;
                    float f;
                    appUseMSTime = XGetDeviceStatsMethod.this.getAppUseMSTime();
                    Float valueOf = Float.valueOf(-1.0f);
                    if (appUseMSTime == -1) {
                        callback.invoke(valueOf);
                        return;
                    }
                    deviceUseMSTime = XGetDeviceStatsMethod.this.getDeviceUseMSTime();
                    if (deviceUseMSTime == -1) {
                        callback.invoke(valueOf);
                        return;
                    }
                    try {
                        Result.Companion companion = Result.Companion;
                        Thread.sleep(360L);
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    appUseMSTime2 = XGetDeviceStatsMethod.this.getAppUseMSTime();
                    if (appUseMSTime2 != -1) {
                        deviceUseMSTime2 = XGetDeviceStatsMethod.this.getDeviceUseMSTime();
                        if (deviceUseMSTime2 == -1) {
                            callback.invoke(valueOf);
                            return;
                        }
                        long j = deviceUseMSTime2 - deviceUseMSTime;
                        if (j > 0) {
                            XGetDeviceStatsMethod.this.latestCpuUsage = ((float) (appUseMSTime2 - appUseMSTime)) / ((float) j);
                            Function1<Float, Unit> function1 = callback;
                            f = XGetDeviceStatsMethod.this.latestCpuUsage;
                            function1.invoke(Float.valueOf(f));
                            return;
                        }
                        callback.invoke(valueOf);
                        return;
                    }
                    callback.invoke(valueOf);
                }
            }, 31, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getAppUseMSTime() {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            try {
                String readLine = bufferedReader2.readLine();
                Intrinsics.checkNotNullExpressionValue(readLine, "load");
                Object[] array = new Regex(" ").split(readLine, 0).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    long parseLong = (Long.parseLong(strArr[13]) + Long.parseLong(strArr[14])) * 10;
                    bufferedReader2.close();
                    return parseLong;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            } catch (Throwable unused) {
                bufferedReader = bufferedReader2;
                if (bufferedReader == null) {
                    return -1L;
                }
                bufferedReader.close();
                return -1L;
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007e, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long getDeviceUseMSTime() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long j = -1;
        loop0: for (int i = 0; i < availableProcessors; i++) {
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.PATH_PREFIX + i + this.PATH_SUFFIX), 50);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        Intrinsics.checkNotNullExpressionValue(readLine, "it");
                        if (readLine != null) {
                            if (readLine.length() == 0) {
                                break;
                            }
                            Object[] array = new Regex("\\s+").split(readLine, 0).toArray(new String[0]);
                            if (array == null) {
                                break loop0;
                            }
                            String[] strArr = (String[]) array;
                            if (strArr.length == 2) {
                                j += Long.parseLong(strArr[1]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
                try {
                    bufferedReader2.close();
                } catch (Throwable unused) {
                    return j;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return j / availableProcessors;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(final IBDXBridgeContext bridgeContext, final AbsXGetDeviceStatsMethodIDL.XGetDeviceStatsParamModel params, final CompletionBlock<AbsXGetDeviceStatsMethodIDL.XGetDeviceStatsResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: com.bytedance.sdk.xbridge.cn.system.XGetDeviceStatsMethod$handle$onResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                XGetDeviceStatsMethod.MemoryMbInfo memory;
                Activity ownerActivity = IBDXBridgeContext.this.getOwnerActivity();
                if (ownerActivity != null) {
                    CompletionBlock<AbsXGetDeviceStatsMethodIDL.XGetDeviceStatsResultModel> completionBlock = callback;
                    XGetDeviceStatsMethod xGetDeviceStatsMethod = this;
                    AbsXGetDeviceStatsMethodIDL.XGetDeviceStatsParamModel xGetDeviceStatsParamModel = params;
                    IBDXBridgeContext iBDXBridgeContext = IBDXBridgeContext.this;
                    XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXGetDeviceStatsMethodIDL.XGetDeviceStatsResultModel.class));
                    AbsXGetDeviceStatsMethodIDL.XGetDeviceStatsResultModel xGetDeviceStatsResultModel = (AbsXGetDeviceStatsMethodIDL.XGetDeviceStatsResultModel) createXModel;
                    memory = xGetDeviceStatsMethod.getMemory(ownerActivity, xGetDeviceStatsParamModel);
                    xGetDeviceStatsResultModel.setMemory_all(Float.valueOf(memory.getAll()));
                    xGetDeviceStatsResultModel.setMemory_use(Float.valueOf(memory.getUse()));
                    xGetDeviceStatsResultModel.setMemory_rest(Float.valueOf(memory.getRest()));
                    xGetDeviceStatsResultModel.setMemory_limit(Float.valueOf(memory.getLimit()));
                    xGetDeviceStatsResultModel.setCpu_usage(Float.valueOf(f));
                    xGetDeviceStatsResultModel.setTemperature(Float.valueOf(Intrinsics.areEqual(xGetDeviceStatsParamModel.getTemperature(), true) ? xGetDeviceStatsMethod.getBatteryTemperature(iBDXBridgeContext.getOwnerActivity()) : -2.0f));
                    CompletionBlock.DefaultImpls.onSuccess$default(completionBlock, (XBaseResultModel) createXModel, null, 2, null);
                }
            }
        };
        if (Intrinsics.areEqual(params.getCpu_usage(), true)) {
            getCpuUsage(function1);
        } else {
            function1.invoke(Float.valueOf(-2.0f));
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_bytedance_sdk_xbridge_cn_system_XGetDeviceStatsMethod_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m155x746c6a31(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
}

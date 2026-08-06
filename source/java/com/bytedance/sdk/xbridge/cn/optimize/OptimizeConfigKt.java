package com.bytedance.sdk.xbridge.cn.optimize;

import com.bytedance.common.utility.concurrent.TTThreadPoolExecutor;
import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OptimizeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0015\u001a\u00020\u0019H\u0000\u001a$\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 \"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0003\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0003\"\u0014\u0010\t\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0003\"\u0014\u0010\u000b\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0003\"\u0014\u0010\r\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0003\"\u0014\u0010\u000f\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0003\"\u0014\u0010\u0011\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0003\"\u001b\u0010\u0013\u001a\u00020\u00148@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"ALLOW_USE_CACHE", "", "getALLOW_USE_CACHE", "()Ljava/lang/String;", "ALL_SCHEMA", "CAN_RUN_IN_BACKGROUND_FIX", "getCAN_RUN_IN_BACKGROUND_FIX", "LATCH_SKIP_AUTH", "getLATCH_SKIP_AUTH", "LATCH_SKIP_BPEA", "getLATCH_SKIP_BPEA", "LOKI_JSB_LOG_DROP_SWITCH", "getLOKI_JSB_LOG_DROP_SWITCH", "LOKI_JSB_OPT_SWITCH", "getLOKI_JSB_OPT_SWITCH", "MIX_JSB_OPT_SWITCH", "getMIX_JSB_OPT_SWITCH", "XBRIDGE_MODEL_PROXY_ENHANCEMENT", "getXBRIDGE_MODEL_PROXY_ENHANCEMENT", "serialThreadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "getSerialThreadPool", "()Ljava/util/concurrent/ThreadPoolExecutor;", "serialThreadPool$delegate", "Lkotlin/Lazy;", "Lcom/bytedance/common/utility/concurrent/TTThreadPoolExecutor;", "getThreadOptType", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod$XBridgeThreadType;", "config", "", "Lcom/bytedance/sdk/xbridge/cn/optimize/ThreadOptConfig;", "call", "Lcom/bytedance/sdk/xbridge/cn/protocol/entity/BaseBridgeCall;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class OptimizeConfigKt {
    private static final String ALLOW_USE_CACHE = "allow_use_cache";
    public static final String ALL_SCHEMA = "bdx_thread_opt_all_schema";
    private static final String CAN_RUN_IN_BACKGROUND_FIX = "can_run_in_background_fix";
    private static final String LATCH_SKIP_AUTH = "latch_skip_auth";
    private static final String LATCH_SKIP_BPEA = "latch_skip_bpea";
    private static final String LOKI_JSB_LOG_DROP_SWITCH = "loki_jsb_log_drop_switch";
    private static final String LOKI_JSB_OPT_SWITCH = "loki_jsb_opt_switch";
    private static final String MIX_JSB_OPT_SWITCH = "mix_jsb_opt_switch";
    private static final String XBRIDGE_MODEL_PROXY_ENHANCEMENT = "xbridge_model_proxy_enhancement";
    private static final Lazy serialThreadPool$delegate = LazyKt.lazy(new Function0<TTThreadPoolExecutor>() { // from class: com.bytedance.sdk.xbridge.cn.optimize.OptimizeConfigKt$serialThreadPool$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TTThreadPoolExecutor m898invoke() {
            return OptimizeConfigKt.getSerialThreadPool();
        }
    });

    public static final String getLATCH_SKIP_BPEA() {
        return LATCH_SKIP_BPEA;
    }

    public static final String getLATCH_SKIP_AUTH() {
        return LATCH_SKIP_AUTH;
    }

    public static final String getMIX_JSB_OPT_SWITCH() {
        return MIX_JSB_OPT_SWITCH;
    }

    public static final String getLOKI_JSB_OPT_SWITCH() {
        return LOKI_JSB_OPT_SWITCH;
    }

    public static final String getLOKI_JSB_LOG_DROP_SWITCH() {
        return LOKI_JSB_LOG_DROP_SWITCH;
    }

    public static final String getCAN_RUN_IN_BACKGROUND_FIX() {
        return CAN_RUN_IN_BACKGROUND_FIX;
    }

    public static final String getXBRIDGE_MODEL_PROXY_ENHANCEMENT() {
        return XBRIDGE_MODEL_PROXY_ENHANCEMENT;
    }

    public static final String getALLOW_USE_CACHE() {
        return ALLOW_USE_CACHE;
    }

    public static final IDLXBridgeMethod.XBridgeThreadType getThreadOptType(List<ThreadOptConfig> list, BaseBridgeCall<?> baseBridgeCall) {
        boolean z;
        Intrinsics.checkNotNullParameter(baseBridgeCall, "call");
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ThreadOptConfig threadOptConfig = (ThreadOptConfig) it.next();
                HashSet<String> threadOptSchemas = threadOptConfig.getThreadOptSchemas();
                boolean z2 = false;
                if (threadOptSchemas != null) {
                    while (true) {
                        z = true;
                        for (String str : threadOptSchemas) {
                            if (Intrinsics.areEqual(str, ALL_SCHEMA)) {
                                break;
                            }
                            if (!StringsKt.contains$default(baseBridgeCall.getUrl(), str, false, 2, (Object) null)) {
                                z = false;
                            }
                        }
                    }
                } else {
                    z = true;
                }
                if (z) {
                    HashSet<String> syncMethods = threadOptConfig.getSyncMethods();
                    if (syncMethods != null && syncMethods.contains(baseBridgeCall.getMethodName())) {
                        return IDLXBridgeMethod.XBridgeThreadType.SYNC_THREAD;
                    }
                    HashSet<String> asyncMethods = threadOptConfig.getAsyncMethods();
                    if (asyncMethods != null && asyncMethods.contains(baseBridgeCall.getMethodName())) {
                        return IDLXBridgeMethod.XBridgeThreadType.ASYNC_THREAD;
                    }
                    HashSet<String> mainThreadMethods = threadOptConfig.getMainThreadMethods();
                    if (mainThreadMethods != null && mainThreadMethods.contains(baseBridgeCall.getMethodName())) {
                        return IDLXBridgeMethod.XBridgeThreadType.MAIN_THREAD;
                    }
                    HashSet<String> mainThreadOptMethods = threadOptConfig.getMainThreadOptMethods();
                    if (mainThreadOptMethods != null && mainThreadOptMethods.contains(baseBridgeCall.getMethodName())) {
                        z2 = true;
                    }
                    if (z2) {
                        return IDLXBridgeMethod.XBridgeThreadType.MAIN_THREAD_OPT;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: getSerialThreadPool, reason: collision with other method in class */
    public static final ThreadPoolExecutor m897getSerialThreadPool() {
        return (ThreadPoolExecutor) serialThreadPool$delegate.getValue();
    }

    public static final TTThreadPoolExecutor getSerialThreadPool() {
        return new TTThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new JSBDefaultThreadFactory("bdx_bridge_serial_executors"));
    }
}

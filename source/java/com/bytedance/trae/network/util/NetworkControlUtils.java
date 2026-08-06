package com.bytedance.trae.network.util;

import com.bytedance.ttnet.priority.ModePriorityManagement;
import com.bytedance.ttnet.priority.TTHttpCallPriorityControl;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkControlUtils.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0015JE\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00062&\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001dR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/network/util/NetworkControlUtils;", "", "<init>", "()V", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ttnet/priority/ModePriorityManagement;", "enableBootPathOpt", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getEnableBootPathOpt", "()Ljava/util/HashMap;", "enableBootPathOpt$delegate", "Lkotlin/Lazy;", "enableBootNqeOpt", "getEnableBootNqeOpt", "()I", "enableBootNqeOpt$delegate", "nqeflag", "", "startNQERequest", "", "needSwitchThread", "startSpeedStrategy", "key", "requestThrottleMap", EventConstants.PARAM_TIME_OUT, "(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/Integer;)V", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NetworkControlUtils {
    private static boolean nqeflag;
    public static final NetworkControlUtils INSTANCE = new NetworkControlUtils();
    private static final ConcurrentHashMap<String, ModePriorityManagement> cacheMap = new ConcurrentHashMap<>();

    /* renamed from: enableBootPathOpt$delegate, reason: from kotlin metadata */
    private static final Lazy enableBootPathOpt = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.network.util.NetworkControlUtils$$ExternalSyntheticLambda0
        public final Object invoke() {
            HashMap enableBootPathOpt_delegate$lambda$0;
            enableBootPathOpt_delegate$lambda$0 = NetworkControlUtils.enableBootPathOpt_delegate$lambda$0();
            return enableBootPathOpt_delegate$lambda$0;
        }
    });

    /* renamed from: enableBootNqeOpt$delegate, reason: from kotlin metadata */
    private static final Lazy enableBootNqeOpt = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.network.util.NetworkControlUtils$$ExternalSyntheticLambda1
        public final Object invoke() {
            int enableBootNqeOpt_delegate$lambda$1;
            enableBootNqeOpt_delegate$lambda$1 = NetworkControlUtils.enableBootNqeOpt_delegate$lambda$1();
            return Integer.valueOf(enableBootNqeOpt_delegate$lambda$1);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final int enableBootNqeOpt_delegate$lambda$1() {
        return 0;
    }

    public final void startNQERequest(boolean needSwitchThread) {
    }

    private NetworkControlUtils() {
    }

    public final HashMap<String, Integer> getEnableBootPathOpt() {
        return (HashMap) enableBootPathOpt.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap enableBootPathOpt_delegate$lambda$0() {
        return new HashMap();
    }

    public final int getEnableBootNqeOpt() {
        return ((Number) enableBootNqeOpt.getValue()).intValue();
    }

    public static /* synthetic */ void startNQERequest$default(NetworkControlUtils networkControlUtils, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        networkControlUtils.startNQERequest(z);
    }

    public final void startSpeedStrategy(String key, HashMap<String, Integer> requestThrottleMap, Integer timeout) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (requestThrottleMap == null || timeout == null) {
            return;
        }
        timeout.intValue();
        if (requestThrottleMap.isEmpty() || timeout.intValue() <= 0) {
            return;
        }
        ConcurrentHashMap<String, ModePriorityManagement> concurrentHashMap = cacheMap;
        ModePriorityManagement modePriorityManagement = concurrentHashMap.get(key);
        if (modePriorityManagement == null) {
            modePriorityManagement = new ModePriorityManagement();
            modePriorityManagement.setStateName(key);
            modePriorityManagement.setDelayDisableTimeMs(timeout.intValue());
            Map<String, Integer> mutableMap = MapsKt.toMutableMap(requestThrottleMap);
            if (mutableMap == null) {
                mutableMap = MapsKt.emptyMap();
            }
            modePriorityManagement.initRequestSpeedController(mutableMap, SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), SetsKt.emptySet(), -1L, -1L, -1L, -1L);
            concurrentHashMap.put(key, modePriorityManagement);
        }
        TTHttpCallPriorityControl.getInstance().startAppStateFromCustom(modePriorityManagement);
    }
}

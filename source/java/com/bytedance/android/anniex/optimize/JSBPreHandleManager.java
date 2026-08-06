package com.bytedance.android.anniex.optimize;

import android.util.LruCache;
import bolts.Task;
import com.bytedance.android.anniex.optimize.prehandle.model.PreHandleConfig;
import com.bytedance.android.anniex.optimize.prehandle.model.PreHandleResult;
import com.bytedance.android.anniex.optimize.prehandle.task.LynxPreHandleTask;
import com.bytedance.android.anniex.optimize.prehandle.task.WebPreHandleTask;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: JSBPreHandleManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0019H\u0002J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007J\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ&\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R'\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/bytedance/android/anniex/optimize/JSBPreHandleManager;", "", "()V", "defaultOverTime", "", "preHandleCache", "Landroid/util/LruCache;", "", "Lcom/bytedance/android/anniex/optimize/prehandle/model/PreHandleResult;", "getPreHandleCache", "()Landroid/util/LruCache;", "preHandleCache$delegate", "Lkotlin/Lazy;", "preHandleConfig", "", "Lcom/bytedance/android/anniex/optimize/prehandle/model/PreHandleConfig;", "preHandleEnable", "", "allowUseCache", "method", StreamTrafficObservable.STREAM_URL, "cacheJSBResult", "", "sessionId", StrategyConstants.RESULT, "", "getPreHandleMethod", "getPreHandleResult", "setHandleConfig", "startPreHandle", "bid", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class JSBPreHandleManager {
    public static final JSBPreHandleManager INSTANCE = new JSBPreHandleManager();
    private static final int defaultOverTime = 10000;

    /* renamed from: preHandleCache$delegate, reason: from kotlin metadata */
    private static final Lazy preHandleCache = LazyKt.lazy(new Function0<LruCache<String, PreHandleResult>>() { // from class: com.bytedance.android.anniex.optimize.JSBPreHandleManager$preHandleCache$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LruCache<String, PreHandleResult> m3396invoke() {
            return new LruCache<>(1024);
        }
    });
    private static List<PreHandleConfig> preHandleConfig;
    private static boolean preHandleEnable;

    private JSBPreHandleManager() {
    }

    private final LruCache<String, PreHandleResult> getPreHandleCache() {
        return (LruCache) preHandleCache.getValue();
    }

    public final void setHandleConfig(boolean preHandleEnable2, List<PreHandleConfig> preHandleConfig2) {
        preHandleEnable = preHandleEnable2;
        preHandleConfig = preHandleConfig2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> getPreHandleMethod(String url) {
        List<PreHandleConfig> list = preHandleConfig;
        if (list != null) {
            for (PreHandleConfig preHandleConfig2 : list) {
                if (StringsKt.contains$default(url, preHandleConfig2.getOptSchema(), false, 2, (Object) null)) {
                    return CollectionsKt.toList(preHandleConfig2.getPreHandleMethodsWithOutParam());
                }
            }
        }
        return null;
    }

    public final boolean allowUseCache(String method, String url) {
        List<PreHandleConfig> list;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        if (preHandleEnable && (list = preHandleConfig) != null) {
            for (PreHandleConfig preHandleConfig2 : list) {
                if (StringsKt.contains$default(url, preHandleConfig2.getOptSchema(), false, 2, (Object) null) && preHandleConfig2.getPreHandleMethodsWithOutParam().contains(method)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Object getPreHandleResult(String sessionId, String method) {
        PreHandleResult preHandleResult;
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(method, "method");
        if (preHandleEnable && (preHandleResult = getPreHandleCache().get(sessionId)) != null && System.currentTimeMillis() - preHandleResult.getCreateTimeStamp() < defaultOverTime) {
            return preHandleResult.getResult().get(method);
        }
        return null;
    }

    public final void startPreHandle(final String sessionId, final String bid, final String url, final PlatformType platformType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        if (preHandleEnable) {
            Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.optimize.JSBPreHandleManager$startPreHandle$1

                /* compiled from: JSBPreHandleManager.kt */
                @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[PlatformType.values().length];
                        try {
                            iArr[PlatformType.WEB.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[PlatformType.LYNX.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[PlatformType.WORKER.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // java.util.concurrent.Callable
                public final Unit call() {
                    List<String> preHandleMethod;
                    Unit unit;
                    List<String> preHandleMethod2;
                    int i = WhenMappings.$EnumSwitchMapping$0[platformType.ordinal()];
                    if (i == 1) {
                        preHandleMethod = JSBPreHandleManager.INSTANCE.getPreHandleMethod(url);
                        if (preHandleMethod == null) {
                            return null;
                        }
                        String str = bid;
                        String str2 = sessionId;
                        Map<String, JSONObject> preHandleMethod3 = new WebPreHandleTask(str).preHandleMethod(preHandleMethod);
                        if (preHandleMethod3 == null) {
                            return null;
                        }
                        JSBPreHandleManager.INSTANCE.cacheJSBResult(str2, preHandleMethod3);
                        unit = Unit.INSTANCE;
                    } else if (i == 2) {
                        preHandleMethod2 = JSBPreHandleManager.INSTANCE.getPreHandleMethod(url);
                        if (preHandleMethod2 == null) {
                            return null;
                        }
                        String str3 = bid;
                        String str4 = sessionId;
                        Map<String, Object> preHandleMethod4 = new LynxPreHandleTask(str3).preHandleMethod(preHandleMethod2);
                        if (preHandleMethod4 == null) {
                            return null;
                        }
                        JSBPreHandleManager.INSTANCE.cacheJSBResult(str4, preHandleMethod4);
                        unit = Unit.INSTANCE;
                    } else {
                        return Unit.INSTANCE;
                    }
                    return unit;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void cacheJSBResult(String sessionId, Map<String, ? extends Object> result) {
        getPreHandleCache().put(sessionId, new PreHandleResult(System.currentTimeMillis(), result));
    }
}

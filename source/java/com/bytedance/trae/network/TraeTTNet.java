package com.bytedance.trae.network;

import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.trae.network.ttnet.ApiUrlParamsProvider;
import com.bytedance.trae.network.ttnet.TTNetExt;
import com.bytedance.trae.platform.model.HttpEnvConfig;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeTTNet.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0013J\u0016\u0010\u0017\u001a\u00020\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0010J\u0014\u0010\u001c\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001eJ\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ*\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0!j\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\"2\u0006\u0010#\u001a\u00020$J&\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fJ\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006-"}, d2 = {"Lcom/bytedance/trae/network/TraeTTNet;", "", "<init>", "()V", "httpEnv", "Lcom/bytedance/trae/platform/model/HttpEnvConfig;", "getHttpEnv", "()Lcom/bytedance/trae/platform/model/HttpEnvConfig;", EventConstants.PARAM_SOURCE_INIT, "", "configServers", "", "", "serviceDomainMap", "", "enableAntiSniffing", "", "interceptors", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "([Ljava/lang/String;Ljava/util/Map;ZLjava/util/List;)V", "addInterceptor", "interceptor", "addInterceptors", "addConnectionTypeListener", "listener", "Lcom/bytedance/trae/network/ConnectionTypeListener;", "isCronetInitSuccess", "runAfterCronetInit", "action", "Lkotlin/Function0;", "removeConnectionTypeListener", "getAppLogExtraParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "level", "", "updateHttpEnv", "boeEnable", "boeEnv", "ppeEnable", "ppeEnv", "getOpaqueDataEnable", "updateOpaqueDataEnable", "enable", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeTTNet {
    public static final TraeTTNet INSTANCE = new TraeTTNet();

    private TraeTTNet() {
    }

    public final HttpEnvConfig getHttpEnv() {
        return DevConfig.INSTANCE.initHttpEnv();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(TraeTTNet traeTTNet, String[] strArr, Map map, boolean z, List list, int i, Object obj) {
        if ((i & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        traeTTNet.init(strArr, map, z, list);
    }

    public final void init(String[] configServers, Map<String, String> serviceDomainMap, boolean enableAntiSniffing, List<? extends Interceptor> interceptors) {
        Intrinsics.checkNotNullParameter(configServers, "configServers");
        Intrinsics.checkNotNullParameter(serviceDomainMap, "serviceDomainMap");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        TTNetExt.INSTANCE.init(configServers, serviceDomainMap, enableAntiSniffing);
    }

    public final void addInterceptor(Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        RetrofitUtils.addInterceptor(interceptor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addInterceptors$default(TraeTTNet traeTTNet, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        traeTTNet.addInterceptors(list);
    }

    public final void addInterceptors(List<? extends Interceptor> interceptors) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Iterator<T> it = interceptors.iterator();
        while (it.hasNext()) {
            RetrofitUtils.addInterceptor((Interceptor) it.next());
        }
    }

    public final void addConnectionTypeListener(ConnectionTypeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TTNetExt.INSTANCE.getConnectionTypeListeners().add(listener);
    }

    public final boolean isCronetInitSuccess() {
        return TTNetInitMetrics.isCronetInitSuccess();
    }

    public final void runAfterCronetInit(final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (isCronetInitSuccess()) {
            action.invoke();
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        TTNetInitMetrics.setTTNetInitSuccessCallback(new TTNetInitMetrics.TTNetInitCallback() { // from class: com.bytedance.trae.network.TraeTTNet$$ExternalSyntheticLambda0
            public final void ttnetInitSuccessCallback() {
                TraeTTNet.runAfterCronetInit$lambda$1(atomicBoolean, action);
            }
        });
        if (isCronetInitSuccess() && atomicBoolean.compareAndSet(false, true)) {
            action.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void runAfterCronetInit$lambda$1(AtomicBoolean atomicBoolean, Function0 function0) {
        if (atomicBoolean.compareAndSet(false, true)) {
            function0.invoke();
        }
    }

    public final void removeConnectionTypeListener(ConnectionTypeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TTNetExt.INSTANCE.getConnectionTypeListeners().remove(listener);
    }

    public final HashMap<String, String> getAppLogExtraParams(int level) {
        return ApiUrlParamsProvider.INSTANCE.getCommonQueryParams(level);
    }

    public final void updateHttpEnv(boolean boeEnable, String boeEnv, boolean ppeEnable, String ppeEnv) {
        Intrinsics.checkNotNullParameter(boeEnv, "boeEnv");
        Intrinsics.checkNotNullParameter(ppeEnv, "ppeEnv");
        DevConfig.INSTANCE.updateHttpEnv(boeEnable, boeEnv, ppeEnable, ppeEnv);
    }

    public final boolean getOpaqueDataEnable() {
        return DevConfig.INSTANCE.getOpaqueDataEnable();
    }

    public final void updateOpaqueDataEnable(boolean enable) {
        DevConfig.INSTANCE.updateOpaqueDataEnable(enable);
    }
}

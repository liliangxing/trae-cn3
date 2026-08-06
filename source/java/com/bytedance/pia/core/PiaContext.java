package com.bytedance.pia.core;

import android.content.Context;
import android.net.Uri;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.monitor.IPiaMetricsObserver;
import com.bytedance.pia.core.api.monitor.IPiaTracer;
import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.security.ISecurityDelegate;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.bridge.BridgeRegistry;
import com.bytedance.pia.core.metrics.PiaMetrics;
import com.bytedance.pia.core.metrics.TracerAdapter;
import com.bytedance.pia.core.misc.UserAgent;
import com.bytedance.pia.core.runtime.BaseContext;
import com.bytedance.pia.core.service.EnvService;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.storage.IPageStorage;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.pia.core.tracing.Tracing;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.UrlUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaContext extends BaseContext {
    private static Context APPLICATION_CONTEXT;
    private final Config config;
    private final Object customContext;
    private final Map<String, ?> globalProps;
    private final PiaMetrics metrics;
    private final String name;
    private final String namespace;
    private final String normalizeUrl;
    private final OnlineTracing onlineTrace;
    private final Uri originUrl;
    private final IPageStorage pageStorage;
    private final IResourceLoader resource;
    private final IPiaRetrofit retrofit;
    private final ISecurityDelegate securityDelegate;
    private final Map<String, String> sensitiveHeaders;
    private final IPiaTracer tracer;
    private final String userAgent;
    private final BridgeRegistry bridgeRegistry = new BridgeRegistry();
    private final Tracing trace = new Tracing();

    public static Context getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    public static void setApplicationContext(Context context) {
        APPLICATION_CONTEXT = context.getApplicationContext();
    }

    public final Config getConfig() {
        return this.config;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final String getName() {
        return this.name;
    }

    public final Uri getOriginUrl() {
        return this.originUrl;
    }

    public final String getNormalizeUrl() {
        return this.normalizeUrl;
    }

    public final BridgeRegistry getBridgeRegistry() {
        return this.bridgeRegistry;
    }

    public final IResourceLoader getResource() {
        return this.resource;
    }

    public final IPiaRetrofit getRetrofit() {
        return this.retrofit;
    }

    public final PiaMetrics getMetrics() {
        return this.metrics;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public final Object getCustomContext() {
        return this.customContext;
    }

    public final Map<String, ?> getGlobalProps() {
        return this.globalProps;
    }

    public final Map<String, String> getSensitiveHeaders() {
        return this.sensitiveHeaders;
    }

    public final ISecurityDelegate getSecurityDelegate() {
        return this.securityDelegate;
    }

    public final Tracing getTrace() {
        return this.trace;
    }

    public final OnlineTracing getOnlineTrace() {
        return this.onlineTrace;
    }

    public final IPageStorage getPageStorage() {
        return this.pageStorage;
    }

    public final IPiaTracer getTracer() {
        return this.tracer;
    }

    public PiaContext(Uri uri, String str, final String str2, Object obj, IResourceLoader iResourceLoader, IPiaRetrofit iPiaRetrofit, String str3, Config config, Map<String, ?> map, IPiaTracer iPiaTracer, Map<String, String> map2, ISecurityDelegate iSecurityDelegate) {
        getTrace().traceWithArgs(EventName.NavigateStart).appendArg("url", uri.toString()).flush();
        this.config = config;
        this.namespace = str2;
        this.name = str;
        if (uri.getQueryParameterNames().contains("_pia_")) {
            this.originUrl = uri;
        } else {
            this.originUrl = UrlUtils.compatV2(uri);
        }
        this.normalizeUrl = UrlUtils.normalizeUrl(uri);
        this.customContext = obj;
        this.resource = iResourceLoader;
        this.retrofit = iPiaRetrofit;
        PiaMetrics piaMetrics = new PiaMetrics(uri.toString());
        this.metrics = piaMetrics;
        put(piaMetrics);
        this.globalProps = map;
        this.sensitiveHeaders = map2;
        this.securityDelegate = iSecurityDelegate;
        this.pageStorage = IPageStorage.create(str);
        this.tracer = new TracerAdapter(iPiaTracer);
        this.onlineTrace = new OnlineTracing(str);
        if (str3 == null) {
            this.userAgent = UserAgent.getDefault();
        } else {
            this.userAgent = UserAgent.getDefault() + " " + str3;
        }
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.PiaContext$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PiaContext.this.m731lambda$new$0$combytedancepiacorePiaContext(str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-bytedance-pia-core-PiaContext, reason: not valid java name */
    public /* synthetic */ void m731lambda$new$0$combytedancepiacorePiaContext(String str) {
        IFactory<Set<PiaMethod<?, ?>>> piaMethodsFactory = PiaEnv.Default.getPiaMethodsFactory();
        initializeBridge(piaMethodsFactory);
        IFactory<Set<PiaMethod<?, ?>>> piaMethodsFactory2 = EnvService.getInstance().getEnv(str).getPiaMethodsFactory();
        if (piaMethodsFactory2 != piaMethodsFactory) {
            initializeBridge(piaMethodsFactory2);
        }
        List<IFactory<IPiaMetricsObserver>> piaMetricsObserverList = PiaEnv.Default.getPiaMetricsObserverList();
        initializeMetrics(piaMetricsObserverList);
        List<IFactory<IPiaMetricsObserver>> piaMetricsObserverListFactory = EnvService.getInstance().getEnv(str).getPiaMetricsObserverListFactory();
        if (piaMetricsObserverListFactory != piaMetricsObserverList) {
            initializeMetrics(piaMetricsObserverListFactory);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0014 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initializeBridge(IFactory<Set<PiaMethod<?, ?>>> iFactory) {
        Set<PiaMethod<?, ?>> create;
        if (iFactory != null) {
            try {
                create = iFactory.create(this.customContext);
            } catch (Throwable th) {
                Logger.m179e("[Runtime] create bridge method error:", th);
            }
            if (create != null) {
                return;
            }
            Iterator<PiaMethod<?, ?>> it = create.iterator();
            while (it.hasNext()) {
                this.bridgeRegistry.register(it.next());
            }
            return;
        }
        create = null;
        if (create != null) {
        }
    }

    private void initializeMetrics(List<IFactory<IPiaMetricsObserver>> list) {
        if (list == null) {
            return;
        }
        Iterator<IFactory<IPiaMetricsObserver>> it = list.iterator();
        while (it.hasNext()) {
            try {
                IPiaMetricsObserver create = it.next().create(this.customContext);
                if (create != null) {
                    this.metrics.addObserver(create);
                }
            } catch (Throwable th) {
                Logger.m179e("[Runtime] create MetricsObserver error:", th);
            }
        }
    }
}

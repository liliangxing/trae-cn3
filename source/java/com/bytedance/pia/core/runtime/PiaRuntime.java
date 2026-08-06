package com.bytedance.pia.core.runtime;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.monitor.IPiaTracer;
import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.security.ISecurityDelegate;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.bridge.PiaBridge;
import com.bytedance.pia.core.metrics.TraceEvent;
import com.bytedance.pia.core.service.EnvService;
import com.bytedance.pia.core.service.PiaLifeCycleService;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.DefaultResourceLoader;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.UrlUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaRuntime extends PiaContext {
    private static final String CTX_KEY_PIA_RUNTIME = "ctx-pia-runtime";

    @Deprecated
    public static final String EVENT_ON_BIND_BRIDGE_HANDLE = "event-on-bind-bridge-handle";
    public static final String EVENT_ON_HTML_ERROR = "event-on-html-error";
    public static final String EVENT_ON_HTML_READY = "event-on-html-ready";
    public static final String EVENT_ON_MANIFEST_ERROR = "event-on-manifest-error";
    public static final String EVENT_ON_MANIFEST_IN_HTML_READY = "event-on-manifest-in-html-ready";
    public static final String EVENT_ON_MANIFEST_READY = "event-on-manifest-ready";
    public static final String EVENT_ON_WORKER_LOG = "event-on-worker-log";
    public static final String SCHEMA_V1 = "__pia_manifest__";
    public static final String SCHEMA_V2 = "_pia_";
    public static final String USER_AGENT = "PIA/2.0.0";
    private volatile IPiaContext globalContext;
    private final AtomicBoolean isInitialized;
    private final AtomicBoolean isOnLoadFinished;
    private final AtomicBoolean isOnLoadStarted;
    private final AtomicBoolean isReleased;
    private final AtomicBoolean isViewBound;
    private final boolean isWarmup;
    private final ConcurrentLinkedQueue<PiaPlugin> plugins;
    private final PiaBridge renderBridge;
    private volatile WeakReference<View> renderView;
    private long startTime;

    public View getRenderView() {
        if (this.renderView != null) {
            return this.renderView.get();
        }
        return null;
    }

    public PiaBridge getRenderBridge() {
        return this.renderBridge;
    }

    public boolean isWarmup() {
        return this.isWarmup;
    }

    public boolean isSchemeV2() {
        return !getConfig().isEmptyForV1();
    }

    public IPiaContext getGlobalContext() {
        return this.globalContext;
    }

    public void setGlobalContext(IPiaContext iPiaContext) {
        this.globalContext = iPiaContext;
        iPiaContext.put(this, CTX_KEY_PIA_RUNTIME);
    }

    public static PiaRuntime getRuntime(IPiaContext iPiaContext) {
        Object obj = iPiaContext.get(CTX_KEY_PIA_RUNTIME);
        if (obj instanceof PiaRuntime) {
            return (PiaRuntime) obj;
        }
        return null;
    }

    protected PiaRuntime(Uri uri, String str, String str2, Object obj, boolean z, IResourceLoader iResourceLoader, IPiaRetrofit iPiaRetrofit, String str3, Config config, Map<String, ?> map, IPiaTracer iPiaTracer, Map<String, String> map2, ISecurityDelegate iSecurityDelegate) {
        super(uri, str, str2, obj, iResourceLoader, iPiaRetrofit, str3, config, map, iPiaTracer, map2, iSecurityDelegate);
        this.plugins = new ConcurrentLinkedQueue<>();
        this.renderView = null;
        this.renderBridge = new PiaBridge(PiaMethod.Scope.Render, this, getBridgeRegistry());
        this.isInitialized = new AtomicBoolean(false);
        this.isViewBound = new AtomicBoolean(false);
        this.isOnLoadStarted = new AtomicBoolean(false);
        this.isOnLoadFinished = new AtomicBoolean(false);
        this.isReleased = new AtomicBoolean(false);
        this.globalContext = null;
        this.isWarmup = z;
        Logger.m181i("[Runtime] created runtime. url=" + uri);
        this.startTime = System.currentTimeMillis();
        getTracer().report(TraceEvent.INITIALIZE_END, this.startTime);
    }

    @Override // com.bytedance.pia.core.runtime.BaseContext, com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        if (!this.isReleased.compareAndSet(false, true)) {
            Logger.m178e("[Runtime] release more than once!");
            return;
        }
        this.globalContext.remove(CTX_KEY_PIA_RUNTIME);
        this.globalContext = null;
        super.release();
        Iterator<PiaPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.plugins.clear();
        getRenderBridge().close();
        Logger.m181i("[Runtime] release runtime. url=" + getOriginUrl());
    }

    public void installPlugin(Class<? extends PiaPlugin> cls) {
        installPlugin(cls, null);
    }

    public void installPlugin(Class<? extends PiaPlugin> cls, Object obj) {
        PiaPlugin newInstance;
        if (this.isInitialized.get()) {
            Logger.m178e("[Runtime] can not install plugin after initialized!");
            return;
        }
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] call installPlugin after release.");
            return;
        }
        try {
            if (obj == null) {
                newInstance = cls.getConstructor(PiaRuntime.class).newInstance(this);
            } else {
                newInstance = cls.getConstructor(PiaRuntime.class, obj.getClass()).newInstance(this, obj);
            }
            if (get(newInstance.getName()) != null) {
                Logger.m181i("[Runtime] duplicate plugin registered, name=" + newInstance.getName());
                return;
            }
            put(newInstance, newInstance.getName());
            this.plugins.add(newInstance);
            Logger.m181i("[Runtime] install plugin success, name=" + newInstance.getName());
        } catch (Throwable th) {
            Logger.m179e("[Runtime] install plugin error:", th);
        }
    }

    public PiaPlugin getPlugin(String str) {
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] call getPlugin after release.");
            return null;
        }
        if (str != null && !str.isEmpty()) {
            Object obj = get(str);
            if (obj instanceof PiaPlugin) {
                return (PiaPlugin) obj;
            }
        }
        return null;
    }

    public void sendEvent(String str, Object... objArr) {
        if (!this.isInitialized.get()) {
            Logger.m178e("[Runtime] can not send event before initialize!");
            return;
        }
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] can not send event after released!");
            return;
        }
        Iterator<PiaPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            PiaPlugin next = it.next();
            try {
                next.onEvent(str, objArr);
            } catch (Throwable th) {
                Logger.m179e("[Runtime] " + next.getName() + " onEvent error:", th);
            }
        }
    }

    public boolean isInitialized() {
        return this.isInitialized.get();
    }

    public void initialize() {
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] call initialize after release.");
            return;
        }
        if (!this.isInitialized.compareAndSet(false, true)) {
            Logger.m178e("[Runtime] initialize more than once!");
            return;
        }
        Iterator<PiaPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            PiaPlugin next = it.next();
            try {
                next.initialize();
            } catch (Throwable th) {
                Logger.m179e("[Runtime] " + next.getName() + "initialize error:", th);
                this.plugins.remove(next);
            }
        }
    }

    public void onBindView(View view) {
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] call onBindView after release.");
            return;
        }
        if (!this.isViewBound.compareAndSet(false, true)) {
            Logger.m178e("[Runtime] onBindView more than once!");
            return;
        }
        if (view instanceof WebView) {
            getMetrics().setWebView((WebView) view);
        }
        this.renderView = new WeakReference<>(view);
        Iterator<PiaPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            PiaPlugin next = it.next();
            try {
                next.onBindView(view);
            } catch (Throwable th) {
                Logger.m179e("[Runtime] " + next.getName() + " onBindView error:", th);
            }
        }
    }

    public void onLoadStarted() {
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] call onLoadStarted after release.");
            return;
        }
        if (!this.isOnLoadStarted.compareAndSet(false, true)) {
            Logger.m178e("[Runtime] onLoadStarted more than once!");
            return;
        }
        Iterator<PiaPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            PiaPlugin next = it.next();
            try {
                next.onLoadStarted();
            } catch (Throwable th) {
                Logger.m179e("[Runtime] " + next.getName() + " onLoadStarted error:", th);
            }
        }
    }

    public void onLoadFinished() {
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] call onLoadFinished after release.");
            return;
        }
        if (!this.isOnLoadFinished.compareAndSet(false, true)) {
            Logger.m178e("[Runtime] onLoadFinished more than once!");
            return;
        }
        getMetrics().reportPvEvent();
        getOnlineTrace().addDuration(".pf", System.currentTimeMillis() - this.startTime);
        Iterator<PiaPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            PiaPlugin next = it.next();
            try {
                next.onLoadFinished();
            } catch (Throwable th) {
                Logger.m179e("[Runtime] " + next.getName() + " onLoadFinished error:", th);
            }
        }
    }

    public boolean shouldHandleResource(Uri uri) {
        if (!UrlUtils.isHttp(uri)) {
            return false;
        }
        if (uri.getBooleanQueryParameter(SCHEMA_V1, false) || uri.getBooleanQueryParameter("_pia_", false)) {
            return true;
        }
        return Settings.get().getIsPiaQueryDisable() && TextUtils.equals(uri.getHost(), getOriginUrl().getHost()) && TextUtils.equals(uri.getPath(), getOriginUrl().getPath());
    }

    public IResourceResponse onBeforeLoadResource(IResourceRequest iResourceRequest) {
        IResourceResponse onBeforeLoadResource;
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] call onBeforeLoadResource after release.");
            return null;
        }
        Iterator<PiaPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            PiaPlugin next = it.next();
            try {
                onBeforeLoadResource = next.onBeforeLoadResource(iResourceRequest);
            } catch (Throwable th) {
                Logger.m179e("[Runtime] " + next.getName() + " error:", th);
            }
            if (onBeforeLoadResource != null) {
                Logger.m181i("[Runtime] " + next.getName() + " intercepted resource loading, url=" + iResourceRequest.getUrl());
                return onBeforeLoadResource;
            }
            continue;
        }
        return null;
    }

    public IResourceResponse onAfterLoadResource(IResourceRequest iResourceRequest, IResourceResponse iResourceResponse) {
        IResourceResponse iResourceResponse2;
        Throwable th;
        if (this.isReleased.get()) {
            Logger.m178e("[Runtime] call onAfterLoadResource after release.");
            return iResourceResponse;
        }
        Iterator<PiaPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            PiaPlugin next = it.next();
            try {
                iResourceResponse2 = next.onAfterLoadResource(iResourceRequest, iResourceResponse);
                if (iResourceResponse2 != iResourceResponse) {
                    try {
                        Logger.m181i("[Runtime] " + next.getName() + " edited resource response, url=" + iResourceRequest.getUrl());
                    } catch (Throwable th2) {
                        th = th2;
                        Logger.m179e("[Runtime] " + next.getName() + " error:", th);
                        iResourceResponse = iResourceResponse2;
                    }
                }
            } catch (Throwable th3) {
                iResourceResponse2 = iResourceResponse;
                th = th3;
            }
            iResourceResponse = iResourceResponse2;
        }
        return iResourceResponse;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Builder {
        private Uri originUri;
        private String namespace = null;
        private String url = null;
        private Object customContext = null;
        private boolean isWarmup = false;
        private Config config = null;
        private String name = null;

        public Builder setNamespace(String str) {
            this.namespace = str;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setCustomContext(Object obj) {
            this.customContext = obj;
            return this;
        }

        public Builder setIsWarmup(boolean z) {
            this.isWarmup = z;
            return this;
        }

        public Builder setConfig(Config config) {
            this.config = config;
            return this;
        }

        public String buildName() {
            if (TextUtils.isEmpty(this.url)) {
                return null;
            }
            if (!Settings.get().getIsPiaQueryDisable() && !this.url.contains(PiaRuntime.SCHEMA_V1) && !this.url.contains("_pia_")) {
                return null;
            }
            String str = this.name;
            if (str != null) {
                return str;
            }
            Uri parse = Uri.parse(this.url);
            this.originUri = parse;
            String normalizeUrl = UrlUtils.normalizeUrl(parse, null);
            this.name = normalizeUrl;
            return normalizeUrl;
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public PiaRuntime build() {
            IResourceLoader create;
            IFactory<IPiaRetrofit> retrofitFactory;
            IPiaRetrofit create2;
            IFactory<String> workerUserAgentFactory;
            String create3;
            IFactory<Map<String, ?>> globalPropsFactory;
            Map<String, ?> create4;
            IFactory<Map<String, String>> sensitiveHeaderFactory;
            Map<String, String> create5;
            IFactory<ISecurityDelegate> securityFactory;
            ISecurityDelegate create6;
            IPiaTracer iPiaTracer = IPiaTracer.get(this.customContext);
            iPiaTracer.report(TraceEvent.INITIALIZE_START, System.currentTimeMillis());
            if (!Settings.get().getIsPiaEnabled()) {
                return null;
            }
            buildName();
            String str = this.name;
            if (str == null || str.isEmpty()) {
                return null;
            }
            if (!PiaLifeCycleService.INSTANCE.support(this.originUri)) {
                Logger.m187w("[Runtime]: url is not support. Url: " + this.url);
                return null;
            }
            boolean z = false;
            boolean booleanQueryParameter = this.originUri.getBooleanQueryParameter("_pia_", false);
            if (!booleanQueryParameter && this.originUri.getBooleanQueryParameter(PiaRuntime.SCHEMA_V1, false)) {
                z = true;
            }
            if (Settings.get().getIsPiaQueryDisable()) {
                Config config = Config.get(this.originUri);
                this.config = config;
                if (config == null && booleanQueryParameter) {
                    this.config = Config.createDefault();
                }
            }
            if (this.config == null && booleanQueryParameter) {
                this.config = Config.get(this.originUri);
            }
            if (this.config == null && z) {
                this.config = Config.createEmptyForV1();
            }
            if (this.config == null) {
                return null;
            }
            PiaEnv env = EnvService.getInstance().getEnv(this.namespace);
            IFactory<IResourceLoader> resourceLoaderFactory = env.getResourceLoaderFactory();
            if (resourceLoaderFactory != null) {
                try {
                    create = resourceLoaderFactory.create(this.customContext);
                } catch (Throwable th) {
                    Logger.m179e("[Runtime] create ResourceLoader error:", th);
                }
                DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader(create);
                retrofitFactory = env.getRetrofitFactory();
                if (retrofitFactory != null) {
                    try {
                        create2 = retrofitFactory.create(this.customContext);
                    } catch (Throwable th2) {
                        Logger.m179e("[Runtime] create Retrofit error:", th2);
                    }
                    if (create2 == null) {
                        create2 = new PiaRuntime$Builder$$ExternalSyntheticLambda0();
                    }
                    IPiaRetrofit iPiaRetrofit = create2;
                    workerUserAgentFactory = env.getWorkerUserAgentFactory();
                    if (workerUserAgentFactory != null) {
                        try {
                            create3 = workerUserAgentFactory.create(this.customContext);
                        } catch (Throwable th3) {
                            Logger.m179e("[Runtime] create custom UserAgent error:", th3);
                        }
                        if (create3 == null) {
                            create3 = "";
                        }
                        String str2 = create3;
                        globalPropsFactory = env.getGlobalPropsFactory();
                        if (globalPropsFactory != null) {
                            try {
                                create4 = globalPropsFactory.create(this.customContext);
                            } catch (Throwable th4) {
                                Logger.m179e("[Runtime] create globalProps error:", th4);
                            }
                            sensitiveHeaderFactory = env.getSensitiveHeaderFactory();
                            if (sensitiveHeaderFactory != null) {
                                try {
                                    create5 = sensitiveHeaderFactory.create(this.customContext);
                                } catch (Throwable th5) {
                                    Logger.m179e("[Runtime] create headers error:", th5);
                                }
                                securityFactory = env.getSecurityFactory();
                                if (securityFactory != null) {
                                    try {
                                        create6 = securityFactory.create(this.customContext);
                                    } catch (Throwable th6) {
                                        Logger.m179e("[Runtime] create securityDelegate error:", th6);
                                    }
                                    return new PiaRuntime(this.originUri, this.name, this.namespace, this.customContext, this.isWarmup, defaultResourceLoader, iPiaRetrofit, str2, this.config, create4, iPiaTracer, create5, create6);
                                }
                                create6 = null;
                                return new PiaRuntime(this.originUri, this.name, this.namespace, this.customContext, this.isWarmup, defaultResourceLoader, iPiaRetrofit, str2, this.config, create4, iPiaTracer, create5, create6);
                            }
                            create5 = null;
                            securityFactory = env.getSecurityFactory();
                            if (securityFactory != null) {
                            }
                            create6 = null;
                            return new PiaRuntime(this.originUri, this.name, this.namespace, this.customContext, this.isWarmup, defaultResourceLoader, iPiaRetrofit, str2, this.config, create4, iPiaTracer, create5, create6);
                        }
                        create4 = null;
                        sensitiveHeaderFactory = env.getSensitiveHeaderFactory();
                        if (sensitiveHeaderFactory != null) {
                        }
                        create5 = null;
                        securityFactory = env.getSecurityFactory();
                        if (securityFactory != null) {
                        }
                        create6 = null;
                        return new PiaRuntime(this.originUri, this.name, this.namespace, this.customContext, this.isWarmup, defaultResourceLoader, iPiaRetrofit, str2, this.config, create4, iPiaTracer, create5, create6);
                    }
                    create3 = null;
                    if (create3 == null) {
                    }
                    String str22 = create3;
                    globalPropsFactory = env.getGlobalPropsFactory();
                    if (globalPropsFactory != null) {
                    }
                    create4 = null;
                    sensitiveHeaderFactory = env.getSensitiveHeaderFactory();
                    if (sensitiveHeaderFactory != null) {
                    }
                    create5 = null;
                    securityFactory = env.getSecurityFactory();
                    if (securityFactory != null) {
                    }
                    create6 = null;
                    return new PiaRuntime(this.originUri, this.name, this.namespace, this.customContext, this.isWarmup, defaultResourceLoader, iPiaRetrofit, str22, this.config, create4, iPiaTracer, create5, create6);
                }
                create2 = null;
                if (create2 == null) {
                }
                IPiaRetrofit iPiaRetrofit2 = create2;
                workerUserAgentFactory = env.getWorkerUserAgentFactory();
                if (workerUserAgentFactory != null) {
                }
                create3 = null;
                if (create3 == null) {
                }
                String str222 = create3;
                globalPropsFactory = env.getGlobalPropsFactory();
                if (globalPropsFactory != null) {
                }
                create4 = null;
                sensitiveHeaderFactory = env.getSensitiveHeaderFactory();
                if (sensitiveHeaderFactory != null) {
                }
                create5 = null;
                securityFactory = env.getSecurityFactory();
                if (securityFactory != null) {
                }
                create6 = null;
                return new PiaRuntime(this.originUri, this.name, this.namespace, this.customContext, this.isWarmup, defaultResourceLoader, iPiaRetrofit2, str222, this.config, create4, iPiaTracer, create5, create6);
            }
            create = null;
            DefaultResourceLoader defaultResourceLoader2 = new DefaultResourceLoader(create);
            retrofitFactory = env.getRetrofitFactory();
            if (retrofitFactory != null) {
            }
            create2 = null;
            if (create2 == null) {
            }
            IPiaRetrofit iPiaRetrofit22 = create2;
            workerUserAgentFactory = env.getWorkerUserAgentFactory();
            if (workerUserAgentFactory != null) {
            }
            create3 = null;
            if (create3 == null) {
            }
            String str2222 = create3;
            globalPropsFactory = env.getGlobalPropsFactory();
            if (globalPropsFactory != null) {
            }
            create4 = null;
            sensitiveHeaderFactory = env.getSensitiveHeaderFactory();
            if (sensitiveHeaderFactory != null) {
            }
            create5 = null;
            securityFactory = env.getSecurityFactory();
            if (securityFactory != null) {
            }
            create6 = null;
            return new PiaRuntime(this.originUri, this.name, this.namespace, this.customContext, this.isWarmup, defaultResourceLoader2, iPiaRetrofit22, str2222, this.config, create4, iPiaTracer, create5, create6);
        }
    }
}

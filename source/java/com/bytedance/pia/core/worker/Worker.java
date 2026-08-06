package com.bytedance.pia.core.worker;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.ies.bullet.kit.resourceloader.loader.CDNLoader;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.security.ISecurityDelegate;
import com.bytedance.pia.core.api.services.IPiaWorkerService;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.bridge.PiaBridge;
import com.bytedance.pia.core.bridge.channel.WorkerPort;
import com.bytedance.pia.core.bridge.methods.ErrorCode;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.metrics.TraceEvent;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.pia.core.tracing.Tracing;
import com.bytedance.pia.core.utils.CacheHandle;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ResourceUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.UrlUtils;
import com.bytedance.pia.core.utils.WorkerUtils;
import com.bytedance.pia.core.worker.binding.BaseModule;
import com.bytedance.pia.core.worker.network.WorkerDelegate;
import com.bytedance.vmsdk.VmSdk;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.monitor.VmSdkMonitor;
import com.bytedance.vmsdk.worker.IWorkerCallback;
import com.bytedance.vmsdk.worker.JsWorker;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Worker implements IReleasable {
    private static final String INLINE_JAVA_SCRIPT_SCHEMA = "javascript:";
    private static final String WARMUP_USER_AGENT = " PIAWarmup";
    private static final String WARMUP_WORKER = " WarmupWorker";
    private final BaseModule baseModule;
    private final PiaBridge bridge;
    private final PiaContext context;
    private final CacheHandle<String> errorHandle = new CacheHandle<>();
    private final Map<String, ?> globalProps;
    private final String inlineScript;
    private final Uri location;
    private final String logTag;
    private final CacheHandle<String> messageHandle;
    private final JSModuleManager moduleManager;
    private final String name;
    private final CacheHandle<JsonObject> remoteBridgeMessages;
    private final CacheHandle<JsonObject> remoteMessages;
    private final IResourceLoader resource;
    private final IConsumer<JsonObject> resultConsumer;
    private IReleasable scriptRequest;
    private final Uri scriptUrl;
    private final ISecurityDelegate securityDelegate;
    private final Map<String, String> sensitiveHeaders;
    private Status status;
    private final String userAgent;
    private final WarmupWorker warmup;
    private final JsWorker worker;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum Status {
        Create,
        Fetching,
        Ready,
        Terminate
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Uri lambda$loadScriptAsync$7(Uri uri) {
        return uri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.pia.core.utils.CacheHandle, java.lang.Object, com.bytedance.pia.core.utils.CacheHandle<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v6 */
    public Worker(final CreateParams createParams) throws Throwable {
        String str;
        JsWorker.EngineType engineType;
        WarmupWorker warmupWorker;
        String str2;
        JsWorker.EngineType engineType2;
        final String cacheHandle = new CacheHandle();
        this.messageHandle = cacheHandle;
        this.remoteMessages = new CacheHandle<>();
        this.remoteBridgeMessages = new CacheHandle<>();
        createParams.context.getTracer().report(TraceEvent.INITIALIZE_WORKER_START, System.currentTimeMillis());
        if (!Settings.get().getIsWorkerEnabled()) {
            createParams.context.getMetrics().onError(ErrorType.WORKER, -1);
            throw new PiaMethod.SettingDisableError();
        }
        if (TextUtils.isEmpty(createParams.name)) {
            this.name = "Worker";
        } else {
            this.name = createParams.name;
        }
        String str3 = "[" + this.name + "] ";
        this.logTag = str3;
        PiaContext piaContext = createParams.context;
        this.context = piaContext;
        trace(EventName.WorkerEnvironmentInitializeStart).flush();
        try {
            try {
                if (TextUtils.isEmpty(createParams.scriptUrl)) {
                    createParams.context.getMetrics().onError(ErrorType.WORKER, -2, "script url is empty.");
                    throw new PiaMethod.Error(ErrorCode.WORKER_SYNTAX_ERROR);
                }
                if (createParams.scriptUrl.startsWith(INLINE_JAVA_SCRIPT_SCHEMA)) {
                    str = createParams.scriptUrl.substring(11);
                    this.scriptUrl = Uri.EMPTY;
                } else {
                    this.scriptUrl = Uri.parse(createParams.scriptUrl);
                    str = null;
                }
                JsWorker.EngineType engineType3 = VmSdkUtil.isV8Enable() ? JsWorker.EngineType.V8 : JsWorker.EngineType.QUICKJS;
                WarmupWorker consume = WarmupWorker.consume(this.scriptUrl);
                this.warmup = consume;
                if (consume != null) {
                    piaContext.getTracer().reportExtra(TraceEvent.IS_WARMUP, 1);
                    piaContext.getTracer().report(TraceEvent.WARMUP_START, consume.getStart());
                    Logger.m181i(str3 + "consume warmup worker.");
                    this.worker = consume.getWorker();
                    this.moduleManager = consume.getModuleManager();
                    engineType = engineType3;
                    warmupWorker = consume;
                } else {
                    piaContext.getTracer().reportExtra(TraceEvent.IS_WARMUP, 0);
                    JSModuleManager jSModuleManager = new JSModuleManager(PiaContext.getApplicationContext());
                    this.moduleManager = jSModuleManager;
                    try {
                        engineType = engineType3;
                        warmupWorker = consume;
                        str2 = "PIA";
                        this.worker = new JsWorker(jSModuleManager, engineType3, (String) null, false, str2);
                        VmSdkUtil.reportVmSdk(true);
                    } catch (Throwable th) {
                        VmSdkUtil.reportVmSdk(false);
                        createParams.context.getMetrics().onError(ErrorType.WORKER, -3, Log.getStackTraceString(th));
                        throw new IPiaWorkerService.NoJSRuntimeException(th);
                    }
                }
                this.location = createParams.location;
                this.resource = createParams.resource;
                this.inlineScript = str;
                this.resultConsumer = createParams.resultConsumer;
                this.globalProps = createParams.globalProps;
                this.sensitiveHeaders = createParams.sensitiveHeaders;
                this.securityDelegate = createParams.securityDelegate;
                this.status = Status.Create;
                StringBuilder sb = new StringBuilder();
                sb.append(piaContext.getUserAgent());
                sb.append("PIANativeWorker ");
                if (createParams.isWarmup) {
                    sb.append(WARMUP_USER_AGENT);
                }
                if (warmupWorker != null) {
                    sb.append(WARMUP_WORKER);
                }
                String sb2 = sb.toString();
                this.userAgent = sb2;
                PiaBridge piaBridge = createParams.bridge;
                this.bridge = piaBridge;
                piaBridge.setDebugger(VmSdkUtil.getDebugger());
                piaBridge.start(new WorkerPort(this));
                this.moduleManager.registerModule(BaseModule.NAME, BaseModule.class, this);
                BaseModule baseModule = (BaseModule) this.moduleManager.getModule(BaseModule.NAME).getModule();
                this.baseModule = baseModule;
                baseModule.setMessageHandle(new IConsumer() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda2
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(Object obj) {
                        Worker.this.m777lambda$new$0$combytedancepiacoreworkerWorker((ReadableMap) obj);
                    }
                });
                baseModule.setBridgeMessageHandle(new IConsumer() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda3
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(Object obj) {
                        Worker.this.m778lambda$new$1$combytedancepiacoreworkerWorker((ReadableMap) obj);
                    }
                });
                if (createParams.needPolyfill) {
                    if (!TextUtils.isEmpty(Polyfill.getValue())) {
                        this.worker.evaluateJavaScript(Polyfill.getValue());
                    } else {
                        createParams.context.getMetrics().onError(ErrorType.WORKER, -4);
                        throw new RuntimeException("Polyfill load failed!");
                    }
                }
                try {
                    if (!Settings.get().getIsVanillaFetchEnabled()) {
                        str2 = TraceEvent.INITIALIZE_WORKER_END;
                        engineType2 = engineType;
                    } else if (createParams.retrofit != null) {
                        JsWorker jsWorker = this.worker;
                        IPiaRetrofit iPiaRetrofit = createParams.retrofit;
                        IResourceLoader iResourceLoader = createParams.resource;
                        Map<String, String> map = createParams.sensitiveHeaders;
                        ISecurityDelegate iSecurityDelegate = createParams.securityDelegate;
                        str2 = TraceEvent.INITIALIZE_WORKER_END;
                        engineType2 = engineType;
                        jsWorker.setWorkerDelegate(new WorkerDelegate(str3, sb2, iPiaRetrofit, iResourceLoader, map, iSecurityDelegate));
                        Logger.m181i(str3 + "Initialize Fetch-API successfully");
                    } else {
                        str2 = TraceEvent.INITIALIZE_WORKER_END;
                        engineType2 = engineType;
                        Logger.m178e(str3 + "Initialize Fetch-API failed (Reason: 'Retrofit is null')");
                    }
                    this.worker.setOnErrorCallback(new IWorkerCallback() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda4
                        public final void execute(String str4) {
                            Worker.this.m779lambda$new$2$combytedancepiacoreworkerWorker(createParams, str4);
                        }
                    });
                    JsWorker jsWorker2 = this.worker;
                    Objects.requireNonNull(cacheHandle);
                    jsWorker2.setOnMessageCallback(new IWorkerCallback() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda5
                        public final void execute(String str4) {
                            CacheHandle.this.offer(str4);
                        }
                    });
                    Logger.m181i(str3 + "Worker create successfully (URL: " + createParams.location + ")");
                    Logger.m181i(str3 + "Create PIA worker (UserAgent: '" + sb2 + "', RuntimeType: " + engineType2 + ", URL: " + this.scriptUrl + ", Debuggable: " + (engineType2 == JsWorker.EngineType.V8) + ")");
                    trace(EventName.WorkerEnvironmentInitializeEnd).flush();
                    createParams.context.getTracer().report(str2, System.currentTimeMillis());
                } catch (Throwable th2) {
                    th = th2;
                    cacheHandle = str2;
                    try {
                        Logger.m179e(this.logTag + " Worker create failed (Reason: " + th + ")", th);
                        throw th;
                    } catch (Throwable th3) {
                        trace(EventName.WorkerEnvironmentInitializeEnd).flush();
                        createParams.context.getTracer().report(cacheHandle, System.currentTimeMillis());
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                Logger.m179e(this.logTag + " Worker create failed (Reason: " + th + ")", th);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            cacheHandle = TraceEvent.INITIALIZE_WORKER_END;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m777lambda$new$0$combytedancepiacoreworkerWorker(ReadableMap readableMap) {
        if (readableMap != null) {
            this.remoteMessages.offer(WorkerUtils.toJson(readableMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m778lambda$new$1$combytedancepiacoreworkerWorker(ReadableMap readableMap) {
        if (readableMap != null) {
            this.remoteBridgeMessages.offer(WorkerUtils.toJson(readableMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m779lambda$new$2$combytedancepiacoreworkerWorker(CreateParams createParams, String str) {
        createParams.context.getMetrics().onError(ErrorType.WORKER, -7, str);
        this.errorHandle.offer(str);
    }

    private Tracing.Event trace(EventName eventName) {
        return this.context.getTrace().traceWithArgs(eventName).appendArg(ErrorType.WORKER, this.context.generateKey(this));
    }

    public void start() {
        if (this.warmup == null) {
            this.context.getTracer().report(TraceEvent.REQUEST_WORKER_START, System.currentTimeMillis());
        } else {
            this.context.getTracer().report(TraceEvent.REQUEST_WORKER_START, this.warmup.getRequestStart());
        }
        if (VmSdkUtil.getDebugger() != null && VmSdkUtil.isDebugEnable()) {
            VmSdkUtil.getDebugger().onWorkerCreate(this.worker, this.location.toString(), this.scriptUrl.toString());
        }
        if (this.status != Status.Create) {
            return;
        }
        this.status = Status.Fetching;
        trace(EventName.WorkerScriptRequestStart).appendArg("url", this.scriptUrl.toString()).flush(false);
        WarmupWorker warmupWorker = this.warmup;
        if (warmupWorker != null) {
            warmupWorker.onFinish(new Runnable() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    Worker.this.m784lambda$start$3$combytedancepiacoreworkerWorker();
                }
            });
            return;
        }
        String str = this.inlineScript;
        if (str != null) {
            onLoadFinish(str, true);
        } else {
            this.scriptRequest = this.resource.loadAsync(LoadFrom.Auto, new IResourceRequest() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda9
                @Override // com.bytedance.pia.core.api.resource.IResourceRequest
                public final Uri getUrl() {
                    return Worker.this.m785lambda$start$4$combytedancepiacoreworkerWorker();
                }
            }, new IConsumer() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda10
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Object obj) {
                    Worker.this.onLoadFinish((IResourceResponse) obj);
                }
            }, new IConsumer() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda11
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Object obj) {
                    Worker.this.onLoadError((Throwable) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$3$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m784lambda$start$3$combytedancepiacoreworkerWorker() {
        this.context.getTracer().report(TraceEvent.WARMUP_END, this.warmup.getEnd());
        if (this.worker.isRunning()) {
            onLoadFinish("", false);
        } else {
            onLoadError(this.warmup.getError());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$4$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ Uri m785lambda$start$4$combytedancepiacoreworkerWorker() {
        return this.scriptUrl;
    }

    public void loadScriptAsync(final String str, final IConsumer<String> iConsumer, final IConsumer<String> iConsumer2) {
        final long currentTimeMillis = System.currentTimeMillis();
        final IConsumer<Throwable> iConsumer3 = new IConsumer() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda13
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                Worker.this.m775lambda$loadScriptAsync$5$combytedancepiacoreworkerWorker(iConsumer2, (Throwable) obj);
            }
        };
        IConsumer<IResourceResponse> iConsumer4 = new IConsumer() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda14
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                Worker.this.m776lambda$loadScriptAsync$6$combytedancepiacoreworkerWorker(currentTimeMillis, iConsumer, str, iConsumer3, (IResourceResponse) obj);
            }
        };
        if (TextUtils.isEmpty(str)) {
            this.context.getMetrics().onError(ErrorType.WORKER, -2, "script url is empty.");
            iConsumer3.accept(new RuntimeException("invalid url"));
        }
        final Uri parse = Uri.parse(str);
        if (!UrlUtils.isHttp(parse)) {
            this.context.getMetrics().onError(ErrorType.WORKER, -2, parse.toString());
            iConsumer3.accept(new RuntimeException("invalid url"));
        }
        this.resource.loadAsync(LoadFrom.Auto, new IResourceRequest() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda1
            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            public final Uri getUrl() {
                return Worker.lambda$loadScriptAsync$7(parse);
            }
        }, iConsumer4, iConsumer3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$loadScriptAsync$5$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m775lambda$loadScriptAsync$5$combytedancepiacoreworkerWorker(IConsumer iConsumer, Throwable th) {
        Logger.m179e(this.logTag + "load script async error:", th);
        iConsumer.accept(th != null ? th.toString() : "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$loadScriptAsync$6$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m776lambda$loadScriptAsync$6$combytedancepiacoreworkerWorker(long j, IConsumer iConsumer, String str, IConsumer iConsumer2, IResourceResponse iResourceResponse) {
        try {
            String readAsString = ResourceUtils.readAsString(iResourceResponse);
            long currentTimeMillis = System.currentTimeMillis() - j;
            this.worker.evaluateJavaScript(readAsString);
            iConsumer.accept(String.valueOf(currentTimeMillis));
        } catch (Throwable th) {
            this.context.getMetrics().onError(ErrorType.WORKER, -6, "url=" + str + ", error=" + Log.getStackTraceString(th));
            iConsumer2.accept(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadFinish(IResourceResponse iResourceResponse) {
        try {
            onLoadFinish(ResourceUtils.readAsString(iResourceResponse), Boolean.valueOf(iResourceResponse.get$from() == LoadFrom.Offline));
        } catch (Throwable th) {
            onLoadError(th);
        }
    }

    private void onLoadFinish(final String str, Boolean bool) {
        if (this.warmup == null) {
            this.context.getTracer().report(TraceEvent.REQUEST_WORKER_END, System.currentTimeMillis());
        } else {
            this.context.getTracer().report(TraceEvent.REQUEST_WORKER_END, this.warmup.getRequestEnd());
        }
        Logger.m181i(this.logTag + "PIA worker fetches script successfully(URL: " + this.scriptUrl + ", Mode: " + (bool.booleanValue() ? "Offline" : "Network") + ")");
        trace(EventName.WorkerScriptRequestEnd).appendArg("url", this.scriptUrl.toString()).appendArg("flag", "success").appendArg("mode", bool.booleanValue() ? ResourceInfo.RESOURCE_FROM_OFFLINE : "online").appendArg("f", 1).appendArg("m", Integer.valueOf(bool.booleanValue() ? 1 : 0)).flush();
        ThreadUtil.INSTANCE.getPiaHandler().post(new Runnable() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                Worker.this.m781lambda$onLoadFinish$8$combytedancepiacoreworkerWorker(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onLoadFinish$8$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m781lambda$onLoadFinish$8$combytedancepiacoreworkerWorker(String str) {
        trace(EventName.WorkerExecuteStart).flush();
        this.context.getOnlineTrace().addDurationByTimestamp(OnlineTracing.NativeMetricsKeys.KEY_NPS);
        this.worker.evaluateJavaScript(str, this.scriptUrl.toString());
        this.worker.evaluateJavaScript("if(typeof globalThis.__activate==='function'){globalThis.__activate();}");
        this.status = Status.Ready;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadError(final Throwable th) {
        if (this.warmup == null) {
            this.context.getTracer().report(TraceEvent.REQUEST_WORKER_END, System.currentTimeMillis());
        } else {
            this.context.getTracer().report(TraceEvent.REQUEST_WORKER_END, this.warmup.getRequestEnd());
        }
        this.context.getMetrics().onError(ErrorType.WORKER, -6, "url=" + this.scriptUrl + ", error=" + Log.getStackTraceString(th));
        Logger.m179e(this.logTag + "PIA worker fails to fetch script(URL:" + this.scriptUrl + ", Reason: " + th + ")", th);
        this.status = Status.Terminate;
        trace(EventName.WorkerScriptRequestEnd).appendArg("url", this.scriptUrl.toString()).appendArg("flag", CDNLoader.PIPELINE_STATUS_FAILED).appendArg("mode", "online").appendArg("f", 0).appendArg("m", 0).flush();
        ThreadUtil.INSTANCE.getPiaHandler().post(new Runnable() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                Worker.this.m780lambda$onLoadError$9$combytedancepiacoreworkerWorker(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onLoadError$9$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m780lambda$onLoadError$9$combytedancepiacoreworkerWorker(Throwable th) {
        if (th == null) {
            this.errorHandle.offer("Load resource failed.");
        } else {
            this.errorHandle.offer("Load resource failed, error: " + th.getMessage());
        }
        this.worker.terminate();
    }

    public String getName() {
        return this.name;
    }

    public String getLogTag() {
        return this.logTag;
    }

    public Uri getLocation() {
        return this.location;
    }

    public String getScriptUrl() {
        String uri = this.scriptUrl.toString();
        return TextUtils.isEmpty(uri) ? INLINE_JAVA_SCRIPT_SCHEMA + this.inlineScript : uri;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public Status getStatus() {
        return this.status;
    }

    public PiaBridge getBridge() {
        return this.bridge;
    }

    public JSModuleManager getModuleManager() {
        return this.moduleManager;
    }

    public Map<String, ?> getGlobalProps() {
        return this.globalProps;
    }

    Map<String, String> getSensitiveHeaders() {
        return this.sensitiveHeaders;
    }

    public ISecurityDelegate getSecurityDelegate() {
        return this.securityDelegate;
    }

    public PiaContext getContext() {
        return this.context;
    }

    @Deprecated
    public void postMessage(String str) {
        if (isRunning()) {
            this.worker.postMessage(str);
            Logger.m181i(this.logTag + "Post message to worker (Message: " + str + ")");
        }
    }

    @Deprecated
    public void setMessageHandle(final IConsumer<String> iConsumer) {
        this.messageHandle.setConsumer(new IConsumer() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda7
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                Worker.this.m783lambda$setMessageHandle$10$combytedancepiacoreworkerWorker(iConsumer, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setMessageHandle$10$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m783lambda$setMessageHandle$10$combytedancepiacoreworkerWorker(IConsumer iConsumer, String str) {
        Logger.m181i(this.logTag + "Handle message from worker (Message: " + str + ")");
        iConsumer.accept(str);
    }

    public void sendMessage(JsonObject jsonObject) {
        this.baseModule.sendWorkerMessage(WorkerUtils.toJavaOnlyMap(jsonObject));
    }

    public void onMessage(IConsumer<JsonObject> iConsumer) {
        this.remoteMessages.setConsumer(iConsumer);
    }

    public void sendBridgeMessage(JsonObject jsonObject) {
        this.baseModule.sendWorkerBridgeMessage(WorkerUtils.toJavaOnlyMap(jsonObject));
    }

    public void onBridgeMessage(IConsumer<JsonObject> iConsumer) {
        this.remoteBridgeMessages.setConsumer(iConsumer);
    }

    public void loadScript(String str) {
        if (!TextUtils.isEmpty(str) && isRunning()) {
            this.worker.evaluateJavaScript(str);
        }
    }

    @Override // com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        terminate();
    }

    public void terminate() {
        terminateWithResult(null);
    }

    public void terminateWithResult(JsonObject jsonObject) {
        if (isRunning()) {
            IConsumer<JsonObject> iConsumer = this.resultConsumer;
            if (iConsumer != null) {
                iConsumer.accept(jsonObject);
            }
            Logger.m181i(this.logTag + "PIA worker was terminated (URL: " + this.location + ")");
            IReleasable iReleasable = this.scriptRequest;
            if (iReleasable != null) {
                iReleasable.release();
                this.scriptRequest = null;
            }
            this.status = Status.Terminate;
            this.bridge.close();
            this.worker.terminate();
        }
    }

    public void setErrorHandle(final IConsumer<String> iConsumer) {
        this.errorHandle.setConsumer(new IConsumer() { // from class: com.bytedance.pia.core.worker.Worker$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                Worker.this.m782lambda$setErrorHandle$11$combytedancepiacoreworkerWorker(iConsumer, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setErrorHandle$11$com-bytedance-pia-core-worker-Worker, reason: not valid java name */
    public /* synthetic */ void m782lambda$setErrorHandle$11$combytedancepiacoreworkerWorker(IConsumer iConsumer, String str) {
        Logger.m178e(this.logTag + "Handle error from worker(Error: " + str + ")");
        iConsumer.accept(str);
    }

    public boolean isRunning() {
        return this.status != Status.Terminate && this.worker.isRunning();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class VmSdkUtil {
        private static final String VMSDK_MONITOR_EVENT = "use_vmsdk_worker";
        private static final String VMSDK_MONITOR_NAME = "pia_worker";
        private static final AtomicBoolean INITIALIZING = new AtomicBoolean();
        private static boolean gHasInitialized = false;
        private static IPiaDebugger gDebug = null;
        private static boolean gEnableDebug = false;
        private static boolean gEnableV8 = false;
        private static boolean gEnableStopAtEntry = false;

        public static void setDebugger(IPiaDebugger iPiaDebugger) {
            gDebug = iPiaDebugger;
        }

        public static IPiaDebugger getDebugger() {
            return gDebug;
        }

        public static boolean isEnableStopAtEntry() {
            return gEnableStopAtEntry;
        }

        public static void setEnableStopAtEntry(boolean z) {
            gEnableStopAtEntry = z;
        }

        public static void enableDebug(boolean z) {
            gEnableDebug = z;
        }

        public static boolean isDebugEnable() {
            return gEnableDebug;
        }

        public static void enableV8(boolean z) {
            gEnableV8 = z;
        }

        public static boolean isV8Enable() {
            return gEnableV8;
        }

        public static void initialize() {
            if (!gHasInitialized && INITIALIZING.compareAndSet(false, true)) {
                if (JsWorker.initialize()) {
                    gHasInitialized = true;
                    return;
                }
                String vmSdkPluginName = VmSdk.getVmSdkPluginName();
                JsWorker.preLoadPlugin(vmSdkPluginName);
                if (JsWorker.initializeWithPlugin2(vmSdkPluginName)) {
                    gHasInitialized = true;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void reportVmSdk(Boolean bool) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VMSDK_MONITOR_EVENT, bool);
                VmSdkMonitor.monitorEvent(VMSDK_MONITOR_NAME, jSONObject, (JSONObject) null, (JSONObject) null);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class CreateParams {
        public final PiaBridge bridge;
        public final PiaContext context;
        public final Map<String, ?> globalProps;
        public final boolean isWarmup;
        public final Uri location;
        public final String name;
        public final boolean needPolyfill;
        public final IResourceLoader resource;
        public final IConsumer<JsonObject> resultConsumer;
        public final IPiaRetrofit retrofit;
        public final String scriptUrl;
        public final ISecurityDelegate securityDelegate;
        public final Map<String, String> sensitiveHeaders;

        public CreateParams(PiaContext piaContext, String str, String str2, Uri uri, IResourceLoader iResourceLoader, PiaBridge piaBridge, IPiaRetrofit iPiaRetrofit, IConsumer<JsonObject> iConsumer, boolean z, boolean z2, Map<String, ?> map, Map<String, String> map2, ISecurityDelegate iSecurityDelegate) {
            this.context = piaContext;
            this.name = str;
            this.scriptUrl = str2;
            this.location = uri;
            this.resource = iResourceLoader;
            this.bridge = piaBridge;
            this.retrofit = iPiaRetrofit;
            this.resultConsumer = iConsumer;
            this.isWarmup = z;
            this.needPolyfill = z2;
            this.globalProps = map;
            this.sensitiveHeaders = map2;
            this.securityDelegate = iSecurityDelegate;
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static class Builder {
            private String location = "";
            private String scriptUrl = "";
            private PiaContext context = null;
            private IResourceLoader resource = null;
            private IConsumer<JsonObject> resultConsumer = null;
            private boolean isWarmup = false;
            public boolean needPolyfill = true;
            private String name = "";
            private String userAgent = "";
            private Map<String, ?> globalProps = null;
            private Map<String, String> sensitiveHeaders = null;
            private ISecurityDelegate securityDelegate = null;

            public Builder setName(String str) {
                this.name = str;
                return this;
            }

            public Builder setLocation(String str) {
                this.location = str;
                return this;
            }

            public Builder setScriptUrl(String str) {
                this.scriptUrl = str;
                return this;
            }

            public Builder setContext(PiaContext piaContext) {
                this.context = piaContext;
                return this;
            }

            public Builder setResource(IResourceLoader iResourceLoader) {
                this.resource = iResourceLoader;
                return this;
            }

            public Builder setResultConsumer(IConsumer<JsonObject> iConsumer) {
                this.resultConsumer = iConsumer;
                return this;
            }

            public Builder setUserAgent(String str) {
                this.userAgent = str;
                return this;
            }

            public Builder setWarmup(boolean z) {
                this.isWarmup = z;
                return this;
            }

            public Builder setNeedPolyfill(boolean z) {
                this.needPolyfill = z;
                return this;
            }

            public Builder setGlobalProps(Map<String, ?> map) {
                this.globalProps = map;
                return this;
            }

            public Builder setSensitiveHeaders(Map<String, String> map) {
                this.sensitiveHeaders = map;
                return this;
            }

            public Builder setSecurityDelegate(ISecurityDelegate iSecurityDelegate) {
                this.securityDelegate = iSecurityDelegate;
                return this;
            }

            public CreateParams build() {
                Uri originUrl;
                if (!Settings.get().getIsWorkerEnabled() || TextUtils.isEmpty(this.scriptUrl)) {
                    return null;
                }
                if (!TextUtils.isEmpty(this.location)) {
                    originUrl = Uri.parse(this.location);
                } else {
                    originUrl = this.context.getOriginUrl();
                }
                Uri uri = originUrl;
                if (!this.scriptUrl.startsWith(Worker.INLINE_JAVA_SCRIPT_SCHEMA)) {
                    Uri resolveRelativeUrl = UrlUtils.resolveRelativeUrl(uri, this.scriptUrl);
                    if (resolveRelativeUrl == null) {
                        return null;
                    }
                    this.scriptUrl = resolveRelativeUrl.toString();
                }
                PiaContext piaContext = this.context;
                if (piaContext == null) {
                    return null;
                }
                IResourceLoader iResourceLoader = this.resource;
                IResourceLoader resource = iResourceLoader == null ? piaContext.getResource() : iResourceLoader;
                PiaMethod.Scope scope = PiaMethod.Scope.Worker;
                PiaContext piaContext2 = this.context;
                try {
                    return new CreateParams(this.context, this.name, this.scriptUrl, uri, resource, new PiaBridge(scope, piaContext2, piaContext2.getBridgeRegistry()), this.context.getRetrofit(), this.resultConsumer, this.isWarmup, this.needPolyfill, this.globalProps, this.sensitiveHeaders, this.securityDelegate);
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
    }
}

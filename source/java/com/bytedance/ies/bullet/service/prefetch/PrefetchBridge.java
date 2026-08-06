package com.bytedance.ies.bullet.service.prefetch;

import bolts.Task;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import com.bytedance.ies.tools.prefetch.IPrefetchProcessor;
import com.bytedance.ies.tools.prefetch.IPrefetchResultListener;
import com.bytedance.ies.tools.prefetch.PrefetchMethodStub;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.auth.ISecurityContext;
import com.bytedance.sdk.xbridge.cn.auth.SecurityContextUtils;
import com.bytedance.sdk.xbridge.cn.protocol.StatefulMethod;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PrefetchBridge.kt */
@XBridgeMethod(biz = "bullet", name = "__prefetch")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u001a\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020 H\u0016J*\u0010&\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J*\u0010-\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010!\u001a\u00020\"2\u0006\u0010.\u001a\u00020\"2\u0006\u0010+\u001a\u00020,H\u0002J\f\u0010/\u001a\u00020 *\u00020\"H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lcom/bytedance/ies/bullet/service/prefetch/PrefetchBridge;", "Lcom/bytedance/ies/bullet/core/kit/bridge/BridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/protocol/StatefulMethod;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;)V", "access", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "setAccess", "(Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;)V", "mStrongRefContainer", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", "name", "", "getName", "()Ljava/lang/String;", "needCallback", "", "getNeedCallback", "()Z", "setNeedCallback", "(Z)V", "prefetchEmptyListener", "com/bytedance/ies/bullet/service/prefetch/PrefetchBridge$prefetchEmptyListener$1", "Lcom/bytedance/ies/bullet/service/prefetch/PrefetchBridge$prefetchEmptyListener$1;", "getProviderFactory", "()Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "canRunInBackground", "handle", "", "params", "Lorg/json/JSONObject;", "callback", "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$ICallback;", "release", "reportFail", "prefetchService", "Lcom/bytedance/ies/bullet/service/prefetch/PrefetchService;", "throwable", "", LynxTimingPerformanceReportProcessor.KEY_DURATION, "", "reportSuccess", "result", "addXSecurityArgusHeader", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PrefetchBridge extends BridgeMethod implements StatefulMethod {
    private IBridgeMethod.Access access;
    private final CopyOnWriteArraySet<IPrefetchResultListener> mStrongRefContainer;
    private final String name;
    private boolean needCallback;
    private final PrefetchBridge$prefetchEmptyListener$1 prefetchEmptyListener;
    private final ContextProviderFactory providerFactory;

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod
    public boolean canRunInBackground() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.ies.bullet.service.prefetch.PrefetchBridge$prefetchEmptyListener$1] */
    public PrefetchBridge(ContextProviderFactory contextProviderFactory) {
        super(contextProviderFactory);
        Intrinsics.checkNotNullParameter(contextProviderFactory, "providerFactory");
        this.providerFactory = contextProviderFactory;
        this.access = IBridgeMethod.Access.PRIVATE;
        this.name = "__prefetch";
        this.prefetchEmptyListener = new IPrefetchResultListener() { // from class: com.bytedance.ies.bullet.service.prefetch.PrefetchBridge$prefetchEmptyListener$1
            @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener
            public void onFailed(Throwable throwable) {
                CopyOnWriteArraySet copyOnWriteArraySet;
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "request failed message = " + throwable.getMessage(), null, "XPrefetch", 2, null);
                copyOnWriteArraySet = PrefetchBridge.this.mStrongRefContainer;
                copyOnWriteArraySet.remove(this);
            }

            @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener
            public void onSucceed(JSONObject result) {
                CopyOnWriteArraySet copyOnWriteArraySet;
                Intrinsics.checkNotNullParameter(result, "result");
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "request success", null, "XPrefetch", 2, null);
                copyOnWriteArraySet = PrefetchBridge.this.mStrongRefContainer;
                copyOnWriteArraySet.remove(this);
            }
        };
        this.mStrongRefContainer = new CopyOnWriteArraySet<>();
    }

    public final ContextProviderFactory getProviderFactory() {
        return this.providerFactory;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public IBridgeMethod.Access getAccess() {
        return this.access;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod
    public void setAccess(IBridgeMethod.Access access) {
        Intrinsics.checkNotNullParameter(access, "<set-?>");
        this.access = access;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.bridge.IGenericBridgeMethod
    public boolean getNeedCallback() {
        return this.needCallback;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod
    public void setNeedCallback(boolean z) {
        this.needCallback = z;
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public void handle(final JSONObject params, IBridgeMethod.ICallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        long currentTimeMillis = System.currentTimeMillis();
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "__prefetch start", null, "XPrefetch", 2, null);
        PrefetchService prefetchService = (PrefetchService) this.providerFactory.provideInstance(PrefetchService.class);
        Object provideInstance = this.providerFactory.provideInstance(IPrefetchProcessor.class);
        Intrinsics.checkNotNull(provideInstance);
        final IPrefetchProcessor iPrefetchProcessor = (IPrefetchProcessor) provideInstance;
        final PrefetchBridge$handle$listener$1 prefetchBridge$handle$listener$1 = new PrefetchBridge$handle$listener$1(callback, this, currentTimeMillis, prefetchService, params);
        this.mStrongRefContainer.add(prefetchBridge$handle$listener$1);
        boolean optBoolean = params.optBoolean("ignore_cache", false);
        final boolean optBoolean2 = params.optBoolean("doRequestEvenInCache", false);
        IPrefetchProcessor processorByParams = PrefetchProcessorManager.INSTANCE.getProcessorByParams(params);
        if (processorByParams == null) {
            processorByParams = iPrefetchProcessor;
        }
        addXSecurityArgusHeader(params);
        if (optBoolean) {
            new PrefetchMethodStub(processorByParams, prefetchBridge$handle$listener$1).invokeForceFallback(params);
            return;
        }
        IPrefetchResultListener iPrefetchResultListener = new IPrefetchResultListener() { // from class: com.bytedance.ies.bullet.service.prefetch.PrefetchBridge$handle$listenerDelegate$1
            @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener
            public void onFailed(Throwable throwable) {
                CopyOnWriteArraySet copyOnWriteArraySet;
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                PrefetchBridge$handle$listener$1.this.onFailed(throwable);
                copyOnWriteArraySet = this.mStrongRefContainer;
                copyOnWriteArraySet.remove(this);
            }

            @Override // com.bytedance.ies.tools.prefetch.IPrefetchResultListener
            public void onSucceed(JSONObject result) {
                CopyOnWriteArraySet copyOnWriteArraySet;
                Intrinsics.checkNotNullParameter(result, "result");
                if (optBoolean2) {
                    final PrefetchBridge prefetchBridge = this;
                    final IPrefetchProcessor iPrefetchProcessor2 = iPrefetchProcessor;
                    final JSONObject jSONObject = params;
                    Task.call(new Callable() { // from class: com.bytedance.ies.bullet.service.prefetch.PrefetchBridge$handle$listenerDelegate$1$onSucceed$1
                        @Override // java.util.concurrent.Callable
                        public /* bridge */ /* synthetic */ Object call() {
                            call();
                            return Unit.INSTANCE;
                        }

                        @Override // java.util.concurrent.Callable
                        public final void call() {
                            CopyOnWriteArraySet copyOnWriteArraySet2;
                            PrefetchBridge$prefetchEmptyListener$1 prefetchBridge$prefetchEmptyListener$1;
                            PrefetchBridge$prefetchEmptyListener$1 prefetchBridge$prefetchEmptyListener$12;
                            copyOnWriteArraySet2 = PrefetchBridge.this.mStrongRefContainer;
                            prefetchBridge$prefetchEmptyListener$1 = PrefetchBridge.this.prefetchEmptyListener;
                            copyOnWriteArraySet2.add(prefetchBridge$prefetchEmptyListener$1);
                            IPrefetchProcessor iPrefetchProcessor3 = iPrefetchProcessor2;
                            prefetchBridge$prefetchEmptyListener$12 = PrefetchBridge.this.prefetchEmptyListener;
                            new PrefetchMethodStub(iPrefetchProcessor3, prefetchBridge$prefetchEmptyListener$12).invokeForceFallback(jSONObject);
                        }
                    }, Task.BACKGROUND_EXECUTOR);
                }
                PrefetchBridge$handle$listener$1.this.onSucceed(result);
                copyOnWriteArraySet = this.mStrongRefContainer;
                copyOnWriteArraySet.remove(this);
            }
        };
        this.mStrongRefContainer.add(iPrefetchResultListener);
        new PrefetchMethodStub(processorByParams, iPrefetchResultListener).invoke(params);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod, com.bytedance.ies.bullet.service.base.IReleasable
    public void release() {
        this.mStrongRefContainer.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportSuccess(PrefetchService prefetchService, JSONObject params, JSONObject result, long duration) {
        IMonitorReportService iMonitorReportService;
        BulletContext bulletContext;
        if (prefetchService == null || (iMonitorReportService = (IMonitorReportService) prefetchService.getService(IMonitorReportService.class)) == null) {
            return;
        }
        ReportInfo reportInfo = new ReportInfo("bdx_monitor_prefetch_data", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        IBulletContainer iBulletContainer = (IBulletContainer) this.providerFactory.provideInstance(IBulletContainer.class);
        reportInfo.setPageIdentifier((iBulletContainer == null || (bulletContext = iBulletContainer.getBulletContext()) == null) ? null : bulletContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("prefetch_api", params.optString("url"));
        jSONObject.put("prefetch_state", "success");
        jSONObject.put("prefetch_from", "bridge");
        jSONObject.put("prefetch_cached", result.optInt("cached"));
        jSONObject.put("prefetch_type", "v1");
        reportInfo.setCategory(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, duration);
        reportInfo.setMetrics(jSONObject2);
        iMonitorReportService.report(reportInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportFail(PrefetchService prefetchService, JSONObject params, Throwable throwable, long duration) {
        IMonitorReportService iMonitorReportService;
        BulletContext bulletContext;
        if (prefetchService == null || (iMonitorReportService = (IMonitorReportService) prefetchService.getService(IMonitorReportService.class)) == null) {
            return;
        }
        ReportInfo reportInfo = new ReportInfo("bdx_monitor_prefetch_data", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        IBulletContainer iBulletContainer = (IBulletContainer) this.providerFactory.provideInstance(IBulletContainer.class);
        reportInfo.setPageIdentifier((iBulletContainer == null || (bulletContext = iBulletContainer.getBulletContext()) == null) ? null : bulletContext.getUriIdentifier());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("prefetch_api", params.optString("url"));
        jSONObject.put("prefetch_state", SccResult.MESSAGE_FAIL);
        jSONObject.put("prefetch_from", "bridge");
        jSONObject.put("prefetch_error", throwable.getMessage());
        jSONObject.put("prefetch_type", "v1");
        reportInfo.setCategory(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, duration);
        reportInfo.setMetrics(jSONObject2);
        iMonitorReportService.report(reportInfo);
    }

    private final void addXSecurityArgusHeader(JSONObject jSONObject) {
        Object obj;
        ISecurityContext iSecurityContext = (ISecurityContext) getContextProviderFactory().provideInstance(ISecurityContext.class);
        if (iSecurityContext == null) {
            return;
        }
        String xSecurityArgusHeaderKey = SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderKey(iSecurityContext);
        Object xSecurityArgusHeaderValue = SecurityContextUtils.INSTANCE.getXSecurityArgusHeaderValue(iSecurityContext);
        JSONObject optJSONObject = jSONObject.optJSONObject("headers");
        if (optJSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(xSecurityArgusHeaderKey, xSecurityArgusHeaderValue);
            Unit unit = Unit.INSTANCE;
            jSONObject.put("headers", jSONObject2);
        } else {
            Iterator<String> keys = optJSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "headers.keys()");
            Iterator it = SequencesKt.asSequence(keys).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (StringsKt.equals((String) obj, xSecurityArgusHeaderKey, true)) {
                        break;
                    }
                }
            }
            String str = (String) obj;
            if (str != null) {
                optJSONObject.remove(str);
            }
            optJSONObject.put(xSecurityArgusHeaderKey, xSecurityArgusHeaderValue);
        }
        jSONObject.put("headers", optJSONObject);
    }
}

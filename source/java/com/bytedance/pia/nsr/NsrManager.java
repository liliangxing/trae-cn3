package com.bytedance.pia.nsr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.TracingAdapter;
import com.bytedance.pia.core.api.bridge.IWorkerBridgeHandle;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.metrics.ErrorCode;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.metrics.MetricsType;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.plugins.BridgeDowngradePlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.pia.core.worker.bridge.BridgeModule;
import com.bytedance.pia.core.worker.bridge.PolyfillCompat;
import com.bytedance.platform.godzilla.common.Constant;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: NsrManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u009a\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\"\b\u0002\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016j\u0004\u0018\u0001`\u00172\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\fJt\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\"\b\u0002\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016j\u0004\u0018\u0001`\u00172\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aJ\u0080\u0001\u0010\u001e\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\"\b\u0002\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016j\u0004\u0018\u0001`\u00172\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0002J&\u0010!\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$J\u001a\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020'R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006)"}, d2 = {"Lcom/bytedance/pia/nsr/NsrManager;", "", "()V", "cache", "Lcom/bytedance/pia/nsr/RecordsCache;", "getCache", "()Lcom/bytedance/pia/nsr/RecordsCache;", "render", "", "context", "Landroid/content/Context;", "url", "", "expires", "", "once", "", "userAgent", "script", "workerBridgeHandle", "Lcom/bytedance/pia/core/api/bridge/IWorkerBridgeHandle;", "onSuccess", "Lkotlin/Function2;", "Lcom/bytedance/pia/nsr/NsrSuccessCallback;", "onFailed", "Lkotlin/Function1;", "Lcom/bytedance/pia/nsr/NsrFailedCallback;", "namespace", "runtime", "Lcom/bytedance/pia/core/runtime/PiaRuntime;", "renderInternal", ErrorType.MANIFEST, "Lcom/bytedance/pia/core/PiaManifest;", "reportPVIfNeeded", "isSuccess", "consumer", "Lcom/bytedance/pia/nsr/NsrManager$NsrTraceConsumer;", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "Lcom/bytedance/pia/core/PiaContext;", "NsrTraceConsumer", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NsrManager {
    public static final NsrManager INSTANCE = new NsrManager();
    private static final RecordsCache cache = new RecordsCache(0, 1, null);

    private NsrManager() {
    }

    public final RecordsCache getCache() {
        return cache;
    }

    public final void render(Context context, String url, long expires, boolean once, String userAgent, String script, IWorkerBridgeHandle workerBridgeHandle, Function2<? super String, ? super Boolean, Unit> onSuccess, Function1<? super String, Unit> onFailed, String namespace) {
        PiaRuntime piaRuntime;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        PiaManifest create$default = PiaManifest.Companion.create$default(PiaManifest.INSTANCE, url, null, 2, null);
        if (create$default == null) {
            return;
        }
        if (!create$default.getEnableNsr()) {
            if (onFailed != null) {
                onFailed.invoke("NSR is Disabled by setting");
                return;
            }
            return;
        }
        PiaRuntime build = new PiaRuntime.Builder().setNamespace(namespace).setUrl(url).build();
        if (build != null) {
            build.installPlugin(BridgeDowngradePlugin.class, create$default);
            build.sendEvent(PiaRuntime.EVENT_ON_BIND_BRIDGE_HANDLE, workerBridgeHandle);
            piaRuntime = build;
        } else {
            piaRuntime = null;
        }
        renderInternal(piaRuntime, create$default, script, expires, once, userAgent, onSuccess, onFailed);
    }

    public final void render(final String url, final long expires, final String namespace, final boolean once, final PiaRuntime runtime, final Function2<? super String, ? super Boolean, Unit> onSuccess, final Function1<? super String, Unit> onFailed) {
        WebSettings settings;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        PiaManifest create = PiaManifest.INSTANCE.create(url, runtime);
        if (create == null) {
            return;
        }
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadUtil.INSTANCE.getMainHandler().post(new Runnable() { // from class: com.bytedance.pia.nsr.NsrManager$render$1
                @Override // java.lang.Runnable
                public final void run() {
                    NsrManager.INSTANCE.render(url, expires, namespace, once, runtime, onSuccess, onFailed);
                }
            });
            return;
        }
        View renderView = runtime.getRenderView();
        WebView webView = renderView instanceof WebView ? (WebView) renderView : null;
        renderInternal(runtime, create, null, expires, once, (webView == null || (settings = webView.getSettings()) == null) ? null : settings.getUserAgentString(), onSuccess, onFailed);
    }

    public final WebResourceResponse shouldInterceptRequest(String url, PiaContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PiaManifest create = PiaManifest.INSTANCE.create(url, context);
        if (!(create != null && create.getEnableNsr())) {
            return null;
        }
        context.getMetrics().onPvEvent(PvEventType.NSR_HIT, 0);
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsNsrV1Enabled()) {
            context.getMetrics().onError(ErrorType.NSR_RENDER, 1007);
            return null;
        }
        String str = cache.get(url);
        if (str != null) {
            Logger.w$default("[NSR] Get NSR HTML (URL: " + url + ')', null, null, 6, null);
            context.getMetrics().onPvEvent(PvEventType.NSR_HIT, 1);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return new WebResourceResponse("text/html", Constant.CHARSET_UTF_8, new ByteArrayInputStream(bytes));
        }
        context.getMetrics().onError(ErrorType.NSR_RENDER, ErrorCode.NO_VALID_NSR_RESULT);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0125 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void renderInternal(PiaRuntime runtime, final PiaManifest manifest, final String script, final long expires, final boolean once, String userAgent, Function2<? super String, ? super Boolean, Unit> onSuccess, Function1<? super String, Unit> onFailed) {
        final NsrManager$renderInternal$safeFailed$1 nsrManager$renderInternal$safeFailed$1;
        Object obj;
        Throwable th;
        final Worker.CreateParams createParams;
        String tryUpdateExistRecord;
        if (runtime == null) {
            if (onFailed != null) {
                onFailed.invoke("runtime is null!");
                return;
            }
            return;
        }
        Logger.i$default("[NSR] Starting renderInternal NSR, script: " + script + ", userAgent: " + userAgent + ", expires: " + expires, null, null, 6, null);
        NsrTraceConsumer nsrTraceConsumer = new NsrTraceConsumer();
        runtime.getTrace().subscribe(nsrTraceConsumer);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final NsrManager$renderInternal$safeSuccess$1 nsrManager$renderInternal$safeSuccess$1 = new NsrManager$renderInternal$safeSuccess$1(atomicBoolean, manifest, runtime, nsrTraceConsumer, onSuccess);
        final NsrManager$renderInternal$safeFailed$1 nsrManager$renderInternal$safeFailed$12 = new NsrManager$renderInternal$safeFailed$1(atomicBoolean, runtime, manifest, nsrTraceConsumer, onFailed);
        if (!Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsNsrV1Enabled()) {
            runtime.getMetrics().onError(ErrorType.NSR_WORKER, 1007);
            nsrManager$renderInternal$safeFailed$12.invoke("disabled by setting.");
            return;
        }
        if (!Worker.VmSdkUtil.isDebugEnable() && (tryUpdateExistRecord = cache.tryUpdateExistRecord(manifest.getUri().toString(), once, expires)) != null) {
            nsrManager$renderInternal$safeSuccess$1.invoke(tryUpdateExistRecord, true);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            nsrManager$renderInternal$safeFailed$1 = nsrManager$renderInternal$safeFailed$12;
        } catch (Throwable th2) {
            th = th2;
            nsrManager$renderInternal$safeFailed$1 = nsrManager$renderInternal$safeFailed$12;
        }
        try {
            obj = Result.constructor-impl(new Worker.CreateParams.Builder().setName("NSR").setLocation(runtime.getOriginUrl().toString()).setResource(runtime.getResource()).setContext(runtime).setScriptUrl(manifest.getNsrScriptPath()).setUserAgent(userAgent).setNeedPolyfill(false).setResultConsumer(new IConsumer() { // from class: com.bytedance.pia.nsr.NsrManager$renderInternal$createParams$1$1
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(JsonObject jsonObject) {
                    Object obj2;
                    try {
                        Result.Companion companion2 = Result.Companion;
                        obj2 = Result.constructor-impl(jsonObject.get("html").getAsString());
                    } catch (Throwable th3) {
                        Result.Companion companion3 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
                    }
                    if (Result.isFailure-impl(obj2)) {
                        obj2 = null;
                    }
                    String str = (String) obj2;
                    if (TextUtils.isEmpty(str)) {
                        NsrManager$renderInternal$safeFailed$1.this.invoke("Save empty result");
                        return;
                    }
                    RecordsCache cache2 = NsrManager.INSTANCE.getCache();
                    String uri = manifest.getUri().toString();
                    Intrinsics.checkNotNullExpressionValue(uri, "manifest.uri.toString()");
                    long j = expires;
                    boolean z = once;
                    Intrinsics.checkNotNull(str);
                    cache2.add(uri, j, z, str);
                    nsrManager$renderInternal$safeSuccess$1.invoke(str, true);
                }
            }).build());
        } catch (Throwable th3) {
            th = th3;
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
            th = Result.exceptionOrNull-impl(obj);
            if (th != null) {
            }
            createParams = (Worker.CreateParams) (Result.isFailure-impl(obj) ? null : obj);
            if (createParams != null) {
            }
        }
        th = Result.exceptionOrNull-impl(obj);
        if (th != null) {
            nsrManager$renderInternal$safeFailed$1.invoke(th.toString());
        }
        createParams = (Worker.CreateParams) (Result.isFailure-impl(obj) ? null : obj);
        if (createParams != null) {
            return;
        }
        ThreadUtil.INSTANCE.getPiaHandler().post(new Runnable() { // from class: com.bytedance.pia.nsr.NsrManager$renderInternal$2
            @Override // java.lang.Runnable
            public final void run() {
                Object obj2;
                Worker.CreateParams createParams2 = createParams;
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj2 = Result.constructor-impl(new Worker(createParams2));
                } catch (Throwable th4) {
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th4));
                }
                NsrManager$renderInternal$safeFailed$1 nsrManager$renderInternal$safeFailed$13 = nsrManager$renderInternal$safeFailed$1;
                Throwable th5 = Result.exceptionOrNull-impl(obj2);
                if (th5 != null) {
                    nsrManager$renderInternal$safeFailed$13.invoke(th5.toString());
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                final Worker worker = (Worker) obj2;
                if (worker == null) {
                    return;
                }
                worker.loadScript(PolyfillCompat.VALUE);
                worker.getModuleManager().registerModule("bridge", BridgeModule.class, worker.getBridge());
                final NsrManager$renderInternal$safeFailed$1 nsrManager$renderInternal$safeFailed$14 = nsrManager$renderInternal$safeFailed$1;
                worker.setErrorHandle(new IConsumer() { // from class: com.bytedance.pia.nsr.NsrManager$renderInternal$2.1
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(String str) {
                        NsrManager$renderInternal$safeFailed$1 nsrManager$renderInternal$safeFailed$15 = NsrManager$renderInternal$safeFailed$1.this;
                        Intrinsics.checkNotNullExpressionValue(str, "it");
                        nsrManager$renderInternal$safeFailed$15.invoke(str);
                        worker.terminate();
                    }
                });
                worker.setMessageHandle(new IConsumer() { // from class: com.bytedance.pia.nsr.NsrManager$renderInternal$2.2
                    @Override // com.bytedance.pia.core.api.utils.IConsumer
                    public final void accept(String str) {
                        Logger.i$default("[NSR] onMessage: " + str, null, null, 6, null);
                    }
                });
                worker.loadScript(script);
                worker.start();
                final WeakReference weakReference = new WeakReference(worker);
                Handler piaHandler = ThreadUtil.INSTANCE.getPiaHandler();
                final NsrManager$renderInternal$safeFailed$1 nsrManager$renderInternal$safeFailed$15 = nsrManager$renderInternal$safeFailed$1;
                piaHandler.postDelayed(new Runnable() { // from class: com.bytedance.pia.nsr.NsrManager$renderInternal$2.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Worker worker2 = weakReference.get();
                        if (worker2 != null) {
                            worker2.terminate();
                            nsrManager$renderInternal$safeFailed$15.invoke("Timeout!");
                        }
                    }
                }, 30000);
            }
        });
    }

    public final void reportPVIfNeeded(PiaRuntime runtime, String url, boolean isSuccess, NsrTraceConsumer consumer) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        runtime.getMetrics().report(MetricsType.NSR_PERFORMANCE, MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("worker_url", url), TuplesKt.to("pia_sdk_version", "2.5.2.8-allinone"), TuplesKt.to("render_success", Boolean.valueOf(isSuccess))}), consumer.getCostMap()), null);
    }

    /* compiled from: NsrManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pia/nsr/NsrManager$NsrTraceConsumer;", "Lcom/bytedance/pia/core/TracingAdapter;", "()V", "costMap", "", "", "", "getCostMap", "()Ljava/util/Map;", "onFinished", "", "put", "name", "element", "Lcom/google/gson/JsonElement;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class NsrTraceConsumer extends TracingAdapter {
        private final Map<String, Long> costMap = new LinkedHashMap();

        public final Map<String, Long> getCostMap() {
            return this.costMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.pia.core.TracingAdapter
        public void onFinished() {
            super.onFinished();
            Set<Map.Entry> entrySet = getResult().entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "result.entrySet()");
            for (Map.Entry entry : entrySet) {
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "it.key");
                put((String) key, (JsonElement) entry.getValue());
            }
        }

        private final void put(String name, JsonElement element) {
            if (element == null || !element.isJsonObject()) {
                return;
            }
            try {
                Result.Companion companion = Result.Companion;
                JsonObject asJsonObject = element.getAsJsonObject();
                long asLong = asJsonObject.get("s").getAsJsonPrimitive().getAsLong();
                Result.constructor-impl(this.costMap.put(name, Long.valueOf(asJsonObject.get("e").getAsJsonPrimitive().getAsLong() - asLong)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
    }
}

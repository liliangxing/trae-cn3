package com.bytedance.pia.page;

import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.TracingAdapter;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.bridge.PiaBridge;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.plugins.PiaPropsPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.pia.core.worker.bridge.BridgeModule;
import com.bytedance.pia.core.worker.bridge.PolyfillCompat;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/pia/page/PrefetchManager;", "", ErrorType.MANIFEST, "Lcom/bytedance/pia/core/PiaManifest;", "context", "Lcom/bytedance/pia/core/runtime/PiaRuntime;", "(Lcom/bytedance/pia/core/PiaManifest;Lcom/bytedance/pia/core/runtime/PiaRuntime;)V", PiaPropsPlugin.PROPS_NAME_MANIFEST, "()Lcom/bytedance/pia/core/PiaManifest;", ErrorType.WORKER, "Lcom/bytedance/pia/core/worker/Worker;", "getWorker", "()Lcom/bytedance/pia/core/worker/Worker;", "setWorker", "(Lcom/bytedance/pia/core/worker/Worker;)V", "destroy", "", "initializeWorker", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchManager {
    private final PiaRuntime context;
    private final PiaManifest manifest;
    private Worker worker;

    public PrefetchManager(PiaManifest piaManifest, PiaRuntime piaRuntime) {
        Intrinsics.checkNotNullParameter(piaManifest, ErrorType.MANIFEST);
        Intrinsics.checkNotNullParameter(piaRuntime, "context");
        this.manifest = piaManifest;
        this.context = piaRuntime;
        initializeWorker();
    }

    public final PiaManifest getManifest() {
        return this.manifest;
    }

    public final Worker getWorker() {
        return this.worker;
    }

    public final void setWorker(Worker worker) {
        this.worker = worker;
    }

    private final void initializeWorker() {
        Object obj;
        WebSettings settings;
        if (this.manifest.getEnableWorker()) {
            if (Settings.Companion.get$default(Settings.INSTANCE, false, 1, null).getIsPrefetchV1Enabled()) {
                try {
                    Result.Companion companion = Result.Companion;
                    Worker.CreateParams.Builder scriptUrl = new Worker.CreateParams.Builder().setName("Prefetch").setWarmup(this.context.isWarmup()).setLocation(this.manifest.getUri().toString()).setScriptUrl(this.manifest.getPrefetchScriptPath());
                    View renderView = this.context.getRenderView();
                    WebView webView = renderView instanceof WebView ? (WebView) renderView : null;
                    obj = Result.constructor-impl(scriptUrl.setUserAgent((webView == null || (settings = webView.getSettings()) == null) ? null : settings.getUserAgentString()).setContext(this.context).setNeedPolyfill(false).build());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                final Worker.CreateParams createParams = (Worker.CreateParams) (Result.isFailure-impl(obj) ? null : obj);
                if (createParams == null) {
                    return;
                }
                ThreadUtil.INSTANCE.getPiaHandler().post(new Runnable() { // from class: com.bytedance.pia.page.PrefetchManager$initializeWorker$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Object obj2;
                        PiaRuntime piaRuntime;
                        PiaRuntime piaRuntime2;
                        PrefetchManager prefetchManager = PrefetchManager.this;
                        Worker.CreateParams createParams2 = createParams;
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj2 = Result.constructor-impl(new Worker(createParams2));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        final PrefetchManager prefetchManager2 = PrefetchManager.this;
                        if (Result.isSuccess-impl(obj2)) {
                            Worker worker = (Worker) obj2;
                            worker.loadScript(PolyfillCompat.VALUE);
                            worker.getModuleManager().registerModule("bridge", BridgeModule.class, worker.getBridge());
                            worker.start();
                            worker.setErrorHandle(new IConsumer() { // from class: com.bytedance.pia.page.PrefetchManager$initializeWorker$1$2$1
                                @Override // com.bytedance.pia.core.api.utils.IConsumer
                                public final void accept(String str) {
                                    PiaRuntime piaRuntime3;
                                    PiaRuntime piaRuntime4;
                                    piaRuntime3 = PrefetchManager.this.context;
                                    piaRuntime3.getMetrics().onError(ErrorType.PREFETCH, 1001, str);
                                    piaRuntime4 = PrefetchManager.this.context;
                                    PiaBridge renderBridge = piaRuntime4.getRenderBridge();
                                    JsonObject jsonObject = new JsonObject();
                                    jsonObject.addProperty("error", str);
                                    Unit unit = Unit.INSTANCE;
                                    renderBridge.send("pia.onWorkerError", jsonObject);
                                }
                            });
                            worker.setMessageHandle(new IConsumer() { // from class: com.bytedance.pia.page.PrefetchManager$initializeWorker$1$2$2
                                @Override // com.bytedance.pia.core.api.utils.IConsumer
                                public final void accept(String str) {
                                    PiaRuntime piaRuntime3;
                                    piaRuntime3 = PrefetchManager.this.context;
                                    PiaBridge renderBridge = piaRuntime3.getRenderBridge();
                                    JsonObject jsonObject = new JsonObject();
                                    jsonObject.addProperty("data", str);
                                    Unit unit = Unit.INSTANCE;
                                    renderBridge.send("pia.onWorkerMessage", jsonObject);
                                }
                            });
                            piaRuntime2 = prefetchManager2.context;
                            piaRuntime2.getTrace().subscribe(new TracingAdapter() { // from class: com.bytedance.pia.page.PrefetchManager$initializeWorker$1$2$3
                                /* JADX INFO: Access modifiers changed from: protected */
                                @Override // com.bytedance.pia.core.TracingAdapter
                                public void onFinished() {
                                    PiaRuntime piaRuntime3;
                                    JsonObject jsonObject = new JsonObject();
                                    jsonObject.add("timing", getResult());
                                    Logger.v$default("on page ready: " + jsonObject, null, null, 6, null);
                                    piaRuntime3 = PrefetchManager.this.context;
                                    piaRuntime3.getRenderBridge().send("pia.onPageReady", jsonObject);
                                }
                            });
                        }
                        PrefetchManager prefetchManager3 = PrefetchManager.this;
                        Throwable th3 = Result.exceptionOrNull-impl(obj2);
                        if (th3 != null) {
                            piaRuntime = prefetchManager3.context;
                            piaRuntime.getMetrics().onError(ErrorType.PREFETCH, 1003, Log.getStackTraceString(th3));
                        }
                        if (Result.isFailure-impl(obj2)) {
                            obj2 = null;
                        }
                        prefetchManager.setWorker((Worker) obj2);
                    }
                });
            }
        }
    }

    public final void destroy() {
        Worker worker = this.worker;
        if (worker != null) {
            worker.terminate();
        }
    }
}

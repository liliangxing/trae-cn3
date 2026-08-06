package com.bytedance.pia.core.worker;

import android.net.Uri;
import com.bytedance.pia.core.api.PiaEnv;
import com.bytedance.pia.core.api.resource.IResourceLoader;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ResourceUtils;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.pia.core.worker.binding.WarmupModule;
import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import com.bytedance.vmsdk.worker.JsWorker;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WarmupWorker {
    private static volatile WarmupWorker warmupInstance;
    private long end;
    private final JSModuleManager moduleManager;
    private long requestEnd;
    private long requestStart;
    private final Uri uri;
    private final JsWorker worker;
    private volatile boolean isFinished = false;
    private volatile Runnable callback = null;
    private volatile Throwable error = null;
    private final long start = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Uri lambda$new$0(Uri uri) {
        return uri;
    }

    public static synchronized void warmup(PiaRuntime.Builder builder) {
        synchronized (WarmupWorker.class) {
            PiaRuntime build = builder.build();
            if (build != null && build.getConfig().isStreamingEnabled()) {
                Uri parse = Uri.parse(build.getConfig().getStreaming());
                if (warmupInstance == null || !warmupInstance.getUri().equals(parse)) {
                    if (warmupInstance != null) {
                        warmupInstance.worker.terminate();
                    }
                    try {
                        warmupInstance = new WarmupWorker(build.getResource(), parse);
                    } catch (Throwable th) {
                        Logger.m179e("[Worker] try warmup failed!", th);
                    }
                }
            }
        }
    }

    public static synchronized WarmupWorker consume(Uri uri) {
        synchronized (WarmupWorker.class) {
            if (warmupInstance == null || !warmupInstance.getUri().equals(uri)) {
                return null;
            }
            WarmupWorker warmupWorker = warmupInstance;
            warmupInstance = null;
            return warmupWorker;
        }
    }

    public static synchronized boolean has(Uri uri) {
        boolean z;
        synchronized (WarmupWorker.class) {
            if (warmupInstance != null && warmupInstance.getUri().equals(uri)) {
                z = warmupInstance.isFinished();
            }
        }
        return z;
    }

    public static synchronized void release(Uri uri) {
        synchronized (WarmupWorker.class) {
            if (warmupInstance != null && warmupInstance.getUri().equals(uri)) {
                warmupInstance.worker.terminate();
                warmupInstance = null;
            }
        }
    }

    public JsWorker getWorker() {
        return this.worker;
    }

    public JSModuleManager getModuleManager() {
        return this.moduleManager;
    }

    public Throwable getError() {
        return this.error;
    }

    public Uri getUri() {
        return this.uri;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        return this.end;
    }

    public long getRequestStart() {
        return this.requestStart;
    }

    public long getRequestEnd() {
        return this.requestEnd;
    }

    public void setFinished() {
        synchronized (this) {
            this.end = System.currentTimeMillis();
            this.isFinished = true;
            if (this.callback != null) {
                this.callback.run();
            }
        }
    }

    public boolean isFinished() {
        boolean z;
        synchronized (this) {
            z = this.isFinished;
        }
        return z;
    }

    public void onFinish(Runnable runnable) {
        synchronized (this) {
            if (this.isFinished) {
                runnable.run();
            } else {
                this.callback = runnable;
            }
        }
    }

    public WarmupWorker(IResourceLoader iResourceLoader, final Uri uri) {
        this.uri = uri;
        JsWorker.EngineType engineType = Worker.VmSdkUtil.isV8Enable() ? JsWorker.EngineType.V8 : JsWorker.EngineType.QUICKJS;
        JSModuleManager jSModuleManager = new JSModuleManager(PiaEnv.Default.getApplicationContext());
        this.moduleManager = jSModuleManager;
        jSModuleManager.registerModule(WarmupModule.NAME, WarmupModule.class, this);
        this.worker = new JsWorker(jSModuleManager, engineType, (String) null, false, "PIA");
        this.requestStart = System.currentTimeMillis();
        iResourceLoader.loadAsync(LoadFrom.Auto, new IResourceRequest() { // from class: com.bytedance.pia.core.worker.WarmupWorker$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            public final Uri getUrl() {
                return WarmupWorker.lambda$new$0(uri);
            }
        }, new IConsumer() { // from class: com.bytedance.pia.core.worker.WarmupWorker$$ExternalSyntheticLambda1
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                WarmupWorker.this.loadSuccess((IResourceResponse) obj);
            }
        }, new IConsumer() { // from class: com.bytedance.pia.core.worker.WarmupWorker$$ExternalSyntheticLambda2
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                WarmupWorker.this.loadFailed((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSuccess(IResourceResponse iResourceResponse) {
        this.requestEnd = System.currentTimeMillis();
        try {
            this.worker.evaluateJavaScript(ResourceUtils.readAsString(iResourceResponse), this.uri.toString());
            this.worker.evaluateJavaScript("NativeModules.get(\"WarmupModule\").finishWarmup();");
        } catch (Throwable th) {
            loadFailed(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFailed(Throwable th) {
        this.requestEnd = System.currentTimeMillis();
        this.error = th;
        this.worker.terminate();
        setFinished();
    }
}

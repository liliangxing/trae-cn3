package com.bytedance.ies.bullet.prefetchv2;

import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.prefetchv2.INetworkExecutor;
import com.bytedance.ies.bullet.prefetchv2.PrefetchTask;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: PrefetchTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002&'B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0012J\u0006\u0010\u001f\u001a\u00020\u001aJ\r\u0010 \u001a\u00020\u001aH\u0000¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\f\u0010#\u001a\u0004\u0018\u00010$*\u00020%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchTask;", "", "schemaModel", "Lcom/bytedance/ies/bullet/prefetchv2/SchemaModel;", "config", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequestConfig;", "request", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", "prefetchConfig", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "(Lcom/bytedance/ies/bullet/prefetchv2/SchemaModel;Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequestConfig;Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;)V", "getConfig", "()Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequestConfig;", "finished", "", "lockObj", "Ljava/lang/Object;", "mCallback", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchTask$Callback;", "getPrefetchConfig", "()Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "getRequest", "()Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", "getSchemaModel", "()Lcom/bytedance/ies/bullet/prefetchv2/SchemaModel;", "finish", "", "getStreamPrefetchResult", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "observe", "callback", "removeObserver", "run", "run$anniex_release", "stickyCallBacks", "getBody", "", "Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor$HttpResponse;", "Callback", "StreamCallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchTask {
    private final PrefetchRequestConfig config;
    private boolean finished;
    private final Object lockObj;
    private Callback mCallback;
    private final PrefetchConfig prefetchConfig;
    private final PrefetchRequest request;
    private final SchemaModel schemaModel;

    /* compiled from: PrefetchTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchTask$Callback;", "", "onFailure", "", "request", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", "throwable", "", "onSuccess", "result", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Callback {

        /* compiled from: PrefetchTask.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class DefaultImpls {
            public static void onFailure(Callback callback, PrefetchRequest prefetchRequest, Throwable th) {
                Intrinsics.checkNotNullParameter(prefetchRequest, "request");
                Intrinsics.checkNotNullParameter(th, "throwable");
            }

            public static void onSuccess(Callback callback, PrefetchRequest prefetchRequest, PrefetchResult prefetchResult) {
                Intrinsics.checkNotNullParameter(prefetchRequest, "request");
                Intrinsics.checkNotNullParameter(prefetchResult, "result");
            }
        }

        void onFailure(PrefetchRequest request, Throwable throwable);

        void onSuccess(PrefetchRequest request, PrefetchResult result);
    }

    public PrefetchTask(SchemaModel schemaModel, PrefetchRequestConfig prefetchRequestConfig, PrefetchRequest prefetchRequest, PrefetchConfig prefetchConfig) {
        Intrinsics.checkNotNullParameter(schemaModel, "schemaModel");
        Intrinsics.checkNotNullParameter(prefetchRequestConfig, "config");
        Intrinsics.checkNotNullParameter(prefetchRequest, "request");
        Intrinsics.checkNotNullParameter(prefetchConfig, "prefetchConfig");
        this.schemaModel = schemaModel;
        this.config = prefetchRequestConfig;
        this.request = prefetchRequest;
        this.prefetchConfig = prefetchConfig;
        this.lockObj = new Object();
    }

    public final PrefetchRequestConfig getConfig() {
        return this.config;
    }

    public final PrefetchConfig getPrefetchConfig() {
        return this.prefetchConfig;
    }

    public final PrefetchRequest getRequest() {
        return this.request;
    }

    public final SchemaModel getSchemaModel() {
        return this.schemaModel;
    }

    public final void run$anniex_release() {
        String business = this.schemaModel.getBusiness();
        INetworkExecutor networkExecutor = ProcessorManager.INSTANCE.getNetworkExecutor(business);
        if (networkExecutor == null) {
            finish();
            PrefetchLogger.INSTANCE.m37e("NetworkExecutor为空, 请查看是否注入网络实现，prefetch_business: " + business);
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.config.getStreamLoadType()) {
            this.request.performStream(new INetworkExecutor.StreamCallback() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchTask$run$1
                @Override // com.bytedance.ies.bullet.prefetchv2.INetworkExecutor.StreamCallback
                public void onReceiveResponse(INetworkExecutor.HttpResponse response) {
                    boolean z;
                    PrefetchTask.Callback callback;
                    PrefetchResult streamPrefetchResult;
                    PrefetchResult streamPrefetchResult2;
                    PrefetchTask.Callback callback2;
                    Object obj;
                    Intrinsics.checkNotNullParameter(response, "response");
                    z = PrefetchTask.this.finished;
                    if (z) {
                        return;
                    }
                    try {
                        streamPrefetchResult = PrefetchTask.this.getStreamPrefetchResult();
                        if (streamPrefetchResult != null) {
                            streamPrefetchResult2 = PrefetchTask.this.getStreamPrefetchResult();
                            if (streamPrefetchResult2 != null) {
                                ByteArrayOutputStream byteArrayOutputStream = streamPrefetchResult2.getByteArrayOutputStream();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.write(response.getBody());
                                }
                            } else {
                                streamPrefetchResult2 = null;
                            }
                        } else {
                            streamPrefetchResult2 = new PrefetchResult();
                            long j = currentTimeMillis;
                            PrefetchTask prefetchTask = PrefetchTask.this;
                            streamPrefetchResult2.setHttpCode(Integer.valueOf(response.getStatusCode()));
                            streamPrefetchResult2.setHeader(response.getHeaderMap());
                            streamPrefetchResult2.setRequestStartTimestamp(Long.valueOf(j));
                            streamPrefetchResult2.setExpireMs(prefetchTask.getConfig().getExpireMs());
                            streamPrefetchResult2.setExpireTimestamp(prefetchTask.getConfig().getExpireTimestamp());
                            streamPrefetchResult2.setGlobalPropsName(prefetchTask.getConfig().getGlobalPropsName());
                            streamPrefetchResult2.setConfigFrom(prefetchTask.getPrefetchConfig().getConfigFrom());
                            streamPrefetchResult2.setStreamRequestFinish(false);
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            byteArrayOutputStream2.write(response.getBody());
                            streamPrefetchResult2.setByteArrayOutputStream(byteArrayOutputStream2);
                            PrefetchCache prefetchCache$anniex_release = PrefetchV2.INSTANCE.getPrefetchCache$anniex_release();
                            if (prefetchCache$anniex_release != null) {
                                prefetchCache$anniex_release.put(PrefetchTask.this.getRequest(), streamPrefetchResult2);
                            }
                        }
                        if (streamPrefetchResult2 != null) {
                            PrefetchTask prefetchTask2 = PrefetchTask.this;
                            callback2 = prefetchTask2.mCallback;
                            PrefetchTask.StreamCallback streamCallback = callback2 instanceof PrefetchTask.StreamCallback ? (PrefetchTask.StreamCallback) callback2 : null;
                            if (streamCallback != null) {
                                obj = prefetchTask2.lockObj;
                                synchronized (obj) {
                                    streamCallback.onProgress(prefetchTask2.getRequest(), streamPrefetchResult2);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        }
                    } catch (Exception e) {
                        HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "接受流式 Prefetch 数据异常: " + e.getMessage(), null, null, 12, null);
                        callback = PrefetchTask.this.mCallback;
                        if (callback != null) {
                            callback.onFailure(PrefetchTask.this.getRequest(), new PrefetchException("请求结果处理异常 in onReceiveResponse: " + e.getMessage()));
                        }
                    }
                }

                @Override // com.bytedance.ies.bullet.prefetchv2.INetworkExecutor.StreamCallback
                public void onRequestSucceed(INetworkExecutor.HttpResponse response) {
                    boolean z;
                    PrefetchTask.Callback callback;
                    PrefetchResult streamPrefetchResult;
                    PrefetchTask.Callback callback2;
                    Object obj;
                    Intrinsics.checkNotNullParameter(response, "response");
                    z = PrefetchTask.this.finished;
                    try {
                        if (z) {
                            return;
                        }
                        try {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            streamPrefetchResult = PrefetchTask.this.getStreamPrefetchResult();
                            if (streamPrefetchResult != null) {
                                streamPrefetchResult.setHttpCode(Integer.valueOf(response.getStatusCode()));
                                streamPrefetchResult.setHeader(response.getHeaderMap());
                                streamPrefetchResult.setStreamRequestFinish(true);
                                streamPrefetchResult.setRequestFinishTimestamp(Long.valueOf(currentTimeMillis2));
                            } else {
                                streamPrefetchResult = null;
                            }
                            HybridLogger.i$default(HybridLogger.INSTANCE, "XPrefetch", "接受流式 Prefetch 数据结束: " + PrefetchTask.this.getRequest().getRequestKey(), null, null, 12, null);
                            if (streamPrefetchResult != null) {
                                PrefetchTask prefetchTask = PrefetchTask.this;
                                callback2 = prefetchTask.mCallback;
                                if (callback2 != null) {
                                    obj = prefetchTask.lockObj;
                                    synchronized (obj) {
                                        callback2.onSuccess(prefetchTask.getRequest(), streamPrefetchResult);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            callback = PrefetchTask.this.mCallback;
                            if (callback != null) {
                                callback.onFailure(PrefetchTask.this.getRequest(), new PrefetchException("请求结果处理异常 in onRequestSucceed: " + e.getMessage()));
                            }
                        }
                    } finally {
                        PrefetchTask.this.finish();
                    }
                }

                @Override // com.bytedance.ies.bullet.prefetchv2.INetworkExecutor.StreamCallback
                public void onRequestFailed(Throwable throwable) {
                    boolean z;
                    PrefetchTask.Callback callback;
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    z = PrefetchTask.this.finished;
                    if (z) {
                        return;
                    }
                    HybridLogger.e$default(HybridLogger.INSTANCE, "XPrefetch", "Prefetch请求失败: " + throwable.getMessage(), null, null, 12, null);
                    callback = PrefetchTask.this.mCallback;
                    if (callback != null) {
                        callback.onFailure(PrefetchTask.this.getRequest(), throwable);
                    }
                    PrefetchTask.this.finish();
                }
            });
        } else {
            this.request.perform(networkExecutor, new INetworkExecutor.Callback() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchTask$run$2
                @Override // com.bytedance.ies.bullet.prefetchv2.INetworkExecutor.Callback
                public void onRequestSucceed(final INetworkExecutor.HttpResponse response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    final PrefetchTask prefetchTask = PrefetchTask.this;
                    final long j = currentTimeMillis;
                    Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.prefetchv2.PrefetchTask$run$2$onRequestSucceed$1
                        @Override // java.util.concurrent.Callable
                        public final Unit call() {
                            PrefetchTask.Callback callback;
                            PrefetchTask.Callback callback2;
                            Unit unit = null;
                            try {
                                try {
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    PrefetchResult prefetchResult = new PrefetchResult();
                                    INetworkExecutor.HttpResponse httpResponse = response;
                                    PrefetchTask prefetchTask2 = PrefetchTask.this;
                                    long j2 = j;
                                    prefetchResult.setHttpCode(Integer.valueOf(httpResponse.getStatusCode()));
                                    prefetchResult.setHeader(httpResponse.getHeaderMap());
                                    try {
                                        String body = prefetchTask2.getBody(httpResponse);
                                        prefetchResult.setBody(body != null ? new JSONObject(body) : new JSONObject());
                                    } catch (Exception unused) {
                                    }
                                    prefetchResult.setRequestStartTimestamp(Long.valueOf(j2));
                                    prefetchResult.setRequestFinishTimestamp(Long.valueOf(currentTimeMillis2));
                                    prefetchResult.setExpireMs(prefetchTask2.getConfig().getExpireMs());
                                    prefetchResult.setExpireTimestamp(prefetchTask2.getConfig().getExpireTimestamp());
                                    prefetchResult.setGlobalPropsName(prefetchTask2.getConfig().getGlobalPropsName());
                                    prefetchResult.setConfigFrom(prefetchTask2.getPrefetchConfig().getConfigFrom());
                                    PrefetchLogger.INSTANCE.m36d("Prefetch成功: " + PrefetchTask.this.getRequest().getRequestKey());
                                    PrefetchCache prefetchCache$anniex_release = PrefetchV2.INSTANCE.getPrefetchCache$anniex_release();
                                    if (prefetchCache$anniex_release != null) {
                                        prefetchCache$anniex_release.put(PrefetchTask.this.getRequest(), prefetchResult);
                                    }
                                    callback2 = PrefetchTask.this.mCallback;
                                    if (callback2 != null) {
                                        callback2.onSuccess(PrefetchTask.this.getRequest(), prefetchResult);
                                        unit = Unit.INSTANCE;
                                    }
                                } catch (Exception e) {
                                    callback = PrefetchTask.this.mCallback;
                                    if (callback != null) {
                                        callback.onFailure(PrefetchTask.this.getRequest(), new PrefetchException("请求结果处理异常: " + e.getMessage()));
                                        unit = Unit.INSTANCE;
                                    }
                                }
                                return unit;
                            } finally {
                                PrefetchTask.this.finish();
                            }
                        }
                    });
                }

                @Override // com.bytedance.ies.bullet.prefetchv2.INetworkExecutor.Callback
                public void onRequestFailed(Throwable throwable) {
                    PrefetchTask.Callback callback;
                    Intrinsics.checkNotNullParameter(throwable, "throwable");
                    PrefetchLogger.INSTANCE.m37e("Prefetch请求失败: " + throwable.getMessage());
                    callback = PrefetchTask.this.mCallback;
                    if (callback != null) {
                        callback.onFailure(PrefetchTask.this.getRequest(), throwable);
                    }
                    PrefetchTask.this.finish();
                }
            });
        }
    }

    public final String getBody(INetworkExecutor.HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        if (httpResponse.getBodyString() != null) {
            return httpResponse.getBodyString();
        }
        byte[] body = httpResponse.getBody();
        if (body != null) {
            httpResponse.setBodyString(new String(body, Charsets.UTF_8));
        }
        return httpResponse.getBodyString();
    }

    public final synchronized void finish() {
        TaskManager.INSTANCE.remove(this.request);
        this.finished = true;
    }

    public final void observe(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.finished) {
            PrefetchCache prefetchCache$anniex_release = PrefetchV2.INSTANCE.getPrefetchCache$anniex_release();
            PrefetchResult prefetchResult = prefetchCache$anniex_release != null ? PrefetchCache.get$default(prefetchCache$anniex_release, this.request, false, 2, null) : null;
            if (prefetchResult != null && !prefetchResult.isExpire()) {
                callback.onSuccess(this.request, prefetchResult);
                return;
            } else {
                callback.onFailure(this.request, new PrefetchException("边界错误，cache: " + prefetchResult + ", cache expire: " + (prefetchResult != null ? Boolean.valueOf(prefetchResult.isExpire()) : null)));
                return;
            }
        }
        this.mCallback = callback;
        stickyCallBacks(callback);
    }

    public final void removeObserver() {
        this.mCallback = null;
    }

    private final void stickyCallBacks(Callback callback) {
        if (callback instanceof StreamCallback) {
            synchronized (this.lockObj) {
                PrefetchResult streamPrefetchResult = getStreamPrefetchResult();
                if (streamPrefetchResult != null) {
                    ((StreamCallback) callback).onObserved(this.request, streamPrefetchResult);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized PrefetchResult getStreamPrefetchResult() {
        PrefetchCache prefetchCache$anniex_release;
        prefetchCache$anniex_release = PrefetchV2.INSTANCE.getPrefetchCache$anniex_release();
        return prefetchCache$anniex_release != null ? PrefetchCache.get$default(prefetchCache$anniex_release, this.request, false, 2, null) : null;
    }

    /* compiled from: PrefetchTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchTask$StreamCallback;", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchTask$Callback;", "onObserved", "", "request", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchRequest;", "result", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchResult;", "onProgress", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface StreamCallback extends Callback {
        void onObserved(PrefetchRequest request, PrefetchResult result);

        void onProgress(PrefetchRequest request, PrefetchResult result);

        /* compiled from: PrefetchTask.kt */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
        public static final class DefaultImpls {
            public static void onObserved(StreamCallback streamCallback, PrefetchRequest prefetchRequest, PrefetchResult prefetchResult) {
                Intrinsics.checkNotNullParameter(prefetchRequest, "request");
                Intrinsics.checkNotNullParameter(prefetchResult, "result");
            }

            public static void onProgress(StreamCallback streamCallback, PrefetchRequest prefetchRequest, PrefetchResult prefetchResult) {
                Intrinsics.checkNotNullParameter(prefetchRequest, "request");
                Intrinsics.checkNotNullParameter(prefetchResult, "result");
            }

            public static void onFailure(StreamCallback streamCallback, PrefetchRequest prefetchRequest, Throwable th) {
                Intrinsics.checkNotNullParameter(prefetchRequest, "request");
                Intrinsics.checkNotNullParameter(th, "throwable");
                Callback.DefaultImpls.onFailure(streamCallback, prefetchRequest, th);
            }

            public static void onSuccess(StreamCallback streamCallback, PrefetchRequest prefetchRequest, PrefetchResult prefetchResult) {
                Intrinsics.checkNotNullParameter(prefetchRequest, "request");
                Intrinsics.checkNotNullParameter(prefetchResult, "result");
                Callback.DefaultImpls.onSuccess(streamCallback, prefetchRequest, prefetchResult);
            }
        }
    }
}

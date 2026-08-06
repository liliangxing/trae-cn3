package com.bytedance.pia.core.plugins;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pia.core.cache.PIACacheManager;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.metrics.TraceEvent;
import com.bytedance.pia.core.misc.CopyableInputStream;
import com.bytedance.pia.core.misc.DetectableInputStream;
import com.bytedance.pia.core.misc.ResourceResponse;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.EventName;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ManifestUtils;
import com.bytedance.pia.core.utils.StreamUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.UrlUtils;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HtmlPlugin extends PiaPlugin {
    private IPiaCacheProvider cache;
    private boolean hasValidate;
    private final CountDownLatch htmlLatch;
    private volatile IResourceResponse response;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return "html";
    }

    public HtmlPlugin(PiaRuntime piaRuntime) {
        super(piaRuntime);
        this.htmlLatch = new CountDownLatch(1);
        this.cache = null;
        this.hasValidate = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void initialize() {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.plugins.HtmlPlugin$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HtmlPlugin.this.m749lambda$initialize$0$combytedancepiacorepluginsHtmlPlugin();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x014d  */
    /* renamed from: lambda$initialize$0$com-bytedance-pia-core-plugins-HtmlPlugin, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void m749lambda$initialize$0$combytedancepiacorepluginsHtmlPlugin() {
        Logger.m181i("[HTML] start load main document.");
        this.runtime.getTracer().report(TraceEvent.REQUEST_HTML_START, System.currentTimeMillis());
        this.runtime.getTrace().traceWithArgs(EventName.HTMLRequestStart).appendArg("url", this.runtime.getOriginUrl().toString()).flush();
        this.runtime.getOnlineTrace().setValid(this.runtime.isSchemeV2(), this.runtime.getOriginUrl());
        this.runtime.getOnlineTrace().parseConfigs(this.runtime.getConfig(), Settings.get().getIsCacheEnabled());
        if (this.runtime.isSchemeV2() && Settings.get().getIsCacheEnabled()) {
            Logger.m181i("[HTML] try load main document from cache.");
            PIACacheManager.init();
            try {
            } catch (Throwable th) {
                Logger.m187w("[HTML] Query Cache Exception. (URL: " + this.runtime.getOriginUrl() + ", Error: " + th + ')');
            }
            if (!this.runtime.getConfig().isCacheEnabled() && !this.runtime.getConfig().isSnapshotEnabled() && !this.runtime.getConfig().isNsrEnabled()) {
                PIACacheManager.removeAllCache(this.runtime.getOriginUrl());
                if (!shouldUseCache(this.cache)) {
                    this.runtime.getTrace().traceWithArgs(EventName.HTMLResponseStart).appendArg("mode", "piaCache").flush();
                    String str = this.cache.get$html();
                    this.response = new ResourceResponse("text/html", "UTF-8", 200, "OK", null, LoadFrom.Offline, new ByteArrayInputStream(str.getBytes()));
                    JsonObject parseManifest = ManifestUtils.parseManifest(str);
                    Logger.m181i("[HTML] load main document from cache success.");
                    this.runtime.sendEvent(PiaRuntime.EVENT_ON_MANIFEST_IN_HTML_READY, parseManifest);
                    this.runtime.getOnlineTrace().parseHTML(str, null, null, this.runtime.getConfig());
                    loadFinished(str, null);
                } else if (this.cache != null) {
                    this.runtime.getOnlineTrace().updateCacheStatus(5);
                    PIACacheManager.deleteWithNormalizeUrl(this.runtime.getOriginUrl(), this.cache.get$normalizeUrl());
                }
            }
            this.cache = PIACacheManager.query4Intercept(this.runtime.getOriginUrl());
            if (!shouldUseCache(this.cache)) {
            }
        }
        loadAsync();
    }

    public void loadAsync() {
        Logger.m181i("[HTML] try load main document from resource loader.");
        final HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.runtime.getUserAgent());
        this.runtime.getResource().loadAsync(LoadFrom.Auto, new IResourceRequest() { // from class: com.bytedance.pia.core.plugins.HtmlPlugin.1
            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            /* renamed from: getUrl */
            public Uri get$uri() {
                return HtmlPlugin.this.runtime.getOriginUrl();
            }

            @Override // com.bytedance.pia.core.api.resource.IResourceRequest
            public Map<String, String> getRequestHeaders() {
                return hashMap;
            }
        }, new IConsumer() { // from class: com.bytedance.pia.core.plugins.HtmlPlugin$$ExternalSyntheticLambda1
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                HtmlPlugin.this.m750lambda$loadAsync$1$combytedancepiacorepluginsHtmlPlugin((IResourceResponse) obj);
            }
        }, new IConsumer() { // from class: com.bytedance.pia.core.plugins.HtmlPlugin$$ExternalSyntheticLambda2
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                HtmlPlugin.this.m751lambda$loadAsync$2$combytedancepiacorepluginsHtmlPlugin((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$loadAsync$1$com-bytedance-pia-core-plugins-HtmlPlugin, reason: not valid java name */
    public /* synthetic */ void m750lambda$loadAsync$1$combytedancepiacorepluginsHtmlPlugin(IResourceResponse iResourceResponse) {
        Logger.m181i("[HTML] load main document from resource loader end.");
        ResourceResponse safeWrap = ResourceResponse.safeWrap(iResourceResponse);
        if (this.response == null) {
            this.runtime.getTrace().traceWithArgs(EventName.HTMLResponseStart).appendArg("mode", safeWrap.get$loadFrom() == LoadFrom.Offline ? ResourceInfo.RESOURCE_FROM_OFFLINE : "online").flush();
        }
        Pair<InputStream, CopyableInputStream> makeCopy = makeCopy(safeWrap.getData());
        CopyableInputStream copy = ((CopyableInputStream) makeCopy.second).copy();
        CopyableInputStream copy2 = ((CopyableInputStream) makeCopy.second).copy();
        CopyableInputStream copy3 = ((CopyableInputStream) makeCopy.second).copy();
        if (this.response == null) {
            this.response = new ResourceResponse(safeWrap.get$mimeType(), safeWrap.get$encoding(), safeWrap.get$statusCode(), safeWrap.get$reasonPhrase(), safeWrap.getHeaders(), safeWrap.get$loadFrom(), (InputStream) makeCopy.first);
            this.htmlLatch.countDown();
        }
        try {
            Logger.m181i("[HTML] Start parsing manifest.");
            this.runtime.getTracer().report(TraceEvent.MANIFEST_PARSE_START, System.currentTimeMillis());
            JsonObject parseManifestWithLink = ManifestUtils.parseManifestWithLink(copy, safeWrap.get$encoding());
            this.runtime.sendEvent(PiaRuntime.EVENT_ON_MANIFEST_IN_HTML_READY, parseManifestWithLink);
            this.runtime.getTracer().report(TraceEvent.MANIFEST_PARSE_END, System.currentTimeMillis());
            Logger.m181i("[HTML] Finish parsing manifest.");
            String str = "";
            if (this.runtime.isSchemeV2() && (this.runtime.getConfig().isCacheEnabled() || this.runtime.getConfig().isNsrEnabled() || this.runtime.getConfig().isSnapshotEnabled())) {
                str = parseHtml(copy2, safeWrap.get$encoding());
                PIACacheManager.update(this.runtime.getOriginUrl(), str, parseManifestWithLink, this.cache);
                this.hasValidate = true;
            } else {
                copy2.close();
            }
            this.runtime.getOnlineTrace().parseHTML(str, copy3, safeWrap.get$encoding(), this.runtime.getConfig());
            loadFinished(str, null);
        } catch (Throwable th) {
            this.runtime.getOnlineTrace().updatePrefetchStatus(6);
            loadFinished(null, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$loadAsync$2$com-bytedance-pia-core-plugins-HtmlPlugin, reason: not valid java name */
    public /* synthetic */ void m751lambda$loadAsync$2$combytedancepiacorepluginsHtmlPlugin(Throwable th) {
        this.runtime.getOnlineTrace().updatePrefetchStatus(6);
        loadFinished(null, th);
    }

    public Pair<InputStream, CopyableInputStream> makeCopy(InputStream inputStream) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        CopyableInputStream copyableInputStream = new CopyableInputStream(new DetectableInputStream(inputStream, new DetectableInputStream.Detector() { // from class: com.bytedance.pia.core.plugins.HtmlPlugin.2
            @Override // com.bytedance.pia.core.misc.DetectableInputStream.Detector
            public void onFinished(int i, boolean z) {
                atomicInteger.compareAndSet(0, i);
                if (z) {
                    return;
                }
                HtmlPlugin.this.runtime.getMetrics().onError("html_stream_truncate", "from=origin,length=" + i);
            }
        }));
        return new Pair<>(new DetectableInputStream(copyableInputStream, new DetectableInputStream.Detector() { // from class: com.bytedance.pia.core.plugins.HtmlPlugin.3
            @Override // com.bytedance.pia.core.misc.DetectableInputStream.Detector
            public void onException(Throwable th) {
                HtmlPlugin.this.runtime.getMetrics().onError("html_stream_exception", Log.getStackTraceString(th));
            }

            @Override // com.bytedance.pia.core.misc.DetectableInputStream.Detector
            public void onFinished(int i, boolean z) {
                int i2 = atomicInteger.get();
                if (i < i2) {
                    HtmlPlugin.this.runtime.getMetrics().onError("html_stream_truncate", "from=copy,length=" + i + ",origin=" + i2);
                }
            }
        }), copyableInputStream);
    }

    public static String parseHtml(InputStream inputStream, String str) {
        try {
            return StreamUtils.readAndClose(inputStream, str);
        } catch (Throwable th) {
            Logger.m178e("[HTML] Parse HTML Exception: " + th);
            return "";
        }
    }

    private void loadFinished(String str, Throwable th) {
        this.htmlLatch.countDown();
        this.runtime.getTracer().report(TraceEvent.REQUEST_HTML_END, System.currentTimeMillis());
        this.runtime.getTrace().trace(EventName.HTMLResponseEnd);
        if (th != null) {
            Logger.m179e("[Manifest] Request Manifest Error:", th);
        }
        if (str != null) {
            this.runtime.sendEvent(PiaRuntime.EVENT_ON_HTML_READY, str);
        } else {
            this.runtime.sendEvent(PiaRuntime.EVENT_ON_HTML_ERROR, th);
        }
    }

    private boolean shouldUseCache(IPiaCacheProvider iPiaCacheProvider) {
        if (iPiaCacheProvider == null) {
            this.runtime.getOnlineTrace().updateCacheStatus(3);
            return false;
        }
        if (iPiaCacheProvider.get$config().getMarked() != null && !iPiaCacheProvider.get$config().getMarked().booleanValue()) {
            try {
                JsonObject meta = iPiaCacheProvider.get$config().getMeta();
                if (meta == null) {
                    return this.runtime.getConfig().isCacheEnabled();
                }
                String str = "";
                try {
                    str = meta.get("type").getAsString();
                } catch (Throwable unused) {
                }
                if ("nsr".equals(str) && this.runtime.getConfig().isNsrEnabled()) {
                    return true;
                }
                if (ErrorType.SNAPSHOT.equals(str) && this.runtime.getConfig().isSnapshotEnabled()) {
                    return true;
                }
            } catch (Throwable unused2) {
            }
        }
        return false;
    }

    @Override // com.bytedance.pia.core.runtime.PiaPlugin, com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        super.release();
        this.htmlLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public IResourceResponse onBeforeLoadResource(IResourceRequest iResourceRequest) {
        Boolean marked;
        String normalizeUrl = UrlUtils.normalizeUrl(iResourceRequest.get$uri());
        if (normalizeUrl != null && normalizeUrl.equals(this.runtime.getNormalizeUrl()) && iResourceRequest.isForMainFrame()) {
            if (this.response != null) {
                this.runtime.getOnlineTrace().updateHTMLPreloadStatus(0);
            } else {
                this.runtime.getOnlineTrace().updateHTMLPreloadStatus(1);
            }
            try {
                Logger.m181i("[HTML] Start intercepting main document.");
                this.runtime.getTrace().traceWithArgs(EventName.ResourceInterceptStart).appendArg("url", iResourceRequest.get$uri()).flush();
                this.htmlLatch.await(Settings.get().getHtmlInterceptTimeout(), TimeUnit.SECONDS);
                Logger.m181i("[HTML] Finish waiting response.");
                IPiaCacheProvider iPiaCacheProvider = this.cache;
                if (iPiaCacheProvider != null && (marked = iPiaCacheProvider.get$config().getMarked()) != null && !marked.booleanValue() && !this.hasValidate) {
                    PIACacheManager.mark(this.runtime.getOriginUrl(), this.cache);
                }
            } catch (Throwable unused) {
            }
            if (this.response != null) {
                Logger.m181i("[HTML] Intercept: " + iResourceRequest.get$uri().toString());
                this.runtime.getOnlineTrace().parseHeader(this.response.getHeaders());
                this.runtime.getOnlineTrace().addDurationByTimestamp(OnlineTracing.NativeMetricsKeys.KEY_NTF);
                this.runtime.getTrace().traceWithArgs(EventName.ResourceInterceptEnd).appendArg("url", iResourceRequest.get$uri()).flush();
                Logger.m181i("[HTML] Finish intercepting main document.");
                return this.response;
            }
            this.runtime.getOnlineTrace().updatePrefetchStatus(6);
            return super.onBeforeLoadResource(iResourceRequest);
        }
        return super.onBeforeLoadResource(iResourceRequest);
    }
}

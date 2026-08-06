package com.bytedance.pia.core.plugins;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.CacheHandle;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.WebViewUtils;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMapKeySetIterator;
import com.bytedance.vmsdk.jsbridge.utils.ReadableType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class StreamingPlugin extends PiaPlugin {
    private static final String APPEND_CHUNK = "(function(_){function n(_){if(!window.__PAGE_FINISH__){window.__PIA_DEV__&&console.log(_);var n=document.createRange();n.selectNode(document.body);var e=n.createContextualFragment(_);document.body.appendChild(e)}}window.__pia_chunks__||(window.__pia_chunks__=[]),window.__pia_chunks__.push(_),function _(){if(\"undefined\"!=typeof document&&\"complete\"===document.readyState){if(window.__pia_chunks__)for(var e=0;e<window.__pia_chunks__.length;e++)n(window.__pia_chunks__[e]);window.__pia_chunks__=[]}else setTimeout(_,50)}()})";
    private static final String PORT_POLYFILL = "(function(a){var t=function(e){if(e&&e.data&&\"streaming\"===e.data&&e.ports&&e.ports[0]){window.removeEventListener(\"message\",t);var n=e.ports[0];n.onmessage=function(t){t.data&&\"string\"==typeof t.data&&a(t.data)},n.postMessage(\"streaming_ack\")}};window.addEventListener(\"message\",t)})(function(_){function n(_){if(!window.__PAGE_FINISH__){window.__PIA_DEV__&&console.log(_);var n=document.createRange();n.selectNode(document.body);var e=n.createContextualFragment(_);document.body.appendChild(e)}}window.__pia_chunks__||(window.__pia_chunks__=[]),window.__pia_chunks__.push(_),function _(){if(\"undefined\"!=typeof document&&\"complete\"===document.readyState){if(window.__pia_chunks__)for(var e=0;e<window.__pia_chunks__.length;e++)n(window.__pia_chunks__[e]);window.__pia_chunks__=[]}else setTimeout(_,50)}()});";
    public static final String STREAMING_PORT_ACK = "streaming_ack";
    private static final String STREAMING_PORT_INIT = "streaming";
    private volatile String bodyCache;
    private final CacheHandle<String> chunkCache;
    private final CountDownLatch firstChunkLatch;
    private final Map<String, String> headers;
    private volatile boolean isFailed;
    private volatile boolean isResponded;
    private final AtomicReference<WebMessagePort> portRef;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return STREAMING_PORT_INIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void appendHeaders(Map<String, String> map) {
        if (this.isFailed) {
            return;
        }
        if (this.isResponded) {
            Logger.m178e("[Streaming] Can't append headers after responded!");
        } else {
            this.headers.putAll(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void appendChunk(String str) {
        if (this.isFailed) {
            return;
        }
        if (this.isResponded) {
            this.chunkCache.offer(str);
        } else {
            this.bodyCache += str;
            this.firstChunkLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public IResourceResponse onBeforeLoadResource(IResourceRequest iResourceRequest) {
        boolean z;
        if (!iResourceRequest.isForMainFrame()) {
            return null;
        }
        synchronized (this) {
            if (this.isFailed) {
                return null;
            }
            if (TextUtils.isEmpty(this.bodyCache)) {
                try {
                    z = !this.firstChunkLatch.await(Settings.get().getStreamingInterceptTimeout(), TimeUnit.SECONDS);
                } catch (Throwable th) {
                    Logger.m179e("[Streaming] intercept html failed, error:", th);
                    synchronized (this) {
                        this.isFailed = true;
                        return null;
                    }
                }
            } else {
                z = false;
            }
            if (TextUtils.isEmpty(this.bodyCache) || z) {
                synchronized (this) {
                    this.isFailed = true;
                }
                return null;
            }
            synchronized (this) {
                this.isResponded = true;
            }
            return new SafeResponse(this.headers, this.bodyCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendChunkByBridge(final String str) {
        WebMessagePort webMessagePort = this.portRef.get();
        if (webMessagePort != null) {
            Logger.m181i("[Streaming] appendChunkByBridge by port.");
            webMessagePort.postMessage(new WebMessage(str));
        } else {
            ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.plugins.StreamingPlugin$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    StreamingPlugin.this.m170x9a5946f(str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$appendChunkByBridge$0$com-bytedance-pia-core-plugins-StreamingPlugin */
    public /* synthetic */ void m170x9a5946f(String str) {
        View renderView = this.runtime.getRenderView();
        if (renderView instanceof WebView) {
            Logger.m181i("[Streaming] appendChunkByBridge by evaluate JavaScript.");
            StringBuilder sb = new StringBuilder(APPEND_CHUNK);
            WebViewUtils.encodeJavaScriptString(sb, str);
            sb.append(";");
            WebViewUtils.evaluateJavaScript((WebView) renderView, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onLoadStarted() {
        final View renderView = this.runtime.getRenderView();
        if (renderView instanceof WebView) {
            ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.plugins.StreamingPlugin$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    StreamingPlugin.this.m173x95225704(renderView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onLoadStarted$2$com-bytedance-pia-core-plugins-StreamingPlugin */
    public /* synthetic */ void m173x95225704(View view) {
        WebView webView = (WebView) view;
        Logger.m181i("[Streaming] Evaluate render polyfill.");
        WebViewUtils.evaluateJavaScript(webView, PORT_POLYFILL, new IConsumer() { // from class: com.bytedance.pia.core.plugins.StreamingPlugin$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                StreamingPlugin.this.m172x5b57b525((String) obj);
            }
        });
        tryUseMessagePort(webView, this.runtime.getOriginUrl());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onLoadStarted$1$com-bytedance-pia-core-plugins-StreamingPlugin */
    public /* synthetic */ void m172x5b57b525(String str) {
        this.chunkCache.setConsumer(new IConsumer() { // from class: com.bytedance.pia.core.plugins.StreamingPlugin$$ExternalSyntheticLambda2
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                StreamingPlugin.this.appendChunkByBridge((String) obj);
            }
        });
    }

    private void tryUseMessagePort(WebView webView, Uri uri) {
        if (WebViewUtils.getChromeVersion(webView) >= 66) {
            final WebMessagePort[] createWebMessageChannel = webView.createWebMessageChannel();
            createWebMessageChannel[0].setWebMessageCallback(new WebMessagePort.WebMessageCallback() { // from class: com.bytedance.pia.core.plugins.StreamingPlugin.1
                @Override // android.webkit.WebMessagePort.WebMessageCallback
                public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                    if (webMessage == null || !StreamingPlugin.STREAMING_PORT_ACK.equals(webMessage.getData())) {
                        return;
                    }
                    StreamingPlugin.this.portRef.set(createWebMessageChannel[0]);
                }
            }, ThreadUtil.INSTANCE.getPiaHandler());
            webView.postWebMessage(new WebMessage(STREAMING_PORT_INIT, new WebMessagePort[]{createWebMessageChannel[1]}), uri);
        }
    }

    public StreamingPlugin(PiaRuntime piaRuntime) {
        super(piaRuntime);
        this.headers = new HashMap();
        this.firstChunkLatch = new CountDownLatch(1);
        this.bodyCache = "";
        this.isResponded = false;
        this.isFailed = false;
        this.portRef = new AtomicReference<>(null);
        this.chunkCache = new CacheHandle<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void initialize() {
        Worker.CreateParams build = new Worker.CreateParams.Builder().setContext(this.runtime).setName(STREAMING_PORT_INIT).setLocation(this.runtime.getOriginUrl().toString()).setScriptUrl(this.runtime.getConfig().getStreaming()).setGlobalProps(this.runtime.getGlobalProps()).build();
        if (build == null) {
            return;
        }
        try {
            Worker worker = new Worker(build);
            worker.setErrorHandle(new IConsumer() { // from class: com.bytedance.pia.core.plugins.StreamingPlugin$$ExternalSyntheticLambda3
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public final void accept(Object obj) {
                    StreamingPlugin.this.m171x9d926155((String) obj);
                }
            });
            worker.getModuleManager().registerModule(Module.NAME, Module.class, this);
            worker.start();
            this.runtime.put(worker, "streaming-worker");
        } catch (Throwable th) {
            Logger.m179e("[Streaming] create streaming worker error:", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initialize$3$com-bytedance-pia-core-plugins-StreamingPlugin */
    public /* synthetic */ void m171x9d926155(String str) {
        Logger.m178e("[Streaming] js error: " + str);
        synchronized (this) {
            this.isFailed = true;
        }
    }

    @Override // com.bytedance.pia.core.runtime.PiaPlugin, com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        this.firstChunkLatch.countDown();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Module extends JSModule {
        private static final String CHUNK_END_MARK = "<!-- chunk end -->";
        public static final String NAME = "StreamingModule";
        private String chunkCache;
        private final StreamingPlugin plugin;

        @JSMethod
        public void finish() {
        }

        public Module(Context context, Object obj) {
            super(context, obj);
            this.chunkCache = "";
            this.plugin = (StreamingPlugin) obj;
        }

        @JSMethod
        public void appendHeaders(ReadableMap readableMap) {
            if (readableMap == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                if (readableMap.getType(nextKey) == ReadableType.String) {
                    hashMap.put(nextKey, readableMap.getString(nextKey));
                }
            }
            this.plugin.appendHeaders(hashMap);
        }

        @JSMethod
        public void appendBody(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int lastIndexOf = str.lastIndexOf(CHUNK_END_MARK);
            if (lastIndexOf != -1) {
                this.plugin.appendChunk(this.chunkCache + str.substring(0, lastIndexOf));
                this.chunkCache = str.substring(lastIndexOf + 18);
            } else {
                this.chunkCache += str;
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class SafeResponse implements IResourceResponse {
        private final String body;
        private final Map<String, String> headers;

        @Override // com.bytedance.pia.core.api.resource.IResourceResponse
        /* renamed from: getEncoding */
        public String get$encoding() {
            return "UTF-8";
        }

        @Override // com.bytedance.pia.core.api.resource.IResourceResponse
        /* renamed from: getMimeType */
        public String get$mimeType() {
            return "text/html";
        }

        @Override // com.bytedance.pia.core.api.resource.IResourceResponse
        /* renamed from: getReasonPhrase */
        public String get$reasonPhrase() {
            return "OK";
        }

        @Override // com.bytedance.pia.core.api.resource.IResourceResponse
        /* renamed from: getStatusCode */
        public int get$statusCode() {
            return 200;
        }

        public SafeResponse(Map<String, String> map, String str) {
            if (map != null) {
                this.headers = new HashMap(map);
            } else {
                this.headers = new HashMap();
            }
            boolean z = str.lastIndexOf("</body>") != -1;
            boolean z2 = str.lastIndexOf("</html>") != -1;
            if (!z && !z2) {
                this.body = str + "</body></html>";
            } else if (!z2) {
                this.body = str + "</html>";
            } else {
                this.body = str;
            }
        }

        @Override // com.bytedance.pia.core.api.resource.IResourceResponse
        public Map<String, String> getHeaders() {
            return this.headers;
        }

        @Override // com.bytedance.pia.core.api.resource.IResourceResponse
        /* renamed from: getLoadFrom */
        public LoadFrom get$loadFrom() {
            return LoadFrom.Online;
        }

        @Override // com.bytedance.pia.core.api.resource.IResourceResponse
        public InputStream getData() {
            return new ByteArrayInputStream(this.body.getBytes());
        }
    }
}

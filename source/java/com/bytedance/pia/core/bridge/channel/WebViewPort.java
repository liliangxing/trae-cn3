package com.bytedance.pia.core.bridge.channel;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.bridge.channel.WebViewPort;
import com.bytedance.pia.core.utils.CacheHandle;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.WebViewUtils;
import com.google.gson.JsonObject;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WebViewPort implements IBridgePort {
    private static final String BRIDGE_NAME = "pia_bridge";
    private static final String FE_PORT_INIT_MESSAGE = "__port_init__";
    private static final String FE_PORT_INIT_NEXT_MESSAGE = "__port_init_next__";
    private static final String JAVA_SCRIPT_INTERFACE_CLOSE_MESSAGE = "__port_close__";
    private static final String MESSAGE_DATA = "data";
    private static final String SCRIPT_MESSAGE_HANDLE = "(function(n){var i=window.pia_bridge,o=i&&i.onmessage;o&&\"function\"==typeof o&&o(n)})";
    private static final String SCRIPT_WEB_MESSAGE_PORT_INIT = "(function(e){var i=function(a){if(\"__channel_init__\"===a.data&&a.ports&&a.ports[0]){var s=a.ports[0];s.postMessage(\"__channel_ack__\"),s.onmessage=function(i){i&&i.data&&\"string\"==typeof i.data&&e(i.data)};var n=function(e){s.postMessage(e)};window.pia_bridge&&window.pia_bridge.onmessage?window.pia_bridge.postMessage=n:window.pia_bridge={postMessage:n},window.removeEventListener(\"message\",i)}};window.addEventListener(\"message\",i)})";
    private static final String WEB_MESSAGE_PORT_ACK_MESSAGE = "__channel_ack__";
    private static final String WEB_MESSAGE_PORT_INIT_MESSAGE = "__channel_init__";
    private final CacheHandle<JsonObject> localMessageCache = new CacheHandle<>();
    private final CacheHandle<String> remoteMessageCache;
    private WebMessagePort webMessagePort;
    private final WeakReference<WebView> webViewReference;

    public static WebViewPort create(WebView webView) {
        JSInterface jSInterface;
        CacheHandle next;
        if (webView == null || (jSInterface = (JSInterface) JSInterface.webViewToJSInterface.get(webView)) == null || (next = jSInterface.getNext()) == null) {
            return null;
        }
        return new WebViewPort(webView, next);
    }

    private WebViewPort(WebView webView, CacheHandle<String> cacheHandle) {
        this.remoteMessageCache = cacheHandle;
        this.webViewReference = new WeakReference<>(webView);
    }

    @Override // com.bytedance.pia.core.bridge.channel.IBridgePort
    public void postMessage(JsonObject jsonObject) {
        this.localMessageCache.offer(jsonObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnMessage$1$com-bytedance-pia-core-bridge-channel-WebViewPort */
    public /* synthetic */ void m164x211b0513(final IConsumer iConsumer, final String str) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                WebViewPort.this.m163xdd8fe752(str, iConsumer);
            }
        });
    }

    @Override // com.bytedance.pia.core.bridge.channel.IBridgePort
    public void setOnMessage(final IConsumer<JsonObject> iConsumer) {
        this.remoteMessageCache.setConsumer(new IConsumer() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                WebViewPort.this.m164x211b0513(iConsumer, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnMessage$0$com-bytedance-pia-core-bridge-channel-WebViewPort */
    public /* synthetic */ void m163xdd8fe752(String str, IConsumer iConsumer) {
        if (FE_PORT_INIT_MESSAGE.equals(str)) {
            remoteReady(false);
            return;
        }
        if (FE_PORT_INIT_NEXT_MESSAGE.equals(str)) {
            remoteReady(true);
            return;
        }
        try {
            JsonObject parse = GsonUtils.getParser().parse(str);
            if (parse.has("data") && !parse.get("data").isJsonObject()) {
                parse.add("data", GsonUtils.getParser().parse(parse.get("data").getAsJsonPrimitive().getAsString()));
            }
            iConsumer.accept(parse);
        } catch (Throwable th) {
            Logger.m179e("[Bridge] onMessage error:", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void remoteReady(final Boolean bool) {
        this.localMessageCache.setConsumer(new IConsumer() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$$ExternalSyntheticLambda6
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                WebViewPort.this.m162xe8e8b4d3(bool, (JsonObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$remoteReady$4$com-bytedance-pia-core-bridge-channel-WebViewPort */
    public /* synthetic */ void m162xe8e8b4d3(final Boolean bool, final JsonObject jsonObject) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                WebViewPort.this.m161xa55d9712(bool, jsonObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$remoteReady$3$com-bytedance-pia-core-bridge-channel-WebViewPort */
    public /* synthetic */ void m161xa55d9712(Boolean bool, JsonObject jsonObject) {
        if (!bool.booleanValue()) {
            try {
                if (jsonObject.has("data") && jsonObject.get("data").isJsonObject()) {
                    jsonObject.addProperty("data", jsonObject.get("data").getAsJsonObject().toString());
                }
            } catch (Throwable th) {
                Logger.m179e("[Bridge] handle local message error:", th);
            }
        }
        final String jsonObject2 = jsonObject.toString();
        Logger.m181i(jsonObject2);
        WebMessagePort webMessagePort = this.webMessagePort;
        if (webMessagePort != null) {
            webMessagePort.postMessage(new WebMessage(jsonObject2));
        } else {
            ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewPort.this.m160x61d27951(jsonObject2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$remoteReady$2$com-bytedance-pia-core-bridge-channel-WebViewPort */
    public /* synthetic */ void m160x61d27951(String str) {
        WebView webView = this.webViewReference.get();
        if (webView == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(SCRIPT_MESSAGE_HANDLE);
        WebViewUtils.encodeJavaScriptString(sb, str);
        WebViewUtils.evaluateJavaScript(webView, sb.toString());
    }

    @Override // com.bytedance.pia.core.bridge.channel.IBridgePort
    public void close() {
        this.localMessageCache.close();
        this.remoteMessageCache.close();
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                WebViewPort.this.m741lambda$close$5$combytedancepiacorebridgechannelWebViewPort();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$close$5$com-bytedance-pia-core-bridge-channel-WebViewPort, reason: not valid java name */
    public /* synthetic */ void m741lambda$close$5$combytedancepiacorebridgechannelWebViewPort() {
        WebMessagePort webMessagePort = this.webMessagePort;
        if (webMessagePort != null) {
            webMessagePort.close();
        }
    }

    public void tryUseWebMessageChannel(final Uri uri) {
        ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                WebViewPort.this.m165xf1f6a85c(uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tryUseWebMessageChannel$6$com-bytedance-pia-core-bridge-channel-WebViewPort */
    public /* synthetic */ void m165xf1f6a85c(Uri uri) {
        WebView webView = this.webViewReference.get();
        if (webView != null && WebViewUtils.getChromeVersion(webView) >= 66) {
            final WebMessagePort[] createWebMessageChannel = webView.createWebMessageChannel();
            createWebMessageChannel[0].setWebMessageCallback(new WebMessagePort.WebMessageCallback() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort.1
                @Override // android.webkit.WebMessagePort.WebMessageCallback
                public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                    String data = webMessage.getData();
                    if (TextUtils.isEmpty(data)) {
                        return;
                    }
                    if (WebViewPort.FE_PORT_INIT_MESSAGE.equals(data)) {
                        WebViewPort.this.remoteReady(false);
                        return;
                    }
                    if (WebViewPort.FE_PORT_INIT_NEXT_MESSAGE.equals(data)) {
                        WebViewPort.this.remoteReady(true);
                    } else if (!WebViewPort.WEB_MESSAGE_PORT_ACK_MESSAGE.equals(data)) {
                        WebViewPort.this.remoteMessageCache.offer(data);
                    } else {
                        WebViewPort.this.webMessagePort = createWebMessageChannel[0];
                    }
                }
            }, ThreadUtil.INSTANCE.getPiaHandler());
            WebViewUtils.evaluateJavaScript(webView, "(function(e){var i=function(a){if(\"__channel_init__\"===a.data&&a.ports&&a.ports[0]){var s=a.ports[0];s.postMessage(\"__channel_ack__\"),s.onmessage=function(i){i&&i.data&&\"string\"==typeof i.data&&e(i.data)};var n=function(e){s.postMessage(e)};window.pia_bridge&&window.pia_bridge.onmessage?window.pia_bridge.postMessage=n:window.pia_bridge={postMessage:n},window.removeEventListener(\"message\",i)}};window.addEventListener(\"message\",i)})(function(n){var i=window.pia_bridge,o=i&&i.onmessage;o&&\"function\"==typeof o&&o(n)})");
            webView.postWebMessage(new WebMessage(WEB_MESSAGE_PORT_INIT_MESSAGE, new WebMessagePort[]{createWebMessageChannel[1]}), uri);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class JSInterface {
        private static final WeakHashMap<WebView, JSInterface> webViewToJSInterface = new WeakHashMap<>();
        private final AtomicReference<CacheHandle<String>> next = new AtomicReference<>(null);
        private CacheHandle<String> current = null;

        private JSInterface() {
        }

        public static void initialize(final WebView webView) {
            ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$JSInterface$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewPort.JSInterface.lambda$initialize$0(webView);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$initialize$0(WebView webView) {
            WeakHashMap<WebView, JSInterface> weakHashMap = webViewToJSInterface;
            if (weakHashMap.get(webView) != null) {
                return;
            }
            JSInterface jSInterface = new JSInterface();
            webView.addJavascriptInterface(jSInterface, WebViewPort.BRIDGE_NAME);
            weakHashMap.put(webView, jSInterface);
        }

        public static void release(final WebView webView) {
            ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.bridge.channel.WebViewPort$JSInterface$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewPort.JSInterface.lambda$release$1(webView);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$release$1(WebView webView) {
            webView.removeJavascriptInterface(WebViewPort.BRIDGE_NAME);
            webViewToJSInterface.remove(webView);
        }

        public static void close(WebView webView) {
            JSInterface jSInterface = webViewToJSInterface.get(webView);
            if (jSInterface == null) {
                return;
            }
            jSInterface.next.set(null);
            jSInterface.current = null;
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (WebViewPort.FE_PORT_INIT_MESSAGE.equals(str) || WebViewPort.FE_PORT_INIT_NEXT_MESSAGE.equals(str)) {
                if (UByte$.ExternalSyntheticBackport0.m(this.next, (Object) null, new CacheHandle())) {
                    this.current = this.next.get();
                } else {
                    this.current = this.next.getAndSet(null);
                }
            }
            CacheHandle<String> cacheHandle = this.current;
            if (cacheHandle != null) {
                cacheHandle.offer(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CacheHandle<String> getNext() {
            if (UByte$.ExternalSyntheticBackport0.m(this.next, (Object) null, new CacheHandle())) {
                return this.next.get();
            }
            return this.next.getAndSet(null);
        }
    }
}

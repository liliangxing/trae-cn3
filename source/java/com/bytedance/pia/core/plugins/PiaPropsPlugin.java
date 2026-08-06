package com.bytedance.pia.core.plugins;

import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.plugins.PiaPropsPlugin;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.WebViewUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaPropsPlugin extends PiaPlugin {
    public static final String CTX_KEY_PIA_PROPS_JS_INTERFACE = "ctx-pia-props-jsi";
    public static final String NAME = "pia_props";
    public static final String PROPS_INJECT_SCRIPT = "(function(n){var r={},o=JSON.parse(n);for(var i in o)r[i]=function(n){return function(){return o[n]}}(i);window.pia_props=r})";
    public static final String PROPS_NAME_MANIFEST = "getManifest";
    public static final String PROPS_NAME_PAGE_CONFIG = "getPageConfig";
    private final JsonObject piaProps;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return NAME;
    }

    public void addProps(String str, String str2) {
        this.piaProps.add(str, new JsonPrimitive(str2));
    }

    public void removeProps(String str) {
        this.piaProps.remove(str);
    }

    public PiaPropsPlugin(PiaRuntime piaRuntime) {
        super(piaRuntime);
        this.piaProps = new JsonObject();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void initialize() {
        addProps(PROPS_NAME_PAGE_CONFIG, GsonUtils.getGson().toJson(this.runtime.getConfig()));
        addProps(PROPS_NAME_MANIFEST, "{}");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onBindView(View view) {
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            IPiaContext globalContext = this.runtime.getGlobalContext();
            if (globalContext == null || (globalContext.get(CTX_KEY_PIA_PROPS_JS_INTERFACE) instanceof JSInterface)) {
                return;
            }
            globalContext.put(new JSInterface(globalContext, webView), CTX_KEY_PIA_PROPS_JS_INTERFACE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onLoadStarted() {
        View renderView = this.runtime.getRenderView();
        if (renderView instanceof WebView) {
            StringBuilder sb = new StringBuilder(PROPS_INJECT_SCRIPT);
            WebViewUtils.encodeJavaScriptString(sb, this.piaProps.toString());
            WebViewUtils.evaluateJavaScript((WebView) renderView, sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class JSInterface implements IReleasable {
        private final IPiaContext globalContext;
        private final WeakReference<WebView> webViewRef;

        @JavascriptInterface
        public String getManifest() {
            return getProps(PiaPropsPlugin.PROPS_NAME_MANIFEST);
        }

        @JavascriptInterface
        public String getPageConfig() {
            return getProps(PiaPropsPlugin.PROPS_NAME_PAGE_CONFIG);
        }

        private String getProps(String str) {
            JsonElement jsonElement;
            PiaRuntime runtime = PiaRuntime.getRuntime(this.globalContext);
            if (runtime == null) {
                return null;
            }
            PiaPlugin plugin = runtime.getPlugin(PiaPropsPlugin.NAME);
            if ((plugin instanceof PiaPropsPlugin) && (jsonElement = ((PiaPropsPlugin) plugin).piaProps.get(str)) != null) {
                return jsonElement.getAsString();
            }
            return null;
        }

        private JSInterface(IPiaContext iPiaContext, final WebView webView) {
            this.globalContext = iPiaContext;
            this.webViewRef = new WeakReference<>(webView);
            ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.plugins.PiaPropsPlugin$JSInterface$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PiaPropsPlugin.JSInterface.this.m168x3987f13a(webView);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$new$0$com-bytedance-pia-core-plugins-PiaPropsPlugin$JSInterface */
        public /* synthetic */ void m168x3987f13a(WebView webView) {
            webView.addJavascriptInterface(this, PiaPropsPlugin.NAME);
        }

        @Override // com.bytedance.pia.core.api.utils.IReleasable
        public void release() {
            ThreadUtil.runOnMain(new Runnable() { // from class: com.bytedance.pia.core.plugins.PiaPropsPlugin$JSInterface$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PiaPropsPlugin.JSInterface.this.m169x20918662();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$release$1$com-bytedance-pia-core-plugins-PiaPropsPlugin$JSInterface */
        public /* synthetic */ void m169x20918662() {
            WebView webView = this.webViewRef.get();
            if (webView != null) {
                webView.removeJavascriptInterface(PiaPropsPlugin.NAME);
            }
        }
    }
}

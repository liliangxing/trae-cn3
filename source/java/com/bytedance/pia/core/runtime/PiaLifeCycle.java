package com.bytedance.pia.core.runtime;

import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.anniex.R;
import com.bytedance.pia.core.PiaManifest;
import com.bytedance.pia.core.api.bridge.IWorkerBridgeHandle;
import com.bytedance.pia.core.api.plugin.IPiaLifeCycle;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;
import com.bytedance.pia.core.bridge.channel.WebViewPort;
import com.bytedance.pia.core.metrics.TraceEvent;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.UrlUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaLifeCycle implements IPiaLifeCycle {
    private final Object customContext;
    private final String namespace;
    private final BaseContext globalContext = new BaseContext();
    private WeakReference<View> viewReference = null;
    private boolean isNavigating = false;
    private PiaRuntime runtime = null;
    private IWorkerBridgeHandle bridgeHandle = null;

    public PiaLifeCycle(String str, Object obj) {
        this.namespace = str;
        this.customContext = obj;
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public void onBindView(View view) {
        if (view == null) {
            return;
        }
        this.viewReference = new WeakReference<>(view);
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            String userAgentString = webView.getSettings().getUserAgentString();
            if (!userAgentString.contains(PiaRuntime.USER_AGENT)) {
                webView.getSettings().setUserAgentString(userAgentString + PiaManifest.UserAgent);
            }
        }
        PiaRuntime piaRuntime = this.runtime;
        if (piaRuntime != null) {
            piaRuntime.onBindView(view);
        }
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public void onBindBridge(IWorkerBridgeHandle iWorkerBridgeHandle) {
        this.bridgeHandle = iWorkerBridgeHandle;
        PiaRuntime piaRuntime = this.runtime;
        if (piaRuntime != null) {
            piaRuntime.sendEvent(PiaRuntime.EVENT_ON_BIND_BRIDGE_HANDLE, iWorkerBridgeHandle);
        }
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public void loadUrl(String str) {
        Logger.m181i("[Runtime] start loadUrl");
        if (UrlUtils.isHttp(str)) {
            this.isNavigating = true;
            releaseRuntime();
            PiaRuntime createRuntime = createRuntime(str);
            this.runtime = createRuntime;
            if (createRuntime != null) {
                createRuntime.getOnlineTrace().addDurationByTimestamp(OnlineTracing.NativeMetricsKeys.KEY_NLS);
            }
        }
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public void onRedirect(String str) {
        if (UrlUtils.isHttp(str)) {
            this.isNavigating = true;
            if (this.runtime == null) {
                return;
            }
            releaseRuntime();
            this.runtime = createRuntime(str);
        }
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public boolean shouldHandleResource(Uri uri) {
        PiaRuntime piaRuntime = this.runtime;
        if (piaRuntime != null) {
            return piaRuntime.shouldHandleResource(uri);
        }
        return false;
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public IResourceResponse onBeforeLoadResource(IResourceRequest iResourceRequest) {
        Logger.m181i("[Runtime] start onBeforeLoadResource.");
        IResourceResponse iResourceResponse = null;
        if (!UrlUtils.isHttp(iResourceRequest.getUrl())) {
            return null;
        }
        if (!this.isNavigating && this.runtime != null && iResourceRequest.isForMainFrame() && iResourceRequest.getUrl() != null && new PiaRuntime.Builder().setUrl(iResourceRequest.getUrl().toString()).buildName() != null) {
            releaseRuntime();
            this.runtime = createRuntime(iResourceRequest.getUrl().toString());
        }
        if (this.runtime != null) {
            long currentTimeMillis = System.currentTimeMillis();
            IResourceResponse onBeforeLoadResource = this.runtime.onBeforeLoadResource(iResourceRequest);
            if (onBeforeLoadResource != null && iResourceRequest.isForMainFrame()) {
                PiaRuntime piaRuntime = this.runtime;
                if (piaRuntime != null) {
                    piaRuntime.getTracer().report(TraceEvent.INTERCEPT_HTML_START, currentTimeMillis);
                }
                PiaRuntime piaRuntime2 = this.runtime;
                if (piaRuntime2 != null) {
                    piaRuntime2.getTracer().report(TraceEvent.INTERCEPT_HTML_END, System.currentTimeMillis());
                }
            }
            iResourceResponse = onBeforeLoadResource;
        }
        Logger.m181i("[Runtime] end onBeforeLoadResource.");
        return iResourceResponse;
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public IResourceResponse onAfterLoadResource(IResourceRequest iResourceRequest, IResourceResponse iResourceResponse) {
        PiaRuntime piaRuntime = this.runtime;
        if (piaRuntime != null) {
            return piaRuntime.onAfterLoadResource(iResourceRequest, iResourceResponse);
        }
        return null;
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public void onLoadStart(String str) {
        this.isNavigating = false;
        PiaRuntime piaRuntime = this.runtime;
        if (piaRuntime != null) {
            piaRuntime.onLoadStarted();
        }
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public void onLoadFinish(String str) {
        PiaRuntime piaRuntime = this.runtime;
        if (piaRuntime != null) {
            piaRuntime.onLoadFinished();
        }
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public void onLoadError(int i, String str) {
        releaseRuntime();
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public void onDestroy() {
        this.globalContext.release();
        releaseRuntime();
        View view = this.viewReference.get();
        if (view instanceof WebView) {
            WebViewPort.JSInterface.release((WebView) view);
        }
    }

    @Override // com.bytedance.pia.core.api.plugin.IPiaLifeCycle
    public Object getCustomContext() {
        PiaRuntime piaRuntime = this.runtime;
        if (piaRuntime != null) {
            return piaRuntime.getCustomContext();
        }
        return this.customContext;
    }

    private PiaRuntime createRuntime(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        PiaRuntime create = PiaRuntimeFactory.getInstance().create(str, this.namespace, this.customContext, true);
        if (create != null) {
            create.setGlobalContext(this.globalContext);
            if (!create.isInitialized()) {
                PluginRegistry.getRegistry().register(create);
                create.initialize();
            }
            View view = this.viewReference.get();
            if (view != null) {
                view.setTag(R.id.tag_binding_pia_runtime, create);
                create.onBindView(view);
            }
            IWorkerBridgeHandle iWorkerBridgeHandle = this.bridgeHandle;
            if (iWorkerBridgeHandle != null) {
                create.sendEvent(PiaRuntime.EVENT_ON_BIND_BRIDGE_HANDLE, iWorkerBridgeHandle);
            }
        }
        return create;
    }

    private void releaseRuntime() {
        PiaRuntime piaRuntime = this.runtime;
        if (piaRuntime != null) {
            piaRuntime.getOnlineTrace().reportMetrics();
            View view = this.viewReference.get();
            if (view instanceof WebView) {
                WebViewPort.JSInterface.close((WebView) view);
                view.setTag(R.id.tag_binding_pia_runtime, null);
            }
            this.runtime.release();
            this.runtime = null;
        }
    }
}

package com.bytedance.pia.core.plugins;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.pia.core.bridge.channel.WebViewPort;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BridgePlugin extends PiaPlugin {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return "pia_bridge";
    }

    public BridgePlugin(PiaRuntime piaRuntime) {
        super(piaRuntime);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onBindView(View view) {
        if (view instanceof WebView) {
            WebViewPort.JSInterface.initialize((WebView) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onLoadStarted() {
        WebViewPort create;
        View renderView = this.runtime.getRenderView();
        if ((renderView instanceof WebView) && (create = WebViewPort.create((WebView) renderView)) != null) {
            this.runtime.getRenderBridge().start(create);
            create.tryUseWebMessageChannel(this.runtime.getOriginUrl());
            Logger.m181i("[Bridge] start render bridge success.");
            return;
        }
        Logger.m178e("[Bridge] start render bridge failed!");
    }
}

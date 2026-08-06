package com.bytedance.ies.web.jsbridge2;

import com.bytedance.ies.web.jsbridge2.JsBridge2;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class JsBridge2ConfigDefault implements IJsBridge2Config {
    @Override // com.bytedance.ies.web.jsbridge2.IJsBridge2Config
    public IBridgePermissionConfigurator getConfigurator() {
        return null;
    }

    @Override // com.bytedance.ies.web.jsbridge2.IJsBridge2Config
    public IGlobalBridgeInterceptor getGlobalBridgeInterceptor() {
        return null;
    }

    @Override // com.bytedance.ies.web.jsbridge2.IJsBridge2Config
    public IGlobalCallListener getGlobalCallListener() {
        return null;
    }

    @Override // com.bytedance.ies.web.jsbridge2.IJsBridge2Config
    public JsBridge2.ISwitchConfig getSwitchConfig() {
        return null;
    }
}

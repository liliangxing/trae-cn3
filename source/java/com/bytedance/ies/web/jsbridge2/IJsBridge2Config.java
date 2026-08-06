package com.bytedance.ies.web.jsbridge2;

import com.bytedance.ies.web.jsbridge2.JsBridge2;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IJsBridge2Config {
    IBridgePermissionConfigurator getConfigurator();

    IGlobalBridgeInterceptor getGlobalBridgeInterceptor();

    IGlobalCallListener getGlobalCallListener();

    JsBridge2.ISwitchConfig getSwitchConfig();
}

package com.bytedance.ies.web.jsbridge2;

import com.bytedance.ies.web.jsbridge2.JsBridge2;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class DefaultConfigProvider {
    DefaultConfigProvider() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IGlobalCallListener getGlobalCallListener() {
        IJsBridge2Config iJsBridge2Config = (IJsBridge2Config) ServiceManager.get().getService(IJsBridge2Config.class);
        if (iJsBridge2Config != null) {
            return iJsBridge2Config.getGlobalCallListener();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBridgePermissionConfigurator getConfigurator() {
        IJsBridge2Config iJsBridge2Config = (IJsBridge2Config) ServiceManager.get().getService(IJsBridge2Config.class);
        if (iJsBridge2Config != null) {
            return iJsBridge2Config.getConfigurator();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JsBridge2.ISwitchConfig getSwitchConfig() {
        IJsBridge2Config iJsBridge2Config = (IJsBridge2Config) ServiceManager.get().getService(IJsBridge2Config.class);
        if (iJsBridge2Config != null) {
            return iJsBridge2Config.getSwitchConfig();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IGlobalBridgeInterceptor getGlobalBridgeInterceptor() {
        IJsBridge2Config iJsBridge2Config = (IJsBridge2Config) ServiceManager.get().getService(IJsBridge2Config.class);
        if (iJsBridge2Config != null) {
            return iJsBridge2Config.getGlobalBridgeInterceptor();
        }
        return null;
    }
}

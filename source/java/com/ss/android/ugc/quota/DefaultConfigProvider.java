package com.ss.android.ugc.quota;

import android.app.Application;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class DefaultConfigProvider {
    DefaultConfigProvider() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Application getApplication() {
        IBDNetworkTagConfig iBDNetworkTagConfig = (IBDNetworkTagConfig) ServiceManager.get().getService(IBDNetworkTagConfig.class);
        if (iBDNetworkTagConfig != null) {
            return iBDNetworkTagConfig.getApplication();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IBDNetworkTagDepend getTagDepend() {
        IBDNetworkTagConfig iBDNetworkTagConfig = (IBDNetworkTagConfig) ServiceManager.get().getService(IBDNetworkTagConfig.class);
        if (iBDNetworkTagConfig != null) {
            return iBDNetworkTagConfig.getTagDepend();
        }
        return null;
    }
}

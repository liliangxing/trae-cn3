package com.bytedance.xbridge.cn.gen;

import com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.preload.WebPreloadBridge;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class bullet_Creator_bullet_preload {
    public static BridgeMethod create(ContextProviderFactory contextProviderFactory) {
        return new WebPreloadBridge(contextProviderFactory);
    }
}

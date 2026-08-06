package com.lynx.tasm.service;

import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.behavior.BehaviorRegistry;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ILynxExtensionService extends IServiceProvider {
    void onLynxEnvSetup();

    void onLynxViewDestroy(LynxContext lynxContext);

    void onLynxViewSetup(LynxContext lynxContext, LynxGroup lynxGroup, BehaviorRegistry behaviorRegistry);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxExtensionService.class;
    }
}

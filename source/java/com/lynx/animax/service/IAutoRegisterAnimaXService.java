package com.lynx.animax.service;

/* loaded from: classes6.dex */
public interface IAutoRegisterAnimaXService extends IAnimaXService {
    Class<? extends IAnimaXService> getServiceClass();

    default ServiceScope getAutoRegisterServiceScope() {
        return ServiceScope.DEFAULT;
    }
}

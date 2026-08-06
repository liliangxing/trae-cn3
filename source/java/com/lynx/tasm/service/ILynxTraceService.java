package com.lynx.tasm.service;

/* loaded from: classes7.dex */
public interface ILynxTraceService extends IServiceProvider {
    long getDefaultTraceFunction();

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxTraceService.class;
    }
}

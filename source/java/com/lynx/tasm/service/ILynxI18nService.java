package com.lynx.tasm.service;

import com.lynx.tasm.INativeLibraryLoader;

/* loaded from: classes7.dex */
public interface ILynxI18nService extends IServiceProvider {
    boolean loadLibrary(INativeLibraryLoader iNativeLibraryLoader);

    boolean registerNapiEnv(long j);

    @Override // com.lynx.tasm.service.IServiceProvider
    default Class<? extends IServiceProvider> getServiceClass() {
        return ILynxI18nService.class;
    }
}
